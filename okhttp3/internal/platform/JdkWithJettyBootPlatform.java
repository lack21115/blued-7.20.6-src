package okhttp3.internal.platform;

import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.soft.blued.ui.find.model.UserFindResult;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
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

    /* renamed from: a  reason: collision with root package name */
    private final Method f43972a;
    private final Method b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f43973c;
    private final Class<?> d;
    private final Class<?> e;

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/platform/JdkWithJettyBootPlatform$JettyNegoProvider.class */
    static class JettyNegoProvider implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        boolean f43974a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f43975c;

        JettyNegoProvider(List<String> list) {
            this.f43975c = list;
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
                this.f43974a = true;
                return null;
            } else if (name.equals("protocols") && strArr.length == 0) {
                return this.f43975c;
            } else {
                if ((!name.equals("selectProtocol") && !name.equals(SmCaptchaWebView.MODE_SELECT)) || String.class != returnType || strArr.length != 1 || !(strArr[0] instanceof List)) {
                    if ((name.equals("protocolSelected") || name.equals(UserFindResult.USER_SORT_BY.SELECTED)) && strArr.length == 1) {
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
                        String str = this.f43975c.get(0);
                        this.b = str;
                        return str;
                    } else if (this.f43975c.contains(list.get(i2))) {
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
        this.f43972a = method;
        this.b = method2;
        this.f43973c = method3;
        this.d = cls;
        this.e = cls2;
    }

    public static Platform a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new JdkWithJettyBootPlatform(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String a(SSLSocket sSLSocket) {
        try {
            JettyNegoProvider jettyNegoProvider = (JettyNegoProvider) Proxy.getInvocationHandler(this.b.invoke(null, sSLSocket));
            if (!jettyNegoProvider.f43974a && jettyNegoProvider.b == null) {
                Platform.e().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (jettyNegoProvider.f43974a) {
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
        List<String> a2 = a(list);
        try {
            this.f43972a.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.d, this.e}, new JettyNegoProvider(a2)));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.a("unable to set alpn", (Exception) e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void b(SSLSocket sSLSocket) {
        try {
            this.f43973c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.a("unable to remove alpn", (Exception) e);
        }
    }
}
