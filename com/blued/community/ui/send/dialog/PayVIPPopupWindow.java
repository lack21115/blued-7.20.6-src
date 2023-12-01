package com.blued.community.ui.send.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.PopupWindowPayVipBinding;
import com.blued.community.track.EventTrackOther;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/PayVIPPopupWindow.class */
public final class PayVIPPopupWindow extends CenterPopupView {
    private final Context e;
    private int f;
    private String g;
    private String h;
    private int i;
    private DialogInterface.OnDismissListener j;
    private String k;
    private final ViewBindingProperty t;
    static final /* synthetic */ KProperty<Object>[] d = {Reflection.a(new PropertyReference1Impl(PayVIPPopupWindow.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/PopupWindowPayVipBinding;", 0))};
    public static final Companion c = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/PayVIPPopupWindow$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i, DialogInterface.OnDismissListener onDismissListener) {
            Intrinsics.e(context, "context");
            if (CommunityServiceManager.e().i()) {
                return;
            }
            new XPopup.Builder(context).a(PopupAnimation.ScaleAlphaFromCenter).c((Boolean) false).d((Boolean) true).b((Boolean) false).a((BasePopupView) new PayVIPPopupWindow(context, i, onDismissListener)).h();
        }

        public final void a(Context context, int i, String title, String desc) {
            Intrinsics.e(context, "context");
            Intrinsics.e(title, "title");
            Intrinsics.e(desc, "desc");
            new XPopup.Builder(context).a(PopupAnimation.ScaleAlphaFromCenter).c((Boolean) false).d((Boolean) true).b((Boolean) false).a((BasePopupView) new PayVIPPopupWindow(context, i, title, desc)).h();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/PayVIPPopupWindow$OnVideoSuccessListener.class */
    public interface OnVideoSuccessListener {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayVIPPopupWindow(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.e = mContext;
        this.f = 1;
        this.g = "";
        this.h = "";
        this.k = "flash_photo";
        this.t = new CustomViewBindingProperty(new Function1<PayVIPPopupWindow, PopupWindowPayVipBinding>() { // from class: com.blued.community.ui.send.dialog.PayVIPPopupWindow$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopupWindowPayVipBinding invoke(PayVIPPopupWindow popView) {
                Intrinsics.e(popView, "popView");
                return PopupWindowPayVipBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PayVIPPopupWindow(Context context, int i, DialogInterface.OnDismissListener onDismissListener) {
        this(context);
        Intrinsics.e(context, "context");
        this.f = 1;
        this.i = i;
        this.j = onDismissListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PayVIPPopupWindow(Context context, int i, String title, String desc) {
        this(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(title, "title");
        Intrinsics.e(desc, "desc");
        this.f = i;
        this.g = title;
        this.h = desc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PayVIPPopupWindow this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        CommunityServiceManager.b().a(this$0.e, 0, "nearb_user_photo", 10001, VipProtos.FromType.UNKNOWN_FROM);
        EventTrackOther.a(VipProtos.Event.NEARBY_USER_VIP_POP_BUY_CLICK);
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PayVIPPopupWindow this$0, Ref.ObjectRef type, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(type, "$type");
        CommunityServiceManager.b().a(this$0.e, 0, this$0.k, 33, VipProtos.FromType.FLASH_PRIVILEGE);
        this$0.p();
        EventTrackOther.a(MessageProtos.Event.FLASH_PHOTO_BUY_POP_YES_CLICK, (String) type.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PayVIPPopupWindow this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final PayVIPPopupWindow this$0, Ref.ObjectRef type, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(type, "$type");
        Log.a("drb", "onClick");
        if (this$0.i != 1 || CommunityServiceManager.a().H() <= 0) {
            this$0.p();
            EventTrackOther.a(MessageProtos.Event.FLASH_PHOTO_BUY_POP_NO_CLICK, (String) type.a);
            return;
        }
        BluedADExtra bluedADExtra = new BluedADExtra();
        bluedADExtra.aid = CommunityServiceManager.a().I();
        bluedADExtra.third_id = CommunityServiceManager.a().J();
        bluedADExtra.adms_type = CommunityServiceManager.a().K();
        if (TextUtils.isEmpty(bluedADExtra.third_id) || !TextUtils.equals(bluedADExtra.adms_type, ATAdConst.ATDevFrameworkType.FLUTTER)) {
            this$0.p();
            AppMethods.d(R.string.msg_flash_stimulate_failed);
        } else {
            CommunityServiceManager.b().a(this$0.getContext(), bluedADExtra, 2, new OnVideoSuccessListener() { // from class: com.blued.community.ui.send.dialog.PayVIPPopupWindow$initFlashPop$3$1
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r3.a.j;
                 */
                @Override // com.blued.community.ui.send.dialog.PayVIPPopupWindow.OnVideoSuccessListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a(boolean r4) {
                    /*
                        r3 = this;
                        r0 = r4
                        if (r0 == 0) goto L1a
                        r0 = r3
                        com.blued.community.ui.send.dialog.PayVIPPopupWindow r0 = com.blued.community.ui.send.dialog.PayVIPPopupWindow.this
                        android.content.DialogInterface$OnDismissListener r0 = com.blued.community.ui.send.dialog.PayVIPPopupWindow.a(r0)
                        r5 = r0
                        r0 = r5
                        if (r0 != 0) goto L13
                        goto L1a
                    L13:
                        r0 = r5
                        r1 = 0
                        r0.onDismiss(r1)
                    L1a:
                        r0 = r3
                        com.blued.community.ui.send.dialog.PayVIPPopupWindow r0 = com.blued.community.ui.send.dialog.PayVIPPopupWindow.this
                        r0.p()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.send.dialog.PayVIPPopupWindow$initFlashPop$3$1.a(boolean):void");
                }
            });
        }
        EventTrackOther.a(MessageProtos.Event.FLASH_PHOTO_BUY_POP_FREE_CLICK, (String) type.a);
    }

    private final void c() {
        PopupWindowPayVipBinding viewBinding = getViewBinding();
        if (viewBinding == null) {
            return;
        }
        viewBinding.g.setText(this.g);
        viewBinding.f.setText(this.h);
        viewBinding.c.setImageDrawable(BluedSkinUtils.b(getMContext(), R.drawable.icon_nearby_people_list_pay_vip_popup_window_bg));
        EventTrackOther.a(VipProtos.Event.NEARBY_USER_VIP_POP_SHOW);
        viewBinding.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$PayVIPPopupWindow$6eZjjR5aMCmGiXZOgJpYCaZR4qk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayVIPPopupWindow.a(PayVIPPopupWindow.this, view);
            }
        });
        viewBinding.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$PayVIPPopupWindow$_ewxYwQ6apFrChKZxkr5pnqIvqg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayVIPPopupWindow.b(PayVIPPopupWindow.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PayVIPPopupWindow this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    private final void d() {
        ImageView imageView;
        TextView textView;
        ShapeTextView shapeTextView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView2;
        TextView textView3;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = "think";
        if (!TextUtils.isEmpty(CommunityServiceManager.a().J()) && TextUtils.equals(CommunityServiceManager.a().K(), "4")) {
            objectRef.a = "video";
        }
        if (!TextUtils.isEmpty(CommunityServiceManager.a().G())) {
            PopupWindowPayVipBinding viewBinding = getViewBinding();
            TextView textView4 = viewBinding == null ? null : viewBinding.f;
            if (textView4 != null) {
                textView4.setText(CommunityServiceManager.a().G());
            }
        }
        if (this.i != 1 || CommunityServiceManager.a().H() <= 0) {
            PopupWindowPayVipBinding viewBinding2 = getViewBinding();
            ImageView imageView4 = viewBinding2 == null ? null : viewBinding2.b;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
            PopupWindowPayVipBinding viewBinding3 = getViewBinding();
            if (viewBinding3 != null && (imageView = viewBinding3.b) != null) {
                imageView.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_pay_vip_popup_window_bg));
            }
        } else {
            this.k = "flash_vip";
            PopupWindowPayVipBinding viewBinding4 = getViewBinding();
            if (viewBinding4 != null && (textView3 = viewBinding4.d) != null) {
                textView3.setTextColor(getContext().getResources().getColor(R.color.syc_a));
            }
            PopupWindowPayVipBinding viewBinding5 = getViewBinding();
            TextView textView5 = viewBinding5 == null ? null : viewBinding5.d;
            if (textView5 != null) {
                textView5.setText(getContext().getString(R.string.msg_flash_dialog_two));
            }
            PopupWindowPayVipBinding viewBinding6 = getViewBinding();
            TextView textView6 = viewBinding6 == null ? null : viewBinding6.f;
            if (textView6 != null) {
                StringBuilder sb = new StringBuilder();
                PopupWindowPayVipBinding viewBinding7 = getViewBinding();
                sb.append((Object) ((viewBinding7 == null || (textView2 = viewBinding7.f) == null) ? null : textView2.getText()));
                sb.append('\n');
                sb.append(getContext().getString(R.string.msg_flash_dialog_refresh_content));
                textView6.setText(sb.toString());
            }
            if (!TextUtils.isEmpty(CommunityServiceManager.a().L())) {
                PopupWindowPayVipBinding viewBinding8 = getViewBinding();
                TextView textView7 = viewBinding8 == null ? null : viewBinding8.d;
                if (textView7 != null) {
                    textView7.setText(CommunityServiceManager.a().L());
                }
            }
            PopupWindowPayVipBinding viewBinding9 = getViewBinding();
            if (viewBinding9 != null && (imageView3 = viewBinding9.c) != null) {
                imageView3.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_pay_vip_popup_window_bg_1));
            }
            PopupWindowPayVipBinding viewBinding10 = getViewBinding();
            ImageView imageView5 = viewBinding10 == null ? null : viewBinding10.b;
            if (imageView5 != null) {
                imageView5.setVisibility(0);
            }
            PopupWindowPayVipBinding viewBinding11 = getViewBinding();
            if (viewBinding11 != null && (imageView2 = viewBinding11.b) != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$PayVIPPopupWindow$t1FvlRbkk14I2Oe6qQGCrmPlPfg
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PayVIPPopupWindow.c(PayVIPPopupWindow.this, view);
                    }
                });
            }
        }
        PopupWindowPayVipBinding viewBinding12 = getViewBinding();
        if (viewBinding12 != null && (shapeTextView = viewBinding12.e) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$PayVIPPopupWindow$zAuIAyio5eCSnKp0mI_mf2hoXkI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayVIPPopupWindow.a(PayVIPPopupWindow.this, objectRef, view);
                }
            });
        }
        PopupWindowPayVipBinding viewBinding13 = getViewBinding();
        if (viewBinding13 != null && (textView = viewBinding13.d) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$PayVIPPopupWindow$t6Go2xUhtnbD2Mjt2v-vVUaMsSI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayVIPPopupWindow.b(PayVIPPopupWindow.this, objectRef, view);
                }
            });
        }
        EventTrackOther.a(MessageProtos.Event.FLASH_PHOTO_BUY_POP_SHOW, (String) objectRef.a);
    }

    private final PopupWindowPayVipBinding getViewBinding() {
        return (PopupWindowPayVipBinding) this.t.b(this, d[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        int i = this.f;
        if (i == 1) {
            d();
        } else if (i != 2) {
        } else {
            c();
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.popup_window_pay_vip;
    }

    public final Context getMContext() {
        return this.e;
    }
}
