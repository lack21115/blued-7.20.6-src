package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvi.EmptyMviViewModel;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.PopOpenCallTwiceBinding;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.home.HomeActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/OpenCallTwiceDialogFragment.class */
public final class OpenCallTwiceDialogFragment extends MVIBaseFragment<EmptyMviViewModel> {
    private final ViewBindingProperty d;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f18685c = {(KProperty) Reflection.a(new PropertyReference1Impl(OpenCallTwiceDialogFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/PopOpenCallTwiceBinding;", 0))};
    public static final Companion b = new Companion(null);
    private static final String e = "button_str";
    private static final String f = "button_img";
    private static final String g = "from";
    private static final String h = "is_secret";

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/OpenCallTwiceDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return OpenCallTwiceDialogFragment.e;
        }

        public final void a(Context context, String str, String str2, int i, boolean z) {
            Intrinsics.e(context, "context");
            Intrinsics.e(str, "buttonStr");
            Intrinsics.e(str2, "buttonImg");
            Bundle bundle = new Bundle();
            bundle.putString(a(), str);
            bundle.putString(b(), str2);
            bundle.putInt(c(), i);
            bundle.putBoolean(d(), z);
            TransparentActivity.a(bundle);
            TransparentActivity.b(context, OpenCallTwiceDialogFragment.class, bundle);
        }

        public final String b() {
            return OpenCallTwiceDialogFragment.f;
        }

        public final String c() {
            return OpenCallTwiceDialogFragment.g;
        }

        public final String d() {
            return OpenCallTwiceDialogFragment.h;
        }
    }

    public OpenCallTwiceDialogFragment() {
        super((int) R.layout.pop_open_call_twice);
        this.d = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<OpenCallTwiceDialogFragment, PopOpenCallTwiceBinding>() { // from class: com.soft.blued.ui.msg.fragment.OpenCallTwiceDialogFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg/fragment/OpenCallTwiceDialogFragment;)Lcom/soft/blued/databinding/PopOpenCallTwiceBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return PopOpenCallTwiceBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<OpenCallTwiceDialogFragment, PopOpenCallTwiceBinding>() { // from class: com.soft.blued.ui.msg.fragment.OpenCallTwiceDialogFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg/fragment/OpenCallTwiceDialogFragment;)Lcom/soft/blued/databinding/PopOpenCallTwiceBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return PopOpenCallTwiceBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentActivity fragmentActivity) {
        Intrinsics.e(fragmentActivity, "$it");
        fragmentActivity.finish();
        ActivityChangeAnimationUtils.h(fragmentActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.BooleanRef booleanRef, Ref.IntRef intRef, OpenCallTwiceDialogFragment openCallTwiceDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(booleanRef, "$isSecret");
        Intrinsics.e(intRef, "$fromPage");
        Intrinsics.e(openCallTwiceDialogFragment, "this$0");
        EventTrackGuy.a(GuyProtos.Event.CALL_MORE_TIMES_POP_TWO_CLICK);
        CallHelloManager.a().a((Context) HomeActivity.f17295c, (IRequestHost) null, booleanRef.a, intRef.a, true);
        openCallTwiceDialogFragment.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Ref.BooleanRef booleanRef, Ref.IntRef intRef, OpenCallTwiceDialogFragment openCallTwiceDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(booleanRef, "$isSecret");
        Intrinsics.e(intRef, "$fromPage");
        Intrinsics.e(openCallTwiceDialogFragment, "this$0");
        EventTrackGuy.a(GuyProtos.Event.CALL_MORE_TIMES_POP_ONE_CLICK);
        CallHelloManager.a().a((Context) HomeActivity.f17295c, (IRequestHost) null, booleanRef.a, intRef.a, false);
        openCallTwiceDialogFragment.f();
    }

    private final PopOpenCallTwiceBinding e() {
        return (PopOpenCallTwiceBinding) this.d.b(this, f18685c[0]);
    }

    private final void f() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$OpenCallTwiceDialogFragment$IoRIuI20i1PiidGkIcoFUQnYGZs
            @Override // java.lang.Runnable
            public final void run() {
                OpenCallTwiceDialogFragment.a(FragmentActivity.this);
            }
        }, 200L);
    }

    public void m() {
        String string;
        ShapeTextView shapeTextView;
        TextView textView;
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Bundle arguments = getArguments();
        String str = "";
        if (arguments == null) {
            string = "";
        } else {
            str = arguments.getString(e, "");
            Intrinsics.c(str, "getString(BUTTON_STR, \"\")");
            string = arguments.getString(f, "");
            Intrinsics.c(string, "getString(BUTTON_IMG, \"\")");
            intRef.a = arguments.getInt(g);
            booleanRef.a = arguments.getBoolean(h);
        }
        PopOpenCallTwiceBinding e2 = e();
        if (e2 != null) {
            String str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                e2.b.setText(str2);
            }
            if (!TextUtils.isEmpty(string)) {
                ImageLoader.a((IRequestHost) null, string).a(e2.f15861c);
            }
        }
        PopOpenCallTwiceBinding e3 = e();
        if (e3 != null && (textView = e3.b) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$OpenCallTwiceDialogFragment$qmNmq26VujxIG2DTLAvA-H4dlD0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpenCallTwiceDialogFragment.a(booleanRef, intRef, this, view);
                }
            });
        }
        PopOpenCallTwiceBinding e4 = e();
        if (e4 != null && (shapeTextView = e4.f15860a) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$OpenCallTwiceDialogFragment$3uT8pq4wbvHeH4T5Ho0k2aOajmY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpenCallTwiceDialogFragment.b(booleanRef, intRef, this, view);
                }
            });
        }
        EventTrackGuy.a(GuyProtos.Event.CALL_MORE_TIMES_POP_SHOW);
    }

    public void o() {
    }

    public boolean onBackPressed() {
        f();
        return true;
    }

    public void v() {
        super.v();
        ActivityChangeAnimationUtils.h(getActivity());
    }
}
