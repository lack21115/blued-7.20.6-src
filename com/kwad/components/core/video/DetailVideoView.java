package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/DetailVideoView.class */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b QZ;
    private b Ra;
    private SurfaceTexture Rb;
    public Surface Rc;
    private a Rd;
    private PhotoInfo.VideoInfo Re;
    private final RectF Rf;
    private int Rg;
    private int Rh;
    private final d Ri;
    private Matrix mMatrix;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/DetailVideoView$a.class */
    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.Rf = new RectF();
        this.Rg = 0;
        this.Rh = 0;
        this.Ri = new d();
        D(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Rf = new RectF();
        this.Rg = 0;
        this.Rh = 0;
        this.Ri = new d();
        D(context);
    }

    private void D(Context context) {
        this.mMatrix = new Matrix();
        this.QZ = new com.kwad.components.core.page.widget.b(context);
        addView(this.QZ, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        qk();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
        if (r14 == 0) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.view.View r6, long r7, long r9) {
        /*
            r5 = this;
            r0 = r6
            if (r0 == 0) goto L99
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L99
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L12
            return
        L12:
            r0 = r6
            android.view.ViewParent r0 = r0.getParent()
            android.view.View r0 = (android.view.View) r0
            r17 = r0
            r0 = r17
            if (r0 != 0) goto L21
            return
        L21:
            r0 = r17
            int r0 = r0.getWidth()
            r15 = r0
            r0 = r17
            int r0 = r0.getHeight()
            r14 = r0
            r0 = r15
            if (r0 == 0) goto L99
            r0 = r14
            if (r0 != 0) goto L3a
            return
        L3a:
            r0 = r6
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r0 = r7
            float r0 = (float) r0
            r1 = r9
            float r1 = (float) r1
            float r0 = r0 / r1
            r11 = r0
            r0 = r14
            float r0 = (float) r0
            r1 = r11
            float r0 = r0 * r1
            r12 = r0
            r0 = r15
            float r0 = (float) r0
            r13 = r0
            r0 = r12
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L67
            r0 = r13
            r1 = r11
            float r0 = r0 / r1
            int r0 = (int) r0
            r14 = r0
            goto L6c
        L67:
            r0 = r12
            int r0 = (int) r0
            r15 = r0
        L6c:
            r0 = r15
            if (r0 == 0) goto L7a
            r0 = r14
            r16 = r0
            r0 = r14
            if (r0 != 0) goto L80
        L7a:
            r0 = -1
            r16 = r0
            r0 = -1
            r15 = r0
        L80:
            r0 = r6
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r6 = r0
            r0 = r6
            r1 = r15
            r0.width = r1
            r0 = r6
            r1 = r16
            r0.height = r1
            r0 = r5
            com.kwad.components.core.page.widget.b r0 = r0.QZ
            r1 = r6
            r0.setLayoutParams(r1)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.video.DetailVideoView.a(android.view.View, long, long):void");
    }

    private void qk() {
        this.QZ.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.Rb == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.Rb = surfaceTexture;
                DetailVideoView.this.ql();
                DetailVideoView.this.Rc = new Surface(surfaceTexture);
                if (DetailVideoView.this.Ra != null) {
                    DetailVideoView.this.Ra.setSurface(DetailVideoView.this.Rc);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ql() {
        Surface surface = this.Rc;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
            this.Rc = null;
        }
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean N = com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (N) {
                    int i2 = (int) (intValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = intValue;
                        layoutParams.width = i2;
                        DetailVideoView.this.setLayoutParams(layoutParams);
                    }
                    DetailVideoView.this.adaptVideoSize(i2, intValue);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = intValue;
                        layoutParams.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofInt.setDuration(500L);
        ofInt.setInterpolator(create);
        return ofInt;
    }

    public final ValueAnimator aM(int i) {
        float height = getHeight();
        float width = getWidth();
        final float f = width / height;
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt((int) width, i);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                layoutParams.height = (int) (intValue / f);
                layoutParams.width = intValue;
                DetailVideoView.this.setLayoutParams(layoutParams);
            }
        });
        return ofInt;
    }

    public final void adaptVideoSize(int i, int i2) {
        if (this.QZ == null) {
            com.kwad.sdk.core.d.b.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.Rh = i2;
        this.Rg = i;
        if (this.Ri.qm()) {
            int qn = this.Ri.qn();
            VideoAdapters.a aVar = null;
            if (qn == 1) {
                aVar = new VideoAdapters.c();
            } else if (qn == 2) {
                aVar = new VideoAdapters.b();
            }
            if (aVar != null) {
                View view = this.QZ;
                aVar.a(view, (View) view.getParent(), i, i2);
            }
        } else if (this.Ri.qs()) {
            com.kwad.sdk.c.kwai.a.B(this.QZ);
        } else if (this.Ri.qo()) {
            com.kwad.sdk.c.kwai.a.e(this.QZ, i, i2);
        } else if (this.Ri.qq()) {
            com.kwad.sdk.c.kwai.a.f(this.QZ, i, i2);
        } else if (this.Ri.qp()) {
            com.kwad.sdk.c.kwai.a.d(this.QZ, i, i2);
        } else if (this.Ri.qr()) {
            a(this.QZ, i, i2);
        } else {
            View view2 = (View) this.QZ.getParent();
            if (view2 == null) {
                return;
            }
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.Re;
            if (videoInfo == null || !com.kwad.sdk.core.response.a.f.a(this.mMatrix, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.QZ.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
                this.mMatrix.reset();
                this.QZ.setTransform(this.mMatrix);
                this.QZ.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.QZ.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                this.QZ.setTransform(this.mMatrix);
                this.QZ.setLayoutParams(layoutParams2);
            }
            this.Rf.set(this.QZ.getLeft(), this.QZ.getTop(), this.QZ.getRight(), this.QZ.getBottom());
        }
    }

    public final void f(boolean z, int i) {
        this.Ri.setAd(true);
        this.Ri.aN(i);
    }

    @Deprecated
    public final void fixWidth(boolean z) {
        this.Ri.aN(z);
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.QZ;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.QZ) {
            a aVar = this.Rd;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.Rd;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ql();
        SurfaceTexture surfaceTexture = this.Rb;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Rb = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        int i6 = this.Rg;
        if (i6 <= 0 || (i5 = this.Rh) <= 0) {
            return;
        }
        adaptVideoSize(i6, i5);
    }

    @Deprecated
    public void setAd(boolean z) {
        this.Ri.setAd(z);
    }

    public void setClickListener(a aVar) {
        this.Rd = aVar;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z) {
        this.Ri.setFillXY(z);
    }

    @Deprecated
    public void setForce(boolean z) {
        this.Ri.setForce(z);
    }

    public void setHorizontalVideo(boolean z) {
        this.Ri.setHorizontalVideo(z);
    }

    public void setMediaPlayer(b bVar) {
        this.Ra = bVar;
        Surface surface = this.Rc;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.kwad.components.core.widget.f.b(this, f);
        }
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.Re = videoInfo;
    }

    public final void updateTextureViewGravity(int i) {
        com.kwad.components.core.page.widget.b bVar = this.QZ;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.QZ.requestLayout();
        }
    }
}
