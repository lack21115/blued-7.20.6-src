package com.xiaomi.push.service;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/am.class */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private static Object f41606a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, Queue<String>> f974a = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (f41606a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f974a.get(str);
            LinkedList linkedList = queue;
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(",");
                linkedList = new LinkedList();
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    linkedList.add(split[i2]);
                    i = i2 + 1;
                }
                f974a.put(str, linkedList);
            }
            if (linkedList.contains(str2)) {
                return true;
            }
            linkedList.add(str2);
            if (linkedList.size() > 25) {
                linkedList.poll();
            }
            String a2 = com.xiaomi.push.bn.a(linkedList, ",");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, a2);
            edit.commit();
            return false;
        }
    }
}
