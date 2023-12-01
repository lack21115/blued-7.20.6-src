package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLivePocketPropDesBinding;
import com.blued.android.module.live_china.model.LivePocketModel;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePropsDesDialogFragment.class */
public final class LivePropsDesDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13165a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<DialogLivePocketPropDesBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePropsDesDialogFragment$viewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLivePocketPropDesBinding invoke() {
            return DialogLivePocketPropDesBinding.a(LayoutInflater.from(LivePropsDesDialogFragment.this.getContext()));
        }
    });

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePropsDesDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LivePropsDesDialogFragment a(FragmentManager manager, LivePocketModel model) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(model, "model");
            LivePropsDesDialogFragment livePropsDesDialogFragment = new LivePropsDesDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("props", model);
            livePropsDesDialogFragment.setArguments(bundle);
            livePropsDesDialogFragment.show(manager, LivePropsDesDialogFragment.class.getSimpleName());
            return livePropsDesDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePropsDesDialogFragment$EventCallback.class */
    public interface EventCallback {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePropsDesDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePropsDesDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    private final void e() {
        String format;
        Bundle arguments = getArguments();
        Serializable serializable = arguments == null ? null : arguments.getSerializable("props");
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LivePocketModel");
        }
        LivePocketModel livePocketModel = (LivePocketModel) serializable;
        d().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePropsDesDialogFragment$trGybux5cGRm_I5pvOLOe25cLVM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePropsDesDialogFragment.a(view);
            }
        });
        d().f11803a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePropsDesDialogFragment$uLnHCDvK1Zzn-oN5jfNNRf2vN6g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePropsDesDialogFragment.a(LivePropsDesDialogFragment.this, view);
            }
        });
        d().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePropsDesDialogFragment$AN4QBPCJ9hRVSJMVv4krQIb_nNU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePropsDesDialogFragment.b(LivePropsDesDialogFragment.this, view);
            }
        });
        ImageLoader.a(a(), livePocketModel.getImage()).a(d().f11804c);
        d().d.setText(livePocketModel.getDescription());
        d().g.setText(livePocketModel.getName());
        if (livePocketModel.getEffect_time() > 0) {
            d().e.setVisibility(0);
            if (livePocketModel.getEffect_time() < b.P) {
                TextView textView = d().e;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = getString(R.string.live_pocket_exp_time_minute);
                Intrinsics.c(string, "getString(R.string.live_pocket_exp_time_minute)");
                String format2 = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(livePocketModel.getEffect_time() / 60)}, 1));
                Intrinsics.c(format2, "format(format, *args)");
                textView.setText(format2);
            } else {
                TextView textView2 = d().e;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
                String string2 = getString(R.string.live_pocket_exp_time_hour);
                Intrinsics.c(string2, "getString(R.string.live_pocket_exp_time_hour)");
                String format3 = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(livePocketModel.getEffect_time() / 3600)}, 1));
                Intrinsics.c(format3, "format(format, *args)");
                textView2.setText(format3);
            }
        } else {
            d().e.setVisibility(8);
        }
        if (livePocketModel.getExpire_time() == -1) {
            d().f.setVisibility(0);
            d().f.setText(getString(R.string.never_expires));
            return;
        }
        d().f.setVisibility(0);
        SimpleDateFormat simpleDateFormat = TimeAndDateUtils.f10914c.get();
        if (TextUtils.equals(simpleDateFormat == null ? null : simpleDateFormat.format(new Date(livePocketModel.getExpire_time() * 1000)), "23:59:59")) {
            SimpleDateFormat simpleDateFormat2 = TimeAndDateUtils.m.get();
            format = simpleDateFormat2 == null ? null : simpleDateFormat2.format(new Date(livePocketModel.getExpire_time() * 1000));
        } else {
            SimpleDateFormat simpleDateFormat3 = TimeAndDateUtils.l.get();
            format = simpleDateFormat3 == null ? null : simpleDateFormat3.format(new Date(livePocketModel.getExpire_time() * 1000));
        }
        String str = format;
        if (format == null) {
            str = "";
        }
        TextView textView3 = d().f;
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.f42549a;
        String string3 = getString(R.string.live_pocket_date_use);
        Intrinsics.c(string3, "getString(R.string.live_pocket_date_use)");
        String format4 = String.format(string3, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.c(format4, "format(format, *args)");
        textView3.setText(format4);
    }

    private final void f() {
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.a(dialog);
            if (dialog.isShowing()) {
                dismissAllowingStateLoss();
            }
        }
    }

    public final DialogLivePocketPropDesBinding d() {
        return (DialogLivePocketPropDesBinding) this.b.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.alpha_menu_animstyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        e();
        return super.onCreateView(inflater, viewGroup, bundle);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
