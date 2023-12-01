package com.umeng.umzid;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ErrorCode;
import com.umeng.analytics.pro.bh;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/umzid/ZIDManager.class */
public class ZIDManager {
    public static ZIDManager d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f40973a = false;
    public boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40974c;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/umzid/ZIDManager$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f40975a;
        public final /* synthetic */ IZIDCompletionCallback b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f40975a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2 = ZIDManager.a(ZIDManager.this, this.f40975a);
            if (TextUtils.isEmpty(a2)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(ErrorCode.serverError, "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a2);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/umzid/ZIDManager$b.class */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f40977a;

        public b(Context context) {
            this.f40977a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.a(this.f40977a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/umzid/ZIDManager$c.class */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f40978a;

        public c(Context context) {
            this.f40978a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f40978a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String str;
        if (zIDManager.f40973a) {
            return null;
        }
        zIDManager.f40973a = true;
        JSONObject jSONObject = new JSONObject();
        String str2 = null;
        try {
            String id = Spy.getID();
            jSONObject.put(bh.aG, id);
            String b2 = d.b(context);
            jSONObject.put("mc", b2);
            String c2 = d.c(context);
            jSONObject.put("o", c2);
            zIDManager.a(context, jSONObject);
            String a2 = com.umeng.umzid.a.a("https://utoken.umeng.com/api/postZdata/v4", jSONObject.toString());
            str = null;
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject2 = new JSONObject(a2);
                str = null;
                if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                    d.f(context, id);
                    d.a(context, b2);
                    d.b(context, c2);
                    String optString = jSONObject2.optString("aaid");
                    if (!TextUtils.isEmpty(optString)) {
                        d.e(context, optString);
                    }
                    String string = jSONObject2.getString("uabc");
                    if (!TextUtils.isEmpty(string)) {
                        d.d(context, string);
                    }
                    String string2 = jSONObject2.getString("resetToken");
                    str = optString;
                    if (!TextUtils.isEmpty(string2)) {
                        str2 = optString;
                        d.c(context, string2);
                        str = optString;
                    }
                }
            }
        } catch (Throwable th) {
            str = str2;
        }
        zIDManager.f40973a = false;
        return str;
    }

    public static ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            try {
                if (d == null) {
                    d = new ZIDManager();
                }
                zIDManager = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.6.3";
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0211  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 814
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:1|(2:2|3)|(2:7|(37:11|12|(7:108|109|110|(2:118|119)|112|113|(34:115|15|16|17|(2:21|(29:25|26|27|28|29|(4:84|85|86|(4:88|89|(2:90|(2:92|93)(1:94))|95))|31|(1:33)(1:83)|34|(1:36)(1:82)|37|38|39|40|41|42|43|44|45|46|(2:48|(1:50))|51|52|53|54|(3:56|57|(3:59|60|(3:62|63|(1:65))))|67|68|69))|106|26|27|28|29|(0)|31|(0)(0)|34|(0)(0)|37|38|39|40|41|42|43|44|45|46|(0)|51|52|53|54|(0)|67|68|69))|14|15|16|17|(3:19|21|(30:23|25|26|27|28|29|(0)|31|(0)(0)|34|(0)(0)|37|38|39|40|41|42|43|44|45|46|(0)|51|52|53|54|(0)|67|68|69))|106|26|27|28|29|(0)|31|(0)(0)|34|(0)(0)|37|38|39|40|41|42|43|44|45|46|(0)|51|52|53|54|(0)|67|68|69))|124|12|(0)|14|15|16|17|(0)|106|26|27|28|29|(0)|31|(0)(0)|34|(0)(0)|37|38|39|40|41|42|43|44|45|46|(0)|51|52|53|54|(0)|67|68|69) */
    /* JADX WARN: Can't wrap try/catch for region: R(41:1|2|3|(2:7|(37:11|12|(7:108|109|110|(2:118|119)|112|113|(34:115|15|16|17|(2:21|(29:25|26|27|28|29|(4:84|85|86|(4:88|89|(2:90|(2:92|93)(1:94))|95))|31|(1:33)(1:83)|34|(1:36)(1:82)|37|38|39|40|41|42|43|44|45|46|(2:48|(1:50))|51|52|53|54|(3:56|57|(3:59|60|(3:62|63|(1:65))))|67|68|69))|106|26|27|28|29|(0)|31|(0)(0)|34|(0)(0)|37|38|39|40|41|42|43|44|45|46|(0)|51|52|53|54|(0)|67|68|69))|14|15|16|17|(3:19|21|(30:23|25|26|27|28|29|(0)|31|(0)(0)|34|(0)(0)|37|38|39|40|41|42|43|44|45|46|(0)|51|52|53|54|(0)|67|68|69))|106|26|27|28|29|(0)|31|(0)(0)|34|(0)(0)|37|38|39|40|41|42|43|44|45|46|(0)|51|52|53|54|(0)|67|68|69))|124|12|(0)|14|15|16|17|(0)|106|26|27|28|29|(0)|31|(0)(0)|34|(0)(0)|37|38|39|40|41|42|43|44|45|46|(0)|51|52|53|54|(0)|67|68|69) */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0399, code lost:
        r12 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01ed, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0272, code lost:
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0274, code lost:
        r12.printStackTrace();
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02a6, code lost:
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02a8, code lost:
        r12.printStackTrace();
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02cc, code lost:
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02ce, code lost:
        r12.printStackTrace();
        r12 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f4 A[Catch: all -> 0x0384, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0384, blocks: (B:27:0x00e8, B:29:0x00f4, B:31:0x010c, B:33:0x0128, B:35:0x0130), top: B:118:0x00e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x031e A[Catch: all -> 0x0398, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0398, blocks: (B:80:0x030e, B:83:0x031e, B:86:0x033a, B:90:0x035c, B:92:0x0363), top: B:124:0x030e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject a(android.content.Context r8, org.json.JSONObject r9) {
        /*
            Method dump skipped, instructions count: 928
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    public String getZID(Context context) {
        synchronized (this) {
            if (context == null) {
                return "";
            }
            Context applicationContext = context.getApplicationContext();
            String a2 = d.a(applicationContext);
            if (TextUtils.isEmpty(a2)) {
                com.umeng.umzid.c.a(new c(applicationContext));
                return "";
            }
            return a2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1 A[Catch: all -> 0x0114, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0002, B:13:0x001e, B:17:0x002d, B:21:0x0038, B:25:0x0047, B:29:0x0056, B:31:0x005d, B:33:0x0069, B:35:0x0077, B:37:0x008a, B:39:0x0092, B:42:0x009c, B:44:0x00ad, B:48:0x00c8, B:50:0x00d1, B:52:0x00de, B:56:0x00e7, B:61:0x00fc, B:45:0x00b7), top: B:72:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(android.content.Context r7, java.lang.String r8, com.umeng.umzid.IZIDCompletionCallback r9) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.init(android.content.Context, java.lang.String, com.umeng.umzid.IZIDCompletionCallback):void");
    }
}
