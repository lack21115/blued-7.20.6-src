package com.blued.android.module.live_china.fragment;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LivePlanetLotteryResultDialogBinding;
import com.blued.android.module.live_china.fitem.FitemPlanetGiftAward;
import com.blued.android.module.live_china.model.PlanetDataExtraModel;
import com.blued.android.module.live_china.model.PlanetGiftModel;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.view.BluedViewExKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetLotteryResultDialog.class */
public final class LivePlanetLotteryResultDialog extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<LivePlanetLotteryResultDialogBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePlanetLotteryResultDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LivePlanetLotteryResultDialogBinding invoke() {
            return LivePlanetLotteryResultDialogBinding.a(LayoutInflater.from(LivePlanetLotteryResultDialog.this.getContext()));
        }
    });
    private PlanetDataExtraModel c;
    private boolean d;
    private boolean e;
    private CountDownTimer f;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetLotteryResultDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LivePlanetLotteryResultDialog a(Fragment fragment) {
            Intrinsics.e(fragment, "fragment");
            LivePlanetLotteryResultDialog livePlanetLotteryResultDialog = new LivePlanetLotteryResultDialog();
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            livePlanetLotteryResultDialog.show(childFragmentManager, LivePlanetLotteryResultDialog.class.getSimpleName());
            if (livePlanetLotteryResultDialog.e) {
                return livePlanetLotteryResultDialog;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetLotteryResultDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetLotteryResultDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LivePlanetLotteryResultDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.f().f, "scaleX", 1.0f, 0.9f, 1.0f);
        ofFloat.setDuration(1680L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(ofFloat.getRepeatCount());
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.f().f, "scaleY", 1.0f, 0.9f, 1.0f);
        ofFloat2.setDuration(1680L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(ofFloat2.getRepeatCount());
        ofFloat2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LivePlanetLotteryResultDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LivePlanetLotteryResultDialogBinding f() {
        return (LivePlanetLotteryResultDialogBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LivePlanetLotteryResultDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.f().g, "scaleX", 1.0f, 0.9f, 1.0f);
        ofFloat.setDuration(1680L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(ofFloat.getRepeatCount());
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.f().g, "scaleY", 1.0f, 0.9f, 1.0f);
        ofFloat2.setDuration(1680L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(ofFloat2.getRepeatCount());
        ofFloat2.start();
    }

    private final void g() {
        RelativeLayout relativeLayout = f().n;
        Intrinsics.c(relativeLayout, "vb.rlNotWinningRoot");
        BluedViewExKt.b(relativeLayout);
        RelativeLayout relativeLayout2 = f().p;
        Intrinsics.c(relativeLayout2, "vb.rlWinningRoot");
        BluedViewExKt.a(relativeLayout2);
        ActivityFragmentActive a2 = a();
        PlanetDataExtraModel planetDataExtraModel = this.c;
        PlanetDataExtraModel planetDataExtraModel2 = planetDataExtraModel;
        if (planetDataExtraModel == null) {
            Intrinsics.c("data");
            planetDataExtraModel2 = null;
        }
        ImageLoader.a(a2, planetDataExtraModel2.getPlanet_image()).a(f().f);
        ActivityFragmentActive a3 = a();
        PlanetDataExtraModel planetDataExtraModel3 = this.c;
        PlanetDataExtraModel planetDataExtraModel4 = planetDataExtraModel3;
        if (planetDataExtraModel3 == null) {
            Intrinsics.c("data");
            planetDataExtraModel4 = null;
        }
        ImageLoader.a(a3, planetDataExtraModel4.getPlanet_name_image()).a(f().h);
        TextView textView = f().t;
        Context d = AppInfo.d();
        int i = R.string.live_planet_multiplying_power;
        PlanetDataExtraModel planetDataExtraModel5 = this.c;
        PlanetDataExtraModel planetDataExtraModel6 = planetDataExtraModel5;
        if (planetDataExtraModel5 == null) {
            Intrinsics.c("data");
            planetDataExtraModel6 = null;
        }
        int i2 = 0;
        textView.setText(d.getString(i, Integer.valueOf(planetDataExtraModel6.getRate())));
        ImageLoader.c(a(), "live_planet_item_power_flow.png").g().g(-1).a(f().c);
        TextView textView2 = f().s;
        PlanetDataExtraModel planetDataExtraModel7 = this.c;
        if (planetDataExtraModel7 == null) {
            Intrinsics.c("data");
            planetDataExtraModel7 = null;
        }
        if (planetDataExtraModel7.is_join() != 1) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        f().n.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetLotteryResultDialog$Kthjk4Bi3xY99kbYCfysY7vEvtI
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetLotteryResultDialog.c(LivePlanetLotteryResultDialog.this);
            }
        });
    }

    private final void h() {
        f().n.animate().scaleX(1.0f).scaleY(1.0f).setDuration(240L).setStartDelay(300L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetLotteryResultDialog$nTKskFP2UvXPFtj0_M87yXUld3U
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetLotteryResultDialog.d(LivePlanetLotteryResultDialog.this);
            }
        }).start();
        f().b.animate().rotation(432.0f).setDuration(6480L).setStartDelay(150L).setInterpolator(new LinearInterpolator()).start();
    }

    private final void i() {
        RelativeLayout relativeLayout = f().n;
        Intrinsics.c(relativeLayout, "vb.rlNotWinningRoot");
        BluedViewExKt.a(relativeLayout);
        RelativeLayout relativeLayout2 = f().p;
        Intrinsics.c(relativeLayout2, "vb.rlWinningRoot");
        BluedViewExKt.b(relativeLayout2);
        ActivityFragmentActive a2 = a();
        PlanetDataExtraModel planetDataExtraModel = this.c;
        PlanetDataExtraModel planetDataExtraModel2 = planetDataExtraModel;
        if (planetDataExtraModel == null) {
            Intrinsics.c("data");
            planetDataExtraModel2 = null;
        }
        ImageLoader.a(a2, planetDataExtraModel2.getPlanet_image()).a(f().g);
        ActivityFragmentActive a3 = a();
        PlanetDataExtraModel planetDataExtraModel3 = this.c;
        PlanetDataExtraModel planetDataExtraModel4 = planetDataExtraModel3;
        if (planetDataExtraModel3 == null) {
            Intrinsics.c("data");
            planetDataExtraModel4 = null;
        }
        ImageLoader.a(a3, planetDataExtraModel4.getPlanet_name_image()).a(f().i);
        TextView textView = f().u;
        Context d = AppInfo.d();
        int i = R.string.live_planet_multiplying_power;
        PlanetDataExtraModel planetDataExtraModel5 = this.c;
        PlanetDataExtraModel planetDataExtraModel6 = planetDataExtraModel5;
        if (planetDataExtraModel5 == null) {
            Intrinsics.c("data");
            planetDataExtraModel6 = null;
        }
        textView.setText(d.getString(i, Integer.valueOf(planetDataExtraModel6.getRate())));
        ImageLoader.c(a(), "live_planet_item_power_flow.png").g().g(-1).a(f().d);
        TextView textView2 = f().w;
        Context d2 = AppInfo.d();
        int i2 = R.string.live_planet_lottery_prize;
        PlanetDataExtraModel planetDataExtraModel7 = this.c;
        PlanetDataExtraModel planetDataExtraModel8 = planetDataExtraModel7;
        if (planetDataExtraModel7 == null) {
            Intrinsics.c("data");
            planetDataExtraModel8 = null;
        }
        int ship_count = planetDataExtraModel8.getShip_count();
        PlanetDataExtraModel planetDataExtraModel9 = this.c;
        PlanetDataExtraModel planetDataExtraModel10 = planetDataExtraModel9;
        if (planetDataExtraModel9 == null) {
            Intrinsics.c("data");
            planetDataExtraModel10 = null;
        }
        textView2.setText(d2.getString(i2, Integer.valueOf(ship_count), planetDataExtraModel10.getPlanet_name()));
        f().w.setText(LiveUtils.a(f().w.getText(), "#FFD452", false));
        TextView textView3 = f().x;
        Context d3 = AppInfo.d();
        int i3 = R.string.live_planet_prize;
        PlanetDataExtraModel planetDataExtraModel11 = this.c;
        PlanetDataExtraModel planetDataExtraModel12 = planetDataExtraModel11;
        if (planetDataExtraModel11 == null) {
            Intrinsics.c("data");
            planetDataExtraModel12 = null;
        }
        textView3.setText(d3.getString(i3, Integer.valueOf(planetDataExtraModel12.getBeans())));
        f().x.setText(LiveUtils.a(f().x.getText(), "#FFD452", false));
        PlanetDataExtraModel planetDataExtraModel13 = this.c;
        if (planetDataExtraModel13 == null) {
            Intrinsics.c("data");
            planetDataExtraModel13 = null;
        }
        ArrayList<PlanetGiftModel> goods_info = planetDataExtraModel13.getGoods_info();
        if (goods_info != null) {
            ArrayList arrayList = new ArrayList();
            for (PlanetGiftModel planetGiftModel : goods_info) {
                arrayList.add(new FitemPlanetGiftAward(planetGiftModel));
            }
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(0);
            f().q.setLayoutManager(linearLayoutManager);
            f().q.setAdapter(new FreedomAdapter(getContext(), a(), arrayList));
        }
        f().p.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetLotteryResultDialog$A3QmWzaq2RcRavmBG9C_GndTP48
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetLotteryResultDialog.e(LivePlanetLotteryResultDialog.this);
            }
        });
    }

    private final void j() {
        f().e.animate().alpha(1.0f).scaleX(1.0f).setDuration(240L).setStartDelay(300L).start();
        f().g.animate().scaleX(1.0f).scaleY(1.0f).setDuration(240L).setStartDelay(300L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetLotteryResultDialog$96z-2C2vIc-v2HpGoOqOsr_wcHY
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetLotteryResultDialog.f(LivePlanetLotteryResultDialog.this);
            }
        }).start();
        f().k.animate().scaleX(1.0f).scaleY(1.0f).setDuration(240L).setStartDelay(300L).start();
        f().l.animate().alpha(1.0f).setDuration(240L).setStartDelay(450L).start();
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.blued.android.module.live_china.fragment.LivePlanetLotteryResultDialog$setData$1] */
    public final void a(PlanetDataExtraModel extraData) {
        Intrinsics.e(extraData, "extraData");
        this.c = extraData;
        if (this.d) {
            TextView textView = f().v;
            Context d = AppInfo.d();
            int i = R.string.live_planet_find_energy;
            PlanetDataExtraModel planetDataExtraModel = this.c;
            PlanetDataExtraModel planetDataExtraModel2 = planetDataExtraModel;
            if (planetDataExtraModel == null) {
                Intrinsics.c("data");
                planetDataExtraModel2 = null;
            }
            textView.setText(d.getString(i, planetDataExtraModel2.getPlanet_name()));
            f().m.animate().alpha(1.0f).setDuration(240L).start();
            this.f = new CountDownTimer(6000L) { // from class: com.blued.android.module.live_china.fragment.LivePlanetLotteryResultDialog$setData$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (LivePlanetLotteryResultDialog.this.getContext() == null) {
                        return;
                    }
                    LivePlanetLotteryResultDialog.this.dismissAllowingStateLoss();
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    LivePlanetLotteryResultDialogBinding f;
                    LivePlanetLotteryResultDialogBinding f2;
                    LivePlanetLotteryResultDialogBinding f3;
                    if (LivePlanetLotteryResultDialog.this.getContext() == null) {
                        return;
                    }
                    long j2 = j / 1000;
                    if (j2 <= 0) {
                        f = LivePlanetLotteryResultDialog.this.f();
                        f.r.animate().alpha(0.0f).setDuration(350L).start();
                        f2 = LivePlanetLotteryResultDialog.this.f();
                        f2.m.animate().alpha(0.0f).setDuration(350L).setStartDelay(300L).start();
                        return;
                    }
                    f3 = LivePlanetLotteryResultDialog.this.f();
                    TextView textView2 = f3.r;
                    StringBuilder sb = new StringBuilder();
                    sb.append(j2);
                    sb.append('s');
                    textView2.setText(sb.toString());
                }
            }.start();
            PlanetDataExtraModel planetDataExtraModel3 = this.c;
            if (planetDataExtraModel3 == null) {
                Intrinsics.c("data");
                planetDataExtraModel3 = null;
            }
            if (planetDataExtraModel3.is_lucky() != 1) {
                g();
            } else {
                i();
            }
        }
    }

    public final void d() {
        if (this.c == null) {
            Intrinsics.c("data");
        }
        PlanetDataExtraModel planetDataExtraModel = this.c;
        PlanetDataExtraModel planetDataExtraModel2 = planetDataExtraModel;
        if (planetDataExtraModel == null) {
            Intrinsics.c("data");
            planetDataExtraModel2 = null;
        }
        a(planetDataExtraModel2);
        f().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetLotteryResultDialog$HtBorm_4c1m7oyPDGaI5P4a65LY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetLotteryResultDialog.a(LivePlanetLotteryResultDialog.this, view);
            }
        });
    }

    public void dismissAllowingStateLoss() {
        e();
        super.dismissAllowingStateLoss();
    }

    public final void e() {
        CountDownTimer countDownTimer = this.f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f = null;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager windowManager;
        Display defaultDisplay;
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(f().getRoot(), new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(Color.argb(178, 0, 0, 0)));
        window.setWindowAnimations(R.style.alpha_menu_slow_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        FragmentActivity activity = getActivity();
        Integer num = null;
        if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            num = Integer.valueOf(defaultDisplay.getWidth());
        }
        Intrinsics.a(num);
        attributes.width = num.intValue();
        attributes.height = -1;
        dialog.onWindowAttributesChanged(attributes);
        window.setFlags(67108864, 67108864);
        this.d = true;
        d();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            if (isAdded()) {
                return;
            }
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
            this.e = true;
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
