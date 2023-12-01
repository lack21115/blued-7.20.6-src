package io.grpc;

import com.google.common.base.Preconditions;
import com.umeng.analytics.pro.bh;
import io.grpc.ServiceProviders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancerRegistry.class */
public final class LoadBalancerRegistry {
    private static LoadBalancerRegistry instance;
    private final LinkedHashSet<LoadBalancerProvider> allProviders = new LinkedHashSet<>();
    private final LinkedHashMap<String, LoadBalancerProvider> effectiveProviders = new LinkedHashMap<>();
    private static final Logger logger = Logger.getLogger(LoadBalancerRegistry.class.getName());
    private static final Iterable<Class<?>> HARDCODED_CLASSES = getHardCodedClasses();

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/LoadBalancerRegistry$LoadBalancerPriorityAccessor.class */
    static final class LoadBalancerPriorityAccessor implements ServiceProviders.PriorityAccessor<LoadBalancerProvider> {
        LoadBalancerPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(LoadBalancerProvider loadBalancerProvider) {
            return loadBalancerProvider.getPriority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(LoadBalancerProvider loadBalancerProvider) {
            return loadBalancerProvider.isAvailable();
        }
    }

    private void addProvider(LoadBalancerProvider loadBalancerProvider) {
        synchronized (this) {
            Preconditions.checkArgument(loadBalancerProvider.isAvailable(), "isAvailable() returned false");
            this.allProviders.add(loadBalancerProvider);
        }
    }

    public static LoadBalancerRegistry getDefaultRegistry() {
        LoadBalancerRegistry loadBalancerRegistry;
        synchronized (LoadBalancerRegistry.class) {
            try {
                if (instance == null) {
                    List<LoadBalancerProvider> loadAll = ServiceProviders.loadAll(LoadBalancerProvider.class, HARDCODED_CLASSES, LoadBalancerProvider.class.getClassLoader(), new LoadBalancerPriorityAccessor());
                    instance = new LoadBalancerRegistry();
                    for (LoadBalancerProvider loadBalancerProvider : loadAll) {
                        Logger logger2 = logger;
                        logger2.fine("Service loader found " + loadBalancerProvider);
                        if (loadBalancerProvider.isAvailable()) {
                            instance.addProvider(loadBalancerProvider);
                        }
                    }
                    instance.refreshProviderMap();
                }
                loadBalancerRegistry = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return loadBalancerRegistry;
    }

    static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.internal.PickFirstLoadBalancerProvider"));
        } catch (ClassNotFoundException e) {
            logger.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e);
        }
        try {
            arrayList.add(Class.forName("io.grpc.util.SecretRoundRobinLoadBalancerProvider$Provider"));
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e2);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private void refreshProviderMap() {
        synchronized (this) {
            this.effectiveProviders.clear();
            Iterator<LoadBalancerProvider> it = this.allProviders.iterator();
            while (it.hasNext()) {
                LoadBalancerProvider next = it.next();
                String policyName = next.getPolicyName();
                LoadBalancerProvider loadBalancerProvider = this.effectiveProviders.get(policyName);
                if (loadBalancerProvider == null || loadBalancerProvider.getPriority() < next.getPriority()) {
                    this.effectiveProviders.put(policyName, next);
                }
            }
        }
    }

    public void deregister(LoadBalancerProvider loadBalancerProvider) {
        synchronized (this) {
            this.allProviders.remove(loadBalancerProvider);
            refreshProviderMap();
        }
    }

    @Nullable
    public LoadBalancerProvider getProvider(String str) {
        LoadBalancerProvider loadBalancerProvider;
        synchronized (this) {
            loadBalancerProvider = this.effectiveProviders.get(Preconditions.checkNotNull(str, bh.bt));
        }
        return loadBalancerProvider;
    }

    Map<String, LoadBalancerProvider> providers() {
        LinkedHashMap linkedHashMap;
        synchronized (this) {
            linkedHashMap = new LinkedHashMap(this.effectiveProviders);
        }
        return linkedHashMap;
    }

    public void register(LoadBalancerProvider loadBalancerProvider) {
        synchronized (this) {
            addProvider(loadBalancerProvider);
            refreshProviderMap();
        }
    }
}
