package android.os;

import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/os/Parcel.class */
public final class Parcel {
    private static final boolean DEBUG_ARRAY_MAP = false;
    private static final boolean DEBUG_RECYCLE = false;
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_HAS_REPLY_HEADER = -128;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final int POOL_SIZE = 6;
    private static final String TAG = "Parcel";
    private static final int VAL_BOOLEAN = 9;
    private static final int VAL_BOOLEANARRAY = 23;
    private static final int VAL_BUNDLE = 3;
    private static final int VAL_BYTE = 20;
    private static final int VAL_BYTEARRAY = 13;
    private static final int VAL_CHARSEQUENCE = 10;
    private static final int VAL_CHARSEQUENCEARRAY = 24;
    private static final int VAL_DOUBLE = 8;
    private static final int VAL_FLOAT = 7;
    private static final int VAL_IBINDER = 15;
    private static final int VAL_INTARRAY = 18;
    private static final int VAL_INTEGER = 1;
    private static final int VAL_LIST = 11;
    private static final int VAL_LONG = 6;
    private static final int VAL_LONGARRAY = 19;
    private static final int VAL_MAP = 2;
    private static final int VAL_NULL = -1;
    private static final int VAL_OBJECTARRAY = 17;
    private static final int VAL_PARCELABLE = 4;
    private static final int VAL_PARCELABLEARRAY = 16;
    private static final int VAL_PERSISTABLEBUNDLE = 25;
    private static final int VAL_SERIALIZABLE = 21;
    private static final int VAL_SHORT = 5;
    private static final int VAL_SIZE = 26;
    private static final int VAL_SIZEF = 27;
    private static final int VAL_SPARSEARRAY = 12;
    private static final int VAL_SPARSEBOOLEANARRAY = 22;
    private static final int VAL_STRING = 0;
    private static final int VAL_STRINGARRAY = 14;
    private long mNativePtr;
    private boolean mOwnsNativeParcelObject;
    private RuntimeException mStack;
    private static final Parcel[] sOwnedPool = new Parcel[6];
    private static final Parcel[] sHolderPool = new Parcel[6];
    public static final Parcelable.Creator<String> STRING_CREATOR = new Parcelable.Creator<String>() { // from class: android.os.Parcel.1
        @Override // android.os.Parcelable.Creator
        public String createFromParcel(Parcel parcel) {
            return parcel.readString();
        }

        @Override // android.os.Parcelable.Creator
        public String[] newArray(int i) {
            return new String[i];
        }
    };
    private static final HashMap<ClassLoader, HashMap<String, Parcelable.Creator>> mCreators = new HashMap<>();

    private Parcel(long j) {
        init(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void clearFileDescriptor(FileDescriptor fileDescriptor);

    static native void closeFileDescriptor(FileDescriptor fileDescriptor) throws IOException;

    private void destroy() {
        if (this.mNativePtr != 0) {
            if (this.mOwnsNativeParcelObject) {
                nativeDestroy(this.mNativePtr);
            }
            this.mNativePtr = 0L;
        }
    }

    static native FileDescriptor dupFileDescriptor(FileDescriptor fileDescriptor) throws IOException;

    private void freeBuffer() {
        if (this.mOwnsNativeParcelObject) {
            nativeFreeBuffer(this.mNativePtr);
        }
    }

    public static native long getGlobalAllocCount();

    public static native long getGlobalAllocSize();

    private void init(long j) {
        if (j != 0) {
            this.mNativePtr = j;
            this.mOwnsNativeParcelObject = false;
            return;
        }
        this.mNativePtr = nativeCreate();
        this.mOwnsNativeParcelObject = true;
    }

    private static native void nativeAppendFrom(long j, long j2, int i, int i2);

    private static native long nativeCreate();

    private static native byte[] nativeCreateByteArray(long j);

    private static native int nativeDataAvail(long j);

    private static native int nativeDataCapacity(long j);

    private static native int nativeDataPosition(long j);

    private static native int nativeDataSize(long j);

    private static native void nativeDestroy(long j);

    private static native void nativeEnforceInterface(long j, String str);

    private static native void nativeFreeBuffer(long j);

    private static native boolean nativeHasFileDescriptors(long j);

    private static native byte[] nativeMarshall(long j);

    private static native boolean nativePushAllowFds(long j, boolean z);

    private static native byte[] nativeReadBlob(long j);

    private static native double nativeReadDouble(long j);

    private static native FileDescriptor nativeReadFileDescriptor(long j);

    private static native float nativeReadFloat(long j);

    private static native int nativeReadInt(long j);

    private static native long nativeReadLong(long j);

    private static native String nativeReadString(long j);

    private static native IBinder nativeReadStrongBinder(long j);

    private static native void nativeRestoreAllowFds(long j, boolean z);

    private static native void nativeSetDataCapacity(long j, int i);

    private static native void nativeSetDataPosition(long j, int i);

    private static native void nativeSetDataSize(long j, int i);

    private static native void nativeUnmarshall(long j, byte[] bArr, int i, int i2);

    private static native void nativeWriteBlob(long j, byte[] bArr, int i, int i2);

    private static native void nativeWriteByteArray(long j, byte[] bArr, int i, int i2);

    private static native void nativeWriteDouble(long j, double d);

    private static native void nativeWriteFileDescriptor(long j, FileDescriptor fileDescriptor);

    private static native void nativeWriteFloat(long j, float f);

    private static native void nativeWriteInt(long j, int i);

    private static native void nativeWriteInterfaceToken(long j, String str);

    private static native void nativeWriteLong(long j, long j2);

    private static native void nativeWriteString(long j, String str);

    private static native void nativeWriteStrongBinder(long j, IBinder iBinder);

    public static Parcel obtain() {
        Parcel[] parcelArr = sOwnedPool;
        synchronized (parcelArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 6) {
                    return new Parcel(0L);
                }
                Parcel parcel = parcelArr[i2];
                if (parcel != null) {
                    parcelArr[i2] = null;
                    return parcel;
                }
                i = i2 + 1;
            }
        }
    }

