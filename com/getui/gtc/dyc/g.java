package com.getui.gtc.dyc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.dyc.b.b;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/g.class */
public class g {

    /* renamed from: com.getui.gtc.dyc.g$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/g$1.class */
    class AnonymousClass1 implements Call.Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f21988a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f21989c;
        final /* synthetic */ b d;

        @Override // com.getui.gtc.base.http.Call.Callback
        public void onFailure(Call call, Exception exc) {
            c cVar = this.f21988a;
            if (cVar != null) {
                cVar.a(exc);
            }
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public void onResponse(Call call, Response response) {
            try {
                h a2 = this.f21989c.a(this.d, response);
                if (this.f21988a != null) {
                    this.f21988a.a(a2);
                }
            } catch (Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
                c cVar = this.f21988a;
                if (cVar != null) {
                    cVar.a(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/g$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static g f21990a = new g(null);
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/g$c.class */
    public interface c {
        void a(h hVar);

        void a(Throwable th);
    }

    private g() {
        a(GtcProvider.context());
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g a() {
        return a.f21990a;
    }

    private void a(Context context) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            com.getui.gtc.dyc.a.a.a.c(e);
            applicationInfo = null;
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return;
        }
        String string = applicationInfo.metaData.getString("DYC_P");
        if (!TextUtils.isEmpty(string)) {
            d.f21979a = string;
        }
        String string2 = applicationInfo.metaData.getString("DYC_K");
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        d.f21980c = string2;
    }

    public h a(b bVar) throws Exception {
        return new d().a(bVar);
    }
}
