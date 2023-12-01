package com.tencent.tmsqmsp.sdk.c;

import android.content.Context;
import com.tencent.mapsdk.internal.oj;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/l.class */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, e> f26041a = new HashMap<>();

    public void a(e eVar) {
        String a2 = eVar.a();
        if (a2 == null || this.f26041a.containsKey(a2)) {
            return;
        }
        this.f26041a.put(a2, eVar);
    }

    @Override // com.tencent.tmsqmsp.sdk.c.c
    public Object getApplicationContext() {
        Context context;
        context = oj.getContext();
        return context;
    }

    @Override // com.tencent.tmsqmsp.sdk.c.c
    public int getRuntimeVersion() {
        return 512;
    }

    @Override // com.tencent.tmsqmsp.sdk.c.c
    public e queryRuntimeInterface(String str) {
        if (str == null) {
            return null;
        }
        e eVar = this.f26041a.get(str);
        if (eVar == null || str.equals(eVar.a())) {
            return eVar;
        }
        return null;
    }
}
