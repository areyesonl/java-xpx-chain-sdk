/*
 * ProximaX Chain REST API Reference
 * ProximaX Chain REST API Reference
 *
 * The version of the OpenAPI document: 0.7.15
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.proximax.sdk.gen.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.proximax.sdk.gen.model.ResolutionStatementDTO;
import io.proximax.sdk.gen.model.TransactionStatementDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The collection of transaction statements and resolutions triggered for the block requested.
 */
@ApiModel(description = "The collection of transaction statements and resolutions triggered for the block requested.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-01T21:35:58.261+02:00[Europe/Prague]")
public class StatementsDTO {
  public static final String SERIALIZED_NAME_TRANSACTION_STATEMENTS = "transactionStatements";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_STATEMENTS)
  private List<TransactionStatementDTO> transactionStatements = new ArrayList<>();

  public static final String SERIALIZED_NAME_ADDRESS_RESOLUTION_STATEMENTS = "addressResolutionStatements";
  @SerializedName(SERIALIZED_NAME_ADDRESS_RESOLUTION_STATEMENTS)
  private List<ResolutionStatementDTO> addressResolutionStatements = new ArrayList<>();

  public static final String SERIALIZED_NAME_MOSAIC_RESOLUTION_STATEMENTS = "mosaicResolutionStatements";
  @SerializedName(SERIALIZED_NAME_MOSAIC_RESOLUTION_STATEMENTS)
  private List<ResolutionStatementDTO> mosaicResolutionStatements = new ArrayList<>();

  public StatementsDTO transactionStatements(List<TransactionStatementDTO> transactionStatements) {
    this.transactionStatements = transactionStatements;
    return this;
  }

  public StatementsDTO addTransactionStatementsItem(TransactionStatementDTO transactionStatementsItem) {
    this.transactionStatements.add(transactionStatementsItem);
    return this;
  }

   /**
   * The array of transaction statements for the block requested.
   * @return transactionStatements
  **/
  @ApiModelProperty(required = true, value = "The array of transaction statements for the block requested.")
  public List<TransactionStatementDTO> getTransactionStatements() {
    return transactionStatements;
  }

  public void setTransactionStatements(List<TransactionStatementDTO> transactionStatements) {
    this.transactionStatements = transactionStatements;
  }

  public StatementsDTO addressResolutionStatements(List<ResolutionStatementDTO> addressResolutionStatements) {
    this.addressResolutionStatements = addressResolutionStatements;
    return this;
  }

  public StatementsDTO addAddressResolutionStatementsItem(ResolutionStatementDTO addressResolutionStatementsItem) {
    this.addressResolutionStatements.add(addressResolutionStatementsItem);
    return this;
  }

   /**
   * The array of address resolutions for the block requested.
   * @return addressResolutionStatements
  **/
  @ApiModelProperty(required = true, value = "The array of address resolutions for the block requested.")
  public List<ResolutionStatementDTO> getAddressResolutionStatements() {
    return addressResolutionStatements;
  }

  public void setAddressResolutionStatements(List<ResolutionStatementDTO> addressResolutionStatements) {
    this.addressResolutionStatements = addressResolutionStatements;
  }

  public StatementsDTO mosaicResolutionStatements(List<ResolutionStatementDTO> mosaicResolutionStatements) {
    this.mosaicResolutionStatements = mosaicResolutionStatements;
    return this;
  }

  public StatementsDTO addMosaicResolutionStatementsItem(ResolutionStatementDTO mosaicResolutionStatementsItem) {
    this.mosaicResolutionStatements.add(mosaicResolutionStatementsItem);
    return this;
  }

   /**
   * The array of mosaic resolutions for the block requested.
   * @return mosaicResolutionStatements
  **/
  @ApiModelProperty(required = true, value = "The array of mosaic resolutions for the block requested.")
  public List<ResolutionStatementDTO> getMosaicResolutionStatements() {
    return mosaicResolutionStatements;
  }

  public void setMosaicResolutionStatements(List<ResolutionStatementDTO> mosaicResolutionStatements) {
    this.mosaicResolutionStatements = mosaicResolutionStatements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatementsDTO statementsDTO = (StatementsDTO) o;
    return Objects.equals(this.transactionStatements, statementsDTO.transactionStatements) &&
        Objects.equals(this.addressResolutionStatements, statementsDTO.addressResolutionStatements) &&
        Objects.equals(this.mosaicResolutionStatements, statementsDTO.mosaicResolutionStatements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionStatements, addressResolutionStatements, mosaicResolutionStatements);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatementsDTO {\n");
    sb.append("    transactionStatements: ").append(toIndentedString(transactionStatements)).append("\n");
    sb.append("    addressResolutionStatements: ").append(toIndentedString(addressResolutionStatements)).append("\n");
    sb.append("    mosaicResolutionStatements: ").append(toIndentedString(mosaicResolutionStatements)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

