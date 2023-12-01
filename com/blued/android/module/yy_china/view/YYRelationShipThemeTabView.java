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
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyRelationTabViewBinding;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUiInfo;
import com.blued.android.module.yy_china.view.YYRelationShipThemeTabView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipThemeTabView.class */
public final class YYRelationShipThemeTabView extends FrameLayout {
    private final List<YYRelationShipRoomMode> a;
    private int b;
    private int c;
    private int d;
    private RecyclerView e;
    private HomeTabAdapter f;
    private ViewPager g;
    private int h;
    private int i;
    private String j;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipThemeTabView$HomeTabAdapter.class */
    public final class HomeTabAdapter extends CommonRecycleAdapter<YYRelationShipRoomMode> {
        final /* synthetic */ YYRelationShipThemeTabView a;
        private final YYRelationShipThemeTabView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomeTabAdapter(YYRelationShipThemeTabView this$0, YYRelationShipThemeTabView tabView) {
            super(this$0.getContext());
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(tabView, "tabView");
            this.a = this$0;
            this.b = tabView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(HomeTabAdapter this$0, int i, View view) {
            ViewPager viewPager;
            Intrinsics.e(this$0, "this$0");
            this$0.b.setToolBtnSelect(i);
            if (i >= this$0.dataList.size() || (viewPager = this$0.b.g) == null) {
                return;
            }
            viewPager.setCurrentItem(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(YYRelationShipRoomMode model, final int i, CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
            Intrinsics.e(model, "model");
            Intrinsics.e(viewHolder, "viewHolder");
            ItemYyRelationTabViewBinding a = ItemYyRelationTabViewBinding.a(viewHolder.a());
            Intrinsics.c(a, "bind(viewHolder.convertView)");
            a.b.setText(model.getRelation_name());
            YYRelationShipRoomUiInfo resource_options = model.getResource_options();
            if (resource_options != null) {
                YYRelationShipThemeTabView yYRelationShipThemeTabView = this.a;
                ImageLoader.a((IRequestHost) null, resource_options.getIcon_tab()).a(a.a);
                a.b.setTextColor(Color.parseColor(yYRelationShipThemeTabView.getColorSelect()));
            }
            if (this.a.b == i) {
                a.a.setVisibility(0);
                a.b.setVisibility(8);
            } else {
                a.a.setVisibility(8);
                a.b.setVisibility(0);
            }
            viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipThemeTabView$HomeTabAdapter$KdALo0f-OexIFaCymEJ5oEih04g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipThemeTabView.HomeTabAdapter.a(YYRelationShipThemeTabView.HomeTabAdapter.this, i, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.item_yy_relation_tab_view;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRelationShipThemeTabView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRelationShipThemeTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRelationShipThemeTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = new ArrayList();
        this.h = R.color.syc_h;
        this.i = R.color.syc_999999;
        this.e = LayoutInflater.from(getContext()).inflate(R.layout.common_tab_view, this).findViewById(R.id.common_tab_view_id);
        this.f = a();
        RecyclerView recyclerView = this.e;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.YYRelationShipThemeTabView.1
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.e(outRect, "outRect");
                    Intrinsics.e(view, "view");
                    Intrinsics.e(parent, "parent");
                    Intrinsics.e(state, "state");
                    outRect.left = YYRelationShipThemeTabView.this.c;
                    outRect.right = YYRelationShipThemeTabView.this.d;
                }
            });
        }
        RecyclerView recyclerView3 = this.e;
        Intrinsics.a(recyclerView3);
        recyclerView3.setAdapter(this.f);
        this.j = "#333333";
    }

    private final HomeTabAdapter a() {
        return new HomeTabAdapter(this, this);
    }

    public static /* synthetic */ void a(YYRelationShipThemeTabView yYRelationShipThemeTabView, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = R.color.syc_h;
        }
        if ((i3 & 4) != 0) {
            i2 = R.color.syc_999999;
        }
        yYRelationShipThemeTabView.a(list, i, i2);
    }

    public final void a(ViewPager pager) {
        Intrinsics.e(pager, "pager");
        this.g = pager;
    }

    public final void a(List<YYRelationShipRoomMode> list, int i, int i2) {
        if (list == null) {
            return;
        }
        this.b = 0;
        this.h = i;
        this.i = i2;
        this.a.clear();
        this.a.addAll(list);
        if (this.a.size() > 0) {
            this.j = this.a.get(this.b).getResource_options().getTheme_color_6();
        }
        HomeTabAdapter homeTabAdapter = this.f;
        if (homeTabAdapter == null) {
            return;
        }
        homeTabAdapter.setDataAndNotify(this.a);
    }

    public final String getColorSelect() {
        return this.j;
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
        this.j = str;
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
        this.j = this.a.get(i).getResource_options().getTheme_color_6();
        HomeTabAdapter homeTabAdapter = this.f;
        if (homeTabAdapter == null) {
            return;
        }
        homeTabAdapter.notifyDataSetChanged();
    }
}
