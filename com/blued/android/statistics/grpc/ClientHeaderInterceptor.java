package com.blued.android.statistics.grpc;

import android.text.TextUtils;
import com.blued.android.statistics.util.Utils;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/ClientHeaderInterceptor.class */
public class ClientHeaderInterceptor implements ClientInterceptor {
    private ConcurrentHashMap<String, String> a;

    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) { // from class: com.blued.android.statistics.grpc.ClientHeaderInterceptor.1
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                if (ClientHeaderInterceptor.this.a != null && ClientHeaderInterceptor.this.a.size() > 0) {
                    for (Map.Entry entry : ClientHeaderInterceptor.this.a.entrySet()) {
                        Metadata.Key<String> a = Utils.a((String) entry.getKey());
                        if (metadata.containsKey(a)) {
                            metadata.removeAll(a);
                        }
                        String str = (String) entry.getValue();
                        if (!TextUtils.isEmpty(str)) {
                            metadata.put(a, str);
                        }
                    }
                }
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(listener) { // from class: com.blued.android.statistics.grpc.ClientHeaderInterceptor.1.1
                    public void onHeaders(Metadata metadata2) {
                        super.onHeaders(metadata2);
                    }
                }, metadata);
            }
        };
    }
}
