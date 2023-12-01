package com.android.dex;

import com.android.dex.ClassData;
import com.android.dex.Code;
import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;
import com.android.dex.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex.class */
public final class Dex {
    private static final int CHECKSUM_OFFSET = 8;
    private static final int CHECKSUM_SIZE = 4;
    static final short[] EMPTY_SHORT_ARRAY = new short[0];
    private static final int SIGNATURE_OFFSET = 12;
    private static final int SIGNATURE_SIZE = 20;
    private ByteBuffer data;
    private final FieldIdTable fieldIds;
    private final MethodIdTable methodIds;
    private int nextSectionStart;
    private final ProtoIdTable protoIds;
    private final StringTable strings;
    private final TableOfContents tableOfContents;
    private final TypeIndexToDescriptorIndexTable typeIds;
    private final TypeIndexToDescriptorTable typeNames;

    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex$ClassDefIterable.class */
    private final class ClassDefIterable implements Iterable<ClassDef> {
        private ClassDefIterable() {
        }

        @Override // java.lang.Iterable
        public Iterator<ClassDef> iterator() {
            return !Dex.this.tableOfContents.classDefs.exists() ? Collections.emptySet().iterator() : new ClassDefIterator();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex$ClassDefIterator.class */
    private final class ClassDefIterator implements Iterator<ClassDef> {
        private int count;
        private final Section in;

        private ClassDefIterator() {
            this.in = Dex.this.open(Dex.this.tableOfContents.classDefs.off);
            this.count = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.count < Dex.this.tableOfContents.classDefs.size;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ClassDef next() {
            if (hasNext()) {
                this.count++;
                return this.in.readClassDef();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex$FieldIdTable.class */
    public final class FieldIdTable extends AbstractList<FieldId> implements RandomAccess {
        private FieldIdTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public FieldId get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.fieldIds.size);
            return Dex.this.open(Dex.this.tableOfContents.fieldIds.off + (i * 8)).readFieldId();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Dex.this.tableOfContents.fieldIds.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex$MethodIdTable.class */
    public final class MethodIdTable extends AbstractList<MethodId> implements RandomAccess {
        private MethodIdTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public MethodId get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.methodIds.size);
            return Dex.this.open(Dex.this.tableOfContents.methodIds.off + (i * 8)).readMethodId();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Dex.this.tableOfContents.methodIds.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex$ProtoIdTable.class */
    public final class ProtoIdTable extends AbstractList<ProtoId> implements RandomAccess {
        private ProtoIdTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public ProtoId get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.protoIds.size);
            return Dex.this.open(Dex.this.tableOfContents.protoIds.off + (i * 12)).readProtoId();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Dex.this.tableOfContents.protoIds.size;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex$Section.class */
    public final class Section implements ByteInput, ByteOutput {
        private final ByteBuffer data;
        private final int initialPosition;
        private final String name;

        private Section(String str, ByteBuffer byteBuffer) {
            this.name = str;
            this.data = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        private int findCatchHandlerIndex(Code.CatchHandler[] catchHandlerArr, int i) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= catchHandlerArr.length) {
                    throw new IllegalArgumentException();
                }
                if (catchHandlerArr[i3].getOffset() == i) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }

        private byte[] getBytesFrom(int i) {
            byte[] bArr = new byte[this.data.position() - i];
            this.data.position(i);
            this.data.get(bArr);
            return bArr;
        }

        private Code.CatchHandler readCatchHandler(int i) {
            int readSleb128 = readSleb128();
            int abs = Math.abs(readSleb128);
            int[] iArr = new int[abs];
            int[] iArr2 = new int[abs];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= abs) {
                    break;
                }
                iArr[i3] = readUleb128();
                iArr2[i3] = readUleb128();
                i2 = i3 + 1;
            }
            return new Code.CatchHandler(iArr, iArr2, readSleb128 <= 0 ? readUleb128() : -1, i);
        }

        private Code.CatchHandler[] readCatchHandlers() {
            int position = this.data.position();
            int readUleb128 = readUleb128();
            Code.CatchHandler[] catchHandlerArr = new Code.CatchHandler[readUleb128];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readUleb128) {
                    return catchHandlerArr;
                }
                catchHandlerArr[i2] = readCatchHandler(this.data.position() - position);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ClassData readClassData() {
            return new ClassData(readFields(readUleb128()), readFields(readUleb128()), readMethods(readUleb128()), readMethods(readUleb128()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Code readCode() {
            Code.Try[] tryArr;
            Code.CatchHandler[] catchHandlerArr;
            int readUnsignedShort = readUnsignedShort();
            int readUnsignedShort2 = readUnsignedShort();
            int readUnsignedShort3 = readUnsignedShort();
            int readUnsignedShort4 = readUnsignedShort();
            int readInt = readInt();
            short[] readShortArray = readShortArray(readInt());
            if (readUnsignedShort4 > 0) {
                if (readShortArray.length % 2 == 1) {
                    readShort();
                }
                Section open = Dex.this.open(this.data.position());
                skip(readUnsignedShort4 * 8);
                catchHandlerArr = readCatchHandlers();
                tryArr = open.readTries(readUnsignedShort4, catchHandlerArr);
            } else {
                tryArr = new Code.Try[0];
                catchHandlerArr = new Code.CatchHandler[0];
            }
            return new Code(readUnsignedShort, readUnsignedShort2, readUnsignedShort3, readInt, readShortArray, tryArr, catchHandlerArr);
        }

        private ClassData.Field[] readFields(int i) {
            ClassData.Field[] fieldArr = new ClassData.Field[i];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i) {
                    return fieldArr;
                }
                i2 += readUleb128();
                fieldArr[i4] = new ClassData.Field(i2, readUleb128());
                i3 = i4 + 1;
            }
        }

        private ClassData.Method[] readMethods(int i) {
            ClassData.Method[] methodArr = new ClassData.Method[i];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i) {
                    return methodArr;
                }
                i2 += readUleb128();
                methodArr[i4] = new ClassData.Method(i2, readUleb128(), readUleb128());
                i3 = i4 + 1;
            }
        }

        private Code.Try[] readTries(int i, Code.CatchHandler[] catchHandlerArr) {
            Code.Try[] tryArr = new Code.Try[i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return tryArr;
                }
                tryArr[i3] = new Code.Try(readInt(), readUnsignedShort(), findCatchHandlerIndex(catchHandlerArr, readUnsignedShort()));
                i2 = i3 + 1;
            }
        }

        public void alignToFourBytes() {
            this.data.position((this.data.position() + 3) & (-4));
        }

        public void alignToFourBytesWithZeroFill() {
            while ((this.data.position() & 3) != 0) {
                this.data.put((byte) 0);
            }
        }

        public void assertFourByteAligned() {
            if ((this.data.position() & 3) != 0) {
                throw new IllegalStateException("Not four byte aligned!");
            }
        }

        public int getPosition() {
            return this.data.position();
        }

        public Annotation readAnnotation() {
            byte readByte = readByte();
            int position = this.data.position();
            new EncodedValueReader(this, 29).skipValue();
            return new Annotation(Dex.this, readByte, new EncodedValue(getBytesFrom(position)));
        }

        @Override // com.android.dex.util.ByteInput
        public byte readByte() {
            return this.data.get();
        }

        public byte[] readByteArray(int i) {
            byte[] bArr = new byte[i];
            this.data.get(bArr);
            return bArr;
        }

        public ClassDef readClassDef() {
            return new ClassDef(Dex.this, getPosition(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt());
        }

        public EncodedValue readEncodedArray() {
            int position = this.data.position();
            new EncodedValueReader(this, 28).skipValue();
            return new EncodedValue(getBytesFrom(position));
        }

        public FieldId readFieldId() {
            return new FieldId(Dex.this, readUnsignedShort(), readUnsignedShort(), readInt());
        }

        public int readInt() {
            return this.data.getInt();
        }

        public MethodId readMethodId() {
            return new MethodId(Dex.this, readUnsignedShort(), readUnsignedShort(), readInt());
        }

        public ProtoId readProtoId() {
            return new ProtoId(Dex.this, readInt(), readInt(), readInt());
        }

        public short readShort() {
            return this.data.getShort();
        }

        public short[] readShortArray(int i) {
            short[] sArr;
            if (i != 0) {
                short[] sArr2 = new short[i];
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    sArr = sArr2;
                    if (i3 >= i) {
                        break;
                    }
                    sArr2[i3] = readShort();
                    i2 = i3 + 1;
                }
            } else {
                sArr = Dex.EMPTY_SHORT_ARRAY;
            }
            return sArr;
        }

        public int readSleb128() {
            return Leb128.readSignedLeb128(this);
        }

        public String readString() {
            int readInt = readInt();
            int position = this.data.position();
            int limit = this.data.limit();
            this.data.position(readInt);
            this.data.limit(this.data.capacity());
            try {
                try {
                    int readUleb128 = readUleb128();
                    String decode = Mutf8.decode(this, new char[readUleb128]);
                    if (decode.length() != readUleb128) {
                        throw new DexException("Declared length " + readUleb128 + " doesn't match decoded length of " + decode.length());
                    }
                    return decode;
                } catch (UTFDataFormatException e) {
                    throw new DexException(e);
                }
            } finally {
                this.data.position(position);
                this.data.limit(limit);
            }
        }

        public TypeList readTypeList() {
            short[] readShortArray = readShortArray(readInt());
            alignToFourBytes();
            return new TypeList(Dex.this, readShortArray);
        }

        public int readUleb128() {
            return Leb128.readUnsignedLeb128(this);
        }

        public int readUleb128p1() {
            return Leb128.readUnsignedLeb128(this) - 1;
        }

        public int readUnsignedShort() {
            return readShort() & 65535;
        }

        public int remaining() {
            return this.data.remaining();
        }

        public void skip(int i) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }
            this.data.position(this.data.position() + i);
        }

