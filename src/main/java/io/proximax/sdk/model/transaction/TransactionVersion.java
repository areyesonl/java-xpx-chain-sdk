/*
 * Copyright 2018 NEM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.proximax.sdk.model.transaction;

/**
 * Enum containing transaction type versions.
 *
 * Transaction format versions are defined in catapult-server in each transaction's plugin source code.
 *
 * In [catapult-server](https://github.com/proximax-storage/catapult-server), the `DEFINE_TRANSACTION_CONSTANTS` macro is used to
 * define the `TYPE` and `VERSION` of the transaction format.
 *
 */
public enum TransactionVersion {

   // Mosaic
   /**
    * Mosaic definition transaction type.
    */
   MOSAIC_DEFINITION(3),

   /**
    * Mosaic supply change transaction.
    */
   MOSAIC_SUPPLY_CHANGE(2),

   // Namespace
   /**
    * Register namespace transaction type.
    */
   REGISTER_NAMESPACE(2),

   /**
    * Address alias transaction type.
    */
   ADDRESS_ALIAS(1),

   /**
    * Mosaic alias transaction type.
    */
   MOSAIC_ALIAS(1),

   // Transfer
   /**
    * Transfer Transaction transaction type.
    */
   TRANSFER(3),

   // Multisignature
   /**
    * Modify multisig account transaction type.
    */
   MODIFY_MULTISIG_ACCOUNT(3),

   /**
    * Aggregate complete transaction type.
    */
   AGGREGATE_COMPLETE(2),

   /**
    * Aggregate bonded transaction type
    */
   AGGREGATE_BONDED(2),

   /**
    * Hash Lock transaction type
    */
   LOCK(1),

   // Account filters
   /**
    * Account properties address transaction type
    */
   ACCOUNT_PROPERTIES_ADDRESS(1),

   /**
    * Account properties mosaic transaction type
    */
   ACCOUNT_PROPERTIES_MOSAIC(1),

   /**
    * Account properties entity type transaction type
    */
   ACCOUNT_PROPERTIES_ENTITY_TYPE(1),

   // Cross-chain swaps
   /**
    * Secret Lock Transaction type
    */
   SECRET_LOCK(1),

   /**
    * Secret Proof transaction type
    */
   SECRET_PROOF(1),

   // Remote harvesting
   /**
    * Account link transaction type
    */
   ACCOUNT_LINK(2),
   
   /**
    * modification of metadata
    */
   METADATA_MODIFICATION(1);

   private Integer code;

   TransactionVersion(int code) {
      this.code = code;
   }

   /**
    * Returns enum value.
    *
    * @return enum value
    */
   public Integer getValue() {
      return this.code;
   }
}