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
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/ApplyGroupHintPop.class */
public final class ApplyGroupHintPop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f19102c = {(KProperty) Reflection.a(new PropertyReference1Impl(ApplyGroupHintPop.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGroupCreateHintBinding;", 0))};
    private final View.OnClickListener d;
    private final View.OnClickListener e;
    private final ViewBindingProperty f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyGroupHintPop(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(onClickListener, "onPositiveClickListener");
        Intrinsics.e(onClickListener2, "onNegativeClickListener");
        this.d = onClickListener;
        this.e = onClickListener2;
        BasePopupView basePopupView = (BasePopupView) this;
        this.f = new CustomViewBindingProperty(new Function1<ApplyGroupHintPop, PopGroupCreateHintBinding>() { // from class: com.soft.blued.ui.msg_group.pop.ApplyGroupHintPop$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopGroupCreateHintBinding invoke(ApplyGroupHintPop applyGroupHintPop) {
                Intrinsics.e(applyGroupHintPop, "popView");
                return PopGroupCreateHintBinding.a(applyGroupHintPop.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ApplyGroupHintPop applyGroupHintPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(applyGroupHintPop, "this$0");
        applyGroupHintPop.p();
        applyGroupHintPop.d.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ApplyGroupHintPop applyGroupHintPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(applyGroupHintPop, "this$0");
        applyGroupHintPop.p();
        applyGroupHintPop.e.onClick(view);
    }

    private final PopGroupCreateHintBinding getVb() {
        return (PopGroupCreateHintBinding) this.f.b(this, f19102c[0]);
    }

    public void b() {
        super.b();
        PopGroupCreateHintBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$ApplyGroupHintPop$bTUp8x3D73DAuJhUTVEjoQBozmE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyGroupHintPop.a(ApplyGroupHintPop.this, view);
            }
        });
        vb.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$ApplyGroupHintPop$r5Fp450KmkN5K7UFBvOkxrFFPZw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyGroupHintPop.b(ApplyGroupHintPop.this, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.pop_group_apply_hint;
    }

    public final View.OnClickListener getOnNegativeClickListener() {
        return this.e;
    }

    public final View.OnClickListener getOnPositiveClickListener() {
        return this.d;
    }
}
