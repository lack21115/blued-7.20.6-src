package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.b.b;
import com.huawei.openalliance.ad.beans.inner.SourceParam;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/m.class */
public class m extends Drawable implements l {
    private static final String Code = "DrawableWrapper";
    private String B;
    private String I;
    private Drawable V;
    private com.huawei.openalliance.ad.inter.data.k Z;
    private volatile boolean C = false;
    private Drawable.Callback S = new Drawable.Callback() { // from class: com.huawei.hms.ads.m.1
        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            m.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            m.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            m.this.unscheduleSelf(runnable);
        }
    };

    public m(com.huawei.openalliance.ad.inter.data.k kVar) {
        this.Z = kVar;
    }

    public m(String str) {
        this.I = str;
    }

    private SourceParam Code(com.huawei.openalliance.ad.inter.data.k kVar) {
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(kVar.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(kVar.I());
        sourceParam.V(kVar.S());
        sourceParam.I(true);
        return sourceParam;
    }

    private void V() {
        Context Z = j.Code().Z();
        if (Z == null) {
            ge.I(Code, b.f7836a);
            return;
        }
        this.C = true;
        com.huawei.openalliance.ad.utils.y.Code(Z, Code(this.Z), this.B, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.m.2
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                ge.I(m.Code, "image load fail");
                m.this.C = false;
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str, final Drawable drawable) {
                if (m.this.Z == null || !TextUtils.equals(str, m.this.Z.Z())) {
                    return;
                }
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.m.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.C = false;
                        m.this.Code(drawable);
                    }
                });
            }
        });
    }

    public String Code() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.l
    public void Code(Drawable drawable) {
        ge.Code(Code, "setDrawable %s for %s", drawable, com.huawei.openalliance.ad.utils.bc.Code(this.I));
        Drawable drawable2 = this.V;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.V = drawable;
        if (drawable != null) {
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (drawable instanceof fb) {
                ((fb) drawable).Code(this.S);
            } else {
                drawable.setCallback(this.S);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
        }
        invalidateSelf();
    }

    public void Code(String str) {
        this.B = str;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.V;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return 255;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.V;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.V;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.V;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.getOutline(outline);
        } else {
            super.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.V;
        return drawable != null && drawable.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.V;
        return drawable != null && drawable.isStateful();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        Drawable drawable = this.V;
        return drawable != null && drawable.setLayoutDirection(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.V;
        return drawable != null && drawable.setLevel(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.V;
        if (drawable == null || !drawable.isStateful()) {
            return false;
        }
        boolean state = this.V.setState(iArr);
        if (state) {
            onBoundsChange(getBounds());
        }
        return state;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.V == null && !this.C) {
            V();
        }
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.V;
        return (drawable != null && drawable.setVisible(z, z2)) | visible;
    }
}
