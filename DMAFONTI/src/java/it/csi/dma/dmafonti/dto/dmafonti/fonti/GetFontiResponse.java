/*
* SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte
*
* SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.dma.dmafonti.dto.dmafonti.fonti;

import java.util.Objects;
import java.util.ArrayList;
import it.csi.dma.dmafonti.dto.dmafonti.fonti.ElencoAsr;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class GetFontiResponse   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String periodoRiferimentoInizio = null;
  private String periodoRiferimentoFine = null;
  private List<Fonte> elencoAsr = new ArrayList<Fonte>();

  /**
   * Data inizio validita.
   **/
  
  @ApiModelProperty(value = "Data inizio validita.")
  @JsonProperty("periodo_riferimento_inizio") 
 
  public String getPeriodoRiferimentoInizio() {
    return periodoRiferimentoInizio;
  }
  public void setPeriodoRiferimentoInizio(String periodoRiferimentoInizio) {
    this.periodoRiferimentoInizio = periodoRiferimentoInizio;
  }

  /**
   * Data fine validita.
   **/
  
  @ApiModelProperty(value = "Data fine validita.")
  @JsonProperty("periodo_riferimento_fine") 
 
  public String getPeriodoRiferimentoFine() {
    return periodoRiferimentoFine;
  }
  public void setPeriodoRiferimentoFine(String periodoRiferimentoFine) {
    this.periodoRiferimentoFine = periodoRiferimentoFine;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("elenco_asr") 
 
  public List<Fonte> getElencoAsr() {
    return elencoAsr;
  }
  public void setElencoAsr(List<Fonte> listaFontiResponse) {
    this.elencoAsr = listaFontiResponse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetFontiResponse getFontiResponse = (GetFontiResponse) o;
    return Objects.equals(periodoRiferimentoInizio, getFontiResponse.periodoRiferimentoInizio) &&
        Objects.equals(periodoRiferimentoFine, getFontiResponse.periodoRiferimentoFine) &&
        Objects.equals(elencoAsr, getFontiResponse.elencoAsr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(periodoRiferimentoInizio, periodoRiferimentoFine, elencoAsr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetFontiResponse {\n");
    
    sb.append("    periodoRiferimentoInizio: ").append(toIndentedString(periodoRiferimentoInizio)).append("\n");
    sb.append("    periodoRiferimentoFine: ").append(toIndentedString(periodoRiferimentoFine)).append("\n");
    sb.append("    elencoAsr: ").append(toIndentedString(elencoAsr)).append("\n");
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

