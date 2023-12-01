package com.danlan.android.cognition.collector.base;

import android.content.Context;
import com.danlan.android.cognition.Cognition;
import com.danlan.android.cognition.Logger;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.listener.CollectorStateObserver;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/base/BaseDeviceInfoCollector.class */
public abstract class BaseDeviceInfoCollector {
    private static String TAG = StringFog.decrypt("Y0JXRmVGUkhCRm1NR0xnTk1PQUBVTFY=");
    private static final Class<?>[] mConstructorSignature = {Context.class, SafeJSONObject.class};
    public SafeJSONObject collectJsonData;
    private HashMap<CollectorMap, SubCollector> collectorsMap;
    public Context mContext;
    private CountDownLatch mCountDownLatch;
    private Object mLock = new Object();
    private CollectorStateObserver mStateObserver;

    public BaseDeviceInfoCollector(Context context, String str) {
        this.mContext = context;
    }

    private SubCollector createSubCollector(CollectorMap collectorMap) {
        Class<? extends SubCollector> clazz = collectorMap.getClazz();
        if (clazz != null) {
            try {
                Constructor<? extends SubCollector> constructor = clazz.getConstructor(mConstructorSignature);
                constructor.setAccessible(true);
                SubCollector newInstance = constructor.newInstance(this.mContext, this.collectJsonData);
                this.collectorsMap.put(collectorMap, newInstance);
                return newInstance;
            } catch (Exception e) {
                Logger.e("" + e.getMessage());
                return null;
            }
        }
        return null;
    }

    private void doCollect(final Cognition.InnerCollectListener innerCollectListener) {
        new Thread(new Runnable() { // from class: com.danlan.android.cognition.collector.base.BaseDeviceInfoCollector.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.d(StringFog.decrypt("RUxnTE1PQUJV"));
                synchronized (BaseDeviceInfoCollector.this.mLock) {
                    BaseDeviceInfoCollector.this.doCollectAutomatically();
                    BaseDeviceInfoCollector.this.notifyCollectionSuccess(innerCollectListener);
                }
            }
        }).start();
    }

    public BaseDeviceInfoCollector bindObserver(CollectorStateObserver collectorStateObserver) {
        this.mStateObserver = collectorStateObserver;
        return this;
    }

    public abstract List<CollectorMap> collectors();

    public void doCollectAutomatically() {
        List<CollectorMap> collectors;
        this.mCountDownLatch = new CountDownLatch(collectors() != null ? collectors().size() : 0);
        HashMap<CollectorMap, SubCollector> hashMap = this.collectorsMap;
        if ((hashMap == null || hashMap.size() == 0) && (collectors = collectors()) != null && collectors.size() > 0) {
            this.collectorsMap = new HashMap<>(collectors.size());
            for (CollectorMap collectorMap : collectors) {
                createSubCollector(collectorMap);
            }
        }
        for (SubCollector subCollector : this.collectorsMap.values()) {
            subCollector.resetCountDownLatch(this.mCountDownLatch);
            subCollector.doCollect();
        }
    }

    public SafeJSONObject getDeviceData() {
        return this.collectJsonData;
    }

    public String getJsonInfo() {
        return this.collectJsonData.toString();
    }

    public final void notifyCollectionFailure(Cognition.InnerCollectListener innerCollectListener, String str) {
        CollectorStateObserver collectorStateObserver = this.mStateObserver;
        if (collectorStateObserver != null) {
            collectorStateObserver.onCollectionFailure(innerCollectListener, this, str);
        }
    }

    public final void notifyCollectionSuccess(Cognition.InnerCollectListener innerCollectListener) {
        try {
            CollectorStateObserver collectorStateObserver = this.mStateObserver;
            if (collectorStateObserver != null) {
                collectorStateObserver.onCollectionSuccess(innerCollectListener, this);
            }
        } catch (Exception e) {
            Logger.e(e.getMessage());
        }
    }

    public void release() {
        HashMap<CollectorMap, SubCollector> hashMap = this.collectorsMap;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (SubCollector subCollector : this.collectorsMap.values()) {
            subCollector.release();
        }
    }

    public final void startCollectAutomatically(Cognition.InnerCollectListener innerCollectListener) {
        doCollect(innerCollectListener);
    }
}
