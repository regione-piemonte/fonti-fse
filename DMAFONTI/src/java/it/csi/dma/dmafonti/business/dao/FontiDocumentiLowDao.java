/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.csi.dma.dmafonti.business.dto.FontiDocumentiLowDto;
import it.csi.dma.dmafonti.exception.FontiDocumentiLowDaoException;

public interface FontiDocumentiLowDao {
 
    public FontiDocumentiLowDto mapRow(ResultSet rs, int row)
            throws SQLException;

    public FontiDocumentiLowDto mapRow_internal(
            FontiDocumentiLowDto objectToFill, ResultSet rs, int row)
            throws SQLException;

    @SuppressWarnings("unchecked")
    public List<FontiDocumentiLowDto> findAll() throws FontiDocumentiLowDaoException;
    

}
