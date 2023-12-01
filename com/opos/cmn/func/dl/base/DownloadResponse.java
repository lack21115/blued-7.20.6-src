package com.opos.cmn.func.dl.base;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/DownloadResponse.class */
public class DownloadResponse implements Parcelable {
    public static final Parcelable.Creator<DownloadResponse> CREATOR = new Parcelable.Creator<DownloadResponse>() { // from class: com.opos.cmn.func.dl.base.DownloadResponse.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadResponse createFromParcel(Parcel parcel) {
            return new DownloadResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadResponse[] newArray(int i) {
            return new DownloadResponse[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f24873a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f24874c;
    public long d;
    public long e;

    public DownloadResponse() {
        this.f24873a = 0;
    }

    private DownloadResponse(Parcel parcel) {
        this.f24873a = 0;
        this.f24873a = parcel.readInt();
        this.b = parcel.readLong();
        this.f24874c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StatusResponse{status=" + this.f24873a + ", startLen=" + this.b + ", downloadedLen=" + this.f24874c + ", totalLen=" + this.d + ", speed=" + this.e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f24873a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.f24874c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
    }
}
