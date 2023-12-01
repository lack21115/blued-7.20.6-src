package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.PopSpecialCareBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/PopSpecialCare.class */
public final class PopSpecialCare extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f32506c = {Reflection.a(new PropertyReference1Impl(PopSpecialCare.class, "vb", "getVb()Lcom/soft/blued/databinding/PopSpecialCareBinding;", 0))};
    private final Context d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopSpecialCare(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.d = mContext;
        this.e = new CustomViewBindingProperty(new Function1<PopSpecialCare, PopSpecialCareBinding>() { // from class: com.soft.blued.ui.msg.pop.PopSpecialCare$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopSpecialCareBinding invoke(PopSpecialCare popView) {
                Intrinsics.e(popView, "popView");
                return PopSpecialCareBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopSpecialCare this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    private final PopSpecialCareBinding getVb() {
        return (PopSpecialCareBinding) this.e.b(this, f32506c[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        ImageView imageView;
        super.b();
        PopSpecialCareBinding vb = getVb();
        if (vb == null || (imageView = vb.f29555a) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$PopSpecialCare$djesoIzSTb3aAjznsIh625XoMRE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopSpecialCare.a(PopSpecialCare.this, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_special_care;
    }

    public final Context getMContext() {
        return this.d;
    }
}
