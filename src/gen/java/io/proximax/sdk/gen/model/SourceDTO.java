/*
 * Catapult REST API Reference
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
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

/**
 * The transaction that triggered the receipt.
 */
@ApiModel(description = "The transaction that triggered the receipt.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-22T22:57:50.932+02:00[Europe/Prague]")
public class SourceDTO {
  public static final String SERIALIZED_NAME_PRIMARY_ID = "primaryId";
  @SerializedName(SERIALIZED_NAME_PRIMARY_ID)
  private Integer primaryId;

  public static final String SERIALIZED_NAME_SECONDARY_ID = "secondaryId";
  @SerializedName(SERIALIZED_NAME_SECONDARY_ID)
  private Integer secondaryId;

  public SourceDTO primaryId(Integer primaryId) {
    this.primaryId = primaryId;
    return this;
  }

   /**
   * The transaction index within the block.
   * @return primaryId
  **/
  @ApiModelProperty(example = "1", required = true, value = "The transaction index within the block.")
  public Integer getPrimaryId() {
    return primaryId;
  }

  public void setPrimaryId(Integer primaryId) {
    this.primaryId = primaryId;
  }

  public SourceDTO secondaryId(Integer secondaryId) {
    this.secondaryId = secondaryId;
    return this;
  }

   /**
   * The transaction index inside within the aggregate transaction. If the transaction is not an inner transaction, then the secondary id is set to 0.
   * @return secondaryId
  **/
  @ApiModelProperty(example = "0", required = true, value = "The transaction index inside within the aggregate transaction. If the transaction is not an inner transaction, then the secondary id is set to 0.")
  public Integer getSecondaryId() {
    return secondaryId;
  }

  public void setSecondaryId(Integer secondaryId) {
    this.secondaryId = secondaryId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceDTO sourceDTO = (SourceDTO) o;
    return Objects.equals(this.primaryId, sourceDTO.primaryId) &&
        Objects.equals(this.secondaryId, sourceDTO.secondaryId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(primaryId, secondaryId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceDTO {\n");
    sb.append("    primaryId: ").append(toIndentedString(primaryId)).append("\n");
    sb.append("    secondaryId: ").append(toIndentedString(secondaryId)).append("\n");
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

