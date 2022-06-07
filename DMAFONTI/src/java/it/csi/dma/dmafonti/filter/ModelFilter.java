/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.filter;

import java.util.List;

public interface ModelFilter<T> {
	
	public List<T> doFilter(List<T> list, String filter);
	

}
