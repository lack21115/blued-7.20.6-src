package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f14222a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        this.f14222a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PM pm;
        try {
            pm = this.f14222a.d;
            pm.getPOFactory();
            this.f14222a.b = true;
        } catch (e e) {
            GDTLogger.e(e.getMessage(), e);
        }
    }
}
