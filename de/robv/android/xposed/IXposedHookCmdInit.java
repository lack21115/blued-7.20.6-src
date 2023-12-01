package de.robv.android.xposed;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/IXposedHookCmdInit.class */
public interface IXposedHookCmdInit extends IXposedMod {

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/IXposedHookCmdInit$StartupParam.class */
    public static final class StartupParam {
        public String modulePath;
        public String startClassName;
    }

    void initCmdApp(StartupParam startupParam) throws Throwable;
}
