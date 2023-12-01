package de.robv.android.xposed;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/IXposedHookZygoteInit.class */
public interface IXposedHookZygoteInit extends IXposedMod {

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/IXposedHookZygoteInit$StartupParam.class */
    public static final class StartupParam {
        public String modulePath;
        public boolean startsSystemServer;
    }

    void initZygote(StartupParam startupParam) throws Throwable;
}
