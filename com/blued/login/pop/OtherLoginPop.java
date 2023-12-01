package com.blued.login.pop;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.R;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.databinding.PopOtherLoginBinding;
import com.blued.login.log.EventTrackLogin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/pop/OtherLoginPop.class */
public final class OtherLoginPop extends BottomPopupView {
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(OtherLoginPop.class, "vb", "getVb()Lcom/blued/login/databinding/PopOtherLoginBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final Context f20564c;
    private final Bundle d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtherLoginPop(Context ctx, Bundle bundle) {
        super(ctx);
        Intrinsics.e(ctx, "ctx");
        this.f20564c = ctx;
        this.d = bundle;
        this.e = new CustomViewBindingProperty(new Function1<OtherLoginPop, PopOtherLoginBinding>() { // from class: com.blued.login.pop.OtherLoginPop$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopOtherLoginBinding invoke(OtherLoginPop popView) {
                Intrinsics.e(popView, "popView");
                return PopOtherLoginBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OtherLoginPop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLogin.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.EMAIL);
        this$0.p();
        LoginServiceManager.a().d(this$0.f20564c, this$0.d);
    }

    private final PopOtherLoginBinding getVb() {
        return (PopOtherLoginBinding) this.e.b(this, b[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        TextView textView;
        super.b();
        PopOtherLoginBinding vb = getVb();
        if (vb == null || (textView = vb.f20533a) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.pop.-$$Lambda$OtherLoginPop$hRBIsAdITxrPSh2ieSZk6LE1srw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtherLoginPop.a(OtherLoginPop.this, view);
            }
        });
    }

    public final Bundle getArguments() {
        return this.d;
    }

    public final Context getCtx() {
        return this.f20564c;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_other_login;
    }
}
