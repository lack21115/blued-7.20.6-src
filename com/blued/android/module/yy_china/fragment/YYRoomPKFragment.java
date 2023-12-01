package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyRoomPkLayoutBinding;
import com.blued.android.module.yy_china.view.YYPkInfoView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRoomPKFragment.class */
public class YYRoomPKFragment extends BaseFullScreenDialog {
    public static final Companion a = new Companion(null);
    private Context b;
    private FragmentYyRoomPkLayoutBinding c;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRoomPKFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseDialogFragment a() {
            Bundle bundle = new Bundle();
            YYRoomPKFragment yYRoomPKFragment = new YYRoomPKFragment();
            yYRoomPKFragment.setArguments(bundle);
            return yYRoomPKFragment;
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRoomPKFragment$PKAdapter.class */
    public final class PKAdapter extends FragmentPagerAdapter {
        final /* synthetic */ YYRoomPKFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PKAdapter(YYRoomPKFragment this$0, FragmentManager fm) {
            super(fm, 1);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(fm, "fm");
            this.a = this$0;
        }

        public int getCount() {
            return 2;
        }

        public Fragment getItem(int i) {
            return i != 0 ? i != 1 ? new Fragment() : new YYPageLevelFragment() : new YYPagePkFragment();
        }

        public CharSequence getPageTitle(int i) {
            return i != 0 ? i != 1 ? "" : "房间等级" : "房间PK";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomPKFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRoomPKFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        new YYPkInfoView().show(this$0.getChildFragmentManager(), "YYPkInfoView");
    }

    private final void h() {
        TabPageIndicatorWithDot tabPageIndicatorWithDot;
        TabPageIndicatorWithDot tabPageIndicatorWithDot2;
        View view;
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding = this.c;
        if (fragmentYyRoomPkLayoutBinding != null && (view = fragmentYyRoomPkLayoutBinding.a) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRoomPKFragment$LljGeSJ9mQlbBHML6t9kFNrEEgg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYRoomPKFragment.a(YYRoomPKFragment.this, view2);
                }
            });
        }
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding2 = this.c;
        TabPageIndicatorWithDot tabPageIndicatorWithDot3 = fragmentYyRoomPkLayoutBinding2 == null ? null : fragmentYyRoomPkLayoutBinding2.d;
        if (tabPageIndicatorWithDot3 != null) {
            tabPageIndicatorWithDot3.setTabPaddingLeftRight(16);
        }
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding3 = this.c;
        if (fragmentYyRoomPkLayoutBinding3 != null && (tabPageIndicatorWithDot2 = fragmentYyRoomPkLayoutBinding3.d) != null) {
            tabPageIndicatorWithDot2.setTabTextColorUnfocused(R.color.syc_989898);
        }
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding4 = this.c;
        TabPageIndicatorWithDot tabPageIndicatorWithDot4 = fragmentYyRoomPkLayoutBinding4 == null ? null : fragmentYyRoomPkLayoutBinding4.d;
        if (tabPageIndicatorWithDot4 != null) {
            tabPageIndicatorWithDot4.setTextColor(R.color.syc_EAEAEA);
        }
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding5 = this.c;
        if (fragmentYyRoomPkLayoutBinding5 == null || (tabPageIndicatorWithDot = fragmentYyRoomPkLayoutBinding5.d) == null) {
            return;
        }
        tabPageIndicatorWithDot.setIndicatorColor(R.color.syc_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FragmentYyRoomPkLayoutBinding f() {
        return this.c;
    }

    public void g() {
        ImageView imageView;
        TabPageIndicatorWithDot tabPageIndicatorWithDot;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        PagerAdapter pKAdapter = new PKAdapter(this, childFragmentManager);
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding = this.c;
        ViewPager viewPager = fragmentYyRoomPkLayoutBinding == null ? null : fragmentYyRoomPkLayoutBinding.c;
        if (viewPager != null) {
            viewPager.setAdapter(pKAdapter);
        }
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding2 = this.c;
        if (fragmentYyRoomPkLayoutBinding2 != null && (tabPageIndicatorWithDot = fragmentYyRoomPkLayoutBinding2.d) != null) {
            FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding3 = this.c;
            tabPageIndicatorWithDot.setViewPager(fragmentYyRoomPkLayoutBinding3 == null ? null : fragmentYyRoomPkLayoutBinding3.c);
        }
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding4 = this.c;
        ViewPager viewPager2 = fragmentYyRoomPkLayoutBinding4 == null ? null : fragmentYyRoomPkLayoutBinding4.c;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(0);
        }
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding5 = this.c;
        ViewPager viewPager3 = fragmentYyRoomPkLayoutBinding5 == null ? null : fragmentYyRoomPkLayoutBinding5.c;
        if (viewPager3 != null) {
            viewPager3.setOffscreenPageLimit(1);
        }
        FragmentYyRoomPkLayoutBinding fragmentYyRoomPkLayoutBinding6 = this.c;
        if (fragmentYyRoomPkLayoutBinding6 == null || (imageView = fragmentYyRoomPkLayoutBinding6.b) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRoomPKFragment$A3IbMzQiQDIldmK6_2aa3CN2cec
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomPKFragment.b(YYRoomPKFragment.this, view);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getActivity();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_room_pk_layout, viewGroup, false);
        this.c = FragmentYyRoomPkLayoutBinding.a(inflate);
        h();
        g();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        LiveEventBus.get("inner_fragment_close").post("");
    }
}
