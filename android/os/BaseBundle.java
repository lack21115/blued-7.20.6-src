package android.os;

import android.util.ArrayMap;
import android.util.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/os/BaseBundle.class */
public class BaseBundle {
    static final int BUNDLE_MAGIC = 1279544898;
    static final boolean DEBUG = false;
    static final Parcel EMPTY_PARCEL = Parcel.obtain();
    private static final String TAG = "Bundle";
    private ClassLoader mClassLoader;
    ArrayMap<String, Object> mMap;
    Parcel mParcelledData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseBundle() {
        this((ClassLoader) null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseBundle(int i) {
        this((ClassLoader) null, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseBundle(BaseBundle baseBundle) {
        this.mMap = null;
        this.mParcelledData = null;
        if (baseBundle.mParcelledData == null) {
            this.mParcelledData = null;
        } else if (baseBundle.mParcelledData == EMPTY_PARCEL) {
            this.mParcelledData = EMPTY_PARCEL;
        } else {
            this.mParcelledData = Parcel.obtain();
            this.mParcelledData.appendFrom(baseBundle.mParcelledData, 0, baseBundle.mParcelledData.dataSize());
            this.mParcelledData.setDataPosition(0);
        }
        if (baseBundle.mMap != null) {
            this.mMap = new ArrayMap<>(baseBundle.mMap);
        } else {
            this.mMap = null;
        }
        this.mClassLoader = baseBundle.mClassLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseBundle(Parcel parcel) {
        this.mMap = null;
        this.mParcelledData = null;
        readFromParcelInner(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseBundle(Parcel parcel, int i) {
        this.mMap = null;
        this.mParcelledData = null;
        readFromParcelInner(parcel, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseBundle(ClassLoader classLoader) {
        this(classLoader, 0);
    }

    BaseBundle(ClassLoader classLoader, int i) {
        this.mMap = null;
        this.mParcelledData = null;
        this.mMap = i > 0 ? new ArrayMap<>(i) : new ArrayMap<>();
        this.mClassLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
    }

    private void readFromParcelInner(Parcel parcel, int i) {
        if (i == 0) {
            this.mParcelledData = EMPTY_PARCEL;
            return;
        }
        int readInt = parcel.readInt();
        if (readInt != BUNDLE_MAGIC) {
            throw new IllegalStateException("Bad magic number for Bundle: 0x" + Integer.toHexString(readInt));
        }
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(dataPosition + i);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.appendFrom(parcel, dataPosition, i);
        obtain.setDataPosition(0);
        this.mParcelledData = obtain;
    }

    public void clear() {
        unparcel();
        this.mMap.clear();
    }

    public boolean containsKey(String str) {
        unparcel();
        return this.mMap.containsKey(str);
    }

    public Object get(String str) {
        unparcel();
        return this.mMap.get(str);
    }

    public boolean getBoolean(String str) {
        unparcel();
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return z;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Boolean", Boolean.valueOf(z), e);
            return z;
        }
    }

    public boolean[] getBooleanArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (boolean[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "byte[]", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte getByte(String str) {
        unparcel();
        return getByte(str, (byte) 0).byteValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Byte getByte(String str, byte b) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return Byte.valueOf(b);
        }
        try {
            return (Byte) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Byte", Byte.valueOf(b), e);
            return Byte.valueOf(b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getByteArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (byte[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "byte[]", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char getChar(String str) {
        unparcel();
        return getChar(str, (char) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char getChar(String str, char c2) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return c2;
        }
        try {
            return ((Character) obj).charValue();
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Character", Character.valueOf(c2), e);
            return c2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char[] getCharArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (char[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "char[]", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getCharSequence(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        try {
            return (CharSequence) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "CharSequence", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getCharSequence(String str, CharSequence charSequence) {
        CharSequence charSequence2 = getCharSequence(str);
        return charSequence2 == null ? charSequence : charSequence2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence[] getCharSequenceArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (CharSequence[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "CharSequence[]", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<CharSequence> getCharSequenceArrayList(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "ArrayList<CharSequence>", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public double getDouble(String str) {
        unparcel();
        return getDouble(str, 0.0d);
    }

    public double getDouble(String str, double d) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return d;
        }
        try {
            return ((Double) obj).doubleValue();
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Double", Double.valueOf(d), e);
            return d;
        }
    }

    public double[] getDoubleArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (double[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "double[]", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFloat(String str) {
        unparcel();
        return getFloat(str, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFloat(String str, float f) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return f;
        }
        try {
            return ((Float) obj).floatValue();
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Float", Float.valueOf(f), e);
            return f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] getFloatArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (float[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "float[]", e);
            return null;
        }
    }

    public int getInt(String str) {
        unparcel();
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return i;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Integer", Integer.valueOf(i), e);
            return i;
        }
    }

    public int[] getIntArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (int[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "int[]", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Integer> getIntegerArrayList(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "ArrayList<Integer>", e);
            return null;
        }
    }

    public long getLong(String str) {
        unparcel();
        return getLong(str, 0L);
    }

    public long getLong(String str, long j) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return j;
        }
        try {
            return ((Long) obj).longValue();
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Long", Long.valueOf(j), e);
            return j;
        }
    }

    public long[] getLongArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (long[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "long[]", e);
            return null;
        }
    }

    public String getPairValue() {
        unparcel();
        int size = this.mMap.size();
        if (size > 1) {
            Log.w(TAG, "getPairValue() used on Bundle with multiple pairs.");
        }
        if (size == 0) {
            return null;
        }
        Object valueAt = this.mMap.valueAt(0);
        try {
            return (String) valueAt;
        } catch (ClassCastException e) {
            typeWarning("getPairValue()", valueAt, "String", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Serializable getSerializable(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (Serializable) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Serializable", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short getShort(String str) {
        unparcel();
        return getShort(str, (short) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short getShort(String str, short s) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return s;
        }
        try {
            return ((Short) obj).shortValue();
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Short", Short.valueOf(s), e);
            return s;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short[] getShortArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (short[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "short[]", e);
            return null;
        }
    }

    public String getString(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        try {
            return (String) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "String", e);
            return null;
        }
    }

    public String getString(String str, String str2) {
        String string = getString(str);
        return string == null ? str2 : string;
    }

    public String[] getStringArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (String[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "String[]", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> getStringArrayList(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "ArrayList<String>", e);
            return null;
        }
    }

    public boolean isEmpty() {
        unparcel();
        return this.mMap.isEmpty();
    }

    public boolean isParcelled() {
        return this.mParcelledData != null;
    }

    public Set<String> keySet() {
        unparcel();
        return this.mMap.keySet();
    }

    public void putAll(PersistableBundle persistableBundle) {
        unparcel();
        persistableBundle.unparcel();
        this.mMap.putAll((ArrayMap<? extends String, ? extends Object>) persistableBundle.mMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putAll(Map map) {
        unparcel();
        this.mMap.putAll(map);
    }

    public void putBoolean(String str, boolean z) {
        unparcel();
        this.mMap.put(str, Boolean.valueOf(z));
    }

    public void putBooleanArray(String str, boolean[] zArr) {
        unparcel();
        this.mMap.put(str, zArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putByte(String str, byte b) {
        unparcel();
        this.mMap.put(str, Byte.valueOf(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putByteArray(String str, byte[] bArr) {
        unparcel();
        this.mMap.put(str, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putChar(String str, char c2) {
        unparcel();
        this.mMap.put(str, Character.valueOf(c2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putCharArray(String str, char[] cArr) {
        unparcel();
        this.mMap.put(str, cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putCharSequence(String str, CharSequence charSequence) {
        unparcel();
        this.mMap.put(str, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putCharSequenceArray(String str, CharSequence[] charSequenceArr) {
        unparcel();
        this.mMap.put(str, charSequenceArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putCharSequenceArrayList(String str, ArrayList<CharSequence> arrayList) {
        unparcel();
        this.mMap.put(str, arrayList);
    }

    public void putDouble(String str, double d) {
        unparcel();
        this.mMap.put(str, Double.valueOf(d));
    }

    public void putDoubleArray(String str, double[] dArr) {
        unparcel();
        this.mMap.put(str, dArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putFloat(String str, float f) {
        unparcel();
        this.mMap.put(str, Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putFloatArray(String str, float[] fArr) {
        unparcel();
        this.mMap.put(str, fArr);
    }

    public void putInt(String str, int i) {
        unparcel();
        this.mMap.put(str, Integer.valueOf(i));
    }

    public void putIntArray(String str, int[] iArr) {
        unparcel();
        this.mMap.put(str, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        unparcel();
        this.mMap.put(str, arrayList);
    }

    public void putLong(String str, long j) {
        unparcel();
        this.mMap.put(str, Long.valueOf(j));
    }

    public void putLongArray(String str, long[] jArr) {
        unparcel();
        this.mMap.put(str, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putSerializable(String str, Serializable serializable) {
        unparcel();
        this.mMap.put(str, serializable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putShort(String str, short s) {
        unparcel();
        this.mMap.put(str, Short.valueOf(s));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putShortArray(String str, short[] sArr) {
        unparcel();
        this.mMap.put(str, sArr);
    }

    public void putString(String str, String str2) {
        unparcel();
        this.mMap.put(str, str2);
    }

    public void putStringArray(String str, String[] strArr) {
        unparcel();
        this.mMap.put(str, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putStringArrayList(String str, ArrayList<String> arrayList) {
        unparcel();
        this.mMap.put(str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readFromParcelInner(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            throw new RuntimeException("Bad length in parcel: " + readInt);
        }
        readFromParcelInner(parcel, readInt);
    }

    public void remove(String str) {
        unparcel();
        this.mMap.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setClassLoader(ClassLoader classLoader) {
        this.mClassLoader = classLoader;
    }

    public int size() {
        unparcel();
        return this.mMap.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void typeWarning(String str, Object obj, String str2, ClassCastException classCastException) {
        typeWarning(str, obj, str2, "<null>", classCastException);
    }

    void typeWarning(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        Log.w(TAG, "Key " + str + " expected " + str2 + " but value was a " + obj.getClass().getName() + ".  The default value " + obj2 + " was returned.");
        Log.w(TAG, "Attempt to cast generated internal exception:", classCastException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unparcel() {
        synchronized (this) {
            if (this.mParcelledData != null) {
                if (this.mParcelledData == EMPTY_PARCEL) {
                    if (this.mMap == null) {
                        this.mMap = new ArrayMap<>(1);
                    } else {
                        this.mMap.erase();
                    }
                    this.mParcelledData = null;
                } else {
                    int readInt = this.mParcelledData.readInt();
                    if (readInt >= 0) {
                        if (this.mMap == null) {
                            this.mMap = new ArrayMap<>(readInt);
                        } else {
                            this.mMap.erase();
                            this.mMap.ensureCapacity(readInt);
                        }
                        this.mParcelledData.readArrayMapInternal(this.mMap, readInt, this.mClassLoader);
                        this.mParcelledData.recycle();
                        this.mParcelledData = null;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeToParcelInner(Parcel parcel, int i) {
        if (this.mParcelledData != null) {
            if (this.mParcelledData == EMPTY_PARCEL) {
                parcel.writeInt(0);
                return;
            }
            int dataSize = this.mParcelledData.dataSize();
            parcel.writeInt(dataSize);
            parcel.writeInt(BUNDLE_MAGIC);
            parcel.appendFrom(this.mParcelledData, 0, dataSize);
        } else if (this.mMap == null || this.mMap.size() <= 0) {
            parcel.writeInt(0);
        } else {
            int dataPosition = parcel.dataPosition();
            parcel.writeInt(-1);
            parcel.writeInt(BUNDLE_MAGIC);
            int dataPosition2 = parcel.dataPosition();
            parcel.writeArrayMapInternal(this.mMap);
            int dataPosition3 = parcel.dataPosition();
            parcel.setDataPosition(dataPosition);
            parcel.writeInt(dataPosition3 - dataPosition2);
            parcel.setDataPosition(dataPosition3);
        }
    }
}
