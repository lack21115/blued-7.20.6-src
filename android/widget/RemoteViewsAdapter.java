package android.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Slog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import com.android.internal.R;
import com.android.internal.widget.IRemoteViewsAdapterConnection;
import com.android.internal.widget.IRemoteViewsFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsAdapter.class */
public class RemoteViewsAdapter extends BaseAdapter implements Handler.Callback {
    private static final String MULTI_USER_PERM = "android.permission.INTERACT_ACROSS_USERS_FULL";
    private static final int REMOTE_VIEWS_CACHE_DURATION = 5000;
    private static final String TAG = "RemoteViewsAdapter";
    private static Handler sCacheRemovalQueue;
    private static HandlerThread sCacheRemovalThread;
    private static final int sDefaultCacheSize = 40;
    private static final int sDefaultLoadingViewHeight = 50;
    private static final int sDefaultMessageType = 0;
    private static final int sUnbindServiceDelay = 5000;
    private static final int sUnbindServiceMessageType = 1;
    private final int mAppWidgetId;
    private FixedSizeRemoteViewsCache mCache;
    private WeakReference<RemoteAdapterConnectionCallback> mCallback;
    private final Context mContext;
    private boolean mDataReady;
    private final Intent mIntent;
    private LayoutInflater mLayoutInflater;
    private Handler mMainQueue;
    private boolean mNotifyDataSetChangedAfterOnServiceConnected = false;
    private RemoteViews.OnClickHandler mRemoteViewsOnClickHandler;
    private RemoteViewsFrameLayoutRefSet mRequestedViews;
    private RemoteViewsAdapterServiceConnection mServiceConnection;
    private int mVisibleWindowLowerBound;
    private int mVisibleWindowUpperBound;
    private Handler mWorkerQueue;
    private HandlerThread mWorkerThread;
    private static final HashMap<RemoteViewsCacheKey, FixedSizeRemoteViewsCache> sCachedRemoteViewsCaches = new HashMap<>();
    private static final HashMap<RemoteViewsCacheKey, Runnable> sRemoteViewsCacheRemoveRunnables = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsAdapter$FixedSizeRemoteViewsCache.class */
    public static class FixedSizeRemoteViewsCache {
        private static final String TAG = "FixedSizeRemoteViewsCache";
        private static final float sMaxCountSlackPercent = 0.75f;
        private static final int sMaxMemoryLimitInBytes = 2097152;
        private int mMaxCount;
        private int mMaxCountSlack;
        private int mPreloadLowerBound = 0;
        private int mPreloadUpperBound = -1;
        private final RemoteViewsMetaData mMetaData = new RemoteViewsMetaData();
        private final RemoteViewsMetaData mTemporaryMetaData = new RemoteViewsMetaData();
        private HashMap<Integer, RemoteViewsIndexMetaData> mIndexMetaData = new HashMap<>();
        private HashMap<Integer, RemoteViews> mIndexRemoteViews = new HashMap<>();
        private HashSet<Integer> mRequestedIndices = new HashSet<>();
        private int mLastRequestedIndex = -1;
        private HashSet<Integer> mLoadIndices = new HashSet<>();

        public FixedSizeRemoteViewsCache(int i) {
            this.mMaxCount = i;
            this.mMaxCountSlack = Math.round(0.75f * (this.mMaxCount / 2));
        }

        private int getFarthestPositionFrom(int i, ArrayList<Integer> arrayList) {
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            for (Integer num : this.mIndexRemoteViews.keySet()) {
                int intValue = num.intValue();
                int abs = Math.abs(intValue - i);
                int i6 = i5;
                int i7 = i4;
                if (abs > i4) {
                    i6 = i5;
                    i7 = i4;
                    if (!arrayList.contains(Integer.valueOf(intValue))) {
                        i6 = intValue;
                        i7 = abs;
                    }
                }
                i5 = i6;
                i4 = i7;
                if (abs >= i2) {
                    i3 = intValue;
                    i2 = abs;
                    i5 = i6;
                    i4 = i7;
                }
            }
            return i5 > -1 ? i5 : i3;
        }

        private int getRemoteViewsBitmapMemoryUsage() {
            int i = 0;
            for (Integer num : this.mIndexRemoteViews.keySet()) {
                RemoteViews remoteViews = this.mIndexRemoteViews.get(num);
                if (remoteViews != null) {
                    i += remoteViews.estimateMemoryUsage();
                }
            }
            return i;
        }

        public void commitTemporaryMetaData() {
            synchronized (this.mTemporaryMetaData) {
                synchronized (this.mMetaData) {
                    this.mMetaData.set(this.mTemporaryMetaData);
                }
            }
        }

