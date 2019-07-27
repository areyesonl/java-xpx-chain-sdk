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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * AccountPropertyDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-05T16:42:36.122+02:00[Europe/Prague]")
public class AccountPropertyDTO {
  public static final String SERIALIZED_NAME_PROPERTY_TYPE = "propertyType";
  @SerializedName(SERIALIZED_NAME_PROPERTY_TYPE)
  private AccountPropertyTypeEnum propertyType;

  public static final String SERIALIZED_NAME_VALUES = "values";
  @SerializedName(SERIALIZED_NAME_VALUES)
  private List<Object> values = new ArrayList<>();

  public AccountPropertyDTO propertyType(AccountPropertyTypeEnum propertyType) {
    this.propertyType = propertyType;
    return this;
  }

   /**
   * Get propertyType
   * @return propertyType
  **/
  @ApiModelProperty(required = true, value = "")
  public AccountPropertyTypeEnum getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(AccountPropertyTypeEnum propertyType) {
    this.propertyType = propertyType;
  }

  public AccountPropertyDTO values(List<Object> values) {
    this.values = values;
    return this;
  }

  public AccountPropertyDTO addValuesItem(Object valuesItem) {
    this.values.add(valuesItem);
    return this;
  }

   /**
   * The address, transaction type or mosaic id to filter.
   * @return values
  **/
  @ApiModelProperty(required = true, value = "The address, transaction type or mosaic id to filter.")
  public List<Object> getValues() {
    return values;
  }

  public void setValues(List<Object> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountPropertyDTO accountPropertyDTO = (AccountPropertyDTO) o;
    return Objects.equals(this.propertyType, accountPropertyDTO.propertyType) &&
        Objects.equals(this.values, accountPropertyDTO.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyType, values);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountPropertyDTO {\n");
    sb.append("    propertyType: ").append(toIndentedString(propertyType)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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

