package com.oplus.log.core;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/core/f.class */
final class f implements g {

    /* renamed from: a  reason: collision with root package name */
    private g f10653a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private i f10654c;

    @Override // com.oplus.log.core.g
    public final void logan_debug(boolean z) {
        g gVar = this.f10653a;
        if (gVar != null) {
            gVar.logan_debug(z);
        }
    }

    @Override // com.oplus.log.core.g
    public final void logan_flush() {
        g gVar = this.f10653a;
        if (gVar != null) {
            gVar.logan_flush();
        }
    }

    @Override // com.oplus.log.core.g
    public final void logan_init(String str, String str2, int i, String str3, String str4) {
        if (this.b) {
            return;
        }
        if (!CLoganProtocol.isCloganSuccess()) {
            this.f10653a = null;
            return;
        }
        CLoganProtocol cLoganProtocol = new CLoganProtocol();
        this.f10653a = cLoganProtocol;
        cLoganProtocol.setOnLoganProtocolStatus(this.f10654c);
        this.f10653a.logan_init(str, str2, i, str3, str4);
        this.b = true;
    }

    @Override // com.oplus.log.core.g
    public final void logan_open(String str) {
        g gVar = this.f10653a;
        if (gVar != null) {
            gVar.logan_open(str);
        }
    }

    @Override // com.oplus.log.core.g
    public final void logan_write(int i, String str, long j, String str2, long j2) {
        g gVar = this.f10653a;
        if (gVar != null) {
            gVar.logan_write(i, str, j, str2, j2);
        }
    }

    @Override // com.oplus.log.core.g
    public final void setOnLoganProtocolStatus(i iVar) {
        this.f10654c = iVar;
    }
}
