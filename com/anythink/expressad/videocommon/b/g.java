package com.anythink.expressad.videocommon.b;

import android.webkit.URLUtil;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.videocommon.b.h;
import com.anythink.expressad.videocommon.b.i;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8736a = "<anythinkloadend></anythinkloadend>";
    private static final String b = "DownLoadUtils";

    /* renamed from: c  reason: collision with root package name */
    private static final int f8737c = 20000;
    private static final int d = 30000;

    public static void a(final String str, final i.c cVar) {
        try {
            if (!w.a(str) && URLUtil.isNetworkUrl(str)) {
                h.a.f8740a.a(new com.anythink.expressad.foundation.g.g.a() { // from class: com.anythink.expressad.videocommon.b.g.1
                    final /* synthetic */ boolean f = true;

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:135:0x0214 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:63:0x01c7  */
                    /* JADX WARN: Removed duplicated region for block: B:67:0x01e8  */
                    /* JADX WARN: Removed duplicated region for block: B:83:0x023a A[Catch: all -> 0x02dc, TRY_ENTER, TryCatch #11 {all -> 0x02dc, blocks: (B:73:0x0214, B:77:0x0220, B:79:0x0226, B:83:0x023a, B:85:0x0242, B:87:0x024a, B:89:0x0254, B:91:0x025b, B:93:0x026b, B:95:0x0272), top: B:135:0x0214 }] */
                    /* JADX WARN: Removed duplicated region for block: B:95:0x0272 A[Catch: all -> 0x02dc, TryCatch #11 {all -> 0x02dc, blocks: (B:73:0x0214, B:77:0x0220, B:79:0x0226, B:83:0x023a, B:85:0x0242, B:87:0x024a, B:89:0x0254, B:91:0x025b, B:93:0x026b, B:95:0x0272), top: B:135:0x0214 }] */
                    /* JADX WARN: Type inference failed for: r0v150, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r0v64 */
                    /* JADX WARN: Type inference failed for: r0v67, types: [com.anythink.expressad.videocommon.b.i$c] */
                    /* JADX WARN: Type inference failed for: r0v73, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r0v75, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r0v77, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r0v82, types: [com.anythink.expressad.videocommon.b.i$c] */
                    /* JADX WARN: Type inference failed for: r1v11, types: [byte[]] */
                    /* JADX WARN: Type inference failed for: r1v7, types: [byte[]] */
                    @Override // com.anythink.expressad.foundation.g.g.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void a() {
                        /*
                            Method dump skipped, instructions count: 742
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.g.AnonymousClass1.a():void");
                    }

                    @Override // com.anythink.expressad.foundation.g.g.a
                    public final void b() {
                    }

                    @Override // com.anythink.expressad.foundation.g.g.a
                    public final void c() {
                    }
                });
                return;
            }
            cVar.a("url is error");
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f6941a) {
                th.printStackTrace();
            }
        }
    }
}
