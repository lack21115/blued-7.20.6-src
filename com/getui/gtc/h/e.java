package com.getui.gtc.h;

import android.util.Base64;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/h/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static int f22028a;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/h/e$a.class */
    public interface a {
        void a(String str);
    }

    public static void a(final String str, final String str2, final a aVar) {
        d.f22027a.newCall(new Request.Builder().url(str).method("GET").logFlags(1).tag("fetch servers").build()).enqueue(new Call.Callback() { // from class: com.getui.gtc.h.e.1
            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onFailure(Call call, Exception exc) {
                com.getui.gtc.i.c.a.b("Failed! = " + call.request().url());
                com.getui.gtc.i.c.a.a(exc);
                if (e.f22028a < 3) {
                    e.b();
                    try {
                        Thread.sleep(e.f22028a * 5000);
                    } catch (InterruptedException e) {
                    }
                    e.a(String.this, str2, aVar);
                }
            }

            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onResponse(Call call, Response response) {
                e.c();
                byte[] body = response.getBody();
                try {
                    byte[] decode = Base64.decode(str2, 2);
                    String str3 = new String(CryptTools.decrypt("AES/CFB/NOPADDING", CryptTools.wrapperKey("AES", decode), new IvParameterSpec(CryptTools.digest("MD5", decode)), body));
                    com.getui.gtc.i.c.a.a("fetch servers from " + call.request().url() + " :" + str3);
                    if (aVar != null) {
                        aVar.a(str3);
                    }
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.a(th);
                }
            }
        });
    }

    static /* synthetic */ int b() {
        int i = f22028a;
        f22028a = i + 1;
        return i;
    }

    static /* synthetic */ int c() {
        f22028a = 0;
        return 0;
    }
}
