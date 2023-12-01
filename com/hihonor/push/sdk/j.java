package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.ipc.HonorApiAvailability;
import com.hihonor.push.sdk.l;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/j.class */
public class j implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    public static final j f22302c = new j();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f22303a;
    public final Map<g, a> b = new ConcurrentHashMap(5, 0.75f, 1);

    /* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/j$a.class */
    public class a implements l.a {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<p0<?>> f22304a = new LinkedList();
        public final Queue<p0<?>> b = new LinkedList();

        /* renamed from: c  reason: collision with root package name */
        public final l f22305c = new n(this);
        public HonorPushErrorEnum d = null;
        public final g e;

        public a(g gVar) {
            this.e = gVar;
        }

        public void a() {
            com.hihonor.push.sdk.a.a(j.this.f22303a);
            n nVar = (n) this.f22305c;
            int i = nVar.f22313a.get();
            Log.i("PushConnectionClient", "enter disconnect, connection Status: ".concat(String.valueOf(i)));
            if (i != 3) {
                if (i == 5) {
                    nVar.f22313a.set(4);
                    return;
                }
                return;
            }
            p pVar = nVar.d;
            if (pVar != null) {
                pVar.b();
            }
            nVar.f22313a.set(1);
        }

        public final void a(HonorPushErrorEnum honorPushErrorEnum) {
            synchronized (this) {
                Log.i("HonorApiManager", "onConnectionFailed");
                com.hihonor.push.sdk.a.a(j.this.f22303a);
                for (p0<?> p0Var : this.f22304a) {
                    p0Var.b(honorPushErrorEnum.toApiException(), null);
                }
                this.f22304a.clear();
                this.d = honorPushErrorEnum;
                a();
                j.this.b.remove(this.e);
            }
        }

        public final void a(p0<?> p0Var) {
            Object obj;
            Type type;
            synchronized (this) {
                this.b.add(p0Var);
                l lVar = this.f22305c;
                b bVar = new b(p0Var);
                p0Var.getClass();
                try {
                    Type genericSuperclass = p0Var.getClass().getGenericSuperclass();
                    Class cls = (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) == null) ? null : (Class) type;
                    obj = null;
                    if (cls != null) {
                        obj = null;
                        if (!cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    }
                } catch (Exception e) {
                    com.hihonor.push.sdk.b.a("In newResponseInstance, instancing exception." + e.getMessage());
                    obj = null;
                }
                r rVar = new r(obj, bVar);
                Log.i("IPCTransport", "start transport parse. " + p0Var.b);
                IPushInvoke iPushInvoke = ((n) lVar).b;
                String str = p0Var.b;
                RequestHeader requestHeader = p0Var.e;
                IMessageEntity iMessageEntity = p0Var.f22319c;
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                MessageCodec.formMessageEntity(requestHeader, bundle);
                MessageCodec.formMessageEntity(iMessageEntity, bundle2);
                DataBuffer dataBuffer = new DataBuffer(str, bundle, bundle2);
                if (iPushInvoke != null) {
                    try {
                        iPushInvoke.call(dataBuffer, rVar);
                    } catch (Exception e2) {
                        new StringBuilder("transport remote error. ").append(e2);
                    }
                }
                Log.i("IPCTransport", "end transport parse.");
            }
        }

        public final void b() {
            synchronized (this) {
                Log.i("HonorApiManager", "onConnected");
                com.hihonor.push.sdk.a.a(j.this.f22303a);
                this.d = null;
                for (p0<?> p0Var : this.f22304a) {
                    a(p0Var);
                }
                this.f22304a.clear();
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/j$b.class */
    public static class b implements s {

        /* renamed from: a  reason: collision with root package name */
        public p0<?> f22306a;

        public b(p0<?> p0Var) {
            this.f22306a = p0Var;
        }
    }

    public j() {
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.f22303a = new Handler(handlerThread.getLooper(), this);
    }

    public <TResult> j0<TResult> a(p0<TResult> p0Var) {
        x<TResult> xVar = new x<>();
        p0Var.f = xVar;
        Log.i("HonorApiManager", "sendRequest start");
        Handler handler = this.f22303a;
        handler.sendMessage(handler.obtainMessage(1, p0Var));
        return xVar.f22324a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        int i = message.what;
        boolean z = false;
        if (i != 1) {
            if (i == 2) {
                p0 p0Var = (p0) message.obj;
                g gVar = p0Var.d;
                if (gVar == null || !this.b.containsKey(gVar) || (aVar = this.b.get(gVar)) == null) {
                    return true;
                }
                synchronized (aVar) {
                    new StringBuilder("resolveResult apiCall ").append(p0Var.b);
                    aVar.b.remove(p0Var);
                    if (aVar.f22304a.peek() == null || aVar.b.peek() == null) {
                        aVar.a();
                        j.this.b.remove(aVar.e);
                    }
                }
                return true;
            }
            return false;
        }
        p0<?> p0Var2 = (p0) message.obj;
        g gVar2 = p0Var2.d;
        a aVar2 = this.b.get(gVar2);
        a aVar3 = aVar2;
        if (aVar2 == null) {
            Log.i("HonorApiManager", "connect and send request, create new connection manager.");
            aVar3 = new a(gVar2);
            this.b.put(gVar2, aVar3);
        }
        synchronized (aVar3) {
            try {
                com.hihonor.push.sdk.a.a(j.this.f22303a);
                new StringBuilder("sendRequest ").append(p0Var2.b);
                if (((n) aVar3.f22305c).a()) {
                    aVar3.a(p0Var2);
                } else {
                    aVar3.f22304a.add(p0Var2);
                    HonorPushErrorEnum honorPushErrorEnum = aVar3.d;
                    if (honorPushErrorEnum == null || honorPushErrorEnum.getErrorCode() == 0) {
                        synchronized (aVar3) {
                            com.hihonor.push.sdk.a.a(j.this.f22303a);
                            if (((n) aVar3.f22305c).a()) {
                                Log.i("HonorApiManager", "client is connected");
                            } else {
                                if (((n) aVar3.f22305c).f22313a.get() == 5) {
                                    z = true;
                                }
                                if (z) {
                                    Log.i("HonorApiManager", "client is isConnecting");
                                } else {
                                    n nVar = (n) aVar3.f22305c;
                                    nVar.getClass();
                                    Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                    int i2 = nVar.f22313a.get();
                                    Log.i("PushConnectionClient", "enter connect, connection Status: ".concat(String.valueOf(i2)));
                                    if (i2 != 3 && i2 != 5 && i2 != 4) {
                                        d dVar = d.e;
                                        int isHonorMobileServicesAvailable = HonorApiAvailability.isHonorMobileServicesAvailable(dVar.a());
                                        if (isHonorMobileServicesAvailable == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                            nVar.f22313a.set(5);
                                            RemoteServiceBean a2 = HonorApiAvailability.a(dVar.a());
                                            Log.i("PushConnectionClient", "enter bindCoreService.");
                                            p pVar = new p(a2);
                                            nVar.d = pVar;
                                            pVar.b = new m(nVar);
                                            if (a2.checkServiceInfo()) {
                                                Intent intent = new Intent();
                                                String packageName = pVar.f22316a.getPackageName();
                                                String packageAction = pVar.f22316a.getPackageAction();
                                                String packageServiceName = pVar.f22316a.getPackageServiceName();
                                                if (TextUtils.isEmpty(packageServiceName)) {
                                                    intent.setAction(packageAction);
                                                    intent.setPackage(packageName);
                                                } else {
                                                    intent.setComponent(new ComponentName(packageName, packageServiceName));
                                                }
                                                synchronized (p.e) {
                                                    if (dVar.a().bindService(intent, pVar, 1)) {
                                                        Handler handler = pVar.f22317c;
                                                        if (handler != null) {
                                                            handler.removeMessages(1001);
                                                        } else {
                                                            pVar.f22317c = new Handler(Looper.getMainLooper(), new o(pVar));
                                                        }
                                                        pVar.f22317c.sendEmptyMessageDelayed(1001, 10000L);
                                                    } else {
                                                        pVar.d = true;
                                                        pVar.a(HonorPushErrorCode.ERROR_BIND_SERVICE);
                                                    }
                                                }
                                            } else {
                                                new StringBuilder("bind core is null : ").append(pVar.f22316a);
                                                pVar.a(HonorPushErrorCode.ERROR_SERVICE_ARGUMENTS_INVALID);
                                            }
                                        } else {
                                            nVar.a(isHonorMobileServicesAvailable);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        aVar3.a(aVar3.d);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }
}
