package android.appwidget;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.IntentSender;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.android.internal.appwidget.IAppWidgetHost;
import com.android.internal.appwidget.IAppWidgetService;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/appwidget/AppWidgetHost.class */
public class AppWidgetHost {
    static final int HANDLE_PROVIDERS_CHANGED = 3;
    static final int HANDLE_PROVIDER_CHANGED = 2;
    static final int HANDLE_UPDATE = 1;
    static final int HANDLE_VIEW_DATA_CHANGED = 4;
    static IAppWidgetService sService;
    static final Object sServiceLock = new Object();
    Callbacks mCallbacks;
    private String mContextOpPackageName;
    private DisplayMetrics mDisplayMetrics;
    Handler mHandler;
    int mHostId;
    private RemoteViews.OnClickHandler mOnClickHandler;
    final HashMap<Integer, AppWidgetHostView> mViews;

    /* loaded from: source-9557208-dex2jar.jar:android/appwidget/AppWidgetHost$Callbacks.class */
    class Callbacks extends IAppWidgetHost.Stub {
        Callbacks() {
        }

        public void providerChanged(int i, AppWidgetProviderInfo appWidgetProviderInfo) {
            AppWidgetProviderInfo appWidgetProviderInfo2 = appWidgetProviderInfo;
            if (AppWidgetHost.this.isLocalBinder()) {
                appWidgetProviderInfo2 = appWidgetProviderInfo;
                if (appWidgetProviderInfo != null) {
                    appWidgetProviderInfo2 = appWidgetProviderInfo.m150clone();
                }
            }
            AppWidgetHost.this.mHandler.obtainMessage(2, i, 0, appWidgetProviderInfo2).sendToTarget();
        }

        public void providersChanged() {
            AppWidgetHost.this.mHandler.obtainMessage(3).sendToTarget();
        }

        public void updateAppWidget(int i, RemoteViews remoteViews) {
            RemoteViews remoteViews2 = remoteViews;
            if (AppWidgetHost.this.isLocalBinder()) {
                remoteViews2 = remoteViews;
                if (remoteViews != null) {
                    remoteViews2 = remoteViews.clone();
                }
            }
            AppWidgetHost.this.mHandler.obtainMessage(1, i, 0, remoteViews2).sendToTarget();
        }

        public void viewDataChanged(int i, int i2) {
            AppWidgetHost.this.mHandler.obtainMessage(4, i, i2).sendToTarget();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/appwidget/AppWidgetHost$UpdateHandler.class */
    class UpdateHandler extends Handler {
        public UpdateHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    AppWidgetHost.this.updateAppWidgetView(message.arg1, (RemoteViews) message.obj);
                    return;
                case 2:
                    AppWidgetHost.this.onProviderChanged(message.arg1, (AppWidgetProviderInfo) message.obj);
                    return;
                case 3:
                    AppWidgetHost.this.onProvidersChanged();
                    return;
                case 4:
                    AppWidgetHost.this.viewDataChanged(message.arg1, message.arg2);
                    return;
                default:
                    return;
            }
        }
    }

    public AppWidgetHost(Context context, int i) {
        this(context, i, null, context.getMainLooper());
    }

    public AppWidgetHost(Context context, int i, RemoteViews.OnClickHandler onClickHandler, Looper looper) {
        this.mCallbacks = new Callbacks();
        this.mViews = new HashMap<>();
        this.mContextOpPackageName = context.getOpPackageName();
        this.mHostId = i;
        this.mOnClickHandler = onClickHandler;
        this.mHandler = new UpdateHandler(looper);
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
        bindService();
    }

    private static void bindService() {
        synchronized (sServiceLock) {
            if (sService == null) {
                sService = IAppWidgetService.Stub.asInterface(ServiceManager.getService(Context.APPWIDGET_SERVICE));
            }
        }
    }

