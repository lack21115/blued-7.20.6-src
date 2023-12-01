package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveRandomGiftHostPowerFragment;
import com.blued.android.module.live_china.fragment.LiveRandomGiftHostRecordFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RandomGiftHostDialogDataModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftHostLottery.class */
public final class FitemRandomGiftHostLottery extends FreedomItem {
    private final RandomGiftHostDialogDataModel b;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftHostLottery$RandomGoodsLotteryAdapter.class */
    public static final class RandomGoodsLotteryAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final RandomGiftHostDialogDataModel f12686a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<String> f12687c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RandomGoodsLotteryAdapter(FragmentManager fm, RandomGiftHostDialogDataModel model) {
            super(fm);
            Intrinsics.e(fm, "fm");
            Intrinsics.e(model, "model");
            this.f12686a = model;
            this.b = 2;
            this.f12687c = CollectionsKt.d("摇奖机会", "摇奖记录");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i == 0) {
                LiveRandomGiftHostPowerFragment liveRandomGiftHostPowerFragment = new LiveRandomGiftHostPowerFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("model", this.f12686a);
                liveRandomGiftHostPowerFragment.setArguments(bundle);
                return liveRandomGiftHostPowerFragment;
            } else if (i != 1) {
                return new Fragment();
            } else {
                LiveRandomGiftHostRecordFragment liveRandomGiftHostRecordFragment = new LiveRandomGiftHostRecordFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("model", this.f12686a);
                liveRandomGiftHostRecordFragment.setArguments(bundle2);
                return liveRandomGiftHostRecordFragment;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            if (i == 0) {
                EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_RANDOM_GIFT_PAGE_LOTTERY_SHOW, LiveRoomManager.a().e());
            } else if (i == 1) {
                EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_RANDOM_GIFT_PAGE_RECORD_SHOW, LiveRoomManager.a().e());
            }
            return this.f12687c.get(i);
        }
    }

    public FitemRandomGiftHostLottery(RandomGiftHostDialogDataModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_host_lottery;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        if (vh.f10931a.a("FragmentManager", (String) null) == null) {
            return;
        }
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) vh.a(R.id.tab_layout);
        tabPageIndicatorWithDot.setIndicatorHeight(DensityUtils.a(context, 2.0f));
        tabPageIndicatorWithDot.w = DensityUtils.d(context, 15.0f);
        tabPageIndicatorWithDot.x = DensityUtils.d(context, 15.0f);
        tabPageIndicatorWithDot.setTextColor(R.color.syc_dark_222);
        tabPageIndicatorWithDot.setTabTextColorUnfocused(R.color.syc_dark_777777);
        tabPageIndicatorWithDot.setHorizontalShade(true);
        if (context != null) {
            tabPageIndicatorWithDot.a(ContextCompat.getColor(context, R.color.syc_dark_222), ContextCompat.getColor(context, R.color.syc_dark_222));
        }
        Object a2 = vh.f10931a.a("FragmentManager", (String) null);
        if (a2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentManager");
        }
        FragmentManager fragmentManager = (FragmentManager) a2;
        ViewPager viewPager = (ViewPager) vh.a(R.id.view_pager);
        viewPager.setAdapter(new RandomGoodsLotteryAdapter(fragmentManager, this.b));
        tabPageIndicatorWithDot.setViewPager(viewPager);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fitem.randomgift.FitemRandomGiftHostLottery$initBindView$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
            }
        });
    }
}
