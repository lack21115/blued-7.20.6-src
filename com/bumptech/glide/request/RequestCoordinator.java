package com.bumptech.glide.request;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/RequestCoordinator.class */
public interface RequestCoordinator {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/RequestCoordinator$RequestState.class */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        private final boolean f;

        RequestState(boolean z) {
            this.f = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f;
        }
    }

    boolean b(Request request);

    boolean c(Request request);

    boolean d(Request request);

    void e(Request request);

    void f(Request request);

    boolean g();

    RequestCoordinator h();
}
