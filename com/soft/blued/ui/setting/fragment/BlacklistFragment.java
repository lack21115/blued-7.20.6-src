package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.R;
import com.soft.blued.ui.find.observer.BlackListDataObserver;
import com.soft.blued.ui.setting.Contract.IBlackListContract;
import com.soft.blued.ui.setting.Presenter.BlackListPresenter;
import com.soft.blued.ui.setting.adapter.BlackAdapter;
import com.soft.blued.ui.setting.model.BluedBlackList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/BlacklistFragment.class */
public class BlacklistFragment extends BaseFragment implements View.OnClickListener, BlackListDataObserver.IBlackListDataObserver, IBlackListContract.IView {

    /* renamed from: a  reason: collision with root package name */
    private Context f33327a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private SmartRefreshLayout f33328c;
    private RecyclerView d;
    private BlackAdapter e;
    private int f = 10;
    private LinearLayout g;
    private NoDataAndLoadFailView h;
    private IBlackListContract.IPresenter i;
    private CommonTopTitleNoTrans j;

    private void g() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        this.j = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setCenterText(this.f33327a.getResources().getString(R.string.my_black_list));
        this.j.setCenterClickListener(this);
        this.j.setLeftClickListener(this);
        this.j.a();
    }

    private void h() {
        this.h = (NoDataAndLoadFailView) this.b.findViewById(2131368079);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_hint);
        this.g = linearLayout;
        linearLayout.setOnClickListener(this);
        this.i.d();
        this.f33328c = (SmartRefreshLayout) this.b.findViewById(2131369119);
        this.d = (RecyclerView) this.b.findViewById(2131369105);
        this.d.setLayoutManager(new LinearLayoutManager(this.f33327a));
        BlackAdapter blackAdapter = new BlackAdapter(this.f33327a, getFragmentActive());
        this.e = blackAdapter;
        this.d.setAdapter(blackAdapter);
        this.f33328c.a(new OnRefreshListener() { // from class: com.soft.blued.ui.setting.fragment.BlacklistFragment.1
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                BlacklistFragment.this.i.b();
            }
        });
        this.f33328c.a(new OnLoadMoreListener() { // from class: com.soft.blued.ui.setting.fragment.BlacklistFragment.2
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                BlacklistFragment.this.i.c();
            }
        });
        this.f33328c.i();
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IView
    public void a() {
        this.f33328c.l(true);
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IView
    public void a(List<BluedBlackList> list) {
        this.e.b(list);
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IView
    public void a(boolean z) {
        if (z) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IView
    public void b() {
        this.f33328c.l(false);
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IView
    public void b(List<BluedBlackList> list) {
        this.e.a(list);
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IView
    public void c() {
        this.f33328c.j();
        this.f33328c.h();
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IView
    public void d() {
        this.h.a();
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IView
    public void e() {
        this.h.d();
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IView
    public void f() {
        this.h.b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131367903) {
        } else {
            PersonalVerifyFragment.a(getActivity());
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.f33327a = activity;
        this.i = new BlackListPresenter(activity, getFragmentActive(), this, this.f);
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_black_list, viewGroup, false);
            h();
            g();
            BlackListDataObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        BlackListDataObserver.a().b(this);
        super.onDestroy();
    }
}
