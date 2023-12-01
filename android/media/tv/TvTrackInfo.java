package android.media.tv;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvTrackInfo.class */
public final class TvTrackInfo implements Parcelable {
    public static final Parcelable.Creator<TvTrackInfo> CREATOR = new Parcelable.Creator<TvTrackInfo>() { // from class: android.media.tv.TvTrackInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TvTrackInfo createFromParcel(Parcel parcel) {
            return new TvTrackInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TvTrackInfo[] newArray(int i) {
            return new TvTrackInfo[i];
        }
    };
    public static final int TYPE_AUDIO = 0;
    public static final int TYPE_SUBTITLE = 2;
    public static final int TYPE_VIDEO = 1;
    private final int mAudioChannelCount;
    private final int mAudioSampleRate;
    private final Bundle mExtra;
    private final String mId;
    private final String mLanguage;
    private final int mType;
    private final float mVideoFrameRate;
    private final int mVideoHeight;
    private final int mVideoWidth;

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvTrackInfo$Builder.class */
    public static final class Builder {
        private int mAudioChannelCount;
        private int mAudioSampleRate;
        private Bundle mExtra;
        private final String mId;
        private String mLanguage;
        private final int mType;
        private float mVideoFrameRate;
        private int mVideoHeight;
        private int mVideoWidth;

        public Builder(int i, String str) {
            if (i != 0 && i != 1 && i != 2) {
                throw new IllegalArgumentException("Unknown type: " + i);
            }
            if (str == null) {
                throw new IllegalArgumentException("id cannot be null");
            }
            this.mType = i;
            this.mId = str;
        }

        public TvTrackInfo build() {
            return new TvTrackInfo(this.mType, this.mId, this.mLanguage, this.mAudioChannelCount, this.mAudioSampleRate, this.mVideoWidth, this.mVideoHeight, this.mVideoFrameRate, this.mExtra);
        }

        public final Builder setAudioChannelCount(int i) {
            if (this.mType != 0) {
                throw new IllegalStateException("Not an audio track");
            }
            this.mAudioChannelCount = i;
            return this;
        }

        public final Builder setAudioSampleRate(int i) {
            if (this.mType != 0) {
                throw new IllegalStateException("Not an audio track");
            }
            this.mAudioSampleRate = i;
            return this;
        }

        public final Builder setExtra(Bundle bundle) {
            this.mExtra = new Bundle(bundle);
            return this;
        }

        public final Builder setLanguage(String str) {
            this.mLanguage = str;
            return this;
        }

        public final Builder setVideoFrameRate(float f) {
            if (this.mType != 1) {
                throw new IllegalStateException("Not a video track");
            }
            this.mVideoFrameRate = f;
            return this;
        }

        public final Builder setVideoHeight(int i) {
            if (this.mType != 1) {
                throw new IllegalStateException("Not a video track");
            }
            this.mVideoHeight = i;
            return this;
        }

        public final Builder setVideoWidth(int i) {
            if (this.mType != 1) {
                throw new IllegalStateException("Not a video track");
            }
            this.mVideoWidth = i;
            return this;
        }
    }

    private TvTrackInfo(int i, String str, String str2, int i2, int i3, int i4, int i5, float f, Bundle bundle) {
        this.mType = i;
        this.mId = str;
        this.mLanguage = str2;
        this.mAudioChannelCount = i2;
        this.mAudioSampleRate = i3;
        this.mVideoWidth = i4;
        this.mVideoHeight = i5;
        this.mVideoFrameRate = f;
        this.mExtra = bundle;
    }

    private TvTrackInfo(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mId = parcel.readString();
        this.mLanguage = parcel.readString();
        this.mAudioChannelCount = parcel.readInt();
        this.mAudioSampleRate = parcel.readInt();
        this.mVideoWidth = parcel.readInt();
        this.mVideoHeight = parcel.readInt();
        this.mVideoFrameRate = parcel.readFloat();
        this.mExtra = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getAudioChannelCount() {
        if (this.mType != 0) {
            throw new IllegalStateException("Not an audio track");
        }
        return this.mAudioChannelCount;
    }

    public final int getAudioSampleRate() {
        if (this.mType != 0) {
            throw new IllegalStateException("Not an audio track");
        }
        return this.mAudioSampleRate;
    }

    public final Bundle getExtra() {
        return this.mExtra;
    }

    public final String getId() {
        return this.mId;
    }

    public final String getLanguage() {
        return this.mLanguage;
    }

    public final int getType() {
        return this.mType;
    }

    public final float getVideoFrameRate() {
        if (this.mType != 1) {
            throw new IllegalStateException("Not a video track");
        }
        return this.mVideoFrameRate;
    }

    public final int getVideoHeight() {
        if (this.mType != 1) {
            throw new IllegalStateException("Not a video track");
        }
        return this.mVideoHeight;
    }

    public final int getVideoWidth() {
        if (this.mType != 1) {
            throw new IllegalStateException("Not a video track");
        }
        return this.mVideoWidth;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        parcel.writeString(this.mId);
        parcel.writeString(this.mLanguage);
        parcel.writeInt(this.mAudioChannelCount);
        parcel.writeInt(this.mAudioSampleRate);
        parcel.writeInt(this.mVideoWidth);
        parcel.writeInt(this.mVideoHeight);
        parcel.writeFloat(this.mVideoFrameRate);
        parcel.writeBundle(this.mExtra);
    }
}
