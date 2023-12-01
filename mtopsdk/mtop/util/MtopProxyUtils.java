package mtopsdk.mtop.util;

import java.util.Arrays;
import java.util.List;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.NetworkListenerAdapter;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/MtopProxyUtils.class */
public class MtopProxyUtils {
    private static final List a = Arrays.asList("mtop.common.gettimestamp$*");

    public static List a() {
        return a;
    }

    public static NetworkListenerAdapter a(MtopProxy mtopProxy) {
        NetworkListenerAdapter networkListenerAdapter;
        NetworkListenerAdapter networkListenerAdapter2;
        if (mtopProxy == null || mtopProxy.f() == null) {
            return null;
        }
        try {
            networkListenerAdapter = new NetworkListenerAdapter(mtopProxy);
            try {
                MtopListener f = mtopProxy.f();
                if (f instanceof MtopCallback.MtopFinishListener) {
                    networkListenerAdapter.a = (MtopCallback.MtopFinishListener) f;
                }
                networkListenerAdapter2 = networkListenerAdapter;
                if (f instanceof MtopCallback.MtopHeaderListener) {
                    networkListenerAdapter.b = (MtopCallback.MtopHeaderListener) f;
                    return networkListenerAdapter;
                }
            } catch (Throwable th) {
                th = th;
                TBSdkLog.a("mtopsdk.MtopProxyUtils", "[convertCallbackListener] convert NetworkListenerAdapter error. apiKey=" + mtopProxy.d().f(), th);
                networkListenerAdapter2 = networkListenerAdapter;
                return networkListenerAdapter2;
            }
        } catch (Throwable th2) {
            th = th2;
            networkListenerAdapter = null;
        }
        return networkListenerAdapter2;
    }
}
