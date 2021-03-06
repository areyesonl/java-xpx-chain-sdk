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
import io.proximax.sdk.gen.model.MosaicPropertyDTO;
import io.proximax.sdk.gen.model.UInt64DTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * MosaicDefinitionDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-22T22:57:50.932+02:00[Europe/Prague]")
public class MosaicDefinitionDTO {
  public static final String SERIALIZED_NAME_MOSAIC_ID = "mosaicId";
  @SerializedName(SERIALIZED_NAME_MOSAIC_ID)
  private UInt64DTO mosaicId = new UInt64DTO();

  public static final String SERIALIZED_NAME_SUPPLY = "supply";
  @SerializedName(SERIALIZED_NAME_SUPPLY)
  private UInt64DTO supply = new UInt64DTO();

  public static final String SERIALIZED_NAME_HEIGHT = "height";
  @SerializedName(SERIALIZED_NAME_HEIGHT)
  private UInt64DTO height = new UInt64DTO();

  public static final String SERIALIZED_NAME_OWNER = "owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private String owner;

  public static final String SERIALIZED_NAME_REVISION = "revision";
  @SerializedName(SERIALIZED_NAME_REVISION)
  private Integer revision;

  public static final String SERIALIZED_NAME_PROPERTIES = "properties";
  @SerializedName(SERIALIZED_NAME_PROPERTIES)
  private List<MosaicPropertyDTO> properties = new ArrayList<>();

  public MosaicDefinitionDTO mosaicId(UInt64DTO mosaicId) {
    this.mosaicId = mosaicId;
    return this;
  }

   /**
   * Get mosaicId
   * @return mosaicId
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getMosaicId() {
    return mosaicId;
  }

  public void setMosaicId(UInt64DTO mosaicId) {
    this.mosaicId = mosaicId;
  }

  public MosaicDefinitionDTO supply(UInt64DTO supply) {
    this.supply = supply;
    return this;
  }

   /**
   * Get supply
   * @return supply
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getSupply() {
    return supply;
  }

  public void setSupply(UInt64DTO supply) {
    this.supply = supply;
  }

  public MosaicDefinitionDTO height(UInt64DTO height) {
    this.height = height;
    return this;
  }

   /**
   * Get height
   * @return height
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getHeight() {
    return height;
  }

  public void setHeight(UInt64DTO height) {
    this.height = height;
  }

  public MosaicDefinitionDTO owner(String owner) {
    this.owner = owner;
    return this;
  }

   /**
   * The public key of the mosaic owner.
   * @return owner
  **/
  @ApiModelProperty(example = "EFF9BC7472263D03EF6362B1F200FD3061BCD1BABE78F82119FB88811227CE85", required = true, value = "The public key of the mosaic owner.")
  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public MosaicDefinitionDTO revision(Integer revision) {
    this.revision = revision;
    return this;
  }

   /**
   * The number of definitions for the same mosaic.
   * @return revision
  **/
  @ApiModelProperty(example = "1", required = true, value = "The number of definitions for the same mosaic.")
  public Integer getRevision() {
    return revision;
  }

  public void setRevision(Integer revision) {
    this.revision = revision;
  }

  public MosaicDefinitionDTO properties(List<MosaicPropertyDTO> properties) {
    this.properties = properties;
    return this;
  }

  public MosaicDefinitionDTO addPropertiesItem(MosaicPropertyDTO propertiesItem) {
    this.properties.add(propertiesItem);
    return this;
  }

   /**
   * Get properties
   * @return properties
  **/
  @ApiModelProperty(required = true, value = "")
  public List<MosaicPropertyDTO> getProperties() {
    return properties;
  }

  public void setProperties(List<MosaicPropertyDTO> properties) {
    this.properties = properties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MosaicDefinitionDTO mosaicDefinitionDTO = (MosaicDefinitionDTO) o;
    return Objects.equals(this.mosaicId, mosaicDefinitionDTO.mosaicId) &&
        Objects.equals(this.supply, mosaicDefinitionDTO.supply) &&
        Objects.equals(this.height, mosaicDefinitionDTO.height) &&
        Objects.equals(this.owner, mosaicDefinitionDTO.owner) &&
        Objects.equals(this.revision, mosaicDefinitionDTO.revision) &&
        Objects.equals(this.properties, mosaicDefinitionDTO.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mosaicId, supply, height, owner, revision, properties);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MosaicDefinitionDTO {\n");
    sb.append("    mosaicId: ").append(toIndentedString(mosaicId)).append("\n");
    sb.append("    supply: ").append(toIndentedString(supply)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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

