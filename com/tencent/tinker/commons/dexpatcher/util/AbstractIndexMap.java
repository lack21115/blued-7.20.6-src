package com.tencent.tinker.commons.dexpatcher.util;

import com.tencent.tinker.android.dex.Annotation;
import com.tencent.tinker.android.dex.AnnotationSet;
import com.tencent.tinker.android.dex.AnnotationSetRefList;
import com.tencent.tinker.android.dex.AnnotationsDirectory;
import com.tencent.tinker.android.dex.ClassData;
import com.tencent.tinker.android.dex.ClassDef;
import com.tencent.tinker.android.dex.Code;
import com.tencent.tinker.android.dex.DebugInfoItem;
import com.tencent.tinker.android.dex.EncodedValue;
import com.tencent.tinker.android.dex.EncodedValueReader;
import com.tencent.tinker.android.dex.FieldId;
import com.tencent.tinker.android.dex.Leb128;
import com.tencent.tinker.android.dex.MethodId;
import com.tencent.tinker.android.dex.ProtoId;
import com.tencent.tinker.android.dex.TypeList;
import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.ByteOutput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/util/AbstractIndexMap.class */
public abstract class AbstractIndexMap {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/util/AbstractIndexMap$EncodedValueTransformer.class */
    final class EncodedValueTransformer {
        private final ByteOutput out;

        EncodedValueTransformer(ByteOutput byteOutput) {
            this.out = byteOutput;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformAnnotation(EncodedValueReader encodedValueReader) {
            int readAnnotation = encodedValueReader.readAnnotation();
            Leb128.writeUnsignedLeb128(this.out, AbstractIndexMap.this.adjustTypeIdIndex(encodedValueReader.getAnnotationType()));
            Leb128.writeUnsignedLeb128(this.out, readAnnotation);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readAnnotation) {
                    return;
                }
                Leb128.writeUnsignedLeb128(this.out, AbstractIndexMap.this.adjustStringIndex(encodedValueReader.readAnnotationName()));
                transform(encodedValueReader);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformArray(EncodedValueReader encodedValueReader) {
            int readArray = encodedValueReader.readArray();
            Leb128.writeUnsignedLeb128(this.out, readArray);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readArray) {
                    return;
                }
                transform(encodedValueReader);
                i = i2 + 1;
            }
        }

