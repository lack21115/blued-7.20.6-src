package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/internal/InternalAbstract.class */
public abstract class InternalAbstract extends RelativeLayout implements RefreshInternal {
    protected View w;
    protected SpinnerStyle x;
    protected RefreshInternal y;

    public InternalAbstract(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InternalAbstract(View view) {
        this(view, view instanceof RefreshInternal ? (RefreshInternal) view : null);
    }

    protected InternalAbstract(View view, RefreshInternal refreshInternal) {
        super(view.getContext(), null, 0);
        this.w = view;
        this.y = refreshInternal;
        if ((this instanceof RefreshFooterWrapper) && (refreshInternal instanceof RefreshHeader) && refreshInternal.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
            refreshInternal.getView().setScaleY(-1.0f);
        } else if (this instanceof RefreshHeaderWrapper) {
            RefreshInternal refreshInternal2 = this.y;
            if ((refreshInternal2 instanceof RefreshFooter) && refreshInternal2.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                refreshInternal.getView().setScaleY(-1.0f);
            }
        }
    }

    public int a(RefreshLayout refreshLayout, boolean z) {
        RefreshInternal refreshInternal = this.y;
        if (refreshInternal == null || refreshInternal == this) {
            return 0;
        }
        return refreshInternal.a(refreshLayout, z);
    }

    public void a(float f, int i, int i2) {
        RefreshInternal refreshInternal = this.y;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.a(f, i, i2);
    }

    public void a(RefreshKernel refreshKernel, int i, int i2) {
        RefreshInternal refreshInternal = this.y;
        if (refreshInternal != null && refreshInternal != this) {
            refreshInternal.a(refreshKernel, i, i2);
            return;
        }
        View view = this.w;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                refreshKernel.a(this, ((SmartRefreshLayout.LayoutParams) layoutParams).f27963a);
            }
        }
    }

    public void a(RefreshLayout refreshLayout, int i, int i2) {
        RefreshInternal refreshInternal = this.y;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.a(refreshLayout, i, i2);
    }

    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        RefreshState refreshState3;
        RefreshState refreshState4;
        RefreshInternal refreshInternal = this.y;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        if ((this instanceof RefreshFooterWrapper) && (refreshInternal instanceof RefreshHeader)) {
            RefreshState refreshState5 = refreshState;
            if (refreshState.s) {
                refreshState5 = refreshState.b();
            }
            refreshState3 = refreshState5;
            refreshState4 = refreshState2;
            if (refreshState2.s) {
                refreshState4 = refreshState2.b();
                refreshState3 = refreshState5;
            }
        } else {
            refreshState3 = refreshState;
            refreshState4 = refreshState2;
            if (this instanceof RefreshHeaderWrapper) {
                refreshState3 = refreshState;
                refreshState4 = refreshState2;
                if (this.y instanceof RefreshFooter) {
                    RefreshState refreshState6 = refreshState;
                    if (refreshState.r) {
                        refreshState6 = refreshState.a();
                    }
                    refreshState3 = refreshState6;
                    refreshState4 = refreshState2;
                    if (refreshState2.r) {
                        refreshState4 = refreshState2.a();
                        refreshState3 = refreshState6;
                    }
                }
            }
        }
        RefreshInternal refreshInternal2 = this.y;
        if (refreshInternal2 != null) {
            refreshInternal2.a(refreshLayout, refreshState3, refreshState4);
        }
    }

    public void a(boolean z, float f, int i, int i2, int i3) {
        RefreshInternal refreshInternal = this.y;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.a(z, f, i, i2, i3);
    }

    public void b(RefreshLayout refreshLayout, int i, int i2) {
        RefreshInternal refreshInternal = this.y;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.b(refreshLayout, i, i2);
    }

    public boolean b() {
        RefreshInternal refreshInternal = this.y;
        return (refreshInternal == null || refreshInternal == this || !refreshInternal.b()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof RefreshInternal) && getView() == ((RefreshInternal) obj).getView();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        SpinnerStyle spinnerStyle = this.x;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        RefreshInternal refreshInternal = this.y;
        if (refreshInternal == null || refreshInternal == this) {
            View view = this.w;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                    SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.LayoutParams) layoutParams).b;
                    this.x = spinnerStyle2;
                    if (spinnerStyle2 != null) {
                        return spinnerStyle2;
                    }
                }
                if (layoutParams != null && (layoutParams.height == 0 || layoutParams.height == -1)) {
                    SpinnerStyle spinnerStyle3 = SpinnerStyle.Scale;
                    this.x = spinnerStyle3;
                    return spinnerStyle3;
                }
            }
            SpinnerStyle spinnerStyle4 = SpinnerStyle.Translate;
            this.x = spinnerStyle4;
            return spinnerStyle4;
        }
        return refreshInternal.getSpinnerStyle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View] */
    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public View getView() {
        ?? r0 = this.w;
        InternalAbstract internalAbstract = r0;
        if (r0 == 0) {
            internalAbstract = this;
        }
        return internalAbstract;
    }

    public void setPrimaryColors(int... iArr) {
        RefreshInternal refreshInternal = this.y;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.setPrimaryColors(iArr);
    }
}
