package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.util.SoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q5.class */
public class q5 implements Parcelable, TencentLocation {
    public static final Parcelable.Creator<TencentLocation> CREATOR = new a();
    public static final q5 q = new q5(-1);

    /* renamed from: a  reason: collision with root package name */
    public n5 f3948a;
    public m5 b;

    /* renamed from: c  reason: collision with root package name */
    public int f3949c;
    public int d;
    public String e;
    public int f;
    public l5 g;
    public final Bundle h;
    public String i;
    public String j;
    public Location k;
    public final long l;
    public long m;
    public long n;
    public int o;
    public int p;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q5$a.class */
    public static final class a implements Parcelable.Creator<TencentLocation> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TencentLocation createFromParcel(Parcel parcel) {
            q5 q5Var = new q5(parcel.readInt(), (a) null);
            n5 n5Var = new n5();
            l5 l5Var = new l5();
            p5 p5Var = new p5();
            l5Var.f3875c = p5Var;
            q5Var.i = parcel.readString();
            q5Var.j = parcel.readString();
            n5Var.f3896a = parcel.readDouble();
            n5Var.b = parcel.readDouble();
            n5Var.d = parcel.readFloat();
            n5Var.f3897c = parcel.readDouble();
            n5Var.g = parcel.readString();
            p5Var.f3933a = parcel.readString();
            p5Var.e = parcel.readString();
            p5Var.f = parcel.readString();
            p5Var.g = parcel.readString();
            p5Var.j = parcel.readString();
            p5Var.k = parcel.readString();
            p5Var.b = parcel.readString();
            q5Var.f3948a = n5Var;
            q5Var.g = l5Var;
            q5Var.m = parcel.readLong();
            q5Var.n = parcel.readLong();
            Bundle readBundle = parcel.readBundle();
            if (readBundle != null) {
                q5Var.h.putAll(readBundle);
            }
            return q5Var;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TencentLocation[] newArray(int i) {
            return new TencentLocation[i];
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q5$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f3950a;
        public q5 b;

        /* renamed from: c  reason: collision with root package name */
        public int f3951c;
        public String d = "network";
        public Location e;
        public Bundle f;

        public b a(int i) {
            this.f3951c = i;
            return this;
        }

        public b a(Location location) {
            this.e = new Location(location);
            return this;
        }

        public b a(Bundle bundle) {
            this.f = bundle;
            return this;
        }

        public b a(q5 q5Var) {
            this.b = q5Var;
            return this;
        }

        public b a(String str) {
            this.f3950a = str;
            return this;
        }

        public q5 a() {
            q5 q5Var;
            String str = this.f3950a;
            if (str != null) {
                try {
                    q5Var = new q5(str, (a) null);
                } catch (JSONException e) {
                    return q5.q;
                }
            } else {
                q5Var = q5.c(this.b);
            }
            q5Var.b(this.f3951c).a(this.d).a(this.e);
            if (this.f != null) {
                q5Var.h.putAll(this.f);
            }
            h5.a(q5Var, this.e);
            n2.a(q5Var.h, "lastNetLocationTimeStampUseWifi", new Long(f6.f3812a), Long.class);
            n2.a(q5Var.h, "lastNetLocationTimeStampUseCellOnly", new Long(f6.b), Long.class);
            return q5Var;
        }

        public b b(String str) {
            this.d = str;
            return this;
        }
    }

    public q5(int i) {
        this.h = new Bundle(9);
        this.i = "network";
        this.j = "wifi";
        this.f3949c = i;
        this.l = SystemClock.elapsedRealtime();
        this.m = System.currentTimeMillis();
    }

    public /* synthetic */ q5(int i, a aVar) {
        this(i);
    }

