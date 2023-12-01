package io.grpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ServiceProviders.class */
final class ServiceProviders {

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ServiceProviders$PriorityAccessor.class */
    public interface PriorityAccessor<T> {
        int getPriority(T t);

        boolean isAvailable(T t);
    }

    private ServiceProviders() {
    }

    static <T> T create(Class<T> cls, Class<?> cls2) {
        try {
            return (T) cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> cls, Iterable<Class<?>> iterable) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls2 : iterable) {
            arrayList.add(create(cls, cls2));
        }
        return arrayList;
    }

    public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> cls, ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        ServiceLoader serviceLoader = load;
        if (!load.iterator().hasNext()) {
            serviceLoader = ServiceLoader.load(cls);
        }
        return serviceLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAndroid(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static <T> T load(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, PriorityAccessor<T> priorityAccessor) {
        List loadAll = loadAll(cls, iterable, classLoader, priorityAccessor);
        if (loadAll.isEmpty()) {
            return null;
        }
        return (T) loadAll.get(0);
    }

    public static <T> List<T> loadAll(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, final PriorityAccessor<T> priorityAccessor) {
        Iterable candidatesViaHardCoded = isAndroid(classLoader) ? getCandidatesViaHardCoded(cls, iterable) : getCandidatesViaServiceLoader(cls, classLoader);
        ArrayList arrayList = new ArrayList();
        for (T t : candidatesViaHardCoded) {
            if (priorityAccessor.isAvailable(t)) {
                arrayList.add(t);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<T>() { // from class: io.grpc.ServiceProviders.1
            @Override // java.util.Comparator
            public int compare(T t2, T t3) {
                int priority = PriorityAccessor.this.getPriority(t2) - PriorityAccessor.this.getPriority(t3);
                return priority != 0 ? priority : t2.getClass().getName().compareTo(t3.getClass().getName());
            }
        }));
        return Collections.unmodifiableList(arrayList);
    }
}
