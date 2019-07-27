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

/**
 * ServerInfoDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-05T16:42:36.122+02:00[Europe/Prague]")
public class ServerInfoDTO {
  public static final String SERIALIZED_NAME_REST_VERSION = "restVersion";
  @SerializedName(SERIALIZED_NAME_REST_VERSION)
  private String restVersion;

  public static final String SERIALIZED_NAME_SDK_VERSION = "sdkVersion";
  @SerializedName(SERIALIZED_NAME_SDK_VERSION)
  private String sdkVersion;

  public ServerInfoDTO restVersion(String restVersion) {
    this.restVersion = restVersion;
    return this;
  }

   /**
   * The catapult-rest component version.
   * @return restVersion
  **/
  @ApiModelProperty(example = "1.0.14", required = true, value = "The catapult-rest component version.")
  public String getRestVersion() {
    return restVersion;
  }

  public void setRestVersion(String restVersion) {
    this.restVersion = restVersion;
  }

  public ServerInfoDTO sdkVersion(String sdkVersion) {
    this.sdkVersion = sdkVersion;
    return this;
  }

   /**
   * The catapult-sdk component version.
   * @return sdkVersion
  **/
  @ApiModelProperty(example = "0.7.14", required = true, value = "The catapult-sdk component version.")
  public String getSdkVersion() {
    return sdkVersion;
  }

  public void setSdkVersion(String sdkVersion) {
    this.sdkVersion = sdkVersion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerInfoDTO serverInfoDTO = (ServerInfoDTO) o;
    return Objects.equals(this.restVersion, serverInfoDTO.restVersion) &&
        Objects.equals(this.sdkVersion, serverInfoDTO.sdkVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restVersion, sdkVersion);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerInfoDTO {\n");
    sb.append("    restVersion: ").append(toIndentedString(restVersion)).append("\n");
    sb.append("    sdkVersion: ").append(toIndentedString(sdkVersion)).append("\n");
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

