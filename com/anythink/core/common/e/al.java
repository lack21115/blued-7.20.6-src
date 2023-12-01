package com.anythink.core.common.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/al.class */
public final class al {
    static final String e = "reqId";
    static final String f = "reqDatetime";
    static final String g = "fillOffers";
    static final String h = "bidResps";
    static final String i = "adSourceId";
    static final String j = "price";
    static final String k = "networkFirmId";
    static final String l = "demandType";
    static final String m = "tp_bid_id";

    /* renamed from: a  reason: collision with root package name */
    String f6640a;
    long b;

    /* renamed from: c  reason: collision with root package name */
    List<a> f6641c = new ArrayList(3);
    List<a> d = new ArrayList(3);

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/al$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f6643a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public int f6644c;
        public double d;
        public String e;

        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
            if (r0 != 8) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.anythink.core.common.e.ai r5) {
            /*
                r4 = this;
                r0 = r4
                r0.<init>()
                r0 = r4
                r1 = r5
                java.lang.String r1 = r1.t()
                r0.b = r1
                com.anythink.core.b.f r0 = com.anythink.core.b.f.a()
                r1 = r5
                com.anythink.core.common.e.m r0 = r0.a(r1)
                r7 = r0
                r0 = r7
                if (r0 == 0) goto L3c
                r0 = r5
                boolean r0 = r0.aa()
                if (r0 == 0) goto L2a
                r0 = r4
                r1 = r7
                double r1 = r1.o
                r0.d = r1
                goto L44
            L2a:
                r0 = r5
                boolean r0 = r0.j()
                if (r0 == 0) goto L44
                r0 = r4
                r1 = r7
                double r1 = r1.price
                r0.d = r1
                goto L44
            L3c:
                r0 = r4
                r1 = r5
                double r1 = r1.x()
                r0.d = r1
            L44:
                r0 = r4
                r1 = r5
                int r1 = r1.c()
                r0.f6644c = r1
                r0 = r5
                int r0 = r0.l()
                r6 = r0
                r0 = r6
                if (r0 == 0) goto L90
                r0 = r6
                r1 = 1
                if (r0 == r1) goto L88
                r0 = r6
                r1 = 2
                if (r0 == r1) goto L80
                r0 = r6
                r1 = 3
                if (r0 == r1) goto L78
                r0 = r6
                r1 = 4
                if (r0 == r1) goto L88
                r0 = r6
                r1 = 7
                if (r0 == r1) goto L88
                r0 = r6
                r1 = 8
                if (r0 == r1) goto L90
                goto L95
            L78:
                r0 = r4
                r1 = 4
                r0.f6643a = r1
                goto L95
            L80:
                r0 = r4
                r1 = 3
                r0.f6643a = r1
                goto L95
            L88:
                r0 = r4
                r1 = 2
                r0.f6643a = r1
                goto L95
            L90:
                r0 = r4
                r1 = 1
                r0.f6643a = r1
            L95:
                r0 = 35
                r1 = r5
                int r1 = r1.c()
                if (r0 != r1) goto La3
                r0 = r4
                r1 = 2
                r0.f6643a = r1
            La3:
                r0 = r7
                if (r0 == 0) goto Laf
                r0 = r7
                java.lang.String r0 = r0.g
                r5 = r0
                goto Lb2
            Laf:
                java.lang.String r0 = ""
                r5 = r0
            Lb2:
                r0 = r4
                r1 = r5
                r0.e = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.al.a.<init>(com.anythink.core.common.e.ai):void");
        }

        public final JSONObject a() {
            JSONObject jSONObject;
            synchronized (this) {
                jSONObject = new JSONObject();
                jSONObject.put(al.i, this.b);
                jSONObject.put("price", this.d);
                jSONObject.put(al.k, this.f6644c);
                jSONObject.put(al.l, this.f6643a);
                jSONObject.put(al.m, this.e);
            }
            return jSONObject;
        }
    }

    public static al a(String str) {
        al alVar = new al();
        try {
            JSONObject jSONObject = new JSONObject(str);
            alVar.b(jSONObject.getString(e));
            alVar.a(jSONObject.getLong(f));
            alVar.a(alVar.c(jSONObject.getString(g)));
            alVar.b(alVar.c(jSONObject.getString(h)));
            return alVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return alVar;
        }
    }

    private void a(List<a> list) {
        synchronized (this) {
            this.f6641c = list;
        }
    }

    private void a(List<a> list, a aVar) {
        int i2;
        synchronized (this) {
            if (aVar != null) {
                if (list.size() == 0) {
                    list.add(aVar);
                    return;
                }
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= list.size()) {
                        i2 = -1;
                        break;
                    } else if (aVar.d > list.get(i2).d) {
                        break;
                    } else {
                        i3 = i2 + 1;
                    }
                }
                if (i2 != -1) {
                    list.add(i2, aVar);
                    return;
                }
                list.add(aVar);
            }
        }
    }

    private void b(List<a> list) {
        synchronized (this) {
            this.d = list;
        }
    }

    private long c() {
        long j2;
        synchronized (this) {
            j2 = this.b;
        }
        return j2;
    }

    private List<a> c(String str) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    a aVar = new a();
                    JSONObject jSONObject = new JSONObject(jSONArray.optString(i3));
                    aVar.b = jSONObject.getString(i);
                    aVar.d = jSONObject.getDouble("price");
                    aVar.f6644c = jSONObject.getInt(k);
                    aVar.f6643a = jSONObject.getInt(l);
                    if (jSONObject.has(m)) {
                        aVar.e = jSONObject.getString(m);
                    }
                    arrayList.add(aVar);
                    i2 = i3 + 1;
                }
                Collections.sort(arrayList, new Comparator<a>() { // from class: com.anythink.core.common.e.al.1
                    private static int a(a aVar2, a aVar3) {
                        if (aVar2.d > aVar3.d) {
                            return -1;
                        }
                        return aVar2.d == aVar3.d ? 0 : 1;
                    }

                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(a aVar2, a aVar3) {
                        a aVar4 = aVar2;
                        a aVar5 = aVar3;
                        if (aVar4.d > aVar5.d) {
                            return -1;
                        }
                        return aVar4.d == aVar5.d ? 0 : 1;
                    }
                });
            }
        }
        return arrayList;
    }

    private JSONArray c(List<a> list) {
        JSONArray jSONArray;
        synchronized (this) {
            jSONArray = new JSONArray();
            if (list != null) {
                for (a aVar : list) {
                    jSONArray.put(aVar.a());
                }
            }
        }
        return jSONArray;
    }

    private JSONArray d() {
        JSONArray c2;
        synchronized (this) {
            c2 = c(this.f6641c);
        }
        return c2;
    }

    private JSONArray e() {
        JSONArray c2;
        synchronized (this) {
            c2 = c(this.d);
        }
        return c2;
    }

    public final JSONObject a() {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
            jSONObject.put(e, this.f6640a);
            jSONObject.put(f, this.b);
            jSONObject.put(g, d());
            jSONObject.put(h, e());
        }
        return jSONObject;
    }

    public final void a(long j2) {
        synchronized (this) {
            this.b = j2;
        }
    }

    public final void a(a aVar) {
        synchronized (this) {
            a(this.f6641c, aVar);
        }
    }

    public final String b() {
        String str;
        synchronized (this) {
            str = this.f6640a;
        }
        return str;
    }

    public final void b(a aVar) {
        synchronized (this) {
            a(this.d, aVar);
        }
    }

    public final void b(String str) {
        synchronized (this) {
            this.f6640a = str;
        }
    }
}
