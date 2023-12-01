package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyHotTopicItemBinding;
import com.blued.android.module.yy_china.databinding.ItemYyHotTopicItemBinding;
import com.blued.android.module.yy_china.fragment.YYHotTopicItemFragment;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHotTopicItemFragment.class */
public final class YYHotTopicItemFragment extends MvpFragment<YYHotTopicPresenter> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17291a = new Companion(null);
    private FragmentYyHotTopicItemBinding b;

    /* renamed from: c  reason: collision with root package name */
    private final TopicAdapter f17292c = new TopicAdapter(this);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHotTopicItemFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHotTopicItemFragment$TopicAdapter.class */
    public final class TopicAdapter extends BaseMultiItemQuickAdapter<HotTopicItemModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYHotTopicItemFragment f17293a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TopicAdapter(YYHotTopicItemFragment this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f17293a = this$0;
            addItemType(0, R.layout.item_yy_hot_topic_item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYHotTopicItemFragment this$0, HotTopicItemModel hotTopicItemModel, View view) {
            Intrinsics.e(this$0, "this$0");
            YYRoomInfoManager e = YYRoomInfoManager.e();
            FragmentActivity activity = this$0.getActivity();
            if (activity == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseFragmentActivity");
            }
            e.a((BaseFragmentActivity) activity, hotTopicItemModel.getRoom_id(), "hot_topic");
        }

        private final void b(BaseViewHolder baseViewHolder, final HotTopicItemModel hotTopicItemModel) {
            final ItemYyHotTopicItemBinding a2 = ItemYyHotTopicItemBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            if (hotTopicItemModel == null) {
                return;
            }
            final YYHotTopicItemFragment yYHotTopicItemFragment = this.f17293a;
            ImageLoader.a(yYHotTopicItemFragment.getFragmentActive(), hotTopicItemModel.getAvatar()).c().b(R.drawable.user_bg_round).a(a2.b);
            a2.d.setText(hotTopicItemModel.getName());
            a2.d.setTextColor(a2.d.getContext().getResources().getColor(BluedSkinUtils.c() ? R.color.syc_dark_222222 : R.color.white));
            a2.e.setText(Intrinsics.a(hotTopicItemModel.getRoom_online(), (Object) "人"));
            a2.f16742c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHotTopicItemFragment$TopicAdapter$-VCvK8ZL_BAG5OQMafox1Qk3Jgw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHotTopicItemFragment.TopicAdapter.a(YYHotTopicItemFragment.this, hotTopicItemModel, view);
                }
            });
            SVGAParser.a(SVGAParser.f15958a.b(), "yy_hot_topic_smale.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.fragment.YYHotTopicItemFragment$TopicAdapter$bindData$1$2
                @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.e(videoItem, "videoItem");
                    ItemYyHotTopicItemBinding.this.f16741a.setImageDrawable(new SVGADrawable(videoItem));
                    ItemYyHotTopicItemBinding.this.f16741a.a();
                }

                @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                public void onError() {
                }
            }, (SVGAParser.PlayCallback) null, 4, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
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
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding = this.b;
        if (fragmentYyHotTopicItemBinding != null && (smartRefreshLayout2 = fragmentYyHotTopicItemBinding.d) != null) {
            smartRefreshLayout2.j();
        }
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding2 = this.b;
        if (fragmentYyHotTopicItemBinding2 != null && (smartRefreshLayout = fragmentYyHotTopicItemBinding2.d) != null) {
            smartRefreshLayout.h();
        }
        if (this.f17292c.getData().size() > 0) {
            FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding3 = this.b;
            if (fragmentYyHotTopicItemBinding3 == null || (noDataAndLoadFailView = fragmentYyHotTopicItemBinding3.b) == null) {
                return;
            }
            noDataAndLoadFailView.d();
            return;
        }
        LogUtils.d("HttpManager", Intrinsics.a("onUIUpdate: ", (Object) Boolean.valueOf(z)));
        if (z) {
            FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding4 = this.b;
            if (fragmentYyHotTopicItemBinding4 == null || (noDataAndLoadFailView3 = fragmentYyHotTopicItemBinding4.b) == null) {
                return;
            }
            noDataAndLoadFailView3.a();
            return;
        }
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding5 = this.b;
        if (fragmentYyHotTopicItemBinding5 == null || (noDataAndLoadFailView2 = fragmentYyHotTopicItemBinding5.b) == null) {
            return;
        }
        noDataAndLoadFailView2.b();
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
            MvpUtils.a(list, HotTopicItemModel.class, new MvpUtils.DataListHandler<HotTopicItemModel>() { // from class: com.blued.android.module.yy_china.fragment.YYHotTopicItemFragment$showDataToUI$1
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<HotTopicItemModel> list2) {
                    YYHotTopicItemFragment.TopicAdapter topicAdapter;
                    Intrinsics.e(list2, "list");
                    topicAdapter = YYHotTopicItemFragment.this.f17292c;
                    topicAdapter.setNewData(list2);
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
        TextView textView;
        SmartRefreshLayout smartRefreshLayout;
        TextView textView2;
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        FragmentYyHotTopicItemBinding a2 = FragmentYyHotTopicItemBinding.a(this.i);
        this.b = a2;
        RecyclerView recyclerView = a2 == null ? null : a2.f16514c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding = this.b;
        RecyclerView recyclerView2 = fragmentYyHotTopicItemBinding == null ? null : fragmentYyHotTopicItemBinding.f16514c;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f17292c);
        }
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding2 = this.b;
        TextView textView3 = fragmentYyHotTopicItemBinding2 == null ? null : fragmentYyHotTopicItemBinding2.e;
        if (textView3 != null) {
            textView3.setText(j().o());
        }
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding3 = this.b;
        if (fragmentYyHotTopicItemBinding3 != null && (noDataAndLoadFailView2 = fragmentYyHotTopicItemBinding3.b) != null) {
            noDataAndLoadFailView2.setBackgroundColorRes(R.color.transparent);
        }
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding4 = this.b;
        if (fragmentYyHotTopicItemBinding4 != null && (noDataAndLoadFailView = fragmentYyHotTopicItemBinding4.b) != null) {
            noDataAndLoadFailView.setNoDataStr(R.string.yy_hot_topic_no_data);
        }
        if (BluedSkinUtils.c()) {
            FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding5 = this.b;
            if (fragmentYyHotTopicItemBinding5 != null && (textView2 = fragmentYyHotTopicItemBinding5.e) != null) {
                textView2.setTextColor(getResources().getColor(R.color.syc_dark_0a0a0a));
            }
            FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding6 = this.b;
            ShapeHelper.b(fragmentYyHotTopicItemBinding6 == null ? null : fragmentYyHotTopicItemBinding6.f16513a, R.color.white);
        } else {
            FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding7 = this.b;
            ShapeHelper.b(fragmentYyHotTopicItemBinding7 == null ? null : fragmentYyHotTopicItemBinding7.f16513a, R.color.white_alpha10);
            FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding8 = this.b;
            if (fragmentYyHotTopicItemBinding8 != null && (textView = fragmentYyHotTopicItemBinding8.e) != null) {
                textView.setTextColor(getResources().getColor(R.color.white));
            }
        }
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding9 = this.b;
        if (fragmentYyHotTopicItemBinding9 == null || (smartRefreshLayout = fragmentYyHotTopicItemBinding9.d) == null) {
            return;
        }
        smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYHotTopicItemFragment$initView$1
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYHotTopicItemFragment.this.j().f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYHotTopicItemFragment.this.j().e();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_hot_topic_item;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        SmartRefreshLayout smartRefreshLayout;
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding = this.b;
        if (fragmentYyHotTopicItemBinding == null || (smartRefreshLayout = fragmentYyHotTopicItemBinding.d) == null) {
            return;
        }
        smartRefreshLayout.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        SmartRefreshLayout smartRefreshLayout;
        super.o();
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding = this.b;
        if (fragmentYyHotTopicItemBinding == null || (smartRefreshLayout = fragmentYyHotTopicItemBinding.d) == null) {
            return;
        }
        smartRefreshLayout.l(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        SmartRefreshLayout smartRefreshLayout;
        super.p();
        FragmentYyHotTopicItemBinding fragmentYyHotTopicItemBinding = this.b;
        if (fragmentYyHotTopicItemBinding == null || (smartRefreshLayout = fragmentYyHotTopicItemBinding.d) == null) {
            return;
        }
        smartRefreshLayout.l(false);
    }
}
