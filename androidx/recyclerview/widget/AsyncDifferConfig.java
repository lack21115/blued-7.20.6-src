package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AsyncDifferConfig.class */
public final class AsyncDifferConfig<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3166a;
    private final Executor b;

    /* renamed from: c  reason: collision with root package name */
    private final DiffUtil.ItemCallback<T> f3167c;

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AsyncDifferConfig$Builder.class */
    public static final class Builder<T> {
        private static final Object d = new Object();
        private static Executor e = null;

        /* renamed from: a  reason: collision with root package name */
        private Executor f3168a;
        private Executor b;

        /* renamed from: c  reason: collision with root package name */
        private final DiffUtil.ItemCallback<T> f3169c;

        public Builder(DiffUtil.ItemCallback<T> itemCallback) {
            this.f3169c = itemCallback;
        }

        public AsyncDifferConfig<T> build() {
            if (this.b == null) {
                synchronized (d) {
                    if (e == null) {
                        e = Executors.newFixedThreadPool(2);
                    }
                }
                this.b = e;
            }
            return new AsyncDifferConfig<>(this.f3168a, this.b, this.f3169c);
        }

        public Builder<T> setBackgroundThreadExecutor(Executor executor) {
            this.b = executor;
            return this;
        }

        public Builder<T> setMainThreadExecutor(Executor executor) {
            this.f3168a = executor;
            return this;
        }
    }

    AsyncDifferConfig(Executor executor, Executor executor2, DiffUtil.ItemCallback<T> itemCallback) {
        this.f3166a = executor;
        this.b = executor2;
        this.f3167c = itemCallback;
    }

    public Executor getBackgroundThreadExecutor() {
        return this.b;
    }

    public DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.f3167c;
    }

    public Executor getMainThreadExecutor() {
        return this.f3166a;
    }
}
