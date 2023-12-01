package java.util;

import dalvik.system.VMStack;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: source-2895416-dex2jar.jar:java/util/ResourceBundle.class */
public abstract class ResourceBundle {
    private static final String EMPTY_STRING = "";
    private static final String UNDER_SCORE = "_";
    private long lastLoadTime = 0;
    private Locale locale;
    protected ResourceBundle parent;
    private static final ResourceBundle MISSING = new MissingBundle();
    private static final ResourceBundle MISSINGBASE = new MissingBundle();
    private static final WeakHashMap<Object, Hashtable<String, ResourceBundle>> cache = new WeakHashMap<>();
    private static Locale cacheLocale = Locale.getDefault();

    /* loaded from: source-2895416-dex2jar.jar:java/util/ResourceBundle$Control.class */
    public static class Control {
        public static final List<String> FORMAT_CLASS;
        private static final Control FORMAT_CLASS_CONTROL;
        public static final List<String> FORMAT_DEFAULT;
        private static final Control FORMAT_DEFAULT_CONTROL;
        public static final List<String> FORMAT_PROPERTIES;
        private static final Control FORMAT_PROPERTIES_CONTROL;
        public static final long TTL_DONT_CACHE = -1;
        public static final long TTL_NO_EXPIRATION_CONTROL = -2;
        List<String> format;
        static List<String> listDefault = new ArrayList();
        static List<String> listClass = new ArrayList();
        static List<String> listProperties = new ArrayList();
        static String JAVACLASS = "java.class";
        static String JAVAPROPERTIES = "java.properties";

        static {
            listDefault.add(JAVACLASS);
            listDefault.add(JAVAPROPERTIES);
            listClass.add(JAVACLASS);
            listProperties.add(JAVAPROPERTIES);
            FORMAT_DEFAULT = Collections.unmodifiableList(listDefault);
            FORMAT_CLASS = Collections.unmodifiableList(listClass);
            FORMAT_PROPERTIES = Collections.unmodifiableList(listProperties);
            FORMAT_PROPERTIES_CONTROL = new SimpleControl(JAVAPROPERTIES);
            FORMAT_CLASS_CONTROL = new SimpleControl(JAVACLASS);
            FORMAT_DEFAULT_CONTROL = new Control();
        }

        protected Control() {
            listClass = new ArrayList();
            listClass.add(JAVACLASS);
            listClass.add(JAVAPROPERTIES);
            this.format = Collections.unmodifiableList(listClass);
        }

        public static Control getControl(List<String> list) {
            switch (list.size()) {
                case 1:
                    if (list.contains(JAVACLASS)) {
                        return FORMAT_CLASS_CONTROL;
                    }
                    if (list.contains(JAVAPROPERTIES)) {
                        return FORMAT_PROPERTIES_CONTROL;
                    }
                    break;
                case 2:
                    if (list.equals(FORMAT_DEFAULT)) {
                        return FORMAT_DEFAULT_CONTROL;
                    }
                    break;
            }
            throw new IllegalArgumentException();
        }

        public static Control getNoFallbackControl(List<String> list) {
            switch (list.size()) {
                case 1:
                    if (list.contains(JAVACLASS)) {
                        return NoFallbackControl.NOFALLBACK_FORMAT_CLASS_CONTROL;
                    }
                    if (list.contains(JAVAPROPERTIES)) {
                        return NoFallbackControl.NOFALLBACK_FORMAT_PROPERTIES_CONTROL;
                    }
                    break;
                case 2:
                    if (list.equals(FORMAT_DEFAULT)) {
                        return NoFallbackControl.NOFALLBACK_FORMAT_DEFAULT_CONTROL;
                    }
                    break;
            }
            throw new IllegalArgumentException();
        }

        public List<Locale> getCandidateLocales(String str, Locale locale) {
            if (str == null) {
                throw new NullPointerException("baseName == null");
            }
            if (locale == null) {
                throw new NullPointerException("locale == null");
            }
            ArrayList arrayList = new ArrayList();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            if (!"".equals(variant)) {
                arrayList.add(new Locale(language, country, variant));
            }
            if (!"".equals(country)) {
                arrayList.add(new Locale(language, country));
            }
            if (!"".equals(language)) {
                arrayList.add(new Locale(language));
            }
            arrayList.add(Locale.ROOT);
            return arrayList;
        }

