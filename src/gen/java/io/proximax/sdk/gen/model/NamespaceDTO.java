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
import io.proximax.sdk.gen.model.AliasDTO;
import io.proximax.sdk.gen.model.NamespaceTypeEnum;
import io.proximax.sdk.gen.model.UInt64DTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * NamespaceDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-01T21:35:58.261+02:00[Europe/Prague]")
public class NamespaceDTO {
  public static final String SERIALIZED_NAME_OWNER = "owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private String owner;

  public static final String SERIALIZED_NAME_OWNER_ADDRESS = "ownerAddress";
  @SerializedName(SERIALIZED_NAME_OWNER_ADDRESS)
  private String ownerAddress;

  public static final String SERIALIZED_NAME_START_HEIGHT = "startHeight";
  @SerializedName(SERIALIZED_NAME_START_HEIGHT)
  private UInt64DTO startHeight = new UInt64DTO();

  public static final String SERIALIZED_NAME_END_HEIGHT = "endHeight";
  @SerializedName(SERIALIZED_NAME_END_HEIGHT)
  private UInt64DTO endHeight = new UInt64DTO();

  public static final String SERIALIZED_NAME_DEPTH = "depth";
  @SerializedName(SERIALIZED_NAME_DEPTH)
  private Integer depth;

  public static final String SERIALIZED_NAME_LEVEL0 = "level0";
  @SerializedName(SERIALIZED_NAME_LEVEL0)
  private UInt64DTO level0 = new UInt64DTO();

  public static final String SERIALIZED_NAME_LEVEL1 = "level1";
  @SerializedName(SERIALIZED_NAME_LEVEL1)
  private UInt64DTO level1 = new UInt64DTO();

  public static final String SERIALIZED_NAME_LEVEL2 = "level2";
  @SerializedName(SERIALIZED_NAME_LEVEL2)
  private UInt64DTO level2 = new UInt64DTO();

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private NamespaceTypeEnum type;

  public static final String SERIALIZED_NAME_ALIAS = "alias";
  @SerializedName(SERIALIZED_NAME_ALIAS)
  private AliasDTO alias = null;

  public static final String SERIALIZED_NAME_PARENT_ID = "parentId";
  @SerializedName(SERIALIZED_NAME_PARENT_ID)
  private UInt64DTO parentId = new UInt64DTO();

  public NamespaceDTO owner(String owner) {
    this.owner = owner;
    return this;
  }

   /**
   * The public key of the owner of the namespace.
   * @return owner
  **/
  @ApiModelProperty(example = "EFF9BC7472263D03EF6362B1F200FD3061BCD1BABE78F82119FB88811227CE85", required = true, value = "The public key of the owner of the namespace.")
  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public NamespaceDTO ownerAddress(String ownerAddress) {
    this.ownerAddress = ownerAddress;
    return this;
  }

   /**
   * The address of the owner of the namespace in hexadecimal.
   * @return ownerAddress
  **/
  @ApiModelProperty(example = "906CBD9B8EC88014F7A4181B00C1837646BD46E504E3D72C44", required = true, value = "The address of the owner of the namespace in hexadecimal.")
  public String getOwnerAddress() {
    return ownerAddress;
  }

  public void setOwnerAddress(String ownerAddress) {
    this.ownerAddress = ownerAddress;
  }

  public NamespaceDTO startHeight(UInt64DTO startHeight) {
    this.startHeight = startHeight;
    return this;
  }

   /**
   * Get startHeight
   * @return startHeight
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getStartHeight() {
    return startHeight;
  }

  public void setStartHeight(UInt64DTO startHeight) {
    this.startHeight = startHeight;
  }

  public NamespaceDTO endHeight(UInt64DTO endHeight) {
    this.endHeight = endHeight;
    return this;
  }

   /**
   * Get endHeight
   * @return endHeight
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getEndHeight() {
    return endHeight;
  }

  public void setEndHeight(UInt64DTO endHeight) {
    this.endHeight = endHeight;
  }

  public NamespaceDTO depth(Integer depth) {
    this.depth = depth;
    return this;
  }

   /**
   * The level of the namespace.
   * @return depth
  **/
  @ApiModelProperty(example = "1", required = true, value = "The level of the namespace.")
  public Integer getDepth() {
    return depth;
  }

