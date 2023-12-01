package com.bumptech.glide.util.pool;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/pool/StateVerifier.class */
public abstract class StateVerifier {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/pool/StateVerifier$DebugStateVerifier.class */
    static class DebugStateVerifier extends StateVerifier {

        /* renamed from: a  reason: collision with root package name */
        private volatile RuntimeException f7509a;

        DebugStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        void a(boolean z) {
            if (z) {
                this.f7509a = new RuntimeException("Released");
            } else {
                this.f7509a = null;
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void b() {
            if (this.f7509a != null) {
                throw new IllegalStateException("Already released", this.f7509a);
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/pool/StateVerifier$DefaultStateVerifier.class */
    static class DefaultStateVerifier extends StateVerifier {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f7510a;

        DefaultStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void a(boolean z) {
            this.f7510a = z;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void b() {
            if (this.f7510a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private StateVerifier() {
    }

    public static StateVerifier a() {
        return new DefaultStateVerifier();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(boolean z);

    public abstract void b();
}
