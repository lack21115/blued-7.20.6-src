package com.soft.blued.ui.setting.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
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
    private final ViewBindingProperty f19697c;
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(InvoiceIdentifyFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentYyApplyLayoutBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19696a = new Companion(null);

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
        super((int) R.layout.fragment_yy_apply_layout);
        this.f19697c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<InvoiceIdentifyFragment, FragmentYyApplyLayoutBinding>() { // from class: com.soft.blued.ui.setting.fragment.InvoiceIdentifyFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/setting/fragment/InvoiceIdentifyFragment;)Lcom/blued/android/module/yy_china/databinding/FragmentYyApplyLayoutBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyApplyLayoutBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<InvoiceIdentifyFragment, FragmentYyApplyLayoutBinding>() { // from class: com.soft.blued.ui.setting.fragment.InvoiceIdentifyFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/setting/fragment/InvoiceIdentifyFragment;)Lcom/blued/android/module/yy_china/databinding/FragmentYyApplyLayoutBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyApplyLayoutBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InvoiceIdentifyFragment invoiceIdentifyFragment, Boolean bool) {
        Intrinsics.e(invoiceIdentifyFragment, "this$0");
        Intrinsics.c(bool, "it");
        if (bool.booleanValue()) {
            FragmentActivity activity = invoiceIdentifyFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
            WebViewShowInfoFragment.show(invoiceIdentifyFragment.getActivity(), Host.a("H5_INVOICE"));
        }
    }

    private final FragmentYyApplyLayoutBinding p() {
        return (FragmentYyApplyLayoutBinding) this.f19697c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        String obj = StringsKt.b(p.i.getText().toString()).toString();
        String obj2 = StringsKt.b(p.h.getText().toString()).toString();
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
            p.a.setEnabled(false);
            p.a.setAlpha(0.5f);
            return;
        }
        p.a.setEnabled(true);
        p.a.setAlpha(1.0f);
    }

    public void f() {
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        p.d.setVisibility(8);
        p.a.setText(getString(R.string.help_bill_submit));
        ImageView imageView = p.l.a;
        InvoiceIdentifyFragment invoiceIdentifyFragment = this;
        imageView.setOnClickListener(invoiceIdentifyFragment);
        p.l.b.setText(getString(R.string.help_bill_identify_authentication));
        p.j.setText(getString(R.string.help_bill_identify_tips_1));
        p.k.setText(getString(R.string.help_bill_identify_tips_2));
        p.i.setFilters(new InputFilter[]{(InputFilter) new EnglishCharFilter(40)});
        p.i.addTextChangedListener((TextWatcher) new ITextWatcher() { // from class: com.soft.blued.ui.setting.fragment.InvoiceIdentifyFragment$initView$1$1
            public void afterTextChanged(Editable editable) {
                Intrinsics.e(editable, "s");
                InvoiceIdentifyFragment.this.q();
            }
        });
        p.h.addTextChangedListener((TextWatcher) new ITextWatcher() { // from class: com.soft.blued.ui.setting.fragment.InvoiceIdentifyFragment$initView$1$2
            public void afterTextChanged(Editable editable) {
                Intrinsics.e(editable, "s");
                InvoiceIdentifyFragment.this.q();
            }
        });
        p.a.setOnClickListener(invoiceIdentifyFragment);
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

    public void l() {
        ((InvoiceIdentifyVM) a()).d().observe((LifecycleOwner) this, new Observer() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$InvoiceIdentifyFragment$NL1LcU-l6-4IaKKln9XbPjiKOko
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InvoiceIdentifyFragment.a(InvoiceIdentifyFragment.this, (Boolean) obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Intrinsics.e(view, "v");
        int id = view.getId();
        boolean z = false;
        if (id == 2131364105) {
            FragmentYyApplyLayoutBinding p = p();
            if (p == null) {
                return;
            }
            String obj = StringsKt.b(p.i.getText().toString()).toString();
            if (TextUtils.isEmpty(obj)) {
                ToastUtils.a("真实姓名不符合标准", 0);
                return;
            }
            String obj2 = StringsKt.b(p.h.getText().toString()).toString();
            if (TextUtils.isEmpty(obj2) || obj2.length() < 18) {
                ToastUtils.a("证件号码不符合标准", 0);
            } else {
                ((InvoiceIdentifyVM) a()).a(obj, obj2);
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
                TerminalActivity.d(getContext(), LinkMobileFragment.class, (Bundle) null);
            }
        }
    }
}
