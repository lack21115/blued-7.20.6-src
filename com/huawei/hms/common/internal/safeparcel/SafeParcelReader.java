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
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/safeparcel/SafeParcelReader.class */
public class SafeParcelReader {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/safeparcel/SafeParcelReader$ParseException.class */
    public static class ParseException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ParseException(java.lang.String r6, android.os.Parcel r7) {
            /*
                r5 = this;
                java.lang.StringBuffer r0 = new java.lang.StringBuffer
                r1 = r0
                r2 = r6
                java.lang.String r2 = java.lang.String.valueOf(r2)
                int r2 = r2.length()
                r3 = 41
                int r2 = r2 + r3
                r1.<init>(r2)
                r8 = r0
                r0 = r8
                r1 = r6
                java.lang.StringBuffer r0 = r0.append(r1)
                r0 = r8
                java.lang.String r1 = " Parcel: pos="
                java.lang.StringBuffer r0 = r0.append(r1)
                r0 = r8
                r1 = r7
                int r1 = r1.dataPosition()
                java.lang.StringBuffer r0 = r0.append(r1)
                r0 = r8
                java.lang.String r1 = " size="
                java.lang.StringBuffer r0 = r0.append(r1)
                r0 = r8
                r1 = r7
                int r1 = r1.dataSize()
                java.lang.StringBuffer r0 = r0.append(r1)
                r0 = r5
                r1 = r8
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private SafeParcelReader() {
    }

    private static void a(Parcel parcel, int i) {
        if (i > 1024) {
            throw new ParseException("arraySize cannot be beyond 65535", parcel);
        }
    }

    private static void a(Parcel parcel, int i, int i2) {
        if (i < 0 || a(i, i2)) {
            throw new ParseException("dataPosition cannot be beyond integer scope", parcel);
        }
    }

    private static void a(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(hexString.length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    private static boolean a(int i, int i2) {
        long j = i + i2;
        return j > 2147483647L || j < -2147483648L;
    }

    private static void b(Parcel parcel, int i, int i2) {
        int readSize = readSize(parcel, i);
        if (readSize == i2) {
            return;
        }
        String hexString = Integer.toHexString(readSize);
        StringBuilder sb = new StringBuilder(hexString.length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(readSize);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    public static BigDecimal createBigDecimal(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(readSize + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static BigDecimal[] createBigDecimalArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new BigDecimal[0];
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigDecimalArr;
    }

    public static BigInteger createBigInteger(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static BigInteger[] createBigIntegerArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new BigInteger[0];
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigIntegerArr;
    }

    public static boolean[] createBooleanArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new boolean[0];
        }
        a(parcel, readSize, dataPosition);
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createBooleanArray;
    }

    public static ArrayList<Boolean> createBooleanList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Boolean> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return arrayList;
            }
            arrayList.add(Boolean.valueOf(parcel.readInt() != 0));
            i2 = i3 + 1;
        }
    }

    public static Bundle createBundle(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(readSize + dataPosition);
        return readBundle;
    }

    public static byte[] createByteArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new byte[0];
        }
        a(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createByteArray;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [byte[], byte[][]] */
    public static byte[][] createByteArrayArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        ?? r0 = new byte[readInt];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return r0;
            }
            r0[i3] = parcel.createByteArray();
            i2 = i3 + 1;
        }
    }

    public static SparseArray<byte[]> createByteArraySparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        SparseArray<byte[]> sparseArray = new SparseArray<>(readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return sparseArray;
            }
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
            i2 = i3 + 1;
        }
    }

    public static char[] createCharArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new char[0];
        }
        a(parcel, readSize, dataPosition);
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createCharArray;
    }

    public static double[] createDoubleArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new double[0];
        }
        a(parcel, readSize, dataPosition);
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createDoubleArray;
    }

    public static ArrayList<Double> createDoubleList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Double> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return arrayList;
            }
            arrayList.add(Double.valueOf(parcel.readDouble()));
            i2 = i3 + 1;
        }
    }

    public static SparseArray<Double> createDoubleSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseArray<Double> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return sparseArray;
            }
            sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
            i2 = i3 + 1;
        }
    }

    public static float[] createFloatArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new float[0];
        }
        a(parcel, readSize, dataPosition);
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createFloatArray;
    }

    public static ArrayList<Float> createFloatList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Float> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return arrayList;
            }
            arrayList.add(Float.valueOf(parcel.readFloat()));
            i2 = i3 + 1;
        }
    }

    public static SparseArray<Float> createFloatSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseArray<Float> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return sparseArray;
            }
            sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
            i2 = i3 + 1;
        }
    }

    public static IBinder[] createIBinderArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new IBinder[0];
        }
        a(parcel, readSize, dataPosition);
        IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createBinderArray;
    }

    public static ArrayList<IBinder> createIBinderList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<IBinder> createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        return createBinderArrayList;
    }

    public static SparseArray<IBinder> createIBinderSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        SparseArray<IBinder> sparseArray = new SparseArray<>(readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return sparseArray;
            }
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
            i2 = i3 + 1;
        }
    }

    public static int[] createIntArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new int[0];
        }
        a(parcel, readSize, dataPosition);
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createIntArray;
    }

    public static ArrayList<Integer> createIntegerList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return arrayList;
            }
            arrayList.add(Integer.valueOf(parcel.readInt()));
            i2 = i3 + 1;
        }
    }

    public static long[] createLongArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new long[0];
        }
        a(parcel, readSize, dataPosition);
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createLongArray;
    }

    public static ArrayList<Long> createLongList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Long> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return arrayList;
            }
            arrayList.add(Long.valueOf(parcel.readLong()));
            i2 = i3 + 1;
        }
    }

    public static Parcel createParcel(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, readSize);
        parcel.setDataPosition(readSize + dataPosition);
        return obtain;
    }

    public static Parcel[] createParcelArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new Parcel[0];
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 == 0) {
                parcelArr[i2] = null;
            } else {
                int dataPosition2 = parcel.dataPosition();
                a(parcel, readInt2, dataPosition2);
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return parcelArr;
    }

    public static ArrayList<Parcel> createParcelList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        ArrayList<Parcel> arrayList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return arrayList;
            }
            int readInt2 = parcel.readInt();
            if (readInt2 == 0) {
                arrayList.add(null);
            } else {
                int dataPosition2 = parcel.dataPosition();
                a(parcel, readInt2, dataPosition2);
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(readInt2 + dataPosition2);
            }
            i2 = i3 + 1;
        }
    }

    public static SparseArray<Parcel> createParcelSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        SparseArray<Parcel> sparseArray = new SparseArray<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return sparseArray;
            }
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 == 0) {
                sparseArray.append(readInt2, null);
            } else {
                int dataPosition2 = parcel.dataPosition();
                a(parcel, readInt3, dataPosition2);
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            }
            i2 = i3 + 1;
        }
    }

    public static <P extends Parcelable> P createParcelable(Parcel parcel, int i, Parcelable.Creator<P> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        P createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(readSize + dataPosition);
        return createFromParcel;
    }

    public static SparseBooleanArray createSparseBooleanArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        return readSparseBooleanArray;
    }

    public static SparseIntArray createSparseIntArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseIntArray sparseIntArray = new SparseIntArray();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return sparseIntArray;
            }
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
            i2 = i3 + 1;
        }
    }

    public static SparseLongArray createSparseLongArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        SparseLongArray sparseLongArray = null;
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        if (Build.VERSION.SDK_INT >= 18) {
            sparseLongArray = new SparseLongArray();
        }
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return sparseLongArray;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                sparseLongArray.append(parcel.readInt(), parcel.readLong());
            }
            i2 = i3 + 1;
        }
    }

    public static String createString(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        String readString = parcel.readString();
        parcel.setDataPosition(readSize + dataPosition);
        return readString;
    }

    public static String[] createStringArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new String[0];
        }
        a(parcel, readSize, dataPosition);
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createStringArray;
    }

    public static ArrayList<String> createStringList(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        return createStringArrayList;
    }

    public static SparseArray<String> createStringSparseArray(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseArray<String> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return sparseArray;
            }
            sparseArray.append(parcel.readInt(), parcel.readString());
            i2 = i3 + 1;
        }
    }

    public static <C> C[] createTypedArray(Parcel parcel, int i, Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return creator.newArray(0);
        }
        a(parcel, readSize, dataPosition);
        C[] cArr = (C[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(readSize + dataPosition);
        return cArr;
    }

    public static <C> ArrayList<C> createTypedList(Parcel parcel, int i, Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<C> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(readSize + dataPosition);
        return createTypedArrayList;
    }

    public static <C> SparseArray<C> createTypedSparseArray(Parcel parcel, int i, Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        SparseArray<C> sparseArray = new SparseArray<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                parcel.setDataPosition(dataPosition + readSize);
                return sparseArray;
            }
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
            i2 = i3 + 1;
        }
    }

    public static void ensureAtEnd(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i, parcel);
    }

    public static int getFieldId(int i) {
        return i & 65535;
    }

    public static boolean readBoolean(Parcel parcel, int i) {
        b(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean readBooleanObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        boolean z = false;
        if (readSize == 0) {
            return false;
        }
        a(parcel, i, readSize, 4);
        if (parcel.readInt() != 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static byte readByte(Parcel parcel, int i) {
        b(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static char readChar(Parcel parcel, int i) {
        b(parcel, i, 4);
        return (char) parcel.readInt();
    }

    public static double readDouble(Parcel parcel, int i) {
        b(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double readDoubleObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        a(parcel, i, readSize, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float readFloat(Parcel parcel, int i) {
        b(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float readFloatObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        a(parcel, i, readSize, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int readHeader(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder readIBinder(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(readSize + dataPosition);
        return readStrongBinder;
    }

    public static int readInt(Parcel parcel, int i) {
        b(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer readIntegerObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        a(parcel, i, readSize, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static void readList(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize != 0) {
            a(parcel, readSize, dataPosition);
            parcel.readList(list, classLoader);
            parcel.setDataPosition(readSize + dataPosition);
        }
    }

    public static long readLong(Parcel parcel, int i) {
        b(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long readLongObject(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        a(parcel, i, readSize, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short readShort(Parcel parcel, int i) {
        b(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int readSize(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static void skipUnknownField(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        a(parcel, readSize, dataPosition);
        parcel.setDataPosition(readSize + dataPosition);
    }

    public static int validateObjectHeader(Parcel parcel) {
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int dataPosition = parcel.dataPosition();
        if (getFieldId(readHeader) != 20293) {
            String hexString = Integer.toHexString(readHeader);
            throw new ParseException(hexString.length() != 0 ? "Expected object header. Got 0x".concat(hexString) : "Expected object header. Got 0x", parcel);
        }
        int i = readSize + dataPosition;
        if (i < dataPosition || i > parcel.dataSize()) {
            throw new ParseException("invalid start=" + dataPosition + " end=" + i, parcel);
        }
        return i;
    }
}
