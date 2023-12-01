package android.appwidget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.android.internal.appwidget.IAppWidgetService;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/appwidget/AppWidgetManager.class */
public class AppWidgetManager {
    public static final String ACTION_APPWIDGET_BIND = "android.appwidget.action.APPWIDGET_BIND";
    public static final String ACTION_APPWIDGET_CONFIGURE = "android.appwidget.action.APPWIDGET_CONFIGURE";
    public static final String ACTION_APPWIDGET_DELETED = "android.appwidget.action.APPWIDGET_DELETED";
    public static final String ACTION_APPWIDGET_DISABLED = "android.appwidget.action.APPWIDGET_DISABLED";
    public static final String ACTION_APPWIDGET_ENABLED = "android.appwidget.action.APPWIDGET_ENABLED";
    public static final String ACTION_APPWIDGET_HOST_RESTORED = "android.appwidget.action.APPWIDGET_HOST_RESTORED";
    public static final String ACTION_APPWIDGET_OPTIONS_CHANGED = "android.appwidget.action.APPWIDGET_UPDATE_OPTIONS";
    public static final String ACTION_APPWIDGET_PICK = "android.appwidget.action.APPWIDGET_PICK";
    public static final String ACTION_APPWIDGET_RESTORED = "android.appwidget.action.APPWIDGET_RESTORED";
    public static final String ACTION_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
    public static final String ACTION_KEYGUARD_APPWIDGET_PICK = "android.appwidget.action.KEYGUARD_APPWIDGET_PICK";
    public static final String EXTRA_APPWIDGET_ID = "appWidgetId";
    public static final String EXTRA_APPWIDGET_IDS = "appWidgetIds";
    public static final String EXTRA_APPWIDGET_OLD_IDS = "appWidgetOldIds";
    public static final String EXTRA_APPWIDGET_OPTIONS = "appWidgetOptions";
    public static final String EXTRA_APPWIDGET_PROVIDER = "appWidgetProvider";
    public static final String EXTRA_APPWIDGET_PROVIDER_PROFILE = "appWidgetProviderProfile";
    public static final String EXTRA_CATEGORY_FILTER = "categoryFilter";
    public static final String EXTRA_CUSTOM_EXTRAS = "customExtras";
    public static final String EXTRA_CUSTOM_INFO = "customInfo";
    public static final String EXTRA_CUSTOM_SORT = "customSort";
    public static final String EXTRA_HOST_ID = "hostId";
    public static final int INVALID_APPWIDGET_ID = 0;
    public static final String META_DATA_APPWIDGET_PROVIDER = "android.appwidget.provider";
    public static final String OPTION_APPWIDGET_HOST_CATEGORY = "appWidgetCategory";
    public static final String OPTION_APPWIDGET_MAX_HEIGHT = "appWidgetMaxHeight";
    public static final String OPTION_APPWIDGET_MAX_WIDTH = "appWidgetMaxWidth";
    public static final String OPTION_APPWIDGET_MIN_HEIGHT = "appWidgetMinHeight";
    public static final String OPTION_APPWIDGET_MIN_WIDTH = "appWidgetMinWidth";
    private final DisplayMetrics mDisplayMetrics;
    private final String mPackageName;
    private final IAppWidgetService mService;

