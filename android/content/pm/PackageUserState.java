package android.content.pm;

import android.util.ArraySet;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageUserState.class */
public class PackageUserState {
    public boolean blockUninstall;
    public ArraySet<String> disabledComponents;
    public int enabled;
    public ArraySet<String> enabledComponents;
    public boolean hidden;
    public boolean installed;
    public String lastDisableAppCaller;
    public boolean notLaunched;
    public ArraySet<String> protectedComponents;
    public boolean stopped;
    public ArraySet<String> visibleComponents;

    public PackageUserState() {
        this.installed = true;
        this.hidden = false;
        this.enabled = 0;
    }

    public PackageUserState(PackageUserState packageUserState) {
        this.installed = packageUserState.installed;
        this.stopped = packageUserState.stopped;
        this.notLaunched = packageUserState.notLaunched;
        this.enabled = packageUserState.enabled;
        this.hidden = packageUserState.hidden;
        this.lastDisableAppCaller = packageUserState.lastDisableAppCaller;
        this.disabledComponents = packageUserState.disabledComponents != null ? new ArraySet<>(packageUserState.disabledComponents) : null;
        this.enabledComponents = packageUserState.enabledComponents != null ? new ArraySet<>(packageUserState.enabledComponents) : null;
        this.blockUninstall = packageUserState.blockUninstall;
        this.protectedComponents = packageUserState.protectedComponents != null ? new ArraySet<>(packageUserState.protectedComponents) : null;
        this.visibleComponents = packageUserState.visibleComponents != null ? new ArraySet<>(packageUserState.visibleComponents) : null;
    }
}
