package android.media;

import android.os.Parcel;

/* loaded from: source-9557208-dex2jar.jar:android/media/SubtitleData.class */
public final class SubtitleData {
    private static final String TAG = "SubtitleData";
    private byte[] mData;
    private long mDurationUs;
    private long mStartTimeUs;
    private int mTrackIndex;

    public SubtitleData(Parcel parcel) {
        if (!parseParcel(parcel)) {
            throw new IllegalArgumentException("parseParcel() fails");
        }
    }

    private boolean parseParcel(Parcel parcel) {
        parcel.setDataPosition(0);
        if (parcel.dataAvail() == 0) {
            return false;
        }
        this.mTrackIndex = parcel.readInt();
        this.mStartTimeUs = parcel.readLong();
        this.mDurationUs = parcel.readLong();
        this.mData = new byte[parcel.readInt()];
        parcel.readByteArray(this.mData);
        return true;
    }

    public byte[] getData() {
        return this.mData;
    }

    public long getDurationUs() {
        return this.mDurationUs;
    }

    public long getStartTimeUs() {
        return this.mStartTimeUs;
    }

    public int getTrackIndex() {
        return this.mTrackIndex;
    }
}
