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
    private final List<HomeThemeModel> a;
    private int b;
    private RecyclerView c;
    private HomeTabAdapter d;
    private ViewPager e;
    private int f;
    private int g;
    private float h;
    private float i;
    private int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHomeThemeTabView$HomeTabAdapter.class */
    public final class HomeTabAdapter extends CommonRecycleAdapter<HomeThemeModel> {
        final /* synthetic */ YYHomeThemeTabView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomeTabAdapter(YYHomeThemeTabView this$0) {
            super(this$0.getContext());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
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

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(HomeThemeModel model, final int i, CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
            Intrinsics.e(model, "model");
            Intrinsics.e(viewHolder, "viewHolder");
            ItemYyHomeTabViewBinding a = ItemYyHomeTabViewBinding.a(viewHolder.a());
            Intrinsics.c(a, "bind(viewHolder.convertView)");
            if (model.getId() == -10) {
                a.c.setVisibility(8);
                a.a.setVisibility(8);
                a.b.setVisibility(8);
                return;
            }
            a.a.setVisibility(StringUtils.b(model.getIcon_after()) ? 8 : 0);
            a.c.setVisibility(StringUtils.b(model.getIcon_after()) ? 0 : 8);
            List<Integer> underLineColors = model.getUnderLineColors();
            if (underLineColors != null) {
                if (underLineColors.size() >= 3) {
                    ShapeHelper.d(a.b, underLineColors.get(0).intValue(), underLineColors.get(1).intValue(), underLineColors.get(2).intValue());
                } else if (underLineColors.size() >= 2) {
                    ShapeHelper.a(a.b, underLineColors.get(0).intValue(), underLineColors.get(1).intValue());
                } else if (!underLineColors.isEmpty()) {
                    ShapeHelper.a(a.b, underLineColors.get(0).intValue(), underLineColors.get(0).intValue());
                }
            }
            if (this.a.j > 0) {
                ConstraintLayout.LayoutParams layoutParams = a.b.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                layoutParams.topMargin = this.a.j;
            }
            ViewGroup.LayoutParams layoutParams2 = a.a.getLayoutParams();
            if (this.a.b == i) {
                layoutParams2.height = a.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_20);
                layoutParams2.width = a.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_91);
                a.c.setTextSize(this.a.i);
                if (!StringUtils.b(model.getIcon_after())) {
                    ImageLoader.a((IRequestHost) null, model.getIcon_after()).e(model.hashCode()).g(-1).a(a.a);
                }
                a.b.setVisibility(0);
                a.c.setTextColor(BluedSkinUtils.a(this.mContext, this.a.f));
            } else {
                layoutParams2.height = a.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_16);
                layoutParams2.width = a.getRoot().getResources().getDimensionPixelOffset(R.dimen.dp_74);
                a.c.setTextSize(this.a.h);
                a.c.setTextColor(BluedSkinUtils.a(this.mContext, this.a.g));
                if (!StringUtils.b(model.getIcon_before())) {
                    ImageLoader.a((IRequestHost) null, model.getIcon_before()).a(a.a);
                }
                a.b.setVisibility(8);
            }
            a.c.setText(model.getName());
            View a2 = viewHolder.a();
            final YYHomeThemeTabView yYHomeThemeTabView = this.a;
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHomeThemeTabView$HomeTabAdapter$sLkwnZI-rwe3abHRUI2XOBqA9Zs
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
        this.a = new ArrayList();
        this.f = R.color.syc_h;
        this.g = R.color.syc_999999;
        this.h = 14.0f;
        this.i = 17.0f;
        this.c = LayoutInflater.from(getContext()).inflate(R.layout.common_tab_view, this).findViewById(R.id.common_tab_view_id);
        this.d = a();
        RecyclerView recyclerView = this.c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.c;
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
        RecyclerView recyclerView = this.c;
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
        this.a.clear();
        this.a.addAll(list);
        if (!z) {
            this.a.add(new HomeThemeModel(-10, "", "", "", null, 16, null));
        }
        HomeTabAdapter homeTabAdapter = this.d;
        if (homeTabAdapter == null) {
            return;
        }
        homeTabAdapter.setDataAndNotify(this.a);
    }

    public final int getListCount() {
        return this.a.size();
    }

    public final void setTextHighlightSize(float f) {
        this.i = f;
    }

    public final void setTextNormalSize(float f) {
        this.h = f;
    }

    public final void setToolBtnSelect(int i) {
        if (i < this.a.size()) {
            this.b = i;
        } else if (this.b >= this.a.size()) {
            this.b = 0;
        }
        if (i == this.a.size() - 2) {
            RecyclerView recyclerView = this.c;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(i + 2);
            }
        } else {
            RecyclerView recyclerView2 = this.c;
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
