package java.security;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.harmony.security.fortress.Engine;
import org.apache.harmony.security.fortress.SecurityAccess;
import org.apache.harmony.security.fortress.Services;

/* loaded from: source-2895416-dex2jar.jar:java/security/Security.class */
public final class Security {
    private static final Properties secprops = new Properties();

    /* loaded from: source-2895416-dex2jar.jar:java/security/Security$SecurityDoor.class */
    private static class SecurityDoor implements SecurityAccess {
        private SecurityDoor() {
        }

        @Override // org.apache.harmony.security.fortress.SecurityAccess
        public List<String> getAliases(Provider.Service service) {
            return service.getAliases();
        }

        @Override // org.apache.harmony.security.fortress.SecurityAccess
        public Provider.Service getService(Provider provider, String str) {
            return provider.getService(str);
        }

        @Override // org.apache.harmony.security.fortress.SecurityAccess
        public void renumProviders() {
            Security.renumProviders();
        }
    }

    static {
        boolean z = false;
        try {
            InputStream resourceAsStream = Security.class.getResourceAsStream("security.properties");
            secprops.load(new BufferedInputStream(resourceAsStream));
            z = true;
            resourceAsStream.close();
            z = true;
        } catch (Exception e) {
            System.logE("Could not load 'security.properties'", e);
        }
        if (!z) {
            registerDefaultProviders();
        }
        Engine.door = new SecurityDoor();
    }

    private Security() {
    }

    public static int addProvider(Provider provider) {
        return insertProviderAt(provider, 0);
    }

    private static void filterProviders(ArrayList<Provider> arrayList, String str, String str2, String str3, String str4) {
        Iterator<Provider> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!it.next().implementsAlg(str, str2, str3, str4)) {
                it.remove();
            }
        }
    }

    @Deprecated
    public static String getAlgorithmProperty(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String str3 = "Alg." + str2 + "." + str;
        Provider[] providers = getProviders();
        int length = providers.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Provider provider = providers[i2];
            Enumeration<?> propertyNames = provider.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str4 = (String) propertyNames.nextElement();
                if (str4.equalsIgnoreCase(str3)) {
                    return provider.getProperty(str4);
                }
            }
            i = i2 + 1;
        }
    }

    public static Set<String> getAlgorithms(String str) {
        HashSet hashSet = new HashSet();
        if (str != null) {
            Provider[] providers = getProviders();
            int length = providers.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                for (Provider.Service service : providers[i2].getServices()) {
                    if (service.getType().equalsIgnoreCase(str)) {
                        hashSet.add(service.getAlgorithm());
                    }
                }
                i = i2 + 1;
            }
        }
        return hashSet;
    }

    public static String getProperty(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        String property = secprops.getProperty(str);
        String str2 = property;
        if (property != null) {
            str2 = property.trim();
        }
        return str2;
    }

    public static Provider getProvider(String str) {
        Provider provider;
        synchronized (Security.class) {
            try {
                provider = Services.getProvider(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return provider;
    }

    public static Provider[] getProviders() {
        Provider[] providerArr;
        synchronized (Security.class) {
            try {
                ArrayList<Provider> providers = Services.getProviders();
                providerArr = (Provider[]) providers.toArray(new Provider[providers.size()]);
            } catch (Throwable th) {
                throw th;
            }
        }
        return providerArr;
    }

    public static Provider[] getProviders(String str) {
        if (str == null) {
            throw new NullPointerException("filter == null");
        }
        if (str.length() == 0) {
            throw new InvalidParameterException();
        }
        HashMap hashMap = new HashMap();
        int indexOf = str.indexOf(58);
        if (indexOf == str.length() - 1 || indexOf == 0) {
            throw new InvalidParameterException();
        }
        if (indexOf < 1) {
            hashMap.put(str, "");
        } else {
            hashMap.put(str.substring(0, indexOf), str.substring(indexOf + 1));
        }
        return getProviders(hashMap);
    }

    public static Provider[] getProviders(Map<String, String> map) {
        Provider[] providerArr;
        synchronized (Security.class) {
            try {
                if (map == null) {
                    throw new NullPointerException("filter == null");
                }
                if (map.isEmpty()) {
                    providerArr = null;
                } else {
                    ArrayList arrayList = new ArrayList(Services.getProviders());
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        String str = null;
                        int indexOf = key.indexOf(32);
                        int indexOf2 = key.indexOf(46);
                        if (indexOf2 == -1) {
                            throw new InvalidParameterException();
                        }
                        if (indexOf == -1) {
                            if (value.length() != 0) {
                                throw new InvalidParameterException();
                            }
                        } else if (value.length() == 0) {
                            throw new InvalidParameterException();
                        } else {
                            str = key.substring(indexOf + 1);
                            if (str.trim().length() == 0) {
                                throw new InvalidParameterException();
                            }
                            key = key.substring(0, indexOf);
                        }
                        String substring = key.substring(0, indexOf2);
                        String substring2 = key.substring(indexOf2 + 1);
                        if (substring.length() == 0 || substring2.length() == 0) {
                            throw new InvalidParameterException();
                        }
                        filterProviders(arrayList, substring, substring2, str, value);
                    }
                    providerArr = null;
                    if (arrayList.size() > 0) {
                        providerArr = (Provider[]) arrayList.toArray(new Provider[arrayList.size()]);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return providerArr;
    }

    public static int insertProviderAt(Provider provider, int i) {
        int insertProviderAt;
        synchronized (Security.class) {
            try {
                if (getProvider(provider.getName()) != null) {
                    insertProviderAt = -1;
                } else {
                    insertProviderAt = Services.insertProviderAt(provider, i);
                    renumProviders();
                }
            } finally {
            }
        }
        return insertProviderAt;
    }

    private static void registerDefaultProviders() {
        secprops.put("security.provider.1", "com.android.org.conscrypt.OpenSSLProvider");
        secprops.put("security.provider.2", "com.android.org.bouncycastle.jce.provider.BouncyCastleProvider");
        secprops.put("security.provider.3", "org.apache.harmony.security.provider.crypto.CryptoProvider");
        secprops.put("security.provider.4", "com.android.org.conscrypt.JSSEProvider");
    }

    public static void removeProvider(String str) {
        Provider provider;
        synchronized (Security.class) {
            if (str != null) {
                try {
                    if (str.length() != 0 && (provider = getProvider(str)) != null) {
                        Services.removeProvider(provider.getProviderNumber());
                        renumProviders();
                        provider.setProviderNumber(-1);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void renumProviders() {
        ArrayList<Provider> providers = Services.getProviders();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= providers.size()) {
                return;
            }
            providers.get(i2).setProviderNumber(i2 + 1);
            i = i2 + 1;
        }
    }

    public static void setProperty(String str, String str2) {
        Services.setNeedRefresh();
        secprops.put(str, str2);
    }
}
