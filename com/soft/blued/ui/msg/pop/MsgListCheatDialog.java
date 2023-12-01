package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
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
    static final /* synthetic */ KProperty<Object>[] f18805c = {(KProperty) Reflection.a(new PropertyReference1Impl(MsgListCheatDialog.class, "vb", "getVb()Lcom/soft/blued/databinding/PopMsgListCheatBinding;", 0))};
    private final MsgListCheatModel d;
    private final ViewBindingProperty e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgListCheatDialog(Context context, MsgListCheatModel msgListCheatModel) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(msgListCheatModel, "info");
        this.d = msgListCheatModel;
        BasePopupView basePopupView = (BasePopupView) this;
        this.e = new CustomViewBindingProperty(new Function1<MsgListCheatDialog, PopMsgListCheatBinding>() { // from class: com.soft.blued.ui.msg.pop.MsgListCheatDialog$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopMsgListCheatBinding invoke(MsgListCheatDialog msgListCheatDialog) {
                Intrinsics.e(msgListCheatDialog, "popView");
                return PopMsgListCheatBinding.a(msgListCheatDialog.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MsgListCheatDialog msgListCheatDialog, View view) {
        Tracker.onClick(view);
        Intrinsics.e(msgListCheatDialog, "this$0");
        EventTrackMessage.a(MessageProtos.Event.MSG_LIST_SAFE_WARN_BACK_CLICK);
        msgListCheatDialog.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MsgListCheatDialog msgListCheatDialog, View view) {
        Tracker.onClick(view);
        Intrinsics.e(msgListCheatDialog, "this$0");
        EventTrackMessage.a(MessageProtos.Event.MSG_LIST_SAFE_WARN_GET_CLICK);
        msgListCheatDialog.p();
        WebViewShowInfoFragment.show(msgListCheatDialog.getContext(), msgListCheatDialog.d.getUrl());
    }

    private final PopMsgListCheatBinding getVb() {
        return (PopMsgListCheatBinding) this.e.b(this, f18805c[0]);
    }

    public void b() {
        super.b();
        PopMsgListCheatBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.f15856c.setText(getInfo().getButton());
        vb.f15855a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$MsgListCheatDialog$_Et1exvtsMfdoBn174EvBDsCpKs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgListCheatDialog.a(MsgListCheatDialog.this, view);
            }
        });
        vb.d.setText(getInfo().getTitle());
        vb.b.setText(getInfo().getContent());
        vb.f15856c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$MsgListCheatDialog$oolgVOaMtoTQ9C4y4P8GOvqHIdM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgListCheatDialog.b(MsgListCheatDialog.this, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.pop_msg_list_cheat;
    }

    public final MsgListCheatModel getInfo() {
        return this.d;
    }
}