    public AppWidgetManager(Context context, IAppWidgetService iAppWidgetService) {
        this.mPackageName = context.getOpPackageName();
        this.mService = iAppWidgetService;
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    private boolean bindAppWidgetIdIfAllowed(int i, int i2, ComponentName componentName, Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.bindAppWidgetId(this.mPackageName, i, i2, componentName, bundle);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    private void convertSizesToPixels(AppWidgetProviderInfo appWidgetProviderInfo) {
        appWidgetProviderInfo.minWidth = TypedValue.complexToDimensionPixelSize(appWidgetProviderInfo.minWidth, this.mDisplayMetrics);
        appWidgetProviderInfo.minHeight = TypedValue.complexToDimensionPixelSize(appWidgetProviderInfo.minHeight, this.mDisplayMetrics);
        appWidgetProviderInfo.minResizeWidth = TypedValue.complexToDimensionPixelSize(appWidgetProviderInfo.minResizeWidth, this.mDisplayMetrics);
        appWidgetProviderInfo.minResizeHeight = TypedValue.complexToDimensionPixelSize(appWidgetProviderInfo.minResizeHeight, this.mDisplayMetrics);
    }

    public static AppWidgetManager getInstance(Context context) {
        return (AppWidgetManager) context.getSystemService(Context.APPWIDGET_SERVICE);
    }

    public void bindAppWidgetId(int i, ComponentName componentName) {
        if (this.mService == null) {
            return;
        }
        bindAppWidgetId(i, componentName, null);
    }

    public void bindAppWidgetId(int i, ComponentName componentName, Bundle bundle) {
        if (this.mService == null) {
            return;
        }
        bindAppWidgetIdIfAllowed(i, Process.myUserHandle(), componentName, bundle);
    }

    public boolean bindAppWidgetIdIfAllowed(int i, ComponentName componentName) {
        if (this.mService == null) {
            return false;
        }
        return bindAppWidgetIdIfAllowed(i, UserHandle.myUserId(), componentName, (Bundle) null);
    }

    public boolean bindAppWidgetIdIfAllowed(int i, ComponentName componentName, Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        return bindAppWidgetIdIfAllowed(i, UserHandle.myUserId(), componentName, bundle);
    }

    public boolean bindAppWidgetIdIfAllowed(int i, UserHandle userHandle, ComponentName componentName, Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        return bindAppWidgetIdIfAllowed(i, userHandle.getIdentifier(), componentName, bundle);
    }

    public void bindRemoteViewsService(String str, int i, Intent intent, IBinder iBinder) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.bindRemoteViewsService(str, i, intent, iBinder);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public int[] getAppWidgetIds(ComponentName componentName) {
        if (this.mService == null) {
            return new int[0];
        }
        try {
            return this.mService.getAppWidgetIds(componentName);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public AppWidgetProviderInfo getAppWidgetInfo(int i) {
        AppWidgetProviderInfo appWidgetProviderInfo;
        if (this.mService == null) {
            appWidgetProviderInfo = null;
        } else {
            try {
                AppWidgetProviderInfo appWidgetInfo = this.mService.getAppWidgetInfo(this.mPackageName, i);
                appWidgetProviderInfo = appWidgetInfo;
                if (appWidgetInfo != null) {
                    convertSizesToPixels(appWidgetInfo);
                    return appWidgetInfo;
                }
            } catch (RemoteException e) {
                throw new RuntimeException("system server dead?", e);
            }
        }
        return appWidgetProviderInfo;
    }

    public Bundle getAppWidgetOptions(int i) {
        if (this.mService == null) {
            return Bundle.EMPTY;
        }
        try {
            return this.mService.getAppWidgetOptions(this.mPackageName, i);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public List<AppWidgetProviderInfo> getInstalledProviders() {
        return this.mService == null ? Collections.emptyList() : getInstalledProvidersForProfile(1, null);
    }

    public List<AppWidgetProviderInfo> getInstalledProviders(int i) {
        return this.mService == null ? Collections.emptyList() : getInstalledProvidersForProfile(i, null);
    }

    public List<AppWidgetProviderInfo> getInstalledProvidersForProfile(int i, UserHandle userHandle) {
        List<AppWidgetProviderInfo> list;
        if (this.mService == null) {
            list = Collections.emptyList();
        } else {
            UserHandle userHandle2 = userHandle;
            if (userHandle == null) {
                userHandle2 = Process.myUserHandle();
            }
            try {
                List<AppWidgetProviderInfo> installedProvidersForProfile = this.mService.getInstalledProvidersForProfile(i, userHandle2.getIdentifier());
                if (installedProvidersForProfile != null) {
                    Iterator<AppWidgetProviderInfo> it = installedProvidersForProfile.iterator();
                    while (true) {
                        list = installedProvidersForProfile;
                        if (!it.hasNext()) {
                            break;
                        }
                        convertSizesToPixels(it.next());
                    }
                } else {
                    return Collections.emptyList();
                }
            } catch (RemoteException e) {
                throw new RuntimeException("system server dead?", e);
            }
        }
        return list;
    }

    public List<AppWidgetProviderInfo> getInstalledProvidersForProfile(UserHandle userHandle) {
        return this.mService == null ? Collections.emptyList() : getInstalledProvidersForProfile(1, userHandle);
    }

    public boolean hasBindAppWidgetPermission(String str) {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.hasBindAppWidgetPermission(str, UserHandle.myUserId());
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public boolean hasBindAppWidgetPermission(String str, int i) {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.hasBindAppWidgetPermission(str, i);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public void notifyAppWidgetViewDataChanged(int i, int i2) {
        if (this.mService == null) {
            return;
        }
        notifyAppWidgetViewDataChanged(new int[]{i}, i2);
    }

    public void notifyAppWidgetViewDataChanged(int[] iArr, int i) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.notifyAppWidgetViewDataChanged(this.mPackageName, iArr, i);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public void partiallyUpdateAppWidget(int i, RemoteViews remoteViews) {
        if (this.mService == null) {
            return;
        }
        partiallyUpdateAppWidget(new int[]{i}, remoteViews);
    }

    public void partiallyUpdateAppWidget(int[] iArr, RemoteViews remoteViews) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.partiallyUpdateAppWidgetIds(this.mPackageName, iArr, remoteViews);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public void setBindAppWidgetPermission(String str, int i, boolean z) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.setBindAppWidgetPermission(str, i, z);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public void setBindAppWidgetPermission(String str, boolean z) {
        if (this.mService == null) {
            return;
        }
        setBindAppWidgetPermission(str, UserHandle.myUserId(), z);
    }

    public void unbindRemoteViewsService(String str, int i, Intent intent) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.unbindRemoteViewsService(str, i, intent);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public void updateAppWidget(int i, RemoteViews remoteViews) {
        if (this.mService == null) {
            return;
        }
        updateAppWidget(new int[]{i}, remoteViews);
    }

    public void updateAppWidget(ComponentName componentName, RemoteViews remoteViews) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.updateAppWidgetProvider(componentName, remoteViews);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public void updateAppWidget(int[] iArr, RemoteViews remoteViews) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.updateAppWidgetIds(this.mPackageName, iArr, remoteViews);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public void updateAppWidgetOptions(int i, Bundle bundle) {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.updateAppWidgetOptions(this.mPackageName, i, bundle);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }
}
