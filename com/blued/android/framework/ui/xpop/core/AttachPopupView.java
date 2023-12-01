package com.blued.android.framework.ui.xpop.core;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.PartShadowContainer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/AttachPopupView.class */
public abstract class AttachPopupView extends BasePopupView {

    /* renamed from: a  reason: collision with root package name */
    protected int f9958a;
    protected int b;

    /* renamed from: c  reason: collision with root package name */
    protected PartShadowContainer f9959c;
    public boolean d;
    boolean e;
    protected int f;
    float g;
    float h;
    float i;
    int j;
    float k;

    public AttachPopupView(Context context) {
        super(context);
        this.f9958a = 0;
        this.b = 0;
        this.f = 6;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = XPopupUtils.b(getContext());
        this.j = 10;
        this.k = 0.0f;
        this.f9959c = (PartShadowContainer) findViewById(R.id.attachPopupContainer);
    }

    protected void a() {
        this.f9959c.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f9959c, false));
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (this.l == null) {
            p();
            return;
        }
        if (this.f9959c.getChildCount() == 0) {
            a();
        }
        if (this.l.a() == null && this.l.k == null) {
            throw new IllegalArgumentException("atView() or touchPoint must not be null for AttachPopupView ！");
        }
        this.f9958a = this.l.y == 0 ? XPopupUtils.a(getContext(), 4.0f) : this.l.y;
        this.b = this.l.x;
        this.f9959c.setTranslationX(this.l.x);
        this.f9959c.setTranslationY(this.l.y);
        c();
        XPopupUtils.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.AttachPopupView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AttachPopupView.this.l != null) {
                    AttachPopupView.this.d();
                }
            }
        });
    }

    public void c() {
        if (this.l == null || this.q) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (getPopupImplView().getBackground() != null) {
                Drawable.ConstantState constantState = getPopupImplView().getBackground().getConstantState();
                if (constantState != null) {
                    this.f9959c.setBackground(constantState.newDrawable());
                    getPopupImplView().setBackground(null);
                }
            } else {
                this.f9959c.setBackground(XPopupUtils.a(getResources().getColor(this.l.E ? R.color._xpopup_dark_color : R.color._xpopup_light_color), this.l.n));
            }
            this.f9959c.setElevation(XPopupUtils.a(getContext(), 20.0f));
        } else if (getPopupImplView().getBackground() == null) {
            int i = this.b;
            int i2 = this.f;
            this.b = i - i2;
            this.f9958a -= i2;
            this.f9959c.setBackground(XPopupUtils.a(getResources().getColor(this.l.E ? R.color._xpopup_dark_color : R.color._xpopup_light_color), this.l.n));
        } else {
            Drawable.ConstantState constantState2 = getPopupImplView().getBackground().getConstantState();
            if (constantState2 != null) {
                this.f9959c.setBackground(constantState2.newDrawable());
                getPopupImplView().setBackground(null);
            }
        }
    }

    public void d() {
        int b;
        int i;
        float b2;
        int i2;
        if (this.l == null) {
            return;
        }
        this.j = XPopupUtils.a(getContext(), this.j);
        final boolean c2 = XPopupUtils.c(getContext());
        if (this.l.k != null) {
            this.k = this.l.k.y;
            if (this.l.k.y + ((float) getPopupContentView().getMeasuredHeight()) > this.i) {
                this.d = this.l.k.y > ((float) (XPopupUtils.b(getContext()) / 2));
            } else {
                this.d = false;
            }
            this.e = this.l.k.x < ((float) (XPopupUtils.a(getContext()) / 2));
            ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
            if (e()) {
                b2 = this.l.k.y - XPopupUtils.a();
                i2 = this.j;
            } else {
                b2 = XPopupUtils.b(getContext()) - this.l.k.y;
                i2 = this.j;
            }
            int i3 = (int) (b2 - i2);
            int a2 = (int) ((this.e ? XPopupUtils.a(getContext()) - this.l.k.x : this.l.k.x) - this.j);
            if (getPopupContentView().getMeasuredHeight() > i3) {
                layoutParams.height = i3;
            }
            if (getPopupContentView().getMeasuredWidth() > a2) {
                layoutParams.width = a2;
            }
            getPopupContentView().setLayoutParams(layoutParams);
            getPopupContentView().post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.AttachPopupView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AttachPopupView.this.l == null) {
                        return;
                    }
                    if (c2) {
                        AttachPopupView attachPopupView = AttachPopupView.this;
                        attachPopupView.g = -(attachPopupView.e ? ((XPopupUtils.a(AttachPopupView.this.getContext()) - AttachPopupView.this.l.k.x) - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.b : (XPopupUtils.a(AttachPopupView.this.getContext()) - AttachPopupView.this.l.k.x) + AttachPopupView.this.b);
                    } else {
                        AttachPopupView attachPopupView2 = AttachPopupView.this;
                        attachPopupView2.g = attachPopupView2.e ? AttachPopupView.this.l.k.x + AttachPopupView.this.b : (AttachPopupView.this.l.k.x - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.b;
                    }
                    if (AttachPopupView.this.l.A) {
                        if (AttachPopupView.this.e) {
                            if (c2) {
                                AttachPopupView.this.g += AttachPopupView.this.getPopupContentView().getMeasuredWidth() / 2.0f;
                            } else {
                                AttachPopupView.this.g -= AttachPopupView.this.getPopupContentView().getMeasuredWidth() / 2.0f;
                            }
                        } else if (c2) {
                            AttachPopupView.this.g -= AttachPopupView.this.getPopupContentView().getMeasuredWidth() / 2.0f;
                        } else {
                            AttachPopupView.this.g += AttachPopupView.this.getPopupContentView().getMeasuredWidth() / 2.0f;
                        }
                    }
                    if (AttachPopupView.this.e()) {
                        AttachPopupView attachPopupView3 = AttachPopupView.this;
                        attachPopupView3.h = (attachPopupView3.l.k.y - AttachPopupView.this.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.f9958a;
                    } else {
                        AttachPopupView attachPopupView4 = AttachPopupView.this;
                        attachPopupView4.h = attachPopupView4.l.k.y + AttachPopupView.this.f9958a;
                    }
                    AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.g);
                    AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.h);
                }
            });
            return;
        }
        int[] iArr = new int[2];
        this.l.a().getLocationOnScreen(iArr);
        final Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.l.a().getMeasuredWidth(), iArr[1] + this.l.a().getMeasuredHeight());
        int i4 = (rect.left + rect.right) / 2;
        boolean z = ((float) (rect.bottom + getPopupContentView().getMeasuredHeight())) > this.i;
        float f = (rect.top + rect.bottom) / 2;
        this.k = f;
        if (z) {
            this.d = f > ((float) (XPopupUtils.b(getContext()) / 2));
        } else {
            this.d = false;
        }
        this.e = i4 <= XPopupUtils.a(getContext()) / 2;
        if (!this.q) {
            ViewGroup.LayoutParams layoutParams2 = getPopupContentView().getLayoutParams();
            if (e()) {
                b = rect.top - XPopupUtils.a();
                i = this.j;
            } else {
                b = XPopupUtils.b(getContext()) - rect.bottom;
                i = this.j;
            }
            int i5 = b - i;
            int a3 = (this.e ? XPopupUtils.a(getContext()) - rect.left : rect.right) - this.j;
            if (getPopupContentView().getMeasuredHeight() > i5) {
                layoutParams2.height = i5;
            }
            if (getPopupContentView().getMeasuredWidth() > a3) {
                layoutParams2.width = a3;
            }
            getPopupContentView().setLayoutParams(layoutParams2);
        }
        getPopupContentView().post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.AttachPopupView.3
            @Override // java.lang.Runnable
            public void run() {
                if (c2) {
                    AttachPopupView attachPopupView = AttachPopupView.this;
                    attachPopupView.g = -(attachPopupView.e ? ((XPopupUtils.a(AttachPopupView.this.getContext()) - rect.left) - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.b : (XPopupUtils.a(AttachPopupView.this.getContext()) - rect.right) + AttachPopupView.this.b);
                } else {
                    AttachPopupView attachPopupView2 = AttachPopupView.this;
                    attachPopupView2.g = attachPopupView2.e ? rect.left + AttachPopupView.this.b : (rect.right - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.b;
                }
                if (AttachPopupView.this.l != null && AttachPopupView.this.l.A) {
                    if (AttachPopupView.this.e) {
                        if (c2) {
                            AttachPopupView.this.g -= (rect.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                        } else {
                            AttachPopupView.this.g += (rect.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                        }
                    } else if (c2) {
                        AttachPopupView.this.g += (rect.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    } else {
                        AttachPopupView.this.g -= (rect.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    }
                }
                if (AttachPopupView.this.e()) {
                    AttachPopupView.this.h = (rect.top - AttachPopupView.this.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.f9958a;
                } else {
                    AttachPopupView.this.h = rect.bottom + AttachPopupView.this.f9958a;
                }
                AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.g);
                AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.h);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r4.l.s == com.blued.android.framework.ui.xpop.enums.PopupPosition.f9998c) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean e() {
        /*
            r4 = this;
            r0 = r4
            com.blued.android.framework.ui.xpop.core.PopupInfo r0 = r0.l
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r7
            if (r0 != 0) goto Lf
            r0 = 0
            return r0
        Lf:
            r0 = r4
            com.blued.android.framework.ui.xpop.core.PopupInfo r0 = r0.l
            boolean r0 = r0.I
            if (r0 == 0) goto L2f
            r0 = r4
            float r0 = r0.k
            r1 = r4
            android.content.Context r1 = r1.getContext()
            int r1 = com.blued.android.framework.ui.xpop.util.XPopupUtils.b(r1)
            r2 = 2
            int r1 = r1 / r2
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2d
            r0 = 1
            r5 = r0
        L2d:
            r0 = r5
            return r0
        L2f:
            r0 = r4
            boolean r0 = r0.d
            if (r0 != 0) goto L45
            r0 = r6
            r5 = r0
            r0 = r4
            com.blued.android.framework.ui.xpop.core.PopupInfo r0 = r0.l
            com.blued.android.framework.ui.xpop.enums.PopupPosition r0 = r0.s
            com.blued.android.framework.ui.xpop.enums.PopupPosition r1 = com.blued.android.framework.ui.xpop.enums.PopupPosition.Top
            if (r0 != r1) goto L56
        L45:
            r0 = r6
            r5 = r0
            r0 = r4
            com.blued.android.framework.ui.xpop.core.PopupInfo r0 = r0.l
            com.blued.android.framework.ui.xpop.enums.PopupPosition r0 = r0.s
            com.blued.android.framework.ui.xpop.enums.PopupPosition r1 = com.blued.android.framework.ui.xpop.enums.PopupPosition.Bottom
            if (r0 == r1) goto L56
            r0 = 1
            r5 = r0
        L56:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.ui.xpop.core.AttachPopupView.e():boolean");
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected PopupAnimator getPopupAnimator() {
        if (e()) {
            return new ScrollScaleAnimator(getPopupContentView(), this.e ? PopupAnimation.ScrollAlphaFromLeftBottom : PopupAnimation.ScrollAlphaFromRightBottom);
        }
        return new ScrollScaleAnimator(getPopupContentView(), this.e ? PopupAnimation.ScrollAlphaFromLeftTop : PopupAnimation.ScrollAlphaFromRightTop);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getPopupLayoutId() {
        return R.layout._xpopup_attach_popup_view;
    }
}
