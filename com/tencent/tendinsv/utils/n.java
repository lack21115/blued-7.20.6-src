package com.tencent.tendinsv.utils;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f39107a = {"log1.cmpassport.com", "wap.cmpassport.com", "cmpassport.com", "config.cmpassport.com", "onekey.cmpassport.com", "auth.wosms.cn", "daily.m.zzx9.cn", "open.e.189.cn", "id6.me"};

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName == null) {
                return;
            }
            int length = allByName.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                InetAddress inetAddress = allByName[i2];
                if (inetAddress != null) {
                    l.a(com.tencent.tendinsv.b.N, "inetAddress==", inetAddress, "__hostAddress=", inetAddress.getHostAddress());
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            l.d(com.tencent.tendinsv.b.N, "getDomainName--Exception_e=", th);
        }
    }

    public FutureTask<Void> a() {
        try {
            return new FutureTask<>(new Callable<Void>() { // from class: com.tencent.tendinsv.utils.n.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    String[] strArr = n.this.f39107a;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            return null;
                        }
                        n.this.a(strArr[i2]);
                        i = i2 + 1;
                    }
                }
            });
        } catch (Exception e) {
            l.d(com.tencent.tendinsv.b.N, "preFetchDns--Exception_e=", e);
            return null;
        }
    }
}
