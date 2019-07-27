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
import io.proximax.sdk.gen.model.LinkActionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * AccountLinkTransactionBodyDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-05T16:42:36.122+02:00[Europe/Prague]")
public class AccountLinkTransactionBodyDTO {
  public static final String SERIALIZED_NAME_REMOTE_ACCOUNT_KEY = "remoteAccountKey";
  @SerializedName(SERIALIZED_NAME_REMOTE_ACCOUNT_KEY)
  private String remoteAccountKey;

  public static final String SERIALIZED_NAME_LINK_ACTION = "linkAction";
  @SerializedName(SERIALIZED_NAME_LINK_ACTION)
  private LinkActionEnum linkAction;

  public AccountLinkTransactionBodyDTO remoteAccountKey(String remoteAccountKey) {
    this.remoteAccountKey = remoteAccountKey;
    return this;
  }

   /**
   * The public key of the remote account.
   * @return remoteAccountKey
  **/
  @ApiModelProperty(required = true, value = "The public key of the remote account.")
  public String getRemoteAccountKey() {
    return remoteAccountKey;
  }

  public void setRemoteAccountKey(String remoteAccountKey) {
    this.remoteAccountKey = remoteAccountKey;
  }

  public AccountLinkTransactionBodyDTO linkAction(LinkActionEnum linkAction) {
    this.linkAction = linkAction;
    return this;
  }

   /**
   * Get linkAction
   * @return linkAction
  **/
  @ApiModelProperty(required = true, value = "")
  public LinkActionEnum getLinkAction() {
    return linkAction;
  }

  public void setLinkAction(LinkActionEnum linkAction) {
    this.linkAction = linkAction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountLinkTransactionBodyDTO accountLinkTransactionBodyDTO = (AccountLinkTransactionBodyDTO) o;
    return Objects.equals(this.remoteAccountKey, accountLinkTransactionBodyDTO.remoteAccountKey) &&
        Objects.equals(this.linkAction, accountLinkTransactionBodyDTO.linkAction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(remoteAccountKey, linkAction);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountLinkTransactionBodyDTO {\n");
    sb.append("    remoteAccountKey: ").append(toIndentedString(remoteAccountKey)).append("\n");
    sb.append("    linkAction: ").append(toIndentedString(linkAction)).append("\n");
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

