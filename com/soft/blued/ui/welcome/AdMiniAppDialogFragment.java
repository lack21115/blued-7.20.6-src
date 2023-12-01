package com.soft.blued.ui.welcome;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.das.login.LoginAndRegisterProtos;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.OapsWrapper;
import com.soft.blued.R;
import com.soft.blued.databinding.LayoutAdMiniAppDialogBinding;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.utils.WeChatUtils;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/AdMiniAppDialogFragment.class */
public final class AdMiniAppDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20819a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<LayoutAdMiniAppDialogBinding>() { // from class: com.soft.blued.ui.welcome.AdMiniAppDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: a */
        public final LayoutAdMiniAppDialogBinding invoke() {
            return LayoutAdMiniAppDialogBinding.a(LayoutInflater.from(AdMiniAppDialogFragment.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private String f20820c = "";
    private String d = "";
    private BluedADExtra e;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/AdMiniAppDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AdMiniAppDialogFragment a(FragmentManager fragmentManager, String str, String str2, BluedADExtra bluedADExtra) {
            Intrinsics.e(fragmentManager, "manager");
            Intrinsics.e(str, "id");
            Intrinsics.e(str2, OapsWrapper.KEY_PATH);
            AdMiniAppDialogFragment adMiniAppDialogFragment = new AdMiniAppDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("mini_app_id", str);
            bundle.putString("mini_app_path", str2);
            bundle.putSerializable("ad_model", (Serializable) bluedADExtra);
            adMiniAppDialogFragment.setArguments(bundle);
            adMiniAppDialogFragment.show(fragmentManager, AdMiniAppDialogFragment.class.getSimpleName());
            return adMiniAppDialogFragment;
        }
    }

    @JvmStatic
    public static final AdMiniAppDialogFragment a(FragmentManager fragmentManager, String str, String str2, BluedADExtra bluedADExtra) {
        return f20819a.a(fragmentManager, str, str2, bluedADExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdMiniAppDialogFragment adMiniAppDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(adMiniAppDialogFragment, "this$0");
        WeChatUtils.a(adMiniAppDialogFragment.getContext(), adMiniAppDialogFragment.f20820c, adMiniAppDialogFragment.d);
        BluedADExtra bluedADExtra = adMiniAppDialogFragment.e;
        if (bluedADExtra != null) {
            Log.v("drb", "广告_启动小程序二次确认弹窗_允许_点击");
            EventTrackLoginAndRegister.e(LoginAndRegisterProtos.Event.AD_APPLET_OPEN_POP_YES_CLICK, bluedADExtra);
        }
        adMiniAppDialogFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdMiniAppDialogFragment adMiniAppDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(adMiniAppDialogFragment, "this$0");
        adMiniAppDialogFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AdMiniAppDialogFragment adMiniAppDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(adMiniAppDialogFragment, "this$0");
        adMiniAppDialogFragment.dismiss();
    }

    private final LayoutAdMiniAppDialogBinding d() {
        return (LayoutAdMiniAppDialogBinding) this.b.getValue();
    }

    private final void e() {
        Log.v("drb", Intrinsics.a("启动小程序弹窗 adExtra:", this.e));
        BluedADExtra bluedADExtra = this.e;
        if (bluedADExtra != null) {
            Log.v("drb", "广告_启动小程序二次确认弹窗_曝光");
            EventTrackLoginAndRegister.e(LoginAndRegisterProtos.Event.AD_APPLET_OPEN_POP_SHOW, bluedADExtra);
        }
        d().e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$AdMiniAppDialogFragment$M-zKZ0EIRZFqpLQw2SfuAJtrgG8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdMiniAppDialogFragment.a(AdMiniAppDialogFragment.this, view);
            }
        });
        d().f15691c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$AdMiniAppDialogFragment$Sm7dmyqdBBVNokS9QGH7EC3QIMQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdMiniAppDialogFragment.b(AdMiniAppDialogFragment.this, view);
            }
        });
        d().f15690a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$AdMiniAppDialogFragment$w-o76tKQltD5baDISurPsNKK9-Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdMiniAppDialogFragment.c(AdMiniAppDialogFragment.this, view);
            }
        });
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        if (window == null) {
            return dialog;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.alpha_menu_slow_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = AppInfo.l;
        attributes.height = -1;
        dialog.onWindowAttributesChanged(attributes);
        window.setFlags(67108864, 67108864);
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(layoutInflater, "inflater");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f20820c = arguments.getString("mini_app_id");
            this.d = arguments.getString("mini_app_path");
            this.e = arguments.getSerializable("ad_model");
        }
        e();
    }
}
