package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.NameResolver;
import io.grpc.ServiceProviders;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolverRegistry.class */
public final class NameResolverRegistry {
    private static NameResolverRegistry instance;
    private static final Logger logger = Logger.getLogger(NameResolverRegistry.class.getName());
    private final NameResolver.Factory factory = new NameResolverFactory();
    private final LinkedHashSet<NameResolverProvider> allProviders = new LinkedHashSet<>();
    private List<NameResolverProvider> effectiveProviders = Collections.emptyList();

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolverRegistry$NameResolverFactory.class */
    final class NameResolverFactory extends NameResolver.Factory {
        private NameResolverFactory() {
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            List<NameResolverProvider> providers = NameResolverRegistry.this.providers();
            return providers.isEmpty() ? "unknown" : providers.get(0).getDefaultScheme();
        }

        @Override // io.grpc.NameResolver.Factory
        @Nullable
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            for (NameResolverProvider nameResolverProvider : NameResolverRegistry.this.providers()) {
                NameResolver newNameResolver = nameResolverProvider.newNameResolver(uri, args);
                if (newNameResolver != null) {
                    return newNameResolver;
                }
            }
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/NameResolverRegistry$NameResolverPriorityAccessor.class */
    static final class NameResolverPriorityAccessor implements ServiceProviders.PriorityAccessor<NameResolverProvider> {
        private NameResolverPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.priority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.isAvailable();
        }
    }

    private void addProvider(NameResolverProvider nameResolverProvider) {
        synchronized (this) {
            Preconditions.checkArgument(nameResolverProvider.isAvailable(), "isAvailable() returned false");
            this.allProviders.add(nameResolverProvider);
        }
    }

    public static NameResolverRegistry getDefaultRegistry() {
        NameResolverRegistry nameResolverRegistry;
        synchronized (NameResolverRegistry.class) {
            try {
                if (instance == null) {
                    List<NameResolverProvider> loadAll = ServiceProviders.loadAll(NameResolverProvider.class, getHardCodedClasses(), NameResolverProvider.class.getClassLoader(), new NameResolverPriorityAccessor());
                    if (loadAll.isEmpty()) {
                        logger.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                    }
                    instance = new NameResolverRegistry();
                    for (NameResolverProvider nameResolverProvider : loadAll) {
                        Logger logger2 = logger;
                        logger2.fine("Service loader found " + nameResolverProvider);
                        if (nameResolverProvider.isAvailable()) {
                            instance.addProvider(nameResolverProvider);
                        }
                    }
                    instance.refreshProviders();
                }
                nameResolverRegistry = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nameResolverRegistry;
    }

    static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.internal.DnsNameResolverProvider"));
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private void refreshProviders() {
        synchronized (this) {
            ArrayList arrayList = new ArrayList(this.allProviders);
            Collections.sort(arrayList, Collections.reverseOrder(new Comparator<NameResolverProvider>() { // from class: io.grpc.NameResolverRegistry.1
                @Override // java.util.Comparator
                public int compare(NameResolverProvider nameResolverProvider, NameResolverProvider nameResolverProvider2) {
                    return nameResolverProvider.priority() - nameResolverProvider2.priority();
                }
            }));
            this.effectiveProviders = Collections.unmodifiableList(arrayList);
        }
    }

    public NameResolver.Factory asFactory() {
        return this.factory;
    }

    public void deregister(NameResolverProvider nameResolverProvider) {
        synchronized (this) {
            this.allProviders.remove(nameResolverProvider);
            refreshProviders();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<NameResolverProvider> providers() {
        List<NameResolverProvider> list;
        synchronized (this) {
            list = this.effectiveProviders;
        }
        return list;
    }

    public void register(NameResolverProvider nameResolverProvider) {
        synchronized (this) {
            addProvider(nameResolverProvider);
            refreshProviders();
        }
    }
}
