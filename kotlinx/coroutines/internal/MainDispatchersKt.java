package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/MainDispatchersKt.class */
public final class MainDispatchersKt {

    /* renamed from: a */
    private static final boolean f43553a = true;

    public static final Void a() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final MainCoroutineDispatcher a(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, mainDispatcherFactory.hintOnError());
        }
    }

    private static final MissingMainCoroutineDispatcher a(Throwable th, String str) {
        if (f43553a) {
            return new MissingMainCoroutineDispatcher(th, str);
        }
        if (th == null) {
            a();
            throw new KotlinNothingValueException();
        }
        throw th;
    }

    public static /* synthetic */ MissingMainCoroutineDispatcher a(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }
}
