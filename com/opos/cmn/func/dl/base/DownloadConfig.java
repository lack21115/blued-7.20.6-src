package com.opos.cmn.func.dl.base;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/DownloadConfig.class */
public class DownloadConfig implements Parcelable {
    public static final Parcelable.Creator<DownloadConfig> CREATOR = new Parcelable.Creator<DownloadConfig>() { // from class: com.opos.cmn.func.dl.base.DownloadConfig.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadConfig createFromParcel(Parcel parcel) {
            return new DownloadConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadConfig[] newArray(int i) {
            return new DownloadConfig[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f11179a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f11180c;
    private boolean d;
    private float e;
    private int f;
    private int g;

    public DownloadConfig() {
        this.f11179a = 3;
        this.b = 2;
        this.f11180c = 3;
        this.d = true;
        this.e = 0.02f;
        this.f = 100;
        this.g = 8192;
    }

    private DownloadConfig(Parcel parcel) {
        this.f11179a = 3;
        this.b = 2;
        this.f11180c = 3;
        boolean z = true;
        this.d = true;
        this.e = 0.02f;
        this.f = 100;
        this.g = 8192;
        this.f11179a = parcel.readInt();
        this.b = parcel.readInt();
        this.f11180c = parcel.readInt();
        this.d = parcel.readByte() == 0 ? false : z;
        this.e = parcel.readFloat();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
    }

    public int a() {
        return this.f11179a;
    }

    public DownloadConfig a(float f, int i, int i2) {
        this.e = f;
        this.f = i;
        this.g = i2;
        return this;
    }

    public DownloadConfig a(int i) {
        this.f11180c = i;
        return this;
    }

    public DownloadConfig a(boolean z) {
        this.d = z;
        return this;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f11180c;
    }

    public boolean d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public String toString() {
        return "DownloadConfig{, readThreadCountPerTask=" + this.f11179a + ", writeThreadCount=" + this.b + ", maxDownloadNum=" + this.f11180c + ", listenOnUi=" + this.d + ", notifyRatio=" + this.e + ", notifyInterval=" + this.f + ", notifyIntervalSize=" + this.g + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11179a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f11180c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
    }
}
