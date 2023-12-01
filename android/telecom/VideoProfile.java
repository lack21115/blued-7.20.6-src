package android.telecom;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/VideoProfile.class */
public class VideoProfile implements Parcelable {
    public static final Parcelable.Creator<VideoProfile> CREATOR = new Parcelable.Creator<VideoProfile>() { // from class: android.telecom.VideoProfile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoProfile createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            VideoProfile.class.getClassLoader();
            return new VideoProfile(readInt, readInt2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoProfile[] newArray(int i) {
            return new VideoProfile[i];
        }
    };
    public static final int QUALITY_DEFAULT = 4;
    public static final int QUALITY_HIGH = 1;
    public static final int QUALITY_LOW = 3;
    public static final int QUALITY_MEDIUM = 2;
    public static final int QUALITY_UNKNOWN = 0;
    private final int mQuality;
    private final int mVideoState;

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/VideoProfile$VideoState.class */
    public static class VideoState {
        public static final int AUDIO_ONLY = 0;
        public static final int BIDIRECTIONAL = 3;
        public static final int PAUSED = 4;
        public static final int RX_ENABLED = 2;
        public static final int TX_ENABLED = 1;

        private static boolean hasState(int i, int i2) {
            return (i & i2) == i2;
        }

        public static boolean isAudioOnly(int i) {
            return (hasState(i, 1) || hasState(i, 2)) ? false : true;
        }

        public static boolean isBidirectional(int i) {
            return hasState(i, 3);
        }

        public static boolean isPaused(int i) {
            return hasState(i, 4);
        }

        public static boolean isReceptionEnabled(int i) {
            return hasState(i, 2);
        }

        public static boolean isTransmissionEnabled(int i) {
            return hasState(i, 1);
        }

        public static boolean isVideo(int i) {
            return hasState(i, 1) || hasState(i, 2) || hasState(i, 3);
        }
    }

    public VideoProfile(int i) {
        this(i, 4);
    }

    public VideoProfile(int i, int i2) {
        this.mVideoState = i;
        this.mQuality = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int getVideoState() {
        return this.mVideoState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVideoState);
        parcel.writeInt(this.mQuality);
    }
}
