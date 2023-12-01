package com.anythink.expressad.video.bt.a;

import android.util.Base64;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.bt.module.AnythinkBTVideoView;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/a/a.class */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f8284c = a.class.getSimpleName();
    private static LinkedHashMap<String, AnythinkBTVideoView> e = new LinkedHashMap<>();
    private String d = "handlerNativeResult";

    /* renamed from: a  reason: collision with root package name */
    int f8285a = 0;
    int b = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.bt.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/a/a$a.class */
    public static final class C0158a {

        /* renamed from: a  reason: collision with root package name */
        private static a f8286a = new a();

        private C0158a() {
        }
    }

    public static a a() {
        return C0158a.f8286a;
    }

    private static void a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e2) {
            o.a(f8284c, e2.getMessage());
        } catch (Throwable th) {
            o.a(f8284c, th.getMessage());
        }
    }

    public static void a(String str) {
        e.remove(str);
    }

    public static void a(String str, AnythinkBTVideoView anythinkBTVideoView) {
        e.put(str, anythinkBTVideoView);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0165 A[Catch: all -> 0x0241, TRY_ENTER, TryCatch #0 {all -> 0x0241, blocks: (B:5:0x0010, B:7:0x0017, B:10:0x0027, B:12:0x003f, B:17:0x0052, B:19:0x005d, B:21:0x0063, B:23:0x006e, B:25:0x0079, B:27:0x0084, B:29:0x0091, B:31:0x00a1, B:33:0x00a6, B:35:0x00b1, B:37:0x00ba, B:39:0x00ca, B:41:0x00cf, B:43:0x00da, B:45:0x00e3, B:47:0x00f3, B:49:0x00f8, B:51:0x0103, B:57:0x011b, B:59:0x0123, B:61:0x0133, B:66:0x0155, B:69:0x0165, B:74:0x0185, B:75:0x0191, B:77:0x01a1, B:79:0x01aa, B:81:0x01b5, B:87:0x01cd, B:89:0x01d5, B:92:0x01e3, B:94:0x01f8, B:99:0x020b, B:100:0x0214, B:100:0x0214, B:101:0x0217, B:103:0x0224, B:105:0x022b, B:107:0x0236), top: B:114:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a1 A[Catch: all -> 0x0241, TRY_ENTER, TryCatch #0 {all -> 0x0241, blocks: (B:5:0x0010, B:7:0x0017, B:10:0x0027, B:12:0x003f, B:17:0x0052, B:19:0x005d, B:21:0x0063, B:23:0x006e, B:25:0x0079, B:27:0x0084, B:29:0x0091, B:31:0x00a1, B:33:0x00a6, B:35:0x00b1, B:37:0x00ba, B:39:0x00ca, B:41:0x00cf, B:43:0x00da, B:45:0x00e3, B:47:0x00f3, B:49:0x00f8, B:51:0x0103, B:57:0x011b, B:59:0x0123, B:61:0x0133, B:66:0x0155, B:69:0x0165, B:74:0x0185, B:75:0x0191, B:77:0x01a1, B:79:0x01aa, B:81:0x01b5, B:87:0x01cd, B:89:0x01d5, B:92:0x01e3, B:94:0x01f8, B:99:0x020b, B:100:0x0214, B:100:0x0214, B:101:0x0217, B:103:0x0224, B:105:0x022b, B:107:0x0236), top: B:114:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01aa A[Catch: all -> 0x0241, TRY_ENTER, TryCatch #0 {all -> 0x0241, blocks: (B:5:0x0010, B:7:0x0017, B:10:0x0027, B:12:0x003f, B:17:0x0052, B:19:0x005d, B:21:0x0063, B:23:0x006e, B:25:0x0079, B:27:0x0084, B:29:0x0091, B:31:0x00a1, B:33:0x00a6, B:35:0x00b1, B:37:0x00ba, B:39:0x00ca, B:41:0x00cf, B:43:0x00da, B:45:0x00e3, B:47:0x00f3, B:49:0x00f8, B:51:0x0103, B:57:0x011b, B:59:0x0123, B:61:0x0133, B:66:0x0155, B:69:0x0165, B:74:0x0185, B:75:0x0191, B:77:0x01a1, B:79:0x01aa, B:81:0x01b5, B:87:0x01cd, B:89:0x01d5, B:92:0x01e3, B:94:0x01f8, B:99:0x020b, B:100:0x0214, B:100:0x0214, B:101:0x0217, B:103:0x0224, B:105:0x022b, B:107:0x0236), top: B:114:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r5, java.lang.String r6, org.json.JSONArray r7) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.bt.a.a.a(java.lang.Object, java.lang.String, org.json.JSONArray):void");
    }
}
