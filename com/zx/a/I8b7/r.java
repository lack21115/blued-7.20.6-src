package com.zx.a.I8b7;

import android.text.TextUtils;
import com.huawei.hms.api.FailedBinderCallBack;
import com.zx.a.I8b7.c3;
import com.zx.a.I8b7.u1;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f42187a = new JSONArray();

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/r$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42188a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f42189c;

        public a(String str, String str2, String str3) {
            this.f42188a = str;
            this.b = str2;
            this.f42189c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (r.this.f42187a.length() >= 100) {
                    z1.a("events length > MAX_COUNT " + r.this.f42187a.length());
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", currentTimeMillis);
                jSONObject.put(FailedBinderCallBack.CALLER_ID, this.f42188a);
                jSONObject.put("action", this.b);
                jSONObject.put("params", this.f42189c);
                r.this.f42187a.put(jSONObject);
                z1.a("events add:" + jSONObject.toString());
                if (t2.D) {
                    z1.a("events save:" + r.this.f42187a.toString());
                    u1 u1Var = u1.a.f42208a;
                    b3 b3Var = u1Var.f42207a;
                    String jSONArray = r.this.f42187a.toString();
                    b3Var.getClass();
                    u1Var.f42207a.a(23, jSONArray, true);
                }
            } catch (Throwable th) {
                z1.a(th);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/r$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final r f42190a = new r();
    }

    public void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            JSONArray jSONArray2 = this.f42187a;
            JSONArray jSONArray3 = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    for (int i3 = 0; i3 < jSONArray2.length() && jSONArray3.length() < 100; i3++) {
                        jSONArray3.put(jSONArray2.get(i3));
                    }
                } else if (jSONArray3.length() >= 100) {
                    break;
                } else {
                    jSONArray3.put(jSONArray.get(i2));
                    i = i2 + 1;
                }
            }
            this.f42187a = jSONArray3;
        } catch (JSONException e) {
            z1.a(e);
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            a aVar = new a(str, str2, str3);
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(aVar);
        } catch (Throwable th) {
            z1.a(th);
        }
    }
}
