package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.applog.util.WebViewJsUtil;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, b> f24533a = new HashMap<>();

    /* renamed from: com.tencent.open.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a$a.class */
    public static class C0802a {

        /* renamed from: a  reason: collision with root package name */
        protected WeakReference<WebView> f24536a;
        protected long b;

        /* renamed from: c  reason: collision with root package name */
        protected String f24537c;

        public C0802a(WebView webView, long j, String str) {
            this.f24536a = new WeakReference<>(webView);
            this.b = j;
            this.f24537c = str;
        }

        public void a() {
            WebView webView = this.f24536a.get();
            if (webView == null) {
                return;
            }
            Tracker.loadUrl(webView, "javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
        }

        public void a(Object obj) {
            String obj2;
            WebView webView = this.f24536a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                String replace = ((String) obj).replace("\\", "\\\\").replace("'", "\\'");
                obj2 = "'" + ((Object) replace) + "'";
            } else {
                obj2 = ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) ? obj.toString() : obj instanceof Boolean ? obj.toString() : "'undefined'";
            }
            Tracker.loadUrl(webView, "javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void a(String str) {
            WebView webView = this.f24536a.get();
            if (webView != null) {
                Tracker.loadUrl(webView, WebViewJsUtil.JS_URL_PREFIX + str);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a$b.class */
    public static class b {
        public void call(String str, List<String> list, C0802a c0802a) {
            Method method;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                }
                i = i2 + 1;
            }
            if (method == null) {
                if (c0802a != null) {
                    c0802a.a();
                    return;
                }
                return;
            }
            try {
                int size = list.size();
                Object invoke = size != 0 ? size != 1 ? size != 2 ? size != 3 ? size != 4 ? size != 5 ? method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3)) : method.invoke(this, list.get(0), list.get(1), list.get(2)) : method.invoke(this, list.get(0), list.get(1)) : method.invoke(this, list.get(0)) : method.invoke(this, new Object[0]);
                Class<?> returnType = method.getReturnType();
                f.b("openSDK_LOG.JsBridge", "-->call, result: " + invoke + " | ReturnType: " + returnType.getName());
                if ("void".equals(returnType.getName()) || returnType == Void.class) {
                    if (c0802a != null) {
                        c0802a.a((Object) null);
                    }
                } else if (c0802a == null || !customCallback()) {
                } else {
                    String str2 = null;
                    if (invoke != null) {
                        str2 = invoke.toString();
                    }
                    c0802a.a(str2);
                }
            } catch (Exception e) {
                f.b("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e);
                if (c0802a != null) {
                    c0802a.a();
                }
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.f24533a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0802a c0802a) {
        f.a("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
        b bVar = this.f24533a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0802a);
            return;
        }
        f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (c0802a != null) {
            c0802a.a();
        }
    }

    public boolean a(WebView webView, String str) {
        f.a("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() < 6) {
                return false;
            }
            String str2 = (String) arrayList.get(2);
            String str3 = (String) arrayList.get(3);
            List<String> subList = arrayList.subList(4, arrayList.size() - 1);
            C0802a c0802a = new C0802a(webView, 4L, str);
            webView.getUrl();
            a(str2, str3, subList, c0802a);
            return true;
        }
        return false;
    }
}
