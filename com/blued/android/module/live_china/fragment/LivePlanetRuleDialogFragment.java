package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live.base.view.subscaleview.ImageSource;
import com.blued.android.module.live.base.view.subscaleview.ImageViewState;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLivePlanetRuleBinding;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRuleDialogFragment.class */
public final class LivePlanetRuleDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<FragmentLivePlanetRuleBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePlanetRuleDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentLivePlanetRuleBinding invoke() {
            return FragmentLivePlanetRuleBinding.a(LayoutInflater.from(LivePlanetRuleDialogFragment.this.getContext()));
        }
    });
    private String c = "";

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRuleDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LivePlanetRuleDialogFragment a(Fragment fragment, String tip) {
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(tip, "tip");
            LivePlanetRuleDialogFragment livePlanetRuleDialogFragment = new LivePlanetRuleDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("tip", tip);
            livePlanetRuleDialogFragment.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            livePlanetRuleDialogFragment.show(childFragmentManager, LivePlanetRuleDialogFragment.class.getSimpleName());
            return livePlanetRuleDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetRuleDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final LivePlanetRuleDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.a = this$0.e().b.getWidth();
        final ImageSize imageSize = new ImageSize();
        ImageFileLoader.a(this$0.a()).a(this$0.c).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.fragment.LivePlanetRuleDialogFragment$getData$1$1
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                FragmentLivePlanetRuleBinding e;
                FragmentLivePlanetRuleBinding e2;
                if (file == null || !file.exists()) {
                    return;
                }
                e = LivePlanetRuleDialogFragment.this.e();
                e.b.setZoomEnabled(false);
                float a2 = imageSize.a();
                float f = 1.0f;
                if (intRef.a > 0) {
                    f = 1.0f;
                    if (a2 > 0.0f) {
                        f = (intRef.a * 1.0f) / a2;
                    }
                }
                e2 = LivePlanetRuleDialogFragment.this.e();
                e2.b.a(ImageSource.b(file.getAbsolutePath()), new ImageViewState(f, new PointF(0.0f, 0.0f), 0));
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLivePlanetRuleBinding e() {
        return (FragmentLivePlanetRuleBinding) this.b.getValue();
    }

    private final void f() {
        e().b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetRuleDialogFragment$vXN0F-gIcJsRWY7BbhOVAIxkDeo
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetRuleDialogFragment.b(LivePlanetRuleDialogFragment.this);
            }
        });
        e().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetRuleDialogFragment$IoGRi65ssa9lBYdBYRMloIQKXmM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetRuleDialogFragment.a(LivePlanetRuleDialogFragment.this, view);
            }
        });
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.c = str;
    }

    public final void d() {
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.a(dialog);
            if (dialog.isShowing()) {
                dismissAllowingStateLoss();
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 520.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(e().getRoot(), new ViewGroup.LayoutParams(-1, a2));
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

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(e().getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("tip", "");
            Intrinsics.c(string, "it.getString(\"tip\", \"\")");
            a(string);
        }
        f();
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
