package com.blued.android.module.im.grpc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.android.ims.ImsConferenceState;
import com.blued.android.statistics.grpc.DnsResolver;
import com.blued.android.statistics.util.Utils;
import com.qiniu.android.dns.DnsManager;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.stub.AbstractStub;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/ChannelManager.class */
public class ChannelManager {
    private volatile ManagedChannel a;
    private volatile ManagedChannel b;
    private final ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();
    private ConnectivityManager d;
    private String e;
    private String f;

    public ChannelManager(Context context, String str, int i, DnsManager dnsManager) {
        this.a = null;
        this.b = null;
        this.d = null;
        Log.i("gRPC", "---------- createChannel! ----------");
        this.e = str;
        if (dnsManager != null) {
            new DnsResolver(dnsManager).a(str, i, new DnsResolver.OnGetIPFinishListener() { // from class: com.blued.android.module.im.grpc.ChannelManager.1
                @Override // com.blued.android.statistics.grpc.DnsResolver.OnGetIPFinishListener
                public void a(String str2) {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    ChannelManager.this.f = str2;
                }
            });
        }
        this.d = (ConnectivityManager) context.getSystemService("connectivity");
        this.b = ((OkHttpChannelBuilder) Utils.a(str, i).keepAliveTime(10L, TimeUnit.SECONDS).keepAliveTimeout(30L, TimeUnit.SECONDS).idleTimeout(1L, TimeUnit.MINUTES)).keepAliveWithoutCalls(true).build();
        this.a = Utils.a(str, i).build();
    }

    public Status a(Exception exc) {
        Status fromThrowable = Status.fromThrowable(exc);
        Status status = fromThrowable;
        if (fromThrowable.getCode() == Status.Code.UNAVAILABLE) {
            status = fromThrowable;
            if (TextUtils.isEmpty(fromThrowable.getDescription())) {
                StringBuilder sb = new StringBuilder();
                sb.append("network is ");
                sb.append(g() ? ImsConferenceState.STATUS_CONNECTED : ImsConferenceState.STATUS_DISCONNECTED);
                status = fromThrowable.withDescription(sb.toString());
            }
        }
        return status;
    }

    public <T extends AbstractStub<T>> T a(T t) {
        return (T) Utils.a(t, f());
    }

    public String a() {
        return this.e;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            this.c.remove(str);
        } else {
            this.c.put(str, str2);
        }
    }

    public String b() {
        return this.f;
    }

    public void c() {
        try {
            if (this.b == null || this.b.isShutdown()) {
                return;
            }
            Log.e("gRPC", "closeChannel!");
            this.b.shutdownNow();
        } catch (Exception e) {
            Log.e("gRPC", "closeChannel Exception : \n", e);
        }
    }

    public Channel d() {
        return this.a;
    }

    public Channel e() {
        return this.b;
    }

    public Metadata f() {
        Metadata metadata = new Metadata();
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            metadata.put(Utils.a(entry.getKey()), entry.getValue());
        }
        return metadata;
    }

    public boolean g() {
        ConnectivityManager connectivityManager = this.d;
        boolean z = false;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            z = false;
            if (activeNetworkInfo != null) {
                z = false;
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                }
            }
        }
        return z;
    }
}
