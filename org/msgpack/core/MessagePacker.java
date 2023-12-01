package org.msgpack.core;

import com.android.org.conscrypt.NativeCrypto;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.msgpack.core.MessagePack;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;
import org.msgpack.value.Value;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/MessagePacker.class */
public class MessagePacker implements Closeable, Flushable {
    private static final boolean CORRUPTED_CHARSET_ENCODER;
    private static final int UTF_8_MAX_CHAR_SIZE = 6;
    private MessageBuffer buffer;
    private final int bufferFlushThreshold;
    private CharsetEncoder encoder;
    protected MessageBufferOutput out;
    private final int smallStringOptimizationThreshold;
    private final boolean str8FormatSupport;
    private int position = 0;
    private long totalFlushBytes = 0;

    static {
        boolean z;
        try {
            Class<?> cls = Class.forName("android.os.Build$VERSION");
            int i = cls.getField("SDK_INT").getInt(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
            z = false;
            if (i >= 14) {
                z = false;
                if (i < 21) {
                    z = true;
                }
            }
        } catch (ClassNotFoundException e) {
            z = false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            z = false;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            z = false;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            z = false;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            z = false;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            z = false;
        }
        CORRUPTED_CHARSET_ENCODER = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MessagePacker(MessageBufferOutput messageBufferOutput, MessagePack.PackerConfig packerConfig) {
        this.out = (MessageBufferOutput) Preconditions.checkNotNull(messageBufferOutput, "MessageBufferOutput is null");
        this.smallStringOptimizationThreshold = packerConfig.getSmallStringOptimizationThreshold();
        this.bufferFlushThreshold = packerConfig.getBufferFlushThreshold();
        this.str8FormatSupport = packerConfig.isStr8FormatSupport();
    }

    private int encodeStringToBufferAt(int i, String str) {
        prepareEncoder();
        MessageBuffer messageBuffer = this.buffer;
        ByteBuffer sliceAsByteBuffer = messageBuffer.sliceAsByteBuffer(i, messageBuffer.size() - i);
        int position = sliceAsByteBuffer.position();
        CoderResult encode = this.encoder.encode(CharBuffer.wrap(str), sliceAsByteBuffer, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e) {
                throw new MessageStringCodingException(e);
            }
        }
        if (encode.isUnderflow() && !encode.isOverflow() && this.encoder.flush(sliceAsByteBuffer).isUnderflow()) {
            return sliceAsByteBuffer.position() - position;
        }
        return -1;
    }

    private void ensureCapacity(int i) throws IOException {
        MessageBuffer messageBuffer = this.buffer;
        if (messageBuffer == null) {
            this.buffer = this.out.next(i);
        } else if (this.position + i >= messageBuffer.size()) {
            flushBuffer();
            this.buffer = this.out.next(i);
        }
    }

    private void flushBuffer() throws IOException {
        this.out.writeBuffer(this.position);
        this.buffer = null;
        this.totalFlushBytes += this.position;
        this.position = 0;
    }

    private void packStringWithGetBytes(String str) throws IOException {
        byte[] bytes = str.getBytes(MessagePack.UTF8);
        packRawStringHeader(bytes.length);
        addPayload(bytes);
    }

    private void prepareEncoder() {
        if (this.encoder == null) {
            this.encoder = MessagePack.UTF8.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        }
        this.encoder.reset();
    }

    private void writeByte(byte b) throws IOException {
        ensureCapacity(1);
        MessageBuffer messageBuffer = this.buffer;
        int i = this.position;
        this.position = i + 1;
        messageBuffer.putByte(i, b);
    }

    private void writeByteAndByte(byte b, byte b2) throws IOException {
        ensureCapacity(2);
        MessageBuffer messageBuffer = this.buffer;
        int i = this.position;
        this.position = i + 1;
        messageBuffer.putByte(i, b);
        MessageBuffer messageBuffer2 = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        messageBuffer2.putByte(i2, b2);
    }

    private void writeByteAndDouble(byte b, double d) throws IOException {
        ensureCapacity(9);
        MessageBuffer messageBuffer = this.buffer;
        int i = this.position;
        this.position = i + 1;
        messageBuffer.putByte(i, b);
        this.buffer.putDouble(this.position, d);
        this.position += 8;
    }

    private void writeByteAndFloat(byte b, float f) throws IOException {
        ensureCapacity(5);
        MessageBuffer messageBuffer = this.buffer;
        int i = this.position;
        this.position = i + 1;
        messageBuffer.putByte(i, b);
        this.buffer.putFloat(this.position, f);
        this.position += 4;
    }

    private void writeByteAndInt(byte b, int i) throws IOException {
        ensureCapacity(5);
        MessageBuffer messageBuffer = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        messageBuffer.putByte(i2, b);
        this.buffer.putInt(this.position, i);
        this.position += 4;
    }

    private void writeByteAndLong(byte b, long j) throws IOException {
        ensureCapacity(9);
        MessageBuffer messageBuffer = this.buffer;
        int i = this.position;
        this.position = i + 1;
        messageBuffer.putByte(i, b);
        this.buffer.putLong(this.position, j);
        this.position += 8;
    }

    private void writeByteAndShort(byte b, short s) throws IOException {
        ensureCapacity(3);
        MessageBuffer messageBuffer = this.buffer;
        int i = this.position;
        this.position = i + 1;
        messageBuffer.putByte(i, b);
        this.buffer.putShort(this.position, s);
        this.position += 2;
    }

    private void writeInt(int i) throws IOException {
        ensureCapacity(4);
        this.buffer.putInt(this.position, i);
        this.position += 4;
    }

    private void writeLong(long j) throws IOException {
        ensureCapacity(8);
        this.buffer.putLong(this.position, j);
        this.position += 8;
    }

    private void writeShort(short s) throws IOException {
        ensureCapacity(2);
        this.buffer.putShort(this.position, s);
        this.position += 2;
    }

    public MessagePacker addPayload(byte[] bArr) throws IOException {
        return addPayload(bArr, 0, bArr.length);
    }

    public MessagePacker addPayload(byte[] bArr, int i, int i2) throws IOException {
        MessageBuffer messageBuffer = this.buffer;
        if (messageBuffer != null) {
            int size = messageBuffer.size();
            int i3 = this.position;
            if (size - i3 >= i2 && i2 <= this.bufferFlushThreshold) {
                this.buffer.putBytes(i3, bArr, i, i2);
                this.position += i2;
                return this;
            }
        }
        flush();
        this.out.add(bArr, i, i2);
        this.totalFlushBytes += i2;
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
        } finally {
            this.out.close();
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.position > 0) {
            flushBuffer();
        }
        this.out.flush();
    }

