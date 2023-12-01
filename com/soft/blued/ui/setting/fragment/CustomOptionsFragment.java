package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentCustomOptionsBinding;
import com.soft.blued.ui.setting.vm.CustomOptionsViewModel;
import com.soft.blued.utils.BluedPreferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/CustomOptionsFragment.class */
public final class CustomOptionsFragment extends MVVMBaseFragment<CustomOptionsViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f33338c;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(CustomOptionsFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentCustomOptionsBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f33337a = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/CustomOptionsFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, CustomOptionsFragment.class, null);
        }
    }

    public CustomOptionsFragment() {
        super(R.layout.fragment_custom_options);
        this.f33338c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<CustomOptionsFragment, FragmentCustomOptionsBinding>() { // from class: com.soft.blued.ui.setting.fragment.CustomOptionsFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentCustomOptionsBinding invoke(CustomOptionsFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentCustomOptionsBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<CustomOptionsFragment, FragmentCustomOptionsBinding>() { // from class: com.soft.blued.ui.setting.fragment.CustomOptionsFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentCustomOptionsBinding invoke(CustomOptionsFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentCustomOptionsBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CompoundButton compoundButton, boolean z) {
        Tracker.onCheckedChanged(compoundButton, z);
        BluedPreferences.C(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CustomOptionsFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final FragmentCustomOptionsBinding p() {
        return (FragmentCustomOptionsBinding) this.f33338c.b(this, b[0]);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        ToggleButton toggleButton;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        FragmentCustomOptionsBinding p = p();
        if (p != null && (commonTopTitleNoTrans = p.f28807c) != null) {
            commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$CustomOptionsFragment$00udUKg0KFsQUW6E7UjEIZ8jUE4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CustomOptionsFragment.a(CustomOptionsFragment.this, view);
                }
            });
        }
        FragmentCustomOptionsBinding p2 = p();
        ToggleButton toggleButton2 = p2 == null ? null : p2.b;
        if (toggleButton2 != null) {
            toggleButton2.setChecked(BluedPreferences.aA());
        }
        FragmentCustomOptionsBinding p3 = p();
        if (p3 == null || (toggleButton = p3.b) == null) {
            return;
        }
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$CustomOptionsFragment$McMgou2IEe5tlurxeqOrt8o3dOk
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CustomOptionsFragment.a(compoundButton, z);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }
}
