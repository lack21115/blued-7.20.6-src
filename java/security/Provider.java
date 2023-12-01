package java.security;

import com.igexin.push.core.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.harmony.security.fortress.Services;

/* loaded from: source-2895416-dex2jar.jar:java/security/Provider.class */
public abstract class Provider extends Properties {
    private static final long serialVersionUID = -4298000515446427739L;
    private transient LinkedHashMap<String, Service> aliasTable;
    private transient LinkedHashMap<Object, Object> changedProperties;
    private String info;
    private transient String lastAlgorithm;
    private transient String lastServiceName;
    private transient Service lastServicesByType;
    private transient Set<Service> lastServicesSet;
    private transient String lastType;
    private String name;
    private transient LinkedHashMap<String, Service> propertyAliasTable;
    private transient LinkedHashMap<String, Service> propertyServiceTable;
    private transient int providerNumber = -1;
    private transient Service returnedService;
    private transient LinkedHashMap<String, Service> serviceTable;
    private double version;
    private transient String versionString;

    /* loaded from: source-2895416-dex2jar.jar:java/security/Provider$Service.class */
    public static class Service {
        private static final String ATTR_SUPPORTED_KEY_CLASSES = "SupportedKeyClasses";
        private static final String ATTR_SUPPORTED_KEY_FORMATS = "SupportedKeyFormats";
        private static final HashMap<String, Class<?>> constructorParameterClasses;
        private static final HashMap<String, Boolean> supportsParameterTypes = new HashMap<>();
        private String algorithm;
        private List<String> aliases;
        private Map<String, String> attributes;
        private String className;
        private Class<?> implementation;
        private Class<?>[] keyClasses;
        private String[] keyFormats;
        private String lastClassName;
        private Provider provider;
        private volatile boolean supportedKeysInitialized;
        private String type;

        static {
            supportsParameterTypes.put("AlgorithmParameterGenerator", false);
            supportsParameterTypes.put("AlgorithmParameters", false);
            supportsParameterTypes.put("CertificateFactory", false);
            supportsParameterTypes.put("CertPathBuilder", false);
            supportsParameterTypes.put("CertPathValidator", false);
            supportsParameterTypes.put("CertStore", false);
            supportsParameterTypes.put("KeyFactory", false);
            supportsParameterTypes.put("KeyGenerator", false);
            supportsParameterTypes.put("KeyManagerFactory", false);
            supportsParameterTypes.put("KeyPairGenerator", false);
            supportsParameterTypes.put("KeyStore", false);
            supportsParameterTypes.put("MessageDigest", false);
            supportsParameterTypes.put("SecretKeyFactory", false);
            supportsParameterTypes.put("SecureRandom", false);
            supportsParameterTypes.put("SSLContext", false);
            supportsParameterTypes.put("TrustManagerFactory", false);
            supportsParameterTypes.put("Cipher", true);
            supportsParameterTypes.put("KeyAgreement", true);
            supportsParameterTypes.put("Mac", true);
            supportsParameterTypes.put("Signature", true);
            constructorParameterClasses = new HashMap<>();
            constructorParameterClasses.put("CertStore", loadClassOrThrow("java.security.cert.CertStoreParameters"));
            constructorParameterClasses.put("AlgorithmParameterGenerator", null);
            constructorParameterClasses.put("AlgorithmParameters", null);
            constructorParameterClasses.put("CertificateFactory", null);
            constructorParameterClasses.put("CertPathBuilder", null);
            constructorParameterClasses.put("CertPathValidator", null);
            constructorParameterClasses.put("KeyFactory", null);
            constructorParameterClasses.put("KeyGenerator", null);
            constructorParameterClasses.put("KeyManagerFactory", null);
            constructorParameterClasses.put("KeyPairGenerator", null);
            constructorParameterClasses.put("KeyStore", null);
            constructorParameterClasses.put("MessageDigest", null);
            constructorParameterClasses.put("SecretKeyFactory", null);
            constructorParameterClasses.put("SecureRandom", null);
            constructorParameterClasses.put("SSLContext", null);
            constructorParameterClasses.put("TrustManagerFactory", null);
            constructorParameterClasses.put("Cipher", null);
            constructorParameterClasses.put("KeyAgreement", null);
            constructorParameterClasses.put("Mac", null);
            constructorParameterClasses.put("Signature", null);
        }

