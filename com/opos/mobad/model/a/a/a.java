package com.opos.mobad.model.a.a;

import android.content.Context;
import com.baidu.mobads.sdk.api.SplashAd;
import com.google.common.net.HttpHeaders;
import com.opos.cmn.biz.a.e;
import com.opos.cmn.func.b.b.d;
import com.opos.mobad.model.b.d;
import com.opos.mobad.model.d.f;
import com.tencent.connect.common.Constants;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/a/a/a.class */
public class a implements com.opos.mobad.model.a.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f26375a;
    private com.opos.mobad.model.a.b b;

    public a(Context context, com.opos.mobad.model.a.b bVar) {
        this.f26375a = context.getApplicationContext();
        this.b = bVar;
    }

    private byte[] a(com.opos.mobad.model.b.c cVar) {
        byte[] bArr;
        com.opos.mobad.model.a.b bVar;
        com.opos.cmn.an.f.a.b("FetchAdEngine", "prepareReqData parser:", this.b, "request:", cVar);
        if (this.f26375a != null && (bVar = this.b) != null && cVar != null) {
            try {
                bArr = bVar.a(cVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("FetchAdEngine", "", (Throwable) e);
            }
            com.opos.cmn.an.f.a.b("FetchAdEngine", "prepareReqData result:", bArr);
            return bArr;
        }
        bArr = null;
        com.opos.cmn.an.f.a.b("FetchAdEngine", "prepareReqData result:", bArr);
        return bArr;
    }

    private d b(String str, com.opos.mobad.model.b.c cVar, f fVar) {
        com.opos.mobad.model.b.b bVar;
        String str2;
        com.opos.mobad.model.b.b bVar2 = new com.opos.mobad.model.b.b(-1, "unknown error.");
        com.opos.mobad.model.b.b bVar3 = bVar2;
        try {
            byte[] a2 = a(cVar);
            if (fVar != null) {
                fVar.a();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("data.size:");
            sb.append(a2.length);
            com.opos.cmn.an.f.a.b("FetchAdEngine", sb.toString());
            bVar = bVar2;
            if (a2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-protobuf");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put(HttpHeaders.ACCEPT, "application/x-protobuf");
                hashMap.put("Route-Data", e.a(this.f26375a));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(com.opos.mobad.service.f.a.a().o());
                hashMap.put("Sdk-Vc", sb2.toString());
                byte[] bArr = a2;
                if (a2.length >= 1024) {
                    com.opos.cmn.an.f.a.b("FetchAdEngine", "data.length >= 1024 ,need gzip compress.");
                    bArr = com.opos.cmn.b.c.a.a(a2);
                    hashMap.put("Content-Encoding", "gzip");
                }
                com.opos.cmn.func.b.b.d a3 = new d.a().a("POST").b(com.opos.mobad.model.e.d.a()).a(bArr).a(hashMap).a();
                com.opos.cmn.func.b.b.e a4 = com.opos.mobad.service.d.a().a(a3);
                com.opos.cmn.func.b.b.e eVar = a4;
                if (a4 == null) {
                    eVar = com.opos.cmn.func.b.b.b.a().a(this.f26375a, a3);
                }
                com.opos.mobad.model.b.b bVar4 = bVar2;
                if (eVar != null) {
                    com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd netResponse=", eVar);
                    com.opos.cmn.func.b.b.e eVar2 = eVar;
                    if (200 == eVar.f24862a) {
                        com.opos.cmn.func.b.b.e eVar3 = eVar;
                        com.opos.cmn.func.b.b.a aVar = eVar.f;
                        boolean z = false;
                        if (aVar != null) {
                            String a5 = aVar.a("Content-Encoding");
                            z = false;
                            if (a5 != null) {
                                z = "gzip".equalsIgnoreCase(a5);
                            }
                        }
                        bVar4 = bVar2;
                        if (eVar.f24863c != null) {
                            com.opos.cmn.func.b.b.e eVar4 = eVar;
                            byte[] a6 = com.opos.cmn.an.d.b.a.a(eVar.f24863c);
                            com.opos.cmn.func.b.b.e eVar5 = eVar;
                            StringBuilder sb3 = new StringBuilder();
                            com.opos.cmn.func.b.b.e eVar6 = eVar;
                            sb3.append("needUnCompress=");
                            com.opos.cmn.func.b.b.e eVar7 = eVar;
                            sb3.append(z);
                            com.opos.cmn.func.b.b.e eVar8 = eVar;
                            com.opos.cmn.an.f.a.b("FetchAdEngine", sb3.toString());
                            byte[] bArr2 = a6;
                            if (z) {
                                bArr2 = com.opos.cmn.b.c.a.b(a6);
                            }
                            bVar4 = bVar2;
                            if (bArr2 != null) {
                                bVar4 = bVar2;
                                if (bArr2.length > 0) {
                                    bVar4 = bVar2;
                                    try {
                                        if (this.b != null) {
                                            com.opos.cmn.func.b.b.e eVar9 = eVar;
                                            com.opos.mobad.model.b.d a7 = this.b.a(bArr2);
                                            bVar4 = bVar2;
                                            if (a7 != null) {
                                                bVar4 = a7;
                                            }
                                        }
                                    } catch (Exception e) {
                                        com.opos.cmn.an.f.a.a("FetchAdEngine", "", (Throwable) e);
                                        com.opos.cmn.func.b.b.e eVar10 = eVar;
                                        bVar4 = new com.opos.mobad.model.b.b(Constants.REQUEST_APPBAR, "parse ad response exception.");
                                    }
                                }
                            }
                        }
                    } else {
                        if (eVar.b != null) {
                            com.opos.cmn.func.b.b.e eVar11 = eVar;
                            str2 = eVar.b;
                        } else {
                            str2 = com.igexin.push.core.b.l;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        com.opos.cmn.func.b.b.e eVar12 = eVar;
                        sb4.append("http code=");
                        com.opos.cmn.func.b.b.e eVar13 = eVar;
                        sb4.append(eVar.f24862a);
                        com.opos.cmn.func.b.b.e eVar14 = eVar;
                        sb4.append(",msg=");
                        com.opos.cmn.func.b.b.e eVar15 = eVar;
                        sb4.append(str2);
                        com.opos.cmn.func.b.b.e eVar16 = eVar;
                        com.opos.cmn.an.f.a.c("FetchAdEngine", sb4.toString());
                        com.opos.cmn.func.b.b.e eVar17 = eVar;
                        bVar4 = new com.opos.mobad.model.b.b(eVar.f24862a, str2);
                    }
                }
                bVar = bVar4;
                if (eVar != null) {
                    bVar3 = bVar4;
                    eVar.a();
                    return bVar4;
                }
            }
        } catch (Exception e2) {
            bVar = bVar3;
            com.opos.cmn.an.f.a.a("FetchAdEngine", "", (Throwable) e2);
        }
        return bVar;
    }

    @Override // com.opos.mobad.model.a.a
    public com.opos.mobad.model.b.d a(String str, com.opos.mobad.model.b.c cVar, f fVar) {
        com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd start=" + System.currentTimeMillis());
        com.opos.mobad.model.b.b bVar = new com.opos.mobad.model.b.b(-1, "unknown error.");
        com.opos.mobad.model.b.b bVar2 = bVar;
        if (!com.opos.cmn.an.c.a.a(str)) {
            bVar2 = bVar;
            if (cVar != null) {
                bVar2 = bVar;
                try {
                    if (com.opos.cmn.an.h.c.a.d(this.f26375a)) {
                        com.opos.mobad.model.b.d b = b(str, cVar, fVar);
                        com.opos.cmn.an.f.a.a("FetchAdEngine", "fetchAd fetchAdResponse=", b);
                        bVar2 = b;
                    } else {
                        bVar2 = new com.opos.mobad.model.b.b(10100, "no net.");
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("FetchAdEngine", SplashAd.KEY_FETCHAD, e);
                }
            }
        }
        com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd end=" + System.currentTimeMillis());
        return bVar2;
    }
}
