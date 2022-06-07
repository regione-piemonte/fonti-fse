/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.dto.dmafonti.fonti;

import java.util.Objects;
import java.util.List;


public class Fonte   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codiceAsr = null;
  private String descrizioneAsr = null;
  private String natura = null;
  private List<Documento> documentiInviati = null;

  public String getCodiceAsr() {
    return codiceAsr;
  }

  public void setCodiceAsr(String codiceAsr) {
    this.codiceAsr = codiceAsr;
  }

  public String getDescrizioneAsr() {
    return descrizioneAsr;
  }

  public void setDescrizioneAsr(String descrizioneAsr) {
    this.descrizioneAsr = descrizioneAsr;
  }

  public String getNatura() {
    return natura;
  }

  public void setNatura(String natura) {
    this.natura = natura;
  }

  public List<Documento> getDocumentiInviati() {
    return documentiInviati;
  }

  public void setDocumentiInviati(List<Documento> documentiInviati) {
    this.documentiInviati = documentiInviati;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Fonte fonte = (Fonte) o;
    return Objects.equals(getCodiceAsr(), fonte.getCodiceAsr()) &&
            Objects.equals(getDescrizioneAsr(), fonte.getDescrizioneAsr()) &&
            Objects.equals(getNatura(), fonte.getNatura());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCodiceAsr(), getDescrizioneAsr(), getNatura());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fonte {\n");
    
    sb.append("    codiceAsr: ").append(toIndentedString(codiceAsr)).append("\n");
    sb.append("    descrizioneAsr: ").append(toIndentedString(descrizioneAsr)).append("\n");
    sb.append("    natura: ").append(toIndentedString(natura)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

