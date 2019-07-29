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
import io.proximax.sdk.gen.model.AliasActionEnum;
import io.proximax.sdk.gen.model.UInt64DTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * AddressAliasTransactionBodyDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-05T16:42:36.122+02:00[Europe/Prague]")
public class AddressAliasTransactionBodyDTO {
  public static final String SERIALIZED_NAME_ALIAS_ACTION = "aliasAction";
  @SerializedName(SERIALIZED_NAME_ALIAS_ACTION)
  private AliasActionEnum aliasAction;

  public static final String SERIALIZED_NAME_NAMESPACE_ID = "namespaceId";
  @SerializedName(SERIALIZED_NAME_NAMESPACE_ID)
  private UInt64DTO namespaceId = new UInt64DTO();

  public static final String SERIALIZED_NAME_ADDRESS = "address";
  @SerializedName(SERIALIZED_NAME_ADDRESS)
  private String address;

  public AddressAliasTransactionBodyDTO aliasAction(AliasActionEnum aliasAction) {
    this.aliasAction = aliasAction;
    return this;
  }

   /**
   * Get aliasAction
   * @return aliasAction
  **/
  @ApiModelProperty(required = true, value = "")
  public AliasActionEnum getAliasAction() {
    return aliasAction;
  }

  public void setAliasAction(AliasActionEnum aliasAction) {
    this.aliasAction = aliasAction;
  }

  public AddressAliasTransactionBodyDTO namespaceId(UInt64DTO namespaceId) {
    this.namespaceId = namespaceId;
    return this;
  }

   /**
   * Get namespaceId
   * @return namespaceId
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getNamespaceId() {
    return namespaceId;
  }

  public void setNamespaceId(UInt64DTO namespaceId) {
    this.namespaceId = namespaceId;
  }

  public AddressAliasTransactionBodyDTO address(String address) {
    this.address = address;
    return this;
  }

   /**
   * The aliased address in hexadecimal.
   * @return address
  **/
  @ApiModelProperty(required = true, value = "The aliased address in hexadecimal.")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressAliasTransactionBodyDTO addressAliasTransactionBodyDTO = (AddressAliasTransactionBodyDTO) o;
    return Objects.equals(this.aliasAction, addressAliasTransactionBodyDTO.aliasAction) &&
        Objects.equals(this.namespaceId, addressAliasTransactionBodyDTO.namespaceId) &&
        Objects.equals(this.address, addressAliasTransactionBodyDTO.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aliasAction, namespaceId, address);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressAliasTransactionBodyDTO {\n");
    sb.append("    aliasAction: ").append(toIndentedString(aliasAction)).append("\n");
    sb.append("    namespaceId: ").append(toIndentedString(namespaceId)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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
