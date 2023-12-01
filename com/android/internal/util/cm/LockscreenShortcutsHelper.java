package com.android.internal.util.cm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/LockscreenShortcutsHelper.class */
public class LockscreenShortcutsHelper {
    private static final String CAMERA_DEFAULT_ICON = "ic_camera_alt_24dp";
    public static final String DEFAULT = "default";
    private static final String DELIMITER = "|";
    public static final String NONE = "none";
    private static final String PHONE_DEFAULT_ICON = "ic_phone_24dp";
    private static final String SYSTEM_UI_PKGNAME = "com.android.systemui";
    private final Context mContext;
    private OnChangeListener mListener;
    private ContentObserver mObserver = new ContentObserver(null) { // from class: com.android.internal.util.cm.LockscreenShortcutsHelper.1
        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            LockscreenShortcutsHelper.this.fetchTargets();
            if (LockscreenShortcutsHelper.this.mListener != null) {
                LockscreenShortcutsHelper.this.mListener.onChange();
            }
        }
    };
    private Resources mSystemUiResources;
    private List<String> mTargetActivities;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/LockscreenShortcutsHelper$OnChangeListener.class */
    public interface OnChangeListener {
        void onChange();
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/LockscreenShortcutsHelper$Shortcuts.class */
    public enum Shortcuts {
        LEFT_SHORTCUT(0),
        RIGHT_SHORTCUT(1);
        
        private final int index;

        Shortcuts(int i) {
            this.index = i;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/LockscreenShortcutsHelper$TargetInfo.class */
    public static class TargetInfo {
        public ColorFilter colorFilter;
        public Drawable icon;
        public String uri;

        public TargetInfo(Drawable drawable, ColorFilter colorFilter, String str) {
            this.icon = drawable;
            this.colorFilter = colorFilter;
            this.uri = str;
        }
    }

    public LockscreenShortcutsHelper(Context context, OnChangeListener onChangeListener) {
        this.mContext = context;
        if (onChangeListener != null) {
            this.mListener = onChangeListener;
            this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("lockscreen_target_actions"), false, this.mObserver);
        }
        fetchTargets();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchTargets() {
        this.mTargetActivities = Settings.Secure.getDelimitedStringAsList(this.mContext.getContentResolver(), "lockscreen_target_actions", DELIMITER);
        int length = Shortcuts.values().length - this.mTargetActivities.size();
        if (length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mTargetActivities.add("default");
            i = i2 + 1;
        }
    }

    private String getFriendlyActivityName(Intent intent, boolean z) {
        PackageManager packageManager = this.mContext.getPackageManager();
        ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(packageManager, 1);
        String str = null;
        if (resolveActivityInfo != null) {
            String charSequence = resolveActivityInfo.loadLabel(packageManager).toString();
            str = charSequence;
            if (charSequence == null) {
                str = charSequence;
                if (!z) {
                    str = resolveActivityInfo.name;
                }
            }
        }
        return (str != null || z) ? str : intent.toUri(0);
    }

    private String getFriendlyShortcutName(Intent intent) {
        String str;
        String friendlyActivityName = getFriendlyActivityName(intent, true);
        String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
        if (friendlyActivityName == null || stringExtra == null) {
            str = stringExtra;
            if (stringExtra == null) {
                return intent.toUri(0);
            }
        } else {
            str = friendlyActivityName + ": " + stringExtra;
        }
        return str;
    }

    public void cleanup() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mObserver);
        this.mListener = null;
    }

    public Drawable getDrawableFromSystemUI(String str) {
        Resources resources;
        int identifier;
        if (this.mContext.getPackageName().equals(SYSTEM_UI_PKGNAME)) {
            resources = this.mContext.getResources();
        } else {
            if (this.mSystemUiResources == null) {
                try {
                    this.mSystemUiResources = this.mContext.getPackageManager().getResourcesForApplication(SYSTEM_UI_PKGNAME);
                } catch (PackageManager.NameNotFoundException e) {
                }
            }
            resources = this.mSystemUiResources;
        }
        if (resources != null && (identifier = resources.getIdentifier(str, "drawable", SYSTEM_UI_PKGNAME)) > 0) {
            return resources.getDrawable(identifier);
        }
        return null;
    }

    public List<TargetInfo> getDrawablesForTargets() {
        fetchTargets();
        ArrayList arrayList = new ArrayList();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Shortcuts.values().length) {
                return arrayList;
            }
            String str = this.mTargetActivities.get(i2);
            Drawable drawable = null;
            ColorMatrixColorFilter colorMatrixColorFilter2 = null;
            if (!TextUtils.isEmpty(str)) {
                drawable = null;
                colorMatrixColorFilter2 = null;
                if (!str.equals("none")) {
                    try {
                        Intent parseUri = Intent.parseUri(str, 0);
                        PackageManager packageManager = this.mContext.getPackageManager();
                        ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(packageManager, 1);
                        drawable = null;
                        colorMatrixColorFilter2 = null;
                        if (resolveActivityInfo != null) {
                            drawable = resolveActivityInfo.loadIcon(packageManager);
                            colorMatrixColorFilter2 = colorMatrixColorFilter;
                        }
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                        drawable = null;
                        colorMatrixColorFilter2 = null;
                    }
                }
            }
            Drawable drawable2 = drawable;
            if (drawable == null) {
                drawable2 = getDrawableFromSystemUI(i2 == Shortcuts.LEFT_SHORTCUT.index ? PHONE_DEFAULT_ICON : CAMERA_DEFAULT_ICON);
                colorMatrixColorFilter2 = null;
            }
            arrayList.add(new TargetInfo(drawable2, colorMatrixColorFilter2, str));
            i = i2 + 1;
        }
    }

    public String getFriendlyNameForUri(Shortcuts shortcuts) {
        Intent intent = getIntent(shortcuts);
        return "android.intent.action.MAIN".equals(intent.getAction()) ? getFriendlyActivityName(intent, false) : getFriendlyShortcutName(intent);
    }

    public Intent getIntent(Shortcuts shortcuts) {
        try {
            return Intent.parseUri(this.mTargetActivities.get(shortcuts.index), 0);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isTargetCustom(Shortcuts shortcuts) {
        if (this.mTargetActivities == null || this.mTargetActivities.isEmpty()) {
            return false;
        }
        String str = this.mTargetActivities.get(shortcuts.index);
        if ("default".equals(str)) {
            return false;
        }
        return "none".equals(str) || getIntent(shortcuts) != null;
    }

    public boolean isTargetEmpty(Shortcuts shortcuts) {
        return (this.mTargetActivities == null || this.mTargetActivities.isEmpty() || !this.mTargetActivities.get(shortcuts.index).equals("none")) ? false : true;
    }

    public void removeTargetsForPackage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTargetActivities.size()) {
                saveTargets(this.mTargetActivities);
                return;
            }
            if (this.mTargetActivities.get(i2).toLowerCase().contains(lowerCase)) {
                this.mTargetActivities.set(i2, "default");
            }
            i = i2 + 1;
        }
    }

    public void saveTargets(List<String> list) {
        Settings.Secure.putListAsDelimitedString(this.mContext.getContentResolver(), "lockscreen_target_actions", DELIMITER, list);
    }
}
