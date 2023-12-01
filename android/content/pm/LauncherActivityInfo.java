package android.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/LauncherActivityInfo.class */
public class LauncherActivityInfo {
    private static final String TAG = "LauncherActivityInfo";
    private ActivityInfo mActivityInfo;
    private ComponentName mComponentName;
    private long mFirstInstallTime;
    private final PackageManager mPm;
    private UserHandle mUser;

    LauncherActivityInfo(Context context) {
        this.mPm = context.getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LauncherActivityInfo(Context context, ResolveInfo resolveInfo, UserHandle userHandle, long j) {
        this(context);
        this.mActivityInfo = resolveInfo.activityInfo;
        this.mComponentName = LauncherApps.getComponentName(resolveInfo);
        this.mUser = userHandle;
        this.mFirstInstallTime = j;
    }

    public int getApplicationFlags() {
        return this.mActivityInfo.applicationInfo.flags;
    }

    public ApplicationInfo getApplicationInfo() {
        return this.mActivityInfo.applicationInfo;
    }

    public Drawable getBadgedIcon(int i) {
        Drawable drawable;
        int iconResource = this.mActivityInfo.getIconResource();
        try {
            Resources resourcesForApplication = this.mPm.getResourcesForApplication(this.mActivityInfo.applicationInfo);
            drawable = null;
            if (i != 0) {
                try {
                    drawable = resourcesForApplication.getDrawableForDensity(iconResource, i);
                } catch (Resources.NotFoundException e) {
                    drawable = null;
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            drawable = null;
        }
        Drawable drawable2 = drawable;
        if (drawable == null) {
            drawable2 = this.mActivityInfo.loadIcon(this.mPm);
        }
        if (drawable2 instanceof BitmapDrawable) {
            return this.mPm.getUserBadgedIcon(drawable2, this.mUser);
        }
        Log.e(TAG, "Unable to create badged icon for " + this.mActivityInfo);
        return drawable2;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public long getFirstInstallTime() {
        return this.mFirstInstallTime;
    }

    public Drawable getIcon(int i) {
        return this.mActivityInfo.loadIcon(this.mPm);
    }

    public CharSequence getLabel() {
        return this.mActivityInfo.loadLabel(this.mPm);
    }

    public String getName() {
        return this.mActivityInfo.name;
    }

    public UserHandle getUser() {
        return this.mUser;
    }
}
