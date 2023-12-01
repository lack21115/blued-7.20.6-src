package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/i.class */
public final class i implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f41101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.f41101a = eVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.b bVar;
        com.vivo.push.util.b bVar2;
        if (i != 0) {
            this.f41101a.k = null;
            bVar = this.f41101a.j;
            bVar.b("APP_TOKEN");
            return;
        }
        this.f41101a.k = "";
        bVar2 = this.f41101a.j;
        bVar2.a("APP_TOKEN", "");
        this.f41101a.m();
        this.f41101a.j.b("APP_TAGS");
    }
}
