package com.opos.mobad.q.a.d;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.opos.mobad.activity.VideoActivity;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.b.a;
import com.opos.mobad.cmn.b.b;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.q.a.a.a;
import com.opos.mobad.q.a.d;
import com.opos.mobad.q.a.g;
import com.opos.mobad.q.a.k;
import com.opos.mobad.service.event.EventDescription;
import com.opos.mobad.service.event.c;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Activity f13479a;
    private Context b;
    private AdItemData d;
    private MaterialData e;
    private a.b f;
    private a.C0555a g;
    private c h;
    private com.opos.mobad.q.a.c i;

    /* renamed from: c  reason: collision with root package name */
    private EventDescription f13480c = null;
    private b j = new b() { // from class: com.opos.mobad.q.a.d.a.4
        @Override // com.opos.mobad.cmn.b.b
        public void b() {
            Activity activity = a.this.f13479a;
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            activity.finish();
        }
    };
    private b.InterfaceC0517b k = new b.InterfaceC0517b() { // from class: com.opos.mobad.q.a.d.a.5
        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("VideoCommonPresenter", "install pkgName=" + str);
            if (a.this.i != null) {
                a.this.i.b(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void b(AdItemData adItemData, String str) {
            if (a.this.i != null) {
                a.this.i.a(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void c(AdItemData adItemData, String str) {
            if (a.this.i != null) {
                a.this.i.a(adItemData, str);
            }
        }
    };

    public a(Activity activity) {
        this.f13479a = activity;
        this.b = activity.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.q.a.d.a.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = a.this.f13479a;
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    com.opos.cmn.an.f.a.b("VideoCommonPresenter", "vip result but destroy");
                } else if (a.this.i != null) {
                    a.this.i.a(i);
                }
            }
        });
    }

    private void a(Activity activity, com.opos.mobad.n.a aVar, com.opos.mobad.cmn.a.a aVar2, String str, AdItemData adItemData, MaterialData materialData, int i, com.opos.mobad.q.a.e.a aVar3, g gVar) {
        com.opos.mobad.n.a a2 = com.opos.mobad.q.a.f.b.a.a().a(this.b, adItemData, (a.InterfaceC0538a) null);
        this.i = new k(activity, str, aVar2, aVar, new d(activity), new com.opos.mobad.o.a.a(this.b, null), aVar3, a2);
        a.b b = f.b(this.f13479a);
        this.f = b;
        aVar2.a(b);
        ((k) this.i).b(adItemData, materialData, i, gVar);
        FrameLayout frameLayout = new FrameLayout(this.b);
        frameLayout.addView(aVar.c());
        if (a2 != null && a2.c() != null) {
            View c2 = a2.c();
            c2.setVisibility(8);
            frameLayout.addView(c2);
        }
        activity.setContentView(frameLayout);
        if (adItemData.u() != 0) {
            a(adItemData.g());
        }
    }

    private void a(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.getDecorView().setBackgroundColor(1711276032);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (z) {
            com.opos.cmn.an.f.a.b("VideoCommonPresenter", "isFullScreen");
            activity.getTheme().applyStyle(R.style.Theme_Translucent_NoTitleBar_Fullscreen, true);
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(1024 | window.getDecorView().getSystemUiVisibility() | 256 | 4 | 4096);
        }
    }

    private void a(Intent intent, AdItemData adItemData, MaterialData materialData, int i, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.q.a.e.a aVar, g gVar) {
        String str;
        Activity activity = this.f13479a;
        if (activity == null) {
            str = "activity is null";
        } else {
            com.opos.mobad.q.a.b.d dVar2 = (com.opos.mobad.q.a.b.d) intent.getParcelableExtra(VideoActivity.EXTRA_KEY_TEMPLATE_CREATOR);
            if (dVar2 != null) {
                this.h = com.opos.mobad.cmn.b.a.a(a.C0514a.a(this.f13480c), this.j);
                a(activity, intent.getBooleanExtra(VideoActivity.EXTRA_KEY_SCREEN_MODE, false));
                String g = adItemData.g();
                com.opos.mobad.n.a a2 = dVar2.a(activity, this.d, a(this.f13479a, adItemData, materialData, g));
                if (a2 != null) {
                    com.opos.mobad.q.a.c cVar = new com.opos.mobad.q.a.c(activity, g, new com.opos.mobad.cmn.a.a(this.b, adItemData.g(), dVar), a2, new d(activity), new com.opos.mobad.o.a.a(activity, null), aVar);
                    this.i = cVar;
                    cVar.a(adItemData, materialData, i, gVar);
                    activity.setContentView(a2.c());
                    return;
                }
                c();
            }
            str = "creator is null";
        }
        com.opos.cmn.an.f.a.b("VideoCommonPresenter", str);
        c();
    }

    private void a(final Window window) {
        window.setBackgroundDrawable(new ColorDrawable(-16777216));
        window.setFlags(1024, 1024);
        window.addFlags(128);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            window.getDecorView().setSystemUiVisibility(5894);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.opos.mobad.q.a.d.a.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (2 == (i & 2) && 4 == (i & 4)) {
                        return;
                    }
                    com.opos.cmn.an.f.a.b("VideoCommonPresenter", "reset system ui");
                    window.getDecorView().setSystemUiVisibility(5894);
                }
            });
        }
    }

    private void a(AdItemData adItemData) {
        Activity activity;
        if (adItemData != null) {
            int F = adItemData.F();
            int i = 1;
            if (F == 1) {
                activity = this.f13479a;
                i = 0;
            } else if (F != 2) {
                return;
            } else {
                activity = this.f13479a;
            }
            activity.setRequestedOrientation(i);
        }
    }

    private void a(AdItemData adItemData, MaterialData materialData, int i, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.q.a.e.a aVar, g gVar) {
        Activity activity = this.f13479a;
        if (activity != null) {
            com.opos.cmn.an.f.a.b("VideoCommonPresenter", "show templateId:" + materialData.b());
            a(activity.getWindow());
            activity.setVolumeControlStream(3);
            a(adItemData);
            String g = adItemData.g();
            com.opos.mobad.cmn.a.a aVar2 = new com.opos.mobad.cmn.a.a(this.b, g, dVar);
            com.opos.mobad.n.a a2 = com.opos.mobad.q.a.b.a(this.b, materialData.b(), adItemData, null);
            if (a2 != null) {
                a(activity, a2, aVar2, g, adItemData, materialData, i, aVar, gVar);
                return;
            }
        }
        c();
    }

    private boolean a(Intent intent, int i, com.opos.mobad.cmn.a.d dVar) {
        if ((i == 1 || i == 2) && dVar != null) {
            AdItemData adItemData = (AdItemData) intent.getParcelableExtra(VideoActivity.EXTRA_KEY_AD_ITEM_DATA);
            this.d = adItemData;
            if (adItemData == null || adItemData.i() == null || this.d.i().size() <= 0) {
                return false;
            }
            MaterialData materialData = this.d.i().get(0);
            this.e = materialData;
            return materialData != null;
        }
        return false;
    }

    public com.opos.mobad.activity.webview.b a(Activity activity, AdItemData adItemData, MaterialData materialData, String str) {
        if (adItemData.R() == 1 && com.opos.mobad.o.e.b.a(materialData.b())) {
            String m = materialData.m();
            return new com.opos.mobad.activity.webview.b(activity, new WebDataHepler(adItemData, str, -1 != f.c(m) ? f.a(adItemData, m, str) : "", m, "", null, 1, false, false));
        }
        return null;
    }

    public void a() {
        com.opos.mobad.q.a.c cVar = this.i;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void a(Intent intent, com.opos.mobad.cmn.a.d dVar, g gVar) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra(VideoActivity.EXTRA_KEY_ACTION_TYPE, -1);
                if (!a(intent, intExtra, dVar)) {
                    c();
                    return;
                }
                int intExtra2 = intent.getIntExtra(VideoActivity.EXTRA_KEY_BID_PRICE, 0);
                EventDescription eventDescription = (EventDescription) intent.getParcelableExtra(VideoActivity.EXTRA_KEY_EVENT_DESCRIPTION);
                this.f13480c = eventDescription;
                a.C0555a c0555a = new a.C0555a(eventDescription);
                this.g = c0555a;
                c0555a.a(this.k);
                if (intExtra == 1) {
                    a(this.d, this.e, intExtra2, dVar, this.g, gVar);
                } else if (intExtra != 2) {
                    c();
                } else {
                    a(intent, this.d, this.e, intExtra2, dVar, this.g, gVar);
                }
                this.g.f();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("VideoCommonPresenter", "", (Throwable) e);
                c();
            }
        }
    }

    public void a(Configuration configuration) {
        com.opos.mobad.q.a.c cVar = this.i;
        if (cVar != null) {
            cVar.a(configuration);
        }
    }

    public void a(String str) {
        final FutureTask<Integer> b = com.opos.mobad.service.a.a().b(this.b, str);
        if (b == null) {
            a(0);
        } else {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.q.a.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    int g;
                    try {
                        g = ((Integer) b.get(com.opos.mobad.service.f.b().q(), TimeUnit.MILLISECONDS)).intValue();
                    } catch (Exception e) {
                        g = com.opos.mobad.service.a.a().g();
                    }
                    a.this.a(g);
                }
            });
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        com.opos.mobad.q.a.c cVar = this.i;
        return cVar != null && cVar.a(i, keyEvent);
    }

    public void b() {
        com.opos.mobad.q.a.c cVar = this.i;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void c() {
        a.b bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
        Activity activity = this.f13479a;
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            activity.finish();
        }
        this.f13479a = null;
        com.opos.mobad.q.a.c cVar = this.i;
        if (cVar != null) {
            cVar.c();
        }
        a.C0555a c0555a = this.g;
        if (c0555a != null) {
            c0555a.g();
            c0555a.a((b.InterfaceC0517b) null);
        }
        com.opos.mobad.service.event.b.a().b(this.h);
        this.g = null;
    }
}