        private void writeTypeAndArg(int i, int i2) {
            this.out.writeByte(i | (i2 << 5));
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public void transform(EncodedValueReader encodedValueReader) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    private Code.CatchHandler[] adjustCatchHandlers(Code.CatchHandler[] catchHandlerArr) {
        if (catchHandlerArr != null && catchHandlerArr.length != 0) {
            Code.CatchHandler[] catchHandlerArr2 = new Code.CatchHandler[catchHandlerArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= catchHandlerArr.length) {
                    return catchHandlerArr2;
                }
                Code.CatchHandler catchHandler = catchHandlerArr[i2];
                int length = catchHandler.typeIndexes.length;
                int[] iArr = new int[length];
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < length) {
                        iArr[i4] = adjustTypeIdIndex(catchHandler.typeIndexes[i4]);
                        i3 = i4 + 1;
                    }
                }
                catchHandlerArr2[i2] = new Code.CatchHandler(iArr, catchHandler.addresses, catchHandler.catchAllAddress, catchHandler.offset);
                i = i2 + 1;
            }
        }
        return catchHandlerArr;
    }

    private byte[] adjustDebugInfoItemSTM(byte[] bArr) {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteInput byteInput = new ByteInput() { // from class: com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap.1
            @Override // com.tencent.tinker.android.dex.util.ByteInput
            public byte readByte() {
                return (byte) (byteArrayInputStream.read() & 255);
            }
        };
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 512);
        ByteOutput byteOutput = new ByteOutput() { // from class: com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap.2
            @Override // com.tencent.tinker.android.dex.util.ByteOutput
            public void writeByte(int i) {
                byteArrayOutputStream.write(i);
            }
        };
        while (true) {
            int read = byteArrayInputStream.read() & 255;
            byteArrayOutputStream.write(read);
            if (read != 9) {
                switch (read) {
                    case 0:
                        return byteArrayOutputStream.toByteArray();
                    case 1:
                        Leb128.writeUnsignedLeb128(byteOutput, Leb128.readUnsignedLeb128(byteInput));
                        continue;
                    case 2:
                        Leb128.writeSignedLeb128(byteOutput, Leb128.readSignedLeb128(byteInput));
                        continue;
                    case 3:
                    case 4:
                        Leb128.writeUnsignedLeb128(byteOutput, Leb128.readUnsignedLeb128(byteInput));
                        Leb128.writeUnsignedLeb128p1(byteOutput, adjustStringIndex(Leb128.readUnsignedLeb128p1(byteInput)));
                        Leb128.writeUnsignedLeb128p1(byteOutput, adjustTypeIdIndex(Leb128.readUnsignedLeb128p1(byteInput)));
                        if (read == 4) {
                            Leb128.writeUnsignedLeb128p1(byteOutput, adjustStringIndex(Leb128.readUnsignedLeb128p1(byteInput)));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                    case 6:
                        Leb128.writeUnsignedLeb128(byteOutput, Leb128.readUnsignedLeb128(byteInput));
                        continue;
                }
            } else {
                Leb128.writeUnsignedLeb128p1(byteOutput, adjustStringIndex(Leb128.readUnsignedLeb128p1(byteInput)));
            }
        }
    }

    private ClassData.Field[] adjustFields(ClassData.Field[] fieldArr) {
        ClassData.Field[] fieldArr2 = new ClassData.Field[fieldArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fieldArr.length) {
                return fieldArr2;
            }
            ClassData.Field field = fieldArr[i2];
            fieldArr2[i2] = new ClassData.Field(adjustFieldIdIndex(field.fieldIndex), field.accessFlags);
            i = i2 + 1;
        }
    }

    private short[] adjustInstructions(short[] sArr) {
        short[] sArr2 = sArr;
        if (sArr != null) {
            if (sArr.length == 0) {
                return sArr;
            }
            sArr2 = new InstructionTransformer(this).transform(sArr);
        }
        return sArr2;
    }

    private ClassData.Method[] adjustMethods(ClassData.Method[] methodArr) {
        ClassData.Method[] methodArr2 = new ClassData.Method[methodArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= methodArr.length) {
                return methodArr2;
            }
            ClassData.Method method = methodArr[i2];
            methodArr2[i2] = new ClassData.Method(adjustMethodIdIndex(method.methodIndex), method.accessFlags, adjustCodeOffset(method.codeOffset));
            i = i2 + 1;
        }
    }

    private int[] adjustParameterNames(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return iArr2;
            }
            iArr2[i2] = adjustStringIndex(iArr[i2]);
            i = i2 + 1;
        }
    }

    public Annotation adjust(Annotation annotation) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(annotation.encodedAnnotation.data.length);
        new EncodedValueTransformer(new ByteOutput() { // from class: com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap.4
            @Override // com.tencent.tinker.android.dex.util.ByteOutput
            public void writeByte(int i) {
                byteArrayOutputStream.write(i);
            }
        }).transformAnnotation(annotation.getReader());
        return new Annotation(annotation.off, annotation.visibility, new EncodedValue(annotation.encodedAnnotation.off, byteArrayOutputStream.toByteArray()));
    }

    public AnnotationSet adjust(AnnotationSet annotationSet) {
        int length = annotationSet.annotationOffsets.length;
        int[] iArr = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new AnnotationSet(annotationSet.off, iArr);
            }
            iArr[i2] = adjustAnnotationOffset(annotationSet.annotationOffsets[i2]);
            i = i2 + 1;
        }
    }

    public AnnotationSetRefList adjust(AnnotationSetRefList annotationSetRefList) {
        int length = annotationSetRefList.annotationSetRefItems.length;
        int[] iArr = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new AnnotationSetRefList(annotationSetRefList.off, iArr);
            }
            iArr[i2] = adjustAnnotationSetOffset(annotationSetRefList.annotationSetRefItems[i2]);
            i = i2 + 1;
        }
    }

    public AnnotationsDirectory adjust(AnnotationsDirectory annotationsDirectory) {
        int adjustAnnotationSetOffset = adjustAnnotationSetOffset(annotationsDirectory.classAnnotationsOffset);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, annotationsDirectory.fieldAnnotations.length, 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2][0] = adjustFieldIdIndex(annotationsDirectory.fieldAnnotations[i2][0]);
            iArr[i2][1] = adjustAnnotationSetOffset(annotationsDirectory.fieldAnnotations[i2][1]);
            i = i2 + 1;
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, annotationsDirectory.methodAnnotations.length, 2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= iArr2.length) {
                break;
            }
            iArr2[i4][0] = adjustMethodIdIndex(annotationsDirectory.methodAnnotations[i4][0]);
            iArr2[i4][1] = adjustAnnotationSetOffset(annotationsDirectory.methodAnnotations[i4][1]);
            i3 = i4 + 1;
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, annotationsDirectory.parameterAnnotations.length, 2);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= iArr3.length) {
                return new AnnotationsDirectory(annotationsDirectory.off, adjustAnnotationSetOffset, iArr, iArr2, iArr3);
            }
            iArr3[i6][0] = adjustMethodIdIndex(annotationsDirectory.parameterAnnotations[i6][0]);
            iArr3[i6][1] = adjustAnnotationSetRefListOffset(annotationsDirectory.parameterAnnotations[i6][1]);
            i5 = i6 + 1;
        }
    }

    public ClassData adjust(ClassData classData) {
        return new ClassData(classData.off, adjustFields(classData.staticFields), adjustFields(classData.instanceFields), adjustMethods(classData.directMethods), adjustMethods(classData.virtualMethods));
    }

    public ClassDef adjust(ClassDef classDef) {
        return new ClassDef(classDef.off, adjustTypeIdIndex(classDef.typeIndex), classDef.accessFlags, adjustTypeIdIndex(classDef.supertypeIndex), adjustTypeListOffset(classDef.interfacesOffset), adjustStringIndex(classDef.sourceFileIndex), adjustAnnotationsDirectoryOffset(classDef.annotationsOffset), adjustClassDataOffset(classDef.classDataOffset), adjustStaticValuesOffset(classDef.staticValuesOffset));
    }

    public Code adjust(Code code) {
        return new Code(code.off, code.registersSize, code.insSize, code.outsSize, adjustDebugInfoItemOffset(code.debugInfoOffset), adjustInstructions(code.instructions), code.tries, adjustCatchHandlers(code.catchHandlers));
    }

    public DebugInfoItem adjust(DebugInfoItem debugInfoItem) {
        return new DebugInfoItem(debugInfoItem.off, debugInfoItem.lineStart, adjustParameterNames(debugInfoItem.parameterNames), adjustDebugInfoItemSTM(debugInfoItem.infoSTM));
    }

    public EncodedValue adjust(EncodedValue encodedValue) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(encodedValue.data.length);
        new EncodedValueTransformer(new ByteOutput() { // from class: com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap.3
            @Override // com.tencent.tinker.android.dex.util.ByteOutput
            public void writeByte(int i) {
                byteArrayOutputStream.write(i);
            }
        }).transformArray(new EncodedValueReader(encodedValue, 28));
        return new EncodedValue(encodedValue.off, byteArrayOutputStream.toByteArray());
    }

    public FieldId adjust(FieldId fieldId) {
        return new FieldId(fieldId.off, adjustTypeIdIndex(fieldId.declaringClassIndex), adjustTypeIdIndex(fieldId.typeIndex), adjustStringIndex(fieldId.nameIndex));
    }

    public MethodId adjust(MethodId methodId) {
        return new MethodId(methodId.off, adjustTypeIdIndex(methodId.declaringClassIndex), adjustProtoIdIndex(methodId.protoIndex), adjustStringIndex(methodId.nameIndex));
    }

    public ProtoId adjust(ProtoId protoId) {
        return new ProtoId(protoId.off, adjustStringIndex(protoId.shortyIndex), adjustTypeIdIndex(protoId.returnTypeIndex), adjustTypeListOffset(protoId.parametersOffset));
    }

    public TypeList adjust(TypeList typeList) {
        if (typeList == TypeList.EMPTY) {
            return typeList;
        }
        int length = typeList.types.length;
        short[] sArr = new short[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new TypeList(typeList.off, sArr);
            }
            sArr[i2] = (short) adjustTypeIdIndex(typeList.types[i2]);
            i = i2 + 1;
        }
    }

    public abstract int adjustAnnotationOffset(int i);

    public abstract int adjustAnnotationSetOffset(int i);

    public abstract int adjustAnnotationSetRefListOffset(int i);

    public abstract int adjustAnnotationsDirectoryOffset(int i);

    public abstract int adjustClassDataOffset(int i);

    public abstract int adjustCodeOffset(int i);

    public abstract int adjustDebugInfoItemOffset(int i);

    public abstract int adjustFieldIdIndex(int i);

    public abstract int adjustMethodIdIndex(int i);

    public abstract int adjustProtoIdIndex(int i);

    public abstract int adjustStaticValuesOffset(int i);

    public abstract int adjustStringIndex(int i);

    public abstract int adjustTypeIdIndex(int i);

    public abstract int adjustTypeListOffset(int i);
}
