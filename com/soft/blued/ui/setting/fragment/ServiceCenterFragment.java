package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sobot.chat.api.model.StCategoryModel;
import com.sobot.chat.api.model.StDocModel;
import com.soft.blued.R;
import com.soft.blued.databinding.FmServiceCenterBinding;
import com.soft.blued.ui.setting.adapter.ServiceCenterAdapter;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.ui.setting.vm.ServiceCenterVM;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ServiceCenterFragment.class */
public final class ServiceCenterFragment extends BaseListFragment<ServiceCenterVM, StDocModel> {
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(ServiceCenterFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FmServiceCenterBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f33599c;

    public ServiceCenterFragment() {
        super(R.layout.fm_service_center);
        this.f33599c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<ServiceCenterFragment, FmServiceCenterBinding>() { // from class: com.soft.blued.ui.setting.fragment.ServiceCenterFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmServiceCenterBinding invoke(ServiceCenterFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmServiceCenterBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<ServiceCenterFragment, FmServiceCenterBinding>() { // from class: com.soft.blued.ui.setting.fragment.ServiceCenterFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmServiceCenterBinding invoke(ServiceCenterFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmServiceCenterBinding.a(fragment.requireView());
            }
        });
    }

    private final FmServiceCenterBinding D() {
        return (FmServiceCenterBinding) this.f33599c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceCenterFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceCenterFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        TextView textView;
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", (Serializable) baseQuickAdapter.getData().get(i));
        FmServiceCenterBinding D = this$0.D();
        CharSequence charSequence = null;
        if (D != null && (textView = D.e) != null) {
            charSequence = textView.getText();
        }
        bundle.putString("title", String.valueOf(charSequence));
        Unit unit = Unit.f42314a;
        TerminalActivity.d(context, QuestionDetailFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceCenterFragment this$0, StCategoryModel stCategoryModel) {
        Intrinsics.e(this$0, "this$0");
        if (stCategoryModel == null) {
            return;
        }
        FmServiceCenterBinding D = this$0.D();
        TextView textView = D == null ? null : D.e;
        if (textView == null) {
            return;
        }
        textView.setText(stCategoryModel.getCategoryName());
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public ServiceCenterAdapter i() {
        return new ServiceCenterAdapter();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().c(false).b(false).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void j() {
        super.j();
        ((ServiceCenterVM) y()).a(getActivity());
        FmServiceCenterBinding D = D();
        a(D == null ? null : D.f28768c);
        FmServiceCenterBinding D2 = D();
        a(D2 == null ? null : D2.b);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        ImageView leftImg;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        super.m();
        ((ServiceCenterVM) y()).b().observe(this, new Observer() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ServiceCenterFragment$7mXJvk6ZiPXtvFe_NOriF6wWapY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ServiceCenterFragment.a(ServiceCenterFragment.this, (StCategoryModel) obj);
            }
        });
        FmServiceCenterBinding D = D();
        if (D != null && (commonTopTitleNoTrans2 = D.d) != null) {
            commonTopTitleNoTrans2.setCenterText(getString(R.string.help_service_center));
        }
        FmServiceCenterBinding D2 = D();
        if (D2 != null && (commonTopTitleNoTrans = D2.d) != null && (leftImg = commonTopTitleNoTrans.getLeftImg()) != null) {
            leftImg.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ServiceCenterFragment$RkLP7Jn0UkivzlbHTCxt16NRUnc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ServiceCenterFragment.a(ServiceCenterFragment.this, view);
                }
            });
        }
        f().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ServiceCenterFragment$I6KZznWak31wcuXj9nnwe5oARFg
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ServiceCenterFragment.a(ServiceCenterFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ServiceHelper serviceHelper = ServiceHelper.f33645a;
        View requireView = requireView();
        Intrinsics.c(requireView, "requireView()");
        serviceHelper.a(requireView);
    }
}
