/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.dto.dmafonti.fonti;

import java.util.Objects;
import java.util.ArrayList;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.ElencoDocumenti;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class GetDocumentiResponse   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private List<ElencoDocumenti> elencoDocumenti = new ArrayList<ElencoDocumenti>();

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("elenco_documenti") 
 
  public List<ElencoDocumenti> getElencoDocumenti() {
    return elencoDocumenti;
  }
  public void setElencoDocumenti(List<ElencoDocumenti> elencoDocumenti) {
    this.elencoDocumenti = elencoDocumenti;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetDocumentiResponse getDocumentiResponse = (GetDocumentiResponse) o;
    return Objects.equals(elencoDocumenti, getDocumentiResponse.elencoDocumenti);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elencoDocumenti);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetDocumentiResponse {\n");
    
    sb.append("    elencoDocumenti: ").append(toIndentedString(elencoDocumenti)).append("\n");
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

