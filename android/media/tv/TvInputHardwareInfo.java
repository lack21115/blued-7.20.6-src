package android.media.tv;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputHardwareInfo.class */
public final class TvInputHardwareInfo implements Parcelable {
    public static final Parcelable.Creator<TvInputHardwareInfo> CREATOR = new Parcelable.Creator<TvInputHardwareInfo>() { // from class: android.media.tv.TvInputHardwareInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TvInputHardwareInfo createFromParcel(Parcel parcel) {
            try {
                TvInputHardwareInfo tvInputHardwareInfo = new TvInputHardwareInfo();
                tvInputHardwareInfo.readFromParcel(parcel);
                return tvInputHardwareInfo;
            } catch (Exception e) {
                Log.e(TvInputHardwareInfo.TAG, "Exception creating TvInputHardwareInfo from parcel", e);
                return null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TvInputHardwareInfo[] newArray(int i) {
            return new TvInputHardwareInfo[i];
        }
    };
    static final String TAG = "TvInputHardwareInfo";
    public static final int TV_INPUT_TYPE_COMPONENT = 6;
    public static final int TV_INPUT_TYPE_COMPOSITE = 3;
    public static final int TV_INPUT_TYPE_DISPLAY_PORT = 10;
    public static final int TV_INPUT_TYPE_DVI = 8;
    public static final int TV_INPUT_TYPE_HDMI = 9;
    public static final int TV_INPUT_TYPE_OTHER_HARDWARE = 1;
    public static final int TV_INPUT_TYPE_SCART = 5;
    public static final int TV_INPUT_TYPE_SVIDEO = 4;
    public static final int TV_INPUT_TYPE_TUNER = 2;
    public static final int TV_INPUT_TYPE_VGA = 7;
    private String mAudioAddress;
    private int mAudioType;
    private int mDeviceId;
    private int mHdmiPortId;
    private int mType;

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputHardwareInfo$Builder.class */
    public static final class Builder {
        private Integer mDeviceId = null;
        private Integer mType = null;
        private int mAudioType = 0;
        private String mAudioAddress = "";
        private Integer mHdmiPortId = null;

        public Builder audioAddress(String str) {
            this.mAudioAddress = str;
            return this;
        }

        public Builder audioType(int i) {
            this.mAudioType = i;
            return this;
        }

        public TvInputHardwareInfo build() {
            if (this.mDeviceId == null || this.mType == null) {
                throw new UnsupportedOperationException();
            }
            if (!(this.mType.intValue() == 9 && this.mHdmiPortId == null) && (this.mType.intValue() == 9 || this.mHdmiPortId == null)) {
                TvInputHardwareInfo tvInputHardwareInfo = new TvInputHardwareInfo();
                tvInputHardwareInfo.mDeviceId = this.mDeviceId.intValue();
                tvInputHardwareInfo.mType = this.mType.intValue();
                tvInputHardwareInfo.mAudioType = this.mAudioType;
                if (tvInputHardwareInfo.mAudioType != 0) {
                    tvInputHardwareInfo.mAudioAddress = this.mAudioAddress;
                }
                if (this.mHdmiPortId != null) {
                    tvInputHardwareInfo.mHdmiPortId = this.mHdmiPortId.intValue();
                }
                return tvInputHardwareInfo;
            }
            throw new UnsupportedOperationException();
        }

        public Builder deviceId(int i) {
            this.mDeviceId = Integer.valueOf(i);
            return this;
        }

        public Builder hdmiPortId(int i) {
            this.mHdmiPortId = Integer.valueOf(i);
            return this;
        }

        public Builder type(int i) {
            this.mType = Integer.valueOf(i);
            return this;
        }
    }

    private TvInputHardwareInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAudioAddress() {
        return this.mAudioAddress;
    }

    public int getAudioType() {
        return this.mAudioType;
    }

    public int getDeviceId() {
        return this.mDeviceId;
    }

    public int getHdmiPortId() {
        if (this.mType != 9) {
            throw new IllegalStateException();
        }
        return this.mHdmiPortId;
    }

    public int getType() {
        return this.mType;
    }

    public void readFromParcel(Parcel parcel) {
        this.mDeviceId = parcel.readInt();
        this.mType = parcel.readInt();
        this.mAudioType = parcel.readInt();
        this.mAudioAddress = parcel.readString();
        if (this.mType == 9) {
            this.mHdmiPortId = parcel.readInt();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("TvInputHardwareInfo {id=").append(this.mDeviceId);
        sb.append(", type=").append(this.mType);
        sb.append(", audio_type=").append(this.mAudioType);
        sb.append(", audio_addr=").append(this.mAudioAddress);
        if (this.mType == 9) {
            sb.append(", hdmi_port=").append(this.mHdmiPortId);
        }
        sb.append(i.d);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mDeviceId);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mAudioType);
        parcel.writeString(this.mAudioAddress);
        if (this.mType == 9) {
            parcel.writeInt(this.mHdmiPortId);
        }
    }
}
