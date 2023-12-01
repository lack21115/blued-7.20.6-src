package com.blued.android.statistics.grpc;

import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.RILConstants;
import com.blued.android.statistics.util.Utils;
import com.qiniu.android.dns.DnsManager;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.grpc.NameResolverRegistry;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Collections;
import javax.annotation.Nullable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/DnsResolver.class */
public class DnsResolver {

    /* renamed from: a  reason: collision with root package name */
    private NameResolverProvider f18696a = null;
    private DnsManager b;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/DnsResolver$DirectAddressNameResolverProvider.class */
    class DirectAddressNameResolverProvider extends NameResolverProvider {
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private int f18701c;
        private String d;

        public DirectAddressNameResolverProvider(String str, int i, String str2) {
            this.b = str;
            this.f18701c = i;
            this.d = str2;
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            return TextUtils.isEmpty(this.b) ? RILConstants.SETUP_DATA_PROTOCOL_IP : URI.create(this.b).getScheme();
        }

        @Override // io.grpc.NameResolverProvider
        public boolean isAvailable() {
            return true;
        }

        @Override // io.grpc.NameResolver.Factory
        @Nullable
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            if (uri == null || TextUtils.isEmpty(this.b) || !uri.getScheme().equals(this.b)) {
                return null;
            }
            return new NameResolver() { // from class: com.blued.android.statistics.grpc.DnsResolver.DirectAddressNameResolverProvider.1
                @Override // io.grpc.NameResolver
                public String getServiceAuthority() {
                    return DirectAddressNameResolverProvider.this.b + ":" + DirectAddressNameResolverProvider.this.f18701c;
                }

                @Override // io.grpc.NameResolver
                public void shutdown() {
                }

                @Override // io.grpc.NameResolver
                public void start(NameResolver.Listener listener) {
                    InetSocketAddress inetSocketAddress;
                    if (TextUtils.isEmpty(DirectAddressNameResolverProvider.this.d)) {
                        try {
                            InetAddress byName = InetAddress.getByName(DirectAddressNameResolverProvider.this.b);
                            inetSocketAddress = new InetSocketAddress(byName, DirectAddressNameResolverProvider.this.f18701c);
                            Log.v("gRPC", "newNameResolver inetAddress : " + byName);
                        } catch (UnknownHostException e) {
                            inetSocketAddress = new InetSocketAddress(DirectAddressNameResolverProvider.this.f18701c);
                            Log.v("gRPC", "Broken system behaviour for dns lookup of " + DirectAddressNameResolverProvider.this.b);
                            e.printStackTrace();
                        }
                    } else {
                        inetSocketAddress = new InetSocketAddress(DirectAddressNameResolverProvider.this.d, DirectAddressNameResolverProvider.this.f18701c);
                    }
                    Log.v("gRPC", "newNameResolver socketAddress : " + inetSocketAddress.toString());
                    listener.onAddresses(Collections.singletonList(new EquivalentAddressGroup(inetSocketAddress)), Attributes.EMPTY);
                }
            };
        }

        @Override // io.grpc.NameResolverProvider
        public int priority() {
            return 5;
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/DnsResolver$OnGetIPFinishListener.class */
    public interface OnGetIPFinishListener {
        void a(String str);
    }

    public DnsResolver(DnsManager dnsManager) {
        this.b = dnsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(DnsManager dnsManager, String str) {
        String[] strArr;
        if (dnsManager != null) {
            try {
                strArr = dnsManager.query(str);
            } catch (IOException e) {
                e.printStackTrace();
                strArr = null;
            }
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            Log.v("gRPC", "get HttpDns from cache, " + str + " -> " + strArr[0]);
            return strArr[0];
        }
        return null;
    }

    public void a(final String str, final int i, final OnGetIPFinishListener onGetIPFinishListener) {
        if (this.f18696a != null) {
            NameResolverRegistry.getDefaultRegistry().deregister(this.f18696a);
            Log.v("gRPC", "dns deregister : " + this.f18696a);
        }
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        StatThreadManager.b().execute(new Runnable() { // from class: com.blued.android.statistics.grpc.DnsResolver.1
            @Override // java.lang.Runnable
            public void run() {
                DnsResolver dnsResolver = DnsResolver.this;
                final String a2 = dnsResolver.a(dnsResolver.b, str);
                Log.v("gRPC", "dns ipAddr : " + a2);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                Utils.a(new Runnable() { // from class: com.blued.android.statistics.grpc.DnsResolver.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DnsResolver.this.f18696a = new DirectAddressNameResolverProvider(str, i, a2);
                        NameResolverRegistry.getDefaultRegistry().register(DnsResolver.this.f18696a);
                        Log.v("gRPC", "dns register : " + DnsResolver.this.f18696a);
                        if (onGetIPFinishListener != null) {
                            onGetIPFinishListener.a(a2);
                        }
                    }
                });
            }
        });
    }
}
