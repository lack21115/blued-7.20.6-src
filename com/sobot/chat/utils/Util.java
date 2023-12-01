package com.sobot.chat.utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.ZhiChiPushMessage;
import com.sobot.chat.core.a.a.j;
import java.io.Closeable;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/Util.class */
public class Util {
    public static boolean isDebug = false;

    public static int bytesToInt(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static void closeQuietly(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        int length = closeableArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Closeable closeable = closeableArr[i2];
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                }
            }
            i = i2 + 1;
        }
    }

    public static String createMsgId(String str) {
        return str + System.currentTimeMillis();
    }

    public static String createReceipt(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RemoteMessageConst.MSGID, str);
            jSONObject.put("type", 301);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getMsgId(String str) {
        try {
            return new JSONObject(str).optString(RemoteMessageConst.MSGID);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean hasNetWork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean z = false;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            z = false;
            if (activeNetworkInfo != null) {
                z = false;
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static void logI(String str, String str2) {
        if (isDebug) {
            Log.i(str, str2);
        }
    }

    public static void notifyConnStatus(Context context, int i) {
        Intent intent = new Intent();
        intent.setAction(ZhiChiConstants.SOBOT_CHANNEL_STATUS_CHANGE);
        intent.putExtra("connStatus", i);
        CommonUtils.sendLocalBroadcast(context, intent);
    }

    public static void notifyMsg(Context context, j jVar) {
        notifyMsg(context, jVar.b());
    }

    public static void notifyMsg(Context context, String str) {
        LogUtils.i("======收到客服消息=========" + str);
        ZhiChiPushMessage jsonToZhiChiPushMessage = GsonUtil.jsonToZhiChiPushMessage(str);
        if (jsonToZhiChiPushMessage == null) {
            return;
        }
        Intent intent = new Intent();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
        intent.setAction(ZhiChiConstants.receiveMessageBrocast);
        intent.putExtra(RemoteMessageConst.MessageBody.MSG_CONTENT, str);
        intent.putExtra(ZhiChiConstants.ZHICHI_PUSH_MESSAGE, jsonToZhiChiPushMessage);
        localBroadcastManager.sendBroadcast(intent);
    }
}
