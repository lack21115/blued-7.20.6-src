package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fd;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.lb;
import com.huawei.hms.ads.nativead.NativeView;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.y;
import java.util.Iterator;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/NativeWindowImageView.class */
public class NativeWindowImageView extends AutoScaleSizeRelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, lb, aj {
    private View B;
    private ImageView C;
    private Drawable D;
    private com.huawei.openalliance.ad.inter.data.g F;
    private Rect L;
    private ProgressBar S;

    /* renamed from: a  reason: collision with root package name */
    private Rect f23009a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private int f23010c;
    private boolean d;

    public NativeWindowImageView(Context context) {
        super(context);
        this.f23009a = new Rect();
        this.b = 1.3007812f;
        this.f23010c = 0;
        this.d = true;
        Code(context);
    }

    public NativeWindowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23009a = new Rect();
        this.b = 1.3007812f;
        this.f23010c = 0;
        this.d = true;
        Code(context);
    }

    public NativeWindowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23009a = new Rect();
        this.b = 1.3007812f;
        this.f23010c = 0;
        this.d = true;
        Code(context);
    }

    private void B() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    private void C() {
        if (S()) {
            V();
            D();
            L();
            a();
            F();
        }
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_window_image_layout, this);
        this.B = this;
        this.C = (ImageView) findViewById(R.id.window_image_content);
        this.S = (ProgressBar) findViewById(R.id.window_image_progress);
        setRatio(Float.valueOf(1.7777778f));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.L = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private boolean Code(int i) {
        return this.L.height() >= i;
    }

    private boolean Code(Object obj) {
        return (obj instanceof PPSNativeView) || (obj instanceof NativeView);
    }

    private void D() {
        ViewParent parent = this.B.getParent();
        if (parent == null) {
            ge.Z("NativeWindowImageView", "invalid parent obj");
        } else {
            ((View) parent).getGlobalVisibleRect(this.L);
        }
    }

    private void F() {
        if (this.D == null) {
            return;
        }
        this.C.setScaleType(ImageView.ScaleType.MATRIX);
        int intrinsicWidth = this.D.getIntrinsicWidth();
        float f = 1.0f;
        if (intrinsicWidth != 0) {
            f = getWidth() / intrinsicWidth;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        matrix.postTranslate(0.0f, this.f23010c);
        this.C.setImageMatrix(matrix);
        this.C.invalidate();
    }

    private void I() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.removeOnGlobalLayoutListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    private void L() {
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        Rect rect2 = new Rect();
        getGlobalVisibleRect(rect2);
        this.f23009a.left = rect2.left - rect.left;
        Rect rect3 = this.f23009a;
        rect3.right = rect3.left + getWidth();
        this.f23009a.top = rect2.top - rect.top;
        Rect rect4 = this.f23009a;
        rect4.bottom = rect4.top + getHeight();
    }

    private boolean S() {
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        return rect.width() > 0 && rect.height() > 0;
    }

    private void V() {
        ViewParent viewParent;
        if (this.d) {
            ViewParent parent = this.B.getParent();
            while (true) {
                viewParent = parent;
                if (viewParent == null || Code(viewParent)) {
                    break;
                }
                parent = viewParent.getParent();
            }
            if (Code(viewParent)) {
                this.B = (View) viewParent;
            }
        }
    }

    private void a() {
        int i;
        int width = (int) (getWidth() * this.b);
        if (Code(width)) {
            int height = (this.L.height() - width) / 2;
            if (this.f23009a.top - this.L.top <= height) {
                i = 0;
            } else if (this.L.bottom - this.f23009a.bottom <= height) {
                this.f23010c = this.f23009a.height() - width;
                return;
            } else {
                i = (this.L.top + height) - this.f23009a.top;
            }
            this.f23010c = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int intrinsicWidth = this.D.getIntrinsicWidth();
        int intrinsicHeight = this.D.getIntrinsicHeight();
        if (intrinsicHeight != 0 && intrinsicWidth != 0) {
            this.b = intrinsicHeight / intrinsicWidth;
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof fb) {
                ((fb) drawable).Code(new fd() { // from class: com.huawei.openalliance.ad.views.NativeWindowImageView.1
                    @Override // com.huawei.hms.ads.fd
                    public void Code() {
                        NativeWindowImageView.this.b();
                    }

                    @Override // com.huawei.hms.ads.fd
                    public void I() {
                    }

                    @Override // com.huawei.hms.ads.fd
                    public void V() {
                    }
                });
            } else {
                b();
            }
            this.C.setImageDrawable(drawable);
            this.S.setVisibility(8);
        }
    }

    @Override // com.huawei.openalliance.ad.utils.aj
    public void Code() {
        ge.Z("NativeWindowImageView", "load image fail");
    }

    @Override // com.huawei.openalliance.ad.utils.aj
    public void Code(String str, final Drawable drawable) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.NativeWindowImageView.2
            @Override // java.lang.Runnable
            public void run() {
                NativeWindowImageView.this.D = drawable;
                NativeWindowImageView nativeWindowImageView = NativeWindowImageView.this;
                nativeWindowImageView.setImageDrawable(nativeWindowImageView.D);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        I();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ImageView imageView = this.C;
        imageView.layout(0, 0, imageView.getMeasuredWidth(), this.C.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = getMeasuredWidth();
        this.C.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (measuredWidth * this.b), 1073741824));
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        C();
    }

    @Override // com.huawei.hms.ads.lb
    public void setDisplayView(View view) {
        if (view != null) {
            this.d = false;
            this.B = view;
        }
    }

    @Override // com.huawei.hms.ads.lb
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.F = gVar;
        if (gVar != null) {
            Iterator<k> it = gVar.Z().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k next = it.next();
                if (next != null) {
                    String Z = next.Z();
                    SourceParam sourceParam = new SourceParam();
                    sourceParam.I(Z);
                    sourceParam.V(next.I());
                    sourceParam.V(next.S());
                    y.Code(getContext(), sourceParam, this);
                    break;
                }
            }
            requestLayout();
        }
    }
}
