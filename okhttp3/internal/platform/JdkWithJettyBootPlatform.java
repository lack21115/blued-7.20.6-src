package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/platform/JdkWithJettyBootPlatform.class */
class JdkWithJettyBootPlatform extends Platform {
    private final Method a;
    private final Method b;
    private final Method c;
    private final Class<?> d;
    private final Class<?> e;

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/platform/JdkWithJettyBootPlatform$JettyNegoProvider.class */
    static class JettyNegoProvider implements InvocationHandler {
        boolean a;
        String b;
        private final List<String> c;

        JettyNegoProvider(List<String> list) {
            this.c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            String[] strArr = objArr;
            if (objArr == null) {
                strArr = Util.b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.a = true;
                return null;
            } else if (name.equals("protocols") && strArr.length == 0) {
                return this.c;
            } else {
                if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || strArr.length != 1 || !(strArr[0] instanceof List)) {
                    if ((name.equals("protocolSelected") || name.equals("selected")) && strArr.length == 1) {
                        this.b = (String) strArr[0];
                        return null;
                    }
                    return method.invoke(this, strArr);
                }
                List list = (List) strArr[0];
                int size = list.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        String str = this.c.get(0);
                        this.b = str;
                        return str;
                    } else if (this.c.contains(list.get(i2))) {
                        String str2 = (String) list.get(i2);
                        this.b = str2;
                        return str2;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        }
    }

    JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.a = method;
        this.b = method2;
        this.c = method3;
        this.d = cls;
        this.e = cls2;
    }

    public static Platform a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new JdkWithJettyBootPlatform(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String a(SSLSocket sSLSocket) {
        try {
            JettyNegoProvider jettyNegoProvider = (JettyNegoProvider) Proxy.getInvocationHandler(this.b.invoke(null, sSLSocket));
            if (!jettyNegoProvider.a && jettyNegoProvider.b == null) {
                Platform.e().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (jettyNegoProvider.a) {
                return null;
            } else {
                return jettyNegoProvider.b;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.a("unable to get selected protocol", (Exception) e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List<String> a = a(list);
        try {
            this.a.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.d, this.e}, new JettyNegoProvider(a)));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.a("unable to set alpn", (Exception) e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void b(SSLSocket sSLSocket) {
        try {
            this.c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.a("unable to remove alpn", (Exception) e);
        }
    }
}
