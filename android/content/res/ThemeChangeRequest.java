package android.content.res;

import android.content.pm.ThemeUtils;
import android.content.res.ThemeConfig;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ThemesContract;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeChangeRequest.class */
public final class ThemeChangeRequest implements Parcelable {
    public static final Parcelable.Creator<ThemeChangeRequest> CREATOR = new Parcelable.Creator<ThemeChangeRequest>() { // from class: android.content.res.ThemeChangeRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThemeChangeRequest createFromParcel(Parcel parcel) {
            return new ThemeChangeRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThemeChangeRequest[] newArray(int i) {
            return new ThemeChangeRequest[i];
        }
    };
    public static final int DEFAULT_WALLPAPER_ID = -1;
    private final Map<String, String> mPerAppOverlays;
    private RequestType mRequestType;
    private final Map<String, String> mThemeComponents;
    private long mWallpaperId;

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeChangeRequest$Builder.class */
    public static class Builder {
        long mWallpaperId;
        Map<String, String> mThemeComponents = new HashMap();
        Map<String, String> mPerAppOverlays = new HashMap();
        RequestType mRequestType = RequestType.USER_REQUEST;

        public Builder() {
        }

        public Builder(ThemeConfig themeConfig) {
            if (themeConfig != null) {
                buildChangeRequestFromThemeConfig(themeConfig);
            }
        }

        private void buildChangeRequestFromThemeConfig(ThemeConfig themeConfig) {
            if (themeConfig.getFontPkgName() != null) {
                setFont(themeConfig.getFontPkgName());
            }
            if (themeConfig.getIconPackPkgName() != null) {
                setIcons(themeConfig.getIconPackPkgName());
            }
            if (themeConfig.getOverlayPkgName() != null) {
                setOverlay(themeConfig.getOverlayPkgName());
            }
            if (themeConfig.getOverlayForStatusBar() != null) {
                setStatusBar(themeConfig.getOverlayForStatusBar());
            }
            if (themeConfig.getOverlayForNavBar() != null) {
                setNavBar(themeConfig.getOverlayForNavBar());
            }
            Map<String, ThemeConfig.AppTheme> appThemes = themeConfig.getAppThemes();
            for (String str : appThemes.keySet()) {
                if (ThemeUtils.isPerAppThemeComponent(str)) {
                    setAppOverlay(str, appThemes.get(str).getOverlayPkgName());
                }
            }
        }

        public ThemeChangeRequest build() {
            return new ThemeChangeRequest(this.mThemeComponents, this.mPerAppOverlays, this.mRequestType, this.mWallpaperId);
        }

        public Builder setAlarm(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_ALARMS, str);
        }

        public Builder setAppOverlay(String str, String str2) {
            if (str != null) {
                if (str2 == null) {
                    this.mPerAppOverlays.remove(str);
                    return this;
                }
                this.mPerAppOverlays.put(str, str2);
            }
            return this;
        }

        public Builder setBootanimation(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_BOOT_ANIM, str);
        }

        public Builder setComponent(String str, String str2) {
            if (str2 != null) {
                this.mThemeComponents.put(str, str2);
                return this;
            }
            this.mThemeComponents.remove(str);
            return this;
        }

        public Builder setFont(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_FONTS, str);
        }

        public Builder setIcons(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_ICONS, str);
        }

        public Builder setLiveLockScreen(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_LIVE_LOCK_SCREEN, str);
        }

        public Builder setLockWallpaper(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_LOCKSCREEN, str);
        }

        public Builder setNavBar(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_NAVIGATION_BAR, str);
        }

        public Builder setNotification(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_NOTIFICATIONS, str);
        }

        public Builder setOverlay(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_OVERLAYS, str);
        }

        public Builder setRequestType(RequestType requestType) {
            if (requestType == null) {
                requestType = RequestType.USER_REQUEST;
            }
            this.mRequestType = requestType;
            return this;
        }

        public Builder setRingtone(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_RINGTONES, str);
        }

        public Builder setStatusBar(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_STATUS_BAR, str);
        }

        public Builder setWallpaper(String str) {
            return setComponent(ThemesContract.ThemesColumns.MODIFIES_LAUNCHER, str);
        }

        public Builder setWallpaperId(long j) {
            this.mWallpaperId = j;
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/ThemeChangeRequest$RequestType.class */
    public enum RequestType {
        USER_REQUEST,
        USER_REQUEST_MIXNMATCH,
        THEME_UPDATED,
        THEME_REMOVED,
        THEME_RESET
    }

    private ThemeChangeRequest(Parcel parcel) {
        this.mThemeComponents = new HashMap();
        this.mPerAppOverlays = new HashMap();
        this.mWallpaperId = -1L;
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                break;
            }
            this.mThemeComponents.put(parcel.readString(), parcel.readString());
            i = i2 + 1;
        }
        int readInt2 = parcel.readInt();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= readInt2) {
                this.mRequestType = RequestType.values()[parcel.readInt()];
                this.mWallpaperId = parcel.readLong();
                return;
            }
            this.mPerAppOverlays.put(parcel.readString(), parcel.readString());
            i3 = i4 + 1;
        }
    }

    private ThemeChangeRequest(Map<String, String> map, Map<String, String> map2, RequestType requestType, long j) {
        this.mThemeComponents = new HashMap();
        this.mPerAppOverlays = new HashMap();
        this.mWallpaperId = -1L;
        if (map != null) {
            this.mThemeComponents.putAll(map);
        }
        if (map2 != null) {
            this.mPerAppOverlays.putAll(map2);
        }
        this.mRequestType = requestType;
        this.mWallpaperId = j;
    }

    private String getThemePackageNameForComponent(String str) {
        return this.mThemeComponents.get(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlarmThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_ALARMS);
    }

    public String getBootanimationThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_BOOT_ANIM);
    }

    public String getFontThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_FONTS);
    }

    public String getIconsThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_ICONS);
    }

    public String getLiveLockScreenThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_LIVE_LOCK_SCREEN);
    }

    public String getLockWallpaperThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_LOCKSCREEN);
    }

    public String getNavBarThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_NAVIGATION_BAR);
    }

    public String getNotificationThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_NOTIFICATIONS);
    }

    public int getNumChangesRequested() {
        return this.mThemeComponents.size() + this.mPerAppOverlays.size();
    }

    public String getOverlayThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_OVERLAYS);
    }

    public final Map<String, String> getPerAppOverlays() {
        return Collections.unmodifiableMap(this.mPerAppOverlays);
    }

    public RequestType getReqeustType() {
        return this.mRequestType;
    }

    public String getRingtoneThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_RINGTONES);
    }

    public String getStatusBarThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_STATUS_BAR);
    }

    public final Map<String, String> getThemeComponentsMap() {
        return Collections.unmodifiableMap(this.mThemeComponents);
    }

    public long getWallpaperId() {
        return this.mWallpaperId;
    }

    public String getWallpaperThemePackageName() {
        return getThemePackageNameForComponent(ThemesContract.ThemesColumns.MODIFIES_LAUNCHER);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mThemeComponents.size());
        for (String str : this.mThemeComponents.keySet()) {
            parcel.writeString(str);
            parcel.writeString(this.mThemeComponents.get(str));
        }
        parcel.writeInt(this.mPerAppOverlays.size());
        for (String str2 : this.mPerAppOverlays.keySet()) {
            parcel.writeString(str2);
            parcel.writeString(this.mPerAppOverlays.get(str2));
        }
        parcel.writeInt(this.mRequestType.ordinal());
        parcel.writeLong(this.mWallpaperId);
    }
}
