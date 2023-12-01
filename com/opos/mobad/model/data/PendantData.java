package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.y;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/PendantData.class */
public class PendantData extends a implements Parcelable {
    public static final Parcelable.Creator<PendantData> CREATOR = new Parcelable.Creator<PendantData>() { // from class: com.opos.mobad.model.data.PendantData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PendantData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new PendantData((MaterialFileData) parcel.readParcelable(PendantData.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PendantData[] newArray(int i) {
            return new PendantData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private MaterialFileData f26479a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f26480c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.model.data.PendantData$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/PendantData$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26481a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[y.i.b.values().length];
            f26481a = iArr;
            try {
                iArr[y.i.b.UPPER_LEFT_CORNER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f26481a[y.i.b.BOTTOM_RIGHT_CORNER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private PendantData() {
    }

    public PendantData(MaterialFileData materialFileData, int i, int i2) {
        this.f26479a = materialFileData;
        this.b = i;
        this.f26480c = i2;
    }

    public PendantData(MaterialFileData materialFileData, y.i iVar) {
        this.f26479a = materialFileData;
        this.b = MaterialData.a(iVar.h);
        this.f26480c = a(iVar.f);
    }

    private int a(y.i.b bVar) {
        return (bVar == null || AnonymousClass2.f26481a[bVar.ordinal()] != 2) ? 1 : 0;
    }

    public MaterialFileData a() {
        return this.f26479a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f26480c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PendantData{imgFile=" + this.f26479a + ", actionType=" + this.b + ", pendantPosition=" + this.f26480c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f26479a, i);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f26480c);
    }
}