    protected static final Parcel obtain(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final Parcel obtain(long j) {
        Parcel[] parcelArr = sHolderPool;
        synchronized (parcelArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 6) {
                    return new Parcel(j);
                }
                Parcel parcel = parcelArr[i2];
                if (parcel != null) {
                    parcelArr[i2] = null;
                    parcel.init(j);
                    return parcel;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native FileDescriptor openFileDescriptor(String str, int i) throws FileNotFoundException;

    private void readArrayInternal(Object[] objArr, int i, ClassLoader classLoader) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            objArr[i3] = readValue(classLoader);
            i2 = i3 + 1;
        }
    }

    private void readListInternal(List list, int i, ClassLoader classLoader) {
        while (i > 0) {
            list.add(readValue(classLoader));
            i--;
        }
    }

    private final Serializable readSerializable(final ClassLoader classLoader) {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(createByteArray())) { // from class: android.os.Parcel.2
                @Override // java.io.ObjectInputStream
                protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                    Class<?> cls;
                    return (classLoader == null || (cls = Class.forName(objectStreamClass.getName(), false, classLoader)) == null) ? super.resolveClass(objectStreamClass) : cls;
                }
            }.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Parcelable encountered IOException reading a Serializable object (name = " + readString + ")", e);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("Parcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e2);
        }
    }

    private void readSparseArrayInternal(SparseArray sparseArray, int i, ClassLoader classLoader) {
        while (i > 0) {
            sparseArray.append(readInt(), readValue(classLoader));
            i--;
        }
    }

    private void readSparseBooleanArrayInternal(SparseBooleanArray sparseBooleanArray, int i) {
        while (i > 0) {
            sparseBooleanArray.append(readInt(), readByte() == 1);
            i--;
        }
    }

    public final void appendFrom(Parcel parcel, int i, int i2) {
        nativeAppendFrom(this.mNativePtr, parcel.mNativePtr, i, i2);
    }

    public final IBinder[] createBinderArray() {
        IBinder[] iBinderArr;
        int readInt = readInt();
        if (readInt >= 0) {
            IBinder[] iBinderArr2 = new IBinder[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                iBinderArr = iBinderArr2;
                if (i2 >= readInt) {
                    break;
                }
                iBinderArr2[i2] = readStrongBinder();
                i = i2 + 1;
            }
        } else {
            iBinderArr = null;
        }
        return iBinderArr;
    }

    public final ArrayList<IBinder> createBinderArrayList() {
        ArrayList<IBinder> arrayList;
        int readInt = readInt();
        if (readInt >= 0) {
            ArrayList<IBinder> arrayList2 = new ArrayList<>(readInt);
            while (true) {
                arrayList = arrayList2;
                if (readInt <= 0) {
                    break;
                }
                arrayList2.add(readStrongBinder());
                readInt--;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public final boolean[] createBooleanArray() {
        boolean[] zArr;
        int readInt = readInt();
        if (readInt >= 0 && readInt <= (dataAvail() >> 2)) {
            boolean[] zArr2 = new boolean[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                zArr = zArr2;
                if (i2 >= readInt) {
                    break;
                }
                zArr2[i2] = readInt() != 0;
                i = i2 + 1;
            }
        } else {
            zArr = null;
        }
        return zArr;
    }

    public final byte[] createByteArray() {
        return nativeCreateByteArray(this.mNativePtr);
    }

    public final char[] createCharArray() {
        char[] cArr;
        int readInt = readInt();
        if (readInt >= 0 && readInt <= (dataAvail() >> 2)) {
            char[] cArr2 = new char[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                cArr = cArr2;
                if (i2 >= readInt) {
                    break;
                }
                cArr2[i2] = (char) readInt();
                i = i2 + 1;
            }
        } else {
            cArr = null;
        }
        return cArr;
    }

    public final double[] createDoubleArray() {
        double[] dArr;
        int readInt = readInt();
        if (readInt >= 0 && readInt <= (dataAvail() >> 3)) {
            double[] dArr2 = new double[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                dArr = dArr2;
                if (i2 >= readInt) {
                    break;
                }
                dArr2[i2] = readDouble();
                i = i2 + 1;
            }
        } else {
            dArr = null;
        }
        return dArr;
    }

    public final float[] createFloatArray() {
        float[] fArr;
        int readInt = readInt();
        if (readInt >= 0 && readInt <= (dataAvail() >> 2)) {
            float[] fArr2 = new float[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                fArr = fArr2;
                if (i2 >= readInt) {
                    break;
                }
                fArr2[i2] = readFloat();
                i = i2 + 1;
            }
        } else {
            fArr = null;
        }
        return fArr;
    }

    public final int[] createIntArray() {
        int[] iArr;
        int readInt = readInt();
        if (readInt >= 0 && readInt <= (dataAvail() >> 2)) {
            int[] iArr2 = new int[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                iArr = iArr2;
                if (i2 >= readInt) {
                    break;
                }
                iArr2[i2] = readInt();
                i = i2 + 1;
            }
        } else {
            iArr = null;
        }
        return iArr;
    }

    public final long[] createLongArray() {
        long[] jArr;
        int readInt = readInt();
        if (readInt >= 0 && readInt <= (dataAvail() >> 3)) {
            long[] jArr2 = new long[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                jArr = jArr2;
                if (i2 >= readInt) {
                    break;
                }
                jArr2[i2] = readLong();
                i = i2 + 1;
            }
        } else {
            jArr = null;
        }
        return jArr;
    }

    public final String[] createStringArray() {
        String[] strArr;
        int readInt = readInt();
        if (readInt >= 0) {
            String[] strArr2 = new String[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                strArr = strArr2;
                if (i2 >= readInt) {
                    break;
                }
                strArr2[i2] = readString();
                i = i2 + 1;
            }
        } else {
            strArr = null;
        }
        return strArr;
    }

    public final ArrayList<String> createStringArrayList() {
        ArrayList<String> arrayList;
        int readInt = readInt();
        if (readInt >= 0) {
            ArrayList<String> arrayList2 = new ArrayList<>(readInt);
            while (true) {
                arrayList = arrayList2;
                if (readInt <= 0) {
                    break;
                }
                arrayList2.add(readString());
                readInt--;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public final <T> T[] createTypedArray(Parcelable.Creator<T> creator) {
        T[] tArr;
        int readInt = readInt();
        if (readInt >= 0) {
            T[] newArray = creator.newArray(readInt);
            int i = 0;
            while (true) {
                int i2 = i;
                tArr = newArray;
                if (i2 >= readInt) {
                    break;
                }
                if (readInt() != 0) {
                    newArray[i2] = creator.createFromParcel(this);
                }
                i = i2 + 1;
            }
        } else {
            tArr = null;
        }
        return tArr;
    }

    public final <T> ArrayList<T> createTypedArrayList(Parcelable.Creator<T> creator) {
        ArrayList<T> arrayList;
        int readInt = readInt();
        if (readInt >= 0) {
            ArrayList<T> arrayList2 = new ArrayList<>(readInt);
            while (true) {
                arrayList = arrayList2;
                if (readInt <= 0) {
                    break;
                }
                if (readInt() != 0) {
                    arrayList2.add(creator.createFromParcel(this));
                } else {
                    arrayList2.add(null);
                }
                readInt--;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public final int dataAvail() {
        return nativeDataAvail(this.mNativePtr);
    }

    public final int dataCapacity() {
        return nativeDataCapacity(this.mNativePtr);
    }

    public final int dataPosition() {
        return nativeDataPosition(this.mNativePtr);
    }

    public final int dataSize() {
        return nativeDataSize(this.mNativePtr);
    }

    public final void enforceInterface(String str) {
        nativeEnforceInterface(this.mNativePtr, str);
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public final boolean hasFileDescriptors() {
        return nativeHasFileDescriptors(this.mNativePtr);
    }

    public final byte[] marshall() {
        return nativeMarshall(this.mNativePtr);
    }

    public final boolean pushAllowFds(boolean z) {
        return nativePushAllowFds(this.mNativePtr, z);
    }

    public final Object[] readArray(ClassLoader classLoader) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Object[] objArr = new Object[readInt];
        readArrayInternal(objArr, readInt, classLoader);
        return objArr;
    }

    public final ArrayList readArrayList(ClassLoader classLoader) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        readListInternal(arrayList, readInt, classLoader);
        return arrayList;
    }

    public void readArrayMap(ArrayMap arrayMap, ClassLoader classLoader) {
        int readInt = readInt();
        if (readInt < 0) {
            return;
        }
        readArrayMapInternal(arrayMap, readInt, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readArrayMapInternal(ArrayMap arrayMap, int i, ClassLoader classLoader) {
        while (i > 0) {
            arrayMap.append(readString(), readValue(classLoader));
            i--;
        }
        arrayMap.validate();
    }

    void readArrayMapSafelyInternal(ArrayMap arrayMap, int i, ClassLoader classLoader) {
        while (i > 0) {
            arrayMap.put(readString(), readValue(classLoader));
            i--;
        }
    }

    public final void readBinderArray(IBinder[] iBinderArr) {
        int readInt = readInt();
        if (readInt != iBinderArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            iBinderArr[i2] = readStrongBinder();
            i = i2 + 1;
        }
    }

    public final void readBinderList(List<IBinder> list) {
        int i;
        int i2;
        int size = list.size();
        int readInt = readInt();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i = i4;
            if (i4 >= size) {
                break;
            }
            i = i4;
            if (i4 >= readInt) {
                break;
            }
            list.set(i4, readStrongBinder());
            i3 = i4 + 1;
        }
        while (true) {
            if (i >= readInt) {
                break;
            }
            list.add(readStrongBinder());
            i++;
        }
        for (i2 = i; i2 < size; i2++) {
            list.remove(readInt);
        }
    }

    public final byte[] readBlob() {
        return nativeReadBlob(this.mNativePtr);
    }

    public final void readBooleanArray(boolean[] zArr) {
        int readInt = readInt();
        if (readInt != zArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            zArr[i2] = readInt() != 0;
            i = i2 + 1;
        }
    }

    public final Bundle readBundle() {
        return readBundle(null);
    }

    public final Bundle readBundle(ClassLoader classLoader) {
        Bundle bundle;
        int readInt = readInt();
        if (readInt < 0) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle(this, readInt);
            bundle = bundle2;
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
                return bundle2;
            }
        }
        return bundle;
    }

    public final byte readByte() {
        return (byte) (readInt() & 255);
    }

    public final void readByteArray(byte[] bArr) {
        byte[] createByteArray = createByteArray();
        if (createByteArray.length != bArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        System.arraycopy(createByteArray, 0, bArr, 0, createByteArray.length);
    }

    public final void readCharArray(char[] cArr) {
        int readInt = readInt();
        if (readInt != cArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            cArr[i2] = (char) readInt();
            i = i2 + 1;
        }
    }

    public final CharSequence readCharSequence() {
        return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
    }

    public final CharSequence[] readCharSequenceArray() {
        CharSequence[] charSequenceArr = null;
        int readInt = readInt();
        if (readInt >= 0) {
            CharSequence[] charSequenceArr2 = new CharSequence[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                charSequenceArr = charSequenceArr2;
                if (i2 >= readInt) {
                    break;
                }
                charSequenceArr2[i2] = readCharSequence();
                i = i2 + 1;
            }
        }
        return charSequenceArr;
    }

    public final <T extends Parcelable> T readCreator(Parcelable.Creator<T> creator, ClassLoader classLoader) {
        return creator instanceof Parcelable.ClassLoaderCreator ? (T) ((Parcelable.ClassLoaderCreator) creator).createFromParcel(this, classLoader) : creator.createFromParcel(this);
    }

    public final double readDouble() {
        return nativeReadDouble(this.mNativePtr);
    }

    public final void readDoubleArray(double[] dArr) {
        int readInt = readInt();
        if (readInt != dArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            dArr[i2] = readDouble();
            i = i2 + 1;
        }
    }

    public final void readException() {
        int readExceptionCode = readExceptionCode();
        if (readExceptionCode != 0) {
            readException(readExceptionCode, readString());
        }
    }

    public final void readException(int i, String str) {
        switch (i) {
            case -7:
                throw new UnsupportedOperationException(str);
            case -6:
                throw new NetworkOnMainThreadException();
            case -5:
                throw new IllegalStateException(str);
            case -4:
                throw new NullPointerException(str);
            case -3:
                throw new IllegalArgumentException(str);
            case -2:
                throw new BadParcelableException(str);
            case -1:
                throw new SecurityException(str);
            default:
                throw new RuntimeException("Unknown exception code: " + i + " msg " + str);
        }
    }

    public final int readExceptionCode() {
        int readInt = readInt();
        int i = readInt;
        if (readInt == -128) {
            if (readInt() == 0) {
                Log.e(TAG, "Unexpected zero-sized Parcel reply header.");
            } else {
                StrictMode.readAndHandleBinderCallViolations(this);
            }
            i = 0;
        }
        return i;
    }

    public final ParcelFileDescriptor readFileDescriptor() {
        FileDescriptor nativeReadFileDescriptor = nativeReadFileDescriptor(this.mNativePtr);
        if (nativeReadFileDescriptor != null) {
            return new ParcelFileDescriptor(nativeReadFileDescriptor);
        }
        return null;
    }

    public final float readFloat() {
        return nativeReadFloat(this.mNativePtr);
    }

    public final void readFloatArray(float[] fArr) {
        int readInt = readInt();
        if (readInt != fArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            fArr[i2] = readFloat();
            i = i2 + 1;
        }
    }

    public final HashMap readHashMap(ClassLoader classLoader) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(readInt);
        readMapInternal(hashMap, readInt, classLoader);
        return hashMap;
    }

    public final int readInt() {
        return nativeReadInt(this.mNativePtr);
    }

    public final void readIntArray(int[] iArr) {
        int readInt = readInt();
        if (readInt != iArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            iArr[i2] = readInt();
            i = i2 + 1;
        }
    }

    public final void readList(List list, ClassLoader classLoader) {
        readListInternal(list, readInt(), classLoader);
    }

    public final long readLong() {
        return nativeReadLong(this.mNativePtr);
    }

    public final void readLongArray(long[] jArr) {
        int readInt = readInt();
        if (readInt != jArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            jArr[i2] = readLong();
            i = i2 + 1;
        }
    }

    public final void readMap(Map map, ClassLoader classLoader) {
        readMapInternal(map, readInt(), classLoader);
    }

    void readMapInternal(Map map, int i, ClassLoader classLoader) {
        while (i > 0) {
            map.put(readValue(classLoader), readValue(classLoader));
            i--;
        }
    }

    public final <T extends Parcelable> T readParcelable(ClassLoader classLoader) {
        Parcelable.Creator<T> readParcelableCreator = readParcelableCreator(classLoader);
        if (readParcelableCreator == null) {
            return null;
        }
        return readParcelableCreator instanceof Parcelable.ClassLoaderCreator ? (T) ((Parcelable.ClassLoaderCreator) readParcelableCreator).createFromParcel(this, classLoader) : readParcelableCreator.createFromParcel(this);
    }

    public final Parcelable[] readParcelableArray(ClassLoader classLoader) {
        Parcelable[] parcelableArr;
        int readInt = readInt();
        if (readInt >= 0) {
            Parcelable[] parcelableArr2 = new Parcelable[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                parcelableArr = parcelableArr2;
                if (i2 >= readInt) {
                    break;
                }
                parcelableArr2[i2] = readParcelable(classLoader);
                i = i2 + 1;
            }
        } else {
            parcelableArr = null;
        }
        return parcelableArr;
    }

    public final <T extends Parcelable> Parcelable.Creator<T> readParcelableCreator(ClassLoader classLoader) {
        Parcelable.Creator<T> creator;
        String readString = readString();
        if (readString == null) {
            return null;
        }
        synchronized (mCreators) {
            HashMap<String, Parcelable.Creator> hashMap = mCreators.get(classLoader);
            HashMap<String, Parcelable.Creator> hashMap2 = hashMap;
            if (hashMap == null) {
                hashMap2 = new HashMap<>();
                mCreators.put(classLoader, hashMap2);
            }
            Parcelable.Creator<T> creator2 = hashMap2.get(readString);
            creator = creator2;
            if (creator2 == null) {
                try {
                    try {
                        try {
                            try {
                                creator = (Parcelable.Creator) (classLoader == null ? Class.forName(readString) : Class.forName(readString, true, classLoader)).getField("CREATOR").get(null);
                                if (creator == null) {
                                    throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class " + readString);
                                }
                                hashMap2.put(readString, creator);
                            } catch (IllegalAccessException e) {
                                Log.e(TAG, "Illegal access when unmarshalling: " + readString, e);
                                throw new BadParcelableException("IllegalAccessException when unmarshalling: " + readString);
                            } catch (NoSuchFieldException e2) {
                                throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class " + readString);
                            }
                        } catch (ClassNotFoundException e3) {
                            Log.e(TAG, "Class not found when unmarshalling: " + readString, e3);
                            throw new BadParcelableException("ClassNotFoundException when unmarshalling: " + readString);
                        }
                    } catch (NullPointerException e4) {
                        throw new BadParcelableException("Parcelable protocol requires the CREATOR object to be static on class " + readString);
                    }
                } catch (ClassCastException e5) {
                    throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class " + readString);
                }
            }
        }
        return creator;
    }

    public final PersistableBundle readPersistableBundle() {
        return readPersistableBundle(null);
    }

    public final PersistableBundle readPersistableBundle(ClassLoader classLoader) {
        PersistableBundle persistableBundle;
        int readInt = readInt();
        if (readInt < 0) {
            persistableBundle = null;
        } else {
            PersistableBundle persistableBundle2 = new PersistableBundle(this, readInt);
            persistableBundle = persistableBundle2;
            if (classLoader != null) {
                persistableBundle2.setClassLoader(classLoader);
                return persistableBundle2;
            }
        }
        return persistableBundle;
    }

    public final FileDescriptor readRawFileDescriptor() {
        return nativeReadFileDescriptor(this.mNativePtr);
    }

    public final Serializable readSerializable() {
        return readSerializable(null);
    }

    public final Size readSize() {
        return new Size(readInt(), readInt());
    }

    public final SizeF readSizeF() {
        return new SizeF(readFloat(), readFloat());
    }

    public final SparseArray readSparseArray(ClassLoader classLoader) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseArray sparseArray = new SparseArray(readInt);
        readSparseArrayInternal(sparseArray, readInt, classLoader);
        return sparseArray;
    }

    public final SparseBooleanArray readSparseBooleanArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(readInt);
        readSparseBooleanArrayInternal(sparseBooleanArray, readInt);
        return sparseBooleanArray;
    }

    public final String readString() {
        return nativeReadString(this.mNativePtr);
    }

    public final void readStringArray(String[] strArr) {
        int readInt = readInt();
        if (readInt != strArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            strArr[i2] = readString();
            i = i2 + 1;
        }
    }

    public final String[] readStringArray() {
        String[] strArr = null;
        int readInt = readInt();
        if (readInt >= 0) {
            String[] strArr2 = new String[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                strArr = strArr2;
                if (i2 >= readInt) {
                    break;
                }
                strArr2[i2] = readString();
                i = i2 + 1;
            }
        }
        return strArr;
    }

    public final void readStringList(List<String> list) {
        int i;
        int i2;
        int size = list.size();
        int readInt = readInt();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i = i4;
            if (i4 >= size) {
                break;
            }
            i = i4;
            if (i4 >= readInt) {
                break;
            }
            list.set(i4, readString());
            i3 = i4 + 1;
        }
        while (true) {
            if (i >= readInt) {
                break;
            }
            list.add(readString());
            i++;
        }
        for (i2 = i; i2 < size; i2++) {
            list.remove(readInt);
        }
    }

    public final IBinder readStrongBinder() {
        return nativeReadStrongBinder(this.mNativePtr);
    }

    public final <T> void readTypedArray(T[] tArr, Parcelable.Creator<T> creator) {
        int readInt = readInt();
        if (readInt != tArr.length) {
            throw new RuntimeException("bad array lengths");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            if (readInt() != 0) {
                tArr[i2] = creator.createFromParcel(this);
            } else {
                tArr[i2] = null;
            }
            i = i2 + 1;
        }
    }

    @Deprecated
    public final <T> T[] readTypedArray(Parcelable.Creator<T> creator) {
        return (T[]) createTypedArray(creator);
    }

    public final <T> void readTypedList(List<T> list, Parcelable.Creator<T> creator) {
        int i;
        int i2;
        int size = list.size();
        int readInt = readInt();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i = i4;
            if (i4 >= size) {
                break;
            }
            i = i4;
            if (i4 >= readInt) {
                break;
            }
            if (readInt() != 0) {
                list.set(i4, creator.createFromParcel(this));
            } else {
                list.set(i4, null);
            }
            i3 = i4 + 1;
        }
        while (true) {
            if (i >= readInt) {
                break;
            }
            if (readInt() != 0) {
                list.add(creator.createFromParcel(this));
            } else {
                list.add(null);
            }
            i++;
        }
        for (i2 = i; i2 < size; i2++) {
            list.remove(readInt);
        }
    }

    public final Object readValue(ClassLoader classLoader) {
        boolean z = true;
        int readInt = readInt();
        switch (readInt) {
            case -1:
                return null;
            case 0:
                return readString();
            case 1:
                return Integer.valueOf(readInt());
            case 2:
                return readHashMap(classLoader);
            case 3:
                return readBundle(classLoader);
            case 4:
                return readParcelable(classLoader);
            case 5:
                return Short.valueOf((short) readInt());
            case 6:
                return Long.valueOf(readLong());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Double.valueOf(readDouble());
            case 9:
                if (readInt() != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 10:
                return readCharSequence();
            case 11:
                return readArrayList(classLoader);
            case 12:
                return readSparseArray(classLoader);
            case 13:
                return createByteArray();
            case 14:
                return readStringArray();
            case 15:
                return readStrongBinder();
            case 16:
                return readParcelableArray(classLoader);
            case 17:
                return readArray(classLoader);
            case 18:
                return createIntArray();
            case 19:
                return createLongArray();
            case 20:
                return Byte.valueOf(readByte());
            case 21:
                return readSerializable(classLoader);
            case 22:
                return readSparseBooleanArray();
            case 23:
                return createBooleanArray();
            case 24:
                return readCharSequenceArray();
            case 25:
                return readPersistableBundle(classLoader);
            case 26:
                return readSize();
            case 27:
                return readSizeF();
            default:
                throw new RuntimeException("Parcel " + this + ": Unmarshalling unknown type code " + readInt + " at offset " + (dataPosition() - 4));
        }
    }

    public final void recycle() {
        Parcel[] parcelArr;
        freeBuffer();
        if (this.mOwnsNativeParcelObject) {
            parcelArr = sOwnedPool;
        } else {
            this.mNativePtr = 0L;
            parcelArr = sHolderPool;
        }
        synchronized (parcelArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                try {
                    if (i2 >= 6) {
                        return;
                    }
                    if (parcelArr[i2] == null) {
                        parcelArr[i2] = this;
                        return;
                    }
                    i = i2 + 1;
                } finally {
                    Parcel[] parcelArr2 = parcelArr;
                }
            }
        }
    }

    public final void restoreAllowFds(boolean z) {
        nativeRestoreAllowFds(this.mNativePtr, z);
    }

    public final void setDataCapacity(int i) {
        nativeSetDataCapacity(this.mNativePtr, i);
    }

    public final void setDataPosition(int i) {
        nativeSetDataPosition(this.mNativePtr, i);
    }

    public final void setDataSize(int i) {
        nativeSetDataSize(this.mNativePtr, i);
    }

    public final void unmarshall(byte[] bArr, int i, int i2) {
        nativeUnmarshall(this.mNativePtr, bArr, i, i2);
    }

    public final void writeArray(Object[] objArr) {
        if (objArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(objArr.length);
        for (Object obj : objArr) {
            writeValue(obj);
        }
    }

    public void writeArrayMap(ArrayMap<String, Object> arrayMap) {
        writeArrayMapInternal(arrayMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeArrayMapInternal(ArrayMap<String, Object> arrayMap) {
        if (arrayMap == null) {
            writeInt(-1);
            return;
        }
        int size = arrayMap.size();
        writeInt(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            writeString(arrayMap.keyAt(i2));
            writeValue(arrayMap.valueAt(i2));
            i = i2 + 1;
        }
    }

    public final void writeBinderArray(IBinder[] iBinderArr) {
        if (iBinderArr == null) {
            writeInt(-1);
            return;
        }
        int length = iBinderArr.length;
        writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeStrongBinder(iBinderArr[i2]);
            i = i2 + 1;
        }
    }

    public final void writeBinderList(List<IBinder> list) {
        if (list == null) {
            writeInt(-1);
            return;
        }
        int size = list.size();
        writeInt(size);
        for (int i = 0; i < size; i++) {
            writeStrongBinder(list.get(i));
        }
    }

    public final void writeBlob(byte[] bArr) {
        nativeWriteBlob(this.mNativePtr, bArr, 0, bArr != null ? bArr.length : 0);
    }

    public final void writeBooleanArray(boolean[] zArr) {
        if (zArr == null) {
            writeInt(-1);
            return;
        }
        int length = zArr.length;
        writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeInt(zArr[i2] ? 1 : 0);
            i = i2 + 1;
        }
    }

    public final void writeBundle(Bundle bundle) {
        if (bundle == null) {
            writeInt(-1);
        } else {
            bundle.writeToParcel(this, 0);
        }
    }

    public final void writeByte(byte b) {
        writeInt(b);
    }

    public final void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr != null ? bArr.length : 0);
    }

    public final void writeByteArray(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            writeInt(-1);
            return;
        }
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        nativeWriteByteArray(this.mNativePtr, bArr, i, i2);
    }

    public final void writeCharArray(char[] cArr) {
        if (cArr == null) {
            writeInt(-1);
            return;
        }
        int length = cArr.length;
        writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeInt(cArr[i2]);
            i = i2 + 1;
        }
    }

    public final void writeCharSequence(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this, 0);
    }

    public final void writeCharSequenceArray(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            writeInt(-1);
            return;
        }
        int length = charSequenceArr.length;
        writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeCharSequence(charSequenceArr[i2]);
            i = i2 + 1;
        }
    }

    public final void writeDouble(double d) {
        nativeWriteDouble(this.mNativePtr, d);
    }

    public final void writeDoubleArray(double[] dArr) {
        if (dArr == null) {
            writeInt(-1);
            return;
        }
        int length = dArr.length;
        writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeDouble(dArr[i2]);
            i = i2 + 1;
        }
    }

    public final void writeException(Exception exc) {
        int i = 0;
        if (exc instanceof SecurityException) {
            i = -1;
        } else if (exc instanceof BadParcelableException) {
            i = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i = -3;
        } else if (exc instanceof NullPointerException) {
            i = -4;
        } else if (exc instanceof IllegalStateException) {
            i = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i = -6;
        } else if (exc instanceof UnsupportedOperationException) {
            i = -7;
        }
        writeInt(i);
        StrictMode.clearGatheredViolations();
        if (i != 0) {
            writeString(exc.getMessage());
        } else if (!(exc instanceof RuntimeException)) {
            throw new RuntimeException(exc);
        } else {
            throw ((RuntimeException) exc);
        }
    }

    public final void writeFileDescriptor(FileDescriptor fileDescriptor) {
        nativeWriteFileDescriptor(this.mNativePtr, fileDescriptor);
    }

    public final void writeFloat(float f) {
        nativeWriteFloat(this.mNativePtr, f);
    }

    public final void writeFloatArray(float[] fArr) {
        if (fArr == null) {
            writeInt(-1);
            return;
        }
        int length = fArr.length;
        writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeFloat(fArr[i2]);
            i = i2 + 1;
        }
    }

    public final void writeInt(int i) {
        nativeWriteInt(this.mNativePtr, i);
    }

    public final void writeIntArray(int[] iArr) {
        if (iArr == null) {
            writeInt(-1);
            return;
        }
        int length = iArr.length;
        writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeInt(iArr[i2]);
            i = i2 + 1;
        }
    }

    public final void writeInterfaceToken(String str) {
        nativeWriteInterfaceToken(this.mNativePtr, str);
    }

    public final void writeList(List list) {
        if (list == null) {
            writeInt(-1);
            return;
        }
        int size = list.size();
        writeInt(size);
        for (int i = 0; i < size; i++) {
            writeValue(list.get(i));
        }
    }

    public final void writeLong(long j) {
        nativeWriteLong(this.mNativePtr, j);
    }

    public final void writeLongArray(long[] jArr) {
        if (jArr == null) {
            writeInt(-1);
            return;
        }
        int length = jArr.length;
        writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeLong(jArr[i2]);
            i = i2 + 1;
        }
    }

    public final void writeMap(Map map) {
        writeMapInternal(map);
    }

    void writeMapInternal(Map<String, Object> map) {
        if (map == null) {
            writeInt(-1);
            return;
        }
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        writeInt(entrySet.size());
        for (Map.Entry<String, Object> entry : entrySet) {
            writeValue(entry.getKey());
            writeValue(entry.getValue());
        }
    }

    public final void writeNoException() {
        if (!StrictMode.hasGatheredViolations()) {
            writeInt(0);
            return;
        }
        writeInt(-128);
        int dataPosition = dataPosition();
        writeInt(0);
        StrictMode.writeGatheredViolationsToParcel(this);
        int dataPosition2 = dataPosition();
        setDataPosition(dataPosition);
        writeInt(dataPosition2 - dataPosition);
        setDataPosition(dataPosition2);
    }

    public final void writeParcelable(Parcelable parcelable, int i) {
        if (parcelable == null) {
            writeString(null);
            return;
        }
        writeString(parcelable.getClass().getName());
        parcelable.writeToParcel(this, i);
    }

    public final <T extends Parcelable> void writeParcelableArray(T[] tArr, int i) {
        if (tArr == null) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            writeParcelable(tArr[i3], i);
            i2 = i3 + 1;
        }
    }

    public final void writeParcelableCreator(Parcelable parcelable) {
        writeString(parcelable.getClass().getName());
    }

    public final void writePersistableBundle(PersistableBundle persistableBundle) {
        if (persistableBundle == null) {
            writeInt(-1);
        } else {
            persistableBundle.writeToParcel(this, 0);
        }
    }

    public final void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Parcelable encountered IOException writing serializable object (name = " + name + ")", e);
        }
    }

    public final void writeSize(Size size) {
        writeInt(size.getWidth());
        writeInt(size.getHeight());
    }

    public final void writeSizeF(SizeF sizeF) {
        writeFloat(sizeF.getWidth());
        writeFloat(sizeF.getHeight());
    }

    public final void writeSparseArray(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseArray.size();
        writeInt(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            writeInt(sparseArray.keyAt(i2));
            writeValue(sparseArray.valueAt(i2));
            i = i2 + 1;
        }
    }

    public final void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            writeInt(sparseBooleanArray.keyAt(i2));
            writeByte((byte) (sparseBooleanArray.valueAt(i2) ? 1 : 0));
            i = i2 + 1;
        }
    }

    public final void writeString(String str) {
        nativeWriteString(this.mNativePtr, str);
    }

    public final void writeStringArray(String[] strArr) {
        if (strArr == null) {
            writeInt(-1);
            return;
        }
        int length = strArr.length;
        writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeString(strArr[i2]);
            i = i2 + 1;
        }
    }

    public final void writeStringList(List<String> list) {
        if (list == null) {
            writeInt(-1);
            return;
        }
        int size = list.size();
        writeInt(size);
        for (int i = 0; i < size; i++) {
            writeString(list.get(i));
        }
    }

    public final void writeStrongBinder(IBinder iBinder) {
        nativeWriteStrongBinder(this.mNativePtr, iBinder);
    }

    public final void writeStrongInterface(IInterface iInterface) {
        writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    public final <T extends Parcelable> void writeTypedArray(T[] tArr, int i) {
        if (tArr == null) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            T t = tArr[i3];
            if (t != null) {
                writeInt(1);
                t.writeToParcel(this, i);
            } else {
                writeInt(0);
            }
            i2 = i3 + 1;
        }
    }

    public final <T extends Parcelable> void writeTypedList(List<T> list) {
        if (list == null) {
            writeInt(-1);
            return;
        }
        int size = list.size();
        writeInt(size);
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            if (t != null) {
                writeInt(1);
                t.writeToParcel(this, 0);
            } else {
                writeInt(0);
            }
        }
    }

    public final void writeValue(Object obj) {
        int i = 1;
        if (obj == null) {
            writeInt(-1);
        } else if (obj instanceof String) {
            writeInt(0);
            writeString((String) obj);
        } else if (obj instanceof Integer) {
            writeInt(1);
            writeInt(((Integer) obj).intValue());
        } else if (obj instanceof Map) {
            writeInt(2);
            writeMap((Map) obj);
        } else if (obj instanceof Bundle) {
            writeInt(3);
            writeBundle((Bundle) obj);
        } else if (obj instanceof Parcelable) {
            writeInt(4);
            writeParcelable((Parcelable) obj, 0);
        } else if (obj instanceof Short) {
            writeInt(5);
            writeInt(((Short) obj).intValue());
        } else if (obj instanceof Long) {
            writeInt(6);
            writeLong(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            writeInt(7);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            writeInt(8);
            writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writeInt(9);
            if (!((Boolean) obj).booleanValue()) {
                i = 0;
            }
            writeInt(i);
        } else if (obj instanceof CharSequence) {
            writeInt(10);
            writeCharSequence((CharSequence) obj);
        } else if (obj instanceof List) {
            writeInt(11);
            writeList((List) obj);
        } else if (obj instanceof SparseArray) {
            writeInt(12);
            writeSparseArray((SparseArray) obj);
        } else if (obj instanceof boolean[]) {
            writeInt(23);
            writeBooleanArray((boolean[]) obj);
        } else if (obj instanceof byte[]) {
            writeInt(13);
            writeByteArray((byte[]) obj);
        } else if (obj instanceof String[]) {
            writeInt(14);
            writeStringArray((String[]) obj);
        } else if (obj instanceof CharSequence[]) {
            writeInt(24);
            writeCharSequenceArray((CharSequence[]) obj);
        } else if (obj instanceof IBinder) {
            writeInt(15);
            writeStrongBinder((IBinder) obj);
        } else if (obj instanceof Parcelable[]) {
            writeInt(16);
            writeParcelableArray((Parcelable[]) obj, 0);
        } else if (obj instanceof int[]) {
            writeInt(18);
            writeIntArray((int[]) obj);
        } else if (obj instanceof long[]) {
            writeInt(19);
            writeLongArray((long[]) obj);
        } else if (obj instanceof Byte) {
            writeInt(20);
            writeInt(((Byte) obj).byteValue());
        } else if (obj instanceof PersistableBundle) {
            writeInt(25);
            writePersistableBundle((PersistableBundle) obj);
        } else if (obj instanceof Size) {
            writeInt(26);
            writeSize((Size) obj);
        } else if (obj instanceof SizeF) {
            writeInt(27);
            writeSizeF((SizeF) obj);
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isArray() && cls.getComponentType() == Object.class) {
                writeInt(17);
                writeArray((Object[]) obj);
            } else if (!(obj instanceof Serializable)) {
                throw new RuntimeException("Parcel: unable to marshal value " + obj);
            } else {
                writeInt(21);
                writeSerializable((Serializable) obj);
            }
        }
    }
}
