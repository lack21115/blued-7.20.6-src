package javax.xml.xpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import libcore.io.IoUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:javax/xml/xpath/XPathFactoryFinder.class */
public final class XPathFactoryFinder {
    private static final int DEFAULT_LINE_LENGTH = 80;
    private static final Class SERVICE_CLASS;
    private static final String SERVICE_ID;
    private static Properties cacheProps;
    private static boolean debug;
    private static boolean firstTime;
    private final ClassLoader classLoader;

    static {
        debug = false;
        String property = System.getProperty("jaxp.debug");
        boolean z = false;
        if (property != null) {
            z = false;
            if (!"false".equals(property)) {
                z = true;
            }
        }
        debug = z;
        cacheProps = new Properties();
        firstTime = true;
        SERVICE_CLASS = XPathFactory.class;
        SERVICE_ID = "META-INF/services/" + SERVICE_CLASS.getName();
    }

    public XPathFactoryFinder(ClassLoader classLoader) {
        this.classLoader = classLoader;
        if (debug) {
            debugDisplayClassLoader();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x013f, code lost:
        if (r0 == null) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private javax.xml.xpath.XPathFactory _newFactory(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.xml.xpath.XPathFactoryFinder._newFactory(java.lang.String):javax.xml.xpath.XPathFactory");
    }

    private Iterable<URL> createServiceFileIterator() {
        if (this.classLoader == null) {
            return Collections.singleton(XPathFactoryFinder.class.getClassLoader().getResource(SERVICE_ID));
        }
        try {
            Enumeration<URL> resources = this.classLoader.getResources(SERVICE_ID);
            if (debug && !resources.hasMoreElements()) {
                debugPrintln("no " + SERVICE_ID + " file was found");
            }
            return Collections.list(resources);
        } catch (IOException e) {
            if (debug) {
                debugPrintln("failed to enumerate resources " + SERVICE_ID);
                e.printStackTrace();
            }
            return Collections.emptySet();
        }
    }

    private void debugDisplayClassLoader() {
        if (this.classLoader == Thread.currentThread().getContextClassLoader()) {
            debugPrintln("using thread context class loader (" + this.classLoader + ") for search");
        } else if (this.classLoader == ClassLoader.getSystemClassLoader()) {
            debugPrintln("using system class loader (" + this.classLoader + ") for search");
        } else {
            debugPrintln("using class loader (" + this.classLoader + ") for search");
        }
    }

    private static void debugPrintln(String str) {
        if (debug) {
            System.err.println("JAXP: " + str);
        }
    }

    private XPathFactory loadFromServicesFile(String str, String str2, InputStream inputStream) {
        BufferedReader bufferedReader;
        XPathFactory xPathFactory;
        if (debug) {
            debugPrintln("Reading " + str2);
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 80);
        } catch (UnsupportedEncodingException e) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 80);
        }
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                xPathFactory = null;
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf(35);
                String str3 = readLine;
                if (indexOf != -1) {
                    str3 = readLine.substring(0, indexOf);
                }
                String trim = str3.trim();
                if (trim.length() != 0) {
                    try {
                        xPathFactory = createInstance(trim);
                        if (xPathFactory.isObjectModelSupported(str)) {
                            break;
                        }
                    } catch (Exception e2) {
                    }
                }
            } catch (IOException e3) {
                xPathFactory = null;
            }
        }
        IoUtils.closeQuietly(bufferedReader);
        return xPathFactory;
    }

    private static String which(Class cls) {
        return which(cls.getName(), cls.getClassLoader());
    }

    private static String which(String str, ClassLoader classLoader) {
        String str2 = str.replace('.', '/') + ".class";
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = ClassLoader.getSystemClassLoader();
        }
        URL resource = classLoader2.getResource(str2);
        if (resource != null) {
            return resource.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPathFactory createInstance(String str) {
        try {
            if (debug) {
                debugPrintln("instantiating " + str);
            }
            Class<?> loadClass = this.classLoader != null ? this.classLoader.loadClass(str) : Class.forName(str);
            if (debug) {
                debugPrintln("loaded it from " + which(loadClass));
            }
            Object newInstance = loadClass.newInstance();
            if (newInstance instanceof XPathFactory) {
                return (XPathFactory) newInstance;
            }
            if (debug) {
                debugPrintln(str + " is not assignable to " + SERVICE_CLASS.getName());
                return null;
            }
            return null;
        } catch (ThreadDeath e) {
            throw e;
        } catch (VirtualMachineError e2) {
            throw e2;
        } catch (Throwable th) {
            if (debug) {
                debugPrintln("failed to instantiate " + str);
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public XPathFactory newFactory(String str) {
        if (str == null) {
            throw new NullPointerException("uri == null");
        }
        XPathFactory _newFactory = _newFactory(str);
        if (debug) {
            if (_newFactory == null) {
                debugPrintln("unable to find a factory for " + str);
                return _newFactory;
            }
            debugPrintln("factory '" + _newFactory.getClass().getName() + "' was found for " + str);
        }
        return _newFactory;
    }
}
