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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import io.proximax.sdk.BaseTest;
import io.proximax.sdk.model.mosaic.MosaicId;
import io.proximax.sdk.model.mosaic.MosaicInfo;
import io.proximax.sdk.model.mosaic.MosaicName;
import io.proximax.sdk.model.mosaic.NetworkCurrencyMosaic;
import io.reactivex.schedulers.Schedulers;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MosaicHttpTest extends BaseTest {
    private MosaicHttp mosaicHttp;

    @BeforeAll
    void setup() throws IOException {
        mosaicHttp = new MosaicHttp(this.getNodeUrl());
    }

    @Test
    void getMosaic() throws ExecutionException, InterruptedException {
        MosaicInfo mosaicInfo = mosaicHttp
                .getMosaic(NetworkCurrencyMosaic.ID)
                .toFuture()
                .get();

        assertEquals(new BigInteger("1"), mosaicInfo.getHeight());
        assertEquals(NetworkCurrencyMosaic.ID, mosaicInfo.getMosaicId());
    }

    @Test
    void getMosaics() throws ExecutionException, InterruptedException {
        List<MosaicInfo> mosaicsInfo = mosaicHttp
                .getMosaics(Collections.singletonList(NetworkCurrencyMosaic.ID))
                .toFuture()
                .get();

        assertEquals(NetworkCurrencyMosaic.ID, mosaicsInfo.get(0).getMosaicId());
    }

    @Test
    @Disabled("not implemented yet")
    void getMosaicNames() throws ExecutionException, InterruptedException {
        List<MosaicName> mosaicNames = mosaicHttp
                .getMosaicNames(Collections.singletonList(NetworkCurrencyMosaic.ID))
                .toFuture()
                .get();

        assertEquals("xpx", mosaicNames.get(0).getName());
        assertEquals(NetworkCurrencyMosaic.ID, mosaicNames.get(0).getMosaicId());
    }

    @Test
    void throwExceptionWhenMosaicDoesNotExists() {
        mosaicHttp
                .getMosaic(new MosaicId(BigInteger.valueOf(123456789l)))
                .subscribeOn(Schedulers.single())
                .test()
                .awaitDone(2, TimeUnit.SECONDS)
                .assertFailure(RuntimeException.class);
    }

}