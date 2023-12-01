package android.content;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/content/ContentProviderOperation.class */
public class ContentProviderOperation implements Parcelable {
    public static final Parcelable.Creator<ContentProviderOperation> CREATOR = new Parcelable.Creator<ContentProviderOperation>() { // from class: android.content.ContentProviderOperation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentProviderOperation createFromParcel(Parcel parcel) {
            return new ContentProviderOperation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentProviderOperation[] newArray(int i) {
            return new ContentProviderOperation[i];
        }
    };
    private static final String TAG = "ContentProviderOperation";
    public static final int TYPE_ASSERT = 4;
    public static final int TYPE_DELETE = 3;
    public static final int TYPE_INSERT = 1;
    public static final int TYPE_UPDATE = 2;
    private final Integer mExpectedCount;
    private final String mSelection;
    private final String[] mSelectionArgs;
    private final Map<Integer, Integer> mSelectionArgsBackReferences;
    private final int mType;
    private final Uri mUri;
    private final ContentValues mValues;
    private final ContentValues mValuesBackReferences;
    private final boolean mYieldAllowed;

    /* loaded from: source-9557208-dex2jar.jar:android/content/ContentProviderOperation$Builder.class */
    public static class Builder {
        private Integer mExpectedCount;
        private String mSelection;
        private String[] mSelectionArgs;
        private Map<Integer, Integer> mSelectionArgsBackReferences;
        private final int mType;
        private final Uri mUri;
        private ContentValues mValues;
        private ContentValues mValuesBackReferences;
        private boolean mYieldAllowed;

        private Builder(int i, Uri uri) {
            if (uri == null) {
                throw new IllegalArgumentException("uri must not be null");
            }
            this.mType = i;
            this.mUri = uri;
        }

        public ContentProviderOperation build() {
            if (this.mType == 2 && ((this.mValues == null || this.mValues.size() == 0) && (this.mValuesBackReferences == null || this.mValuesBackReferences.size() == 0))) {
                throw new IllegalArgumentException("Empty values");
            }
            if (this.mType == 4 && ((this.mValues == null || this.mValues.size() == 0) && ((this.mValuesBackReferences == null || this.mValuesBackReferences.size() == 0) && this.mExpectedCount == null))) {
                throw new IllegalArgumentException("Empty values");
            }
            return new ContentProviderOperation(this);
        }

        public Builder withExpectedCount(int i) {
            if (this.mType == 2 || this.mType == 3 || this.mType == 4) {
                this.mExpectedCount = Integer.valueOf(i);
                return this;
            }
            throw new IllegalArgumentException("only updates, deletes, and asserts can have expected counts");
        }

        public Builder withSelection(String str, String[] strArr) {
            if (this.mType == 2 || this.mType == 3 || this.mType == 4) {
                this.mSelection = str;
                if (strArr == null) {
                    this.mSelectionArgs = null;
                    return this;
                }
                this.mSelectionArgs = new String[strArr.length];
                System.arraycopy(strArr, 0, this.mSelectionArgs, 0, strArr.length);
                return this;
            }
            throw new IllegalArgumentException("only updates, deletes, and asserts can have selections");
        }

        public Builder withSelectionBackReference(int i, int i2) {
            if (this.mType == 2 || this.mType == 3 || this.mType == 4) {
                if (this.mSelectionArgsBackReferences == null) {
                    this.mSelectionArgsBackReferences = new HashMap();
                }
                this.mSelectionArgsBackReferences.put(Integer.valueOf(i), Integer.valueOf(i2));
                return this;
            }
            throw new IllegalArgumentException("only updates, deletes, and asserts can have selection back-references");
        }

        public Builder withValue(String str, Object obj) {
            if (this.mType == 1 || this.mType == 2 || this.mType == 4) {
                if (this.mValues == null) {
                    this.mValues = new ContentValues();
                }
                if (obj == null) {
                    this.mValues.putNull(str);
                    return this;
                } else if (obj instanceof String) {
                    this.mValues.put(str, (String) obj);
                    return this;
                } else if (obj instanceof Byte) {
                    this.mValues.put(str, (Byte) obj);
                    return this;
                } else if (obj instanceof Short) {
                    this.mValues.put(str, (Short) obj);
                    return this;
                } else if (obj instanceof Integer) {
                    this.mValues.put(str, (Integer) obj);
                    return this;
                } else if (obj instanceof Long) {
                    this.mValues.put(str, (Long) obj);
                    return this;
                } else if (obj instanceof Float) {
                    this.mValues.put(str, (Float) obj);
                    return this;
                } else if (obj instanceof Double) {
                    this.mValues.put(str, (Double) obj);
                    return this;
                } else if (obj instanceof Boolean) {
                    this.mValues.put(str, (Boolean) obj);
                    return this;
                } else if (obj instanceof byte[]) {
                    this.mValues.put(str, (byte[]) obj);
                    return this;
                } else {
                    throw new IllegalArgumentException("bad value type: " + obj.getClass().getName());
                }
            }
            throw new IllegalArgumentException("only inserts and updates can have values");
        }

