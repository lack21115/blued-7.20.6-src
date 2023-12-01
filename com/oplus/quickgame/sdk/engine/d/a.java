package com.oplus.quickgame.sdk.engine.d;

import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.utils.i;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/d/a.class */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f24402c = new a();

    /* renamed from: a  reason: collision with root package name */
    private QuickGame.IStatisticsProvider f24403a = null;
    private QuickGame.IStatisticsProvider b = new C0616a(this);

    /* renamed from: com.oplus.quickgame.sdk.engine.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/d/a$a.class */
    class C0616a implements QuickGame.IStatisticsProvider {
        C0616a(a aVar) {
        }

        @Override // com.oplus.quickgame.sdk.QuickGame.IStatisticsProvider
        public void onStat(Map<String, String> map) {
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                sb.append("[");
                sb.append(str);
                sb.append(":");
                sb.append(map.get(str));
                sb.append("]");
            }
            i.b("router_stat", "fail to stat:" + sb.toString());
        }
    }

    private a() {
    }

    public static a b() {
        return f24402c;
    }

    public QuickGame.IStatisticsProvider a() {
        QuickGame.IStatisticsProvider iStatisticsProvider = this.f24403a;
        return iStatisticsProvider != null ? iStatisticsProvider : this.b;
    }

    public void a(QuickGame.IStatisticsProvider iStatisticsProvider) {
        this.f24403a = iStatisticsProvider;
    }
}
