package com.bytedance.bdtracker;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/t3.class */
public final class t3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f21312a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f21313c;
    public final Long d;
    public final Long e;
    public final Integer f;
    public final Long g;

    public t3(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.f21312a = str;
        this.b = str2;
        this.f21313c = bool;
        this.d = l;
        this.e = l2;
        this.f = num;
        this.g = l3;
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        r3.a(hashMap, "id", this.f21312a);
        r3.a(hashMap, "req_id", this.b);
        r3.a(hashMap, "is_track_limited", String.valueOf(this.f21313c));
        r3.a(hashMap, "take_ms", String.valueOf(this.d));
        r3.a(hashMap, "time", String.valueOf(this.e));
        r3.a(hashMap, "query_times", String.valueOf(this.f));
        r3.a(hashMap, "hw_id_version_code", String.valueOf(this.g));
        return hashMap;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        r3.a(jSONObject, "id", this.f21312a);
        r3.a(jSONObject, "req_id", this.b);
        r3.a(jSONObject, "is_track_limited", this.f21313c);
        r3.a(jSONObject, "take_ms", this.d);
        r3.a(jSONObject, "time", this.e);
        r3.a(jSONObject, "query_times", this.f);
        r3.a(jSONObject, "hw_id_version_code", this.g);
        return jSONObject;
    }

    public String toString() {
        return b().toString();
    }
}
