package com.opos.mobad.provider.openId;

import android.content.Context;
import com.opos.cmn.g.a.b;
import com.opos.cmn.g.a.c;
import com.opos.mobad.provider.statistic.StatisticModel;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/openId/IdModel.class */
public class IdModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.openId.IdModel.1
        @Override // com.opos.process.bridge.provider.d.a
        public IdModel getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            IdModelIdentify idModelIdentify = (IdModelIdentify) iBridgeTargetIdentify;
            return IdModel.b(context.getApplicationContext(), idModelIdentify.f27119a, idModelIdentify.b);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static volatile IdModel f27117a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27118c;
    private String d;

    private IdModel(Context context, boolean z, String str) {
        this.b = context;
        this.f27118c = z;
        this.d = str;
        StatisticModel.a(context, z, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IdModel b(Context context, boolean z, String str) {
        if (f27117a == null) {
            synchronized (IdModel.class) {
                try {
                    if (f27117a == null) {
                        f27117a = new IdModel(context, z, str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27117a;
    }

    @BridgeMethod(a = 1)
    public OpenIdData a() {
        return new OpenIdData(b.a(this.b), b.b(this.b), !com.opos.cmn.an.f.a.b(this.b) ? b.c(this.b) : null);
    }

    @BridgeMethod(a = 2)
    public boolean b() {
        return b.h(this.b);
    }

    @BridgeMethod(a = 3)
    public String c() {
        c.b(this.b);
        return com.opos.cmn.an.f.a.b(this.b) ? c.c(this.b) : c.a(this.b);
    }
}
