package com.blued.login.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.R;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.constant.LoginConstants;
import com.blued.login.databinding.FmFinishProfile1Binding;
import com.blued.login.log.EventTrackLogin;
import com.blued.login.model.ProfileInfoModel;
import com.blued.login.utils.LoginHelper;
import com.blued.login.vm.FinishProfileVM;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/fragment/FinishProfile1Fragment.class */
public final class FinishProfile1Fragment extends MVVMBaseFragment<FinishProfileVM> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f20541c;
    private final ProfileInfoModel d;
    private String e;
    private final Runnable f;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(FinishProfile1Fragment.class, "vb", "getVb()Lcom/blued/login/databinding/FmFinishProfile1Binding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20540a = new Companion(null);

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/login/fragment/FinishProfile1Fragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            LoginHelper.f20590a.a(context);
        }

        public final void a(Context context, String str, String str2, String str3, LoginAndRegisterProtos.Source source, String str4) {
            Bundle bundle = new Bundle();
            bundle.putInt("re_type", 1);
            bundle.putString("re_token", str);
            bundle.putString("re_password", str2);
            bundle.putString("re_account", str3);
            bundle.putString("aliasUserId", str4);
            bundle.putSerializable("RE_KEY_FROM_SRC", source);
            TerminalActivity.d(context, FinishProfile1Fragment.class, bundle);
        }

        public final void a(Context context, String str, String str2, String registerPlat, String str3, String str4, String str5) {
            Intrinsics.e(registerPlat, "registerPlat");
            Bundle bundle = new Bundle();
            bundle.putString("re_token", str);
            bundle.putString("re_password", "");
            bundle.putString("re_nickname", str2);
            bundle.putString("aliasUserId", str5);
            boolean b = StringsKt.b("plat_weixin", registerPlat, false, 2, (Object) null);
            String str6 = UserAccountsModel.ACCOUNT_THREE_ONECLICK;
            if (b) {
                bundle.putSerializable("RE_KEY_FROM_SRC", LoginAndRegisterProtos.Source.WECHAT);
                str6 = UserAccountsModel.ACCOUNT_THREE_WEIXIN;
            } else if (Intrinsics.a((Object) UserAccountsModel.ACCOUNT_THREE_ONECLICK, (Object) registerPlat)) {
                bundle.putSerializable("RE_KEY_FROM_SRC", LoginAndRegisterProtos.Source.ONE_CLICK);
            } else {
                str6 = "";
            }
            LoginHelper loginHelper = LoginHelper.f20590a;
            String str7 = str3;
            if (str3 == null) {
                str7 = "";
            }
            String str8 = str4;
            if (str4 == null) {
                str8 = "";
            }
            String a2 = loginHelper.a(str7, str8, str6);
            bundle.putString(LoginConstants.f20504a, str6);
            bundle.putString("re_account", a2);
            bundle.putInt("re_type", 2);
            TerminalActivity.d(context, FinishProfile1Fragment.class, bundle);
        }
    }

    public FinishProfile1Fragment() {
        super(R.layout.fm_finish_profile_1);
        this.f20541c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<FinishProfile1Fragment, FmFinishProfile1Binding>() { // from class: com.blued.login.fragment.FinishProfile1Fragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmFinishProfile1Binding invoke(FinishProfile1Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmFinishProfile1Binding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<FinishProfile1Fragment, FmFinishProfile1Binding>() { // from class: com.blued.login.fragment.FinishProfile1Fragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmFinishProfile1Binding invoke(FinishProfile1Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmFinishProfile1Binding.a(fragment.requireView());
            }
        });
        this.d = new ProfileInfoModel();
        this.f = new Runnable() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile1Fragment$yRvmxiYUZnpFBMR8cNxaILrUrGE
            @Override // java.lang.Runnable
            public final void run() {
                FinishProfile1Fragment.d(FinishProfile1Fragment.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            i2 += str.charAt(i) < 128 ? 1 : 2;
            i = i3;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FinishProfile1Fragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FinishProfile1Fragment this$0, View view, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            return;
        }
        this$0.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += str.charAt(i2) < 128 ? 1 : 2;
            if (i > 20) {
                return i2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final FinishProfile1Fragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.login.fragment.FinishProfile1Fragment$initView$4$1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                LoginServiceManager.a().a(FinishProfile1Fragment.this, 1, 22);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strings) {
                Intrinsics.e(strings, "strings");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cc, code lost:
        if (r0.length() == 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(com.blued.login.fragment.FinishProfile1Fragment r4, android.view.View r5) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.login.fragment.FinishProfile1Fragment.c(com.blued.login.fragment.FinishProfile1Fragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FinishProfile1Fragment this$0, String it) {
        FmFinishProfile1Binding p;
        CommonEdittextView commonEdittextView;
        ClearEditText editText;
        CommonEdittextView commonEdittextView2;
        ClearEditText editText2;
        Intrinsics.e(this$0, "this$0");
        ProfileInfoModel profileInfoModel = this$0.d;
        Intrinsics.c(it, "it");
        profileInfoModel.a(it);
        FmFinishProfile1Binding p2 = this$0.p();
        if (p2 != null && (commonEdittextView2 = p2.f20511a) != null && (editText2 = commonEdittextView2.getEditText()) != null) {
            editText2.setText(it);
        }
        if ((it.length() > 0) && (p = this$0.p()) != null && (commonEdittextView = p.f20511a) != null && (editText = commonEdittextView.getEditText()) != null) {
            editText.setSelection(it.length());
        }
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FinishProfile1Fragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FmFinishProfile1Binding p() {
        return (FmFinishProfile1Binding) this.f20541c.b(this, b[0]);
    }

    private final void q() {
        CommonEdittextView commonEdittextView;
        ClearEditText editText;
        ShapeTextView shapeTextView;
        CommonEdittextView commonEdittextView2;
        ClearEditText editText2;
        FmFinishProfile1Binding p = p();
        ClearEditText editText3 = (p == null || (commonEdittextView = p.f20511a) == null) ? null : commonEdittextView.getEditText();
        if (editText3 != null) {
            editText3.setHint(getString(R.string.login_nick_hint));
        }
        FmFinishProfile1Binding p2 = p();
        if (p2 != null && (commonEdittextView2 = p2.f20511a) != null && (editText2 = commonEdittextView2.getEditText()) != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.blued.login.fragment.FinishProfile1Fragment$initEdit$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    FmFinishProfile1Binding p3;
                    FmFinishProfile1Binding p4;
                    int a2;
                    int b2;
                    FmFinishProfile1Binding p5;
                    FmFinishProfile1Binding p6;
                    CommonEdittextView commonEdittextView3;
                    ClearEditText editText4;
                    CommonEdittextView commonEdittextView4;
                    ClearEditText editText5;
                    Intrinsics.e(s, "s");
                    FinishProfile1Fragment.this.t();
                    TextView textView = null;
                    if (!(s.toString().length() > 0)) {
                        p3 = FinishProfile1Fragment.this.p();
                        TextView textView2 = p3 == null ? null : p3.h;
                        if (textView2 == null) {
                            return;
                        }
                        textView2.setVisibility(4);
                        return;
                    }
                    p4 = FinishProfile1Fragment.this.p();
                    if (p4 != null) {
                        textView = p4.h;
                    }
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    a2 = FinishProfile1Fragment.this.a(s.toString());
                    if (a2 <= 20) {
                        FinishProfile1Fragment.this.r();
                        return;
                    }
                    b2 = FinishProfile1Fragment.this.b(s.toString());
                    p5 = FinishProfile1Fragment.this.p();
                    if (p5 != null && (commonEdittextView4 = p5.f20511a) != null && (editText5 = commonEdittextView4.getEditText()) != null) {
                        editText5.setText(s.toString().subSequence(0, b2).toString());
                    }
                    p6 = FinishProfile1Fragment.this.p();
                    if (p6 == null || (commonEdittextView3 = p6.f20511a) == null || (editText4 = commonEdittextView3.getEditText()) == null) {
                        return;
                    }
                    editText4.setSelection(b2);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
        FmFinishProfile1Binding p3 = p();
        if (p3 == null) {
            editText = null;
        } else {
            CommonEdittextView commonEdittextView3 = p3.f20511a;
            editText = commonEdittextView3 == null ? null : commonEdittextView3.getEditText();
        }
        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile1Fragment$3TKiIyT_xLRuJYAWbHRIOegMw3w
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    FinishProfile1Fragment.a(FinishProfile1Fragment.this, view, z);
                }
            });
        }
        FmFinishProfile1Binding p4 = p();
        if (p4 != null && (shapeTextView = p4.g) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile1Fragment$JP_-vbSFoAL-1l90TrE9kePTfWA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FinishProfile1Fragment.c(FinishProfile1Fragment.this, view);
                }
            });
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        CommonEdittextView commonEdittextView;
        ClearEditText editText;
        String a2 = this.d.a();
        FmFinishProfile1Binding p = p();
        Editable editable = null;
        if (p != null && (commonEdittextView = p.f20511a) != null && (editText = commonEdittextView.getEditText()) != null) {
            editable = editText.getText();
        }
        if (Intrinsics.a((Object) a2, (Object) String.valueOf(editable))) {
            return;
        }
        AppInfo.n().removeCallbacks(this.f);
        AppInfo.n().postDelayed(this.f, 1000L);
    }

    private final void s() {
        CommonEdittextView commonEdittextView;
        ClearEditText editText;
        FmFinishProfile1Binding p = p();
        Editable editable = null;
        if (p != null && (commonEdittextView = p.f20511a) != null && (editText = commonEdittextView.getEditText()) != null) {
            editable = editText.getText();
        }
        String valueOf = String.valueOf(editable);
        int length = valueOf.length();
        if (!(2 <= length && length < 21)) {
            AppMethods.d(R.string.error_nickname_over_length);
            return;
        }
        String str = valueOf;
        boolean z = true;
        if (str != null) {
            z = str.length() == 0;
        }
        if (z) {
            return;
        }
        a().a(this.d.g(), valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t() {
        ShapeTextView shapeTextView;
        String a2 = this.d.a();
        boolean z = !(a2 == null || a2.length() == 0);
        FmFinishProfile1Binding p = p();
        ShapeTextView shapeTextView2 = null;
        ShapeModel shapeModel = (p == null || (shapeTextView = p.g) == null) ? null : shapeTextView.getShapeModel();
        if (shapeModel != null) {
            shapeModel.k = BluedSkinUtils.a(getContext(), z ? R.color.syc_a : R.color.syc_a_20);
        }
        FmFinishProfile1Binding p2 = p();
        if (p2 != null) {
            shapeTextView2 = p2.g;
        }
        if (shapeTextView2 == null) {
            return z;
        }
        shapeTextView2.setShapeModel(shapeModel);
        return z;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        RelativeLayout relativeLayout;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        ImageView leftImg;
        Bundle arguments = getArguments();
        String string = arguments == null ? null : arguments.getString("re_token");
        this.e = string;
        if (string != null) {
            this.d.g(string);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            this.d.a(arguments2.getInt("re_type"));
            ProfileInfoModel profileInfoModel = this.d;
            String string2 = arguments2.getString("re_account", "");
            Intrinsics.c(string2, "it.getString(LoginConsta….DATA_KEY.RE_ACCOUNT, \"\")");
            profileInfoModel.l(string2);
            this.d.a((LoginAndRegisterProtos.Source) arguments2.getSerializable("RE_KEY_FROM_SRC"));
            ProfileInfoModel profileInfoModel2 = this.d;
            String string3 = arguments2.getString("aliasUserId", "");
            Intrinsics.c(string3, "it.getString(LoginConsta…A_KEY.BIND_ALIAS_UID, \"\")");
            profileInfoModel2.m(string3);
            ProfileInfoModel profileInfoModel3 = this.d;
            String string4 = arguments2.getString(LoginConstants.f20504a, "");
            Intrinsics.c(string4, "it.getString(LoginConstants.RE_TYPE_THREE, \"\")");
            profileInfoModel3.k(string4);
            EventTrackLogin.a(LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_SHOW, LoginHelper.f20590a.a(this.d));
        }
        FmFinishProfile1Binding p = p();
        if (p != null && (commonTopTitleNoTrans = p.e) != null && (leftImg = commonTopTitleNoTrans.getLeftImg()) != null) {
            leftImg.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile1Fragment$fB4UxRcRhN3B9eEMCB_-1mVtiGo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FinishProfile1Fragment.a(FinishProfile1Fragment.this, view);
                }
            });
        }
        FmFinishProfile1Binding p2 = p();
        if (p2 != null && (relativeLayout = p2.d) != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile1Fragment$P7dyabPFcgOULFOjUmtMNklWhuw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FinishProfile1Fragment.b(FinishProfile1Fragment.this, view);
                }
            });
        }
        q();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        a().d().observe(this, new Observer() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile1Fragment$Mob4Aq1V0G1mns6OjOBHf972PPg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FinishProfile1Fragment.c(FinishProfile1Fragment.this, (String) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 22 || intent == null) {
            return;
        }
        this.d.b(String.valueOf(intent.getStringExtra("photo_path")));
        ImageWrapper b2 = ImageLoader.d(getFragmentActive(), this.d.b()).c().b(R.drawable.user_bg_round);
        FmFinishProfile1Binding p = p();
        b2.a(p == null ? null : p.f20512c);
        t();
    }
}
