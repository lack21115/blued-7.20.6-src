package org.msgpack.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.HashMap;
import org.msgpack.core.MessagePack;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferInput;
import org.msgpack.value.ImmutableValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueFactory;
import org.msgpack.value.ValueType;
import org.msgpack.value.Variable;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/MessageUnpacker.class */
public class MessageUnpacker implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final MessageBuffer EMPTY_BUFFER = MessageBuffer.wrap(new byte[0]);
    private static final String EMPTY_STRING = "";
    private final CodingErrorAction actionOnMalformedString;
    private final CodingErrorAction actionOnUnmappableString;
    private final boolean allowReadingBinaryAsString;
    private final boolean allowReadingStringAsBinary;
    private CharBuffer decodeBuffer;
    private StringBuilder decodeStringBuffer;
    private CharsetDecoder decoder;

    /* renamed from: in  reason: collision with root package name */
    private MessageBufferInput f44098in;
    private int nextReadPosition;
    private int position;
    private final int stringDecoderBufferSize;
    private final int stringSizeLimit;
    private long totalReadBytes;
    private MessageBuffer buffer = EMPTY_BUFFER;
    private final MessageBuffer numberBuffer = MessageBuffer.allocate(8);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.msgpack.core.MessageUnpacker$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/MessageUnpacker$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$msgpack$core$MessageFormat;
        static final /* synthetic */ int[] $SwitchMap$org$msgpack$value$ValueType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x0231 -> B:242:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x0235 -> B:260:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x0239 -> B:254:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x023d -> B:272:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0241 -> B:266:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x0245 -> B:20:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0249 -> B:188:0x0084). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x024d -> B:206:0x008f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x0251 -> B:200:0x009a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x0255 -> B:214:0x00a5). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x0259 -> B:210:0x00b0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x025d -> B:224:0x00bc). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:0x0261 -> B:218:0x00c8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x0265 -> B:234:0x00d4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:128:0x0269 -> B:228:0x00e0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:130:0x026d -> B:246:0x00ec). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:132:0x0271 -> B:240:0x00f8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:134:0x0275 -> B:258:0x0104). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x0279 -> B:252:0x0110). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:138:0x027d -> B:270:0x011c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:140:0x0281 -> B:264:0x0128). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x0285 -> B:192:0x0134). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x0289 -> B:186:0x0140). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:146:0x028d -> B:204:0x014c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x0291 -> B:198:0x0158). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:150:0x0295 -> B:212:0x0164). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:152:0x0299 -> B:208:0x0170). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:154:0x029d -> B:222:0x017c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:156:0x02a1 -> B:216:0x0188). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:158:0x02a5 -> B:232:0x0194). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x02a9 -> B:226:0x01a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x02ad -> B:244:0x01ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x02b1 -> B:238:0x01b8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:166:0x02b5 -> B:256:0x01c4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:168:0x02b9 -> B:250:0x01d0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:170:0x02bd -> B:268:0x01dc). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:172:0x02c1 -> B:262:0x01e8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x02c5 -> B:190:0x01f4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:176:0x02c9 -> B:184:0x0200). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:178:0x02cd -> B:202:0x020c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:180:0x02d1 -> B:196:0x0218). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x0225 -> B:236:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x0229 -> B:230:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x022d -> B:248:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[ValueType.values().length];
            $SwitchMap$org$msgpack$value$ValueType = iArr;
            try {
                iArr[ValueType.NIL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.BINARY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.MAP.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$org$msgpack$value$ValueType[ValueType.EXTENSION.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            int[] iArr2 = new int[MessageFormat.values().length];
            $SwitchMap$org$msgpack$core$MessageFormat = iArr2;
            try {
                iArr2[MessageFormat.POSFIXINT.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.NEGFIXINT.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.NIL.ordinal()] = 4;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXMAP.ordinal()] = 5;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXSTR.ordinal()] = 7;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT8.ordinal()] = 8;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT8.ordinal()] = 9;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT16.ordinal()] = 10;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT16.ordinal()] = 11;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT32.ordinal()] = 12;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FLOAT32.ordinal()] = 14;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT64.ordinal()] = 15;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT64.ordinal()] = 16;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FLOAT64.ordinal()] = 17;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BIN8.ordinal()] = 18;
            } catch (NoSuchFieldError e27) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.STR8.ordinal()] = 19;
            } catch (NoSuchFieldError e28) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BIN16.ordinal()] = 20;
            } catch (NoSuchFieldError e29) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.STR16.ordinal()] = 21;
            } catch (NoSuchFieldError e30) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BIN32.ordinal()] = 22;
            } catch (NoSuchFieldError e31) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.STR32.ordinal()] = 23;
            } catch (NoSuchFieldError e32) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT1.ordinal()] = 24;
            } catch (NoSuchFieldError e33) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT2.ordinal()] = 25;
            } catch (NoSuchFieldError e34) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT4.ordinal()] = 26;
            } catch (NoSuchFieldError e35) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT8.ordinal()] = 27;
            } catch (NoSuchFieldError e36) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT16.ordinal()] = 28;
            } catch (NoSuchFieldError e37) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.EXT8.ordinal()] = 29;
            } catch (NoSuchFieldError e38) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.EXT16.ordinal()] = 30;
            } catch (NoSuchFieldError e39) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.EXT32.ordinal()] = 31;
            } catch (NoSuchFieldError e40) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.ARRAY16.ordinal()] = 32;
            } catch (NoSuchFieldError e41) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.ARRAY32.ordinal()] = 33;
            } catch (NoSuchFieldError e42) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.MAP16.ordinal()] = 34;
            } catch (NoSuchFieldError e43) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.MAP32.ordinal()] = 35;
            } catch (NoSuchFieldError e44) {
            }
            try {
                $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.NEVER_USED.ordinal()] = 36;
            } catch (NoSuchFieldError e45) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageUnpacker(MessageBufferInput messageBufferInput, MessagePack.UnpackerConfig unpackerConfig) {
        this.f44098in = (MessageBufferInput) Preconditions.checkNotNull(messageBufferInput, "MessageBufferInput is null");
        this.allowReadingStringAsBinary = unpackerConfig.getAllowReadingStringAsBinary();
        this.allowReadingBinaryAsString = unpackerConfig.getAllowReadingBinaryAsString();
        this.actionOnMalformedString = unpackerConfig.getActionOnMalformedString();
        this.actionOnUnmappableString = unpackerConfig.getActionOnUnmappableString();
        this.stringSizeLimit = unpackerConfig.getStringSizeLimit();
        this.stringDecoderBufferSize = unpackerConfig.getStringDecoderBufferSize();
    }

    private String decodeStringFastPath(int i) {
        if (this.actionOnMalformedString == CodingErrorAction.REPLACE && this.actionOnUnmappableString == CodingErrorAction.REPLACE && this.buffer.hasArray()) {
            String str = new String(this.buffer.array(), this.buffer.arrayOffset() + this.position, i, MessagePack.UTF8);
            this.position += i;
            return str;
        }
        try {
            CharBuffer decode = this.decoder.decode(this.buffer.sliceAsByteBuffer(this.position, i));
            this.position += i;
            return decode.toString();
        } catch (CharacterCodingException e) {
            throw new MessageStringCodingException(e);
        }
    }

    private boolean ensureBuffer() throws IOException {
        while (this.buffer.size() <= this.position) {
            MessageBuffer next = this.f44098in.next();
            if (next == null) {
                return false;
            }
            this.totalReadBytes += this.buffer.size();
            this.buffer = next;
            this.position = 0;
        }
        return true;
    }

    private MessageBuffer getNextBuffer() throws IOException {
        MessageBuffer next = this.f44098in.next();
        if (next != null) {
            this.totalReadBytes += this.buffer.size();
            return next;
        }
        throw new MessageInsufficientBufferException();
    }

    private void handleCoderError(CoderResult coderResult) throws CharacterCodingException {
        if ((coderResult.isMalformed() && this.actionOnMalformedString == CodingErrorAction.REPORT) || (coderResult.isUnmappable() && this.actionOnUnmappableString == CodingErrorAction.REPORT)) {
            coderResult.throwException();
        }
    }

    private void nextBuffer() throws IOException {
        this.buffer = getNextBuffer();
        this.position = 0;
    }

    private static MessageIntegerOverflowException overflowI16(short s) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(s));
    }

    private static MessageIntegerOverflowException overflowI32(int i) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(i));
    }

    private static MessageIntegerOverflowException overflowI64(long j) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(j));
    }

    private static MessageIntegerOverflowException overflowU16(short s) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(s & 65535));
    }

    private static MessageIntegerOverflowException overflowU32(int i) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((i & Integer.MAX_VALUE) + 2147483648L));
    }

    private static MessageSizeException overflowU32Size(int i) {
        return new MessageSizeException((i & Integer.MAX_VALUE) + 2147483648L);
    }

    private static MessageIntegerOverflowException overflowU64(long j) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(j + Long.MAX_VALUE + 1).setBit(63));
    }

    private static MessageIntegerOverflowException overflowU8(byte b) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(b & 255));
    }

    private MessageBuffer prepareNumberBuffer(int i) throws IOException {
        int i2;
        int i3;
        int size = this.buffer.size();
        int i4 = this.position;
        int i5 = size - i4;
        if (i5 >= i) {
            this.nextReadPosition = i4;
            this.position = i4 + i;
            return this.buffer;
        }
        if (i5 > 0) {
            this.numberBuffer.putMessageBuffer(0, this.buffer, i4, i5);
            i2 = i - i5;
            i3 = i5 + 0;
        } else {
            i2 = i;
            i3 = 0;
        }
        while (true) {
            int i6 = i3;
            nextBuffer();
            int size2 = this.buffer.size();
            if (size2 >= i2) {
                this.numberBuffer.putMessageBuffer(i6, this.buffer, 0, i2);
                this.position = i2;
                this.nextReadPosition = 0;
                return this.numberBuffer;
            }
            this.numberBuffer.putMessageBuffer(i6, this.buffer, 0, size2);
            i2 -= size2;
            i3 = i6 + size2;
        }
    }

    private byte readByte() throws IOException {
        int size = this.buffer.size();
        int i = this.position;
        if (size > i) {
            byte b = this.buffer.getByte(i);
            this.position++;
            return b;
        }
        nextBuffer();
        if (this.buffer.size() > 0) {
            byte b2 = this.buffer.getByte(0);
            this.position = 1;
            return b2;
        }
        return readByte();
    }

    private double readDouble() throws IOException {
        return prepareNumberBuffer(8).getDouble(this.nextReadPosition);
    }

    private float readFloat() throws IOException {
        return prepareNumberBuffer(4).getFloat(this.nextReadPosition);
    }

    private int readInt() throws IOException {
        return prepareNumberBuffer(4).getInt(this.nextReadPosition);
    }

    private long readLong() throws IOException {
        return prepareNumberBuffer(8).getLong(this.nextReadPosition);
    }

    private int readNextLength16() throws IOException {
        return readShort() & 65535;
    }

    private int readNextLength32() throws IOException {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw overflowU32Size(readInt);
    }

    private int readNextLength8() throws IOException {
        return readByte() & 255;
    }

    private short readShort() throws IOException {
        return prepareNumberBuffer(2).getShort(this.nextReadPosition);
    }

    private void resetDecoder() {
        CharsetDecoder charsetDecoder = this.decoder;
        if (charsetDecoder == null) {
            this.decodeBuffer = CharBuffer.allocate(this.stringDecoderBufferSize);
            this.decoder = MessagePack.UTF8.newDecoder().onMalformedInput(this.actionOnMalformedString).onUnmappableCharacter(this.actionOnUnmappableString);
        } else {
            charsetDecoder.reset();
        }
        StringBuilder sb = this.decodeStringBuffer;
        if (sb == null) {
            this.decodeStringBuffer = new StringBuilder();
        } else {
            sb.setLength(0);
        }
    }

    private void skipPayload(int i) throws IOException {
        while (true) {
            int size = this.buffer.size();
            int i2 = this.position;
            int i3 = size - i2;
            if (i3 >= i) {
                this.position = i2 + i;
                return;
            }
            this.position = i2 + i3;
            i -= i3;
            nextBuffer();
        }
    }

    private int tryReadBinaryHeader(byte b) throws IOException {
        switch (b) {
            case MessagePack.Code.BIN8 /* -60 */:
                return readNextLength8();
            case MessagePack.Code.BIN16 /* -59 */:
                return readNextLength16();
            case MessagePack.Code.BIN32 /* -58 */:
                return readNextLength32();
            default:
                return -1;
        }
    }

    private int tryReadStringHeader(byte b) throws IOException {
        switch (b) {
            case MessagePack.Code.STR8 /* -39 */:
                return readNextLength8();
            case -38:
                return readNextLength16();
            case MessagePack.Code.STR32 /* -37 */:
                return readNextLength32();
            default:
                return -1;
        }
    }

    private static MessagePackException unexpected(String str, byte b) {
        MessageFormat valueOf = MessageFormat.valueOf(b);
        if (valueOf == MessageFormat.NEVER_USED) {
            return new MessageNeverUsedFormatException(String.format("Expected %s, but encountered 0xC1 \"NEVER_USED\" byte", str));
        }
        String name = valueOf.getValueType().name();
        return new MessageTypeException(String.format("Expected %s, but got %s (%02x)", str, name.substring(0, 1) + name.substring(1).toLowerCase(), Byte.valueOf(b)));
    }

    private static int utf8MultibyteCharacterSize(byte b) {
        return Integer.numberOfLeadingZeros((b & 255) << 24);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.buffer = EMPTY_BUFFER;
        this.position = 0;
        this.f44098in.close();
    }

    public MessageFormat getNextFormat() throws IOException {
        if (ensureBuffer()) {
            return MessageFormat.valueOf(this.buffer.getByte(this.position));
        }
        throw new MessageInsufficientBufferException();
    }

    public long getTotalReadBytes() {
        return this.totalReadBytes + this.position;
    }

    public boolean hasNext() throws IOException {
        return ensureBuffer();
    }

    public void readPayload(ByteBuffer byteBuffer) throws IOException {
        while (true) {
            int remaining = byteBuffer.remaining();
            int size = this.buffer.size();
            int i = this.position;
            int i2 = size - i;
            if (i2 >= remaining) {
                this.buffer.getBytes(i, remaining, byteBuffer);
                this.position += remaining;
                return;
            }
            this.buffer.getBytes(i, i2, byteBuffer);
            this.position += i2;
            nextBuffer();
        }
    }

    public void readPayload(byte[] bArr) throws IOException {
        readPayload(bArr, 0, bArr.length);
    }

    public void readPayload(byte[] bArr, int i, int i2) throws IOException {
        readPayload(ByteBuffer.wrap(bArr, i, i2));
    }

    public byte[] readPayload(int i) throws IOException {
        byte[] bArr = new byte[i];
        readPayload(bArr);
        return bArr;
    }

    public MessageBuffer readPayloadAsReference(int i) throws IOException {
        int size = this.buffer.size();
        int i2 = this.position;
        if (size - i2 >= i) {
            MessageBuffer slice = this.buffer.slice(i2, i);
            this.position += i;
            return slice;
        }
        MessageBuffer allocate = MessageBuffer.allocate(i);
        readPayload(allocate.sliceAsByteBuffer());
        return allocate;
    }

    public MessageBufferInput reset(MessageBufferInput messageBufferInput) throws IOException {
        MessageBufferInput messageBufferInput2 = (MessageBufferInput) Preconditions.checkNotNull(messageBufferInput, "MessageBufferInput is null");
        MessageBufferInput messageBufferInput3 = this.f44098in;
        this.f44098in = messageBufferInput2;
        this.buffer = EMPTY_BUFFER;
        this.position = 0;
        this.totalReadBytes = 0L;
        return messageBufferInput3;
    }

    public void skipValue() throws IOException {
        skipValue(1);
    }

    public void skipValue(int i) throws IOException {
        int i2;
        int i3;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 <= 0) {
                return;
            }
            byte readByte = readByte();
            switch (AnonymousClass1.$SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.valueOf(readByte).ordinal()]) {
                case 5:
                    i2 = readByte & 15;
                    i3 = i2 * 2;
                    break;
                case 6:
                    i3 = readByte & 15;
                    break;
                case 7:
                    skipPayload(readByte & 31);
                    continue;
                    i4 = i5 - 1;
                case 8:
                case 9:
                    skipPayload(1);
                    continue;
                    i4 = i5 - 1;
                case 10:
                case 11:
                    skipPayload(2);
                    continue;
                    i4 = i5 - 1;
                case 12:
                case 13:
                case 14:
                    skipPayload(4);
                    continue;
                    i4 = i5 - 1;
                case 15:
                case 16:
                case 17:
                    skipPayload(8);
                    continue;
                    i4 = i5 - 1;
                case 18:
                case 19:
                    skipPayload(readNextLength8());
                    continue;
                    i4 = i5 - 1;
                case 20:
                case 21:
                    skipPayload(readNextLength16());
                    continue;
                    i4 = i5 - 1;
                case 22:
                case 23:
                    skipPayload(readNextLength32());
                    continue;
                    i4 = i5 - 1;
                case 24:
                    skipPayload(2);
                    continue;
                    i4 = i5 - 1;
                case 25:
                    skipPayload(3);
                    continue;
                    i4 = i5 - 1;
                case 26:
                    skipPayload(5);
                    continue;
                    i4 = i5 - 1;
                case 27:
                    skipPayload(9);
                    continue;
                    i4 = i5 - 1;
                case 28:
                    skipPayload(17);
                    continue;
                    i4 = i5 - 1;
                case 29:
                    skipPayload(readNextLength8() + 1);
                    continue;
                    i4 = i5 - 1;
                case 30:
                    skipPayload(readNextLength16() + 1);
                    continue;
                    i4 = i5 - 1;
                case 31:
                    skipPayload(readNextLength32() + 1);
                    continue;
                    i4 = i5 - 1;
                case 32:
                    i3 = readNextLength16();
                    break;
                case 33:
                    i3 = readNextLength32();
                    break;
                case 34:
                    i2 = readNextLength16();
                    i3 = i2 * 2;
                    break;
                case 35:
                    i2 = readNextLength32();
                    i3 = i2 * 2;
                    break;
                case 36:
                    throw new MessageNeverUsedFormatException("Encountered 0xC1 \"NEVER_USED\" byte");
                default:
                    i4 = i5 - 1;
            }
            i5 += i3;
            i4 = i5 - 1;
        }
    }

    public int unpackArrayHeader() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixedArray(readByte)) {
            return readByte & 15;
        }
        if (readByte != -36) {
            if (readByte == -35) {
                return readNextLength32();
            }
            throw unexpected("Array", readByte);
        }
        return readNextLength16();
    }

    public BigInteger unpackBigInteger() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixInt(readByte)) {
            return BigInteger.valueOf(readByte);
        }
        switch (readByte) {
            case MessagePack.Code.UINT8 /* -52 */:
                return BigInteger.valueOf(readByte() & 255);
            case MessagePack.Code.UINT16 /* -51 */:
                return BigInteger.valueOf(readShort() & 65535);
            case MessagePack.Code.UINT32 /* -50 */:
                int readInt = readInt();
                return readInt < 0 ? BigInteger.valueOf((readInt & Integer.MAX_VALUE) + 2147483648L) : BigInteger.valueOf(readInt);
            case MessagePack.Code.UINT64 /* -49 */:
                long readLong = readLong();
                return readLong < 0 ? BigInteger.valueOf(readLong + Long.MAX_VALUE + 1).setBit(63) : BigInteger.valueOf(readLong);
            case MessagePack.Code.INT8 /* -48 */:
                return BigInteger.valueOf(readByte());
            case MessagePack.Code.INT16 /* -47 */:
                return BigInteger.valueOf(readShort());
            case MessagePack.Code.INT32 /* -46 */:
                return BigInteger.valueOf(readInt());
            case MessagePack.Code.INT64 /* -45 */:
                return BigInteger.valueOf(readLong());
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public int unpackBinaryHeader() throws IOException {
        int tryReadStringHeader;
        byte readByte = readByte();
        if (MessagePack.Code.isFixedRaw(readByte)) {
            return readByte & 31;
        }
        int tryReadBinaryHeader = tryReadBinaryHeader(readByte);
        if (tryReadBinaryHeader >= 0) {
            return tryReadBinaryHeader;
        }
        if (!this.allowReadingStringAsBinary || (tryReadStringHeader = tryReadStringHeader(readByte)) < 0) {
            throw unexpected("Binary", readByte);
        }
        return tryReadStringHeader;
    }

    public boolean unpackBoolean() throws IOException {
        byte readByte = readByte();
        if (readByte == -62) {
            return false;
        }
        if (readByte == -61) {
            return true;
        }
        throw unexpected(TypedValues.Custom.S_BOOLEAN, readByte);
    }

    public byte unpackByte() throws IOException {
        long readLong;
        byte readByte = readByte();
        if (MessagePack.Code.isFixInt(readByte)) {
            return readByte;
        }
        switch (readByte) {
            case MessagePack.Code.UINT8 /* -52 */:
                byte readByte2 = readByte();
                if (readByte2 >= 0) {
                    return readByte2;
                }
                throw overflowU8(readByte2);
            case MessagePack.Code.UINT16 /* -51 */:
                short readShort = readShort();
                if (readShort < 0 || readShort > 127) {
                    throw overflowU16(readShort);
                }
                return (byte) readShort;
            case MessagePack.Code.UINT32 /* -50 */:
                int readInt = readInt();
                if (readInt < 0 || readInt > 127) {
                    throw overflowU32(readInt);
                }
                return (byte) readInt;
            case MessagePack.Code.UINT64 /* -49 */:
                readLong = readLong();
                if (readLong < 0 || readLong > 127) {
                    throw overflowU64(readLong);
                }
                break;
            case MessagePack.Code.INT8 /* -48 */:
                return readByte();
            case MessagePack.Code.INT16 /* -47 */:
                short readShort2 = readShort();
                if (readShort2 < -128 || readShort2 > 127) {
                    throw overflowI16(readShort2);
                }
                return (byte) readShort2;
            case MessagePack.Code.INT32 /* -46 */:
                int readInt2 = readInt();
                if (readInt2 < -128 || readInt2 > 127) {
                    throw overflowI32(readInt2);
                }
                return (byte) readInt2;
            case MessagePack.Code.INT64 /* -45 */:
                readLong = readLong();
                if (readLong < -128 || readLong > 127) {
                    throw overflowI64(readLong);
                }
                break;
            default:
                throw unexpected("Integer", readByte);
        }
        return (byte) readLong;
    }

    public double unpackDouble() throws IOException {
        byte readByte = readByte();
        if (readByte != -54) {
            if (readByte == -53) {
                return readDouble();
            }
            throw unexpected("Float", readByte);
        }
        return readFloat();
    }

    public ExtensionTypeHeader unpackExtensionTypeHeader() throws IOException {
        byte readByte = readByte();
        switch (readByte) {
            case MessagePack.Code.EXT8 /* -57 */:
                MessageBuffer prepareNumberBuffer = prepareNumberBuffer(2);
                return new ExtensionTypeHeader(prepareNumberBuffer.getByte(this.nextReadPosition + 1), prepareNumberBuffer.getByte(this.nextReadPosition) & 255);
            case MessagePack.Code.EXT16 /* -56 */:
                MessageBuffer prepareNumberBuffer2 = prepareNumberBuffer(3);
                return new ExtensionTypeHeader(prepareNumberBuffer2.getByte(this.nextReadPosition + 2), prepareNumberBuffer2.getShort(this.nextReadPosition) & 65535);
            case MessagePack.Code.EXT32 /* -55 */:
                MessageBuffer prepareNumberBuffer3 = prepareNumberBuffer(5);
                int i = prepareNumberBuffer3.getInt(this.nextReadPosition);
                if (i >= 0) {
                    return new ExtensionTypeHeader(prepareNumberBuffer3.getByte(this.nextReadPosition + 4), i);
                }
                throw overflowU32Size(i);
            default:
                switch (readByte) {
                    case MessagePack.Code.FIXEXT1 /* -44 */:
                        return new ExtensionTypeHeader(readByte(), 1);
                    case MessagePack.Code.FIXEXT2 /* -43 */:
                        return new ExtensionTypeHeader(readByte(), 2);
                    case MessagePack.Code.FIXEXT4 /* -42 */:
                        return new ExtensionTypeHeader(readByte(), 4);
                    case MessagePack.Code.FIXEXT8 /* -41 */:
                        return new ExtensionTypeHeader(readByte(), 8);
                    case MessagePack.Code.FIXEXT16 /* -40 */:
                        return new ExtensionTypeHeader(readByte(), 16);
                    default:
                        throw unexpected("Ext", readByte);
                }
        }
    }

    public float unpackFloat() throws IOException {
        byte readByte = readByte();
        if (readByte != -54) {
            if (readByte == -53) {
                return (float) readDouble();
            }
            throw unexpected("Float", readByte);
        }
        return readFloat();
    }

    public int unpackInt() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixInt(readByte)) {
            return readByte;
        }
        switch (readByte) {
            case MessagePack.Code.UINT8 /* -52 */:
                return readByte() & 255;
            case MessagePack.Code.UINT16 /* -51 */:
                return readShort() & 65535;
            case MessagePack.Code.UINT32 /* -50 */:
                int readInt = readInt();
                if (readInt >= 0) {
                    return readInt;
                }
                throw overflowU32(readInt);
            case MessagePack.Code.UINT64 /* -49 */:
                long readLong = readLong();
                if (readLong < 0 || readLong > 2147483647L) {
                    throw overflowU64(readLong);
                }
                return (int) readLong;
            case MessagePack.Code.INT8 /* -48 */:
                return readByte();
            case MessagePack.Code.INT16 /* -47 */:
                return readShort();
            case MessagePack.Code.INT32 /* -46 */:
                return readInt();
            case MessagePack.Code.INT64 /* -45 */:
                long readLong2 = readLong();
                if (readLong2 < -2147483648L || readLong2 > 2147483647L) {
                    throw overflowI64(readLong2);
                }
                return (int) readLong2;
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public long unpackLong() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixInt(readByte)) {
            return readByte;
        }
        switch (readByte) {
            case MessagePack.Code.UINT8 /* -52 */:
                return readByte() & 255;
            case MessagePack.Code.UINT16 /* -51 */:
                return readShort() & 65535;
            case MessagePack.Code.UINT32 /* -50 */:
                int readInt = readInt();
                return readInt < 0 ? (readInt & Integer.MAX_VALUE) + 2147483648L : readInt;
            case MessagePack.Code.UINT64 /* -49 */:
                long readLong = readLong();
                if (readLong >= 0) {
                    return readLong;
                }
                throw overflowU64(readLong);
            case MessagePack.Code.INT8 /* -48 */:
                return readByte();
            case MessagePack.Code.INT16 /* -47 */:
                return readShort();
            case MessagePack.Code.INT32 /* -46 */:
                return readInt();
            case MessagePack.Code.INT64 /* -45 */:
                return readLong();
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public int unpackMapHeader() throws IOException {
        byte readByte = readByte();
        if (MessagePack.Code.isFixedMap(readByte)) {
            return readByte & 15;
        }
        if (readByte != -34) {
            if (readByte == -33) {
                return readNextLength32();
            }
            throw unexpected("Map", readByte);
        }
        return readNextLength16();
    }

    public void unpackNil() throws IOException {
        byte readByte = readByte();
        if (readByte != -64) {
            throw unexpected("Nil", readByte);
        }
    }

    public int unpackRawStringHeader() throws IOException {
        int tryReadBinaryHeader;
        byte readByte = readByte();
        if (MessagePack.Code.isFixedRaw(readByte)) {
            return readByte & 31;
        }
        int tryReadStringHeader = tryReadStringHeader(readByte);
        if (tryReadStringHeader >= 0) {
            return tryReadStringHeader;
        }
        if (!this.allowReadingBinaryAsString || (tryReadBinaryHeader = tryReadBinaryHeader(readByte)) < 0) {
            throw unexpected("String", readByte);
        }
        return tryReadBinaryHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v45, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public short unpackShort() throws IOException {
        byte b;
        long readLong;
        byte readByte = readByte();
        if (MessagePack.Code.isFixInt(readByte)) {
            return readByte;
        }
        switch (readByte) {
            case MessagePack.Code.UINT8 /* -52 */:
                b = (readByte() & 255) == true ? 1 : 0;
                break;
            case MessagePack.Code.UINT16 /* -51 */:
                short readShort = readShort();
                if (readShort >= 0) {
                    return readShort;
                }
                throw overflowU16(readShort);
            case MessagePack.Code.UINT32 /* -50 */:
                int readInt = readInt();
                if (readInt < 0 || readInt > 32767) {
                    throw overflowU32(readInt);
                }
                return (short) readInt;
            case MessagePack.Code.UINT64 /* -49 */:
                readLong = readLong();
                if (readLong < 0 || readLong > 32767) {
                    throw overflowU64(readLong);
                }
                b = (int) readLong;
                break;
            case MessagePack.Code.INT8 /* -48 */:
                b = readByte();
                break;
            case MessagePack.Code.INT16 /* -47 */:
                return readShort();
            case MessagePack.Code.INT32 /* -46 */:
                int readInt2 = readInt();
                if (readInt2 < -32768 || readInt2 > 32767) {
                    throw overflowI32(readInt2);
                }
                return (short) readInt2;
            case MessagePack.Code.INT64 /* -45 */:
                readLong = readLong();
                if (readLong < -32768 || readLong > 32767) {
                    throw overflowI64(readLong);
                }
                b = (int) readLong;
                break;
            default:
                throw unexpected("Integer", readByte);
        }
        return b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x018a, code lost:
        r0.throwException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0199, code lost:
        throw new org.msgpack.core.MessageFormatException("Unexpected UTF-8 multibyte sequence");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01d3, code lost:
        return r8.decodeStringBuffer.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String unpackString() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.msgpack.core.MessageUnpacker.unpackString():java.lang.String");
    }

    public ImmutableValue unpackValue() throws IOException {
        MessageFormat nextFormat = getNextFormat();
        int i = 0;
        switch (AnonymousClass1.$SwitchMap$org$msgpack$value$ValueType[nextFormat.getValueType().ordinal()]) {
            case 1:
                readByte();
                return ValueFactory.newNil();
            case 2:
                return ValueFactory.newBoolean(unpackBoolean());
            case 3:
                return AnonymousClass1.$SwitchMap$org$msgpack$core$MessageFormat[nextFormat.ordinal()] != 16 ? ValueFactory.newInteger(unpackLong()) : ValueFactory.newInteger(unpackBigInteger());
            case 4:
                return ValueFactory.newFloat(unpackDouble());
            case 5:
                return ValueFactory.newString(readPayload(unpackRawStringHeader()), true);
            case 6:
                return ValueFactory.newBinary(readPayload(unpackBinaryHeader()), true);
            case 7:
                int unpackArrayHeader = unpackArrayHeader();
                Value[] valueArr = new Value[unpackArrayHeader];
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= unpackArrayHeader) {
                        return ValueFactory.newArray(valueArr, true);
                    }
                    valueArr[i3] = unpackValue();
                    i2 = i3 + 1;
                }
            case 8:
                int unpackMapHeader = unpackMapHeader() * 2;
                Value[] valueArr2 = new Value[unpackMapHeader];
                while (i < unpackMapHeader) {
                    valueArr2[i] = unpackValue();
                    int i4 = i + 1;
                    valueArr2[i4] = unpackValue();
                    i = i4 + 1;
                }
                return ValueFactory.newMap(valueArr2, true);
            case 9:
                ExtensionTypeHeader unpackExtensionTypeHeader = unpackExtensionTypeHeader();
                return ValueFactory.newExtension(unpackExtensionTypeHeader.getType(), readPayload(unpackExtensionTypeHeader.getLength()));
            default:
                throw new MessageNeverUsedFormatException("Unknown value type");
        }
    }

    public Variable unpackValue(Variable variable) throws IOException {
        MessageFormat nextFormat = getNextFormat();
        switch (AnonymousClass1.$SwitchMap$org$msgpack$value$ValueType[nextFormat.getValueType().ordinal()]) {
            case 1:
                readByte();
                variable.setNilValue();
                return variable;
            case 2:
                variable.setBooleanValue(unpackBoolean());
                return variable;
            case 3:
                if (AnonymousClass1.$SwitchMap$org$msgpack$core$MessageFormat[nextFormat.ordinal()] != 16) {
                    variable.setIntegerValue(unpackLong());
                    return variable;
                }
                variable.setIntegerValue(unpackBigInteger());
                return variable;
            case 4:
                variable.setFloatValue(unpackDouble());
                return variable;
            case 5:
                variable.setStringValue(readPayload(unpackRawStringHeader()));
                return variable;
            case 6:
                variable.setBinaryValue(readPayload(unpackBinaryHeader()));
                return variable;
            case 7:
                int unpackArrayHeader = unpackArrayHeader();
                ArrayList arrayList = new ArrayList(unpackArrayHeader);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= unpackArrayHeader) {
                        variable.setArrayValue(arrayList);
                        return variable;
                    }
                    arrayList.add(unpackValue());
                    i = i2 + 1;
                }
            case 8:
                int unpackMapHeader = unpackMapHeader();
                HashMap hashMap = new HashMap();
                for (int i3 = 0; i3 < unpackMapHeader; i3++) {
                    hashMap.put(unpackValue(), unpackValue());
                }
                variable.setMapValue(hashMap);
                return variable;
            case 9:
                ExtensionTypeHeader unpackExtensionTypeHeader = unpackExtensionTypeHeader();
                variable.setExtensionValue(unpackExtensionTypeHeader.getType(), readPayload(unpackExtensionTypeHeader.getLength()));
                return variable;
            default:
                throw new MessageFormatException("Unknown value type");
        }
    }
}
