package com.efs.sdk.base.core.a;

import android.os.Message;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/a/d.class */
public final class d extends AbsHttpListener {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/a/d$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f8118a = new d((byte) 0);
    }

    private d() {
    }

    /* synthetic */ d(byte b) {
        this();
    }

    public static d a() {
        return a.f8118a;
    }

    private static void a(HttpResponse httpResponse) {
        String str;
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (httpResponse == null) {
                str = "upload result : false";
            } else {
                str = "upload result : " + httpResponse.succ + ", resp is " + httpResponse.toString();
            }
            Log.i("efs.px.api", str);
        }
    }

    private static void b(HttpResponse httpResponse) {
        f fVar;
        fVar = f.a.f8175a;
        fVar.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }

    private static void c(HttpResponse httpResponse) {
        int parseInt;
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (!TextUtils.isEmpty(str) && (parseInt = Integer.parseInt(str)) > com.efs.sdk.base.core.config.a.c.a().d.f8143a) {
                com.efs.sdk.base.core.config.a.c.a().a(parseInt);
            }
        }
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* synthetic */ void a(com.efs.sdk.base.core.util.concurrent.c<HttpResponse> cVar, HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.util.a.b bVar = (com.efs.sdk.base.core.util.a.b) cVar;
            ((Map) httpResponse2.extra).putAll(bVar.f);
            bVar.f.clear();
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(HttpResponse httpResponse) {
        a(httpResponse);
        if (httpResponse == null) {
            return;
        }
        b(httpResponse);
        c(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(HttpResponse httpResponse) {
        int i;
        f fVar;
        if (!((Map) httpResponse.extra).containsKey("flow_limit") || !Boolean.FALSE.toString().equals(((Map) httpResponse.extra).get("flow_limit"))) {
            String str = ((Map) httpResponse.extra).containsKey("type") ? (String) ((Map) httpResponse.extra).get("type") : "";
            if (((Map) httpResponse.extra).containsKey(OapsKey.KEY_SIZE)) {
                String str2 = (String) ((Map) httpResponse.extra).get(OapsKey.KEY_SIZE);
                if (!TextUtils.isEmpty(str2)) {
                    i = Integer.parseInt(str2);
                    com.efs.sdk.base.core.c.b a2 = com.efs.sdk.base.core.c.b.a();
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = str;
                    obtain.arg1 = i;
                    a2.sendMessage(obtain);
                }
            }
            i = 0;
            com.efs.sdk.base.core.c.b a22 = com.efs.sdk.base.core.c.b.a();
            Message obtain2 = Message.obtain();
            obtain2.what = 0;
            obtain2.obj = str;
            obtain2.arg1 = i;
            a22.sendMessage(obtain2);
        }
        b(httpResponse);
        fVar = f.a.f8175a;
        fVar.f8174c.b.incrementAndGet();
        c(httpResponse);
        a(httpResponse);
    }
}
