/*
 * Copyright 2019 ProximaX
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
 * TODO add proper description
 */
public interface TransactionDeadline {
   
   public static final long MILLIS_OF_NEMESIS = 1459468800l;
   
   /**
    * Returns number of milliseconds elapsed since the creation of the nemesis block.
    *
    * @return long
    */
   long getInstant();
}