  public void setDepth(Integer depth) {
    this.depth = depth;
  }

  public NamespaceDTO level0(UInt64DTO level0) {
    this.level0 = level0;
    return this;
  }

   /**
   * Get level0
   * @return level0
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getLevel0() {
    return level0;
  }

  public void setLevel0(UInt64DTO level0) {
    this.level0 = level0;
  }

  public NamespaceDTO level1(UInt64DTO level1) {
    this.level1 = level1;
    return this;
  }

   /**
   * Get level1
   * @return level1
  **/
  @ApiModelProperty(value = "")
  public UInt64DTO getLevel1() {
    return level1;
  }

  public void setLevel1(UInt64DTO level1) {
    this.level1 = level1;
  }

  public NamespaceDTO level2(UInt64DTO level2) {
    this.level2 = level2;
    return this;
  }

   /**
   * Get level2
   * @return level2
  **/
  @ApiModelProperty(value = "")
  public UInt64DTO getLevel2() {
    return level2;
  }

  public void setLevel2(UInt64DTO level2) {
    this.level2 = level2;
  }

  public NamespaceDTO type(NamespaceTypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public NamespaceTypeEnum getType() {
    return type;
  }

  public void setType(NamespaceTypeEnum type) {
    this.type = type;
  }

  public NamespaceDTO alias(AliasDTO alias) {
    this.alias = alias;
    return this;
  }

   /**
   * Get alias
   * @return alias
  **/
  @ApiModelProperty(required = true, value = "")
  public AliasDTO getAlias() {
    return alias;
  }

  public void setAlias(AliasDTO alias) {
    this.alias = alias;
  }

  public NamespaceDTO parentId(UInt64DTO parentId) {
    this.parentId = parentId;
    return this;
  }

   /**
   * Get parentId
   * @return parentId
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getParentId() {
    return parentId;
  }

  public void setParentId(UInt64DTO parentId) {
    this.parentId = parentId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NamespaceDTO namespaceDTO = (NamespaceDTO) o;
    return Objects.equals(this.owner, namespaceDTO.owner) &&
        Objects.equals(this.ownerAddress, namespaceDTO.ownerAddress) &&
        Objects.equals(this.startHeight, namespaceDTO.startHeight) &&
        Objects.equals(this.endHeight, namespaceDTO.endHeight) &&
        Objects.equals(this.depth, namespaceDTO.depth) &&
        Objects.equals(this.level0, namespaceDTO.level0) &&
        Objects.equals(this.level1, namespaceDTO.level1) &&
        Objects.equals(this.level2, namespaceDTO.level2) &&
        Objects.equals(this.type, namespaceDTO.type) &&
        Objects.equals(this.alias, namespaceDTO.alias) &&
        Objects.equals(this.parentId, namespaceDTO.parentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, ownerAddress, startHeight, endHeight, depth, level0, level1, level2, type, alias, parentId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NamespaceDTO {\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    ownerAddress: ").append(toIndentedString(ownerAddress)).append("\n");
    sb.append("    startHeight: ").append(toIndentedString(startHeight)).append("\n");
    sb.append("    endHeight: ").append(toIndentedString(endHeight)).append("\n");
    sb.append("    depth: ").append(toIndentedString(depth)).append("\n");
    sb.append("    level0: ").append(toIndentedString(level0)).append("\n");
    sb.append("    level1: ").append(toIndentedString(level1)).append("\n");
    sb.append("    level2: ").append(toIndentedString(level2)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
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

