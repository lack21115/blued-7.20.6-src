package com.blued.android.module.live_china.fragment;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LivePlanetBuyConfirmDialogBinding;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetBuyGiftConfirmDialog.class */
public final class LivePlanetBuyGiftConfirmDialog extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13100a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private Callback f13101c;
    private final Lazy b = LazyKt.a(new Function0<LivePlanetBuyConfirmDialogBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePlanetBuyGiftConfirmDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LivePlanetBuyConfirmDialogBinding invoke() {
            return LivePlanetBuyConfirmDialogBinding.a(LayoutInflater.from(LivePlanetBuyGiftConfirmDialog.this.getContext()));
        }
    });
    private boolean d = true;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetBuyGiftConfirmDialog$Callback.class */
    public interface Callback {
        void a();
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetBuyGiftConfirmDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Fragment fragment, int i, int i2, String giftImg, Callback callback) {
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(giftImg, "giftImg");
            Intrinsics.e(callback, "callback");
            LivePlanetBuyGiftConfirmDialog livePlanetBuyGiftConfirmDialog = new LivePlanetBuyGiftConfirmDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("gift_count", i);
            bundle.putInt("gift_price", i2);
            bundle.putString("gift_img", giftImg);
            livePlanetBuyGiftConfirmDialog.f13101c = callback;
            livePlanetBuyGiftConfirmDialog.setArguments(bundle);
            livePlanetBuyGiftConfirmDialog.show(fragment.getChildFragmentManager(), "LiveBattleRandomAwardDialog");
        }
    }

    private final void a(final ViewGroup viewGroup) {
        final int width = viewGroup.getWidth();
        final int height = viewGroup.getHeight();
        final int a2 = DensityUtils.a(getContext(), 25.0f);
        viewGroup.getLayoutParams().width = a2;
        viewGroup.getLayoutParams().height = a2;
        viewGroup.setLayoutParams(viewGroup.getLayoutParams());
        viewGroup.setAlpha(1.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 2.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator(0.25f));
        ofFloat.setDuration(600L);
        final OvershootInterpolator overshootInterpolator = new OvershootInterpolator(2.5f);
        final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(2.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetBuyGiftConfirmDialog$rM100PoNWzB1qA7qHviHzT-nIn4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetBuyGiftConfirmDialog.a(OvershootInterpolator.this, viewGroup, a2, width, decelerateInterpolator, height, valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OvershootInterpolator decelerate, ViewGroup rootView, int i, int i2, DecelerateInterpolator accelerate, int i3, ValueAnimator animation) {
        Intrinsics.e(decelerate, "$decelerate");
        Intrinsics.e(rootView, "$rootView");
        Intrinsics.e(accelerate, "$accelerate");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        if (floatValue < 1.0f) {
            rootView.getLayoutParams().width = (int) (i + ((i2 - i) * decelerate.getInterpolation(floatValue)));
        }
        if (floatValue >= 0.7d) {
            float f = floatValue + 0.3f;
            float f2 = f;
            if (f > 2.0f) {
                f2 = 2.0f;
            }
            rootView.getLayoutParams().height = (int) (i + ((i3 - i) * accelerate.getInterpolation(f2 - 1)));
        }
        rootView.setLayoutParams(rootView.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetBuyGiftConfirmDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        FrameLayout frameLayout = this$0.d().f12362a;
        Intrinsics.c(frameLayout, "vb.flRoot");
        this$0.a(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetBuyGiftConfirmDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetBuyGiftConfirmDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d = !this$0.d;
        this$0.d().b.setImageResource(this$0.d ? R.drawable.live_planet_checkbox_select : R.drawable.live_planet_checkbox_not_select);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetBuyGiftConfirmDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d) {
            LiveRoomPreferences.X();
        }
        Callback callback = this$0.f13101c;
        if (callback != null) {
            callback.a();
        }
        this$0.dismissAllowingStateLoss();
    }

    private final LivePlanetBuyConfirmDialogBinding d() {
        return (LivePlanetBuyConfirmDialogBinding) this.b.getValue();
    }

    private final void e() {
        int i;
        int i2;
        Bundle arguments = getArguments();
        String str = "";
        if (arguments == null) {
            i = 0;
            i2 = 0;
        } else {
            i = arguments.getInt("gift_count", 0);
            i2 = arguments.getInt("gift_price", 0);
            str = arguments.getString("gift_img", "");
            Intrinsics.c(str, "it.getString(\"gift_img\", \"\")");
        }
        ImageLoader.a(a(), str).a(d().d);
        d().h.setText(AppInfo.d().getString(R.string.live_planet_dialog_insufficient_info, Integer.valueOf(i), Integer.valueOf(i2)));
        d().b.setImageResource(this.d ? R.drawable.live_planet_checkbox_select : R.drawable.live_planet_checkbox_not_select);
        d().f12363c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetBuyGiftConfirmDialog$lLxng-kNurlWZ6piutLKTiW6-QM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetBuyGiftConfirmDialog.a(LivePlanetBuyGiftConfirmDialog.this, view);
            }
        });
        d().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetBuyGiftConfirmDialog$wFRv5piH4uPZckQxuFTILzS7CT8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetBuyGiftConfirmDialog.b(LivePlanetBuyGiftConfirmDialog.this, view);
            }
        });
        d().f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetBuyGiftConfirmDialog$dxR-SHJeUhqk-CdSLN4ibz2JGJw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetBuyGiftConfirmDialog.c(LivePlanetBuyGiftConfirmDialog.this, view);
            }
        });
        d().f12362a.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetBuyGiftConfirmDialog$ATAsFwc_WdbZmAIeJOoQtIfnZok
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetBuyGiftConfirmDialog.a(LivePlanetBuyGiftConfirmDialog.this);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager windowManager;
        Display defaultDisplay;
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, -1));
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
        e();
        return dialog;
    }
}
