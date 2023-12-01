package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.r;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/FloatLayerData.class */
public class FloatLayerData extends a implements Parcelable {
    public static final Parcelable.Creator<FloatLayerData> CREATOR = new Parcelable.Creator<FloatLayerData>() { // from class: com.opos.mobad.model.data.FloatLayerData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FloatLayerData createFromParcel(Parcel parcel) {
            FloatLayerData floatLayerData = null;
            if (parcel != null) {
                floatLayerData = new FloatLayerData();
                floatLayerData.a((MaterialFileData) parcel.readParcelable(FloatLayerData.class.getClassLoader()));
                floatLayerData.a(parcel.readString());
                floatLayerData.b(parcel.readString());
                floatLayerData.a(parcel.createTypedArrayList(MaterialFileData.CREATOR));
                floatLayerData.e = parcel.createTypedArrayList(MaterialFileData.CREATOR);
            }
            return floatLayerData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FloatLayerData[] newArray(int i) {
            return new FloatLayerData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private MaterialFileData f12783a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f12784c;
    private List<MaterialFileData> d;
    private List<MaterialFileData> e;

    private FloatLayerData() {
    }

    public FloatLayerData(r rVar, MaterialFileData materialFileData, List<MaterialFileData> list, List<MaterialFileData> list2) {
        this.f12783a = materialFileData;
        this.d = list;
        this.e = list2;
        this.b = rVar.e != null ? rVar.e : "";
        this.f12784c = rVar.f != null ? rVar.f : "";
    }

    public MaterialFileData a() {
        return this.f12783a;
    }

    public void a(MaterialFileData materialFileData) {
        this.f12783a = materialFileData;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(List<MaterialFileData> list) {
        this.d = list;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.f12784c = str;
    }

    public String c() {
        return this.f12784c;
    }

    public List<MaterialFileData> d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<MaterialFileData> e() {
        return this.e;
    }

    public String toString() {
        return "FloatLayerData{iconFile='" + this.f12783a + "'title='" + this.b + "'desc='" + this.f12784c + "'imgFileList='" + this.d + "'interactiveFileList='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12783a, i);
        parcel.writeString(this.b);
        parcel.writeString(this.f12784c);
        parcel.writeTypedList(this.d);
        parcel.writeTypedList(this.e);
    }
}
