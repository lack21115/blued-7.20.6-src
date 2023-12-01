package com.tencent.thumbplayer.tplayer.a;

import android.content.Context;
import com.tencent.thumbplayer.api.reportv2.ITPReportChannelListener;
import com.tencent.thumbplayer.api.reportv2.ITPReportInfoGetter;
import com.tencent.thumbplayer.api.reportv2.TPExtendCommonKey;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.d.b;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/c.class */
public class c implements a {
    private static com.tencent.thumbplayer.utils.c i;

    /* renamed from: a  reason: collision with root package name */
    protected ITPReportInfoGetter f25696a;
    protected com.tencent.thumbplayer.tplayer.a.a.a b;

    /* renamed from: c  reason: collision with root package name */
    protected CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> f25697c;
    protected Context d;
    protected l e;
    protected j f = null;
    protected int g = 0;
    protected Map<String, Object> h = new HashMap();

    private void a(Context context, String str) {
        synchronized (this) {
            if (i != null) {
                return;
            }
            i = new com.tencent.thumbplayer.utils.c(this.d, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (c(entry.getKey())) {
                map2.put(entry.getKey(), entry.getValue());
            } else if (b(entry.getKey())) {
                map3.put(entry.getKey(), entry.getValue());
            } else {
                TPLogUtil.e("TPBaseReporter", "invalid extend info <" + entry.getKey() + ", " + entry.getValue() + "> from ITPReportInfoGetter, key valid!");
            }
        }
    }

    protected static boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("ext_");
    }

