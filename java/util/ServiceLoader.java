package java.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:java/util/ServiceLoader.class */
public final class ServiceLoader<S> implements Iterable<S> {
    private final ClassLoader classLoader;
    private final Class<S> service;
    private final Set<URL> services;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/ServiceLoader$ServiceIterator.class */
    public class ServiceIterator implements Iterator<S> {
        private final ClassLoader classLoader;
        private boolean isRead = false;
        private LinkedList<String> queue = new LinkedList<>();
        private final Class<S> service;
        private final Set<URL> services;

        public ServiceIterator(ServiceLoader<S> serviceLoader) {
            this.classLoader = ((ServiceLoader) serviceLoader).classLoader;
            this.service = ((ServiceLoader) serviceLoader).service;
            this.services = ((ServiceLoader) serviceLoader).services;
        }

        private void checkValidJavaClassName(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= str.length()) {
                    return;
                }
                char charAt = str.charAt(i2);
                if (!Character.isJavaIdentifierPart(charAt) && charAt != '.') {
                    throw new ServiceConfigurationError("Bad character '" + charAt + "' in class name");
                }
                i = i2 + 1;
            }
        }

        private void readClass() {
            for (URL url : this.services) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                int indexOf = readLine.indexOf(35);
                                String str = readLine;
                                if (indexOf != -1) {
                                    str = readLine.substring(0, indexOf);
                                }
                                String trim = str.trim();
                                if (!trim.isEmpty()) {
                                    checkValidJavaClassName(trim);
                                    if (!this.queue.contains(trim)) {
                                        this.queue.add(trim);
                                    }
                                }
                            } catch (Exception e) {
                                bufferedReader = bufferedReader2;
                                e = e;
                                throw new ServiceConfigurationError("Couldn't read " + url, e);
                            } catch (Throwable th) {
                                bufferedReader = bufferedReader2;
                                th = th;
                                IoUtils.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        this.isRead = true;
                        IoUtils.closeQuietly(bufferedReader2);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.isRead) {
                readClass();
            }
            return (this.queue == null || this.queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public S next() {
            if (hasNext()) {
                String remove = this.queue.remove();
                try {
                    return this.service.cast(this.classLoader.loadClass(remove).newInstance());
                } catch (Exception e) {
                    throw new ServiceConfigurationError("Couldn't instantiate class " + remove, e);
                }
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private ServiceLoader(Class<S> cls, ClassLoader classLoader) {
        if (cls == null) {
            throw new NullPointerException("service == null");
        }
        this.service = cls;
        this.classLoader = classLoader;
        this.services = new HashSet();
        reload();
    }

    private void internalLoad() {
        this.services.clear();
        try {
            this.services.addAll(Collections.list(this.classLoader.getResources("META-INF/services/" + this.service.getName())));
        } catch (IOException e) {
        }
    }

    public static <S> ServiceLoader<S> load(Class<S> cls) {
        return load(cls, Thread.currentThread().getContextClassLoader());
    }

    public static <S> ServiceLoader<S> load(Class<S> cls, ClassLoader classLoader) {
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = ClassLoader.getSystemClassLoader();
        }
        return new ServiceLoader<>(cls, classLoader2);
    }

    public static <S> S loadFromSystemProperty(Class<S> cls) {
        try {
            String property = System.getProperty(cls.getName());
            if (property != null) {
                return (S) ClassLoader.getSystemClassLoader().loadClass(property).newInstance();
            }
            return null;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static <S> ServiceLoader<S> loadInstalled(Class<S> cls) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader classLoader = systemClassLoader;
        if (systemClassLoader != null) {
            while (true) {
                classLoader = systemClassLoader;
                if (systemClassLoader.getParent() == null) {
                    break;
                }
                systemClassLoader = systemClassLoader.getParent();
            }
        }
        return load(cls, classLoader);
    }

    @Override // java.lang.Iterable
    public Iterator<S> iterator() {
        return new ServiceIterator(this);
    }

    public void reload() {
        internalLoad();
    }

    public String toString() {
        return "ServiceLoader for " + this.service.getName();
    }
}
