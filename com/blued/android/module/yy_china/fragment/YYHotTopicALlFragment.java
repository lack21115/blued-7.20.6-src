package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyHotTopicAllBinding;
import com.blued.android.module.yy_china.databinding.ItemYyHotTopicAllBinding;
import com.blued.android.module.yy_china.fragment.YYHotTopicALlFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.HotTopicItemModel;
import com.blued.android.module.yy_china.presenter.YYHotTopicPresenter;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHotTopicALlFragment.class */
public final class YYHotTopicALlFragment extends MvpFragment<YYHotTopicPresenter> {
    private FragmentYyHotTopicAllBinding a;
    private final AllTopicAdapter b = new AllTopicAdapter(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHotTopicALlFragment$AllTopicAdapter.class */
    public final class AllTopicAdapter extends BaseMultiItemQuickAdapter<HotTopicItemModel, BaseViewHolder> {
        final /* synthetic */ YYHotTopicALlFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AllTopicAdapter(YYHotTopicALlFragment this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            addItemType(0, R.layout.item_yy_hot_topic_all);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYHotTopicALlFragment this$0, HotTopicItemModel hotTopicItemModel, View view) {
            Intrinsics.e(this$0, "this$0");
            YYRoomInfoManager e = YYRoomInfoManager.e();
            FragmentActivity activity = this$0.getActivity();
            if (activity == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseFragmentActivity");
            }
            e.a((BaseFragmentActivity) activity, hotTopicItemModel.getRoom_id(), "hot_topic");
        }

        private final void b(BaseViewHolder baseViewHolder, final HotTopicItemModel hotTopicItemModel) {
            final ItemYyHotTopicAllBinding a = ItemYyHotTopicAllBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            if (hotTopicItemModel == null) {
                return;
            }
            final YYHotTopicALlFragment yYHotTopicALlFragment = this.a;
            ImageLoader.a(yYHotTopicALlFragment.getFragmentActive(), hotTopicItemModel.getAvatar()).c().b(R.drawable.user_bg_round).a(a.b);
            a.f.setText(Intrinsics.a("#", (Object) hotTopicItemModel.getTopic()));
            a.d.setText(hotTopicItemModel.getName());
            a.e.setText(Intrinsics.a(hotTopicItemModel.getRoom_online(), (Object) "人"));
            a.d.setTextColor(a.d.getContext().getResources().getColor(BluedSkinUtils.c() ? R.color.syc_dark_222222 : R.color.white));
            a.f.setTextColor(a.d.getContext().getResources().getColor(BluedSkinUtils.c() ? R.color.syc_dark_222222 : R.color.white));
            a.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHotTopicALlFragment$AllTopicAdapter$bgpCePMe9-uuqq2NSKvbQS_s-LU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHotTopicALlFragment.AllTopicAdapter.a(YYHotTopicALlFragment.this, hotTopicItemModel, view);
                }
            });
            SVGAParser.a(SVGAParser.a.b(), "yy_hot_topic_smale.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.fragment.YYHotTopicALlFragment$AllTopicAdapter$bindData$1$2
                @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.e(videoItem, "videoItem");
                    ItemYyHotTopicAllBinding.this.a.setImageDrawable(new SVGADrawable(videoItem));
                    ItemYyHotTopicAllBinding.this.a.a();
                }

