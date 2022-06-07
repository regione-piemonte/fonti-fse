/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

import it.csi.dma.dmafonti.business.dao.FontiDocumentiLowDao;
import it.csi.dma.dmafonti.business.dto.FontiDinamicheLowDto;
import it.csi.dma.dmafonti.business.dto.FontiDocumentiLowDto;
import it.csi.dma.dmafonti.exception.FontiDocumentiLowDaoException;
import it.csi.dma.dmafonti.util.Constants;
import it.csi.util.performance.StopWatch;

@Component
@ImportResource({"/WEB-INF/dao-beans.xml"})
public class FontiDocumentiLowDaoImpl extends AbstractDAO implements
        ParameterizedRowMapper<FontiDocumentiLowDto>,
        FontiDocumentiLowDao, BeanFactoryAware {
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

    public FontiDocumentiLowDto mapRow(ResultSet rs, int row)
            throws SQLException {
    	FontiDocumentiLowDto dto = new FontiDocumentiLowDto();
        dto = mapRow_internal(dto, rs, row);
        return dto;
    }

    public FontiDocumentiLowDto mapRow_internal(
    		FontiDocumentiLowDto objectToFill, ResultSet rs, int row)
            throws SQLException {
    	FontiDocumentiLowDto dto = objectToFill;

        FontiDocumentiLowDaoRowMapper FontiDocumentiLowDaoRowMapper = new FontiDocumentiLowDaoRowMapper(
                null, FontiDocumentiLowDto.class);

        return FontiDocumentiLowDaoRowMapper.mapRow_internal(
                objectToFill, rs, row);
    }

    protected FontiDocumentiLowDaoRowMapper findAllRowMapper = new FontiDocumentiLowDaoRowMapper(
            null, FontiDocumentiLowDto.class);

    public String getTableName() {
        return "dmaccfonti_t_documenti";
    }

    @SuppressWarnings("unchecked")
    public List<FontiDocumentiLowDto> findAll() throws FontiDocumentiLowDaoException {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource paramMap = new MapSqlParameterSource();

        sql.append("SELECT codice, descrizione ");
        sql.append(" FROM " + getTableName());        

        /* PROTECTED REGION END */
        List<FontiDocumentiLowDto> list = null;
        StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
        try {
            stopWatch.start();
            list = jdbcTemplate.query(sql.toString(), paramMap,
            		findAllRowMapper);

        } catch (RuntimeException ex) {
            log.error(
                    "[FontiDocumentiLowDaoImpl::findAll] esecuzione query",
                    ex);
            throw new FontiDocumentiLowDaoException("Query failed", ex);
        } finally {
            stopWatch.dumpElapsed("FontiDocumentiLowDaoImpl",
                    "findAll", "esecuzione query",
                    sql.toString());
            log.debug("[FontiDocumentiLowDaoImpl::findAll] END");
        }
        return list;
    }    


    public class FontiDocumentiLowDaoRowMapper implements
            org.springframework.jdbc.core.RowMapper {

        private java.util.HashMap<String, String> columnsToReadMap = new java.util.HashMap<String, String>();
        private boolean mapAllColumns = true;
        private Class dtoClass;

        /**
         * @param columnsToRead
         *            elenco delle colonne da includere nel mapping (per query
         *            incomplete, esempio distinct, custom select...)
         */
        public FontiDocumentiLowDaoRowMapper(String[] columnsToRead,
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

            if (dto instanceof FontiDocumentiLowDto) {
                return mapRow_internal((FontiDocumentiLowDto) dto, rs,
                        row);
            }

            return dto;
        }

        public FontiDocumentiLowDto mapRow_internal(
        		FontiDocumentiLowDto objectToFill, ResultSet rs,
                int row) throws SQLException

        {
        	FontiDocumentiLowDto dto = objectToFill;

            if (mapAllColumns || columnsToReadMap.get("codice") != null)
                dto.setCodice((String) rs.getObject("codice"));

            if (mapAllColumns
                    || columnsToReadMap.get("descrizione") != null)
                dto.setDescrizione(rs.getString("descrizione"));

            return dto;
        }

    }

}
