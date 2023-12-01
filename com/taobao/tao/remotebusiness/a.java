package com.taobao.tao.remotebusiness;

import com.taobao.tao.remotebusiness.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopResponse;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static List f21218a = new ArrayList();
    private static Lock b = new ReentrantLock();

    public static void a() {
        b.lock();
        try {
            if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
                TBSdkLog.b("mtop.rb-RequestPool", "retry all request, current size=" + f21218a.size());
            }
            Iterator it = new ArrayList(f21218a).iterator();
            while (it.hasNext()) {
                ((MtopBusiness) it.next()).retryRequest();
            }
        } finally {
            b.unlock();
        }
    }

    public static void a(MtopBusiness mtopBusiness) {
        b.lock();
        try {
            f21218a.add(mtopBusiness);
            TBSdkLog.b("mtop.rb-RequestPool", mtopBusiness.getSeqNo(), "request add to request pool");
            b.unlock();
        } catch (Throwable th) {
            b.unlock();
            throw th;
        }
    }

    public static void a(String str, String str2) {
        b.lock();
        try {
            TBSdkLog.b("mtop.rb-RequestPool", "session fail  all request");
            for (MtopBusiness mtopBusiness : f21218a) {
                MtopResponse mtopResponse = mtopBusiness.request != null ? new MtopResponse(mtopBusiness.request.a(), mtopBusiness.request.b(), str, str2) : new MtopResponse(str, str2);
                b a2 = com.taobao.tao.remotebusiness.a.a.a(null, null, mtopBusiness);
                a2.e = mtopResponse;
                com.taobao.tao.remotebusiness.a.a.a().obtainMessage(3, a2).sendToTarget();
            }
            f21218a.clear();
            b.unlock();
        } catch (Throwable th) {
            b.unlock();
            throw th;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0031 -> B:4:0x001d). Please submit an issue!!! */
    public static void b(MtopBusiness mtopBusiness) {
        b.lock();
        try {
            TBSdkLog.b("mtop.rb-RequestPool", mtopBusiness.getSeqNo(), "request remove from request pool");
            f21218a.remove(mtopBusiness);
        } catch (Exception e) {
        } catch (Throwable th) {
            b.unlock();
            throw th;
        }
        b.unlock();
    }
}
