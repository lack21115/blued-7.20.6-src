package com.opos.mobad.provider.monitor;

import android.content.Context;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/monitor/MonitorModel.class */
public class MonitorModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.monitor.MonitorModel.1
        @Override // com.opos.process.bridge.provider.d.a
        public d getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return MonitorModel.b(context.getApplicationContext());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static volatile MonitorModel f27115a;
    private Context b;

    private MonitorModel(Context context) {
        this.b = context;
        com.opos.cmn.biz.monitor.a.a().a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MonitorModel b(Context context) {
        if (f27115a == null) {
            synchronized (MonitorModel.class) {
                try {
                    if (f27115a == null) {
                        f27115a = new MonitorModel(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27115a;
    }

    @BridgeMethod(a = 1)
    public void a(String str, MonitorEvent monitorEvent) {
        com.opos.cmn.biz.monitor.a.a().a(this.b, str, monitorEvent);
    }
}
