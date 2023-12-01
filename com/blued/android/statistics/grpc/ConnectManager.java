package com.blued.android.statistics.grpc;

import com.blued.android.statistics.grpc.DnsResolver;
import com.blued.android.statistics.util.Utils;
import com.qiniu.android.dns.DnsManager;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/ConnectManager.class */
public class ConnectManager {
    private static ManagedChannel a;
    private static OkHttpChannelBuilder b;
    private static ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();
    private static Metadata d = new Metadata();
    private static DnsResolver e = null;

    public static Channel a() {
        return a;
    }

    public static <T extends AbstractStub<T>> T a(T t) {
        return (T) Utils.a(t, d);
    }

    public static void a(String str, int i, DnsManager dnsManager) {
        if (dnsManager != null) {
            if (e == null) {
                e = new DnsResolver(dnsManager);
            }
            e.a(str, i, (DnsResolver.OnGetIPFinishListener) null);
        }
        OkHttpChannelBuilder a2 = Utils.a(str, i);
        b = a2;
        a = a2.build();
    }

    public static void a(String str, String str2) {
        d = Utils.a(c, d, str, str2);
    }

    public static boolean b() {
        return a != null;
    }
}
