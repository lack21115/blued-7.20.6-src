package com.anythink.expressad.video.dynview.i;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.k.d;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/i/c.class */
public final class c {
    public static int a(com.anythink.expressad.foundation.d.c cVar) {
        int i;
        if (cVar != null && cVar.M() != null) {
            int b = cVar.M().b();
            i = -3;
            if (b != 302) {
                i = -3;
                if (b != 802) {
                    if (b == 904) {
                        i = -3;
                        if (!a(cVar.M().e())) {
                            return -1;
                        }
                    }
                }
            }
            return i;
        }
        i = 100;
        return i;
    }

    private static String a(long j, Context context) {
        String f = d.f(context);
        if (f.startsWith(com.anythink.expressad.video.dynview.a.a.V)) {
            if (f.contains("TW") || f.contains(com.anythink.expressad.video.dynview.a.a.ae)) {
                return j + com.anythink.expressad.video.dynview.a.a.G;
            }
            return j + com.anythink.expressad.video.dynview.a.a.F;
        } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.W)) {
            return j + com.anythink.expressad.video.dynview.a.a.I;
        } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.X)) {
            return com.anythink.expressad.video.dynview.a.a.J + j + " Sekunden";
        } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.Y)) {
            return j + com.anythink.expressad.video.dynview.a.a.K;
        } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.Z)) {
            return com.anythink.expressad.video.dynview.a.a.L + j + " secondes";
        } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.aa)) {
            return " ثوان" + j + com.anythink.expressad.video.dynview.a.a.M;
        } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.ab)) {
            return com.anythink.expressad.video.dynview.a.a.N + j + " секунд";
        } else {
            return com.anythink.expressad.video.dynview.a.a.H + j + " s";
        }
    }

    private static void a(Activity activity) {
        if (a((Context) activity)) {
            activity.setRequestedOrientation(6);
        } else {
            activity.setRequestedOrientation(7);
        }
    }

    private static void a(com.anythink.expressad.foundation.d.c cVar, Activity activity) {
        if (cVar == null || cVar.M() == null) {
            return;
        }
        int c2 = cVar.M().c();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (c2 == 1) {
            activity.setRequestedOrientation(7);
        } else if (c2 == 2) {
            activity.setRequestedOrientation(6);
        } else if (a((Context) activity)) {
            activity.setRequestedOrientation(6);
        } else {
            activity.setRequestedOrientation(7);
        }
    }

    public static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        boolean z = false;
        if (parse != null) {
            try {
                String queryParameter = parse.getQueryParameter(com.anythink.expressad.video.dynview.a.a.Q);
                z = false;
                if (!TextUtils.isEmpty(queryParameter)) {
                    z = false;
                    if (queryParameter.equals("1")) {
                        z = true;
                    }
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return z;
    }

    private static boolean a(List<com.anythink.expressad.foundation.d.c> list) {
        com.anythink.expressad.foundation.d.c cVar;
        if (list == null || list.size() <= 0 || (cVar = list.get(0)) == null) {
            return false;
        }
        return cVar.j();
    }

    private static int b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.M() == null) {
            return 1;
        }
        return cVar.M().c();
    }
}
