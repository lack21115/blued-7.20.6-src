package com.anythink.expressad.exoplayer.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/e.class */
public final class e implements Parcelable, Comparator<a> {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.anythink.expressad.exoplayer.d.e.1
        private static e a(Parcel parcel) {
            return new e(parcel);
        }

        private static e[] a(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ e[] newArray(int i) {
            return new e[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f7253a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    private final a[] f7254c;
    private int d;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/e$a.class */
    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.d.e.a.1
            private static a a(Parcel parcel) {
                return new a(parcel);
            }

            private static a[] a(int i) {
                return new a[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ a[] newArray(int i) {
                return new a[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final String f7255a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f7256c;
        public final boolean d;
        private int e;
        private final UUID f;

        a(Parcel parcel) {
            this.f = new UUID(parcel.readLong(), parcel.readLong());
            this.f7255a = parcel.readString();
            this.b = parcel.readString();
            this.f7256c = parcel.createByteArray();
            this.d = parcel.readByte() != 0;
        }

        private a(UUID uuid, String str, String str2, byte[] bArr) {
            this.f = (UUID) com.anythink.expressad.exoplayer.k.a.a(uuid);
            this.f7255a = str;
            this.b = (String) com.anythink.expressad.exoplayer.k.a.a(str2);
            this.f7256c = bArr;
            this.d = false;
        }

        public a(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, (byte) 0);
        }

        private a(UUID uuid, String str, byte[] bArr, byte b) {
            this(uuid, (String) null, str, bArr);
        }

        private boolean b(a aVar) {
            return a() && !aVar.a() && a(aVar.f);
        }

        public final boolean a() {
            return this.f7256c != null;
        }

        public final boolean a(UUID uuid) {
            return com.anythink.expressad.exoplayer.b.bh.equals(this.f) || uuid.equals(this.f);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                if (obj == this) {
                    return true;
                }
                a aVar = (a) obj;
                return af.a((Object) this.f7255a, (Object) aVar.f7255a) && af.a((Object) this.b, (Object) aVar.b) && af.a(this.f, aVar.f) && Arrays.equals(this.f7256c, aVar.f7256c);
            }
            return false;
        }

        public final int hashCode() {
            if (this.e == 0) {
                int hashCode = this.f.hashCode();
                String str = this.f7255a;
                this.e = (((((hashCode * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.b.hashCode()) * 31) + Arrays.hashCode(this.f7256c);
            }
            return this.e;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f.getMostSignificantBits());
            parcel.writeLong(this.f.getLeastSignificantBits());
            parcel.writeString(this.f7255a);
            parcel.writeString(this.b);
            parcel.writeByteArray(this.f7256c);
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        }
    }

    e(Parcel parcel) {
        this.f7253a = parcel.readString();
        a[] aVarArr = (a[]) parcel.createTypedArray(a.CREATOR);
        this.f7254c = aVarArr;
        this.b = aVarArr.length;
    }

    private e(String str, List<a> list) {
        this(str, false, (a[]) list.toArray(new a[list.size()]));
    }

    private e(String str, boolean z, a... aVarArr) {
        this.f7253a = str;
        a[] aVarArr2 = z ? (a[]) aVarArr.clone() : aVarArr;
        Arrays.sort(aVarArr2, this);
        this.f7254c = aVarArr2;
        this.b = aVarArr2.length;
    }

    private e(String str, a... aVarArr) {
        this(str, true, aVarArr);
    }

    public e(List<a> list) {
        this(null, false, (a[]) list.toArray(new a[list.size()]));
    }

    private e(a... aVarArr) {
        this((String) null, aVarArr);
    }

    private static int a(a aVar, a aVar2) {
        return com.anythink.expressad.exoplayer.b.bh.equals(aVar.f) ? com.anythink.expressad.exoplayer.b.bh.equals(aVar2.f) ? 0 : 1 : aVar.f.compareTo(aVar2.f);
    }

    @Deprecated
    private a a(UUID uuid) {
        a[] aVarArr = this.f7254c;
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            a aVar = aVarArr[i2];
            if (aVar.a(uuid)) {
                return aVar;
            }
            i = i2 + 1;
        }
    }

    public static e a(e eVar, e eVar2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (eVar != null) {
            String str2 = eVar.f7253a;
            a[] aVarArr = eVar.f7254c;
            int length = aVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                str = str2;
                if (i2 >= length) {
                    break;
                }
                a aVar = aVarArr[i2];
                if (aVar.a()) {
                    arrayList.add(aVar);
                }
                i = i2 + 1;
            }
        } else {
            str = null;
        }
        String str3 = str;
        if (eVar2 != null) {
            String str4 = str;
            if (str == null) {
                str4 = eVar2.f7253a;
            }
            int size = arrayList.size();
            a[] aVarArr2 = eVar2.f7254c;
            int length2 = aVarArr2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                str3 = str4;
                if (i4 >= length2) {
                    break;
                }
                a aVar2 = aVarArr2[i4];
                if (aVar2.a() && !a(arrayList, size, aVar2.f)) {
                    arrayList.add(aVar2);
                }
                i3 = i4 + 1;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new e(str3, arrayList);
    }

    private static boolean a(ArrayList<a> arrayList, int i, UUID uuid) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return false;
            }
            if (arrayList.get(i3).f.equals(uuid)) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public final a a(int i) {
        return this.f7254c[i];
    }

    public final e a(String str) {
        return af.a((Object) this.f7253a, (Object) str) ? this : new e(str, false, this.f7254c);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(a aVar, a aVar2) {
        a aVar3 = aVar;
        a aVar4 = aVar2;
        return com.anythink.expressad.exoplayer.b.bh.equals(aVar3.f) ? com.anythink.expressad.exoplayer.b.bh.equals(aVar4.f) ? 0 : 1 : aVar3.f.compareTo(aVar4.f);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return af.a((Object) this.f7253a, (Object) eVar.f7253a) && Arrays.equals(this.f7254c, eVar.f7254c);
    }

    public final int hashCode() {
        if (this.d == 0) {
            String str = this.f7253a;
            this.d = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f7254c);
        }
        return this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7253a);
        parcel.writeTypedArray(this.f7254c, 0);
    }
}
