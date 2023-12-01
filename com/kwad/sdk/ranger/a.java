package com.kwad.sdk.ranger;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.ranger.d;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.y;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/a.class */
public final class a {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();

    static void a(Activity activity, List<d.a> list) {
        String str;
        try {
            for (d.a aVar : list) {
                if (aVar != null) {
                    if (TextUtils.equals(activity.getClass().getName(), aVar.axY)) {
                        str = aVar.axY;
                    } else {
                        str = "";
                        if (!TextUtils.isEmpty(aVar.axZ)) {
                            str = "";
                            if (activity.getClass().getName().startsWith(aVar.axY)) {
                                str = c(activity, aVar.axZ);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        int c2 = y.c("ksadsdk_perf_ranger", str, 0) + 1;
                        y.b("ksadsdk_perf_ranger", str, c2);
                        String str2 = TAG;
                        com.kwad.sdk.core.d.b.d(str2, "act:" + str + " num:" + c2);
                    }
                }
            }
        } catch (Throwable th) {
            String str3 = TAG;
            com.kwad.sdk.core.d.b.e(str3, "record:" + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(d dVar) {
        final List<d.a> list = dVar.axU;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(new com.kwad.sdk.core.b.d() { // from class: com.kwad.sdk.ranger.a.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                super.onActivityCreated(activity, bundle);
                try {
                    a.a(activity, List.this);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.e(a.TAG, Log.getStackTraceString(th));
                }
            }
        });
    }

    private static String c(Object obj, String str) {
        Object d;
        return (TextUtils.isEmpty(str) || (d = s.d(obj, str)) == null) ? "" : d.getClass().getName();
    }
}
