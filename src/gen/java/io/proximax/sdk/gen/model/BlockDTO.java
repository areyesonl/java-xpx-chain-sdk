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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * BlockDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-22T22:57:50.932+02:00[Europe/Prague]")
public class BlockDTO {
  public static final String SERIALIZED_NAME_SIGNATURE = "signature";
  @SerializedName(SERIALIZED_NAME_SIGNATURE)
  private String signature;

  public static final String SERIALIZED_NAME_SIGNER = "signer";
  @SerializedName(SERIALIZED_NAME_SIGNER)
  private String signer;

  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private Long version;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private EntityTypeEnum type;

  public static final String SERIALIZED_NAME_HEIGHT = "height";
  @SerializedName(SERIALIZED_NAME_HEIGHT)
  private UInt64DTO height = new UInt64DTO();

  public static final String SERIALIZED_NAME_TIMESTAMP = "timestamp";
  @SerializedName(SERIALIZED_NAME_TIMESTAMP)
  private UInt64DTO timestamp = new UInt64DTO();

  public static final String SERIALIZED_NAME_DIFFICULTY = "difficulty";
  @SerializedName(SERIALIZED_NAME_DIFFICULTY)
  private UInt64DTO difficulty = new UInt64DTO();

  public static final String SERIALIZED_NAME_FEE_MULTIPLIER = "feeMultiplier";
  @SerializedName(SERIALIZED_NAME_FEE_MULTIPLIER)
  private Integer feeMultiplier;

  public static final String SERIALIZED_NAME_PREVIOUS_BLOCK_HASH = "previousBlockHash";
  @SerializedName(SERIALIZED_NAME_PREVIOUS_BLOCK_HASH)
  private String previousBlockHash;

  public static final String SERIALIZED_NAME_BLOCK_TRANSACTIONS_HASH = "blockTransactionsHash";
  @SerializedName(SERIALIZED_NAME_BLOCK_TRANSACTIONS_HASH)
  private String blockTransactionsHash;

  public static final String SERIALIZED_NAME_BLOCK_RECEIPTS_HASH = "blockReceiptsHash";
  @SerializedName(SERIALIZED_NAME_BLOCK_RECEIPTS_HASH)
  private String blockReceiptsHash;

  public static final String SERIALIZED_NAME_STATE_HASH = "stateHash";
  @SerializedName(SERIALIZED_NAME_STATE_HASH)
  private String stateHash;

  public static final String SERIALIZED_NAME_BENEFICIARY = "beneficiary";
  @SerializedName(SERIALIZED_NAME_BENEFICIARY)
  private String beneficiary;

  public static final String SERIALIZED_NAME_FEE_INTEREST = "feeInterest";
  @SerializedName(SERIALIZED_NAME_FEE_INTEREST)
  private Integer feeInterest;

  public static final String SERIALIZED_NAME_FEE_INTEREST_DENOMINATOR = "feeInterestDenominator";
  @SerializedName(SERIALIZED_NAME_FEE_INTEREST_DENOMINATOR)
  private Integer feeInterestDenominator;

  public BlockDTO signature(String signature) {
    this.signature = signature;
    return this;
  }

   /**
   * The signature of the entity. The signature was generated by the signer and can be used to validate tha the entity data was not modified by a node. 
   * @return signature
  **/
  @ApiModelProperty(example = "D8047EB8285077D9900EDD42F4081070DDB26E08E7F15A3E29642C80CF0C7D68340682DC9868C73EB09744D6298146D8DFC02ED47070FC81FB47D6F73B33EF0A", required = true, value = "The signature of the entity. The signature was generated by the signer and can be used to validate tha the entity data was not modified by a node. ")
  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public BlockDTO signer(String signer) {
    this.signer = signer;
    return this;
  }

   /**
   * The public key of the entity signer formatted as hexadecimal.
   * @return signer
  **/
  @ApiModelProperty(example = "D799E559AB735A5E62187306E80C1679EE3E1170532280C968D974E351CB412F", required = true, value = "The public key of the entity signer formatted as hexadecimal.")
  public String getSigner() {
    return signer;
  }

  public void setSigner(String signer) {
    this.signer = signer;
  }

  public BlockDTO version(Long version) {
    this.version = version;
    return this;
  }

