package com.blued.login.test;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.login.R;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.databinding.FragmentLoginTestBinding;
import com.blued.login.utils.LoginPreferences;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/test/LoginFragment.class */
public final class LoginFragment extends MVVMBaseFragment<LoginViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f20570c;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(LoginFragment.class, "viewBinding", "getViewBinding()Lcom/blued/login/databinding/FragmentLoginTestBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20569a = new Companion(null);

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/login/test/LoginFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            TerminalActivity.d(context, LoginFragment.class, null);
        }
    }

    public LoginFragment() {
        super(R.layout.fragment_login_test);
        this.f20570c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<LoginFragment, FragmentLoginTestBinding>() { // from class: com.blued.login.test.LoginFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentLoginTestBinding invoke(LoginFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLoginTestBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LoginFragment, FragmentLoginTestBinding>() { // from class: com.blued.login.test.LoginFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentLoginTestBinding invoke(LoginFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLoginTestBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentLoginTestBinding viewBinding, View view) {
        Intrinsics.e(viewBinding, "$viewBinding");
        LoginPreferences.a(viewBinding.j.isChecked());
        if (viewBinding.j.isChecked()) {
            BluedHttpUrl.k();
        } else {
            BluedHttpUrl.l();
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("HOST_HTTP", BluedHttpUrl.q());
        arrayMap.put("HOST_PAY", BluedHttpUrl.r());
        arrayMap.put("HOST_SDK", BluedHttpUrl.s());
        arrayMap.put("HOST_WEB", BluedHttpUrl.p());
        BluedApiProxy.b().a(arrayMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentLoginTestBinding viewBinding, LoginFragment this$0, View view) {
        Intrinsics.e(viewBinding, "$viewBinding");
        Intrinsics.e(this$0, "this$0");
        LoginAccountModel loginAccountModel = new LoginAccountModel();
        loginAccountModel.b("mobile");
        StringBuilder sb = new StringBuilder();
        sb.append((Object) viewBinding.d.getText());
        sb.append('-');
        sb.append((Object) viewBinding.f20524c.getText());
        loginAccountModel.c(sb.toString());
        loginAccountModel.d(viewBinding.f.getText().toString());
        this$0.a().a(this$0.getContext(), loginAccountModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FragmentLoginTestBinding viewBinding, LoginFragment this$0, View view) {
        Intrinsics.e(viewBinding, "$viewBinding");
        Intrinsics.e(this$0, "this$0");
        LoginAccountModel loginAccountModel = new LoginAccountModel();
        loginAccountModel.b("mobile");
        StringBuilder sb = new StringBuilder();
        sb.append((Object) viewBinding.d.getText());
        sb.append('-');
        sb.append((Object) viewBinding.f20524c.getText());
        loginAccountModel.c(sb.toString());
        loginAccountModel.d(viewBinding.f.getText().toString());
        this$0.a().a(this$0.getContext(), loginAccountModel.b(), loginAccountModel.c(), viewBinding.b.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        if (z) {
            LoginServiceManager.a().a(getContext(), (Bundle) null, (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FragmentLoginTestBinding viewBinding, LoginFragment this$0, View view) {
        Intrinsics.e(viewBinding, "$viewBinding");
        Intrinsics.e(this$0, "this$0");
        LoginAccountModel loginAccountModel = new LoginAccountModel();
        loginAccountModel.b("email");
        loginAccountModel.c(viewBinding.f20524c.getText().toString());
        loginAccountModel.d(viewBinding.f.getText().toString());
        this$0.a().a(this$0.getContext(), loginAccountModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FragmentLoginTestBinding viewBinding, LoginFragment this$0, View view) {
        Intrinsics.e(viewBinding, "$viewBinding");
        Intrinsics.e(this$0, "this$0");
        LoginAccountModel loginAccountModel = new LoginAccountModel();
        loginAccountModel.b("mobile");
        StringBuilder sb = new StringBuilder();
        sb.append((Object) viewBinding.d.getText());
        sb.append('-');
        sb.append((Object) viewBinding.f20524c.getText());
        loginAccountModel.c(sb.toString());
        this$0.a().a(this$0.getContext(), loginAccountModel.b(), "", viewBinding.b.getText().toString());
    }

    public final LoginAccountModel a(String name, String type, String identify, String pwd) {
        Intrinsics.e(name, "name");
        Intrinsics.e(type, "type");
        Intrinsics.e(identify, "identify");
        Intrinsics.e(pwd, "pwd");
        LoginAccountModel loginAccountModel = new LoginAccountModel();
        loginAccountModel.a(name);
        loginAccountModel.b(type);
        loginAccountModel.c(identify);
        loginAccountModel.d(pwd);
        return loginAccountModel;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        BluedHttpUrl.k();
        BluedDeviceIdentity.a().a(AppInfo.d(), Intrinsics.a(BluedHttpUrl.q(), (Object) "/blued/device"), 2);
        final FragmentLoginTestBinding p = p();
        if (p == null) {
            return;
        }
        p.m.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.test.-$$Lambda$LoginFragment$i4l6Efd9O5oMqC4hfXjSFZgTcwU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginFragment.a(FragmentLoginTestBinding.this, this, view);
            }
        });
        p.n.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.test.-$$Lambda$LoginFragment$iFaIqlBr26MWpBvjtp4oKhub3p8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginFragment.b(FragmentLoginTestBinding.this, this, view);
            }
        });
        p.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.test.-$$Lambda$LoginFragment$zMesmW1adCpBEC90GNY7-WttiqE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginFragment.c(FragmentLoginTestBinding.this, this, view);
            }
        });
        p.o.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.test.-$$Lambda$LoginFragment$Mbo1W6lqwElSRtInN3chjf1z0vQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginFragment.d(FragmentLoginTestBinding.this, this, view);
            }
        });
        p.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.test.-$$Lambda$LoginFragment$OfqizJatYlwOoDHfg5zQews8GIA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginFragment.a(FragmentLoginTestBinding.this, view);
            }
        });
        p.j.setChecked(LoginPreferences.e());
        if (p.j.isChecked()) {
            BluedHttpUrl.k();
        } else {
            BluedHttpUrl.l();
        }
        p.i.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        LoginAccountAdapter loginAccountAdapter = new LoginAccountAdapter(getContext(), a());
        loginAccountAdapter.setNewData(q());
        p.i.setAdapter(loginAccountAdapter);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LoginFragment loginFragment = this;
        LifecycleExtKt.a(loginFragment, a().d(), new LoginFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(loginFragment, a().e(), new LoginFragment$liveDataObserver$2(this));
    }

    public final FragmentLoginTestBinding p() {
        return (FragmentLoginTestBinding) this.f20570c.b(this, b[0]);
    }

    public final List<LoginAccountModel> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a("飞飞邮箱登录1", "email", "ldq68@qq.com", "111111"));
        arrayList.add(a("飞飞手机登录1", "mobile", "+86-17611017208", "6800234x"));
        arrayList.add(a("飞飞手机登录2", "mobile", "+86-17611017209", "6800234x"));
        arrayList.add(a("尘尘手机登录1", "mobile", "+86-15556786781", "1qwertyu"));
        arrayList.add(a("尘尘手机登录2", "mobile", "+86-15556786782", "1qwertyu"));
        arrayList.add(a("尘尘手机登录3", "mobile", "+86-15556786783", "1qwertyu"));
        arrayList.add(a("尘尘手机登录4", "mobile", "+86-15556786784", "1qwertyu"));
        arrayList.add(a("大发邮箱登录", "email", "ldq70@qq.com", "111111"));
        arrayList.add(a("大发手机登录", "mobile", "+86-13388884444", "111111"));
        arrayList.add(a("大发手机登录1", "mobile", "+86-13343210001", "bluecity123"));
        arrayList.add(a("大发手机登录2", "mobile", "+86-13343210002", "bluecity123"));
        arrayList.add(a("bais2 厅主播手机登录", "mobile", "+86-18900005001", "Tan123456"));
        arrayList.add(a("bais3 主播手机登录", "mobile", "+86-18900005002", "Tan123456"));
        arrayList.add(a("bais1手机登录", "mobile", "+86-18974978449", "Tan123456"));
        arrayList.add(a("非主播手机登录", "mobile", "+86-18974978448", "Tan123456"));
        return arrayList;
    }
}