        public Service(Provider provider, String str, String str2, String str3, List<String> list, Map<String, String> map) {
            if (provider == null) {
                throw new NullPointerException("provider == null");
            }
            if (str == null) {
                throw new NullPointerException("type == null");
            }
            if (str2 == null) {
                throw new NullPointerException("algorithm == null");
            }
            if (str3 == null) {
                throw new NullPointerException("className == null");
            }
            this.provider = provider;
            this.type = str;
            this.algorithm = str2;
            this.className = str3;
            List<String> list2 = list;
            if (list != null) {
                list2 = list;
                if (list.size() == 0) {
                    list2 = Collections.emptyList();
                }
            }
            this.aliases = list2;
            Map<String, String> map2 = map;
            if (map != null) {
                map2 = map;
                if (map.size() == 0) {
                    map2 = Collections.emptyMap();
                }
            }
            this.attributes = map2;
        }

        private void ensureSupportedKeysInitialized() {
            if (this.supportedKeysInitialized) {
                return;
            }
            String attribute = getAttribute(ATTR_SUPPORTED_KEY_CLASSES);
            if (attribute != null) {
                String[] split = attribute.split("\\|");
                ArrayList arrayList = new ArrayList(split.length);
                ClassLoader classLoader = getProvider().getClass().getClassLoader();
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    try {
                        Class<?> loadClass = classLoader.loadClass(split[i2]);
                        if (Key.class.isAssignableFrom(loadClass)) {
                            arrayList.add(loadClass);
                        }
                    } catch (ClassNotFoundException e) {
                    }
                    i = i2 + 1;
                }
                this.keyClasses = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
            }
            String attribute2 = getAttribute(ATTR_SUPPORTED_KEY_FORMATS);
            if (attribute2 != null) {
                this.keyFormats = attribute2.split("\\|");
            }
            this.supportedKeysInitialized = true;
        }

