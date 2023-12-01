package com.bytedance.sdk.openadsdk;

import android.os.Bundle;
import java.io.Serializable;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdEvent.class */
public interface TTAdEvent extends Serializable {
    void onEvent(int i, Bundle bundle);
}