        public boolean containsMetaDataAt(int i) {
            return this.mIndexMetaData.containsKey(Integer.valueOf(i));
        }

        public boolean containsRemoteViewAt(int i) {
            return this.mIndexRemoteViews.containsKey(Integer.valueOf(i));
        }

        public RemoteViewsMetaData getMetaData() {
            return this.mMetaData;
        }

        public RemoteViewsIndexMetaData getMetaDataAt(int i) {
            if (this.mIndexMetaData.containsKey(Integer.valueOf(i))) {
                return this.mIndexMetaData.get(Integer.valueOf(i));
            }
            return null;
        }

        public int[] getNextIndexToLoad() {
            synchronized (this.mLoadIndices) {
                if (!this.mRequestedIndices.isEmpty()) {
                    Integer next = this.mRequestedIndices.iterator().next();
                    this.mRequestedIndices.remove(next);
                    this.mLoadIndices.remove(next);
                    return new int[]{next.intValue(), 1};
                } else if (this.mLoadIndices.isEmpty()) {
                    return new int[]{-1, 0};
                } else {
                    Integer next2 = this.mLoadIndices.iterator().next();
                    this.mLoadIndices.remove(next2);
                    return new int[]{next2.intValue(), 0};
                }
            }
        }

        public RemoteViews getRemoteViewsAt(int i) {
            if (this.mIndexRemoteViews.containsKey(Integer.valueOf(i))) {
                return this.mIndexRemoteViews.get(Integer.valueOf(i));
            }
            return null;
        }

        public RemoteViewsMetaData getTemporaryMetaData() {
            return this.mTemporaryMetaData;
        }

        public void insert(int i, RemoteViews remoteViews, long j, ArrayList<Integer> arrayList) {
            int farthestPositionFrom;
            if (this.mIndexRemoteViews.size() >= this.mMaxCount) {
                this.mIndexRemoteViews.remove(Integer.valueOf(getFarthestPositionFrom(i, arrayList)));
            }
            int i2 = this.mLastRequestedIndex > -1 ? this.mLastRequestedIndex : i;
            while (getRemoteViewsBitmapMemoryUsage() >= 2097152 && (farthestPositionFrom = getFarthestPositionFrom(i2, arrayList)) >= 0) {
                this.mIndexRemoteViews.remove(Integer.valueOf(farthestPositionFrom));
            }
            if (this.mIndexMetaData.containsKey(Integer.valueOf(i))) {
                this.mIndexMetaData.get(Integer.valueOf(i)).set(remoteViews, j);
            } else {
                this.mIndexMetaData.put(Integer.valueOf(i), new RemoteViewsIndexMetaData(remoteViews, j));
            }
            this.mIndexRemoteViews.put(Integer.valueOf(i), remoteViews);
        }

        public boolean queuePositionsToBePreloadedFromRequestedPosition(int i) {
            int i2;
            if (this.mPreloadLowerBound > i || i > this.mPreloadUpperBound || Math.abs(i - ((this.mPreloadUpperBound + this.mPreloadLowerBound) / 2)) >= this.mMaxCountSlack) {
                synchronized (this.mMetaData) {
                    i2 = this.mMetaData.count;
                }
                synchronized (this.mLoadIndices) {
                    this.mLoadIndices.clear();
                    this.mLoadIndices.addAll(this.mRequestedIndices);
                    int i3 = this.mMaxCount / 2;
                    this.mPreloadLowerBound = i - i3;
                    this.mPreloadUpperBound = i + i3;
                    int min = Math.min(this.mPreloadUpperBound, i2 - 1);
                    for (int max = Math.max(0, this.mPreloadLowerBound); max <= min; max++) {
                        this.mLoadIndices.add(Integer.valueOf(max));
                    }
                    this.mLoadIndices.removeAll(this.mIndexRemoteViews.keySet());
                }
                return true;
            }
            return false;
        }

        public void queueRequestedPositionToLoad(int i) {
            this.mLastRequestedIndex = i;
            synchronized (this.mLoadIndices) {
                this.mRequestedIndices.add(Integer.valueOf(i));
                this.mLoadIndices.add(Integer.valueOf(i));
            }
        }

