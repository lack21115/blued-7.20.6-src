package com.soft.blued.ui.home.pop;

import android.content.Context;
import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.PopAlinkBinding;
import com.soft.blued.ui.home.model.ALinkActionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/pop/PopALink.class */
public final class PopALink extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f31049c = {Reflection.a(new PropertyReference1Impl(PopALink.class, "vb", "getVb()Lcom/soft/blued/databinding/PopAlinkBinding;", 0))};
    private final ALinkActionModel d;
    private final ViewBindingProperty e;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopALink this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    private final PopAlinkBinding getVb() {
        return (PopAlinkBinding) this.e.b(this, f31049c[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        PopAlinkBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.pop.-$$Lambda$PopALink$yiI6VnkiglLzN7YdGaVldKUloGQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopALink.a(PopALink.this, view);
            }
        });
        Context context = getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.net.IRequestHost");
        }
        ImageLoader.a((IRequestHost) context, (String) StringsKt.b((CharSequence) getModel().getPopup_image(), new String[]{","}, false, 0, 6, (Object) null).get(0)).a(vb.f29504a);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_alink;
    }

    public final ALinkActionModel getModel() {
        return this.d;
    }
}
