// automatically generated by the FlatBuffers compiler, do not modify

package io.nem.sdk.model.transaction;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class MosaicAliasDefinitionTransactionBuffer extends Table {
  public static MosaicAliasDefinitionTransactionBuffer getRootAsMosaicAliasDefinitionTransactionBuffer(ByteBuffer _bb) { return getRootAsMosaicAliasDefinitionTransactionBuffer(_bb, new MosaicAliasDefinitionTransactionBuffer()); }
  public static MosaicAliasDefinitionTransactionBuffer getRootAsMosaicAliasDefinitionTransactionBuffer(ByteBuffer _bb, MosaicAliasDefinitionTransactionBuffer obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public MosaicAliasDefinitionTransactionBuffer __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public long size() { int o = __offset(4); return o != 0 ? (long)bb.getInt(o + bb_pos) & 0xFFFFFFFFL : 0L; }
  public int signature(int j) { int o = __offset(6); return o != 0 ? bb.get(__vector(o) + j * 1) & 0xFF : 0; }
  public int signatureLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer signatureAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer signatureInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }
  public int signer(int j) { int o = __offset(8); return o != 0 ? bb.get(__vector(o) + j * 1) & 0xFF : 0; }
  public int signerLength() { int o = __offset(8); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer signerAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public ByteBuffer signerInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 8, 1); }
  public int version() { int o = __offset(10); return o != 0 ? bb.getShort(o + bb_pos) & 0xFFFF : 0; }
  public int type() { int o = __offset(12); return o != 0 ? bb.getShort(o + bb_pos) & 0xFFFF : 0; }
  public long fee(int j) { int o = __offset(14); return o != 0 ? (long)bb.getInt(__vector(o) + j * 4) & 0xFFFFFFFFL : 0; }
  public int feeLength() { int o = __offset(14); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer feeAsByteBuffer() { return __vector_as_bytebuffer(14, 4); }
  public ByteBuffer feeInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 14, 4); }
  public long deadline(int j) { int o = __offset(16); return o != 0 ? (long)bb.getInt(__vector(o) + j * 4) & 0xFFFFFFFFL : 0; }
  public int deadlineLength() { int o = __offset(16); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer deadlineAsByteBuffer() { return __vector_as_bytebuffer(16, 4); }
  public ByteBuffer deadlineInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 16, 4); }
  public long namespaceId(int j) { int o = __offset(18); return o != 0 ? (long)bb.getInt(__vector(o) + j * 4) & 0xFFFFFFFFL : 0; }
  public int namespaceIdLength() { int o = __offset(18); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer namespaceIdAsByteBuffer() { return __vector_as_bytebuffer(18, 4); }
  public ByteBuffer namespaceIdInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 18, 4); }
  public long mosaicId(int j) { int o = __offset(20); return o != 0 ? (long)bb.getInt(__vector(o) + j * 4) & 0xFFFFFFFFL : 0; }
  public int mosaicIdLength() { int o = __offset(20); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer mosaicIdAsByteBuffer() { return __vector_as_bytebuffer(20, 4); }
  public ByteBuffer mosaicIdInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 20, 4); }
  public long aliasAction() { int o = __offset(22); return o != 0 ? (long)bb.getInt(o + bb_pos) & 0xFFFFFFFFL : 0L; }

  public static int createMosaicAliasDefinitionTransactionBuffer(FlatBufferBuilder builder,
      long size,
      int signatureOffset,
      int signerOffset,
      int version,
      int type,
      int feeOffset,
      int deadlineOffset,
      int namespaceIdOffset,
      int mosaicIdOffset,
      long aliasAction) {
    builder.startObject(10);
    MosaicAliasDefinitionTransactionBuffer.addAliasAction(builder, aliasAction);
    MosaicAliasDefinitionTransactionBuffer.addMosaicId(builder, mosaicIdOffset);
    MosaicAliasDefinitionTransactionBuffer.addNamespaceId(builder, namespaceIdOffset);
    MosaicAliasDefinitionTransactionBuffer.addDeadline(builder, deadlineOffset);
    MosaicAliasDefinitionTransactionBuffer.addFee(builder, feeOffset);
    MosaicAliasDefinitionTransactionBuffer.addSigner(builder, signerOffset);
    MosaicAliasDefinitionTransactionBuffer.addSignature(builder, signatureOffset);
    MosaicAliasDefinitionTransactionBuffer.addSize(builder, size);
    MosaicAliasDefinitionTransactionBuffer.addType(builder, type);
    MosaicAliasDefinitionTransactionBuffer.addVersion(builder, version);
    return MosaicAliasDefinitionTransactionBuffer.endMosaicAliasDefinitionTransactionBuffer(builder);
  }

  public static void startMosaicAliasDefinitionTransactionBuffer(FlatBufferBuilder builder) { builder.startObject(10); }
  public static void addSize(FlatBufferBuilder builder, long size) { builder.addInt(0, (int)size, (int)0L); }
  public static void addSignature(FlatBufferBuilder builder, int signatureOffset) { builder.addOffset(1, signatureOffset, 0); }
  public static int createSignatureVector(FlatBufferBuilder builder, byte[] data) { builder.startVector(1, data.length, 1); for (int i = data.length - 1; i >= 0; i--) builder.addByte(data[i]); return builder.endVector(); }
  public static void startSignatureVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static void addSigner(FlatBufferBuilder builder, int signerOffset) { builder.addOffset(2, signerOffset, 0); }
  public static int createSignerVector(FlatBufferBuilder builder, byte[] data) { builder.startVector(1, data.length, 1); for (int i = data.length - 1; i >= 0; i--) builder.addByte(data[i]); return builder.endVector(); }
  public static void startSignerVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static void addVersion(FlatBufferBuilder builder, int version) { builder.addShort(3, (short)version, (short)0); }
  public static void addType(FlatBufferBuilder builder, int type) { builder.addShort(4, (short)type, (short)0); }
  public static void addFee(FlatBufferBuilder builder, int feeOffset) { builder.addOffset(5, feeOffset, 0); }
  public static int createFeeVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startFeeVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addDeadline(FlatBufferBuilder builder, int deadlineOffset) { builder.addOffset(6, deadlineOffset, 0); }
  public static int createDeadlineVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startDeadlineVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addNamespaceId(FlatBufferBuilder builder, int namespaceIdOffset) { builder.addOffset(7, namespaceIdOffset, 0); }
  public static int createNamespaceIdVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startNamespaceIdVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addMosaicId(FlatBufferBuilder builder, int mosaicIdOffset) { builder.addOffset(8, mosaicIdOffset, 0); }
  public static int createMosaicIdVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startMosaicIdVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addAliasAction(FlatBufferBuilder builder, long aliasAction) { builder.addInt(9, (int)aliasAction, (int)0L); }
  public static int endMosaicAliasDefinitionTransactionBuffer(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishMosaicAliasDefinitionTransactionBufferBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedMosaicAliasDefinitionTransactionBufferBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }
}

