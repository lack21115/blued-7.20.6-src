package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt.class */
public final /* synthetic */ class SystemPropsKt__SystemPropsKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f43564a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f43564a;
    }

    public static final String a(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException e) {
            return null;
        }
    }
}
