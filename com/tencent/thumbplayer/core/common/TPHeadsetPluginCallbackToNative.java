package com.tencent.thumbplayer.core.common;

import com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPHeadsetPluginCallbackToNative.class */
public class TPHeadsetPluginCallbackToNative implements TPHeadsetPluginDetector.HeadsetPluginListener {
    private static final String TAG = "TPHeadsetPluginCallback";
    private long mNativeContext;

    private TPHeadsetPluginCallbackToNative(long j) {
        this.mNativeContext = j;
    }

    private native void _onAudioRouteChanged(Set<Integer> set, Set<Integer> set2);

    private long getNativeContext() {
        return this.mNativeContext;
    }

    private void registerCallback() {
        TPHeadsetPluginDetector.addHeadsetPluginListener(this);
    }

    private void unregisterCallback() {
        TPHeadsetPluginDetector.removeHeadsetPluginListener(this);
    }

    @Override // com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.HeadsetPluginListener
    public void onHeadsetPlugin(Set<Integer> set, Set<Integer> set2) {
        TPNativeLog.printLog(2, TAG, "onHeadsetPlugin: oldOutputs: " + set + ", newOutputs: " + set2);
        _onAudioRouteChanged(set, set2);
    }
}
