package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/a/b.class */
public final class b extends AbsHttpListener {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/a/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f21721a = new b((byte) 0);
    }

    private b() {
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a() {
        return a.f21721a;
    }

    private static void a(HttpResponse httpResponse) {
        f fVar;
        fVar = f.a.f21781a;
        fVar.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* bridge */ /* synthetic */ void a(com.efs.sdk.base.core.util.concurrent.c<HttpResponse> cVar, HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return;
        }
        a(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(HttpResponse httpResponse) {
        f fVar;
        a(httpResponse);
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int parseInt = Integer.parseInt(str);
            fVar = f.a.f21781a;
            if (fVar.b == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                return;
            }
            com.efs.sdk.base.core.f.b bVar = new com.efs.sdk.base.core.f.b("efs_core", "config_coverage", fVar.f21779a.f21777c);
            bVar.put("cver", Integer.valueOf(parseInt));
            fVar.b.send(bVar);
        }
    }
}
