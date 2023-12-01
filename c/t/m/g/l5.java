package c.t.m.g;

import android.os.Parcelable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/l5.class */
public class l5 {

    /* renamed from: a  reason: collision with root package name */
    public int f3874a;
    public final ArrayList<TencentPoi> b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public p5 f3875c;

    public l5() {
    }

    public l5(JSONObject jSONObject) throws JSONException {
        this.f3874a = jSONObject.optInt("stat");
        if (jSONObject.has("subnation")) {
            this.f3875c = new p5(jSONObject.optJSONObject("subnation"));
        } else if (jSONObject.has("results")) {
            this.f3875c = a(jSONObject.optJSONArray("results"));
        } else {
            this.f3875c = p5.n;
            jSONObject.toString();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("poilist");
        if (optJSONArray == null) {
            return;
        }
        try {
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                this.b.add(new o5(optJSONArray.getJSONObject(i2)));
                i = i2 + 1;
            }
        } catch (JSONException e) {
        }
    }

    public static l5 a(l5 l5Var) {
        if (l5Var == null) {
            return null;
        }
        l5 l5Var2 = new l5();
        l5Var2.f3874a = l5Var.f3874a;
        l5Var2.f3875c = p5.a(l5Var.f3875c);
        Iterator<TencentPoi> it = l5Var.b.iterator();
        while (it.hasNext()) {
            l5Var2.b.add(new o5(it.next()));
        }
        return l5Var2;
    }

    public final p5 a(JSONArray jSONArray) {
        p5 a2;
        JSONObject optJSONObject;
        if (jSONArray == null || (a2 = p5.a(p5.n)) == null) {
            return null;
        }
        int length = jSONArray.length();
        if (length > 0 && (optJSONObject = jSONArray.optJSONObject(0)) != null) {
            a2.f3933a = optJSONObject.optString("n", null);
            a2.e = optJSONObject.optString("p", null);
            a2.f = optJSONObject.optString("c", null);
            a2.g = optJSONObject.optString("d", null);
            a2.f3934c = optJSONObject.optString("adcode", null);
        }
        if (length > 1) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(1);
            a2.m.putString("addrdesp.name", optJSONObject2.optString("address_name"));
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("landmark");
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("second_landmark");
            if (optJSONObject3 != null) {
                a2.m.putParcelable(TencentLocation.EXTRA_ADDRDESP_LANDMARK, new k5(optJSONObject3));
            }
            if (optJSONObject4 != null) {
                a2.m.putParcelable(TencentLocation.EXTRA_ADDRDESP_SECOND_LANDMARK, new k5(optJSONObject4));
            }
        }
        if (length > 2) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i = 2; i < length; i++) {
                k5 k5Var = new k5(jSONArray.optJSONObject(i));
                arrayList.add(k5Var);
                if ("ST".equals(k5Var.b)) {
                    a2.j = k5Var.f3865a;
                } else if ("ST_NO".equals(k5Var.b)) {
                    a2.k = k5Var.f3865a;
                }
            }
            a2.m.putParcelableArrayList(TencentLocation.EXTRA_ADDRDESP_OTHERS_RESULTS, arrayList);
        }
        return a2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DetailsData{");
        sb.append("subnation=");
        sb.append(this.f3875c);
        sb.append(",");
        sb.append("poilist=[");
        Iterator<TencentPoi> it = this.b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        sb.append("]");
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }
}
