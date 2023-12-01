package com.bytedance.bdtracker;

import android.net.Uri;
import com.bytedance.applog.network.INetworkClient;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public c f21255a;

    public m(c appLogInstance) {
        Intrinsics.d(appLogInstance, "appLogInstance");
        this.f21255a = appLogInstance;
    }

    public final i<g> a(String uri, h queryParam) {
        Intrinsics.d(uri, "uri");
        Intrinsics.d(queryParam, "queryParam");
        try {
            INetworkClient netClient = this.f21255a.getNetClient();
            q1 q1Var = this.f21255a.j;
            Intrinsics.b(q1Var, "appLogInstance.api");
            String str = netClient.get(q1Var.f21291c.a(a(uri, queryParam.a())), a());
            Intrinsics.b(str, "appLogInstance.netClient…etHeaders()\n            )");
            return i.b.a(str, g.class);
        } catch (Throwable th) {
            return null;
        }
    }

    public final i<j> a(String uri, k request, h queryParam) {
        Intrinsics.d(uri, "uri");
        Intrinsics.d(request, "request");
        Intrinsics.d(queryParam, "queryParam");
        try {
            INetworkClient netClient = this.f21255a.getNetClient();
            q1 q1Var = this.f21255a.j;
            Intrinsics.b(q1Var, "appLogInstance.api");
            String a2 = q1Var.f21291c.a(a(uri, queryParam.a()));
            q1 q1Var2 = this.f21255a.j;
            Intrinsics.b(q1Var2, "appLogInstance.api");
            return i.b.a(netClient.post(a2, q1Var2.f21291c.b(request.toString()), a()), j.class);
        } catch (Throwable th) {
            return null;
        }
    }

    public final String a(String str, JSONObject jSONObject) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (!(optString == null || optString.length() == 0)) {
                buildUpon.appendQueryParameter(next, jSONObject.optString(next));
            }
        }
        return buildUpon.build().toString();
    }

    public final HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>(2);
        hashMap.put("Content-Type", this.f21255a.A ? "application/octet-stream;tt-data=a" : "application/json; charset=utf-8");
        return hashMap;
    }
}