    public long getTotalWrittenBytes() {
        return this.totalFlushBytes + this.position;
    }

    public MessagePacker packArrayHeader(int i) throws IOException {
        if (i >= 0) {
            if (i < 16) {
                writeByte((byte) (i | MessagePack.Code.FIXARRAY_PREFIX));
                return this;
            } else if (i < 65536) {
                writeByteAndShort((byte) -36, (short) i);
                return this;
            } else {
                writeByteAndInt((byte) -35, i);
                return this;
            }
        }
        throw new IllegalArgumentException("array size must be >= 0");
    }

    public MessagePacker packBigInteger(BigInteger bigInteger) throws IOException {
        if (bigInteger.bitLength() <= 63) {
            packLong(bigInteger.longValue());
            return this;
        } else if (bigInteger.bitLength() == 64 && bigInteger.signum() == 1) {
            writeByteAndLong((byte) -49, bigInteger.longValue());
            return this;
        } else {
            throw new IllegalArgumentException("MessagePack cannot serialize BigInteger larger than 2^64-1");
        }
    }

    public MessagePacker packBinaryHeader(int i) throws IOException {
        if (i < 256) {
            writeByteAndByte((byte) -60, (byte) i);
            return this;
        } else if (i < 65536) {
            writeByteAndShort((byte) -59, (short) i);
            return this;
        } else {
            writeByteAndInt((byte) -58, i);
            return this;
        }
    }

    public MessagePacker packBoolean(boolean z) throws IOException {
        writeByte(z ? (byte) -61 : (byte) -62);
        return this;
    }

    public MessagePacker packByte(byte b) throws IOException {
        if (b < -32) {
            writeByteAndByte((byte) -48, b);
            return this;
        }
        writeByte(b);
        return this;
    }

    public MessagePacker packDouble(double d) throws IOException {
        writeByteAndDouble((byte) -53, d);
        return this;
    }

