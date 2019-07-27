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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TransactionIds
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-05T16:42:36.122+02:00[Europe/Prague]")
public class TransactionIds {
  public static final String SERIALIZED_NAME_TRANSACTION_IDS = "transactionIds";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_IDS)
  private List<String> transactionIds = new ArrayList<>();

  public TransactionIds transactionIds(List<String> transactionIds) {
    this.transactionIds = transactionIds;
    return this;
  }

  public TransactionIds addTransactionIdsItem(String transactionIdsItem) {
    if (this.transactionIds == null) {
      this.transactionIds = new ArrayList<>();
    }
    this.transactionIds.add(transactionIdsItem);
    return this;
  }

   /**
   * The array of transaction ids.
   * @return transactionIds
  **/
  @ApiModelProperty(example = "[\"59B8DA0F0CB2720001103922\",\"59B8D8E60CB2720001103904\"]", value = "The array of transaction ids.")
  public List<String> getTransactionIds() {
    return transactionIds;
  }

  public void setTransactionIds(List<String> transactionIds) {
    this.transactionIds = transactionIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionIds transactionIds = (TransactionIds) o;
    return Objects.equals(this.transactionIds, transactionIds.transactionIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionIds {\n");
    sb.append("    transactionIds: ").append(toIndentedString(transactionIds)).append("\n");
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