        public int used() {
            return this.data.position() - this.initialPosition;
        }

        public void write(byte[] bArr) {
            this.data.put(bArr);
        }

        public void write(short[] sArr) {
            int length = sArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                writeShort(sArr[i2]);
                i = i2 + 1;
            }
        }

        @Override // com.android.dex.util.ByteOutput
        public void writeByte(int i) {
            this.data.put((byte) i);
        }

        public void writeInt(int i) {
            this.data.putInt(i);
        }

        public void writeShort(short s) {
            this.data.putShort(s);
        }

        public void writeSleb128(int i) {
            try {
                Leb128.writeSignedLeb128(this, i);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DexException("Section limit " + this.data.limit() + " exceeded by " + this.name);
            }
        }

        public void writeStringData(String str) {
            try {
                writeUleb128(str.length());
                write(Mutf8.encode(str));
                writeByte(0);
            } catch (UTFDataFormatException e) {
                throw new AssertionError();
            }
        }

        public void writeTypeList(TypeList typeList) {
            short[] types = typeList.getTypes();
            writeInt(types.length);
            int length = types.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    alignToFourBytesWithZeroFill();
                    return;
                } else {
                    writeShort(types[i2]);
                    i = i2 + 1;
                }
            }
        }

        public void writeUleb128(int i) {
            try {
                Leb128.writeUnsignedLeb128(this, i);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DexException("Section limit " + this.data.limit() + " exceeded by " + this.name);
            }
        }

        public void writeUleb128p1(int i) {
            writeUleb128(i + 1);
        }

        public void writeUnsignedShort(int i) {
            short s = (short) i;
            if (i != (65535 & s)) {
                throw new IllegalArgumentException("Expected an unsigned short: " + i);
            }
            writeShort(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex$StringTable.class */
    public final class StringTable extends AbstractList<String> implements RandomAccess {
        private StringTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public String get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.stringIds.size);
            return Dex.this.open(Dex.this.tableOfContents.stringIds.off + (i * 4)).readString();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Dex.this.tableOfContents.stringIds.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex$TypeIndexToDescriptorIndexTable.class */
    public final class TypeIndexToDescriptorIndexTable extends AbstractList<Integer> implements RandomAccess {
        private TypeIndexToDescriptorIndexTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i) {
            return Integer.valueOf(Dex.this.descriptorIndexFromTypeIndex(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Dex.this.tableOfContents.typeIds.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/Dex$TypeIndexToDescriptorTable.class */
    public final class TypeIndexToDescriptorTable extends AbstractList<String> implements RandomAccess {
        private TypeIndexToDescriptorTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public String get(int i) {
            return Dex.this.strings.get(Dex.this.descriptorIndexFromTypeIndex(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Dex.this.tableOfContents.typeIds.size;
        }
    }

    public Dex(int i) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.nextSectionStart = 0;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.data = ByteBuffer.wrap(new byte[i]);
        this.data.order(ByteOrder.LITTLE_ENDIAN);
    }

    public Dex(File file) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.nextSectionStart = 0;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        if (!FileUtils.hasArchiveSuffix(file.getName())) {
            if (!file.getName().endsWith(".dex")) {
                throw new DexException("unknown output extension: " + file);
            }
            loadFrom(new FileInputStream(file));
            return;
        }
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = zipFile.getEntry(DexFormat.DEX_IN_JAR_NAME);
        if (entry == null) {
            throw new DexException("Expected classes.dex in " + file);
        }
        loadFrom(zipFile.getInputStream(entry));
        zipFile.close();
    }

    public Dex(InputStream inputStream) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.nextSectionStart = 0;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        loadFrom(inputStream);
    }

    private Dex(ByteBuffer byteBuffer) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.nextSectionStart = 0;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.data = byteBuffer;
        this.data.order(ByteOrder.LITTLE_ENDIAN);
        this.tableOfContents.readFrom(this);
    }

    public Dex(byte[] bArr) throws IOException {
        this(ByteBuffer.wrap(bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkBounds(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    public static Dex create(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer byteBuffer2 = byteBuffer;
        if (byteBuffer.get(0) == 100) {
            byteBuffer2 = byteBuffer;
            if (byteBuffer.get(1) == 101) {
                byteBuffer2 = byteBuffer;
                if (byteBuffer.get(2) == 121) {
                    byteBuffer2 = byteBuffer;
                    if (byteBuffer.get(3) == 10) {
                        byteBuffer.position(8);
                        int i = byteBuffer.getInt();
                        int i2 = byteBuffer.getInt();
                        byteBuffer.position(i);
                        byteBuffer.limit(i + i2);
                        byteBuffer2 = byteBuffer.slice();
                    }
                }
            }
        }
        return new Dex(byteBuffer2);
    }

    private void loadFrom(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                inputStream.close();
                this.data = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                this.data.order(ByteOrder.LITTLE_ENDIAN);
                this.tableOfContents.readFrom(this);
                return;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public int annotationDirectoryOffsetFromClassDefIndex(int i) {
        checkBounds(i, this.tableOfContents.classDefs.size);
        return this.data.getInt(this.tableOfContents.classDefs.off + (i * 32) + 4 + 4 + 4 + 4 + 4);
    }

    public Section appendSection(int i, String str) {
        if ((i & 3) != 0) {
            throw new IllegalStateException("Not four byte aligned!");
        }
        int i2 = this.nextSectionStart + i;
        ByteBuffer duplicate = this.data.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(this.nextSectionStart);
        duplicate.limit(i2);
        Section section = new Section(str, duplicate);
        this.nextSectionStart = i2;
        return section;
    }

    public Iterable<ClassDef> classDefs() {
        return new ClassDefIterable();
    }

    public int computeChecksum() throws IOException {
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.data.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(bArr.length, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        return (int) adler32.getValue();
    }

    public byte[] computeSignature() throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer duplicate = this.data.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(bArr.length, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                messageDigest.update(bArr, 0, min);
            }
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public int declaringClassIndexFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        return this.data.getShort(this.tableOfContents.methodIds.off + (i * 8)) & 65535;
    }

    public int descriptorIndexFromTypeIndex(int i) {
        checkBounds(i, this.tableOfContents.typeIds.size);
        return this.data.getInt(this.tableOfContents.typeIds.off + (i * 4));
    }

    public List<FieldId> fieldIds() {
        return this.fieldIds;
    }

    public int findClassDefIndexFromTypeIndex(int i) {
        int i2;
        checkBounds(i, this.tableOfContents.typeIds.size);
        if (this.tableOfContents.classDefs.exists()) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.tableOfContents.classDefs.size) {
                    return -1;
                }
                i2 = i4;
                if (typeIndexFromClassDefIndex(i4) == i) {
                    break;
                }
                i3 = i4 + 1;
            }
        } else {
            i2 = -1;
        }
        return i2;
    }

    public int findFieldIndex(FieldId fieldId) {
        return Collections.binarySearch(this.fieldIds, fieldId);
    }

    public int findMethodIndex(MethodId methodId) {
        return Collections.binarySearch(this.methodIds, methodId);
    }

    public int findStringIndex(String str) {
        return Collections.binarySearch(this.strings, str);
    }

    public int findTypeIndex(String str) {
        return Collections.binarySearch(this.typeNames, str);
    }

    public byte[] getBytes() {
        ByteBuffer duplicate = this.data.duplicate();
        byte[] bArr = new byte[duplicate.capacity()];
        duplicate.position(0);
        duplicate.get(bArr);
        return bArr;
    }

    public int getLength() {
        return this.data.capacity();
    }

    public int getNextSectionStart() {
        return this.nextSectionStart;
    }

    public TableOfContents getTableOfContents() {
        return this.tableOfContents;
    }

    public short[] interfaceTypeIndicesFromClassDefIndex(int i) {
        short[] sArr;
        checkBounds(i, this.tableOfContents.classDefs.size);
        int i2 = this.data.getInt(this.tableOfContents.classDefs.off + (i * 32) + 4 + 4 + 4);
        if (i2 != 0) {
            int i3 = this.data.getInt(i2);
            if (i3 > 0) {
                int i4 = i2 + 4;
                short[] sArr2 = new short[i3];
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    sArr = sArr2;
                    if (i6 >= i3) {
                        break;
                    }
                    sArr2[i6] = this.data.getShort(i4);
                    i4 += 2;
                    i5 = i6 + 1;
                }
            } else {
                throw new AssertionError("Unexpected interfaces list size: " + i3);
            }
        } else {
            sArr = EMPTY_SHORT_ARRAY;
        }
        return sArr;
    }

    public List<MethodId> methodIds() {
        return this.methodIds;
    }

    public int nameIndexFromFieldIndex(int i) {
        checkBounds(i, this.tableOfContents.fieldIds.size);
        return this.data.getInt(this.tableOfContents.fieldIds.off + (i * 8) + 2 + 2);
    }

    public int nameIndexFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        return this.data.getInt(this.tableOfContents.methodIds.off + (i * 8) + 2 + 2);
    }

    public Section open(int i) {
        if (i < 0 || i >= this.data.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.data.capacity());
        }
        ByteBuffer duplicate = this.data.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(this.data.capacity());
        return new Section("section", duplicate);
    }

    public short[] parameterTypeIndicesFromMethodIndex(int i) {
        short[] sArr;
        checkBounds(i, this.tableOfContents.methodIds.size);
        int i2 = this.data.getShort(this.tableOfContents.methodIds.off + (i * 8) + 2) & 65535;
        checkBounds(i2, this.tableOfContents.protoIds.size);
        int i3 = this.data.getInt(this.tableOfContents.protoIds.off + (i2 * 12) + 4 + 4);
        if (i3 != 0) {
            int i4 = this.data.getInt(i3);
            if (i4 > 0) {
                int i5 = i3 + 4;
                short[] sArr2 = new short[i4];
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    sArr = sArr2;
                    if (i7 >= i4) {
                        break;
                    }
                    sArr2[i7] = this.data.getShort(i5);
                    i5 += 2;
                    i6 = i7 + 1;
                }
            } else {
                throw new AssertionError("Unexpected parameter type list size: " + i4);
            }
        } else {
            sArr = EMPTY_SHORT_ARRAY;
        }
        return sArr;
    }

    public List<ProtoId> protoIds() {
        return this.protoIds;
    }

    public ClassData readClassData(ClassDef classDef) {
        int classDataOffset = classDef.getClassDataOffset();
        if (classDataOffset == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        return open(classDataOffset).readClassData();
    }

    public Code readCode(ClassData.Method method) {
        int codeOffset = method.getCodeOffset();
        if (codeOffset == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        return open(codeOffset).readCode();
    }

    public TypeList readTypeList(int i) {
        return i == 0 ? TypeList.EMPTY : open(i).readTypeList();
    }

    public int returnTypeIndexFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        int i2 = this.data.getShort(this.tableOfContents.methodIds.off + (i * 8) + 2) & 65535;
        checkBounds(i2, this.tableOfContents.protoIds.size);
        return this.data.getInt(this.tableOfContents.protoIds.off + (i2 * 12) + 4);
    }

    public List<String> strings() {
        return this.strings;
    }

    public List<Integer> typeIds() {
        return this.typeIds;
    }

    public int typeIndexFromClassDefIndex(int i) {
        checkBounds(i, this.tableOfContents.classDefs.size);
        return this.data.getInt(this.tableOfContents.classDefs.off + (i * 32));
    }

    public int typeIndexFromFieldIndex(int i) {
        checkBounds(i, this.tableOfContents.fieldIds.size);
        return this.data.getShort(this.tableOfContents.fieldIds.off + (i * 8) + 2) & 65535;
    }

    public List<String> typeNames() {
        return this.typeNames;
    }

    public void writeHashes() throws IOException {
        open(12).write(computeSignature());
        open(8).writeInt(computeChecksum());
    }

    public void writeTo(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        writeTo(fileOutputStream);
        fileOutputStream.close();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.data.duplicate();
        duplicate.clear();
        while (duplicate.hasRemaining()) {
            int min = Math.min(bArr.length, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            outputStream.write(bArr, 0, min);
        }
    }
}
