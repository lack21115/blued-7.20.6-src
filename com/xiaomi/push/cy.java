package com.xiaomi.push;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cy.class */
public class cy implements Comparable<cy> {

    /* renamed from: a  reason: collision with root package name */
    protected int f41323a;

    /* renamed from: a  reason: collision with other field name */
    private long f276a;

    /* renamed from: a  reason: collision with other field name */
    String f277a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<co> f278a;

    public cy() {
        this(null, 0);
    }

    public cy(String str) {
        this(str, 0);
    }

    public cy(String str, int i) {
        this.f278a = new LinkedList<>();
        this.f276a = 0L;
        this.f277a = str;
        this.f41323a = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(cy cyVar) {
        if (cyVar == null) {
            return 1;
        }
        return cyVar.f41323a - this.f41323a;
    }

    public cy a(JSONObject jSONObject) {
        synchronized (this) {
            this.f276a = jSONObject.getLong("tt");
            this.f41323a = jSONObject.getInt(com.anythink.expressad.d.a.b.R);
            this.f277a = jSONObject.getString("host");
            JSONArray jSONArray = jSONObject.getJSONArray("ah");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    this.f278a.add(new co().a(jSONArray.getJSONObject(i2)));
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
            jSONObject.put("tt", this.f276a);
            jSONObject.put(com.anythink.expressad.d.a.b.R, this.f41323a);
            jSONObject.put("host", this.f277a);
            JSONArray jSONArray = new JSONArray();
            Iterator<co> it = this.f278a.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m11586a());
            }
            jSONObject.put("ah", jSONArray);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(co coVar) {
        synchronized (this) {
            if (coVar != null) {
                this.f278a.add(coVar);
                int a2 = coVar.a();
                if (a2 > 0) {
                    this.f41323a += coVar.a();
                } else {
                    int i = 0;
                    int size = this.f278a.size();
                    while (true) {
                        int i2 = size - 1;
                        if (i2 < 0 || this.f278a.get(i2).a() >= 0) {
                            break;
                        }
                        i++;
                        size = i2;
                    }
                    this.f41323a += a2 * i;
                }
                if (this.f278a.size() > 30) {
                    this.f41323a -= this.f278a.remove().a();
                }
            }
        }
    }

    public String toString() {
        return this.f277a + ":" + this.f41323a;
    }
}