        private static boolean isInArray(Class<?>[] clsArr, Class<?> cls) {
            if (cls == null) {
                return false;
            }
            int length = clsArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (clsArr[i2].isAssignableFrom(cls)) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        private static <T> boolean isInArray(T[] tArr, T t) {
            if (t == null) {
                return false;
            }
            int length = tArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (t.equals(tArr[i2])) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        private static Class<?> loadClassOrThrow(String str) {
            try {
                return Provider.class.getClassLoader().loadClass(str);
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        }

        private Object newInstanceNoParameter() throws NoSuchAlgorithmException {
            try {
                return this.implementation.newInstance();
            } catch (Exception e) {
                throw new NoSuchAlgorithmException(this.type + " " + this.algorithm + " implementation not found", e);
            }
        }

        private Object newInstanceWithParameter(Object obj, Class<?> cls) throws NoSuchAlgorithmException {
            try {
                return this.implementation.getConstructor(cls).newInstance(obj);
            } catch (Exception e) {
                throw new NoSuchAlgorithmException(this.type + " " + this.algorithm + " implementation not found", e);
            }
        }

        void addAlias(String str) {
            if (this.aliases == null || this.aliases.size() == 0) {
                this.aliases = new ArrayList();
            }
            this.aliases.add(str);
        }

        public final String getAlgorithm() {
            return this.algorithm;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<String> getAliases() {
            if (this.aliases == null) {
                this.aliases = new ArrayList(0);
            }
            return this.aliases;
        }

        public final String getAttribute(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.attributes == null) {
                return null;
            }
            return this.attributes.get(str);
        }

        public final String getClassName() {
            return this.className;
        }

        public final Provider getProvider() {
            return this.provider;
        }

        public final String getType() {
            return this.type;
        }

        public Object newInstance(Object obj) throws NoSuchAlgorithmException {
            if (this.implementation == null || !this.className.equals(this.lastClassName)) {
                ClassLoader classLoader = this.provider.getClass().getClassLoader();
                ClassLoader classLoader2 = classLoader;
                if (classLoader == null) {
                    classLoader2 = ClassLoader.getSystemClassLoader();
                }
                try {
                    this.implementation = Class.forName(this.className, true, classLoader2);
                    this.lastClassName = this.className;
                } catch (Exception e) {
                    throw new NoSuchAlgorithmException(this.type + " " + this.algorithm + " implementation not found: " + e);
                }
            }
            if (!constructorParameterClasses.containsKey(this.type)) {
                return obj == null ? newInstanceNoParameter() : newInstanceWithParameter(obj, obj.getClass());
            } else if (obj == null) {
                return newInstanceNoParameter();
            } else {
                Class<?> cls = constructorParameterClasses.get(this.type);
                if (cls == null) {
                    throw new IllegalArgumentException("Constructor parameter not supported for " + this.type);
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return newInstanceWithParameter(obj, cls);
                }
                throw new IllegalArgumentException("Expecting constructor parameter of type " + cls.getName() + " but was " + obj.getClass().getName());
            }
        }

        void putAttribute(String str, String str2) {
            if (this.attributes == null || this.attributes.size() == 0) {
                this.attributes = new HashMap();
            }
            this.attributes.put(str, str2);
        }

        public boolean supportsParameter(Object obj) {
            Boolean bool = supportsParameterTypes.get(this.type);
            if (bool == null) {
                return true;
            }
            if (bool.booleanValue()) {
                if (obj == null || (obj instanceof Key)) {
                    ensureSupportedKeysInitialized();
                    if (this.keyClasses == null && this.keyFormats == null) {
                        return true;
                    }
                    if (obj == null) {
                        return false;
                    }
                    Key key = (Key) obj;
                    if (this.keyClasses == null || !isInArray(this.keyClasses, key.getClass())) {
                        return this.keyFormats != null && isInArray(this.keyFormats, key.getFormat());
                    }
                    return true;
                }
                throw new InvalidParameterException("Parameter should be of type Key");
            }
            throw new InvalidParameterException("Cannot use a parameter with " + this.type);
        }

        public String toString() {
            String str = "Provider " + this.provider.getName() + " Service " + this.type + "." + this.algorithm + " " + this.className;
            String str2 = str;
            if (this.aliases != null) {
                str2 = str + "\nAliases " + this.aliases.toString();
            }
            String str3 = str2;
            if (this.attributes != null) {
                str3 = str2 + "\nAttributes " + this.attributes.toString();
            }
            return str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Provider(String str, double d, String str2) {
        this.name = str;
        this.version = d;
        this.info = str2;
        this.versionString = String.valueOf(d);
        putProviderInfo();
    }

    private boolean checkAttribute(String str, String str2, String str3) {
        String propertyIgnoreCase = getPropertyIgnoreCase(str + ' ' + str2);
        if (propertyIgnoreCase != null) {
            return str2.equalsIgnoreCase("KeySize") ? Integer.parseInt(propertyIgnoreCase) >= Integer.parseInt(str3) : propertyIgnoreCase.equalsIgnoreCase(str3);
        }
        return false;
    }

    private String getPropertyIgnoreCase(String str) {
        String property = getProperty(str);
        if (property != null) {
            return property;
        }
        Enumeration<?> propertyNames = propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str2 = (String) propertyNames.nextElement();
            if (str.equalsIgnoreCase(str2)) {
                return getProperty(str2);
            }
        }
        return null;
    }

    private static String key(String str, String str2) {
        return str + '.' + str2.toUpperCase(Locale.US);
    }

    private void myPutAll(Map<?, ?> map) {
        if (this.changedProperties == null) {
            this.changedProperties = new LinkedHashMap<>();
        }
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (!(key instanceof String) || !((String) key).startsWith("Provider.")) {
                Object value = entry.getValue();
                super.put(key, value);
                if (this.changedProperties.remove(key) == null) {
                    removeFromPropertyServiceTable(key);
                }
                this.changedProperties.put(key, value);
            }
        }
        if (this.providerNumber != -1) {
            Services.setNeedRefresh();
        }
    }

    private void putProviderInfo() {
        super.put("Provider.id name", this.name != null ? this.name : b.l);
        super.put("Provider.id version", this.versionString);
        super.put("Provider.id info", this.info != null ? this.info : b.l);
        super.put("Provider.id className", getClass().getName());
    }

    private void readObject(ObjectInputStream objectInputStream) throws NotActiveException, IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.versionString = String.valueOf(this.version);
        this.providerNumber = -1;
    }

    private void removeFromPropertyServiceTable(Object obj) {
        Service service;
        Service remove;
        if (obj == null || !(obj instanceof String)) {
            return;
        }
        String str = (String) obj;
        if (str.startsWith("Provider.")) {
            return;
        }
        if (str.startsWith("Alg.Alias.")) {
            String substring = str.substring(10);
            int indexOf = substring.indexOf(46);
            String substring2 = substring.substring(0, indexOf);
            String substring3 = substring.substring(indexOf + 1);
            if (this.propertyAliasTable != null) {
                this.propertyAliasTable.remove(key(substring2, substring3));
            }
            if (this.propertyServiceTable != null) {
                for (Service service2 : this.propertyServiceTable.values()) {
                    if (service2.aliases.contains(substring3)) {
                        service2.aliases.remove(substring3);
                        return;
                    }
                }
                return;
            }
            return;
        }
        int indexOf2 = str.indexOf(46);
        if (indexOf2 != -1) {
            int indexOf3 = str.indexOf(32);
            if (indexOf3 != -1) {
                String substring4 = str.substring(indexOf3 + 1);
                String substring5 = str.substring(0, indexOf2);
                String substring6 = str.substring(indexOf2 + 1, indexOf3);
                if (this.propertyServiceTable == null || (service = this.propertyServiceTable.get(key(substring5, substring6))) == null) {
                    return;
                }
                service.attributes.remove(substring4);
                return;
            }
            String substring7 = str.substring(0, indexOf2);
            String substring8 = str.substring(indexOf2 + 1);
            if (this.propertyServiceTable == null || (remove = this.propertyServiceTable.remove(key(substring7, substring8))) == null || this.propertyAliasTable == null || remove.aliases == null) {
                return;
            }
            for (String str2 : remove.aliases) {
                this.propertyAliasTable.remove(key(substring7, str2));
            }
        }
    }

    private void serviceInfoFromProperties(Service service) {
        super.remove(service.type + "." + service.algorithm);
        if (service.aliases != null) {
            Iterator it = service.aliases.iterator();
            while (it.hasNext()) {
                super.remove("Alg.Alias." + service.type + "." + ((String) it.next()));
            }
        }
        if (service.attributes != null) {
            Iterator it2 = service.attributes.entrySet().iterator();
            while (it2.hasNext()) {
                super.remove(service.type + "." + service.algorithm + " " + ((String) ((Map.Entry) it2.next()).getKey()));
            }
        }
        if (this.providerNumber != -1) {
            Services.setNeedRefresh();
        }
    }

    private void serviceInfoToProperties(Service service) {
        super.put(service.type + "." + service.algorithm, service.className);
        if (service.aliases != null) {
            Iterator it = service.aliases.iterator();
            while (it.hasNext()) {
                super.put("Alg.Alias." + service.type + "." + ((String) it.next()), service.algorithm);
            }
        }
        if (service.attributes != null) {
            for (Map.Entry entry : service.attributes.entrySet()) {
                super.put(service.type + "." + service.algorithm + " " + ((String) entry.getKey()), entry.getValue());
            }
        }
        if (this.providerNumber != -1) {
            Services.setNeedRefresh();
        }
    }

    private void servicesChanged() {
        this.lastServicesByType = null;
        this.lastServiceName = null;
        this.lastServicesSet = null;
    }

    private void updatePropertyServiceTable() {
        if (this.changedProperties == null || this.changedProperties.isEmpty()) {
            return;
        }
        for (Map.Entry<Object, Object> entry : this.changedProperties.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null && (key instanceof String) && (value instanceof String)) {
                String str = (String) key;
                String str2 = (String) value;
                if (!str.startsWith("Provider")) {
                    if (str.startsWith("Alg.Alias.")) {
                        String substring = str.substring(10);
                        int indexOf = substring.indexOf(46);
                        String substring2 = substring.substring(0, indexOf);
                        String substring3 = substring.substring(indexOf + 1);
                        String key2 = key(substring2, str2);
                        Service service = null;
                        if (this.propertyServiceTable == null) {
                            this.propertyServiceTable = new LinkedHashMap<>(128);
                        } else {
                            service = this.propertyServiceTable.get(key2);
                        }
                        if (service != null) {
                            Service service2 = service;
                            service2.addAlias(substring3);
                            if (this.propertyAliasTable == null) {
                                this.propertyAliasTable = new LinkedHashMap<>(256);
                            }
                            this.propertyAliasTable.put(key(substring2, substring3), service2);
                        } else {
                            String str3 = (String) this.changedProperties.get(substring2 + "." + str2);
                            if (str3 != null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(substring3);
                                Service service3 = new Service(this, substring2, str2, str3, arrayList, new HashMap());
                                this.propertyServiceTable.put(key2, service3);
                                if (this.propertyAliasTable == null) {
                                    this.propertyAliasTable = new LinkedHashMap<>(256);
                                }
                                this.propertyAliasTable.put(key(substring2, substring3), service3);
                            }
                        }
                    } else {
                        int indexOf2 = str.indexOf(46);
                        if (indexOf2 != -1) {
                            int indexOf3 = str.indexOf(32);
                            if (indexOf3 == -1) {
                                String substring4 = str.substring(0, indexOf2);
                                String substring5 = str.substring(indexOf2 + 1);
                                String key3 = key(substring4, substring5);
                                Service service4 = this.propertyServiceTable != null ? this.propertyServiceTable.get(key3) : null;
                                if (service4 != null) {
                                    service4.className = str2;
                                } else {
                                    Service service5 = new Service(this, substring4, substring5, str2, Collections.emptyList(), Collections.emptyMap());
                                    if (this.propertyServiceTable == null) {
                                        this.propertyServiceTable = new LinkedHashMap<>(128);
                                    }
                                    this.propertyServiceTable.put(key3, service5);
                                }
                            } else {
                                String substring6 = str.substring(0, indexOf2);
                                String substring7 = str.substring(indexOf2 + 1, indexOf3);
                                String substring8 = str.substring(indexOf3 + 1);
                                String key4 = key(substring6, substring7);
                                Service service6 = this.propertyServiceTable != null ? this.propertyServiceTable.get(key4) : null;
                                if (service6 != null) {
                                    service6.putAttribute(substring8, str2);
                                } else {
                                    String str4 = (String) this.changedProperties.get(substring6 + "." + substring7);
                                    if (str4 != null) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(substring8, str2);
                                        Service service7 = new Service(this, substring6, substring7, str4, new ArrayList(), hashMap);
                                        if (this.propertyServiceTable == null) {
                                            this.propertyServiceTable = new LinkedHashMap<>(128);
                                        }
                                        this.propertyServiceTable.put(key4, service7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        servicesChanged();
        this.changedProperties = null;
    }

    @Override // java.util.Hashtable, java.util.Map
    public void clear() {
        synchronized (this) {
            super.clear();
            if (this.serviceTable != null) {
                this.serviceTable.clear();
            }
            if (this.propertyServiceTable != null) {
                this.propertyServiceTable.clear();
            }
            if (this.aliasTable != null) {
                this.aliasTable.clear();
            }
            if (this.propertyAliasTable != null) {
                this.propertyAliasTable.clear();
            }
            this.changedProperties = null;
            putProviderInfo();
            if (this.providerNumber != -1) {
                Services.setNeedRefresh();
            }
            servicesChanged();
        }
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> unmodifiableSet;
        synchronized (this) {
            unmodifiableSet = Collections.unmodifiableSet(super.entrySet());
        }
        return unmodifiableSet;
    }

    public String getInfo() {
        return this.info;
    }

    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getProviderNumber() {
        return this.providerNumber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Service getService(String str) {
        Service service;
        synchronized (this) {
            updatePropertyServiceTable();
            if (this.lastServicesByType == null || !str.equals(this.lastType)) {
                Iterator<Service> it = getServices().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        service = null;
                        break;
                    }
                    Service next = it.next();
                    if (str.equals(next.type)) {
                        this.lastType = str;
                        this.lastServicesByType = next;
                        service = next;
                        break;
                    }
                }
            } else {
                service = this.lastServicesByType;
            }
        }
        return service;
    }

    public Service getService(String str, String str2) {
        Service service;
        synchronized (this) {
            if (str == null) {
                throw new NullPointerException("type == null");
            }
            if (str2 == null) {
                throw new NullPointerException("algorithm == null");
            }
            if (str.equals(this.lastServiceName) && str2.equalsIgnoreCase(this.lastAlgorithm)) {
                service = this.returnedService;
            } else {
                String key = key(str, str2);
                Service service2 = null;
                if (this.serviceTable != null) {
                    service2 = this.serviceTable.get(key);
                }
                Service service3 = (service2 != null || this.aliasTable == null) ? service2 : this.aliasTable.get(key);
                if (service3 == null) {
                    updatePropertyServiceTable();
                }
                Service service4 = service3;
                if (service3 == null) {
                    service4 = service3;
                    if (this.propertyServiceTable != null) {
                        service4 = this.propertyServiceTable.get(key);
                    }
                }
                Service service5 = service4;
                if (service4 == null) {
                    service5 = service4;
                    if (this.propertyAliasTable != null) {
                        service5 = this.propertyAliasTable.get(key);
                    }
                }
                if (service5 != null) {
                    this.lastServiceName = str;
                    this.lastAlgorithm = str2;
                    this.returnedService = service5;
                    service = this.returnedService;
                } else {
                    service = null;
                }
            }
        }
        return service;
    }

    public Set<Service> getServices() {
        Set<Service> set;
        synchronized (this) {
            updatePropertyServiceTable();
            if (this.lastServicesSet != null) {
                set = this.lastServicesSet;
            } else {
                if (this.serviceTable != null) {
                    this.lastServicesSet = new LinkedHashSet(this.serviceTable.values());
                } else {
                    this.lastServicesSet = new LinkedHashSet();
                }
                if (this.propertyServiceTable != null) {
                    this.lastServicesSet.addAll(this.propertyServiceTable.values());
                }
                this.lastServicesSet = Collections.unmodifiableSet(this.lastServicesSet);
                set = this.lastServicesSet;
            }
        }
        return set;
    }

    public double getVersion() {
        return this.version;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean implementsAlg(String str, String str2, String str3, String str4) {
        String str5 = str + "." + str2;
        String propertyIgnoreCase = getPropertyIgnoreCase(str5);
        String str6 = propertyIgnoreCase;
        String str7 = str5;
        if (propertyIgnoreCase == null) {
            String propertyIgnoreCase2 = getPropertyIgnoreCase("Alg.Alias." + str5);
            str6 = propertyIgnoreCase;
            str7 = str5;
            if (propertyIgnoreCase2 != null) {
                str7 = str + "." + propertyIgnoreCase2;
                str6 = getPropertyIgnoreCase(str7);
            }
        }
        if (str6 != null) {
            if (str3 == null) {
                return true;
            }
            return checkAttribute(str7, str3, str4);
        }
        return false;
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set<Object> keySet() {
        return Collections.unmodifiableSet(super.keySet());
    }

    @Override // java.util.Properties
    public void load(InputStream inputStream) throws IOException {
        synchronized (this) {
            Properties properties = new Properties();
            properties.load(inputStream);
            myPutAll(properties);
        }
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public Object put(Object obj, Object obj2) {
        Object put;
        synchronized (this) {
            if ((obj instanceof String) && ((String) obj).startsWith("Provider.")) {
                put = null;
            } else {
                if (this.providerNumber != -1) {
                    Services.setNeedRefresh();
                }
                if (this.changedProperties != null && this.changedProperties.remove(obj) == null) {
                    removeFromPropertyServiceTable(obj);
                }
                if (this.changedProperties == null) {
                    this.changedProperties = new LinkedHashMap<>();
                }
                this.changedProperties.put(obj, obj2);
                put = super.put(obj, obj2);
            }
        }
        return put;
    }

    @Override // java.util.Hashtable, java.util.Map
    public void putAll(Map<?, ?> map) {
        synchronized (this) {
            myPutAll(map);
        }
    }

    protected void putService(Service service) {
        synchronized (this) {
            if (service == null) {
                throw new NullPointerException("s == null");
            }
            if (!"Provider".equals(service.getType())) {
                servicesChanged();
                if (this.serviceTable == null) {
                    this.serviceTable = new LinkedHashMap<>(128);
                }
                this.serviceTable.put(key(service.type, service.algorithm), service);
                if (service.aliases != null) {
                    if (this.aliasTable == null) {
                        this.aliasTable = new LinkedHashMap<>(256);
                    }
                    for (String str : service.getAliases()) {
                        this.aliasTable.put(key(service.type, str), service);
                    }
                }
                serviceInfoToProperties(service);
            }
        }
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public Object remove(Object obj) {
        Object remove;
        synchronized (this) {
            if ((obj instanceof String) && ((String) obj).startsWith("Provider.")) {
                remove = null;
            } else {
                if (this.providerNumber != -1) {
                    Services.setNeedRefresh();
                }
                if (this.changedProperties != null && this.changedProperties.remove(obj) == null) {
                    removeFromPropertyServiceTable(obj);
                    if (this.changedProperties.size() == 0) {
                        this.changedProperties = null;
                    }
                }
                remove = super.remove(obj);
            }
        }
        return remove;
    }

    protected void removeService(Service service) {
        synchronized (this) {
            if (service == null) {
                throw new NullPointerException("s == null");
            }
            servicesChanged();
            if (this.serviceTable != null) {
                this.serviceTable.remove(key(service.type, service.algorithm));
            }
            if (this.aliasTable != null && service.aliases != null) {
                for (String str : service.getAliases()) {
                    this.aliasTable.remove(key(service.type, str));
                }
            }
            serviceInfoFromProperties(service);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProviderNumber(int i) {
        this.providerNumber = i;
    }

    @Override // java.util.Hashtable
    public String toString() {
        return this.name + " version " + this.version;
    }

    @Override // java.util.Hashtable, java.util.Map
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(super.values());
    }
}