    public static void deleteAllHosts() {
        try {
            sService.deleteAllHosts();
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLocalBinder() {
        return Process.myPid() == Binder.getCallingPid();
    }

    public int allocateAppWidgetId() {
        try {
            return sService.allocateAppWidgetId(this.mContextOpPackageName, this.mHostId);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    protected void clearViews() {
        this.mViews.clear();
    }

    public final AppWidgetHostView createView(Context context, int i, AppWidgetProviderInfo appWidgetProviderInfo) {
        AppWidgetHostView onCreateView = onCreateView(context, i, appWidgetProviderInfo);
        onCreateView.setOnClickHandler(this.mOnClickHandler);
        onCreateView.setAppWidget(i, appWidgetProviderInfo);
        synchronized (this.mViews) {
            this.mViews.put(Integer.valueOf(i), onCreateView);
        }
        try {
            onCreateView.updateAppWidget(sService.getAppWidgetViews(this.mContextOpPackageName, i));
            return onCreateView;
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public void deleteAppWidgetId(int i) {
        synchronized (this.mViews) {
            this.mViews.remove(Integer.valueOf(i));
            try {
                sService.deleteAppWidgetId(this.mContextOpPackageName, i);
            } catch (RemoteException e) {
                throw new RuntimeException("system server dead?", e);
            }
        }
    }

    public void deleteHost() {
        try {
            sService.deleteHost(this.mContextOpPackageName, this.mHostId);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public int[] getAppWidgetIds() {
        try {
            if (sService == null) {
                bindService();
            }
            return sService.getAppWidgetIdsForHost(this.mContextOpPackageName, this.mHostId);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    protected AppWidgetHostView onCreateView(Context context, int i, AppWidgetProviderInfo appWidgetProviderInfo) {
        return new AppWidgetHostView(context, this.mOnClickHandler);
    }

    protected void onProviderChanged(int i, AppWidgetProviderInfo appWidgetProviderInfo) {
        AppWidgetHostView appWidgetHostView;
        appWidgetProviderInfo.minWidth = TypedValue.complexToDimensionPixelSize(appWidgetProviderInfo.minWidth, this.mDisplayMetrics);
        appWidgetProviderInfo.minHeight = TypedValue.complexToDimensionPixelSize(appWidgetProviderInfo.minHeight, this.mDisplayMetrics);
        appWidgetProviderInfo.minResizeWidth = TypedValue.complexToDimensionPixelSize(appWidgetProviderInfo.minResizeWidth, this.mDisplayMetrics);
        appWidgetProviderInfo.minResizeHeight = TypedValue.complexToDimensionPixelSize(appWidgetProviderInfo.minResizeHeight, this.mDisplayMetrics);
        synchronized (this.mViews) {
            appWidgetHostView = this.mViews.get(Integer.valueOf(i));
        }
        if (appWidgetHostView != null) {
            appWidgetHostView.resetAppWidget(appWidgetProviderInfo);
        }
    }

    protected void onProvidersChanged() {
    }

    public final void startAppWidgetConfigureActivityForResult(Activity activity, int i, int i2, int i3, Bundle bundle) {
        try {
            IntentSender createAppWidgetConfigIntentSender = sService.createAppWidgetConfigIntentSender(this.mContextOpPackageName, i);
            if (createAppWidgetConfigIntentSender == null) {
                throw new ActivityNotFoundException();
            }
            activity.startIntentSenderForResult(createAppWidgetConfigIntentSender, i3, null, 0, i2, i2, bundle);
        } catch (IntentSender.SendIntentException e) {
            throw new ActivityNotFoundException();
        } catch (RemoteException e2) {
            throw new RuntimeException("system server dead?", e2);
        }
    }

    public void startListening() {
        ArrayList arrayList = new ArrayList();
        try {
            int[] startListening = sService.startListening(this.mCallbacks, this.mContextOpPackageName, this.mHostId, arrayList);
            int length = startListening.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                updateAppWidgetView(startListening[i2], (RemoteViews) arrayList.get(i2));
                i = i2 + 1;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    public void stopListening() {
        try {
            sService.stopListening(this.mContextOpPackageName, this.mHostId);
            clearViews();
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    void updateAppWidgetView(int i, RemoteViews remoteViews) {
        AppWidgetHostView appWidgetHostView;
        synchronized (this.mViews) {
            appWidgetHostView = this.mViews.get(Integer.valueOf(i));
        }
        if (appWidgetHostView != null) {
            appWidgetHostView.updateAppWidget(remoteViews);
        }
    }

    void viewDataChanged(int i, int i2) {
        AppWidgetHostView appWidgetHostView;
        synchronized (this.mViews) {
            appWidgetHostView = this.mViews.get(Integer.valueOf(i));
        }
        if (appWidgetHostView != null) {
            appWidgetHostView.viewDataChanged(i2);
        }
    }
}
