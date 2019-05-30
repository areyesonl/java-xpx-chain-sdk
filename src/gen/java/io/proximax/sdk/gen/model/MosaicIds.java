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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * MosaicIds
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-31T00:16:53.236+02:00")
public class MosaicIds {
  @SerializedName("mosaicIds")
  private List<String> mosaicIds = null;

  public MosaicIds mosaicIds(List<String> mosaicIds) {
    this.mosaicIds = mosaicIds;
    return this;
  }

  public MosaicIds addMosaicIdsItem(String mosaicIdsItem) {
    if (this.mosaicIds == null) {
      this.mosaicIds = new ArrayList<String>();
    }
    this.mosaicIds.add(mosaicIdsItem);
    return this;
  }

   /**
   * Get mosaicIds
   * @return mosaicIds
  **/
  @ApiModelProperty(example = "[\"d525ad41d95fcf29\"]", value = "")
  public List<String> getMosaicIds() {
    return mosaicIds;
  }

  public void setMosaicIds(List<String> mosaicIds) {
    this.mosaicIds = mosaicIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MosaicIds mosaicIds = (MosaicIds) o;
    return Objects.equals(this.mosaicIds, mosaicIds.mosaicIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mosaicIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MosaicIds {\n");
    
    sb.append("    mosaicIds: ").append(toIndentedString(mosaicIds)).append("\n");
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

