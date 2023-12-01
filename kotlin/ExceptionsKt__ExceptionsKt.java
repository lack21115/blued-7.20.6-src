package kotlin;

import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ExceptionsKt__ExceptionsKt.class */
public class ExceptionsKt__ExceptionsKt {
    public static final void a(Throwable th, Throwable exception) {
        Intrinsics.e(th, "<this>");
        Intrinsics.e(exception, "exception");
        if (th != exception) {
            PlatformImplementationsKt.f42478a.a(th, exception);
        }
    }
}
