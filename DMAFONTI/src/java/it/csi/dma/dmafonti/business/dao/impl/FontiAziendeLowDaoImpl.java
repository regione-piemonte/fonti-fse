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

import it.csi.dma.dmafonti.business.dao.FontiAziendeLowDao;
import it.csi.dma.dmafonti.business.dto.FontiAziendeLowDto;
import it.csi.dma.dmafonti.exception.FontiAziendeLowDaoException;
import it.csi.dma.dmafonti.util.Constants;
import it.csi.util.performance.StopWatch;

@Component
@ImportResource({"/WEB-INF/dao-beans.xml"})
public class FontiAziendeLowDaoImpl extends AbstractDAO implements
        ParameterizedRowMapper<FontiAziendeLowDto>,
        FontiAziendeLowDao, BeanFactoryAware {
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

    public FontiAziendeLowDto mapRow(ResultSet rs, int row)
            throws SQLException {
    	FontiAziendeLowDto dto = new FontiAziendeLowDto();
        dto = mapRow_internal(dto, rs, row);
        return dto;
    }

    public FontiAziendeLowDto mapRow_internal(
    		FontiAziendeLowDto objectToFill, ResultSet rs, int row)
            throws SQLException {
    	FontiAziendeLowDto dto = objectToFill;

        FontiAziendeLowDaoRowMapper FontiAziendeLowDaoRowMapper = new FontiAziendeLowDaoRowMapper(
                null, FontiAziendeLowDto.class);

        return FontiAziendeLowDaoRowMapper.mapRow_internal(
                objectToFill, rs, row);
    }

    protected FontiAziendeLowDaoRowMapper findAllRowMapper = new FontiAziendeLowDaoRowMapper(
            null, FontiAziendeLowDto.class);

    public String getTableName() {
        return "dmaccfonti_t_aziende";
    }

    @SuppressWarnings("unchecked")
    public List<FontiAziendeLowDto> findAll() throws FontiAziendeLowDaoException {
        StringBuilder sql = new StringBuilder();
        MapSqlParameterSource paramMap = new MapSqlParameterSource();

        sql.append("SELECT azienda_codice, azienda_descrizione, natura_id, natura_descrizione ");
        sql.append(" FROM " + getTableName());        

        /* PROTECTED REGION END */
        List<FontiAziendeLowDto> list = null;
        StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
        try {
            stopWatch.start();
            list = jdbcTemplate.query(sql.toString(), paramMap,
            		findAllRowMapper);

        } catch (RuntimeException ex) {
            log.error(
                    "[FontiAziendeLowDaoImpl::findAll] esecuzione query",
                    ex);
            throw new FontiAziendeLowDaoException("Query failed", ex);
        } finally {
            stopWatch.dumpElapsed("FontiAziendeLowDaoImpl",
                    "findAll", "esecuzione query",
                    sql.toString());
            log.debug("[FontiAziendeLowDaoImpl::findAll] END");
        }
        return list;
    }    


    public class FontiAziendeLowDaoRowMapper implements
            org.springframework.jdbc.core.RowMapper {

        private java.util.HashMap<String, String> columnsToReadMap = new java.util.HashMap<String, String>();
        private boolean mapAllColumns = true;
        private Class dtoClass;

        /**
         * @param columnsToRead
         *            elenco delle colonne da includere nel mapping (per query
         *            incomplete, esempio distinct, custom select...)
         */
        public FontiAziendeLowDaoRowMapper(String[] columnsToRead,
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

            if (dto instanceof FontiAziendeLowDto) {
                return mapRow_internal((FontiAziendeLowDto) dto, rs,
                        row);
            }

            return dto;
        }

        public FontiAziendeLowDto mapRow_internal(
        		FontiAziendeLowDto objectToFill, ResultSet rs,
                int row) throws SQLException

        {
        	FontiAziendeLowDto dto = objectToFill;

            if (mapAllColumns || columnsToReadMap.get("azienda_codice") != null)
                dto.setAziendaCodice((Long) rs.getObject("azienda_codice"));

            if (mapAllColumns
                    || columnsToReadMap.get("azienda_descrizione") != null)
                dto.setAziendaDescrizione(rs.getString("azienda_descrizione"));
            
            if (mapAllColumns || columnsToReadMap.get("natura_id") != null)
                dto.setNatura_id((Long) rs.getObject("natura_id"));

            if (mapAllColumns
                    || columnsToReadMap.get("azienda_descrizione") != null)
                dto.setNaturaDescrizione(rs.getString("azienda_descrizione"));


            return dto;
        }

    }

}
