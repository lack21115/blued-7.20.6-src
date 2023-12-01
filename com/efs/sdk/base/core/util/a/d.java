package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public b f21791a;
    private List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> b;

    public d(String str) {
        b bVar = new b();
        this.f21791a = bVar;
        bVar.f21788a = str;
    }

    public final c a() {
        c cVar = new c(this.f21791a);
        List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> list = this.b;
        if (list != null && list.size() > 0) {
            cVar.a(this.b);
        }
        List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> httpListenerList = HttpEnv.getInstance().getHttpListenerList();
        if (httpListenerList != null && httpListenerList.size() > 0) {
            cVar.a(httpListenerList);
        }
        return cVar;
    }

    public final d a(AbsHttpListener absHttpListener) {
        if (this.b == null) {
            this.b = new ArrayList(5);
        }
        this.b.add(absHttpListener);
        return this;
    }

    public final d a(String str, String str2) {
        if (this.f21791a.f == null) {
            this.f21791a.f = new HashMap(5);
        }
        this.f21791a.f.put(str, str2);
        return this;
    }

    public final d a(Map<String, String> map) {
        this.f21791a.b = map;
        return this;
    }
}
