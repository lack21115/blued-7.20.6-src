package com.oplus.quickgame.sdk.engine.c;

import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/c/a.class */
public abstract class a extends QuickGame.Req {

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f24394a;
    Map<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, String> f24395c;
    Map<String, String> d;
    Callback e;
    String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        this.f24394a = bVar.f24396a;
        this.b = bVar.b;
        this.f24395c = bVar.f24397c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
    }
}
