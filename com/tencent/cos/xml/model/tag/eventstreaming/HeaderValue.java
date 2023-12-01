package com.tencent.cos.xml.model.tag.eventstreaming;

import com.tencent.cos.xml.s3.Base64;
import com.tencent.cos.xml.s3.Base64Codec;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue.class */
public abstract class HeaderValue {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007d -> B:61:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:55:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0085 -> B:51:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0089 -> B:45:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008d -> B:59:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0091 -> B:53:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0095 -> B:49:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0099 -> B:43:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009d -> B:57:0x0070). Please submit an issue!!! */
        static {
            int[] iArr = new int[HeaderType.values().length];
            $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType = iArr;
            try {
                iArr[HeaderType.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.INTEGER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.LONG.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.BYTE_ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.STRING.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.TIMESTAMP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.UUID.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$BooleanValue.class */
    static final class BooleanValue extends HeaderValue {
        private final boolean value;

        private BooleanValue(boolean z) {
            this.value = z;
        }

        /* synthetic */ BooleanValue(boolean z, AnonymousClass1 anonymousClass1) {
            this(z);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        void encodeValue(DataOutputStream dataOutputStream) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((BooleanValue) obj).value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public boolean getBoolean() {
            return this.value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public HeaderType getType() {
            return this.value ? HeaderType.TRUE : HeaderType.FALSE;
        }

        public int hashCode() {
            return this.value ? 1 : 0;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$ByteArrayValue.class */
    public static final class ByteArrayValue extends HeaderValue {
        private Base64Codec codec;
        private final byte[] value;

        private ByteArrayValue(byte[] bArr) {
            this.value = (byte[]) ValidationUtils.assertNotNull(bArr, "value");
        }

        /* synthetic */ ByteArrayValue(byte[] bArr, AnonymousClass1 anonymousClass1) {
            this(bArr);
        }

        private String toStringDirect(byte[] bArr) {
            char[] cArr = new char[bArr.length];
            int length = bArr.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= length) {
                    return new String(cArr);
                }
                cArr[i3] = (char) bArr[i];
                i++;
                i2 = i3 + 1;
            }
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        void encodeValue(DataOutputStream dataOutputStream) throws IOException {
            Utils.writeBytes(dataOutputStream, this.value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Arrays.equals(this.value, ((ByteArrayValue) obj).value);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public byte[] getByteArray() {
            return this.value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public HeaderType getType() {
            return HeaderType.BYTE_ARRAY;
        }

        public int hashCode() {
            return Arrays.hashCode(this.value);
        }

        public String toString() {
            return Base64.encodeAsString(this.value);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$ByteValue.class */
    static final class ByteValue extends HeaderValue {
        private final byte value;

        private ByteValue(byte b) {
            this.value = b;
        }

        /* synthetic */ ByteValue(byte b, AnonymousClass1 anonymousClass1) {
            this(b);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        void encodeValue(DataOutputStream dataOutputStream) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((ByteValue) obj).value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public byte getByte() {
            return this.value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public HeaderType getType() {
            return HeaderType.BYTE;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return String.valueOf((int) this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$IntegerValue.class */
    public static final class IntegerValue extends HeaderValue {
        private final int value;

        private IntegerValue(int i) {
            this.value = i;
        }

        /* synthetic */ IntegerValue(int i, AnonymousClass1 anonymousClass1) {
            this(i);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        void encodeValue(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((IntegerValue) obj).value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public int getInteger() {
            return this.value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public HeaderType getType() {
            return HeaderType.INTEGER;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$LongValue.class */
    static final class LongValue extends HeaderValue {
        private final long value;

        private LongValue(long j) {
            this.value = j;
        }

        /* synthetic */ LongValue(long j, AnonymousClass1 anonymousClass1) {
            this(j);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        void encodeValue(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeLong(this.value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((LongValue) obj).value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public long getLong() {
            return this.value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public HeaderType getType() {
            return HeaderType.LONG;
        }

        public int hashCode() {
            long j = this.value;
            return (int) (j ^ (j >>> 32));
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$ShortValue.class */
    static final class ShortValue extends HeaderValue {
        private final short value;

        private ShortValue(short s) {
            this.value = s;
        }

        /* synthetic */ ShortValue(short s, AnonymousClass1 anonymousClass1) {
            this(s);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        void encodeValue(DataOutputStream dataOutputStream) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((ShortValue) obj).value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public short getShort() {
            return this.value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public HeaderType getType() {
            return HeaderType.SHORT;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return String.valueOf((int) this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$StringValue.class */
    public static final class StringValue extends HeaderValue {
        private final String value;

        private StringValue(String str) {
            this.value = (String) ValidationUtils.assertNotNull(str, "value");
        }

        /* synthetic */ StringValue(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        void encodeValue(DataOutputStream dataOutputStream) throws IOException {
            Utils.writeString(dataOutputStream, this.value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.value.equals(((StringValue) obj).value);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public String getString() {
            return this.value;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public HeaderType getType() {
            return HeaderType.STRING;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return '\"' + this.value + '\"';
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$TimestampValue.class */
    static final class TimestampValue extends HeaderValue {
        private final Date value;

        private TimestampValue(Date date) {
            this.value = (Date) ValidationUtils.assertNotNull(date, "value");
        }

        /* synthetic */ TimestampValue(Date date, AnonymousClass1 anonymousClass1) {
            this(date);
        }

        static TimestampValue decode(ByteBuffer byteBuffer) {
            return new TimestampValue(new Date(byteBuffer.getLong()));
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        void encodeValue(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeLong(this.value.getTime());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.value.equals(((TimestampValue) obj).value);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public long getTimestamp() {
            return this.value.getTime();
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public HeaderType getType() {
            return HeaderType.TIMESTAMP;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return this.value.toString();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/HeaderValue$UuidValue.class */
    static final class UuidValue extends HeaderValue {
        private final UUID value;

        private UuidValue(UUID uuid) {
            this.value = (UUID) ValidationUtils.assertNotNull(uuid, "value");
        }

        /* synthetic */ UuidValue(UUID uuid, AnonymousClass1 anonymousClass1) {
            this(uuid);
        }

        static UuidValue decode(ByteBuffer byteBuffer) {
            return new UuidValue(new UUID(byteBuffer.getLong(), byteBuffer.getLong()));
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        void encodeValue(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeLong(this.value.getMostSignificantBits());
            dataOutputStream.writeLong(this.value.getLeastSignificantBits());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.value.equals(((UuidValue) obj).value);
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public HeaderType getType() {
            return HeaderType.UUID;
        }

        @Override // com.tencent.cos.xml.model.tag.eventstreaming.HeaderValue
        public UUID getUuid() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return this.value.toString();
        }
    }

    protected HeaderValue() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HeaderValue decode(ByteBuffer byteBuffer) {
        switch (AnonymousClass1.$SwitchMap$com$tencent$cos$xml$model$tag$eventstreaming$HeaderType[HeaderType.fromTypeId(byteBuffer.get()).ordinal()]) {
            case 1:
                return new BooleanValue(true, null);
            case 2:
                return new BooleanValue(false, null);
            case 3:
                return new ByteValue(byteBuffer.get(), null);
            case 4:
                return new ShortValue(byteBuffer.getShort(), null);
            case 5:
                return fromInteger(byteBuffer.getInt());
            case 6:
                return new LongValue(byteBuffer.getLong(), null);
            case 7:
                return fromByteArray(Utils.readBytes(byteBuffer));
            case 8:
                try {
                    return fromString(Utils.readString(byteBuffer));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    throw new IllegalStateException();
                }
            case 9:
                return TimestampValue.decode(byteBuffer);
            case 10:
                return UuidValue.decode(byteBuffer);
            default:
                throw new IllegalStateException();
        }
    }

    public static HeaderValue fromBoolean(boolean z) {
        return new BooleanValue(z, null);
    }

    public static HeaderValue fromByte(byte b) {
        return new ByteValue(b, null);
    }

    public static HeaderValue fromByteArray(byte[] bArr) {
        return new ByteArrayValue(bArr, null);
    }

    public static HeaderValue fromByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        byte[] bArr = new byte[duplicate.remaining()];
        duplicate.get(bArr);
        return fromByteArray(bArr);
    }

    public static HeaderValue fromDate(Date date) {
        return new TimestampValue(date, null);
    }

    public static HeaderValue fromInteger(int i) {
        return new IntegerValue(i, null);
    }

    public static HeaderValue fromLong(long j) {
        return new LongValue(j, null);
    }

    public static HeaderValue fromShort(short s) {
        return new ShortValue(s, null);
    }

    public static HeaderValue fromString(String str) {
        return new StringValue(str, null);
    }

    public static HeaderValue fromTimestamp(long j) {
        return new TimestampValue(new Date(j), null);
    }

    public static HeaderValue fromUuid(UUID uuid) {
        return new UuidValue(uuid, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(getType().headerTypeId);
        encodeValue(dataOutputStream);
    }

    abstract void encodeValue(DataOutputStream dataOutputStream) throws IOException;

    public boolean getBoolean() {
        throw new IllegalStateException();
    }

    public byte getByte() {
        throw new IllegalStateException("Expected byte, but type was " + getType().name());
    }

    public byte[] getByteArray() {
        throw new IllegalStateException();
    }

    public final ByteBuffer getByteBuffer() {
        return ByteBuffer.wrap(getByteArray());
    }

    public Date getDate() {
        return new Date(getTimestamp());
    }

    public int getInteger() {
        throw new IllegalStateException("Expected integer, but type was " + getType().name());
    }

    public long getLong() {
        throw new IllegalStateException("Expected long, but type was " + getType().name());
    }

    public short getShort() {
        throw new IllegalStateException("Expected short, but type was " + getType().name());
    }

    public String getString() {
        throw new IllegalStateException();
    }

    public long getTimestamp() {
        throw new IllegalStateException("Expected timestamp, but type was " + getType().name());
    }

    public abstract HeaderType getType();

    public UUID getUuid() {
        throw new IllegalStateException("Expected UUID, but type was " + getType().name());
    }
}
