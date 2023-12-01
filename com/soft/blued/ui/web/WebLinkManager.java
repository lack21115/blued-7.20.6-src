package com.soft.blued.ui.web;

import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.ui.web.modelloader.model.WebLinkModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/WebLinkManager.class */
public final class WebLinkManager {

    /* renamed from: a  reason: collision with root package name */
    public static final WebLinkManager f34474a;
    private static final String b;

    /* renamed from: c  reason: collision with root package name */
    private static long f34475c;
    private static List<String> d;
    private static List<String> e;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/WebLinkManager$LinkType.class */
    public enum LinkType {
        NORMAL,
        WHITE,
        BLACK
    }

    static {
        WebLinkManager webLinkManager = new WebLinkManager();
        f34474a = webLinkManager;
        b = "web_links_rule";
        d = webLinkManager.c();
        e = CollectionsKt.b();
    }

    private WebLinkManager() {
    }

    private final void a(BluedUIHttpResponse<?> bluedUIHttpResponse) {
        HttpManager.a(Intrinsics.a(BluedHttpUrl.q(), (Object) "/blued/url/list"), bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[Catch: Exception -> 0x0032, TRY_ENTER, TryCatch #0 {Exception -> 0x0032, blocks: (B:2:0x0000, B:4:0x0011, B:9:0x0021), top: B:15:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.soft.blued.ui.web.modelloader.model.WebLinkModel r5) {
        /*
            r4 = this;
            com.google.gson.Gson r0 = com.blued.android.core.AppInfo.f()     // Catch: java.lang.Exception -> L32
            r1 = r5
            java.lang.String r0 = r0.toJson(r1)     // Catch: java.lang.Exception -> L32
            r5 = r0
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L32
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L39
            r0 = r7
            int r0 = r0.length()     // Catch: java.lang.Exception -> L32
            if (r0 != 0) goto L34
            goto L39
        L1d:
            r0 = r6
            if (r0 != 0) goto L31
            com.blued.android.module.common.utils.BluedSharedPreferences r0 = com.soft.blued.utils.BluedPreferences.a()     // Catch: java.lang.Exception -> L32
            com.blued.android.module.common.utils.BluedSharedPreferences$Editor r0 = r0.c()     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = com.soft.blued.ui.web.WebLinkManager.b     // Catch: java.lang.Exception -> L32
            r2 = r5
            com.blued.android.module.common.utils.BluedSharedPreferences$Editor r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L32
            r0.b()     // Catch: java.lang.Exception -> L32
        L31:
            return
        L32:
            r5 = move-exception
            return
        L34:
            r0 = 0
            r6 = r0
            goto L1d
        L39:
            r0 = 1
            r6 = r0
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.web.WebLinkManager.a(com.soft.blued.ui.web.modelloader.model.WebLinkModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        String a2 = BluedPreferences.a().a(b, "");
        String str = a2;
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            WebLinkModel webLinkModel = (WebLinkModel) AppInfo.f().fromJson(a2, (Class<Object>) WebLinkModel.class);
            e = webLinkModel.getBlack_list();
            List<String> white_list = webLinkModel.getWhite_list();
            List<String> list = white_list;
            if (white_list.isEmpty()) {
                list = f34474a.c();
            }
            d = list;
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> c() {
        return CollectionsKt.a("blued.cn");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027 A[Catch: Exception -> 0x00b2, TRY_ENTER, TryCatch #0 {Exception -> 0x00b2, blocks: (B:3:0x0006, B:5:0x0015, B:10:0x0027, B:12:0x002f, B:15:0x003a, B:18:0x0046, B:20:0x0053, B:22:0x005b, B:24:0x0077, B:26:0x007b, B:26:0x007b, B:27:0x007e, B:29:0x0088, B:31:0x0090, B:33:0x00ac), top: B:41:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[Catch: Exception -> 0x00b2, TryCatch #0 {Exception -> 0x00b2, blocks: (B:3:0x0006, B:5:0x0015, B:10:0x0027, B:12:0x002f, B:15:0x003a, B:18:0x0046, B:20:0x0053, B:22:0x005b, B:24:0x0077, B:26:0x007b, B:26:0x007b, B:27:0x007e, B:29:0x0088, B:31:0x0090, B:33:0x00ac), top: B:41:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.soft.blued.ui.web.WebLinkManager.LinkType a(java.lang.String r8) {
        /*
            r7 = this;
            r0 = r8
            java.lang.String r1 = "urlStr"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r8
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r0 = r0.getScheme()     // Catch: java.lang.Exception -> Lb2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> Lb2
            r10 = r0
            r0 = r10
            if (r0 == 0) goto Lc0
            r0 = r10
            int r0 = r0.length()     // Catch: java.lang.Exception -> Lb2
            if (r0 != 0) goto Lbb
            goto Lc0
        L21:
            r0 = r8
            r10 = r0
            r0 = r9
            if (r0 == 0) goto L2e
            java.lang.String r0 = "http://"
            r1 = r8
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.a(r0, r1)     // Catch: java.lang.Exception -> Lb2
            r10 = r0
        L2e:
            r0 = r10
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Exception -> Lb2
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L3a
            goto Lb7
        L3a:
            r0 = r8
            java.lang.String r0 = r0.getHost()     // Catch: java.lang.Exception -> Lb2
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L46
            goto Lb7
        L46:
            java.util.List<java.lang.String> r0 = com.soft.blued.ui.web.WebLinkManager.d     // Catch: java.lang.Exception -> Lb2
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Exception -> Lb2
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Lb2
            r10 = r0
        L52:
            r0 = r10
            boolean r0 = r0.hasNext()     // Catch: java.lang.Exception -> Lb2
            if (r0 == 0) goto L7b
            r0 = r10
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Exception -> Lb2
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> Lb2
            r11 = r0
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> Lb2
            r1 = r11
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            int r0 = kotlin.text.StringsKt.a(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Lb2
            if (r0 < 0) goto L52
            com.soft.blued.ui.web.WebLinkManager$LinkType r0 = com.soft.blued.ui.web.WebLinkManager.LinkType.WHITE     // Catch: java.lang.Exception -> Lb2
            return r0
        L7b:
            java.util.List<java.lang.String> r0 = com.soft.blued.ui.web.WebLinkManager.e     // Catch: java.lang.Exception -> Lb2 java.lang.Exception -> Lb2
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Exception -> Lb2
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Lb2
            r10 = r0
        L87:
            r0 = r10
            boolean r0 = r0.hasNext()     // Catch: java.lang.Exception -> Lb2
            if (r0 == 0) goto Lb7
            r0 = r10
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Exception -> Lb2
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> Lb2
            r11 = r0
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> Lb2
            r1 = r11
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            int r0 = kotlin.text.StringsKt.a(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Lb2
            if (r0 < 0) goto L87
            com.soft.blued.ui.web.WebLinkManager$LinkType r0 = com.soft.blued.ui.web.WebLinkManager.LinkType.BLACK     // Catch: java.lang.Exception -> Lb2
            r8 = r0
            r0 = r8
            return r0
        Lb2:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        Lb7:
            com.soft.blued.ui.web.WebLinkManager$LinkType r0 = com.soft.blued.ui.web.WebLinkManager.LinkType.NORMAL
            return r0
        Lbb:
            r0 = 0
            r9 = r0
            goto L21
        Lc0:
            r0 = 1
            r9 = r0
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.web.WebLinkManager.a(java.lang.String):com.soft.blued.ui.web.WebLinkManager$LinkType");
    }

    public final void a() {
        if (UserInfo.getInstance().isLogin() && f34475c + 60000 <= System.currentTimeMillis()) {
            f34475c = System.currentTimeMillis();
            a(new BluedUIHttpResponse<BluedEntityA<WebLinkModel>>() { // from class: com.soft.blued.ui.web.WebLinkManager$updateWebLinks$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<WebLinkModel> bluedEntityA) {
                    WebLinkModel singleData;
                    List<String> c2;
                    if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                        WebLinkManager.f34474a.b();
                        return;
                    }
                    WebLinkManager webLinkManager = WebLinkManager.f34474a;
                    WebLinkManager.e = singleData.getBlack_list();
                    WebLinkManager webLinkManager2 = WebLinkManager.f34474a;
                    List<String> white_list = singleData.getWhite_list();
                    List<String> list = white_list;
                    if (white_list.isEmpty()) {
                        c2 = WebLinkManager.f34474a.c();
                        list = c2;
                    }
                    WebLinkManager.d = list;
                    WebLinkManager.f34474a.a(singleData);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    WebLinkManager.f34474a.b();
                    return true;
                }
            });
        }
    }
}
