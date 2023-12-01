package com.xiaomi.push;

import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ft.class */
public class ft implements fx {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fs f27728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(fs fsVar) {
        this.f27728a = fsVar;
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f27728a.f431a.format(new Date()) + " Connection started (" + this.f27728a.f428a.hashCode() + ")");
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar, int i, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f27728a.f431a.format(new Date()) + " Connection closed (" + this.f27728a.f428a.hashCode() + ")");
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f27728a.f431a.format(new Date()) + " Reconnection failed due to an exception (" + this.f27728a.f428a.hashCode() + ")");
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.fx
    public void b(fu fuVar) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f27728a.f431a.format(new Date()) + " Connection reconnected (" + this.f27728a.f428a.hashCode() + ")");
    }
}
