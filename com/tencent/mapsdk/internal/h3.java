package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetFileResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetHead;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJceResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJsonResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.l2;
import com.tencent.mapsdk.internal.l2.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h3.class */
public abstract class h3<R extends l2.a> implements l2<R> {

    /* renamed from: a  reason: collision with root package name */
    private volatile R f37506a;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37507c = true;
    private boolean d = true;
    private Map<String, String> e;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h3$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37508a;

        static {
            NetMethod.values();
            int[] iArr = new int[4];
            f37508a = iArr;
            try {
                NetMethod netMethod = NetMethod.GET;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f37508a;
                NetMethod netMethod2 = NetMethod.POST;
                iArr2[0] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h3$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f37509a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f37510c;
        public String d;
        public String[] e;
        public HashMap<String, String> f;
        public String g;
        public String h;
        public int i;
        public boolean j;
        public NetMethod k;
        public y3 l;
        public int[] m;

        private b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public String toString() {
            return "RequestEntity{service='" + this.f37509a + "', request='" + this.b + "', method=" + this.k + ", heads=" + this.f + ", authority=" + this.d + ", queryKeys=" + Arrays.toString(this.e) + ", constQuery='" + this.g + "', useAgent='" + this.h + "', resolver='" + this.l + "', retry=" + this.i + ", useExtraQuery=" + this.j + "\nurl='" + this.f37510c + "'}";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h3$c.class */
    public class c implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private Class<? extends h3> f37511a;

        public c(Class<? extends h3> cls) {
            this.f37511a = cls;
        }

        private b a(Method method) {
            b bVar = new b(null);
            NetJceResolver netJceResolver = (NetJceResolver) method.getAnnotation(NetJceResolver.class);
            NetFileResolver netFileResolver = (NetFileResolver) method.getAnnotation(NetFileResolver.class);
            NetJsonResolver netJsonResolver = (NetJsonResolver) method.getAnnotation(NetJsonResolver.class);
            NetRequest netRequest = (NetRequest) method.getAnnotation(NetRequest.class);
            if (netJceResolver != null) {
                bVar.l = new w3(netJceResolver.inJce(), netJceResolver.outJce());
                bVar.m = netJceResolver.queryRange();
            } else if (netFileResolver != null) {
                bVar.l = new v3(netFileResolver.outFile());
                bVar.m = netFileResolver.queryRange();
            } else if (netJsonResolver != null) {
                bVar.l = new x3(netJsonResolver.outModel());
                bVar.m = netJsonResolver.queryRange();
            }
            if (netRequest != null) {
                bVar.f37509a = this.f37511a.getSimpleName();
                bVar.k = netRequest.method();
                bVar.b = method.getName();
                bVar.d = netRequest.authority();
                bVar.h = netRequest.userAgent();
                bVar.e = netRequest.queryKeys();
                bVar.i = netRequest.retry();
                bVar.j = netRequest.useExtraQuery();
                NetHead head = netRequest.head();
                String[] keys = head.keys();
                String[] values = head.values();
                if (keys.length > 0 && keys.length == values.length) {
                    bVar.f = new HashMap<>();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= keys.length) {
                            break;
                        }
                        bVar.f.put(keys[i2], values[i2]);
                        i = i2 + 1;
                    }
                }
                StringBuilder sb = new StringBuilder();
                String a2 = h3.this.a(bVar.d);
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(a2);
                }
                String path = netRequest.path();
                if (path.length() != 0) {
                    sb.append(BridgeUtil.SPLIT_MARK);
                    sb.append(path);
                }
                bVar.g = netRequest.constQuery();
                bVar.f37510c = sb.toString();
            }
            return bVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            b a2 = a(method);
            if (!h3.this.b()) {
                na.g(ma.g, "The Service[" + this.f37511a.getSimpleName() + "] is block!!  Please check the ServiceProtocol for corrected, or contact the Tencent MapSdk Office to enable it. ");
                if (a2.k == NetMethod.URL) {
                    return "";
                }
                return null;
            } else if (a2.k != NetMethod.URL) {
                y3 y3Var = a2.l;
                if (y3Var != null) {
                    return a2.l.a(h3.this.b(a2, y3Var.a(a2.m, objArr)));
                }
                return h3.this.b(a2, objArr);
            } else {
                String str = a2.f37510c;
                String a3 = h3.this.a(a2, objArr);
                String str2 = str;
                if (a3.length() != 0) {
                    str2 = str + "?" + a3;
                }
                a2.f37510c = str2;
                na.c(ma.g, a2.toString());
                return str2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(b bVar, Object... objArr) {
        Map<String, String> map;
        String[] strArr = bVar.e;
        StringBuilder sb = new StringBuilder();
        if (strArr != null && objArr != null && strArr.length <= objArr.length) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(strArr[i2]);
                sb.append("=");
                sb.append("%s");
                sb.append("&");
                i = i2 + 1;
            }
        }
        String str = bVar.g;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("&");
            int length2 = split.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                String[] split2 = split[i4].split("=");
                if (split2.length == 2) {
                    sb.append(split2[0]);
                    sb.append("=");
                    sb.append(split2[1]);
                    sb.append("&");
                }
                i3 = i4 + 1;
            }
        }
        if (bVar.j && (map = this.e) != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : this.e.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
        }
        int lastIndexOf = sb.lastIndexOf("&");
        if (lastIndexOf >= 0 && lastIndexOf == sb.length() - 1) {
            sb.deleteCharAt(lastIndexOf);
        }
        return String.format(sb.toString(), objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = str;
        if (f7.b(str)) {
            str2 = h();
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String i = i();
        if (!TextUtils.isEmpty(i)) {
            sb.append(i);
            sb.append("://");
        }
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetResponse b(b bVar, Object... objArr) {
        if (bVar != null) {
            String str = bVar.f37510c;
            try {
                String a2 = a(bVar, objArr);
                String str2 = str;
                if (!TextUtils.isEmpty(a2)) {
                    str2 = str + "?" + a2;
                }
                bVar.f37510c = str2;
                na.c(ma.g, bVar.toString());
                int ordinal = bVar.k.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        return null;
                    }
                    return NetManager.getInstance().builder().forceHttps(false).userAgent(bVar.h).url(str2).retryNum(bVar.i).header(bVar.f).doGet();
                }
                byte[] bArr = new byte[0];
                byte[] bArr2 = bArr;
                if (objArr.length > 0) {
                    int length = objArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        bArr2 = bArr;
                        if (i2 >= length) {
                            break;
                        }
                        Object obj = objArr[i2];
                        if (obj instanceof byte[]) {
                            bArr2 = (byte[]) obj;
                            break;
                        }
                        i = i2 + 1;
                    }
                }
                return NetManager.getInstance().builder().userAgent(bVar.h).forceHttps(false).url(str2).retryNum(bVar.i).header(bVar.f).postData(bArr2).doPost();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private R k() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (actualTypeArguments.length <= 0 || !(actualTypeArguments[0] instanceof Class)) {
                return null;
            }
            Class cls = (Class) actualTypeArguments[0];
            ClassLoader classLoader = cls.getClassLoader();
            Class<?>[] clsArr = new Class[1];
            if (cls.isInterface()) {
                clsArr[0] = cls;
            } else {
                clsArr = cls.getInterfaces();
            }
            return (R) Proxy.newProxyInstance(classLoader, clsArr, new c(getClass()));
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.l2
    public String a() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.l2
    public void a(Map<String, String> map) {
        Map<String, String> map2 = this.e;
        if (map2 != null) {
            map2.putAll(map);
        } else {
            this.e = map;
        }
    }

    @Override // com.tencent.mapsdk.internal.l2
    public boolean b() {
        return this.d;
    }

    @Override // com.tencent.mapsdk.internal.l2
    public boolean c() {
        return this.b;
    }

    @Override // com.tencent.mapsdk.internal.l2
    public final R d() {
        if (this.f37506a != null) {
            return this.f37506a;
        }
        this.f37506a = k();
        return this.f37506a;
    }

    @Override // com.tencent.mapsdk.internal.l2
    public boolean e() {
        return this.f37507c;
    }

    @Override // com.tencent.mapsdk.internal.l2
    public String f() {
        return null;
    }

    public final String h() {
        String g = g();
        if (c()) {
            g = f();
        }
        return g;
    }

    public final String i() {
        return e() ? "https" : "http";
    }

    public final String j() {
        StringBuilder sb = new StringBuilder();
        String h = h();
        if (TextUtils.isEmpty(h)) {
            return null;
        }
        String i = i();
        if (!TextUtils.isEmpty(i)) {
            sb.append(i);
            sb.append("://");
        }
        sb.append(h);
        return sb.toString();
    }

    @Override // com.tencent.mapsdk.internal.k2.a
    public void setAllow(boolean z) {
        this.d = z;
    }

    @Override // com.tencent.mapsdk.internal.k2.a
    public void setUseHttps(boolean z) {
        this.f37507c = z;
    }

    @Override // com.tencent.mapsdk.internal.k2.a
    public void setUseTest(boolean z) {
        this.b = z;
    }
}
