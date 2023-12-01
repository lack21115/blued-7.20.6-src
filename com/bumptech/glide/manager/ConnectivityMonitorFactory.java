package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.ConnectivityMonitor;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/ConnectivityMonitorFactory.class */
public interface ConnectivityMonitorFactory {
    ConnectivityMonitor a(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener);
}
