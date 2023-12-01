package com.huawei.hms.common.internal.safeparcel;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/safeparcel/SafeParcelWriter.class */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    private static int a(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void a(Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt(i | (i2 << 16));
            return;
        }
        parcel.writeInt(i | (-65536));
        parcel.writeInt(i2);
    }

    private static <P extends Parcelable> void a(Parcel parcel, P p, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        p.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void b(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static int beginObjectHeader(Parcel parcel) {
        return a(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i) {
        b(parcel, i);
    }

    public static void writeBigDecimal(Parcel parcel, int i, BigDecimal bigDecimal, boolean z) {
        if (bigDecimal == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        b(parcel, a2);
    }

    public static void writeBigDecimalArray(Parcel parcel, int i, BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                b(parcel, a2);
                return;
            }
            parcel.writeByteArray(bigDecimalArr[i3].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i3].scale());
            i2 = i3 + 1;
        }
    }

    public static void writeBigInteger(Parcel parcel, int i, BigInteger bigInteger, boolean z) {
        if (bigInteger != null) {
            int a2 = a(parcel, i);
            parcel.writeByteArray(bigInteger.toByteArray());
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i, BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int length = bigIntegerArr.length;
        parcel.writeInt(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                b(parcel, a2);
                return;
            } else {
                parcel.writeByteArray(bigIntegerArr[i3].toByteArray());
                i2 = i3 + 1;
            }
        }
    }

    public static void writeBoolean(Parcel parcel, int i, boolean z) {
        a(parcel, i, 4);
        if (z) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }

    public static void writeBooleanArray(Parcel parcel, int i, boolean[] zArr, boolean z) {
        if (zArr != null) {
            int a2 = a(parcel, i);
            parcel.writeBooleanArray(zArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void writeBooleanList(Parcel parcel, int i, List<Boolean> list, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void writeBooleanObject(Parcel parcel, int i, Boolean bool, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void writeBundle(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int a2 = a(parcel, i);
            parcel.writeBundle(bundle);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeByte(Parcel parcel, int i, byte b) {
        a(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void writeByteArray(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int a2 = a(parcel, i);
            parcel.writeByteArray(bArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i, byte[][] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int length = bArr.length;
        parcel.writeInt(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                b(parcel, a2);
                return;
            } else {
                parcel.writeByteArray(bArr[i3]);
                i2 = i3 + 1;
            }
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i, SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeByteArray(sparseArray.valueAt(i3));
            i2 = i3 + 1;
        }
    }

    public static void writeChar(Parcel parcel, int i, char c2) {
        a(parcel, i, 4);
        parcel.writeInt(c2);
    }

    public static void writeCharArray(Parcel parcel, int i, char[] cArr, boolean z) {
        if (cArr != null) {
            int a2 = a(parcel, i);
            parcel.writeCharArray(cArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int i, double d) {
        a(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void writeDoubleArray(Parcel parcel, int i, double[] dArr, boolean z) {
        if (dArr != null) {
            int a2 = a(parcel, i);
            parcel.writeDoubleArray(dArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i, List<Double> list, boolean z) {
        if (list == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            } else {
                parcel.writeDouble(list.get(i3).doubleValue());
                i2 = i3 + 1;
            }
        }
    }

    public static void writeDoubleObject(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            a(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i, SparseArray<Double> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeDouble(sparseArray.valueAt(i3).doubleValue());
            i2 = i3 + 1;
        }
    }

    public static void writeFloat(Parcel parcel, int i, float f) {
        a(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void writeFloatArray(Parcel parcel, int i, float[] fArr, boolean z) {
        if (fArr != null) {
            int a2 = a(parcel, i);
            parcel.writeFloatArray(fArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int i, List<Float> list, boolean z) {
        if (list == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            } else {
                parcel.writeFloat(list.get(i3).floatValue());
                i2 = i3 + 1;
            }
        }
    }

    public static void writeFloatObject(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            a(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i, SparseArray<Float> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeFloat(sparseArray.valueAt(i3).floatValue());
            i2 = i3 + 1;
        }
    }

    public static void writeIBinder(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int a2 = a(parcel, i);
            parcel.writeStrongBinder(iBinder);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i, IBinder[] iBinderArr, boolean z) {
        if (iBinderArr != null) {
            int a2 = a(parcel, i);
            parcel.writeBinderArray(iBinderArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i, List<IBinder> list, boolean z) {
        if (list != null) {
            int a2 = a(parcel, i);
            parcel.writeBinderList(list);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i, SparseArray<IBinder> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeStrongBinder(sparseArray.valueAt(i3));
            i2 = i3 + 1;
        }
    }

    public static void writeInt(Parcel parcel, int i, int i2) {
        a(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void writeIntArray(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int a2 = a(parcel, i);
            parcel.writeIntArray(iArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            } else {
                parcel.writeInt(list.get(i3).intValue());
                i2 = i3 + 1;
            }
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            a(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeList(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int a2 = a(parcel, i);
            parcel.writeList(list);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i, long j) {
        a(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void writeLongArray(Parcel parcel, int i, long[] jArr, boolean z) {
        if (jArr != null) {
            int a2 = a(parcel, i);
            parcel.writeLongArray(jArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int i, List<Long> list, boolean z) {
        if (list == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            } else {
                parcel.writeLong(list.get(i3).longValue());
                i2 = i3 + 1;
            }
        }
    }

    public static void writeLongObject(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            a(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int a2 = a(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i, Parcel[] parcelArr, boolean z) {
        if (parcelArr == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int length = parcelArr.length;
        parcel.writeInt(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                b(parcel, a2);
                return;
            }
            if (parcelArr[i3] == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcelArr[i3].dataSize());
                parcel.appendFrom(parcelArr[i3], 0, parcelArr[i3].dataSize());
            }
            i2 = i3 + 1;
        }
    }

    public static void writeParcelList(Parcel parcel, int i, List<Parcel> list, boolean z) {
        if (list == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            Parcel parcel2 = list.get(i3);
            if (parcel2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            }
            i2 = i3 + 1;
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int i, SparseArray<Parcel> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(i3));
            Parcel valueAt = sparseArray.valueAt(i3);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            }
            i2 = i3 + 1;
        }
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int a2 = a(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeShort(Parcel parcel, int i, short s) {
        a(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i, SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray != null) {
            int a2 = a(parcel, i);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i, SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            parcel.writeInt(sparseIntArray.keyAt(i3));
            parcel.writeInt(sparseIntArray.valueAt(i3));
            i2 = i3 + 1;
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int i, SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = Build.VERSION.SDK_INT >= 18 ? sparseLongArray.size() : 0;
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            if (Build.VERSION.SDK_INT >= 18) {
                parcel.writeInt(sparseLongArray.keyAt(i2));
            }
            if (Build.VERSION.SDK_INT >= 18) {
                parcel.writeLong(sparseLongArray.valueAt(i2));
            }
        }
        b(parcel, a2);
    }

    public static void writeString(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int a2 = a(parcel, i);
            parcel.writeString(str);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int a2 = a(parcel, i);
            parcel.writeStringArray(strArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int a2 = a(parcel, i);
            parcel.writeStringList(list);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i, SparseArray<String> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeString(sparseArray.valueAt(i3));
            i2 = i3 + 1;
        }
    }

    public static <P extends Parcelable> void writeTypedArray(Parcel parcel, int i, P[] pArr, int i2, boolean z) {
        if (pArr == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        parcel.writeInt(a2);
        int length = pArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                b(parcel, a2);
                return;
            }
            if (pArr[i4] != null) {
                a(parcel, pArr[i4], i2);
            } else {
                parcel.writeInt(0);
            }
            i3 = i4 + 1;
        }
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            T t = list.get(i3);
            if (t != null) {
                a(parcel, t, 0);
            } else {
                parcel.writeInt(0);
            }
            i2 = i3 + 1;
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i, SparseArray<T> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                a(parcel, i, 0);
                return;
            }
            return;
        }
        int a2 = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                b(parcel, a2);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(i3));
            T valueAt = sparseArray.valueAt(i3);
            if (valueAt != null) {
                a(parcel, valueAt, 0);
            } else {
                parcel.writeInt(0);
            }
            i2 = i3 + 1;
        }
    }
}
