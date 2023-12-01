package java.net;

import com.android.internal.content.NativeLibraryHelper;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.SecureClassLoader;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import libcore.io.IoUtils;
import libcore.io.Streams;

@FindBugsSuppressWarnings({"DMI_COLLECTION_OF_URLS", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
/* loaded from: source-2895416-dex2jar.jar:java/net/URLClassLoader.class */
public class URLClassLoader extends SecureClassLoader {
    private URLStreamHandlerFactory factory;
    ArrayList<URLHandler> handlerList;
    Map<URL, URLHandler> handlerMap;
    ArrayList<URL> originalUrls;
    List<URL> searchList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/net/URLClassLoader$IndexFile.class */
    public static class IndexFile {
        private HashMap<String, ArrayList<URL>> map;

        public IndexFile(HashMap<String, ArrayList<URL>> hashMap) {
            this.map = hashMap;
        }

        private static URL getParentURL(URL url) throws IOException {
            URL jarFileURL = ((JarURLConnection) url.openConnection()).getJarFileURL();
            String replace = new File(jarFileURL.getFile()).getParent().replace(File.separatorChar, '/');
            String str = replace;
            if (replace.charAt(0) != '/') {
                str = BridgeUtil.SPLIT_MARK + replace;
            }
            return new URL(jarFileURL.getProtocol(), jarFileURL.getHost(), jarFileURL.getPort(), str);
        }

        static IndexFile readIndexFile(JarFile jarFile, JarEntry jarEntry, URL url) {
            InputStream inputStream;
            BufferedReader bufferedReader;
            String str;
            ArrayList arrayList;
            InputStream inputStream2 = null;
            InputStream inputStream3 = null;
            InputStream inputStream4 = null;
            try {
                str = "jar:" + getParentURL(url).toExternalForm() + BridgeUtil.SPLIT_MARK;
                inputStream = jarFile.getInputStream(jarEntry);
                inputStream2 = inputStream;
                inputStream3 = inputStream;
                inputStream4 = inputStream;
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            } catch (MalformedURLException e) {
                bufferedReader = null;
                inputStream = inputStream4;
            } catch (IOException e2) {
                bufferedReader = null;
                inputStream = inputStream3;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStream2;
                bufferedReader = null;
            }
            try {
                HashMap hashMap = new HashMap();
                if (bufferedReader.readLine() == null) {
                    IoUtils.closeQuietly(bufferedReader);
                    IoUtils.closeQuietly(inputStream);
                    return null;
                }
                if (bufferedReader.readLine() == null) {
                    IoUtils.closeQuietly(bufferedReader);
                    IoUtils.closeQuietly(inputStream);
                    return null;
                }
                loop0: while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    URL url2 = new URL(str + readLine + "!/");
                    while (true) {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 == null) {
                            break loop0;
                        } else if (readLine2.isEmpty()) {
                            break;
                        } else {
                            if (hashMap.containsKey(readLine2)) {
                                arrayList = (ArrayList) hashMap.get(readLine2);
                            } else {
                                arrayList = new ArrayList();
                                hashMap.put(readLine2, arrayList);
                            }
                            arrayList.add(url2);
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    IoUtils.closeQuietly(bufferedReader);
                    IoUtils.closeQuietly(inputStream);
                    return null;
                }
                IndexFile indexFile = new IndexFile(hashMap);
                IoUtils.closeQuietly(bufferedReader);
                IoUtils.closeQuietly(inputStream);
                return indexFile;
            } catch (MalformedURLException e3) {
                IoUtils.closeQuietly(bufferedReader);
                IoUtils.closeQuietly(inputStream);
                return null;
            } catch (IOException e4) {
                IoUtils.closeQuietly(bufferedReader);
                IoUtils.closeQuietly(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                IoUtils.closeQuietly(bufferedReader);
                IoUtils.closeQuietly(inputStream);
                throw th;
            }
        }

        ArrayList<URL> get(String str) {
            return this.map.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/net/URLClassLoader$URLFileHandler.class */
    public class URLFileHandler extends URLHandler {
        private String prefix;

        public URLFileHandler(URL url) {
            super(url);
            String file = url.getFile();
            String host = url.getHost();
            int length = host != null ? host.length() : 0;
            StringBuilder sb = new StringBuilder(length + 2 + file.length());
            if (length > 0) {
                sb.append("//").append(host);
            }
            sb.append(file);
            this.prefix = sb.toString();
        }

        @Override // java.net.URLClassLoader.URLHandler
        Class<?> findClass(String str, String str2, String str3) {
            try {
                File file = new File(URLDecoder.decode(this.prefix + str2, "UTF-8"));
                Class<?> cls = null;
                if (file.exists()) {
                    try {
                        cls = createClass(new FileInputStream(file), str, str3);
                    } catch (FileNotFoundException e) {
                        return null;
                    }
                }
                return cls;
            } catch (UnsupportedEncodingException e2) {
                return null;
            } catch (IllegalArgumentException e3) {
                return null;
            }
        }

        @Override // java.net.URLClassLoader.URLHandler
        URL findResource(String str) {
            int i;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= str.length() || !(str.charAt(i) == '/' || str.charAt(i) == '\\')) {
                    break;
                }
                i2 = i + 1;
            }
            String str2 = str;
            if (i > 0) {
                str2 = str.substring(i);
            }
            URL url = null;
            try {
                if (new File(URLDecoder.decode(this.prefix, "UTF-8") + str2).exists()) {
                    url = targetURL(this.url, str2);
                }
                return url;
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            } catch (IllegalArgumentException e2) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/net/URLClassLoader$URLHandler.class */
    public class URLHandler {
        URL codeSourceUrl;
        URL url;

        public URLHandler(URL url) {
            this.url = url;
            this.codeSourceUrl = url;
        }

        Class<?> createClass(InputStream inputStream, String str, String str2) {
            if (inputStream == null) {
                return null;
            }
            try {
                byte[] readFully = Streams.readFully(inputStream);
                if (str != null) {
                    String replace = str.replace('/', '.');
                    Package r0 = URLClassLoader.this.getPackage(replace);
                    if (r0 == null) {
                        URLClassLoader.this.definePackage(replace, null, null, null, null, null, null, null);
                    } else if (r0.isSealed()) {
                        throw new SecurityException("Package is sealed");
                    }
                }
                return URLClassLoader.this.defineClass(str2, readFully, 0, readFully.length, new CodeSource(this.codeSourceUrl, (Certificate[]) null));
            } catch (IOException e) {
                return null;
            }
        }

        Class<?> findClass(String str, String str2, String str3) {
            URL targetURL = targetURL(this.url, str2);
            if (targetURL != null) {
                try {
                    return createClass(targetURL.openStream(), str, str3);
                } catch (IOException e) {
                    return null;
                }
            }
            return null;
        }

        URL findResource(String str) {
            URLConnection openConnection;
            URL targetURL = targetURL(this.url, str);
            if (targetURL != null) {
                try {
                    openConnection = targetURL.openConnection();
                    openConnection.getInputStream().close();
                } catch (IOException e) {
                    targetURL = null;
                } catch (SecurityException e2) {
                    return null;
                }
                if (targetURL.getProtocol().equals("http")) {
                    int responseCode = ((HttpURLConnection) openConnection).getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        return null;
                    }
                    return targetURL;
                }
                return targetURL;
            }
            return null;
        }

        void findResources(String str, ArrayList<URL> arrayList) {
            URL findResource = findResource(str);
            if (findResource == null || arrayList.contains(findResource)) {
                return;
            }
            arrayList.add(findResource);
        }

        URL targetURL(URL url, String str) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url.getFile());
                URI.PATH_ENCODER.appendEncoded(sb, str);
                return new URL(url.getProtocol(), url.getHost(), url.getPort(), sb.toString(), null);
            } catch (MalformedURLException e) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/net/URLClassLoader$URLJarHandler.class */
    public class URLJarHandler extends URLHandler {
        final IndexFile index;
        final JarFile jf;
        final String prefixName;
        final Map<URL, URLHandler> subHandlers;

        public URLJarHandler(URL url, URL url2, JarFile jarFile, String str) {
            super(url);
            this.subHandlers = new HashMap();
            this.jf = jarFile;
            this.prefixName = str;
            this.codeSourceUrl = url2;
            JarEntry jarEntry = jarFile.getJarEntry("META-INF/INDEX.LIST");
            this.index = jarEntry == null ? null : IndexFile.readIndexFile(jarFile, jarEntry, url);
        }

        public URLJarHandler(URL url, URL url2, JarFile jarFile, String str, IndexFile indexFile) {
            super(url);
            this.subHandlers = new HashMap();
            this.jf = jarFile;
            this.prefixName = str;
            this.index = indexFile;
            this.codeSourceUrl = url2;
        }

        private Class<?> createClass(JarEntry jarEntry, Manifest manifest, String str, String str2) {
            try {
                byte[] readFully = Streams.readFully(this.jf.getInputStream(jarEntry));
                if (str != null) {
                    String replace = str.replace('/', '.');
                    Package r0 = URLClassLoader.this.getPackage(replace);
                    if (r0 != null) {
                        boolean isSealed = r0.isSealed();
                        boolean z = isSealed;
                        if (manifest != null) {
                            z = isSealed;
                            if (URLClassLoader.this.isSealed(manifest, str + BridgeUtil.SPLIT_MARK)) {
                                z = !r0.isSealed(this.codeSourceUrl);
                            }
                        }
                        if (z) {
                            throw new SecurityException(String.format("Package %s is sealed", str));
                        }
                    } else if (manifest != null) {
                        URLClassLoader.this.definePackage(replace, manifest, this.codeSourceUrl);
                    } else {
                        URLClassLoader.this.definePackage(replace, null, null, null, null, null, null, null);
                    }
                }
                return URLClassLoader.this.defineClass(str2, readFully, 0, readFully.length, new CodeSource(this.codeSourceUrl, jarEntry.getCertificates()));
            } catch (IOException e) {
                return null;
            }
        }

        private URLHandler createURLSubJarHandler(URL url) {
            String substring;
            String file = url.getFile();
            if (url.getFile().endsWith("!/")) {
                substring = "";
            } else {
                int lastIndexOf = file.lastIndexOf("!/");
                if (lastIndexOf == -1) {
                    return null;
                }
                substring = file.substring(lastIndexOf + 2);
            }
            try {
                URL jarFileURL = ((JarURLConnection) url.openConnection()).getJarFileURL();
                return new URLJarHandler(url, jarFileURL, ((JarURLConnection) new URL("jar", "", jarFileURL.toExternalForm() + "!/").openConnection()).getJarFile(), substring, null);
            } catch (IOException e) {
                return null;
            }
        }

        private URLHandler getSubHandler(URL url) {
            URLHandler uRLHandler;
            synchronized (this) {
                URLHandler uRLHandler2 = this.subHandlers.get(url);
                if (uRLHandler2 != null) {
                    uRLHandler = uRLHandler2;
                } else {
                    String protocol = url.getProtocol();
                    URLHandler createURLJarHandler = protocol.equals("jar") ? URLClassLoader.this.createURLJarHandler(url) : protocol.equals("file") ? createURLSubJarHandler(url) : URLClassLoader.this.createURLHandler(url);
                    if (createURLJarHandler != null) {
                        this.subHandlers.put(url, createURLJarHandler);
                    }
                    uRLHandler = createURLJarHandler;
                }
            }
            return uRLHandler;
        }

        @Override // java.net.URLClassLoader.URLHandler
        Class<?> findClass(String str, String str2, String str3) {
            Class<?> findClass;
            JarEntry jarEntry = this.jf.getJarEntry(this.prefixName + str2);
            if (jarEntry != null) {
                try {
                    return createClass(jarEntry, this.jf.getManifest(), str, str3);
                } catch (IOException e) {
                }
            }
            if (this.index != null) {
                ArrayList<URL> arrayList = str == null ? this.index.get(str2) : this.index.get(str);
                if (arrayList != null) {
                    arrayList.remove(this.url);
                    Iterator<URL> it = arrayList.iterator();
                    while (it.hasNext()) {
                        URLHandler subHandler = getSubHandler(it.next());
                        if (subHandler != null && (findClass = subHandler.findClass(str, str2, str3)) != null) {
                            return findClass;
                        }
                    }
                    return null;
                }
                return null;
            }
            return null;
        }

        @Override // java.net.URLClassLoader.URLHandler
        URL findResource(String str) {
            URL findResource;
            URL findResourceInOwn = findResourceInOwn(str);
            if (findResourceInOwn != null) {
                return findResourceInOwn;
            }
            if (this.index != null) {
                int lastIndexOf = str.lastIndexOf(BridgeUtil.SPLIT_MARK);
                ArrayList<URL> arrayList = this.index.get(lastIndexOf > 0 ? str.substring(0, lastIndexOf) : str);
                if (arrayList != null) {
                    arrayList.remove(this.url);
                    Iterator<URL> it = arrayList.iterator();
                    while (it.hasNext()) {
                        URLHandler subHandler = getSubHandler(it.next());
                        if (subHandler != null && (findResource = subHandler.findResource(str)) != null) {
                            return findResource;
                        }
                    }
                    return null;
                }
                return null;
            }
            return null;
        }

        URL findResourceInOwn(String str) {
            if (this.jf.getEntry(this.prefixName + str) != null) {
                return targetURL(this.url, str);
            }
            return null;
        }

        @Override // java.net.URLClassLoader.URLHandler
        void findResources(String str, ArrayList<URL> arrayList) {
            URL findResourceInOwn = findResourceInOwn(str);
            if (findResourceInOwn != null && !arrayList.contains(findResourceInOwn)) {
                arrayList.add(findResourceInOwn);
            }
            if (this.index != null) {
                int lastIndexOf = str.lastIndexOf(BridgeUtil.SPLIT_MARK);
                ArrayList<URL> arrayList2 = this.index.get(lastIndexOf > 0 ? str.substring(0, lastIndexOf) : str);
                if (arrayList2 != null) {
                    arrayList2.remove(this.url);
                    Iterator<URL> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        URLHandler subHandler = getSubHandler(it.next());
                        if (subHandler != null) {
                            subHandler.findResources(str, arrayList);
                        }
                    }
                }
            }
        }

        IndexFile getIndex() {
            return this.index;
        }
    }

    public URLClassLoader(URL[] urlArr) {
        this(urlArr, ClassLoader.getSystemClassLoader(), null);
    }

    public URLClassLoader(URL[] urlArr, ClassLoader classLoader) {
        this(urlArr, classLoader, null);
    }

    public URLClassLoader(URL[] urlArr, ClassLoader classLoader, URLStreamHandlerFactory uRLStreamHandlerFactory) {
        super(classLoader);
        this.handlerMap = new HashMap();
        this.factory = uRLStreamHandlerFactory;
        int length = urlArr.length;
        this.originalUrls = new ArrayList<>(length);
        this.handlerList = new ArrayList<>(length);
        this.searchList = Collections.synchronizedList(new ArrayList(length));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.originalUrls.add(urlArr[i2]);
            try {
                this.searchList.add(createSearchURL(urlArr[i2]));
            } catch (MalformedURLException e) {
            }
            i = i2 + 1;
        }
    }

    private URL createSearchURL(URL url) throws MalformedURLException {
        if (url != null) {
            String protocol = url.getProtocol();
            if (!isDirectory(url) && !protocol.equals("jar")) {
                return this.factory == null ? new URL("jar", "", -1, url.toString() + "!/") : new URL("jar", "", -1, url.toString() + "!/", this.factory.createURLStreamHandler("jar"));
            }
        }
        return url;
    }

    private URLHandler createURLFileHandler(URL url) {
        return new URLFileHandler(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public URLHandler createURLHandler(URL url) {
        return new URLHandler(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public URLHandler createURLJarHandler(URL url) {
        String substring;
        String value;
        String file = url.getFile();
        if (url.getFile().endsWith("!/")) {
            substring = "";
        } else {
            int lastIndexOf = file.lastIndexOf("!/");
            if (lastIndexOf == -1) {
                return null;
            }
            substring = file.substring(lastIndexOf + 2);
        }
        try {
            URL jarFileURL = ((JarURLConnection) url.openConnection()).getJarFileURL();
            JarFile jarFile = ((JarURLConnection) new URL("jar", "", jarFileURL.toExternalForm() + "!/").openConnection()).getJarFile();
            URLJarHandler uRLJarHandler = new URLJarHandler(url, jarFileURL, jarFile, substring);
            if (uRLJarHandler.getIndex() == null) {
                try {
                    Manifest manifest = jarFile.getManifest();
                    if (manifest != null && (value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH)) != null) {
                        this.searchList.addAll(0, getInternalURLs(url, value));
                    }
                } catch (IOException e) {
                    return uRLJarHandler;
                }
            }
            return uRLJarHandler;
        } catch (IOException e2) {
            return null;
        }
    }

    private URLHandler getHandler(int i) {
        if (i < this.handlerList.size()) {
            return this.handlerList.get(i);
        }
        makeNewHandler();
        if (i < this.handlerList.size()) {
            return this.handlerList.get(i);
        }
        return null;
    }

    private ArrayList<URL> getInternalURLs(URL url, String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        ArrayList<URL> arrayList = new ArrayList<>();
        String file = url.getFile();
        int lastIndexOf = file.lastIndexOf("!/") - 1;
        int lastIndexOf2 = file.lastIndexOf(BridgeUtil.SPLIT_MARK, lastIndexOf) + 1;
        int i = lastIndexOf2;
        if (lastIndexOf2 == 0) {
            i = file.lastIndexOf(System.getProperty("file.separator"), lastIndexOf) + 1;
        }
        String substring = file.substring(0, i);
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            if (!nextToken.isEmpty()) {
                try {
                    arrayList.add(createSearchURL(new URL(new URL(substring), nextToken)));
                } catch (MalformedURLException e) {
                }
            }
        }
        return arrayList;
    }

    private static boolean isDirectory(URL url) {
        String file = url.getFile();
        return file.length() > 0 && file.charAt(file.length() - 1) == '/';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSealed(Manifest manifest, String str) {
        String value;
        Attributes attributes = manifest.getAttributes(str);
        if (attributes == null || (value = attributes.getValue(Attributes.Name.SEALED)) == null) {
            String value2 = manifest.getMainAttributes().getValue(Attributes.Name.SEALED);
            return value2 != null && value2.equalsIgnoreCase("true");
        }
        return value.equalsIgnoreCase("true");
    }

    private void makeNewHandler() {
        synchronized (this) {
            while (true) {
                if (this.searchList.isEmpty()) {
                    break;
                }
                URL remove = this.searchList.remove(0);
                if (remove == null) {
                    throw new NullPointerException("nextCandidate == null");
                }
                if (!this.handlerMap.containsKey(remove)) {
                    String protocol = remove.getProtocol();
                    URLHandler createURLJarHandler = protocol.equals("jar") ? createURLJarHandler(remove) : protocol.equals("file") ? createURLFileHandler(remove) : createURLHandler(remove);
                    if (createURLJarHandler != null) {
                        this.handlerMap.put(remove, createURLJarHandler);
                        this.handlerList.add(createURLJarHandler);
                        break;
                    }
                }
            }
        }
    }

    public static URLClassLoader newInstance(URL[] urlArr) {
        return new URLClassLoader(urlArr, ClassLoader.getSystemClassLoader());
    }

    public static URLClassLoader newInstance(URL[] urlArr, ClassLoader classLoader) {
        return new URLClassLoader(urlArr, classLoader);
    }

    protected void addURL(URL url) {
        try {
            this.originalUrls.add(url);
            this.searchList.add(createSearchURL(url));
        } catch (MalformedURLException e) {
        }
    }

    protected Package definePackage(String str, Manifest manifest, URL url) throws IllegalArgumentException {
        Attributes mainAttributes = manifest.getMainAttributes();
        String str2 = str.replace('.', '/') + BridgeUtil.SPLIT_MARK;
        Attributes attributes = manifest.getAttributes(str2);
        boolean z = false;
        Attributes attributes2 = attributes;
        if (attributes == null) {
            z = true;
            attributes2 = mainAttributes;
        }
        String value = attributes2.getValue(Attributes.Name.SPECIFICATION_TITLE);
        String str3 = value;
        if (value == null) {
            str3 = value;
            if (!z) {
                str3 = mainAttributes.getValue(Attributes.Name.SPECIFICATION_TITLE);
            }
        }
        String value2 = attributes2.getValue(Attributes.Name.SPECIFICATION_VERSION);
        String str4 = value2;
        if (value2 == null) {
            str4 = value2;
            if (!z) {
                str4 = mainAttributes.getValue(Attributes.Name.SPECIFICATION_VERSION);
            }
        }
        String value3 = attributes2.getValue(Attributes.Name.SPECIFICATION_VENDOR);
        String str5 = value3;
        if (value3 == null) {
            str5 = value3;
            if (!z) {
                str5 = mainAttributes.getValue(Attributes.Name.SPECIFICATION_VENDOR);
            }
        }
        String value4 = attributes2.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
        String str6 = value4;
        if (value4 == null) {
            str6 = value4;
            if (!z) {
                str6 = mainAttributes.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
            }
        }
        String value5 = attributes2.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
        String str7 = value5;
        if (value5 == null) {
            str7 = value5;
            if (!z) {
                str7 = mainAttributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            }
        }
        String value6 = attributes2.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
        String str8 = value6;
        if (value6 == null) {
            str8 = value6;
            if (!z) {
                str8 = mainAttributes.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
            }
        }
        if (!isSealed(manifest, str2)) {
            url = null;
        }
        return definePackage(str, str3, str4, str5, str6, str7, str8, url);
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        String replace = str.replace('.', '/');
        String str2 = replace + ".class";
        String str3 = null;
        replace.lastIndexOf(47);
        int lastIndexOf = replace.lastIndexOf(47);
        if (lastIndexOf != -1) {
            str3 = replace.substring(0, lastIndexOf);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            URLHandler handler = getHandler(i2);
            if (handler == null) {
                throw new ClassNotFoundException(str);
            }
            Class<?> findClass = handler.findClass(str3, str2, str);
            if (findClass != null) {
                return findClass;
            }
            i = i2 + 1;
        }
    }

    @Override // java.lang.ClassLoader
    public URL findResource(String str) {
        URL url;
        if (str != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                URLHandler handler = getHandler(i2);
                if (handler != null) {
                    URL findResource = handler.findResource(str);
                    url = findResource;
                    if (findResource != null) {
                        break;
                    }
                    i = i2 + 1;
                } else {
                    return null;
                }
            }
        } else {
            url = null;
        }
        return url;
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) throws IOException {
        if (str == null) {
            return null;
        }
        ArrayList<URL> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            URLHandler handler = getHandler(i2);
            if (handler == null) {
                return Collections.enumeration(arrayList);
            }
            handler.findResources(str, arrayList);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureClassLoader
    public PermissionCollection getPermissions(CodeSource codeSource) {
        PermissionCollection permissions = super.getPermissions(codeSource);
        URL location = codeSource.getLocation();
        URL url = location;
        if (location.getProtocol().equals("jar")) {
            try {
                url = ((JarURLConnection) location.openConnection()).getJarFileURL();
            } catch (IOException e) {
                url = location;
            }
        }
        if (!url.getProtocol().equals("file")) {
            String host = url.getHost();
            String str = host;
            if (host.length() == 0) {
                str = "localhost";
            }
            permissions.add(new SocketPermission(str, "connect, accept"));
            return permissions;
        }
        String file = url.getFile();
        String host2 = url.getHost();
        String str2 = file;
        if (host2 != null) {
            str2 = file;
            if (host2.length() > 0) {
                str2 = "//" + host2 + file;
            }
        }
        String str3 = str2;
        if (File.separatorChar != '/') {
            str3 = str2.replace('/', File.separatorChar);
        }
        if (isDirectory(url)) {
            permissions.add(new FilePermission(str3 + NativeLibraryHelper.CLEAR_ABI_OVERRIDE, "read"));
            return permissions;
        }
        permissions.add(new FilePermission(str3, "read"));
        return permissions;
    }

    public URL[] getURLs() {
        return (URL[]) this.originalUrls.toArray(new URL[this.originalUrls.size()]);
    }
}
