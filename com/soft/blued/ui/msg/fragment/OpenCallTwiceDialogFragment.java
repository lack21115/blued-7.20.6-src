package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
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
    static final /* synthetic */ KProperty<Object>[] f32375c = {Reflection.a(new PropertyReference1Impl(OpenCallTwiceDialogFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/PopOpenCallTwiceBinding;", 0))};
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

        public final void a(Context context, String buttonStr, String buttonImg, int i, boolean z) {
            Intrinsics.e(context, "context");
            Intrinsics.e(buttonStr, "buttonStr");
            Intrinsics.e(buttonImg, "buttonImg");
            Bundle bundle = new Bundle();
            bundle.putString(a(), buttonStr);
            bundle.putString(b(), buttonImg);
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
        super(R.layout.pop_open_call_twice);
        this.d = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<OpenCallTwiceDialogFragment, PopOpenCallTwiceBinding>() { // from class: com.soft.blued.ui.msg.fragment.OpenCallTwiceDialogFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopOpenCallTwiceBinding invoke(OpenCallTwiceDialogFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return PopOpenCallTwiceBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<OpenCallTwiceDialogFragment, PopOpenCallTwiceBinding>() { // from class: com.soft.blued.ui.msg.fragment.OpenCallTwiceDialogFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopOpenCallTwiceBinding invoke(OpenCallTwiceDialogFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return PopOpenCallTwiceBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentActivity it) {
        Intrinsics.e(it, "$it");
        it.finish();
        ActivityChangeAnimationUtils.h(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.BooleanRef isSecret, Ref.IntRef fromPage, OpenCallTwiceDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(isSecret, "$isSecret");
        Intrinsics.e(fromPage, "$fromPage");
        Intrinsics.e(this$0, "this$0");
        EventTrackGuy.a(GuyProtos.Event.CALL_MORE_TIMES_POP_TWO_CLICK);
        CallHelloManager.a().a((Context) HomeActivity.f30985c, (IRequestHost) null, isSecret.f42538a, fromPage.f42543a, true);
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Ref.BooleanRef isSecret, Ref.IntRef fromPage, OpenCallTwiceDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(isSecret, "$isSecret");
        Intrinsics.e(fromPage, "$fromPage");
        Intrinsics.e(this$0, "this$0");
        EventTrackGuy.a(GuyProtos.Event.CALL_MORE_TIMES_POP_ONE_CLICK);
        CallHelloManager.a().a((Context) HomeActivity.f30985c, (IRequestHost) null, isSecret.f42538a, fromPage.f42543a, false);
        this$0.f();
    }

    private final PopOpenCallTwiceBinding e() {
        return (PopOpenCallTwiceBinding) this.d.b(this, f32375c[0]);
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

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
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
            intRef.f42543a = arguments.getInt(g);
            booleanRef.f42538a = arguments.getBoolean(h);
        }
        PopOpenCallTwiceBinding e2 = e();
        if (e2 != null) {
            String str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                e2.b.setText(str2);
            }
            if (!TextUtils.isEmpty(string)) {
                ImageLoader.a((IRequestHost) null, string).a(e2.f29551c);
            }
        }
        PopOpenCallTwiceBinding e3 = e();
        if (e3 != null && (textView = e3.b) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$OpenCallTwiceDialogFragment$qmNmq26VujxIG2DTLAvA-H4dlD0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpenCallTwiceDialogFragment.a(Ref.BooleanRef.this, intRef, this, view);
                }
            });
        }
        PopOpenCallTwiceBinding e4 = e();
        if (e4 != null && (shapeTextView = e4.f29550a) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$OpenCallTwiceDialogFragment$3uT8pq4wbvHeH4T5Ho0k2aOajmY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpenCallTwiceDialogFragment.b(Ref.BooleanRef.this, intRef, this, view);
                }
            });
        }
        EventTrackGuy.a(GuyProtos.Event.CALL_MORE_TIMES_POP_SHOW);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        f();
        return true;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void v() {
        super.v();
        ActivityChangeAnimationUtils.h(getActivity());
    }
}
