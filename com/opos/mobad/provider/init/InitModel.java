package com.opos.mobad.provider.init;

import android.content.Context;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/init/InitModel.class */
public class InitModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.init.InitModel.1
        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return InitModel.b(context.getApplicationContext());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static volatile InitModel f27113a;
    private Context b;

    public InitModel(Context context) {
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitModel b(Context context) {
        if (f27113a == null) {
            synchronized (InitModel.class) {
                try {
                    if (f27113a == null) {
                        f27113a = new InitModel(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27113a;
    }

    @BridgeMethod(a = 1)
    public void a(boolean z, boolean z2) {
        com.opos.cmn.c.a.a(this.b.getApplicationContext(), z, z2);
        com.opos.cmn.an.f.a.b("", "init ContentProvider Log " + z2);
    }
}
