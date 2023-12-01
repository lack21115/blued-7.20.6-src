package com.efs.sdk.base.core.c;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.config.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/c/d.class */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public int f8131a;
    public c b;

    /* renamed from: c  reason: collision with root package name */
    private c f8132c;
    private List<String> d;
    private AtomicInteger e;
    private com.efs.sdk.base.core.b.f f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/c/d$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f8133a = new d((byte) 0);
    }

    private d() {
        super(com.efs.sdk.base.core.util.concurrent.a.f8189a.getLooper());
        this.f8131a = 5;
        this.d = new ArrayList();
        this.e = new AtomicInteger(0);
        this.b = new com.efs.sdk.base.core.c.a();
        this.f8132c = new com.efs.sdk.base.core.f.e();
        this.f = new h();
    }

    /* synthetic */ d(byte b) {
        this();
    }

    public static d a() {
        return a.f8133a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Object obj, int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = obj;
        obtain.arg1 = i;
        sendMessage(obtain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v113, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.efs.sdk.base.core.c.d, android.os.Handler] */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        f fVar;
        com.efs.sdk.base.core.config.b bVar;
        List<com.efs.sdk.base.core.d.b> list;
        com.efs.sdk.base.core.b.a aVar;
        ArrayList<File> arrayList;
        com.efs.sdk.base.core.f.f fVar2;
        super.handleMessage(message);
        fVar = f.a.f8138a;
        if (fVar.a()) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                Object obj = message.obj;
                if (obj != null) {
                    this.d.remove(obj.toString());
                }
                int incrementAndGet = message.arg1 != 0 ? this.e.incrementAndGet() : 0;
                if (this.d.isEmpty()) {
                    if (incrementAndGet < 5) {
                        sendEmptyMessage(0);
                        return;
                    }
                    this.e.set(0);
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                    Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            bVar = b.a.f8152a;
            String a2 = bVar.a();
            if (NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(a2) || NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(a2)) {
                Log.i("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(a2)));
                sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                return;
            }
            List emptyList = Collections.emptyList();
            try {
                aVar = a.b.f8121a;
                int i2 = this.f8131a;
                com.efs.sdk.base.core.b.f fVar3 = this.f;
                aVar.a();
                aVar.a();
                File f = com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
                if (f.exists()) {
                    List<File> d = com.efs.sdk.base.core.util.b.d(f);
                    if (aVar.b) {
                        fVar2 = f.a.f8175a;
                        int size = d.size();
                        if (fVar2.b != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                            ILogProtocol bVar2 = new com.efs.sdk.base.core.f.b("efs_core", "log_lag", fVar2.f8173a.f8171c);
                            bVar2.put("cnt", Integer.valueOf(size));
                            fVar2.b.send(bVar2);
                        }
                        aVar.b = false;
                    }
                    Collections.sort(d, aVar.d);
                    arrayList = new ArrayList(i2);
                    int size2 = d.size();
                    while (true) {
                        int i3 = size2 - 1;
                        if (i3 < 0 || arrayList.size() >= i2) {
                            break;
                        }
                        File file = d.get(i3);
                        if (file.exists() && (fVar3 == null || !fVar3.a(file))) {
                            arrayList.add(file);
                        }
                        size2 = i3;
                    }
                } else {
                    arrayList = Collections.emptyList();
                }
                ArrayList arrayList2 = new ArrayList(i2);
                for (File file2 : arrayList) {
                    com.efs.sdk.base.core.d.b a3 = aVar.a(file2);
                    if (a3 == null) {
                        Log.w("efs.cache", "file upload error, name is " + file2.getName());
                    } else {
                        arrayList2.add(a3);
                    }
                }
                list = arrayList2;
            } catch (Throwable th) {
                list = emptyList;
            }
            for (com.efs.sdk.base.core.d.b bVar3 : list) {
                if ("wa".equals(bVar3.f8158a.f8156a) || b.a().a(bVar3.f8158a.f8156a, bVar3.a())) {
                    c cVar = this.b;
                    if ("wa".equals(bVar3.f8158a.f8156a)) {
                        cVar = this.f8132c;
                    }
                    String uuid = UUID.randomUUID().toString();
                    this.d.add(uuid);
                    if (WorkThreadUtil.submit(new e(bVar3, cVar, uuid)) == null) {
                        a(uuid, -1);
                    }
                }
            }
            if (this.d.size() <= 0) {
                sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
            }
        }
    }
}
