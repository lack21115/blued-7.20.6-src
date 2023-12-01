package com.soft.blued.ui.setting.fragment;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.yy_china.databinding.FragmentYyApplyLayoutBinding;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.setting.vm.InvoiceIdentifyVM;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/InvoiceIdentifyFragment.class */
public final class InvoiceIdentifyFragment extends MVVMBaseFragment<InvoiceIdentifyVM> implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f33388c;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(InvoiceIdentifyFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentYyApplyLayoutBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f33387a = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/InvoiceIdentifyFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InvoiceIdentifyFragment() {
        super(2131559360);
        this.f33388c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<InvoiceIdentifyFragment, FragmentYyApplyLayoutBinding>() { // from class: com.soft.blued.ui.setting.fragment.InvoiceIdentifyFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyApplyLayoutBinding invoke(InvoiceIdentifyFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyApplyLayoutBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<InvoiceIdentifyFragment, FragmentYyApplyLayoutBinding>() { // from class: com.soft.blued.ui.setting.fragment.InvoiceIdentifyFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyApplyLayoutBinding invoke(InvoiceIdentifyFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyApplyLayoutBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InvoiceIdentifyFragment this$0, Boolean it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(it, "it");
        if (it.booleanValue()) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
            WebViewShowInfoFragment.show(this$0.getActivity(), Host.a("H5_INVOICE"));
        }
    }

    private final FragmentYyApplyLayoutBinding p() {
        return (FragmentYyApplyLayoutBinding) this.f33388c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        String obj = StringsKt.b((CharSequence) p.i.getText().toString()).toString();
        String obj2 = StringsKt.b((CharSequence) p.h.getText().toString()).toString();
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
            p.f16489a.setEnabled(false);
            p.f16489a.setAlpha(0.5f);
            return;
        }
        p.f16489a.setEnabled(true);
        p.f16489a.setAlpha(1.0f);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        p.d.setVisibility(8);
        p.f16489a.setText(getString(R.string.help_bill_submit));
        ImageView imageView = p.l.f16964a;
        InvoiceIdentifyFragment invoiceIdentifyFragment = this;
        imageView.setOnClickListener(invoiceIdentifyFragment);
        p.l.b.setText(getString(R.string.help_bill_identify_authentication));
        p.j.setText(getString(R.string.help_bill_identify_tips_1));
        p.k.setText(getString(R.string.help_bill_identify_tips_2));
        p.i.setFilters(new InputFilter[]{new EnglishCharFilter(40)});
        p.i.addTextChangedListener(new ITextWatcher() { // from class: com.soft.blued.ui.setting.fragment.InvoiceIdentifyFragment$initView$1$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.e(s, "s");
                InvoiceIdentifyFragment.this.q();
            }
        });
        p.h.addTextChangedListener(new ITextWatcher() { // from class: com.soft.blued.ui.setting.fragment.InvoiceIdentifyFragment$initView$1$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.e(s, "s");
                InvoiceIdentifyFragment.this.q();
            }
        });
        p.f16489a.setOnClickListener(invoiceIdentifyFragment);
        p.g.setOnClickListener(invoiceIdentifyFragment);
        TextView textView = p.g;
        String b2 = LoginRegisterTools.b();
        boolean z = true;
        if (b2 != null) {
            z = b2.length() == 0;
        }
        textView.setText(getString(z ? 2131892874 : 2131892876));
        q();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        a().d().observe(this, new Observer() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$InvoiceIdentifyFragment$NL1LcU-l6-4IaKKln9XbPjiKOko
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InvoiceIdentifyFragment.a(InvoiceIdentifyFragment.this, (Boolean) obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Tracker.onClick(v);
        Intrinsics.e(v, "v");
        int id = v.getId();
        boolean z = false;
        if (id == 2131364105) {
            FragmentYyApplyLayoutBinding p = p();
            if (p == null) {
                return;
            }
            String obj = StringsKt.b((CharSequence) p.i.getText().toString()).toString();
            if (TextUtils.isEmpty(obj)) {
                ToastUtils.a("真实姓名不符合标准", 0);
                return;
            }
            String obj2 = StringsKt.b((CharSequence) p.h.getText().toString()).toString();
            if (TextUtils.isEmpty(obj2) || obj2.length() < 18) {
                ToastUtils.a("证件号码不符合标准", 0);
            } else {
                a().a(obj, obj2);
            }
        } else if (id == 2131365115) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        } else if (id != 2131370980) {
        } else {
            String b2 = LoginRegisterTools.b();
            if (b2 == null || b2.length() == 0) {
                z = true;
            }
            if (z) {
                TerminalActivity.d(getContext(), LinkMobileFragment.class, null);
            }
        }
    }
}
