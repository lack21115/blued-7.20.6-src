package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.PopMsgListCheatBinding;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.model.MsgListCheatModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/MsgListCheatDialog.class */
public final class MsgListCheatDialog extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f32496c = {Reflection.a(new PropertyReference1Impl(MsgListCheatDialog.class, "vb", "getVb()Lcom/soft/blued/databinding/PopMsgListCheatBinding;", 0))};
    private final MsgListCheatModel d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgListCheatDialog(Context context, MsgListCheatModel info) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(info, "info");
        this.d = info;
        this.e = new CustomViewBindingProperty(new Function1<MsgListCheatDialog, PopMsgListCheatBinding>() { // from class: com.soft.blued.ui.msg.pop.MsgListCheatDialog$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopMsgListCheatBinding invoke(MsgListCheatDialog popView) {
                Intrinsics.e(popView, "popView");
                return PopMsgListCheatBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MsgListCheatDialog this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        EventTrackMessage.a(MessageProtos.Event.MSG_LIST_SAFE_WARN_BACK_CLICK);
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MsgListCheatDialog this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        EventTrackMessage.a(MessageProtos.Event.MSG_LIST_SAFE_WARN_GET_CLICK);
        this$0.p();
        WebViewShowInfoFragment.show(this$0.getContext(), this$0.d.getUrl());
    }

    private final PopMsgListCheatBinding getVb() {
        return (PopMsgListCheatBinding) this.e.b(this, f32496c[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        PopMsgListCheatBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.f29546c.setText(getInfo().getButton());
        vb.f29545a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$MsgListCheatDialog$_Et1exvtsMfdoBn174EvBDsCpKs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgListCheatDialog.a(MsgListCheatDialog.this, view);
            }
        });
        vb.d.setText(getInfo().getTitle());
        vb.b.setText(getInfo().getContent());
        vb.f29546c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$MsgListCheatDialog$oolgVOaMtoTQ9C4y4P8GOvqHIdM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgListCheatDialog.b(MsgListCheatDialog.this, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_msg_list_cheat;
    }

    public final MsgListCheatModel getInfo() {
        return this.d;
    }
}
