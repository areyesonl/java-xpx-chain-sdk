// automatically generated by the FlatBuffers compiler, do not modify

package io.proximax.sdk.gen.buffers;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class PropertyModificationBuffer extends Table {
  public static PropertyModificationBuffer getRootAsPropertyModificationBuffer(ByteBuffer _bb) { return getRootAsPropertyModificationBuffer(_bb, new PropertyModificationBuffer()); }
  public static PropertyModificationBuffer getRootAsPropertyModificationBuffer(ByteBuffer _bb, PropertyModificationBuffer obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public PropertyModificationBuffer __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int modificationType() { int o = __offset(4); return o != 0 ? bb.get(o + bb_pos) & 0xFF : 0; }
  /**
   * In case of address it is 25 bytes array. In case of mosaic it is 8 byte array(or 2 uint32 array).
   * In case of transaction it is 2 byte array(ushort)
   */
  public int value(int j) { int o = __offset(6); return o != 0 ? bb.get(__vector(o) + j * 1) & 0xFF : 0; }
  public int valueLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer valueAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer valueInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }

  public static int createPropertyModificationBuffer(FlatBufferBuilder builder,
      int modificationType,
      int valueOffset) {
    builder.startObject(2);
    PropertyModificationBuffer.addValue(builder, valueOffset);
    PropertyModificationBuffer.addModificationType(builder, modificationType);
    return PropertyModificationBuffer.endPropertyModificationBuffer(builder);
  }

  public static void startPropertyModificationBuffer(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addModificationType(FlatBufferBuilder builder, int modificationType) { builder.addByte(0, (byte)modificationType, (byte)0); }
  public static void addValue(FlatBufferBuilder builder, int valueOffset) { builder.addOffset(1, valueOffset, 0); }
  public static int createValueVector(FlatBufferBuilder builder, byte[] data) { builder.startVector(1, data.length, 1); for (int i = data.length - 1; i >= 0; i--) builder.addByte(data[i]); return builder.endVector(); }
  public static void startValueVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static int endPropertyModificationBuffer(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