    public MessagePacker packExtensionTypeHeader(byte b, int i) throws IOException {
        if (i >= 256) {
            if (i < 65536) {
                writeByteAndShort((byte) -56, (short) i);
                writeByte(b);
                return this;
            }
            writeByteAndInt((byte) -55, i);
            writeByte(b);
            return this;
        } else if (i <= 0 || ((i - 1) & i) != 0) {
            writeByteAndByte((byte) -57, (byte) i);
            writeByte(b);
            return this;
        } else if (i == 1) {
            writeByteAndByte((byte) -44, b);
            return this;
        } else if (i == 2) {
            writeByteAndByte((byte) -43, b);
            return this;
        } else if (i == 4) {
            writeByteAndByte((byte) -42, b);
            return this;
        } else if (i == 8) {
            writeByteAndByte((byte) -41, b);
            return this;
        } else if (i == 16) {
            writeByteAndByte((byte) -40, b);
            return this;
        } else {
            writeByteAndByte((byte) -57, (byte) i);
            writeByte(b);
            return this;
        }
    }

    public MessagePacker packFloat(float f) throws IOException {
        writeByteAndFloat((byte) -54, f);
        return this;
    }

    public MessagePacker packInt(int i) throws IOException {
        if (i < -32) {
            if (i < -32768) {
                writeByteAndInt((byte) -46, i);
                return this;
            } else if (i < -128) {
                writeByteAndShort((byte) -47, (short) i);
                return this;
            } else {
                writeByteAndByte((byte) -48, (byte) i);
                return this;
            }
        } else if (i < 128) {
            writeByte((byte) i);
            return this;
        } else if (i < 256) {
            writeByteAndByte((byte) -52, (byte) i);
            return this;
        } else if (i < 65536) {
            writeByteAndShort((byte) -51, (short) i);
            return this;
        } else {
            writeByteAndInt((byte) -50, i);
            return this;
        }
    }

    public MessagePacker packLong(long j) throws IOException {
        if (j < -32) {
            if (j < -32768) {
                if (j < -2147483648L) {
                    writeByteAndLong((byte) -45, j);
                    return this;
                }
                writeByteAndInt((byte) -46, (int) j);
                return this;
            } else if (j < -128) {
                writeByteAndShort((byte) -47, (short) j);
                return this;
            } else {
                writeByteAndByte((byte) -48, (byte) j);
                return this;
            }
        } else if (j < 128) {
            writeByte((byte) j);
            return this;
        } else if (j < NativeCrypto.SSL_OP_NO_SESSION_RESUMPTION_ON_RENEGOTIATION) {
            if (j < 256) {
                writeByteAndByte((byte) -52, (byte) j);
                return this;
            }
            writeByteAndShort((byte) -51, (short) j);
            return this;
        } else if (j < 4294967296L) {
            writeByteAndInt((byte) -50, (int) j);
            return this;
        } else {
            writeByteAndLong((byte) -49, j);
            return this;
        }
    }

    public MessagePacker packMapHeader(int i) throws IOException {
        if (i >= 0) {
            if (i < 16) {
                writeByte((byte) (i | (-128)));
                return this;
            } else if (i < 65536) {
                writeByteAndShort((byte) -34, (short) i);
                return this;
            } else {
                writeByteAndInt((byte) -33, i);
                return this;
            }
        }
        throw new IllegalArgumentException("map size must be >= 0");
    }

    public MessagePacker packNil() throws IOException {
        writeByte((byte) -64);
        return this;
    }

    public MessagePacker packRawStringHeader(int i) throws IOException {
        if (i < 32) {
            writeByte((byte) (i | (-96)));
            return this;
        } else if (this.str8FormatSupport && i < 256) {
            writeByteAndByte((byte) -39, (byte) i);
            return this;
        } else if (i < 65536) {
            writeByteAndShort((byte) -38, (short) i);
            return this;
        } else {
            writeByteAndInt((byte) -37, i);
            return this;
        }
    }

    public MessagePacker packShort(short s) throws IOException {
        if (s < -32) {
            if (s < -128) {
                writeByteAndShort((byte) -47, s);
                return this;
            }
            writeByteAndByte((byte) -48, (byte) s);
            return this;
        } else if (s < 128) {
            writeByte((byte) s);
            return this;
        } else if (s < 256) {
            writeByteAndByte((byte) -52, (byte) s);
            return this;
        } else {
            writeByteAndShort((byte) -51, s);
            return this;
        }
    }

