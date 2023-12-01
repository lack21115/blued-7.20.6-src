package com.blued.login.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.das.settings.SettingsProtos;
import com.blued.login.R;
import com.blued.login.databinding.FmIdentifyFaceBinding;
import com.blued.login.state.IdentifyFaceAction;
import com.blued.login.state.IdentifyFaceState;
import com.blued.login.vm.IdentifyFaceVM;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/fragment/IdentifyFaceFragment.class */
public final class IdentifyFaceFragment extends MVIBaseFragment<IdentifyFaceVM> implements View.OnClickListener {
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(IdentifyFaceFragment.class, "vb", "getVb()Lcom/blued/login/databinding/FmIdentifyFaceBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f6942c;

    public IdentifyFaceFragment() {
        super(R.layout.fm_identify_face);
        this.f6942c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<IdentifyFaceFragment, FmIdentifyFaceBinding>() { // from class: com.blued.login.fragment.IdentifyFaceFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/blued/login/fragment/IdentifyFaceFragment;)Lcom/blued/login/databinding/FmIdentifyFaceBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmIdentifyFaceBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<IdentifyFaceFragment, FmIdentifyFaceBinding>() { // from class: com.blued.login.fragment.IdentifyFaceFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/blued/login/fragment/IdentifyFaceFragment;)Lcom/blued/login/databinding/FmIdentifyFaceBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmIdentifyFaceBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FmIdentifyFaceBinding a() {
        return (FmIdentifyFaceBinding) this.f6942c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IdentifyFaceFragment identifyFaceFragment, View view) {
        Intrinsics.e(identifyFaceFragment, "this$0");
        FragmentActivity activity = identifyFaceFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    public void a(boolean z, boolean z2) {
        super.a(z, z2);
        DialogUtils.b(t());
    }

    public void m() {
        ((IdentifyFaceVM) y()).a(getActivity());
        FmIdentifyFaceBinding a2 = a();
        if (a2 == null) {
            return;
        }
        a2.d.setOnClickListener(new SingleClickProxy() { // from class: com.blued.login.fragment.IdentifyFaceFragment$initView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(IdentifyFaceFragment.this);
            }
        });
        a2.f6912c.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$IdentifyFaceFragment$WQEa2SKvOTAhwXpcTeyi-Bh1eoo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdentifyFaceFragment.a(IdentifyFaceFragment.this, view);
            }
        });
        a2.f6912c.setCenterText(getString(R.string.login_adult_certification));
        a2.b.setHintText(R.string.login_input_hint_name);
        a2.f6911a.setHintText(R.string.login_input_hint_id);
    }

    public void o() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new MutablePropertyReference1Impl() { // from class: com.blued.login.fragment.IdentifyFaceFragment$liveDataObserver$1
            public Object a(Object obj) {
                return ((IdentifyFaceState) obj).getSucceed();
            }
        }, new Function1<Boolean, Unit>() { // from class: com.blued.login.fragment.IdentifyFaceFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(boolean z) {
                if (z) {
                    LiveEventBus.get("LOGIN_ADULT_IDENTIFY_SUCCEED").post(null);
                    FragmentActivity activity = IdentifyFaceFragment.this.getActivity();
                    if (activity == null) {
                        return;
                    }
                    activity.finish();
                }
            }

            public /* synthetic */ Object invoke(Object obj) {
                a(((Boolean) obj).booleanValue());
                return Unit.a;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Intrinsics.e(view, "v");
        if (view.getId() == R.id.tv_identify) {
            EventTrackSettings.a(SettingsProtos.Event.UNDER_AGE_FACE_BTN_CLICK);
            PermissionUtils.b(new PermissionCallbacks() { // from class: com.blued.login.fragment.IdentifyFaceFragment$onClick$1
                public void U_() {
                    FmIdentifyFaceBinding a2;
                    a2 = IdentifyFaceFragment.this.a();
                    if (a2 == null) {
                        return;
                    }
                    BluedStructureExtKt.a(IdentifyFaceFragment.this, new IdentifyFaceAction.VerifyCard(a2.b.getText().toString(), a2.f6911a.getText().toString()));
                }

                public void a(String[] strArr) {
                }
            });
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.e(bundle, "outState");
        FmIdentifyFaceBinding a2 = a();
        if (a2 == null) {
            return;
        }
        bundle.putString("name", a2.b.getText().toString());
        bundle.putString("card", a2.f6911a.getText().toString());
    }

    public void onViewStateRestored(Bundle bundle) {
        FmIdentifyFaceBinding a2;
        super.onViewStateRestored(bundle);
        if (bundle == null || (a2 = a()) == null) {
            return;
        }
        Object obj = bundle.get("name");
        if (obj != null && (obj instanceof String)) {
            a2.b.getEditText().setText((CharSequence) obj);
        }
        Object obj2 = bundle.get("card");
        if (obj2 == null || !(obj2 instanceof String)) {
            return;
        }
        a2.f6911a.getEditText().setText((CharSequence) obj2);
    }

    public void r() {
        super.r();
        DialogUtils.a(t());
    }
}
