package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.ht;
import com.xiaomi.push.ij;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/PushMessageHelper.class */
public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3, List<String> list2) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        miPushCommandMessage.setAutoMarkPkgs(list2);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(ij ijVar, ht htVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(ijVar.m11990a());
        if (!TextUtils.isEmpty(ijVar.d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(ijVar.d());
        } else if (!TextUtils.isEmpty(ijVar.c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(ijVar.c());
        } else if (TextUtils.isEmpty(ijVar.f())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(ijVar.f());
        }
        miPushMessage.setCategory(ijVar.e());
        if (ijVar.a() != null) {
            miPushMessage.setContent(ijVar.a().c());
        }
        if (htVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(htVar.m11895a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(htVar.m11900b());
            }
            miPushMessage.setDescription(htVar.d());
            miPushMessage.setTitle(htVar.m11903c());
            miPushMessage.setNotifyType(htVar.a());
            miPushMessage.setNotifyId(htVar.c());
            miPushMessage.setPassThrough(htVar.b());
            miPushMessage.setExtra(htVar.m11896a());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static ht generateMessage(MiPushMessage miPushMessage) {
        ht htVar = new ht();
        htVar.a(miPushMessage.getMessageId());
        htVar.b(miPushMessage.getTopic());
        htVar.d(miPushMessage.getDescription());
        htVar.c(miPushMessage.getTitle());
        htVar.c(miPushMessage.getNotifyId());
        htVar.a(miPushMessage.getNotifyType());
        htVar.b(miPushMessage.getPassThrough());
        htVar.a(miPushMessage.getExtra());
        return htVar;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            setPushMode(isUseCallbackPushMode(context) ? 1 : 2);
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                return !queryBroadcastReceivers.isEmpty();
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }
}
