package com.tencent.qmsp.sdk.c;

import android.content.Context;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/l.class */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, e> f38576a = new HashMap<>();

    public void a(e eVar) {
        String a2 = eVar.a();
        if (a2 == null || this.f38576a.containsKey(a2)) {
            return;
        }
        this.f38576a.put(a2, eVar);
    }

    @Override // com.tencent.qmsp.sdk.c.c
    public Object getApplicationContext() {
        Context context;
        context = com.tencent.qmsp.sdk.app.a.getContext();
        return context;
    }

    @Override // com.tencent.qmsp.sdk.c.c
    public int getRuntimeVersion() {
        return 512;
    }

    @Override // com.tencent.qmsp.sdk.c.c
    public e queryRuntimeInterface(String str) {
        if (str == null) {
            return null;
        }
        e eVar = this.f38576a.get(str);
        if (eVar == null || str.equals(eVar.a())) {
            return eVar;
        }
        return null;
    }
}
