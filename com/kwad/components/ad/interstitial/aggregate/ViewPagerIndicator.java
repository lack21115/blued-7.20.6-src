package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/ViewPagerIndicator.class */
public class ViewPagerIndicator extends View {
    private int iC;
    private int iI;
    private int iJ;
    private int iK;
    private float iL;
    private float iM;
    private Paint iN;
    private float iO;
    private float iP;
    private float iQ;
    private int iR;
    private Paint iS;
    private float iT;
    private boolean iU;
    private a iV;
    private ValueAnimator iW;
    private final Context mContext;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/ViewPagerIndicator$a.class */
    public interface a {
        void cz();
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setWillNotDraw(false);
        init(context, attributeSet, i);
        cD();
    }

    private void a(Canvas canvas) {
        float f;
        Paint paint;
        int i;
        RectF rectF = new RectF();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.iK) {
                return;
            }
            int i4 = this.iC;
            if (i3 < i4) {
                f = i3 * (this.iM + this.iQ);
            } else {
                if (i3 == i4) {
                    rectF.left = i3 * (this.iM + this.iQ);
                    float f2 = rectF.left;
                    float f3 = this.iQ;
                    rectF.right = f2 + f3 + ((this.iP - f3) * (1.0f - this.iL));
                    if (this.iU) {
                        this.iN.setColor(this.iI);
                        paint = this.iN;
                        i = (int) (((1.0f - this.iL) * 127.0f) + 127.0f);
                        paint.setAlpha(i);
                    }
                    this.iN.setColor(this.iJ);
                } else if (i3 == i4 + 1) {
                    float f4 = this.iM;
                    float f5 = this.iQ;
                    rectF.left = ((i3 - 1) * (f4 + f5)) + f5 + ((this.iP - f5) * (1.0f - this.iL)) + f4;
                    float f6 = rectF.left;
                    float f7 = this.iL;
                    float f8 = this.iP;
                    float f9 = this.iQ;
                    rectF.right = f6 + (f7 * (f8 - f9)) + f9;
                    if (this.iU) {
                        this.iN.setColor(this.iI);
                        paint = this.iN;
                        i = (int) (255.0f - ((1.0f - this.iL) * 127.0f));
                        paint.setAlpha(i);
                    }
                    this.iN.setColor(this.iJ);
                } else {
                    float f10 = this.iM;
                    f = ((i3 - 1) * (this.iQ + f10)) + f10 + this.iP;
                }
                rectF.top = 0.0f;
                rectF.bottom = rectF.top + this.iO;
                float f11 = this.iO;
                canvas.drawRoundRect(rectF, f11 / 2.0f, f11 / 2.0f, this.iN);
                i2 = i3 + 1;
            }
            rectF.left = f;
            rectF.right = rectF.left + this.iQ;
            this.iN.setColor(this.iJ);
            rectF.top = 0.0f;
            rectF.bottom = rectF.top + this.iO;
            float f112 = this.iO;
            canvas.drawRoundRect(rectF, f112 / 2.0f, f112 / 2.0f, this.iN);
            i2 = i3 + 1;
        }
    }

    static /* synthetic */ boolean a(ViewPagerIndicator viewPagerIndicator, boolean z) {
        viewPagerIndicator.iU = true;
        return true;
    }

    private void b(Canvas canvas) {
        if (this.iU || this.iC != 0) {
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, this.iT, this.iO);
        float f = this.iO;
        canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.iS);
    }

    private void cD() {
        Paint paint = new Paint(1);
        this.iN = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.iN.setStrokeWidth(1.0f);
        this.iN.setColor(this.iJ);
        Paint paint2 = new Paint(1);
        this.iS = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.iS.setStrokeWidth(1.0f);
        this.iS.setColor(this.iI);
    }

    private void cE() {
        if (this.iR <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.iQ, this.iP);
        this.iW = ofFloat;
        ofFloat.setDuration(this.iR * 1000);
        this.iW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.iT = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.iW.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewPagerIndicator.a(ViewPagerIndicator.this, true);
                if (ViewPagerIndicator.this.iV != null) {
                    ViewPagerIndicator.this.iV.cz();
                }
            }
        });
        this.iW.start();
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i, 0);
        this.iM = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, com.kwad.sdk.c.kwai.a.a(this.mContext, 5.0f));
        this.iO = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, com.kwad.sdk.c.kwai.a.a(this.mContext, 6.0f));
        this.iP = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, com.kwad.sdk.c.kwai.a.a(this.mContext, 50.0f));
        this.iQ = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, com.kwad.sdk.c.kwai.a.a(this.mContext, 6.0f));
        this.iJ = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(R.color.ksad_88_white));
        this.iI = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(R.color.ksad_white));
        obtainStyledAttributes.recycle();
    }

    public final void cF() {
        ValueAnimator valueAnimator = this.iW;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public final void cG() {
        ValueAnimator valueAnimator = this.iW;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = mode2 == 1073741824 ? size2 : mode2 == Integer.MIN_VALUE ? (int) this.iO : 0;
        if (mode == 1073741824) {
            i3 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i3 = this.iK > 1 ? (int) (this.iP + ((i4 - 1) * (this.iM + this.iQ))) : (int) this.iP;
        } else {
            i3 = 0;
        }
        setMeasuredDimension(i3, i5);
    }

    public void setFirstAdShowTime(int i) {
        this.iR = i;
    }

    public void setPlayProgressListener(a aVar) {
        this.iV = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.iK = count;
        if (count <= 1) {
            return;
        }
        this.iU = false;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                ViewPagerIndicator.this.iC = i;
                ViewPagerIndicator.this.iL = f;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                ViewPagerIndicator.this.iC = i;
                ViewPagerIndicator.this.iL = 0.0f;
                ViewPagerIndicator.this.invalidate();
            }
        });
        cE();
    }
}
