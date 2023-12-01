package io.grpc;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata.class */
public final class Metadata {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String BINARY_HEADER_SUFFIX = "-bin";
    private Object[] namesAndValues;
    private int size;
    public static final BinaryMarshaller<byte[]> BINARY_BYTE_MARSHALLER = new BinaryMarshaller<byte[]>() { // from class: io.grpc.Metadata.1
        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] parseBytes(byte[] bArr) {
            return bArr;
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] toBytes(byte[] bArr) {
            return bArr;
        }
    };
    public static final AsciiMarshaller<String> ASCII_STRING_MARSHALLER = new AsciiMarshaller<String>() { // from class: io.grpc.Metadata.2
        @Override // io.grpc.Metadata.AsciiMarshaller
        public String parseAsciiString(String str) {
            return str;
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(String str) {
            return str;
        }
    };
    static final BaseEncoding BASE64_ENCODING_OMIT_PADDING = BaseEncoding.base64().omitPadding();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$AsciiKey.class */
    public static class AsciiKey<T> extends Key<T> {
        private final AsciiMarshaller<T> marshaller;

        private AsciiKey(String str, boolean z, AsciiMarshaller<T> asciiMarshaller) {
            super(str, z, asciiMarshaller);
            Preconditions.checkArgument(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (AsciiMarshaller) Preconditions.checkNotNull(asciiMarshaller, "marshaller");
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] bArr) {
            return this.marshaller.parseAsciiString(new String(bArr, Charsets.US_ASCII));
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T t) {
            return this.marshaller.toAsciiString(t).getBytes(Charsets.US_ASCII);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$AsciiMarshaller.class */
    public interface AsciiMarshaller<T> {
        T parseAsciiString(String str);

        String toAsciiString(T t);
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$BinaryKey.class */
    static class BinaryKey<T> extends Key<T> {
        private final BinaryMarshaller<T> marshaller;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private BinaryKey(String str, BinaryMarshaller<T> binaryMarshaller) {
            super(str, false, binaryMarshaller);
            boolean z = false;
            Preconditions.checkArgument(str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            Preconditions.checkArgument(str.length() > 4 ? true : z, "empty key name");
            this.marshaller = (BinaryMarshaller) Preconditions.checkNotNull(binaryMarshaller, "marshaller is null");
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] bArr) {
            return this.marshaller.parseBytes(bArr);
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T t) {
            return this.marshaller.toBytes(t);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$BinaryMarshaller.class */
    public interface BinaryMarshaller<T> {
        T parseBytes(byte[] bArr);

        byte[] toBytes(T t);
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$BinaryStreamMarshaller.class */
    public interface BinaryStreamMarshaller<T> {
        T parseStream(InputStream inputStream);

        InputStream toStream(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$IterableAt.class */
    public final class IterableAt<T> implements Iterable<T> {
        private final Key<T> key;
        private int startIdx;

        private IterableAt(Key<T> key, int i) {
            this.key = key;
            this.startIdx = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new Iterator<T>() { // from class: io.grpc.Metadata.IterableAt.1
                private boolean hasNext = true;
                private int idx;

                {
                    this.idx = IterableAt.this.startIdx;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.hasNext) {
                        return true;
                    }
                    while (this.idx < Metadata.this.size) {
                        if (Metadata.this.bytesEqual(IterableAt.this.key.asciiName(), Metadata.this.name(this.idx))) {
                            this.hasNext = true;
                            return true;
                        }
                        this.idx++;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public T next() {
                    if (hasNext()) {
                        this.hasNext = false;
                        Metadata metadata = Metadata.this;
                        int i = this.idx;
                        this.idx = i + 1;
                        return (T) metadata.valueAsT(i, IterableAt.this.key);
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$Key.class */
    public static abstract class Key<T> {
        private static final BitSet VALID_T_CHARS = generateValidTChars();
        private final Object marshaller;
        private final String name;
        private final byte[] nameBytes;
        private final String originalName;

        private Key(String str, boolean z, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str, "name");
            this.originalName = str2;
            String validateName = validateName(str2.toLowerCase(Locale.ROOT), z);
            this.name = validateName;
            this.nameBytes = validateName.getBytes(Charsets.US_ASCII);
            this.marshaller = obj;
        }

        private static BitSet generateValidTChars() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            char c2 = '0';
            while (true) {
                char c3 = c2;
                if (c3 > '9') {
                    break;
                }
                bitSet.set(c3);
                c2 = (char) (c3 + 1);
            }
            char c4 = 'a';
            while (true) {
                char c5 = c4;
                if (c5 > 'z') {
                    return bitSet;
                }
                bitSet.set(c5);
                c4 = (char) (c5 + 1);
            }
        }

        public static <T> Key<T> of(String str, AsciiMarshaller<T> asciiMarshaller) {
            return of(str, false, (AsciiMarshaller) asciiMarshaller);
        }

        public static <T> Key<T> of(String str, BinaryMarshaller<T> binaryMarshaller) {
            return new BinaryKey(str, binaryMarshaller);
        }

        public static <T> Key<T> of(String str, BinaryStreamMarshaller<T> binaryStreamMarshaller) {
            return new LazyStreamBinaryKey(str, binaryStreamMarshaller);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <T> Key<T> of(String str, boolean z, AsciiMarshaller<T> asciiMarshaller) {
            return new AsciiKey(str, z, asciiMarshaller);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <T> Key<T> of(String str, boolean z, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
            return new TrustedAsciiKey(str, z, trustedAsciiMarshaller);
        }

        private static String validateName(String str, boolean z) {
            Preconditions.checkNotNull(str, "name");
            Preconditions.checkArgument(!str.isEmpty(), "token must have at least 1 tchar");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= str.length()) {
                    return str;
                }
                char charAt = str.charAt(i2);
                if (!z || charAt != ':' || i2 != 0) {
                    Preconditions.checkArgument(VALID_T_CHARS.get(charAt), "Invalid character '%s' in key name '%s'", charAt, (Object) str);
                }
                i = i2 + 1;
            }
        }

        byte[] asciiName() {
            return this.nameBytes;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.name.equals(((Key) obj).name);
        }

        @Nullable
        final <M> M getMarshaller(Class<M> cls) {
            if (cls.isInstance(this.marshaller)) {
                return cls.cast(this.marshaller);
            }
            return null;
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public final String name() {
            return this.name;
        }

        public final String originalName() {
            return this.originalName;
        }

        abstract T parseBytes(byte[] bArr);

        boolean serializesToStreams() {
            return false;
        }

        abstract byte[] toBytes(T t);

        public String toString() {
            return "Key{name='" + this.name + "'}";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$LazyStreamBinaryKey.class */
    static class LazyStreamBinaryKey<T> extends Key<T> {
        private final BinaryStreamMarshaller<T> marshaller;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private LazyStreamBinaryKey(String str, BinaryStreamMarshaller<T> binaryStreamMarshaller) {
            super(str, false, binaryStreamMarshaller);
            boolean z = false;
            Preconditions.checkArgument(str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            Preconditions.checkArgument(str.length() > 4 ? true : z, "empty key name");
            this.marshaller = (BinaryStreamMarshaller) Preconditions.checkNotNull(binaryStreamMarshaller, "marshaller is null");
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] bArr) {
            return this.marshaller.parseStream(new ByteArrayInputStream(bArr));
        }

        @Override // io.grpc.Metadata.Key
        boolean serializesToStreams() {
            return true;
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T t) {
            return Metadata.streamToBytes(this.marshaller.toStream(t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$LazyValue.class */
    public static final class LazyValue<T> {
        private final BinaryStreamMarshaller<T> marshaller;
        private volatile byte[] serialized;
        private final T value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LazyValue(BinaryStreamMarshaller<T> binaryStreamMarshaller, T t) {
            this.marshaller = binaryStreamMarshaller;
            this.value = t;
        }

        static <T> LazyValue<T> create(Key<T> key, T t) {
            return new LazyValue<>((BinaryStreamMarshaller) Preconditions.checkNotNull(getBinaryStreamMarshaller(key)), t);
        }

        @Nullable
        private static <T> BinaryStreamMarshaller<T> getBinaryStreamMarshaller(Key<T> key) {
            return (BinaryStreamMarshaller) key.getMarshaller(BinaryStreamMarshaller.class);
        }

        byte[] toBytes() {
            if (this.serialized == null) {
                synchronized (this) {
                    if (this.serialized == null) {
                        this.serialized = Metadata.streamToBytes(toStream());
                    }
                }
            }
            return this.serialized;
        }

        <T2> T2 toObject(Key<T2> key) {
            BinaryStreamMarshaller binaryStreamMarshaller;
            return (!key.serializesToStreams() || (binaryStreamMarshaller = getBinaryStreamMarshaller(key)) == null) ? key.parseBytes(toBytes()) : (T2) binaryStreamMarshaller.parseStream(toStream());
        }

        InputStream toStream() {
            return this.marshaller.toStream(this.value);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$TrustedAsciiKey.class */
    static final class TrustedAsciiKey<T> extends Key<T> {
        private final TrustedAsciiMarshaller<T> marshaller;

        private TrustedAsciiKey(String str, boolean z, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
            super(str, z, trustedAsciiMarshaller);
            Preconditions.checkArgument(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (TrustedAsciiMarshaller) Preconditions.checkNotNull(trustedAsciiMarshaller, "marshaller");
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] bArr) {
            return this.marshaller.parseAsciiString(bArr);
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T t) {
            return this.marshaller.toAsciiString(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Metadata$TrustedAsciiMarshaller.class */
    public interface TrustedAsciiMarshaller<T> {
        T parseAsciiString(byte[] bArr);

        byte[] toAsciiString(T t);
    }

    public Metadata() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(int i, Object[] objArr) {
        this.size = i;
        this.namesAndValues = objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(int i, byte[]... bArr) {
        this(i, (Object[]) bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bytesEqual(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    private int cap() {
        Object[] objArr = this.namesAndValues;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    private void expand(int i) {
        Object[] objArr = new Object[i];
        if (!isEmpty()) {
            System.arraycopy(this.namesAndValues, 0, objArr, 0, len());
        }
        this.namesAndValues = objArr;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private int len() {
        return this.size * 2;
    }

    private void maybeExpand() {
        if (len() == 0 || len() == cap()) {
            expand(Math.max(len() * 2, 8));
        }
    }

    private void name(int i, byte[] bArr) {
        this.namesAndValues[i * 2] = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] name(int i) {
        return (byte[]) this.namesAndValues[i * 2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] streamToBytes(InputStream inputStream) {
        try {
            return ByteStreams.toByteArray(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("failure reading serialized stream", e);
        }
    }

    private Object value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    private void value(int i, Object obj) {
        if (this.namesAndValues instanceof byte[][]) {
            expand(cap());
        }
        this.namesAndValues[(i * 2) + 1] = obj;
    }

    private void value(int i, byte[] bArr) {
        this.namesAndValues[(i * 2) + 1] = bArr;
    }

    private byte[] valueAsBytes(int i) {
        Object value = value(i);
        return value instanceof byte[] ? (byte[]) value : ((LazyValue) value).toBytes();
    }

    private Object valueAsBytesOrStream(int i) {
        Object value = value(i);
        return value instanceof byte[] ? value : ((LazyValue) value).toStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T valueAsT(int i, Key<T> key) {
        Object value = value(i);
        return value instanceof byte[] ? key.parseBytes((byte[]) value) : (T) ((LazyValue) value).toObject(key);
    }

    public boolean containsKey(Key<?> key) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return false;
            }
            if (bytesEqual(key.asciiName(), name(i2))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public <T> void discardAll(Key<T> key) {
        if (isEmpty()) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (!bytesEqual(key.asciiName(), name(i2))) {
                name(i, name(i2));
                value(i, value(i2));
                i++;
            }
        }
        Arrays.fill(this.namesAndValues, i * 2, len(), (Object) null);
        this.size = i;
    }

    @Nullable
    public <T> T get(Key<T> key) {
        int i = this.size;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return null;
            }
            if (bytesEqual(key.asciiName(), name(i2))) {
                return (T) valueAsT(i2, key);
            }
            i = i2;
        }
    }

    @Nullable
    public <T> Iterable<T> getAll(Key<T> key) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return null;
            }
            if (bytesEqual(key.asciiName(), name(i2))) {
                return new IterableAt(key, i2);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int headerCount() {
        return this.size;
    }

    public Set<String> keys() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return Collections.unmodifiableSet(hashSet);
            }
            hashSet.add(new String(name(i2), 0));
            i = i2 + 1;
        }
    }

    public void merge(Metadata metadata) {
        if (metadata.isEmpty()) {
            return;
        }
        int cap = cap();
        int len = len();
        if (isEmpty() || cap - len < metadata.len()) {
            expand(len() + metadata.len());
        }
        System.arraycopy(metadata.namesAndValues, 0, this.namesAndValues, len(), metadata.len());
        this.size += metadata.size;
    }

    public void merge(Metadata metadata, Set<Key<?>> set) {
        Preconditions.checkNotNull(metadata, "other");
        HashMap hashMap = new HashMap(set.size());
        for (Key<?> key : set) {
            hashMap.put(ByteBuffer.wrap(key.asciiName()), key);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= metadata.size) {
                return;
            }
            if (hashMap.containsKey(ByteBuffer.wrap(metadata.name(i2)))) {
                maybeExpand();
                name(this.size, metadata.name(i2));
                value(this.size, metadata.value(i2));
                this.size++;
            }
            i = i2 + 1;
        }
    }

    public <T> void put(Key<T> key, T t) {
        Preconditions.checkNotNull(key, "key");
        Preconditions.checkNotNull(t, "value");
        maybeExpand();
        name(this.size, key.asciiName());
        if (key.serializesToStreams()) {
            value(this.size, LazyValue.create(key, t));
        } else {
            value(this.size, key.toBytes(t));
        }
        this.size++;
    }

    public <T> boolean remove(Key<T> key, T t) {
        Preconditions.checkNotNull(key, "key");
        Preconditions.checkNotNull(t, "value");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return false;
            }
            if (bytesEqual(key.asciiName(), name(i2)) && t.equals(valueAsT(i2, key))) {
                int i3 = (i2 + 1) * 2;
                int len = len();
                Object[] objArr = this.namesAndValues;
                System.arraycopy(objArr, i3, objArr, i2 * 2, len - i3);
                int i4 = this.size - 1;
                this.size = i4;
                name(i4, null);
                value(this.size, (byte[]) null);
                return true;
            }
            i = i2 + 1;
        }
    }

    public <T> Iterable<T> removeAll(Key<T> key) {
        if (isEmpty()) {
            return null;
        }
        ArrayList arrayList = null;
        int i = 0;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (bytesEqual(key.asciiName(), name(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(valueAsT(i2, key));
            } else {
                name(i, name(i2));
                value(i, value(i2));
                i++;
            }
        }
        Arrays.fill(this.namesAndValues, i * 2, len(), (Object) null);
        this.size = i;
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v2, types: [byte[], byte[][], java.lang.Object] */
    @Nullable
    public byte[][] serialize() {
        ?? r0 = new byte[len()];
        Object[] objArr = this.namesAndValues;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, (Object) r0, 0, len());
            return r0;
        }
        for (int i = 0; i < this.size; i++) {
            int i2 = i * 2;
            r0[i2] = name(i);
            r0[i2 + 1] = valueAsBytes(i);
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object[] serializePartial() {
        Object[] objArr = new Object[len()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return objArr;
            }
            int i3 = i2 * 2;
            objArr[i3] = name(i2);
            objArr[i3 + 1] = valueAsBytesOrStream(i2);
            i = i2 + 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                sb.append(')');
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(',');
            }
            String str = new String(name(i2), Charsets.US_ASCII);
            sb.append(str);
            sb.append('=');
            if (str.endsWith(BINARY_HEADER_SUFFIX)) {
                sb.append(BASE64_ENCODING_OMIT_PADDING.encode(valueAsBytes(i2)));
            } else {
                sb.append(new String(valueAsBytes(i2), Charsets.US_ASCII));
            }
            i = i2 + 1;
        }
    }
}
