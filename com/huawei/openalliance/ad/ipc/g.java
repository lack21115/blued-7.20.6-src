package com.huawei.openalliance.ad.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.anythink.expressad.video.module.a.a.m;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.ipc.c;
import com.huawei.openalliance.ad.ipc.e;
import com.huawei.openalliance.ad.ipc.f;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.v;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/g.class */
public class g extends c<f> {
    private static final String B = "com.huawei.android.hms.ppskit.PpsCoreService";
    private static final String C = "Decouple.PPSApiServiceManager";
    private static final byte[] D = new byte[0];
    private static g F;
    private static final String S = "AidlConnectMonitorMethod";
    private static final String Z = "com.huawei.android.hms.ppskit.PPS_API_SERVICE";
    private long L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/g$a.class */
    public static class a<T> extends c.a<f> {
        private String Code;
        private RemoteCallResultCallback<T> I;
        private String V;
        private Class<T> Z;

        a(String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
            this.Code = str;
            this.V = str2;
            this.I = remoteCallResultCallback;
            this.Z = cls;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Code(final RemoteCallResultCallback remoteCallResultCallback, final String str, final CallResult callResult) {
            if (callResult != null) {
                ge.V(g.C, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
            }
            if (remoteCallResultCallback != null) {
                com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.g.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        remoteCallResultCallback.onRemoteCallResult(str, callResult);
                    }
                });
            }
        }

        private void V(String str) {
            ge.I(g.C, str);
            CallResult callResult = new CallResult();
            callResult.setCode(-1);
            callResult.setMsg(str);
            Code(this.I, this.Code, callResult);
        }

        @Override // com.huawei.openalliance.ad.ipc.c.a
        public void Code(f fVar) {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sdk_version", "13.4.61.304");
                jSONObject.put("content", this.V);
                fVar.Code(this.Code, jSONObject.toString(), new e.a() { // from class: com.huawei.openalliance.ad.ipc.g.a.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.huawei.openalliance.ad.ipc.e
                    public void Code(String str2, int i, String str3) {
                        String message;
                        if (ge.Code()) {
                            ge.Code(g.C, "call: %s code: %s result: %s", str2, Integer.valueOf(i), bc.Code(str3));
                        }
                        CallResult callResult = new CallResult();
                        callResult.setCode(i);
                        try {
                            if (i == 200) {
                                callResult.setData(i.Code(str3, a.this.Z));
                            } else {
                                callResult.setMsg(str3);
                            }
                        } catch (IllegalArgumentException e) {
                            ge.I(g.C, "onCallResult IllegalArgumentException");
                            callResult.setCode(-1);
                            message = e.getMessage();
                            callResult.setMsg(message);
                            a aVar = a.this;
                            aVar.Code(aVar.I, str2, callResult);
                        } catch (Throwable th) {
                            ge.I(g.C, "onCallResult " + th.getClass().getSimpleName());
                            callResult.setCode(-1);
                            message = th.getMessage();
                            callResult.setMsg(message);
                            a aVar2 = a.this;
                            aVar2.Code(aVar2.I, str2, callResult);
                        }
                        a aVar22 = a.this;
                        aVar22.Code(aVar22.I, str2, callResult);
                    }
                });
            } catch (RemoteException e) {
                str = "remote call RemoteException";
                V(str);
            } catch (Throwable th) {
                str = "remote call " + th.getClass().getSimpleName();
                V(str);
            }
        }

        @Override // com.huawei.openalliance.ad.ipc.c.a
        public void Code(String str) {
            V("onServiceCallFailed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context) {
        super(context);
    }

    public static g V(Context context) {
        g gVar;
        synchronized (D) {
            if (F == null) {
                F = new g(context);
            }
            gVar = F;
        }
        return gVar;
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    protected void B() {
        this.L = System.currentTimeMillis();
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    protected void Code(ComponentName componentName) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.L;
        v.V(componentName.getPackageName());
        Code(S, String.valueOf(currentTimeMillis - j), null, null);
    }

    public <T> void Code(String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        String V = V();
        ge.V(V, "call remote method: " + str);
        if (ge.Code()) {
            ge.Code(V(), "paramContent: %s", bc.Code(str2));
        }
        Code(new a(str, str2, remoteCallResultCallback, cls), m.ag);
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    protected String F() {
        return "com.huawei.android.hms.ppskit.PpsCoreService";
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    protected String I() {
        return Z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.ipc.c
    /* renamed from: V */
    public f Code(IBinder iBinder) {
        return f.a.Code(iBinder);
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    public String V() {
        return C;
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    protected String Z() {
        return v.Z(this.V);
    }
}
