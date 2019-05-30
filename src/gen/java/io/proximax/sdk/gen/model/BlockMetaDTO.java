/*
 * Catapult REST API Reference
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.13
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
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
import io.proximax.sdk.gen.model.UInt64DTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * BlockMetaDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-31T00:16:53.236+02:00")
public class BlockMetaDTO {
  @SerializedName("hash")
  private String hash = null;

  @SerializedName("generationHash")
  private String generationHash = null;

  @SerializedName("totalFee")
  private UInt64DTO totalFee = null;

  @SerializedName("numTransactions")
  private BigDecimal numTransactions = null;

  public BlockMetaDTO hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * Get hash
   * @return hash
  **/
  @ApiModelProperty(required = true, value = "")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public BlockMetaDTO generationHash(String generationHash) {
    this.generationHash = generationHash;
    return this;
  }

   /**
   * Get generationHash
   * @return generationHash
  **/
  @ApiModelProperty(required = true, value = "")
  public String getGenerationHash() {
    return generationHash;
  }

  public void setGenerationHash(String generationHash) {
    this.generationHash = generationHash;
  }

  public BlockMetaDTO totalFee(UInt64DTO totalFee) {
    this.totalFee = totalFee;
    return this;
  }

   /**
   * Get totalFee
   * @return totalFee
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(UInt64DTO totalFee) {
    this.totalFee = totalFee;
  }

  public BlockMetaDTO numTransactions(BigDecimal numTransactions) {
    this.numTransactions = numTransactions;
    return this;
  }

   /**
   * Get numTransactions
   * @return numTransactions
  **/
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getNumTransactions() {
    return numTransactions;
  }

  public void setNumTransactions(BigDecimal numTransactions) {
    this.numTransactions = numTransactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockMetaDTO blockMetaDTO = (BlockMetaDTO) o;
    return Objects.equals(this.hash, blockMetaDTO.hash) &&
        Objects.equals(this.generationHash, blockMetaDTO.generationHash) &&
        Objects.equals(this.totalFee, blockMetaDTO.totalFee) &&
        Objects.equals(this.numTransactions, blockMetaDTO.numTransactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hash, generationHash, totalFee, numTransactions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockMetaDTO {\n");
    
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    generationHash: ").append(toIndentedString(generationHash)).append("\n");
    sb.append("    totalFee: ").append(toIndentedString(totalFee)).append("\n");
    sb.append("    numTransactions: ").append(toIndentedString(numTransactions)).append("\n");
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