                @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                public void onError() {
                }
            }, (SVGAParser.PlayCallback) null, 4, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, HotTopicItemModel item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            if (item.getItemType() == 0) {
                b(helper, item);
            }
        }
    }

    private final void b(boolean z) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        NoDataAndLoadFailView noDataAndLoadFailView3;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding = this.a;
        if (fragmentYyHotTopicAllBinding != null && (smartRefreshLayout2 = fragmentYyHotTopicAllBinding.c) != null) {
            smartRefreshLayout2.g();
        }
        FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding2 = this.a;
        if (fragmentYyHotTopicAllBinding2 != null && (smartRefreshLayout = fragmentYyHotTopicAllBinding2.c) != null) {
            smartRefreshLayout.h();
        }
        if (this.b.getData().size() > 0) {
            FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding3 = this.a;
            if (fragmentYyHotTopicAllBinding3 == null || (noDataAndLoadFailView = fragmentYyHotTopicAllBinding3.a) == null) {
                return;
            }
            noDataAndLoadFailView.d();
        } else if (z) {
            FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding4 = this.a;
            if (fragmentYyHotTopicAllBinding4 == null || (noDataAndLoadFailView3 = fragmentYyHotTopicAllBinding4.a) == null) {
                return;
            }
            noDataAndLoadFailView3.a();
        } else {
            FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding5 = this.a;
            if (fragmentYyHotTopicAllBinding5 == null || (noDataAndLoadFailView2 = fragmentYyHotTopicAllBinding5.a) == null) {
                return;
            }
            noDataAndLoadFailView2.b();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List<?> list) {
        super.a(str, list);
        if (Intrinsics.a((Object) str, (Object) j().m())) {
            MvpUtils.a(list, HotTopicItemModel.class, new MvpUtils.DataListHandler<HotTopicItemModel>() { // from class: com.blued.android.module.yy_china.fragment.YYHotTopicALlFragment$showDataToUI$1
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<HotTopicItemModel> list2) {
                    YYHotTopicALlFragment.AllTopicAdapter allTopicAdapter;
                    Intrinsics.e(list2, "list");
                    allTopicAdapter = YYHotTopicALlFragment.this.b;
                    allTopicAdapter.setNewData(list2);
                }
            });
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        if (Intrinsics.a((Object) str, (Object) "_load_type_refresh_") ? true : Intrinsics.a((Object) str, (Object) "_load_type_loadmore_")) {
            b(z);
        }
    }

    public final void b() {
        SmartRefreshLayout smartRefreshLayout;
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        FragmentYyHotTopicAllBinding a = FragmentYyHotTopicAllBinding.a(this.i);
        this.a = a;
        RecyclerView recyclerView = a == null ? null : a.b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding = this.a;
        RecyclerView recyclerView2 = fragmentYyHotTopicAllBinding == null ? null : fragmentYyHotTopicAllBinding.b;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.b);
        }
        FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding2 = this.a;
        if (fragmentYyHotTopicAllBinding2 != null && (noDataAndLoadFailView2 = fragmentYyHotTopicAllBinding2.a) != null) {
            noDataAndLoadFailView2.setBackgroundColorRes(R.color.transparent);
        }
        FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding3 = this.a;
        if (fragmentYyHotTopicAllBinding3 != null && (noDataAndLoadFailView = fragmentYyHotTopicAllBinding3.a) != null) {
            noDataAndLoadFailView.setNoDataStr(R.string.yy_hot_topic_no_data);
        }
        FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding4 = this.a;
        if (fragmentYyHotTopicAllBinding4 == null || (smartRefreshLayout = fragmentYyHotTopicAllBinding4.c) == null) {
            return;
        }
        smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYHotTopicALlFragment$initView$1
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYHotTopicALlFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYHotTopicALlFragment.this.j().e();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_hot_topic_all;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        SmartRefreshLayout smartRefreshLayout;
        FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding = this.a;
        if (fragmentYyHotTopicAllBinding == null || (smartRefreshLayout = fragmentYyHotTopicAllBinding.c) == null) {
            return;
        }
        smartRefreshLayout.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        SmartRefreshLayout smartRefreshLayout;
        super.o();
        FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding = this.a;
        if (fragmentYyHotTopicAllBinding == null || (smartRefreshLayout = fragmentYyHotTopicAllBinding.c) == null) {
            return;
        }
        smartRefreshLayout.b(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        SmartRefreshLayout smartRefreshLayout;
        super.p();
        FragmentYyHotTopicAllBinding fragmentYyHotTopicAllBinding = this.a;
        if (fragmentYyHotTopicAllBinding == null || (smartRefreshLayout = fragmentYyHotTopicAllBinding.c) == null) {
            return;
        }
        smartRefreshLayout.b(false);
    }
}
