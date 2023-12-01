package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/MissingMainCoroutineDispatcherFactory.class */
public final class MissingMainCoroutineDispatcherFactory implements MainDispatcherFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final MissingMainCoroutineDispatcherFactory f43555a = new MissingMainCoroutineDispatcherFactory();

    private MissingMainCoroutineDispatcherFactory() {
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> list) {
        return new MissingMainCoroutineDispatcher(null, null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return -1;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return MainDispatcherFactory.DefaultImpls.a(this);
    }
}
