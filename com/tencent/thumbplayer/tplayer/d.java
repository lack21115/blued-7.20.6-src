package com.tencent.thumbplayer.tplayer;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.n;
import com.tencent.thumbplayer.utils.q;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/d.class */
public class d implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private b f25716a;
    private q b;

    public d(b bVar) {
        this.f25716a = bVar;
        this.b = new q(bVar.b(), this.f25716a.a(), this.f25716a);
    }

    private int a(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    private boolean a(Method method, Object[] objArr) {
        return n.a(this.f25716a.getClass(), method.getName(), objArr) != null;
    }

    private Object b(Method method, Object[] objArr) {
        String name = method.getName();
        Object[] objArr2 = objArr;
        if (name.equals("setDataSource")) {
            objArr2 = b(objArr);
        }
        if (method.getReturnType().getName().equals("void")) {
            this.b.b(name, objArr2);
            return null;
        }
        Object a2 = this.b.a(name, objArr2);
        String b = this.f25716a.b();
        TPLogUtil.i(b, "dealThreadSwitch: " + name + ", var count:" + a(objArr2) + ", result:" + a2);
        return a2;
    }

    private Object[] b(Object[] objArr) {
        String b;
        StringBuilder sb;
        if (objArr[0] != null && (objArr[0] instanceof ParcelFileDescriptor)) {
            try {
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) objArr[0];
                objArr[0] = ParcelFileDescriptor.fromFd(parcelFileDescriptor.detachFd());
                parcelFileDescriptor.close();
                return objArr;
            } catch (Exception e) {
                e = e;
                b = this.f25716a.b();
                sb = new StringBuilder("setDataSource, fromFd has exception:");
            }
        } else if (objArr[0] == null || !(objArr[0] instanceof AssetFileDescriptor)) {
            return objArr;
        } else {
            try {
                AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) objArr[0];
                objArr[0] = new AssetFileDescriptor(ParcelFileDescriptor.fromFd(assetFileDescriptor.getParcelFileDescriptor().detachFd()), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                assetFileDescriptor.close();
                return objArr;
            } catch (Exception e2) {
                e = e2;
                b = this.f25716a.b();
                sb = new StringBuilder("setDataSource, fromFd has exception:");
            }
        }
        sb.append(e.toString());
        TPLogUtil.e(b, sb.toString());
        return objArr;
    }

    public Object a() {
        return Proxy.newProxyInstance(this.f25716a.getClass().getClassLoader(), this.f25716a.getClass().getInterfaces(), this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        return !a(method, objArr) ? method.invoke(this.f25716a, objArr) : b(method, objArr);
    }
}
