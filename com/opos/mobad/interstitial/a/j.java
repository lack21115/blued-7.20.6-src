package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/j.class */
public class j implements DialogInterface.OnKeyListener, DialogInterface.OnShowListener, com.opos.mobad.q.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private d f26234a;
    private Activity b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.q.a.b.a f26235c;

    private void a(Activity activity) {
        d dVar = this.f26234a;
        if (dVar != null && (dVar.getContext() instanceof Activity)) {
            if (((Activity) this.f26234a.getContext()) == activity) {
                com.opos.cmn.an.f.a.b("InterstitialDialog", "same activity");
                return;
            }
            a();
        }
        int i = 16973840;
        if (com.opos.cmn.an.h.f.a.a(activity)) {
            i = 16973841;
        }
        d dVar2 = new d(activity, i);
        this.f26234a = dVar2;
        dVar2.getWindow().getDecorView().setBackgroundColor(1711276032);
        this.f26234a.setOnKeyListener(this);
        this.f26234a.setOnShowListener(this);
    }

    @Override // com.opos.mobad.q.a.b.b
    public void a() {
        if (this.b == null || !this.f26234a.isShowing()) {
            com.opos.cmn.an.f.a.b("InterstitialDialog", "dismiss dialog but fail");
        } else {
            this.f26234a.dismiss();
        }
    }

    @Override // com.opos.mobad.q.a.b.b
    public void a(Activity activity, View view) {
        this.b = activity;
        a(activity);
        if (view != null) {
            int i = 0;
            if (Build.VERSION.SDK_INT >= 29) {
                view.setForceDarkAllowed(false);
            }
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.opos.mobad.interstitial.a.j.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return j.this.b();
                }
            });
            this.f26234a.setContentView(view, new ViewGroup.LayoutParams(-1, -1));
            this.f26234a.show();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = this.f26234a.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                this.f26234a.getWindow().setAttributes(attributes);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
                if ((systemUiVisibility & 1024) == 1024) {
                    i = 1280;
                }
                int i2 = i;
                if ((systemUiVisibility & 4) == 4) {
                    i2 = i | 4 | 4096;
                }
                this.f26234a.getWindow().getDecorView().setSystemUiVisibility(i2);
            }
        }
    }

    @Override // com.opos.mobad.q.a.b.b
    public void a(com.opos.mobad.q.a.b.a aVar) {
        this.f26235c = aVar;
    }

    public boolean b() {
        boolean z;
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterstitialDialog", "isShowing", (Throwable) e);
        }
        if (!this.b.isFinishing() && this.f26234a != null) {
            if (this.f26234a.isShowing()) {
                z = true;
                com.opos.cmn.an.f.a.b("InterstitialDialog", "isShowing=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("InterstitialDialog", "isShowing=" + z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    @Override // android.content.DialogInterface.OnKeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKey(android.content.DialogInterface r5, int r6, android.view.KeyEvent r7) {
        /*
            r4 = this;
            r0 = r6
            r1 = 4
            if (r0 == r1) goto L8
            goto L35
        L8:
            r0 = r4
            boolean r0 = r0.b()     // Catch: java.lang.Exception -> L2c
            if (r0 == 0) goto L35
            r0 = r7
            int r0 = r0.getAction()     // Catch: java.lang.Exception -> L2c
            if (r0 != 0) goto L35
            r0 = r4
            com.opos.mobad.q.a.b.a r0 = r0.f26235c     // Catch: java.lang.Exception -> L2c
            if (r0 == 0) goto L26
            r0 = r4
            com.opos.mobad.q.a.b.a r0 = r0.f26235c     // Catch: java.lang.Exception -> L2c
            r0.a()     // Catch: java.lang.Exception -> L2c
        L26:
            r0 = 1
            r8 = r0
            goto L38
        L2c:
            r5 = move-exception
            java.lang.String r0 = "InterstitialDialog"
            java.lang.String r1 = ""
            r2 = r5
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L35:
            r0 = 0
            r8 = r0
        L38:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "dialog onKey="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r1 = ",keyEvent="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L5e
            goto L61
        L5e:
            java.lang.String r0 = ""
            r7 = r0
        L61:
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "InterstitialDialog"
            r1 = r5
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.interstitial.a.j.onKey(android.content.DialogInterface, int, android.view.KeyEvent):boolean");
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        com.opos.cmn.an.f.a.b("InterstitialDialog", "dialog show");
    }
}
