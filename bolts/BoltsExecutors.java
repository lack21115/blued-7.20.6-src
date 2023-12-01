package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8756600-dex2jar.jar:bolts/BoltsExecutors.class */
final class BoltsExecutors {

    /* renamed from: a  reason: collision with root package name */
    private static final BoltsExecutors f3635a = new BoltsExecutors();
    private final ExecutorService b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f3636c;
    private final Executor d;

    /* loaded from: source-8756600-dex2jar.jar:bolts/BoltsExecutors$ImmediateExecutor.class */
    static class ImmediateExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private ThreadLocal<Integer> f3637a;

        private ImmediateExecutor() {
            this.f3637a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.f3637a.get();
            Integer num2 = num;
            if (num == null) {
                num2 = 0;
            }
            int intValue = num2.intValue() + 1;
            this.f3637a.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int b() {
            Integer num = this.f3637a.get();
            Integer num2 = num;
            if (num == null) {
                num2 = 0;
            }
            int intValue = num2.intValue() - 1;
            if (intValue == 0) {
                this.f3637a.remove();
                return intValue;
            }
            this.f3637a.set(Integer.valueOf(intValue));
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (a() <= 15) {
                    runnable.run();
                } else {
                    BoltsExecutors.a().execute(runnable);
                }
            } finally {
                b();
            }
        }
    }

    private BoltsExecutors() {
        this.b = !d() ? Executors.newCachedThreadPool() : AndroidExecutors.a();
        this.f3636c = Executors.newSingleThreadScheduledExecutor();
        this.d = new ImmediateExecutor();
    }

    public static ExecutorService a() {
        return f3635a.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ScheduledExecutorService b() {
        return f3635a.f3636c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor c() {
        return f3635a.d;
    }

    private static boolean d() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }
}
