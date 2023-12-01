package com.tencent.thumbplayer.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.d.b;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/d.class */
public class d implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private e f39246a;
    private com.tencent.thumbplayer.tplayer.a b;

    /* renamed from: c  reason: collision with root package name */
    private ITPPlayListener f39247c;
    private a d = new a();
    private Object e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/d$a.class */
    public class a implements ITPPlayListener {
        private a() {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getAdvRemainTime() {
            return d.this.f39247c.getAdvRemainTime();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public String getContentType(int i, String str) {
            return d.this.f39247c.getContentType(i, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int getCurrentPlayClipNo() {
            return d.this.f39247c.getCurrentPlayClipNo();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getCurrentPlayOffset() {
            return d.this.f39247c.getCurrentPlayOffset();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getCurrentPosition() {
            return d.this.f39247c.getCurrentPosition();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public String getDataFilePath(int i, String str) {
            return d.this.f39247c.getDataFilePath(i, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getDataTotalSize(int i, String str) {
            return d.this.f39247c.getDataTotalSize(i, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public Object getPlayInfo(long j) {
            return d.this.f39247c.getPlayInfo(j);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public Object getPlayInfo(String str) {
            return d.this.f39247c.getPlayInfo(str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getPlayerBufferLength() {
            return d.this.f39247c.getPlayerBufferLength();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadCdnUrlExpired(Map<String, String> map) {
            d.this.f39247c.onDownloadCdnUrlExpired(map);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
            b.d dVar = new b.d();
            dVar.a(str2);
            dVar.b(str3);
            d.this.b.b().a(dVar);
            d.this.f39247c.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadCdnUrlUpdate(String str) {
            d.this.f39247c.onDownloadCdnUrlUpdate(str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadError(int i, int i2, String str) {
            d.this.f39247c.onDownloadError(i, i2, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadFinish() {
            d.this.f39247c.onDownloadFinish();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadProgressUpdate(int i, int i2, long j, long j2, String str) {
            b.e eVar = new b.e();
            eVar.b(i2 * 8);
            d.this.b.b().a(eVar);
            d.this.f39247c.onDownloadProgressUpdate(i, i2, j, j2, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadProtocolUpdate(String str, String str2) {
            b.f fVar = new b.f();
            fVar.b(str);
            fVar.a(str2);
            d.this.b.b().a(fVar);
            d.this.f39247c.onDownloadProtocolUpdate(str, str2);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadStatusUpdate(int i) {
            d.this.f39247c.onDownloadStatusUpdate(i);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public Object onPlayCallback(int i, Object obj, Object obj2, Object obj3, Object obj4) {
            return d.this.f39247c.onPlayCallback(i, obj, obj2, obj3, obj4);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int onReadData(int i, String str, long j, long j2) {
            return d.this.f39247c.onReadData(i, str, j, j2);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int onStartReadData(int i, String str, long j, long j2) {
            return d.this.f39247c.onStartReadData(i, str, j, j2);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int onStopReadData(int i, String str, int i2) {
            return d.this.f39247c.onStopReadData(i, str, i2);
        }
    }

    public d(e eVar, com.tencent.thumbplayer.tplayer.a aVar) {
        this.f39246a = eVar;
        this.b = aVar;
    }

    private static Object a(Method method) {
        String name = method.getReturnType().getName();
        if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.FALSE;
        }
        if (name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return 0;
        }
        if (name.equals("long")) {
            return 0L;
        }
        if (name.equals(TypedValues.Custom.S_FLOAT)) {
            return Float.valueOf(0.0f);
        }
        return null;
    }

    private void a(Method method, Object[] objArr) {
        boolean z;
        String name = method.getName();
        int hashCode = name.hashCode();
        if (hashCode != 832972187) {
            if (hashCode == 1922160990 && name.equals("startDownloadPlay")) {
                z = false;
            }
            z = true;
        } else {
            if (name.equals("startDownloadPlayByAsset")) {
                z = true;
            }
            z = true;
        }
        if (!z || z) {
            a(objArr);
        }
    }

    private void a(Object[] objArr) {
        this.b.b().a(new b.g());
    }

    private void b(Method method, Object[] objArr) {
        if (method.getName().equals("setPlayListener")) {
            this.f39247c = (ITPPlayListener) objArr[0];
            objArr[0] = this.d;
        }
    }

    public Object a() {
        Object obj;
        synchronized (this) {
            if (this.e == null) {
                this.e = Proxy.newProxyInstance(this.f39246a.getClass().getClassLoader(), this.f39246a.getClass().getInterfaces(), this);
            }
            obj = this.e;
        }
        return obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        StringBuilder sb;
        String th;
        b(method, objArr);
        try {
            Object invoke = method.invoke(this.f39246a, objArr);
            a(method, objArr);
            return invoke;
        } catch (InvocationTargetException e) {
            if (e.getTargetException() == null) {
                sb = new StringBuilder("invokeMethod ");
                sb.append(method.getName());
                sb.append(" has excecption: ");
                th = e.toString();
                sb.append(th);
                TPLogUtil.e("TPDataTransportManagerProxy", sb.toString());
                return a(method);
            }
            throw e.getTargetException();
        } catch (Throwable th2) {
            sb = new StringBuilder("invokeMethod ");
            sb.append(method.getName());
            sb.append(" has excecption: ");
            th = th2.toString();
            sb.append(th);
            TPLogUtil.e("TPDataTransportManagerProxy", sb.toString());
            return a(method);
        }
    }
}
