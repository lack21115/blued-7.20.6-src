package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/PrimitiveArraySerializer.class */
public class PrimitiveArraySerializer implements ObjectSerializer {
    public static PrimitiveArraySerializer instance = new PrimitiveArraySerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (serializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(iArr[i2]);
            }
            serializeWriter.write(93);
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= sArr.length) {
                    serializeWriter.write(93);
                    return;
                }
                if (i4 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(sArr[i4]);
                i3 = i4 + 1;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= jArr.length) {
                    serializeWriter.write(93);
                    return;
                }
                if (i6 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(jArr[i6]);
                i5 = i6 + 1;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= zArr.length) {
                    serializeWriter.write(93);
                    return;
                }
                if (i8 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.write(zArr[i8]);
                i7 = i8 + 1;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            serializeWriter.write(91);
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= fArr.length) {
                    serializeWriter.write(93);
                    return;
                }
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                float f = fArr[i10];
                if (Float.isNaN(f)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Float.toString(f));
                }
                i9 = i10 + 1;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            serializeWriter.write(91);
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= dArr.length) {
                    serializeWriter.write(93);
                    return;
                }
                if (i12 != 0) {
                    serializeWriter.write(44);
                }
                double d = dArr[i12];
                if (Double.isNaN(d)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Double.toString(d));
                }
                i11 = i12 + 1;
            }
        } else if (obj instanceof byte[]) {
            serializeWriter.writeByteArray((byte[]) obj);
        } else {
            serializeWriter.writeString(new String((char[]) obj));
        }
    }
}
