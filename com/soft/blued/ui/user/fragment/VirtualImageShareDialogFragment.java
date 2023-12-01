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
import androidx.fragment.app.FragmentActivity;
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
    private final ViewBindingProperty f34221c;
    private String d;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(VirtualImageShareDialogFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/DialogFragmentVirtualImageShareBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f34220a = new Companion(null);

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
            Intrinsics.e(bundle, "bundle");
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, VirtualImageShareDialogFragment.class, bundle);
            if (baseFragmentActivity instanceof Activity) {
                ActivityChangeAnimationUtils.i(baseFragmentActivity);
            }
        }
    }

    public VirtualImageShareDialogFragment() {
        super(R.layout.dialog_fragment_virtual_image_share);
        this.f34221c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<VirtualImageShareDialogFragment, DialogFragmentVirtualImageShareBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageShareDialogFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogFragmentVirtualImageShareBinding invoke(VirtualImageShareDialogFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return DialogFragmentVirtualImageShareBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VirtualImageShareDialogFragment, DialogFragmentVirtualImageShareBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageShareDialogFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogFragmentVirtualImageShareBinding invoke(VirtualImageShareDialogFragment fragment) {
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
    public static final void a(VirtualImageShareDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageShareDialogFragment this$0, DialogFragmentVirtualImageShareBinding vb, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vb, "$vb");
        ShareEntity shareEntity = new ShareEntity();
        Context context = this$0.getContext();
        shareEntity.content = context == null ? null : context.getString(R.string.user_virtual_image_share_feed_content);
        CardView cardView = vb.f28701a;
        Intrinsics.c(cardView, "vb.cardUserFace");
        shareEntity.netImgUrl = this$0.a(this$0.a(cardView), false);
        shareEntity.shareType = 1;
        FeedAddPostFragment.a(this$0.getContext(), shareEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageShareDialogFragment this$0, DialogFragmentVirtualImageShareBinding vb, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vb, "$vb");
        LinearLayout linearLayout = vb.d;
        Intrinsics.c(linearLayout, "vb.linearLayout");
        this$0.a(this$0.a(linearLayout), true);
    }

    private final DialogFragmentVirtualImageShareBinding p() {
        return (DialogFragmentVirtualImageShareBinding) this.f34221c.b(this, b[0]);
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
            if (Intrinsics.a((Object) Environment.MEDIA_MOUNTED, (Object) Environment.getExternalStorageState())) {
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
                    ImageUtils.a(bitmap, sb2, Intrinsics.a(Environment.DIRECTORY_PICTURES, (Object) "/blued"), 100, false);
                    str2 = str4;
                    if (z) {
                        AppMethods.a((CharSequence) Intrinsics.a(AppInfo.d().getString(2131891268), (Object) str4));
                        return str4;
                    }
                }
            }
        }
        return str2;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
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
        textView.setText(Intrinsics.a(str, (Object) (context == null ? null : context.getString(R.string.user_virtual_image_share_dialog_title))));
        ViewGroup.LayoutParams layoutParams = p.f28702c.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.height = (int) (AppInfo.m * 0.6f);
        p.f28702c.setLayoutParams(layoutParams2);
        ImageLoader.d(getFragmentActive(), this.d).b(2131232687).a(10.0f).a(p.f28702c);
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

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        q();
        return true;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.d = String.valueOf(arguments.getString("user_face"));
    }
}