    public q5(String str) throws JSONException {
        p5 p5Var;
        this.h = new Bundle(9);
        this.i = "network";
        this.j = "wifi";
        this.l = SystemClock.elapsedRealtime();
        this.m = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(str);
        try {
            this.f3948a = new n5(jSONObject.getJSONObject("location"));
            try {
                this.b = new m5(jSONObject.getJSONObject("indoorinfo"));
            } catch (Throwable th) {
            }
            this.e = jSONObject.optString("bearing");
            this.d = jSONObject.optInt("fackgps", 0);
            long optLong = jSONObject.optLong("timestamp", System.currentTimeMillis());
            this.n = optLong;
            this.m = optLong;
            try {
                String optString = jSONObject.optString("icontrol");
                if (!TextUtils.isEmpty(optString)) {
                    this.h.putInt("icontrol", Integer.valueOf(optString.split(",")[0]).intValue());
                }
            } catch (Exception e) {
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("details");
            if (optJSONObject != null) {
                try {
                    this.g = new l5(optJSONObject);
                } catch (JSONException e2) {
                    throw e2;
                }
            } else {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("addrdesp");
                if (optJSONObject2 != null && optJSONObject2.has("detail")) {
                    this.g = new l5(optJSONObject2.optJSONObject("detail"));
                }
            }
            l5 l5Var = this.g;
            if (l5Var == null || (p5Var = l5Var.f3875c) == null) {
                return;
            }
            this.h.putAll(p5Var.m);
        } catch (JSONException e3) {
            throw e3;
        }
    }

    public /* synthetic */ q5(String str, a aVar) throws JSONException {
        this(str);
    }

    public static q5 a(q5 q5Var, q5 q5Var2) {
        if (q5Var != null && q5Var2 != null) {
            n5 n5Var = q5Var2.f3948a;
            if (n5Var != null) {
                n5 n5Var2 = q5Var.f3948a;
                n5 n5Var3 = n5Var2;
                if (n5Var2 == null) {
                    n5Var3 = new n5();
                }
                n5Var3.f = n5Var.f;
                n5Var3.g = n5Var.g;
                q5Var.f3948a = n5Var3;
            }
            q5Var.g = l5.a(q5Var2.g);
        }
        return q5Var;
    }

    public static q5 a(q5 q5Var, boolean z) {
        String str;
        if (q5Var != null && (str = q5Var.e) != null && !z) {
            int i = 0;
            if (str != null) {
                i = 0;
                if (str.split(",").length > 1) {
                    i = Integer.parseInt(str.split(",")[1]);
                }
            }
            n5 n5Var = q5Var.f3948a;
            if (n5Var != null) {
                try {
                    n5Var.d = (float) SoUtils.fun_r(n5Var.d, i, -70);
                } catch (UnsatisfiedLinkError e) {
                    return q5Var;
                }
            }
        }
        return q5Var;
    }

    public static q5 b(q5 q5Var, int i) {
        q5Var.o = i;
        return q5Var;
    }

    public static q5 c(q5 q5Var) {
        q5 q5Var2 = new q5(-1);
        if (q5Var == null) {
            q5Var2.f3948a = new n5();
            return q5Var2;
        }
        q5Var2.f3948a = n5.a(q5Var.f3948a);
        q5Var2.f3949c = q5Var.f3949c;
        q5Var2.e = q5Var.e;
        q5Var2.g = l5.a(q5Var.g);
        if (q5Var.h.size() > 0) {
            q5Var2.h.putAll(q5Var.h);
        }
        return q5Var2;
    }

    public static void d(q5 q5Var) throws JSONException {
        if (q5Var == q) {
            throw new JSONException("location failed");
        }
    }

    public final float a() {
        float f = 0.0f;
        if ((getFakeReason() & 1) != 0) {
            f = Math.max(0.0f, 0.99f);
        }
        float f2 = f;
        if ((getFakeReason() & 2) != 0) {
            f2 = Math.max(f, 0.8f);
        }
        float f3 = f2;
        if ((getFakeReason() & 4) != 0) {
            f3 = Math.max(f2, 0.8f);
        }
        float f4 = f3;
        if ((getFakeReason() & 8) != 0) {
            f4 = Math.max(f3, 0.9f);
        }
        float f5 = f4;
        if ((getFakeReason() & 16) != 0) {
            f5 = Math.max(f4, 0.9f);
        }
        float f6 = f5;
        if ((getFakeReason() & 32) != 0) {
            f6 = Math.max(f5, 0.8f);
        }
        float f7 = f6;
        if ((getFakeReason() & 64) != 0) {
            f7 = Math.max(f6, 0.9f);
        }
        return f7;
    }

    public q5 a(long j) {
        this.m = j;
        return this;
    }

    public final q5 a(Location location) {
        this.k = location;
        return this;
    }

    public q5 a(String str) {
        this.i = str;
        return this;
    }

    public void a(double d, double d2) {
        this.f3948a.f3896a = Math.round(d * 1000000.0d) / 1000000.0d;
        this.f3948a.b = Math.round(d2 * 1000000.0d) / 1000000.0d;
    }

    public void a(int i) {
        this.f = i;
    }

    public final q5 b(int i) {
        this.f3949c = i;
        return this;
    }

    public String b() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.f3934c;
        }
        return null;
    }

