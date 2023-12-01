package org.apache.harmony.security.fortress;

import java.security.Provider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/fortress/Services.class */
public class Services {
    private static Provider.Service cachedSecureRandomService;
    private static boolean needRefresh;
    private static final HashMap<String, ArrayList<Provider.Service>> services = new HashMap<>(600);
    private static int cacheVersion = 1;
    private static final ArrayList<Provider> providers = new ArrayList<>(20);
    private static final HashMap<String, Provider> providersNames = new HashMap<>(20);

    static {
        ClassLoader.getSystemClassLoader();
        new StringBuilder();
        throw new VerifyError("bad dex opcode");
    }

    private static void appendServiceLocked(String str, Provider.Service service) {
        ArrayList<Provider.Service> arrayList = services.get(str);
        ArrayList<Provider.Service> arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = new ArrayList<>(1);
            services.put(str, arrayList2);
        }
        arrayList2.add(service);
    }

    public static int getCacheVersion() {
        int i;
        synchronized (Services.class) {
            try {
                if (needRefresh) {
                    cacheVersion++;
                    synchronized (services) {
                        services.clear();
                    }
                    cachedSecureRandomService = null;
                    Iterator<Provider> it = providers.iterator();
                    while (it.hasNext()) {
                        initServiceInfo(it.next());
                    }
                    needRefresh = false;
                }
                i = cacheVersion;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public static Provider getProvider(String str) {
        Provider provider;
        synchronized (Services.class) {
            if (str == null) {
                provider = null;
            } else {
                try {
                    provider = providersNames.get(str);
                } finally {
                }
            }
        }
        return provider;
    }

    public static ArrayList<Provider> getProviders() {
        ArrayList<Provider> arrayList;
        synchronized (Services.class) {
            try {
                arrayList = providers;
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public static Provider.Service getSecureRandomService() {
        Provider.Service service;
        synchronized (Services.class) {
            try {
                getCacheVersion();
                service = cachedSecureRandomService;
            } catch (Throwable th) {
                throw th;
            }
        }
        return service;
    }

    public static ArrayList<Provider.Service> getServices(String str) {
        ArrayList<Provider.Service> arrayList;
        synchronized (Services.class) {
            try {
                arrayList = services.get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public static void initServiceInfo(Provider provider) {
        synchronized (Services.class) {
            try {
                for (Provider.Service service : provider.getServices()) {
                    String type = service.getType();
                    if (cachedSecureRandomService == null && type.equals("SecureRandom")) {
                        cachedSecureRandomService = service;
                    }
                    appendServiceLocked(type + "." + service.getAlgorithm().toUpperCase(Locale.US), service);
                    Iterator<String> it = Engine.door.getAliases(service).iterator();
                    while (it.hasNext()) {
                        appendServiceLocked(type + "." + it.next().toUpperCase(Locale.US), service);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r5 > r0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int insertProviderAt(java.security.Provider r4, int r5) {
        /*
            java.lang.Class<org.apache.harmony.security.fortress.Services> r0 = org.apache.harmony.security.fortress.Services.class
            monitor-enter(r0)
            java.util.ArrayList<java.security.Provider> r0 = org.apache.harmony.security.fortress.Services.providers     // Catch: java.lang.Throwable -> L37
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L37
            r7 = r0
            r0 = r5
            r1 = 1
            if (r0 < r1) goto L3d
            r0 = r5
            r6 = r0
            r0 = r5
            r1 = r7
            if (r0 <= r1) goto L19
            goto L3d
        L19:
            java.util.ArrayList<java.security.Provider> r0 = org.apache.harmony.security.fortress.Services.providers     // Catch: java.lang.Throwable -> L37
            r1 = r6
            r2 = 1
            int r1 = r1 - r2
            r2 = r4
            r0.add(r1, r2)     // Catch: java.lang.Throwable -> L37
            java.util.HashMap<java.lang.String, java.security.Provider> r0 = org.apache.harmony.security.fortress.Services.providersNames     // Catch: java.lang.Throwable -> L37
            r1 = r4
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L37
            r2 = r4
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L37
            setNeedRefresh()     // Catch: java.lang.Throwable -> L37
            java.lang.Class<org.apache.harmony.security.fortress.Services> r0 = org.apache.harmony.security.fortress.Services.class
            monitor-exit(r0)
            r0 = r6
            return r0
        L37:
            r4 = move-exception
            java.lang.Class<org.apache.harmony.security.fortress.Services> r0 = org.apache.harmony.security.fortress.Services.class
            monitor-exit(r0)
            r0 = r4
            throw r0
        L3d:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.security.fortress.Services.insertProviderAt(java.security.Provider, int):int");
    }

    public static boolean isEmpty() {
        boolean isEmpty;
        synchronized (Services.class) {
            try {
                isEmpty = services.isEmpty();
            } catch (Throwable th) {
                throw th;
            }
        }
        return isEmpty;
    }

    public static void removeProvider(int i) {
        synchronized (Services.class) {
            try {
                providersNames.remove(providers.remove(i - 1).getName());
                setNeedRefresh();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setNeedRefresh() {
        synchronized (Services.class) {
            try {
                needRefresh = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
