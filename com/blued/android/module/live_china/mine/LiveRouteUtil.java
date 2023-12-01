package com.blued.android.module.live_china.mine;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment;
import com.blued.android.module.live_china.fragment.LiveCouponDlgFragment;
import com.blued.android.module.live_china.fragment.LiveFirstChargeDialogFragment;
import com.blued.android.module.live_china.fragment.LiveGuestErrorDlgFragment;
import com.blued.android.module.live_china.fragment.LiveGuestFinishDlgFragment;
import com.blued.android.module.live_china.fragment.LiveGuestGuideDlgFragment;
import com.blued.android.module.live_china.fragment.LiveGuestInterruptDlgFragment;
import com.blued.android.module.live_china.fragment.LiveHostErrorFragment;
import com.blued.android.module.live_china.fragment.LiveHostExitDlgFragment;
import com.blued.android.module.live_china.fragment.LiveMultiDialogFragment;
import com.blued.android.module.live_china.fragment.LiveRechargeDlgFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.LiveUploadTimerManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.observer.PushGuideObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveRouteUtil.class */
public class LiveRouteUtil {
    public static boolean a = false;
    private static int b = -1;
    private static LiveRechargeDlgFragment c;

    public static void a() {
        b = -1;
    }

    public static void a(Fragment fragment) {
        LiveGiftCountInputDlg liveGiftCountInputDlg = new LiveGiftCountInputDlg();
        liveGiftCountInputDlg.show(fragment.getFragmentManager(), liveGiftCountInputDlg.b());
    }

    public static void a(Fragment fragment, Bundle bundle, int i) {
        if (a) {
            return;
        }
        LiveSetPayPwdFragment liveSetPayPwdFragment = new LiveSetPayPwdFragment();
        liveSetPayPwdFragment.setTargetFragment(fragment, i);
        liveSetPayPwdFragment.setArguments(bundle);
        liveSetPayPwdFragment.setCancelable(true);
        liveSetPayPwdFragment.show(fragment.getFragmentManager(), liveSetPayPwdFragment.b());
    }

