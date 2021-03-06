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
import io.proximax.sdk.gen.model.FieldDTO;
import io.proximax.sdk.gen.model.MetadataDTO;
import io.proximax.sdk.gen.model.NamespaceMetadataDTOAllOf;
import io.proximax.sdk.gen.model.UInt64DTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * NamespaceMetadataDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-22T22:57:50.932+02:00[Europe/Prague]")
public class NamespaceMetadataDTO {
  public static final String SERIALIZED_NAME_METADATA_TYPE = "metadataType";
  @SerializedName(SERIALIZED_NAME_METADATA_TYPE)
  private Integer metadataType;

  public static final String SERIALIZED_NAME_FIELDS = "fields";
  @SerializedName(SERIALIZED_NAME_FIELDS)
  private List<FieldDTO> fields = new ArrayList<>();

  public static final String SERIALIZED_NAME_METADATA_ID = "metadataId";
  @SerializedName(SERIALIZED_NAME_METADATA_ID)
  private UInt64DTO metadataId = new UInt64DTO();

  public NamespaceMetadataDTO metadataType(Integer metadataType) {
    this.metadataType = metadataType;
    return this;
  }

   /**
   * Get metadataType
   * @return metadataType
  **/
  @ApiModelProperty(example = "3", required = true, value = "")
  public Integer getMetadataType() {
    return metadataType;
  }

  public void setMetadataType(Integer metadataType) {
    this.metadataType = metadataType;
  }

  public NamespaceMetadataDTO fields(List<FieldDTO> fields) {
    this.fields = fields;
    return this;
  }

  public NamespaceMetadataDTO addFieldsItem(FieldDTO fieldsItem) {
    this.fields.add(fieldsItem);
    return this;
  }

   /**
   * Get fields
   * @return fields
  **/
  @ApiModelProperty(required = true, value = "")
  public List<FieldDTO> getFields() {
    return fields;
  }

  public void setFields(List<FieldDTO> fields) {
    this.fields = fields;
  }

  public NamespaceMetadataDTO metadataId(UInt64DTO metadataId) {
    this.metadataId = metadataId;
    return this;
  }

   /**
   * Get metadataId
   * @return metadataId
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getMetadataId() {
    return metadataId;
  }

  public void setMetadataId(UInt64DTO metadataId) {
    this.metadataId = metadataId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NamespaceMetadataDTO namespaceMetadataDTO = (NamespaceMetadataDTO) o;
    return Objects.equals(this.metadataType, namespaceMetadataDTO.metadataType) &&
        Objects.equals(this.fields, namespaceMetadataDTO.fields) &&
        Objects.equals(this.metadataId, namespaceMetadataDTO.metadataId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadataType, fields, metadataId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NamespaceMetadataDTO {\n");
    sb.append("    metadataType: ").append(toIndentedString(metadataType)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    metadataId: ").append(toIndentedString(metadataId)).append("\n");
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

