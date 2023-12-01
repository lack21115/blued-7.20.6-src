package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.BluedLoadMoreView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvMusicListBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/BaseMusicItemFragment.class */
public abstract class BaseMusicItemFragment<T> extends BaseFragment {
    protected FragmentYyKtvMusicListBinding a;
    private BaseQuickAdapter<T, BaseViewHolder> b;
    private NoDataAndLoadFailView c;
    private View d;
    private YYRoomModel e;

    private final void h() {
        View view;
        FrameLayout frameLayout;
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.b = e();
        a().b.setLayoutManager(linearLayoutManager);
        a().b.setAdapter(this.b);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.c = noDataAndLoadFailView;
        if (noDataAndLoadFailView != null) {
            noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_data_common);
        }
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.c;
        if (noDataAndLoadFailView2 != null) {
            noDataAndLoadFailView2.setBackgroundColorRes(R.color.transparent);
        }
        NoDataAndLoadFailView noDataAndLoadFailView3 = this.c;
        if (noDataAndLoadFailView3 != null) {
            noDataAndLoadFailView3.setFailTextColor(R.color.transparent);
        }
        NoDataAndLoadFailView noDataAndLoadFailView4 = this.c;
        if (noDataAndLoadFailView4 != null) {
            noDataAndLoadFailView4.setTopSpace(DensityUtils.a(getContext(), 40.0f));
        }
        NoDataAndLoadFailView noDataAndLoadFailView5 = this.c;
        if (noDataAndLoadFailView5 != null) {
            noDataAndLoadFailView5.setNoDataTextColor(R.color.transparent);
        }
        NoDataAndLoadFailView noDataAndLoadFailView6 = this.c;
        if (noDataAndLoadFailView6 != null) {
            noDataAndLoadFailView6.d();
        }
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.b;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.setEmptyView(this.c);
        }
        a().a.a(new OnRefreshLoadMoreListener(this) { // from class: com.blued.android.module.yy_china.fragment.BaseMusicItemFragment$initView$1
            final /* synthetic */ BaseMusicItemFragment<T> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                this.a.g();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                this.a.f();
            }
        });
        BluedLoadMoreView bluedLoadMoreView = new BluedLoadMoreView(getContext());
        bluedLoadMoreView.setBackgroundColorRes(R.color.transparent);
        a().a.a(bluedLoadMoreView);
        RefreshFooter refreshFooter = a().a.getRefreshFooter();
        if (refreshFooter != null && (view = refreshFooter.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.layout_load_more_view)) != null) {
            frameLayout.setBackgroundResource(R.color.transparent);
        }
        View inflate = View.inflate(getContext(), R.layout.layout_load_end_footer, null);
        this.d = inflate;
        if (inflate != null) {
            inflate.setVisibility(8);
        }
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter2 = this.b;
        if (baseQuickAdapter2 != null) {
            baseQuickAdapter2.addFooterView(this.d);
        }
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter3 = this.b;
        if (baseQuickAdapter3 == null) {
            return;
        }
        baseQuickAdapter3.setEnableLoadMore(false);
    }

    protected final FragmentYyKtvMusicListBinding a() {
        FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding = this.a;
        if (fragmentYyKtvMusicListBinding != null) {
            return fragmentYyKtvMusicListBinding;
        }
        Intrinsics.c("mBinding");
        return null;
    }

    protected final void a(FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding) {
        Intrinsics.e(fragmentYyKtvMusicListBinding, "<set-?>");
        this.a = fragmentYyKtvMusicListBinding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        List data;
        boolean z2 = true;
        if (z) {
            a().a.b(true);
            View view = this.d;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            a().a.b(false);
            View view2 = this.d;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        a().a.h();
        a().a.g();
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.b;
        if (baseQuickAdapter == null || (data = baseQuickAdapter.getData()) == null || data.size() != 0) {
            z2 = false;
        }
        if (z2) {
            NoDataAndLoadFailView noDataAndLoadFailView = this.c;
            if (noDataAndLoadFailView == null) {
                return;
            }
            noDataAndLoadFailView.a();
            return;
        }
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.c;
        if (noDataAndLoadFailView2 == null) {
            return;
        }
        noDataAndLoadFailView2.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseQuickAdapter<T, BaseViewHolder> b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final NoDataAndLoadFailView c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final YYRoomModel d() {
        return this.e;
    }

    public abstract BaseQuickAdapter<T, BaseViewHolder> e();

    public abstract void f();

    public abstract void g();

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = YYRoomInfoManager.e().b();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_yy_ktv_music_list, (ViewGroup) null);
        FragmentYyKtvMusicListBinding a = FragmentYyKtvMusicListBinding.a(inflate);
        Intrinsics.c(a, "bind(view)");
        a(a);
        h();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        a().a.i();
    }
}
