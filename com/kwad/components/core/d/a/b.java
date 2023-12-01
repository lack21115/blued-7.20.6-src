package com.kwad.components.core.d.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.d.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/a/b.class */
public final class b extends com.kwad.components.core.l.e {
    private static b Iv;
    private boolean IA;
    private final C0518b Iw;
    private com.kwad.components.core.d.a.a Iz;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/a/b$a.class */
    public static final class a {
        private DialogInterface.OnShowListener IC;
        private DialogInterface.OnDismissListener ID;
        private AdTemplate adTemplate;
        private String url;

        public final a H(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final a a(DialogInterface.OnShowListener onShowListener) {
            this.IC = onShowListener;
            return this;
        }

        public final a ao(String str) {
            this.url = str;
            return this;
        }

        public final a c(DialogInterface.OnDismissListener onDismissListener) {
            this.ID = onDismissListener;
            return this;
        }

        public final C0518b mI() {
            if (com.kwad.components.core.a.bI.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0518b(this, (byte) 0);
        }
    }

    /* renamed from: com.kwad.components.core.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/a/b$b.class */
    public static final class C0518b {
        protected DialogInterface.OnShowListener IC;
        protected DialogInterface.OnDismissListener ID;
        protected final AdTemplate adTemplate;
        protected String url;

        private C0518b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.IC = aVar.IC;
            this.ID = aVar.ID;
        }

        /* synthetic */ C0518b(a aVar, byte b) {
            this(aVar);
        }
    }

    private b(Activity activity, C0518b c0518b) {
        super(activity);
        this.IA = false;
        this.Iw = c0518b;
        if (com.kwad.sdk.c.kwai.a.a(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0518b.IC);
        setOnDismissListener(c0518b.ID);
    }

    public static boolean a(Context context, C0518b c0518b) {
        Activity dj;
        b bVar = Iv;
        if ((bVar != null && bVar.isShowing()) || context == null || (dj = k.dj(context)) == null || dj.isFinishing()) {
            return false;
        }
        com.kwad.sdk.kwai.kwai.c.sZ().dismiss();
        try {
            b bVar2 = new b(dj, c0518b);
            Iv = bVar2;
            bVar2.show();
            com.kwad.sdk.core.report.a.b(c0518b.adTemplate, 86, (JSONObject) null);
            return true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            return false;
        }
    }

    public static boolean mF() {
        b bVar = Iv;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public final void an(boolean z) {
        this.IA = z;
        dismiss();
    }

    @Override // com.kwad.components.core.l.e
    public final ViewGroup cm() {
        com.kwad.components.core.d.a.a aVar = new com.kwad.components.core.d.a.a(this.mContext, this, this.Iw);
        this.Iz = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.l.e, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        Iv = null;
    }

    @Override // com.kwad.components.core.l.e
    public final void g(View view) {
        this.Iz.setChangeListener(new a.InterfaceC0517a() { // from class: com.kwad.components.core.d.a.b.1
            @Override // com.kwad.components.core.d.a.a.InterfaceC0517a
            public final void mE() {
                b.this.dismiss();
            }
        });
    }

    @Override // com.kwad.components.core.l.e
    public final int getLayoutId() {
        return 0;
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.kwad.components.core.l.e
    public final boolean mG() {
        return true;
    }

    public final boolean mH() {
        return this.IA;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.report.a.ay(this.Iw.adTemplate);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iv = null;
    }

    @Override // com.kwad.components.core.l.e, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = Iv;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        try {
            super.show();
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }
}
