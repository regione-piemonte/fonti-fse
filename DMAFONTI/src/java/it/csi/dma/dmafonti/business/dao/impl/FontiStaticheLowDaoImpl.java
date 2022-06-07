/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dao.impl;

import it.csi.dma.dmafonti.business.dao.FontiStaticheLowDao;
import it.csi.dma.dmafonti.business.dto.FontiStaticheLowDto;
import it.csi.dma.dmafonti.exception.FontiStaticheLowDaoException;
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
public class FontiStaticheLowDaoImpl extends AbstractDAO implements
        ParameterizedRowMapper<FontiStaticheLowDto>,
        FontiStaticheLowDao, BeanFactoryAware {
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

    public FontiStaticheLowDto mapRow(ResultSet rs, int row)
            throws SQLException {
    	FontiStaticheLowDto dto = new FontiStaticheLowDto();
        dto = mapRow_internal(dto, rs, row);
        return dto;
    }

    public FontiStaticheLowDto mapRow_internal(
    		FontiStaticheLowDto objectToFill, ResultSet rs, int row)
            throws SQLException {
    	FontiStaticheLowDto dto = objectToFill;

        FontiStaticheLowDaoRowMapper fontiStaticheLowDaoRowMapper = new FontiStaticheLowDaoRowMapper(
                null, FontiStaticheLowDto.class);

        return fontiStaticheLowDaoRowMapper.mapRow_internal(
                objectToFill, rs, row);
    }

    protected FontiStaticheLowDaoRowMapper ByCodiceApplicazioneRowMapper = new FontiStaticheLowDaoRowMapper(
            null, FontiStaticheLowDto.class);

    protected FontiStaticheLowDaoRowMapper findByPrimaryKeyRowMapper = new FontiStaticheLowDaoRowMapper(
            null, FontiStaticheLowDto.class);

    public String getTableName() {
        return "dmaccfonti_t_fonti_statiche";
    }

    @SuppressWarnings("unchecked")
    public List<FontiStaticheLowDto> findAll() throws FontiStaticheLowDaoException {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource paramMap = new MapSqlParameterSource();

        sql.append("SELECT id_fonte_statica,codice_azienda,descrizione_azienda,id_natura_azienda,codice_documento,descrizione_documento,alimentazione_documento ");
        sql.append(" FROM " + getTableName());

        /* PROTECTED REGION END */
        List<FontiStaticheLowDto> list = null;
        StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
        try {
            stopWatch.start();
            list = jdbcTemplate.query(sql.toString(), paramMap,
                    ByCodiceApplicazioneRowMapper);

        } catch (RuntimeException ex) {
            log.error(
                    "[FontiStaticheLowDaoImpl::findByCodiceApplicazione] esecuzione query",
                    ex);
            throw new FontiStaticheLowDaoException("Query failed", ex);
        } finally {
            stopWatch.dumpElapsed("FontiStaticheLowDaoImpl",
                    "findByCodiceApplicazione", "esecuzione query",
                    sql.toString());
            log.debug("[FontiStaticheLowDaoImpl::findByCodiceApplicazione] END");
        }
        return list;
    }

    public class FontiStaticheLowDaoRowMapper implements
            org.springframework.jdbc.core.RowMapper {

        private java.util.HashMap<String, String> columnsToReadMap = new java.util.HashMap<String, String>();
        private boolean mapAllColumns = true;
        private Class dtoClass;

        /**
         * @param columnsToRead
         *            elenco delle colonne da includere nel mapping (per query
         *            incomplete, esempio distinct, custom select...)
         */
        public FontiStaticheLowDaoRowMapper(String[] columnsToRead,
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

            if (dto instanceof FontiStaticheLowDto) {
                return mapRow_internal((FontiStaticheLowDto) dto, rs,
                        row);
            }

            return dto;
        }

        public FontiStaticheLowDto mapRow_internal(
        		FontiStaticheLowDto objectToFill, ResultSet rs,
                int row) throws SQLException

        {
        	FontiStaticheLowDto dto = objectToFill;

            if (mapAllColumns || columnsToReadMap.get("id_fonte_statica") != null)
                dto.setIdFonteStatica((Integer) rs.getObject("id_fonte_statica"));

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

            if (mapAllColumns
                    || columnsToReadMap.get("alimentazione_documento") != null)
                dto.setAlimentazioneDocumento(rs
                        .getString("alimentazione_documento"));

            return dto;
        }

    }

}
