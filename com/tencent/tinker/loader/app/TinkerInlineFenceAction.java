package com.tencent.tinker.loader.app;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/app/TinkerInlineFenceAction.class */
public final class TinkerInlineFenceAction {
    public static final int ACTION_GET_ASSETS = 9;
    public static final int ACTION_GET_BASE_CONTEXT = 8;
    public static final int ACTION_GET_CLASSLOADER = 7;
    public static final int ACTION_GET_RESOURCES = 10;
    public static final int ACTION_GET_SYSTEM_SERVICE = 11;
    public static final int ACTION_MZ_NIGHTMODE_USE_OF = 12;
    public static final int ACTION_ON_BASE_CONTEXT_ATTACHED = 1;
    public static final int ACTION_ON_CONFIGURATION_CHANGED = 3;
    public static final int ACTION_ON_CREATE = 2;
    public static final int ACTION_ON_LOW_MEMORY = 5;
    public static final int ACTION_ON_TERMINATE = 6;
    public static final int ACTION_ON_TRIM_MEMORY = 4;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AssetManager callGetAssets(Handler handler, AssetManager assetManager) {
        Message obtain = Message.obtain(handler, 9, assetManager);
        handler.handleMessage(obtain);
        return (AssetManager) obtain.obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context callGetBaseContext(Handler handler, Context context) {
        Message obtain = Message.obtain(handler, 8, context);
        handler.handleMessage(obtain);
        return (Context) obtain.obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader callGetClassLoader(Handler handler, ClassLoader classLoader) {
        Message obtain = Message.obtain(handler, 7, classLoader);
        handler.handleMessage(obtain);
        return (ClassLoader) obtain.obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources callGetResources(Handler handler, Resources resources) {
        Message obtain = Message.obtain(handler, 10, resources);
        handler.handleMessage(obtain);
        return (Resources) obtain.obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object callGetSystemService(Handler handler, String str, Object obj) {
        Message obtain = Message.obtain(handler, 11, new Object[]{str, obj});
        handler.handleMessage(obtain);
        return obtain.obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int callMZNightModeUseOf(Handler handler) {
        Message obtain = Message.obtain(handler, 12);
        handler.handleMessage(obtain);
        return ((Integer) obtain.obj).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnBaseContextAttached(Handler handler, Context context) {
        handler.handleMessage(Message.obtain(handler, 1, context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnConfigurationChanged(Handler handler, Configuration configuration) {
        handler.handleMessage(Message.obtain(handler, 3, configuration));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnCreate(Handler handler) {
        handler.handleMessage(Message.obtain(handler, 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnLowMemory(Handler handler) {
        handler.handleMessage(Message.obtain(handler, 5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnTerminate(Handler handler) {
        handler.handleMessage(Message.obtain(handler, 6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callOnTrimMemory(Handler handler, int i) {
        handler.handleMessage(Message.obtain(handler, 4, Integer.valueOf(i)));
    }
}
