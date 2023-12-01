package com.tencent.tinker.android.dex.io;

import com.tencent.tinker.android.dex.Annotation;
import com.tencent.tinker.android.dex.AnnotationSet;
import com.tencent.tinker.android.dex.AnnotationSetRefList;
import com.tencent.tinker.android.dex.AnnotationsDirectory;
import com.tencent.tinker.android.dex.ClassData;
import com.tencent.tinker.android.dex.ClassDef;
import com.tencent.tinker.android.dex.Code;
import com.tencent.tinker.android.dex.DebugInfoItem;
import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dex.EncodedValue;
import com.tencent.tinker.android.dex.EncodedValueReader;
import com.tencent.tinker.android.dex.FieldId;
import com.tencent.tinker.android.dex.Leb128;
import com.tencent.tinker.android.dex.MethodId;
import com.tencent.tinker.android.dex.Mutf8;
import com.tencent.tinker.android.dex.ProtoId;
import com.tencent.tinker.android.dex.SizeOf;
import com.tencent.tinker.android.dex.StringData;
import com.tencent.tinker.android.dex.TypeList;
import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.ByteOutput;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/io/DexDataBuffer.class */
public class DexDataBuffer implements ByteInput, ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 512;
    private ByteBuffer data;
    private int dataBound;
    private boolean isResizeAllowed;
    private static final short[] EMPTY_SHORT_ARRAY = new short[0];
    private static final Code.Try[] EMPTY_TRY_ARRAY = new Code.Try[0];
    private static final Code.CatchHandler[] EMPTY_CATCHHANDLER_ARRAY = new Code.CatchHandler[0];

    public DexDataBuffer() {
        ByteBuffer allocate = ByteBuffer.allocate(512);
        this.data = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.dataBound = this.data.position();
        ByteBuffer byteBuffer = this.data;
        byteBuffer.limit(byteBuffer.capacity());
        this.isResizeAllowed = true;
    }

    public DexDataBuffer(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.dataBound = byteBuffer.limit();
        this.isResizeAllowed = false;
    }

    public DexDataBuffer(ByteBuffer byteBuffer, boolean z) {
        this.data = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.dataBound = byteBuffer.limit();
        this.isResizeAllowed = z;
    }

    private void ensureBufferSize(int i) {
        if (this.data.position() + i <= this.data.limit() || !this.isResizeAllowed) {
            return;
        }
        byte[] array = this.data.array();
        byte[] bArr = new byte[array.length + i + (array.length >> 1)];
        System.arraycopy(array, 0, bArr, 0, this.data.position());
        int position = this.data.position();
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.data = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.data.position(position);
        ByteBuffer byteBuffer = this.data;
        byteBuffer.limit(byteBuffer.capacity());
    }

    private int findCatchHandlerIndex(Code.CatchHandler[] catchHandlerArr, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= catchHandlerArr.length) {
                throw new IllegalArgumentException();
            }
            if (catchHandlerArr[i3].offset == i) {
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

    private ClassData.Field[] readFields(int i) {
        ClassData.Field[] fieldArr = new ClassData.Field[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += readUleb128();
            fieldArr[i3] = new ClassData.Field(i2, readUleb128());
        }
        return fieldArr;
    }

    private ClassData.Method[] readMethods(int i) {
        ClassData.Method[] methodArr = new ClassData.Method[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += readUleb128();
            methodArr[i3] = new ClassData.Method(i2, readUleb128(), readUleb128());
        }
        return methodArr;
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

    private void writeCatchHandler(Code.CatchHandler catchHandler) {
        int i = catchHandler.catchAllAddress;
        int[] iArr = catchHandler.typeIndexes;
        int[] iArr2 = catchHandler.addresses;
        if (i != -1) {
            writeSleb128(-iArr.length);
        } else {
            writeSleb128(iArr.length);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                break;
            }
            writeUleb128(iArr[i3]);
            writeUleb128(iArr2[i3]);
            i2 = i3 + 1;
        }
        if (i != -1) {
            writeUleb128(i);
        }
    }

    private int[] writeCatchHandlers(Code.CatchHandler[] catchHandlerArr) {
        int position = this.data.position();
        writeUleb128(catchHandlerArr.length);
        int[] iArr = new int[catchHandlerArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= catchHandlerArr.length) {
                return iArr;
            }
            iArr[i2] = this.data.position() - position;
            writeCatchHandler(catchHandlerArr[i2]);
            i = i2 + 1;
        }
    }

    private void writeFields(ClassData.Field[] fieldArr) {
        int i = 0;
        for (ClassData.Field field : fieldArr) {
            writeUleb128(field.fieldIndex - i);
            i = field.fieldIndex;
            writeUleb128(field.accessFlags);
        }
    }

    private void writeMethods(ClassData.Method[] methodArr) {
        int i = 0;
        for (ClassData.Method method : methodArr) {
            writeUleb128(method.methodIndex - i);
            i = method.methodIndex;
            writeUleb128(method.accessFlags);
            writeUleb128(method.codeOffset);
        }
    }

    private void writeTries(Code.Try[] tryArr, int[] iArr) {
        int length = tryArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Code.Try r0 = tryArr[i2];
            writeInt(r0.startAddress);
            writeUnsignedShort(r0.instructionCount);
            writeUnsignedShort(iArr[r0.catchHandlerIndex]);
            i = i2 + 1;
        }
    }

    public void alignToFourBytes() {
        ByteBuffer byteBuffer = this.data;
        byteBuffer.position((byteBuffer.position() + 3) & (-4));
    }

    public void alignToFourBytesWithZeroFill() {
        ensureBufferSize((SizeOf.roundToTimesOfFour(this.data.position()) - this.data.position()) * 1);
        while ((this.data.position() & 3) != 0) {
            this.data.put((byte) 0);
        }
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public byte[] array() {
        byte[] bArr = new byte[this.dataBound];
        System.arraycopy(this.data.array(), 0, bArr, 0, this.dataBound);
        return bArr;
    }

    public int available() {
        return this.dataBound - this.data.position();
    }

    public int position() {
        return this.data.position();
    }

    public void position(int i) {
        this.data.position(i);
    }

    public Annotation readAnnotation() {
        int position = this.data.position();
        byte readByte = readByte();
        int position2 = this.data.position();
        new EncodedValueReader(this, 29).skipValue();
        return new Annotation(position, readByte, new EncodedValue(position2, getBytesFrom(position2)));
    }

    public AnnotationSet readAnnotationSet() {
        int position = this.data.position();
        int readInt = readInt();
        int[] iArr = new int[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return new AnnotationSet(position, iArr);
            }
            iArr[i2] = readInt();
            i = i2 + 1;
        }
    }

    public AnnotationSetRefList readAnnotationSetRefList() {
        int position = this.data.position();
        int readInt = readInt();
        int[] iArr = new int[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return new AnnotationSetRefList(position, iArr);
            }
            iArr[i2] = readInt();
            i = i2 + 1;
        }
    }

    public AnnotationsDirectory readAnnotationsDirectory() {
        int position = this.data.position();
        int readInt = readInt();
        int readInt2 = readInt();
        int readInt3 = readInt();
        int readInt4 = readInt();
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, readInt2, 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt2) {
                break;
            }
            iArr[i2][0] = readInt();
            iArr[i2][1] = readInt();
            i = i2 + 1;
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, readInt3, 2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= readInt3) {
                break;
            }
            iArr2[i4][0] = readInt();
            iArr2[i4][1] = readInt();
            i3 = i4 + 1;
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, readInt4, 2);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= readInt4) {
                return new AnnotationsDirectory(position, readInt, iArr, iArr2, iArr3);
            }
            iArr3[i6][0] = readInt();
            iArr3[i6][1] = readInt();
            i5 = i6 + 1;
        }
    }

    @Override // com.tencent.tinker.android.dex.util.ByteInput
    public byte readByte() {
        return this.data.get();
    }

    public byte[] readByteArray(int i) {
        byte[] bArr = new byte[i];
        this.data.get(bArr);
        return bArr;
    }

    public ClassData readClassData() {
        return new ClassData(this.data.position(), readFields(readUleb128()), readFields(readUleb128()), readMethods(readUleb128()), readMethods(readUleb128()));
    }

    public ClassDef readClassDef() {
        return new ClassDef(position(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt());
    }

    public Code readCode() {
        Code.CatchHandler[] catchHandlerArr;
        Code.Try[] tryArr;
        int position = this.data.position();
        int readUnsignedShort = readUnsignedShort();
        int readUnsignedShort2 = readUnsignedShort();
        int readUnsignedShort3 = readUnsignedShort();
        int readUnsignedShort4 = readUnsignedShort();
        int readInt = readInt();
        short[] readShortArray = readShortArray(readInt());
        if (readUnsignedShort4 > 0) {
            if ((readShortArray.length & 1) == 1) {
                skip(2);
            }
            int position2 = this.data.position();
            skip(readUnsignedShort4 * 8);
            Code.CatchHandler[] readCatchHandlers = readCatchHandlers();
            int position3 = this.data.position();
            this.data.position(position2);
            tryArr = readTries(readUnsignedShort4, readCatchHandlers);
            this.data.position(position3);
            catchHandlerArr = readCatchHandlers;
        } else {
            Code.Try[] tryArr2 = EMPTY_TRY_ARRAY;
            catchHandlerArr = EMPTY_CATCHHANDLER_ARRAY;
            tryArr = tryArr2;
        }
        return new Code(position, readUnsignedShort, readUnsignedShort2, readUnsignedShort3, readInt, readShortArray, tryArr, catchHandlerArr);
    }

    public DebugInfoItem readDebugInfoItem() {
        final ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        int position = this.data.position();
        int readUleb128 = readUleb128();
        int readUleb1282 = readUleb128();
        int[] iArr = new int[readUleb1282];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readUleb1282) {
                break;
            }
            iArr[i2] = readUleb128p1();
            i = i2 + 1;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(64);
        } catch (Throwable th2) {
            byteArrayOutputStream = null;
            th = th2;
        }
        try {
            ByteOutput byteOutput = new ByteOutput() { // from class: com.tencent.tinker.android.dex.io.DexDataBuffer.1
                @Override // com.tencent.tinker.android.dex.util.ByteOutput
                public void writeByte(int i3) {
                    byteArrayOutputStream.write(i3);
                }
            };
            while (true) {
                byte readByte = readByte();
                byteArrayOutputStream.write(readByte);
                if (readByte != 9) {
                    switch (readByte) {
                        case 0:
                            DebugInfoItem debugInfoItem = new DebugInfoItem(position, readUleb128, iArr, byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayOutputStream.close();
                                return debugInfoItem;
                            } catch (Exception e) {
                                return debugInfoItem;
                            }
                        case 1:
                            Leb128.writeUnsignedLeb128(byteOutput, readUleb128());
                            continue;
                        case 2:
                            Leb128.writeSignedLeb128(byteOutput, readSleb128());
                            continue;
                        case 3:
                        case 4:
                            Leb128.writeUnsignedLeb128(byteOutput, readUleb128());
                            Leb128.writeUnsignedLeb128p1(byteOutput, readUleb128p1());
                            Leb128.writeUnsignedLeb128p1(byteOutput, readUleb128p1());
                            if (readByte == 4) {
                                Leb128.writeUnsignedLeb128p1(byteOutput, readUleb128p1());
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                        case 6:
                            Leb128.writeUnsignedLeb128(byteOutput, readUleb128());
                            continue;
                    }
                } else {
                    Leb128.writeUnsignedLeb128p1(byteOutput, readUleb128p1());
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
            }
            throw th;
        }
    }

    public EncodedValue readEncodedArray() {
        int position = this.data.position();
        new EncodedValueReader(this, 28).skipValue();
        return new EncodedValue(position, getBytesFrom(position));
    }

    public FieldId readFieldId() {
        return new FieldId(this.data.position(), readUnsignedShort(), readUnsignedShort(), readInt());
    }

    public int readInt() {
        return this.data.getInt();
    }

    public MethodId readMethodId() {
        return new MethodId(this.data.position(), readUnsignedShort(), readUnsignedShort(), readInt());
    }

    public ProtoId readProtoId() {
        return new ProtoId(this.data.position(), readInt(), readInt(), readInt());
    }

    public short readShort() {
        return this.data.getShort();
    }

    public short[] readShortArray(int i) {
        if (i == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return sArr;
            }
            sArr[i3] = readShort();
            i2 = i3 + 1;
        }
    }

    public int readSleb128() {
        return Leb128.readSignedLeb128(this);
    }

    public StringData readStringData() {
        int position = this.data.position();
        try {
            int readUleb128 = readUleb128();
            String decode = Mutf8.decode(this, new char[readUleb128]);
            if (decode.length() == readUleb128) {
                return new StringData(position, decode);
            }
            throw new DexException("Declared length " + readUleb128 + " doesn't match decoded length of " + decode.length());
        } catch (UTFDataFormatException e) {
            throw new DexException(e);
        }
    }

    public TypeList readTypeList() {
        return new TypeList(this.data.position(), readShortArray(readInt()));
    }

    public int readUleb128() {
        return Leb128.readUnsignedLeb128(this);
    }

    public int readUleb128p1() {
        return Leb128.readUnsignedLeb128(this) - 1;
    }

    public int readUnsignedByte() {
        return readByte() & 255;
    }

    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    public void skip(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        ByteBuffer byteBuffer = this.data;
        byteBuffer.position(byteBuffer.position() + i);
    }

    public void skipWithAutoExpand(int i) {
        ensureBufferSize(i * 1);
        skip(i);
    }

    public void write(byte[] bArr) {
        ensureBufferSize(bArr.length * 1);
        this.data.put(bArr);
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public void write(short[] sArr) {
        ensureBufferSize(sArr.length * 2);
        int length = sArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            writeShort(sArr[i2]);
            i = i2 + 1;
        }
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public int writeAnnotation(Annotation annotation) {
        int position = this.data.position();
        writeByte(annotation.visibility);
        writeEncodedArray(annotation.encodedAnnotation);
        return position;
    }

    public int writeAnnotationSet(AnnotationSet annotationSet) {
        int position = this.data.position();
        writeInt(annotationSet.annotationOffsets.length);
        int[] iArr = annotationSet.annotationOffsets;
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return position;
            }
            writeInt(iArr[i2]);
            i = i2 + 1;
        }
    }

    public int writeAnnotationSetRefList(AnnotationSetRefList annotationSetRefList) {
        int position = this.data.position();
        writeInt(annotationSetRefList.annotationSetRefItems.length);
        int[] iArr = annotationSetRefList.annotationSetRefItems;
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return position;
            }
            writeInt(iArr[i2]);
            i = i2 + 1;
        }
    }

    public int writeAnnotationsDirectory(AnnotationsDirectory annotationsDirectory) {
        int position = this.data.position();
        writeInt(annotationsDirectory.classAnnotationsOffset);
        writeInt(annotationsDirectory.fieldAnnotations.length);
        writeInt(annotationsDirectory.methodAnnotations.length);
        writeInt(annotationsDirectory.parameterAnnotations.length);
        int[][] iArr = annotationsDirectory.fieldAnnotations;
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            int[] iArr2 = iArr[i2];
            writeInt(iArr2[0]);
            writeInt(iArr2[1]);
            i = i2 + 1;
        }
        int[][] iArr3 = annotationsDirectory.methodAnnotations;
        int length2 = iArr3.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                break;
            }
            int[] iArr4 = iArr3[i4];
            writeInt(iArr4[0]);
            writeInt(iArr4[1]);
            i3 = i4 + 1;
        }
        int[][] iArr5 = annotationsDirectory.parameterAnnotations;
        int length3 = iArr5.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length3) {
                return position;
            }
            int[] iArr6 = iArr5[i6];
            writeInt(iArr6[0]);
            writeInt(iArr6[1]);
            i5 = i6 + 1;
        }
    }

    @Override // com.tencent.tinker.android.dex.util.ByteOutput
    public void writeByte(int i) {
        ensureBufferSize(1);
        this.data.put((byte) i);
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public int writeClassData(ClassData classData) {
        int position = this.data.position();
        writeUleb128(classData.staticFields.length);
        writeUleb128(classData.instanceFields.length);
        writeUleb128(classData.directMethods.length);
        writeUleb128(classData.virtualMethods.length);
        writeFields(classData.staticFields);
        writeFields(classData.instanceFields);
        writeMethods(classData.directMethods);
        writeMethods(classData.virtualMethods);
        return position;
    }

    public int writeClassDef(ClassDef classDef) {
        int position = this.data.position();
        writeInt(classDef.typeIndex);
        writeInt(classDef.accessFlags);
        writeInt(classDef.supertypeIndex);
        writeInt(classDef.interfacesOffset);
        writeInt(classDef.sourceFileIndex);
        writeInt(classDef.annotationsOffset);
        writeInt(classDef.classDataOffset);
        writeInt(classDef.staticValuesOffset);
        return position;
    }

    public int writeCode(Code code) {
        int position = this.data.position();
        writeUnsignedShort(code.registersSize);
        writeUnsignedShort(code.insSize);
        writeUnsignedShort(code.outsSize);
        writeUnsignedShort(code.tries.length);
        writeInt(code.debugInfoOffset);
        writeInt(code.instructions.length);
        write(code.instructions);
        if (code.tries.length > 0) {
            if ((code.instructions.length & 1) == 1) {
                writeShort((short) 0);
            }
            int position2 = this.data.position();
            skipWithAutoExpand(code.tries.length * 8);
            int[] writeCatchHandlers = writeCatchHandlers(code.catchHandlers);
            int position3 = this.data.position();
            this.data.position(position2);
            writeTries(code.tries, writeCatchHandlers);
            this.data.position(position3);
        }
        return position;
    }

    public int writeDebugInfoItem(DebugInfoItem debugInfoItem) {
        int position = this.data.position();
        writeUleb128(debugInfoItem.lineStart);
        int length = debugInfoItem.parameterNames.length;
        writeUleb128(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                write(debugInfoItem.infoSTM);
                return position;
            }
            writeUleb128p1(debugInfoItem.parameterNames[i2]);
            i = i2 + 1;
        }
    }

    public int writeEncodedArray(EncodedValue encodedValue) {
        int position = this.data.position();
        write(encodedValue.data);
        return position;
    }

    public int writeFieldId(FieldId fieldId) {
        int position = this.data.position();
        writeUnsignedShort(fieldId.declaringClassIndex);
        writeUnsignedShort(fieldId.typeIndex);
        writeInt(fieldId.nameIndex);
        return position;
    }

    public void writeInt(int i) {
        ensureBufferSize(4);
        this.data.putInt(i);
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public int writeMethodId(MethodId methodId) {
        int position = this.data.position();
        writeUnsignedShort(methodId.declaringClassIndex);
        writeUnsignedShort(methodId.protoIndex);
        writeInt(methodId.nameIndex);
        return position;
    }

    public int writeProtoId(ProtoId protoId) {
        int position = this.data.position();
        writeInt(protoId.shortyIndex);
        writeInt(protoId.returnTypeIndex);
        writeInt(protoId.parametersOffset);
        return position;
    }

    public void writeShort(short s) {
        ensureBufferSize(2);
        this.data.putShort(s);
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public void writeSleb128(int i) {
        Leb128.writeSignedLeb128(this, i);
    }

    public int writeStringData(StringData stringData) {
        int position = this.data.position();
        try {
            writeUleb128(stringData.value.length());
            write(Mutf8.encode(stringData.value));
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e) {
            throw new AssertionError(e);
        }
    }

    public int writeTypeList(TypeList typeList) {
        int position = this.data.position();
        short[] sArr = typeList.types;
        writeInt(sArr.length);
        int length = sArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return position;
            }
            writeShort(sArr[i2]);
            i = i2 + 1;
        }
    }

    public void writeUleb128(int i) {
        Leb128.writeUnsignedLeb128(this, i);
    }

    public void writeUleb128p1(int i) {
        writeUleb128(i + 1);
    }

    public void writeUnsignedShort(int i) {
        short s = (short) i;
        if (i == (65535 & s)) {
            writeShort(s);
            return;
        }
        throw new IllegalArgumentException("Expected an unsigned short: " + i);
    }
}
