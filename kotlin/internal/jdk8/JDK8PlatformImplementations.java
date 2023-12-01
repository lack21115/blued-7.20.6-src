package kotlin.internal.jdk8;

import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/internal/jdk8/JDK8PlatformImplementations.class */
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion.class */
    public static final class ReflectSdkVersion {
        public static final ReflectSdkVersion a = new ReflectSdkVersion();
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
    public Random a() {
        return a(24) ? new PlatformThreadLocalRandom() : super.a();
    }
}
