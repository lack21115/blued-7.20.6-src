package com.opos.mobad.provider.strategy;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/strategy/StrategyModel.class */
public class StrategyModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.strategy.StrategyModel.1
        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return StrategyModel.b(context);
        }
    };
    private static volatile StrategyModel b;

    /* renamed from: a  reason: collision with root package name */
    private Context f27136a;

    /* renamed from: c  reason: collision with root package name */
    private a f27137c;

    private StrategyModel(Context context) {
        this.f27136a = context;
        this.f27137c = new a(context);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrategyModel b(Context context) {
        if (b == null) {
            synchronized (StrategyModel.class) {
                try {
                    if (b == null) {
                        b = new StrategyModel(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private void b() {
        d("dispatch_strategy");
    }

    private void c(String str) {
        d("dispatch_strategy_" + str);
    }

    private void d(String str) {
        if (this.f27136a != null && Build.VERSION.SDK_INT >= 24) {
            this.f27136a.deleteSharedPreferences(str);
        }
    }

    @BridgeMethod(a = 3)
    public Bundle a(String str) {
        return this.f27137c.b(str);
    }

    @BridgeMethod(a = 5)
    public AppInfo a() {
        return this.f27137c.a();
    }

    @BridgeMethod(a = 2)
    public void a(String str, StrategyInfo strategyInfo) {
        this.f27137c.a(str, strategyInfo.b, strategyInfo.f27135a);
    }

    @BridgeMethod(a = 1)
    public void a(String str, String str2, AppInfo appInfo) {
        c(str);
        this.f27137c.a(str2, appInfo.b, appInfo.f27133a);
    }

    @BridgeMethod(a = 4)
    public AppInfo b(String str) {
        return this.f27137c.a(str);
    }
}
