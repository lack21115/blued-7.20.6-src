package com.efs.sdk.base.core.f;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.cdo.oaps.ad.OapsWrapper;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/f/g.class */
public final class g extends com.efs.sdk.base.core.f.a {
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>(10);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/f/g$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f21782a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f21783c;
        AtomicInteger d = new AtomicInteger(0);

        a(String str, String str2, String str3) {
            this.f21782a = str;
            this.b = str2;
            this.f21783c = str3;
        }
    }

    @Override // com.efs.sdk.base.core.f.a
    public final void a() {
        f fVar;
        try {
            if (this.f21773a == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                return;
            }
            for (Map.Entry<String, a> entry : this.b.entrySet()) {
                a value = entry.getValue();
                int i = value.d.get();
                if (i > 0) {
                    ControllerCenter controllerCenter = this.f21773a;
                    String str = value.f21782a;
                    String str2 = value.b;
                    String str3 = value.f21783c;
                    fVar = f.a.f21781a;
                    b bVar = new b("efs_core", "req_succ_rate", fVar.f21779a.f21777c);
                    bVar.put("rep_code", str);
                    bVar.put("px_code", str2);
                    bVar.put(OapsWrapper.KEY_PATH, str3);
                    bVar.put("cnt", Integer.valueOf(i));
                    controllerCenter.send(bVar);
                    value.d.addAndGet(i * (-1));
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2, String str3) {
        String str4 = str + BridgeUtil.UNDERLINE_STR + str2 + BridgeUtil.UNDERLINE_STR + str3.trim();
        if (!this.b.containsKey(str4) || this.b.get(str4) == null) {
            this.b.putIfAbsent(str4, new a(str, str2, str3));
        }
        this.b.get(str4).d.incrementAndGet();
    }
}
