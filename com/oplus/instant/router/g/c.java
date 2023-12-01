package com.oplus.instant.router.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.oplus.instant.router.callback.Callback;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/c.class */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/c$a.class */
    public static final class a extends Callback {
        a() {
        }

        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            d.a("GameUtil", "wrapCallback onResponse=" + response);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/c$b.class */
    public static class b extends Callback {

        /* renamed from: a  reason: collision with root package name */
        private Callback f24295a;
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private String f24296c;

        public b(Context context, String str, Callback callback) {
            this.f24295a = callback;
            this.b = context;
            this.f24296c = str;
        }

        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            Callback.Response response2 = response;
            if (response != null) {
                response2 = response;
                if (response.getCode() == 1) {
                    try {
                        d.c("GameUtil", "wrapper onResponse " + response);
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(h.d(this.b), com.oplus.instant.router.g.a.a("Y29tLm5lYXJtZS5pbnN0YW50LnF1aWNrZ2FtZS5hY3Rpdml0eS5HYW1lVHJhbnNmZXJBY3Rpdml0eQ==")));
                        intent.putExtra("req_uri", this.f24296c);
                        this.b.startActivity(intent);
                        response2 = response;
                    } catch (Exception e) {
                        d.c("GameUtil", "wrapper onResponse ex:" + e.getMessage());
                        response2 = new Callback.Response();
                        response2.setCode(-4);
                        response2.setMsg("start transform page failed");
                    }
                }
            }
            Callback callback = this.f24295a;
            if (callback != null) {
                callback.onResponse(response2);
            }
        }
    }

    public static Callback a(Context context, String str, Callback callback) {
        a aVar = callback;
        if (callback == null) {
            aVar = new a();
        }
        return new b(context, str, aVar);
    }

    public static boolean a(Context context, String str, Map<String, String> map) {
        if (str == null || !str.startsWith("hap://game") || h.c(context) < 3100) {
            return false;
        }
        try {
            if ("1".equals(Uri.parse(str).getQueryParameter("in_one_task"))) {
                return true;
            }
        } catch (Exception e) {
            d.a("GameUtil", e);
        }
        return map != null && "1".equals(map.get("in_one_task"));
    }
}
