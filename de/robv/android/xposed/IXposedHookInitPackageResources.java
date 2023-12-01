package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XC_InitPackageResources;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/IXposedHookInitPackageResources.class */
public interface IXposedHookInitPackageResources extends IXposedMod {

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/IXposedHookInitPackageResources$Wrapper.class */
    public static final class Wrapper extends XC_InitPackageResources {
        private final IXposedHookInitPackageResources instance;

        public Wrapper(IXposedHookInitPackageResources iXposedHookInitPackageResources) {
            this.instance = iXposedHookInitPackageResources;
        }

        @Override // de.robv.android.xposed.IXposedHookInitPackageResources
        public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam) throws Throwable {
            this.instance.handleInitPackageResources(initPackageResourcesParam);
        }
    }

    void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam) throws Throwable;
}
