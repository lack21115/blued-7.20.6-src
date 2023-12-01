package com.soft.blued.ui.welcome;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.utils.PermissionUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.LayoutAdDownLoadAppDialogBinding;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/AdDownLoadAppDialogFragment.class */
public final class AdDownLoadAppDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f34505a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<LayoutAdDownLoadAppDialogBinding>() { // from class: com.soft.blued.ui.welcome.AdDownLoadAppDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LayoutAdDownLoadAppDialogBinding invoke() {
            return LayoutAdDownLoadAppDialogBinding.a(LayoutInflater.from(AdDownLoadAppDialogFragment.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private BluedADExtra.DownLoadModel f34506c;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/AdDownLoadAppDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AdDownLoadAppDialogFragment a(FragmentManager manager, Context context, BluedADExtra.DownLoadModel downLoadModel) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(context, "context");
            Intrinsics.e(downLoadModel, "downLoadModel");
            AdDownLoadAppDialogFragment adDownLoadAppDialogFragment = new AdDownLoadAppDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("down_load_model", downLoadModel);
            adDownLoadAppDialogFragment.setArguments(bundle);
            adDownLoadAppDialogFragment.show(manager, AdDownLoadAppDialogFragment.class.getSimpleName());
            return adDownLoadAppDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final AdDownLoadAppDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.welcome.AdDownLoadAppDialogFragment$initView$1$1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                AdDownLoadAppDialogFragment.this.g();
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
                AdDownLoadAppDialogFragment.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdDownLoadAppDialogFragment this$0, BluedADExtra.DownLoadModel this_apply, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(this_apply, "$this_apply");
        WebViewShowInfoFragment.show(this$0.getContext(), this_apply.app_privacy_url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdDownLoadAppDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdDownLoadAppDialogFragment this$0, BluedADExtra.DownLoadModel this_apply, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(this_apply, "$this_apply");
        WebViewShowInfoFragment.show(this$0.getContext(), this_apply.app_permission_url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AdDownLoadAppDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    private final LayoutAdDownLoadAppDialogBinding d() {
        return (LayoutAdDownLoadAppDialogBinding) this.b.getValue();
    }

    private final void e() {
        LayoutAdDownLoadAppDialogBinding d = d();
        final BluedADExtra.DownLoadModel downLoadModel = this.f34506c;
        if (downLoadModel == null) {
            return;
        }
        Log.v("drb", "下载apk   link=" + ((Object) downLoadModel.down_link) + ", appName=" + ((Object) downLoadModel.app_name));
        ImageLoader.a(a(), downLoadModel.app_icon).a(12.0f).a(d.f29379c);
        if (TextUtils.isEmpty(downLoadModel.app_name)) {
            d.g.setVisibility(8);
        } else {
            d.g.setText(downLoadModel.app_name);
        }
        if (TextUtils.isEmpty(downLoadModel.app_permission_url) || TextUtils.isEmpty(downLoadModel.app_privacy_url)) {
            d.e.setVisibility(8);
        } else {
            d.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$AdDownLoadAppDialogFragment$Is9V5N3-sgsvomOssuP62qx-9a4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdDownLoadAppDialogFragment.a(AdDownLoadAppDialogFragment.this, downLoadModel, view);
                }
            });
            d.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$AdDownLoadAppDialogFragment$AeA1cvaVCcPYTT78OG6ZOzhTrk4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdDownLoadAppDialogFragment.b(AdDownLoadAppDialogFragment.this, downLoadModel, view);
                }
            });
        }
        if (!TextUtils.isEmpty(downLoadModel.app_version)) {
            TextView textView = d.l;
            Context context = getContext();
            textView.setText(Intrinsics.a(context == null ? null : context.getString(R.string.ad_download_app_version), (Object) downLoadModel.app_version));
        }
        if (TextUtils.isEmpty(downLoadModel.app_size)) {
            return;
        }
        TextView textView2 = d.h;
        Context context2 = getContext();
        textView2.setText(Intrinsics.a(context2 == null ? null : context2.getString(R.string.ad_download_app_size), (Object) downLoadModel.app_size));
    }

    private final void f() {
        d().b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$AdDownLoadAppDialogFragment$4sn_6YZD9eQwUi9uj73Mte5VkRI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdDownLoadAppDialogFragment.a(AdDownLoadAppDialogFragment.this, view);
            }
        });
        d().f29378a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$AdDownLoadAppDialogFragment$0ge8QbMy1rB0Wke6z5Ds_s72lkY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdDownLoadAppDialogFragment.b(AdDownLoadAppDialogFragment.this, view);
            }
        });
        d().d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$AdDownLoadAppDialogFragment$Ja_iVKzhq96up7ibahGsU0265m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdDownLoadAppDialogFragment.c(AdDownLoadAppDialogFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        BluedADExtra.DownLoadModel downLoadModel = this.f34506c;
        if (downLoadModel == null) {
            return;
        }
        Log.v("drb", Intrinsics.a("「开机图下载」downLoadModel:", (Object) downLoadModel));
        ImageLoader.a(a(), downLoadModel.app_icon).c().a(new AdDownLoadAppDialogFragment$downloadApkIcon$1$1(this, downLoadModel));
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireActivity(), 2131953017);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        if (window == null) {
            return dialog;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(2131952742);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = AppInfo.l;
        attributes.height = -1;
        dialog.onWindowAttributesChanged(attributes);
        window.setFlags(67108864, 67108864);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        return super.onCreateView(inflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("down_load_model");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.login.model.BluedADExtra.DownLoadModel");
            }
            this.f34506c = (BluedADExtra.DownLoadModel) serializable;
        }
        f();
        e();
    }
}
