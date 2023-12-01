package de.robv.android.xposed.callbacks;

import android.content.res.XResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XCallback;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/callbacks/XC_InitPackageResources.class */
public abstract class XC_InitPackageResources extends XCallback implements IXposedHookInitPackageResources {

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/callbacks/XC_InitPackageResources$InitPackageResourcesParam.class */
    public static final class InitPackageResourcesParam extends XCallback.Param {
        public String packageName;
        public XResources res;

        public InitPackageResourcesParam(XposedBridge.CopyOnWriteSortedSet<XC_InitPackageResources> copyOnWriteSortedSet) {
            super(copyOnWriteSortedSet);
        }
    }

    public XC_InitPackageResources() {
    }

    public XC_InitPackageResources(int i) {
        super(i);
    }

    @Override // de.robv.android.xposed.callbacks.XCallback
    protected void call(XCallback.Param param) throws Throwable {
        if (param instanceof InitPackageResourcesParam) {
            handleInitPackageResources((InitPackageResourcesParam) param);
        }
    }
}
