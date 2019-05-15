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

package io.proximax.sdk.infrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import io.proximax.sdk.BaseTest;
import io.proximax.sdk.model.account.Account;
import io.proximax.sdk.model.account.Address;
import io.proximax.sdk.model.namespace.NamespaceId;
import io.proximax.sdk.model.namespace.NamespaceInfo;
import io.proximax.sdk.model.namespace.NamespaceName;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NamespaceHttpTest extends BaseTest {
   protected static final String NAMESPACE_CATAPULT_NAME = "cat";
   protected static final NamespaceId CATAPULT_NAMESPACE_ID = new NamespaceId(NAMESPACE_CATAPULT_NAME);
   
   private NamespaceHttp namespaceHttp;
   private Account seedAccount;
   private Address king = Address
         .createFromPublicKey("B4F12E7C9F6946091E2CB8B6D3A12B50D17CCBBF646386EA27CE2946A7423DCF", getNetworkType());

   @BeforeAll
   void setup() throws IOException {
      namespaceHttp = new NamespaceHttp(this.getNodeUrl());
      seedAccount = getSeedAccount();
   }

   @Test
   void getNamespace() throws ExecutionException, InterruptedException {
      NamespaceInfo namespaceInfo = namespaceHttp.getNamespace(CATAPULT_NAMESPACE_ID).toFuture().get();

      assertEquals(new BigInteger("1"), namespaceInfo.getStartHeight());
      assertEquals(new BigInteger("-1"), namespaceInfo.getEndHeight());
      assertEquals(CATAPULT_NAMESPACE_ID, namespaceInfo.getLevels().get(0));
   }

   @Test
   void getVerifyNamespaceIdGenerator() throws ExecutionException, InterruptedException {
      NamespaceInfo namespaceInfoByNum = namespaceHttp.getNamespace(CATAPULT_NAMESPACE_ID).toFuture().get();
      NamespaceInfo namespaceInfoByName = namespaceHttp.getNamespace(new NamespaceId(NAMESPACE_CATAPULT_NAME)).toFuture().get();

      assertEquals(namespaceInfoByNum.getOwner(), namespaceInfoByName.getOwner());
   }

   @Test
   void getNamespacesFromAccount() throws ExecutionException, InterruptedException {
      List<NamespaceInfo> namespacesInfo = namespaceHttp.getNamespacesFromAccount(king).toFuture()
            .get();

      assertEquals(3, namespacesInfo.size());
      assertEquals(new BigInteger("1"), namespacesInfo.get(0).getStartHeight());
      assertEquals(new BigInteger("-1"), namespacesInfo.get(0).getEndHeight());
      assertEquals(CATAPULT_NAMESPACE_ID, namespacesInfo.get(0).getLevels().get(0));
   }

   @Test
   void getNamespacesFromAccounts() throws ExecutionException, InterruptedException {
      List<NamespaceInfo> namespacesInfo = namespaceHttp
            .getNamespacesFromAccounts(Collections.singletonList(king)).toFuture().get();

      assertEquals(3, namespacesInfo.size());
      assertEquals(new BigInteger("1"), namespacesInfo.get(0).getStartHeight());
      assertEquals(new BigInteger("-1"), namespacesInfo.get(0).getEndHeight());
      assertEquals(CATAPULT_NAMESPACE_ID, namespacesInfo.get(0).getLevels().get(0));
   }

   @Test
   void getNamespaceNames() throws ExecutionException, InterruptedException {
      List<NamespaceName> namespaceNames = namespaceHttp.getNamespaceNames(Collections.singletonList(CATAPULT_NAMESPACE_ID))
            .toFuture().get();

      assertEquals(1, namespaceNames.size());
      assertEquals(NAMESPACE_CATAPULT_NAME, namespaceNames.get(0).getName());
      assertEquals(CATAPULT_NAMESPACE_ID, namespaceNames.get(0).getNamespaceId());
   }

   @Test
   void throwExceptionWhenNamespaceDoesNotExists() {
      TestObserver<NamespaceInfo> testObserver = new TestObserver<>();
      namespaceHttp.getNamespace(new NamespaceId("nonregisterednamespace")).subscribeOn(Schedulers.single()).test()
            .awaitDone(2, TimeUnit.SECONDS).assertFailure(RuntimeException.class);
   }
}
