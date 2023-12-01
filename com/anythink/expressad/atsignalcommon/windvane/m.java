package com.anythink.expressad.atsignalcommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.anythink.expressad.atsignalcommon.b.c;
import com.anythink.expressad.atsignalcommon.mraid.MraidUriUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/m.class */
public final class m implements Handler.Callback, d {

    /* renamed from: a  reason: collision with root package name */
    protected Pattern f4272a;
    protected String b;
    protected Context d;
    protected WindVaneWebView e;

    /* renamed from: c  reason: collision with root package name */
    protected final int f4273c = 1;
    protected Handler f = new Handler(Looper.getMainLooper(), this);

    public m(Context context) {
        this.d = context;
    }

    private void a(a aVar) {
        Object jsObject = aVar.f4263a == null ? null : aVar.f4263a.getJsObject(aVar.d);
        if (jsObject == null) {
            return;
        }
        try {
            c.f a2 = com.anythink.expressad.atsignalcommon.b.c.a(this.d.getClassLoader(), jsObject.getClass().getName()).a(aVar.e, Object.class, String.class);
            a2.a();
            if (jsObject == null || !(jsObject instanceof l)) {
                return;
            }
            aVar.b = jsObject;
            aVar.f4264c = a2;
            aVar.b = jsObject;
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = aVar;
            this.f.sendMessage(obtain);
        } catch (c.b.a e) {
            if (com.anythink.expressad.a.f4103a) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(a aVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = aVar;
        this.f.sendMessage(obtain);
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final WebView a() {
        return this.e;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final void a(WindVaneWebView windVaneWebView) {
        this.e = windVaneWebView;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final void a(Pattern pattern) {
        this.f4272a = pattern;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final boolean a(String str) {
        if (n.a(str)) {
            this.f4272a = n.b(str);
            this.b = str;
            return true;
        }
        return false;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final a b(String str) {
        if (str == null) {
            return null;
        }
        a mraidMethodContext = MraidUriUtil.getMraidMethodContext(this.e, str);
        if (mraidMethodContext != null) {
            mraidMethodContext.f4263a = this.e;
            return mraidMethodContext;
        }
        Matcher matcher = this.f4272a.matcher(str);
        if (matcher.matches()) {
            a aVar = new a();
            int groupCount = matcher.groupCount();
            if (groupCount >= 5) {
                aVar.f = matcher.group(5);
            }
            if (groupCount >= 3) {
                aVar.d = matcher.group(1);
                aVar.g = matcher.group(2);
                aVar.e = matcher.group(3);
                if (com.anythink.expressad.atsignalcommon.base.e.k != null && com.anythink.expressad.atsignalcommon.base.e.k.containsKey(aVar.e)) {
                    aVar.e = com.anythink.expressad.atsignalcommon.base.e.k.get(aVar.e);
                }
                aVar.f4263a = this.e;
                return aVar;
            }
            return null;
        }
        return null;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final String b() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.atsignalcommon.windvane.m.c(java.lang.String):void");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final void d(String str) {
        this.b = str;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        a aVar = (a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
            if (message.what != 1) {
                return false;
            }
            aVar.f4264c.a(aVar.b, aVar, TextUtils.isEmpty(aVar.f) ? "{}" : aVar.f);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
