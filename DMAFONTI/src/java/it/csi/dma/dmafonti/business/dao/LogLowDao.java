/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dao;



import it.csi.dma.dmafonti.business.dto.LogLowDto;
import it.csi.dma.dmafonti.business.dto.LogLowPk;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @generated
 */
public interface LogLowDao {

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return LogLowPk
	 * @generated
	 */

	public LogLowPk insert(LogLowDto dto);

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return LogLowDto
	 * @generated
	 */
	public LogLowDto mapRow(ResultSet rs, int row) throws SQLException;

	/**
	 * Method 'mapRow_internal'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return LogLowDto
	 * @generated
	 */
	public LogLowDto mapRow_internal(LogLowDto objectToFill, ResultSet rs,
                                     int row) throws SQLException;

}
