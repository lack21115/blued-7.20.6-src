package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/content/ContentValues.class */
public final class ContentValues implements Parcelable {
    public static final Parcelable.Creator<ContentValues> CREATOR = new Parcelable.Creator<ContentValues>() { // from class: android.content.ContentValues.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentValues createFromParcel(Parcel parcel) {
            return new ContentValues(parcel.readHashMap(null));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentValues[] newArray(int i) {
            return new ContentValues[i];
        }
    };
    public static final String TAG = "ContentValues";
    private HashMap<String, Object> mValues;

    public ContentValues() {
        this.mValues = new HashMap<>(8);
    }

    public ContentValues(int i) {
        this.mValues = new HashMap<>(i, 1.0f);
    }

    public ContentValues(ContentValues contentValues) {
        this.mValues = new HashMap<>(contentValues.mValues);
    }

    private ContentValues(HashMap<String, Object> hashMap) {
        this.mValues = hashMap;
    }

    public void clear() {
        this.mValues.clear();
    }

    public boolean containsKey(String str) {
        return this.mValues.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ContentValues) {
            return this.mValues.equals(((ContentValues) obj).mValues);
        }
        return false;
    }

    public Object get(String str) {
        return this.mValues.get(str);
    }

    public Boolean getAsBoolean(String str) {
        Object obj = this.mValues.get(str);
        try {
            return (Boolean) obj;
        } catch (ClassCastException e) {
            if (obj instanceof CharSequence) {
                return Boolean.valueOf(obj.toString());
            }
            if (obj instanceof Number) {
                return Boolean.valueOf(((Number) obj).intValue() != 0);
            }
            Log.e(TAG, "Cannot cast value for " + str + " to a Boolean: " + obj, e);
            return null;
        }
    }

    public Byte getAsByte(String str) {
        Byte valueOf;
        Object obj = this.mValues.get(str);
        if (obj != null) {
            try {
                valueOf = Byte.valueOf(((Number) obj).byteValue());
            } catch (ClassCastException e) {
                if (!(obj instanceof CharSequence)) {
                    Log.e(TAG, "Cannot cast value for " + str + " to a Byte: " + obj, e);
                    return null;
                }
                try {
                    return Byte.valueOf(obj.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Byte value for " + obj + " at key " + str);
                    return null;
                }
            }
        } else {
            valueOf = null;
        }
        return valueOf;
    }

    public byte[] getAsByteArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        return null;
    }

    public Double getAsDouble(String str) {
        Double valueOf;
        Object obj = this.mValues.get(str);
        if (obj != null) {
            try {
                valueOf = Double.valueOf(((Number) obj).doubleValue());
            } catch (ClassCastException e) {
                if (!(obj instanceof CharSequence)) {
                    Log.e(TAG, "Cannot cast value for " + str + " to a Double: " + obj, e);
                    return null;
                }
                try {
                    return Double.valueOf(obj.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Double value for " + obj + " at key " + str);
                    return null;
                }
            }
        } else {
            valueOf = null;
        }
        return valueOf;
    }

    public Float getAsFloat(String str) {
        Float valueOf;
        Object obj = this.mValues.get(str);
        if (obj != null) {
            try {
                valueOf = Float.valueOf(((Number) obj).floatValue());
            } catch (ClassCastException e) {
                if (!(obj instanceof CharSequence)) {
                    Log.e(TAG, "Cannot cast value for " + str + " to a Float: " + obj, e);
                    return null;
                }
                try {
                    return Float.valueOf(obj.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Float value for " + obj + " at key " + str);
                    return null;
                }
            }
        } else {
            valueOf = null;
        }
        return valueOf;
    }

    public Integer getAsInteger(String str) {
        Integer valueOf;
        Object obj = this.mValues.get(str);
        if (obj != null) {
            try {
                valueOf = Integer.valueOf(((Number) obj).intValue());
            } catch (ClassCastException e) {
                if (!(obj instanceof CharSequence)) {
                    Log.e(TAG, "Cannot cast value for " + str + " to a Integer: " + obj, e);
                    return null;
                }
                try {
                    return Integer.valueOf(obj.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Integer value for " + obj + " at key " + str);
                    return null;
                }
            }
        } else {
            valueOf = null;
        }
        return valueOf;
    }

    public Long getAsLong(String str) {
        Long valueOf;
        Object obj = this.mValues.get(str);
        if (obj != null) {
            try {
                valueOf = Long.valueOf(((Number) obj).longValue());
            } catch (ClassCastException e) {
                if (!(obj instanceof CharSequence)) {
                    Log.e(TAG, "Cannot cast value for " + str + " to a Long: " + obj, e);
                    return null;
                }
                try {
                    return Long.valueOf(obj.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Long value for " + obj + " at key " + str);
                    return null;
                }
            }
        } else {
            valueOf = null;
        }
        return valueOf;
    }

    public Short getAsShort(String str) {
        Short valueOf;
        Object obj = this.mValues.get(str);
        if (obj != null) {
            try {
                valueOf = Short.valueOf(((Number) obj).shortValue());
            } catch (ClassCastException e) {
                if (!(obj instanceof CharSequence)) {
                    Log.e(TAG, "Cannot cast value for " + str + " to a Short: " + obj, e);
                    return null;
                }
                try {
                    return Short.valueOf(obj.toString());
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Cannot parse Short value for " + obj + " at key " + str);
                    return null;
                }
            }
        } else {
            valueOf = null;
        }
        return valueOf;
    }

    public String getAsString(String str) {
        Object obj = this.mValues.get(str);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    @Deprecated
    public ArrayList<String> getStringArrayList(String str) {
        return (ArrayList) this.mValues.get(str);
    }

    public int hashCode() {
        return this.mValues.hashCode();
    }

    public Set<String> keySet() {
        return this.mValues.keySet();
    }

    public void put(String str, Boolean bool) {
        this.mValues.put(str, bool);
    }

    public void put(String str, Byte b) {
        this.mValues.put(str, b);
    }

    public void put(String str, Double d) {
        this.mValues.put(str, d);
    }

    public void put(String str, Float f) {
        this.mValues.put(str, f);
    }

    public void put(String str, Integer num) {
        this.mValues.put(str, num);
    }

    public void put(String str, Long l) {
        this.mValues.put(str, l);
    }

    public void put(String str, Short sh) {
        this.mValues.put(str, sh);
    }

    public void put(String str, String str2) {
        this.mValues.put(str, str2);
    }

    public void put(String str, byte[] bArr) {
        this.mValues.put(str, bArr);
    }

    public void putAll(ContentValues contentValues) {
        this.mValues.putAll(contentValues.mValues);
    }

    public void putNull(String str) {
        this.mValues.put(str, null);
    }

    @Deprecated
    public void putStringArrayList(String str, ArrayList<String> arrayList) {
        this.mValues.put(str, arrayList);
    }

    public void remove(String str) {
        this.mValues.remove(str);
    }

    public int size() {
        return this.mValues.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.mValues.keySet()) {
            String asString = getAsString(str);
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str + "=" + asString);
        }
        return sb.toString();
    }

    public Set<Map.Entry<String, Object>> valueSet() {
        return this.mValues.entrySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.mValues);
    }
}
