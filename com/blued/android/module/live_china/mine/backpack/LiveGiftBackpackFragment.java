package com.blued.android.module.live_china.mine.backpack;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CircleProgressView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.event.LiveBeansChangeEvent;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveVp2Adapter;
import com.blued.android.module.live_china.fragment.LivePocketDialogFragment;
import com.blued.android.module.live_china.fragment.LiveShoutCardViewDialog;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveGiftBagRedDotControlManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveGiftFragment;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.mine.backpack.observer.LiveGiftBackpackItemObserver;
import com.blued.android.module.live_china.model.LiveBunchLightModel;
import com.blued.android.module.live_china.model.LiveEffectModel;
import com.blued.android.module.live_china.model.LiveGiftAdvancedModel;
import com.blued.android.module.live_china.model.LiveGiftBackpackModel;
import com.blued.android.module.live_china.model.LiveGiftBackpackProps;
import com.blued.android.module.live_china.model.LiveGiftBackpackTabsModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.model.LiveImgModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.presenter.LiveGiftPresenter;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.CommonShowBottomWindow;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.BubbleLayout;
import com.blued.android.module.live_china.view.PopActionSheet;
import com.blued.android.module.media.selector.view.ActionSheet;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBackpackFragment.class */
public class LiveGiftBackpackFragment extends LiveGiftBackpackBaseFragment<LiveGiftPresenter> {
    private TextView A;
    private LinearLayout B;
    private View C;
    private LiveGiftBackpackModel F;
    private String L;
    private String M;
    private String N;
    private LiveGiftModel O;
    private Dialog P;
    private View R;
    private View S;
    private View T;
    private ImageView U;
    private ImageView V;
    private View W;
    private View X;
    private TextView Y;
    private CircleProgressView Z;
    private BubbleLayout aa;
    private int ad;
    private long af;
    private CommonLiveGiftModel ah;
    private boolean ai;
    private boolean ak;
    private boolean al;
    private ViewGroup n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private FrameLayout r;
    private ImageView s;
    private TextView t;
    private TextView u;
    private ViewGroup v;
    private View w;
    private TextView x;
    private TextView y;
    private View z;
    private final Lazy D = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveGiftBagTabView>() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$giftBackpackToolbarView$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveGiftBagTabView invoke() {
            View view;
            view = LiveGiftBackpackFragment.this.i;
            return (LiveGiftBagTabView) view.findViewById(R.id.base_gift_toolbar_view);
        }
    });
    private final ArrayList<CommonGiftPackageModel<?>> E = new ArrayList<>();
    private final Lazy G = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<ViewPager2>() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$giftBackpackVp$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final ViewPager2 invoke() {
            View view;
            view = LiveGiftBackpackFragment.this.i;
            return (ViewPager2) view.findViewById(R.id.base_view_pager_id);
        }
    });
    private final Lazy H = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveVp2Adapter>() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$giftBackpackVpAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveVp2Adapter invoke() {
            ArrayList arrayList;
            FragmentManager childFragmentManager = LiveGiftBackpackFragment.this.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            Lifecycle lifecycle = LiveGiftBackpackFragment.this.getLifecycle();
            Intrinsics.c(lifecycle, "lifecycle");
            arrayList = LiveGiftBackpackFragment.this.I;
            return new LiveVp2Adapter(childFragmentManager, lifecycle, arrayList);
        }
    });
    private final ArrayList<Fragment> I = new ArrayList<>();
    private final Lazy J = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<String>() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$strFirstChargeTips$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final String invoke() {
            String string = LiveGiftBackpackFragment.this.getResources().getString(R.string.Live_SendPresent_recharge);
            Intrinsics.c(string, "resources.getString(R.st…ive_SendPresent_recharge)");
            return string;
        }
    });
    private final String K = "#3494f4";
    private int Q = 15;
    private final HashMap<String, LiveGiftBackpackItemFragment> ab = new HashMap<>();
    private String ac = "";
    private final Observer<LiveGiftBackpackModel> ae = new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$YASZnpqosvHs_k8LnFxBXfPTj-c
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            LiveGiftBackpackFragment.a(LiveGiftBackpackFragment.this, (LiveGiftBackpackModel) obj);
        }
    };
    private String ag = "";
    private final ConcurrentLinkedQueue<String> aj = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveGiftBagTabView C() {
        Object value = this.D.getValue();
        Intrinsics.c(value, "<get-giftBackpackToolbarView>(...)");
        return (LiveGiftBagTabView) value;
    }

    private final ViewPager2 D() {
        Object value = this.G.getValue();
        Intrinsics.c(value, "<get-giftBackpackVp>(...)");
        return (ViewPager2) value;
    }

    private final LiveVp2Adapter E() {
        return (LiveVp2Adapter) this.H.getValue();
    }

    private final String F() {
        return (String) this.J.getValue();
    }

    private final void G() {
        if (this.I.size() > 2) {
            Fragment fragment = this.I.get(2);
            Intrinsics.c(fragment, "viewFragmentList[2]");
            Fragment fragment2 = fragment;
            if (fragment2 instanceof LiveGiftBackpackItemFragment) {
                ((LiveGiftBackpackItemFragment) fragment2).k();
            }
        }
    }

    private final void H() {
        LiveGiftPresenter liveGiftPresenter = (LiveGiftPresenter) j();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        liveGiftPresenter.a(fragmentActive);
        LiveRoomHttpUtils.d();
        b(new BasePayRemaining());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveGiftFragment I() {
        return (LiveGiftFragment) getParentFragment();
    }

    private final LiveGiftFragment J() {
        return (LiveGiftFragment) getParentFragment();
    }

    private final void K() {
        PlayingOnliveFragment s;
        PlayingOnliveFragment s2;
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_POP_RECHARGE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        LiveGiftFragment J = J();
        boolean z = false;
        if (J != null && (s2 = J.s()) != null && s2.aE()) {
            z = true;
        }
        if (z) {
            if (!LiveDataManager.a().f()) {
                LiveRoomInfo.a().a(getContext(), getFragmentManager(), 10);
                return;
            }
            LiveGiftFragment J2 = J();
            if (J2 != null && (s = J2.s()) != null) {
                s.b(true);
            }
            LiveRoomInfo.a().a(getContext(), 3);
        }
    }

    private final void L() {
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            if (liveGiftModel.ops == 5) {
                return;
            }
            LogUtils.d("pLog", "     private fun onClickSend() 点击发送");
            int b = b();
            LiveGiftModel liveGiftModel2 = this.O;
            Intrinsics.a(liveGiftModel2);
            EventTrackLive.a(LiveProtos.Event.USER_LIVE_GIFT_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel2.goods_id, b);
            LiveGiftModel liveGiftModel3 = this.O;
            Intrinsics.a(liveGiftModel3);
            if (liveGiftModel3.is_join_ticket == 1 && LiveRoomManager.a().q() != null && LiveRoomManager.a().q().fans_status == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = getResources().getString(R.string.live_fans_name_join_tip);
                Intrinsics.c(string, "resources.getString(R.st….live_fans_name_join_tip)");
                LiveGiftModel liveGiftModel4 = this.O;
                Intrinsics.a(liveGiftModel4);
                String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(liveGiftModel4.beans)}, 1));
                Intrinsics.c(format, "format(format, *args)");
                CommonAlertDialog.a(getActivity(), "", format, getResources().getString(R.string.sure), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$i23yE1_S2iKftAhBb2mHuLBaKpk
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        LiveGiftBackpackFragment.a(LiveGiftBackpackFragment.this, dialogInterface, i);
                    }
                }, getResources().getString(R.string.live_fans_quit_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            }
            LiveGiftModel liveGiftModel5 = this.O;
            Intrinsics.a(liveGiftModel5);
            if (liveGiftModel5.ops == 17) {
                P();
                return;
            }
            LiveGiftModel liveGiftModel6 = this.O;
            Intrinsics.a(liveGiftModel6);
            if (liveGiftModel6.ops == 18) {
                T();
                return;
            }
            LiveGiftModel liveGiftModel7 = this.O;
            Intrinsics.a(liveGiftModel7);
            if (liveGiftModel7.ops == 20) {
                S();
                return;
            }
            LiveGiftModel liveGiftModel8 = this.O;
            Intrinsics.a(liveGiftModel8);
            if (liveGiftModel8.ops == 16) {
                LiveGiftModel liveGiftModel9 = this.O;
                if (liveGiftModel9 == null) {
                    return;
                }
                if (liveGiftModel9 != null && liveGiftModel9.is_use == 1) {
                    a(this.O, 0, 0);
                    return;
                } else {
                    a(this.O, 1, 1);
                    return;
                }
            }
            LiveGiftModel liveGiftModel10 = this.O;
            Intrinsics.a(liveGiftModel10);
            if (liveGiftModel10.ops == 21) {
                Q();
                return;
            }
            LiveGiftModel liveGiftModel11 = this.O;
            Intrinsics.a(liveGiftModel11);
            if (liveGiftModel11.ops == 22) {
                R();
                return;
            }
            LiveGiftModel liveGiftModel12 = this.O;
            Intrinsics.a(liveGiftModel12);
            if (liveGiftModel12.ops == 23) {
                O();
            } else {
                M();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void M() {
        /*
            Method dump skipped, instructions count: 695
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment.M():void");
    }

    private final String N() {
        return LiveRoomManager.a().O();
    }

    private final void O() {
        final LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel == null) {
            return;
        }
        DialogUtils.a(this.P);
        boolean z = true;
        if (liveGiftModel.is_use == 1) {
            z = false;
        }
        final boolean z2 = z;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.a(liveGiftModel.decoration_id, liveGiftModel.decoration_type, z, new BluedUIHttpResponse<BluedEntityA<CountModel>>(z2, this, fragmentActive) { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$useCardFrame$1
            final /* synthetic */ boolean b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ LiveGiftBackpackFragment f13918c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CountModel> bluedEntityA) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                Dialog dialog;
                super.onUIFinish();
                dialog = this.f13918c.P;
                DialogUtils.b(dialog);
            }
        }, getFragmentActive());
        if (z) {
            EventTrackLive.p(LiveProtos.Event.LIVE_GIFT_POP_DRESS_TAB_PROFILE_CARD_USE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        } else {
            EventTrackLive.p(LiveProtos.Event.LIVE_GIFT_POP_DRESS_TAB_PROFILE_CARD_CANCEL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        }
    }

    private final void P() {
        final LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel == null) {
            return;
        }
        DialogUtils.a(this.P);
        boolean z = true;
        if (liveGiftModel.is_use == 1) {
            z = false;
        }
        final boolean z2 = z;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.a(liveGiftModel.goods_id, z, new BluedUIHttpResponse<BluedEntityA<CountModel>>(z2, this, fragmentActive) { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$useAvatar$1
            final /* synthetic */ boolean b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ LiveGiftBackpackFragment f13912c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CountModel> bluedEntityA) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                Dialog dialog;
                super.onUIFinish();
                dialog = this.f13912c.P;
                DialogUtils.b(dialog);
            }
        }, getFragmentActive());
        if (z) {
            EventTrackLive.p(LiveProtos.Event.LIVE_PHOTO_FRAME_USE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        } else {
            EventTrackLive.p(LiveProtos.Event.LIVE_PHOTO_FRAME_CANCEL, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        }
    }

    private final void Q() {
        final LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel == null) {
            return;
        }
        DialogUtils.a(this.P);
        boolean z = true;
        if (liveGiftModel.is_use == 1) {
            z = false;
        }
        final boolean z2 = z;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.b(liveGiftModel.goods_id, z, new BluedUIHttpResponse<BluedEntityA<CountModel>>(z2, this, fragmentActive) { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$useBadge$1
            final /* synthetic */ boolean b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ LiveGiftBackpackFragment f13914c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CountModel> bluedEntityA) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                Dialog dialog;
                super.onUIFinish();
                dialog = this.f13914c.P;
                DialogUtils.b(dialog);
            }
        }, getFragmentActive());
        if (z) {
            EventTrackLive.p(LiveProtos.Event.LIVE_BAG_CHAT_MARK_USE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        } else {
            EventTrackLive.p(LiveProtos.Event.LIVE_BAG_CHAT_MARK_CANCEL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        }
    }

    private final void R() {
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel == null) {
            return;
        }
        EventTrackLive.x(LiveProtos.Event.LIVE_GIFT_POP_PATCH_TAB_COMPOSE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        LiveRoomHttpUtils.c(liveGiftModel.goods_id, new LiveGiftBackpackFragment$syntheticFragment$1(this, getFragmentActive()), getFragmentActive());
    }

    private final void S() {
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel == null) {
            return;
        }
        String str = liveGiftModel.type;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 49) {
                if (hashCode != 50) {
                    if (hashCode == 53 && str.equals("5")) {
                        V();
                    }
                } else if (str.equals("2")) {
                    if (LiveRoomManager.a().b == 1) {
                        ToastUtils.a(getResources().getString(R.string.live_shout_card_send_tips));
                        return;
                    }
                    LiveShoutCardViewDialog.Companion companion = LiveShoutCardViewDialog.f13263a;
                    String str2 = liveGiftModel.pop_up_title;
                    Intrinsics.c(str2, "selectedModel.pop_up_title");
                    String str3 = liveGiftModel.pop_up_description;
                    Intrinsics.c(str3, "selectedModel.pop_up_description");
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    Intrinsics.c(parentFragmentManager, "parentFragmentManager");
                    companion.a(str2, str3, parentFragmentManager);
                    postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$VK_ffU-4WtoTaDiZxjS6Zm1gikU
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveGiftBackpackFragment.p(LiveGiftBackpackFragment.this);
                        }
                    }, 200L);
                }
            } else if (str.equals("1")) {
                LiveRoomInfo a2 = LiveRoomInfo.a();
                FragmentActivity activity = getActivity();
                FragmentManager fragmentManager = getFragmentManager();
                Object obj = liveGiftModel.extraModel;
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.model.LiveChargeCouponModel");
                }
                a2.a(activity, fragmentManager, 2, (LiveChargeCouponModel) obj);
            }
            EventTrackLive.p(LiveProtos.Event.LIVE_GIFT_COUPON_PAGE_ONE_USE, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        }
        U();
        EventTrackLive.p(LiveProtos.Event.LIVE_GIFT_COUPON_PAGE_ONE_USE, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
    }

    private final void T() {
        final LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel == null) {
            return;
        }
        DialogUtils.a(this.P);
        boolean z = true;
        if (liveGiftModel.is_use == 1) {
            z = false;
        }
        final boolean z2 = z;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.c(liveGiftModel.goods_id, z, new BluedUIHttpResponse<BluedEntityA<CountModel>>(z2, this, fragmentActive) { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$useBubbleBg$1
            final /* synthetic */ boolean b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ LiveGiftBackpackFragment f13916c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CountModel> bluedEntityA) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                Dialog dialog;
                super.onUIFinish();
                dialog = this.f13916c.P;
                DialogUtils.b(dialog);
            }
        }, getFragmentActive());
        if (z) {
            EventTrackLive.p(LiveProtos.Event.LIVE_CHAT_BUBBLE_USE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        } else {
            EventTrackLive.p(LiveProtos.Event.LIVE_CHAT_BUBBLE_CANCEL, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        }
    }

    private final void U() {
        final LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel == null) {
            return;
        }
        String str = liveGiftModel.goods_id.toString();
        String str2 = liveGiftModel.type.toString();
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.a(str, str2, e, g, new BluedUIHttpResponse<BluedEntityA<Object>>(this, fragmentActive) { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$userProp$1
            final /* synthetic */ LiveGiftBackpackFragment b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                LiveEventBus.get("live_use_prop_success", LiveGiftModel.class).post(LiveGiftModel.this);
                if (bluedEntityA == null || TextUtils.isEmpty(bluedEntityA.message)) {
                    AppMethods.a((CharSequence) "使用成功");
                } else {
                    AppMethods.a((CharSequence) bluedEntityA.message);
                }
                if (this.b.getParentFragment() instanceof LivePocketDialogFragment) {
                    Fragment parentFragment = this.b.getParentFragment();
                    if (parentFragment == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LivePocketDialogFragment");
                    }
                    ((LivePocketDialogFragment) parentFragment).g();
                }
            }
        });
    }

    private final void V() {
        final LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel == null) {
            return;
        }
        String str = liveGiftModel.goods_id.toString();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.j(str, new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$userSkillCard$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (bluedEntityA != null && !TextUtils.isEmpty(bluedEntityA.message)) {
                    AppMethods.a((CharSequence) bluedEntityA.message);
                    return;
                }
                LiveEventBus.get("live_use_prop_success", LiveGiftModel.class).post(LiveGiftModel.this);
                AppMethods.a((CharSequence) "使用成功");
            }
        });
    }

    private final void W() {
        this.ai = false;
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$LJfPmWNOWt7ObpR1Lkfnacnm8mw
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment.q(LiveGiftBackpackFragment.this);
            }
        }, 500L);
    }

    private final void X() {
        LiveGiftFragment I;
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            if (liveGiftModel.ops != 5) {
                LiveGiftModel liveGiftModel2 = this.O;
                Intrinsics.a(liveGiftModel2);
                if (liveGiftModel2.ops != 1101) {
                    LiveGiftModel liveGiftModel3 = this.O;
                    Intrinsics.a(liveGiftModel3);
                    if (liveGiftModel3.ops != 1102) {
                        LiveGiftModel liveGiftModel4 = this.O;
                        Intrinsics.a(liveGiftModel4);
                        if (liveGiftModel4.ops == 1103 || (I = I()) == null) {
                            return;
                        }
                        I.b(this.O);
                    }
                }
            }
        }
    }

    private final void Y() {
        LogUtils.c("GiftCombo.startComboShowAnim: ");
        this.ak = true;
        ViewGroup viewGroup = this.n;
        Intrinsics.a(viewGroup);
        viewGroup.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$lnA1p8Qd2kNHOQIyGZwPKL9MIdA
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment.s(LiveGiftBackpackFragment.this);
            }
        }).start();
        View view = this.R;
        if (view != null) {
            BluedViewExKt.b(view);
            view.setAlpha(1.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        }
        final View view2 = this.T;
        if (view2 != null) {
            view2.setAlpha(0.0f);
            view2.setScaleX(0.0f);
            view2.setScaleY(0.0f);
            view2.animate().alpha(1.0f).scaleX(1.1f).scaleY(1.1f).setDuration(400L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$Yzsnj9rmxcpVj0ilWp7chVFLEv0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveGiftBackpackFragment.a(View.this, this);
                }
            }).start();
        }
        View view3 = this.W;
        if (view3 != null) {
            view3.setTranslationY(0.0f);
        }
        View view4 = this.S;
        if (view4 != null) {
            view4.setAlpha(0.0f);
            view4.animate().alpha(1.0f).setDuration(320L).setStartDelay(200L).start();
        }
        View view5 = this.X;
        if (view5 != null) {
            view5.setAlpha(0.0f);
            view5.setScaleX(0.0f);
            view5.setScaleY(0.0f);
            view5.setTranslationY(0.0f);
            view5.animate().alpha(1.0f).scaleX(1.1f).scaleY(1.1f).setDuration(400L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$IUZ8VAD5Q5wdQFcAaZhLRbZu--s
                @Override // java.lang.Runnable
                public final void run() {
                    LiveGiftBackpackFragment.v(LiveGiftBackpackFragment.this);
                }
            }).start();
        }
        TextView textView = this.Y;
        if (textView != null) {
            textView.setText("1");
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE_SEND_CONTINUE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        this.ak = false;
        this.aj.clear();
        ImageView imageView = this.V;
        if (imageView != null) {
            imageView.clearAnimation();
        }
        View view = this.T;
        if (view != null) {
            view.clearAnimation();
        }
        View view2 = this.R;
        if (view2 != null) {
            BluedViewExKt.a(view2);
        }
        ViewGroup viewGroup = this.n;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f);
        }
        BubbleLayout bubbleLayout = this.aa;
        if (bubbleLayout != null) {
            bubbleLayout.a();
        }
        BubbleLayout bubbleLayout2 = this.aa;
        if (bubbleLayout2 == null) {
            return;
        }
        BluedViewExKt.a(bubbleLayout2);
    }

    private final long a(LiveGiftModel liveGiftModel, int i) {
        LogUtils.c("giftCount = " + i + ", " + liveGiftModel);
        super.e(liveGiftModel, i);
        if (i > 1) {
            liveGiftModel.hit_batch = 1;
            liveGiftModel.hit_count = i;
        } else {
            liveGiftModel.hit_batch = 0;
            liveGiftModel.displayCount = 1;
            if (liveGiftModel.double_hit == 1) {
                liveGiftModel.hit_count++;
            } else {
                liveGiftModel.hit_count = 1;
            }
        }
        if (liveGiftModel.double_hit == 1 && liveGiftModel.hit_batch == 0) {
            liveGiftModel.comboWaitTime = this.l;
            e(liveGiftModel.hit_count);
        }
        this.af = liveGiftModel.hit_id;
        LogUtils.c("after judge, giftCount = " + i + ", " + liveGiftModel);
        return this.af;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2) {
        if (i == 1) {
            return;
        }
        if (i == 2) {
            g(i2);
        } else if (i == 3 && i2 == 1) {
            a(this.O, 0, 1);
        } else if (i == 4 && i2 == 1) {
            a(this.O, 1, 1);
        } else if (i == 5) {
            LiveGiftModel liveGiftModel = this.O;
            Intrinsics.a(liveGiftModel);
            if (liveGiftModel.effect != null) {
                LiveGiftModel liveGiftModel2 = this.O;
                Intrinsics.a(liveGiftModel2);
                LiveGiftModel liveGiftModel3 = this.O;
                Intrinsics.a(liveGiftModel3);
                liveGiftModel2.effectModel = liveGiftModel3.effect.get(i2);
            }
            ah();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface) {
        LiveGiftPayTools.f14162a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
        LiveGiftPayTools.f14162a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View it, final LiveGiftBackpackFragment this$0) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        it.setScaleX(1.0f);
        it.setScaleY(1.0f);
        it.animate().scaleX(1.0f).scaleY(1.0f).setDuration(320L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$u1GbZ82wNMVzwWcl6DQfK6o_JjU
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment.t(LiveGiftBackpackFragment.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TextView it, int i, int i2) {
        Intrinsics.e(it, "$it");
        it.setText(String.valueOf(i));
        it.setScaleX(2.0f);
        it.setScaleY(2.0f);
        it.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(i2 / 2).start();
    }

    private final void a(BaseGiftModel baseGiftModel, boolean z) {
        LogUtils.c("onItemSelected: " + ((Object) baseGiftModel.index) + ", " + z);
        if (isHidden()) {
            return;
        }
        this.ac = "";
        LiveGiftModel liveGiftModel = (LiveGiftModel) baseGiftModel;
        this.O = liveGiftModel;
        if (TypeUtils.a((List<?>) (liveGiftModel == null ? null : liveGiftModel.groups))) {
            LiveGiftModel liveGiftModel2 = this.O;
            if (liveGiftModel2 != null) {
                liveGiftModel2.selectNumModel = null;
            }
        } else {
            LiveGiftModel liveGiftModel3 = this.O;
            List<LiveGiftNumberModel> list = liveGiftModel3 == null ? null : liveGiftModel3.groups;
            Intrinsics.a(list);
            for (LiveGiftNumberModel liveGiftNumberModel : list) {
                if (liveGiftNumberModel.isUserDefined) {
                    liveGiftNumberModel.count = 0;
                }
            }
            LiveGiftModel liveGiftModel4 = this.O;
            Intrinsics.a(liveGiftModel4);
            LiveGiftModel liveGiftModel5 = this.O;
            Intrinsics.a(liveGiftModel5);
            List<LiveGiftNumberModel> list2 = liveGiftModel5.groups;
            LiveGiftModel liveGiftModel6 = this.O;
            List<LiveGiftNumberModel> list3 = liveGiftModel6 == null ? null : liveGiftModel6.groups;
            Intrinsics.a(list3);
            liveGiftModel4.selectNumModel = list2.get(list3.size() - 1);
        }
        ad();
        ae();
        LiveGiftFragment J = J();
        if (J != null) {
            J.b(this.O);
        }
        w();
        Z();
        LogUtils.d("pLog", Intrinsics.a(" item.ops =  ", (Object) Integer.valueOf(liveGiftModel.ops)));
        switch (liveGiftModel.ops) {
            case 16:
            case 23:
                if (D().getCurrentItem() != 2) {
                    return;
                }
                ViewGroup viewGroup = this.n;
                Intrinsics.a(viewGroup);
                viewGroup.setVisibility(0);
                ViewGroup viewGroup2 = this.n;
                Intrinsics.a(viewGroup2);
                viewGroup2.setBackgroundResource(R.color.transparent);
                c(true);
                if (liveGiftModel.is_use == 1) {
                    TextView textView = this.y;
                    if (textView == null) {
                        return;
                    }
                    textView.setText("取消佩戴");
                    return;
                }
                TextView textView2 = this.y;
                if (textView2 == null) {
                    return;
                }
                textView2.setText("佩戴");
                return;
            case 17:
            case 21:
                if (D().getCurrentItem() != 2) {
                    return;
                }
                c(true);
                ViewGroup viewGroup3 = this.n;
                Intrinsics.a(viewGroup3);
                viewGroup3.setVisibility(0);
                ViewGroup viewGroup4 = this.n;
                Intrinsics.a(viewGroup4);
                viewGroup4.setBackgroundResource(R.color.transparent);
                if (liveGiftModel.is_use == 1) {
                    TextView textView3 = this.y;
                    if (textView3 == null) {
                        return;
                    }
                    textView3.setText("取消佩戴");
                    return;
                }
                TextView textView4 = this.y;
                if (textView4 == null) {
                    return;
                }
                textView4.setText("佩戴");
                return;
            case 18:
                if (D().getCurrentItem() != 2) {
                    return;
                }
                c(true);
                ViewGroup viewGroup5 = this.n;
                Intrinsics.a(viewGroup5);
                viewGroup5.setVisibility(0);
                ViewGroup viewGroup6 = this.n;
                Intrinsics.a(viewGroup6);
                viewGroup6.setBackgroundResource(R.color.transparent);
                if (liveGiftModel.is_use == 1) {
                    TextView textView5 = this.y;
                    if (textView5 == null) {
                        return;
                    }
                    textView5.setText("取消使用");
                    return;
                }
                TextView textView6 = this.y;
                if (textView6 == null) {
                    return;
                }
                textView6.setText("使用");
                return;
            case 19:
                if (D().getCurrentItem() != 0) {
                    return;
                }
                c(true);
                ViewGroup viewGroup7 = this.n;
                Intrinsics.a(viewGroup7);
                viewGroup7.setVisibility(0);
                TextView textView7 = this.y;
                if (textView7 != null) {
                    textView7.setText(getString(R.string.live_give_gift));
                }
                LinearLayout linearLayout = this.B;
                Intrinsics.a(linearLayout);
                linearLayout.setVisibility(0);
                ViewGroup viewGroup8 = this.n;
                Intrinsics.a(viewGroup8);
                viewGroup8.setBackgroundResource(R.drawable.live_gift_switcher_bg);
                return;
            case 20:
                if (D().getCurrentItem() != 1) {
                    return;
                }
                LiveGiftModel liveGiftModel7 = this.O;
                if (liveGiftModel7 != null && liveGiftModel7.is_use == 1) {
                    return;
                }
                c(true);
                ViewGroup viewGroup9 = this.n;
                Intrinsics.a(viewGroup9);
                viewGroup9.setVisibility(0);
                ViewGroup viewGroup10 = this.n;
                Intrinsics.a(viewGroup10);
                viewGroup10.setBackgroundResource(R.color.transparent);
                TextView textView8 = this.y;
                if (textView8 != null) {
                    textView8.setText("使用");
                }
                EventTrackLive.p(LiveProtos.Event.LIVE_GIFT_COUPON_PAGE_ONE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
                return;
            case 22:
                if (baseGiftModel.count < liveGiftModel.consume) {
                    ViewGroup viewGroup11 = this.n;
                    Intrinsics.a(viewGroup11);
                    viewGroup11.setBackgroundResource(R.color.transparent);
                    ViewGroup viewGroup12 = this.n;
                    Intrinsics.a(viewGroup12);
                    viewGroup12.setVisibility(8);
                    return;
                }
                c(true);
                ViewGroup viewGroup13 = this.n;
                Intrinsics.a(viewGroup13);
                viewGroup13.setVisibility(0);
                ViewGroup viewGroup14 = this.n;
                Intrinsics.a(viewGroup14);
                viewGroup14.setBackgroundResource(R.color.transparent);
                TextView textView9 = this.y;
                if (textView9 == null) {
                    return;
                }
                textView9.setText("合成");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0, int i, String str) {
        Intrinsics.e(this$0, "this$0");
        LiveGiftModel liveGiftModel = this$0.O;
        Intrinsics.a(liveGiftModel);
        if (liveGiftModel.effect != null) {
            LiveGiftModel liveGiftModel2 = this$0.O;
            Intrinsics.a(liveGiftModel2);
            LiveGiftModel liveGiftModel3 = this$0.O;
            Intrinsics.a(liveGiftModel3);
            liveGiftModel2.effectModel = liveGiftModel3.effect.get(i);
        }
        this$0.a(2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.af();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ViewGroup viewGroup;
        Intrinsics.e(this$0, "this$0");
        ImageView imageView = this$0.p;
        if (imageView == null || (viewGroup = this$0.v) == null) {
            return;
        }
        int i9 = viewGroup.getWidth() < imageView.getWidth() ? 0 : LiveRoomManager.a().p().rechargeGiftBagIconShowType;
        LiveGiftPresenter liveGiftPresenter = (LiveGiftPresenter) this$0.j();
        ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        liveGiftPresenter.a(i9, imageView, fragmentActive, this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0, BasePayRemaining remaining) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(remaining, "remaining");
        this$0.b(remaining);
        if (remaining.text != null) {
            if (TextUtils.isEmpty(remaining.text.sums)) {
                TextView textView = this$0.u;
                if (textView == null) {
                    return;
                }
                textView.setText(this$0.F());
                return;
            }
            TextView textView2 = this$0.u;
            if (textView2 == null) {
                return;
            }
            textView2.setText(remaining.text.sums);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0, LiveGiftBackpackModel liveGiftBackpackModel) {
        Intrinsics.e(this$0, "this$0");
        if (liveGiftBackpackModel == null) {
            return;
        }
        this$0.F = liveGiftBackpackModel;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<LiveGiftBackpackTabsModel> it = liveGiftBackpackModel.getTabs().iterator();
        while (it.hasNext()) {
            LiveGiftBackpackTabsModel next = it.next();
            LiveGiftPackageModel liveGiftPackageModel = new LiveGiftPackageModel();
            liveGiftPackageModel.name = next.getName();
            liveGiftPackageModel.hasNew = next.getRed_point() == 1;
            liveGiftPackageModel.red_point = next.getRed_point();
            liveGiftPackageModel.red_point_cancel = next.getRed_point_cancel();
            if (next.getRed_point() == 1) {
                LiveGiftBagRedDotControlManager.f13644a.a().a(next.getRed_point_word());
            }
            liveGiftPackageModel.red_point_word = next.getRed_point_word();
            liveGiftPackageModel.type_name = next.getKey();
            String key = next.getKey();
            if (Intrinsics.a((Object) key, (Object) "gifts") ? true : Intrinsics.a((Object) key, (Object) "fragment")) {
                liveGiftPackageModel.showQuestion = false;
            } else {
                liveGiftPackageModel.showQuestion = true;
            }
            arrayList.add(liveGiftPackageModel);
            BaseFragment a2 = this$0.a(liveGiftPackageModel);
            this$0.ab.put(next.getKey(), (LiveGiftBackpackItemFragment) a2);
            arrayList2.add(a2);
        }
        this$0.E.clear();
        this$0.E.addAll(arrayList);
        this$0.C().setData(arrayList);
        this$0.I.clear();
        this$0.I.addAll(arrayList2);
        LiveVp2Adapter E = this$0.E();
        if (E != null) {
            E.notifyDataSetChanged();
        }
        if (this$0.B()) {
            this$0.W();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0, LiveGiftModel liveGiftModel) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(liveGiftModel, "liveGiftModel");
        this$0.a((BaseGiftModel) liveGiftModel, true);
        LiveGiftBackpackItemObserver.f13929a.a().a(liveGiftModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0, Boolean status) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(status, "status");
        this$0.d(status.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBackpackFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        LiveGiftPresenter liveGiftPresenter = (LiveGiftPresenter) this$0.j();
        Intrinsics.a(num);
        int intValue = num.intValue();
        ImageView imageView = this$0.p;
        ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        liveGiftPresenter.a(intValue, imageView, fragmentActive, this$0);
    }

    private final void a(LiveGiftModel liveGiftModel) {
        LiveGiftPayTools.b();
        if (LiveGiftPayTools.f14162a) {
            return;
        }
        LiveGiftFragment J = J();
        Intrinsics.a(J);
        if (J.getFragmentActive() != null) {
            LiveGiftFragment J2 = J();
            Intrinsics.a(J2);
            if (J2.getFragmentActive().isActive()) {
                String string = getString(R.string.Live_SendPresent_notEnoughWandou);
                Intrinsics.c(string, "getString(R.string.Live_…dPresent_notEnoughWandou)");
                String str = string;
                if (liveGiftModel.effect != null) {
                    str = string;
                    if (liveGiftModel.effect.size() > 0) {
                        str = getString(R.string.Live_effect_not_enough);
                        Intrinsics.c(str, "getString(R.string.Live_effect_not_enough)");
                    }
                }
                LiveGiftPayTools.f14162a = true;
                CommonAlertDialog.a((Context) getActivity(), (View) null, "", str, getString(R.string.cancel), getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$MMFdI5XVjQPz0_Hq-nIYe6icHYE
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        LiveGiftBackpackFragment.b(LiveGiftBackpackFragment.this, dialogInterface, i);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$pJN7FdwKLYUHVh3Wv5xTssZN808
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        LiveGiftBackpackFragment.a(dialogInterface, i);
                    }
                }, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$kyw1nJ8YlY57WUfXZ-6WLP-q6T0
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        LiveGiftBackpackFragment.a(dialogInterface);
                    }
                }, true);
            }
        }
    }

    private final void a(final LiveGiftModel liveGiftModel, int i, final int i2) {
        if (liveGiftModel == null) {
            return;
        }
        liveGiftModel.sendGiftStatus = 1;
        String str = liveGiftModel.goods_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.a(str, i, new BluedUIHttpResponse<BluedEntityA<LiveGiftModel>>(i2, this, fragmentActive) { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$equipEffectGift$1
            final /* synthetic */ int b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ LiveGiftBackpackFragment f13903c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGiftModel> bluedEntityA) {
                TextView textView;
                TextView textView2;
                LiveGiftModel.this.sendGiftStatus = 0;
                if (this.b == 1) {
                    ToastUtils.a("装备成功");
                    textView2 = this.f13903c.y;
                    if (textView2 != null) {
                        textView2.setText("取下");
                    }
                } else {
                    ToastUtils.a("取消装备成功");
                    textView = this.f13903c.y;
                    if (textView != null) {
                        textView.setText("装备");
                    }
                }
                LiveGiftModel.this.is_use = this.b;
                LiveEventBus.get("live_equip_effect_gift", LiveGiftModel.class).post(LiveGiftModel.this);
                LiveGiftBackpackItemObserver.f13929a.a().a(LiveGiftModel.this, 16, this.b);
            }
        });
        if (i2 == 0) {
            EventTrackLive.p(LiveProtos.Event.LIVE_GIFT_POP_DRESS_TAB_CAR_CANCEL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        } else {
            EventTrackLive.p(LiveProtos.Event.LIVE_GIFT_POP_DRESS_TAB_CAR_USE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(LiveGiftModel liveGiftModel, int i, int i2, String str) {
        LogUtils.c("buyGiftFail: " + liveGiftModel + ", giftCount:" + i + ", errorCode:" + i2 + ", errorMessage:" + ((Object) str));
        liveGiftModel.sendGiftStatus = 2;
        StringBuilder sb = new StringBuilder();
        sb.append("buyGiftFail: ");
        sb.append(i2);
        sb.append(", msg: ");
        sb.append((Object) str);
        LogUtils.c(sb.toString());
        switch (i2) {
            case 4221002:
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected_model", liveGiftModel);
                bundle.putInt("gift_count", i);
                bundle.putString("title", getString(R.string.Live_SendPresent_resetPayPassword));
                bundle.putString("content", getString(R.string.live_set_6_num));
                bundle.putString("http_host", LiveRoomInfo.a().m());
                LiveRouteUtil.a(this, bundle, i2);
                return;
            case 4221003:
            case 4221006:
            case 4221007:
            default:
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                AppMethods.a((CharSequence) str2);
                liveGiftModel.errorMessage = str;
                return;
            case 4221004:
            case 4221005:
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("selected_model", liveGiftModel);
                bundle2.putInt("gift_count", i);
                if (i2 == 4221005) {
                    bundle2.putString("title", getString(R.string.Live_SendPresent_verifyPassword));
                } else {
                    bundle2.putString("title", str);
                }
                bundle2.putString("content", getString(R.string.Live_SendPresent_verifyPasswordText));
                LiveRouteUtil.a(this, bundle2, i2);
                return;
            case 4221008:
                a(liveGiftModel);
                return;
        }
    }

    private final void a(final LiveGiftModel liveGiftModel, final int i, String str, boolean z) {
        if (liveGiftModel == null) {
            return;
        }
        LogUtils.c("buyGift.selectedModel: " + liveGiftModel + ", gifCount:" + i + ", payCode:" + str + ", payToken:" + ((Object) LiveRoomPreferences.b("")) + ", remember_me:" + z);
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(fragmentActive) { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$buyGift$response$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i2, String str2) {
                LiveGiftFragment I;
                super.onFailure(th, i2, str2);
                I = LiveGiftBackpackFragment.this.I();
                if (I == null) {
                    return;
                }
                I.e(str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str2) {
                if (isActive()) {
                    KeyboardUtils.a(LiveGiftBackpackFragment.this.getActivity());
                    LiveGiftBackpackFragment.this.a(liveGiftModel, i, i2, str2);
                    return true;
                }
                return false;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> bluedEntity) {
                if (isActive()) {
                    KeyboardUtils.a(LiveGiftBackpackFragment.this.getActivity());
                    if (bluedEntity == null || bluedEntity.getSingleData() == null) {
                        LiveGiftBackpackFragment.this.a(liveGiftModel, i, 0, (String) null);
                        return;
                    }
                    LiveGiftBackpackFragment.this.a(bluedEntity.getSingleData(), liveGiftModel, bluedEntity.extra, i);
                }
            }
        };
        LiveRoomHttpUtils.a(LiveRoomManager.a().g(), LiveRoomManager.a().e(), liveGiftModel, "", str, TextUtils.isEmpty(str) ? LiveRoomPreferences.b("") : "", z, i, N(), bluedUIHttpResponse, getFragmentActive());
    }

    private final void a(LiveGiftModel liveGiftModel, PayRemaining payRemaining, LiveZanExtraModel liveZanExtraModel, int i) {
        LiveGiftModel liveGiftModel2;
        liveGiftModel.sendGiftStatus = 3;
        liveGiftModel.hit_id = payRemaining.hit_id;
        liveGiftModel.beans_count = payRemaining.beans_count;
        liveGiftModel.beans_current_count = payRemaining.beans_current;
        liveGiftModel.free_number = payRemaining.free_number;
        liveGiftModel.bonus = payRemaining.bonus;
        liveGiftModel.animation = payRemaining.animation;
        if (liveZanExtraModel != null) {
            LogUtils.c(Intrinsics.a("updateGiftValue: ", (Object) liveZanExtraModel));
            String str = liveZanExtraModel.expire_info;
            if (!(str == null || str.length() == 0)) {
                liveGiftModel.expire_info = liveZanExtraModel.expire_info;
            }
            if (liveZanExtraModel.skin_on_process != null && liveZanExtraModel.skin_on_process.goods_id != null) {
                liveGiftModel.skin_on_process = liveZanExtraModel.skin_on_process;
            }
            if (this.O != null && liveZanExtraModel.skin_on_process != null) {
                LiveGiftModel liveGiftModel3 = this.O;
                Intrinsics.a(liveGiftModel3);
                if (StringUtils.a(liveGiftModel3.goods_id, liveGiftModel.goods_id) && liveZanExtraModel.skin_on_process.goods_id != null) {
                    LiveGiftModel liveGiftModel4 = this.O;
                    Intrinsics.a(liveGiftModel4);
                    liveGiftModel4.skin_on_process = liveZanExtraModel.skin_on_process;
                }
            }
            LiveGiftModel liveGiftModel5 = this.O;
            if (liveGiftModel5 != null) {
                Intrinsics.a(liveGiftModel5);
                if (liveGiftModel5.skin_on_use != null && (liveGiftModel2 = this.O) != null) {
                    Intrinsics.a(liveGiftModel2);
                    StringUtils.a(liveGiftModel2.goods_id, liveGiftModel.goods_id);
                }
            }
            liveGiftModel.user_store_count = liveZanExtraModel.user_store_count;
            liveGiftModel.danmu_count = liveZanExtraModel.danmu_count;
        }
        LiveGiftBackpackItemObserver.f13929a.a().a(liveGiftModel, 19);
        if (LiveRoomManager.a().q() != null && LiveRoomManager.a().q().fans_status == 2 && liveGiftModel.beans_count >= 6.0d) {
            LiveFansObserver.a().d();
        }
        LogUtils.c(Intrinsics.a("after updateGiftValue: ", (Object) liveGiftModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(PayRemaining payRemaining, LiveGiftModel liveGiftModel, LiveZanExtraModel liveZanExtraModel, int i) {
        LiveGiftFragment I;
        LiveGiftAdvancedModel liveGiftAdvancedModel;
        if (payRemaining == null) {
            return;
        }
        LogUtils.c(Intrinsics.a("buyGiftSuccess: ", (Object) payRemaining));
        if (!TextUtils.isEmpty(payRemaining.token)) {
            LiveRoomPreferences.c(payRemaining.token);
        }
        LiveEventBus.get("send_gift_success").post(true);
        Intrinsics.a(liveZanExtraModel);
        liveGiftModel.bg_color = liveZanExtraModel.bg_color;
        liveGiftModel.bg_img = liveZanExtraModel.bg_img;
        liveGiftModel.avatar_frame_url = liveZanExtraModel.avatar_frame_url;
        a(liveGiftModel, payRemaining, liveZanExtraModel, i);
        a(payRemaining);
        if ((liveGiftModel.ops == 13 || liveGiftModel.ops == 19) && liveZanExtraModel.goods != null && liveZanExtraModel.goods.size() >= 2) {
            a(liveGiftModel, i);
            LiveGiftFragment I2 = I();
            if (I2 != null) {
                I2.a(payRemaining, liveGiftModel, liveZanExtraModel, i);
            }
        } else if (liveGiftModel.ops == 16) {
            AppMethods.d(R.string.live_effect_renew_finish);
            this.ai = true;
            H();
        } else {
            a(liveGiftModel, i);
            if (liveGiftModel.ops != 15 || TypeUtils.a((List<?>) liveGiftModel.advance_list)) {
                List<LiveImgModel> list = liveZanExtraModel.lantern_image;
                if (!(list != null ? list.isEmpty() : true)) {
                    LiveBunchLightModel liveBunchLightModel = new LiveBunchLightModel();
                    ArrayList<String> arrayList = new ArrayList<>();
                    List<LiveImgModel> list2 = liveZanExtraModel.lantern_image;
                    Intrinsics.c(list2, "zanExtraModel.lantern_image");
                    for (LiveImgModel liveImgModel : list2) {
                        arrayList.add(liveImgModel.getImg());
                    }
                    liveBunchLightModel.setImage(arrayList);
                    liveBunchLightModel.setPlay_times(liveZanExtraModel.lantern_play_times);
                    liveGiftModel.bunchLightModel = liveBunchLightModel;
                }
                if (!liveZanExtraModel.behalf_bind_status) {
                    LiveMsgSendManager.a().a(liveGiftModel);
                }
            } else {
                LiveGiftModel liveGiftModel2 = new LiveGiftModel();
                ReflectionUtils.a(liveGiftModel, liveGiftModel2);
                Iterator<LiveGiftAdvancedModel> it = liveGiftModel.advance_list.iterator();
                do {
                    liveGiftAdvancedModel = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    liveGiftAdvancedModel = it.next();
                    if (liveGiftModel.hit_count <= liveGiftAdvancedModel.count) {
                        break;
                    }
                } while (!liveGiftAdvancedModel.is_max);
                if (liveGiftAdvancedModel != null) {
                    LogUtils.c("连击数： " + liveGiftModel.hit_count + " 使用" + liveGiftAdvancedModel);
                    liveGiftModel2.images_gif = liveGiftAdvancedModel.images_gif;
                    liveGiftModel2.images_apng2 = liveGiftAdvancedModel.images_apng;
                    liveGiftModel2.images_mp4 = liveGiftAdvancedModel.images_mp4;
                }
                List<LiveImgModel> list3 = liveZanExtraModel.lantern_image;
                if (!(list3 != null ? list3.isEmpty() : true)) {
                    LiveBunchLightModel liveBunchLightModel2 = new LiveBunchLightModel();
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    List<LiveImgModel> list4 = liveZanExtraModel.lantern_image;
                    Intrinsics.c(list4, "zanExtraModel.lantern_image");
                    for (LiveImgModel liveImgModel2 : list4) {
                        arrayList2.add(liveImgModel2.getImg());
                    }
                    liveBunchLightModel2.setImage(arrayList2);
                    liveBunchLightModel2.setPlay_times(liveZanExtraModel.lantern_play_times);
                    liveGiftModel2.bunchLightModel = liveBunchLightModel2;
                }
                if (!liveZanExtraModel.behalf_bind_status) {
                    LiveMsgSendManager.a().a(liveGiftModel2);
                }
            }
        }
        LiveGiftModel liveGiftModel3 = liveGiftModel;
        this.ah = liveGiftModel3;
        f(liveGiftModel3, i);
        LiveEventBus.get("live_update_item_gift", LiveGiftModel.class).post(liveGiftModel);
        if (liveGiftModel.ops == 16 || (I = I()) == null) {
            return;
        }
        I.b((CommonLiveGiftModel) liveGiftModel3);
    }

    private final void aa() {
        if (this.ak) {
            return;
        }
        View view = this.R;
        boolean z = false;
        if (view != null && view.getVisibility() == 8) {
            z = true;
        }
        if (z) {
            return;
        }
        this.al = true;
        this.aj.clear();
        ImageView imageView = this.V;
        if (imageView != null) {
            imageView.clearAnimation();
        }
        View view2 = this.T;
        if (view2 != null) {
            view2.clearAnimation();
        }
        BubbleLayout bubbleLayout = this.aa;
        if (bubbleLayout != null) {
            bubbleLayout.a();
        }
        BubbleLayout bubbleLayout2 = this.aa;
        if (bubbleLayout2 != null) {
            BluedViewExKt.a(bubbleLayout2);
        }
        View view3 = this.R;
        if (view3 != null) {
            view3.setAlpha(1.0f);
        }
        View view4 = this.R;
        if (view4 != null) {
            view4.setScaleY(1.0f);
        }
        View view5 = this.R;
        if (view5 != null) {
            view5.setScaleY(1.0f);
        }
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.85f));
        animationSet.setDuration(320L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$disComboLayoutAnim$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view6;
                ConcurrentLinkedQueue concurrentLinkedQueue;
                ConcurrentLinkedQueue concurrentLinkedQueue2;
                ConcurrentLinkedQueue concurrentLinkedQueue3;
                Intrinsics.e(animation, "animation");
                view6 = LiveGiftBackpackFragment.this.R;
                if (view6 != null) {
                    BluedViewExKt.a(view6);
                }
                LiveGiftBackpackFragment.this.al = false;
                concurrentLinkedQueue = LiveGiftBackpackFragment.this.aj;
                LogUtils.c(Intrinsics.a("GiftCombo.disComboLayoutAnim.end: ", (Object) Integer.valueOf(concurrentLinkedQueue.size())));
                concurrentLinkedQueue2 = LiveGiftBackpackFragment.this.aj;
                if (concurrentLinkedQueue2.isEmpty()) {
                    return;
                }
                LiveGiftBackpackFragment liveGiftBackpackFragment = LiveGiftBackpackFragment.this;
                concurrentLinkedQueue3 = liveGiftBackpackFragment.aj;
                liveGiftBackpackFragment.e(CommonStringUtils.a((String) concurrentLinkedQueue3.poll()));
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        View view6 = this.R;
        if (view6 != null) {
            view6.startAnimation(animationSet);
        }
        ViewGroup viewGroup = this.n;
        if (viewGroup != null) {
            BluedViewExKt.b(viewGroup);
            viewGroup.setAlpha(0.0f);
            viewGroup.animate().alpha(1.0f).setDuration(320L).start();
        }
        LogUtils.c("GiftCombo.disComboLayoutAnim");
    }

    private final void ab() {
        View view = this.T;
        if (view != null) {
            if (view.getAnimation() != null) {
                view.getAnimation().reset();
                view.getAnimation().cancel();
            }
            view.clearAnimation();
        }
        ImageView imageView = this.V;
        if (imageView != null) {
            if (imageView.getAnimation() != null) {
                imageView.getAnimation().reset();
                imageView.getAnimation().cancel();
            }
            imageView.clearAnimation();
        }
        final View view2 = this.T;
        if (view2 == null) {
            return;
        }
        view2.setScaleX(1.0f);
        view2.setScaleY(1.0f);
        view2.animate().scaleX(0.7f).scaleY(0.7f).setDuration(120L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$qla6H8jKrbabhf6c2c9rZVeY_Hw
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment.b(View.this, this);
            }
        }).start();
    }

    private final void ac() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setDuration(320L);
        View view = this.T;
        Intrinsics.a(view);
        view.startAnimation(scaleAnimation);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        ImageView imageView = this.V;
        Intrinsics.a(imageView);
        imageView.startAnimation(rotateAnimation);
    }

    private final void ad() {
        TextView textView = this.A;
        if (textView != null) {
            textView.setText(String.valueOf(b()));
        }
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            if (liveGiftModel.selectNumModel != null) {
                TextView textView2 = this.A;
                Intrinsics.a(textView2);
                textView2.setTextColor(getResources().getColor(R.color.syc_dark_b));
                this.f13894a.setAlpha(1.0f);
                return;
            }
        }
        TextView textView3 = this.A;
        Intrinsics.a(textView3);
        textView3.setTextColor(Color.parseColor("#8A8A8A"));
        this.f13894a.setAlpha(0.15f);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void ae() {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment.ae():void");
    }

    private final void af() {
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            if (TypeUtils.a((List<?>) liveGiftModel.groups)) {
                return;
            }
            int b = b();
            ArrayList arrayList = new ArrayList();
            LiveGiftModel liveGiftModel2 = this.O;
            Intrinsics.a(liveGiftModel2);
            for (LiveGiftNumberModel model : liveGiftModel2.groups) {
                model.selected = model.count == b;
                Intrinsics.c(model, "model");
                arrayList.add(model);
            }
            a(arrayList);
        }
    }

    private final void ag() {
        LiveGiftModel liveGiftModel;
        LiveGiftModel liveGiftModel2 = this.O;
        if (liveGiftModel2 != null) {
            Intrinsics.a(liveGiftModel2);
            if (liveGiftModel2.ops != 5) {
                LiveGiftModel liveGiftModel3 = this.O;
                Intrinsics.a(liveGiftModel3);
                if (LiveTimeAndDateUtils.a(liveGiftModel3.expire_time) > 1827590400000L) {
                    AppMethods.d(R.string.live_effect_already_has);
                    return;
                }
                LiveGiftModel liveGiftModel4 = this.O;
                Intrinsics.a(liveGiftModel4);
                if (liveGiftModel4.is_renewal == 1) {
                    LiveGiftModel liveGiftModel5 = this.O;
                    Intrinsics.a(liveGiftModel5);
                    List<LiveEffectModel> list = liveGiftModel5.effect;
                    if (!(list == null || list.isEmpty())) {
                        LiveGiftModel liveGiftModel6 = this.O;
                        Intrinsics.a(liveGiftModel6);
                        int size = liveGiftModel6.effect.size();
                        String[] strArr = new String[size];
                        LiveGiftModel liveGiftModel7 = this.O;
                        Intrinsics.a(liveGiftModel7);
                        int size2 = liveGiftModel7.effect.size();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size2) {
                                break;
                            }
                            LiveGiftModel liveGiftModel8 = this.O;
                            Intrinsics.a(liveGiftModel8);
                            long j = liveGiftModel8.effect.get(i2).expire;
                            Intrinsics.a(this.O);
                            String a2 = CommonStringUtils.a(liveGiftModel.effect.get(i2).beans);
                            StringBuilder sb = new StringBuilder();
                            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                            String string = getResources().getString(R.string.bug_1_months);
                            Intrinsics.c(string, "resources.getString(R.string.bug_1_months)");
                            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(j)}, 1));
                            Intrinsics.c(format, "format(format, *args)");
                            sb.append(format);
                            sb.append('(');
                            sb.append((Object) a2);
                            sb.append(getResources().getString(R.string.Live_SendPresent_wandou));
                            sb.append(')');
                            strArr[i2] = sb.toString();
                            i = i2 + 1;
                        }
                        int[] iArr = new int[size];
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= size) {
                                break;
                            }
                            iArr[i4] = R.color.sara_a;
                            i3 = i4 + 1;
                        }
                        if (LiveDataManager.a().f()) {
                            PopActionSheet.a(getContext(), strArr, iArr, DensityUtils.a(getContext(), 300.0f), new PopActionSheet.PopSheetClickListner() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$ESKwPela4vOjlzZ5HwUcgpGa9gM
                                @Override // com.blued.android.module.live_china.view.PopActionSheet.PopSheetClickListner
                                public final void onClick(int i5, String str) {
                                    LiveGiftBackpackFragment.a(LiveGiftBackpackFragment.this, i5, str);
                                }
                            });
                            return;
                        } else {
                            CommonShowBottomWindow.a(getActivity(), strArr, this.K, new ActionSheet.ActionSheetListener() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$onClickRenew$2
                                @Override // com.blued.android.module.media.selector.view.ActionSheet.ActionSheetListener
                                public void a(ActionSheet actionSheet, int i5) {
                                    LiveGiftModel liveGiftModel9;
                                    LiveGiftModel liveGiftModel10;
                                    LiveGiftModel liveGiftModel11;
                                    Intrinsics.e(actionSheet, "actionSheet");
                                    liveGiftModel9 = LiveGiftBackpackFragment.this.O;
                                    Intrinsics.a(liveGiftModel9);
                                    if (liveGiftModel9.effect != null) {
                                        liveGiftModel10 = LiveGiftBackpackFragment.this.O;
                                        Intrinsics.a(liveGiftModel10);
                                        liveGiftModel11 = LiveGiftBackpackFragment.this.O;
                                        Intrinsics.a(liveGiftModel11);
                                        liveGiftModel10.effectModel = liveGiftModel11.effect.get(i5);
                                    }
                                    LiveGiftBackpackFragment.this.a(2, i5);
                                }

                                @Override // com.blued.android.module.media.selector.view.ActionSheet.ActionSheetListener
                                public void a(ActionSheet actionSheet, boolean z) {
                                    Intrinsics.e(actionSheet, "actionSheet");
                                }
                            });
                            return;
                        }
                    }
                }
                AppMethods.d(R.string.live_effect_unable_renew);
                return;
            }
        }
        AppMethods.d(R.string.live_effect_unable_renew);
    }

    private final void ah() {
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            if (liveGiftModel.effectModel == null) {
                return;
            }
            FragmentActivity activity = getActivity();
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string = getString(R.string.verify_renew_mounts);
            Intrinsics.c(string, "getString(R.string.verify_renew_mounts)");
            LiveGiftModel liveGiftModel2 = this.O;
            Intrinsics.a(liveGiftModel2);
            long j = liveGiftModel2.effectModel.expire;
            LiveGiftModel liveGiftModel3 = this.O;
            Intrinsics.a(liveGiftModel3);
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(j), liveGiftModel3.name}, 2));
            Intrinsics.c(format, "format(format, *args)");
            CommonAlertDialog.a(activity, "", format, getString(R.string.verify_renew), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$yaiOEkm-UGEUpq4a7-hsOHpbDsQ
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    LiveGiftBackpackFragment.c(LiveGiftBackpackFragment.this, dialogInterface, i);
                }
            }, getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void ai() {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment.ai():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View it, final LiveGiftBackpackFragment this$0) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        it.animate().scaleX(1.0f).scaleY(1.0f).setDuration(160L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$J8MTa-hjwXDVr2IE4lIWVMUILqY
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment.x(LiveGiftBackpackFragment.this);
            }
        }).start();
    }

    private final void b(BasePayRemaining basePayRemaining) {
        TextView textView = this.t;
        if (textView != null) {
            textView.setText(CommonStringUtils.d(String.valueOf(LiveDataManager.a().d() + (basePayRemaining == null ? 0L : basePayRemaining.bonus))));
        }
        Long valueOf = basePayRemaining == null ? null : Long.valueOf(basePayRemaining.bonus);
        Intrinsics.a(valueOf);
        if (valueOf.longValue() <= 0) {
            TextView textView2 = this.o;
            if (textView2 == null) {
                return;
            }
            BluedViewExKt.a(textView2);
            return;
        }
        TextView textView3 = this.o;
        if (textView3 != null) {
            BluedViewExKt.b(textView3);
        }
        TextView textView4 = this.o;
        if (textView4 == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = getResources().getString(R.string.live_contain);
        Intrinsics.c(string, "resources.getString(R.string.live_contain)");
        String format = String.format(string, Arrays.copyOf(new Object[]{CommonStringUtils.d(String.valueOf(basePayRemaining.bonus))}, 1));
        Intrinsics.c(format, "format(format, *args)");
        sb.append(format);
        sb.append(')');
        textView4.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGiftBackpackFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        if (LiveDataManager.a().f()) {
            if (this$0.J() != null) {
                LiveGiftFragment J = this$0.J();
                Intrinsics.a(J);
                J.finish();
            }
            LiveRoomInfo.a().a(this$0.getActivity(), 2);
        } else {
            LiveRoomInfo.a().a(this$0.getActivity(), this$0.getFragmentManager(), 2);
        }
        LiveGiftPayTools.f14162a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGiftBackpackFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGiftBackpackFragment this$0, Boolean status) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(status, "status");
        this$0.c(status.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGiftBackpackFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        if (num == null) {
            return;
        }
        this$0.D().setCurrentItem(num.intValue());
        this$0.b(num.intValue());
        this$0.a(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGiftBackpackFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveGiftBackpackFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.ai();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveGiftBackpackFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FrameLayout frameLayout = this$0.r;
        if (frameLayout == null) {
            return;
        }
        BluedViewExKt.a(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveGiftBackpackFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == -1295475133) {
                if (str.equals("equips")) {
                    this$0.d(2);
                }
            } else if (hashCode == 3172656) {
                str.equals("gift");
            } else if (hashCode == 106940784 && str.equals("props")) {
                this$0.d(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int i) {
        LiveGiftBagRedDotControlManager.f13644a.a().b(C().getAdapter().getDataList().get(i).red_point_word);
        C().getAdapter().getDataList().get(i).hasNew = false;
        C().getAdapter().getDataList().get(i).red_point_cancel = 0;
        LiveRoomHttpUtils.b((BluedUIHttpResponse) null, C().getAdapter().getDataList().get(i).red_point_word);
        C().getAdapter().notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveGiftBackpackFragment this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.c(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveGiftBackpackFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveGiftModel liveGiftModel = this$0.O;
        if (liveGiftModel == null) {
            return;
        }
        Intrinsics.a(liveGiftModel);
        if (liveGiftModel.ops != 5) {
            LiveGiftModel liveGiftModel2 = this$0.O;
            Intrinsics.a(liveGiftModel2);
            if (liveGiftModel2.ops != 1101) {
                LiveGiftModel liveGiftModel3 = this$0.O;
                Intrinsics.a(liveGiftModel3);
                if (liveGiftModel3.double_hit == 1) {
                    this$0.ab();
                    this$0.M();
                }
            }
        }
    }

    private final void d(String str) {
        if (str == null) {
            return;
        }
        Object[] array = StringsKt.b((CharSequence) str, new String[]{BridgeUtil.UNDERLINE_STR}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        String[] strArr = (String[]) array;
        if (strArr.length < 2) {
            return;
        }
        int parseInt = Integer.parseInt(strArr[1]);
        String str2 = strArr[0];
        Context context = null;
        if (Intrinsics.a((Object) str2, (Object) "道具")) {
            ImageView imageView = this.s;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.img_live_props_qa_tips);
            }
            FrameLayout frameLayout = this.r;
            if (frameLayout != null) {
                ImageView imageView2 = this.s;
                if (imageView2 != null) {
                    context = imageView2.getContext();
                }
                frameLayout.setPadding(parseInt - DisplayUtil.a(context, 63.0f), 0, 0, 0);
            }
            FrameLayout frameLayout2 = this.r;
            if (frameLayout2 == null) {
                return;
            }
            BluedViewExKt.b(frameLayout2);
        } else if (!Intrinsics.a((Object) str2, (Object) "装扮")) {
            FrameLayout frameLayout3 = this.r;
            if (frameLayout3 == null) {
                return;
            }
            BluedViewExKt.a(frameLayout3);
        } else {
            ImageView imageView3 = this.s;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.img_live_dress_qa_tips);
            }
            FrameLayout frameLayout4 = this.r;
            if (frameLayout4 != null) {
                ImageView imageView4 = this.s;
                frameLayout4.setPadding(parseInt - DisplayUtil.a(imageView4 == null ? null : imageView4.getContext(), 68.0f), 0, 0, 0);
            }
            FrameLayout frameLayout5 = this.r;
            if (frameLayout5 == null) {
                return;
            }
            BluedViewExKt.b(frameLayout5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int i) {
        Animation animation;
        if (i == 1) {
            if (this.al) {
                LogUtils.c("GiftCombo.isDisComboLayoutAnim = true, wait finish");
                View view = this.R;
                if ((view == null ? null : view.getAnimation()) != null) {
                    View view2 = this.R;
                    if (view2 != null && (animation = view2.getAnimation()) != null) {
                        animation.cancel();
                    }
                    View view3 = this.R;
                    if (view3 != null) {
                        view3.clearAnimation();
                    }
                }
                this.aj.offer("1");
            } else {
                Y();
            }
        } else if (this.ak) {
            this.aj.offer(String.valueOf(i));
            LogUtils.c("GiftCombo.isPlaying, Add " + i + " into list, size:" + this.aj.size());
        } else if (this.aj.isEmpty()) {
            f(i);
        } else {
            this.aj.offer(String.valueOf(i));
            LogUtils.c("GiftCombo.waitingScrawlList, Add " + i + " into list, size:" + this.aj.size());
            f(CommonStringUtils.a(this.aj.poll()));
        }
        CircleProgressView circleProgressView = this.Z;
        if (circleProgressView != null) {
            circleProgressView.setValue(100.0f);
        }
        CircleProgressView circleProgressView2 = this.Z;
        if (circleProgressView2 != null) {
            circleProgressView2.a(100.0f, 0.0f, 5000L);
        }
        View view4 = this.R;
        if (view4 != null && view4.getVisibility() == 0) {
            BubbleLayout bubbleLayout = this.aa;
            if (bubbleLayout != null) {
                BluedViewExKt.b(bubbleLayout);
            }
            BubbleLayout bubbleLayout2 = this.aa;
            if (bubbleLayout2 == null) {
                return;
            }
            bubbleLayout2.a(false, 0, true);
            return;
        }
        BubbleLayout bubbleLayout3 = this.aa;
        if (bubbleLayout3 != null) {
            bubbleLayout3.a();
        }
        BubbleLayout bubbleLayout4 = this.aa;
        if (bubbleLayout4 == null) {
            return;
        }
        BluedViewExKt.a(bubbleLayout4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveGiftBackpackFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.L();
    }

    private final void f(final int i) {
        LogUtils.c(Intrinsics.a("GiftCombo.startComboCountAnim:", (Object) Integer.valueOf(i)));
        this.ak = true;
        View view = this.R;
        if (view != null) {
            BluedViewExKt.b(view);
        }
        int i2 = this.aj.isEmpty() ? 400 : 200;
        int i3 = this.Q;
        int i4 = (i - 1) / 10;
        final TextView textView = this.Y;
        if (textView != null) {
            final int i5 = i2;
            textView.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$ZReAfiJgJpyEIo1txAosOVDLCgI
                @Override // java.lang.Runnable
                public final void run() {
                    LiveGiftBackpackFragment.a(TextView.this, i, i5);
                }
            }).setDuration(i2 / 2).start();
        }
        View view2 = this.W;
        if (view2 != null) {
            if (i % 10 == 1) {
                view2.setAlpha(0.0f);
                view2.setScaleX(0.0f);
                view2.setScaleY(0.0f);
                view2.setTranslationY(0.0f);
                view2.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(i2).start();
            } else {
                view2.animate().translationY(i3 * (-1) * (i - (i4 * 10))).setDuration(i2).start();
            }
        }
        ImageView imageView = this.U;
        if (imageView == null) {
            return;
        }
        imageView.setScaleX(1.0f);
        imageView.setScaleY(1.0f);
        imageView.setAlpha(1.0f);
        imageView.animate().scaleX(1.7f).scaleY(1.7f).alpha(0.0f).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$li5IKHDtjmherZrsCkeapALBcRc
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment.r(LiveGiftBackpackFragment.this);
            }
        }).setDuration(i2).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveGiftBackpackFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.ag();
    }

    private final void g(int i) {
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            if (liveGiftModel.effect != null) {
                LiveGiftModel liveGiftModel2 = this.O;
                Intrinsics.a(liveGiftModel2);
                if (liveGiftModel2.effect.size() <= i) {
                    return;
                }
                LiveGiftModel liveGiftModel3 = this.O;
                Intrinsics.a(liveGiftModel3);
                LiveGiftModel liveGiftModel4 = this.O;
                Intrinsics.a(liveGiftModel4);
                liveGiftModel3.effectModel = liveGiftModel4.effect.get(i);
                ah();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LiveGiftBackpackFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(LiveGiftBackpackFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.I.size() > 0) {
            Fragment fragment = this$0.I.get(0);
            Intrinsics.c(fragment, "viewFragmentList[position]");
            Fragment fragment2 = fragment;
            if (fragment2 instanceof LiveGiftBackpackItemFragment) {
                ((LiveGiftBackpackItemFragment) fragment2).j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(LiveGiftBackpackFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        LiveGiftFragment I = this$0.I();
        if (I == null) {
            return;
        }
        I.ak();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(LiveGiftBackpackFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(LiveGiftBackpackFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.getFragmentActive() == null || !this$0.getFragmentActive().isActive()) {
            return;
        }
        this$0.ak = false;
        if (this$0.aj.isEmpty()) {
            return;
        }
        LogUtils.c("GiftCombo.waitingList has " + this$0.aj.size() + " data");
        this$0.f(CommonStringUtils.a(this$0.aj.poll()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(LiveGiftBackpackFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        ViewGroup viewGroup = this$0.n;
        Intrinsics.a(viewGroup);
        BluedViewExKt.a(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(LiveGiftBackpackFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.ac();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(LiveGiftBackpackFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.ak = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final LiveGiftBackpackFragment this$0) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator scaleX;
        ViewPropertyAnimator scaleY;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator withEndAction;
        Intrinsics.e(this$0, "this$0");
        View view = this$0.X;
        if (view != null) {
            view.setScaleX(1.1f);
        }
        View view2 = this$0.X;
        if (view2 != null) {
            view2.setScaleY(1.1f);
        }
        View view3 = this$0.X;
        if (view3 == null || (animate = view3.animate()) == null || (scaleX = animate.scaleX(1.0f)) == null || (scaleY = scaleX.scaleY(1.0f)) == null || (duration = scaleY.setDuration(320L)) == null || (withEndAction = duration.withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$I_HSGNh9GxhWiCDF4ZJ6W-BUk8w
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment.u(LiveGiftBackpackFragment.this);
            }
        })) == null) {
            return;
        }
        withEndAction.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(LiveGiftBackpackFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.aa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(LiveGiftBackpackFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.ac();
    }

    public final void A() {
        LiveGiftFragment I = I();
        if (I != null) {
            I.A();
        }
        FrameLayout frameLayout = this.r;
        if (frameLayout == null) {
            return;
        }
        BluedViewExKt.a(frameLayout);
    }

    public final boolean B() {
        return this.ai;
    }

    public final BaseFragment a(CommonGiftPackageModel<?> commonGiftPackageModel) {
        if (commonGiftPackageModel != null) {
            LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) commonGiftPackageModel;
            LiveGiftBackpackItemFragment liveGiftBackpackItemFragment = new LiveGiftBackpackItemFragment();
            Bundle bundle = new Bundle();
            String str = liveGiftPackageModel.type_name;
            if (str != null) {
                LiveGiftBackpackProps liveGiftBackpackProps = null;
                switch (str.hashCode()) {
                    case -1650269616:
                        if (str.equals("fragment")) {
                            bundle.putSerializable(liveGiftPackageModel.type_name, this.F);
                            break;
                        }
                        break;
                    case -1295475133:
                        if (str.equals("equips")) {
                            String str2 = liveGiftPackageModel.type_name;
                            LiveGiftBackpackModel liveGiftBackpackModel = this.F;
                            bundle.putSerializable(str2, liveGiftBackpackModel == null ? null : liveGiftBackpackModel.getEquips());
                            break;
                        }
                        break;
                    case 98352451:
                        if (str.equals("gifts")) {
                            if (this.ac.length() > 0) {
                                bundle.putString("goods_id", this.ac);
                            }
                            bundle.putSerializable(liveGiftPackageModel.type_name, this.F);
                            break;
                        }
                        break;
                    case 106940784:
                        if (str.equals("props")) {
                            String str3 = liveGiftPackageModel.type_name;
                            LiveGiftBackpackModel liveGiftBackpackModel2 = this.F;
                            if (liveGiftBackpackModel2 != null) {
                                liveGiftBackpackProps = liveGiftBackpackModel2.getProps();
                            }
                            bundle.putSerializable(str3, liveGiftBackpackProps);
                            break;
                        }
                        break;
                }
            }
            liveGiftBackpackItemFragment.setArguments(bundle);
            return liveGiftBackpackItemFragment;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftPackageModel");
    }

    public final void a(int i) {
        if (this.I.size() > i) {
            Fragment fragment = this.I.get(i);
            Intrinsics.c(fragment, "viewFragmentList[position]");
            Fragment fragment2 = fragment;
            if (fragment2 instanceof LiveGiftBackpackItemFragment) {
                BaseFragment c2 = ((LiveGiftBackpackItemFragment) fragment2).c();
                if (c2 != null && (c2 instanceof LiveGiftBackpackParentFragment)) {
                    ((LiveGiftBackpackParentFragment) c2).g();
                    return;
                }
                LiveEventBus.get("live_gift_backpack_pager_send_status").post(false);
                LiveEventBus.get("gift_backpack_renew_clicked").post(false);
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        Bundle arguments = getArguments();
        this.ac = String.valueOf(arguments == null ? null : arguments.getString("goods_id"));
        this.o = (TextView) this.i.findViewById(R.id.give_price_view);
        this.n = (ViewGroup) this.i.findViewById(R.id.live_gift_send_layout);
        this.v = (ViewGroup) this.i.findViewById(R.id.view_space);
        this.y = (TextView) this.i.findViewById(R.id.give_gift_view);
        this.w = this.i.findViewById(R.id.fl_renewal_root);
        this.x = (TextView) this.i.findViewById(R.id.renewal_view);
        this.z = this.i.findViewById(R.id.live_gift_blank_view);
        this.p = (ImageView) this.i.findViewById(R.id.live_gift_first_charge_iv);
        this.t = (TextView) this.i.findViewById(R.id.price_view);
        this.A = (TextView) this.i.findViewById(R.id.gift_select_num_text);
        this.f13894a = (ImageView) this.i.findViewById(R.id.gift_select_num_image);
        this.B = (LinearLayout) this.i.findViewById(R.id.gift_select_num_view);
        this.u = (TextView) this.i.findViewById(R.id.top_up_view);
        LinearLayout linearLayout = this.B;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.B;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$0fWDl9T-D8knCDJS0ah2ODM26Ak
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftBackpackFragment.a(LiveGiftBackpackFragment.this, view);
                }
            });
        }
        this.b = this.i.findViewById(R.id.live_gift_number_select_layout);
        this.C = this.i.findViewById(R.id.live_gift_number_select_card);
        this.f13895c = (ListView) this.i.findViewById(R.id.live_gift_number_select_list);
        this.r = (FrameLayout) this.i.findViewById(R.id.live_gift_avatar_qa_layout);
        this.s = (ImageView) this.i.findViewById(R.id.live_gift_avatar_qa_iv);
        ImageView imageView = (ImageView) this.i.findViewById(R.id.iv_live_backpack_back);
        this.q = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$38STXioy2PR5YitzOPZzT9X2m4I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftBackpackFragment.b(LiveGiftBackpackFragment.this, view);
                }
            });
        }
        FrameLayout frameLayout = this.r;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$yrUwZH3C4zhJ9HE6hm_B4zNWqeY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftBackpackFragment.c(LiveGiftBackpackFragment.this, view);
                }
            });
        }
        this.R = this.i.findViewById(R.id.live_gift_combo_layout);
        this.S = this.i.findViewById(R.id.live_gift_combo_line);
        this.T = this.i.findViewById(R.id.live_gift_combo_btn_layout);
        this.U = (ImageView) this.i.findViewById(R.id.live_gift_combo_btn_click_bg);
        this.V = (ImageView) this.i.findViewById(R.id.live_gift_combo_btn_mid);
        this.W = this.i.findViewById(R.id.live_gift_combo_count_parent);
        this.X = this.i.findViewById(R.id.live_gift_combo_count_layout);
        this.Y = (TextView) this.i.findViewById(R.id.live_gift_combo_count_tv);
        this.Z = (CircleProgressView) this.i.findViewById(R.id.live_gift_combo_progress);
        BubbleLayout bubbleLayout = (BubbleLayout) this.i.findViewById(R.id.live_gift_combo_bubble);
        this.aa = bubbleLayout;
        if (bubbleLayout != null) {
            bubbleLayout.setShakeWidth(DisplayUtil.a(AppInfo.d(), 75.0f));
        }
        View view = this.T;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$fqZIW6NPADghwW_JfhzRUXKFa-I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveGiftBackpackFragment.d(LiveGiftBackpackFragment.this, view2);
                }
            });
        }
        View view2 = this.R;
        if (view2 != null) {
            BluedViewExKt.a(view2);
        }
        LiveGiftPresenter liveGiftPresenter = (LiveGiftPresenter) j();
        int i = LiveRoomManager.a().p().rechargeGiftBagIconShowType;
        ImageView imageView2 = this.p;
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        liveGiftPresenter.a(i, imageView2, fragmentActive, this);
        this.P = DialogUtils.a(getActivity());
        this.N = getResources().getString(R.string.suspend_renewals);
        this.L = getResources().getString(R.string.equipment);
        this.M = getResources().getString(R.string.cancel_equipment);
        TextView textView = this.y;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$ewkveIz_Of0GeEEcbTPUs2LaWaY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveGiftBackpackFragment.e(LiveGiftBackpackFragment.this, view3);
                }
            });
        }
        TextView textView2 = this.x;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$MVZPZEbJuF0liF3KN53Xhxzc0K4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveGiftBackpackFragment.f(LiveGiftBackpackFragment.this, view3);
                }
            });
        }
        D().setAdapter(E());
        D().setOffscreenPageLimit(3);
        D().registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$onInitView$7
            /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x0134  */
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPageSelected(int r6) {
                /*
                    Method dump skipped, instructions count: 399
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment$onInitView$7.onPageSelected(int):void");
            }
        });
        z();
        H();
        this.Q = DisplayUtil.a(AppInfo.d(), 5.0f);
        TextView textView3 = this.u;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$ODBhlom9gyqU0E8Q6qmagFoevY4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveGiftBackpackFragment.g(LiveGiftBackpackFragment.this, view3);
                }
            });
        }
        ViewGroup viewGroup = this.n;
        if (viewGroup == null) {
            return;
        }
        viewGroup.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$x4XD8ZRALGsChhZhU1qMhubXooA
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                LiveGiftBackpackFragment.a(LiveGiftBackpackFragment.this, view3, i2, i3, i4, i5, i6, i7, i8, i9);
            }
        });
    }

    public final void a(BasePayRemaining basePayRemaining) {
        if (basePayRemaining == null) {
            return;
        }
        LiveDataManager.a().a(basePayRemaining);
        b(basePayRemaining);
        LiveEventBus.get("live_beans_change").post(new LiveBeansChangeEvent(LiveDataManager.a().c(), basePayRemaining.beans_current, basePayRemaining.beans_count));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment
    public void a(CommonLiveGiftModel commonLiveGiftModel) {
        if (commonLiveGiftModel != null) {
            LiveGiftModel liveGiftModel = (LiveGiftModel) commonLiveGiftModel;
            if (liveGiftModel.ops == 15) {
                EventTrackLive.c(LiveProtos.Event.LIVE_GIFT_MORE_HITS, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id, liveGiftModel.hit_count);
                LogUtils.c(Intrinsics.a("进阶礼物埋点：", (Object) Integer.valueOf(liveGiftModel.hit_count)));
            }
        }
        super.a(commonLiveGiftModel);
        this.ak = false;
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$sLAE3d38wKUXWTwjdW6YKlLIoTA
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment.w(LiveGiftBackpackFragment.this);
            }
        }, 100L);
    }

    @Override // com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment
    protected void a(LiveGiftNumberModel liveGiftNumberModel) {
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            liveGiftModel.selectNumModel = liveGiftNumberModel;
        }
        LiveRouteUtil.a((Fragment) this);
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_NUM_SET_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment
    public void a(List<? extends LiveGiftNumberModel> list) {
        View view;
        Intrinsics.e(list, "list");
        super.a((List<LiveGiftNumberModel>) list);
        if (TypeUtils.a((List<?>) list) || (view = this.C) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = DisplayUtil.a(view.getContext(), list.size() * 34);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment
    protected int b() {
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            if (liveGiftModel.selectNumModel != null) {
                LiveGiftModel liveGiftModel2 = this.O;
                Intrinsics.a(liveGiftModel2);
                if (liveGiftModel2.selectNumModel.count > 0) {
                    LiveGiftModel liveGiftModel3 = this.O;
                    Intrinsics.a(liveGiftModel3);
                    return liveGiftModel3.selectNumModel.count;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }

    public final void b(int i) {
        if (this.I.size() > i) {
            Fragment fragment = this.I.get(i);
            Intrinsics.c(fragment, "viewFragmentList[position]");
            Fragment fragment2 = fragment;
            if (fragment2 instanceof LiveGiftBackpackItemFragment) {
                ((LiveGiftBackpackItemFragment) fragment2).g();
            }
        }
    }

    @Override // com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment
    protected void b(LiveGiftNumberModel liveGiftNumberModel) {
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            liveGiftModel.selectNumModel = liveGiftNumberModel;
        }
        ad();
    }

    protected final CommonGiftPackageModel<?> c(String str) {
        int a2;
        if (str == null) {
            return null;
        }
        Object[] array = StringsKt.b((CharSequence) str, new String[]{BridgeUtil.UNDERLINE_STR}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            if (strArr.length <= 1 || this.E.size() <= (a2 = CommonStringUtils.a(strArr[0]))) {
                return null;
            }
            return this.E.get(a2);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final void c(int i) {
        int i2;
        int i3 = i;
        if (i == 0) {
            i3 = 1;
        }
        LiveGiftModel liveGiftModel = this.O;
        if (liveGiftModel != null) {
            Intrinsics.a(liveGiftModel);
            if (liveGiftModel.selectNumModel != null) {
                LiveGiftModel liveGiftModel2 = this.O;
                Intrinsics.a(liveGiftModel2);
                if (liveGiftModel2.selectNumModel.isUserDefined) {
                    LiveGiftModel liveGiftModel3 = this.O;
                    Intrinsics.a(liveGiftModel3);
                    liveGiftModel3.selectNumModel.count = i3;
                    int i4 = 0;
                    while (true) {
                        i2 = i4;
                        LiveGiftModel liveGiftModel4 = this.O;
                        Intrinsics.a(liveGiftModel4);
                        if (i2 >= liveGiftModel4.groups.size()) {
                            break;
                        }
                        LiveGiftModel liveGiftModel5 = this.O;
                        Intrinsics.a(liveGiftModel5);
                        if (!liveGiftModel5.groups.get(i2).isUserDefined) {
                            LiveGiftModel liveGiftModel6 = this.O;
                            Intrinsics.a(liveGiftModel6);
                            if (i3 >= liveGiftModel6.groups.get(i2).count) {
                                break;
                            }
                        }
                        i4 = i2 + 1;
                    }
                    LogUtils.c(Intrinsics.a("index: ", (Object) Integer.valueOf(i2)));
                    LiveGiftModel liveGiftModel7 = this.O;
                    Intrinsics.a(liveGiftModel7);
                    if (i2 < liveGiftModel7.groups.size()) {
                        LiveGiftModel liveGiftModel8 = this.O;
                        Intrinsics.a(liveGiftModel8);
                        LiveGiftNumberModel liveGiftNumberModel = liveGiftModel8.selectNumModel;
                        LiveGiftModel liveGiftModel9 = this.O;
                        Intrinsics.a(liveGiftModel9);
                        liveGiftNumberModel.gift_pic_mp4 = liveGiftModel9.groups.get(i2).gift_pic_mp4;
                        LiveGiftModel liveGiftModel10 = this.O;
                        Intrinsics.a(liveGiftModel10);
                        LogUtils.c(Intrinsics.a("use: ", (Object) Integer.valueOf(liveGiftModel10.groups.get(i2).count)));
                    }
                }
            }
        }
        ad();
    }

    public final void c(boolean z) {
        TextView textView = this.y;
        if (textView == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
    }

    public final void d(boolean z) {
        View view = this.w;
        if (view == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return LiveDataManager.a().f() ? R.layout.fragment_live_gift_backpack_land : R.layout.fragment_live_gift_backpack;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 4221005 || i == 4221004) && intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra("selected_model");
                if (serializableExtra == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftModel");
                }
                LiveGiftModel liveGiftModel = (LiveGiftModel) serializableExtra;
                String stringExtra = intent.getStringExtra("password");
                boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
                int intExtra = intent.getIntExtra("gift_count", 1);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                a(liveGiftModel, intExtra, String.valueOf(stringExtra), booleanExtra);
            } else if (i != 4221002 || intent == null) {
                if (i == 100018) {
                    X();
                }
            } else {
                Serializable serializableExtra2 = intent.getSerializableExtra("selected_model");
                if (serializableExtra2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftModel");
                }
                a((LiveGiftModel) serializableExtra2, intent.getIntExtra("gift_count", 1), String.valueOf(intent.getStringExtra("password")), intent.getBooleanExtra("remember_me", false));
            }
        }
    }

    @Override // com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            Z();
            return;
        }
        LiveGiftPresenter liveGiftPresenter = (LiveGiftPresenter) j();
        ImageView imageView = this.p;
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        liveGiftPresenter.a(0, imageView, fragmentActive, this);
    }

    @Override // com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackBaseFragment
    protected LiveGiftModel x() {
        return this.O;
    }

    public final void y() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$STcS_aOYTNWoNrIiYvH6SJiL3F8
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBackpackFragment.o(LiveGiftBackpackFragment.this);
            }
        }, 200L);
    }

    public final void z() {
        LiveGiftBackpackFragment liveGiftBackpackFragment = this;
        LiveEventBus.get("key_event_live_gift_backpack_data", LiveGiftBackpackModel.class).observe(liveGiftBackpackFragment, this.ae);
        LiveEventBus.get(LiveEventBusUtil.s, String.class).observe(liveGiftBackpackFragment, new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$POCyL2ExvjC3PynAunSgXmmgo58
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftBackpackFragment.b(LiveGiftBackpackFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("gift_backpack_item_clicked", LiveGiftModel.class).observe(liveGiftBackpackFragment, new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$XMFNXQFdKTDiOcxJXijQ6NRqlWA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftBackpackFragment.a(LiveGiftBackpackFragment.this, (LiveGiftModel) obj);
            }
        });
        LiveEventBus.get("gift_backpack_renew_clicked", Boolean.TYPE).observe(liveGiftBackpackFragment, new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$qS_iL8euN3-7pG3T5zXylDj7JSA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftBackpackFragment.a(LiveGiftBackpackFragment.this, (Boolean) obj);
            }
        });
        LiveEventBus.get("live_gift_backpack_pager_send_status", Boolean.TYPE).observe(liveGiftBackpackFragment, new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$IrPVlzhPSmuH6Q6b1nGbINQXMHA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftBackpackFragment.b(LiveGiftBackpackFragment.this, (Boolean) obj);
            }
        });
        LiveEventBus.get("gold_remain_result", BasePayRemaining.class).observe(liveGiftBackpackFragment, new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$Q9MXKCralfQJF5m0su_KULRE2hA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftBackpackFragment.a(LiveGiftBackpackFragment.this, (BasePayRemaining) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.j, Integer.TYPE).observe(liveGiftBackpackFragment, new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$14rHuUz1JE9RsUQ6H3j-Y1lqUQM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftBackpackFragment.a(LiveGiftBackpackFragment.this, (Integer) obj);
            }
        });
        LiveEventBus.get("live_gift_bag_page_switch", String.class).observe(liveGiftBackpackFragment, new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$0iXViUqBT5GqpRbzD0K4ikXT5N0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftBackpackFragment.c(LiveGiftBackpackFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("gift_backpack_package_selected", Integer.TYPE).observe(liveGiftBackpackFragment, new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$9nS-VtxxQVShrWiZrN2oHmF2bME
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftBackpackFragment.b(LiveGiftBackpackFragment.this, (Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.w, Integer.TYPE).observe(liveGiftBackpackFragment, new Observer() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackFragment$2NabsVy8-MtKdl9yWembtzyARlg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftBackpackFragment.d(LiveGiftBackpackFragment.this, ((Integer) obj).intValue());
            }
        });
    }
}
