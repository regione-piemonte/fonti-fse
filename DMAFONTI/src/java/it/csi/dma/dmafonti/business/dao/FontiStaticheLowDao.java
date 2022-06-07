/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dao;

import it.csi.dma.dmafonti.business.dto.FontiStaticheLowDto;
import it.csi.dma.dmafonti.exception.FontiStaticheLowDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface FontiStaticheLowDao {
 
    public FontiStaticheLowDto mapRow(ResultSet rs, int row)
            throws SQLException;

    public FontiStaticheLowDto mapRow_internal(
            FontiStaticheLowDto objectToFill, ResultSet rs, int row)
            throws SQLException;

    @SuppressWarnings("unchecked")
    public List<FontiStaticheLowDto> findAll() throws FontiStaticheLowDaoException;

}
