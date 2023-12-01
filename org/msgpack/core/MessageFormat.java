package org.msgpack.core;

import org.msgpack.core.MessagePack;
import org.msgpack.value.ValueType;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/MessageFormat.class */
public enum MessageFormat {
    POSFIXINT(ValueType.INTEGER),
    FIXMAP(ValueType.MAP),
    FIXARRAY(ValueType.ARRAY),
    FIXSTR(ValueType.STRING),
    NIL(ValueType.NIL),
    NEVER_USED(null),
    BOOLEAN(ValueType.BOOLEAN),
    BIN8(ValueType.BINARY),
    BIN16(ValueType.BINARY),
    BIN32(ValueType.BINARY),
    EXT8(ValueType.EXTENSION),
    EXT16(ValueType.EXTENSION),
    EXT32(ValueType.EXTENSION),
    FLOAT32(ValueType.FLOAT),
    FLOAT64(ValueType.FLOAT),
    UINT8(ValueType.INTEGER),
    UINT16(ValueType.INTEGER),
    UINT32(ValueType.INTEGER),
    UINT64(ValueType.INTEGER),
    INT8(ValueType.INTEGER),
    INT16(ValueType.INTEGER),
    INT32(ValueType.INTEGER),
    INT64(ValueType.INTEGER),
    FIXEXT1(ValueType.EXTENSION),
    FIXEXT2(ValueType.EXTENSION),
    FIXEXT4(ValueType.EXTENSION),
    FIXEXT8(ValueType.EXTENSION),
    FIXEXT16(ValueType.EXTENSION),
    STR8(ValueType.STRING),
    STR16(ValueType.STRING),
    STR32(ValueType.STRING),
    ARRAY16(ValueType.ARRAY),
    ARRAY32(ValueType.ARRAY),
    MAP16(ValueType.MAP),
    MAP32(ValueType.MAP),
    NEGFIXINT(ValueType.INTEGER);
    
    private static final MessageFormat[] formatTable = new MessageFormat[256];
    private final ValueType valueType;

    static {
        for (int i = 0; i <= 255; i++) {
            formatTable[i] = toMessageFormat((byte) i);
        }
    }

    MessageFormat(ValueType valueType) {
        this.valueType = valueType;
    }

    static MessageFormat toMessageFormat(byte b) {
        if (MessagePack.Code.isPosFixInt(b)) {
            return POSFIXINT;
        }
        if (MessagePack.Code.isNegFixInt(b)) {
            return NEGFIXINT;
        }
        if (MessagePack.Code.isFixStr(b)) {
            return FIXSTR;
        }
        if (MessagePack.Code.isFixedArray(b)) {
            return FIXARRAY;
        }
        if (MessagePack.Code.isFixedMap(b)) {
            return FIXMAP;
        }
        switch (b) {
            case -64:
                return NIL;
            case MessagePack.Code.NEVER_USED /* -63 */:
            default:
                return NEVER_USED;
            case MessagePack.Code.FALSE /* -62 */:
            case MessagePack.Code.TRUE /* -61 */:
                return BOOLEAN;
            case MessagePack.Code.BIN8 /* -60 */:
                return BIN8;
            case MessagePack.Code.BIN16 /* -59 */:
                return BIN16;
            case MessagePack.Code.BIN32 /* -58 */:
                return BIN32;
            case MessagePack.Code.EXT8 /* -57 */:
                return EXT8;
            case MessagePack.Code.EXT16 /* -56 */:
                return EXT16;
            case MessagePack.Code.EXT32 /* -55 */:
                return EXT32;
            case MessagePack.Code.FLOAT32 /* -54 */:
                return FLOAT32;
            case MessagePack.Code.FLOAT64 /* -53 */:
                return FLOAT64;
            case MessagePack.Code.UINT8 /* -52 */:
                return UINT8;
            case MessagePack.Code.UINT16 /* -51 */:
                return UINT16;
            case MessagePack.Code.UINT32 /* -50 */:
                return UINT32;
            case MessagePack.Code.UINT64 /* -49 */:
                return UINT64;
            case MessagePack.Code.INT8 /* -48 */:
                return INT8;
            case MessagePack.Code.INT16 /* -47 */:
                return INT16;
            case MessagePack.Code.INT32 /* -46 */:
                return INT32;
            case MessagePack.Code.INT64 /* -45 */:
                return INT64;
            case MessagePack.Code.FIXEXT1 /* -44 */:
                return FIXEXT1;
            case MessagePack.Code.FIXEXT2 /* -43 */:
                return FIXEXT2;
            case MessagePack.Code.FIXEXT4 /* -42 */:
                return FIXEXT4;
            case MessagePack.Code.FIXEXT8 /* -41 */:
                return FIXEXT8;
            case MessagePack.Code.FIXEXT16 /* -40 */:
                return FIXEXT16;
            case MessagePack.Code.STR8 /* -39 */:
                return STR8;
            case -38:
                return STR16;
            case MessagePack.Code.STR32 /* -37 */:
                return STR32;
            case MessagePack.Code.ARRAY16 /* -36 */:
                return ARRAY16;
            case MessagePack.Code.ARRAY32 /* -35 */:
                return ARRAY32;
            case MessagePack.Code.MAP16 /* -34 */:
                return MAP16;
            case MessagePack.Code.MAP32 /* -33 */:
                return MAP32;
        }
    }

    public static MessageFormat valueOf(byte b) {
        return formatTable[b & 255];
    }

    public ValueType getValueType() throws MessageFormatException {
        if (this != NEVER_USED) {
            return this.valueType;
        }
        throw new MessageFormatException("Cannot convert NEVER_USED to ValueType");
    }
}
