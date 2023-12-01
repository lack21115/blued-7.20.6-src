package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
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
    static final /* synthetic */ KProperty<Object>[] f16860c = {(KProperty) Reflection.a(new PropertyReference1Impl(VIPGuidePopupWindow.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/DialogVipGuideBinding;", 0))};
    private final Context d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VIPGuidePopupWindow(Context context) {
        super(context);
        Intrinsics.e(context, "mContext");
        this.d = context;
        BasePopupView basePopupView = (BasePopupView) this;
        this.e = new CustomViewBindingProperty(new Function1<VIPGuidePopupWindow, DialogVipGuideBinding>() { // from class: com.soft.blued.ui.find.fragment.VIPGuidePopupWindow$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final DialogVipGuideBinding invoke(VIPGuidePopupWindow vIPGuidePopupWindow) {
                Intrinsics.e(vIPGuidePopupWindow, "popView");
                return DialogVipGuideBinding.a(vIPGuidePopupWindow.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPGuidePopupWindow vIPGuidePopupWindow, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, View view) {
        Tracker.onClick(view);
        Intrinsics.e(vIPGuidePopupWindow, "this$0");
        Intrinsics.e(objectRef, "$detail");
        Intrinsics.e(objectRef2, "$from");
        PayUtils.a(vIPGuidePopupWindow.d, 2, (String) objectRef.a, -1, (VipProtos.FromType) objectRef2.a);
        if (BluedConfig.a().U() == 1) {
            EventTrackVIP.a(VipProtos.Event.NEW_USER_VIP_GUIDE_POP_BUY_CLICK);
        } else {
            EventTrackVIP.a(VipProtos.Event.NEW_USER_VIP_POP_BUY_CLICK);
        }
        vIPGuidePopupWindow.p();
    }

    private final DialogVipGuideBinding getViewBinding() {
        return (DialogVipGuideBinding) this.e.b(this, f16860c[0]);
    }

    public void b() {
        super.b();
        DialogVipGuideBinding viewBinding = getViewBinding();
        if (viewBinding == null) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = "";
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.a = VipProtos.FromType.UNKNOWN_FROM;
        if (BluedConfig.a().U() == 1) {
            objectRef.a = "new_user_guide";
            ImageLoader.a((IRequestHost) null, ImgURLMap.a.a("vip_guide_dialog_bg_new")).a(viewBinding.f15038a);
            objectRef2.a = VipProtos.FromType.NEW_USER_GUIDE;
            EventTrackVIP.a(VipProtos.Event.NEW_USER_VIP_GUIDE_POP_SHOW);
        } else {
            ImageLoader.a((IRequestHost) null, ImgURLMap.a.a("vip_guide_dialog_bg")).a(viewBinding.f15038a);
            EventTrackVIP.a(VipProtos.Event.NEW_USER_VIP_POP_SHOW);
        }
        viewBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$VIPGuidePopupWindow$hYzKqIxseNkTs-DhWskOo1sOdnw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPGuidePopupWindow.a(VIPGuidePopupWindow.this, objectRef, objectRef2, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.dialog_vip_guide;
    }

    public final Context getMContext() {
        return this.d;
    }
}
