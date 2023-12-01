package android.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.android.internal.widget.IRemoteViewsFactory;
import java.util.HashMap;

/* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsService.class */
public abstract class RemoteViewsService extends Service {
    private static final String LOG_TAG = "RemoteViewsService";
    private static final HashMap<Intent.FilterComparison, RemoteViewsFactory> sRemoteViewFactories = new HashMap<>();
    private static final Object sLock = new Object();

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsService$RemoteViewsFactory.class */
    public interface RemoteViewsFactory {
        int getCount();

        long getItemId(int i);

        RemoteViews getLoadingView();

        RemoteViews getViewAt(int i);

        int getViewTypeCount();

        boolean hasStableIds();

        void onCreate();

        void onDataSetChanged();

        void onDestroy();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsService$RemoteViewsFactoryAdapter.class */
    private static class RemoteViewsFactoryAdapter extends IRemoteViewsFactory.Stub {
        private RemoteViewsFactory mFactory;
        private boolean mIsCreated;

        public RemoteViewsFactoryAdapter(RemoteViewsFactory remoteViewsFactory, boolean z) {
            this.mFactory = remoteViewsFactory;
            this.mIsCreated = z;
        }

        @Override // com.android.internal.widget.IRemoteViewsFactory
        public int getCount() {
            int i;
            synchronized (this) {
                i = 0;
                try {
                    i = this.mFactory.getCount();
                } catch (Exception e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
            return i;
        }

        @Override // com.android.internal.widget.IRemoteViewsFactory
        public long getItemId(int i) {
            long j;
            synchronized (this) {
                j = 0;
                try {
                    j = this.mFactory.getItemId(i);
                } catch (Exception e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
            return j;
        }

        @Override // com.android.internal.widget.IRemoteViewsFactory
        public RemoteViews getLoadingView() {
            RemoteViews remoteViews;
            synchronized (this) {
                remoteViews = null;
                try {
                    remoteViews = this.mFactory.getLoadingView();
                } catch (Exception e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
            return remoteViews;
        }

        @Override // com.android.internal.widget.IRemoteViewsFactory
        public RemoteViews getViewAt(int i) {
            RemoteViews remoteViews;
            synchronized (this) {
                remoteViews = null;
                try {
                    RemoteViews viewAt = this.mFactory.getViewAt(i);
                    remoteViews = viewAt;
                    if (viewAt != null) {
                        remoteViews = viewAt;
                        viewAt.setIsWidgetCollectionChild(true);
                        remoteViews = viewAt;
                    }
                } catch (Exception e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
            return remoteViews;
        }

        @Override // com.android.internal.widget.IRemoteViewsFactory
        public int getViewTypeCount() {
            int i;
            synchronized (this) {
                i = 0;
                try {
                    i = this.mFactory.getViewTypeCount();
                } catch (Exception e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
            return i;
        }

        @Override // com.android.internal.widget.IRemoteViewsFactory
        public boolean hasStableIds() {
            boolean z;
            synchronized (this) {
                z = false;
                try {
                    z = this.mFactory.hasStableIds();
                } catch (Exception e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
            return z;
        }

        @Override // com.android.internal.widget.IRemoteViewsFactory
        public boolean isCreated() {
            boolean z;
            synchronized (this) {
                z = this.mIsCreated;
            }
            return z;
        }

        @Override // com.android.internal.widget.IRemoteViewsFactory
        public void onDataSetChanged() {
            synchronized (this) {
                try {
                    this.mFactory.onDataSetChanged();
                } catch (Exception e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }

        @Override // com.android.internal.widget.IRemoteViewsFactory
        public void onDataSetChangedAsync() {
            synchronized (this) {
                onDataSetChanged();
            }
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0036 -> B:9:0x002a). Please submit an issue!!! */
        @Override // com.android.internal.widget.IRemoteViewsFactory
        public void onDestroy(Intent intent) {
            synchronized (RemoteViewsService.sLock) {
                Intent.FilterComparison filterComparison = new Intent.FilterComparison(intent);
                if (RemoteViewsService.sRemoteViewFactories.containsKey(filterComparison)) {
                    try {
                        ((RemoteViewsFactory) RemoteViewsService.sRemoteViewFactories.get(filterComparison)).onDestroy();
                    } catch (Exception e) {
                        Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                    }
                    RemoteViewsService.sRemoteViewFactories.remove(filterComparison);
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        RemoteViewsFactory remoteViewsFactory;
        boolean z;
        RemoteViewsFactoryAdapter remoteViewsFactoryAdapter;
        synchronized (sLock) {
            Intent.FilterComparison filterComparison = new Intent.FilterComparison(intent);
            if (sRemoteViewFactories.containsKey(filterComparison)) {
                remoteViewsFactory = sRemoteViewFactories.get(filterComparison);
                z = true;
            } else {
                remoteViewsFactory = onGetViewFactory(intent);
                sRemoteViewFactories.put(filterComparison, remoteViewsFactory);
                remoteViewsFactory.onCreate();
                z = false;
            }
            remoteViewsFactoryAdapter = new RemoteViewsFactoryAdapter(remoteViewsFactory, z);
        }
        return remoteViewsFactoryAdapter;
    }

    public abstract RemoteViewsFactory onGetViewFactory(Intent intent);
}
