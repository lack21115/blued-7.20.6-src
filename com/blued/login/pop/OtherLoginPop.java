package com.blued.login.pop;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
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
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(OtherLoginPop.class, "vb", "getVb()Lcom/blued/login/databinding/PopOtherLoginBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final Context f6958c;
    private final Bundle d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtherLoginPop(Context context, Bundle bundle) {
        super(context);
        Intrinsics.e(context, "ctx");
        this.f6958c = context;
        this.d = bundle;
        BasePopupView basePopupView = (BasePopupView) this;
        this.e = new CustomViewBindingProperty(new Function1<OtherLoginPop, PopOtherLoginBinding>() { // from class: com.blued.login.pop.OtherLoginPop$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopOtherLoginBinding invoke(OtherLoginPop otherLoginPop) {
                Intrinsics.e(otherLoginPop, "popView");
                return PopOtherLoginBinding.a(otherLoginPop.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OtherLoginPop otherLoginPop, View view) {
        Intrinsics.e(otherLoginPop, "this$0");
        EventTrackLogin.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.EMAIL);
        otherLoginPop.p();
        LoginServiceManager.a().d(otherLoginPop.f6958c, otherLoginPop.d);
    }

    private final PopOtherLoginBinding getVb() {
        return (PopOtherLoginBinding) this.e.b(this, b[0]);
    }

    public void b() {
        TextView textView;
        super.b();
        PopOtherLoginBinding vb = getVb();
        if (vb == null || (textView = vb.f6927a) == null) {
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
        return this.f6958c;
    }

    public int getImplLayoutId() {
        return R.layout.pop_other_login;
    }
}