    public MessagePacker packString(String str) throws IOException {
        if (str.length() <= 0) {
            packRawStringHeader(0);
            return this;
        } else if (CORRUPTED_CHARSET_ENCODER || str.length() < this.smallStringOptimizationThreshold) {
            packStringWithGetBytes(str);
            return this;
        } else {
            if (str.length() < 256) {
                ensureCapacity((str.length() * 6) + 2 + 1);
                int encodeStringToBufferAt = encodeStringToBufferAt(this.position + 2, str);
                if (encodeStringToBufferAt >= 0) {
                    if (this.str8FormatSupport && encodeStringToBufferAt < 256) {
                        MessageBuffer messageBuffer = this.buffer;
                        int i = this.position;
                        this.position = i + 1;
                        messageBuffer.putByte(i, (byte) -39);
                        MessageBuffer messageBuffer2 = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        messageBuffer2.putByte(i2, (byte) encodeStringToBufferAt);
                        this.position += encodeStringToBufferAt;
                        return this;
                    } else if (encodeStringToBufferAt < 65536) {
                        MessageBuffer messageBuffer3 = this.buffer;
                        int i3 = this.position;
                        messageBuffer3.putMessageBuffer(i3 + 3, messageBuffer3, i3 + 2, encodeStringToBufferAt);
                        MessageBuffer messageBuffer4 = this.buffer;
                        int i4 = this.position;
                        this.position = i4 + 1;
                        messageBuffer4.putByte(i4, (byte) -38);
                        this.buffer.putShort(this.position, (short) encodeStringToBufferAt);
                        int i5 = this.position + 2;
                        this.position = i5;
                        this.position = i5 + encodeStringToBufferAt;
                        return this;
                    } else {
                        throw new IllegalArgumentException("Unexpected UTF-8 encoder state");
                    }
                }
            } else if (str.length() < 65536) {
                ensureCapacity((str.length() * 6) + 3 + 2);
                int encodeStringToBufferAt2 = encodeStringToBufferAt(this.position + 3, str);
                if (encodeStringToBufferAt2 >= 0) {
                    if (encodeStringToBufferAt2 < 65536) {
                        MessageBuffer messageBuffer5 = this.buffer;
                        int i6 = this.position;
                        this.position = i6 + 1;
                        messageBuffer5.putByte(i6, (byte) -38);
                        this.buffer.putShort(this.position, (short) encodeStringToBufferAt2);
                        int i7 = this.position + 2;
                        this.position = i7;
                        this.position = i7 + encodeStringToBufferAt2;
                        return this;
                    } else if (encodeStringToBufferAt2 < 4294967296L) {
                        MessageBuffer messageBuffer6 = this.buffer;
                        int i8 = this.position;
                        messageBuffer6.putMessageBuffer(i8 + 5, messageBuffer6, i8 + 3, encodeStringToBufferAt2);
                        MessageBuffer messageBuffer7 = this.buffer;
                        int i9 = this.position;
                        this.position = i9 + 1;
                        messageBuffer7.putByte(i9, (byte) -37);
                        this.buffer.putInt(this.position, encodeStringToBufferAt2);
                        int i10 = this.position + 4;
                        this.position = i10;
                        this.position = i10 + encodeStringToBufferAt2;
                        return this;
                    } else {
                        throw new IllegalArgumentException("Unexpected UTF-8 encoder state");
                    }
                }
            }
            packStringWithGetBytes(str);
            return this;
        }
    }

    public MessagePacker packValue(Value value) throws IOException {
        value.writeTo(this);
        return this;
    }

    public MessageBufferOutput reset(MessageBufferOutput messageBufferOutput) throws IOException {
        MessageBufferOutput messageBufferOutput2 = (MessageBufferOutput) Preconditions.checkNotNull(messageBufferOutput, "MessageBufferOutput is null");
        flush();
        MessageBufferOutput messageBufferOutput3 = this.out;
        this.out = messageBufferOutput2;
        this.totalFlushBytes = 0L;
        return messageBufferOutput3;
    }

    public MessagePacker writePayload(byte[] bArr) throws IOException {
        return writePayload(bArr, 0, bArr.length);
    }

    public MessagePacker writePayload(byte[] bArr, int i, int i2) throws IOException {
        MessageBuffer messageBuffer = this.buffer;
        if (messageBuffer != null) {
            int size = messageBuffer.size();
            int i3 = this.position;
            if (size - i3 >= i2 && i2 <= this.bufferFlushThreshold) {
                this.buffer.putBytes(i3, bArr, i, i2);
                this.position += i2;
                return this;
            }
        }
        flush();
        this.out.write(bArr, i, i2);
        this.totalFlushBytes += i2;
        return this;
    }
}
