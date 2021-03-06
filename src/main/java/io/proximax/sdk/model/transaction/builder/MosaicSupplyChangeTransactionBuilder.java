/*
 * Copyright 2019 ProximaX Limited. All rights reserved.
 * Use of this source code is governed by the Apache 2.0
 * license that can be found in the LICENSE file.
 */
package io.proximax.sdk.model.transaction.builder;

import java.math.BigInteger;

import io.proximax.sdk.model.mosaic.MosaicId;
import io.proximax.sdk.model.mosaic.MosaicSupplyType;
import io.proximax.sdk.model.transaction.EntityType;
import io.proximax.sdk.model.transaction.EntityVersion;
import io.proximax.sdk.model.transaction.MosaicSupplyChangeTransaction;

/**
 * <p>
 * builder for {@link MosaicSupplyChangeTransaction}
 * </p>
 * <p>
 * Standard use: call {@link #increase(MosaicId, BigInteger)} or {@link #decrease(MosaicId, BigInteger)}
 * </p>
 */
public class MosaicSupplyChangeTransactionBuilder
      extends TransactionBuilder<MosaicSupplyChangeTransactionBuilder, MosaicSupplyChangeTransaction> {

   private MosaicId mosaicId;
   private MosaicSupplyType mosaicSupplyType;
   private BigInteger delta;

   public MosaicSupplyChangeTransactionBuilder() {
      super(EntityType.MOSAIC_SUPPLY_CHANGE, EntityVersion.MOSAIC_SUPPLY_CHANGE.getValue());
   }

   @Override
   protected MosaicSupplyChangeTransactionBuilder self() {
      return this;
   }

   @Override
   public MosaicSupplyChangeTransaction build() {
      // use or calculate maxFee
      BigInteger maxFee = getMaxFee()
            .orElseGet(() -> getMaxFeeCalculation(MosaicSupplyChangeTransaction.calculatePayloadSize()));
      // create transaction instance
      return new MosaicSupplyChangeTransaction(getNetworkType(), getVersion(), getDeadline(), maxFee, getSignature(),
            getSigner(), getTransactionInfo(), getMosaicId(), getMosaicSupplyType(), getDelta());
   }

   // ------------------------------------- setters ---------------------------------------------//

   /**
    * define mosaic ID to change supply for
    * 
    * @param mosaicId the mosaic ID
    * @return self
    */
   public MosaicSupplyChangeTransactionBuilder mosaicId(MosaicId mosaicId) {
      this.mosaicId = mosaicId;
      return self();
   }

   /**
    * define type of the change to the mosaic supply
    * 
    * @param mosaicSupplyType the change type
    * @return self
    */
   public MosaicSupplyChangeTransactionBuilder mosaicSupplyType(MosaicSupplyType mosaicSupplyType) {
      this.mosaicSupplyType = mosaicSupplyType;
      return self();
   }

   /**
    * define the change to the supply as delta
    * 
    * @param delta the delta from current state
    * @return self
    */
   public MosaicSupplyChangeTransactionBuilder delta(BigInteger delta) {
      this.delta = delta;
      return self();
   }

   // -------------------------------------- getters --------------------------------------------//

   /**
    * @return the mosaicId
    */
   public MosaicId getMosaicId() {
      return mosaicId;
   }

   /**
    * @return the mosaicSupplyType
    */
   public MosaicSupplyType getMosaicSupplyType() {
      return mosaicSupplyType;
   }

   /**
    * @return the delta
    */
   public BigInteger getDelta() {
      return delta;
   }

   // -------------------------------------- convenience --------------------------------------------//

   /**
    * increase supply for specified mosaic ID
    * 
    * @param mosaicId the mosaic ID to increase supply for
    * @return self
    * @deprecated use {@link #increase(MosaicId, BigInteger)} instead
    */
   @Deprecated
   public MosaicSupplyChangeTransactionBuilder increaseSupplyFor(MosaicId mosaicId) {
      mosaicSupplyType(MosaicSupplyType.INCREASE);
      mosaicId(mosaicId);
      return self();
   }

   /**
    * increase supply for specified mosaic ID
    * 
    * @param mosaicId the mosaic ID to increase supply for
    * @param delta supply amount added to current supply
    * @return self
    */
   public MosaicSupplyChangeTransactionBuilder increase(MosaicId mosaicId, BigInteger delta) {
      return mosaicSupplyType(MosaicSupplyType.INCREASE).mosaicId(mosaicId).delta(delta);
   }

   /**
    * decrease supply for specified mosaic ID
    * 
    * @param mosaicId the mosaic ID to decrease supply for
    * @return self
    * @deprecated use {@link #decrease(MosaicId, BigInteger)} instead
    */
   @Deprecated
   public MosaicSupplyChangeTransactionBuilder decreaseSupplyFor(MosaicId mosaicId) {
      mosaicSupplyType(MosaicSupplyType.DECREASE);
      mosaicId(mosaicId);
      return self();
   }

   /**
    * decrease supply for specified mosaic ID
    * 
    * @param mosaicId the mosaic ID to decrease supply for
    * @param delta supply amount subtracted from current supply
    * @return self
    */
   public MosaicSupplyChangeTransactionBuilder decrease(MosaicId mosaicId, BigInteger delta) {
      return mosaicSupplyType(MosaicSupplyType.DECREASE).mosaicId(mosaicId).delta(delta);
   }
}
