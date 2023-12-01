package com.anythink.expressad.out;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/out/TemplateBannerView.class */
public class TemplateBannerView extends RelativeLayout implements com.anythink.core.common.a.g {

    /* renamed from: a  reason: collision with root package name */
    private com.anythink.expressad.mbbanner.b.a f5223a;
    private h b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5224c;
    private boolean d;
    private String e;

    public TemplateBannerView(Context context) {
        this(context, null);
    }

    public TemplateBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TemplateBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5224c = false;
        this.d = false;
        com.anythink.expressad.foundation.b.a.b().b(context);
    }

    private void a() {
        postDelayed(new Runnable() { // from class: com.anythink.expressad.out.TemplateBannerView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (TemplateBannerView.this.f5223a == null || com.anythink.expressad.foundation.f.b.f4978c) {
                    return;
                }
                TemplateBannerView.this.f5223a.c(true);
            }
        }, 200L);
    }

    private void a(boolean z) {
        this.f5224c = z;
        com.anythink.expressad.mbbanner.b.a aVar = this.f5223a;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public String getRequestId() {
        com.anythink.expressad.mbbanner.b.a aVar = this.f5223a;
        return aVar != null ? aVar.a() : "";
    }

    public void init(i iVar, String str, String str2) {
        com.anythink.expressad.mbbanner.b.a aVar = new com.anythink.expressad.mbbanner.b.a(this, iVar, str, str2);
        this.f5223a = aVar;
        aVar.c(this.d);
        this.f5223a.b(this.f5224c);
    }

    public boolean isReady() {
        return true;
    }

    public void load(com.anythink.expressad.foundation.d.d dVar) {
        com.anythink.expressad.mbbanner.b.a aVar = this.f5223a;
        if (aVar != null) {
            aVar.b(this.f5224c);
            this.f5223a.a(dVar);
            return;
        }
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(com.anythink.expressad.mbbanner.a.a.f5154a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
    }

    public void onPause() {
        if (this.f5223a == null || !TextUtils.isEmpty(this.e)) {
            return;
        }
        this.f5223a.c();
    }

    public void onResume() {
        if (this.f5223a == null || !TextUtils.isEmpty(this.e) || com.anythink.expressad.foundation.f.b.f4978c) {
            return;
        }
        this.f5223a.d();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.anythink.expressad.mbbanner.b.a aVar = this.f5223a;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.d = i == 0;
        com.anythink.expressad.mbbanner.b.a aVar = this.f5223a;
        if (aVar != null) {
            if (i == 0) {
                a();
            } else {
                aVar.c(false);
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.d = i == 0;
        if (this.f5223a != null) {
            if (i == 0) {
                a();
            } else if (com.anythink.expressad.foundation.f.b.f4978c) {
            } else {
                this.f5223a.c(false);
            }
        }
    }

    public void release() {
        if (this.b != null) {
            this.b = null;
        }
        com.anythink.expressad.mbbanner.b.a aVar = this.f5223a;
        if (aVar != null) {
            aVar.a((h) null);
            this.f5223a.b();
        }
        removeAllViews();
    }

    public void setAllowShowCloseBtn(boolean z) {
        com.anythink.expressad.mbbanner.b.a aVar = this.f5223a;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setBannerAdListener(h hVar) {
        this.b = hVar;
        com.anythink.expressad.mbbanner.b.a aVar = this.f5223a;
        if (aVar != null) {
            aVar.a(hVar);
        }
    }

    public void updateBannerSize(i iVar) {
        com.anythink.expressad.mbbanner.b.a aVar = this.f5223a;
        if (aVar != null) {
            aVar.a(iVar);
        }
    }
}
