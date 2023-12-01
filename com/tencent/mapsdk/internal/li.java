package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.mi;
import com.tencent.mapsdk.shell.events.ReportEvent;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/li.class */
public interface li extends mi.a {
    void onPauseReport();

    void onReport(ReportEvent reportEvent);

    void onResumeReport();
}
