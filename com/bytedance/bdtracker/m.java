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
    public c f7649a;

    public m(c cVar) {
        Intrinsics.d(cVar, "appLogInstance");
        this.f7649a = cVar;
    }

    public final i<g> a(String str, h hVar) {
        Intrinsics.d(str, "uri");
        Intrinsics.d(hVar, "queryParam");
        try {
            INetworkClient netClient = this.f7649a.getNetClient();
            q1 q1Var = this.f7649a.j;
            Intrinsics.b(q1Var, "appLogInstance.api");
            String str2 = netClient.get(q1Var.f7685c.a(a(str, hVar.a())), a());
            Intrinsics.b(str2, "appLogInstance.netClient…etHeaders()\n            )");
            return i.b.a(str2, g.class);
        } catch (Throwable th) {
            return null;
        }
    }

    public final i<j> a(String str, k kVar, h hVar) {
        Intrinsics.d(str, "uri");
        Intrinsics.d(kVar, "request");
        Intrinsics.d(hVar, "queryParam");
        try {
            INetworkClient netClient = this.f7649a.getNetClient();
            q1 q1Var = this.f7649a.j;
            Intrinsics.b(q1Var, "appLogInstance.api");
            String a2 = q1Var.f7685c.a(a(str, hVar.a()));
            q1 q1Var2 = this.f7649a.j;
            Intrinsics.b(q1Var2, "appLogInstance.api");
            return i.b.a(netClient.post(a2, q1Var2.f7685c.b(kVar.toString()), a()), j.class);
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
        hashMap.put("Content-Type", this.f7649a.A ? "application/octet-stream;tt-data=a" : "application/json; charset=utf-8");
        return hashMap;
    }
}
