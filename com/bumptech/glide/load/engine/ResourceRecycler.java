package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/ResourceRecycler.class */
class ResourceRecycler {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20795a;
    private final Handler b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/ResourceRecycler$ResourceRecyclerCallback.class */
    static final class ResourceRecyclerCallback implements Handler.Callback {
        ResourceRecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((Resource) message.obj).c();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Resource<?> resource, boolean z) {
        synchronized (this) {
            if (this.f20795a || z) {
                this.b.obtainMessage(1, resource).sendToTarget();
            } else {
                this.f20795a = true;
                resource.c();
                this.f20795a = false;
            }
        }
    }
}
