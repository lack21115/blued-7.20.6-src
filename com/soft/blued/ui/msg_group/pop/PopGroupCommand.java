package com.soft.blued.ui.msg_group.pop;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.bytedance.applog.tracker.Tracker;
import com.heytap.mcssdk.constant.IntentConstant;
import com.soft.blued.R;
import com.soft.blued.databinding.PopGroupCommandBinding;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew;
import com.soft.blued.ui.msg_group.model.GroupCommandDetailResp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/PopGroupCommand.class */
public final class PopGroupCommand extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f19105c = {(KProperty) Reflection.a(new PropertyReference1Impl(PopGroupCommand.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGroupCommandBinding;", 0))};
    private final String d;
    private final GroupCommandDetailResp e;
    private final ViewBindingProperty f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopGroupCommand(Context context, String str, GroupCommandDetailResp groupCommandDetailResp) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(str, IntentConstant.COMMAND);
        Intrinsics.e(groupCommandDetailResp, "detail");
        this.d = str;
        this.e = groupCommandDetailResp;
        BasePopupView basePopupView = (BasePopupView) this;
        this.f = new CustomViewBindingProperty(new Function1<PopGroupCommand, PopGroupCommandBinding>() { // from class: com.soft.blued.ui.msg_group.pop.PopGroupCommand$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopGroupCommandBinding invoke(PopGroupCommand popGroupCommand) {
                Intrinsics.e(popGroupCommand, "popView");
                return PopGroupCommandBinding.a(popGroupCommand.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopGroupCommand popGroupCommand, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popGroupCommand, "this$0");
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_PASSWORD_LOOK_CLICK, popGroupCommand.d);
        popGroupCommand.p();
        Context context = popGroupCommand.getContext();
        Bundle bundle = new Bundle();
        bundle.putString("group_command", popGroupCommand.getCommand());
        bundle.putSerializable("group_command_data", popGroupCommand.getDetail());
        Unit unit = Unit.a;
        TerminalActivity.d(context, MyGroupFragmentNew.class, bundle);
    }

    private final PopGroupCommandBinding getVb() {
        return (PopGroupCommandBinding) this.f.b(this, f19105c[0]);
    }

    public void b() {
        super.b();
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_PASSWORD_POP_SHOW, this.d);
        PopGroupCommandBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.f15832a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupCommand$GiifUbzFDZ7NTw5av8-UT3jByIs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupCommand.a(PopGroupCommand.this, view);
            }
        });
    }

    public final String getCommand() {
        return this.d;
    }

    public final GroupCommandDetailResp getDetail() {
        return this.e;
    }

    public int getImplLayoutId() {
        return R.layout.pop_group_command;
    }
}