        public void reset() {
            this.mPreloadLowerBound = 0;
            this.mPreloadUpperBound = -1;
            this.mLastRequestedIndex = -1;
            this.mIndexRemoteViews.clear();
            this.mIndexMetaData.clear();
            synchronized (this.mLoadIndices) {
                this.mRequestedIndices.clear();
                this.mLoadIndices.clear();
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsAdapter$RemoteAdapterConnectionCallback.class */
    public interface RemoteAdapterConnectionCallback {
        void deferNotifyDataSetChanged();

        boolean onRemoteAdapterConnected();

        void onRemoteAdapterDisconnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsAdapter$RemoteViewsAdapterServiceConnection.class */
    public static class RemoteViewsAdapterServiceConnection extends IRemoteViewsAdapterConnection.Stub {
        private WeakReference<RemoteViewsAdapter> mAdapter;
        private boolean mIsConnected;
        private boolean mIsConnecting;
        private IRemoteViewsFactory mRemoteViewsFactory;

        public RemoteViewsAdapterServiceConnection(RemoteViewsAdapter remoteViewsAdapter) {
            this.mAdapter = new WeakReference<>(remoteViewsAdapter);
        }

        public void bind(Context context, int i, Intent intent) {
            synchronized (this) {
                if (!this.mIsConnecting) {
                    try {
                        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                        if (this.mAdapter.get() != null) {
                            appWidgetManager.bindRemoteViewsService(context.getOpPackageName(), i, intent, asBinder());
                        } else {
                            Slog.w(RemoteViewsAdapter.TAG, "bind: adapter was null");
                        }
                        this.mIsConnecting = true;
                    } catch (Exception e) {
                        Log.e("RemoteViewsAdapterServiceConnection", "bind(): " + e.getMessage());
                        this.mIsConnecting = false;
                        this.mIsConnected = false;
                    }
                }
            }
        }

        public IRemoteViewsFactory getRemoteViewsFactory() {
            IRemoteViewsFactory iRemoteViewsFactory;
            synchronized (this) {
                iRemoteViewsFactory = this.mRemoteViewsFactory;
            }
            return iRemoteViewsFactory;
        }

        public boolean isConnected() {
            boolean z;
            synchronized (this) {
                z = this.mIsConnected;
            }
            return z;
        }

        @Override // com.android.internal.widget.IRemoteViewsAdapterConnection
        public void onServiceConnected(IBinder iBinder) {
            synchronized (this) {
                this.mRemoteViewsFactory = IRemoteViewsFactory.Stub.asInterface(iBinder);
                final RemoteViewsAdapter remoteViewsAdapter = this.mAdapter.get();
                if (remoteViewsAdapter != null) {
                    remoteViewsAdapter.mWorkerQueue.post(new Runnable() { // from class: android.widget.RemoteViewsAdapter.RemoteViewsAdapterServiceConnection.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (remoteViewsAdapter.mNotifyDataSetChangedAfterOnServiceConnected) {
                                remoteViewsAdapter.onNotifyDataSetChanged();
                            } else {
                                IRemoteViewsFactory remoteViewsFactory = remoteViewsAdapter.mServiceConnection.getRemoteViewsFactory();
                                try {
                                    if (!remoteViewsFactory.isCreated()) {
                                        remoteViewsFactory.onDataSetChanged();
                                    }
                                } catch (RemoteException e) {
                                    Log.e(RemoteViewsAdapter.TAG, "Error notifying factory of data set changed in onServiceConnected(): " + e.getMessage());
                                    return;
                                } catch (RuntimeException e2) {
                                    Log.e(RemoteViewsAdapter.TAG, "Error notifying factory of data set changed in onServiceConnected(): " + e2.getMessage());
                                }
                                remoteViewsAdapter.updateTemporaryMetaData();
                                remoteViewsAdapter.mMainQueue.post(new Runnable() { // from class: android.widget.RemoteViewsAdapter.RemoteViewsAdapterServiceConnection.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        synchronized (remoteViewsAdapter.mCache) {
                                            remoteViewsAdapter.mCache.commitTemporaryMetaData();
                                        }
                                        RemoteAdapterConnectionCallback remoteAdapterConnectionCallback = (RemoteAdapterConnectionCallback) remoteViewsAdapter.mCallback.get();
                                        if (remoteAdapterConnectionCallback != null) {
                                            remoteAdapterConnectionCallback.onRemoteAdapterConnected();
                                        }
                                    }
                                });
                            }
                            remoteViewsAdapter.enqueueDeferredUnbindServiceMessage();
                            RemoteViewsAdapterServiceConnection.this.mIsConnected = true;
                            RemoteViewsAdapterServiceConnection.this.mIsConnecting = false;
                        }
                    });
                }
            }
        }

