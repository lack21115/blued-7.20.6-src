package com.amap.api.trace;

import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/trace/LBSTraceBase.class */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener);

    void setLocationInterval(long j);

    void setTraceStatusInterval(int i);

    void startTrace(TraceStatusListener traceStatusListener);

    void stopTrace();
}
