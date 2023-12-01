package com.blued.community.ui.event.dialog;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.HyperlinkUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.DialogEventSignUpBinding;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/dialog/EventSignUpPopupWindow.class */
public final class EventSignUpPopupWindow extends CenterPopupView {
    static final /* synthetic */ KProperty<Object>[] c = {Reflection.a(new PropertyReference1Impl(EventSignUpPopupWindow.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/DialogEventSignUpBinding;", 0))};
    private final View.OnClickListener d;
    private final EventDetailsModel e;
    private final ViewBindingProperty f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventSignUpPopupWindow(Context context, View.OnClickListener onPositiveClickListener, EventDetailsModel model) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(onPositiveClickListener, "onPositiveClickListener");
        Intrinsics.e(model, "model");
        this.d = onPositiveClickListener;
        this.e = model;
        this.f = new CustomViewBindingProperty(new Function1<EventSignUpPopupWindow, DialogEventSignUpBinding>() { // from class: com.blued.community.ui.event.dialog.EventSignUpPopupWindow$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogEventSignUpBinding invoke(EventSignUpPopupWindow popView) {
                Intrinsics.e(popView, "popView");
                return DialogEventSignUpBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogEventSignUpBinding viewBinding, View view) {
        Intrinsics.e(viewBinding, "$viewBinding");
        viewBinding.a.setChecked(!viewBinding.a.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogEventSignUpBinding viewBinding, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(viewBinding, "$viewBinding");
        if (z) {
            viewBinding.j.getBackground().setAlpha(255);
        } else {
            viewBinding.j.getBackground().setAlpha(55);
        }
        CommunityPreferences.c(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogEventSignUpBinding viewBinding, EventSignUpPopupWindow this$0, View view) {
        Intrinsics.e(viewBinding, "$viewBinding");
        Intrinsics.e(this$0, "this$0");
        if (viewBinding.a.isChecked()) {
            this$0.d.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventSignUpPopupWindow this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        CommunityServiceManager.b().a(this$0.getContext(), H5Url.a(72));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventSignUpPopupWindow this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.p();
        String[] strArr = this$0.e.scene_images;
        Intrinsics.c(strArr, "model.scene_images");
        int i = 0;
        if (!(strArr.length == 0)) {
            i = this$0.e.scene_images.length;
        }
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_DETAIL_PAGE_SIGNUP_POP_NO_CLICK, this$0.e.id, this$0.e.group_id, i);
    }

    private final DialogEventSignUpBinding getViewBinding() {
        return (DialogEventSignUpBinding) this.f.b(this, c[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        final DialogEventSignUpBinding viewBinding = getViewBinding();
        if (viewBinding == null) {
            return;
        }
        viewBinding.j.getBackground().setAlpha(55);
        if (getModel().is_free == 1) {
            viewBinding.i.setText(R.string.event_apply_for_registration);
            viewBinding.h.setText(R.string.event_sign_up_dialog_content_exempt_review);
            viewBinding.j.setText(R.string.event_apply_for_registration_btn);
        } else {
            viewBinding.i.setText(R.string.event_apply_for_registration_apply);
            viewBinding.h.setText(R.string.event_sign_up_dialog_content);
            viewBinding.j.setText(R.string.event_apply_for_registration_apply);
        }
        viewBinding.f.setText(Intrinsics.a(getContext().getString(R.string.event_security_reminders_radio), (Object) getContext().getString(R.string.event_security_reminders)));
        HyperlinkUtils.a(getContext(), viewBinding.f, getContext().getString(R.string.event_security_reminders), BluedSkinUtils.a(getContext(), R.color.syc_m), new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventSignUpPopupWindow$0zGmDecyzuFnzYivZJtxOn2C1Wk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventSignUpPopupWindow.a(EventSignUpPopupWindow.this, view);
            }
        });
        viewBinding.a.setChecked(CommunityPreferences.i());
        if (CommunityPreferences.i()) {
            viewBinding.j.getBackground().setAlpha(255);
        } else {
            viewBinding.j.getBackground().setAlpha(55);
        }
        viewBinding.a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventSignUpPopupWindow$57V6qftEMaXJfSvLJ_ZrKEYV8aE
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EventSignUpPopupWindow.a(DialogEventSignUpBinding.this, compoundButton, z);
            }
        });
        viewBinding.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventSignUpPopupWindow$55q4wiHVU0F9J5QLecNi5D2vPBU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventSignUpPopupWindow.a(DialogEventSignUpBinding.this, view);
            }
        });
        viewBinding.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventSignUpPopupWindow$Cf4CwSc1BEiwp9eMYMvT4IgLF60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventSignUpPopupWindow.a(DialogEventSignUpBinding.this, this, view);
            }
        });
        viewBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.dialog.-$$Lambda$EventSignUpPopupWindow$eCNyJWImXaZwLM0nGi2E526ahco
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventSignUpPopupWindow.b(EventSignUpPopupWindow.this, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.dialog_event_sign_up;
    }

    public final EventDetailsModel getModel() {
        return this.e;
    }

    public final View.OnClickListener getOnPositiveClickListener() {
        return this.d;
    }
}