        public Locale getFallbackLocale(String str, Locale locale) {
            if (str == null) {
                throw new NullPointerException("baseName == null");
            }
            if (locale == null) {
                throw new NullPointerException("locale == null");
            }
            if (Locale.getDefault() != locale) {
                return Locale.getDefault();
            }
            return null;
        }

        public List<String> getFormats(String str) {
            if (str == null) {
                throw new NullPointerException("baseName == null");
            }
            return this.format;
        }

        public long getTimeToLive(String str, Locale locale) {
            if (str == null) {
                throw new NullPointerException("baseName == null");
            }
            if (locale == null) {
                throw new NullPointerException("locale == null");
            }
            return -2L;
        }

        public boolean needsReload(String str, Locale locale, String str2, ClassLoader classLoader, ResourceBundle resourceBundle, long j) {
            if (resourceBundle == null) {
                throw new NullPointerException("bundle == null");
            }
            String bundleName = toBundleName(str, locale);
            String str3 = str2;
            if (str2.equals(JAVACLASS)) {
                str3 = "class";
            }
            if (str2.equals(JAVAPROPERTIES)) {
                str3 = "properties";
            }
            URL resource = classLoader.getResource(toResourceName(bundleName, str3));
            return resource != null && new File(resource.getFile()).lastModified() > j;
        }

