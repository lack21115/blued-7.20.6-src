package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.DialogVipGuideBinding;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/VIPGuidePopupWindow.class */
public final class VIPGuidePopupWindow extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f30550c = {Reflection.a(new PropertyReference1Impl(VIPGuidePopupWindow.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/DialogVipGuideBinding;", 0))};
    private final Context d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VIPGuidePopupWindow(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.d = mContext;
        this.e = new CustomViewBindingProperty(new Function1<VIPGuidePopupWindow, DialogVipGuideBinding>() { // from class: com.soft.blued.ui.find.fragment.VIPGuidePopupWindow$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogVipGuideBinding invoke(VIPGuidePopupWindow popView) {
                Intrinsics.e(popView, "popView");
                return DialogVipGuideBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPGuidePopupWindow this$0, Ref.ObjectRef detail, Ref.ObjectRef from, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(detail, "$detail");
        Intrinsics.e(from, "$from");
        PayUtils.a(this$0.d, 2, (String) detail.f42545a, -1, (VipProtos.FromType) from.f42545a);
        if (BluedConfig.a().U() == 1) {
            EventTrackVIP.a(VipProtos.Event.NEW_USER_VIP_GUIDE_POP_BUY_CLICK);
        } else {
            EventTrackVIP.a(VipProtos.Event.NEW_USER_VIP_POP_BUY_CLICK);
        }
        this$0.p();
    }

    private final DialogVipGuideBinding getViewBinding() {
        return (DialogVipGuideBinding) this.e.b(this, f30550c[0]);
    }

    /* JADX WARN: Type inference failed for: r1v15, types: [com.blued.das.vip.VipProtos$FromType, T] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.blued.das.vip.VipProtos$FromType, T] */
    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        DialogVipGuideBinding viewBinding = getViewBinding();
        if (viewBinding == null) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = "";
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.f42545a = VipProtos.FromType.UNKNOWN_FROM;
        if (BluedConfig.a().U() == 1) {
            objectRef.f42545a = "new_user_guide";
            ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("vip_guide_dialog_bg_new")).a(viewBinding.f28728a);
            objectRef2.f42545a = VipProtos.FromType.NEW_USER_GUIDE;
            EventTrackVIP.a(VipProtos.Event.NEW_USER_VIP_GUIDE_POP_SHOW);
        } else {
            ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("vip_guide_dialog_bg")).a(viewBinding.f28728a);
            EventTrackVIP.a(VipProtos.Event.NEW_USER_VIP_POP_SHOW);
        }
        viewBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$VIPGuidePopupWindow$hYzKqIxseNkTs-DhWskOo1sOdnw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPGuidePopupWindow.a(VIPGuidePopupWindow.this, objectRef, objectRef2, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.dialog_vip_guide;
    }

    public final Context getMContext() {
        return this.d;
    }
}
