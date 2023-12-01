package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyHomeTabViewBinding;
import com.blued.android.module.yy_china.model.HomeThemeModel;
import com.blued.android.module.yy_china.view.YYHomeThemeTabView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHomeThemeTabView.class */
public final class YYHomeThemeTabView extends FrameLayout {

    /* renamed from: a */
    private final List<HomeThemeModel> f18233a;
    private int b;

    /* renamed from: c */
    private RecyclerView f18234c;
    private HomeTabAdapter d;
    private ViewPager e;
    private int f;
    private int g;
    private float h;
    private float i;
    private int j;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHomeThemeTabView$HomeTabAdapter.class */
    public final class HomeTabAdapter extends CommonRecycleAdapter<HomeThemeModel> {

        /* renamed from: a */
        final /* synthetic */ YYHomeThemeTabView f18235a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomeTabAdapter(YYHomeThemeTabView this$0) {
            super(this$0.getContext());
            Intrinsics.e(this$0, "this$0");
            this.f18235a = this$0;
        }

        public static final void a(YYHomeThemeTabView this$0, int i, HomeTabAdapter this$1, View view) {
            ViewPager viewPager;
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            this$0.setToolBtnSelect(i);
            if (i >= this$1.dataList.size() || (viewPager = this$0.e) == null) {
                return;
            }
            viewPager.setCurrentItem(i);
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(HomeThemeModel model, final int i, CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
            Intrinsics.e(model, "model");
            Intrinsics.e(viewHolder, "viewHolder");
            ItemYyHomeTabViewBinding a2 = ItemYyHomeTabViewBinding.a(viewHolder.a());
            Intrinsics.c(a2, "bind(viewHolder.convertView)");
            if (model.getId() == -10) {
                a2.f16738c.setVisibility(8);
                a2.f16737a.setVisibility(8);
                a2.b.setVisibility(8);
                return;
            }
            a2.f16737a.setVisibility(StringUtils.b(model.getIcon_after()) ? 8 : 0);
            a2.f16738c.setVisibility(StringUtils.b(model.getIcon_after()) ? 0 : 8);
            List<Integer> underLineColors = model.getUnderLineColors();
            if (underLineColors != null) {
                if (underLineColors.size() >= 3) {
                    ShapeHelper.d(a2.b, underLineColors.get(0).intValue(), underLineColors.get(1).intValue(), underLineColors.get(2).intValue());
                } else if (underLineColors.size() >= 2) {
                    ShapeHelper.a(a2.b, underLineColors.get(0).intValue(), underLineColors.get(1).intValue());
                } else if (!underLineColors.isEmpty()) {
                    ShapeHelper.a(a2.b, underLineColors.get(0).intValue(), underLineColors.get(0).intValue());
                }
            }
            if (this.f18235a.j > 0) {
                ViewGroup.LayoutParams layoutParams = a2.b.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ((ConstraintLayout.LayoutParams) layoutParams).topMargin = this.f18235a.j;
            }
            ViewGroup.LayoutParams layoutParams2 = a2.f16737a.getLayoutParams();
            if (this.f18235a.b == i) {
                layoutParams2.height = a2.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_20);
                layoutParams2.width = a2.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_91);
                a2.f16738c.setTextSize(this.f18235a.i);
                if (!StringUtils.b(model.getIcon_after())) {
                    ImageLoader.a((IRequestHost) null, model.getIcon_after()).e(model.hashCode()).g(-1).a(a2.f16737a);
                }
                a2.b.setVisibility(0);
                a2.f16738c.setTextColor(BluedSkinUtils.a(this.mContext, this.f18235a.f));
            } else {
                layoutParams2.height = a2.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_16);
                layoutParams2.width = a2.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_74);
                a2.f16738c.setTextSize(this.f18235a.h);
                a2.f16738c.setTextColor(BluedSkinUtils.a(this.mContext, this.f18235a.g));
                if (!StringUtils.b(model.getIcon_before())) {
                    ImageLoader.a((IRequestHost) null, model.getIcon_before()).a(a2.f16737a);
                }
                a2.b.setVisibility(8);
            }
            a2.f16738c.setText(model.getName());
            View a3 = viewHolder.a();
            final YYHomeThemeTabView yYHomeThemeTabView = this.f18235a;
            a3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHomeThemeTabView$HomeTabAdapter$sLkwnZI-rwe3abHRUI2XOBqA9Zs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHomeThemeTabView.HomeTabAdapter.a(YYHomeThemeTabView.this, i, this, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.item_yy_home_tab_view;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHomeThemeTabView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHomeThemeTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYHomeThemeTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f18233a = new ArrayList();
        this.f = R.color.syc_h;
        this.g = R.color.syc_999999;
        this.h = 14.0f;
        this.i = 17.0f;
        this.f18234c = (RecyclerView) LayoutInflater.from(getContext()).inflate(R.layout.common_tab_view, this).findViewById(R.id.common_tab_view_id);
        this.d = a();
        RecyclerView recyclerView = this.f18234c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.f18234c;
        Intrinsics.a(recyclerView2);
        recyclerView2.setAdapter(this.d);
    }

    private final HomeTabAdapter a() {
        return new HomeTabAdapter(this);
    }

    public static /* synthetic */ void a(YYHomeThemeTabView yYHomeThemeTabView, List list, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = R.color.syc_h;
        }
        if ((i3 & 8) != 0) {
            i2 = R.color.syc_999999;
        }
        yYHomeThemeTabView.a(list, z, i, i2);
    }

    public final void a(RecyclerView.OnScrollListener listener) {
        Intrinsics.e(listener, "listener");
        RecyclerView recyclerView = this.f18234c;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(listener);
    }

    public final void a(ViewPager pager) {
        Intrinsics.e(pager, "pager");
        this.e = pager;
    }

    public final void a(List<HomeThemeModel> list, boolean z, int i, int i2) {
        if (list == null) {
            return;
        }
        this.f = i;
        this.g = i2;
        this.f18233a.clear();
        this.f18233a.addAll(list);
        if (!z) {
            this.f18233a.add(new HomeThemeModel(-10, "", "", "", null, 16, null));
        }
        HomeTabAdapter homeTabAdapter = this.d;
        if (homeTabAdapter == null) {
            return;
        }
        homeTabAdapter.setDataAndNotify(this.f18233a);
    }

    public final int getListCount() {
        return this.f18233a.size();
    }

    public final void setTextHighlightSize(float f) {
        this.i = f;
    }

    public final void setTextNormalSize(float f) {
        this.h = f;
    }

    public final void setToolBtnSelect(int i) {
        if (i < this.f18233a.size()) {
            this.b = i;
        } else if (this.b >= this.f18233a.size()) {
            this.b = 0;
        }
        if (i == this.f18233a.size() - 2) {
            RecyclerView recyclerView = this.f18234c;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(i + 2);
            }
        } else {
            RecyclerView recyclerView2 = this.f18234c;
            if (recyclerView2 != null) {
                recyclerView2.smoothScrollToPosition(i);
            }
        }
        HomeTabAdapter homeTabAdapter = this.d;
        if (homeTabAdapter == null) {
            return;
        }
        homeTabAdapter.notifyDataSetChanged();
    }

    public final void setUnderLineTopMargin(int i) {
        this.j = i;
    }
}
