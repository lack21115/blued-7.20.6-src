package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyRankLayoutBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.HomeThemeModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.view.YYHomeThemeTabView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankFragment.class */
public final class YYRankFragment extends BaseFullScreenDialog {
    public static final Companion a = new Companion(null);
    private FragmentYyRankLayoutBinding b;
    private RankPagerAdapter c;
    private String d = "";
    private int e;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final YYRankFragment a() {
            Bundle bundle = new Bundle();
            YYRankFragment yYRankFragment = new YYRankFragment();
            yYRankFragment.setArguments(bundle);
            return yYRankFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankFragment$RankPagerAdapter.class */
    public final class RankPagerAdapter extends FragmentPagerAdapter {
        final /* synthetic */ YYRankFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RankPagerAdapter(YYRankFragment this$0, FragmentManager fm) {
            super(fm, 1);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(fm, "fm");
            this.a = this$0;
        }

        public int getCount() {
            return 3;
        }

        public Fragment getItem(int i) {
            if (i == 0) {
                YYRankItemFragment yYRankItemFragment = new YYRankItemFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("position", 1);
                yYRankItemFragment.setArguments(bundle);
                return yYRankItemFragment;
            } else if (i == 1) {
                YYRankItemFragment yYRankItemFragment2 = new YYRankItemFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("position", 0);
                yYRankItemFragment2.setArguments(bundle2);
                return yYRankItemFragment2;
            } else if (i != 2) {
                return new BaseLazyFragment();
            } else {
                LogUtils.d(Intrinsics.a("web top margin: ", (Object) Integer.valueOf(this.a.e)));
                YYWebViewFragment yYWebViewFragment = new YYWebViewFragment();
                yYWebViewFragment.a(this.a.d + "?from=room_rank&actionbar_height=" + (this.a.e / 2));
                return yYWebViewFragment;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRankFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRankFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @JvmStatic
    public static final YYRankFragment f() {
        return a.a();
    }

    private final void g() {
        int i;
        if (StatusBarHelper.a()) {
            FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding = this.b;
            FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding2 = fragmentYyRankLayoutBinding;
            if (fragmentYyRankLayoutBinding == null) {
                Intrinsics.c("mBinding");
                fragmentYyRankLayoutBinding2 = null;
            }
            ConstraintLayout.LayoutParams layoutParams = fragmentYyRankLayoutBinding2.a.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
            i = layoutParams2.topMargin + StatusBarHelper.a(getActivity());
            layoutParams2.topMargin = i;
            LogUtils.d(Intrinsics.a("height: ", (Object) Integer.valueOf(i)));
        } else {
            i = 0;
        }
        int a2 = DensityUtils.a(getContext(), 24.0f) + i;
        this.e = a2;
        LogUtils.d(Intrinsics.a("total height: ", (Object) Integer.valueOf(a2)));
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding3 = this.b;
        if (fragmentYyRankLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding3 = null;
        }
        fragmentYyRankLayoutBinding3.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRankFragment$X6NukDqf5H14OPS9oxoDcqcH5xI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRankFragment.a(YYRankFragment.this, view);
            }
        });
    }

    private final void h() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(R.color.syc_dark_b));
        ArrayList arrayList3 = arrayList2;
        arrayList.add(new HomeThemeModel(1, "贡献榜", "", "", arrayList3));
        arrayList.add(new HomeThemeModel(0, "人气榜", "", "", arrayList3));
        if (!TextUtils.isEmpty(this.d)) {
            arrayList.add(new HomeThemeModel(2, "周星榜", "", "", arrayList3));
        }
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding = this.b;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding2 = fragmentYyRankLayoutBinding;
        if (fragmentYyRankLayoutBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding2 = null;
        }
        YYHomeThemeTabView yYHomeThemeTabView = fragmentYyRankLayoutBinding2.c;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding3 = this.b;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding4 = fragmentYyRankLayoutBinding3;
        if (fragmentYyRankLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding4 = null;
        }
        ViewPager viewPager = fragmentYyRankLayoutBinding4.d;
        Intrinsics.c(viewPager, "mBinding.rankViewpager");
        yYHomeThemeTabView.a(viewPager);
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding5 = this.b;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding6 = fragmentYyRankLayoutBinding5;
        if (fragmentYyRankLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding6 = null;
        }
        fragmentYyRankLayoutBinding6.c.setTextHighlightSize(17.0f);
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding7 = this.b;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding8 = fragmentYyRankLayoutBinding7;
        if (fragmentYyRankLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding8 = null;
        }
        fragmentYyRankLayoutBinding8.c.setTextNormalSize(17.0f);
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding9 = this.b;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding10 = fragmentYyRankLayoutBinding9;
        if (fragmentYyRankLayoutBinding9 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding10 = null;
        }
        fragmentYyRankLayoutBinding10.c.setUnderLineTopMargin(DensityUtils.a(getContext(), 4.0f));
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding11 = this.b;
        if (fragmentYyRankLayoutBinding11 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding11 = null;
        }
        fragmentYyRankLayoutBinding11.c.a(arrayList, true, R.color.syc_dark_b, R.color.syc_tran50_FFFFFF);
        i();
    }

    private final void i() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        this.c = new RankPagerAdapter(this, childFragmentManager);
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding = this.b;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding2 = fragmentYyRankLayoutBinding;
        if (fragmentYyRankLayoutBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding2 = null;
        }
        fragmentYyRankLayoutBinding2.d.setAdapter(this.c);
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding3 = this.b;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding4 = fragmentYyRankLayoutBinding3;
        if (fragmentYyRankLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding4 = null;
        }
        ViewPager viewPager = fragmentYyRankLayoutBinding4.d;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding5 = this.b;
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding6 = fragmentYyRankLayoutBinding5;
        if (fragmentYyRankLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding6 = null;
        }
        viewPager.setOffscreenPageLimit(fragmentYyRankLayoutBinding6.c.getListCount());
        FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding7 = this.b;
        if (fragmentYyRankLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankLayoutBinding7 = null;
        }
        fragmentYyRankLayoutBinding7.d.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYRankFragment$initViewPager$1
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding8;
                FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding9;
                fragmentYyRankLayoutBinding8 = YYRankFragment.this.b;
                FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding10 = fragmentYyRankLayoutBinding8;
                if (fragmentYyRankLayoutBinding8 == null) {
                    Intrinsics.c("mBinding");
                    fragmentYyRankLayoutBinding10 = null;
                }
                fragmentYyRankLayoutBinding10.c.setToolBtnSelect(i);
                fragmentYyRankLayoutBinding9 = YYRankFragment.this.b;
                FragmentYyRankLayoutBinding fragmentYyRankLayoutBinding11 = fragmentYyRankLayoutBinding9;
                if (fragmentYyRankLayoutBinding11 == null) {
                    Intrinsics.c("mBinding");
                    fragmentYyRankLayoutBinding11 = null;
                }
                fragmentYyRankLayoutBinding11.b.setVisibility(i == 2 ? 0 : 8);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LiveEventBus.get("show_gift_view", String.class).observe((LifecycleOwner) this, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRankFragment$8UC73NDUZ-flii2vCMS0m_Y4tlo
            public final void onChanged(Object obj) {
                YYRankFragment.a(YYRankFragment.this, (String) obj);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_rank_layout, viewGroup, false);
        FragmentYyRankLayoutBinding a2 = FragmentYyRankLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.b = a2;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (str = b.weeklyRankUrl) != null) {
            this.d = str;
        }
        g();
        h();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        LiveEventBus.get("inner_fragment_close").post("");
    }
}
