package com.opos.mobad.cmn.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.ad.privacy.b;
import com.opos.mobad.cmn.b.a;
import com.opos.mobad.o.d.e;
import com.opos.mobad.service.event.EventDescription;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/b/e.class */
public class e implements com.opos.mobad.ad.privacy.b {

    /* renamed from: a  reason: collision with root package name */
    private c f25906a;
    private b b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.service.event.c f25907c;
    private String d;
    private Dialog e;
    private b.a f;
    private boolean g = false;
    private com.opos.mobad.activity.webview.b.d h = new com.opos.mobad.activity.webview.b.d() { // from class: com.opos.mobad.cmn.b.e.2
        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            com.opos.cmn.an.f.a.b("PrivacyShowManager", "onActivityOnDestory");
            com.opos.mobad.service.event.b.a().b(e.this.f25907c);
            e.this.b = null;
            if (e.this.f != null) {
                e.this.f.a();
            }
        }
    };

    public e(c cVar) {
        this.f25906a = cVar;
    }

    private void a(Activity activity, int i, ComplianceInfo complianceInfo, b.a aVar) {
        com.opos.cmn.an.f.a.a("PrivacyShowManager", "showAsDialog " + complianceInfo);
        this.f = aVar;
        b();
        this.e = com.opos.mobad.o.d.e.a(activity, activity.getResources().getString(i == 0 ? R.string.opos_mob_privacy_title : R.string.opos_mob_permission_title), i == 0 ? complianceInfo.a() : complianceInfo.b(), i == 1 ? complianceInfo.c() : null, new e.b() { // from class: com.opos.mobad.cmn.b.e.1
            @Override // com.opos.mobad.o.d.e.b
            public void a() {
                if (e.this.f == null) {
                    return;
                }
                e.this.f.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Dialog dialog = this.e;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void b(Context context, int i, ComplianceInfo complianceInfo, b.a aVar) {
        com.opos.cmn.an.f.a.a("PrivacyShowManager", "showAsProxyContentView " + complianceInfo);
        if (this.f25906a == null) {
            com.opos.cmn.an.f.a.a("PrivacyShowManager", "null video player");
            return;
        }
        this.f = aVar;
        c();
        String uuid = UUID.randomUUID().toString();
        this.d = uuid;
        EventDescription eventDescription = new EventDescription(uuid);
        this.f25907c = com.opos.mobad.activity.webview.b.e.a(eventDescription, this.h);
        this.b = new a.C0684a(a.C0684a.a(eventDescription));
        if (i == 1) {
            this.f25906a.b(context, complianceInfo, eventDescription);
        } else {
            this.f25906a.a(context, complianceInfo, eventDescription);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.opos.mobad.service.event.b.a().b(this.f25907c);
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
            this.b = null;
        }
    }

    @Override // com.opos.mobad.ad.privacy.b
    public void a() {
        this.g = true;
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.cmn.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.f25906a = null;
                e.this.b();
                e.this.c();
            }
        });
    }

    @Override // com.opos.mobad.ad.privacy.b
    public void a(Context context, int i, ComplianceInfo complianceInfo, b.a aVar) {
        String str;
        if (this.g) {
            str = "privacy show but destroy";
        } else if (context == null) {
            str = "null context";
        } else if (complianceInfo != null) {
            if (context instanceof Activity) {
                a((Activity) context, i, complianceInfo, aVar);
                return;
            } else {
                b(context, i, complianceInfo, aVar);
                return;
            }
        } else {
            str = "illegal data";
        }
        com.opos.cmn.an.f.a.a("PrivacyShowManager", str);
    }
}
