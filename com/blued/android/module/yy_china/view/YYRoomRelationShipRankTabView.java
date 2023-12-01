package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyRelationshipRankTopicTitleBinding;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.view.YYRoomRelationShipRankTabView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRoomRelationShipRankTabView.class */
public final class YYRoomRelationShipRankTabView extends FrameLayout {
    private final List<YYRelationShipRoomMode> a;
    private int b;
    private int c;
    private int d;
    private RecyclerView e;
    private HomeTabAdapter f;
    private ViewPager g;
    private String h;
    private String i;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRoomRelationShipRankTabView$HomeTabAdapter.class */
    public final class HomeTabAdapter extends CommonRecycleAdapter<YYRelationShipRoomMode> {
        final /* synthetic */ YYRoomRelationShipRankTabView a;
        private final YYRoomRelationShipRankTabView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomeTabAdapter(YYRoomRelationShipRankTabView this$0, Context context, YYRoomRelationShipRankTabView tabView) {
            super(context);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(context, "context");
            Intrinsics.e(tabView, "tabView");
            this.a = this$0;
            this.b = tabView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(HomeTabAdapter this$0, int i, View view) {
            ViewPager mPage;
            Intrinsics.e(this$0, "this$0");
            this$0.b.setToolBtnSelect(i);
            if (i >= this$0.dataList.size() || (mPage = this$0.b.getMPage()) == null) {
                return;
            }
            mPage.setCurrentItem(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(YYRelationShipRoomMode yYRelationShipRoomMode, final int i, CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
            Intrinsics.e(viewHolder, "viewHolder");
            ItemYyRelationshipRankTopicTitleBinding a = ItemYyRelationshipRankTopicTitleBinding.a(viewHolder.a());
            Intrinsics.c(a, "bind(viewHolder.convertView)");
            a.b.setText(yYRelationShipRoomMode == null ? null : yYRelationShipRoomMode.getRelation_name());
            ShapeModel shapeModel = a.a.getShapeModel();
            shapeModel.t = Color.parseColor(this.a.getColorSelect());
            shapeModel.v = Color.parseColor(this.a.getColorSelect2());
            a.a.setShapeModel(shapeModel);
            if (this.b.getCurItemIndex() == i) {
                a.b.setTextColor(a.b.getContext().getResources().getColor(R.color.syc_383838));
                a.a.setVisibility(0);
            } else {
                a.a.setVisibility(8);
                a.b.setTextColor(a.b.getContext().getResources().getColor(R.color.syc_999999));
            }
            viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomRelationShipRankTabView$HomeTabAdapter$JfQaMHadEdJRsLJMmle7x6uWUDA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRoomRelationShipRankTabView.HomeTabAdapter.a(YYRoomRelationShipRankTabView.HomeTabAdapter.this, i, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.item_yy_relationship_rank_topic_title;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRoomRelationShipRankTabView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRoomRelationShipRankTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRoomRelationShipRankTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = new ArrayList();
        this.h = "#333333";
        this.i = "#333333";
        this.e = LayoutInflater.from(getContext()).inflate(R.layout.common_tab_view, this).findViewById(R.id.common_tab_view_id);
        this.f = a();
        RecyclerView recyclerView = this.e;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.YYRoomRelationShipRankTabView.1
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.e(outRect, "outRect");
                    Intrinsics.e(view, "view");
                    Intrinsics.e(parent, "parent");
                    Intrinsics.e(state, "state");
                    outRect.left = YYRoomRelationShipRankTabView.this.getLeftPadding();
                    outRect.right = YYRoomRelationShipRankTabView.this.getRightPadding();
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
        return new HomeTabAdapter(this, context, this);
    }

    public final void a(ViewPager pager) {
        Intrinsics.e(pager, "pager");
        this.g = pager;
    }

    public final String getColorSelect() {
        return this.h;
    }

    public final String getColorSelect2() {
        return this.i;
    }

    public final int getCurItemIndex() {
        return this.b;
    }

    public final List<YYRelationShipRoomMode> getDataList() {
        return this.a;
    }

    public final YYRelationShipRoomMode getItem() {
        if (this.a.size() > 0) {
            int size = this.a.size();
            int i = this.b;
            if (size > i) {
                return this.a.get(i);
            }
            return null;
        }
        return null;
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

    public final String getSelectId() {
        List<YYRelationShipRoomMode> list = this.a;
        if (list != null) {
            int size = list.size();
            int i = this.b;
            if (size > i) {
                return this.a.get(i).getId();
            }
            return null;
        }
        return null;
    }

    public final void setColorSelect(String str) {
        Intrinsics.e(str, "<set-?>");
        this.h = str;
    }

    public final void setColorSelect2(String str) {
        Intrinsics.e(str, "<set-?>");
        this.i = str;
    }

    public final void setCurItemIndex(int i) {
        this.b = i;
    }

    public final void setData(List<YYRelationShipRoomMode> list) {
        if (list == null) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
        if (this.a.size() > 0) {
            this.h = this.a.get(this.b).getResource_options().getTheme_color_1();
            this.i = this.a.get(this.b).getResource_options().getTheme_color_2();
        }
        HomeTabAdapter homeTabAdapter = this.f;
        if (homeTabAdapter != null) {
            homeTabAdapter.setDataAndNotify(this.a);
        }
        setToolBtnSelect(this.b);
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
        if (this.a.size() > 0) {
            this.h = this.a.get(this.b).getResource_options().getTheme_color_1();
            this.i = this.a.get(this.b).getResource_options().getTheme_color_2();
        }
        HomeTabAdapter homeTabAdapter = this.f;
        if (homeTabAdapter == null) {
            return;
        }
        homeTabAdapter.notifyDataSetChanged();
    }
}
