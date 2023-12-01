package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/content/ClipDescription.class */
public class ClipDescription implements Parcelable {
    public static final Parcelable.Creator<ClipDescription> CREATOR = new Parcelable.Creator<ClipDescription>() { // from class: android.content.ClipDescription.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClipDescription createFromParcel(Parcel parcel) {
            return new ClipDescription(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClipDescription[] newArray(int i) {
            return new ClipDescription[i];
        }
    };
    public static final String MIMETYPE_TEXT_HTML = "text/html";
    public static final String MIMETYPE_TEXT_INTENT = "text/vnd.android.intent";
    public static final String MIMETYPE_TEXT_PLAIN = "text/plain";
    public static final String MIMETYPE_TEXT_URILIST = "text/uri-list";
    final CharSequence mLabel;
    final String[] mMimeTypes;

    public ClipDescription(ClipDescription clipDescription) {
        this.mLabel = clipDescription.mLabel;
        this.mMimeTypes = clipDescription.mMimeTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClipDescription(Parcel parcel) {
        this.mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mMimeTypes = parcel.createStringArray();
    }

    public ClipDescription(CharSequence charSequence, String[] strArr) {
        if (strArr == null) {
            throw new NullPointerException("mimeTypes is null");
        }
        this.mLabel = charSequence;
        this.mMimeTypes = strArr;
    }

    public static boolean compareMimeTypes(String str, String str2) {
        int length = str2.length();
        if (length == 3 && str2.equals("*/*")) {
            return true;
        }
        int indexOf = str2.indexOf(47);
        if (indexOf > 0) {
            return (length == indexOf + 2 && str2.charAt(indexOf + 1) == '*') ? str2.regionMatches(0, str, 0, indexOf + 1) : str2.equals(str);
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] filterMimeTypes(String str) {
        ArrayList arrayList = null;
        int i = 0;
        while (i < this.mMimeTypes.length) {
            ArrayList arrayList2 = arrayList;
            if (compareMimeTypes(this.mMimeTypes[i], str)) {
                arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(this.mMimeTypes[i]);
            }
            i++;
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return null;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public String getMimeType(int i) {
        return this.mMimeTypes[i];
    }

    public int getMimeTypeCount() {
        return this.mMimeTypes.length;
    }

    public boolean hasMimeType(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mMimeTypes.length) {
                return false;
            }
            if (compareMimeTypes(this.mMimeTypes[i2], str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean toShortString(StringBuilder sb) {
        boolean z = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mMimeTypes.length) {
                break;
            }
            if (!z) {
                sb.append(' ');
            }
            z = false;
            sb.append(this.mMimeTypes[i2]);
            i = i2 + 1;
        }
        boolean z2 = z;
        if (this.mLabel != null) {
            if (!z) {
                sb.append(' ');
            }
            z2 = false;
            sb.append('\"');
            sb.append(this.mLabel);
            sb.append('\"');
        }
        return !z2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("ClipDescription { ");
        toShortString(sb);
        sb.append(" }");
        return sb.toString();
    }

    public void validate() {
        if (this.mMimeTypes == null) {
            throw new NullPointerException("null mime types");
        }
        if (this.mMimeTypes.length <= 0) {
            throw new IllegalArgumentException("must have at least 1 mime type");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mMimeTypes.length) {
                return;
            }
            if (this.mMimeTypes[i2] == null) {
                throw new NullPointerException("mime type at " + i2 + " is null");
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        TextUtils.writeToParcel(this.mLabel, parcel, i);
        parcel.writeStringArray(this.mMimeTypes);
    }
}
