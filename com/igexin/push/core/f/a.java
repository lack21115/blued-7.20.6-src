package com.igexin.push.core.f;

import android.app.NotificationManager;
import android.content.Intent;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.igexin.push.core.e;
import com.igexin.push.core.e.c;
import com.igexin.push.core.n;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.main.FeedbackImpl;
import java.util.HashSet;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/f/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9939a = "NotificationExecutor";
    private static a b;

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static void a(Intent intent) {
        String str;
        String stringExtra = intent.getStringExtra("taskid");
        String stringExtra2 = intent.getStringExtra("groupId");
        HashSet<String> hashSet = e.aj.get(stringExtra2);
        Integer num = e.ak.get(stringExtra2);
        if (hashSet != null && !hashSet.isEmpty()) {
            hashSet.remove(stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2) && num != null && hashSet != null && hashSet.isEmpty()) {
            ((NotificationManager) e.l.getSystemService("notification")).cancel(num.intValue());
            e.aj.remove(stringExtra2);
            e.ak.remove(stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("checkpackage");
        String stringExtra4 = intent.getStringExtra("accesstoken");
        if (stringExtra3 == null || stringExtra4 == null || !stringExtra3.equals(e.l.getPackageName()) || !stringExtra4.equals(e.aC)) {
            return;
        }
        intent.putExtra("accesstoken", e.an);
        n.a().a(intent);
        c.a();
        c.a(stringExtra, b.ag, intent.getIntExtra("redisplayFreq", 0));
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(intent.getStringExtra("appid"));
        pushTaskBean.setMessageId(intent.getStringExtra("messageid"));
        pushTaskBean.setTaskId(stringExtra);
        pushTaskBean.setId(intent.getStringExtra("id"));
        intent.getStringExtra("bigStyle");
        intent.getStringExtra("notifyStyle");
        try {
            int parseInt = Integer.parseInt(intent.getStringExtra("feedbackid")) + 30010;
            pushTaskBean.setCurrentActionid(parseInt);
            if (intent.getBooleanExtra("isFloat", false)) {
                str = "notifyFloat:" + intent.getStringExtra("bigStyle");
            } else {
                str = "notifyStyle:" + intent.getStringExtra("notifyStyle");
            }
            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, String.valueOf(parseInt), str);
        } catch (Exception e) {
        }
    }
}
