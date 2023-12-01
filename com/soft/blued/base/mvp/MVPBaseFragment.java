package com.soft.blued.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.base.mvp.MVPBasePresent;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/base/mvp/MVPBaseFragment.class */
public abstract class MVPBaseFragment<V, T extends MVPBasePresent<V>> extends BaseFragment implements MVPIView {

    /* renamed from: a  reason: collision with root package name */
    public T f28293a;
    protected Context b;

    /* renamed from: c  reason: collision with root package name */
    protected RelativeLayout f28294c;
    protected FrameLayout d;
    protected FrameLayout e;
    protected CommonTopTitleNoTrans f;
    protected NestedScrollView g;
    protected NoDataAndLoadFailView h;
    protected View i;

    public View a(int i, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.fragment_base, (ViewGroup) null);
        this.f28294c = relativeLayout;
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) relativeLayout.findViewById(2131370694);
        this.f = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.base.mvp.MVPBaseFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MVPBaseFragment.this.getActivity().finish();
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.f28294c.findViewById(R.id.content_v);
        this.d = frameLayout;
        layoutInflater.inflate(i, frameLayout);
        this.g = (NestedScrollView) this.f28294c.findViewById(R.id.error_view);
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) this.f28294c.findViewById(R.id.nodataview);
        this.h = noDataAndLoadFailView;
        noDataAndLoadFailView.setBackgroundColorRes(2131101191);
        this.e = (FrameLayout) this.f28294c.findViewById(R.id.guide_v);
        this.i = this.f28294c.findViewById(R.id.base_loading);
        b(bundle);
        T e = e();
        this.f28293a = e;
        if (e != null) {
            e.a(this);
            this.f28293a.a(bundle);
        }
        f();
        return this.f28294c;
    }

    public void a() {
        FrameLayout frameLayout = this.e;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        NoDataAndLoadFailView noDataAndLoadFailView = this.h;
        if (noDataAndLoadFailView != null) {
            noDataAndLoadFailView.setFailBtnListener(onClickListener);
        }
    }

    @Override // com.soft.blued.base.mvp.MVPIView
    public void a(boolean z) {
        View view = this.i;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public abstract boolean a(Bundle bundle);

    @Override // com.soft.blued.base.mvp.MVPIView
    public void b() {
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        NestedScrollView nestedScrollView = this.g;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
    }

    protected abstract void b(Bundle bundle);

    @Override // com.soft.blued.base.mvp.MVPIView
    public void c() {
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        a();
        NestedScrollView nestedScrollView = this.g;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(0);
        }
        NoDataAndLoadFailView noDataAndLoadFailView = this.h;
        if (noDataAndLoadFailView != null) {
            noDataAndLoadFailView.a();
        }
    }

    @Override // com.soft.blued.base.mvp.MVPIView
    public void d() {
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        a();
        NestedScrollView nestedScrollView = this.g;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(0);
        }
        NoDataAndLoadFailView noDataAndLoadFailView = this.h;
        if (noDataAndLoadFailView != null) {
            noDataAndLoadFailView.b();
        }
    }

    protected abstract T e();

    protected abstract void f();

    @Override // com.soft.blued.base.mvp.MVPIView
    public /* synthetic */ IRequestHost g() {
        return super.getFragmentActive();
    }

    @Override // com.soft.blued.base.mvp.MVPIView
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        T t = this.f28293a;
        if (t != null) {
            t.a(getActivity(), i, i2, intent);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getContext();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        T t = this.f28293a;
        if (t != null) {
            t.b();
        }
        super.onDestroy();
        LogUtils.b(MVPBaseFragment.class.getSimpleName() + " onDestroy()");
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        T t;
        super.onSaveInstanceState(bundle);
        if (a(bundle) || (t = this.f28293a) == null) {
            return;
        }
        t.b(bundle);
    }
}
