package com.soft.blued.ui.msg_group.pop;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.PopGroupCommandSendBinding;
import com.soft.blued.log.track.EventTrackGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/PopGroupCommandSend.class */
public final class PopGroupCommandSend extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f32797c = {Reflection.a(new PropertyReference1Impl(PopGroupCommandSend.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGroupCommandSendBinding;", 0))};
    private final String d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopGroupCommandSend(Context context, String groupId) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(groupId, "groupId");
        this.d = groupId;
        this.e = new CustomViewBindingProperty(new Function1<PopGroupCommandSend, PopGroupCommandSendBinding>() { // from class: com.soft.blued.ui.msg_group.pop.PopGroupCommandSend$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopGroupCommandSendBinding invoke(PopGroupCommandSend popView) {
                Intrinsics.e(popView, "popView");
                return PopGroupCommandSendBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopGroupCommandSend this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopGroupCommandSend this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_JOIN_LIMIT_POP_WECHAT_CLICK, this$0.d);
        Intent launchIntentForPackage = this$0.getContext().getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
        if (launchIntentForPackage == null) {
            return;
        }
        this$0.getContext().startActivity(launchIntentForPackage);
    }

    private final PopGroupCommandSendBinding getVb() {
        return (PopGroupCommandSendBinding) this.e.b(this, f32797c[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        PopGroupCommandSendBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.f29523a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupCommandSend$qkpkI-xVQ6LQQOAdoLVpYAmrxaw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupCommandSend.a(PopGroupCommandSend.this, view);
            }
        });
        vb.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupCommandSend$fElKzNxkCBUHCK6BLg_Ueuw9f18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupCommandSend.b(PopGroupCommandSend.this, view);
            }
        });
    }

    public final String getGroupId() {
        return this.d;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_group_command_send;
    }
}
