/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dao.util;

import it.csi.dma.dmafonti.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

public class NamedParameterJdbcTemplateWithQueryDebug
		extends
			NamedParameterJdbcTemplate {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	private static String PLACEHOLDER = ":";

	private static String[] terminatoriParametro = new String[]{" ", "=", ")",
			"|", "(", ">", "<", "+", "-", "*", "/"};

	public NamedParameterJdbcTemplateWithQueryDebug(DataSource dataSource) {
		super(dataSource);
	}

	public NamedParameterJdbcTemplateWithQueryDebug(
			JdbcOperations classicJdbcTemplate) {
		super(classicJdbcTemplate);
	}

	@Override
	public int update(String sql, SqlParameterSource paramSource)
			throws DataAccessException {
		try {
			logSql(sql, paramSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.update(sql, paramSource);
	}

	@Override
	public List query(String sql, SqlParameterSource paramSource,
			RowMapper rowMapper) throws DataAccessException {
		try {
			logSql(sql, paramSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.query(sql, paramSource, rowMapper);
	}

	/**
	 * stampa su log la query con i valori dei parametri impostati al posto dei placeholder
	 * 
	 * @param sql query con i placeholder 
	 * @param paramSource  mappa contenente i parametri e loro valori
	 */
	private void logSql(String sql, SqlParameterSource paramSource) {
		if (log.isDebugEnabled()) {
			sql = buildSqlWithParameters(sql, paramSource);
		}
		log.debug(sql);
	}

	/**
	 * 
	 * Restituisce una query con i valori impostati al posto dei placeholder (:nomeparametro)
	 * 
	 * @param sql query con i placeholder 
	 * @param paramSource  mappa contenente i parametri e loro valori
	 * @return
	 */
	private String buildSqlWithParameters(String sql,
			SqlParameterSource paramSource) {
		String[] parametriQuery = sql.split(PLACEHOLDER);
		for (String parametro : parametriQuery) {
			parametro = getParametroUtile(parametro);
			if (paramSource.hasValue(parametro)) {
				sql = sql.replaceAll(PLACEHOLDER + parametro,
						getValue(paramSource, parametro));
			}
		}
		return sql;
	}

	/**
	 * Cerca all'interno di una parte di query la minore porzione di stringa utile per essere considerata
	 * come parametro
	 *  
	 * @param parametro  pezzo di query ottenuta da una istruzione split con il carattere ':' come separatore 
	 * @return la minore parola utile utilizzabile come parametro della query
	 */
	private String getParametroUtile(String parametro) {
		int posizioneTerminatoreAttuale = 0;
		for (int i = 0; i < terminatoriParametro.length; i++) {
			posizioneTerminatoreAttuale = parametro
					.indexOf(terminatoriParametro[i]);
			if (posizioneTerminatoreAttuale > 0) {
				parametro = parametro.substring(0, posizioneTerminatoreAttuale);
			}
		}
		return parametro;
	}

	/**
	 * restituisce una rappresentazione in formato stringa di un parametro con placeholder
	 * nella query prelevando il valore dalla Map
	 * @param paramSource mappa contenente i parametri e ralativi valori
	 * @param parametro nome del parametro nella query
	 * @return
	 */
	private String getValue(SqlParameterSource paramSource, String parametro) {
		String resultValue = "null";
		Object paramValue = paramSource.getValue(parametro);

		if (paramValue != null) {
			if (paramValue instanceof String) {
				return "'" + ((String) paramValue).replaceAll("'", "''") + "'";
			} else if (paramValue instanceof Number) {
				resultValue = paramValue.toString();
			} else if (paramValue instanceof Date) {
				resultValue = parseDate((Date) paramValue);
			}
		}
		return resultValue;
	}

	/**
	 * Converte una data in un formato stringa utilizzabile nelle query per Oracle 
	 * @param date 
	 * @return  stringa rappresentante la data nel formato to_date(,DD/MM/YYYY HH24:MI:SS')
	 */
	private static String parseDate(Date date) {
		String retvalue = "";
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(date);
		retvalue = Integer.toString(cal.get(java.util.Calendar.DAY_OF_MONTH))
				+ "/";
		retvalue = retvalue
				+ Integer.toString(cal.get(java.util.Calendar.MONTH) + 1) + "/";
		retvalue = retvalue
				+ Integer.toString(cal.get(java.util.Calendar.YEAR)) + "-";
		retvalue = retvalue
				+ Integer.toString(cal.get(java.util.Calendar.HOUR_OF_DAY))
				+ ":";
		retvalue = retvalue
				+ Integer.toString(cal.get(java.util.Calendar.MINUTE)) + ":";
		retvalue = retvalue
				+ Integer.toString(cal.get(java.util.Calendar.SECOND));
		retvalue = "to_date('" + retvalue + "','DD/MM/YYYY HH24:MI:SS')";
		return retvalue;
	}

}
