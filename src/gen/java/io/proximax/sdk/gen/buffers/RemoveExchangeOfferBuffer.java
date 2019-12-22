// automatically generated by the FlatBuffers compiler, do not modify

package io.proximax.sdk.gen.buffers;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class RemoveExchangeOfferBuffer extends Table {
  public static RemoveExchangeOfferBuffer getRootAsRemoveExchangeOfferBuffer(ByteBuffer _bb) { return getRootAsRemoveExchangeOfferBuffer(_bb, new RemoveExchangeOfferBuffer()); }
  public static RemoveExchangeOfferBuffer getRootAsRemoveExchangeOfferBuffer(ByteBuffer _bb, RemoveExchangeOfferBuffer obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public RemoveExchangeOfferBuffer __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public long mosaicId(int j) { int o = __offset(4); return o != 0 ? (long)bb.getInt(__vector(o) + j * 4) & 0xFFFFFFFFL : 0; }
  public int mosaicIdLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer mosaicIdAsByteBuffer() { return __vector_as_bytebuffer(4, 4); }
  public ByteBuffer mosaicIdInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 4); }
  public int type() { int o = __offset(6); return o != 0 ? bb.get(o + bb_pos) & 0xFF : 0; }

  public static int createRemoveExchangeOfferBuffer(FlatBufferBuilder builder,
      int mosaicIdOffset,
      int type) {
    builder.startObject(2);
    RemoveExchangeOfferBuffer.addMosaicId(builder, mosaicIdOffset);
    RemoveExchangeOfferBuffer.addType(builder, type);
    return RemoveExchangeOfferBuffer.endRemoveExchangeOfferBuffer(builder);
  }

  public static void startRemoveExchangeOfferBuffer(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addMosaicId(FlatBufferBuilder builder, int mosaicIdOffset) { builder.addOffset(0, mosaicIdOffset, 0); }
  public static int createMosaicIdVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startMosaicIdVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addType(FlatBufferBuilder builder, int type) { builder.addByte(1, (byte)type, (byte)0); }
  public static int endRemoveExchangeOfferBuffer(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}
