/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.csi.dma.dmafonti.business.dto.FontiAziendeLowDto;
import it.csi.dma.dmafonti.exception.FontiAziendeLowDaoException;

public interface FontiAziendeLowDao {
 
    public FontiAziendeLowDto mapRow(ResultSet rs, int row)
            throws SQLException;

    public FontiAziendeLowDto mapRow_internal(
            FontiAziendeLowDto objectToFill, ResultSet rs, int row)
            throws SQLException;

    @SuppressWarnings("unchecked")
    public List<FontiAziendeLowDto> findAll() throws FontiAziendeLowDaoException;
    

}
