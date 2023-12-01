package com.oplus.log;

import android.text.TextUtils;
import android.util.Log;
import com.oplus.log.core.e;
import com.oplus.log.core.i;
import com.oplus.log.core.m;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/e.class */
public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private com.oplus.log.core.b f10678a = null;

    @Override // com.oplus.log.d
    public final void a() {
        try {
            com.oplus.log.core.b bVar = this.f10678a;
            if (bVar.b == null) {
                throw new RuntimeException("Please initialize Logan first");
            }
            com.oplus.log.core.d dVar = bVar.b;
            if (TextUtils.isEmpty(dVar.b) || dVar.d == null) {
                return;
            }
            dVar.d.b();
        } catch (Exception e) {
            if (b.a()) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.oplus.log.d
    public final void a(com.oplus.log.core.c cVar) {
        try {
            com.oplus.log.core.b bVar = new com.oplus.log.core.b();
            this.f10678a = bVar;
            bVar.a(cVar);
            if (b.a()) {
                this.f10678a.a(new i() { // from class: com.oplus.log.e.1
                    @Override // com.oplus.log.core.i
                    public final void a(String str, int i) {
                        Log.i("NLogWriter", "loganProtocolStatus: " + str + "," + i);
                    }
                });
            }
        } catch (Throwable th) {
            if (b.a()) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.oplus.log.d
    public final void a(e.b bVar) {
        try {
            this.f10678a.a(bVar);
        } catch (Exception e) {
            if (b.a()) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.oplus.log.d
    public final void a(String str, String str2, byte b, int i) {
        try {
            com.oplus.log.core.b bVar = this.f10678a;
            if (bVar.b == null) {
                throw new RuntimeException("Please initialize Logan first");
            }
            com.oplus.log.core.d dVar = bVar.b;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            com.oplus.log.core.e eVar = new com.oplus.log.core.e();
            eVar.f10649a = e.a.f10651a;
            m mVar = new m();
            String name = Thread.currentThread().getName();
            long id = Thread.currentThread().getId();
            mVar.f10664a = str;
            mVar.f10665c = str2;
            mVar.b = b;
            mVar.f = System.currentTimeMillis();
            mVar.g = i;
            mVar.d = id;
            mVar.e = name;
            eVar.f10650c = mVar;
            if (dVar.f10647a.size() < dVar.f10648c) {
                dVar.f10647a.add(eVar);
                if (dVar.d != null) {
                    dVar.d.a();
                }
            }
        } catch (Exception e) {
            if (b.a()) {
                e.printStackTrace();
            }
        }
    }
}
