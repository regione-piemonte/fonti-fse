/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dao;

import it.csi.dma.dmafonti.business.dto.FontiDinamicheLowDto;
import it.csi.dma.dmafonti.exception.FontiDinamicheLowDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface FontiDinamicheLowDao {
 
    public FontiDinamicheLowDto mapRow(ResultSet rs, int row)
            throws SQLException;

    public FontiDinamicheLowDto mapRow_internal(
            FontiDinamicheLowDto objectToFill, ResultSet rs, int row)
            throws SQLException;

    @SuppressWarnings("unchecked")
    public List<FontiDinamicheLowDto> findAllMaxDate(FontiDinamicheLowDto filter) throws FontiDinamicheLowDaoException;

    public FontiDinamicheLowDto findMaxDate() throws FontiDinamicheLowDaoException;

}
