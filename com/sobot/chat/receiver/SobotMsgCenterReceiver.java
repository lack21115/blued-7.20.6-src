package com.sobot.chat.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.api.model.ZhiChiPushMessage;
import com.sobot.chat.utils.ZhiChiConstant;
import java.util.Calendar;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/receiver/SobotMsgCenterReceiver.class */
public abstract class SobotMsgCenterReceiver extends BroadcastReceiver {
    public abstract List<SobotMsgCenterModel> getMsgCenterDatas();

    public abstract void onDataChanged(SobotMsgCenterModel sobotMsgCenterModel);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SobotMsgCenterModel sobotMsgCenterModel;
        ZhiChiPushMessage zhiChiPushMessage;
        List<SobotMsgCenterModel> msgCenterDatas;
        if (!ZhiChiConstants.receiveMessageBrocast.equals(intent.getAction())) {
            if (!ZhiChiConstant.SOBOT_ACTION_UPDATE_LAST_MSG.equals(intent.getAction()) || (sobotMsgCenterModel = (SobotMsgCenterModel) intent.getSerializableExtra("lastMsg")) == null || sobotMsgCenterModel.getInfo() == null || TextUtils.isEmpty(sobotMsgCenterModel.getInfo().getApp_key())) {
                return;
            }
            onDataChanged(sobotMsgCenterModel);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null || (zhiChiPushMessage = (ZhiChiPushMessage) extras.getSerializable(ZhiChiConstants.ZHICHI_PUSH_MESSAGE)) == null || TextUtils.isEmpty(zhiChiPushMessage.getAppId()) || 202 != zhiChiPushMessage.getType() || (msgCenterDatas = getMsgCenterDatas()) == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= msgCenterDatas.size()) {
                return;
            }
            SobotMsgCenterModel sobotMsgCenterModel2 = msgCenterDatas.get(i2);
            if (sobotMsgCenterModel2.getInfo() != null && zhiChiPushMessage.getAppId().equals(sobotMsgCenterModel2.getInfo().getApp_key())) {
                sobotMsgCenterModel2.setLastDateTime(Calendar.getInstance().getTime().getTime() + "");
                if (zhiChiPushMessage.getAnswer() != null) {
                    sobotMsgCenterModel2.setLastMsg(zhiChiPushMessage.getAnswer().getMsg());
                }
                sobotMsgCenterModel2.setUnreadCount(sobotMsgCenterModel2.getUnreadCount() + 1);
                onDataChanged(sobotMsgCenterModel2);
                return;
            }
            i = i2 + 1;
        }
    }
}
