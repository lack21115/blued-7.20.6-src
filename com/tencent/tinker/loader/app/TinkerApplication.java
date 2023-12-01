package com.tencent.tinker.loader.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.TinkerUncaughtHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.lang.reflect.Constructor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/app/TinkerApplication.class */
public abstract class TinkerApplication extends Application {
    private static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
    private static final TinkerApplication[] SELF_HOLDER = {null};
    private static final String TINKER_LOADER_METHOD = "tryLoad";
    private final String delegateClassName;
    private final String loaderClassName;
    protected ClassLoader mCurrentClassLoader;
    private Handler mInlineFence;
    private final int tinkerFlags;
    private final boolean tinkerLoadVerifyFlag;
    protected Intent tinkerResultIntent;
    private final boolean useDelegateLastClassLoader;
    private boolean useSafeMode;

    protected TinkerApplication(int i) {
        this(i, "com.tencent.tinker.entry.DefaultApplicationLike", TinkerLoader.class.getName(), false, false);
    }

    protected TinkerApplication(int i, String str) {
        this(i, str, TinkerLoader.class.getName(), false, false);
    }

    public TinkerApplication(int i, String str, String str2, boolean z) {
        this(i, str, str2, z, true);
    }

    protected TinkerApplication(int i, String str, String str2, boolean z, boolean z2) {
        this.mCurrentClassLoader = null;
        this.mInlineFence = null;
        synchronized (SELF_HOLDER) {
            SELF_HOLDER[0] = this;
        }
        this.tinkerFlags = i;
        this.delegateClassName = str;
        this.loaderClassName = str2;
        this.tinkerLoadVerifyFlag = z;
        this.useDelegateLastClassLoader = z2;
    }

    private Handler createInlineFence(Application application, int i, String str, boolean z, long j, long j2, Intent intent) {
        try {
            Object newInstance = Class.forName(str, false, this.mCurrentClassLoader).getConstructor(Application.class, Integer.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, Intent.class).newInstance(application, Integer.valueOf(i), Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), intent);
            Constructor<?> constructor = Class.forName("com.tencent.tinker.entry.TinkerApplicationInlineFence", false, this.mCurrentClassLoader).getConstructor(Class.forName("com.tencent.tinker.entry.ApplicationLike", false, this.mCurrentClassLoader));
            constructor.setAccessible(true);
            return (Handler) constructor.newInstance(newInstance);
        } catch (Throwable th) {
            throw new TinkerRuntimeException("createInlineFence failed", th);
        }
    }

    public static TinkerApplication getInstance() {
        TinkerApplication tinkerApplication;
        synchronized (SELF_HOLDER) {
            if (SELF_HOLDER[0] == null) {
                throw new IllegalStateException("TinkerApplication is not initialized.");
            }
            tinkerApplication = SELF_HOLDER[0];
        }
        return tinkerApplication;
    }

    private void loadTinker() {
        try {
            Class<?> cls = Class.forName(this.loaderClassName, false, TinkerApplication.class.getClassLoader());
            this.tinkerResultIntent = (Intent) cls.getMethod(TINKER_LOADER_METHOD, TinkerApplication.class).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), this);
        } catch (Throwable th) {
            Intent intent = new Intent();
            this.tinkerResultIntent = intent;
            ShareIntentUtil.setIntentReturnCode(intent, -20);
            this.tinkerResultIntent.putExtra("intent_patch_exception", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        Thread.setDefaultUncaughtExceptionHandler(new TinkerUncaughtHandler(this));
        onBaseContextAttached(context, elapsedRealtime, currentTimeMillis);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        AssetManager assets = super.getAssets();
        Handler handler = this.mInlineFence;
        return handler == null ? assets : TinkerInlineFenceAction.callGetAssets(handler, assets);
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        Context baseContext = super.getBaseContext();
        Handler handler = this.mInlineFence;
        return handler == null ? baseContext : TinkerInlineFenceAction.callGetBaseContext(handler, baseContext);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        ClassLoader classLoader = super.getClassLoader();
        Handler handler = this.mInlineFence;
        return handler == null ? classLoader : TinkerInlineFenceAction.callGetClassLoader(handler, classLoader);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Handler handler = this.mInlineFence;
        return handler == null ? resources : TinkerInlineFenceAction.callGetResources(handler, resources);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        Handler handler = this.mInlineFence;
        return handler == null ? systemService : TinkerInlineFenceAction.callGetSystemService(handler, str, systemService);
    }

    public int getTinkerFlags() {
        return this.tinkerFlags;
    }

    public boolean isTinkerLoadVerifyFlag() {
        return this.tinkerLoadVerifyFlag;
    }

    public boolean isUseDelegateLastClassLoader() {
        return this.useDelegateLastClassLoader;
    }

    public int mzNightModeUseOf() {
        Handler handler = this.mInlineFence;
        if (handler == null) {
            return 1;
        }
        return TinkerInlineFenceAction.callMZNightModeUseOf(handler);
    }

    protected void onBaseContextAttached(Context context, long j, long j2) {
        try {
            loadTinker();
            this.mCurrentClassLoader = context.getClassLoader();
            Handler createInlineFence = createInlineFence(this, this.tinkerFlags, this.delegateClassName, this.tinkerLoadVerifyFlag, j, j2, this.tinkerResultIntent);
            this.mInlineFence = createInlineFence;
            TinkerInlineFenceAction.callOnBaseContextAttached(createInlineFence, context);
            if (this.useSafeMode) {
                ShareTinkerInternals.setSafeModeCount(this, 0);
            }
        } catch (TinkerRuntimeException e) {
            throw e;
        } catch (Throwable th) {
            throw new TinkerRuntimeException(th.getMessage(), th);
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Handler handler = this.mInlineFence;
        if (handler == null) {
            return;
        }
        TinkerInlineFenceAction.callOnConfigurationChanged(handler, configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Handler handler = this.mInlineFence;
        if (handler == null) {
            return;
        }
        TinkerInlineFenceAction.callOnCreate(handler);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        Handler handler = this.mInlineFence;
        if (handler == null) {
            return;
        }
        TinkerInlineFenceAction.callOnLowMemory(handler);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        Handler handler = this.mInlineFence;
        if (handler == null) {
            return;
        }
        TinkerInlineFenceAction.callOnTerminate(handler);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Handler handler = this.mInlineFence;
        if (handler == null) {
            return;
        }
        TinkerInlineFenceAction.callOnTrimMemory(handler, i);
    }

    public void setUseSafeMode(boolean z) {
        this.useSafeMode = z;
    }
}
