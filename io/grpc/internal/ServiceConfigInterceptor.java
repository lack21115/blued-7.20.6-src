package io.grpc.internal;

import io.grpc.CallOptions;
import io.grpc.ClientInterceptor;
import io.grpc.MethodDescriptor;
import io.grpc.internal.HedgingPolicy;
import io.grpc.internal.ManagedChannelServiceConfig;
import io.grpc.internal.RetryPolicy;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServiceConfigInterceptor.class */
final class ServiceConfigInterceptor implements ClientInterceptor {
    private volatile boolean initComplete;
    final AtomicReference<ManagedChannelServiceConfig> managedChannelServiceConfig = new AtomicReference<>();
    private final boolean retryEnabled;
    static final CallOptions.Key<RetryPolicy.Provider> RETRY_POLICY_KEY = CallOptions.Key.create("internal-retry-policy");
    static final CallOptions.Key<HedgingPolicy.Provider> HEDGING_POLICY_KEY = CallOptions.Key.create("internal-hedging-policy");

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConfigInterceptor(boolean z) {
        this.retryEnabled = z;
    }

    @CheckForNull
    private ManagedChannelServiceConfig.MethodInfo getMethodInfo(MethodDescriptor<?, ?> methodDescriptor) {
        ManagedChannelServiceConfig managedChannelServiceConfig = this.managedChannelServiceConfig.get();
        if (managedChannelServiceConfig == null) {
            return null;
        }
        ManagedChannelServiceConfig.MethodInfo methodInfo = managedChannelServiceConfig.getServiceMethodMap().get(methodDescriptor.getFullMethodName());
        ManagedChannelServiceConfig.MethodInfo methodInfo2 = methodInfo;
        if (methodInfo == null) {
            methodInfo2 = managedChannelServiceConfig.getServiceMap().get(methodDescriptor.getServiceName());
        }
        ManagedChannelServiceConfig.MethodInfo methodInfo3 = methodInfo2;
        if (methodInfo2 == null) {
            methodInfo3 = managedChannelServiceConfig.getDefaultMethodConfig();
        }
        return methodInfo3;
    }

    HedgingPolicy getHedgingPolicyFromConfig(MethodDescriptor<?, ?> methodDescriptor) {
        ManagedChannelServiceConfig.MethodInfo methodInfo = getMethodInfo(methodDescriptor);
        return methodInfo == null ? HedgingPolicy.DEFAULT : methodInfo.hedgingPolicy;
    }

    RetryPolicy getRetryPolicyFromConfig(MethodDescriptor<?, ?> methodDescriptor) {
        ManagedChannelServiceConfig.MethodInfo methodInfo = getMethodInfo(methodDescriptor);
        return methodInfo == null ? RetryPolicy.DEFAULT : methodInfo.retryPolicy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleUpdate(@Nullable ManagedChannelServiceConfig managedChannelServiceConfig) {
        this.managedChannelServiceConfig.set(managedChannelServiceConfig);
        this.initComplete = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d5, code lost:
        if (r0.compareTo(r0) < 0) goto L24;
     */
    @Override // io.grpc.ClientInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <ReqT, RespT> io.grpc.ClientCall<ReqT, RespT> interceptCall(final io.grpc.MethodDescriptor<ReqT, RespT> r8, io.grpc.CallOptions r9, io.grpc.Channel r10) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ServiceConfigInterceptor.interceptCall(io.grpc.MethodDescriptor, io.grpc.CallOptions, io.grpc.Channel):io.grpc.ClientCall");
    }
}
