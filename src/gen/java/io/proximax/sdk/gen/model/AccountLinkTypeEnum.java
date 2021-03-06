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
import io.swagger.annotations.ApiModel;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * The account link types: * 0 -  Unlinked. Account is not linked to another account. * 1 -  Main. Account is a balance-holding account that is linked to a remote harvester account. * 2 -  Remote. Account is a remote harvester account that is linked to a balance-holding account. * 3 -  Remote_Unlinked. Account is a remote harvester eligible account that is unlinked. 
 */
@JsonAdapter(AccountLinkTypeEnum.Adapter.class)
public enum AccountLinkTypeEnum {
  
  NUMBER_0(0),
  
  NUMBER_1(1),
  
  NUMBER_2(2),
  
  NUMBER_3(3);

  private Integer value;

  AccountLinkTypeEnum(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static AccountLinkTypeEnum fromValue(Integer value) {
    for (AccountLinkTypeEnum b : AccountLinkTypeEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<AccountLinkTypeEnum> {
    @Override
    public void write(final JsonWriter jsonWriter, final AccountLinkTypeEnum enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public AccountLinkTypeEnum read(final JsonReader jsonReader) throws IOException {
      Integer value = jsonReader.nextInt();
      return AccountLinkTypeEnum.fromValue(value);
    }
  }
}

