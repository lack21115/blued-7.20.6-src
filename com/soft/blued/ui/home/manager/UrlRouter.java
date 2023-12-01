package com.soft.blued.ui.home.manager;

import android.net.Uri;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.track.trackUtils.EventTrackCommon;
import com.blued.track.trackUtils.IALinkListener;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.manager.SendNotificationManager;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.utils.Logger;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/manager/UrlRouter.class */
public final class UrlRouter {

    /* renamed from: a  reason: collision with root package name */
    public static final UrlRouter f31043a = new UrlRouter();
    private static AtomicBoolean b = new AtomicBoolean(false);

    private UrlRouter() {
    }

    @JvmStatic
    public static final void a() {
        if (BluedApplicationLike.outUri == null) {
            return;
        }
        final Uri uri = BluedApplicationLike.outUri;
        BluedApplicationLike.outUri = null;
        if (uri != null) {
            try {
                String uri2 = uri.toString();
                Intrinsics.c(uri2, "outUri.toString()");
                String decode = URLDecoder.decode(uri2, "UTF-8");
                Intrinsics.c(decode, "decode(url, \"UTF-8\")");
                if ((StringsKt.b(decode, "blued://", true) || StringsKt.c((CharSequence) decode, (CharSequence) "ur.blued.cn", false, 2, (Object) null)) && StringsKt.c((CharSequence) decode, (CharSequence) "tr_param1=", false, 2, (Object) null)) {
                    AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.home.manager.-$$Lambda$UrlRouter$zzPJfvsBfRPvEqLBX3UWFUjEsuM
                        @Override // java.lang.Runnable
                        public final void run() {
                            UrlRouter.c(Uri.this);
                        }
                    }, 2000L);
                    f31043a.b(uri);
                } else {
                    f31043a.a(decode, false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        SDKActionManager.a(SendNotificationManager.a().b());
    }

    private final void a(Uri uri) {
        if (b.get()) {
            boolean z = false;
            b.set(false);
            String queryParameter = uri.getQueryParameter("tr_param1");
            if (queryParameter == null) {
                return;
            }
            if (queryParameter.length() > 0) {
                z = true;
            }
            if (z) {
                f31043a.a(queryParameter, true);
            }
        }
    }

    private final void a(String str, boolean z) {
        String str2 = str;
        if (z) {
            str2 = StringsKt.c((CharSequence) str, (CharSequence) "action=webbrowse", false, 2, (Object) null) ? StringsKt.b(str, "-", "&", false, 4, (Object) null) : StringsKt.a(str, "-", "&", false, 4, (Object) null);
        }
        Uri f = BluedURIRouter.a().f(str2);
        if (f != null) {
            BluedURIRouter.a().a(SendNotificationManager.a().b(), f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        String str = map.get("utm_campaign");
        if (str != null) {
            ALinkAction.f31041a.a(str, (IRequestHost) null);
        }
        String str2 = map.get("tr_param1");
        if (str2 == null) {
            return;
        }
        if (str2.length() > 0) {
            b.set(false);
            f31043a.a(str2, true);
        }
    }

    private final void b(Uri uri) {
        b.set(true);
        Logger.a("xxx", Intrinsics.a(" ALink=", (Object) uri));
        EventTrackCommon.a(uri, new IALinkListener() { // from class: com.soft.blued.ui.home.manager.UrlRouter$processALink$1
            @Override // com.blued.track.trackUtils.IALinkListener
            public void a(Map<String, String> map, Exception exc) {
                UrlRouter.f31043a.a(map);
            }

            @Override // com.blued.track.trackUtils.IALinkListener
            public void b(Map<String, String> map, Exception e) {
                Intrinsics.e(map, "map");
                Intrinsics.e(e, "e");
                UrlRouter.f31043a.a(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Uri outUri) {
        Intrinsics.e(outUri, "$outUri");
        f31043a.a(outUri);
    }
}
