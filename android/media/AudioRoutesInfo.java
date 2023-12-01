package android.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioRoutesInfo.class */
public class AudioRoutesInfo implements Parcelable {
    public static final Parcelable.Creator<AudioRoutesInfo> CREATOR = new Parcelable.Creator<AudioRoutesInfo>() { // from class: android.media.AudioRoutesInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioRoutesInfo createFromParcel(Parcel parcel) {
            return new AudioRoutesInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioRoutesInfo[] newArray(int i) {
            return new AudioRoutesInfo[i];
        }
    };
    static final int MAIN_DOCK_SPEAKERS = 4;
    static final int MAIN_HDMI = 8;
    static final int MAIN_HEADPHONES = 2;
    static final int MAIN_HEADSET = 1;
    static final int MAIN_SPEAKER = 0;
    CharSequence mBluetoothName;
    int mMainType;

    public AudioRoutesInfo() {
        this.mMainType = 0;
    }

    public AudioRoutesInfo(AudioRoutesInfo audioRoutesInfo) {
        this.mMainType = 0;
        this.mBluetoothName = audioRoutesInfo.mBluetoothName;
        this.mMainType = audioRoutesInfo.mMainType;
    }

    AudioRoutesInfo(Parcel parcel) {
        this.mMainType = 0;
        this.mBluetoothName = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mMainType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        TextUtils.writeToParcel(this.mBluetoothName, parcel, i);
        parcel.writeInt(this.mMainType);
    }
}
