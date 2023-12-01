package com.blued.community.ui.event.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.community.R;
import com.blued.community.databinding.DialogEventSendBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/dialog/EventSendDialogFragment.class */
public final class EventSendDialogFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19532c;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(EventSendDialogFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/DialogEventSendBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19531a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/dialog/EventSendDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            Bundle bundle = new Bundle();
            TransparentActivity.a(bundle);
            TransparentActivity.b(context, EventSendDialogFragment.class, bundle);
        }
    }

    public EventSendDialogFragment() {
        super(R.layout.dialog_event_send);
        this.f19532c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<EventSendDialogFragment, DialogEventSendBinding>() { // from class: com.blued.community.ui.event.dialog.EventSendDialogFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogEventSendBinding invoke(EventSendDialogFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return DialogEventSendBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<EventSendDialogFragment, DialogEventSendBinding>() { // from class: com.blued.community.ui.event.dialog.EventSendDialogFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogEventSendBinding invoke(EventSendDialogFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return DialogEventSendBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventSendDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final DialogEventSendBinding p() {
        return (DialogEventSendBinding) this.f19532c.b(this, b[0]);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void e() {
        super.e();
        ActivityChangeAnimationUtils.h(getActivity());
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        ShapeTextView shapeTextView;
        DialogEventSendBinding p = p();
        if (p == null || (shapeTextView = p.f18796a) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventSendDialogFragment$B3Mvq-DzC7ArH5LsWmoMCgGUAZE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventSendDialogFragment.a(EventSendDialogFragment.this, view);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }
}
