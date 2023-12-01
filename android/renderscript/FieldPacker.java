package android.renderscript;

import android.util.Log;
import android.widget.ExpandableListView;
import java.util.BitSet;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/FieldPacker.class */
public class FieldPacker {
    private BitSet mAlignment;
    private final byte[] mData;
    private int mLen;
    private int mPos;

    public FieldPacker(int i) {
        this.mPos = 0;
        this.mLen = i;
        this.mData = new byte[i];
        this.mAlignment = new BitSet();
    }

    public FieldPacker(byte[] bArr) {
        this.mPos = bArr.length;
        this.mLen = bArr.length;
        this.mData = bArr;
        this.mAlignment = new BitSet();
    }

    public void addBoolean(boolean z) {
        addI8((byte) (z ? 1 : 0));
    }

    public void addF32(float f) {
        addI32(Float.floatToRawIntBits(f));
    }

    public void addF32(Float2 float2) {
        addF32(float2.x);
        addF32(float2.y);
    }

    public void addF32(Float3 float3) {
        addF32(float3.x);
        addF32(float3.y);
        addF32(float3.z);
    }

    public void addF32(Float4 float4) {
        addF32(float4.x);
        addF32(float4.y);
        addF32(float4.z);
        addF32(float4.w);
    }

    public void addF64(double d) {
        addI64(Double.doubleToRawLongBits(d));
    }

    public void addF64(Double2 double2) {
        addF64(double2.x);
        addF64(double2.y);
    }

    public void addF64(Double3 double3) {
        addF64(double3.x);
        addF64(double3.y);
        addF64(double3.z);
    }

    public void addF64(Double4 double4) {
        addF64(double4.x);
        addF64(double4.y);
        addF64(double4.z);
        addF64(double4.w);
    }

    public void addI16(Short2 short2) {
        addI16(short2.x);
        addI16(short2.y);
    }

    public void addI16(Short3 short3) {
        addI16(short3.x);
        addI16(short3.y);
        addI16(short3.z);
    }

    public void addI16(Short4 short4) {
        addI16(short4.x);
        addI16(short4.y);
        addI16(short4.z);
        addI16(short4.w);
    }