    private void c() {
        synchronized (this) {
            if (i == null) {
                return;
            }
            Iterator<String> it = i.b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                String d = d(next);
                com.tencent.thumbplayer.tplayer.a.b.a aVar = (com.tencent.thumbplayer.tplayer.a.b.a) i.b(next);
                if (d != null && aVar != null) {
                    Map<String, String> b = aVar.b();
                    b(d, b);
                    com.tencent.thumbplayer.common.a.b.a(d, b);
                    TPLogUtil.i("TPBaseReporter", "report cached reportEvent, key:".concat(String.valueOf(next)));
                }
            }
            i.c();
        }
    }

    protected static boolean c(String str) {
        if (str == null) {
            return false;
        }
        Field[] declaredFields = TPExtendCommonKey.class.getDeclaredFields();
        int length = declaredFields.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            Field field = declaredFields[i3];
            try {
                field.setAccessible(true);
                String str2 = (String) field.get(TPExtendCommonKey.class);
                if (str2 != null && str2.equals(str)) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                TPLogUtil.e("TPBaseReporter", e);
            }
            i2 = i3 + 1;
        }
    }

    private static String d(String str) {
        Field[] declaredFields = i.class.getDeclaredFields();
        int length = declaredFields.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return null;
            }
            Field field = declaredFields[i3];
            field.setAccessible(true);
            if (field.getType() == String.class) {
                try {
                    String str2 = (String) field.get(i.class);
                    if (str2 != null && str.endsWith(str2)) {
                        return str2;
                    }
                } catch (IllegalAccessException e) {
                    TPLogUtil.w("TPBaseReporter", "fail to get value of field(" + field.getName() + ") in TPReportEventId.class)");
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TPDynamicStatisticParams a(boolean z) {
        com.tencent.thumbplayer.tplayer.a.a.a aVar = this.b;
        if (aVar == null) {
            TPLogUtil.e("TPBaseReporter", "getDynamicStatParamsFromCore failed, mPlayerInfoGetter is null, return default value");
            return new TPDynamicStatisticParams();
        }
        return aVar.a(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TPGeneralPlayFlowParams a(b.a aVar) {
        TPGeneralPlayFlowParams tPGeneralPlayFlowParams;
        if (aVar instanceof b.n) {
            tPGeneralPlayFlowParams = ((b.n) aVar).d();
        } else if (aVar instanceof b.l) {
            tPGeneralPlayFlowParams = ((b.l) aVar).d();
        } else if (aVar instanceof b.i) {
            tPGeneralPlayFlowParams = ((b.i) aVar).f();
        } else {
            TPLogUtil.e("TPBaseReporter", "event info do not have generalPlayFlowParams");
            tPGeneralPlayFlowParams = null;
        }
        TPGeneralPlayFlowParams tPGeneralPlayFlowParams2 = tPGeneralPlayFlowParams;
        if (tPGeneralPlayFlowParams == null) {
            tPGeneralPlayFlowParams2 = new TPGeneralPlayFlowParams();
        }
        return tPGeneralPlayFlowParams2;
    }

    @Override // com.tencent.thumbplayer.tplayer.a.a
    public void a() {
        CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> copyOnWriteArrayList = this.f25697c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.f25697c = null;
        }
    }

    @Override // com.tencent.thumbplayer.tplayer.a.a
    public void a(int i2, b.a aVar) {
    }

    @Override // com.tencent.thumbplayer.tplayer.a.a
    public void a(Context context, l lVar) {
        this.d = context;
        this.f25697c = new CopyOnWriteArrayList<>();
        this.e = lVar;
        this.f = new j(context);
        a(context, "TPReporterCache");
        c();
    }

    @Override // com.tencent.thumbplayer.tplayer.a.a
    public void a(ITPReportChannelListener iTPReportChannelListener) {
        CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> copyOnWriteArrayList = this.f25697c;
        if (copyOnWriteArrayList == null) {
            TPLogUtil.w("TPBaseReporter", "mReportChannelListenerList is null");
            return;
        }
        Iterator<WeakReference<ITPReportChannelListener>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTPReportChannelListener) {
                TPLogUtil.w("TPBaseReporter", "mReportChannelListenerList has contain reportChannelListener");
                return;
            }
        }
        this.f25697c.add(new WeakReference<>(iTPReportChannelListener));
    }

    @Override // com.tencent.thumbplayer.tplayer.a.a
    public void a(ITPReportInfoGetter iTPReportInfoGetter) {
        this.f25696a = iTPReportInfoGetter;
    }

    @Override // com.tencent.thumbplayer.tplayer.a.a
    public void a(com.tencent.thumbplayer.tplayer.a.a.a aVar) {
        this.b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
        com.tencent.thumbplayer.tplayer.a.a.a aVar = this.b;
        if (aVar == null) {
            TPLogUtil.e("TPBaseReporter", "fillStreamInfoToCommonParams fail, not set mPlayerInfoGetter");
            return;
        }
        TPGeneralPlayFlowParams a2 = aVar.a();
        bVar.f25674a.a(this.e.i);
        bVar.f25674a.a(a2.mPlayerBaseMediaParams.mDurationMs);
        bVar.f25674a.e(a2.mPlayerBaseMediaParams.mHlsSourceType);
        bVar.f25674a.f(this.e.g);
        bVar.f25674a.g(this.e.f);
        bVar.f25674a.i(a2.mPlayerBaseMediaParams.mFormatContainer);
        bVar.f25674a.h(a2.mPlayerBaseMediaParams.mVideoEncodeFormat);
        bVar.f25674a.i(a2.mPlayerBaseMediaParams.mAudioEncodeFormat);
        bVar.f25674a.j(a2.mPlayerBaseMediaParams.mSubtitleEncodeFormat);
        bVar.f25674a.b(a2.mPlayerBaseMediaParams.mVideoStreamBitrateKbps);
        bVar.f25674a.a(a2.mPlayerBaseMediaParams.mVideoFrameRate);
        bVar.f25674a.j(this.e.e);
        bVar.f25674a.k(a2.mPlayerBaseMediaParams.mVideoWidth + "*" + a2.mPlayerBaseMediaParams.mVideoHeight);
        bVar.f25674a.l(TPDownloadProxyHelper.getNativeLibVersion());
        bVar.f25674a.k(bVar.b);
        bVar.f25674a.o(bVar.e);
        bVar.f25674a.m(bVar.d);
        bVar.f25674a.n(bVar.f25675c);
        bVar.f25674a.l(this.e.h);
        this.h.put("buffermintotaldurationms", Long.valueOf(a2.mPlayerConfigParams.mBufferMinTotalDurationMs));
        this.h.put("buffermaxtotaldurationms", Long.valueOf(a2.mPlayerConfigParams.mBufferMaxTotalDurationMs));
        this.h.put("preloadtotaldurationms", Long.valueOf(a2.mPlayerConfigParams.mPreloadTotalDurationMs));
        this.h.put("minbufferingdurationms", Long.valueOf(a2.mPlayerConfigParams.mMinBufferingDurationMs));
        this.h.put("minbufferingtimems", Long.valueOf(a2.mPlayerConfigParams.mMinBufferingTimeMs));
        this.h.put("maxbufferingtimems", Long.valueOf(a2.mPlayerConfigParams.mMaxBufferingTimeMs));
        this.h.put("reducelatencyaction", Integer.valueOf(a2.mPlayerConfigParams.mReduceLatencyAction));
        this.h.put("reducelatencyspeed", Float.valueOf(a2.mPlayerConfigParams.mReduceLatencyPlaySpeed));
        this.h.put("buffertype", Integer.valueOf(a2.mPlayerConfigParams.mBufferType));
        try {
            bVar.f25674a.p(new JSONObject(this.h).toString());
        } catch (NullPointerException e) {
            TPLogUtil.e("TPBaseReporter", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        synchronized (this) {
            if (i == null) {
                return;
            }
            Iterator<String> it = i.b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.startsWith(str)) {
                    i.a(next);
                    TPLogUtil.i("TPBaseReporter", "remove cache, key:".concat(String.valueOf(next)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, com.tencent.thumbplayer.tplayer.a.b.a aVar) {
        synchronized (this) {
            if (i == null) {
                return;
            }
            com.tencent.thumbplayer.utils.c cVar = i;
            cVar.a(aVar.a() + str, aVar);
            TPLogUtil.i("TPBaseReporter", "write cache, flowid:" + aVar.a() + ", reportId:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = ":{";
        while (true) {
            sb.append(str2);
            if (!it.hasNext()) {
                sb.append("}");
                TPLogUtil.i("TPBaseReporter", sb.toString());
                return;
            }
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append(":");
            sb.append(next.getValue());
            str2 = ",";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TPDynamicStatisticParams b(b.a aVar) {
        TPDynamicStatisticParams tPDynamicStatisticParams;
        if (aVar instanceof b.n) {
            tPDynamicStatisticParams = ((b.n) aVar).e();
        } else if (aVar instanceof b.l) {
            tPDynamicStatisticParams = ((b.l) aVar).e();
        } else if (aVar instanceof b.i) {
            tPDynamicStatisticParams = ((b.i) aVar).g();
        } else {
            TPLogUtil.e("TPBaseReporter", "event info do not have dynamicStatisticParams");
            tPDynamicStatisticParams = null;
        }
        TPDynamicStatisticParams tPDynamicStatisticParams2 = tPDynamicStatisticParams;
        if (tPDynamicStatisticParams == null) {
            tPDynamicStatisticParams2 = new TPDynamicStatisticParams();
        }
        return tPDynamicStatisticParams2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TPGeneralPlayFlowParams b() {
        com.tencent.thumbplayer.tplayer.a.a.a aVar = this.b;
        if (aVar == null) {
            TPLogUtil.e("TPBaseReporter", "getGeneralPlayFlowParams failed, mPlayerInfoGetter is null, return default value");
            return new TPGeneralPlayFlowParams();
        }
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(b bVar) {
        ITPReportInfoGetter iTPReportInfoGetter = this.f25696a;
        if (iTPReportInfoGetter == null) {
            return;
        }
        Map<String, String> initExtendReportInfo = iTPReportInfoGetter.getInitExtendReportInfo();
        if (initExtendReportInfo == null) {
            TPLogUtil.e("TPBaseReporter", "fillInitExtReportInfoToCommonParams fail, initExtendReportInfo is null");
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a(initExtendReportInfo, hashMap, hashMap2);
        bVar.f25674a.a(hashMap);
        bVar.f25674a.b(hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, Map<String, String> map) {
        if (this.f25697c.size() == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f25697c.size()) {
                return;
            }
            ITPReportChannelListener iTPReportChannelListener = this.f25697c.get(i3).get();
            if (iTPReportChannelListener != null) {
                iTPReportChannelListener.reportEvent(str, map);
            }
            i2 = i3 + 1;
        }
    }
}
