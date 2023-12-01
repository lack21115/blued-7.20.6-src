package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Dispatchers.class */
public final class Dispatchers {

    /* renamed from: a  reason: collision with root package name */
    public static final Dispatchers f42810a = new Dispatchers();
    private static final CoroutineDispatcher b = CoroutineContextKt.a();

    /* renamed from: c  reason: collision with root package name */
    private static final CoroutineDispatcher f42811c = Unconfined.b;
    private static final CoroutineDispatcher d = DefaultScheduler.b.b();

    private Dispatchers() {
    }

    public static final CoroutineDispatcher a() {
        return b;
    }

    public static final MainCoroutineDispatcher b() {
        return MainDispatcherLoader.b;
    }

    public static final CoroutineDispatcher c() {
        return d;
    }
}
