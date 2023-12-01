package com.kwad.sdk.core.webview.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.q;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/a/a/b.class */
public final class b {
    public static boolean a(Context context, com.kwad.sdk.f.kwai.b bVar) {
        synchronized (b.class) {
            try {
                String str = bVar.ato;
                File file = new File(str);
                if (q.G(file)) {
                    if (!TextUtils.isEmpty(bVar.atq)) {
                        String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
                        String str2 = fileMD5;
                        if (fileMD5 != null) {
                            str2 = fileMD5;
                            if (fileMD5.length() > 10) {
                                str2 = fileMD5.substring(0, 10);
                            }
                        }
                        if (!bb.isEquals(str2, bVar.atq)) {
                            q.V(file);
                            return false;
                        }
                    }
                    com.kwad.sdk.core.webview.a.b.b.a(bVar, 2);
                    try {
                        com.kwad.sdk.core.webview.a.b.a.e(context, str, com.kwad.sdk.core.webview.a.b.a.x(context, bVar.atn));
                        q.V(file);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 2, e.getMessage());
                        return false;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
