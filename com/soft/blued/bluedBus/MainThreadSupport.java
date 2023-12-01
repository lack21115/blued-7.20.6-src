package com.soft.blued.bluedBus;

import android.os.Looper;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/bluedBus/MainThreadSupport.class */
public interface MainThreadSupport {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/bluedBus/MainThreadSupport$AndroidHandlerMainThreadSupport.class */
    public static class AndroidHandlerMainThreadSupport implements MainThreadSupport {

        /* renamed from: a  reason: collision with root package name */
        private final Looper f14611a;

        public AndroidHandlerMainThreadSupport(Looper looper) {
            this.f14611a = looper;
        }

        @Override // com.soft.blued.bluedBus.MainThreadSupport
        public Poster a(BluedBus bluedBus) {
            return new HandlerPoster(bluedBus, this.f14611a, 10);
        }
    }

    Poster a(BluedBus bluedBus);
}
