package com.opos.cmn.func.dl.base;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Map;
import java.util.Objects;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/DownloadRequest.class */
public class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() { // from class: com.opos.cmn.func.dl.base.DownloadRequest.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadRequest[] newArray(int i) {
            return new DownloadRequest[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f24869a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public String f24870c;
    public final int d;
    public final String e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final Map<String, String> j;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/DownloadRequest$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f24871a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f24872c;
        private String d;
        private int e;
        private String f;
        private int g;
        private boolean h;
        private boolean i;
        private Map<String, String> j;

        public a(String str) {
            this.b = str;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public DownloadRequest a(Context context) {
            if (TextUtils.isEmpty(this.b) || context == null) {
                throw new IllegalArgumentException("download url or context should not be null");
            }
            if (TextUtils.isEmpty(this.f24872c)) {
                this.f24872c = context.getExternalCacheDir().getAbsolutePath();
            }
            this.g = com.opos.cmn.func.dl.base.h.a.a(this.b, this.f24872c);
            return new DownloadRequest(this);
        }

        public a b(String str) {
            this.f24872c = str;
            return this;
        }

        public a b(boolean z) {
            this.h = z;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a c(boolean z) {
            this.f24871a = z;
            return this;
        }
    }

    private DownloadRequest(Parcel parcel) {
        this.f24869a = parcel.readString();
        this.b = parcel.readString();
        this.f24870c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readByte() != 0;
        this.h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.j = parcel.readHashMap(Map.class.getClassLoader());
    }

    private DownloadRequest(a aVar) {
        this.f24869a = aVar.b;
        this.b = aVar.f24872c;
        this.f24870c = aVar.d;
        this.d = aVar.e;
        this.e = aVar.f;
        this.g = aVar.f24871a;
        this.h = aVar.h;
        this.f = aVar.g;
        this.i = aVar.i;
        this.j = aVar.j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                DownloadRequest downloadRequest = (DownloadRequest) obj;
                z = false;
                if (Objects.equals(this.f24869a, downloadRequest.f24869a)) {
                    if (!Objects.equals(this.b, downloadRequest.b)) {
                        return false;
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        return Objects.hash(this.f24869a, this.b);
    }

    public String toString() {
        return "DownloadRequest{url='" + this.f24869a + "', dirPath='" + this.b + "', fileName='" + this.f24870c + "', priority=" + this.d + ", md5='" + this.e + "', downloadId=" + this.f + ", autoRetry=" + this.g + ", downloadIfExist=" + this.h + ", allowMobileDownload=" + this.i + ", headerMap=" + this.j + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f24869a);
        parcel.writeString(this.b);
        parcel.writeString(this.f24870c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeMap(this.j);
    }
}
