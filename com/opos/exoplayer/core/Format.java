package com.opos.exoplayer.core;

import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/Format.class */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() { // from class: com.opos.exoplayer.core.Format.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Format[] newArray(int i) {
            return new Format[i];
        }
    };
    private int A;

    /* renamed from: a  reason: collision with root package name */
    public final String f25000a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25001c;
    public final Metadata d;
    public final String e;
    public final String f;
    public final int g;
    public final List<byte[]> h;
    public final DrmInitData i;
    public final int j;
    public final int k;
    public final float l;
    public final int m;
    public final float n;
    public final int o;
    public final byte[] p;
    public final ColorInfo q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final long w;
    public final int x;
    public final String y;
    public final int z;

    Format(Parcel parcel) {
        this.f25000a = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.f25001c = parcel.readString();
        this.b = parcel.readInt();
        this.g = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.o = parcel.readInt();
        this.q = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readLong();
        int readInt = parcel.readInt();
        this.h = new ArrayList(readInt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                this.i = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
                this.d = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
                return;
            }
            this.h.add(parcel.createByteArray());
            i = i2 + 1;
        }
    }

    Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        this.f25000a = str;
        this.e = str2;
        this.f = str3;
        this.f25001c = str4;
        this.b = i;
        this.g = i2;
        this.j = i3;
        this.k = i4;
        this.l = f;
        this.m = i5;
        this.n = f2;
        this.p = bArr;
        this.o = i6;
        this.q = colorInfo;
        this.r = i7;
        this.s = i8;
        this.t = i9;
        this.u = i10;
        this.v = i11;
        this.x = i12;
        this.y = str5;
        this.z = i13;
        this.w = j;
        this.h = list == null ? Collections.emptyList() : list;
        this.i = drmInitData;
        this.d = metadata;
    }

    public static Format a(String str, String str2, int i, String str3) {
        return a(str, str2, i, str3, (DrmInitData) null);
    }

    public static Format a(String str, String str2, int i, String str3, DrmInitData drmInitData) {
        return a(str, str2, null, -1, i, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format a(String str, String str2, long j) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, DrmInitData drmInitData) {
        return a(str, str2, str3, i, i2, i3, i4, f, list, i5, f2, (byte[]) null, -1, (ColorInfo) null, drmInitData);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, i2, i3, i4, f, i5, f2, bArr, i6, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, int i8, String str4, Metadata metadata) {
        return new Format(str, null, str2, str3, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str4, -1, Long.MAX_VALUE, list, drmInitData, metadata);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        return a(str, str2, str3, i, i2, i3, i4, i5, -1, -1, list, drmInitData, i6, str4, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, int i5, String str4) {
        return a(str, str2, str3, i, i2, i3, i4, -1, list, drmInitData, i5, str4);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, String str4, int i3, DrmInitData drmInitData) {
        return a(str, str2, str3, i, i2, str4, i3, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i, int i2, String str4, int i3, DrmInitData drmInitData, long j, List<byte[]> list) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, i3, j, list, drmInitData, null);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format a(String str, String str2, String str3, int i, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, drmInitData, null);
    }

    private static void a(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo == null) {
            return;
        }
        a(mediaFormat, "color-transfer", colorInfo.f25560c);
        a(mediaFormat, "color-standard", colorInfo.f25559a);
        a(mediaFormat, "color-range", colorInfo.b);
        a(mediaFormat, "hdr-static-info", colorInfo.d);
    }

    private static void a(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    private static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    private static void a(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    private static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public int a() {
        int i = this.j;
        int i2 = -1;
        if (i != -1) {
            int i3 = this.k;
            if (i3 == -1) {
                return -1;
            }
            i2 = i * i3;
        }
        return i2;
    }

    public Format a(int i) {
        return new Format(this.f25000a, this.e, this.f, this.f25001c, this.b, i, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, this.i, this.d);
    }

    public Format a(int i, int i2) {
        return new Format(this.f25000a, this.e, this.f, this.f25001c, this.b, this.g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, i, i2, this.x, this.y, this.z, this.w, this.h, this.i, this.d);
    }

    public Format a(long j) {
        return new Format(this.f25000a, this.e, this.f, this.f25001c, this.b, this.g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, j, this.h, this.i, this.d);
    }

    public Format a(DrmInitData drmInitData) {
        return new Format(this.f25000a, this.e, this.f, this.f25001c, this.b, this.g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, drmInitData, this.d);
    }

    public Format a(Metadata metadata) {
        return new Format(this.f25000a, this.e, this.f, this.f25001c, this.b, this.g, this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r, this.s, this.t, this.u, this.v, this.x, this.y, this.z, this.w, this.h, this.i, metadata);
    }

    public final MediaFormat b() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(MediaFormat.KEY_MIME, this.f);
        a(mediaFormat, "language", this.y);
        a(mediaFormat, MediaFormat.KEY_MAX_INPUT_SIZE, this.g);
        a(mediaFormat, "width", this.j);
        a(mediaFormat, "height", this.k);
        a(mediaFormat, MediaFormat.KEY_FRAME_RATE, this.l);
        a(mediaFormat, "rotation-degrees", this.m);
        a(mediaFormat, MediaFormat.KEY_CHANNEL_COUNT, this.r);
        a(mediaFormat, MediaFormat.KEY_SAMPLE_RATE, this.s);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                a(mediaFormat, this.q);
                return mediaFormat;
            }
            mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(this.h.get(i2)));
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.b != format.b || this.g != format.g || this.j != format.j || this.k != format.k || this.l != format.l || this.m != format.m || this.n != format.n || this.o != format.o || this.r != format.r || this.s != format.s || this.t != format.t || this.u != format.u || this.v != format.v || this.w != format.w || this.x != format.x || !com.opos.exoplayer.core.i.u.a(this.f25000a, format.f25000a) || !com.opos.exoplayer.core.i.u.a(this.y, format.y) || this.z != format.z || !com.opos.exoplayer.core.i.u.a(this.e, format.e) || !com.opos.exoplayer.core.i.u.a(this.f, format.f) || !com.opos.exoplayer.core.i.u.a(this.f25001c, format.f25001c) || !com.opos.exoplayer.core.i.u.a(this.i, format.i) || !com.opos.exoplayer.core.i.u.a(this.d, format.d) || !com.opos.exoplayer.core.i.u.a(this.q, format.q) || !Arrays.equals(this.p, format.p) || this.h.size() != format.h.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                return true;
            }
            if (!Arrays.equals(this.h.get(i2), format.h.get(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public int hashCode() {
        if (this.A == 0) {
            String str = this.f25000a;
            int i = 0;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.e;
            int hashCode2 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.f;
            int hashCode3 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.f25001c;
            int hashCode4 = str4 == null ? 0 : str4.hashCode();
            int i2 = this.b;
            int i3 = this.j;
            int i4 = this.k;
            int i5 = this.r;
            int i6 = this.s;
            String str5 = this.y;
            int hashCode5 = str5 == null ? 0 : str5.hashCode();
            int i7 = this.z;
            DrmInitData drmInitData = this.i;
            int hashCode6 = drmInitData == null ? 0 : drmInitData.hashCode();
            Metadata metadata = this.d;
            if (metadata != null) {
                i = metadata.hashCode();
            }
            this.A = ((hashCode6 + ((((hashCode5 + ((((((((((((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31)) * 31)) * 31)) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6) * 31)) * 31) + i7) * 31)) * 31) + i;
        }
        return this.A;
    }

    public String toString() {
        return "Format(" + this.f25000a + ", " + this.e + ", " + this.f + ", " + this.b + ", " + this.y + ", [" + this.j + ", " + this.k + ", " + this.l + "], [" + this.r + ", " + this.s + "])";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f25000a);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.f25001c);
        parcel.writeInt(this.b);
        parcel.writeInt(this.g);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.p != null ? 1 : 0);
        byte[] bArr = this.p;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.o);
        parcel.writeParcelable(this.q, i);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeInt(this.z);
        parcel.writeLong(this.w);
        int size = this.h.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                parcel.writeParcelable(this.i, 0);
                parcel.writeParcelable(this.d, 0);
                return;
            }
            parcel.writeByteArray(this.h.get(i3));
            i2 = i3 + 1;
        }
    }
}
