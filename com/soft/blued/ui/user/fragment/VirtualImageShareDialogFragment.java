package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.soft.blued.R;
import com.soft.blued.databinding.DialogFragmentVirtualImageShareBinding;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageShareDialogFragment.class */
public final class VirtualImageShareDialogFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f20530c;
    private String d;
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(VirtualImageShareDialogFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/DialogFragmentVirtualImageShareBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20529a = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageShareDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, BaseFragmentActivity baseFragmentActivity, Bundle bundle) {
            Intrinsics.e(context, "context");
            Intrinsics.e(bundle, TTLiveConstants.BUNDLE_KEY);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, VirtualImageShareDialogFragment.class, bundle);
            if (baseFragmentActivity instanceof Activity) {
                ActivityChangeAnimationUtils.i((Activity) baseFragmentActivity);
            }
        }
    }

    public VirtualImageShareDialogFragment() {
        super((int) R.layout.dialog_fragment_virtual_image_share);
        this.f20530c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<VirtualImageShareDialogFragment, DialogFragmentVirtualImageShareBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageShareDialogFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImageShareDialogFragment;)Lcom/soft/blued/databinding/DialogFragmentVirtualImageShareBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return DialogFragmentVirtualImageShareBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VirtualImageShareDialogFragment, DialogFragmentVirtualImageShareBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageShareDialogFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImageShareDialogFragment;)Lcom/soft/blued/databinding/DialogFragmentVirtualImageShareBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return DialogFragmentVirtualImageShareBinding.a(fragment.requireView());
            }
        });
        this.d = "";
    }

    private final Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageShareDialogFragment virtualImageShareDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageShareDialogFragment, "this$0");
        virtualImageShareDialogFragment.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageShareDialogFragment virtualImageShareDialogFragment, DialogFragmentVirtualImageShareBinding dialogFragmentVirtualImageShareBinding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageShareDialogFragment, "this$0");
        Intrinsics.e(dialogFragmentVirtualImageShareBinding, "$vb");
        ShareEntity shareEntity = new ShareEntity();
        Context context = virtualImageShareDialogFragment.getContext();
        shareEntity.content = context == null ? null : context.getString(R.string.user_virtual_image_share_feed_content);
        CardView cardView = dialogFragmentVirtualImageShareBinding.f15011a;
        Intrinsics.c(cardView, "vb.cardUserFace");
        shareEntity.netImgUrl = virtualImageShareDialogFragment.a(virtualImageShareDialogFragment.a(cardView), false);
        shareEntity.shareType = 1;
        FeedAddPostFragment.a(virtualImageShareDialogFragment.getContext(), shareEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageShareDialogFragment virtualImageShareDialogFragment, DialogFragmentVirtualImageShareBinding dialogFragmentVirtualImageShareBinding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageShareDialogFragment, "this$0");
        Intrinsics.e(dialogFragmentVirtualImageShareBinding, "$vb");
        LinearLayout linearLayout = dialogFragmentVirtualImageShareBinding.d;
        Intrinsics.c(linearLayout, "vb.linearLayout");
        virtualImageShareDialogFragment.a(virtualImageShareDialogFragment.a(linearLayout), true);
    }

    private final DialogFragmentVirtualImageShareBinding p() {
        return (DialogFragmentVirtualImageShareBinding) this.f20530c.b(this, b[0]);
    }

    private final void q() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        r();
        activity.finish();
        ActivityChangeAnimationUtils.j(activity);
    }

    private final void r() {
        File file = new File(this.d);
        if (file.exists()) {
            file.delete();
        }
    }

    public final String a(Bitmap bitmap, boolean z) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String str = externalStoragePublicDirectory.getAbsolutePath() + ((Object) File.separator) + "blued";
        String str2 = "";
        if (bitmap != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(z ? ".png" : "");
            String sb2 = sb.toString();
            str2 = "";
            if (Intrinsics.a(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState())) {
                String str3 = str;
                if (str == null) {
                    File externalStoragePublicDirectory2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    str3 = externalStoragePublicDirectory2.getAbsolutePath() + ((Object) File.separator) + "blued";
                }
                String str4 = str3 + ((Object) File.separator) + sb2;
                if (Build.VERSION.SDK_INT < 29 || Environment.isExternalStorageLegacy()) {
                    ImageUtils.b(bitmap, str4, 100, false);
                    AppUtils.a(AppInfo.d(), str4, z);
                    str2 = str4;
                } else {
                    ImageUtils.a(bitmap, sb2, Intrinsics.a(Environment.DIRECTORY_PICTURES, "/blued"), 100, false);
                    str2 = str4;
                    if (z) {
                        AppMethods.a(Intrinsics.a(AppInfo.d().getString(2131891268), str4));
                        return str4;
                    }
                }
            }
        }
        return str2;
    }

    public void f() {
        final DialogFragmentVirtualImageShareBinding p = p();
        if (p == null) {
            return;
        }
        p.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageShareDialogFragment$oSFDr-kXp-4RwrTaJoaKsYSi8TQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageShareDialogFragment.a(VirtualImageShareDialogFragment.this, view);
            }
        });
        TextView textView = p.h;
        String str = UserInfo.getInstance().getLoginUserInfo().name;
        Context context = getContext();
        textView.setText(Intrinsics.a(str, context == null ? null : context.getString(R.string.user_virtual_image_share_dialog_title)));
        ViewGroup.LayoutParams layoutParams = p.f15012c.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.height = (int) (AppInfo.m * 0.6f);
        p.f15012c.setLayoutParams(layoutParams2);
        ImageLoader.d(getFragmentActive(), this.d).b((int) R.drawable.feed_photo_default).a(10.0f).a(p.f15012c);
        p.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageShareDialogFragment$20ElmBtd85BYk3_caMw1cutfXAw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageShareDialogFragment.a(VirtualImageShareDialogFragment.this, p, view);
            }
        });
        p.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageShareDialogFragment$WpVevC8SGKspgMpE-tRFlIFGwz0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageShareDialogFragment.b(VirtualImageShareDialogFragment.this, p, view);
            }
        });
    }

    public void l() {
    }

    public boolean onBackPressed() {
        q();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.d = String.valueOf(arguments.getString("user_face"));
    }
}
