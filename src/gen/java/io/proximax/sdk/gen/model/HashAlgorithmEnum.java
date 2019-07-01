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
import io.swagger.annotations.ApiModel;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * The hash algorithm used to hash te proof: * 0 (Op_Sha3_256)  - The proof is hashed using sha3 256. * 1 (Op_Keccak_256)  - The proof is hashed using Keccak (ETH compatibility). * 2 (Op_Hash_160)  - The proof is hashed twice: first with Sha-256 and then with RIPEMD-160 (bitcoin’s OP_HASH160). * 3 (Op_Hash_256)  - The proof is hashed twice with Sha-256 (bitcoin’s OP_HASH256). 
 */
@JsonAdapter(HashAlgorithmEnum.Adapter.class)
public enum HashAlgorithmEnum {
  
  NUMBER_0(0),
  
  NUMBER_1(1),
  
  NUMBER_2(2),
  
  NUMBER_3(3);

  private Integer value;

  HashAlgorithmEnum(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static HashAlgorithmEnum fromValue(Integer value) {
    for (HashAlgorithmEnum b : HashAlgorithmEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<HashAlgorithmEnum> {
    @Override
    public void write(final JsonWriter jsonWriter, final HashAlgorithmEnum enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public HashAlgorithmEnum read(final JsonReader jsonReader) throws IOException {
      Integer value = jsonReader.nextInt();
      return HashAlgorithmEnum.fromValue(value);
    }
  }
}

