package com.vivo.push.d;

import com.vivo.push.cache.ClientConfigManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/ah.class */
public final class ah extends com.vivo.push.l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        if (this.f41105a == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; mContext is Null");
        } else if (oVar == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask pushCommand is Null");
        } else {
            com.vivo.push.model.b a2 = com.vivo.push.util.t.a(this.f41105a);
            int b = oVar.b();
            if (b == 2009) {
                com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f41105a).isDebug());
                if (com.vivo.push.util.p.a()) {
                    com.vivo.push.e.a().i();
                    com.vivo.push.util.b bVar = new com.vivo.push.util.b();
                    bVar.a(this.f41105a, "com.vivo.push_preferences.hybridapptoken_v1");
                    bVar.a();
                    com.vivo.push.util.b bVar2 = new com.vivo.push.util.b();
                    bVar2.a(this.f41105a, "com.vivo.push_preferences.appconfig_v1");
                    bVar2.a();
                    if (!com.vivo.push.e.a().e()) {
                        ClientConfigManagerImpl.getInstance(this.f41105a).clearPush();
                    }
                }
            } else if (b != 2011) {
                switch (b) {
                    case 2002:
                    case 2003:
                    case 2004:
                    case 2005:
                        if (a2 == null || a2.c()) {
                            com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1005);
                            break;
                        } else {
                            com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
                            int a3 = com.vivo.push.util.s.a(cVar);
                            if (a3 != 0) {
                                com.vivo.push.e.a().a(cVar.h(), a3);
                                return;
                            }
                        }
                        break;
                }
            } else {
                com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f41105a).isDebug(((com.vivo.push.b.w) oVar).d()));
            }
            if (a2 == null) {
                com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pushPkgInfo is Null");
                return;
            }
            String a4 = a2.a();
            com.vivo.push.b.e eVar = oVar;
            if (a2.c()) {
                try {
                    com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1004);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                eVar = new com.vivo.push.b.e();
                com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + eVar + " ; pkgName is InBlackList ");
            }
            com.vivo.push.a.a.a(this.f41105a, a4, eVar);
        }
    }
}
