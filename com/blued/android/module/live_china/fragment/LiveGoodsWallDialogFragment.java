package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveGoodsWallBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGoodsWallDialogFragment.class */
public final class LiveGoodsWallDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<DialogLiveGoodsWallBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveGoodsWallBinding invoke() {
            return DialogLiveGoodsWallBinding.a(LayoutInflater.from(LiveGoodsWallDialogFragment.this.getContext()));
        }
    });
    private boolean c;
    private LiveGoodsWallAdapter d;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGoodsWallDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveGoodsWallDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            LiveGoodsWallDialogFragment liveGoodsWallDialogFragment = new LiveGoodsWallDialogFragment();
            liveGoodsWallDialogFragment.show(manager, LiveGoodsWallDialogFragment.class.getSimpleName());
            return liveGoodsWallDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGoodsWallDialogFragment$LiveGoodsWallAdapter.class */
    public static final class LiveGoodsWallAdapter extends FragmentPagerAdapter {
        private boolean a;
        private Fragment b;
        private final int c;
        private ArrayList<String> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiveGoodsWallAdapter(FragmentManager fm, boolean z, Fragment fragment) {
            super(fm);
            Intrinsics.e(fm, "fm");
            Intrinsics.e(fragment, "fragment");
            this.a = z;
            this.b = fragment;
            this.c = 2;
            this.d = CollectionsKt.d("礼物墙", "定制印记");
        }

        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
        }

        public int getCount() {
            return this.c;
        }

        public Fragment getItem(int i) {
            return i != 0 ? i != 1 ? new Fragment() : new LiveGoodsWallBrandFragment() : new LiveGoodsWallFragment();
        }

        public CharSequence getPageTitle(int i) {
            return this.d.get(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGoodsWallDialogFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveGoodsWallBinding d() {
        return (DialogLiveGoodsWallBinding) this.b.getValue();
    }

    private final void e() {
        f();
    }

    private final void f() {
        d().a.setIndicatorHeight(DensityUtils.a(getContext(), 4.0f));
        d().a.w = DensityUtils.d(getContext(), 15.0f);
        d().a.x = DensityUtils.d(getContext(), 15.0f);
        d().a.setTextColor(R.color.white);
        d().a.setTabTextColorUnfocused(R.color.white_alpha70);
        d().a.setHorizontalShade(true);
        Context context = getContext();
        if (context != null) {
            d().a.a(ContextCompat.getColor(context, R.color.syc_dark_FF3AAA), ContextCompat.getColor(context, R.color.syc_dark_922cee));
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        this.d = new LiveGoodsWallAdapter(childFragmentManager, this.c, (Fragment) this);
        d().d.setAdapter(this.d);
        d().a.setViewPager(d().d);
        d().d.setCurrentItem(0);
        d().d.setOffscreenPageLimit(1);
        d().d.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallDialogFragment$initViewPager$2
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                DialogLiveGoodsWallBinding d;
                DialogLiveGoodsWallBinding d2;
                DialogLiveGoodsWallBinding d3;
                DialogLiveGoodsWallBinding d4;
                DialogLiveGoodsWallBinding d5;
                DialogLiveGoodsWallBinding d6;
                DialogLiveGoodsWallBinding d7;
                DialogLiveGoodsWallBinding d8;
                if (i == 1) {
                    d5 = LiveGoodsWallDialogFragment.this.d();
                    d5.a.setTextColor(R.color.syc_dark_FFE1A6);
                    d6 = LiveGoodsWallDialogFragment.this.d();
                    d6.a.setTabTextColorUnfocused(R.color.syc_dark_C4BFBB);
                    d7 = LiveGoodsWallDialogFragment.this.d();
                    d7.a.a(1);
                    d8 = LiveGoodsWallDialogFragment.this.d();
                    d8.b.animate().alpha(1.0f).setDuration(200L).start();
                    EventTrackLive.a(LiveProtos.Event.LIVE_CUSTOM_MADE_SEAL_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                    return;
                }
                d = LiveGoodsWallDialogFragment.this.d();
                d.a.setTextColor(R.color.white);
                d2 = LiveGoodsWallDialogFragment.this.d();
                d2.a.setTabTextColorUnfocused(R.color.syc_dark_BCBCC8);
                d3 = LiveGoodsWallDialogFragment.this.d();
                d3.a.a(0);
                d4 = LiveGoodsWallDialogFragment.this.d();
                d4.b.animate().alpha(0.0f).setDuration(200L).start();
                EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_WALL_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
        });
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_WALL_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 511.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        this.c = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
        LiveEventBus.get(LiveEventBusUtil.S, Integer.TYPE).observe((LifecycleOwner) this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGoodsWallDialogFragment$3LHNOPl8PPyNVfCQNwCw5JdGwS4
            public final void onChanged(Object obj) {
                LiveGoodsWallDialogFragment.a(LiveGoodsWallDialogFragment.this, (Integer) obj);
            }
        });
        e();
    }
}
