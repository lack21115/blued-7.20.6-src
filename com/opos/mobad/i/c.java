package com.opos.mobad.i;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f26220a;
    private static final byte[] b = new byte[0];

    public static b a(Context context, a aVar) {
        b bVar;
        if (context != null && aVar != null) {
            a();
            try {
                bVar = f26220a.a(context.getApplicationContext(), aVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadTool", "download", (Throwable) e);
            }
            com.opos.cmn.an.f.a.b("DownloadTool", "download request=", aVar, "response=", bVar);
            return bVar;
        }
        bVar = null;
        com.opos.cmn.an.f.a.b("DownloadTool", "download request=", aVar, "response=", bVar);
        return bVar;
    }

    private static void a() {
        if (f26220a == null) {
            synchronized (b) {
                if (f26220a == null) {
                    f26220a = new com.opos.mobad.i.a.a();
                }
            }
        }
    }
}
