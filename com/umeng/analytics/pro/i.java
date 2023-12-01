package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.e;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final int f27059a = 2049;
    public static final int b = 2050;

    /* renamed from: c  reason: collision with root package name */
    private static final int f27060c = 1000;
    private static Context d;
    private static String e;
    private static final String f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/i$a.class */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/i$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final i f27063a = new i();

        private b() {
        }
    }

    private i() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Cursor cursor = null;
        if (sQLiteDatabase != null) {
            cursor = null;
            try {
                if (sQLiteDatabase.isOpen()) {
                    cursor = sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
                }
            } catch (Throwable th) {
                return null;
            }
        }
        return cursor;
    }

    public static i a(Context context) {
        i iVar = b.f27063a;
        if (d == null && context != null) {
            d = context.getApplicationContext();
            iVar.k();
        }
        return iVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0444, code lost:
        if (r17 != null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0473, code lost:
        if (r17 != null) goto L92;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0467  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:175:0x0508 -> B:99:0x037d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x0514 -> B:144:0x04a1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(org.json.JSONObject r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, boolean):java.lang.String");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt(e.d.a.g)).longValue();
            Object opt = jSONObject.opt(e.d.a.h);
            long j = 0;
            if (opt != null) {
                j = 0;
                if (opt instanceof Long) {
                    j = ((Long) opt).longValue();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            String str2 = "";
            if (optJSONObject2 != null) {
                str2 = "";
                if (optJSONObject2.length() > 0) {
                    str2 = c(optJSONObject2.toString());
                }
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + e.d.a.h + "=\"" + j + "\", __sp=\"" + c2 + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad A[Catch: all -> 0x0187, TryCatch #1 {all -> 0x0187, blocks: (B:23:0x007b, B:25:0x0085, B:26:0x009d, B:28:0x00a7, B:30:0x00ad, B:32:0x00b9, B:40:0x00d6, B:43:0x00e4, B:45:0x00f0, B:46:0x00fa, B:48:0x010b), top: B:71:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r12, org.json.JSONObject r13, android.database.sqlite.SQLiteDatabase r14, java.lang.String r15) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:170:0x03eb, code lost:
        if (r12 == null) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x040c, code lost:
        if (r12 == null) goto L191;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v154, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v158, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v162, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v175, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v24, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v51, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v64, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v15, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v17, types: [android.database.Cursor] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:201:0x0453 -> B:180:0x0413). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:203:0x0457 -> B:190:0x0432). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 1115
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x02b8, code lost:
        r15 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0238, code lost:
        if (r14 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0263, code lost:
        if (r14 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0266, code lost:
        r14.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x026b, code lost:
        r15 = r12;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x02b3 -> B:69:0x01de). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:121:0x02be -> B:102:0x0290). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(org.json.JSONObject r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 717
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, boolean):java.lang.String");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return jSONArray2;
            }
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
            i = i2 + 1;
        }
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            String str2 = "";
            if (optJSONObject2 != null) {
                str2 = "";
                if (optJSONObject2.length() > 0) {
                    str2 = c(optJSONObject2.toString());
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c2);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
            sQLiteDatabase.insert(e.c.f27044a, null, contentValues);
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0124, code lost:
        if (r12 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0144, code lost:
        if (r12 == null) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v0, types: [org.json.JSONObject] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0187 -> B:61:0x014b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x018b -> B:71:0x0168). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(org.json.JSONObject r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.lang.String r12, org.json.JSONObject r13, android.database.sqlite.SQLiteDatabase r14) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.c(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(d, g);
                String str = multiProcessSP;
                if (TextUtils.isEmpty(multiProcessSP)) {
                    String string = PreferenceWrapper.getDefault(d).getString(g, null);
                    String str2 = string;
                    if (TextUtils.isEmpty(string)) {
                        str2 = UMUtils.genId();
                    }
                    str = str2;
                    if (!TextUtils.isEmpty(str2)) {
                        UMUtils.setMultiProcessSP(d, g, str2);
                        str = str2;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    String substring = str.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= substring.length()) {
                            break;
                        }
                        char charAt = substring.charAt(i2);
                        if (!Character.isDigit(charAt)) {
                            sb.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                        i = i2 + 1;
                    }
                    e = sb.toString();
                }
                if (TextUtils.isEmpty(e)) {
                    return;
                }
                e += new StringBuilder(e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(d, h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(d, h, c(f));
                } else if (f.equals(d(multiProcessSP2))) {
                } else {
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x008b, code lost:
        if (r19 != null) goto L26;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00f3 -> B:32:0x00af). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String):long");
    }

    public JSONObject a(boolean z) {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
            return jSONObject;
        }
        String a2 = a(jSONObject, z);
        if (!TextUtils.isEmpty(a2)) {
            b(jSONObject, a2);
            a(jSONObject, a2);
        }
        return jSONObject;
    }

    public void a() {
        this.i.clear();
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:362)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:97)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:534)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:519)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:483)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:486)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x014b -> B:29:0x0103). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x014f -> B:39:0x0124). Please submit an issue!!! */
    public void a(org.json.JSONArray r6) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONArray):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x015b, code lost:
        if (r6 == null) goto L50;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x017d -> B:51:0x014a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0181 -> B:61:0x016a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(boolean, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x012b, code lost:
        if (r9 == null) goto L19;
     */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x013f: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:54:0x013f */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x015f -> B:50:0x0133). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0164 -> B:57:0x0149). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r4, boolean r5) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(boolean, boolean):void");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:362)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:97)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:534)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:519)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:483)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:486)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00cc -> B:13:0x0087). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d0 -> B:24:0x00ab). Please submit an issue!!! */
    public boolean a(java.lang.String r6, java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, java.lang.String, int):boolean");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:362)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:97)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:534)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:519)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:483)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:486)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0125 -> B:32:0x00e3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0129 -> B:42:0x0104). Please submit an issue!!! */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.i.a r9) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.i$a):boolean");
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    public void b() {
        this.l.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
        if (r5 == null) goto L28;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c4 -> B:29:0x0091). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00c8 -> B:39:0x00b1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0104, code lost:
        if (r8 == null) goto L18;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x012c -> B:39:0x00f2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0131 -> B:49:0x0116). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(boolean r5, boolean r6) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(boolean, boolean):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), e.getBytes()), 0);
        } catch (Exception e2) {
            return null;
        }
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
        } catch (Exception e2) {
            if (Build.VERSION.SDK_INT < 29 || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                new JSONObject(str);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                return str;
            } catch (Throwable th) {
                return null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0131, code lost:
        if (r9 == null) goto L51;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0156 -> B:14:0x0046). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x015a -> B:47:0x0120). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x015e -> B:57:0x0141). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.d():void");
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0122, code lost:
        if (r14 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0125, code lost:
        r14.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012a, code lost:
        r15 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0156, code lost:
        if (r14 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a1, code lost:
        r15 = r13;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x019c -> B:27:0x00d6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x01a7 -> B:60:0x0171). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject f() {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.f():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0121, code lost:
        if (r14 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0124, code lost:
        r14.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0129, code lost:
        r15 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0155, code lost:
        if (r14 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a0, code lost:
        r15 = r13;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x019b -> B:27:0x00d5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x01a6 -> B:60:0x0170). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject g() {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.g():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cc, code lost:
        if (r6 == null) goto L33;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ee -> B:34:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f2 -> B:44:0x00db). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.h():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r4 == null) goto L15;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x006f -> B:16:0x003c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0073 -> B:26:0x005c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            r3 = this;
            r0 = 0
            r5 = r0
            r0 = 0
            r4 = r0
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L67 java.lang.Throwable -> L6b
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L67 java.lang.Throwable -> L6b
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L67 java.lang.Throwable -> L6b
            r6 = r0
            r0 = r6
            r4 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            r0.beginTransaction()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L67 java.lang.Throwable -> L6b
            r0 = r6
            r4 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L67 java.lang.Throwable -> L6b
            r0 = r6
            r4 = r0
            r0 = r6
            r5 = r0
            r0 = r6
            r0.setTransactionSuccessful()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L67 java.lang.Throwable -> L6b
            r0 = r6
            if (r0 == 0) goto L3c
            r0 = r6
            r4 = r0
            goto L38
        L32:
            r0 = r5
            if (r0 == 0) goto L3c
            r0 = r5
            r4 = r0
        L38:
            r0 = r4
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L3c:
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L6f
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            return
        L46:
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L53
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> L53
            r0 = r4
            if (r0 == 0) goto L3c
            goto L38
        L53:
            r5 = move-exception
            r0 = r4
            if (r0 == 0) goto L5c
            r0 = r4
            r0.endTransaction()     // Catch: java.lang.Throwable -> L73
        L5c:
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L73
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r0 = r5
            throw r0
        L67:
            r5 = move-exception
            goto L46
        L6b:
            r4 = move-exception
            goto L32
        L6f:
            r4 = move-exception
            goto L3c
        L73:
            r4 = move-exception
            goto L5c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.i():void");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:362)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:97)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:534)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:519)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:483)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:486)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c4 -> B:13:0x007f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c8 -> B:23:0x00a3). Please submit an issue!!! */
    public void j() {
        /*
            r3 = this;
            r0 = r3
            java.lang.String r0 = r0.k
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lae
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4 java.lang.Throwable -> Lb8
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4 java.lang.Throwable -> Lb8
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lb4 java.lang.Throwable -> Lb8
            r4 = r0
            r0 = r4
            r0.beginTransaction()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r1 = r0
            r1.<init>()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r5 = r0
            r0 = r5
            java.lang.String r1 = "delete from __er where __i=\""
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0 = r5
            r1 = r3
            java.lang.String r1 = r1.k     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0 = r5
            java.lang.String r1 = "\""
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0 = r4
            r1 = r5
            java.lang.String r1 = r1.toString()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0.execSQL(r1)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r1 = r0
            r1.<init>()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r5 = r0
            r0 = r5
            java.lang.String r1 = "delete from __et where __i=\""
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0 = r5
            r1 = r3
            java.lang.String r1 = r1.k     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0 = r5
            java.lang.String r1 = "\""
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0 = r4
            r1 = r5
            java.lang.String r1 = r1.toString()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0.execSQL(r1)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0 = r4
            r0.setTransactionSuccessful()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> Lbc java.lang.Throwable -> Lc0
            r0 = r4
            if (r0 == 0) goto L7f
            goto L7b
        L75:
            r0 = 0
            r4 = r0
        L77:
            r0 = r4
            if (r0 == 0) goto L7f
        L7b:
            r0 = r4
            r0.endTransaction()     // Catch: java.lang.Throwable -> Lc4
        L7f:
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> Lc4
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto Lae
        L8b:
            r0 = 0
            r4 = r0
        L8d:
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> L9a
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> L9a
            r0 = r4
            if (r0 == 0) goto L7f
            goto L7b
        L9a:
            r5 = move-exception
            r0 = r4
            if (r0 == 0) goto La3
            r0 = r4
            r0.endTransaction()     // Catch: java.lang.Throwable -> Lc8
        La3:
            android.content.Context r0 = com.umeng.analytics.pro.i.d     // Catch: java.lang.Throwable -> Lc8
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r0 = r5
            throw r0
        Lae:
            r0 = r3
            r1 = 0
            r0.k = r1
            return
        Lb4:
            r4 = move-exception
            goto L8b
        Lb8:
            r4 = move-exception
            goto L75
        Lbc:
            r5 = move-exception
            goto L8d
        Lc0:
            r5 = move-exception
            goto L77
        Lc4:
            r4 = move-exception
            goto L7f
        Lc8:
            r4 = move-exception
            goto La3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.j():void");
    }
}
