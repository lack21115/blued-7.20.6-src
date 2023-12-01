package com.tencent.mapsdk.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yg.class */
public class yg {
    private static final String e = "[{\"id\":0,\"index\":0,\"order\":1},{\"id\":-1,\"index\":1,\"order\":-1},{\"id\":-1,\"index\":2,\"order\":-1},{\"id\":-1,\"index\":3,\"order\":-1},{\"id\":-1,\"index\":4,\"order\":-1},{\"id\":-1,\"index\":5,\"order\":-1},{\"id\":-1,\"index\":6,\"order\":-1},{\"id\":-1,\"index\":7,\"order\":-1},{\"id\":16,\"index\":8,\"order\":-1},{\"id\":9,\"index\":9,\"order\":-1},{\"id\":10,\"index\":10,\"order\":-1},{\"id\":5,\"index\":11,\"order\":-1},{\"id\":4,\"index\":12,\"order\":-1},{\"id\":6,\"index\":13,\"order\":-1},{\"id\":7,\"index\":14,\"order\":-1},{\"id\":8,\"index\":15,\"order\":-1}]";
    public static final int f = 1000;
    public static final int g = 11;

    /* renamed from: a  reason: collision with root package name */
    private volatile List<xg> f24439a;

    /* renamed from: c  reason: collision with root package name */
    private ic f24440c;
    private final Object b = new Object();
    private int d = -1;

    public yg(Context context, String str) {
        if (str == null) {
            this.f24440c = lc.a(context);
        } else {
            this.f24440c = kc.a(context, str);
        }
        b();
    }

    private List<xg> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Collections.sort(arrayList);
                return arrayList;
            }
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(new xg(jSONObject.getInt("index"), jSONObject.getInt("id"), jSONObject.getInt("order")));
                i = i2 + 1;
            } catch (Exception e2) {
                return null;
            }
        }
    }

    private void b() {
        this.f24439a = new CopyOnWriteArrayList();
        String d = this.f24440c.d(m4.A);
        String str = d;
        if (d == null) {
            str = e;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            synchronized (this.b) {
                this.f24439a.addAll(a(jSONArray));
            }
        } catch (Exception e2) {
        }
    }

    public xg a(int i) {
        xg next;
        synchronized (this.b) {
            if (this.f24439a != null && this.f24439a.size() != 0 && i >= 0) {
                int i2 = i - 1000;
                if (i2 < this.f24439a.size()) {
                    this.d = i;
                    if (i >= 1000) {
                        return this.f24439a.get(i2);
                    } else if (i > 8 && i < 989) {
                        int i3 = i + 11;
                        if (i3 >= this.f24439a.size()) {
                            return null;
                        }
                        return this.f24439a.get(i3);
                    } else {
                        Iterator<xg> it = this.f24439a.iterator();
                        do {
                            if (!it.hasNext()) {
                                return this.f24439a.get(0);
                            }
                            next = it.next();
                        } while (next.d != i);
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public String a() {
        if (this.f24439a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        for (xg xgVar : this.f24439a) {
            if (xgVar.f24423c != -1) {
                if (sb.length() == 0) {
                    sb.append(xgVar.f24423c);
                } else {
                    sb.append(",");
                    sb.append(xgVar.f24423c);
                }
            } else if (sb.length() == 0) {
                sb.append(0);
            } else {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void a(rc rcVar) {
        xg a2;
        if (rcVar == null || (a2 = a(this.d)) == null) {
            return;
        }
        rcVar.h().d(a2.b);
    }

    public int b(int i) {
        xg next;
        synchronized (this.b) {
            if (this.f24439a == null || this.f24439a.size() == 0 || i < 0) {
                return i;
            }
            if ((i < 8 || i > 19) && this.d < 1000) {
                if (i <= 19 || i >= 1000) {
                    Iterator<xg> it = this.f24439a.iterator();
                    do {
                        if (!it.hasNext()) {
                            return i;
                        }
                        next = it.next();
                    } while (i != next.b);
                    if (i == 0 && next.f24423c == 0 && this.d < 1) {
                        return 1000;
                    }
                    return next.d;
                }
                return i - 11;
            }
            return i + 1000;
        }
    }

    public void b(JSONArray jSONArray) {
        List<xg> a2;
        String d = this.f24440c.d(m4.A);
        if (jSONArray == null || (a2 = a(jSONArray)) == null) {
            return;
        }
        synchronized (this.b) {
            this.f24439a.clear();
            this.f24439a.addAll(a2);
        }
        if (jSONArray.toString().equals(d)) {
            return;
        }
        this.f24440c.b();
        this.f24440c.b(m4.A, jSONArray.toString());
    }
}
