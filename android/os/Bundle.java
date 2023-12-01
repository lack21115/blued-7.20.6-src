package android.os;

import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/os/Bundle.class */
public final class Bundle extends BaseBundle implements Cloneable, Parcelable {
    public static final Parcelable.Creator<Bundle> CREATOR;
    public static final Bundle EMPTY = new Bundle();
    static final Parcel EMPTY_PARCEL;
    private boolean mAllowFds;
    private boolean mFdsKnown;
    private boolean mHasFds;

    static {
        EMPTY.mMap = ArrayMap.EMPTY;
        EMPTY_PARCEL = BaseBundle.EMPTY_PARCEL;
        CREATOR = new Parcelable.Creator<Bundle>() { // from class: android.os.Bundle.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Bundle createFromParcel(Parcel parcel) {
                return parcel.readBundle();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Bundle[] newArray(int i) {
                return new Bundle[i];
            }
        };
    }

    public Bundle() {
        this.mHasFds = false;
        this.mFdsKnown = true;
        this.mAllowFds = true;
    }

    public Bundle(int i) {
        super(i);
        this.mHasFds = false;
        this.mFdsKnown = true;
        this.mAllowFds = true;
    }

    public Bundle(Bundle bundle) {
        super(bundle);
        this.mHasFds = false;
        this.mFdsKnown = true;
        this.mAllowFds = true;
        this.mHasFds = bundle.mHasFds;
        this.mFdsKnown = bundle.mFdsKnown;
    }

    Bundle(Parcel parcel) {
        super(parcel);
        this.mHasFds = false;
        this.mFdsKnown = true;
        this.mAllowFds = true;
        this.mHasFds = this.mParcelledData.hasFileDescriptors();
        this.mFdsKnown = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle(Parcel parcel, int i) {
        super(parcel, i);
        this.mHasFds = false;
        this.mFdsKnown = true;
        this.mAllowFds = true;
        this.mHasFds = this.mParcelledData.hasFileDescriptors();
        this.mFdsKnown = true;
    }

    public Bundle(PersistableBundle persistableBundle) {
        super(persistableBundle);
        this.mHasFds = false;
        this.mFdsKnown = true;
        this.mAllowFds = true;
    }

    public Bundle(ClassLoader classLoader) {
        super(classLoader);
        this.mHasFds = false;
        this.mFdsKnown = true;
        this.mAllowFds = true;
    }

    public static Bundle forPair(String str, String str2) {
        Bundle bundle = new Bundle(1);
        bundle.putString(str, str2);
        return bundle;
    }

    @Override // android.os.BaseBundle
    public void clear() {
        super.clear();
        this.mHasFds = false;
        this.mFdsKnown = true;
    }

    public Object clone() {
        return new Bundle(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int i = 0;
        if (hasFileDescriptors()) {
            i = 0 | 1;
        }
        return i;
    }

    public IBinder getBinder(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (IBinder) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "IBinder", e);
            return null;
        }
    }

