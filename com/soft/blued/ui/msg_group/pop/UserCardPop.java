package com.soft.blued.ui.msg_group.pop;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
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
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(UserCardPop.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGroupUserCardBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final UserInfoEntity f19111c;
    private final IRequestHost d;
    private final int e;
    private final GroupInfoModel f;
    private final ViewBindingProperty g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCardPop(Context context, UserInfoEntity userInfoEntity, IRequestHost iRequestHost, int i, GroupInfoModel groupInfoModel) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(userInfoEntity, "userInfo");
        Intrinsics.e(iRequestHost, "requestHost");
        Intrinsics.e(groupInfoModel, "groupInfo");
        this.f19111c = userInfoEntity;
        this.d = iRequestHost;
        this.e = i;
        this.f = groupInfoModel;
        BasePopupView basePopupView = (BasePopupView) this;
        this.g = new CustomViewBindingProperty(new Function1<UserCardPop, PopGroupUserCardBinding>() { // from class: com.soft.blued.ui.msg_group.pop.UserCardPop$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopGroupUserCardBinding invoke(UserCardPop userCardPop) {
                Intrinsics.e(userCardPop, "popView");
                return PopGroupUserCardBinding.a(userCardPop.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardPop userCardPop) {
        Intrinsics.e(userCardPop, "this$0");
        Observable<Object> observable = LiveEventBus.get("card_at_user");
        AtUserEvent atUserEvent = new AtUserEvent();
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.name = userCardPop.getUserInfo().name;
        userBasicModel.uid = userCardPop.getUserInfo().uid;
        atUserEvent.a(userBasicModel);
        observable.post(atUserEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardPop userCardPop, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(userCardPop, "this$0");
        LiveEventBus.get("group_chat_kick_out", String.class).post(userCardPop.f19111c.uid);
        dialogInterface.dismiss();
        userCardPop.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardPop userCardPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(userCardPop, "this$0");
        userCardPop.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(UserCardPop userCardPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(userCardPop, "this$0");
        userCardPop.p();
        UserInfoFragmentNew.a(userCardPop.getContext(), Intrinsics.a(userCardPop.f19111c.uid, ""), "group_chatting");
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
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format(string, Arrays.copyOf(new Object[]{this.f19111c.name}, 1));
        Intrinsics.c(format, "format(format, *args)");
        CommonAlertDialog.a(context2, "", format, getContext().getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$UserCardPop$6Th1reD4Dcwn_92zx_F_zJbP0QY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UserCardPop.a(UserCardPop.this, dialogInterface, i2);
            }
        }, getContext().getResources().getString(R.string.common_cancel), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$UserCardPop$qaE8ikmCr9nE9PJ---TWdth9bIs
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UserCardPop.a(dialogInterface, i2);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(UserCardPop userCardPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(userCardPop, "this$0");
        userCardPop.p();
        ChatHelperV4 a2 = ChatHelperV4.a();
        Context context = userCardPop.getContext();
        String str = userCardPop.f19111c.uid;
        Intrinsics.c(str, "userInfo.uid");
        long parseLong = Long.parseLong(str);
        String str2 = userCardPop.f19111c.name;
        String str3 = userCardPop.f19111c.avatar;
        int i = userCardPop.f19111c.vbadge;
        int i2 = userCardPop.f19111c.vip_grade;
        int i3 = userCardPop.f19111c.is_vip_annual;
        int i4 = userCardPop.f19111c.vip_exp_lvl;
        LogData logData = new LogData();
        logData.userFrom = "group_chatting";
        Unit unit = Unit.a;
        a2.a(context, parseLong, str2, str3, i, i2, i3, i4, "", false, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.GROUP_CHAT, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final UserCardPop userCardPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(userCardPop, "this$0");
        userCardPop.p();
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
        GroupUtil.a(getRequestHost(), getUserInfo().avatar, vb.f15844c);
        GroupUtil.a(vb.m, getGroupRole());
        vb.n.setText(getUserInfo().name);
        UserRelationshipUtils.a(vb.e, getUserInfo());
        UserInfoHelper.a(vb.d, getUserInfo().vbadge, 3);
        if (getUserInfo().vbadge == 3 || getUserInfo().vbadge == 5) {
            vb.g.setVisibility(4);
            vb.l.setVisibility(8);
        } else {
            if (TextUtils.isEmpty(getUserInfo().age)) {
                vb.f15843a.setText("");
            } else {
                vb.f15843a.setText(Intrinsics.a(getUserInfo().age, getResources().getString(2131886374)));
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
                vb.l.setText(Intrinsics.a(getUserInfo().location, " · "));
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

    public int getImplLayoutId() {
        return R.layout.pop_group_user_card;
    }

    public final IRequestHost getRequestHost() {
        return this.d;
    }

    public final UserInfoEntity getUserInfo() {
        return this.f19111c;
    }
}
