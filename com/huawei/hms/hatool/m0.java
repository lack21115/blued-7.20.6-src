package com.huawei.hms.hatool;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/m0.class */
public class m0 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    public String f22770a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f22771c;
    public List<q> d;

    public m0(List<q> list, String str, String str2, String str3) {
        this.f22770a = str;
        this.b = str2;
        this.f22771c = str3;
        this.d = list;
    }

    public final void a() {
        h0.a(b.i(), "backup_event", v0.a(this.f22770a, this.f22771c, this.b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<q> list = this.d;
        if (list == null || list.size() == 0) {
            z.d("hmsSdk", "failed events is empty");
            return;
        }
        if (r0.a(b.i(), "cached_v2_1", b.k() * 1048576)) {
            z.e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.b);
            return;
        }
        String a2 = v0.a(this.f22770a, this.f22771c);
        List<q> list2 = w.b(b.i(), "cached_v2_1", a2).get(a2);
        if (list2 != null && list2.size() != 0) {
            this.d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        for (q qVar : this.d) {
            try {
                jSONArray.put(qVar.d());
            } catch (JSONException e) {
                z.e("hmsSdk", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > b.h() * 1048576) {
            z.e("hmsSdk", "this failed data is too long,can not writing it");
            this.d = null;
            return;
        }
        z.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.b);
        h0.b(b.i(), "cached_v2_1", a2, jSONArray2);
        a();
    }
}
