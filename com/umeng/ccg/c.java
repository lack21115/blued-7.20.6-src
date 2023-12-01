package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/ccg/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f40816a = 101;
    public static final int b = 102;

    /* renamed from: c  reason: collision with root package name */
    public static final int f40817c = 103;
    public static final int d = 104;
    public static final int e = 105;
    public static final int f = 106;
    public static final int g = 107;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 201;
    public static final int l = 202;
    public static final int m = 203;
    public static final int n = 301;
    public static final int o = 302;
    public static final int p = 303;
    private static HandlerThread q;
    private static Handler r;
    private static HashMap<Integer, a> s;
    private static final int t = 256;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/ccg/c$a.class */
    public interface a {
        void a(Object obj, int i);
    }

    private c() {
    }

    private static void a() {
        synchronized (c.class) {
            try {
                if (q == null) {
                    HandlerThread handlerThread = new HandlerThread("ccg_dispatch");
                    q = handlerThread;
                    handlerThread.start();
                    if (r == null) {
                        r = new Handler(q.getLooper()) { // from class: com.umeng.ccg.c.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                c.b(message);
                            }
                        };
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(Context context, int i2, int i3, a aVar, Object obj, long j2) {
        if (context == null || aVar == null) {
            return;
        }
        if (s == null) {
            s = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i3 / 100);
        if (!s.containsKey(valueOf)) {
            s.put(valueOf, aVar);
        }
        if (q == null || r == null) {
            a();
        }
        try {
            if (r != null) {
                Message obtainMessage = r.obtainMessage();
                obtainMessage.what = i2;
                obtainMessage.arg1 = i3;
                obtainMessage.obj = obj;
                r.sendMessageDelayed(obtainMessage, j2);
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, int i2, a aVar, Object obj) {
        a(context, 256, i2, aVar, obj, 0L);
    }

    public static void a(Context context, int i2, a aVar, Object obj, long j2) {
        a(context, 256, i2, aVar, obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i2 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i2 / 100);
        HashMap<Integer, a> hashMap = s;
        if (hashMap == null) {
            return;
        }
        a aVar = null;
        if (hashMap.containsKey(valueOf)) {
            aVar = s.get(valueOf);
        }
        if (aVar != null) {
            aVar.a(obj, i2);
        }
    }
}