    public Bundle getBundle(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (Bundle) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Bundle", e);
            return null;
        }
    }

    @Override // android.os.BaseBundle
    public byte getByte(String str) {
        return super.getByte(str);
    }

    @Override // android.os.BaseBundle
    public Byte getByte(String str, byte b) {
        return super.getByte(str, b);
    }

    @Override // android.os.BaseBundle
    public byte[] getByteArray(String str) {
        return super.getByteArray(str);
    }

    @Override // android.os.BaseBundle
    public char getChar(String str) {
        return super.getChar(str);
    }

    @Override // android.os.BaseBundle
    public char getChar(String str, char c2) {
        return super.getChar(str, c2);
    }

    @Override // android.os.BaseBundle
    public char[] getCharArray(String str) {
        return super.getCharArray(str);
    }

    @Override // android.os.BaseBundle
    public CharSequence getCharSequence(String str) {
        return super.getCharSequence(str);
    }

    @Override // android.os.BaseBundle
    public CharSequence getCharSequence(String str, CharSequence charSequence) {
        return super.getCharSequence(str, charSequence);
    }

    @Override // android.os.BaseBundle
    public CharSequence[] getCharSequenceArray(String str) {
        return super.getCharSequenceArray(str);
    }

    @Override // android.os.BaseBundle
    public ArrayList<CharSequence> getCharSequenceArrayList(String str) {
        return super.getCharSequenceArrayList(str);
    }

    @Override // android.os.BaseBundle
    public ClassLoader getClassLoader() {
        return super.getClassLoader();
    }

    @Override // android.os.BaseBundle
    public float getFloat(String str) {
        return super.getFloat(str);
    }

    @Override // android.os.BaseBundle
    public float getFloat(String str, float f) {
        return super.getFloat(str, f);
    }

    @Override // android.os.BaseBundle
    public float[] getFloatArray(String str) {
        return super.getFloatArray(str);
    }

    @Deprecated
    public IBinder getIBinder(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (IBinder) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "IBinder", e);
            return null;
        }
    }

    @Override // android.os.BaseBundle
    public ArrayList<Integer> getIntegerArrayList(String str) {
        return super.getIntegerArrayList(str);
    }

    public <T extends Parcelable> T getParcelable(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Parcelable", e);
            return null;
        }
    }

    public Parcelable[] getParcelableArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (Parcelable[]) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Parcelable[]", e);
            return null;
        }
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "ArrayList", e);
            return null;
        }
    }

    @Override // android.os.BaseBundle
    public Serializable getSerializable(String str) {
        return super.getSerializable(str);
    }

    @Override // android.os.BaseBundle
    public short getShort(String str) {
        return super.getShort(str);
    }

    @Override // android.os.BaseBundle
    public short getShort(String str, short s) {
        return super.getShort(str, s);
    }

    @Override // android.os.BaseBundle
    public short[] getShortArray(String str) {
        return super.getShortArray(str);
    }

    public Size getSize(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        try {
            return (Size) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Size", e);
            return null;
        }
    }

    public SizeF getSizeF(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        try {
            return (SizeF) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "SizeF", e);
            return null;
        }
    }

    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (SparseArray) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "SparseArray", e);
            return null;
        }
    }

    @Override // android.os.BaseBundle
    public ArrayList<String> getStringArrayList(String str) {
        return super.getStringArrayList(str);
    }

    public boolean hasFileDescriptors() {
        boolean z;
        if (!this.mFdsKnown) {
            boolean z2 = false;
            boolean z3 = false;
            if (this.mParcelledData == null) {
                int size = this.mMap.size() - 1;
                while (true) {
                    z3 = z2;
                    if (size < 0) {
                        break;
                    }
                    Object valueAt = this.mMap.valueAt(size);
                    if (valueAt instanceof Parcelable) {
                        z = z2;
                        if ((((Parcelable) valueAt).describeContents() & 1) != 0) {
                            z3 = true;
                            break;
                        }
                    } else if (valueAt instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) valueAt;
                        int length = parcelableArr.length;
                        while (true) {
                            int i = length - 1;
                            z = z2;
                            if (i < 0) {
                                break;
                            } else if ((parcelableArr[i].describeContents() & 1) != 0) {
                                z = true;
                                break;
                            } else {
                                length = i;
                            }
                        }
                    } else if (valueAt instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) valueAt;
                        int size2 = sparseArray.size();
                        while (true) {
                            int i2 = size2 - 1;
                            z = z2;
                            if (i2 < 0) {
                                break;
                            } else if ((((Parcelable) sparseArray.valueAt(i2)).describeContents() & 1) != 0) {
                                z = true;
                                break;
                            } else {
                                size2 = i2;
                            }
                        }
                    } else {
                        z = z2;
                        if (valueAt instanceof ArrayList) {
                            ArrayList arrayList = (ArrayList) valueAt;
                            z = z2;
                            if (!arrayList.isEmpty()) {
                                z = z2;
                                if (arrayList.get(0) instanceof Parcelable) {
                                    int size3 = arrayList.size();
                                    while (true) {
                                        int i3 = size3 - 1;
                                        z = z2;
                                        if (i3 >= 0) {
                                            Parcelable parcelable = (Parcelable) arrayList.get(i3);
                                            if (parcelable != null && (parcelable.describeContents() & 1) != 0) {
                                                z = true;
                                                break;
                                            }
                                            size3 = i3;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    size--;
                    z2 = z;
                }
            } else if (this.mParcelledData.hasFileDescriptors()) {
                z3 = true;
            }
            this.mHasFds = z3;
            this.mFdsKnown = true;
        }
        return this.mHasFds;
    }

    public void putAll(Bundle bundle) {
        unparcel();
        bundle.unparcel();
        this.mMap.putAll((ArrayMap<? extends String, ? extends Object>) bundle.mMap);
        this.mHasFds |= bundle.mHasFds;
        this.mFdsKnown = this.mFdsKnown && bundle.mFdsKnown;
    }

    public void putBinder(String str, IBinder iBinder) {
        unparcel();
        this.mMap.put(str, iBinder);
    }

    public void putBundle(String str, Bundle bundle) {
        unparcel();
        this.mMap.put(str, bundle);
    }

    @Override // android.os.BaseBundle
    public void putByte(String str, byte b) {
        super.putByte(str, b);
    }

    @Override // android.os.BaseBundle
    public void putByteArray(String str, byte[] bArr) {
        super.putByteArray(str, bArr);
    }

    @Override // android.os.BaseBundle
    public void putChar(String str, char c2) {
        super.putChar(str, c2);
    }

    @Override // android.os.BaseBundle
    public void putCharArray(String str, char[] cArr) {
        super.putCharArray(str, cArr);
    }

    @Override // android.os.BaseBundle
    public void putCharSequence(String str, CharSequence charSequence) {
        super.putCharSequence(str, charSequence);
    }

    @Override // android.os.BaseBundle
    public void putCharSequenceArray(String str, CharSequence[] charSequenceArr) {
        super.putCharSequenceArray(str, charSequenceArr);
    }

    @Override // android.os.BaseBundle
    public void putCharSequenceArrayList(String str, ArrayList<CharSequence> arrayList) {
        super.putCharSequenceArrayList(str, arrayList);
    }

    @Override // android.os.BaseBundle
    public void putFloat(String str, float f) {
        super.putFloat(str, f);
    }

    @Override // android.os.BaseBundle
    public void putFloatArray(String str, float[] fArr) {
        super.putFloatArray(str, fArr);
    }

    @Deprecated
    public void putIBinder(String str, IBinder iBinder) {
        unparcel();
        this.mMap.put(str, iBinder);
    }

    @Override // android.os.BaseBundle
    public void putIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        super.putIntegerArrayList(str, arrayList);
    }

    public void putParcelable(String str, Parcelable parcelable) {
        unparcel();
        this.mMap.put(str, parcelable);
        this.mFdsKnown = false;
    }

    public void putParcelableArray(String str, Parcelable[] parcelableArr) {
        unparcel();
        this.mMap.put(str, parcelableArr);
        this.mFdsKnown = false;
    }

    public void putParcelableArrayList(String str, ArrayList<? extends Parcelable> arrayList) {
        unparcel();
        this.mMap.put(str, arrayList);
        this.mFdsKnown = false;
    }

    public void putParcelableList(String str, List<? extends Parcelable> list) {
        unparcel();
        this.mMap.put(str, list);
        this.mFdsKnown = false;
    }

    @Override // android.os.BaseBundle
    public void putSerializable(String str, Serializable serializable) {
        super.putSerializable(str, serializable);
    }

    @Override // android.os.BaseBundle
    public void putShort(String str, short s) {
        super.putShort(str, s);
    }

    @Override // android.os.BaseBundle
    public void putShortArray(String str, short[] sArr) {
        super.putShortArray(str, sArr);
    }

    public void putSize(String str, Size size) {
        unparcel();
        this.mMap.put(str, size);
    }

    public void putSizeF(String str, SizeF sizeF) {
        unparcel();
        this.mMap.put(str, sizeF);
    }

    public void putSparseParcelableArray(String str, SparseArray<? extends Parcelable> sparseArray) {
        unparcel();
        this.mMap.put(str, sparseArray);
        this.mFdsKnown = false;
    }

    @Override // android.os.BaseBundle
    public void putStringArrayList(String str, ArrayList<String> arrayList) {
        super.putStringArrayList(str, arrayList);
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcelInner(parcel);
        this.mHasFds = this.mParcelledData.hasFileDescriptors();
        this.mFdsKnown = true;
    }

    public boolean setAllowFds(boolean z) {
        boolean z2 = this.mAllowFds;
        this.mAllowFds = z;
        return z2;
    }

    @Override // android.os.BaseBundle
    public void setClassLoader(ClassLoader classLoader) {
        super.setClassLoader(classLoader);
    }

    public String toString() {
        String str;
        synchronized (this) {
            str = this.mParcelledData != null ? this.mParcelledData == EMPTY_PARCEL ? "Bundle[EMPTY_PARCEL]" : "Bundle[mParcelledData.dataSize=" + this.mParcelledData.dataSize() + "]" : "Bundle[" + this.mMap.toString() + "]";
        }
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        boolean pushAllowFds = parcel.pushAllowFds(this.mAllowFds);
        try {
            super.writeToParcelInner(parcel, i);
        } finally {
            parcel.restoreAllowFds(pushAllowFds);
        }
    }
}
