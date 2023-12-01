package kotlin.internal.jdk7;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/internal/jdk7/JDK7PlatformImplementations.class */
public class JDK7PlatformImplementations extends PlatformImplementations {

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion.class */
    public static final class ReflectSdkVersion {

        /* renamed from: a  reason: collision with root package name */
        public static final ReflectSdkVersion f42481a = new ReflectSdkVersion();
        public static final Integer b;

        static {
            Integer num;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable th) {
                num = null;
            }
            Integer num2 = null;
            if (num != null) {
                num2 = null;
                if (num.intValue() > 0) {
                    num2 = num;
                }
            }
            b = num2;
        }

        private ReflectSdkVersion() {
        }
    }

    private final boolean a(int i) {
        return ReflectSdkVersion.b == null || ReflectSdkVersion.b.intValue() >= i;
    }

    @Override // kotlin.internal.PlatformImplementations
    public void a(Throwable cause, Throwable exception) {
        Intrinsics.e(cause, "cause");
        Intrinsics.e(exception, "exception");
        if (a(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
