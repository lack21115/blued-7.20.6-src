package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import com.anythink.expressad.foundation.g.f.g.c;
import com.google.common.net.HttpHeaders;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.func.b.b.e;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a.class */
public final class a {

    /* renamed from: com.opos.cmn.biz.requeststatistic.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a$a.class */
    public interface InterfaceC0460a {
        void onFail();

        void onSuccess();
    }

    public static final void a(Context context, String str, InterfaceC0460a interfaceC0460a) {
        e eVar;
        e eVar2 = null;
        try {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-type", "application/json");
                hashMap.put(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
                hashMap.put("Connection", c.f5066c);
                hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                hashMap.put("Content-Encoding", "gzip");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(str.getBytes());
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                eVar = com.opos.cmn.func.b.b.b.a().a(context, new d.a().a(hashMap).a(byteArray).a("POST").b(b.a(context)).a());
                if (eVar == null || 200 != eVar.f11174a) {
                    if (interfaceC0460a != null) {
                        interfaceC0460a.onFail();
                    }
                } else if (interfaceC0460a != null) {
                    interfaceC0460a.onSuccess();
                }
                if (eVar == null) {
                    return;
                }
            } catch (Exception e) {
                if (interfaceC0460a != null) {
                    interfaceC0460a.onFail();
                }
                if (0 == 0) {
                    return;
                }
                eVar = null;
            }
            eVar.a();
        } catch (Throwable th) {
            if (0 != 0) {
                eVar2.a();
            }
            throw th;
        }
    }
}
