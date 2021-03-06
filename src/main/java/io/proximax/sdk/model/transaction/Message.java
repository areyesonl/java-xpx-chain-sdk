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
 * An abstract message class that serves as the base class of all message types.
 *
 * @since 1.0
 */
public abstract class Message {
    private final int type;
    private byte[] encodedPayload;
    private String payload;

    public Message(int type, byte[] encodedPayload, String payload)
    {
        this.type = type;
        this.encodedPayload = encodedPayload;
        this.payload = payload;
    }

    /**
     * Returns message type.
     *
     * @return int
     */
    public int getTypeCode() {
        return type;
    }

    /**
     * get message type
     * 
     * @return MessageType enum entry representing the message type code or UNKNOWN
     */
    public MessageType getType() {
    	return MessageType.getByCode(type);
    }
    
    /**
     * Returns message payload.
     *
     * @return String
     */
    public String getPayload() {
        return payload;
    }

    /**
     * Returns encoded payload
     *
     * @return String
     */
    public byte[] getEncodedPayload() {
        return encodedPayload;
    }
}
