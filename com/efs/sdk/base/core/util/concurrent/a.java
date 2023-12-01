package com.efs.sdk.base.core.util.concurrent;

import android.os.HandlerThread;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/concurrent/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f8189a;

    static {
        HandlerThread handlerThread = new HandlerThread("efs-base", 10);
        f8189a = handlerThread;
        handlerThread.start();
    }
}