   /**
   * The entity version. The higher byte represents the network identifier: * 0x68 (MAIN_NET) - Public main network. * 0x98 (TEST_NET) - Public test network. * 0x60 (MIJIN) - Private network. * 0x90 (MIJIN_TEST) - Private test network. 
   * @return version
  **/
  @ApiModelProperty(example = "36867", required = true, value = "The entity version. The higher byte represents the network identifier: * 0x68 (MAIN_NET) - Public main network. * 0x98 (TEST_NET) - Public test network. * 0x60 (MIJIN) - Private network. * 0x90 (MIJIN_TEST) - Private test network. ")
  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public BlockDTO type(EntityTypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public EntityTypeEnum getType() {
    return type;
  }

  public void setType(EntityTypeEnum type) {
    this.type = type;
  }

  public BlockDTO height(UInt64DTO height) {
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

  public BlockDTO timestamp(UInt64DTO timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(UInt64DTO timestamp) {
    this.timestamp = timestamp;
  }

  public BlockDTO difficulty(UInt64DTO difficulty) {
    this.difficulty = difficulty;
    return this;
  }

   /**
   * Get difficulty
   * @return difficulty
  **/
  @ApiModelProperty(required = true, value = "")
  public UInt64DTO getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(UInt64DTO difficulty) {
    this.difficulty = difficulty;
  }

  public BlockDTO feeMultiplier(Integer feeMultiplier) {
    this.feeMultiplier = feeMultiplier;
    return this;
  }

   /**
   * The fee multiplier applied to transactions contained in block.
   * @return feeMultiplier
  **/
  @ApiModelProperty(example = "0", required = true, value = "The fee multiplier applied to transactions contained in block.")
  public Integer getFeeMultiplier() {
    return feeMultiplier;
  }

  public void setFeeMultiplier(Integer feeMultiplier) {
    this.feeMultiplier = feeMultiplier;
  }

  public BlockDTO previousBlockHash(String previousBlockHash) {
    this.previousBlockHash = previousBlockHash;
    return this;
  }

   /**
   * The hash of the previous block.
   * @return previousBlockHash
  **/
  @ApiModelProperty(example = "[0]", required = true, value = "The hash of the previous block.")
  public String getPreviousBlockHash() {
    return previousBlockHash;
  }

  public void setPreviousBlockHash(String previousBlockHash) {
    this.previousBlockHash = previousBlockHash;
  }

  public BlockDTO blockTransactionsHash(String blockTransactionsHash) {
    this.blockTransactionsHash = blockTransactionsHash;
    return this;
  }

   /**
   * The transactions included in a block are hashed forming a merkle tree. The root of the tree summarizes them. 
   * @return blockTransactionsHash
  **/
  @ApiModelProperty(example = "8F8C6EB33332F69196AD0D30D7CD90FAC1332089DF460DF0CF4A8A28C1C17AD4", required = true, value = "The transactions included in a block are hashed forming a merkle tree. The root of the tree summarizes them. ")
  public String getBlockTransactionsHash() {
    return blockTransactionsHash;
  }

  public void setBlockTransactionsHash(String blockTransactionsHash) {
    this.blockTransactionsHash = blockTransactionsHash;
  }

  public BlockDTO blockReceiptsHash(String blockReceiptsHash) {
    this.blockReceiptsHash = blockReceiptsHash;
    return this;
  }

   /**
   * The collection of receipts  are hashed into a merkle tree and linked  to a block. The block header stores the root hash. 
   * @return blockReceiptsHash
  **/
  @ApiModelProperty(example = "sZznHmvGSZKIy1Ney2O0tKxJ4sOgk5jYYhqsua1RCRo=", required = true, value = "The collection of receipts  are hashed into a merkle tree and linked  to a block. The block header stores the root hash. ")
  public String getBlockReceiptsHash() {
    return blockReceiptsHash;
  }

  public void setBlockReceiptsHash(String blockReceiptsHash) {
    this.blockReceiptsHash = blockReceiptsHash;
  }

  public BlockDTO stateHash(String stateHash) {
    this.stateHash = stateHash;
    return this;
  }

   /**
   * For each block, the state of the blockchain is stored in RocksDB,  forming a patricia tree. The root of the tree summarizes the state of the blockchain for the given block. 
   * @return stateHash
  **/
  @ApiModelProperty(example = "011811795453FA9FBD9DAC969085F8938BBFEDE3A3FDDC0C93B8FD6C4E7B2840", required = true, value = "For each block, the state of the blockchain is stored in RocksDB,  forming a patricia tree. The root of the tree summarizes the state of the blockchain for the given block. ")
  public String getStateHash() {
    return stateHash;
  }

  public void setStateHash(String stateHash) {
    this.stateHash = stateHash;
  }

  public BlockDTO beneficiary(String beneficiary) {
    this.beneficiary = beneficiary;
    return this;
  }

   /**
   * The public key of the optional beneficiary designated by harvester.
   * @return beneficiary
  **/
  @ApiModelProperty(example = "0", required = true, value = "The public key of the optional beneficiary designated by harvester.")
  public String getBeneficiary() {
    return beneficiary;
  }

  public void setBeneficiary(String beneficiary) {
    this.beneficiary = beneficiary;
  }

  public BlockDTO feeInterest(Integer feeInterest) {
    this.feeInterest = feeInterest;
    return this;
  }

   /**
   * The part of the transaction fee harvester is willing to get. From 0 up to FeeInterestDenominator. The customer gets (FeeInterest / FeeInterestDenominator)&#39;th part of the maximum transaction fee.
   * @return feeInterest
  **/
  @ApiModelProperty(example = "0", required = true, value = "The part of the transaction fee harvester is willing to get. From 0 up to FeeInterestDenominator. The customer gets (FeeInterest / FeeInterestDenominator)'th part of the maximum transaction fee.")
  public Integer getFeeInterest() {
    return feeInterest;
  }

  public void setFeeInterest(Integer feeInterest) {
    this.feeInterest = feeInterest;
  }

  public BlockDTO feeInterestDenominator(Integer feeInterestDenominator) {
    this.feeInterestDenominator = feeInterestDenominator;
    return this;
  }

   /**
   * Denominator of the transaction fee.
   * @return feeInterestDenominator
  **/
  @ApiModelProperty(example = "0", required = true, value = "Denominator of the transaction fee.")
  public Integer getFeeInterestDenominator() {
    return feeInterestDenominator;
  }

  public void setFeeInterestDenominator(Integer feeInterestDenominator) {
    this.feeInterestDenominator = feeInterestDenominator;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockDTO blockDTO = (BlockDTO) o;
    return Objects.equals(this.signature, blockDTO.signature) &&
        Objects.equals(this.signer, blockDTO.signer) &&
        Objects.equals(this.version, blockDTO.version) &&
        Objects.equals(this.type, blockDTO.type) &&
        Objects.equals(this.height, blockDTO.height) &&
        Objects.equals(this.timestamp, blockDTO.timestamp) &&
        Objects.equals(this.difficulty, blockDTO.difficulty) &&
        Objects.equals(this.feeMultiplier, blockDTO.feeMultiplier) &&
        Objects.equals(this.previousBlockHash, blockDTO.previousBlockHash) &&
        Objects.equals(this.blockTransactionsHash, blockDTO.blockTransactionsHash) &&
        Objects.equals(this.blockReceiptsHash, blockDTO.blockReceiptsHash) &&
        Objects.equals(this.stateHash, blockDTO.stateHash) &&
        Objects.equals(this.beneficiary, blockDTO.beneficiary) &&
        Objects.equals(this.feeInterest, blockDTO.feeInterest) &&
        Objects.equals(this.feeInterestDenominator, blockDTO.feeInterestDenominator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signature, signer, version, type, height, timestamp, difficulty, feeMultiplier, previousBlockHash, blockTransactionsHash, blockReceiptsHash, stateHash, beneficiary, feeInterest, feeInterestDenominator);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockDTO {\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    signer: ").append(toIndentedString(signer)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    difficulty: ").append(toIndentedString(difficulty)).append("\n");
    sb.append("    feeMultiplier: ").append(toIndentedString(feeMultiplier)).append("\n");
    sb.append("    previousBlockHash: ").append(toIndentedString(previousBlockHash)).append("\n");
    sb.append("    blockTransactionsHash: ").append(toIndentedString(blockTransactionsHash)).append("\n");
    sb.append("    blockReceiptsHash: ").append(toIndentedString(blockReceiptsHash)).append("\n");
    sb.append("    stateHash: ").append(toIndentedString(stateHash)).append("\n");
    sb.append("    beneficiary: ").append(toIndentedString(beneficiary)).append("\n");
    sb.append("    feeInterest: ").append(toIndentedString(feeInterest)).append("\n");
    sb.append("    feeInterestDenominator: ").append(toIndentedString(feeInterestDenominator)).append("\n");
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

