package com.soft.blued.ui.msg_group.pop;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.PopGroupCreateHintBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/CreateGroupHintPop.class */
public final class CreateGroupHintPop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f19104c = {(KProperty) Reflection.a(new PropertyReference1Impl(CreateGroupHintPop.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGroupCreateHintBinding;", 0))};
    private final View.OnClickListener d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGroupHintPop(Context context, View.OnClickListener onClickListener) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(onClickListener, "onPositiveClickListener");
        this.d = onClickListener;
        BasePopupView basePopupView = (BasePopupView) this;
        this.e = new CustomViewBindingProperty(new Function1<CreateGroupHintPop, PopGroupCreateHintBinding>() { // from class: com.soft.blued.ui.msg_group.pop.CreateGroupHintPop$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopGroupCreateHintBinding invoke(CreateGroupHintPop createGroupHintPop) {
                Intrinsics.e(createGroupHintPop, "popView");
                return PopGroupCreateHintBinding.a(createGroupHintPop.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CreateGroupHintPop createGroupHintPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(createGroupHintPop, "this$0");
        createGroupHintPop.p();
        createGroupHintPop.d.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CreateGroupHintPop createGroupHintPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(createGroupHintPop, "this$0");
        createGroupHintPop.p();
    }

    private final PopGroupCreateHintBinding getVb() {
        return (PopGroupCreateHintBinding) this.e.b(this, f19104c[0]);
    }

    public void b() {
        super.b();
        PopGroupCreateHintBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$CreateGroupHintPop$pkXrywPB_iREaSN8ZDaYnu3Q2zE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateGroupHintPop.a(CreateGroupHintPop.this, view);
            }
        });
        vb.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$CreateGroupHintPop$3_MbeBUS-rg3N9VjkUTYmHNwcmg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateGroupHintPop.b(CreateGroupHintPop.this, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.pop_group_create_hint;
    }

    public final View.OnClickListener getOnPositiveClickListener() {
        return this.d;
    }
}
