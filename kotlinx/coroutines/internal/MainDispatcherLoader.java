package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/MainDispatcherLoader.class */
public final class MainDispatcherLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final MainDispatcherLoader f43551a = new MainDispatcherLoader();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f43552c = SystemPropsKt.a("kotlinx.coroutines.fast.service.loader", true);
    public static final MainCoroutineDispatcher b = f43551a.a();

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher a() {
        Object next;
        try {
            List<MainDispatcherFactory> a2 = f43552c ? FastServiceLoader.f43534a.a() : SequencesKt.d(SequencesKt.a(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            Iterator<E> it = a2.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    Object obj = next;
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        next = obj;
                        int i = loadPriority;
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            i = loadPriority2;
                        }
                        obj = next;
                        loadPriority = i;
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return mainDispatcherFactory == null ? MainDispatchersKt.a(null, null, 3, null) : MainDispatchersKt.a(mainDispatcherFactory, a2);
        } catch (Throwable th) {
            return MainDispatchersKt.a(th, null, 2, null);
        }
    }
}
