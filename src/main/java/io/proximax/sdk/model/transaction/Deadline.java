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

import java.math.BigInteger;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * The deadline of the transaction. The deadline is given as the number of milliseconds elapsed since the creation of the
 * nemesis block. If a transaction does not get included in a block before the deadline is reached, it is deleted.
 */
public class Deadline implements TransactionDeadline {

   /**
    * epoch of the network is hard-coded value and all times are relative to that
    */
   public static final Instant NETWORK_EPOCH = Instant.ofEpochMilli(NETWORK_EPOCH_START_MILLIS);
   private final Instant instant;

   /**
    * Constructor
    *
    * @param units int
    * @param chronoUnit Chrono unit
    */
   public Deadline(int units, ChronoUnit chronoUnit) {
      instant = Instant.now().plus(units, chronoUnit);
   }

   /**
    * Constructor
    *
    * @param input Deadline in BigInteger format
    */
   public Deadline(BigInteger input) {
      instant = Instant.ofEpochMilli(input.longValue() + NETWORK_EPOCH_START_MILLIS);
   }

   /**
    * Create deadline model.
    *
    * @param units int
    * @param chronoUnit Chrono unit
    * @return {@link Deadline}
    */
   public static Deadline create(int units, ChronoUnit chronoUnit) {
      return new Deadline(units, chronoUnit);
   }

   @Override
   public long getInstant() {
      return instant.toEpochMilli() - Deadline.NETWORK_EPOCH.toEpochMilli();
   }

   @Override
   public String toString() {
      return "Deadline [instant=" + instant + "]";
   }
}
