package com.soft.blued.ui.msg_group.pop;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.soft.blued.R;
import com.soft.blued.databinding.PopGroupUserCardBinding;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.model.AtUserEvent;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/UserCardPop.class */
public final class UserCardPop extends BottomPopupView {
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(UserCardPop.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGroupUserCardBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final UserInfoEntity f32802c;
    private final IRequestHost d;
    private final int e;
    private final GroupInfoModel f;
    private final ViewBindingProperty g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCardPop(Context context, UserInfoEntity userInfo, IRequestHost requestHost, int i, GroupInfoModel groupInfo) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(userInfo, "userInfo");
        Intrinsics.e(requestHost, "requestHost");
        Intrinsics.e(groupInfo, "groupInfo");
        this.f32802c = userInfo;
        this.d = requestHost;
        this.e = i;
        this.f = groupInfo;
        this.g = new CustomViewBindingProperty(new Function1<UserCardPop, PopGroupUserCardBinding>() { // from class: com.soft.blued.ui.msg_group.pop.UserCardPop$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopGroupUserCardBinding invoke(UserCardPop popView) {
                Intrinsics.e(popView, "popView");
                return PopGroupUserCardBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardPop this$0) {
        Intrinsics.e(this$0, "this$0");
        Observable<Object> observable = LiveEventBus.get("card_at_user");
        AtUserEvent atUserEvent = new AtUserEvent();
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.name = this$0.getUserInfo().name;
        userBasicModel.uid = this$0.getUserInfo().uid;
        atUserEvent.a(userBasicModel);
        observable.post(atUserEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardPop this$0, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        LiveEventBus.get("group_chat_kick_out", String.class).post(this$0.f32802c.uid);
        dialogInterface.dismiss();
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardPop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(UserCardPop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
        UserInfoFragmentNew.a(this$0.getContext(), Intrinsics.a(this$0.f32802c.uid, (Object) ""), "group_chatting");
    }

    private final void c() {
        Context context;
        int i;
        if (this.f.type == 4) {
            context = getContext();
            i = 2131888375;
        } else {
            context = getContext();
            i = 2131888441;
        }
        String string = context.getString(i);
        Intrinsics.c(string, "if (groupInfo.type == Gr…R.string.group_kick_user)");
        Context context2 = getContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String format = String.format(string, Arrays.copyOf(new Object[]{this.f32802c.name}, 1));
        Intrinsics.c(format, "format(format, *args)");
        CommonAlertDialog.a(context2, "", format, getContext().getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$UserCardPop$6Th1reD4Dcwn_92zx_F_zJbP0QY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UserCardPop.a(UserCardPop.this, dialogInterface, i2);
            }
        }, getContext().getResources().getString(2131887258), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$UserCardPop$qaE8ikmCr9nE9PJ---TWdth9bIs
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UserCardPop.a(dialogInterface, i2);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(UserCardPop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
        ChatHelperV4 a2 = ChatHelperV4.a();
        Context context = this$0.getContext();
        String str = this$0.f32802c.uid;
        Intrinsics.c(str, "userInfo.uid");
        long parseLong = Long.parseLong(str);
        String str2 = this$0.f32802c.name;
        String str3 = this$0.f32802c.avatar;
        int i = this$0.f32802c.vbadge;
        int i2 = this$0.f32802c.vip_grade;
        int i3 = this$0.f32802c.is_vip_annual;
        int i4 = this$0.f32802c.vip_exp_lvl;
        LogData logData = new LogData();
        logData.userFrom = "group_chatting";
        Unit unit = Unit.f42314a;
        a2.a(context, parseLong, str2, str3, i, i2, i3, i4, "", false, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.GROUP_CHAT, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final UserCardPop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
        view.postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$UserCardPop$Q5j6899ntIduIkLAk90u0rc9OUc
            @Override // java.lang.Runnable
            public final void run() {
                UserCardPop.a(UserCardPop.this);
            }
        }, 500L);
    }

    private final boolean d() {
        if (this.f.group_role == 2 || this.f.group_role == 1) {
            return this.f.group_role != 2 || this.e == 3;
        }
        return false;
    }

    private final PopGroupUserCardBinding getVb() {
        return (PopGroupUserCardBinding) this.g.b(this, b[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        PopGroupUserCardBinding vb = getVb();
        if (vb == null) {
            return;
        }
        if (d()) {
            vb.f.setVisibility(0);
            vb.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$UserCardPop$j8854VDj7zOG4GRVGG5fhRTimHY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserCardPop.a(UserCardPop.this, view);
                }
            });
        } else {
            vb.f.setVisibility(4);
        }
        GroupUtil.a(getRequestHost(), getUserInfo().avatar, vb.f29534c);
        GroupUtil.a(vb.m, getGroupRole());
        vb.n.setText(getUserInfo().name);
        UserRelationshipUtils.a(vb.e, getUserInfo());
        UserInfoHelper.a(vb.d, getUserInfo().vbadge, 3);
        if (getUserInfo().vbadge == 3 || getUserInfo().vbadge == 5) {
            vb.g.setVisibility(4);
            vb.l.setVisibility(8);
        } else {
            if (TextUtils.isEmpty(getUserInfo().age)) {
                vb.f29533a.setText("");
            } else {
                vb.f29533a.setText(Intrinsics.a(getUserInfo().age, (Object) getResources().getString(2131886374)));
            }
            if (TextUtils.isEmpty(getUserInfo().height)) {
                vb.b.setText("");
            } else {
                vb.b.setText(getUserInfo().height);
            }
            if (TextUtils.isEmpty(getUserInfo().weight)) {
                vb.q.setText("");
            } else {
                vb.q.setText(getUserInfo().weight);
            }
            if (TextUtils.isEmpty(getUserInfo().location) || getUserInfo().vbadge == 3) {
                vb.l.setText("");
            } else {
                vb.l.setText(Intrinsics.a(getUserInfo().location, (Object) " · "));
            }
        }
        vb.o.setText(TimeAndDateUtils.a(getContext(), TimeAndDateUtils.c(getUserInfo().last_operate)));
        if (getUserInfo().is_official != 1) {
            UserInfoHelper.a(getContext(), vb.i, getUserInfo().role);
        }
        vb.p.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$UserCardPop$NTPfG9H64vWQe8VmU0n-ck8892c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardPop.b(UserCardPop.this, view);
            }
        });
        vb.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$UserCardPop$jUv_F4Mt6ypJC1tnS2Ew6D4U6AQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardPop.c(UserCardPop.this, view);
            }
        });
        vb.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$UserCardPop$cCqeKHuUPmMRo7sjDw01LxDC-xY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardPop.d(UserCardPop.this, view);
            }
        });
    }

    public final GroupInfoModel getGroupInfo() {
        return this.f;
    }

    public final int getGroupRole() {
        return this.e;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_group_user_card;
    }

    public final IRequestHost getRequestHost() {
        return this.d;
    }

    public final UserInfoEntity getUserInfo() {
        return this.f32802c;
    }
}
