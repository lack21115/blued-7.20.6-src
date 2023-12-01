package com.oplus.instant.router.callback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.oplus.instant.router.callback.Callback;
import com.oplus.instant.router.g.d;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/callback/c.class */
public class c extends Callback {

    /* renamed from: a  reason: collision with root package name */
    private Context f24283a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Callback f24284c;

    public c(Context context, String str, Callback callback) {
        this.f24283a = context;
        this.b = str;
        this.f24284c = callback;
    }

    private String a(String str) {
        return str.replace("hap://app/", "hap://on_stack/");
    }

    @Override // com.oplus.instant.router.callback.Callback
    public void onResponse(Callback.Response response) {
        String str;
        StringBuilder sb;
        if (this.f24284c == null) {
            return;
        }
        if (this.f24283a instanceof Activity) {
            if (response.f24281a == 1) {
                Intent intent = new Intent("android.intent.action.instant.on_stack", Uri.parse(a(this.b)));
                intent.putExtra("in_one_task", "1");
                if (intent.resolveActivity(this.f24283a.getPackageManager()) != null) {
                    sb = new StringBuilder();
                } else {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(this.b));
                    if (intent.resolveActivity(this.f24283a.getPackageManager()) != null) {
                        sb = new StringBuilder();
                    } else {
                        response.f24281a = 200;
                        str = "QuickApp is not support";
                    }
                }
                sb.append("req_uri: ");
                sb.append(intent.getDataString());
                d.a("OneTaskCallback", sb.toString());
                this.f24283a.startActivity(intent);
            }
            this.f24284c.onResponse(response);
        }
        response.f24281a = 200;
        str = "context is not activity";
        response.b = str;
        this.f24284c.onResponse(response);
    }
}
