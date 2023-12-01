package androidx.emoji2.text.flatbuffer;

import android.widget.ExpandableListView;
import com.igexin.push.core.b;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers.class */
public class FlexBuffers {
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2855a = !FlexBuffers.class.desiredAssertionStatus();
    private static final ReadBuf b = new ArrayReadWriteBuf(new byte[]{0}, 1);

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$Blob.class */
    public static class Blob extends Sized {
        static final /* synthetic */ boolean b = !FlexBuffers.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        static final Blob f2856a = new Blob(FlexBuffers.b, 1, 1);

        Blob(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Blob empty() {
            return f2856a;
        }

        public ByteBuffer data() {
            ByteBuffer wrap = ByteBuffer.wrap(this.f2860c.data());
            wrap.position(this.d);
            wrap.limit(this.d + size());
            return wrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i) {
            if (b || (i >= 0 && i <= size())) {
                return this.f2860c.get(this.d + i);
            }
            throw new AssertionError();
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return bArr;
                }
                bArr[i2] = this.f2860c.get(this.d + i2);
                i = i2 + 1;
            }
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.f2860c.getString(this.d, size());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append('\"');
            sb.append(this.f2860c.getString(this.d, size()));
            sb.append('\"');
            return sb;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$FlexBufferException.class */
    public static class FlexBufferException extends RuntimeException {
        /* JADX INFO: Access modifiers changed from: package-private */
        public FlexBufferException(String str) {
            super(str);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$Key.class */
    public static class Key extends Object {

        /* renamed from: a  reason: collision with root package name */
        private static final Key f2857a = new Key(FlexBuffers.b, 0, 0);

        Key(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Key empty() {
            return f2857a;
        }

        int a(byte[] bArr) {
            byte b;
            byte b2;
            int i = this.d;
            int i2 = 0;
            do {
                b = this.f2860c.get(i);
                b2 = bArr[i2];
                if (b == 0) {
                    return b - b2;
                }
                i++;
                i2++;
                if (i2 == bArr.length) {
                    return b - b2;
                }
            } while (b == b2);
            return b - b2;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                boolean z = false;
                if (key.d == this.d) {
                    z = false;
                    if (key.e == this.e) {
                        z = true;
                    }
                }
                return z;
            }
            return false;
        }

        public int hashCode() {
            return this.d ^ this.e;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int i = this.d;
            while (true) {
                int i2 = i;
                if (this.f2860c.get(i2) == 0) {
                    return this.f2860c.getString(this.d, i2 - this.d);
                }
                i = i2 + 1;
            }
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$KeyVector.class */
    public static class KeyVector {

        /* renamed from: a  reason: collision with root package name */
        private final TypedVector f2858a;

        KeyVector(TypedVector typedVector) {
            this.f2858a = typedVector;
        }

        public Key get(int i) {
            if (i >= size()) {
                return Key.f2857a;
            }
            return new Key(this.f2858a.f2860c, FlexBuffers.f(this.f2858a.f2860c, this.f2858a.d + (i * this.f2858a.e), this.f2858a.e), 1);
        }

        public int size() {
            return this.f2858a.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f2858a.size()) {
                    sb.append("]");
                    return sb.toString();
                }
                this.f2858a.get(i2).a(sb);
                if (i2 != this.f2858a.size() - 1) {
                    sb.append(", ");
                }
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$Map.class */
    public static class Map extends Vector {

        /* renamed from: a  reason: collision with root package name */
        private static final Map f2859a = new Map(FlexBuffers.b, 1, 1);

        Map(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        private int a(KeyVector keyVector, byte[] bArr) {
            int size = keyVector.size() - 1;
            int i = 0;
            while (i <= size) {
                int i2 = (i + size) >>> 1;
                int a2 = keyVector.get(i2).a(bArr);
                if (a2 < 0) {
                    i = i2 + 1;
                } else if (a2 <= 0) {
                    return i2;
                } else {
                    size = i2 - 1;
                }
            }
            return -(i + 1);
        }

        public static Map empty() {
            return f2859a;
        }

        public Reference get(String str) {
            return get(str.getBytes(StandardCharsets.UTF_8));
        }

        public Reference get(byte[] bArr) {
            KeyVector keys = keys();
            int size = keys.size();
            int a2 = a(keys, bArr);
            return (a2 < 0 || a2 >= size) ? Reference.f2861a : get(a2);
        }

        public KeyVector keys() {
            int i = this.d - (this.e * 3);
            return new KeyVector(new TypedVector(this.f2860c, FlexBuffers.f(this.f2860c, i, this.e), FlexBuffers.h(this.f2860c, i + this.e, this.e), 4));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append("{ ");
            KeyVector keys = keys();
            int size = size();
            Vector values = values();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    sb.append(" }");
                    return sb;
                }
                sb.append('\"');
                sb.append(keys.get(i2).toString());
                sb.append("\" : ");
                sb.append(values.get(i2).toString());
                if (i2 != size - 1) {
                    sb.append(", ");
                }
                i = i2 + 1;
            }
        }

        public Vector values() {
            return new Vector(this.f2860c, this.d, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$Object.class */
    public static abstract class Object {

        /* renamed from: c  reason: collision with root package name */
        ReadBuf f2860c;
        int d;
        int e;

        Object(ReadBuf readBuf, int i, int i2) {
            this.f2860c = readBuf;
            this.d = i;
            this.e = i2;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder sb);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$Reference.class */
    public static class Reference {

        /* renamed from: a  reason: collision with root package name */
        private static final Reference f2861a = new Reference(FlexBuffers.b, 0, 1, 0);
        private ReadBuf b;

        /* renamed from: c  reason: collision with root package name */
        private int f2862c;
        private int d;
        private int e;
        private int f;

        Reference(ReadBuf readBuf, int i, int i2, int i3) {
            this(readBuf, i, i2, 1 << (i3 & 3), i3 >> 2);
        }

        Reference(ReadBuf readBuf, int i, int i2, int i3, int i4) {
            this.b = readBuf;
            this.f2862c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        StringBuilder a(StringBuilder sb) {
            int i = this.f;
            if (i != 36) {
                switch (i) {
                    case 0:
                        sb.append(b.l);
                        return sb;
                    case 1:
                    case 6:
                        sb.append(asLong());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(asUInt());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(asFloat());
                        return sb;
                    case 4:
                        Key asKey = asKey();
                        sb.append('\"');
                        StringBuilder key = asKey.toString(sb);
                        key.append('\"');
                        return key;
                    case 5:
                        sb.append('\"');
                        sb.append(asString());
                        sb.append('\"');
                        return sb;
                    case 9:
                        return asMap().toString(sb);
                    case 10:
                        return asVector().toString(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.f);
                    case 25:
                        return asBlob().toString(sb);
                    case 26:
                        sb.append(asBoolean());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(asVector());
            return sb;
        }

        public Blob asBlob() {
            if (isBlob() || isString()) {
                ReadBuf readBuf = this.b;
                return new Blob(readBuf, FlexBuffers.f(readBuf, this.f2862c, this.d), this.e);
            }
            return Blob.empty();
        }

        public boolean asBoolean() {
            return isBoolean() ? this.b.get(this.f2862c) != 0 : asUInt() != 0;
        }

        public double asFloat() {
            int i = this.f;
            if (i == 3) {
                return FlexBuffers.j(this.b, this.f2862c, this.d);
            }
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        return Double.parseDouble(asString());
                    }
                    if (i == 6) {
                        ReadBuf readBuf = this.b;
                        return FlexBuffers.h(readBuf, FlexBuffers.f(readBuf, this.f2862c, this.d), this.e);
                    } else if (i == 7) {
                        ReadBuf readBuf2 = this.b;
                        return FlexBuffers.g(readBuf2, FlexBuffers.f(readBuf2, this.f2862c, this.d), this.e);
                    } else if (i == 8) {
                        ReadBuf readBuf3 = this.b;
                        return FlexBuffers.j(readBuf3, FlexBuffers.f(readBuf3, this.f2862c, this.d), this.e);
                    } else if (i == 10) {
                        return asVector().size();
                    } else {
                        if (i != 26) {
                            return 0.0d;
                        }
                    }
                }
                return FlexBuffers.g(this.b, this.f2862c, this.d);
            }
            return FlexBuffers.h(this.b, this.f2862c, this.d);
        }

        public int asInt() {
            long g;
            int i = this.f;
            if (i == 1) {
                return FlexBuffers.h(this.b, this.f2862c, this.d);
            }
            if (i == 2) {
                g = FlexBuffers.g(this.b, this.f2862c, this.d);
            } else if (i == 3) {
                return (int) FlexBuffers.j(this.b, this.f2862c, this.d);
            } else {
                if (i == 5) {
                    return Integer.parseInt(asString());
                }
                if (i == 6) {
                    ReadBuf readBuf = this.b;
                    return FlexBuffers.h(readBuf, FlexBuffers.f(readBuf, this.f2862c, this.d), this.e);
                } else if (i != 7) {
                    if (i == 8) {
                        ReadBuf readBuf2 = this.b;
                        return (int) FlexBuffers.j(readBuf2, FlexBuffers.f(readBuf2, this.f2862c, this.d), this.e);
                    } else if (i != 10) {
                        if (i != 26) {
                            return 0;
                        }
                        return FlexBuffers.h(this.b, this.f2862c, this.d);
                    } else {
                        return asVector().size();
                    }
                } else {
                    ReadBuf readBuf3 = this.b;
                    g = FlexBuffers.g(readBuf3, FlexBuffers.f(readBuf3, this.f2862c, this.d), this.d);
                }
            }
            return (int) g;
        }

        public Key asKey() {
            if (isKey()) {
                ReadBuf readBuf = this.b;
                return new Key(readBuf, FlexBuffers.f(readBuf, this.f2862c, this.d), this.e);
            }
            return Key.empty();
        }

        public long asLong() {
            int i = this.f;
            if (i == 1) {
                return FlexBuffers.i(this.b, this.f2862c, this.d);
            }
            if (i != 2) {
                if (i != 3) {
                    if (i == 5) {
                        try {
                            return Long.parseLong(asString());
                        } catch (NumberFormatException e) {
                            return 0L;
                        }
                    } else if (i == 6) {
                        ReadBuf readBuf = this.b;
                        return FlexBuffers.i(readBuf, FlexBuffers.f(readBuf, this.f2862c, this.d), this.e);
                    } else if (i == 7) {
                        ReadBuf readBuf2 = this.b;
                        return FlexBuffers.g(readBuf2, FlexBuffers.f(readBuf2, this.f2862c, this.d), this.d);
                    } else if (i == 8) {
                        ReadBuf readBuf3 = this.b;
                        return (long) FlexBuffers.j(readBuf3, FlexBuffers.f(readBuf3, this.f2862c, this.d), this.e);
                    } else if (i != 10) {
                        if (i != 26) {
                            return 0L;
                        }
                        return FlexBuffers.h(this.b, this.f2862c, this.d);
                    } else {
                        return asVector().size();
                    }
                }
                return (long) FlexBuffers.j(this.b, this.f2862c, this.d);
            }
            return FlexBuffers.g(this.b, this.f2862c, this.d);
        }

        public Map asMap() {
            if (isMap()) {
                ReadBuf readBuf = this.b;
                return new Map(readBuf, FlexBuffers.f(readBuf, this.f2862c, this.d), this.e);
            }
            return Map.empty();
        }

        public String asString() {
            if (isString()) {
                int f = FlexBuffers.f(this.b, this.f2862c, this.d);
                ReadBuf readBuf = this.b;
                int i = this.e;
                return this.b.getString(f, (int) FlexBuffers.g(readBuf, f - i, i));
            } else if (!isKey()) {
                return "";
            } else {
                int f2 = FlexBuffers.f(this.b, this.f2862c, this.e);
                int i2 = f2;
                while (true) {
                    int i3 = i2;
                    if (this.b.get(i3) == 0) {
                        return this.b.getString(f2, i3 - f2);
                    }
                    i2 = i3 + 1;
                }
            }
        }

        public long asUInt() {
            int i = this.f;
            if (i == 2) {
                return FlexBuffers.g(this.b, this.f2862c, this.d);
            }
            if (i != 1) {
                if (i != 3) {
                    if (i != 10) {
                        if (i != 26) {
                            if (i != 5) {
                                if (i == 6) {
                                    ReadBuf readBuf = this.b;
                                    return FlexBuffers.i(readBuf, FlexBuffers.f(readBuf, this.f2862c, this.d), this.e);
                                } else if (i == 7) {
                                    ReadBuf readBuf2 = this.b;
                                    return FlexBuffers.g(readBuf2, FlexBuffers.f(readBuf2, this.f2862c, this.d), this.e);
                                } else if (i != 8) {
                                    return 0L;
                                } else {
                                    ReadBuf readBuf3 = this.b;
                                    return (long) FlexBuffers.j(readBuf3, FlexBuffers.f(readBuf3, this.f2862c, this.d), this.d);
                                }
                            }
                            return Long.parseLong(asString());
                        }
                        return FlexBuffers.h(this.b, this.f2862c, this.d);
                    }
                    return asVector().size();
                }
                return (long) FlexBuffers.j(this.b, this.f2862c, this.d);
            }
            return FlexBuffers.i(this.b, this.f2862c, this.d);
        }

        public Vector asVector() {
            if (isVector()) {
                ReadBuf readBuf = this.b;
                return new Vector(readBuf, FlexBuffers.f(readBuf, this.f2862c, this.d), this.e);
            }
            int i = this.f;
            if (i == 15) {
                ReadBuf readBuf2 = this.b;
                return new TypedVector(readBuf2, FlexBuffers.f(readBuf2, this.f2862c, this.d), this.e, 4);
            } else if (FlexBuffers.a(i)) {
                ReadBuf readBuf3 = this.b;
                return new TypedVector(readBuf3, FlexBuffers.f(readBuf3, this.f2862c, this.d), this.e, FlexBuffers.c(this.f));
            } else {
                return Vector.empty();
            }
        }

        public int getType() {
            return this.f;
        }

        public boolean isBlob() {
            return this.f == 25;
        }

        public boolean isBoolean() {
            return this.f == 26;
        }

        public boolean isFloat() {
            int i = this.f;
            return i == 3 || i == 8;
        }

        public boolean isInt() {
            int i = this.f;
            boolean z = true;
            if (i != 1) {
                if (i == 6) {
                    return true;
                }
                z = false;
            }
            return z;
        }

        public boolean isIntOrUInt() {
            return isInt() || isUInt();
        }

        public boolean isKey() {
            return this.f == 4;
        }

        public boolean isMap() {
            return this.f == 9;
        }

        public boolean isNull() {
            return this.f == 0;
        }

        public boolean isNumeric() {
            return isIntOrUInt() || isFloat();
        }

        public boolean isString() {
            return this.f == 5;
        }

        public boolean isTypedVector() {
            return FlexBuffers.a(this.f);
        }

        public boolean isUInt() {
            int i = this.f;
            return i == 2 || i == 7;
        }

        public boolean isVector() {
            int i = this.f;
            return i == 10 || i == 9;
        }

        public String toString() {
            return a(new StringBuilder(128)).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$Sized.class */
    public static abstract class Sized extends Object {
        protected final int f;

        Sized(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
            this.f = FlexBuffers.h(this.f2860c, i - i2, i2);
        }

        public int size() {
            return this.f;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$TypedVector.class */
    public static class TypedVector extends Vector {

        /* renamed from: a  reason: collision with root package name */
        private static final TypedVector f2863a = new TypedVector(FlexBuffers.b, 1, 1, 1);
        private final int b;

        TypedVector(ReadBuf readBuf, int i, int i2, int i3) {
            super(readBuf, i, i2);
            this.b = i3;
        }

        public static TypedVector empty() {
            return f2863a;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int i) {
            if (i >= size()) {
                return Reference.f2861a;
            }
            return new Reference(this.f2860c, this.d + (i * this.e), this.e, 1, this.b);
        }

        public int getElemType() {
            return this.b;
        }

        public boolean isEmptyVector() {
            return this == f2863a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$Unsigned.class */
    public static class Unsigned {
        Unsigned() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int a(byte b) {
            return b & 255;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int a(short s) {
            return s & 65535;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static long a(int i) {
            return i & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffers$Vector.class */
    public static class Vector extends Sized {

        /* renamed from: a  reason: collision with root package name */
        private static final Vector f2864a = new Vector(FlexBuffers.b, 1, 1);

        Vector(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Vector empty() {
            return f2864a;
        }

        public Reference get(int i) {
            long size = size();
            long j = i;
            if (j >= size) {
                return Reference.f2861a;
            }
            return new Reference(this.f2860c, this.d + (i * this.e), this.e, Unsigned.a(this.f2860c.get((int) (this.d + (size * this.e) + j))));
        }

        public boolean isEmpty() {
            return this == f2864a;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append("[ ");
            int size = size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    sb.append(" ]");
                    return sb;
                }
                get(i2).a(sb);
                if (i2 != size - 1) {
                    sb.append(", ");
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, int i2) {
        if (f2855a || d(i)) {
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (f2855a) {
                                return 0;
                            }
                            throw new AssertionError();
                        }
                        return (i - 1) + 22;
                    }
                    return (i - 1) + 19;
                }
                return (i - 1) + 16;
            }
            return (i - 1) + 11;
        }
        throw new AssertionError();
    }

    static boolean a(int i) {
        return (i >= 11 && i <= 15) || i == 36;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(int i) {
        return i <= 3 || i == 26;
    }

    static int c(int i) {
        return (i - 11) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(int i) {
        boolean z = true;
        if (i < 1 || i > 4) {
            if (i == 26) {
                return true;
            }
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(ReadBuf readBuf, int i, int i2) {
        return (int) (i - g(readBuf, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long g(ReadBuf readBuf, int i, int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 8) {
                        return -1L;
                    }
                    return readBuf.getLong(i);
                }
                return Unsigned.a(readBuf.getInt(i));
            }
            return Unsigned.a(readBuf.getShort(i));
        }
        return Unsigned.a(readBuf.get(i));
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int limit = readBuf.limit() - 1;
        byte b2 = readBuf.get(limit);
        int i = limit - 1;
        return new Reference(readBuf, i - b2, b2, Unsigned.a(readBuf.get(i)));
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(ReadBuf readBuf, int i, int i2) {
        return (int) i(readBuf, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long i(ReadBuf readBuf, int i, int i2) {
        short s;
        if (i2 == 1) {
            s = readBuf.get(i);
        } else if (i2 == 2) {
            s = readBuf.getShort(i);
        } else if (i2 != 4) {
            if (i2 != 8) {
                return -1L;
            }
            return readBuf.getLong(i);
        } else {
            s = readBuf.getInt(i);
        }
        return s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double j(ReadBuf readBuf, int i, int i2) {
        if (i2 != 4) {
            if (i2 != 8) {
                return -1.0d;
            }
            return readBuf.getDouble(i);
        }
        return readBuf.getFloat(i);
    }
}
