package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.turingface.sdk.mfa.ITuringIoTFeatureMap;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.em;
import com.xiaomi.push.ew;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MessageHandleService.class */
public class MessageHandleService extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentLinkedQueue<a> f41188a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f109a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MessageHandleService$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Intent f41189a;

        /* renamed from: a  reason: collision with other field name */
        private PushMessageReceiver f110a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f110a = pushMessageReceiver;
            this.f41189a = intent;
        }

        public Intent a() {
            return this.f41189a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m11415a() {
            return this.f110a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            PushMessageReceiver m11415a = aVar.m11415a();
            Intent a2 = aVar.a();
            int intExtra = a2.getIntExtra("message_type", 1);
            if (intExtra != 1) {
                if (intExtra != 3) {
                    if (intExtra == 5 && PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(a2.getStringExtra(PushMessageHelper.ERROR_TYPE)) && (stringArrayExtra = a2.getStringArrayExtra("error_message")) != null) {
                        com.xiaomi.channel.commonutils.logger.b.e("begin execute onRequirePermissions, lack of necessary permissions");
                        m11415a.onRequirePermissions(context, stringArrayExtra);
                        return;
                    }
                    return;
                }
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a2.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                com.xiaomi.channel.commonutils.logger.b.e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                m11415a.onCommandResult(context, miPushCommandMessage);
                if (TextUtils.equals(miPushCommandMessage.getCommand(), ew.COMMAND_REGISTER.f411a)) {
                    m11415a.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() == 0) {
                        i.b(context);
                        return;
                    }
                    return;
                }
                return;
            }
            PushMessageHandler.a a3 = am.a(context).a(a2);
            int intExtra2 = a2.getIntExtra("eventMessageType", -1);
            if (a3 != null) {
                if (!(a3 instanceof MiPushMessage)) {
                    if (a3 instanceof MiPushCommandMessage) {
                        MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a3;
                        com.xiaomi.channel.commonutils.logger.b.e("begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                        m11415a.onCommandResult(context, miPushCommandMessage2);
                        if (TextUtils.equals(miPushCommandMessage2.getCommand(), ew.COMMAND_REGISTER.f411a)) {
                            m11415a.onReceiveRegisterResult(context, miPushCommandMessage2);
                            PushMessageHandler.a(context, miPushCommandMessage2);
                            if (miPushCommandMessage2.getResultCode() == 0) {
                                i.b(context);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                MiPushMessage miPushMessage = (MiPushMessage) a3;
                if (!miPushMessage.isArrivedMessage()) {
                    m11415a.onReceiveMessage(context, miPushMessage);
                }
                if (miPushMessage.getPassThrough() == 1) {
                    em.a(context.getApplicationContext()).a(context.getPackageName(), a2, 2004, (String) null);
                    com.xiaomi.channel.commonutils.logger.b.e("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                    m11415a.onReceivePassThroughMessage(context, miPushMessage);
                } else if (!miPushMessage.isNotified()) {
                    com.xiaomi.channel.commonutils.logger.b.e("begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                    m11415a.onNotificationMessageArrived(context, miPushMessage);
                } else {
                    if (intExtra2 == 1000) {
                        em.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007, (String) null);
                    } else {
                        em.a(context.getApplicationContext()).a(context.getPackageName(), a2, ITuringIoTFeatureMap.RIOT_SIM_NUMBER, (String) null);
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                    m11415a.onNotificationMessageClicked(context, miPushMessage);
                }
            }
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            f41188a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(Context context) {
        if (f109a.isShutdown()) {
            return;
        }
        f109a.execute(new z(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, f41188a.poll());
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        com.xiaomi.push.ai.a(context).a(new y(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo11424a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f41188a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
