package com.tencent.tendinsv.utils;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f39105a = {com.tencent.tendinsv.a.h};
    private ExecutorService b = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        synchronized (this) {
            System.currentTimeMillis();
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName != null) {
                int length = allByName.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    InetAddress inetAddress = allByName[i2];
                    if (inetAddress != null) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (!"0.0.0.0".equals(hostAddress) && !"255.255.255.255".equals(hostAddress) && !"127.0.0.1".equals(hostAddress) && !"224.0.0.1".equals(hostAddress) && !hostAddress.startsWith("169.254.") && !hostAddress.contains(" ") && !hostAddress.startsWith("::")) {
                            l.a(com.tencent.tendinsv.b.M, "getDomainName--domainName=", str);
                            return str;
                        }
                        l.a(com.tencent.tendinsv.b.M, "getDomainName--failure_domainName=", str);
                    }
                    i = i2 + 1;
                }
            }
            return null;
        }
    }

    private FutureTask<String> b() {
        return new FutureTask<>(new Callable<String>() { // from class: com.tencent.tendinsv.utils.m.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public String call() {
                String[] strArr = m.this.f39105a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return com.tencent.tendinsv.a.h;
                    }
                    String a2 = m.this.a(strArr[i2]);
                    if (a2 != null) {
                        return a2;
                    }
                    i = i2 + 1;
                }
            }
        });
    }

    public String a() {
        try {
            FutureTask<String> b = b();
            this.b.execute(b);
            return b.get(2L, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            l.d(com.tencent.tendinsv.b.M, "preFetchDnsMethod--Exception_e=", e);
            return com.tencent.tendinsv.a.h;
        } catch (Exception e2) {
            e2.printStackTrace();
            l.d(com.tencent.tendinsv.b.M, "preFetchDnsMethod--Exception_e=", e2);
            return com.tencent.tendinsv.a.h;
        }
    }
}
