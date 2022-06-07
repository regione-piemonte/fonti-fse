/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dao.impl;

import it.csi.dma.dmafonti.business.dao.FontiDinamicheLowDao;
import it.csi.dma.dmafonti.business.dto.FontiDinamicheLowDto;
import it.csi.dma.dmafonti.exception.FontiDinamicheLowDaoException;
import it.csi.dma.dmafonti.util.Constants;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@ImportResource({"/WEB-INF/dao-beans.xml"})
public class FontiDinamicheLowDaoImpl extends AbstractDAO implements
        ParameterizedRowMapper<FontiDinamicheLowDto>,
        FontiDinamicheLowDao, BeanFactoryAware {
    protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);
    /**
     * @generated
     */
    protected NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @generated
     */
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.jdbcTemplate = beanFactory.getBean("namedJdbcTemplate", NamedParameterJdbcTemplate.class);
    }

    public FontiDinamicheLowDto mapRow(ResultSet rs, int row)
            throws SQLException {
    	FontiDinamicheLowDto dto = new FontiDinamicheLowDto();
        dto = mapRow_internal(dto, rs, row);
        return dto;
    }

    public FontiDinamicheLowDto mapRow_internal(
    		FontiDinamicheLowDto objectToFill, ResultSet rs, int row)
            throws SQLException {
    	FontiDinamicheLowDto dto = objectToFill;

        FontiDinamicheLowDaoRowMapper FontiDinamicheLowDaoRowMapper = new FontiDinamicheLowDaoRowMapper(
                null, FontiDinamicheLowDto.class);

        return FontiDinamicheLowDaoRowMapper.mapRow_internal(
                objectToFill, rs, row);
    }

    protected FontiDinamicheLowDaoRowMapper ByCodiceApplicazioneRowMapper = new FontiDinamicheLowDaoRowMapper(
            null, FontiDinamicheLowDto.class);

    protected FontiDinamicheLowDaoRowMapper findByPrimaryKeyRowMapper = new FontiDinamicheLowDaoRowMapper(
            null, FontiDinamicheLowDto.class);

    protected FontiDinamicheLowDaoRowMapper maxDataInizioFineValiditaRowMapper = new FontiDinamicheLowDaoRowMapper(
            new String[]{"data_inizio_validita", "data_fine_validita"}, FontiDinamicheLowDto.class);

    public String getTableName() {
        return "dmaccfonti_t_fonti_da_dwh";
    }

    @SuppressWarnings("unchecked")
    public List<FontiDinamicheLowDto> findAllMaxDate(FontiDinamicheLowDto filter) throws FontiDinamicheLowDaoException {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource paramMap = new MapSqlParameterSource();

        sql.append("SELECT id_fonte_dwh,codice_azienda,descrizione_azienda,id_natura_azienda,codice_documento,descrizione_documento,conteggio_documento,alimentazione_documento," +
                " data_inizio_validita, data_fine_validita ");
        sql.append(" FROM " + getTableName());
        sql.append(" where data_inizio_validita = :data_inizio_validita and data_fine_validita = :data_fine_validita");



        paramMap.addValue("data_inizio_validita", filter.getDataInizioValidita(),
                java.sql.Types.TIMESTAMP);

        paramMap.addValue("data_fine_validita", filter.getDataFineValidita(),
                java.sql.Types.TIMESTAMP);

        /* PROTECTED REGION END */
        List<FontiDinamicheLowDto> list = null;
        StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
        try {
            stopWatch.start();
            list = jdbcTemplate.query(sql.toString(), paramMap,
                    ByCodiceApplicazioneRowMapper);

        } catch (RuntimeException ex) {
            log.error(
                    "[FontiDinamicheLowDaoImpl::findByCodiceApplicazione] esecuzione query",
                    ex);
            throw new FontiDinamicheLowDaoException("Query failed", ex);
        } finally {
            stopWatch.dumpElapsed("FontiDinamicheLowDaoImpl",
                    "findByCodiceApplicazione", "esecuzione query",
                    sql.toString());
            log.debug("[FontiDinamicheLowDaoImpl::findByCodiceApplicazione] END");
        }
        return list;
    }

    public FontiDinamicheLowDto findMaxDate() throws FontiDinamicheLowDaoException {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        FontiDinamicheLowDto output = new FontiDinamicheLowDto();

        sql.append("SELECT max(data_inizio_validita) as data_inizio_validita, max(data_fine_validita) as data_fine_validita ");
        sql.append(" FROM " + getTableName());

        /* PROTECTED REGION END */
        List<FontiDinamicheLowDto> list = null;
        StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
        try {
            stopWatch.start();
            list = jdbcTemplate.query(sql.toString(), paramMap,
                    maxDataInizioFineValiditaRowMapper);

            if(list != null && !list.isEmpty()){
                FontiDinamicheLowDto fromList = list.get(0);
                output.setDataInizioValidita(fromList.getDataInizioValidita());
                output.setDataFineValidita(fromList.getDataFineValidita());
            }

        } catch (RuntimeException ex) {
            log.error(
                    "[FontiDinamicheLowDaoImpl::findMaxDate] esecuzione query",
                    ex);
            throw new FontiDinamicheLowDaoException("Query failed", ex);
        } finally {
            stopWatch.dumpElapsed("FontiDinamicheLowDaoImpl",
                    "findMaxDate", "esecuzione query",
                    sql.toString());
            log.debug("[FontiDinamicheLowDaoImpl::findMaxDate] END");
        }
        return output;
    }



    public class FontiDinamicheLowDaoRowMapper implements
            org.springframework.jdbc.core.RowMapper {

        private java.util.HashMap<String, String> columnsToReadMap = new java.util.HashMap<String, String>();
        private boolean mapAllColumns = true;
        private Class dtoClass;

        /**
         * @param columnsToRead
         *            elenco delle colonne da includere nel mapping (per query
         *            incomplete, esempio distinct, custom select...)
         */
        public FontiDinamicheLowDaoRowMapper(String[] columnsToRead,
                Class dtoClass) {
            if (columnsToRead != null) {
                mapAllColumns = false;
                for (int i = 0; i < columnsToRead.length; i++)
                    columnsToReadMap.put(columnsToRead[i], columnsToRead[i]);
            }
            this.dtoClass = dtoClass;
        }

        public Object mapRow(ResultSet rs, int row) throws SQLException {

            Object dto = null;
            try {
                dto = dtoClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                throw new RuntimeException("Impossibile istanziare la classe "
                        + dto.getClass().getCanonicalName() + " ,"
                        + e.getCause());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("Impossibile accedere alla classe "
                        + dto.getClass().getCanonicalName() + " ,"
                        + e.getCause());
            }

            if (dto instanceof FontiDinamicheLowDto) {
                return mapRow_internal((FontiDinamicheLowDto) dto, rs,
                        row);
            }

            return dto;
        }

        public FontiDinamicheLowDto mapRow_internal(
        		FontiDinamicheLowDto objectToFill, ResultSet rs,
                int row) throws SQLException

        {
        	FontiDinamicheLowDto dto = objectToFill;

            if (mapAllColumns || columnsToReadMap.get("id_fonte_statica") != null)
                dto.setIdFonteDinamica((Integer) rs.getObject("id_fonte_dwh"));

            if (mapAllColumns
                    || columnsToReadMap.get("codice_azienda") != null)
                dto.setCodiceAzienda(rs.getString("codice_azienda"));

            if (mapAllColumns
                    || columnsToReadMap.get("descrizione_azienda") != null)
                dto.setDescrizioneAzienda(rs
                        .getString("descrizione_azienda"));

            if (mapAllColumns || columnsToReadMap.get("id_natura_azienda") != null)
                dto.setIdNaturaAzienda((BigDecimal) rs.getObject("id_natura_azienda"));

            if (mapAllColumns
                    || columnsToReadMap.get("codice_documento") != null)
                dto.setCodiceDocumento(rs
                        .getString("codice_documento"));

            if (mapAllColumns
                    || columnsToReadMap.get("descrizione_documento") != null)
                dto.setDescrizioneDocumento(rs
                        .getString("descrizione_documento"));

            if (mapAllColumns || columnsToReadMap.get("conteggio_documento") != null)
                dto.setConteggioDocumento((BigDecimal) rs.getObject("conteggio_documento"));

            if (mapAllColumns
                    || columnsToReadMap.get("alimentazione_documento") != null)
                dto.setAlimentazioneDocumento(rs
                        .getString("alimentazione_documento"));

            if (mapAllColumns
                    || columnsToReadMap.get("data_inizio_validita") != null)
                dto.setDataInizioValidita(rs
                        .getTimestamp("data_inizio_validita"));

            if (mapAllColumns
                    || columnsToReadMap.get("data_fine_validita") != null)
                dto.setDataFineValidita(rs
                        .getTimestamp("data_fine_validita"));

            return dto;
        }

    }

}