        public Builder withValueBackReference(String str, int i) {
            if (this.mType == 1 || this.mType == 2 || this.mType == 4) {
                if (this.mValuesBackReferences == null) {
                    this.mValuesBackReferences = new ContentValues();
                }
                this.mValuesBackReferences.put(str, Integer.valueOf(i));
                return this;
            }
            throw new IllegalArgumentException("only inserts, updates, and asserts can have value back-references");
        }

        public Builder withValueBackReferences(ContentValues contentValues) {
            if (this.mType == 1 || this.mType == 2 || this.mType == 4) {
                this.mValuesBackReferences = contentValues;
                return this;
            }
            throw new IllegalArgumentException("only inserts, updates, and asserts can have value back-references");
        }

        public Builder withValues(ContentValues contentValues) {
            if (this.mType == 1 || this.mType == 2 || this.mType == 4) {
                if (this.mValues == null) {
                    this.mValues = new ContentValues();
                }
                this.mValues.putAll(contentValues);
                return this;
            }
            throw new IllegalArgumentException("only inserts, updates, and asserts can have values");
        }

        public Builder withYieldAllowed(boolean z) {
            this.mYieldAllowed = z;
            return this;
        }
    }

    private ContentProviderOperation(Builder builder) {
        this.mType = builder.mType;
        this.mUri = builder.mUri;
        this.mValues = builder.mValues;
        this.mSelection = builder.mSelection;
        this.mSelectionArgs = builder.mSelectionArgs;
        this.mExpectedCount = builder.mExpectedCount;
        this.mSelectionArgsBackReferences = builder.mSelectionArgsBackReferences;
        this.mValuesBackReferences = builder.mValuesBackReferences;
        this.mYieldAllowed = builder.mYieldAllowed;
    }

    public ContentProviderOperation(ContentProviderOperation contentProviderOperation, boolean z) {
        this.mType = contentProviderOperation.mType;
        if (z) {
            this.mUri = ContentProvider.getUriWithoutUserId(contentProviderOperation.mUri);
        } else {
            this.mUri = contentProviderOperation.mUri;
        }
        this.mValues = contentProviderOperation.mValues;
        this.mSelection = contentProviderOperation.mSelection;
        this.mSelectionArgs = contentProviderOperation.mSelectionArgs;
        this.mExpectedCount = contentProviderOperation.mExpectedCount;
        this.mSelectionArgsBackReferences = contentProviderOperation.mSelectionArgsBackReferences;
        this.mValuesBackReferences = contentProviderOperation.mValuesBackReferences;
        this.mYieldAllowed = contentProviderOperation.mYieldAllowed;
    }

