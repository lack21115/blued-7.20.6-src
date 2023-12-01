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

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, String> f18691a;

    @Override // io.grpc.ClientInterceptor
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) { // from class: com.blued.android.statistics.grpc.ClientHeaderInterceptor.1
            @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                if (ClientHeaderInterceptor.this.f18691a != null && ClientHeaderInterceptor.this.f18691a.size() > 0) {
                    for (Map.Entry entry : ClientHeaderInterceptor.this.f18691a.entrySet()) {
                        Metadata.Key<String> a2 = Utils.a((String) entry.getKey());
                        if (metadata.containsKey(a2)) {
                            metadata.removeAll(a2);
                        }
                        String str = (String) entry.getValue();
                        if (!TextUtils.isEmpty(str)) {
                            metadata.put(a2, str);
                        }
                    }
                }
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(listener) { // from class: com.blued.android.statistics.grpc.ClientHeaderInterceptor.1.1
                    @Override // io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener, io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
                    public void onHeaders(Metadata metadata2) {
                        super.onHeaders(metadata2);
                    }
                }, metadata);
            }
        };
    }
}
