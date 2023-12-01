package com.oplus.instant.router.f;

import com.oplus.instant.router.Instant;
import com.oplus.instant.router.g.d;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/f/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f10606a = new a();
    private Instant.IStatisticsProvider b = null;

    /* renamed from: c  reason: collision with root package name */
    private Instant.IStatisticsProvider f10607c = new C0442a(this);

    /* renamed from: com.oplus.instant.router.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/f/a$a.class */
    class C0442a implements Instant.IStatisticsProvider {
        C0442a(a aVar) {
        }

        @Override // com.oplus.instant.router.Instant.IStatisticsProvider
        public void onStat(Map<String, String> map) {
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                sb.append("[");
                sb.append(str);
                sb.append(":");
                sb.append(map.get(str));
                sb.append("]");
            }
            d.c("router_stat", "fail to stat:" + sb.toString());
        }
    }

    private a() {
    }

    public static a a() {
        return f10606a;
    }

    public void a(Instant.IStatisticsProvider iStatisticsProvider) {
        this.b = iStatisticsProvider;
    }

    public Instant.IStatisticsProvider b() {
        Instant.IStatisticsProvider iStatisticsProvider = this.b;
        return iStatisticsProvider != null ? iStatisticsProvider : this.f10607c;
    }
}
