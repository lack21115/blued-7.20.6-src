package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyHotTopicTitleBinding;
import com.blued.android.module.yy_china.model.HotTopicModel;
import com.blued.android.module.yy_china.view.YYHotTopicTabView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHotTopicTabView.class */
public final class YYHotTopicTabView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final List<HotTopicModel> f18253a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f18254c;
    private int d;
    private RecyclerView e;
    private HomeTabAdapter f;
    private ViewPager g;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHotTopicTabView$HomeTabAdapter.class */
    public static final class HomeTabAdapter extends CommonRecycleAdapter<HotTopicModel> {

        /* renamed from: a  reason: collision with root package name */
        private final YYHotTopicTabView f18256a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomeTabAdapter(Context context, YYHotTopicTabView tabView) {
            super(context);
            Intrinsics.e(context, "context");
            Intrinsics.e(tabView, "tabView");
            this.f18256a = tabView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(HomeTabAdapter this$0, int i, View view) {
            ViewPager mPage;
            Intrinsics.e(this$0, "this$0");
            this$0.f18256a.setToolBtnSelect(i);
            if (i >= this$0.dataList.size() || (mPage = this$0.f18256a.getMPage()) == null) {
                return;
            }
            mPage.setCurrentItem(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(HotTopicModel model, final int i, CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
            Intrinsics.e(model, "model");
            Intrinsics.e(viewHolder, "viewHolder");
            ItemYyHotTopicTitleBinding a2 = ItemYyHotTopicTitleBinding.a(viewHolder.a());
            Intrinsics.c(a2, "bind(viewHolder.convertView)");
            if (StringUtils.a("全部", model.getTopic())) {
                a2.f16743a.setText(String.valueOf(model.getTopic()));
            } else {
                a2.f16743a.setText(Intrinsics.a("#", (Object) model.getTopic()));
            }
            if (this.f18256a.getCurItemIndex() == i) {
                ShapeHelper.a(a2.f16743a, R.color.syc_4d74EEE7, R.color.syc_4d74EEE7);
                a2.f16743a.setTextColor(a2.f16743a.getContext().getResources().getColor(BluedSkinUtils.c() ? R.color.syc_dark_222222 : R.color.white));
            } else {
                ShapeHelper.a(a2.f16743a, R.color.white, R.color.white);
                a2.f16743a.setTextColor(a2.f16743a.getContext().getResources().getColor(R.color.syc_dark_777777));
            }
            viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHotTopicTabView$HomeTabAdapter$S12phOFNMHKApY1gaPfKJD_qEgg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHotTopicTabView.HomeTabAdapter.a(YYHotTopicTabView.HomeTabAdapter.this, i, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.item_yy_hot_topic_title;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHotTopicTabView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHotTopicTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYHotTopicTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f18253a = new ArrayList();
        this.e = (RecyclerView) LayoutInflater.from(getContext()).inflate(R.layout.common_tab_view, this).findViewById(R.id.common_tab_view_id);
        this.f = a();
        RecyclerView recyclerView = this.e;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.YYHotTopicTabView.1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.e(outRect, "outRect");
                    Intrinsics.e(view, "view");
                    Intrinsics.e(parent, "parent");
                    Intrinsics.e(state, "state");
                    outRect.left = YYHotTopicTabView.this.getLeftPadding();
                    outRect.right = YYHotTopicTabView.this.getRightPadding();
                }
            });
        }
        RecyclerView recyclerView3 = this.e;
        Intrinsics.a(recyclerView3);
        recyclerView3.setAdapter(this.f);
    }

    private final HomeTabAdapter a() {
        Context context = getContext();
        Intrinsics.c(context, "context");
        return new HomeTabAdapter(context, this);
    }

    public final void a(ViewPager pager) {
        Intrinsics.e(pager, "pager");
        this.g = pager;
    }

    public final int getCurItemIndex() {
        return this.b;
    }

    public final List<HotTopicModel> getDataList() {
        return this.f18253a;
    }

    public final int getLeftPadding() {
        return this.f18254c;
    }

    public final HomeTabAdapter getMAdapter() {
        return this.f;
    }

    public final ViewPager getMPage() {
        return this.g;
    }

    public final RecyclerView getRecyclerView() {
        return this.e;
    }

    public final int getRightPadding() {
        return this.d;
    }

    public final void setCurItemIndex(int i) {
        this.b = i;
    }

    public final void setData(List<HotTopicModel> list) {
        if (list == null) {
            return;
        }
        this.f18253a.clear();
        this.f18253a.addAll(list);
        HomeTabAdapter homeTabAdapter = this.f;
        if (homeTabAdapter == null) {
            return;
        }
        homeTabAdapter.setDataAndNotify(this.f18253a);
    }

    public final void setLeftPadding(int i) {
        this.f18254c = i;
    }

    public final void setMAdapter(HomeTabAdapter homeTabAdapter) {
        this.f = homeTabAdapter;
    }

    public final void setMPage(ViewPager viewPager) {
        this.g = viewPager;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        this.e = recyclerView;
    }

    public final void setRightPadding(int i) {
        this.d = i;
    }

    public final void setToolBtnSelect(int i) {
        if (i < this.f18253a.size()) {
            this.b = i;
        } else if (this.b >= this.f18253a.size()) {
            this.b = 0;
        }
        if (i == this.f18253a.size() - 2) {
            RecyclerView recyclerView = this.e;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(i + 2);
            }
        } else {
            RecyclerView recyclerView2 = this.e;
            if (recyclerView2 != null) {
                recyclerView2.smoothScrollToPosition(i);
            }
        }
        HomeTabAdapter homeTabAdapter = this.f;
        if (homeTabAdapter == null) {
            return;
        }
        homeTabAdapter.notifyDataSetChanged();
    }
}
