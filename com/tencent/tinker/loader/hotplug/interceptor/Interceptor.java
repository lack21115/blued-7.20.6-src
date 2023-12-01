package com.tencent.tinker.loader.hotplug.interceptor;

import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/interceptor/Interceptor.class */
public abstract class Interceptor<T_TARGET> {
    private static final String TAG = "Tinker.Interceptor";
    private T_TARGET mTarget = null;
    private volatile boolean mInstalled = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/interceptor/Interceptor$ITinkerHotplugProxy.class */
    public interface ITinkerHotplugProxy {
    }

    protected T_TARGET decorate(T_TARGET t_target) throws Throwable {
        return t_target;
    }

    protected abstract T_TARGET fetchTarget() throws Throwable;

    protected abstract void inject(T_TARGET t_target) throws Throwable;

    public void install() throws InterceptFailedException {
        synchronized (this) {
            try {
                T_TARGET fetchTarget = fetchTarget();
                this.mTarget = fetchTarget;
                T_TARGET decorate = decorate(fetchTarget);
                if (decorate != fetchTarget) {
                    inject(decorate);
                } else {
                    ShareTinkerLog.w(TAG, "target: " + fetchTarget + " was already hooked.", new Object[0]);
                }
                this.mInstalled = true;
            } catch (Throwable th) {
                this.mTarget = null;
                throw new InterceptFailedException(th);
            }
        }
    }

    public void uninstall() throws InterceptFailedException {
        synchronized (this) {
            if (this.mInstalled) {
                inject(this.mTarget);
                this.mTarget = null;
                this.mInstalled = false;
            }
        }
    }
}
