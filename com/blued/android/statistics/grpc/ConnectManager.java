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

    /* renamed from: a  reason: collision with root package name */
    private static ManagedChannel f18694a;
    private static OkHttpChannelBuilder b;

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f18695c = new ConcurrentHashMap<>();
    private static Metadata d = new Metadata();
    private static DnsResolver e = null;

    public static Channel a() {
        return f18694a;
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
        f18694a = a2.build();
    }

    public static void a(String str, String str2) {
        d = Utils.a(f18695c, d, str, str2);
    }

    public static boolean b() {
        return f18694a != null;
    }
}
