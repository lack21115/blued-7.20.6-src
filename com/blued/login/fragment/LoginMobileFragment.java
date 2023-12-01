package com.blued.login.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.R;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.databinding.FmLoginMobileBinding;
import com.blued.login.log.EventTrackLogin;
import com.blued.login.model.OneLoginData;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/fragment/LoginMobileFragment.class */
public final class LoginMobileFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f6950a = {(KProperty) Reflection.a(new PropertyReference1Impl(LoginMobileFragment.class, "vb", "getVb()Lcom/blued/login/databinding/FmLoginMobileBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private CheckBox f6951c;
    private String d;

    public LoginMobileFragment() {
        super(R.layout.fm_login_mobile);
        this.b = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<LoginMobileFragment, FmLoginMobileBinding>() { // from class: com.blued.login.fragment.LoginMobileFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/blued/login/fragment/LoginMobileFragment;)Lcom/blued/login/databinding/FmLoginMobileBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmLoginMobileBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LoginMobileFragment, FmLoginMobileBinding>() { // from class: com.blued.login.fragment.LoginMobileFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/blued/login/fragment/LoginMobileFragment;)Lcom/blued/login/databinding/FmLoginMobileBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmLoginMobileBinding.a(fragment.requireView());
            }
        });
        this.d = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginMobileFragment loginMobileFragment, View view) {
        Intrinsics.e(loginMobileFragment, "this$0");
        EventTrackLogin.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.ONE_CLICK);
        CheckBox checkBox = loginMobileFragment.f6951c;
        if (checkBox == null) {
            return;
        }
        if (!checkBox.isChecked()) {
            AppMethods.d(R.string.login_check_rule);
            return;
        }
        String str = loginMobileFragment.d;
        if (str == null || str.length() == 0) {
            return;
        }
        loginMobileFragment.a(loginMobileFragment.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginMobileFragment loginMobileFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(loginMobileFragment, "this$0");
        if (z) {
            LoginServiceManager.a().a("check_term", loginMobileFragment.getContext(), loginMobileFragment.f6951c);
        }
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LOGIN_CHECK).post(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginMobileFragment loginMobileFragment, Boolean bool) {
        Intrinsics.e(loginMobileFragment, "this$0");
        if (bool == null) {
            return;
        }
        boolean booleanValue = bool.booleanValue();
        CheckBox checkBox = loginMobileFragment.f6951c;
        if (checkBox == null) {
            return;
        }
        checkBox.setChecked(booleanValue);
    }

    private final void a(String str) {
        CheckBox checkBox = this.f6951c;
        if (checkBox != null) {
            OneLoginData oneLoginData = new OneLoginData();
            oneLoginData.a(str);
            Bundle arguments = getArguments();
            if (arguments != null) {
                String string = arguments.getString(oneLoginData.a(), "");
                Intrinsics.c(string, "it.getString(aliasUserId, \"\")");
                oneLoginData.b(string);
            }
            checkBox.setTag(oneLoginData);
        }
        LoginServiceManager.a().a("one_login", getContext(), this.f6951c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LoginMobileFragment loginMobileFragment, View view) {
        Intrinsics.e(loginMobileFragment, "this$0");
        EventTrackLogin.a(LoginAndRegisterProtos.Event.OTHER_PHONE_LOGIN_CLICK, LoginAndRegisterProtos.Source.UNKNOWN_SOURCE);
        CheckBox checkBox = loginMobileFragment.f6951c;
        if (checkBox == null) {
            return;
        }
        if (checkBox.isChecked()) {
            LoginServiceManager.a().a(loginMobileFragment.getContext(), loginMobileFragment.getArguments());
        } else {
            AppMethods.d(R.string.login_check_rule);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LoginMobileFragment loginMobileFragment, View view) {
        Intrinsics.e(loginMobileFragment, "this$0");
        FragmentActivity activity = loginMobileFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final FmLoginMobileBinding p() {
        return (FmLoginMobileBinding) this.b.b(this, f6950a[0]);
    }

    public void f() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        View findViewById;
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        FmLoginMobileBinding p = p();
        TextView textView = (p == null || (frameLayout = p.f6915a) == null) ? null : (TextView) frameLayout.findViewById(R.id.tv_terms);
        FmLoginMobileBinding p2 = p();
        TextView textView2 = (p2 == null || (frameLayout2 = p2.f6915a) == null) ? null : (TextView) frameLayout2.findViewById(R.id.tv_terms_en);
        if (textView != null && textView2 != null) {
            LoginServiceManager.a().a(textView, textView2, false);
        }
        FmLoginMobileBinding p3 = p();
        CheckBox checkBox = (p3 == null || (frameLayout3 = p3.f6915a) == null) ? null : (CheckBox) frameLayout3.findViewById(R.id.cb_terms);
        this.f6951c = checkBox;
        if (checkBox != null) {
            checkBox.setChecked(true);
        }
        CheckBox checkBox2 = this.f6951c;
        if (checkBox2 != null) {
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMobileFragment$na8QBma-LsVnvnMnhIQ3_ygL164
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LoginMobileFragment.a(LoginMobileFragment.this, compoundButton, z);
                }
            });
        }
        FmLoginMobileBinding p4 = p();
        if (p4 != null && (shapeTextView2 = p4.f6916c) != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMobileFragment$U9jsoa3HohK28-KqMrPDQSklY9w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginMobileFragment.a(LoginMobileFragment.this, view);
                }
            });
        }
        FmLoginMobileBinding p5 = p();
        if (p5 != null && (shapeTextView = p5.d) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMobileFragment$7yDkFU6nQvLPRFWxBowTxYQ4iuc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginMobileFragment.b(LoginMobileFragment.this, view);
                }
            });
        }
        View view = getView();
        if (view != null && (findViewById = view.findViewById(R.id.iv_back)) != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMobileFragment$aTYuKt0Ro2RSwgEJ_4yTIJ875YI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginMobileFragment.c(LoginMobileFragment.this, view2);
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        String string = arguments.getString("login_one_num", "");
        Intrinsics.c(string, "it.getString(LoginConsta…TA_KEY.LOGIN_ONE_NUM, \"\")");
        this.d = string;
        String str = string;
        boolean z = true;
        if (str != null) {
            z = str.length() == 0;
        }
        if (z) {
            return;
        }
        FmLoginMobileBinding p6 = p();
        ShapeTextView shapeTextView3 = p6 == null ? null : p6.f6916c;
        if (shapeTextView3 != null) {
            shapeTextView3.setVisibility(0);
        }
        FmLoginMobileBinding p7 = p();
        TextView textView3 = p7 == null ? null : p7.e;
        if (textView3 == null) {
            return;
        }
        textView3.setText(this.d);
    }

    public void l() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LOGIN_CHECK, Boolean.TYPE).observe((LifecycleOwner) this, new Observer() { // from class: com.blued.login.fragment.-$$Lambda$LoginMobileFragment$t8oF2LTMgZfj95vt8ytnpYSHGck
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginMobileFragment.a(LoginMobileFragment.this, (Boolean) obj);
            }
        });
    }
}
