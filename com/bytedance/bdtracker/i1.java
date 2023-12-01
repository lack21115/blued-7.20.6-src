package com.bytedance.bdtracker;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.util.WebViewJsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/i1.class */
public class i1 implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    public Handler f7626c;
    public b f;
    public final IAppLogInstance h;

    /* renamed from: a  reason: collision with root package name */
    public final Rect f7625a = new Rect();
    public final Map<Integer, a> b = new HashMap();
    public boolean d = false;
    public int e = 0;
    public boolean g = true;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/i1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public h1 f7627a;
        public List<l1> b = new ArrayList(2);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/i1$b.class */
    public interface b {
        void onGetCircleInfoFinish(Map<Integer, a> map);
    }

    public i1(IAppLogInstance iAppLogInstance, b bVar, Looper looper) {
        this.f7626c = new Handler(Looper.getMainLooper(), this);
        this.h = iAppLogInstance;
        this.f = bVar;
        this.f7626c = new Handler(looper, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WebView webView) {
        WebViewJsUtil.getWebInfo(webView, this.f7626c);
    }

    public void a() {
        a aVar;
        d3.b();
        View[] a2 = d3.a();
        int length = a2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.d = true;
                b();
                return;
            }
            View view = a2[i2];
            int a3 = c3.a(view);
            if (this.b.containsKey(Integer.valueOf(a3))) {
                aVar = this.b.get(Integer.valueOf(a3));
            } else {
                aVar = new a();
                this.b.put(Integer.valueOf(a3), aVar);
            }
            a(view, null, aVar);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
        if (com.bytedance.bdtracker.c3.c(r6) != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.View r6, com.bytedance.bdtracker.h1 r7, com.bytedance.bdtracker.i1.a r8) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.i1.a(android.view.View, com.bytedance.bdtracker.h1, com.bytedance.bdtracker.i1$a):void");
    }

    public final void a(final WebView webView) {
        webView.post(new Runnable() { // from class: com.bytedance.bdtracker.-$$Lambda$i1$ewt5ahS1M0cfb_at1kpgeuoy-aM
            @Override // java.lang.Runnable
            public final void run() {
                i1.this.b(webView);
            }
        });
    }

    public final void b() {
        if (this.d && this.e == 0) {
            b bVar = this.f;
            if (bVar != null) {
                bVar.onGetCircleInfoFinish(this.b);
            }
            this.d = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x01b2  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r9) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.i1.handleMessage(android.os.Message):boolean");
    }
}
