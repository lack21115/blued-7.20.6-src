package com.igexin.push.core;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.push.core.d;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.main.FeedbackImpl;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/c.class */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static String f23466a = c.class.getName();
    private boolean b;

    public c(Looper looper) {
        super(looper);
        this.b = false;
    }

    private static void a() {
        if (e.u || e.O <= 10000) {
            return;
        }
        int random = (int) ((Math.random() * 100.0d) + 150.0d);
        long j = e.O;
        com.igexin.c.a.c.a.a(f23466a + "|userPresent, rdelay = " + e.O + ", reset = " + random, new Object[0]);
        e.O = (long) random;
        com.igexin.push.e.b.e.g().a(e.O);
    }

    private static void a(Intent intent) {
        String stringExtra = intent.getStringExtra("action");
        if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE)) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(intent);
        } else if (stringExtra.equals(PushConsts.ACTION_SERVICE_ONRESUME)) {
            com.igexin.c.a.c.a.a(f23466a + "|handle onresume ~~~", new Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.b("on fg");
        } else if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.b(intent);
            AssistPushManager.getInstance().turnOnPush(e.l);
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
            String stringExtra2 = intent.getStringExtra("sc");
            if (TextUtils.isEmpty(e.i) || e.i.equals(stringExtra2)) {
                Bundle bundleExtra = intent.getBundleExtra(TTLiveConstants.BUNDLE_KEY);
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.a(bundleExtra);
                return;
            }
            com.igexin.c.a.c.a.a("safeCode not match!!" + e.i + "," + stringExtra2, new Object[0]);
            com.igexin.c.a.c.a.d a2 = com.igexin.c.a.c.a.d.a();
            a2.a("safeCode not match!!" + e.i + "," + stringExtra2);
        } else if (stringExtra.equals("android.intent.action.USER_PRESENT")) {
            if (e.u || e.O <= 10000) {
                return;
            }
            int random = (int) ((Math.random() * 100.0d) + 150.0d);
            long j = e.O;
            com.igexin.c.a.c.a.a(f23466a + "|userPresent, rdelay = " + e.O + ", reset = " + random, new Object[0]);
            e.O = (long) random;
            com.igexin.push.e.b.e.g().a(e.O);
        } else if (stringExtra.equals("com.igexin.action.notification.click")) {
            Intent intent2 = (Intent) intent.getParcelableExtra("broadcast_intent");
            if (intent2 != null) {
                com.igexin.push.core.f.a.a();
                com.igexin.push.core.f.a.a(intent2);
            }
        } else if (stringExtra.equals(b.I)) {
            HashMap hashMap = (HashMap) intent.getSerializableExtra("push_action");
            com.igexin.c.a.c.a.a(f23466a + "| handle other push action broadcast", new Object[0]);
            n.a().f23578a.putAll(hashMap);
            n.a().e();
        } else if (!stringExtra.equals("com.igexin.action.notification.delete")) {
            if (stringExtra.equals(PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253)) {
                String stringExtra3 = intent.getStringExtra("id");
                com.igexin.push.core.c.a.a();
                com.igexin.push.core.c.a.a(stringExtra3);
            }
        } else if (intent.getBooleanExtra("isSummary", false)) {
            String stringExtra4 = intent.getStringExtra("groupId");
            e.aj.remove(stringExtra4);
            e.ak.remove(stringExtra4);
        } else {
            PushTaskBean pushTaskBean = new PushTaskBean();
            pushTaskBean.setAppid(intent.getStringExtra("appid"));
            pushTaskBean.setMessageId(intent.getStringExtra("messageid"));
            String stringExtra5 = intent.getStringExtra("taskid");
            pushTaskBean.setTaskId(stringExtra5);
            pushTaskBean.setId(intent.getStringExtra("id"));
            pushTaskBean.setAppKey(intent.getStringExtra("appkey"));
            com.igexin.push.core.e.c.a();
            com.igexin.push.core.e.c.a(stringExtra5, b.ah, intent.getIntExtra("redisplayFreq", 0));
            int parseInt = Integer.parseInt(intent.getStringExtra("feedbackid")) + 30040;
            pushTaskBean.setCurrentActionid(parseInt);
            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, String.valueOf(parseInt), "notifyStyle:" + intent.getStringExtra("notifyStyle"));
            com.igexin.push.core.a.b.d();
            String a3 = com.igexin.push.core.a.b.a(intent.getStringExtra("taskid"), intent.getStringExtra("messageid"));
            com.igexin.c.a.c.a.a(f23466a + "|notification delete = " + a3, new Object[0]);
            try {
                e.ah.remove(a3);
                com.igexin.c.a.c.a.a(f23466a + "|del notification, pushMessageMap remove = " + a3, new Object[0]);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("EndAction|" + e.toString(), new Object[0]);
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        int i = message.what;
        if (message.what == b.P) {
            n.a().d();
        } else if (message.obj == null) {
        } else {
            try {
                if (message.what != b.M) {
                    if (message.what == b.N) {
                        com.igexin.push.core.a.b.d();
                        Intent intent = (Intent) message.obj;
                        if (intent == null || intent.getAction() == null) {
                            return;
                        }
                        String action = intent.getAction();
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                            com.igexin.push.core.a.b.e();
                            return;
                        } else if (b.H.equals(action)) {
                            n.a().a(intent);
                            return;
                        } else if ("android.intent.action.TIME_SET".equals(action)) {
                            if (com.igexin.push.config.d.f23376c != 0) {
                                com.igexin.push.e.f.c().d();
                                return;
                            }
                            return;
                        } else if (!Intent.ACTION_SCREEN_ON.equals(action)) {
                            if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                                e.y = 0;
                                return;
                            }
                            return;
                        } else {
                            e.y = 1;
                            n.a();
                            if (n.b()) {
                                n.a().d();
                            }
                            if (Build.VERSION.SDK_INT >= 26) {
                                com.igexin.push.core.a.b.b("screen on");
                                return;
                            }
                            return;
                        }
                    } else if (message.what == b.R) {
                        Bundle bundle = (Bundle) message.obj;
                        String string = bundle.getString("taskid");
                        String string2 = bundle.getString("messageid");
                        n a2 = n.a();
                        com.igexin.c.a.c.a.a("PushMessageExecutor do processActionExecute", new Object[0]);
                        if (string2 == null || string == null || a2.a(string, string2) != PushMessageInterface.ActionPrepareState.success) {
                            return;
                        }
                        a2.a(string, string2, "1");
                        return;
                    } else if (message.what == b.O) {
                        Bundle bundle2 = (Bundle) message.obj;
                        String string3 = bundle2.getString("taskid");
                        String string4 = bundle2.getString("messageid");
                        String string5 = bundle2.getString("actionid");
                        com.igexin.c.a.c.a.a(f23466a + "|hand execute_action taskid = " + string3 + ", actionid = " + string5, new Object[0]);
                        n.a().b(string3, string4, string5);
                        return;
                    } else if (message.what == b.S) {
                        if (this.b) {
                            return;
                        }
                        d.a.f23474a.a();
                        this.b = true;
                        return;
                    } else if (message.what != b.Q || "false".equals(e.I)) {
                        return;
                    } else {
                        com.igexin.push.c.c.n nVar = new com.igexin.push.c.c.n();
                        nVar.f23354c = 128;
                        nVar.f = message.obj;
                        nVar.g = message.getData().getByteArray("payload");
                        new com.igexin.push.core.a.b.d().a(nVar);
                        return;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                if (intent2.hasExtra("action")) {
                    String stringExtra = intent2.getStringExtra("action");
                    if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE)) {
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.a(intent2);
                    } else if (stringExtra.equals(PushConsts.ACTION_SERVICE_ONRESUME)) {
                        com.igexin.c.a.c.a.a(f23466a + "|handle onresume ~~~", new Object[0]);
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.b("on fg");
                    } else if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.b(intent2);
                        AssistPushManager.getInstance().turnOnPush(e.l);
                    } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
                        String stringExtra2 = intent2.getStringExtra("sc");
                        if (TextUtils.isEmpty(e.i) || e.i.equals(stringExtra2)) {
                            Bundle bundleExtra = intent2.getBundleExtra(TTLiveConstants.BUNDLE_KEY);
                            com.igexin.push.core.a.b.d();
                            com.igexin.push.core.a.b.a(bundleExtra);
                            return;
                        }
                        com.igexin.c.a.c.a.a("safeCode not match!!" + e.i + "," + stringExtra2, new Object[0]);
                        com.igexin.c.a.c.a.d a3 = com.igexin.c.a.c.a.d.a();
                        a3.a("safeCode not match!!" + e.i + "," + stringExtra2);
                    } else if (stringExtra.equals("android.intent.action.USER_PRESENT")) {
                        if (e.u || e.O <= 10000) {
                            return;
                        }
                        int random = (int) ((Math.random() * 100.0d) + 150.0d);
                        long j = e.O;
                        com.igexin.c.a.c.a.a(f23466a + "|userPresent, rdelay = " + e.O + ", reset = " + random, new Object[0]);
                        e.O = (long) random;
                        com.igexin.push.e.b.e.g().a(e.O);
                    } else if (stringExtra.equals("com.igexin.action.notification.click")) {
                        Intent intent3 = (Intent) intent2.getParcelableExtra("broadcast_intent");
                        if (intent3 != null) {
                            com.igexin.push.core.f.a.a();
                            com.igexin.push.core.f.a.a(intent3);
                        }
                    } else if (stringExtra.equals(b.I)) {
                        HashMap hashMap = (HashMap) intent2.getSerializableExtra("push_action");
                        com.igexin.c.a.c.a.a(f23466a + "| handle other push action broadcast", new Object[0]);
                        n.a().f23578a.putAll(hashMap);
                        n.a().e();
                    } else if (!stringExtra.equals("com.igexin.action.notification.delete")) {
                        if (stringExtra.equals(PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253)) {
                            String stringExtra3 = intent2.getStringExtra("id");
                            com.igexin.push.core.c.a.a();
                            com.igexin.push.core.c.a.a(stringExtra3);
                        }
                    } else if (intent2.getBooleanExtra("isSummary", false)) {
                        String stringExtra4 = intent2.getStringExtra("groupId");
                        e.aj.remove(stringExtra4);
                        e.ak.remove(stringExtra4);
                    } else {
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setAppid(intent2.getStringExtra("appid"));
                        pushTaskBean.setMessageId(intent2.getStringExtra("messageid"));
                        String stringExtra5 = intent2.getStringExtra("taskid");
                        pushTaskBean.setTaskId(stringExtra5);
                        pushTaskBean.setId(intent2.getStringExtra("id"));
                        pushTaskBean.setAppKey(intent2.getStringExtra("appkey"));
                        com.igexin.push.core.e.c.a();
                        com.igexin.push.core.e.c.a(stringExtra5, b.ah, intent2.getIntExtra("redisplayFreq", 0));
                        int parseInt = Integer.parseInt(intent2.getStringExtra("feedbackid")) + 30040;
                        pushTaskBean.setCurrentActionid(parseInt);
                        FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, String.valueOf(parseInt), "notifyStyle:" + intent2.getStringExtra("notifyStyle"));
                        com.igexin.push.core.a.b.d();
                        String a4 = com.igexin.push.core.a.b.a(intent2.getStringExtra("taskid"), intent2.getStringExtra("messageid"));
                        com.igexin.c.a.c.a.a(f23466a + "|notification delete = " + a4, new Object[0]);
                        try {
                            e.ah.remove(a4);
                            com.igexin.c.a.c.a.a(f23466a + "|del notification, pushMessageMap remove = " + a4, new Object[0]);
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            com.igexin.c.a.c.a.a("EndAction|" + e.toString(), new Object[0]);
                        }
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }
}
