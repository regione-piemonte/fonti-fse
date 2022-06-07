/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dmafonti.impl.base.service;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.csi.dma.dmafonti.business.dmafonti.impl.base.FseRESTBaseService;
import it.csi.dma.dmafonti.business.dao.CatalogoLogLowDao;
import it.csi.dma.dmafonti.business.dao.FontiDinamicheLowDao;
import it.csi.dma.dmafonti.business.dao.FontiStaticheLowDao;
import it.csi.dma.dmafonti.business.dao.LogLowDao;
import it.csi.dma.dmafonti.business.dto.CatalogoLogLowDto;
import it.csi.dma.dmafonti.business.dto.FontiDinamicheLowDto;
import it.csi.dma.dmafonti.business.dto.FontiStaticheLowDto;
import it.csi.dma.dmafonti.business.dto.LogLowDto;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.Documento;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.Fonte;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.GetFontiResponse;
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CittadiniFontiGetService extends FseRESTBaseService {

	public static final String FALLIMENTO = "FALLIMENTO";
	public static final String SUCCESSO = "SUCCESSO";

	public CittadiniFontiGetService(String shibIdentitaCodiceFiscale, String xRequestID, String xCodiceServizio,
									String xForwardedFor,
									SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest request) {
		super(shibIdentitaCodiceFiscale, xRequestID, xCodiceServizio, xForwardedFor, securityContext, httpHeaders, request);
	}

	@Autowired
	FontiStaticheLowDao fontiStaticheLowDao;

	@Autowired
	FontiDinamicheLowDao fontiDinamicheLowDao;

	@Autowired
	LogLowDao logLowDao;

	@Autowired
	CatalogoLogLowDao catalogoLogLowDao;

	private static final String LOG_START = "CC_LOG_003";
	private static final String LOG_END = "CC_LOG_002";
	private static final String ERROR = "";
	private static final String COD_SERVIZIO = "GET_FONTI";
	private static final String NOME_SERVIZIO = "GetFonti";


	@Override
	protected Response execute() {
		String METHOD_NAME = "execute";
		log.info(METHOD_NAME, "GetFonti versione 1.1.0");

//		checkNotNull(xRequestID, "Request non valorizzata");
		
//		List<MetadatiDocumentoSR> metadatiDocumenti = getMetadatiDocumentoDistinctIdReferto(response.getMetadatiDocumenti());
//		  
//		List<Referto> referti = new RefertoMetadatiDocumentoSRMapper(codifiche).fromList(metadatiDocumenti);
		
		
//		return Response.ok(referti).build();

		GetFontiResponse getFontiResponse = new GetFontiResponse();
		String esito = FALLIMENTO;
		try {

			//Log start
			logStart();

			//Ricerco tutte le fonti statiche
			List<FontiStaticheLowDto> listaFontiStaticheDto = fontiStaticheLowDao.findAll();

			/* Ricerco le date max per poterle mettere precise nel where ed in response*/
			FontiDinamicheLowDto filter = fontiDinamicheLowDao.findMaxDate();

			getFontiResponse.setPeriodoRiferimentoInizio(filter.getDataInizioValidita().toString());
			getFontiResponse.setPeriodoRiferimentoFine(filter.getDataFineValidita().toString());

			//Ricerco tutte le fonti dinamiche con data inizio e data fine piu' recenti
			List<FontiDinamicheLowDto> listaFontiDinamicheDto = fontiDinamicheLowDao.findAllMaxDate(filter);

			/*
				Logica che raggruppa tutti i documenti per le fonti trovate
				Per ogni record trovato mi segno la Fonte, se e' gia' stata lavorata
				allora aggiungo solo il documento collegato
				Altrimenti inserisco nella mappa la Fonte come chiave ed inizializzo la lista di Docs
			 */
			Map<Fonte, List<Documento>> mapFonteDoc = new HashMap<Fonte, List<Documento>>();

			if(listaFontiStaticheDto != null && !listaFontiStaticheDto.isEmpty()){
				popolaFontiStatiche(listaFontiStaticheDto, mapFonteDoc);
			}

			if(listaFontiDinamicheDto != null && !listaFontiDinamicheDto.isEmpty()){
				popolaFontiDinamiche(listaFontiDinamicheDto, mapFonteDoc);
			}


			List<Fonte> listaFontiResponse = new ArrayList<Fonte>();
			if(mapFonteDoc != null && !mapFonteDoc.isEmpty()) {
				popolaResponse(mapFonteDoc, getFontiResponse, listaFontiResponse);
			}

			esito = SUCCESSO;
		} catch (Exception e) {
			return handleException(e);
		}finally {
			logEnd(esito);
		}

		return Response.ok(getFontiResponse, MediaType.APPLICATION_JSON_TYPE).build();
	}

	private void logStart() {
		try{
			CatalogoLogLowDto logStartCatalogo = catalogoLogLowDao.findByCodice(LOG_START);

			insertLog(logStartCatalogo, NOME_SERVIZIO);
		}catch (Exception e){
			handleException(e);
		}
	}

	private void logEnd(String esito) {
		try{
			CatalogoLogLowDto logStartCatalogo = catalogoLogLowDao.findByCodice(LOG_END);

			insertLog(logStartCatalogo, null, null, null, COD_SERVIZIO, NOME_SERVIZIO, esito);
		}catch (Exception e){
			handleException(e);
		}
	}

	private void insertLog(CatalogoLogLowDto logStartCatalogo, String... params) {
		LogLowDto logLowDto = new LogLowDto();
		logLowDto.setCodiceServizio(COD_SERVIZIO);
		logLowDto.setIdCatalogoLog(logStartCatalogo.getId());
		String descrizioneLog = MessageFormat.format(logStartCatalogo.getDescrizioneLog(), params);
		logLowDto.setInformazioniTracciate(descrizioneLog);
		logLowDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		logLowDao.insert(logLowDto);
	}

	private void popolaResponse(Map<Fonte, List<Documento>> mapFonteDoc, GetFontiResponse getFontiResponse, List<Fonte> listaFontiResponse) {
		for(Fonte fonte : mapFonteDoc.keySet()){
			fonte.setDocumentiInviati(mapFonteDoc.get(fonte));
			listaFontiResponse.add(fonte);
		}
		getFontiResponse.setElencoAsr(listaFontiResponse);
	}

	private void popolaFontiStatiche(List<FontiStaticheLowDto> listaFontiStaticheDto, Map<Fonte, List<Documento>> mapFonteDoc) {
		for(FontiStaticheLowDto fonteStatica : listaFontiStaticheDto){
			Fonte fonte = new Fonte();
			fonte.setCodiceAsr(fonteStatica.getCodiceAzienda());
			fonte.setDescrizioneAsr(fonteStatica.getDescrizioneAzienda());
			fonte.setNatura(fonteStatica.getIdNaturaAzienda() != null?
					fonteStatica.getIdNaturaAzienda().toString():null);

			Documento documento = new Documento();
			documento.setCodiceDocumento(fonteStatica.getCodiceDocumento());
			documento.setDescrizioneDocumento(fonteStatica.getDescrizioneDocumento());
			documento.setValoreAlimentazione(fonteStatica.getAlimentazioneDocumento());

			popolaMapFonteDocumento(mapFonteDoc, fonte, documento);
		}
	}

	private void popolaFontiDinamiche(List<FontiDinamicheLowDto> listaFontiDinamicheDto, Map<Fonte, List<Documento>> mapFonteDoc) {
		for(FontiDinamicheLowDto fonteDinamica : listaFontiDinamicheDto){
			Fonte fonte = new Fonte();
			fonte.setCodiceAsr(fonteDinamica.getCodiceAzienda());
			fonte.setDescrizioneAsr(fonteDinamica.getDescrizioneAzienda());
			fonte.setNatura(fonteDinamica.getIdNaturaAzienda() != null?
					fonteDinamica.getIdNaturaAzienda().toString():null);

			Documento documento = new Documento();
			documento.setCodiceDocumento(fonteDinamica.getCodiceDocumento());
			documento.setDescrizioneDocumento(fonteDinamica.getDescrizioneDocumento());
			documento.setValoreAlimentazione(fonteDinamica.getAlimentazioneDocumento());
			documento.setValoreConteggio(fonteDinamica.getConteggioDocumento() != null?
					fonteDinamica.getConteggioDocumento().toString():null);

			popolaMapFonteDocumento(mapFonteDoc, fonte, documento);
		}
	}

	private void popolaMapFonteDocumento(Map<Fonte, List<Documento>> mapFonteDoc, Fonte fonte, Documento documento) {
		List<Documento> listDocumento = null;
		if(mapFonteDoc.get(fonte) == null){
			listDocumento = new ArrayList<Documento>();
		}else{
			listDocumento = mapFonteDoc.get(fonte);
		}

		listDocumento.add(documento);
		mapFonteDoc.put(fonte, listDocumento);
	}


}
