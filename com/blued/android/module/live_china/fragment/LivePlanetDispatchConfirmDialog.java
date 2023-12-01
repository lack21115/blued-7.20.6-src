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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LivePlanetDispatchConfirmDialogBinding;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetDispatchConfirmDialog.class */
public final class LivePlanetDispatchConfirmDialog extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private Callback c;
    private final Lazy b = LazyKt.a(new Function0<LivePlanetDispatchConfirmDialogBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePlanetDispatchConfirmDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LivePlanetDispatchConfirmDialogBinding invoke() {
            return LivePlanetDispatchConfirmDialogBinding.a(LayoutInflater.from(LivePlanetDispatchConfirmDialog.this.getContext()));
        }
    });
    private boolean d = true;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetDispatchConfirmDialog$Callback.class */
    public interface Callback {
        void a();
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetDispatchConfirmDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Fragment fragment, int i, int i2, Callback callback) {
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(callback, "callback");
            LivePlanetDispatchConfirmDialog livePlanetDispatchConfirmDialog = new LivePlanetDispatchConfirmDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("bet_num_count", i);
            bundle.putInt("bet_time", i2);
            livePlanetDispatchConfirmDialog.c = callback;
            livePlanetDispatchConfirmDialog.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            livePlanetDispatchConfirmDialog.show(childFragmentManager, LivePlanetDispatchConfirmDialog.class.getSimpleName());
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
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDispatchConfirmDialog$apza7jh1xqDlrxCSBRevtTXbRmw
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivePlanetDispatchConfirmDialog.a(OvershootInterpolator.this, viewGroup, a2, width, decelerateInterpolator, height, valueAnimator);
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
    public static final void a(LivePlanetDispatchConfirmDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        FrameLayout frameLayout = this$0.d().a;
        Intrinsics.c(frameLayout, "vb.flRoot");
        this$0.a(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetDispatchConfirmDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetDispatchConfirmDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d = !this$0.d;
        this$0.d().b.setImageResource(this$0.d ? R.drawable.live_planet_checkbox_select : R.drawable.live_planet_checkbox_not_select);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetDispatchConfirmDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d) {
            LiveRoomPreferences.V();
        }
        Callback callback = this$0.c;
        if (callback != null) {
            callback.a();
        }
        this$0.dismissAllowingStateLoss();
    }

    private final LivePlanetDispatchConfirmDialogBinding d() {
        return (LivePlanetDispatchConfirmDialogBinding) this.b.getValue();
    }

    private final void e() {
        int i;
        int i2;
        Bundle arguments = getArguments();
        if (arguments == null) {
            i2 = 0;
            i = 0;
        } else {
            i = arguments.getInt("bet_num_count", 0);
            i2 = arguments.getInt("bet_time", 0);
        }
        d().g.setText(AppInfo.d().getString(R.string.live_planet_dialog_verify_dispatch_count, Integer.valueOf(i)));
        d().g.setText(LiveUtils.a(d().g.getText(), "#FFEF5F", false));
        d().h.setText(AppInfo.d().getString(R.string.live_planet_dialog_dispatch_count_down, Integer.valueOf(i2)));
        d().h.setText(LiveUtils.a(d().h.getText(), "#FFEF5F", false));
        d().b.setImageResource(this.d ? R.drawable.live_planet_checkbox_select : R.drawable.live_planet_checkbox_not_select);
        d().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDispatchConfirmDialog$cUJcilr0VLgJpqEgO_sjzX9-4Ls
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDispatchConfirmDialog.a(LivePlanetDispatchConfirmDialog.this, view);
            }
        });
        d().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDispatchConfirmDialog$gztzQbcpvjrXYlmSh8YkCLtZkbM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDispatchConfirmDialog.b(LivePlanetDispatchConfirmDialog.this, view);
            }
        });
        d().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDispatchConfirmDialog$nZ5cR8EUEi4-BDf4SAIchLX9kYA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetDispatchConfirmDialog.c(LivePlanetDispatchConfirmDialog.this, view);
            }
        });
        d().a.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetDispatchConfirmDialog$iOXnmnOeEpQ5q7IM8sZpP_zJXo8
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetDispatchConfirmDialog.a(LivePlanetDispatchConfirmDialog.this);
            }
        });
    }

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
