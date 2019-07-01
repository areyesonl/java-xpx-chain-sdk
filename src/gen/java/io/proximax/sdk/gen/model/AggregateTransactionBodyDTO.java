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
import io.proximax.sdk.gen.model.CosignatureDTO;
import io.proximax.sdk.gen.model.EmbeddedTransactionInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AggregateTransactionBodyDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-01T21:35:58.261+02:00[Europe/Prague]")
public class AggregateTransactionBodyDTO {
  public static final String SERIALIZED_NAME_COSIGNATURES = "cosignatures";
  @SerializedName(SERIALIZED_NAME_COSIGNATURES)
  private List<CosignatureDTO> cosignatures = new ArrayList<>();

  public static final String SERIALIZED_NAME_TRANSACTIONS = "transactions";
  @SerializedName(SERIALIZED_NAME_TRANSACTIONS)
  private List<EmbeddedTransactionInfoDTO> transactions = new ArrayList<>();

  public AggregateTransactionBodyDTO cosignatures(List<CosignatureDTO> cosignatures) {
    this.cosignatures = cosignatures;
    return this;
  }

  public AggregateTransactionBodyDTO addCosignaturesItem(CosignatureDTO cosignaturesItem) {
    this.cosignatures.add(cosignaturesItem);
    return this;
  }

   /**
   * An array of transaction cosignatures.
   * @return cosignatures
  **/
  @ApiModelProperty(required = true, value = "An array of transaction cosignatures.")
  public List<CosignatureDTO> getCosignatures() {
    return cosignatures;
  }

  public void setCosignatures(List<CosignatureDTO> cosignatures) {
    this.cosignatures = cosignatures;
  }

  public AggregateTransactionBodyDTO transactions(List<EmbeddedTransactionInfoDTO> transactions) {
    this.transactions = transactions;
    return this;
  }

  public AggregateTransactionBodyDTO addTransactionsItem(EmbeddedTransactionInfoDTO transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

   /**
   * The array of transactions initiated by different accounts.
   * @return transactions
  **/
  @ApiModelProperty(required = true, value = "The array of transactions initiated by different accounts.")
  public List<EmbeddedTransactionInfoDTO> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<EmbeddedTransactionInfoDTO> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AggregateTransactionBodyDTO aggregateTransactionBodyDTO = (AggregateTransactionBodyDTO) o;
    return Objects.equals(this.cosignatures, aggregateTransactionBodyDTO.cosignatures) &&
        Objects.equals(this.transactions, aggregateTransactionBodyDTO.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cosignatures, transactions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AggregateTransactionBodyDTO {\n");
    sb.append("    cosignatures: ").append(toIndentedString(cosignatures)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

