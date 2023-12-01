package com.soft.blued.ui.setting.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blued.android.core.Hashids;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.community.utils.UserInfoUtils;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.api.enumtype.SobotChatTitleDisplayMode;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.utils.ZhiChiConstant;
import com.soft.blued.R;
import com.soft.blued.ui.setting.fragment.ServiceCenterFragment;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/tools/ServiceHelper.class */
public final class ServiceHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final ServiceHelper f19954a = new ServiceHelper();

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/tools/ServiceHelper$ZhiChiNewMsgListener.class */
    public interface ZhiChiNewMsgListener {
        void a();
    }

    private ServiceHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, View view2) {
        Tracker.onClick(view2);
        Intrinsics.e(view, "$root");
        Information information = new Information();
        information.setApp_key(view.getContext().getString(R.string.sobot_app_key));
        information.setShowLeftBackPop(true);
        information.setShowSatisfaction(true);
        information.setHideMenuLeave(false);
        try {
            Long valueOf = Long.valueOf(!UserInfoUtils.f() ? String.valueOf(System.currentTimeMillis()) : UserInfoUtils.c());
            Intrinsics.c(valueOf, "valueOf(uid)");
            information.setPartnerid(new Hashids("2765", 24).a(new long[]{valueOf.longValue()}));
        } catch (Exception e) {
            e.printStackTrace();
        }
        information.setUname(information.getPartnerid());
        information.setUser_name(information.getPartnerid());
        information.setUser_nick(information.getPartnerid());
        information.setUseVoice(false);
        ZCSobotApi.setEvaluationCompletedExit(view.getContext(), true);
        ZCSobotApi.setSwitchMarkStatus(2, false);
        information.setHideMenuVedio(true);
        ZCSobotApi.setChatTitleDisplayMode(view.getContext(), SobotChatTitleDisplayMode.Default, "", true);
        ZCSobotApi.openZCChat(view.getContext(), information);
    }

    public final void a(Context context) {
        Intrinsics.e(context, "context");
        TerminalActivity.d(context, ServiceCenterFragment.class, (Bundle) null);
    }

    public final void a(Context context, final ZhiChiNewMsgListener zhiChiNewMsgListener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(zhiChiNewMsgListener, "listener");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ZhiChiConstant.sobot_unreadCountBrocast);
        context.registerReceiver(new BroadcastReceiver() { // from class: com.soft.blued.ui.setting.tools.ServiceHelper$registerNewMsgBroadcast$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                ServiceHelper.ZhiChiNewMsgListener.this.a();
            }
        }, intentFilter);
    }

    public final void a(final View view) {
        Intrinsics.e(view, "root");
        View findViewById = view.findViewById(R.id.btn_service);
        QBadgeContainer qBadgeContainer = (QBadgeContainer) view.findViewById(R.id.badge_container);
        Intrinsics.c(qBadgeContainer, "tv_badgeContainer");
        View findViewById2 = view.findViewById(R.id.bindView);
        Intrinsics.c(findViewById2, "root.findViewById(R.id.bindView)");
        a(qBadgeContainer, findViewById2);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.tools.-$$Lambda$ServiceHelper$_EXm86zWmLgRQ2ogNuE7D9YgPW0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ServiceHelper.a(view, view2);
            }
        });
    }

    public final void a(QBadgeContainer qBadgeContainer, View view) {
        Intrinsics.e(qBadgeContainer, "tv_badgeContainer");
        Intrinsics.e(view, "bindView");
        qBadgeContainer.a(view);
        qBadgeContainer.d(17);
        qBadgeContainer.b(5.0f, true);
        qBadgeContainer.b(ContextCompat.getColor(qBadgeContainer.getContext(), 2131102251));
        int unReadMessage = ZCSobotApi.getUnReadMessage(qBadgeContainer.getContext(), EncryptTool.b(UserInfoUtils.c()));
        qBadgeContainer.a(unReadMessage);
        if (unReadMessage > 0) {
            qBadgeContainer.setVisibility(0);
        } else {
            qBadgeContainer.setVisibility(8);
        }
    }
}
