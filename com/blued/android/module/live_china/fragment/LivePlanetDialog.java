package com.blued.android.module.live_china.fragment;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.view.clickanimview.BamFrameLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLivePlanetBinding;
import com.blued.android.module.live_china.fragment.LivePlanetBuyGiftConfirmDialog;
import com.blued.android.module.live_china.fragment.LivePlanetDispatchConfirmDialog;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LivePlanetExtra;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.model.PlanetBallModel;
import com.blued.android.module.live_china.model.PlanetBroadcastModel;
import com.blued.android.module.live_china.model.PlanetDataExtraModel;
import com.blued.android.module.live_china.model.PlanetDataModel;
import com.blued.android.module.live_china.model.PlanetGiveNumModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.pop.LivePlanetGiftNumTipsPop;
import com.blued.android.module.live_china.pop.LivePlanetGiveTipPop;
import com.blued.android.module.live_china.pop.LivePlanetGuidePop;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.LivePlanetAreaView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
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
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetDialog.class */
public final class LivePlanetDialog extends BaseDialogFragment {
    private static int m;
    private boolean c;
    private PlanetDataModel d;
    private PlanetDataExtraModel e;
    private boolean h;
    private ValueAnimator i;
    private ValueAnimator j;
    private boolean k;
    public static final Companion a = new Companion(null);
    private static final int n = 7;
    private final Lazy b = LazyKt.a(new Function0<DialogLivePlanetBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePlanetDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLivePlanetBinding invoke() {
            return DialogLivePlanetBinding.a(LayoutInflater.from(LivePlanetDialog.this.getContext()));
        }
    });
    private final ArrayList<LivePlanetAreaView> f = new ArrayList<>();
    private int g = 1;
    private ArrayList<Integer> l = CollectionsKt.d(-1, -1, -1, -1);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return LivePlanetDialog.m;
        }

        public final LivePlanetDialog a(BaseFragment fragment) {
            Intrinsics.e(fragment, "fragment");
            LivePlanetDialog livePlanetDialog = new LivePlanetDialog();
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            livePlanetDialog.show(childFragmentManager, LivePlanetDialog.class.getSimpleName());
            return livePlanetDialog;
        }

        public final int b() {
            return LivePlanetDialog.n;
        }
    }

    private final int a(ArrayList<Integer> arrayList) {
        int a2 = RangesKt.a(new IntRange(0, 7), Random.a);
        int i = a2;
        if (arrayList.contains(Integer.valueOf(a2))) {
            i = a(arrayList);
        }
        return i;
    }

    private final void a(int i) {
        b((String) null, 0, i);
    }

    private final void a(int i, int i2) {
        PlanetDataModel planetDataModel = this.d;
        if (planetDataModel == null) {
            return;
        }
        if (i >= 0) {
            b(planetDataModel.getBet_count(), i);
            planetDataModel.setBet_count(planetDataModel.getBet_count() - i);
        }
        if (i2 >= 0) {
            c(planetDataModel.getShip_count(), i2);
            planetDataModel.setShip_count(planetDataModel.getShip_count() + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2, LiveZanExtraModel liveZanExtraModel) {
        if (i == 0) {
            Context context = getContext();
            if (context != null) {
                new LivePlanetGiveTipPop(context, i2).b(f().L);
            }
        } else {
            String str = liveZanExtraModel.bet_err_msg;
            if (str == null || str.length() == 0) {
                for (LivePlanetAreaView livePlanetAreaView : this.f) {
                    if (livePlanetAreaView.b()) {
                        livePlanetAreaView.a(i);
                    }
                }
                PlanetDataModel planetDataModel = this.d;
                if (planetDataModel != null) {
                    b(planetDataModel.getBet_count(), liveZanExtraModel.bet_count);
                    planetDataModel.setBet_count(liveZanExtraModel.bet_count);
                }
                ToastUtils.b(R.string.live_planet_toast_already_dispatch);
            } else {
                ToastUtils.b(liveZanExtraModel.bet_err_msg);
            }
        }
        PlanetDataModel planetDataModel2 = this.d;
        if (planetDataModel2 == null) {
            return;
        }
        c(planetDataModel2.getShip_count(), liveZanExtraModel.ship_count);
        planetDataModel2.setShip_count(liveZanExtraModel.ship_count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, LivePlanetExtra livePlanetExtra) {
        for (LivePlanetAreaView livePlanetAreaView : this.f) {
            if (livePlanetAreaView.b()) {
                livePlanetAreaView.a(i);
            }
        }
        PlanetDataModel planetDataModel = this.d;
        if (planetDataModel != null) {
            b(planetDataModel.getBet_count(), livePlanetExtra.getBet_count());
            planetDataModel.setBet_count(livePlanetExtra.getBet_count());
            c(planetDataModel.getShip_count(), livePlanetExtra.getShip_count());
            planetDataModel.setShip_count(livePlanetExtra.getShip_count());
        }
        ToastUtils.b(R.string.live_planet_toast_already_dispatch);
    }

    private final void a(int i, String str) {
    }

    private final void a(long j) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$N7zx5F-3k5DeE1VeGiNZc0wp0-c
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetDialog.e(LivePlanetDialog.this);
            }
        }, j);
    }

    private final void a(Context context) {
        ArrayList<PlanetGiveNumModel> expedition_goods_option;
        PlanetDataModel planetDataModel = this.d;
        ArrayList<PlanetGiveNumModel> expedition_goods_option2 = planetDataModel == null ? null : planetDataModel.getExpedition_goods_option();
        if (expedition_goods_option2 == null || expedition_goods_option2.isEmpty()) {
            return;
        }
        f().h.setRotation(0.0f);
        f().h.animate().rotation(180.0f).setDuration(300L).start();
        PlanetDataModel planetDataModel2 = this.d;
        if (planetDataModel2 == null || (expedition_goods_option = planetDataModel2.getExpedition_goods_option()) == null) {
            return;
        }
        new LivePlanetGiftNumTipsPop(context, this, expedition_goods_option).a(f().q, new XPopupCallback() { // from class: com.blued.android.module.live_china.fragment.LivePlanetDialog$clickToShowSelectGiftNumTips$1$1
            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView) {
                Intrinsics.e(basePopupView, "basePopupView");
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView, int i) {
                Intrinsics.e(basePopupView, "basePopupView");
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView, int i, float f, boolean z) {
                Intrinsics.e(basePopupView, "basePopupView");
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void b(BasePopupView basePopupView) {
                Intrinsics.e(basePopupView, "basePopupView");
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void c(BasePopupView basePopupView) {
                Intrinsics.e(basePopupView, "basePopupView");
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void d(BasePopupView basePopupView) {
                Intrinsics.e(basePopupView, "basePopupView");
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void e(BasePopupView basePopupView) {
                DialogLivePlanetBinding f;
                Intrinsics.e(basePopupView, "basePopupView");
                f = LivePlanetDialog.this.f();
                f.h.animate().rotation(360.0f).setDuration(300L).start();
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public boolean f(BasePopupView basePopupView) {
                Intrinsics.e(basePopupView, "basePopupView");
                return false;
            }
        });
    }

    private final void a(View view) {
        int intValue;
        if (view.getTag() != null || (view.getTag() instanceof Integer)) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            intValue = ((Integer) tag).intValue();
        } else {
            intValue = 0;
        }
        if (intValue <= 0) {
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), intValue);
        ArrayList arrayList = new ArrayList();
        for (LivePlanetAreaView livePlanetAreaView : this.f) {
            if (livePlanetAreaView.b() && livePlanetAreaView.getPlanetId() > 0) {
                if (livePlanetAreaView.getMaxNum() > 0 && livePlanetAreaView.getCurrentNum() + intValue > livePlanetAreaView.getMaxNum()) {
                    String string = AppInfo.d().getString(R.string.live_planet_toast_max_airship_count, Integer.valueOf(livePlanetAreaView.getMaxNum()));
                    Intrinsics.c(string, "getAppContext().getStrin…Num\n                    )");
                    ToastUtils.b(string);
                    return;
                }
                arrayList.add(Integer.valueOf(livePlanetAreaView.getPlanetId()));
            }
        }
        if (arrayList.isEmpty()) {
            ToastUtils.b(R.string.live_planet_toast_please_select);
        } else if (this.d != null) {
            String arrayList2 = arrayList.toString();
            Intrinsics.c(arrayList2, "planetAreaList.toString()");
            a(arrayList2, intValue, arrayList.size() * intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, float f, long j) {
        Intrinsics.e(view, "$view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, (-view.getHeight()) * f * 1.1f, 0.0f);
        ofFloat.setDuration(3360L);
        ofFloat.setStartDelay(j);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(ofFloat.getRepeatCount());
        ofFloat.start();
    }

    private final void a(final View view, final long j, final float f) {
        view.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$bsnHp0rdYJR_e7vFck7mUonKFwg
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetDialog.a(View.this, f, j);
            }
        });
    }

    private final void a(ViewGroup viewGroup) {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(2, ObjectAnimator.ofFloat((Object) null, "alpha", 0.0f, 1.0f));
        layoutTransition.setAnimator(3, ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 0.0f));
        layoutTransition.setInterpolator(2, new DecelerateInterpolator());
        layoutTransition.setInterpolator(3, new DecelerateInterpolator());
        layoutTransition.setDuration(200L);
        viewGroup.setLayoutTransition(layoutTransition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetDialog this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetDialog this$0, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        this$0.f().N.setText(AppInfo.d().getString(R.string.live_planet_my_dispatch, Integer.valueOf(((Integer) animatedValue).intValue())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.e(this$0, "this$0");
        this$0.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetDialog this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.k = false;
        if (LiveDataManager.a().f()) {
            LiveRoomInfo.a().a((Context) this$0.requireActivity(), 2);
        } else {
            LiveRoomInfo.a().a((Context) this$0.requireActivity(), this$0.getFragmentManager(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        PlanetDataModel planetDataModel = this$0.d;
        if (planetDataModel == null) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_RULE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        LivePlanetRuleDialogFragment.a.a((Fragment) this$0, planetDataModel.getText_image());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetDialog this$0, PlanetDataExtraModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "model");
        this$0.a(model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetDialog this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetDialog this$0, Object pair) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(pair, "pair");
        Pair pair2 = (Pair) pair;
        Object obj = pair2.first;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        if (((Boolean) obj).booleanValue()) {
            Object obj2 = pair2.second;
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            this$0.a(((Boolean) obj2).booleanValue());
            return;
        }
        Object obj3 = pair2.second;
        if (obj3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        this$0.b(((Boolean) obj3).booleanValue());
    }

    private final void a(final PlanetDataExtraModel planetDataExtraModel) {
        f().t.setData(-1);
        f().t.a(planetDataExtraModel.getRemain_time() + 1);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$1TiN8y1DKtrMWTOYIEzXmHd28mk
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetDialog.b(LivePlanetDialog.this, planetDataExtraModel);
            }
        }, 100L);
        if (planetDataExtraModel.getPlanet_id() >= 0) {
            if (planetDataExtraModel.getRemain_time() <= 6) {
                b(planetDataExtraModel);
            } else {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$OPTN1vDpy878bb-jOBn2VaCZ66I
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePlanetDialog.a(PlanetDataExtraModel.this, this);
                    }
                }, (planetDataExtraModel.getRemain_time() - 6) * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PlanetDataExtraModel extraData, LivePlanetDialog this$0) {
        Intrinsics.e(extraData, "$extraData");
        Intrinsics.e(this$0, "this$0");
        extraData.setRemain_time(6);
        this$0.b(extraData);
    }

    private final void a(PlanetDataModel planetDataModel) {
        ArrayList<PlanetBallModel> planet;
        ArrayList<PlanetBallModel> planet2 = planetDataModel.getPlanet();
        if (planet2 == null || planet2.isEmpty()) {
            return;
        }
        ArrayList<PlanetBallModel> planet3 = planetDataModel.getPlanet();
        if (!(planet3 != null && planet3.size() == 8) || (planet = planetDataModel.getPlanet()) == null) {
            return;
        }
        int size = this.f.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                ImageLoader.a(a(), planet.get(0).getImage()).a(f().o);
                ImageLoader.a(a(), planet.get(1).getImage()).a(f().i);
                ImageLoader.a(a(), planet.get(2).getImage()).a(f().l);
                ImageLoader.a(a(), planet.get(3).getImage()).a(f().p);
                ImageLoader.a(a(), planet.get(4).getImage()).a(f().m);
                ImageLoader.a(a(), planet.get(5).getImage()).a(f().j);
                ImageLoader.a(a(), planet.get(6).getImage()).a(f().k);
                ImageLoader.a(a(), planet.get(7).getImage()).a(f().n);
                return;
            }
            LivePlanetAreaView livePlanetAreaView = this.f.get(i2);
            PlanetBallModel planetBallModel = planet.get(i2);
            Intrinsics.c(planetBallModel, "list[i]");
            livePlanetAreaView.setData(planetBallModel);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(PlanetDataModel planetDataModel, PlanetDataExtraModel planetDataExtraModel) {
        PlanetDataExtraModel planetDataExtraModel2;
        this.d = planetDataModel;
        this.e = planetDataExtraModel;
        f().N.setText(AppInfo.d().getString(R.string.live_planet_my_dispatch, Integer.valueOf(planetDataModel.getBet_count())));
        ArrayList<PlanetBroadcastModel> draw_rotation = planetDataModel.getDraw_rotation();
        if (draw_rotation == null || draw_rotation.isEmpty()) {
            f().a.animate().alpha(0.0f).setDuration(300L).setStartDelay(0L).start();
        } else {
            f().a.animate().alpha(1.0f).setDuration(300L).setStartDelay(0L).start();
            f().a.setData(planetDataModel.getDraw_rotation());
        }
        f().L.setText(AppInfo.d().getString(R.string.live_planet_airship_count_title, Integer.valueOf(planetDataModel.getShip_count())));
        f().M.setText(AppInfo.d().getString(R.string.live_planet_airship_info, Integer.valueOf(planetDataModel.getExpedition_goods_beans())));
        f().M.setText(LiveUtils.a(f().M.getText(), "#5CF8FF", false));
        f().K.setText(String.valueOf(this.g));
        a(planetDataModel);
        b(planetDataModel);
        p();
        if (planetDataModel.getStatus() != 2 || (planetDataExtraModel2 = this.e) == null) {
            if (planetDataModel.getBet_remain_time() != 0) {
                f().t.setData(planetDataModel.getBet_remain_time());
                return;
            }
            LiveEventBusUtil.a(true, true);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$Zps1nA09YAUCi660UYJucG3Sthk
                @Override // java.lang.Runnable
                public final void run() {
                    LivePlanetDialog.d(LivePlanetDialog.this);
                }
            }, 1000L);
            return;
        }
        Intrinsics.a(planetDataExtraModel2);
        if (planetDataExtraModel2.getRemain_time() == 0) {
            LiveEventBusUtil.a(true, true);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$Efoo6YlkegOyzItytkMVkerYQEI
                @Override // java.lang.Runnable
                public final void run() {
                    LivePlanetDialog.c(LivePlanetDialog.this);
                }
            }, 1000L);
            return;
        }
        PlanetDataExtraModel planetDataExtraModel3 = this.e;
        Intrinsics.a(planetDataExtraModel3);
        a(planetDataExtraModel3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, final int i) {
        b(true);
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.a(str, i, new BluedUIHttpResponse<BluedEntityA<LivePlanetExtra>>(a2) { // from class: com.blued.android.module.live_china.fragment.LivePlanetDialog$planetBetHttp$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LivePlanetExtra> entity) {
                Intrinsics.e(entity, "entity");
                LivePlanetExtra singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LivePlanetDialog.this.a(i, singleData);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str2) {
                return super.onUIFailure(i2, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LivePlanetDialog.this.b(false);
            }
        }, a());
    }

    private final void a(final String str, final int i, final int i2) {
        if (LiveRoomPreferences.U()) {
            final PlanetDataModel planetDataModel = this.d;
            if (planetDataModel == null) {
                return;
            }
            LivePlanetDispatchConfirmDialog.a.a((Fragment) this, i2, planetDataModel.getBet_time(), new LivePlanetDispatchConfirmDialog.Callback() { // from class: com.blued.android.module.live_china.fragment.LivePlanetDialog$planetBet$1$1
                @Override // com.blued.android.module.live_china.fragment.LivePlanetDispatchConfirmDialog.Callback
                public void a() {
                    if (i2 <= planetDataModel.getShip_count()) {
                        this.a(str, i);
                        return;
                    }
                    LivePlanetDialog livePlanetDialog = this;
                    String str2 = str;
                    int i3 = i;
                    int i4 = i2;
                    livePlanetDialog.a(str2, i3, i4, i4 - planetDataModel.getShip_count());
                }
            });
            return;
        }
        PlanetDataModel planetDataModel2 = this.d;
        if (planetDataModel2 == null) {
            return;
        }
        if (i2 > planetDataModel2.getShip_count()) {
            a(str, i, i2, i2 - planetDataModel2.getShip_count());
        } else {
            a(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final String str, final int i, int i2, final int i3) {
        if (!LiveRoomPreferences.W()) {
            b(str, i, i3);
            return;
        }
        PlanetDataModel planetDataModel = this.d;
        if (planetDataModel == null) {
            return;
        }
        LivePlanetBuyGiftConfirmDialog.a.a((Fragment) this, i3, planetDataModel.getExpedition_goods_beans(), planetDataModel.getExpedition_goods_image(), new LivePlanetBuyGiftConfirmDialog.Callback() { // from class: com.blued.android.module.live_china.fragment.LivePlanetDialog$giveGift$1$1
            @Override // com.blued.android.module.live_china.fragment.LivePlanetBuyGiftConfirmDialog.Callback
            public void a() {
                LivePlanetDialog.this.b(str, i, i3);
            }
        });
    }

    private final void a(String str, int i, int i2, String str2, boolean z) {
        PlanetDataModel planetDataModel = this.d;
        if (planetDataModel != null) {
            Intrinsics.a(planetDataModel);
            if (planetDataModel.getExpedition_goods_id() <= 0) {
                return;
            }
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            PlanetDataModel planetDataModel2 = this.d;
            Intrinsics.a(planetDataModel2);
            liveGiftModel.goods_id = String.valueOf(planetDataModel2.getExpedition_goods_id());
            PlanetDataModel planetDataModel3 = this.d;
            Intrinsics.a(planetDataModel3);
            LiveRoomHttpUtils.a(String.valueOf(planetDataModel3.getExpedition_goods_id()), i2, str2, TextUtils.isEmpty(str2) ? LiveRoomPreferences.b("") : "", z, str, i, d(i, i2), a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        if (!z) {
            FrameLayout frameLayout = f().s;
            Intrinsics.c(frameLayout, "vb.loading");
            BluedViewExKt.a(frameLayout);
            return;
        }
        f().s.setAlpha(0.0f);
        f().s.setScaleX(0.0f);
        f().s.setScaleY(0.0f);
        FrameLayout frameLayout2 = f().s;
        Intrinsics.c(frameLayout2, "vb.loading");
        BluedViewExKt.b(frameLayout2);
        f().s.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).setStartDelay(250L).start();
    }

    private final void b(int i) {
        if (this.h) {
            return;
        }
        this.h = true;
        b(true);
        for (LivePlanetAreaView livePlanetAreaView : this.f) {
            livePlanetAreaView.setState(3);
        }
        f().R.animate().alpha(0.0f).setDuration(200L).start();
        f().b.animate().alpha(0.5f).setDuration(200L).start();
        f().c.animate().alpha(0.5f).setDuration(200L).start();
        f().d.animate().alpha(0.5f).setDuration(200L).start();
        f().r.animate().alpha(0.5f).setDuration(200L).start();
        if (i >= 6) {
            a(0L);
            a(166L);
        }
        if (i >= 7) {
            a(733L);
            a(899L);
        }
        if (i >= 8) {
            a(1400L);
            a(1566L);
        }
        if (i >= 9) {
            a(2066L);
            a(2232L);
        }
        if (i >= 10) {
            a(2700L);
            a(2866L);
        }
    }

    private final void b(int i, int i2) {
        if (Math.abs(i - i2) <= 2) {
            f().N.setText(AppInfo.d().getString(R.string.live_planet_my_dispatch, Integer.valueOf(i2)));
            return;
        }
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.i = valueAnimator2;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(300L);
            }
            ValueAnimator valueAnimator3 = this.i;
            if (valueAnimator3 != null) {
                valueAnimator3.setInterpolator(new DecelerateInterpolator(1.5f));
            }
            ValueAnimator valueAnimator4 = this.i;
            if (valueAnimator4 != null) {
                valueAnimator4.setEvaluator(null);
            }
        } else {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator5 = this.i;
            if (valueAnimator5 != null) {
                valueAnimator5.removeAllUpdateListeners();
            }
        }
        ValueAnimator valueAnimator6 = this.i;
        if (valueAnimator6 == null) {
            return;
        }
        valueAnimator6.setIntValues(i, i2);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$Dw9IaojtYqL1WO_Pjtj73xPzxek
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator7) {
                LivePlanetDialog.a(LivePlanetDialog.this, valueAnimator7);
            }
        };
        valueAnimator6.setTarget(null);
        valueAnimator6.addUpdateListener(animatorUpdateListener);
        valueAnimator6.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i, String str) {
        LogUtils.c("buyGiftFail: , errorCode:" + i + ", errorMessage:" + str);
        if (i == 4221008) {
            q();
        } else {
            String str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                AppMethods.a((CharSequence) str2);
            }
        }
        a(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetDialog this$0) {
        FragmentActivity activity;
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null || (activity = this$0.getActivity()) == null) {
            return;
        }
        LivePlanetGuidePop livePlanetGuidePop = new LivePlanetGuidePop(context, activity);
        DialogLivePlanetBinding vb = this$0.f();
        Intrinsics.c(vb, "vb");
        livePlanetGuidePop.a(vb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetDialog this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.g = i;
        this$0.f().K.setText(String.valueOf(this$0.g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetDialog this$0, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        this$0.f().L.setText(AppInfo.d().getString(R.string.live_planet_airship_count_title, Integer.valueOf(((Integer) animatedValue).intValue())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetDialog this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_RECORD_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        PlanetDataModel planetDataModel = this$0.d;
        LivePlanetRecordDialogFragment.a.a((Fragment) this$0, planetDataModel == null ? "" : planetDataModel.getText_image());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetDialog this$0, PlanetDataExtraModel extraData) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(extraData, "$extraData");
        this$0.b(extraData.getRemain_time());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetDialog this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetDialog this$0, Object pair) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(pair, "pair");
        this$0.p();
        Pair pair2 = (Pair) pair;
        Object obj = pair2.first;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) obj).intValue();
        Object obj2 = pair2.second;
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        this$0.a(intValue, ((Integer) obj2).intValue());
    }

    private final void b(final PlanetDataExtraModel planetDataExtraModel) {
        for (LivePlanetAreaView livePlanetAreaView : this.f) {
            if (livePlanetAreaView.getPlanetId() == planetDataExtraModel.getPlanet_id()) {
                livePlanetAreaView.e();
            }
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$Rovqo9eqt8SigtFZt4VT1XU7108
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetDialog.b(PlanetDataExtraModel.this, this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PlanetDataExtraModel extraData, LivePlanetDialog this$0) {
        Intrinsics.e(extraData, "$extraData");
        Intrinsics.e(this$0, "this$0");
        extraData.setRemain_time(extraData.getRemain_time() - 1);
        this$0.c(extraData);
    }

    private final void b(PlanetDataModel planetDataModel) {
        ArrayList<Integer> bet_option = planetDataModel.getBet_option();
        if (!(bet_option == null || bet_option.isEmpty())) {
            ArrayList<Integer> bet_option2 = planetDataModel.getBet_option();
            Integer valueOf = bet_option2 == null ? null : Integer.valueOf(bet_option2.size());
            Intrinsics.a(valueOf);
            if (valueOf.intValue() >= 3) {
                ArrayList<Integer> bet_option3 = planetDataModel.getBet_option();
                if (bet_option3 == null) {
                    return;
                }
                f().b.setTag(bet_option3.get(0));
                f().c.setTag(bet_option3.get(1));
                f().d.setTag(bet_option3.get(2));
                f().G.setText(AppInfo.d().getString(R.string.live_planet_add_num, bet_option3.get(0)));
                f().H.setText(AppInfo.d().getString(R.string.live_planet_add_num, bet_option3.get(1)));
                f().I.setText(AppInfo.d().getString(R.string.live_planet_add_num, bet_option3.get(2)));
                f().D.setText(AppInfo.d().getString(R.string.live_planet_add_num, bet_option3.get(0)));
                f().E.setText(AppInfo.d().getString(R.string.live_planet_add_num, bet_option3.get(1)));
                f().F.setText(AppInfo.d().getString(R.string.live_planet_add_num, bet_option3.get(2)));
                return;
            }
        }
        f().b.setTag(0);
        f().c.setTag(0);
        f().d.setTag(0);
        f().G.setText(AppInfo.d().getString(R.string.live_planet_add_num, 0));
        f().H.setText(AppInfo.d().getString(R.string.live_planet_add_num, 0));
        f().I.setText(AppInfo.d().getString(R.string.live_planet_add_num, 0));
        f().D.setText(AppInfo.d().getString(R.string.live_planet_add_num, 0));
        f().E.setText(AppInfo.d().getString(R.string.live_planet_add_num, 0));
        f().F.setText(AppInfo.d().getString(R.string.live_planet_add_num, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str, int i, int i2) {
        a(str, i, i2, "", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        if (!z) {
            FrameLayout frameLayout = f().s;
            Intrinsics.c(frameLayout, "vb.loading");
            BluedViewExKt.a(frameLayout);
            return;
        }
        f().s.animate().cancel();
        f().s.setAlpha(0.0f);
        f().s.setScaleX(0.0f);
        f().s.setScaleY(0.0f);
        FrameLayout frameLayout2 = f().s;
        Intrinsics.c(frameLayout2, "vb.loading");
        BluedViewExKt.b(frameLayout2);
    }

    private final void c(int i, int i2) {
        if (Math.abs(i - i2) <= 2) {
            f().L.setText(AppInfo.d().getString(R.string.live_planet_airship_count_title, Integer.valueOf(i2)));
            return;
        }
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.j = valueAnimator2;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(300L);
            }
            ValueAnimator valueAnimator3 = this.j;
            if (valueAnimator3 != null) {
                valueAnimator3.setInterpolator(new DecelerateInterpolator(1.5f));
            }
            ValueAnimator valueAnimator4 = this.j;
            if (valueAnimator4 != null) {
                valueAnimator4.setEvaluator(null);
            }
        } else {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator5 = this.j;
            if (valueAnimator5 != null) {
                valueAnimator5.removeAllUpdateListeners();
            }
        }
        ValueAnimator valueAnimator6 = this.j;
        if (valueAnimator6 == null) {
            return;
        }
        valueAnimator6.setIntValues(i, i2);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$eFel64p7P6mbMZS69YbHCuW-mYo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator7) {
                LivePlanetDialog.b(LivePlanetDialog.this, valueAnimator7);
            }
        };
        valueAnimator6.setTarget(null);
        valueAnimator6.addUpdateListener(animatorUpdateListener);
        valueAnimator6.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_RANK_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        PlanetDataModel planetDataModel = this$0.d;
        LivePlanetRankDialogFragment.a.a((Fragment) this$0, planetDataModel == null ? "" : planetDataModel.getText_image());
    }

    private final void c(PlanetDataExtraModel planetDataExtraModel) {
        LivePlanetLotteryResultDialog a2;
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.a(dialog);
            if (dialog.isShowing() && isAdded() && (a2 = LivePlanetLotteryResultDialog.a.a((Fragment) this)) != null) {
                a2.a(planetDataExtraModel);
            }
        }
    }

    private final BluedUIHttpResponse<?> d(final int i, final int i2) {
        final ActivityFragmentActive a2 = a();
        return new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LivePlanetDialog$response$response$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable error, int i3, String content) {
                Intrinsics.e(error, "error");
                Intrinsics.e(content, "content");
                super.onFailure(error, i3, content);
                LiveGiftPayTools.a(content);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i3, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                if (LivePlanetDialog.this.a() == null) {
                    LivePlanetDialog.this.requireActivity().finish();
                    return false;
                }
                KeyboardUtils.a(LivePlanetDialog.this.requireActivity());
                LivePlanetDialog.this.b(i3, errorMessage);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LivePlanetDialog.this.a(false);
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LivePlanetDialog.this.a(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> bluedEntity) {
                if (LivePlanetDialog.this.a() == null) {
                    LivePlanetDialog.this.requireActivity().finish();
                    return;
                }
                KeyboardUtils.a(LivePlanetDialog.this.requireActivity());
                if (bluedEntity == null || bluedEntity.getSingleData() == null) {
                    LivePlanetDialog.this.b(0, "");
                    return;
                }
                PayRemaining singleData = bluedEntity.getSingleData();
                Intrinsics.a(singleData);
                if (!TextUtils.isEmpty(singleData.token)) {
                    LiveRoomPreferences.c(singleData.token);
                }
                LiveZanExtraModel liveZanExtraModel = bluedEntity.extra;
                if (liveZanExtraModel == null) {
                    return;
                }
                LivePlanetDialog.this.a(i, i2, liveZanExtraModel);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LivePlanetDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LivePlanetDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(view, "view");
        this$0.a(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LivePlanetDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        int a2 = this$0.a(this$0.l);
        this$0.l.remove(0);
        this$0.l.add(Integer.valueOf(a2));
        this$0.f.get(a2).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LivePlanetDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(view, "view");
        this$0.a(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLivePlanetBinding f() {
        return (DialogLivePlanetBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LivePlanetDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(view, "view");
        this$0.a(view);
    }

    private final void g() {
        this.c = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
        h();
        k();
        j();
        l();
        if (this.c || !LiveRoomPreferences.Y()) {
            o();
            return;
        }
        n();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$c5TrEpDMIMMkr1S7q8Bzx4AyRfw
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetDialog.b(LivePlanetDialog.this);
            }
        }, 300L);
        LiveRoomPreferences.Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LivePlanetDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null) {
            return;
        }
        this$0.a(context);
    }

    private final void h() {
        f().Q.getPaint().setFakeBoldText(true);
        f().P.getPaint().setFakeBoldText(true);
        f().O.getPaint().setFakeBoldText(true);
        if (this.c) {
            TextView textView = f().R;
            Intrinsics.c(textView, "vb.tvSelectAreaHint");
            BluedViewExKt.a(textView);
            BamFrameLayout bamFrameLayout = f().b;
            Intrinsics.c(bamFrameLayout, "vb.flAddDispatch1");
            BluedViewExKt.a(bamFrameLayout);
            BamFrameLayout bamFrameLayout2 = f().c;
            Intrinsics.c(bamFrameLayout2, "vb.flAddDispatch2");
            BluedViewExKt.a(bamFrameLayout2);
            BamFrameLayout bamFrameLayout3 = f().d;
            Intrinsics.c(bamFrameLayout3, "vb.flAddDispatch3");
            BluedViewExKt.a(bamFrameLayout3);
            LinearLayout linearLayout = f().r;
            Intrinsics.c(linearLayout, "vb.llMyAirshipRoot");
            BluedViewExKt.a(linearLayout);
        } else {
            f().R.getPaint().setFakeBoldText(true);
            f().D.getPaint().setFakeBoldText(true);
            f().G.getPaint().setFakeBoldText(true);
            f().E.getPaint().setFakeBoldText(true);
            f().H.getPaint().setFakeBoldText(true);
            f().F.getPaint().setFakeBoldText(true);
            f().I.getPaint().setFakeBoldText(true);
            f().L.getPaint().setFakeBoldText(true);
            f().M.getPaint().setFakeBoldText(true);
            f().K.getPaint().setFakeBoldText(true);
            f().J.getPaint().setFakeBoldText(true);
        }
        LivePlanetAreaView livePlanetAreaView = f().u;
        ActivityFragmentActive fragmentActive = a();
        Intrinsics.c(fragmentActive, "fragmentActive");
        livePlanetAreaView.setFragmentActive(fragmentActive);
        this.f.add(f().u);
        LivePlanetAreaView livePlanetAreaView2 = f().v;
        ActivityFragmentActive fragmentActive2 = a();
        Intrinsics.c(fragmentActive2, "fragmentActive");
        livePlanetAreaView2.setFragmentActive(fragmentActive2);
        this.f.add(f().v);
        LivePlanetAreaView livePlanetAreaView3 = f().w;
        ActivityFragmentActive fragmentActive3 = a();
        Intrinsics.c(fragmentActive3, "fragmentActive");
        livePlanetAreaView3.setFragmentActive(fragmentActive3);
        this.f.add(f().w);
        LivePlanetAreaView livePlanetAreaView4 = f().x;
        ActivityFragmentActive fragmentActive4 = a();
        Intrinsics.c(fragmentActive4, "fragmentActive");
        livePlanetAreaView4.setFragmentActive(fragmentActive4);
        this.f.add(f().x);
        LivePlanetAreaView livePlanetAreaView5 = f().y;
        ActivityFragmentActive fragmentActive5 = a();
        Intrinsics.c(fragmentActive5, "fragmentActive");
        livePlanetAreaView5.setFragmentActive(fragmentActive5);
        this.f.add(f().y);
        LivePlanetAreaView livePlanetAreaView6 = f().z;
        ActivityFragmentActive fragmentActive6 = a();
        Intrinsics.c(fragmentActive6, "fragmentActive");
        livePlanetAreaView6.setFragmentActive(fragmentActive6);
        this.f.add(f().z);
        LivePlanetAreaView livePlanetAreaView7 = f().A;
        ActivityFragmentActive fragmentActive7 = a();
        Intrinsics.c(fragmentActive7, "fragmentActive");
        livePlanetAreaView7.setFragmentActive(fragmentActive7);
        this.f.add(f().A);
        LivePlanetAreaView livePlanetAreaView8 = f().B;
        ActivityFragmentActive fragmentActive8 = a();
        Intrinsics.c(fragmentActive8, "fragmentActive");
        livePlanetAreaView8.setFragmentActive(fragmentActive8);
        this.f.add(f().B);
        BamFrameLayout bamFrameLayout4 = f().b;
        Intrinsics.c(bamFrameLayout4, "vb.flAddDispatch1");
        a((ViewGroup) bamFrameLayout4);
        BamFrameLayout bamFrameLayout5 = f().c;
        Intrinsics.c(bamFrameLayout5, "vb.flAddDispatch2");
        a((ViewGroup) bamFrameLayout5);
        BamFrameLayout bamFrameLayout6 = f().d;
        Intrinsics.c(bamFrameLayout6, "vb.flAddDispatch3");
        a((ViewGroup) bamFrameLayout6);
        SVGAParser.a(SVGAParser.a.b(), "live_planet_background.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.live_china.fragment.LivePlanetDialog$initUI$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                DialogLivePlanetBinding f;
                DialogLivePlanetBinding f2;
                Intrinsics.e(videoItem, "videoItem");
                f = LivePlanetDialog.this.f();
                f.C.setVideoItem(videoItem);
                f2 = LivePlanetDialog.this.f();
                f2.C.a(0, true);
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
        ImageLoader.c(a(), "live_planet_fly_star.png").g().g(-1).a(f().g);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(LivePlanetDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.b(LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_SEND, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.g);
        this$0.a(this$0.g);
    }

    private final void i() {
        ImageView imageView = f().o;
        Intrinsics.c(imageView, "vb.ivPlanetTianwang");
        a((View) imageView, 270L, 0.04f);
        ImageView imageView2 = f().i;
        Intrinsics.c(imageView2, "vb.ivPlanetHaiwang");
        a((View) imageView2, 60L, 0.05f);
        ImageView imageView3 = f().l;
        Intrinsics.c(imageView3, "vb.ivPlanetMingwang");
        a((View) imageView3, 330L, 0.08f);
        ImageView imageView4 = f().p;
        Intrinsics.c(imageView4, "vb.ivPlanetTuxing");
        a((View) imageView4, 270L, 0.07f);
        ImageView imageView5 = f().m;
        Intrinsics.c(imageView5, "vb.ivPlanetMuxing");
        a((View) imageView5, 660L, 0.03f);
        ImageView imageView6 = f().j;
        Intrinsics.c(imageView6, "vb.ivPlanetHuoxing");
        a((View) imageView6, 180L, 0.03f);
        ImageView imageView7 = f().k;
        Intrinsics.c(imageView7, "vb.ivPlanetJinxing");
        a((View) imageView7, 0L, 0.01f);
        ImageView imageView8 = f().n;
        Intrinsics.c(imageView8, "vb.ivPlanetShuixing");
        a((View) imageView8, 60L, 0.02f);
    }

    private final void j() {
        f().Q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$ofSbepG6lwtI0-XVCP_UIkS5rJc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDialog.a(LivePlanetDialog.this, view);
            }
        });
        f().P.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$xLs10BDA4lhApQuHKwUaImt7dOc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDialog.b(LivePlanetDialog.this, view);
            }
        });
        f().O.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$NbzonwgmKHD82E7HobKYdMPJ22Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDialog.c(LivePlanetDialog.this, view);
            }
        });
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$VDERvSTx1weAyxlS0tV6TCmjZEw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDialog.d(LivePlanetDialog.this, view);
            }
        });
        f().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$_D8KCFTcHclt9RMTQ9eTH5A3OWY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDialog.e(LivePlanetDialog.this, view);
            }
        });
        f().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$WW0cBDpiPOb0ZVZqM86rNbwxSO8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDialog.f(LivePlanetDialog.this, view);
            }
        });
        f().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$aHx576BJwVvyl8X9YjLoOb0fRYw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDialog.g(LivePlanetDialog.this, view);
            }
        });
        f().J.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$jgnDx_3yoYksFlr9Ly19wmh0pB8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDialog.h(LivePlanetDialog.this, view);
            }
        });
    }

    private final void k() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get(LiveEventBusUtil.K, Pair.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$ejzc5kI9JcyCVS4Q-EJ9Qx9YxLE
            public final void onChanged(Object obj) {
                LivePlanetDialog.a(LivePlanetDialog.this, (Pair) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.L, Integer.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$yq_b5dlbdeOuLOyks6zdGG6gDqk
            public final void onChanged(Object obj) {
                LivePlanetDialog.a(LivePlanetDialog.this, (Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.M, Pair.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$qRxEDr-4DNMa2RAw8Eybu6oHaiU
            public final void onChanged(Object obj) {
                LivePlanetDialog.b(LivePlanetDialog.this, (Pair) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.P, Integer.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$SpQYs77mvHwtf0jgWYZW5uXVmn8
            public final void onChanged(Object obj) {
                LivePlanetDialog.b(LivePlanetDialog.this, (Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.N, Integer.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$jAiQ3hLvBM8GLGJkjKiPrlL3bRE
            public final void onChanged(Object obj) {
                LivePlanetDialog.a(LivePlanetDialog.this, ((Integer) obj).intValue());
            }
        });
        LiveEventBus.get(LiveEventBusUtil.O, PlanetDataExtraModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$pCUVxIDyLVWF6Usl-TjPOlr2C0Q
            public final void onChanged(Object obj) {
                LivePlanetDialog.a(LivePlanetDialog.this, (PlanetDataExtraModel) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.w, Integer.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$ysKUbUwxII062rF7qYxPiC35tT8
            public final void onChanged(Object obj) {
                LivePlanetDialog.b(LivePlanetDialog.this, ((Integer) obj).intValue());
            }
        });
    }

    private final void l() {
        f().N.setText(AppInfo.d().getString(R.string.live_planet_my_dispatch, 0));
        f().u.a();
        f().v.a();
        f().w.a();
        f().x.a();
        f().y.a();
        f().z.a();
        f().A.a();
        f().B.a();
        f().R.setText(AppInfo.d().getString(R.string.live_planet_selected_area_count, 0));
        f().R.setText(LiveUtils.a(f().R.getText(), "#5CF8FF", false));
        f().b.setBackgroundResource(R.drawable.live_planet_add_num_light_not);
        f().G.setTextColor(BluedSkinUtils.a(getContext(), R.color.white));
        f().G.setAlpha(0.6f);
        TextView textView = f().D;
        Intrinsics.c(textView, "vb.tvAddDispatch1");
        BluedViewExKt.a(textView);
        f().c.setBackgroundResource(R.drawable.live_planet_add_num_light_not);
        f().H.setTextColor(BluedSkinUtils.a(getContext(), R.color.white));
        f().H.setAlpha(0.6f);
        TextView textView2 = f().E;
        Intrinsics.c(textView2, "vb.tvAddDispatch2");
        BluedViewExKt.a(textView2);
        f().d.setBackgroundResource(R.drawable.live_planet_add_num_light_not);
        f().I.setTextColor(BluedSkinUtils.a(getContext(), R.color.white));
        f().I.setAlpha(0.6f);
        TextView textView3 = f().F;
        Intrinsics.c(textView3, "vb.tvAddDispatch3");
        BluedViewExKt.a(textView3);
        f().R.animate().alpha(1.0f).setDuration(200L).start();
        f().b.animate().alpha(1.0f).setDuration(200L).start();
        f().c.animate().alpha(1.0f).setDuration(200L).start();
        f().d.animate().alpha(1.0f).setDuration(200L).start();
        f().r.animate().alpha(1.0f).setDuration(200L).start();
        f().t.a();
    }

    private final void m() {
        LiveRoomHttpUtils.f();
    }

    private final void n() {
        f().L.setText(AppInfo.d().getString(R.string.live_planet_airship_count_title, 999999));
        f().M.setText(AppInfo.d().getString(R.string.live_planet_airship_info, 50));
        f().M.setText(LiveUtils.a(f().M.getText(), "#5CF8FF", false));
        f().K.setText("1314");
        f().b.setBackgroundResource(R.drawable.live_planet_add_num_light);
        f().G.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_dark_2FACFF));
        f().G.setAlpha(1.0f);
        f().G.setText("+1");
        TextView textView = f().D;
        Intrinsics.c(textView, "vb.tvAddDispatch1");
        BluedViewExKt.b(textView);
        f().D.setText("+1");
        this.f.get(0).setNameImg(R.drawable.live_planet_item_name_tianwang);
        this.f.get(0).setRate(25);
        this.f.get(1).setNameImg(R.drawable.live_planet_item_name_haiwang);
        this.f.get(1).setRate(25);
        this.f.get(1).a(100);
        this.f.get(7).setNameImg(R.drawable.live_planet_item_name_shuixing);
        this.f.get(7).setRate(25);
    }

    private final void o() {
        a(true);
        this.h = false;
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.A(new BluedUIHttpResponse<BluedEntity<PlanetDataModel, PlanetDataExtraModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LivePlanetDialog$getData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LivePlanetDialog.this.a(false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<PlanetDataModel, PlanetDataExtraModel> entity) {
                Intrinsics.e(entity, "entity");
                PlanetDataModel singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LivePlanetDialog.this.a(singleData, entity.extra);
            }
        }, a());
    }

    private final void p() {
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (LivePlanetAreaView livePlanetAreaView : this.f) {
            boolean z2 = z;
            int i3 = i;
            if (livePlanetAreaView.b()) {
                i3 = i + 1;
                z2 = false;
            }
            if (!livePlanetAreaView.b()) {
                z = z2;
                i = i3;
                if (livePlanetAreaView.c()) {
                }
            }
            i2++;
            z = z2;
            i = i3;
        }
        if (z) {
            f().b.setBackgroundResource(R.drawable.live_planet_add_num_light_not);
            f().c.setBackgroundResource(R.drawable.live_planet_add_num_light_not);
            f().d.setBackgroundResource(R.drawable.live_planet_add_num_light_not);
            int a2 = BluedSkinUtils.a(getContext(), R.color.white);
            f().G.setTextColor(a2);
            f().H.setTextColor(a2);
            f().I.setTextColor(a2);
            f().G.setAlpha(0.5f);
            f().H.setAlpha(0.5f);
            f().I.setAlpha(0.5f);
            TextView textView = f().D;
            Intrinsics.c(textView, "vb.tvAddDispatch1");
            BluedViewExKt.a(textView);
            TextView textView2 = f().E;
            Intrinsics.c(textView2, "vb.tvAddDispatch2");
            BluedViewExKt.a(textView2);
            TextView textView3 = f().F;
            Intrinsics.c(textView3, "vb.tvAddDispatch3");
            BluedViewExKt.a(textView3);
        } else {
            f().b.setBackgroundResource(R.drawable.live_planet_add_num_light);
            f().c.setBackgroundResource(R.drawable.live_planet_add_num_light);
            f().d.setBackgroundResource(R.drawable.live_planet_add_num_light);
            int a3 = BluedSkinUtils.a(getContext(), R.color.syc_dark_2FACFF);
            f().G.setTextColor(a3);
            f().H.setTextColor(a3);
            f().I.setTextColor(a3);
            f().G.setAlpha(1.0f);
            f().H.setAlpha(1.0f);
            f().I.setAlpha(1.0f);
            TextView textView4 = f().D;
            Intrinsics.c(textView4, "vb.tvAddDispatch1");
            BluedViewExKt.b(textView4);
            TextView textView5 = f().E;
            Intrinsics.c(textView5, "vb.tvAddDispatch2");
            BluedViewExKt.b(textView5);
            TextView textView6 = f().F;
            Intrinsics.c(textView6, "vb.tvAddDispatch3");
            BluedViewExKt.b(textView6);
        }
        f().R.setText(AppInfo.d().getString(R.string.live_planet_selected_area_count, Integer.valueOf(i)));
        f().R.setText(LiveUtils.a(f().R.getText(), "#5CF8FF", false));
        m = i2;
    }

    private final void q() {
        LiveGiftPayTools.b();
        if (this.k || getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        String a2 = AppUtils.a(R.string.live_id_charge_tip);
        this.k = true;
        CommonAlertDialog.a(requireActivity(), (View) null, "", a2, AppUtils.a(R.string.cancel), AppUtils.a(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$Cmxf8bYiRVU84gIV9_L_35RXXTc
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LivePlanetDialog.a(LivePlanetDialog.this, dialogInterface, i);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$ClRE1kXteVC-54kQfFUfTKQsqZw
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LivePlanetDialog.b(LivePlanetDialog.this, dialogInterface, i);
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDialog$GwUhQ7vh48jcpq6ymeaKBLy3KM0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LivePlanetDialog.a(LivePlanetDialog.this, dialogInterface);
            }
        }, true);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 521.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(f().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        EventTrackLive.a(LiveProtos.Event.LIVE_STAR_EXPLORE_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        f().t.a();
        m();
        super.onDismiss(dialog);
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(f().getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        g();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
