package com.soft.blued.ui.setting.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.menu.ActionSheetDefaultItem;
import com.blued.android.module.common.widget.menu.BluedActionSheet;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentResetPwdBinding;
import com.soft.blued.ui.setting.model.ResetPwdModel;
import com.soft.blued.ui.setting.state.ResetPwdState;
import com.soft.blued.ui.setting.state.ResetPwdUiAction;
import com.soft.blued.ui.setting.vm.ResetPwdVM;
import com.soft.blued.utils.password.PasswordCheckUtils;
import com.soft.blued.utils.password.PasswordStatusView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ResetPwdFragment.class */
public final class ResetPwdFragment extends MVIBaseFragment<ResetPwdVM> implements View.OnClickListener {
    private final ViewBindingProperty d;
    private ResetPwdModel e;
    private String f;
    private boolean g;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f33586c = {Reflection.a(new PropertyReference1Impl(ResetPwdFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FragmentResetPwdBinding;", 0))};
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ResetPwdFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ResetPwdFragment() {
        super(R.layout.fragment_reset_pwd);
        this.d = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<ResetPwdFragment, FragmentResetPwdBinding>() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentResetPwdBinding invoke(ResetPwdFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentResetPwdBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<ResetPwdFragment, FragmentResetPwdBinding>() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentResetPwdBinding invoke(ResetPwdFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentResetPwdBinding.a(fragment.requireView());
            }
        });
        this.f = "login_mobile";
        this.g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentResetPwdBinding a() {
        return (FragmentResetPwdBinding) this.d.b(this, f33586c[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ResetPwdFragment this$0, BluedActionSheet bluedActionSheet) {
        Intrinsics.e(this$0, "this$0");
        this$0.f = "login_mobile";
        FragmentResetPwdBinding a2 = this$0.a();
        TextView textView = a2 == null ? null : a2.k;
        if (textView == null) {
            return;
        }
        ResetPwdModel resetPwdModel = this$0.e;
        textView.setText(resetPwdModel == null ? null : resetPwdModel.getLogin_mobile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.soft.blued.ui.setting.fragment.ResetPwdFragment r3, com.soft.blued.databinding.FragmentResetPwdBinding r4, boolean r5) {
        /*
            r0 = r3
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r4
            java.lang.String r1 = "$it"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r3
            r1 = r5
            r0.g = r1
            r0 = r4
            android.widget.TextView r0 = r0.f28955a
            r8 = r0
            r0 = r3
            boolean r0 = r0.g
            r7 = r0
            r0 = 1
            r5 = r0
            r0 = r7
            if (r0 != 0) goto L50
            r0 = r4
            com.blued.android.module.common.view.ClearEditText r0 = r0.b
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3 = r0
            r0 = r3
            if (r0 == 0) goto L47
            r0 = r3
            int r0 = r0.length()
            if (r0 != 0) goto L42
            goto L47
        L42:
            r0 = 0
            r6 = r0
            goto L49
        L47:
            r0 = 1
            r6 = r0
        L49:
            r0 = r6
            if (r0 != 0) goto L50
            goto L52
        L50:
            r0 = 0
            r5 = r0
        L52:
            r0 = r8
            r1 = r5
            r0.setEnabled(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.setting.fragment.ResetPwdFragment.a(com.soft.blued.ui.setting.fragment.ResetPwdFragment, com.soft.blued.databinding.FragmentResetPwdBinding, boolean):void");
    }

    private final void b() {
        ClearEditText clearEditText;
        CommonEdittextView commonEdittextView;
        ClearEditText editText;
        CommonEdittextView commonEdittextView2;
        ClearEditText editText2;
        CommonEdittextView commonEdittextView3;
        ClearEditText editText3;
        CommonEdittextView commonEdittextView4;
        ClearEditText editText4;
        CommonEdittextView commonEdittextView5;
        ClearEditText editText5;
        CommonEdittextView commonEdittextView6;
        ClearEditText editText6;
        Editable text;
        FragmentResetPwdBinding a2 = a();
        if (String.valueOf((a2 != null && (clearEditText = a2.b) != null) ? clearEditText.getText() : null).length() == 0) {
            ToastUtils.a(getString(2131891287));
            return;
        }
        FragmentResetPwdBinding a3 = a();
        if (!(String.valueOf((a3 != null && (commonEdittextView = a3.f28956c) != null && (editText = commonEdittextView.getEditText()) != null) ? editText.getText() : null).length() == 0)) {
            FragmentResetPwdBinding a4 = a();
            if (!(String.valueOf((a4 != null && (commonEdittextView2 = a4.d) != null && (editText2 = commonEdittextView2.getEditText()) != null) ? editText2.getText() : null).length() == 0)) {
                FragmentResetPwdBinding a5 = a();
                if (String.valueOf((a5 == null || (commonEdittextView3 = a5.f28956c) == null || (editText3 = commonEdittextView3.getEditText()) == null) ? null : editText3.getText()).length() < 8) {
                    AppMethods.d(2131886713);
                    return;
                }
                FragmentResetPwdBinding a6 = a();
                String valueOf = String.valueOf((a6 == null || (commonEdittextView4 = a6.f28956c) == null || (editText4 = commonEdittextView4.getEditText()) == null) ? null : editText4.getText());
                FragmentResetPwdBinding a7 = a();
                if (!Intrinsics.a((Object) valueOf, (Object) String.valueOf((a7 == null || (commonEdittextView5 = a7.d) == null || (editText5 = commonEdittextView5.getEditText()) == null) ? null : editText5.getText()))) {
                    AppMethods.d((int) R.string.pwd_errorthree);
                    return;
                }
                ResetPwdVM y = y();
                ResetPwdModel resetPwdModel = this.e;
                String token = resetPwdModel == null ? null : resetPwdModel.getToken();
                FragmentResetPwdBinding a8 = a();
                String valueOf2 = String.valueOf((a8 == null || (commonEdittextView6 = a8.d) == null || (editText6 = commonEdittextView6.getEditText()) == null) ? null : editText6.getText());
                FragmentResetPwdBinding a9 = a();
                if (a9 == null) {
                    text = null;
                } else {
                    ClearEditText clearEditText2 = a9.b;
                    text = clearEditText2 == null ? null : clearEditText2.getText();
                }
                y.dispatchAction((ResetPwdUiAction) new ResetPwdUiAction.ModifyPwd(token, valueOf2, String.valueOf(text)));
                return;
            }
        }
        AppMethods.d((int) R.string.pwd_errorone);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ResetPwdFragment this$0, BluedActionSheet bluedActionSheet) {
        Intrinsics.e(this$0, "this$0");
        this$0.f = "relation_mobile";
        FragmentResetPwdBinding a2 = this$0.a();
        TextView textView = a2 == null ? null : a2.k;
        if (textView == null) {
            return;
        }
        ResetPwdModel resetPwdModel = this$0.e;
        textView.setText(resetPwdModel == null ? null : resetPwdModel.getRelation_mobile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        ResetPwdModel resetPwdModel = this.e;
        String login_mobile = resetPwdModel == null ? null : resetPwdModel.getLogin_mobile();
        if (login_mobile == null || login_mobile.length() == 0) {
            ResetPwdModel resetPwdModel2 = this.e;
            String relation_mobile = resetPwdModel2 == null ? null : resetPwdModel2.getRelation_mobile();
            if (!(relation_mobile == null || relation_mobile.length() == 0)) {
                this.f = "relation_mobile";
                FragmentResetPwdBinding a2 = a();
                TextView textView = a2 == null ? null : a2.k;
                if (textView != null) {
                    ResetPwdModel resetPwdModel3 = this.e;
                    textView.setText(resetPwdModel3 == null ? null : resetPwdModel3.getRelation_mobile());
                }
            }
        } else {
            this.f = "login_mobile";
            FragmentResetPwdBinding a3 = a();
            TextView textView2 = a3 == null ? null : a3.k;
            if (textView2 != null) {
                ResetPwdModel resetPwdModel4 = this.e;
                textView2.setText(resetPwdModel4 == null ? null : resetPwdModel4.getLogin_mobile());
            }
        }
        ResetPwdModel resetPwdModel5 = this.e;
        String login_mobile2 = resetPwdModel5 == null ? null : resetPwdModel5.getLogin_mobile();
        if (login_mobile2 == null || login_mobile2.length() == 0) {
            return;
        }
        ResetPwdModel resetPwdModel6 = this.e;
        String relation_mobile2 = resetPwdModel6 == null ? null : resetPwdModel6.getRelation_mobile();
        boolean z = true;
        if (relation_mobile2 != null) {
            z = relation_mobile2.length() == 0;
        }
        if (z) {
            return;
        }
        FragmentResetPwdBinding a4 = a();
        ImageView imageView = a4 == null ? null : a4.e;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    private final void d() {
        ImageView imageView;
        FragmentResetPwdBinding a2 = a();
        boolean z = false;
        if (a2 != null && (imageView = a2.e) != null && imageView.getVisibility() == 0) {
            z = true;
        }
        if (z) {
            BluedActionSheet.Builder builder = new BluedActionSheet.Builder(getContext());
            ActionSheetDefaultItem a3 = ActionSheetDefaultItem.a();
            ResetPwdModel resetPwdModel = this.e;
            builder.a(a3.a(resetPwdModel == null ? null : resetPwdModel.getLogin_mobile()).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ResetPwdFragment$BwoDtZmo0VQsNM6zy--oiquGM5Q
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    ResetPwdFragment.a(ResetPwdFragment.this, bluedActionSheet);
                }
            }));
            ActionSheetDefaultItem a4 = ActionSheetDefaultItem.a();
            ResetPwdModel resetPwdModel2 = this.e;
            builder.a(a4.a(resetPwdModel2 == null ? null : resetPwdModel2.getRelation_mobile()).b(new BluedActionSheet.OnClickActionSheetListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ResetPwdFragment$VijnZkyQ3AhEESXAf73294miaqI
                @Override // com.blued.android.module.common.widget.menu.BluedActionSheet.OnClickActionSheetListener
                public final void onClickActionSheet(BluedActionSheet bluedActionSheet) {
                    ResetPwdFragment.b(ResetPwdFragment.this, bluedActionSheet);
                }
            }));
            builder.d();
        }
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        final FragmentResetPwdBinding a2 = a();
        if (a2 != null) {
            a2.i.setCenterText(getString(R.string.system_set_pwd));
            CommonTopTitleNoTrans commonTopTitleNoTrans = a2.i;
            ResetPwdFragment resetPwdFragment = this;
            commonTopTitleNoTrans.setLeftClickListener(resetPwdFragment);
            a2.l.setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
            a2.l.setOnClickListener(resetPwdFragment);
            a2.h.setOnClickListener(resetPwdFragment);
            a2.f28955a.setOnClickListener(resetPwdFragment);
            a2.f28955a.setEnabled(false);
            a2.f28956c.getEditText().setInputType(128);
            a2.d.getEditText().setInputType(128);
            a2.g.a(a2.f28956c.getEditText(), a2.d.getEditText(), UserInfo.getInstance().getUserName(), UserInfo.getInstance().getLoginUserInfo().name, PasswordCheckUtils.PWD_CHECK_PAGE.MODIFY_PWD, getFragmentActive(), new PasswordStatusView.OnCheckResult() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ResetPwdFragment$BWA2bhIVFpiQgxJpxw-zrWRx0T0
                @Override // com.soft.blued.utils.password.PasswordStatusView.OnCheckResult
                public final void onResult(boolean z) {
                    ResetPwdFragment.a(ResetPwdFragment.this, a2, z);
                }
            });
            a2.b.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$initView$1$2
                /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
                    if ((r0 == null || r0.length() == 0) == false) goto L14;
                 */
                @Override // android.text.TextWatcher
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void afterTextChanged(android.text.Editable r4) {
                    /*
                        r3 = this;
                        r0 = r3
                        com.soft.blued.ui.setting.fragment.ResetPwdFragment r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.this
                        com.soft.blued.databinding.FragmentResetPwdBinding r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.b(r0)
                        r8 = r0
                        r0 = r8
                        if (r0 != 0) goto Lf
                        return
                    Lf:
                        r0 = r3
                        com.soft.blued.ui.setting.fragment.ResetPwdFragment r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.this
                        r9 = r0
                        r0 = r8
                        android.widget.TextView r0 = r0.f28955a
                        r4 = r0
                        r0 = r9
                        boolean r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.c(r0)
                        r7 = r0
                        r0 = 1
                        r6 = r0
                        r0 = r7
                        if (r0 != 0) goto L59
                        r0 = r8
                        com.blued.android.module.common.view.ClearEditText r0 = r0.b
                        android.text.Editable r0 = r0.getText()
                        java.lang.String r0 = java.lang.String.valueOf(r0)
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                        r8 = r0
                        r0 = r8
                        if (r0 == 0) goto L50
                        r0 = r8
                        int r0 = r0.length()
                        if (r0 != 0) goto L4b
                        goto L50
                    L4b:
                        r0 = 0
                        r5 = r0
                        goto L52
                    L50:
                        r0 = 1
                        r5 = r0
                    L52:
                        r0 = r5
                        if (r0 != 0) goto L59
                        goto L5b
                    L59:
                        r0 = 0
                        r6 = r0
                    L5b:
                        r0 = r4
                        r1 = r6
                        r0.setEnabled(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.setting.fragment.ResetPwdFragment$initView$1$2.afterTextChanged(android.text.Editable):void");
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
        BluedStructureExtKt.a(this, ResetPwdUiAction.GetPhone.f33642a);
        EventTrackSettings.a(SettingsProtos.Event.PASSWORD_SET_PAGE_SHOW);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        ResetPwdFragment resetPwdFragment = this;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(resetPwdFragment, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$liveDataObserver$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((ResetPwdState) obj).getPhoneModel();
            }
        }, new Function1<ResetPwdModel, Unit>() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(ResetPwdModel it) {
                Intrinsics.e(it, "it");
                ResetPwdFragment.this.e = it;
                ResetPwdFragment.this.c();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(ResetPwdModel resetPwdModel) {
                a(resetPwdModel);
                return Unit.f42314a;
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner2, "viewLifecycleOwner");
        BluedStructureExtKt.a(resetPwdFragment, viewLifecycleOwner2, new PropertyReference1Impl() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$liveDataObserver$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((ResetPwdState) obj).getCountdown();
            }
        }, new Function1<Integer, Unit>() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$liveDataObserver$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(int i) {
                FragmentResetPwdBinding a2;
                String string = ResetPwdFragment.this.getString(2131888229);
                Intrinsics.c(string, "getString(R.string.get_vcode_again_after)");
                a2 = ResetPwdFragment.this.a();
                TextView textView = a2 == null ? null : a2.l;
                if (textView == null) {
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                Intrinsics.c(format, "format(format, *args)");
                textView.setText(format);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Integer num) {
                a(num.intValue());
                return Unit.f42314a;
            }
        });
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner3, "viewLifecycleOwner");
        BluedStructureExtKt.a(resetPwdFragment, viewLifecycleOwner3, new PropertyReference1Impl() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$liveDataObserver$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((ResetPwdState) obj).getSmsClickable();
            }
        }, new Function1<Boolean, Unit>() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$liveDataObserver$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
                r0 = r4.f33593a.a();
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(boolean r5) {
                /*
                    r4 = this;
                    r0 = r4
                    com.soft.blued.ui.setting.fragment.ResetPwdFragment r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.this
                    com.soft.blued.databinding.FragmentResetPwdBinding r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.b(r0)
                    r7 = r0
                    r0 = r7
                    if (r0 != 0) goto Lf
                    goto L3b
                Lf:
                    r0 = r7
                    android.widget.TextView r0 = r0.l
                    r7 = r0
                    r0 = r7
                    if (r0 != 0) goto L1b
                    goto L3b
                L1b:
                    r0 = r4
                    com.soft.blued.ui.setting.fragment.ResetPwdFragment r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.this
                    android.content.Context r0 = r0.getContext()
                    r8 = r0
                    r0 = r5
                    if (r0 == 0) goto L2e
                    r0 = 2131101766(0x7f060846, float:1.781595E38)
                    r6 = r0
                    goto L31
                L2e:
                    r0 = 2131102264(0x7f060a38, float:1.7816961E38)
                    r6 = r0
                L31:
                    r0 = r7
                    r1 = r8
                    r2 = r6
                    int r1 = com.blued.android.core.utils.skin.BluedSkinUtils.a(r1, r2)
                    r0.setTextColor(r1)
                L3b:
                    r0 = r4
                    com.soft.blued.ui.setting.fragment.ResetPwdFragment r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.this
                    com.soft.blued.databinding.FragmentResetPwdBinding r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.b(r0)
                    r7 = r0
                    r0 = r7
                    if (r0 != 0) goto L4c
                    r0 = 0
                    r7 = r0
                    goto L51
                L4c:
                    r0 = r7
                    android.widget.TextView r0 = r0.l
                    r7 = r0
                L51:
                    r0 = r7
                    if (r0 != 0) goto L58
                    goto L5d
                L58:
                    r0 = r7
                    r1 = r5
                    r0.setEnabled(r1)
                L5d:
                    r0 = r5
                    if (r0 == 0) goto L7e
                    r0 = r4
                    com.soft.blued.ui.setting.fragment.ResetPwdFragment r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.this
                    com.soft.blued.databinding.FragmentResetPwdBinding r0 = com.soft.blued.ui.setting.fragment.ResetPwdFragment.b(r0)
                    r7 = r0
                    r0 = r7
                    if (r0 != 0) goto L6e
                    return
                L6e:
                    r0 = r7
                    android.widget.TextView r0 = r0.l
                    r7 = r0
                    r0 = r7
                    if (r0 != 0) goto L78
                    return
                L78:
                    r0 = r7
                    r1 = 2131891539(0x7f121553, float:1.94178E38)
                    r0.setText(r1)
                L7e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.setting.fragment.ResetPwdFragment$liveDataObserver$6.a(boolean):void");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Boolean bool) {
                a(bool.booleanValue());
                return Unit.f42314a;
            }
        });
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner4, "viewLifecycleOwner");
        BluedStructureExtKt.a(resetPwdFragment, viewLifecycleOwner4, new PropertyReference1Impl() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$liveDataObserver$7
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((ResetPwdState) obj).getModifySucceed();
            }
        }, new Function1<Boolean, Unit>() { // from class: com.soft.blued.ui.setting.fragment.ResetPwdFragment$liveDataObserver$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(boolean z) {
                if (z) {
                    FragmentActivity activity = ResetPwdFragment.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                    EventTrackSettings.a(SettingsProtos.Event.PASSWORD_SET_SUCCESS);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Boolean bool) {
                a(bool.booleanValue());
                return Unit.f42314a;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == 2131363120) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        } else if (valueOf != null && valueOf.intValue() == 2131372899) {
            ResetPwdVM y = y();
            String str = this.f;
            ResetPwdModel resetPwdModel = this.e;
            y.dispatchAction((ResetPwdUiAction) new ResetPwdUiAction.GetCode(str, resetPwdModel == null ? null : resetPwdModel.getToken()));
        } else if (valueOf != null && valueOf.intValue() == 2131369369) {
            d();
        } else if (valueOf != null && valueOf.intValue() == 2131362557) {
            b();
        }
    }
}
