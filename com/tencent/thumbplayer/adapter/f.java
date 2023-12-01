package com.tencent.thumbplayer.adapter;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.thumbplayer.adapter.a.c;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPDrmInfo;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.d.b;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/f.class */
public class f implements InvocationHandler {
    private static final Map<String, Class> f;

    /* renamed from: a  reason: collision with root package name */
    private d f39202a;
    private com.tencent.thumbplayer.tplayer.a b;

    /* renamed from: c  reason: collision with root package name */
    private g f39203c = new g("TPPlayerAdapterProxy");
    private a d;
    private Object e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/f$a.class */
    public class a implements c.f, c.g, c.h, c.i, c.j {
        private a() {
        }

        private void a(long j, long j2, Object obj) {
            f.this.b.b().a(new b.c());
        }

        private void b(long j, long j2, Object obj) {
            f.this.b.b().a(new b.C1018b());
        }

        private void c(long j, long j2, Object obj) {
            b.s sVar = new b.s();
            sVar.a(((Long) obj).longValue());
            sVar.b((int) j2);
            f.this.b.b().a(sVar);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.i
        public void a() {
            b.o oVar = new b.o();
            oVar.b(f.this.f39202a.d());
            oVar.a(f.this.f39202a.m());
            f.this.b.b().a(oVar);
            f.this.f39203c.a();
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.f
        public void a(@TPCommonEnum.TPErrorType int i, int i2, long j, long j2) {
            b.i iVar = new b.i();
            iVar.c(i2);
            iVar.b(i);
            TPGeneralPlayFlowParams u = f.this.f39202a.u();
            TPGeneralPlayFlowParams tPGeneralPlayFlowParams = u;
            if (u == null) {
                tPGeneralPlayFlowParams = new TPGeneralPlayFlowParams();
            }
            iVar.a(tPGeneralPlayFlowParams);
            TPDynamicStatisticParams c2 = f.this.f39202a.c(false);
            TPDynamicStatisticParams tPDynamicStatisticParams = c2;
            if (c2 == null) {
                tPDynamicStatisticParams = new TPDynamicStatisticParams();
            }
            iVar.a(tPDynamicStatisticParams);
            f.this.b.b().a(iVar);
            f.this.f39203c.a(i, i2, j, j2);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.h
        public void a(int i, long j, long j2, Object obj) {
            if (i == 4) {
                c(j, j2, obj);
            } else if (i == 200) {
                a(j, j2, obj);
            } else if (i == 201) {
                b(j, j2, obj);
            }
            f.this.f39203c.a(i, j, j2, obj);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.g
        public void a(TPDrmInfo tPDrmInfo) {
            b.h hVar = new b.h();
            hVar.a(tPDrmInfo);
            f.this.b.b().a(hVar);
            f.this.f39203c.a(tPDrmInfo);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.j
        public void c() {
            f.this.b.b().a(new b.q());
            f.this.f39203c.c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put("setOnPreparedListener", c.i.class);
        f.put("setOnInfoListener", c.h.class);
        f.put("setOnErrorListener", c.f.class);
        f.put("setOnSeekCompleteListener", c.j.class);
    }

    public f(d dVar, com.tencent.thumbplayer.tplayer.a aVar) {
        a aVar2 = new a();
        this.d = aVar2;
        this.f39202a = dVar;
        this.b = aVar;
        dVar.a((c.g) aVar2);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(Method method, Object[] objArr) {
        boolean z;
        String name = method.getName();
        switch (name.hashCode()) {
            case -2055859787:
                if (name.equals("prepareAsync")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -906224877:
                if (name.equals("seekTo")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3540994:
                if (name.equals("stop")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 106440182:
                if (name.equals(com.anythink.expressad.foundation.d.c.cb)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 108404047:
                if (name.equals("reset")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 109757538:
                if (name.equals("start")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 205228463:
                if (name.equals("selectTrack")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 218603354:
                if (name.equals("setPlaySpeedRatio")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1090594823:
                if (name.equals("release")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                a(objArr);
                return;
            case true:
                b(objArr);
                return;
            case true:
                c(objArr);
                return;
            case true:
                d(objArr);
                return;
            case true:
                e(objArr);
                return;
            case true:
                f(objArr);
                return;
            case true:
                g(objArr);
                return;
            case true:
                h(objArr);
                return;
            case true:
                i(objArr);
                return;
            default:
                return;
        }
    }

    private void a(Object[] objArr) {
    }

    private void b(Method method, Object[] objArr) {
        if (f.containsKey(method.getName())) {
            try {
                this.f39203c.getClass().getMethod(method.getName(), f.get(method.getName())).invoke(this.f39203c, objArr[0]);
                objArr[0] = this.d;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    private void b(Object[] objArr) {
        this.b.b().a(new b.m());
    }

    private void c(Object[] objArr) {
        this.b.b().a(new b.j());
    }

    private void d(Object[] objArr) {
        b.n nVar = new b.n();
        TPGeneralPlayFlowParams u = this.f39202a.u();
        TPGeneralPlayFlowParams tPGeneralPlayFlowParams = u;
        if (u == null) {
            tPGeneralPlayFlowParams = new TPGeneralPlayFlowParams();
        }
        nVar.a(tPGeneralPlayFlowParams);
        TPDynamicStatisticParams c2 = this.f39202a.c(false);
        TPDynamicStatisticParams tPDynamicStatisticParams = c2;
        if (c2 == null) {
            tPDynamicStatisticParams = new TPDynamicStatisticParams();
        }
        nVar.a(tPDynamicStatisticParams);
        this.b.b().a(nVar);
    }

    private void e(Object[] objArr) {
        b.l lVar = new b.l();
        TPGeneralPlayFlowParams u = this.f39202a.u();
        TPGeneralPlayFlowParams tPGeneralPlayFlowParams = u;
        if (u == null) {
            tPGeneralPlayFlowParams = new TPGeneralPlayFlowParams();
        }
        lVar.a(tPGeneralPlayFlowParams);
        TPDynamicStatisticParams c2 = this.f39202a.c(false);
        TPDynamicStatisticParams tPDynamicStatisticParams = c2;
        if (c2 == null) {
            tPDynamicStatisticParams = new TPDynamicStatisticParams();
        }
        lVar.a(tPDynamicStatisticParams);
        this.b.b().a(lVar);
    }

    private void f(Object[] objArr) {
        this.b.b().a(new b.k());
    }

    private void g(Object[] objArr) {
        this.b.b().a(new b.r());
    }

    private void h(Object[] objArr) {
        b.v vVar = new b.v();
        vVar.a(((Float) objArr[0]).floatValue());
        this.b.b().a(vVar);
    }

    private void i(Object[] objArr) {
        b.t tVar = new b.t();
        tVar.b(((Integer) objArr[0]).intValue());
        tVar.a(((Long) objArr[1]).longValue());
        tVar.a(this.f39202a.r()[((Integer) objArr[0]).intValue()]);
        this.b.b().a(tVar);
    }

    public Object a() {
        Object obj;
        synchronized (this) {
            if (this.e == null) {
                this.e = Proxy.newProxyInstance(this.f39202a.getClass().getClassLoader(), this.f39202a.getClass().getInterfaces(), this);
            }
            obj = this.e;
        }
        return obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        StringBuilder sb;
        String th;
        try {
            a(method, objArr);
            b(method, objArr);
            return method.invoke(this.f39202a, objArr);
        } catch (InvocationTargetException e) {
            if (e.getTargetException() == null) {
                sb = new StringBuilder("invokeMethod ");
                sb.append(method.getName());
                sb.append(" has excecption: ");
                th = e.toString();
                sb.append(th);
                TPLogUtil.e("TPPlayerAdapterProxy", sb.toString());
                return a(method);
            }
            throw e.getTargetException();
        } catch (Throwable th2) {
            sb = new StringBuilder("invokeMethod ");
            sb.append(method.getName());
            sb.append(" has excecption: ");
            th = th2.toString();
            sb.append(th);
            TPLogUtil.e("TPPlayerAdapterProxy", sb.toString());
            return a(method);
        }
    }
}
