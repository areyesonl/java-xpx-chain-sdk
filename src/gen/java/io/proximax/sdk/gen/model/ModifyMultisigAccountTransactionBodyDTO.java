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
import io.proximax.sdk.gen.model.CosignatoryModificationDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ModifyMultisigAccountTransactionBodyDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-01T21:35:58.261+02:00[Europe/Prague]")
public class ModifyMultisigAccountTransactionBodyDTO {
  public static final String SERIALIZED_NAME_MIN_REMOVAL_DELTA = "minRemovalDelta";
  @SerializedName(SERIALIZED_NAME_MIN_REMOVAL_DELTA)
  private Integer minRemovalDelta;

  public static final String SERIALIZED_NAME_MIN_APPROVAL_DELTA = "minApprovalDelta";
  @SerializedName(SERIALIZED_NAME_MIN_APPROVAL_DELTA)
  private Integer minApprovalDelta;

  public static final String SERIALIZED_NAME_MODIFICATIONS = "modifications";
  @SerializedName(SERIALIZED_NAME_MODIFICATIONS)
  private List<CosignatoryModificationDTO> modifications = new ArrayList<>();

  public ModifyMultisigAccountTransactionBodyDTO minRemovalDelta(Integer minRemovalDelta) {
    this.minRemovalDelta = minRemovalDelta;
    return this;
  }

   /**
   * The number of signatures needed to remove a cosignatory. If we are modifying an existing multisig account, this indicates the relative change of the minimum cosignatories. 
   * @return minRemovalDelta
  **/
  @ApiModelProperty(example = "1", required = true, value = "The number of signatures needed to remove a cosignatory. If we are modifying an existing multisig account, this indicates the relative change of the minimum cosignatories. ")
  public Integer getMinRemovalDelta() {
    return minRemovalDelta;
  }

  public void setMinRemovalDelta(Integer minRemovalDelta) {
    this.minRemovalDelta = minRemovalDelta;
  }

  public ModifyMultisigAccountTransactionBodyDTO minApprovalDelta(Integer minApprovalDelta) {
    this.minApprovalDelta = minApprovalDelta;
    return this;
  }

   /**
   * The number of signatures needed to approve a transaction. If we are modifying an existing multisig account, this indicates the relative change of the minimum cosignatories. 
   * @return minApprovalDelta
  **/
  @ApiModelProperty(example = "1", required = true, value = "The number of signatures needed to approve a transaction. If we are modifying an existing multisig account, this indicates the relative change of the minimum cosignatories. ")
  public Integer getMinApprovalDelta() {
    return minApprovalDelta;
  }

  public void setMinApprovalDelta(Integer minApprovalDelta) {
    this.minApprovalDelta = minApprovalDelta;
  }

  public ModifyMultisigAccountTransactionBodyDTO modifications(List<CosignatoryModificationDTO> modifications) {
    this.modifications = modifications;
    return this;
  }

  public ModifyMultisigAccountTransactionBodyDTO addModificationsItem(CosignatoryModificationDTO modificationsItem) {
    this.modifications.add(modificationsItem);
    return this;
  }

   /**
   * The array of cosignatory accounts to add or delete.
   * @return modifications
  **/
  @ApiModelProperty(required = true, value = "The array of cosignatory accounts to add or delete.")
  public List<CosignatoryModificationDTO> getModifications() {
    return modifications;
  }

  public void setModifications(List<CosignatoryModificationDTO> modifications) {
    this.modifications = modifications;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyMultisigAccountTransactionBodyDTO modifyMultisigAccountTransactionBodyDTO = (ModifyMultisigAccountTransactionBodyDTO) o;
    return Objects.equals(this.minRemovalDelta, modifyMultisigAccountTransactionBodyDTO.minRemovalDelta) &&
        Objects.equals(this.minApprovalDelta, modifyMultisigAccountTransactionBodyDTO.minApprovalDelta) &&
        Objects.equals(this.modifications, modifyMultisigAccountTransactionBodyDTO.modifications);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minRemovalDelta, minApprovalDelta, modifications);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyMultisigAccountTransactionBodyDTO {\n");
    sb.append("    minRemovalDelta: ").append(toIndentedString(minRemovalDelta)).append("\n");
    sb.append("    minApprovalDelta: ").append(toIndentedString(minApprovalDelta)).append("\n");
    sb.append("    modifications: ").append(toIndentedString(modifications)).append("\n");
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

