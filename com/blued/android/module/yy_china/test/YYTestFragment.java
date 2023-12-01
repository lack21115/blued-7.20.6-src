package com.blued.android.module.yy_china.test;

import android.content.Context;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentTestBinding;
import com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment;
import com.blued.login.test.LoginFragment;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYTestFragment.class */
public final class YYTestFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f17816c;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(YYTestFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentTestBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17815a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYTestFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, YYTestFragment.class, BundleKt.bundleOf(new Pair[0]));
        }
    }

    public YYTestFragment() {
        super(R.layout.fragment_test);
        this.f17816c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<YYTestFragment, FragmentTestBinding>() { // from class: com.blued.android.module.yy_china.test.YYTestFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentTestBinding invoke(YYTestFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentTestBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<YYTestFragment, FragmentTestBinding>() { // from class: com.blued.android.module.yy_china.test.YYTestFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentTestBinding invoke(YYTestFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentTestBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        YYChatRoomsListFragment.Companion companion = YYChatRoomsListFragment.f17120a;
        Context context = view.getContext();
        Intrinsics.c(context, "it.context");
        companion.a(context, "home_chat_room");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYTestFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LoginFragment.f20569a.a(this$0.getContext());
        UserInfo.getInstance().logout(false);
        IMManager.a().c();
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final FragmentTestBinding p() {
        return (FragmentTestBinding) this.f17816c.b(this, b[0]);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        FragmentTestBinding p = p();
        if (p != null && (shapeTextView2 = p.f16486a) != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.test.-$$Lambda$YYTestFragment$cjrjJmGOMpT0521bjMM8qI-HrCA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYTestFragment.a(view);
                }
            });
        }
        FragmentTestBinding p2 = p();
        if (p2 != null && (shapeTextView = p2.b) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.test.-$$Lambda$YYTestFragment$_-m6ZTwaqbQNpIR4eg7IvEKjG9Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYTestFragment.a(YYTestFragment.this, view);
                }
            });
        }
        Host.a(1);
        IMManager.a().b();
        ChatManager.getInstance().setServerInfo(BluedHttpUrl.t(), BluedHttpUrl.u(), BluedHttpUrl.v(), HappyDnsUtils.d(), HappyDnsUtils.a(), BluedHttpUrl.h());
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }
}
