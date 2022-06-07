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

import it.csi.dma.dmafonti.business.dao.CatalogoLogLowDao;
import it.csi.dma.dmafonti.business.dao.FontiAziendeLowDao;
import it.csi.dma.dmafonti.business.dao.LogLowDao;
import it.csi.dma.dmafonti.business.dmafonti.impl.base.FseRESTBaseService;
import it.csi.dma.dmafonti.business.dto.CatalogoLogLowDto;
import it.csi.dma.dmafonti.business.dto.FontiAziendeLowDto;
import it.csi.dma.dmafonti.business.dto.LogLowDto;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.Documento;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.ElencoAziende;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.Fonte;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.GetAziendeResponse;
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CittadiniAziendeGetService extends FseRESTBaseService {

	public static final String FALLIMENTO = "FALLIMENTO";
	public static final String SUCCESSO = "SUCCESSO";

	public CittadiniAziendeGetService(String shibIdentitaCodiceFiscale, String xRequestID, String xCodiceServizio,
									String xForwardedFor,
									SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest request) {
		super(shibIdentitaCodiceFiscale, xRequestID, xCodiceServizio, xForwardedFor, securityContext, httpHeaders, request);
	}

	@Autowired
	FontiAziendeLowDao fontiAziendeLowDao;

	@Autowired
	LogLowDao logLowDao;

	@Autowired
	CatalogoLogLowDao catalogoLogLowDao;

	private static final String LOG_START = "CC_LOG_003";
	private static final String LOG_END = "CC_LOG_002";
	private static final String ERROR = "";
	private static final String COD_SERVIZIO = "GET_FONTI_AZIENDE";
	private static final String NOME_SERVIZIO = "GetAziende";


	@Override
	protected Response execute() {
		String METHOD_NAME = "execute";
		log.info(METHOD_NAME, "GetAziende versione 1.1.0");

//		checkNotNull(xRequestID, "Request non valorizzata");
		
//		List<MetadatiDocumentoSR> metadatiDocumenti = getMetadatiDocumentoDistinctIdReferto(response.getMetadatiDocumenti());
//		  
//		List<Referto> referti = new RefertoMetadatiDocumentoSRMapper(codifiche).fromList(metadatiDocumenti);
		
		
//		return Response.ok(referti).build();

		GetAziendeResponse getAziendeResponse = new GetAziendeResponse();
		String esito = FALLIMENTO;
		try {

			//Log start
			logStart();

			//Ricerco tutte le fonti statiche
			List<FontiAziendeLowDto> listaFontiAziendeDto = fontiAziendeLowDao.findAll();

			List<ElencoAziende> elencoAziendeList = new ArrayList<ElencoAziende>();
			if(listaFontiAziendeDto != null && !listaFontiAziendeDto.isEmpty()){
				for (FontiAziendeLowDto fontiAziendeDto : listaFontiAziendeDto) {
									
					ElencoAziende elencoAziende = new ElencoAziende();
					elencoAziende.setAziendaCodice(fontiAziendeDto.getAziendaCodice().intValue());
					elencoAziende.setAziendaDescrizione(fontiAziendeDto.getAziendaDescrizione());
					elencoAziende.setNaturaDescrizione(fontiAziendeDto.getNaturaDescrizione());
					elencoAziende.setNaturaId(fontiAziendeDto.getNatura_id().intValue());
					elencoAziendeList.add(elencoAziende);
				}
			}
			
			getAziendeResponse.setElencoAziende(elencoAziendeList);

			esito = SUCCESSO;
		} catch (Exception e) {
			return handleException(e);
		}finally {
			logEnd(esito);
		}

		return Response.ok(getAziendeResponse, MediaType.APPLICATION_JSON_TYPE).build();
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

}
