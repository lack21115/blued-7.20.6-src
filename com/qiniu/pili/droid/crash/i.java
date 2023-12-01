package com.qiniu.pili.droid.crash;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Throwable f13796a;
    private Thread b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f13797c = new HashMap();
    private Map<String, String> d = new HashMap();
    private Context e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.e = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i a(ReportField reportField, String str) {
        this.d.put(reportField.name(), str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i a(Thread thread) {
        this.b = thread;
        return this;
    }

    public i a(Throwable th) {
        this.f13796a = th;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(ReportField reportField) {
        return this.d.get(reportField.name());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        return this.f13797c.get(str);
    }

    public Thread a() {
        return this.b;
    }

    public Throwable b() {
        return this.f13796a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(new JSONObject(this.d));
        jSONObject.put("__logs__", jSONArray);
        return jSONObject;
    }

    public void d() {
        d dVar = new d(this.e);
        try {
            if (dVar.a(this)) {
                dVar.b(this);
                f a2 = f.a();
                a2.a(new File(a2.c(), a(ReportField.crash_time)), this);
            }
        } catch (Exception e) {
        }
    }
}
