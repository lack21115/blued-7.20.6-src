package android.view;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-4181928-dex2jar.jar:android/view/WindowContentFrameStats.class */
public final class WindowContentFrameStats extends FrameStats implements Parcelable {
    public static final Parcelable.Creator<WindowContentFrameStats> CREATOR = new Parcelable.Creator<WindowContentFrameStats>() { // from class: android.view.WindowContentFrameStats.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WindowContentFrameStats createFromParcel(Parcel parcel) {
            return new WindowContentFrameStats(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WindowContentFrameStats[] newArray(int i) {
            return new WindowContentFrameStats[i];
        }
    };
    private long[] mFramesPostedTimeNano;
    private long[] mFramesReadyTimeNano;

    public WindowContentFrameStats() {
    }

    private WindowContentFrameStats(Parcel parcel) {
        this.mRefreshPeriodNano = parcel.readLong();
        this.mFramesPostedTimeNano = parcel.createLongArray();
        this.mFramesPresentedTimeNano = parcel.createLongArray();
        this.mFramesReadyTimeNano = parcel.createLongArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getFramePostedTimeNano(int i) {
        if (this.mFramesPostedTimeNano == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.mFramesPostedTimeNano[i];
    }

    public long getFrameReadyTimeNano(int i) {
        if (this.mFramesReadyTimeNano == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.mFramesReadyTimeNano[i];
    }

    public void init(long j, long[] jArr, long[] jArr2, long[] jArr3) {
        this.mRefreshPeriodNano = j;
        this.mFramesPostedTimeNano = jArr;
        this.mFramesPresentedTimeNano = jArr2;
        this.mFramesReadyTimeNano = jArr3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WindowContentFrameStats[");
        sb.append("frameCount:" + getFrameCount());
        sb.append(", fromTimeNano:" + getStartTimeNano());
        sb.append(", toTimeNano:" + getEndTimeNano());
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mRefreshPeriodNano);
        parcel.writeLongArray(this.mFramesPostedTimeNano);
        parcel.writeLongArray(this.mFramesPresentedTimeNano);
        parcel.writeLongArray(this.mFramesReadyTimeNano);
    }
}
