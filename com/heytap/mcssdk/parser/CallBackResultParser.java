package com.heytap.mcssdk.parser;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.constant.IntentConstant;
import com.heytap.mcssdk.mode.CallBackResult;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.msp.push.mode.BaseMode;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/parser/CallBackResultParser.class */
public class CallBackResultParser extends MessageParser {
    @Override // com.heytap.mcssdk.parser.Parser
    public BaseMode parse(Context context, int i, Intent intent) {
        if (4105 == i) {
            return parseMessageByIntent(intent, i);
        }
        return null;
    }

    @Override // com.heytap.mcssdk.parser.MessageParser
    protected BaseMode parseMessageByIntent(Intent intent, int i) {
        try {
            CallBackResult callBackResult = new CallBackResult();
            callBackResult.setCommand(Integer.parseInt(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.COMMAND))));
            callBackResult.setResponseCode(Integer.parseInt(CryptoUtil.sdkDecrypt(intent.getStringExtra("code"))));
            callBackResult.setContent(CryptoUtil.sdkDecrypt(intent.getStringExtra("content")));
            callBackResult.setAppKey(CryptoUtil.sdkDecrypt(intent.getStringExtra("appKey")));
            callBackResult.setAppSecret(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.APP_SECRET)));
            callBackResult.setAppPackage(CryptoUtil.sdkDecrypt(intent.getStringExtra(IntentConstant.APP_PACKAGE)));
            LogUtil.d("OnHandleIntent-message:" + callBackResult.toString());
            return callBackResult;
        } catch (Exception e) {
            LogUtil.d("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
