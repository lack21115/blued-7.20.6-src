package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import io.grpc.MethodDescriptor;
import io.grpc.internal.RetriableStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ManagedChannelServiceConfig.class */
public final class ManagedChannelServiceConfig {
    @Nullable
    private final MethodInfo defaultMethodConfig;
    @Nullable
    private final Map<String, ?> healthCheckingConfig;
    @Nullable
    private final Object loadBalancingConfig;
    @Nullable
    private final RetriableStream.Throttle retryThrottling;
    private final Map<String, MethodInfo> serviceMap;
    private final Map<String, MethodInfo> serviceMethodMap;

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ManagedChannelServiceConfig$MethodInfo.class */
    static final class MethodInfo {
        final HedgingPolicy hedgingPolicy;
        final Integer maxInboundMessageSize;
        final Integer maxOutboundMessageSize;
        final RetryPolicy retryPolicy;
        final Long timeoutNanos;
        final Boolean waitForReady;

        MethodInfo(Map<String, ?> map, boolean z, int i, int i2) {
            this.timeoutNanos = ServiceConfigUtil.getTimeoutFromMethodConfig(map);
            this.waitForReady = ServiceConfigUtil.getWaitForReadyFromMethodConfig(map);
            Integer maxResponseMessageBytesFromMethodConfig = ServiceConfigUtil.getMaxResponseMessageBytesFromMethodConfig(map);
            this.maxInboundMessageSize = maxResponseMessageBytesFromMethodConfig;
            if (maxResponseMessageBytesFromMethodConfig != null) {
                Preconditions.checkArgument(maxResponseMessageBytesFromMethodConfig.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", this.maxInboundMessageSize);
            }
            Integer maxRequestMessageBytesFromMethodConfig = ServiceConfigUtil.getMaxRequestMessageBytesFromMethodConfig(map);
            this.maxOutboundMessageSize = maxRequestMessageBytesFromMethodConfig;
            if (maxRequestMessageBytesFromMethodConfig != null) {
                Preconditions.checkArgument(maxRequestMessageBytesFromMethodConfig.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", this.maxOutboundMessageSize);
            }
            Map<String, ?> retryPolicyFromMethodConfig = z ? ServiceConfigUtil.getRetryPolicyFromMethodConfig(map) : null;
            this.retryPolicy = retryPolicyFromMethodConfig == null ? RetryPolicy.DEFAULT : retryPolicy(retryPolicyFromMethodConfig, i);
            Map<String, ?> hedgingPolicyFromMethodConfig = z ? ServiceConfigUtil.getHedgingPolicyFromMethodConfig(map) : null;
            this.hedgingPolicy = hedgingPolicyFromMethodConfig == null ? HedgingPolicy.DEFAULT : hedgingPolicy(hedgingPolicyFromMethodConfig, i2);
        }

        private static HedgingPolicy hedgingPolicy(Map<String, ?> map, int i) {
            int intValue = ((Integer) Preconditions.checkNotNull(ServiceConfigUtil.getMaxAttemptsFromHedgingPolicy(map), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i);
            long longValue = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.getHedgingDelayNanosFromHedgingPolicy(map), "hedgingDelay cannot be empty")).longValue();
            Preconditions.checkArgument(longValue >= 0, "hedgingDelay must not be negative: %s", longValue);
            return new HedgingPolicy(min, longValue, ServiceConfigUtil.getNonFatalStatusCodesFromHedgingPolicy(map));
        }

        private static RetryPolicy retryPolicy(Map<String, ?> map, int i) {
            int intValue = ((Integer) Preconditions.checkNotNull(ServiceConfigUtil.getMaxAttemptsFromRetryPolicy(map), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i);
            long longValue = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.getInitialBackoffNanosFromRetryPolicy(map), "initialBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(longValue > 0, "initialBackoffNanos must be greater than 0: %s", longValue);
            long longValue2 = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.getMaxBackoffNanosFromRetryPolicy(map), "maxBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(longValue2 > 0, "maxBackoff must be greater than 0: %s", longValue2);
            double doubleValue = ((Double) Preconditions.checkNotNull(ServiceConfigUtil.getBackoffMultiplierFromRetryPolicy(map), "backoffMultiplier cannot be empty")).doubleValue();
            Preconditions.checkArgument(doubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", Double.valueOf(doubleValue));
            return new RetryPolicy(min, longValue, longValue2, doubleValue, ServiceConfigUtil.getRetryableStatusCodesFromRetryPolicy(map));
        }

        public boolean equals(Object obj) {
            if (obj instanceof MethodInfo) {
                MethodInfo methodInfo = (MethodInfo) obj;
                boolean z = false;
                if (Objects.equal(this.timeoutNanos, methodInfo.timeoutNanos)) {
                    z = false;
                    if (Objects.equal(this.waitForReady, methodInfo.waitForReady)) {
                        z = false;
                        if (Objects.equal(this.maxInboundMessageSize, methodInfo.maxInboundMessageSize)) {
                            z = false;
                            if (Objects.equal(this.maxOutboundMessageSize, methodInfo.maxOutboundMessageSize)) {
                                z = false;
                                if (Objects.equal(this.retryPolicy, methodInfo.retryPolicy)) {
                                    z = false;
                                    if (Objects.equal(this.hedgingPolicy, methodInfo.hedgingPolicy)) {
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
                return z;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.timeoutNanos, this.waitForReady, this.maxInboundMessageSize, this.maxOutboundMessageSize, this.retryPolicy, this.hedgingPolicy);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("timeoutNanos", this.timeoutNanos).add("waitForReady", this.waitForReady).add("maxInboundMessageSize", this.maxInboundMessageSize).add("maxOutboundMessageSize", this.maxOutboundMessageSize).add("retryPolicy", this.retryPolicy).add("hedgingPolicy", this.hedgingPolicy).toString();
        }
    }

    ManagedChannelServiceConfig(@Nullable MethodInfo methodInfo, Map<String, MethodInfo> map, Map<String, MethodInfo> map2, @Nullable RetriableStream.Throttle throttle, @Nullable Object obj, @Nullable Map<String, ?> map3) {
        this.defaultMethodConfig = methodInfo;
        this.serviceMethodMap = Collections.unmodifiableMap(new HashMap(map));
        this.serviceMap = Collections.unmodifiableMap(new HashMap(map2));
        this.retryThrottling = throttle;
        this.loadBalancingConfig = obj;
        this.healthCheckingConfig = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ManagedChannelServiceConfig empty() {
        return new ManagedChannelServiceConfig(null, new HashMap(), new HashMap(), null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ManagedChannelServiceConfig fromServiceConfig(Map<String, ?> map, boolean z, int i, int i2, @Nullable Object obj) {
        RetriableStream.Throttle throttlePolicy = z ? ServiceConfigUtil.getThrottlePolicy(map) : null;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Map<String, ?> healthCheckedService = ServiceConfigUtil.getHealthCheckedService(map);
        List<Map<String, ?>> methodConfigFromServiceConfig = ServiceConfigUtil.getMethodConfigFromServiceConfig(map);
        if (methodConfigFromServiceConfig == null) {
            return new ManagedChannelServiceConfig(null, hashMap, hashMap2, throttlePolicy, obj, healthCheckedService);
        }
        Iterator<Map<String, ?>> it = methodConfigFromServiceConfig.iterator();
        MethodInfo methodInfo = null;
        while (true) {
            MethodInfo methodInfo2 = methodInfo;
            if (!it.hasNext()) {
                return new ManagedChannelServiceConfig(methodInfo2, hashMap, hashMap2, throttlePolicy, obj, healthCheckedService);
            }
            Map<String, ?> next = it.next();
            MethodInfo methodInfo3 = new MethodInfo(next, z, i, i2);
            List<Map<String, ?>> nameListFromMethodConfig = ServiceConfigUtil.getNameListFromMethodConfig(next);
            MethodInfo methodInfo4 = methodInfo2;
            if (nameListFromMethodConfig != null) {
                if (nameListFromMethodConfig.isEmpty()) {
                    methodInfo4 = methodInfo2;
                } else {
                    Iterator<Map<String, ?>> it2 = nameListFromMethodConfig.iterator();
                    while (true) {
                        methodInfo4 = methodInfo2;
                        if (it2.hasNext()) {
                            Map<String, ?> next2 = it2.next();
                            String serviceFromName = ServiceConfigUtil.getServiceFromName(next2);
                            String methodFromName = ServiceConfigUtil.getMethodFromName(next2);
                            boolean z2 = true;
                            if (Strings.isNullOrEmpty(serviceFromName)) {
                                Preconditions.checkArgument(Strings.isNullOrEmpty(methodFromName), "missing service name for method %s", methodFromName);
                                if (methodInfo2 != null) {
                                    z2 = false;
                                }
                                Preconditions.checkArgument(z2, "Duplicate default method config in service config %s", map);
                                methodInfo2 = methodInfo3;
                            } else if (Strings.isNullOrEmpty(methodFromName)) {
                                Preconditions.checkArgument(!hashMap2.containsKey(serviceFromName), "Duplicate service %s", serviceFromName);
                                hashMap2.put(serviceFromName, methodInfo3);
                            } else {
                                String generateFullMethodName = MethodDescriptor.generateFullMethodName(serviceFromName, methodFromName);
                                Preconditions.checkArgument(!hashMap.containsKey(generateFullMethodName), "Duplicate method name %s", generateFullMethodName);
                                hashMap.put(generateFullMethodName, methodInfo3);
                            }
                        }
                    }
                }
            }
            methodInfo = methodInfo4;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ManagedChannelServiceConfig managedChannelServiceConfig = (ManagedChannelServiceConfig) obj;
        return Objects.equal(this.serviceMethodMap, managedChannelServiceConfig.serviceMethodMap) && Objects.equal(this.serviceMap, managedChannelServiceConfig.serviceMap) && Objects.equal(this.retryThrottling, managedChannelServiceConfig.retryThrottling) && Objects.equal(this.loadBalancingConfig, managedChannelServiceConfig.loadBalancingConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public MethodInfo getDefaultMethodConfig() {
        return this.defaultMethodConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Map<String, ?> getHealthCheckingConfig() {
        return this.healthCheckingConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object getLoadBalancingConfig() {
        return this.loadBalancingConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public RetriableStream.Throttle getRetryThrottling() {
        return this.retryThrottling;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, MethodInfo> getServiceMap() {
        return this.serviceMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, MethodInfo> getServiceMethodMap() {
        return this.serviceMethodMap;
    }

    public int hashCode() {
        return Objects.hashCode(this.serviceMethodMap, this.serviceMap, this.retryThrottling, this.loadBalancingConfig);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("serviceMethodMap", this.serviceMethodMap).add("serviceMap", this.serviceMap).add("retryThrottling", this.retryThrottling).add("loadBalancingConfig", this.loadBalancingConfig).toString();
    }
}
