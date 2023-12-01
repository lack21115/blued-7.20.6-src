package com.android.ims;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-4181928-dex2jar.jar:com/android/ims/ImsStreamMediaProfile.class */
public class ImsStreamMediaProfile implements Parcelable {
    public static final int AUDIO_QUALITY_AMR = 1;
    public static final int AUDIO_QUALITY_AMR_WB = 2;
    public static final int AUDIO_QUALITY_EVRC = 4;
    public static final int AUDIO_QUALITY_EVRC_B = 5;
    public static final int AUDIO_QUALITY_EVRC_NW = 7;
    public static final int AUDIO_QUALITY_EVRC_WB = 6;
    public static final int AUDIO_QUALITY_GSM_EFR = 8;
    public static final int AUDIO_QUALITY_GSM_FR = 9;
    public static final int AUDIO_QUALITY_GSM_HR = 10;
    public static final int AUDIO_QUALITY_NONE = 0;
    public static final int AUDIO_QUALITY_QCELP13K = 3;
    public static final Parcelable.Creator<ImsStreamMediaProfile> CREATOR = new Parcelable.Creator<ImsStreamMediaProfile>() { // from class: com.android.ims.ImsStreamMediaProfile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsStreamMediaProfile createFromParcel(Parcel parcel) {
            return new ImsStreamMediaProfile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsStreamMediaProfile[] newArray(int i) {
            return new ImsStreamMediaProfile[i];
        }
    };
    public static final int DIRECTION_INACTIVE = 0;
    public static final int DIRECTION_INVALID = -1;
    public static final int DIRECTION_RECEIVE = 1;
    public static final int DIRECTION_SEND = 2;
    public static final int DIRECTION_SEND_RECEIVE = 3;
    private static final String TAG = "ImsStreamMediaProfile";
    public static final int VIDEO_QUALITY_NONE = 0;
    public static final int VIDEO_QUALITY_QCIF = 1;
    public static final int VIDEO_QUALITY_QVGA_LANDSCAPE = 2;
    public static final int VIDEO_QUALITY_QVGA_PORTRAIT = 4;
    public static final int VIDEO_QUALITY_VGA_LANDSCAPE = 8;
    public static final int VIDEO_QUALITY_VGA_PORTRAIT = 16;
    public int mAudioDirection;
    public int mAudioQuality;
    public int mVideoDirection;
    public int mVideoQuality;

    public ImsStreamMediaProfile() {
        this.mAudioQuality = 0;
        this.mAudioDirection = 3;
        this.mVideoQuality = 0;
        this.mVideoDirection = -1;
    }

    public ImsStreamMediaProfile(int i, int i2, int i3, int i4) {
        this.mAudioQuality = i;
        this.mAudioDirection = i2;
        this.mVideoQuality = i3;
        this.mVideoDirection = i4;
    }

    public ImsStreamMediaProfile(Parcel parcel) {
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        this.mAudioQuality = parcel.readInt();
        this.mAudioDirection = parcel.readInt();
        this.mVideoQuality = parcel.readInt();
        this.mVideoDirection = parcel.readInt();
    }

    public void copyFrom(ImsStreamMediaProfile imsStreamMediaProfile) {
        this.mAudioQuality = imsStreamMediaProfile.mAudioQuality;
        this.mAudioDirection = imsStreamMediaProfile.mAudioDirection;
        this.mVideoQuality = imsStreamMediaProfile.mVideoQuality;
        this.mVideoDirection = imsStreamMediaProfile.mVideoDirection;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "{ audioQuality=" + this.mAudioQuality + ", audioDirection=" + this.mAudioDirection + ", videoQuality=" + this.mVideoQuality + ", videoDirection=" + this.mVideoDirection + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAudioQuality);
        parcel.writeInt(this.mAudioDirection);
        parcel.writeInt(this.mVideoQuality);
        parcel.writeInt(this.mVideoDirection);
    }
}
