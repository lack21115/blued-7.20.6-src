package com.heytap.mcssdk.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.IntentConstant;
import com.heytap.mcssdk.constant.McsEventConstant;
import com.heytap.mcssdk.statis.McsStatisticUtils;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/parser/DataMessageParser.class */
public class DataMessageParser extends MessageParser {
    public String getMsgCommand(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(IntentConstant.MSG_COMMAND);
        } catch (JSONException e) {
            LogUtil.d(e.getMessage());
            return "";
        }
    }

    @Override // com.heytap.mcssdk.parser.Parser
    public BaseMode parse(Context context, int i, Intent intent) {
        if (4103 == i || 4098 == i || 4108 == i) {
            BaseMode parseMessageByIntent = parseMessageByIntent(intent, i);
            McsStatisticUtils.statisticEvent(context, McsEventConstant.EventId.EVENT_ID_PUSH_TRANSMIT, (DataMessage) parseMessageByIntent);
            return parseMessageByIntent;
        }
        return null;
    }

    @Override // com.heytap.mcssdk.parser.MessageParser
    public BaseMode parseMessageByIntent(Intent intent, int i) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.MESSAGE_ID)));
            dataMessage.setTaskID(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.TASK_ID)));
            dataMessage.setGlobalId(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.GLOBAL_ID)));
            dataMessage.setAppPackage(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.APP_PACKAGE)));
            dataMessage.setTitle(CryptoUtil.sdkDecrypt(intent.getStringExtra("title")));
            dataMessage.setContent(CryptoUtil.sdkDecrypt(intent.getStringExtra("content")));
            dataMessage.setDescription(CryptoUtil.sdkDecrypt(intent.getStringExtra("description")));
            String sdkDecrypt = CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.NOTIFY_ID));
            dataMessage.setNotifyID(TextUtils.isEmpty(sdkDecrypt) ? 0 : Integer.parseInt(sdkDecrypt));
            dataMessage.setMiniProgramPkg(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.MINI_PROGRAM_PKG)));
            dataMessage.setMessageType(i);
            dataMessage.setEventId(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.EVENT_ID)));
            dataMessage.setStatisticsExtra(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.STATISTICS_EXTRA)));
            String sdkDecrypt2 = CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.DATA_EXTRA));
            dataMessage.setDataExtra(sdkDecrypt2);
            String msgCommand = getMsgCommand(sdkDecrypt2);
            dataMessage.setMsgCommand(TextUtils.isEmpty(msgCommand) ? 0 : Integer.parseInt(msgCommand));
            dataMessage.setBalanceTime(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.BALANCE_TIME)));
            dataMessage.setStartDate(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.START_DATE)));
            dataMessage.setEndDate(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.END_DATE)));
            dataMessage.setTimeRanges(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.TIME_RANGES)));
            dataMessage.setRule(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.RULE)));
            dataMessage.setForcedDelivery(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.FORCED_DELIVERY)));
            dataMessage.setDistinctContent(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.DISTINCT_CONTENT)));
            dataMessage.setAppId(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.APP_ID)));
            return dataMessage;
        } catch (Exception e) {
            LogUtil.d("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