        @Override // com.android.internal.widget.IRemoteViewsAdapterConnection
        public void onServiceDisconnected() {
            synchronized (this) {
                this.mIsConnected = false;
                this.mIsConnecting = false;
                this.mRemoteViewsFactory = null;
                final RemoteViewsAdapter remoteViewsAdapter = this.mAdapter.get();
                if (remoteViewsAdapter != null) {
                    remoteViewsAdapter.mMainQueue.post(new Runnable() { // from class: android.widget.RemoteViewsAdapter.RemoteViewsAdapterServiceConnection.2
                        @Override // java.lang.Runnable
                        public void run() {
                            remoteViewsAdapter.mMainQueue.removeMessages(1);
                            RemoteAdapterConnectionCallback remoteAdapterConnectionCallback = (RemoteAdapterConnectionCallback) remoteViewsAdapter.mCallback.get();
                            if (remoteAdapterConnectionCallback != null) {
                                remoteAdapterConnectionCallback.onRemoteAdapterDisconnected();
                            }
                        }
                    });
                }
            }
        }

        public void unbind(Context context, int i, Intent intent) {
            synchronized (this) {
                try {
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    if (this.mAdapter.get() != null) {
                        appWidgetManager.unbindRemoteViewsService(context.getOpPackageName(), i, intent);
                    } else {
                        Slog.w(RemoteViewsAdapter.TAG, "unbind: adapter was null");
                    }
                    this.mIsConnecting = false;
                } catch (Exception e) {
                    Log.e("RemoteViewsAdapterServiceConnection", "unbind(): " + e.getMessage());
                    this.mIsConnecting = false;
                    this.mIsConnected = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsAdapter$RemoteViewsCacheKey.class */
    public static class RemoteViewsCacheKey {
        final Intent.FilterComparison filter;
        final int widgetId;

        RemoteViewsCacheKey(Intent.FilterComparison filterComparison, int i) {
            this.filter = filterComparison;
            this.widgetId = i;
        }

        public boolean equals(Object obj) {
            if (obj instanceof RemoteViewsCacheKey) {
                RemoteViewsCacheKey remoteViewsCacheKey = (RemoteViewsCacheKey) obj;
                return remoteViewsCacheKey.filter.equals(this.filter) && remoteViewsCacheKey.widgetId == this.widgetId;
            }
            return false;
        }

        public int hashCode() {
            return (this.filter == null ? 0 : this.filter.hashCode()) ^ (this.widgetId << 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsAdapter$RemoteViewsFrameLayout.class */
    public static class RemoteViewsFrameLayout extends FrameLayout {
        public RemoteViewsFrameLayout(Context context) {
            super(context);
        }

        public void onRemoteViewsLoaded(RemoteViews remoteViews, RemoteViews.OnClickHandler onClickHandler) {
            try {
                removeAllViews();
                addView(remoteViews.apply(getContext(), this, onClickHandler));
            } catch (Exception e) {
                Log.e(RemoteViewsAdapter.TAG, "Failed to apply RemoteViews.");
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsAdapter$RemoteViewsFrameLayoutRefSet.class */
    private class RemoteViewsFrameLayoutRefSet {
        private HashMap<Integer, LinkedList<RemoteViewsFrameLayout>> mReferences = new HashMap<>();
        private HashMap<RemoteViewsFrameLayout, LinkedList<RemoteViewsFrameLayout>> mViewToLinkedList = new HashMap<>();

        public RemoteViewsFrameLayoutRefSet() {
        }

        public void add(int i, RemoteViewsFrameLayout remoteViewsFrameLayout) {
            LinkedList<RemoteViewsFrameLayout> linkedList;
            Integer valueOf = Integer.valueOf(i);
            if (this.mReferences.containsKey(valueOf)) {
                linkedList = this.mReferences.get(valueOf);
            } else {
                linkedList = new LinkedList<>();
                this.mReferences.put(valueOf, linkedList);
            }
            this.mViewToLinkedList.put(remoteViewsFrameLayout, linkedList);
            linkedList.add(remoteViewsFrameLayout);
        }

        public void clear() {
            this.mReferences.clear();
            this.mViewToLinkedList.clear();
        }

        public void notifyOnRemoteViewsLoaded(int i, RemoteViews remoteViews) {
            if (remoteViews == null) {
                return;
            }
            Integer valueOf = Integer.valueOf(i);
            if (this.mReferences.containsKey(valueOf)) {
                LinkedList<RemoteViewsFrameLayout> linkedList = this.mReferences.get(valueOf);
                Iterator<RemoteViewsFrameLayout> it = linkedList.iterator();
                while (it.hasNext()) {
                    RemoteViewsFrameLayout next = it.next();
                    next.onRemoteViewsLoaded(remoteViews, RemoteViewsAdapter.this.mRemoteViewsOnClickHandler);
                    if (this.mViewToLinkedList.containsKey(next)) {
                        this.mViewToLinkedList.remove(next);
                    }
                }
                linkedList.clear();
                this.mReferences.remove(valueOf);
            }
        }

        public void removeView(RemoteViewsFrameLayout remoteViewsFrameLayout) {
            if (this.mViewToLinkedList.containsKey(remoteViewsFrameLayout)) {
                this.mViewToLinkedList.get(remoteViewsFrameLayout).remove(remoteViewsFrameLayout);
                this.mViewToLinkedList.remove(remoteViewsFrameLayout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsAdapter$RemoteViewsIndexMetaData.class */
    public static class RemoteViewsIndexMetaData {
        long itemId;
        int typeId;

        public RemoteViewsIndexMetaData(RemoteViews remoteViews, long j) {
            set(remoteViews, j);
        }

        public void set(RemoteViews remoteViews, long j) {
            this.itemId = j;
            if (remoteViews != null) {
                this.typeId = remoteViews.getLayoutId();
            } else {
                this.typeId = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/RemoteViewsAdapter$RemoteViewsMetaData.class */
    public static class RemoteViewsMetaData {
        int count;
        boolean hasStableIds;
        RemoteViews mFirstView;
        int mFirstViewHeight;
        private final HashMap<Integer, Integer> mTypeIdIndexMap = new HashMap<>();
        RemoteViews mUserLoadingView;
        int viewTypeCount;

        public RemoteViewsMetaData() {
            reset();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RemoteViewsFrameLayout createLoadingView(int i, View view, ViewGroup viewGroup, Object obj, LayoutInflater layoutInflater, RemoteViews.OnClickHandler onClickHandler) {
            Context context = viewGroup.getContext();
            RemoteViewsFrameLayout remoteViewsFrameLayout = new RemoteViewsFrameLayout(context);
            synchronized (obj) {
                boolean z = false;
                if (this.mUserLoadingView != null) {
                    try {
                        View apply = this.mUserLoadingView.apply(viewGroup.getContext(), viewGroup, onClickHandler);
                        apply.setTagInternal(R.id.rowTypeId, new Integer(0));
                        remoteViewsFrameLayout.addView(apply);
                        z = true;
                    } catch (Exception e) {
                        Log.w(RemoteViewsAdapter.TAG, "Error inflating custom loading view, using default loadingview instead", e);
                        z = false;
                    }
                }
                if (!z) {
                    if (this.mFirstViewHeight < 0) {
                        try {
                            View apply2 = this.mFirstView.apply(viewGroup.getContext(), viewGroup, onClickHandler);
                            apply2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                            this.mFirstViewHeight = apply2.getMeasuredHeight();
                            this.mFirstView = null;
                        } catch (Exception e2) {
                            this.mFirstViewHeight = Math.round(50.0f * context.getResources().getDisplayMetrics().density);
                            this.mFirstView = null;
                            Log.w(RemoteViewsAdapter.TAG, "Error inflating first RemoteViews" + e2);
                        }
                    }
                    TextView textView = (TextView) layoutInflater.inflate(R.layout.remote_views_adapter_default_loading_view, (ViewGroup) remoteViewsFrameLayout, false);
                    textView.setHeight(this.mFirstViewHeight);
                    textView.setTag(new Integer(0));
                    remoteViewsFrameLayout.addView(textView);
                }
            }
            return remoteViewsFrameLayout;
        }

        public int getMappedViewType(int i) {
            if (this.mTypeIdIndexMap.containsKey(Integer.valueOf(i))) {
                return this.mTypeIdIndexMap.get(Integer.valueOf(i)).intValue();
            }
            int size = this.mTypeIdIndexMap.size() + 1;
            this.mTypeIdIndexMap.put(Integer.valueOf(i), Integer.valueOf(size));
            return size;
        }

        public boolean isViewTypeInRange(int i) {
            return getMappedViewType(i) < this.viewTypeCount;
        }

        public void reset() {
            this.count = 0;
            this.viewTypeCount = 1;
            this.hasStableIds = true;
            this.mUserLoadingView = null;
            this.mFirstView = null;
            this.mFirstViewHeight = 0;
            this.mTypeIdIndexMap.clear();
        }

        public void set(RemoteViewsMetaData remoteViewsMetaData) {
            synchronized (remoteViewsMetaData) {
                this.count = remoteViewsMetaData.count;
                this.viewTypeCount = remoteViewsMetaData.viewTypeCount;
                this.hasStableIds = remoteViewsMetaData.hasStableIds;
                setLoadingViewTemplates(remoteViewsMetaData.mUserLoadingView, remoteViewsMetaData.mFirstView);
            }
        }

        public void setLoadingViewTemplates(RemoteViews remoteViews, RemoteViews remoteViews2) {
            this.mUserLoadingView = remoteViews;
            if (remoteViews2 != null) {
                this.mFirstView = remoteViews2;
                this.mFirstViewHeight = -1;
            }
        }
    }

    public RemoteViewsAdapter(Context context, Intent intent, RemoteAdapterConnectionCallback remoteAdapterConnectionCallback) {
        this.mDataReady = false;
        this.mContext = context;
        this.mIntent = intent;
        this.mAppWidgetId = intent.getIntExtra("remoteAdapterAppWidgetId", -1);
        this.mLayoutInflater = LayoutInflater.from(context);
        if (this.mIntent == null) {
            throw new IllegalArgumentException("Non-null Intent must be specified.");
        }
        this.mRequestedViews = new RemoteViewsFrameLayoutRefSet();
        if (intent.hasExtra("remoteAdapterAppWidgetId")) {
            intent.removeExtra("remoteAdapterAppWidgetId");
        }
        this.mWorkerThread = new HandlerThread("RemoteViewsCache-loader");
        this.mWorkerThread.start();
        this.mWorkerQueue = new Handler(this.mWorkerThread.getLooper());
        this.mMainQueue = new Handler(Looper.myLooper(), this);
        if (sCacheRemovalThread == null) {
            sCacheRemovalThread = new HandlerThread("RemoteViewsAdapter-cachePruner");
            sCacheRemovalThread.start();
            sCacheRemovalQueue = new Handler(sCacheRemovalThread.getLooper());
        }
        this.mCallback = new WeakReference<>(remoteAdapterConnectionCallback);
        this.mServiceConnection = new RemoteViewsAdapterServiceConnection(this);
        RemoteViewsCacheKey remoteViewsCacheKey = new RemoteViewsCacheKey(new Intent.FilterComparison(this.mIntent), this.mAppWidgetId);
        synchronized (sCachedRemoteViewsCaches) {
            if (sCachedRemoteViewsCaches.containsKey(remoteViewsCacheKey)) {
                this.mCache = sCachedRemoteViewsCaches.get(remoteViewsCacheKey);
                synchronized (this.mCache.mMetaData) {
                    if (this.mCache.mMetaData.count > 0) {
                        this.mDataReady = true;
                    }
                }
            } else {
                this.mCache = new FixedSizeRemoteViewsCache(40);
            }
            if (!this.mDataReady) {
                requestBindService();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enqueueDeferredUnbindServiceMessage() {
        this.mMainQueue.removeMessages(1);
        this.mMainQueue.sendEmptyMessageDelayed(1, 5000L);
    }

    private int getConvertViewTypeId(View view) {
        int i = -1;
        if (view != null) {
            Object tag = view.getTag(R.id.rowTypeId);
            i = -1;
            if (tag != null) {
                i = ((Integer) tag).intValue();
            }
        }
        return i;
    }

    private ArrayList<Integer> getVisibleWindow(int i, int i2, int i3) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if ((i != 0 || i2 != 0) && i >= 0 && i2 >= 0) {
            if (i > i2) {
                while (i < i3) {
                    arrayList.add(Integer.valueOf(i));
                    i++;
                }
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 > i2) {
                        break;
                    }
                    arrayList.add(Integer.valueOf(i5));
                    i4 = i5 + 1;
                }
            } else {
                while (i <= i2) {
                    arrayList.add(Integer.valueOf(i));
                    i++;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNextIndexInBackground() {
        this.mWorkerQueue.post(new Runnable() { // from class: android.widget.RemoteViewsAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (RemoteViewsAdapter.this.mServiceConnection.isConnected()) {
                    synchronized (RemoteViewsAdapter.this.mCache) {
                        i = RemoteViewsAdapter.this.mCache.getNextIndexToLoad()[0];
                    }
                    if (i <= -1) {
                        RemoteViewsAdapter.this.enqueueDeferredUnbindServiceMessage();
                        return;
                    }
                    RemoteViewsAdapter.this.updateRemoteViews(i, true);
                    RemoteViewsAdapter.this.loadNextIndexInBackground();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNotifyDataSetChanged() {
        int i;
        ArrayList<Integer> visibleWindow;
        try {
            this.mServiceConnection.getRemoteViewsFactory().onDataSetChanged();
            synchronized (this.mCache) {
                this.mCache.reset();
            }
            updateTemporaryMetaData();
            synchronized (this.mCache.getTemporaryMetaData()) {
                i = this.mCache.getTemporaryMetaData().count;
                visibleWindow = getVisibleWindow(this.mVisibleWindowLowerBound, this.mVisibleWindowUpperBound, i);
            }
            Iterator<Integer> it = visibleWindow.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue < i) {
                    updateRemoteViews(intValue, false);
                }
            }
            this.mMainQueue.post(new Runnable() { // from class: android.widget.RemoteViewsAdapter.5
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (RemoteViewsAdapter.this.mCache) {
                        RemoteViewsAdapter.this.mCache.commitTemporaryMetaData();
                    }
                    RemoteViewsAdapter.this.superNotifyDataSetChanged();
                    RemoteViewsAdapter.this.enqueueDeferredUnbindServiceMessage();
                }
            });
            this.mNotifyDataSetChangedAfterOnServiceConnected = false;
        } catch (RemoteException e) {
            Log.e(TAG, "Error in updateNotifyDataSetChanged(): " + e.getMessage());
        } catch (RuntimeException e2) {
            Log.e(TAG, "Error in updateNotifyDataSetChanged(): " + e2.getMessage());
        }
    }

    private void processException(String str, Exception exc) {
        Log.e(TAG, "Error in " + str + ": " + exc.getMessage());
        RemoteViewsMetaData metaData = this.mCache.getMetaData();
        synchronized (metaData) {
            metaData.reset();
        }
        synchronized (this.mCache) {
            this.mCache.reset();
        }
        this.mMainQueue.post(new Runnable() { // from class: android.widget.RemoteViewsAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                RemoteViewsAdapter.this.superNotifyDataSetChanged();
            }
        });
    }

    private boolean requestBindService() {
        if (!this.mServiceConnection.isConnected()) {
            this.mServiceConnection.bind(this.mContext, this.mAppWidgetId, this.mIntent);
        }
        this.mMainQueue.removeMessages(1);
        return this.mServiceConnection.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteViews(final int i, boolean z) {
        boolean isViewTypeInRange;
        int i2;
        IRemoteViewsFactory remoteViewsFactory = this.mServiceConnection.getRemoteViewsFactory();
        try {
            final RemoteViews viewAt = remoteViewsFactory.getViewAt(i);
            long itemId = remoteViewsFactory.getItemId(i);
            if (viewAt == null) {
                Log.e(TAG, "Error in updateRemoteViews(" + i + "):  null RemoteViews returned from RemoteViewsFactory.");
                return;
            }
            int layoutId = viewAt.getLayoutId();
            RemoteViewsMetaData metaData = this.mCache.getMetaData();
            synchronized (metaData) {
                isViewTypeInRange = metaData.isViewTypeInRange(layoutId);
                i2 = this.mCache.mMetaData.count;
            }
            synchronized (this.mCache) {
                if (isViewTypeInRange) {
                    this.mCache.insert(i, viewAt, itemId, getVisibleWindow(this.mVisibleWindowLowerBound, this.mVisibleWindowUpperBound, i2));
                    if (z) {
                        this.mMainQueue.post(new Runnable() { // from class: android.widget.RemoteViewsAdapter.4
                            @Override // java.lang.Runnable
                            public void run() {
                                RemoteViewsAdapter.this.mRequestedViews.notifyOnRemoteViewsLoaded(i, viewAt);
                            }
                        });
                    }
                } else {
                    Log.e(TAG, "Error: widget's RemoteViewsFactory returns more view types than  indicated by getViewTypeCount() ");
                }
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Error in updateRemoteViews(" + i + "): " + e.getMessage());
        } catch (RuntimeException e2) {
            Log.e(TAG, "Error in updateRemoteViews(" + i + "): " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTemporaryMetaData() {
        IRemoteViewsFactory remoteViewsFactory = this.mServiceConnection.getRemoteViewsFactory();
        try {
            boolean hasStableIds = remoteViewsFactory.hasStableIds();
            int viewTypeCount = remoteViewsFactory.getViewTypeCount();
            int count = remoteViewsFactory.getCount();
            RemoteViews loadingView = remoteViewsFactory.getLoadingView();
            RemoteViews remoteViews = null;
            if (count > 0) {
                remoteViews = null;
                if (loadingView == null) {
                    remoteViews = remoteViewsFactory.getViewAt(0);
                }
            }
            RemoteViewsMetaData temporaryMetaData = this.mCache.getTemporaryMetaData();
            synchronized (temporaryMetaData) {
                temporaryMetaData.hasStableIds = hasStableIds;
                temporaryMetaData.viewTypeCount = viewTypeCount + 1;
                temporaryMetaData.count = count;
                temporaryMetaData.setLoadingViewTemplates(loadingView, remoteViews);
            }
        } catch (RemoteException e) {
            processException("updateMetaData", e);
        } catch (RuntimeException e2) {
            processException("updateMetaData", e2);
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mWorkerThread != null) {
                this.mWorkerThread.quit();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i;
        RemoteViewsMetaData metaData = this.mCache.getMetaData();
        synchronized (metaData) {
            i = metaData.count;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        synchronized (this.mCache) {
            if (this.mCache.containsMetaDataAt(i)) {
                return this.mCache.getMetaDataAt(i).itemId;
            }
            return 0L;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int mappedViewType;
        synchronized (this.mCache) {
            if (this.mCache.containsMetaDataAt(i)) {
                int i2 = this.mCache.getMetaDataAt(i).typeId;
                RemoteViewsMetaData metaData = this.mCache.getMetaData();
                synchronized (metaData) {
                    mappedViewType = metaData.getMappedViewType(i2);
                }
                return mappedViewType;
            }
            return 0;
        }
    }

    public Intent getRemoteViewsServiceIntent() {
        return this.mIntent;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0177 A[Catch: all -> 0x0165, TRY_ENTER, TryCatch #5 {, blocks: (B:4:0x0009, B:7:0x0023, B:9:0x002a, B:14:0x003f, B:18:0x004f, B:20:0x0056, B:22:0x006d, B:28:0x00a7, B:30:0x00ad, B:38:0x00ee, B:40:0x00f4, B:70:0x0177, B:72:0x017c, B:52:0x015c, B:54:0x0162, B:74:0x017e, B:75:0x0188, B:80:0x01a2, B:81:0x01b8, B:33:0x00b1, B:77:0x018b, B:78:0x01a0), top: B:98:0x0009 }] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.RemoteViewsAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        int i;
        RemoteViewsMetaData metaData = this.mCache.getMetaData();
        synchronized (metaData) {
            i = metaData.viewTypeCount;
        }
        return i;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.mServiceConnection.isConnected()) {
                    this.mServiceConnection.unbind(this.mContext, this.mAppWidgetId, this.mIntent);
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        boolean z;
        RemoteViewsMetaData metaData = this.mCache.getMetaData();
        synchronized (metaData) {
            z = metaData.hasStableIds;
        }
        return z;
    }

    public boolean isDataReady() {
        return this.mDataReady;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return getCount() <= 0;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.mMainQueue.removeMessages(1);
        if (this.mServiceConnection.isConnected()) {
            this.mWorkerQueue.post(new Runnable() { // from class: android.widget.RemoteViewsAdapter.6
                @Override // java.lang.Runnable
                public void run() {
                    RemoteViewsAdapter.this.onNotifyDataSetChanged();
                }
            });
        } else if (this.mNotifyDataSetChangedAfterOnServiceConnected) {
        } else {
            this.mNotifyDataSetChangedAfterOnServiceConnected = true;
            requestBindService();
        }
    }

    public void saveRemoteViewsCache() {
        int i;
        int size;
        final RemoteViewsCacheKey remoteViewsCacheKey = new RemoteViewsCacheKey(new Intent.FilterComparison(this.mIntent), this.mAppWidgetId);
        synchronized (sCachedRemoteViewsCaches) {
            if (sRemoteViewsCacheRemoveRunnables.containsKey(remoteViewsCacheKey)) {
                sCacheRemovalQueue.removeCallbacks(sRemoteViewsCacheRemoveRunnables.get(remoteViewsCacheKey));
                sRemoteViewsCacheRemoveRunnables.remove(remoteViewsCacheKey);
            }
            synchronized (this.mCache.mMetaData) {
                i = this.mCache.mMetaData.count;
            }
            synchronized (this.mCache) {
                size = this.mCache.mIndexRemoteViews.size();
            }
            if (i > 0 && size > 0) {
                sCachedRemoteViewsCaches.put(remoteViewsCacheKey, this.mCache);
            }
            Runnable runnable = new Runnable() { // from class: android.widget.RemoteViewsAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (RemoteViewsAdapter.sCachedRemoteViewsCaches) {
                        if (RemoteViewsAdapter.sCachedRemoteViewsCaches.containsKey(remoteViewsCacheKey)) {
                            RemoteViewsAdapter.sCachedRemoteViewsCaches.remove(remoteViewsCacheKey);
                        }
                        if (RemoteViewsAdapter.sRemoteViewsCacheRemoveRunnables.containsKey(remoteViewsCacheKey)) {
                            RemoteViewsAdapter.sRemoteViewsCacheRemoveRunnables.remove(remoteViewsCacheKey);
                        }
                    }
                }
            };
            sRemoteViewsCacheRemoveRunnables.put(remoteViewsCacheKey, runnable);
            sCacheRemovalQueue.postDelayed(runnable, 5000L);
        }
    }

    public void setRemoteViewsOnClickHandler(RemoteViews.OnClickHandler onClickHandler) {
        this.mRemoteViewsOnClickHandler = onClickHandler;
    }

    public void setVisibleRangeHint(int i, int i2) {
        this.mVisibleWindowLowerBound = i;
        this.mVisibleWindowUpperBound = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void superNotifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
