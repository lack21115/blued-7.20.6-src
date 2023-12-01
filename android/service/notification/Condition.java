package android.service.notification;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/service/notification/Condition.class */
public class Condition implements Parcelable {
    public static final Parcelable.Creator<Condition> CREATOR = new Parcelable.Creator<Condition>() { // from class: android.service.notification.Condition.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Condition createFromParcel(Parcel parcel) {
            return new Condition(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Condition[] newArray(int i) {
            return new Condition[i];
        }
    };
    public static final int FLAG_RELEVANT_ALWAYS = 2;
    public static final int FLAG_RELEVANT_NOW = 1;
    public static final String SCHEME = "condition";
    public static final int STATE_ERROR = 3;
    public static final int STATE_FALSE = 0;
    public static final int STATE_TRUE = 1;
    public static final int STATE_UNKNOWN = 2;
    public final int flags;
    public final int icon;
    public final Uri id;
    public final String line1;
    public final String line2;
    public final int state;
    public final String summary;

    public Condition(Uri uri, String str, String str2, String str3, int i, int i2, int i3) {
        if (uri == null) {
            throw new IllegalArgumentException("id is required");
        }
        if (str == null) {
            throw new IllegalArgumentException("summary is required");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("line1 is required");
        }
        if (str3 == null) {
            throw new IllegalArgumentException("line2 is required");
        }
        if (!isValidState(i2)) {
            throw new IllegalArgumentException("state is invalid: " + i2);
        }
        this.id = uri;
        this.summary = str;
        this.line1 = str2;
        this.line2 = str3;
        this.icon = i;
        this.state = i2;
        this.flags = i3;
    }

    private Condition(Parcel parcel) {
        this((Uri) parcel.readParcelable(Condition.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    public static boolean isValidId(Uri uri, String str) {
        return uri != null && SCHEME.equals(uri.getScheme()) && str.equals(uri.getAuthority());
    }

    private static boolean isValidState(int i) {
        return i >= 0 && i <= 3;
    }

    public static Uri.Builder newId(Context context) {
        return new Uri.Builder().scheme(SCHEME).authority(context.getPackageName());
    }

    public static String relevanceToString(int i) {
        boolean z = (i & 1) != 0;
        boolean z2 = (i & 2) != 0;
        return (z || z2) ? (z && z2) ? "NOW, ALWAYS" : z ? "NOW" : "ALWAYS" : "NONE";
    }

    public static String stateToString(int i) {
        if (i == 0) {
            return "STATE_FALSE";
        }
        if (i == 1) {
            return "STATE_TRUE";
        }
        if (i == 2) {
            return "STATE_UNKNOWN";
        }
        if (i == 3) {
            return "STATE_ERROR";
        }
        throw new IllegalArgumentException("state is invalid: " + i);
    }

    public Condition copy() {
        Parcel obtain = Parcel.obtain();
        try {
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            return new Condition(obtain);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj instanceof Condition) {
            z = true;
            if (obj != this) {
                Condition condition = (Condition) obj;
                if (!Objects.equals(condition.id, this.id) || !Objects.equals(condition.summary, this.summary) || !Objects.equals(condition.line1, this.line1) || !Objects.equals(condition.line2, this.line2) || condition.icon != this.icon || condition.state != this.state) {
                    return false;
                }
                z = true;
                if (condition.flags != this.flags) {
                    return false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.summary, this.line1, this.line2, Integer.valueOf(this.icon), Integer.valueOf(this.state), Integer.valueOf(this.flags));
    }

    public String toString() {
        return Condition.class.getSimpleName() + "[id=" + this.id + ",summary=" + this.summary + ",line1=" + this.line1 + ",line2=" + this.line2 + ",icon=" + this.icon + ",state=" + stateToString(this.state) + ",flags=" + this.flags + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.id, 0);
        parcel.writeString(this.summary);
        parcel.writeString(this.line1);
        parcel.writeString(this.line2);
        parcel.writeInt(this.icon);
        parcel.writeInt(this.state);
        parcel.writeInt(this.flags);
    }
}
