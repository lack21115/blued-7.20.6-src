package android.media;

import android.media.AudioAttributes;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioFocusInfo.class */
public final class AudioFocusInfo implements Parcelable {
    public static final Parcelable.Creator<AudioFocusInfo> CREATOR = new Parcelable.Creator<AudioFocusInfo>() { // from class: android.media.AudioFocusInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioFocusInfo createFromParcel(Parcel parcel) {
            return new AudioFocusInfo(AudioAttributes.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioFocusInfo[] newArray(int i) {
            return new AudioFocusInfo[i];
        }
    };
    private AudioAttributes mAttributes;
    private String mClientId;
    private int mFlags;
    private int mGainRequest;
    private int mLossReceived;
    private String mPackageName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioFocusInfo(AudioAttributes audioAttributes, String str, String str2, int i, int i2, int i3) {
        this.mAttributes = audioAttributes == null ? new AudioAttributes.Builder().build() : audioAttributes;
        this.mClientId = str == null ? "" : str;
        this.mPackageName = str2 == null ? "" : str2;
        this.mGainRequest = i;
        this.mLossReceived = i2;
        this.mFlags = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearLossReceived() {
        this.mLossReceived = 0;
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
            AudioFocusInfo audioFocusInfo = (AudioFocusInfo) obj;
            return this.mAttributes.equals(audioFocusInfo.mAttributes) && this.mClientId.equals(audioFocusInfo.mClientId) && this.mPackageName.equals(audioFocusInfo.mPackageName) && this.mGainRequest == audioFocusInfo.mGainRequest && this.mLossReceived == audioFocusInfo.mLossReceived && this.mFlags == audioFocusInfo.mFlags;
        }
        return false;
    }

    public AudioAttributes getAttributes() {
        return this.mAttributes;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public int getGainRequest() {
        return this.mGainRequest;
    }

    public int getLossReceived() {
        return this.mLossReceived;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int hashCode() {
        return Objects.hash(this.mAttributes, this.mClientId, this.mPackageName, Integer.valueOf(this.mGainRequest), Integer.valueOf(this.mFlags));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.mAttributes.writeToParcel(parcel, i);
        parcel.writeString(this.mClientId);
        parcel.writeString(this.mPackageName);
        parcel.writeInt(this.mGainRequest);
        parcel.writeInt(this.mLossReceived);
        parcel.writeInt(this.mFlags);
    }
}
