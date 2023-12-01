package android.speech.tts;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/Voice.class */
public class Voice implements Parcelable {
    public static final Parcelable.Creator<Voice> CREATOR = new Parcelable.Creator<Voice>() { // from class: android.speech.tts.Voice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Voice createFromParcel(Parcel parcel) {
            return new Voice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Voice[] newArray(int i) {
            return new Voice[i];
        }
    };
    public static final int LATENCY_HIGH = 400;
    public static final int LATENCY_LOW = 200;
    public static final int LATENCY_NORMAL = 300;
    public static final int LATENCY_VERY_HIGH = 500;
    public static final int LATENCY_VERY_LOW = 100;
    public static final int QUALITY_HIGH = 400;
    public static final int QUALITY_LOW = 200;
    public static final int QUALITY_NORMAL = 300;
    public static final int QUALITY_VERY_HIGH = 500;
    public static final int QUALITY_VERY_LOW = 100;
    private final Set<String> mFeatures;
    private final int mLatency;
    private final Locale mLocale;
    private final String mName;
    private final int mQuality;
    private final boolean mRequiresNetworkConnection;

    private Voice(Parcel parcel) {
        this.mName = parcel.readString();
        this.mLocale = (Locale) parcel.readSerializable();
        this.mQuality = parcel.readInt();
        this.mLatency = parcel.readInt();
        this.mRequiresNetworkConnection = parcel.readByte() == 1;
        this.mFeatures = new HashSet();
        Collections.addAll(this.mFeatures, parcel.readStringArray());
    }

    public Voice(String str, Locale locale, int i, int i2, boolean z, Set<String> set) {
        this.mName = str;
        this.mLocale = locale;
        this.mQuality = i;
        this.mLatency = i2;
        this.mRequiresNetworkConnection = z;
        this.mFeatures = set;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Voice voice = (Voice) obj;
            if (this.mFeatures == null) {
                if (voice.mFeatures != null) {
                    return false;
                }
            } else if (!this.mFeatures.equals(voice.mFeatures)) {
                return false;
            }
            if (this.mLatency != voice.mLatency) {
                return false;
            }
            if (this.mLocale == null) {
                if (voice.mLocale != null) {
                    return false;
                }
            } else if (!this.mLocale.equals(voice.mLocale)) {
                return false;
            }
            if (this.mName == null) {
                if (voice.mName != null) {
                    return false;
                }
            } else if (!this.mName.equals(voice.mName)) {
                return false;
            }
            return this.mQuality == voice.mQuality && this.mRequiresNetworkConnection == voice.mRequiresNetworkConnection;
        }
        return false;
    }

    public Set<String> getFeatures() {
        return this.mFeatures;
    }

    public int getLatency() {
        return this.mLatency;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public String getName() {
        return this.mName;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.mFeatures == null ? 0 : this.mFeatures.hashCode();
        int i2 = this.mLatency;
        int hashCode2 = this.mLocale == null ? 0 : this.mLocale.hashCode();
        if (this.mName != null) {
            i = this.mName.hashCode();
        }
        return ((((((((((hashCode + 31) * 31) + i2) * 31) + hashCode2) * 31) + i) * 31) + this.mQuality) * 31) + (this.mRequiresNetworkConnection ? 1231 : 1237);
    }

    public boolean isNetworkConnectionRequired() {
        return this.mRequiresNetworkConnection;
    }

    public String toString() {
        return new StringBuilder(64).append("Voice[Name: ").append(this.mName).append(", locale: ").append(this.mLocale).append(", quality: ").append(this.mQuality).append(", latency: ").append(this.mLatency).append(", requiresNetwork: ").append(this.mRequiresNetworkConnection).append(", features: ").append(this.mFeatures.toString()).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeSerializable(this.mLocale);
        parcel.writeInt(this.mQuality);
        parcel.writeInt(this.mLatency);
        parcel.writeByte((byte) (this.mRequiresNetworkConnection ? 1 : 0));
        parcel.writeStringList(new ArrayList(this.mFeatures));
    }
}
