package com.danlan.android.cognition.collector.listener;

import com.danlan.android.cognition.Cognition;
import com.danlan.android.cognition.collector.base.BaseDeviceInfoCollector;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/listener/DeviceInfoCollectListener.class */
public interface DeviceInfoCollectListener {
    void onAllDone(Cognition cognition);

    void onSingleFailure(BaseDeviceInfoCollector baseDeviceInfoCollector, String str);

    void onSingleSuccess(BaseDeviceInfoCollector baseDeviceInfoCollector);

    void onStart();
}
