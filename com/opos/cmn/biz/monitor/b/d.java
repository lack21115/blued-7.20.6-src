package com.opos.cmn.biz.monitor.b;

import android.content.Context;
import android.os.Handler;
import com.opos.cmn.biz.monitor.b.a;
import com.opos.cmn.biz.monitor.b.c;
import com.opos.cmn.func.b.b.d;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/b/d.class */
public class d implements a {
    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(com.opos.cmn.func.b.b.e eVar, String str) {
        if (!com.opos.cmn.biz.monitor.e.a(str) || eVar == null || 200 != eVar.f24862a || eVar.d <= 0 || eVar.f24863c == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            do {
                int read = eVar.f24863c.read(bArr);
                if (-1 == read) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } while (byteArrayOutputStream.size() <= 8192);
            return null;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("DefaultRequestResolver", "getResponseBytes error,url" + str, th);
            return null;
        }
    }

    @Override // com.opos.cmn.biz.monitor.b.a
    public void a(final Context context, final b bVar, final a.InterfaceC0627a interfaceC0627a) {
        final Handler handler = new Handler(context.getMainLooper());
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.func.b.b.e eVar;
                Throwable th;
                com.opos.cmn.func.b.b.e eVar2 = null;
                try {
                    try {
                        Map<String, String> c2 = bVar.c();
                        HashMap hashMap = c2;
                        if (c2 == null) {
                            hashMap = new HashMap();
                        }
                        hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                        com.opos.cmn.func.b.b.d a2 = new d.a().a(bVar.d()).a(hashMap).a(bVar.b()).b(bVar.a()).a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("netRequest is = ");
                        sb.append(a2);
                        sb.append(". url = ");
                        sb.append(a2.b);
                        com.opos.cmn.an.f.a.b("DefaultRequestResolver", sb.toString());
                        eVar = com.opos.cmn.func.b.b.b.a().a(context, a2);
                        c cVar = null;
                        if (eVar != null) {
                            try {
                                cVar = new c.a(eVar.f24862a).a(eVar.e).a(d.b(eVar, bVar.a())).a();
                            } catch (Exception e) {
                                e = e;
                                StringBuilder sb2 = new StringBuilder();
                                com.opos.cmn.func.b.b.e eVar3 = eVar;
                                sb2.append("resolve fail,");
                                com.opos.cmn.func.b.b.e eVar4 = eVar;
                                sb2.append(e.toString());
                                com.opos.cmn.func.b.b.e eVar5 = eVar;
                                com.opos.cmn.an.f.a.d("DefaultRequestResolver", sb2.toString());
                                eVar2 = eVar;
                                handler.post(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        interfaceC0627a.a();
                                    }
                                });
                                if (eVar != null) {
                                    eVar.a();
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                if (eVar != null) {
                                    eVar.a();
                                }
                                throw th;
                            }
                        }
                        com.opos.cmn.an.f.a.b("DefaultRequestResolver", "response is = " + cVar);
                        final c cVar2 = cVar;
                        handler.post(new Runnable() { // from class: com.opos.cmn.biz.monitor.b.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (cVar2 != null) {
                                    interfaceC0627a.a(cVar2);
                                } else {
                                    interfaceC0627a.a();
                                }
                            }
                        });
                        if (eVar != null) {
                            eVar.a();
                        }
                    } catch (Throwable th3) {
                        eVar = eVar2;
                        th = th3;
                    }
                } catch (Exception e2) {
                    e = e2;
                    eVar = null;
                }
            }
        });
    }
}
