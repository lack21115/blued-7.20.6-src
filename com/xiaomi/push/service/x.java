package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.push.gf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/x.class */
public class x {

    /* renamed from: a  reason: collision with other field name */
    private static final Map<String, byte[]> f1039a = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<Pair<String, byte[]>> f28017a = new ArrayList<>();

    public static void a(Context context, int i, String str) {
        synchronized (f1039a) {
            for (String str2 : f1039a.keySet()) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("notify registration error. ".concat(String.valueOf(str2)));
                a(context, str2, f1039a.get(str2), i, str);
            }
            f1039a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, ah.a(str));
    }

    public static void a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f28017a) {
                arrayList = f28017a;
                f28017a = new ArrayList<>();
            }
            boolean a2 = com.xiaomi.push.s.a();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                ah.a(xMPushService, next.first, next.second);
                if (!a2) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                    }
                }
            }
        } catch (gf e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. ".concat(String.valueOf(e2)));
            xMPushService.a(10, e2);
        }
    }

    public static void a(XMPushService xMPushService, boolean z) {
        try {
            synchronized (f1039a) {
                for (String str : f1039a.keySet()) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("processing pending registration request. ".concat(String.valueOf(str)));
                    ah.a(xMPushService, str, f1039a.get(str));
                    if (z && !com.xiaomi.push.s.a()) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception e) {
                        }
                    }
                }
                f1039a.clear();
            }
        } catch (gf e2) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. ".concat(String.valueOf(e2)));
            xMPushService.a(10, e2);
        }
    }

    public static void a(String str, byte[] bArr) {
        synchronized (f1039a) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("pending registration request. ".concat(String.valueOf(str)));
            f1039a.put(str, bArr);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (f28017a) {
            f28017a.add(new Pair<>(str, bArr));
            if (f28017a.size() > 50) {
                f28017a.remove(0);
            }
        }
    }
}
