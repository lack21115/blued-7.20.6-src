package com.danlan.android.cognition.collector.listener;

import com.danlan.android.cognition.Cognition;
import com.danlan.android.cognition.collector.base.BaseDeviceInfoCollector;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/listener/CollectorStateObserver.class */
public interface CollectorStateObserver {
    void onCollectionFailure(Cognition.InnerCollectListener innerCollectListener, BaseDeviceInfoCollector baseDeviceInfoCollector, String str);

    void onCollectionSuccess(Cognition.InnerCollectListener innerCollectListener, BaseDeviceInfoCollector baseDeviceInfoCollector);
}