    private ContentProviderOperation(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mUri = Uri.CREATOR.createFromParcel(parcel);
        this.mValues = parcel.readInt() != 0 ? ContentValues.CREATOR.createFromParcel(parcel) : null;
        this.mSelection = parcel.readInt() != 0 ? parcel.readString() : null;
        this.mSelectionArgs = parcel.readInt() != 0 ? parcel.readStringArray() : null;
        this.mExpectedCount = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
        this.mValuesBackReferences = parcel.readInt() != 0 ? ContentValues.CREATOR.createFromParcel(parcel) : null;
        this.mSelectionArgsBackReferences = parcel.readInt() != 0 ? new HashMap() : null;
        if (this.mSelectionArgsBackReferences != null) {
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                this.mSelectionArgsBackReferences.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                i = i2 + 1;
            }
        }
        this.mYieldAllowed = parcel.readInt() != 0;
    }

    private long backRefToValue(ContentProviderResult[] contentProviderResultArr, int i, Integer num) {
        if (num.intValue() >= i) {
            Log.e(TAG, toString());
            throw new ArrayIndexOutOfBoundsException("asked for back ref " + num + " but there are only " + i + " back refs");
        }
        ContentProviderResult contentProviderResult = contentProviderResultArr[num.intValue()];
        return contentProviderResult.uri != null ? ContentUris.parseId(contentProviderResult.uri) : contentProviderResult.count.intValue();
    }

    public static Builder newAssertQuery(Uri uri) {
        return new Builder(4, uri);
    }

    public static Builder newDelete(Uri uri) {
        return new Builder(3, uri);
    }

    public static Builder newInsert(Uri uri) {
        return new Builder(1, uri);
    }

    public static Builder newUpdate(Uri uri) {
        return new Builder(2, uri);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0111, code lost:
        if (r9 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x011a, code lost:
        if (r0.moveToNext() == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x011d, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011f, code lost:
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0122, code lost:
        if (r10 >= r9.length) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0125, code lost:
        r0 = r0.getString(r10);
        r0 = r0.getAsString(r9[r10]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x013f, code lost:
        if (android.text.TextUtils.equals(r0, r0) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0142, code lost:
        android.util.Log.e(android.content.ContentProviderOperation.TAG, toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x017f, code lost:
        throw new android.content.OperationApplicationException("Found value " + r0 + " when expected " + r0 + " for column " + r9[r10]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0189, code lost:
        r0 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0190, code lost:
        r0.close();
        r10 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.ContentProviderResult apply(android.content.ContentProvider r8, android.content.ContentProviderResult[] r9, int r10) throws android.content.OperationApplicationException {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.ContentProviderOperation.apply(android.content.ContentProvider, android.content.ContentProviderResult[], int):android.content.ContentProviderResult");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getType() {
        return this.mType;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public ContentProviderOperation getWithoutUserIdInUri() {
        ContentProviderOperation contentProviderOperation = this;
        if (ContentProvider.uriHasUserId(this.mUri)) {
            contentProviderOperation = new ContentProviderOperation(this, true);
        }
        return contentProviderOperation;
    }

    public boolean isDeleteOperation() {
        return this.mType == 3;
    }

    public boolean isReadOperation() {
        return this.mType == 4;
    }

    public boolean isWriteOperation() {
        return this.mType == 3 || this.mType == 1 || this.mType == 2;
    }

    public boolean isYieldAllowed() {
        return this.mYieldAllowed;
    }

    public String[] resolveSelectionArgsBackReferences(ContentProviderResult[] contentProviderResultArr, int i) {
        String[] strArr;
        if (this.mSelectionArgsBackReferences != null) {
            String[] strArr2 = new String[this.mSelectionArgs.length];
            System.arraycopy(this.mSelectionArgs, 0, strArr2, 0, this.mSelectionArgs.length);
            Iterator<Map.Entry<Integer, Integer>> it = this.mSelectionArgsBackReferences.entrySet().iterator();
            while (true) {
                strArr = strArr2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Integer, Integer> next = it.next();
                strArr2[next.getKey().intValue()] = String.valueOf(backRefToValue(contentProviderResultArr, i, Integer.valueOf(next.getValue().intValue())));
            }
        } else {
            strArr = this.mSelectionArgs;
        }
        return strArr;
    }

    public ContentValues resolveValueBackReferences(ContentProviderResult[] contentProviderResultArr, int i) {
        ContentValues contentValues;
        if (this.mValuesBackReferences != null) {
            ContentValues contentValues2 = this.mValues == null ? new ContentValues() : new ContentValues(this.mValues);
            Iterator<Map.Entry<String, Object>> it = this.mValuesBackReferences.valueSet().iterator();
            while (true) {
                contentValues = contentValues2;
                if (!it.hasNext()) {
                    break;
                }
                String key = it.next().getKey();
                Integer asInteger = this.mValuesBackReferences.getAsInteger(key);
                if (asInteger == null) {
                    Log.e(TAG, toString());
                    throw new IllegalArgumentException("values backref " + key + " is not an integer");
                }
                contentValues2.put(key, Long.valueOf(backRefToValue(contentProviderResultArr, i, asInteger)));
            }
        } else {
            contentValues = this.mValues;
        }
        return contentValues;
    }

    public String toString() {
        return "mType: " + this.mType + ", mUri: " + this.mUri + ", mSelection: " + this.mSelection + ", mExpectedCount: " + this.mExpectedCount + ", mYieldAllowed: " + this.mYieldAllowed + ", mValues: " + this.mValues + ", mValuesBackReferences: " + this.mValuesBackReferences + ", mSelectionArgsBackReferences: " + this.mSelectionArgsBackReferences;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        Uri.writeToParcel(parcel, this.mUri);
        if (this.mValues != null) {
            parcel.writeInt(1);
            this.mValues.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (this.mSelection != null) {
            parcel.writeInt(1);
            parcel.writeString(this.mSelection);
        } else {
            parcel.writeInt(0);
        }
        if (this.mSelectionArgs != null) {
            parcel.writeInt(1);
            parcel.writeStringArray(this.mSelectionArgs);
        } else {
            parcel.writeInt(0);
        }
        if (this.mExpectedCount != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.mExpectedCount.intValue());
        } else {
            parcel.writeInt(0);
        }
        if (this.mValuesBackReferences != null) {
            parcel.writeInt(1);
            this.mValuesBackReferences.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (this.mSelectionArgsBackReferences != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.mSelectionArgsBackReferences.size());
            for (Map.Entry<Integer, Integer> entry : this.mSelectionArgsBackReferences.entrySet()) {
                parcel.writeInt(entry.getKey().intValue());
                parcel.writeInt(entry.getValue().intValue());
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mYieldAllowed ? 1 : 0);
    }
}