    public void b(Location location) {
        if (location == null || this.f3948a == null) {
            return;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        double round = Math.round(latitude * 1000000.0d) / 1000000.0d;
        double round2 = Math.round(longitude * 1000000.0d) / 1000000.0d;
        n5 n5Var = this.f3948a;
        n5Var.f3896a = round;
        n5Var.b = round2;
        n5Var.f3897c = location.getAltitude();
        this.f3948a.d = location.getAccuracy();
    }

    public long c() {
        return this.n;
    }

    public void c(int i) {
        if ("gps".equals(getProvider())) {
            if (i != 0) {
                this.j = TencentLocation.FAKE;
            } else {
                this.j = "gps";
            }
        } else if (!"network".equals(getProvider())) {
            this.j = getProvider();
        } else if (i != 0) {
            this.j = TencentLocation.FAKE;
        } else if (getAccuracy() <= 150.0d) {
            this.j = "wifi";
        } else {
            this.j = "cell";
        }
        this.p = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getAccuracy() {
        n5 n5Var = this.f3948a;
        if (n5Var != null) {
            return n5Var.d;
        }
        return 0.0f;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getAddress() {
        int i = this.f3949c;
        if (i == 5) {
            return this.h.getString("addrdesp.name");
        }
        String str = null;
        if (i == 3) {
            l5 l5Var = this.g;
            if (l5Var != null) {
                str = l5Var.f3875c.l;
            }
            return str;
        }
        n5 n5Var = this.f3948a;
        String str2 = null;
        if (n5Var != null) {
            str2 = n5Var.g;
        }
        return str2;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getAltitude() {
        n5 n5Var = this.f3948a;
        if (n5Var != null) {
            return n5Var.f3897c;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public Integer getAreaStat() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return Integer.valueOf(l5Var.f3874a);
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getBearing() {
        Location location = this.k;
        if (location == null) {
            return 0.0f;
        }
        return location.getBearing();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCity() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.f;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCityCode() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.f3934c;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCityPhoneCode() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.d;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getCoordinateType() {
        return this.o;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getDirection() {
        Bundle bundle = this.h;
        if (bundle != null) {
            return bundle.getDouble("direction");
        }
        return Double.NaN;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getDistrict() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.g;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public long getElapsedRealtime() {
        return this.l;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public Bundle getExtra() {
        return this.h;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getFakeProbability() {
        return a();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getFakeReason() {
        return this.p;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getGPSRssi() {
        Bundle extras;
        Location location = this.k;
        if (location == null || (extras = location.getExtras()) == null) {
            return 0;
        }
        return extras.getInt("rssi", 0);
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getIndoorBuildingFloor() {
        m5 m5Var = this.b;
        return m5Var != null ? m5Var.b : Constants.DEFAULT_UIN;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getIndoorBuildingId() {
        m5 m5Var = this.b;
        if (m5Var != null) {
            return m5Var.f3884a;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getIndoorLocationType() {
        m5 m5Var = this.b;
        if (m5Var != null) {
            return m5Var.f3885c;
        }
        return -1;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getLatitude() {
        n5 n5Var = this.f3948a;
        if (n5Var != null) {
            return n5Var.f3896a;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getLongitude() {
        n5 n5Var = this.f3948a;
        if (n5Var != null) {
            return n5Var.b;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getName() {
        int i = this.f3949c;
        if (i == 5) {
            return this.h.getString("addrdesp.name");
        }
        String str = null;
        if (i == 3) {
            l5 l5Var = this.g;
            if (l5Var != null) {
                str = l5Var.f3875c.b;
            }
            return str;
        }
        n5 n5Var = this.f3948a;
        String str2 = null;
        if (n5Var != null) {
            str2 = n5Var.f;
        }
        return str2;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getNation() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.f3933a;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getNationCode() {
        return this.f;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public List<TencentPoi> getPoiList() {
        return this.g != null ? new ArrayList(this.g.b) : Collections.emptyList();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getProvider() {
        return this.i;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getProvince() {
        l5 l5Var = this.g;
        return l5Var != null ? l5Var.f3875c.e : "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getSourceProvider() {
        return this.j;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getSpeed() {
        Location location = this.k;
        if (location == null) {
            return 0.0f;
        }
        return location.getSpeed();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getStreet() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.j;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getStreetNo() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.k;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public long getTime() {
        return this.m;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getTown() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.h;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getVillage() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.i;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getadCode() {
        l5 l5Var = this.g;
        if (l5Var != null) {
            return l5Var.f3875c.f3934c;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int isMockGps() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TxLocation{");
        sb.append("level=");
        sb.append(this.f3949c);
        sb.append(",");
        sb.append("name=");
        sb.append(getName());
        sb.append(",");
        sb.append("address=");
        sb.append(getAddress());
        sb.append(",");
        sb.append("provider=");
        sb.append(getProvider());
        sb.append(",");
        sb.append("latitude=");
        sb.append(getLatitude());
        sb.append(",");
        sb.append("longitude=");
        sb.append(getLongitude());
        sb.append(",");
        sb.append("altitude=");
        sb.append(getAltitude());
        sb.append(",");
        sb.append("accuracy=");
        sb.append(getAccuracy());
        sb.append(",");
        sb.append("sourceProvider=");
        sb.append(getSourceProvider());
        sb.append(",");
        sb.append("fakeReason=");
        sb.append(getFakeReason());
        sb.append(",");
        sb.append("fakeProbability=");
        sb.append(getFakeProbability());
        sb.append(",");
        sb.append("cityCode=");
        sb.append(getCityCode());
        sb.append(",");
        sb.append("areaStat=");
        sb.append(getAreaStat());
        sb.append(",");
        sb.append("nation=");
        sb.append(getNation());
        sb.append(",");
        sb.append("province=");
        sb.append(getProvince());
        sb.append(",");
        sb.append("city=");
        sb.append(getCity());
        sb.append(",");
        sb.append("district=");
        sb.append(getDistrict());
        sb.append(",");
        sb.append("street=");
        sb.append(getStreet());
        sb.append(",");
        sb.append("streetNo=");
        sb.append(getStreetNo());
        sb.append(",");
        sb.append("town=");
        sb.append(getTown());
        sb.append(",");
        sb.append("village=");
        sb.append(getVillage());
        sb.append(",");
        sb.append("bearing=");
        sb.append(getBearing());
        sb.append(",");
        sb.append("time=");
        sb.append(getTime());
        sb.append(",");
        sb.append("poilist=[");
        for (TencentPoi tencentPoi : getPoiList()) {
            sb.append(tencentPoi);
            sb.append(",");
        }
        sb.append("]");
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3949c);
        parcel.writeString(getProvider());
        parcel.writeDouble(getLatitude());
        parcel.writeDouble(getLongitude());
        parcel.writeDouble(getAccuracy());
        parcel.writeDouble(getAltitude());
        parcel.writeString(getAddress());
        parcel.writeString(getSourceProvider());
        parcel.writeString(getNation());
        parcel.writeString(getProvince());
        parcel.writeString(getCity());
        parcel.writeString(getDistrict());
        parcel.writeString(getStreet());
        parcel.writeString(getStreetNo());
        parcel.writeString(b());
        parcel.writeString(getName());
        parcel.writeLong(this.m);
        parcel.writeLong(this.n);
        parcel.writeBundle(this.h);
    }
}
