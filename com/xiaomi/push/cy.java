package com.xiaomi.push;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cy.class */
class cy implements Comparable<cy> {

    /* renamed from: a  reason: collision with root package name */
    protected int f27632a;

    /* renamed from: a  reason: collision with other field name */
    private long f229a;

    /* renamed from: a  reason: collision with other field name */
    String f230a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<co> f231a;

    public cy() {
        this(null, 0);
    }

    public cy(String str) {
        this(str, 0);
    }

    public cy(String str, int i) {
        this.f231a = new LinkedList<>();
        this.f229a = 0L;
        this.f230a = str;
        this.f27632a = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(cy cyVar) {
        if (cyVar == null) {
            return 1;
        }
        return cyVar.f27632a - this.f27632a;
    }

    public cy a(JSONObject jSONObject) {
        synchronized (this) {
            this.f229a = jSONObject.getLong("tt");
            this.f27632a = jSONObject.getInt(com.anythink.expressad.d.a.b.R);
            this.f230a = jSONObject.getString("host");
            JSONArray jSONArray = jSONObject.getJSONArray("ah");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    this.f231a.add(new co().a(jSONArray.getJSONObject(i2)));
                    i = i2 + 1;
                }
            }
        }
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
            jSONObject.put("tt", this.f229a);
            jSONObject.put(com.anythink.expressad.d.a.b.R, this.f27632a);
            jSONObject.put("host", this.f230a);
            JSONArray jSONArray = new JSONArray();
            Iterator<co> it = this.f231a.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m8536a());
            }
            jSONObject.put("ah", jSONArray);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(co coVar) {
        synchronized (this) {
            if (coVar != null) {
                this.f231a.add(coVar);
                int a2 = coVar.a();
                if (a2 > 0) {
                    this.f27632a += coVar.a();
                } else {
                    int i = 0;
                    int size = this.f231a.size();
                    while (true) {
                        int i2 = size - 1;
                        if (i2 < 0 || this.f231a.get(i2).a() >= 0) {
                            break;
                        }
                        i++;
                        size = i2;
                    }
                    this.f27632a += a2 * i;
                }
                if (this.f231a.size() > 30) {
                    this.f27632a -= this.f231a.remove().a();
                }
            }
        }
    }

    public String toString() {
        return this.f230a + ":" + this.f27632a;
    }
}
