package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.os.Vibrator;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/api/IVibratorUtil.class */
public interface IVibratorUtil {
    void cancelVibrate(Context context, Vibrator vibrator);

    void vibrate(Context context, Vibrator vibrator, long j);
}
