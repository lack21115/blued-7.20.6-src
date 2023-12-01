package com.opos.exoplayer.core.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/drm/DrmInitData.class */
public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() { // from class: com.opos.exoplayer.core.drm.DrmInitData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DrmInitData[] newArray(int i) {
            return new DrmInitData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f11579a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    private final SchemeData[] f11580c;
    private int d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/drm/DrmInitData$SchemeData.class */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() { // from class: com.opos.exoplayer.core.drm.DrmInitData.SchemeData.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SchemeData[] newArray(int i) {
                return new SchemeData[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final String f11581a;
        public final byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f11582c;
        private int d;
        private final UUID e;

        SchemeData(Parcel parcel) {
            this.e = new UUID(parcel.readLong(), parcel.readLong());
            this.f11581a = parcel.readString();
            this.b = parcel.createByteArray();
            this.f11582c = parcel.readByte() != 0;
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, byte[] bArr, boolean z) {
            this.e = (UUID) com.opos.exoplayer.core.i.a.a(uuid);
            this.f11581a = (String) com.opos.exoplayer.core.i.a.a(str);
            this.b = bArr;
            this.f11582c = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            boolean z;
            if (obj instanceof SchemeData) {
                if (obj != this) {
                    SchemeData schemeData = (SchemeData) obj;
                    z = false;
                    if (this.f11581a.equals(schemeData.f11581a)) {
                        z = false;
                        if (u.a(this.e, schemeData.e)) {
                            if (!Arrays.equals(this.b, schemeData.b)) {
                                return false;
                            }
                        }
                    }
                    return z;
                }
                z = true;
                return z;
            }
            return false;
        }

        public int hashCode() {
            if (this.d == 0) {
                this.d = (((this.e.hashCode() * 31) + this.f11581a.hashCode()) * 31) + Arrays.hashCode(this.b);
            }
            return this.d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.e.getMostSignificantBits());
            parcel.writeLong(this.e.getLeastSignificantBits());
            parcel.writeString(this.f11581a);
            parcel.writeByteArray(this.b);
            parcel.writeByte(this.f11582c ? (byte) 1 : (byte) 0);
        }
    }

    DrmInitData(Parcel parcel) {
        this.f11579a = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.f11580c = schemeDataArr;
        this.b = schemeDataArr.length;
    }

    private DrmInitData(String str, boolean z, SchemeData... schemeDataArr) {
        this.f11579a = str;
        SchemeData[] schemeDataArr2 = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        Arrays.sort(schemeDataArr2, this);
        this.f11580c = schemeDataArr2;
        this.b = schemeDataArr2.length;
    }

    public DrmInitData(String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(List<SchemeData> list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(null, schemeDataArr);
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        return com.opos.exoplayer.core.b.b.equals(schemeData.e) ? com.opos.exoplayer.core.b.b.equals(schemeData2.e) ? 0 : 1 : schemeData.e.compareTo(schemeData2.e);
    }

    public SchemeData a(int i) {
        return this.f11580c[i];
    }

    public DrmInitData a(String str) {
        return u.a(this.f11579a, str) ? this : new DrmInitData(str, false, this.f11580c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                DrmInitData drmInitData = (DrmInitData) obj;
                z = false;
                if (u.a(this.f11579a, drmInitData.f11579a)) {
                    if (!Arrays.equals(this.f11580c, drmInitData.f11580c)) {
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
        if (this.d == 0) {
            String str = this.f11579a;
            this.d = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f11580c);
        }
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11579a);
        parcel.writeTypedArray(this.f11580c, 0);
    }
}
