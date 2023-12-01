package c.t.m.g;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k5.class */
public class k5 implements Parcelable {
    public static final Parcelable.Creator<k5> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f3865a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f3866c;
    public double d;
    public double e;
    public double f;
    public String g;
    public String h;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k5$a.class */
    public static final class a implements Parcelable.Creator<k5> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public k5 createFromParcel(Parcel parcel) {
            k5 k5Var = new k5();
            k5Var.f3865a = parcel.readString();
            k5Var.b = parcel.readString();
            k5Var.f3866c = parcel.readString();
            k5Var.d = parcel.readDouble();
            k5Var.e = parcel.readDouble();
            k5Var.f = parcel.readDouble();
            k5Var.g = parcel.readString();
            k5Var.h = parcel.readString();
            return k5Var;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public k5[] newArray(int i) {
            return new k5[i];
        }
    }

    public k5() {
    }

    public k5(JSONObject jSONObject) {
        this.f3865a = jSONObject.optString("name");
        this.b = jSONObject.optString("dtype");
        this.f3866c = jSONObject.optString("addr");
        this.d = jSONObject.optDouble("pointx");
        this.e = jSONObject.optDouble("pointy");
        this.f = jSONObject.optDouble("dist");
        this.g = jSONObject.optString("direction");
        this.h = jSONObject.optString("tag");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AddressData{name=" + this.f3865a + ",dtype=" + this.b + ",pointx=" + this.d + ",pointy=" + this.e + ",dist=" + this.f + ",direction=" + this.g + ",tag=" + this.h + "," + com.alipay.sdk.util.i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3865a);
        parcel.writeString(this.b);
        parcel.writeString(this.f3866c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.e);
        parcel.writeDouble(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }
}