    public void addI16(short s) {
        align(2);
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) (s & 255);
        byte[] bArr2 = this.mData;
        int i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr2[i2] = (byte) (s >> 8);
    }

    public void addI32(int i) {
        align(4);
        byte[] bArr = this.mData;
        int i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        byte[] bArr2 = this.mData;
        int i3 = this.mPos;
        this.mPos = i3 + 1;
        bArr2[i3] = (byte) ((i >> 8) & 255);
        byte[] bArr3 = this.mData;
        int i4 = this.mPos;
        this.mPos = i4 + 1;
        bArr3[i4] = (byte) ((i >> 16) & 255);
        byte[] bArr4 = this.mData;
        int i5 = this.mPos;
        this.mPos = i5 + 1;
        bArr4[i5] = (byte) ((i >> 24) & 255);
    }

    public void addI32(Int2 int2) {
        addI32(int2.x);
        addI32(int2.y);
    }

    public void addI32(Int3 int3) {
        addI32(int3.x);
        addI32(int3.y);
        addI32(int3.z);
    }

    public void addI32(Int4 int4) {
        addI32(int4.x);
        addI32(int4.y);
        addI32(int4.z);
        addI32(int4.w);
    }

    public void addI64(long j) {
        align(8);
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) (j & 255);
        byte[] bArr2 = this.mData;
        int i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr2[i2] = (byte) ((j >> 8) & 255);
        byte[] bArr3 = this.mData;
        int i3 = this.mPos;
        this.mPos = i3 + 1;
        bArr3[i3] = (byte) ((j >> 16) & 255);
        byte[] bArr4 = this.mData;
        int i4 = this.mPos;
        this.mPos = i4 + 1;
        bArr4[i4] = (byte) ((j >> 24) & 255);
        byte[] bArr5 = this.mData;
        int i5 = this.mPos;
        this.mPos = i5 + 1;
        bArr5[i5] = (byte) ((j >> 32) & 255);
        byte[] bArr6 = this.mData;
        int i6 = this.mPos;
        this.mPos = i6 + 1;
        bArr6[i6] = (byte) ((j >> 40) & 255);
        byte[] bArr7 = this.mData;
        int i7 = this.mPos;
        this.mPos = i7 + 1;
        bArr7[i7] = (byte) ((j >> 48) & 255);
        byte[] bArr8 = this.mData;
        int i8 = this.mPos;
        this.mPos = i8 + 1;
        bArr8[i8] = (byte) ((j >> 56) & 255);
    }

    public void addI64(Long2 long2) {
        addI64(long2.x);
        addI64(long2.y);
    }

    public void addI64(Long3 long3) {
        addI64(long3.x);
        addI64(long3.y);
        addI64(long3.z);
    }

    public void addI64(Long4 long4) {
        addI64(long4.x);
        addI64(long4.y);
        addI64(long4.z);
        addI64(long4.w);
    }

    public void addI8(byte b) {
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = b;
    }

    public void addI8(Byte2 byte2) {
        addI8(byte2.x);
        addI8(byte2.y);
    }

    public void addI8(Byte3 byte3) {
        addI8(byte3.x);
        addI8(byte3.y);
        addI8(byte3.z);
    }

    public void addI8(Byte4 byte4) {
        addI8(byte4.x);
        addI8(byte4.y);
        addI8(byte4.z);
        addI8(byte4.w);
    }

    public void addMatrix(Matrix2f matrix2f) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= matrix2f.mMat.length) {
                return;
            }
            addF32(matrix2f.mMat[i2]);
            i = i2 + 1;
        }
    }

    public void addMatrix(Matrix3f matrix3f) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= matrix3f.mMat.length) {
                return;
            }
            addF32(matrix3f.mMat[i2]);
            i = i2 + 1;
        }
    }

    public void addMatrix(Matrix4f matrix4f) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= matrix4f.mMat.length) {
                return;
            }
            addF32(matrix4f.mMat[i2]);
            i = i2 + 1;
        }
    }

    public void addObj(BaseObj baseObj) {
        if (baseObj != null) {
            if (RenderScript.sPointerSize != 8) {
                addI32((int) baseObj.getID(null));
                return;
            }
            addI64(baseObj.getID(null));
            addI64(0L);
            addI64(0L);
            addI64(0L);
        } else if (RenderScript.sPointerSize != 8) {
            addI32(0);
        } else {
            addI64(0L);
            addI64(0L);
            addI64(0L);
            addI64(0L);
        }
    }

    public void addU16(int i) {
        if (i < 0 || i > 65535) {
            Log.e("rs", "FieldPacker.addU16( " + i + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        align(2);
        byte[] bArr = this.mData;
        int i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        byte[] bArr2 = this.mData;
        int i3 = this.mPos;
        this.mPos = i3 + 1;
        bArr2[i3] = (byte) (i >> 8);
    }

    public void addU16(Int2 int2) {
        addU16(int2.x);
        addU16(int2.y);
    }

    public void addU16(Int3 int3) {
        addU16(int3.x);
        addU16(int3.y);
        addU16(int3.z);
    }

    public void addU16(Int4 int4) {
        addU16(int4.x);
        addU16(int4.y);
        addU16(int4.z);
        addU16(int4.w);
    }

    public void addU32(long j) {
        if (j < 0 || j > ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            Log.e("rs", "FieldPacker.addU32( " + j + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        align(4);
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) (j & 255);
        byte[] bArr2 = this.mData;
        int i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr2[i2] = (byte) ((j >> 8) & 255);
        byte[] bArr3 = this.mData;
        int i3 = this.mPos;
        this.mPos = i3 + 1;
        bArr3[i3] = (byte) ((j >> 16) & 255);
        byte[] bArr4 = this.mData;
        int i4 = this.mPos;
        this.mPos = i4 + 1;
        bArr4[i4] = (byte) ((j >> 24) & 255);
    }

    public void addU32(Long2 long2) {
        addU32(long2.x);
        addU32(long2.y);
    }

    public void addU32(Long3 long3) {
        addU32(long3.x);
        addU32(long3.y);
        addU32(long3.z);
    }

    public void addU32(Long4 long4) {
        addU32(long4.x);
        addU32(long4.y);
        addU32(long4.z);
        addU32(long4.w);
    }

    public void addU64(long j) {
        if (j < 0) {
            Log.e("rs", "FieldPacker.addU64( " + j + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        align(8);
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) (j & 255);
        byte[] bArr2 = this.mData;
        int i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr2[i2] = (byte) ((j >> 8) & 255);
        byte[] bArr3 = this.mData;
        int i3 = this.mPos;
        this.mPos = i3 + 1;
        bArr3[i3] = (byte) ((j >> 16) & 255);
        byte[] bArr4 = this.mData;
        int i4 = this.mPos;
        this.mPos = i4 + 1;
        bArr4[i4] = (byte) ((j >> 24) & 255);
        byte[] bArr5 = this.mData;
        int i5 = this.mPos;
        this.mPos = i5 + 1;
        bArr5[i5] = (byte) ((j >> 32) & 255);
        byte[] bArr6 = this.mData;
        int i6 = this.mPos;
        this.mPos = i6 + 1;
        bArr6[i6] = (byte) ((j >> 40) & 255);
        byte[] bArr7 = this.mData;
        int i7 = this.mPos;
        this.mPos = i7 + 1;
        bArr7[i7] = (byte) ((j >> 48) & 255);
        byte[] bArr8 = this.mData;
        int i8 = this.mPos;
        this.mPos = i8 + 1;
        bArr8[i8] = (byte) ((j >> 56) & 255);
    }

    public void addU64(Long2 long2) {
        addU64(long2.x);
        addU64(long2.y);
    }

    public void addU64(Long3 long3) {
        addU64(long3.x);
        addU64(long3.y);
        addU64(long3.z);
    }

    public void addU64(Long4 long4) {
        addU64(long4.x);
        addU64(long4.y);
        addU64(long4.z);
        addU64(long4.w);
    }

    public void addU8(Short2 short2) {
        addU8(short2.x);
        addU8(short2.y);
    }

    public void addU8(Short3 short3) {
        addU8(short3.x);
        addU8(short3.y);
        addU8(short3.z);
    }

    public void addU8(Short4 short4) {
        addU8(short4.x);
        addU8(short4.y);
        addU8(short4.z);
        addU8(short4.w);
    }

    public void addU8(short s) {
        if (s < 0 || s > 255) {
            Log.e("rs", "FieldPacker.addU8( " + ((int) s) + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) s;
    }

    public void align(int i) {
        if (i <= 0 || ((i - 1) & i) != 0) {
            throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + i);
        }
        while ((this.mPos & (i - 1)) != 0) {
            this.mAlignment.flip(this.mPos);
            byte[] bArr = this.mData;
            int i2 = this.mPos;
            this.mPos = i2 + 1;
            bArr[i2] = 0;
        }
    }

    public final byte[] getData() {
        return this.mData;
    }

    public int getPos() {
        return this.mPos;
    }

    public void reset() {
        this.mPos = 0;
    }

    public void reset(int i) {
        if (i < 0 || i > this.mLen) {
            throw new RSIllegalArgumentException("out of range argument: " + i);
        }
        this.mPos = i;
    }

    public void skip(int i) {
        int i2 = this.mPos + i;
        if (i2 < 0 || i2 > this.mLen) {
            throw new RSIllegalArgumentException("out of range argument: " + i);
        }
        this.mPos = i2;
    }

    public boolean subBoolean() {
        return subI8() == 1;
    }

    public Byte2 subByte2() {
        Byte2 byte2 = new Byte2();
        byte2.y = subI8();
        byte2.x = subI8();
        return byte2;
    }

    public Byte3 subByte3() {
        Byte3 byte3 = new Byte3();
        byte3.z = subI8();
        byte3.y = subI8();
        byte3.x = subI8();
        return byte3;
    }

    public Byte4 subByte4() {
        Byte4 byte4 = new Byte4();
        byte4.w = subI8();
        byte4.z = subI8();
        byte4.y = subI8();
        byte4.x = subI8();
        return byte4;
    }

    public Double2 subDouble2() {
        Double2 double2 = new Double2();
        double2.y = subF64();
        double2.x = subF64();
        return double2;
    }

    public Double3 subDouble3() {
        Double3 double3 = new Double3();
        double3.z = subF64();
        double3.y = subF64();
        double3.x = subF64();
        return double3;
    }

    public Double4 subDouble4() {
        Double4 double4 = new Double4();
        double4.w = subF64();
        double4.z = subF64();
        double4.y = subF64();
        double4.x = subF64();
        return double4;
    }

    public float subF32() {
        return Float.intBitsToFloat(subI32());
    }

    public double subF64() {
        return Double.longBitsToDouble(subI64());
    }

    public Float2 subFloat2() {
        Float2 float2 = new Float2();
        float2.y = subF32();
        float2.x = subF32();
        return float2;
    }

    public Float3 subFloat3() {
        Float3 float3 = new Float3();
        float3.z = subF32();
        float3.y = subF32();
        float3.x = subF32();
        return float3;
    }

    public Float4 subFloat4() {
        Float4 float4 = new Float4();
        float4.w = subF32();
        float4.z = subF32();
        float4.y = subF32();
        float4.x = subF32();
        return float4;
    }

    public short subI16() {
        subalign(2);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        short s = (short) ((bArr[i] & 255) << 8);
        byte[] bArr2 = this.mData;
        int i2 = this.mPos - 1;
        this.mPos = i2;
        return (short) (((short) (bArr2[i2] & 255)) | s);
    }

    public int subI32() {
        subalign(4);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        byte b = bArr[i];
        byte[] bArr2 = this.mData;
        int i2 = this.mPos - 1;
        this.mPos = i2;
        byte b2 = bArr2[i2];
        byte[] bArr3 = this.mData;
        int i3 = this.mPos - 1;
        this.mPos = i3;
        byte b3 = bArr3[i3];
        byte[] bArr4 = this.mData;
        int i4 = this.mPos - 1;
        this.mPos = i4;
        return ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (bArr4[i4] & 255);
    }

    public long subI64() {
        int i;
        subalign(8);
        byte[] bArr = this.mData;
        int i2 = this.mPos - 1;
        this.mPos = i2;
        long j = bArr[i2];
        byte[] bArr2 = this.mData;
        int i3 = this.mPos - 1;
        this.mPos = i3;
        long j2 = bArr2[i3];
        byte[] bArr3 = this.mData;
        int i4 = this.mPos - 1;
        this.mPos = i4;
        long j3 = bArr3[i4];
        byte[] bArr4 = this.mData;
        int i5 = this.mPos - 1;
        this.mPos = i5;
        long j4 = bArr4[i5];
        byte[] bArr5 = this.mData;
        int i6 = this.mPos - 1;
        this.mPos = i6;
        long j5 = bArr5[i6];
        byte[] bArr6 = this.mData;
        int i7 = this.mPos - 1;
        this.mPos = i7;
        long j6 = bArr6[i7];
        byte[] bArr7 = this.mData;
        int i8 = this.mPos - 1;
        this.mPos = i8;
        long j7 = bArr7[i8];
        byte[] bArr8 = this.mData;
        this.mPos = this.mPos - 1;
        return 0 | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8) | (bArr8[i] & 255);
    }

    public byte subI8() {
        subalign(1);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        return bArr[i];
    }

    public Int2 subInt2() {
        Int2 int2 = new Int2();
        int2.y = subI32();
        int2.x = subI32();
        return int2;
    }

    public Int3 subInt3() {
        Int3 int3 = new Int3();
        int3.z = subI32();
        int3.y = subI32();
        int3.x = subI32();
        return int3;
    }

    public Int4 subInt4() {
        Int4 int4 = new Int4();
        int4.w = subI32();
        int4.z = subI32();
        int4.y = subI32();
        int4.x = subI32();
        return int4;
    }

    public Long2 subLong2() {
        Long2 long2 = new Long2();
        long2.y = subI64();
        long2.x = subI64();
        return long2;
    }

    public Long3 subLong3() {
        Long3 long3 = new Long3();
        long3.z = subI64();
        long3.y = subI64();
        long3.x = subI64();
        return long3;
    }

    public Long4 subLong4() {
        Long4 long4 = new Long4();
        long4.w = subI64();
        long4.z = subI64();
        long4.y = subI64();
        long4.x = subI64();
        return long4;
    }

    public Matrix2f subMatrix2f() {
        Matrix2f matrix2f = new Matrix2f();
        int length = matrix2f.mMat.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return matrix2f;
            }
            matrix2f.mMat[i] = subF32();
            length = i;
        }
    }

    public Matrix3f subMatrix3f() {
        Matrix3f matrix3f = new Matrix3f();
        int length = matrix3f.mMat.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return matrix3f;
            }
            matrix3f.mMat[i] = subF32();
            length = i;
        }
    }

    public Matrix4f subMatrix4f() {
        Matrix4f matrix4f = new Matrix4f();
        int length = matrix4f.mMat.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return matrix4f;
            }
            matrix4f.mMat[i] = subF32();
            length = i;
        }
    }

    public Short2 subShort2() {
        Short2 short2 = new Short2();
        short2.y = subI16();
        short2.x = subI16();
        return short2;
    }

    public Short3 subShort3() {
        Short3 short3 = new Short3();
        short3.z = subI16();
        short3.y = subI16();
        short3.x = subI16();
        return short3;
    }

    public Short4 subShort4() {
        Short4 short4 = new Short4();
        short4.w = subI16();
        short4.z = subI16();
        short4.y = subI16();
        short4.x = subI16();
        return short4;
    }

    public void subalign(int i) {
        if (((i - 1) & i) != 0) {
            throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + i);
        }
        while ((this.mPos & (i - 1)) != 0) {
            this.mPos--;
        }
        if (this.mPos > 0) {
            while (this.mAlignment.get(this.mPos - 1)) {
                this.mPos--;
                this.mAlignment.flip(this.mPos);
            }
        }
    }
}
