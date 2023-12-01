package com.igexin.push.core;

import android.database.Cursor;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Message;
import android.service.notification.Condition;
import android.text.TextUtils;
import com.igexin.push.core.d;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.main.FeedbackImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/n.class */
public final class n {
    private static final String b = "PushMessageExecutor";
    private static Set<String> d;
    private static volatile n f;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, PushMessageInterface> f23579c;

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, String> f23578a = new HashMap<>();
    private final Map<String, String> e = new ConcurrentHashMap();

    private n() {
        d = new HashSet();
        this.f23579c = new HashMap();
        d.add(b.q);
        d.add("notification");
        d.add(b.n);
        d.add(b.o);
        d.add(b.p);
        d.add(b.l);
        d.add(b.r);
        d.add(b.s);
        d.add(b.t);
        d.add(b.u);
        d.add(b.v);
    }

    public static n a() {
        if (f == null) {
            synchronized (n.class) {
                try {
                    if (f == null) {
                        f = new n();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.igexin.push.extension.mod.PushMessageInterface a(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 754
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.a(java.lang.String):com.igexin.push.extension.mod.PushMessageInterface");
    }

    private PushMessageInterface b(String str) {
        if (TextUtils.isEmpty(str) || !d.contains(str)) {
            return null;
        }
        PushMessageInterface pushMessageInterface = this.f23579c.get(str);
        if (pushMessageInterface != null) {
            return pushMessageInterface;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -1618888868:
                if (str.equals(b.v)) {
                    z = true;
                    break;
                }
                break;
            case -1352939875:
                if (str.equals(b.o)) {
                    z = true;
                    break;
                }
                break;
            case -1218913434:
                if (str.equals(b.n)) {
                    z = true;
                    break;
                }
                break;
            case -631641375:
                if (str.equals(b.u)) {
                    z = true;
                    break;
                }
                break;
            case 3178851:
                if (str.equals(b.q)) {
                    z = false;
                    break;
                }
                break;
            case 3392903:
                if (str.equals(b.l)) {
                    z = true;
                    break;
                }
                break;
            case 595233003:
                if (str.equals("notification")) {
                    z = true;
                    break;
                }
                break;
            case 790184760:
                if (str.equals(b.t)) {
                    z = true;
                    break;
                }
                break;
            case 1316799103:
                if (str.equals(b.p)) {
                    z = true;
                    break;
                }
                break;
            case 1316819890:
                if (str.equals(b.r)) {
                    z = true;
                    break;
                }
                break;
            case 1536890905:
                if (str.equals(b.s)) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                this.f23579c.put(b.q, new com.igexin.push.core.a.c.f());
                break;
            case true:
                this.f23579c.put("notification", new com.igexin.push.core.a.c.g());
                break;
            case true:
                this.f23579c.put(b.n, new com.igexin.push.core.a.c.l());
                break;
            case true:
                this.f23579c.put(b.o, new com.igexin.push.core.a.c.j());
                break;
            case true:
                this.f23579c.put(b.p, new com.igexin.push.core.a.c.i());
                break;
            case true:
                this.f23579c.put(b.l, new com.igexin.push.core.a.c.e());
                break;
            case true:
                this.f23579c.put(b.r, new com.igexin.push.core.a.c.k());
                break;
            case true:
                this.f23579c.put(b.s, new com.igexin.push.core.a.c.a());
                break;
            case true:
                this.f23579c.put(b.u, new com.igexin.push.core.a.c.d());
                break;
            case true:
                this.f23579c.put(b.v, new com.igexin.push.core.a.c.c());
                break;
            case true:
                this.f23579c.put(b.t, new com.igexin.push.core.a.c.b());
                break;
        }
        return this.f23579c.get(str);
    }

    private static void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        Message obtain = Message.obtain();
        obtain.what = b.R;
        obtain.obj = bundle;
        d.a.a().a(obtain);
    }

    private static void b(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Condition.SCHEME);
            HashMap hashMap = new HashMap();
            if (jSONObject2.has("wifi")) {
                hashMap.put("wifi", jSONObject2.getString("wifi"));
            }
            if (jSONObject2.has("screenOn")) {
                hashMap.put("screenOn", jSONObject2.getString("screenOn"));
            }
            if (jSONObject2.has("ssid")) {
                hashMap.put("ssid", jSONObject2.getString("ssid"));
                if (jSONObject2.has("bssid")) {
                    hashMap.put("bssid", jSONObject2.getString("bssid"));
                }
            }
            if (jSONObject2.has("duration")) {
                String string = jSONObject2.getString("duration");
                if (string.contains("-")) {
                    int indexOf = string.indexOf("-");
                    String substring = string.substring(0, indexOf);
                    String substring2 = string.substring(indexOf + 1, string.length());
                    hashMap.put("startTime", substring);
                    hashMap.put("endTime", substring2);
                }
            }
            if (jSONObject2.has("netConnected")) {
                hashMap.put("netConnected", jSONObject2.getString("netConnected"));
            }
            if (jSONObject2.has("expireTime")) {
                String string2 = jSONObject2.getString("expireTime");
                if (!TextUtils.isEmpty(string2) && TextUtils.isDigitsOnly(string2)) {
                    hashMap.put("expireTime", string2);
                }
            }
            pushTaskBean.setConditionMap(hashMap);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    public static boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (e.S <= 0) {
            e.S = currentTimeMillis - 60000;
            return true;
        } else if (currentTimeMillis - e.S > 60000) {
            e.S = currentTimeMillis;
            return true;
        } else {
            return false;
        }
    }

    public static void c() {
        try {
            if (TextUtils.isEmpty(com.igexin.push.config.d.C) || "none".equals(com.igexin.push.config.d.C)) {
                return;
            }
            List<String> asList = Arrays.asList(com.igexin.push.config.d.C.split(","));
            if (asList.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, PushTaskBean>> it = e.ah.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, PushTaskBean> next = it.next();
                String key = next.getKey();
                PushTaskBean value = next.getValue();
                if (!TextUtils.isEmpty(key)) {
                    for (String str : asList) {
                        if (!TextUtils.isEmpty(str) && key.startsWith(str)) {
                            arrayList.add(value.getTaskId());
                            it.remove();
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            String[] strArr = new String[arrayList.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    d.a.a().i.a("message", new String[]{"taskid"}, strArr);
                    return;
                } else {
                    strArr[i2] = (String) arrayList.get(i2);
                    i = i2 + 1;
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void c(String str, String str2) {
        com.igexin.c.a.c.a.a("PushMessageExecutor do processActionExecute", new Object[0]);
        if (str2 == null || str == null) {
            return;
        }
        try {
            if (a(str, str2) == PushMessageInterface.ActionPrepareState.success) {
                a(str, str2, "1");
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x01df, code lost:
        if (r9 == null) goto L117;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean f() {
        /*
            Method dump skipped, instructions count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.f():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x01dd, code lost:
        if (r9 == null) goto L106;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean g() {
        /*
            Method dump skipped, instructions count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.g():boolean");
    }

    private void h() {
        try {
            List<ScanResult> k = com.igexin.push.f.n.k();
            this.e.clear();
            if (k == null || k.isEmpty()) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= k.size()) {
                    return;
                }
                this.e.put(k.get(i2).BSSID, k.get(i2).SSID);
                String str = k.get(i2).BSSID;
                String str2 = k.get(i2).SSID;
                i = i2 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final PushMessageInterface.ActionPrepareState a(String str, String str2) {
        PushMessageInterface.ActionPrepareState actionPrepareState = PushMessageInterface.ActionPrepareState.success;
        com.igexin.push.core.a.b.d();
        PushTaskBean pushTaskBean = e.ah.get(com.igexin.push.core.a.b.a(str, str2));
        if (pushTaskBean == null) {
            return PushMessageInterface.ActionPrepareState.stop;
        }
        int i = 0;
        PushMessageInterface.ActionPrepareState actionPrepareState2 = actionPrepareState;
        for (BaseActionBean baseActionBean : pushTaskBean.getActionChains()) {
            PushMessageInterface.ActionPrepareState actionPrepareState3 = PushMessageInterface.ActionPrepareState.stop;
            if (baseActionBean == null) {
                return actionPrepareState3;
            }
            PushMessageInterface a2 = a(baseActionBean.getType());
            if (a2 != null) {
                actionPrepareState3 = a2.prepareExecuteAction(pushTaskBean, baseActionBean);
            } else {
                baseActionBean.getType();
            }
            PushMessageInterface.ActionPrepareState actionPrepareState4 = actionPrepareState2;
            if (actionPrepareState2 == PushMessageInterface.ActionPrepareState.success) {
                actionPrepareState4 = actionPrepareState3;
            }
            actionPrepareState2 = actionPrepareState4;
            if (actionPrepareState3 == PushMessageInterface.ActionPrepareState.wait) {
                i++;
                actionPrepareState2 = actionPrepareState4;
            }
        }
        PushMessageInterface.ActionPrepareState actionPrepareState5 = actionPrepareState2;
        if (i != 0) {
            actionPrepareState5 = actionPrepareState2;
            if (!e.a(str, Integer.valueOf(i))) {
                actionPrepareState5 = PushMessageInterface.ActionPrepareState.success;
            }
        }
        return actionPrepareState5;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.content.Intent r7) {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = "taskid"
            java.lang.String r0 = r0.getStringExtra(r1)
            r12 = r0
            r0 = r7
            java.lang.String r1 = "messageid"
            java.lang.String r0 = r0.getStringExtra(r1)
            r13 = r0
            r0 = r7
            java.lang.String r1 = "actionid"
            java.lang.String r0 = r0.getStringExtra(r1)
            r14 = r0
            r0 = r7
            java.lang.String r1 = "accesstoken"
            java.lang.String r0 = r0.getStringExtra(r1)
            r15 = r0
            r0 = r7
            java.lang.String r1 = "title"
            boolean r0 = r0.hasExtra(r1)
            r9 = r0
            java.lang.String r0 = ""
            r11 = r0
            r0 = r9
            if (r0 == 0) goto L3f
            r0 = r7
            java.lang.String r1 = "title"
            java.lang.String r0 = r0.getStringExtra(r1)
            r10 = r0
            goto L44
        L3f:
            java.lang.String r0 = ""
            r10 = r0
        L44:
            r0 = r7
            java.lang.String r1 = "content"
            boolean r0 = r0.hasExtra(r1)
            if (r0 == 0) goto L57
            r0 = r7
            java.lang.String r1 = "content"
            java.lang.String r0 = r0.getStringExtra(r1)
            r11 = r0
        L57:
            r0 = r7
            java.lang.String r1 = "notifID"
            r2 = 0
            int r0 = r0.getIntExtra(r1, r2)
            r8 = r0
            android.content.Context r0 = com.igexin.push.core.e.l
            java.lang.String r1 = "notification"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L78
        L70:
            r0 = r7
            r1 = r8
            r0.cancel(r1)
            goto L99
        L78:
            java.util.Map<java.lang.String, java.lang.Integer> r0 = com.igexin.push.core.e.ai
            r1 = r12
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L99
            java.util.Map<java.lang.String, java.lang.Integer> r0 = com.igexin.push.core.e.ai
            r1 = r12
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r8 = r0
            goto L70
        L99:
            java.util.Map<java.lang.String, java.lang.Integer> r0 = com.igexin.push.core.e.ai
            r1 = r12
            java.lang.Object r0 = r0.remove(r1)
            r0 = r15
            java.lang.String r1 = com.igexin.push.core.e.an
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc8
            com.igexin.push.core.l r0 = com.igexin.push.core.l.a()
            r1 = r12
            r2 = r13
            r3 = r10
            r4 = r11
            r0.c(r1, r2, r3, r4)
            r0 = r6
            r1 = r12
            r2 = r13
            r3 = r14
            boolean r0 = r0.b(r1, r2, r3)
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.a(android.content.Intent):void");
    }

    public final boolean a(String str, String str2, String str3) {
        if (Thread.currentThread().getId() == d.a.a().b()) {
            b(str, str2, str3);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", str3);
        Message obtain = Message.obtain();
        obtain.what = b.O;
        obtain.obj = bundle;
        return d.a.a().a(obtain);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final boolean a(Map<String, String> map, String str, PushTaskBean pushTaskBean) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final boolean a(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        com.igexin.c.a.c.a.a("PushMessageExecutor------parse pushmessage actionchain json start-------", new Object[0]);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i4);
                        String string = jSONObject2.getString("type");
                        com.igexin.c.a.c.a.a("PushMessageExecutor|start parse type = ".concat(String.valueOf(string)), new Object[0]);
                        PushMessageInterface a2 = a(string);
                        if (a2 != null) {
                            arrayList.add(a2.parseAction(jSONObject2));
                        }
                        i3 = i4 + 1;
                    }
                } else {
                    String string2 = ((JSONObject) jSONArray.get(i2)).getString("type");
                    if (!this.f23578a.containsKey(string2) && !d.contains(string2)) {
                        com.igexin.c.a.c.a.a("PushMessageExecutor|" + string2 + " not support~", new Object[0]);
                        return false;
                    }
                    i = i2 + 1;
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        pushTaskBean.setActionChains(arrayList);
        com.igexin.c.a.c.a.b(b, "------parse pushmessage actionchain json-------");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x047f A[LOOP:0: B:45:0x0255->B:117:0x047f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02b9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(org.json.JSONObject r7, byte[] r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.a(org.json.JSONObject, byte[], boolean):boolean");
    }

    /* JADX WARN: Finally extract failed */
    public final boolean b(String str, String str2, final String str3) {
        PushMessageInterface a2;
        PushTaskBean pushTaskBean;
        Cursor a3;
        com.igexin.push.core.a.b.d();
        String a4 = com.igexin.push.core.a.b.a(str, str2);
        PushTaskBean pushTaskBean2 = e.ah.get(a4);
        PushTaskBean pushTaskBean3 = pushTaskBean2;
        if (pushTaskBean2 == null) {
            Cursor cursor = null;
            PushTaskBean pushTaskBean4 = pushTaskBean2;
            try {
                a3 = d.a.a().i.a("message", new String[]{"taskid", "messageid"}, new String[]{str, str2}, null, null);
            } catch (Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                    pushTaskBean3 = pushTaskBean4;
                    if (cursor != null) {
                        pushTaskBean = pushTaskBean4;
                    }
                } catch (Throwable th2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th2;
                }
            }
            if (a3 != null) {
                pushTaskBean = pushTaskBean2;
                if (a3.getCount() > 0) {
                    do {
                        pushTaskBean4 = pushTaskBean;
                        cursor = a3;
                        if (a3.moveToNext()) {
                            PushTaskBean pushTaskBean5 = pushTaskBean;
                            byte[] blob = a3.getBlob(a3.getColumnIndexOrThrow("info"));
                            PushTaskBean pushTaskBean6 = pushTaskBean;
                            byte[] blob2 = a3.getBlob(a3.getColumnIndexOrThrow("msgextra"));
                            PushTaskBean pushTaskBean7 = pushTaskBean;
                            JSONObject jSONObject = new JSONObject(new String(com.igexin.c.b.a.c(blob)));
                            PushTaskBean pushTaskBean8 = pushTaskBean;
                            a().a(jSONObject, blob2, false);
                            PushTaskBean pushTaskBean9 = pushTaskBean;
                            Map<String, PushTaskBean> map = e.ah;
                            PushTaskBean pushTaskBean10 = pushTaskBean;
                            StringBuilder sb = new StringBuilder();
                            PushTaskBean pushTaskBean11 = pushTaskBean;
                            sb.append(str);
                            PushTaskBean pushTaskBean12 = pushTaskBean;
                            sb.append(":");
                            PushTaskBean pushTaskBean13 = pushTaskBean;
                            sb.append(str2);
                            PushTaskBean pushTaskBean14 = pushTaskBean;
                            pushTaskBean = map.get(sb.toString());
                        } else {
                            pushTaskBean3 = pushTaskBean;
                            if (a3 != null) {
                                cursor = a3;
                                cursor.close();
                                pushTaskBean3 = pushTaskBean;
                            }
                        }
                    } while (pushTaskBean != null);
                    if (a3 != null) {
                        a3.close();
                        return false;
                    }
                    return false;
                }
            }
            if (a3 != null) {
                a3.close();
                return false;
            }
            return false;
        }
        int executeTimes = pushTaskBean3.getExecuteTimes();
        if (executeTimes >= 50) {
            try {
                e.ah.remove(a4);
                return true;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new Object[0]);
                return true;
            }
        }
        pushTaskBean3.setExecuteTimes(executeTimes + 1);
        final PushTaskBean pushTaskBean15 = pushTaskBean3;
        FeedbackImpl.getInstance().asyncFeedback(new Runnable() { // from class: com.igexin.push.core.n.2
            @Override // java.lang.Runnable
            public final void run() {
                FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean15, str3);
            }
        });
        try {
            BaseActionBean baseAction = pushTaskBean3.getBaseAction(str3);
            if (baseAction == null || (a2 = a(baseAction.getType())) == null) {
                return false;
            }
            return a2.executeAction(pushTaskBean3, baseAction);
        } catch (Throwable th3) {
            com.igexin.c.a.c.a.a(th3);
            return false;
        }
    }

    public final void d() {
        try {
            if (f()) {
                return;
            }
            for (Map.Entry<String, PushTaskBean> entry : e.ah.entrySet()) {
                try {
                    entry.getKey();
                    PushTaskBean value = entry.getValue();
                    if (value != null && value.getStatus() == b.ac) {
                        String taskId = value.getTaskId();
                        Map<String, String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (a(conditionMap, taskId, value)) {
                            b(taskId, value.getMessageId());
                            com.igexin.push.core.e.c.a();
                            com.igexin.push.core.e.c.a(b.ad, taskId);
                            value.setStatus(b.ad);
                        }
                    }
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new Object[0]);
                }
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e2.toString(), new Object[0]);
        }
    }

    public final void e() {
        com.igexin.c.a.c.a.a("PushMessageExecutor|--------checkConditionStatus the pushMessageMap from db because log gkt...", new Object[0]);
        try {
            if (g()) {
                return;
            }
            for (Map.Entry<String, PushTaskBean> entry : e.ah.entrySet()) {
                try {
                    entry.getKey();
                    PushTaskBean value = entry.getValue();
                    if (value != null && value.getStatus() == b.ac) {
                        String taskId = value.getTaskId();
                        Map<String, String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (a(conditionMap, taskId, value)) {
                            b(taskId, value.getMessageId());
                            com.igexin.push.core.e.c.a();
                            com.igexin.push.core.e.c.a(b.ad, taskId);
                            value.setStatus(b.ad);
                        }
                    }
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new Object[0]);
                }
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e2.toString(), new Object[0]);
        }
    }
}