        public ResourceBundle newBundle(String str, Locale locale, String str2, ClassLoader classLoader, boolean z) throws IllegalAccessException, InstantiationException, IOException {
            if (str2 == null) {
                throw new NullPointerException("format == null");
            }
            if (classLoader == null) {
                throw new NullPointerException("loader == null");
            }
            String bundleName = toBundleName(str, locale);
            if (str2.equals(JAVACLASS)) {
                Class<?> cls = null;
                try {
                    cls = classLoader.loadClass(bundleName);
                } catch (Exception e) {
                } catch (NoClassDefFoundError e2) {
                }
                if (cls == null) {
                    return null;
                }
                try {
                    ResourceBundle resourceBundle = (ResourceBundle) cls.newInstance();
                    resourceBundle.setLocale(locale);
                    return resourceBundle;
                } catch (NullPointerException e3) {
                    return null;
                }
            } else if (str2.equals(JAVAPROPERTIES)) {
                InputStream inputStream = null;
                String resourceName = toResourceName(bundleName, "properties");
                if (z) {
                    URL url = null;
                    try {
                        url = classLoader.getResource(resourceName);
                    } catch (NullPointerException e4) {
                    }
                    if (url != null) {
                        URLConnection openConnection = url.openConnection();
                        openConnection.setUseCaches(false);
                        inputStream = openConnection.getInputStream();
                    }
                } else {
                    try {
                        inputStream = classLoader.getResourceAsStream(resourceName);
                    } catch (NullPointerException e5) {
                    }
                }
                if (inputStream != null) {
                    try {
                        PropertyResourceBundle propertyResourceBundle = new PropertyResourceBundle(new InputStreamReader(inputStream));
                        propertyResourceBundle.setLocale(locale);
                        inputStream.close();
                        return propertyResourceBundle;
                    } catch (IOException e6) {
                        return null;
                    }
                }
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public String toBundleName(String str, Locale locale) {
            StringBuilder sb;
            if (str == null) {
                throw new NullPointerException("baseName == null");
            }
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            sb2.append(str);
            if (locale.getLanguage().equals("")) {
                sb3.append("_");
            } else {
                sb2.append("_");
                sb2.append(locale.getLanguage());
            }
            if (locale.getCountry().equals("")) {
                sb3.append("_");
                sb = sb3;
            } else {
                sb2.append((CharSequence) sb3);
                sb2.append("_");
                sb2.append(locale.getCountry());
                sb = new StringBuilder();
            }
            if (!locale.getVariant().equals("")) {
                sb2.append((CharSequence) sb);
                sb2.append("_");
                sb2.append(locale.getVariant());
            }
            return sb2.toString();
        }

        public final String toResourceName(String str, String str2) {
            if (str2 == null) {
                throw new NullPointerException("suffix == null");
            }
            return str.replace('.', '/') + '.' + str2;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/ResourceBundle$MissingBundle.class */
    static class MissingBundle extends ResourceBundle {
        MissingBundle() {
        }

        @Override // java.util.ResourceBundle
        public Enumeration<String> getKeys() {
            return null;
        }

        @Override // java.util.ResourceBundle
        public Object handleGetObject(String str) {
            return null;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/ResourceBundle$NoFallbackControl.class */
    private static class NoFallbackControl extends Control {
        static final Control NOFALLBACK_FORMAT_PROPERTIES_CONTROL = new NoFallbackControl(JAVAPROPERTIES);
        static final Control NOFALLBACK_FORMAT_CLASS_CONTROL = new NoFallbackControl(JAVACLASS);
        static final Control NOFALLBACK_FORMAT_DEFAULT_CONTROL = new NoFallbackControl(listDefault);

        public NoFallbackControl(String str) {
            listClass = new ArrayList();
            listClass.add(str);
            this.format = Collections.unmodifiableList(listClass);
        }

        public NoFallbackControl(List<String> list) {
            this.format = list;
        }

        @Override // java.util.ResourceBundle.Control
        public Locale getFallbackLocale(String str, Locale locale) {
            if (str == null) {
                throw new NullPointerException("baseName == null");
            }
            if (locale == null) {
                throw new NullPointerException("locale == null");
            }
            return null;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/ResourceBundle$SimpleControl.class */
    private static class SimpleControl extends Control {
        public SimpleControl(String str) {
            listClass = new ArrayList();
            listClass.add(str);
            this.format = Collections.unmodifiableList(listClass);
        }
    }

    public static void clearCache() {
        cache.remove(ClassLoader.getSystemClassLoader());
    }

    public static void clearCache(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new NullPointerException("loader == null");
        }
        cache.remove(classLoader);
    }

    public static ResourceBundle getBundle(String str) throws MissingResourceException {
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        ClassLoader classLoader = callingClassLoader;
        if (callingClassLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(str, Locale.getDefault(), classLoader);
    }

    public static ResourceBundle getBundle(String str, Locale locale) {
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        ClassLoader classLoader = callingClassLoader;
        if (callingClassLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(str, locale, classLoader);
    }

    public static ResourceBundle getBundle(String str, Locale locale, ClassLoader classLoader) throws MissingResourceException {
        if (classLoader == null) {
            throw new NullPointerException("loader == null");
        }
        if (str == null) {
            throw new NullPointerException("bundleName == null");
        }
        Locale locale2 = Locale.getDefault();
        if (!cacheLocale.equals(locale2)) {
            cache.clear();
            cacheLocale = locale2;
        }
        ResourceBundle resourceBundle = null;
        if (!locale.equals(locale2)) {
            resourceBundle = handleGetBundle(false, str, locale, classLoader);
        }
        ResourceBundle resourceBundle2 = resourceBundle;
        if (resourceBundle == null) {
            ResourceBundle handleGetBundle = handleGetBundle(true, str, locale2, classLoader);
            resourceBundle2 = handleGetBundle;
            if (handleGetBundle == null) {
                throw missingResourceException(str + '_' + locale, "");
            }
        }
        return resourceBundle2;
    }

    public static ResourceBundle getBundle(String str, Locale locale, ClassLoader classLoader, Control control) {
        ResourceBundle processGetBundle;
        boolean z = false;
        String bundleName = control.toBundleName(str, locale);
        Hashtable<String, ResourceBundle> loaderCache = getLoaderCache(classLoader != null ? classLoader : "null");
        ResourceBundle resourceBundle = loaderCache.get(bundleName);
        if (resourceBundle != null) {
            long timeToLive = control.getTimeToLive(str, locale);
            if (timeToLive == 0 || timeToLive == -2 || resourceBundle.lastLoadTime + timeToLive < System.currentTimeMillis()) {
                processGetBundle = resourceBundle;
                if (MISSING == resourceBundle) {
                    throw new MissingResourceException(null, bundleName + '_' + locale, "");
                }
                return processGetBundle;
            }
            z = true;
        }
        processGetBundle = processGetBundle(str, locale, classLoader, control, z, resourceBundle);
        if (processGetBundle == null) {
            loaderCache.put(bundleName, MISSING);
            throw new MissingResourceException(null, bundleName + '_' + locale, "");
        }
        loaderCache.put(bundleName, processGetBundle);
        processGetBundle.lastLoadTime = System.currentTimeMillis();
        return processGetBundle;
    }

    public static ResourceBundle getBundle(String str, Locale locale, Control control) {
        return getBundle(str, locale, getLoader(), control);
    }

    public static ResourceBundle getBundle(String str, Control control) {
        return getBundle(str, Locale.getDefault(), getLoader(), control);
    }

    private static ClassLoader getLoader() {
        ClassLoader classLoader = ResourceBundle.class.getClassLoader();
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = ClassLoader.getSystemClassLoader();
        }
        return classLoader2;
    }

    private static Hashtable<String, ResourceBundle> getLoaderCache(Object obj) {
        Hashtable<String, ResourceBundle> hashtable;
        synchronized (cache) {
            Hashtable<String, ResourceBundle> hashtable2 = cache.get(obj);
            hashtable = hashtable2;
            if (hashtable2 == null) {
                hashtable = new Hashtable<>();
                cache.put(obj, hashtable);
            }
        }
        return hashtable;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ResourceBundle handleGetBundle(boolean r7, java.lang.String r8, java.util.Locale r9, java.lang.ClassLoader r10) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ResourceBundle.handleGetBundle(boolean, java.lang.String, java.util.Locale, java.lang.ClassLoader):java.util.ResourceBundle");
    }

    private static MissingResourceException missingResourceException(String str, String str2) {
        throw new MissingResourceException("Can't find resource for bundle '" + str + "', key '" + str2 + "'", str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0150, code lost:
        if (r0.contains(java.util.Locale.ROOT) == false) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ResourceBundle processGetBundle(java.lang.String r14, java.util.Locale r15, java.lang.ClassLoader r16, java.util.ResourceBundle.Control r17, boolean r18, java.util.ResourceBundle r19) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ResourceBundle.processGetBundle(java.lang.String, java.util.Locale, java.lang.ClassLoader, java.util.ResourceBundle$Control, boolean, java.util.ResourceBundle):java.util.ResourceBundle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    private static Locale strip(Locale locale) {
        String str;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        if (!variant.isEmpty()) {
            variant = "";
            str = country;
        } else if (!country.isEmpty()) {
            str = "";
        } else if (language.isEmpty()) {
            return null;
        } else {
            language = "";
            str = country;
        }
        return new Locale(language, str, variant);
    }

    public boolean containsKey(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        return keySet().contains(str);
    }

    public abstract Enumeration<String> getKeys();

    public Locale getLocale() {
        return this.locale;
    }

    public final Object getObject(String str) {
        ResourceBundle resourceBundle;
        ResourceBundle resourceBundle2;
        ResourceBundle resourceBundle3 = this;
        do {
            resourceBundle = resourceBundle3;
            Object handleGetObject = resourceBundle.handleGetObject(str);
            if (handleGetObject != null) {
                return handleGetObject;
            }
            resourceBundle2 = resourceBundle.parent;
            resourceBundle3 = resourceBundle2;
        } while (resourceBundle2 != null);
        throw missingResourceException(resourceBundle.getClass().getName(), str);
    }

    public final String getString(String str) {
        return (String) getObject(str);
    }

    public final String[] getStringArray(String str) {
        return (String[]) getObject(str);
    }

    protected abstract Object handleGetObject(String str);

    protected Set<String> handleKeySet() {
        Set<String> keySet = keySet();
        HashSet hashSet = new HashSet();
        for (String str : keySet) {
            if (handleGetObject(str) != null) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public Set<String> keySet() {
        HashSet hashSet = new HashSet();
        Enumeration<String> keys = getKeys();
        while (keys.hasMoreElements()) {
            hashSet.add(keys.nextElement());
        }
        return hashSet;
    }

    protected void setParent(ResourceBundle resourceBundle) {
        this.parent = resourceBundle;
    }
}
