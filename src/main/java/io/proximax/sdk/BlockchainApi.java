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
package io.proximax.sdk;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.proximax.sdk.infrastructure.AccountHttp;
import io.proximax.sdk.infrastructure.BlockchainHttp;
import io.proximax.sdk.infrastructure.Listener;
import io.proximax.sdk.infrastructure.MetadataHttp;
import io.proximax.sdk.infrastructure.MosaicHttp;
import io.proximax.sdk.infrastructure.NamespaceHttp;
import io.proximax.sdk.infrastructure.NetworkHttp;
import io.proximax.sdk.infrastructure.TransactionHttp;
import io.proximax.sdk.model.blockchain.NetworkType;

/**
 * Central API for blockchain interaction
 */
public class BlockchainApi {
   /** URL of the node */
   private final URL url;
   /** network type of the node */
   private NetworkType networkType;
   
   /**
    * create new instance that connects to specified node
    * 
    * @param url URL of the node
    */
   public BlockchainApi(URL url) {
      this.url = url;
   }
   
   /**
    * create new instance that connects to specified node
    * 
    * @param url URL of the node
    * @param networkType network type of the node
    */
   public BlockchainApi(URL url, NetworkType networkType) {
      this.url = url;
      this.networkType = networkType;
   }
   
   /**
    * check that the network type matches what is reported by the node
    * 
    * this is useful to make sure that network type is OK. This method also loads network type if not specified
    * in constructor
    * 
    * @return true if reported network type matches expectation, false otherwise
    */
   public boolean isNetworkTypeValid() {
      return queryForNetowrkType() == getNetworkType();
   }
   
   /**
    * create account repository
    * 
    * @return the account repository
    */
   public AccountRepository createAccountRepository() {
      return new AccountHttp(this);
   }

   /**
    * create blockchain repository
    * 
    * @return the blockchain repository
    */
   public BlockchainRepository createBlockchainRepository() {
      return new BlockchainHttp(this);
   }

   /**
    * create metadata repository
    * 
    * @return the metadata repository
    */
   public MetadataRepository createMetadataRepository() {
      return new MetadataHttp(this);
   }
   
   /**
    * create mosaic repository
    * 
    * @return the mosaic repository
    */
   public MosaicRepository createMosaicRepository() {
      return new MosaicHttp(this);
   }
   
   /**
    * create namespace repository
    * 
    * @return the namespace repository
    */
   public NamespaceRepository createNamespaceRepository() {
      return new NamespaceHttp(this);
   }
   
   /**
    * create network repository
    * 
    * @return the network repository
    */
   public NetworkRepository createNetworkRepository() {
      return new NetworkHttp(this);
   }

   /**
    * create transaction repository
    * 
    * @return the transaction repository
    */
   public TransactionRepository createTransactionRepository() {
      return new TransactionHttp(this);
   }

   /**
    * create listener that allows caller to subscribe to various network events
    * 
    * @return the network listener
    */
   public Listener createListener() {
      return new Listener(url);
   }
   
   /**
    * get the configured network type
    * 
    * @return the networkType
    */
   public synchronized NetworkType getNetworkType() {
      if (networkType == null) {
         
      }
      return networkType;
   }

   /**
    * get the URL of the node
    * 
    * @return the URL of the node
    */
   public URL getUrl() {
      return url;
   }
   
   /**
    * query the network blockchain API to retrieve network type as reported by the node
    * 
    * @return network type of the node
    */
   private NetworkType queryForNetowrkType() {
      return createNetworkRepository().getNetworkType().timeout(30, TimeUnit.SECONDS).blockingFirst();
   }
}