package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cq.class */
class cq {

    /* renamed from: a  reason: collision with root package name */
    private String f27625a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<cp> f215a = new ArrayList<>();

    public cq() {
    }

    public cq(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f27625a = str;
    }

    public cp a() {
        synchronized (this) {
            int size = this.f215a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return null;
                }
                cp cpVar = this.f215a.get(i);
                if (cpVar.m8540a()) {
                    ct.a().m8552a(cpVar.a());
                    return cpVar;
                }
                size = i;
            }
        }
    }

    public cq a(JSONObject jSONObject) {
        synchronized (this) {
            this.f27625a = jSONObject.getString("host");
            JSONArray jSONArray = jSONObject.getJSONArray("fbs");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    this.f215a.add(new cp(this.f27625a).a(jSONArray.getJSONObject(i2)));
                    i = i2 + 1;
                }
            }
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8541a() {
        return this.f27625a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<cp> m8542a() {
        return this.f215a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m8543a() {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
            jSONObject.put("host", this.f27625a);
            JSONArray jSONArray = new JSONArray();
            Iterator<cp> it = this.f215a.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m8538a());
            }
            jSONObject.put("fbs", jSONArray);
        }
        return jSONObject;
    }

    public void a(cp cpVar) {
        int i;
        synchronized (this) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.f215a.size()) {
                    break;
                } else if (this.f215a.get(i).a(cpVar)) {
                    this.f215a.set(i, cpVar);
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            if (i >= this.f215a.size()) {
                this.f215a.add(cpVar);
            }
        }
    }

    public void a(boolean z) {
        ArrayList<cp> arrayList;
        synchronized (this) {
            int size = this.f215a.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    cp cpVar = this.f215a.get(i);
                    if (z) {
                        if (cpVar.c()) {
                            arrayList = this.f215a;
                            arrayList.remove(i);
                            size = i;
                        } else {
                            size = i;
                        }
                    } else if (cpVar.b()) {
                        size = i;
                    } else {
                        arrayList = this.f215a;
                        arrayList.remove(i);
                        size = i;
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f27625a);
        sb.append("\n");
        Iterator<cp> it = this.f215a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
