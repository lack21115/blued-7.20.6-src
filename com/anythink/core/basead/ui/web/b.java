package com.anythink.core.basead.ui.web;

import android.webkit.WebView;
import com.anythink.core.common.e.i;
import com.bytedance.applog.tracker.Tracker;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/ui/web/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    i f6409a;
    JSONObject b;

    /* renamed from: c  reason: collision with root package name */
    HashMap<String, Boolean> f6410c = new HashMap<>(3);

    public b(i iVar) {
        JSONObject jSONObject;
        this.f6409a = iVar;
        if (iVar != null) {
            try {
                jSONObject = new JSONObject(iVar.M());
            } catch (Throwable th) {
                return;
            }
        } else {
            jSONObject = null;
        }
        this.b = jSONObject;
    }

    private void a(WebView webView, String str) {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && str != null && str.contains(next) && this.f6410c.get(next) == null) {
                    this.f6410c.put(next, Boolean.TRUE);
                    Tracker.loadUrl(webView, this.b.optString(next));
                }
            }
        } catch (Throwable th) {
        }
    }
}
