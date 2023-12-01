package com.opos.mobad.cmn.b;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.activity.webview.b.e;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.cmn.b.a;
import com.opos.mobad.o.d.e;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/b/f.class */
public class f {
    private Activity b;

    /* renamed from: c  reason: collision with root package name */
    private e.a f25912c;
    private com.opos.mobad.activity.webview.b.d d;
    private com.opos.mobad.service.event.c e;

    /* renamed from: a  reason: collision with root package name */
    private boolean f25911a = false;
    private b f = new b() { // from class: com.opos.mobad.cmn.b.f.2
        @Override // com.opos.mobad.cmn.b.b
        public void b() {
            Activity activity = f.this.b;
            if (f.this.f25911a || activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            com.opos.cmn.an.f.a.b("PrivacyWebPresenter", "finish remote");
            activity.finish();
        }
    };

    public f(EventDescription eventDescription) {
        this.d = new e.a(eventDescription);
        this.e = a.a(a.C0684a.a(eventDescription), this.f);
        com.opos.mobad.activity.webview.b.d dVar = this.d;
        if (dVar != null) {
            dVar.d();
        }
    }

    private String a(Context context, int i) {
        if (context == null) {
            return "";
        }
        return context.getResources().getString(i == 3 ? R.string.opos_mob_privacy_title : R.string.opos_mob_permission_title);
    }

    private String a(ComplianceInfo complianceInfo, int i) {
        return i == 4 ? complianceInfo.b() : complianceInfo.a();
    }

    public void a() {
        this.f25911a = true;
        this.f25912c.a();
        com.opos.mobad.activity.webview.b.d dVar = this.d;
        if (dVar != null) {
            dVar.e();
            this.d = null;
        }
        this.f = null;
        com.opos.mobad.service.event.b.a().b(this.e);
    }

    public void a(Activity activity, int i, ComplianceInfo complianceInfo) {
        String str;
        if (this.f25911a) {
            return;
        }
        if (activity == null) {
            str = "null activity";
        } else if (complianceInfo != null) {
            this.b = activity;
            e.a a2 = com.opos.mobad.o.d.e.a(activity.getApplicationContext(), a(activity, i), a(complianceInfo, i), i == 4 ? complianceInfo.c() : null, new e.b() { // from class: com.opos.mobad.cmn.b.f.1
                @Override // com.opos.mobad.o.d.e.b
                public void a() {
                    if (f.this.f25911a) {
                        return;
                    }
                    f.this.f.b();
                }
            });
            this.f25912c = a2;
            activity.setContentView(a2);
            return;
        } else {
            str = "illegal data";
        }
        com.opos.cmn.an.f.a.a("PrivacyWebPresenter", str);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        com.opos.cmn.an.f.a.b("PrivacyWebPresenter", "onKeyDown keyCode = " + i);
        if (i != 4) {
            return false;
        }
        b bVar = this.f;
        if (bVar != null) {
            bVar.b();
            return true;
        }
        return true;
    }
}
