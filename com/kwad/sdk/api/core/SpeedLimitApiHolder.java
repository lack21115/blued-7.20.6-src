package com.kwad.sdk.api.core;

import com.kwad.sdk.api.loader.Loader;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/SpeedLimitApiHolder.class */
public class SpeedLimitApiHolder {
    private static volatile SpeedLimitApi instance;

    public static SpeedLimitApi getInstance() {
        if (instance == null) {
            synchronized (SpeedLimitApiHolder.class) {
                try {
                    if (instance == null) {
                        instance = (SpeedLimitApi) Loader.get().newInstance(SpeedLimitApi.class);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }
}
