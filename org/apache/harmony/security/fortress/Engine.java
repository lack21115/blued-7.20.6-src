package org.apache.harmony.security.fortress;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/fortress/Engine.class */
public final class Engine {
    public static SecurityAccess door;
    private volatile ServiceCacheEntry serviceCache;
    private final String serviceName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/fortress/Engine$ServiceCacheEntry.class */
    public static final class ServiceCacheEntry {
        private final String algorithm;
        private final int cacheVersion;
        private final ArrayList<Provider.Service> services;

        private ServiceCacheEntry(String str, int i, ArrayList<Provider.Service> arrayList) {
            this.algorithm = str;
            this.cacheVersion = i;
            this.services = arrayList;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/fortress/Engine$SpiAndProvider.class */
    public static final class SpiAndProvider {
        public final Provider provider;
        public final Object spi;

        private SpiAndProvider(Object obj, Provider provider) {
            this.spi = obj;
            this.provider = provider;
        }
    }

    public Engine(String str) {
        this.serviceName = str;
    }

    private NoSuchAlgorithmException notFound(String str, String str2) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException(str + " " + str2 + " implementation not found");
    }

    public Object getInstance(String str, Provider provider, Object obj) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NoSuchAlgorithmException("algorithm == null");
        }
        Provider.Service service = provider.getService(this.serviceName, str);
        if (service == null) {
            throw notFound(this.serviceName, str);
        }
        return service.newInstance(obj);
    }

    public SpiAndProvider getInstance(String str, Object obj) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NoSuchAlgorithmException("Null algorithm name");
        }
        ArrayList<Provider.Service> services = getServices(str);
        if (services == null) {
            throw notFound(this.serviceName, str);
        }
        return new SpiAndProvider(services.get(0).newInstance(obj), services.get(0).getProvider());
    }

    public SpiAndProvider getInstance(Provider.Service service, String str) throws NoSuchAlgorithmException {
        return new SpiAndProvider(service.newInstance(str), service.getProvider());
    }

    public ArrayList<Provider.Service> getServices(String str) {
        int cacheVersion = Services.getCacheVersion();
        ServiceCacheEntry serviceCacheEntry = this.serviceCache;
        String upperCase = str.toUpperCase(Locale.US);
        if (serviceCacheEntry != null && serviceCacheEntry.algorithm.equalsIgnoreCase(upperCase) && cacheVersion == serviceCacheEntry.cacheVersion) {
            return serviceCacheEntry.services;
        }
        ArrayList<Provider.Service> services = Services.getServices(this.serviceName + "." + upperCase);
        this.serviceCache = new ServiceCacheEntry(upperCase, cacheVersion, services);
        return services;
    }
}
