package com.blued.android.module.im.biz;

import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.google.protobuf.Any;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/biz/IMConnectorDebuger.class */
public class IMConnectorDebuger {

    /* renamed from: a  reason: collision with root package name */
    private static String f11338a;
    private static long b;

    /* renamed from: c  reason: collision with root package name */
    private static OnConnectStateListener f11339c = new OnConnectStateListener() { // from class: com.blued.android.module.im.biz.IMConnectorDebuger.1
        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onConnected() {
            IMConnectorDebuger.a("connector connected");
        }

        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onConnecting() {
            IMConnectorDebuger.a("connector connecting");
        }

        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onDisconnected() {
            IMConnectorDebuger.a("connector disconnected");
        }

        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onReceive(Any any) {
        }
    };

    public static OnConnectStateListener a() {
        return f11339c;
    }

    public static void a(String str) {
        f11338a = str;
    }

    public static void b() {
        b = System.currentTimeMillis();
    }

    public static String c() {
        return f11338a;
    }

    public static String d() {
        if (b == 0) {
            return "No Message";
        }
        long currentTimeMillis = (System.currentTimeMillis() - b) / 1000;
        return currentTimeMillis + " seconds ago";
    }
}
