package android.content.res;

import android.os.IBinder;
import com.blued.das.live.LiveProtos;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/ResourcesKey.class */
public final class ResourcesKey {
    public final int mDisplayId;
    private final int mHash;
    private final boolean mIsThemeable;
    public final Configuration mOverrideConfiguration = new Configuration();
    final String mResDir;
    final float mScale;
    private final ThemeConfig mThemeConfig;
    private final IBinder mToken;

    public ResourcesKey(String str, int i, Configuration configuration, float f, boolean z, ThemeConfig themeConfig, IBinder iBinder) {
        int i2 = 0;
        this.mResDir = str;
        this.mDisplayId = i;
        if (configuration != null) {
            this.mOverrideConfiguration.setTo(configuration);
        }
        this.mScale = f;
        this.mIsThemeable = z;
        this.mToken = iBinder;
        this.mThemeConfig = themeConfig;
        int hashCode = this.mResDir == null ? 0 : this.mResDir.hashCode();
        int i3 = this.mDisplayId;
        int hashCode2 = this.mOverrideConfiguration != null ? this.mOverrideConfiguration.hashCode() : 0;
        this.mHash = ((((((((((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + i3) * 31) + hashCode2) * 31) + Float.floatToIntBits(this.mScale)) * 31) + (this.mIsThemeable ? 1 : 0)) * 31) + (themeConfig != null ? themeConfig.hashCode() : i2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ResourcesKey) {
            ResourcesKey resourcesKey = (ResourcesKey) obj;
            if (this.mResDir != null || resourcesKey.mResDir == null) {
                if (this.mResDir == null || resourcesKey.mResDir != null) {
                    if ((this.mResDir == null || resourcesKey.mResDir == null || this.mResDir.equals(resourcesKey.mResDir)) && this.mDisplayId == resourcesKey.mDisplayId) {
                        if ((this.mOverrideConfiguration == resourcesKey.mOverrideConfiguration || !(this.mOverrideConfiguration == null || resourcesKey.mOverrideConfiguration == null || !this.mOverrideConfiguration.equals(resourcesKey.mOverrideConfiguration))) && this.mScale == resourcesKey.mScale && this.mIsThemeable == resourcesKey.mIsThemeable) {
                            if (this.mThemeConfig != resourcesKey.mThemeConfig) {
                                return (this.mThemeConfig == null || resourcesKey.mThemeConfig == null || !this.mThemeConfig.equals(resourcesKey.mThemeConfig)) ? false : true;
                            }
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean hasOverrideConfiguration() {
        return !Configuration.EMPTY.equals(this.mOverrideConfiguration);
    }

    public int hashCode() {
        return this.mHash;
    }

    public String toString() {
        return Integer.toHexString(this.mHash);
    }
}
