package javax.xml.datatype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Properties;
import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/datatype/FactoryFinder.class */
final class FactoryFinder {
    private static final String CLASS_NAME = "javax.xml.datatype.FactoryFinder";
    private static final int DEFAULT_LINE_LENGTH = 80;
    private static boolean debug;
    private static Properties cacheProps = new Properties();
    private static boolean firstTime = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:javax/xml/datatype/FactoryFinder$ConfigurationError.class */
    public static class ConfigurationError extends Error {
        private static final long serialVersionUID = -3644413026244211347L;
        private Exception exception;

        ConfigurationError(String str, Exception exc) {
            super(str);
            this.exception = exc;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Exception getException() {
            return this.exception;
        }
    }

    static {
        boolean z = true;
        debug = false;
        String property = System.getProperty("jaxp.debug");
        if (property == null || "false".equals(property)) {
            z = false;
        }
        debug = z;
    }

    private FactoryFinder() {
    }

    private static void debugPrintln(String str) {
        if (debug) {
            System.err.println("javax.xml.datatype.FactoryFinder:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object find(String str, String str2) throws ConfigurationError {
        Object obj;
        ClassLoader findClassLoader = findClassLoader();
        String property = System.getProperty(str);
        if (property == null || property.length() <= 0) {
            try {
                String str3 = System.getProperty("java.home") + File.separator + "lib" + File.separator + "jaxp.properties";
                if (firstTime) {
                    synchronized (cacheProps) {
                        if (firstTime) {
                            File file = new File(str3);
                            firstTime = false;
                            if (file.exists()) {
                                if (debug) {
                                    debugPrintln("Read properties file " + file);
                                }
                                cacheProps.load(new FileInputStream(file));
                            }
                        }
                    }
                }
                String property2 = cacheProps.getProperty(str);
                if (debug) {
                    debugPrintln("found " + property2 + " in $java.home/jaxp.properties");
                }
                if (property2 != null) {
                    return newInstance(property2, findClassLoader);
                }
            } catch (Exception e) {
                if (debug) {
                    e.printStackTrace();
                }
            }
            Object findJarServiceProvider = findJarServiceProvider(str);
            obj = findJarServiceProvider;
            if (findJarServiceProvider == null) {
                if (str2 == null) {
                    throw new ConfigurationError("Provider for " + str + " cannot be found", null);
                }
                if (debug) {
                    debugPrintln("loaded from fallback value: " + str2);
                }
                return newInstance(str2, findClassLoader);
            }
        } else {
            if (debug) {
                debugPrintln("found " + property + " in the system property " + str);
            }
            obj = newInstance(property, findClassLoader);
        }
        return obj;
    }

    private static ClassLoader findClassLoader() throws ConfigurationError {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (debug) {
            debugPrintln("Using context class loader: " + contextClassLoader);
        }
        ClassLoader classLoader = contextClassLoader;
        if (contextClassLoader == null) {
            ClassLoader classLoader2 = FactoryFinder.class.getClassLoader();
            classLoader = classLoader2;
            if (debug) {
                debugPrintln("Using the class loader of FactoryFinder: " + classLoader2);
                classLoader = classLoader2;
            }
        }
        return classLoader;
    }

    private static Object findJarServiceProvider(String str) throws ConfigurationError {
        BufferedReader bufferedReader;
        String str2 = "META-INF/services/" + str;
        InputStream inputStream = null;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            inputStream = contextClassLoader.getResourceAsStream(str2);
        }
        InputStream inputStream2 = inputStream;
        if (inputStream == null) {
            contextClassLoader = FactoryFinder.class.getClassLoader();
            inputStream2 = contextClassLoader.getResourceAsStream(str2);
        }
        if (inputStream2 == null) {
            return null;
        }
        if (debug) {
            debugPrintln("found jar resource=" + str2 + " using ClassLoader: " + contextClassLoader);
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"), 80);
        } catch (UnsupportedEncodingException e) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream2), 80);
        }
        try {
            String readLine = bufferedReader.readLine();
            IoUtils.closeQuietly(bufferedReader);
            if (readLine == null || "".equals(readLine)) {
                return null;
            }
            if (debug) {
                debugPrintln("found in resource, value=" + readLine);
            }
            return newInstance(readLine, contextClassLoader);
        } catch (IOException e2) {
            IoUtils.closeQuietly(bufferedReader);
            return null;
        } catch (Throwable th) {
            IoUtils.closeQuietly(bufferedReader);
            throw th;
        }
    }

    static Object newInstance(String str, ClassLoader classLoader) throws ConfigurationError {
        try {
            Class<?> cls = classLoader == null ? Class.forName(str) : classLoader.loadClass(str);
            if (debug) {
                debugPrintln("Loaded " + str + " from " + which(cls));
            }
            return cls.newInstance();
        } catch (ClassNotFoundException e) {
            throw new ConfigurationError("Provider " + str + " not found", e);
        } catch (Exception e2) {
            throw new ConfigurationError("Provider " + str + " could not be instantiated: " + e2, e2);
        }
    }

    private static String which(Class cls) {
        try {
            String str = cls.getName().replace('.', '/') + ".class";
            ClassLoader classLoader = cls.getClassLoader();
            URL resource = classLoader != null ? classLoader.getResource(str) : ClassLoader.getSystemResource(str);
            return resource != null ? resource.toString() : "unknown location";
        } catch (ThreadDeath e) {
            throw e;
        } catch (VirtualMachineError e2) {
            throw e2;
        } catch (Throwable th) {
            if (debug) {
                th.printStackTrace();
                return "unknown location";
            }
            return "unknown location";
        }
    }
}