    public static void a(Fragment fragment, IRequestHost iRequestHost, int i, boolean z, int i2) {
        if (PushGuideObserver.d().a() || fragment == null || iRequestHost == null || !iRequestHost.isActive() || fragment.getFragmentManager() == null) {
            return;
        }
        if (!(fragment instanceof BaseFragment) || ((BaseFragment) fragment).isVisible()) {
            LiveFirstChargeDialogFragment.a.a(fragment, i, z);
            EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_PAY_SHOW, i);
        }
    }

    public static void a(Fragment fragment, LiveGiftModel liveGiftModel) {
        LiveGiftExpireDlgFragment liveGiftExpireDlgFragment = new LiveGiftExpireDlgFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("gift_model", liveGiftModel);
        liveGiftExpireDlgFragment.setArguments(bundle);
        liveGiftExpireDlgFragment.show(fragment.getFragmentManager(), liveGiftExpireDlgFragment.b());
    }

    public static void a(BaseFragment baseFragment) {
        LiveHostExitDlgFragment liveHostExitDlgFragment = new LiveHostExitDlgFragment();
        liveHostExitDlgFragment.setTargetFragment(baseFragment, 100014);
        liveHostExitDlgFragment.show(baseFragment.getFragmentManager(), liveHostExitDlgFragment.b());
    }

    public static void a(BaseFragment baseFragment, int i) {
        if (PushGuideObserver.d().a()) {
            return;
        }
        LiveGuestGuideDlgFragment liveGuestGuideDlgFragment = new LiveGuestGuideDlgFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        liveGuestGuideDlgFragment.setArguments(bundle);
        liveGuestGuideDlgFragment.setTargetFragment(baseFragment, 100013);
        liveGuestGuideDlgFragment.show(baseFragment.getFragmentManager(), liveGuestGuideDlgFragment.b());
    }

    public static void a(BaseFragment baseFragment, LiveChargeCouponModel liveChargeCouponModel) {
        LiveCouponDlgFragment liveCouponDlgFragment = new LiveCouponDlgFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("coupon_model", liveChargeCouponModel);
        liveCouponDlgFragment.setArguments(bundle);
        liveCouponDlgFragment.setTargetFragment(baseFragment, 100017);
        liveCouponDlgFragment.show(baseFragment.getFragmentManager(), liveCouponDlgFragment.b());
    }

    public static void a(BaseFragment baseFragment, MultiDialogModel multiDialogModel) {
        if (PushGuideObserver.d().a()) {
            return;
        }
        a(multiDialogModel != null);
        if (multiDialogModel != null) {
            LiveMultiDialogFragment.a(baseFragment.getChildFragmentManager(), multiDialogModel);
        }
    }

    public static void a(BaseFragment baseFragment, String str) {
        LiveGiftSkinDlgFragment liveGiftSkinDlgFragment = new LiveGiftSkinDlgFragment();
        liveGiftSkinDlgFragment.setTargetFragment(baseFragment, 100018);
        Bundle bundle = new Bundle();
        bundle.putString("goods_id", str);
        liveGiftSkinDlgFragment.setArguments(bundle);
        liveGiftSkinDlgFragment.show(baseFragment.getFragmentManager(), liveGiftSkinDlgFragment.b());
    }

    public static void a(BaseFragment baseFragment, String str, String str2) {
        LiveGuestInterruptDlgFragment liveGuestInterruptDlgFragment = new LiveGuestInterruptDlgFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg_text", str2);
        bundle.putString("msg_title", str);
        liveGuestInterruptDlgFragment.setArguments(bundle);
        liveGuestInterruptDlgFragment.setTargetFragment(baseFragment, 100012);
        liveGuestInterruptDlgFragment.show(baseFragment.getFragmentManager(), liveGuestInterruptDlgFragment.b());
    }

    public static void a(BaseFragment baseFragment, List<LiveGiftModel> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        if (TypeUtils.a((List<?>) list)) {
            return;
        }
        LiveRoomManager.a().e(list);
        LiveGiftScrawlFragment liveGiftScrawlFragment = new LiveGiftScrawlFragment();
        Bundle bundle = new Bundle();
        bundle.putFloat("dlg_dim", 0.6f);
        bundle.putString("selected_index", str);
        bundle.putBoolean("isPking", z);
        bundle.putBoolean("isHit", z2);
        bundle.putBoolean("isMakeLover", z3);
        bundle.putString("defined_rank_name", str2);
        liveGiftScrawlFragment.setArguments(bundle);
        liveGiftScrawlFragment.setTargetFragment(baseFragment, 100016);
        liveGiftScrawlFragment.show(baseFragment.getFragmentManager(), liveGiftScrawlFragment.b());
    }

    public static void a(BaseFragment baseFragment, boolean z) {
        if (PushGuideObserver.d().a() || baseFragment == null || baseFragment.getContext() == null || baseFragment.getFragmentActive() == null || !baseFragment.getFragmentActive().isActive() || !LiveFloatManager.a().y() || LiveFloatManager.a().x() || LiveRoomManager.a().E() == null || c != null) {
            return;
        }
        LiveRechargeDlgFragment liveRechargeDlgFragment = new LiveRechargeDlgFragment(z);
        c = liveRechargeDlgFragment;
        liveRechargeDlgFragment.a(new DialogInterface.OnDismissListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveRouteUtil$r7rK70MbHnOtmWyQwE0rrKMKLf8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                LiveRouteUtil.c = null;
            }
        });
        c.show(baseFragment.getFragmentManager(), c.b());
    }

    public static void a(PlayingOnliveFragment playingOnliveFragment) {
        LiveGuestFinishDlgFragment liveGuestFinishDlgFragment = new LiveGuestFinishDlgFragment();
        liveGuestFinishDlgFragment.a(playingOnliveFragment);
        liveGuestFinishDlgFragment.setTargetFragment(playingOnliveFragment, 100010);
        liveGuestFinishDlgFragment.show(playingOnliveFragment.getFragmentManager(), liveGuestFinishDlgFragment.b());
        LiveUploadTimerManager.b();
    }

    public static void a(PlayingOnliveFragment playingOnliveFragment, String str) {
        LiveGuestErrorDlgFragment liveGuestErrorDlgFragment = new LiveGuestErrorDlgFragment();
        liveGuestErrorDlgFragment.a(playingOnliveFragment);
        Bundle bundle = new Bundle();
        bundle.putString("msg_text", str);
        liveGuestErrorDlgFragment.setArguments(bundle);
        liveGuestErrorDlgFragment.setTargetFragment(playingOnliveFragment, 100011);
        liveGuestErrorDlgFragment.show(playingOnliveFragment.getFragmentManager(), liveGuestErrorDlgFragment.b());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void b(Fragment fragment, LiveGiftModel liveGiftModel) {
        LiveGiftPropExpireDlgFragment liveGiftPropExpireDlgFragment = new LiveGiftPropExpireDlgFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("gift_model", liveGiftModel);
        liveGiftPropExpireDlgFragment.setArguments(bundle);
        liveGiftPropExpireDlgFragment.show(fragment.getFragmentManager(), liveGiftPropExpireDlgFragment.b());
    }

    public static void b(BaseFragment baseFragment) {
        LiveHostErrorFragment liveHostErrorFragment = new LiveHostErrorFragment();
        liveHostErrorFragment.setTargetFragment(baseFragment, 100015);
        liveHostErrorFragment.show(baseFragment.getFragmentManager(), liveHostErrorFragment.b());
    }

    public static boolean b() {
        return b == 1;
    }
}
