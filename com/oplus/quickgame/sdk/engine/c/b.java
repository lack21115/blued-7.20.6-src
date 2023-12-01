package com.oplus.quickgame.sdk.engine.c;

import android.app.backup.FullBackup;
import com.cdo.oaps.ad.OapsKey;
import com.google.common.net.HttpHeaders;
import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/c/b.class */
public class b extends QuickGame.Builder {

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f10709a = new HashMap();
    Map<String, String> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    Map<String, String> f10710c = null;
    Map<String, String> d = null;
    Callback e;
    String f;

    public b(String str, String str2) {
        a(str);
        b(str2);
    }

    private QuickGame.Builder a(String str) {
        this.b.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, str);
        return this;
    }

    private QuickGame.Builder b(String str) {
        this.b.put("secret", str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Req build() {
        return new d(this);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder putDeepLink(String str, String str2) {
        if (this.f10709a == null) {
            this.f10709a = new HashMap();
        }
        this.f10709a.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder putExtra(String str, String str2) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder putPlatform(String str, String str2) {
        this.b.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder putStat(String str, String str2) {
        if (this.f10710c == null) {
            this.f10710c = new HashMap();
        }
        this.f10710c.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder setCallback(Callback callback) {
        this.e = callback;
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder setExtra(String str) {
        this.f10709a.put("ext", str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder setFrom(String str) {
        this.f10709a.put(FullBackup.DATA_TREE_TOKEN, str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    @Deprecated
    public QuickGame.Builder setPackage(String str) {
        this.f10709a.put("pkg", str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder setRequestUrl(String str) {
        this.f = str;
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder signAsPlatform() {
        this.b.put(OapsKey.KEY_SIGN_TYPE, "1");
        return this;
    }
}
