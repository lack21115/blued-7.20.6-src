package com.amap.api.trace;

import android.content.Context;
import com.amap.api.col.p0003sl.dw;
import com.amap.api.col.p0003sl.hk;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.col.p0003sl.hy;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/trace/LBSTraceClient.class */
public class LBSTraceClient {
    public static final String LOCATE_TIMEOUT_ERROR = "定位超时";
    public static final String MIN_GRASP_POINT_ERROR = "轨迹点太少或距离太近,轨迹纠偏失败";
    public static final String TRACE_SUCCESS = "纠偏成功";
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;
    private static LBSTraceBase a;
    private static volatile LBSTraceClient b;

    private LBSTraceClient() {
    }

    public LBSTraceClient(Context context) throws Exception {
        a(context);
    }

    private static void a() {
        a = null;
        b = null;
    }

    private static void a(Context context) throws Exception {
        hy a2 = hx.a(context, dw.a());
        if (a2.a != hx.c.SuccessCode) {
            throw new Exception(a2.b);
        }
        if (context != null) {
            a = new hk(context.getApplicationContext());
        }
    }

    public static LBSTraceClient getInstance(Context context) throws Exception {
        if (b == null) {
            synchronized (LBSTraceClient.class) {
                try {
                    if (b == null) {
                        a(context);
                        b = new LBSTraceClient();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void destroy() {
        LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.destroy();
            a();
        }
    }

    public void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
        LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.queryProcessedTrace(i, list, i2, traceListener);
        }
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.startTrace(traceStatusListener);
        }
    }

    public void stopTrace() {
        LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.stopTrace();
        }
    }
}
