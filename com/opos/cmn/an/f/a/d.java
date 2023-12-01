package com.opos.cmn.an.f.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/d.class */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.cmn.an.f.a.a.b f24526a;

    public d(Looper looper) {
        super(looper);
    }

    private void a(com.opos.cmn.an.f.a.b.c cVar) {
        if (cVar.f24516a.e == 2 && a()) {
            this.f24526a = new com.opos.cmn.an.f.a.a.d();
            if (c.b()) {
                Log.d("LogHandler", "use NearLogImpl");
            }
        }
        if (this.f24526a == null) {
            this.f24526a = new com.opos.cmn.an.f.a.a.a();
            if (c.b()) {
                Log.d("LogHandler", "use BasicLogImpl");
            }
        }
    }

    private boolean a() {
        try {
            String canonicalName = com.oplus.log.b.class.getCanonicalName();
            if (TextUtils.isEmpty(canonicalName) || !c.b()) {
                return true;
            }
            Log.d("LogHandler", canonicalName + " exits");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.opos.cmn.an.f.a.b.e eVar;
        if (message != null) {
            try {
                switch (message.what) {
                    case 1:
                        if (message.obj != null) {
                            com.opos.cmn.an.f.a.b.c cVar = (com.opos.cmn.an.f.a.b.c) message.obj;
                            a(cVar);
                            this.f24526a.a(cVar.f24516a);
                            return;
                        }
                        return;
                    case 2:
                        if (this.f24526a == null || message.obj == null) {
                            return;
                        }
                        this.f24526a.a((com.opos.cmn.an.f.a.b.d) message.obj);
                        return;
                    case 3:
                        if (this.f24526a == null || message.obj == null) {
                            return;
                        }
                        com.opos.cmn.an.f.a.b.f fVar = (com.opos.cmn.an.f.a.b.f) message.obj;
                        this.f24526a.a(fVar.f24523a, fVar.b);
                        return;
                    case 4:
                        if (this.f24526a == null || message.obj == null) {
                            return;
                        }
                        this.f24526a.a(((com.opos.cmn.an.f.a.b.b) message.obj).f24515a);
                        return;
                    case 5:
                        if (this.f24526a == null || message.obj == null) {
                            return;
                        }
                        this.f24526a.a();
                        return;
                    case 6:
                        if (this.f24526a == null || message.obj == null || (eVar = (com.opos.cmn.an.f.a.b.e) message.obj) == null) {
                            return;
                        }
                        this.f24526a.a(eVar.f24522a);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
            }
        }
    }
}
