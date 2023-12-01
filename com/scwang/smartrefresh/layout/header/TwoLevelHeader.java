package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/header/TwoLevelHeader.class */
public class TwoLevelHeader extends InternalAbstract implements RefreshHeader {

    /* renamed from: c  reason: collision with root package name */
    protected int f27988c;
    protected float d;
    protected float e;
    protected float f;
    protected float g;
    protected boolean h;
    protected boolean i;
    protected int j;
    protected int k;
    protected RefreshInternal l;
    protected RefreshKernel m;
    protected OnTwoLevelListener n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.header.TwoLevelHeader$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/header/TwoLevelHeader$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27989a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:32:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005d -> B:38:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0061 -> B:34:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:30:0x0049). Please submit an issue!!! */
        static {
            int[] iArr = new int[SpinnerStyle.values().length];
            b = iArr;
            try {
                iArr[SpinnerStyle.Translate.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[SpinnerStyle.Scale.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[RefreshState.values().length];
            f27989a = iArr2;
            try {
                iArr2[RefreshState.TwoLevelReleased.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f27989a[RefreshState.TwoLevel.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f27989a[RefreshState.TwoLevelFinish.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f27989a[RefreshState.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public TwoLevelHeader(Context context) {
        this(context, null);
    }

    public TwoLevelHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoLevelHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0.0f;
        this.e = 2.5f;
        this.f = 1.9f;
        this.g = 1.0f;
        this.h = true;
        this.i = true;
        this.j = 1000;
        this.x = SpinnerStyle.FixedBehind;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TwoLevelHeader);
        this.e = obtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlMaxRage, this.e);
        this.f = obtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorRage, this.f);
        this.g = obtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlRefreshRage, this.g);
        this.j = obtainStyledAttributes.getInt(R.styleable.TwoLevelHeader_srlFloorDuration, this.j);
        this.h = obtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnableTwoLevel, this.h);
        this.i = obtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.i);
        obtainStyledAttributes.recycle();
    }

    public TwoLevelHeader a(OnTwoLevelListener onTwoLevelListener) {
        this.n = onTwoLevelListener;
        return this;
    }

    public TwoLevelHeader a(RefreshHeader refreshHeader) {
        return a(refreshHeader, -1, -2);
    }

    public TwoLevelHeader a(RefreshHeader refreshHeader, int i, int i2) {
        if (refreshHeader != null) {
            RefreshInternal refreshInternal = this.l;
            if (refreshInternal != null) {
                removeView(refreshInternal.getView());
            }
            if (refreshHeader.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                addView(refreshHeader.getView(), 0, new RelativeLayout.LayoutParams(i, i2));
            } else {
                addView(refreshHeader.getView(), i, i2);
            }
            this.l = refreshHeader;
            this.y = refreshHeader;
        }
        return this;
    }

    public TwoLevelHeader a(boolean z) {
        this.h = z;
        return this;
    }

    protected void a(int i) {
        RefreshInternal refreshInternal = this.l;
        if (this.f27988c == i || refreshInternal == null) {
            return;
        }
        this.f27988c = i;
        int i2 = AnonymousClass1.b[refreshInternal.getSpinnerStyle().ordinal()];
        if (i2 == 1) {
            refreshInternal.getView().setTranslationY(i);
        } else if (i2 != 2) {
        } else {
            View view = refreshInternal.getView();
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i));
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(RefreshKernel refreshKernel, int i, int i2) {
        RefreshInternal refreshInternal = this.l;
        if (refreshInternal == null) {
            return;
        }
        if (((i2 + i) * 1.0f) / i != this.e && this.k == 0) {
            this.k = i;
            this.l = null;
            refreshKernel.a().e(this.e);
            this.l = refreshInternal;
        }
        if (this.m == null && refreshInternal.getSpinnerStyle() == SpinnerStyle.Translate && !isInEditMode()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) refreshInternal.getView().getLayoutParams();
            marginLayoutParams.topMargin -= i;
            refreshInternal.getView().setLayoutParams(marginLayoutParams);
        }
        this.k = i;
        this.m = refreshKernel;
        refreshKernel.b(this.j);
        refreshKernel.a(this, !this.i);
        refreshInternal.a(refreshKernel, i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        RefreshInternal refreshInternal = this.l;
        if (refreshInternal != null) {
            refreshInternal.a(refreshLayout, refreshState, refreshState2);
            int i = AnonymousClass1.f27989a[refreshState2.ordinal()];
            if (i != 1) {
                if (i == 3) {
                    if (refreshInternal.getView() != this) {
                        refreshInternal.getView().animate().alpha(1.0f).setDuration(this.j / 2);
                        return;
                    }
                    return;
                } else if (i == 4 && refreshInternal.getView().getAlpha() == 0.0f && refreshInternal.getView() != this) {
                    refreshInternal.getView().setAlpha(1.0f);
                    return;
                } else {
                    return;
                }
            }
            if (refreshInternal.getView() != this) {
                refreshInternal.getView().animate().alpha(0.0f).setDuration(this.j / 2);
            }
            RefreshKernel refreshKernel = this.m;
            if (refreshKernel != null) {
                OnTwoLevelListener onTwoLevelListener = this.n;
                boolean z = true;
                if (onTwoLevelListener != null) {
                    z = onTwoLevelListener.onTwoLevel(refreshLayout);
                }
                refreshKernel.a(z);
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(boolean z, float f, int i, int i2, int i3) {
        a(i);
        RefreshInternal refreshInternal = this.l;
        RefreshKernel refreshKernel = this.m;
        if (refreshInternal != null) {
            refreshInternal.a(z, f, i, i2, i3);
        }
        if (z) {
            float f2 = this.d;
            float f3 = this.f;
            if (f2 < f3 && f >= f3 && this.h) {
                refreshKernel.a(RefreshState.ReleaseToTwoLevel);
            } else if (this.d < this.f || f >= this.g) {
                float f4 = this.d;
                float f5 = this.f;
                if (f4 >= f5 && f < f5) {
                    refreshKernel.a(RefreshState.ReleaseToRefresh);
                }
            } else {
                refreshKernel.a(RefreshState.PullDownToRefresh);
            }
            this.d = f;
        }
    }

    public TwoLevelHeader b(int i) {
        this.j = i;
        return this;
    }

    public TwoLevelHeader b(boolean z) {
        RefreshKernel refreshKernel = this.m;
        if (refreshKernel != null) {
            OnTwoLevelListener onTwoLevelListener = this.n;
            refreshKernel.a(!z || onTwoLevelListener == null || onTwoLevelListener.onTwoLevel(refreshKernel.a()));
        }
        return this;
    }

    public TwoLevelHeader c() {
        RefreshKernel refreshKernel = this.m;
        if (refreshKernel != null) {
            refreshKernel.b();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract
    public boolean equals(Object obj) {
        RefreshInternal refreshInternal = this.l;
        return (refreshInternal != null && refreshInternal.equals(obj)) || super.equals(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.x = SpinnerStyle.MatchLayout;
        if (this.l == null) {
            a(new ClassicsHeader(getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.x = SpinnerStyle.FixedBehind;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt instanceof RefreshHeader) {
                this.l = (RefreshHeader) childAt;
                this.y = (RefreshInternal) childAt;
                bringChildToFront(childAt);
                break;
            }
            i = i2 + 1;
        }
        if (this.l == null) {
            a(new ClassicsHeader(getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        RefreshInternal refreshInternal = this.l;
        if (refreshInternal == null) {
            super.onMeasure(i, i2);
        } else if (View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            super.onMeasure(i, i2);
        } else {
            refreshInternal.getView().measure(i, i2);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), refreshInternal.getView().getMeasuredHeight());
        }
    }
}
