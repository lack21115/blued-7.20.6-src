package com.oplus.quickgame.sdk.hall.a;

import com.oplus.quickgame.sdk.QuickGame;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/hall/a/a.class */
public class a extends QuickGame.GameHallRouterBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f10742a = new HashMap();

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public String build() {
        return com.oplus.quickgame.sdk.hall.b.a.a(this.f10742a);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public QuickGame.GameHallRouterBuilder setHost(String str) {
        com.oplus.quickgame.sdk.hall.c.b.b(this.f10742a).b(str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public QuickGame.GameHallRouterBuilder setParams(Map<String, Object> map) {
        if (map != null) {
            com.oplus.quickgame.sdk.hall.c.b.b(this.f10742a).a(map);
        }
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public QuickGame.GameHallRouterBuilder setPath(String str) {
        com.oplus.quickgame.sdk.hall.c.b.b(this.f10742a).c(str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public QuickGame.GameHallRouterBuilder setScheme(String str) {
        com.oplus.quickgame.sdk.hall.c.b.b(this.f10742a).d(str);
        return this;
    }
}
