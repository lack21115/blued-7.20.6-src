package com.igexin.sdk.main;

import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.b.a;
import com.igexin.push.core.b;
import com.igexin.push.core.b.l;
import com.igexin.push.core.d;
import com.igexin.push.core.e;
import com.igexin.push.extension.mod.PushTaskBean;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/main/FeedbackImpl.class */
public class FeedbackImpl {
    private static final String TAG = "FeedbackImpl";
    public static volatile FeedbackImpl instance;

    private FeedbackImpl() {
    }

    public static FeedbackImpl getInstance() {
        if (instance == null) {
            synchronized (FeedbackImpl.class) {
                try {
                    if (instance == null) {
                        instance = new FeedbackImpl();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public void asyncFeedback(Runnable runnable) {
        a.a().a(TAG).execute(runnable);
    }

    public void clearFeedbackMessage() {
        int i = e.am - 100;
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        e.am = i2;
        int i3 = e.am;
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<String, Long>> it = e.al.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            next.getKey();
            if (currentTimeMillis - next.getValue().longValue() > 3600000) {
                it.remove();
            }
        }
    }

    public void feedbackMessageAction(PushTaskBean pushTaskBean, String str) {
        feedbackMessageAction(pushTaskBean, str, b.x);
    }

    public void feedbackMessageAction(PushTaskBean pushTaskBean, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "pushmessage_feedback");
            jSONObject.put("appid", pushTaskBean.getAppid());
            jSONObject.put("id", String.valueOf(currentTimeMillis));
            jSONObject.put("appkey", pushTaskBean.getAppKey());
            jSONObject.put("messageid", pushTaskBean.getMessageId());
            jSONObject.put("taskid", pushTaskBean.getTaskId());
            jSONObject.put("actionid", str);
            jSONObject.put("result", str2);
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        String jSONObject2 = jSONObject.toString();
        com.igexin.push.c.c.b bVar = new com.igexin.push.c.c.b();
        bVar.f9726c = 128;
        bVar.b = (int) currentTimeMillis;
        bVar.e = b.K;
        bVar.f = jSONObject2;
        bVar.h = e.A;
        com.igexin.push.core.e.e.a().b(new l(currentTimeMillis, jSONObject2, (byte) 3, e.u ? currentTimeMillis : 0L));
        if (d.a.a().h != null) {
            com.igexin.push.d.a aVar = d.a.a().h;
            aVar.a("C-" + e.A, bVar, false);
        }
        com.igexin.c.a.c.a.a("feedback|" + pushTaskBean.getTaskId() + "|" + pushTaskBean.getMessageId() + "|" + str, new Object[0]);
    }

    public void feedbackMultiBrandMessageAction(PushTaskBean pushTaskBean, String str) {
        feedbackMessageAction(pushTaskBean, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE.concat(String.valueOf(str)), b.x);
    }

    public void feedbackMultiBrandMessageAction(JSONObject jSONObject, String str) {
        try {
            PushTaskBean pushTaskBean = new PushTaskBean();
            pushTaskBean.parse(jSONObject);
            feedbackMultiBrandMessageAction(pushTaskBean, str);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}
