package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.eo;
import com.xiaomi.push.ic;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/as.class */
public abstract class as {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract eo a(Context context, int i, String str, Map<String, String> map);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(ic icVar, Map<String, String> map, int i, Notification notification);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m12123a(Context context, int i, String str, Map<String, String> map);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(Map<String, String> map, int i, Notification notification);
}
