package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/MainDispatcherFactory.class */
public interface MainDispatcherFactory {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/MainDispatcherFactory$DefaultImpls.class */
    public static final class DefaultImpls {
        public static String a(MainDispatcherFactory mainDispatcherFactory) {
            return null;
        }
    }

    MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
