package com.opos.mobad.provider.ad;

import android.content.Context;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/ad/AdCacheModel.class */
public class AdCacheModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.ad.AdCacheModel.1
        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return AdCacheModel.b(context.getApplicationContext());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static volatile AdCacheModel f27109a;
    private b b;

    private AdCacheModel(Context context) {
        this.b = new b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdCacheModel b(Context context) {
        if (f27109a == null) {
            synchronized (AdCacheModel.class) {
                try {
                    if (f27109a == null) {
                        f27109a = new AdCacheModel(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27109a;
    }

    @BridgeMethod(a = 2)
    public AdEntity a(String str) {
        return this.b.a(str);
    }

    @BridgeMethod(a = 1)
    public void a(String str, AdEntity adEntity) {
        this.b.a(str, adEntity);
    }
}
