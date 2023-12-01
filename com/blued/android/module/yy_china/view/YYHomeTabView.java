package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyHomeTabViewBinding;
import com.blued.android.module.yy_china.model.HomeTopicModel;
import com.blued.android.module.yy_china.view.YYHomeTabView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHomeTabView.class */
public final class YYHomeTabView extends FrameLayout {
    private final List<HomeTopicModel> a;
    private int b;
    private int c;
    private int d;
    private RecyclerView e;
    private HomeTabAdapter f;
    private ViewPager g;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHomeTabView$HomeTabAdapter.class */
    public static final class HomeTabAdapter extends CommonRecycleAdapter<HomeTopicModel> {
        private final YYHomeTabView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomeTabAdapter(Context context, YYHomeTabView tabView) {
            super(context);
            Intrinsics.e(context, "context");
            Intrinsics.e(tabView, "tabView");
            this.a = tabView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(HomeTabAdapter this$0, int i, View view) {
            ViewPager mPage;
            Intrinsics.e(this$0, "this$0");
            this$0.a.setToolBtnSelect(i);
            if (i >= this$0.dataList.size() || (mPage = this$0.a.getMPage()) == null) {
                return;
            }
            mPage.setCurrentItem(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(HomeTopicModel model, final int i, CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
            Intrinsics.e(model, "model");
            Intrinsics.e(viewHolder, "viewHolder");
            ItemYyHomeTabViewBinding a = ItemYyHomeTabViewBinding.a(viewHolder.a());
            Intrinsics.c(a, "bind(viewHolder.convertView)");
            if (model.getLabel_id() == -10) {
                a.c.setVisibility(8);
                a.a.setVisibility(8);
                a.b.setVisibility(8);
                return;
            }
            if (StringUtils.b(model.getPendant_after())) {
                a.a.setVisibility(8);
                a.c.setVisibility(0);
            } else {
                a.a.setVisibility(0);
                a.c.setVisibility(8);
            }
            if (this.a.getCurItemIndex() == i) {
                ViewGroup.LayoutParams layoutParams = a.a.getLayoutParams();
                layoutParams.height = a.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_20);
                layoutParams.width = a.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_91);
                a.c.setTextSize(17.0f);
                if (!StringUtils.b(model.getPendant_after())) {
                    ImageLoader.a((IRequestHost) null, model.getPendant_after()).e(model.hashCode()).g(-1).a(a.a);
                }
                a.b.setVisibility(0);
                a.c.setTextColor(BluedSkinUtils.a(this.mContext, R.color.syc_h));
            } else {
                ViewGroup.LayoutParams layoutParams2 = a.a.getLayoutParams();
                layoutParams2.height = a.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_16);
                layoutParams2.width = a.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_74);
                a.c.setTextSize(14.0f);
                a.c.setTextColor(BluedSkinUtils.a(this.mContext, R.color.syc_999999));
                if (!StringUtils.b(model.getPendant_after())) {
                    ImageLoader.a((IRequestHost) null, model.getPendant_before()).a(a.a);
                }
                a.b.setVisibility(8);
            }
            a.c.setText(model.getLabel_name());
            viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHomeTabView$HomeTabAdapter$vPNRh52Md-luN_MNdW7YV-fXd1Y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHomeTabView.HomeTabAdapter.a(YYHomeTabView.HomeTabAdapter.this, i, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.item_yy_home_tab_view;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHomeTabView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHomeTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYHomeTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = new ArrayList();
        this.e = LayoutInflater.from(getContext()).inflate(R.layout.common_tab_view, this).findViewById(R.id.common_tab_view_id);
        this.f = a();
        RecyclerView recyclerView = this.e;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.YYHomeTabView.1
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.e(outRect, "outRect");
                    Intrinsics.e(view, "view");
                    Intrinsics.e(parent, "parent");
                    Intrinsics.e(state, "state");
                    outRect.left = YYHomeTabView.this.getLeftPadding();
                    outRect.right = YYHomeTabView.this.getRightPadding();
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

    public final void a(RecyclerView.OnScrollListener listener) {
        Intrinsics.e(listener, "listener");
        RecyclerView recyclerView = this.e;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(listener);
    }

    public final void a(ViewPager pager) {
        Intrinsics.e(pager, "pager");
        this.g = pager;
    }

    public final int getCurItemIndex() {
        return this.b;
    }

    public final List<HomeTopicModel> getDataList() {
        return this.a;
    }

    public final int getLeftPadding() {
        return this.c;
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

    public final void setData(List<? extends HomeTopicModel> list) {
        if (list == null) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
        HomeTopicModel homeTopicModel = new HomeTopicModel();
        homeTopicModel.setLabel_id(-10);
        this.a.add(homeTopicModel);
        HomeTabAdapter homeTabAdapter = this.f;
        if (homeTabAdapter == null) {
            return;
        }
        homeTabAdapter.setDataAndNotify(this.a);
    }

    public final void setLeftPadding(int i) {
        this.c = i;
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
        if (i < this.a.size()) {
            this.b = i;
        } else if (this.b >= this.a.size()) {
            this.b = 0;
        }
        if (i == this.a.size() - 2) {
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
