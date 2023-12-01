package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ConcurrentKt.class */
public final class ConcurrentKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f43519a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable th) {
            method = null;
        }
        f43519a = method;
    }
}
