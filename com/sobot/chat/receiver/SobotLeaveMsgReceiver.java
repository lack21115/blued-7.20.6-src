package com.sobot.chat.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sobot.chat.activity.SobotTicketDetailActivity;
import com.sobot.chat.api.model.SobotLeaveReplyModel;
import com.sobot.chat.api.model.SobotUserTicketInfo;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ZhiChiConstant;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/receiver/SobotLeaveMsgReceiver.class */
public class SobotLeaveMsgReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (ZhiChiConstant.SOBOT_LEAVEREPLEY_NOTIFICATION_CLICK.equals(intent.getAction())) {
            SobotLeaveReplyModel sobotLeaveReplyModel = (SobotLeaveReplyModel) intent.getSerializableExtra("sobot_leavereply_model");
            String stringExtra = intent.getStringExtra("sobot_leavereply_companyId");
            String stringExtra2 = intent.getStringExtra("sobot_leavereply_uid");
            LogUtils.i(" 留言回复：" + sobotLeaveReplyModel);
            SobotUserTicketInfo sobotUserTicketInfo = new SobotUserTicketInfo();
            sobotUserTicketInfo.setTicketId(sobotLeaveReplyModel.getTicketId());
            context.startActivity(SobotTicketDetailActivity.newIntent(context, stringExtra, stringExtra2, sobotUserTicketInfo));
        }
    }
}
