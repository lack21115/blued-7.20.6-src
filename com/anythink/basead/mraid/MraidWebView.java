package com.anythink.basead.mraid;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.mbbanner.view.ATBannerWebView;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/MraidWebView.class */
public class MraidWebView extends ATBannerWebView {
    public static String TAG = MraidWebView.class.getSimpleName();
    b a;
    boolean b;
    MraidVolumeChangeReceiver c;
    boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.mraid.MraidWebView$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/MraidWebView$2.class */
    public final class AnonymousClass2 implements MraidVolumeChangeReceiver.VolumeChangeListener {
        AnonymousClass2() {
        }

        public final void onVolumeChanged(double d) {
            o.d(MraidWebView.TAG, "volume is : ".concat(String.valueOf(d)));
            try {
                CallMraidJS.getInstance().fireAudioVolumeChange(MraidWebView.this, d);
            } catch (Exception e) {
                o.d(MraidWebView.TAG, e.getMessage());
            }
        }
    }

    public MraidWebView(Context context) {
        super(context);
        this.b = false;
    }

    public MraidWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
    }

    public MraidWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
    }

    static /* synthetic */ void a(MraidWebView mraidWebView) {
        Object object = mraidWebView.getObject();
        com.anythink.expressad.atsignalcommon.base.b baseWebViewClient = mraidWebView.getBaseWebViewClient();
        if (object instanceof a) {
            Context context = mraidWebView.getContext();
            if (context instanceof Activity) {
                ((a) object).b = new WeakReference<>((Activity) context);
            }
            ((a) object).a(mraidWebView.a);
        }
        if (baseWebViewClient instanceof e) {
            ((e) baseWebViewClient).c = mraidWebView.a;
        }
    }

    private void b() {
        Object object = getObject();
        com.anythink.expressad.atsignalcommon.base.b baseWebViewClient = getBaseWebViewClient();
        if (object instanceof a) {
            Context context = getContext();
            if (context instanceof Activity) {
                ((a) object).b = new WeakReference<>((Activity) context);
            }
            ((a) object).a(this.a);
        }
        if (baseWebViewClient instanceof e) {
            ((e) baseWebViewClient).c = this.a;
        }
    }

    static /* synthetic */ void b(MraidWebView mraidWebView) {
        MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new MraidVolumeChangeReceiver(mraidWebView.getContext());
        mraidWebView.c = mraidVolumeChangeReceiver;
        mraidVolumeChangeReceiver.registerReceiver();
        mraidWebView.c.getCurrentVolume();
        mraidWebView.c.setVolumeChangeListener(new AnonymousClass2());
    }

    private void c() {
        MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new MraidVolumeChangeReceiver(getContext());
        this.c = mraidVolumeChangeReceiver;
        mraidVolumeChangeReceiver.registerReceiver();
        this.c.getCurrentVolume();
        this.c.setVolumeChangeListener(new AnonymousClass2());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
        if (r0.contains(com.anythink.core.common.res.d.a(com.anythink.core.common.b.n.a().g()).a()) == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            if (r0 != 0) goto L52
            r0 = r5
            java.lang.String r1 = "../"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L1d
        L18:
            r0 = 1
            r6 = r0
            goto L52
        L1d:
            r0 = r7
            r6 = r0
            r0 = r5
            java.lang.String r1 = "file"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L52
            r0 = r5
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r0 = r0.getPath()
            r9 = r0
            r0 = r9
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L18
            r0 = r7
            r6 = r0
            r0 = r9
            com.anythink.core.common.b.n r1 = com.anythink.core.common.b.n.a()
            android.content.Context r1 = r1.g()
            com.anythink.core.common.res.d r1 = com.anythink.core.common.res.d.a(r1)
            java.lang.String r1 = r1.a()
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L52
            goto L18
        L52:
            r0 = r5
            r9 = r0
            r0 = r6
            if (r0 == 0) goto L6c
            java.lang.String r0 = "anythink_express"
            java.lang.String r1 = "illegal URL: "
            r2 = r5
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = r1.concat(r2)
            int r0 = android.util.Log.e(r0, r1)
            java.lang.String r0 = "about:blank"
            r9 = r0
        L6c:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.mraid.MraidWebView.a(java.lang.String):java.lang.String");
    }

    public void prepare(Context context, b bVar) {
        this.a = bVar;
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.anythink.basead.mraid.MraidWebView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                try {
                    if (MraidWebView.this.b) {
                        return false;
                    }
                    MraidWebView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    MraidWebView.this.b = true;
                    int[] iArr = new int[2];
                    MraidWebView.this.getLocationInWindow(iArr);
                    com.anythink.expressad.mbbanner.a.a.a.a(MraidWebView.this, iArr[0], iArr[1]);
                    com.anythink.expressad.mbbanner.a.a.a.a(MraidWebView.this, iArr[0], iArr[1], MraidWebView.this.getWidth(), MraidWebView.this.getHeight());
                    MraidWebView.a(MraidWebView.this);
                    if (MraidWebView.this.d) {
                        MraidWebView.b(MraidWebView.this);
                    }
                    if (MraidWebView.this.a != null) {
                        MraidWebView.this.a.a();
                        return false;
                    }
                    return false;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            }
        });
    }

    public void release() {
        super.release();
        setWebViewListener(null);
        MraidVolumeChangeReceiver mraidVolumeChangeReceiver = this.c;
        if (mraidVolumeChangeReceiver != null) {
            mraidVolumeChangeReceiver.unregisterReceiver();
        }
    }

    public void setNeedRegisterVolumeChangeReceiver(boolean z) {
        this.d = z;
    }
}
