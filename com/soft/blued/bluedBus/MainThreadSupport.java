package com.soft.blued.bluedBus;

import android.os.Looper;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/bluedBus/MainThreadSupport.class */
public interface MainThreadSupport {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/bluedBus/MainThreadSupport$AndroidHandlerMainThreadSupport.class */
    public static class AndroidHandlerMainThreadSupport implements MainThreadSupport {

        /* renamed from: a  reason: collision with root package name */
        private final Looper f28301a;

        public AndroidHandlerMainThreadSupport(Looper looper) {
            this.f28301a = looper;
        }

        @Override // com.soft.blued.bluedBus.MainThreadSupport
        public Poster a(BluedBus bluedBus) {
            return new HandlerPoster(bluedBus, this.f28301a, 10);
        }
    }

    Poster a(BluedBus bluedBus);
}
