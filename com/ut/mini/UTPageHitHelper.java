package com.ut.mini;

import android.app.Activity;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTPageHitHelper.class */
public class UTPageHitHelper {

    /* renamed from: a  reason: collision with root package name */
    private static UTPageHitHelper f41017a = new UTPageHitHelper();
    private boolean K = false;
    private Map<String, String> w = new HashMap();
    private Map<String, UTPageEventObject> x = new HashMap();
    private String ag = null;
    private Map<String, String> y = new HashMap();
    private String ah = null;

    /* renamed from: a  reason: collision with other field name */
    private Queue<UTPageEventObject> f76a = new LinkedList();
    private Map<Object, String> z = new HashMap();

    /* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTPageHitHelper$UTPageEventObject.class */
    public static class UTPageEventObject {
        private Map<String, String> w = new HashMap();
        private long A = 0;

        /* renamed from: a  reason: collision with root package name */
        private Uri f41018a = null;
        private String ai = null;
        private String aj = null;

        /* renamed from: a  reason: collision with other field name */
        private UTPageStatus f77a = null;
        private boolean L = false;
        private boolean M = false;
        private boolean N = false;
        private String ak = null;

        public String getCacheKey() {
            return this.ak;
        }

        public String getPageName() {
            return this.ai;
        }

        public Map<String, String> getPageProperties() {
            return this.w;
        }

        public UTPageStatus getPageStatus() {
            return this.f77a;
        }

        public long getPageStayTimstamp() {
            return this.A;
        }

        public Uri getPageUrl() {
            return this.f41018a;
        }

        public String getRefPage() {
            return this.aj;
        }

        public boolean isH5Called() {
            return this.N;
        }

        public boolean isPageAppearCalled() {
            return this.L;
        }

        public boolean isSkipPage() {
            return this.M;
        }

        public void resetPropertiesWithoutSkipFlagAndH5Flag() {
            this.w = new HashMap();
            this.A = 0L;
            this.f41018a = null;
            this.ai = null;
            this.aj = null;
            UTPageStatus uTPageStatus = this.f77a;
            if (uTPageStatus == null || uTPageStatus != UTPageStatus.UT_H5_IN_WebView) {
                this.f77a = null;
            }
            this.L = false;
            this.N = false;
        }

        public void setCacheKey(String str) {
            this.ak = str;
        }

        public void setH5Called() {
            this.N = true;
        }

        public void setPageAppearCalled() {
            this.L = true;
        }

        public void setPageName(String str) {
            this.ai = str;
        }

        public void setPageProperties(Map<String, String> map) {
            this.w = map;
        }

        public void setPageStatus(UTPageStatus uTPageStatus) {
            this.f77a = uTPageStatus;
        }

        public void setPageStayTimstamp(long j) {
            this.A = j;
        }

        public void setPageUrl(Uri uri) {
            this.f41018a = uri;
        }

        public void setRefPage(String str) {
            this.aj = str;
        }

        public void setToSkipPage() {
            this.M = true;
        }
    }

    private UTPageEventObject a(Object obj) {
        synchronized (this) {
            String m11327a = m11327a(obj);
            if (this.x.containsKey(m11327a)) {
                return this.x.get(m11327a);
            }
            UTPageEventObject uTPageEventObject = new UTPageEventObject();
            this.x.put(m11327a, uTPageEventObject);
            uTPageEventObject.setCacheKey(m11327a);
            return uTPageEventObject;
        }
    }

    private static String a(Uri uri) {
        List<String> queryParameters;
        if (uri == null || (queryParameters = uri.getQueryParameters("ttid")) == null) {
            return null;
        }
        for (String str : queryParameters) {
            if (!str.contains("@") && !str.contains("%40")) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m11327a(Object obj) {
        String simpleName = obj instanceof String ? (String) obj : obj.getClass().getSimpleName();
        int hashCode = obj.hashCode();
        return simpleName + hashCode;
    }

    private void a(String str, UTPageEventObject uTPageEventObject) {
        synchronized (this) {
            this.x.put(str, uTPageEventObject);
        }
    }

    private static String b(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        String str = simpleName;
        if (simpleName != null) {
            str = simpleName;
            if (simpleName.toLowerCase().endsWith("activity")) {
                str = simpleName.substring(0, simpleName.length() - 8);
            }
        }
        return str;
    }

    private void b(UTPageEventObject uTPageEventObject) {
        synchronized (this) {
            if (this.x.containsKey(uTPageEventObject.getCacheKey())) {
                this.x.remove(uTPageEventObject.getCacheKey());
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private void m11328b(Object obj) {
        synchronized (this) {
            String m11327a = m11327a(obj);
            if (this.x.containsKey(m11327a)) {
                this.x.remove(m11327a);
            }
        }
    }

    public static UTPageHitHelper getInstance() {
        return f41017a;
    }

    void a(UTPageEventObject uTPageEventObject) {
        synchronized (this) {
            uTPageEventObject.resetPropertiesWithoutSkipFlagAndH5Flag();
            if (!this.f76a.contains(uTPageEventObject)) {
                this.f76a.add(uTPageEventObject);
            }
            if (this.f76a.size() > 200) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 100) {
                        break;
                    }
                    UTPageEventObject poll = this.f76a.poll();
                    if (poll != null && this.x.containsKey(poll.getCacheKey())) {
                        this.x.remove(poll.getCacheKey());
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m11329a(Object obj) {
        synchronized (this) {
            if (obj != null) {
                UTPageEventObject a2 = a(obj);
                if (a2.getPageStatus() != null) {
                    a2.setH5Called();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj, String str, boolean z) {
        synchronized (this) {
            if (obj != null) {
                String m11327a = m11327a(obj);
                if (m11327a != null && m11327a.equals(this.ag)) {
                    return;
                }
                if (this.ag != null) {
                    i.a("lost 2001", "Last page requires leave(" + this.ag + ").");
                }
                UTPageEventObject a2 = a(obj);
                if (!z && a2.isSkipPage()) {
                    i.a("skip page[pageAppear]", "page name:" + obj.getClass().getSimpleName());
                    return;
                }
                String h5Url = UTMIVariables.getInstance().getH5Url();
                if (h5Url != null) {
                    this.w.put("spm", Uri.parse(h5Url).getQueryParameter("spm"));
                    UTMIVariables.getInstance().setH5Url(null);
                }
                String b = b(obj);
                if (TextUtils.isEmpty(str)) {
                    str = b;
                }
                if (!TextUtils.isEmpty(a2.getPageName())) {
                    str = a2.getPageName();
                }
                this.ah = str;
                a2.setPageName(str);
                a2.setPageStayTimstamp(SystemClock.elapsedRealtime());
                a2.setRefPage(UTMIVariables.getInstance().getRefPage());
                a2.setPageAppearCalled();
                if (this.y != null) {
                    Map<String, String> pageProperties = a2.getPageProperties();
                    if (pageProperties == null) {
                        a2.setPageProperties(this.y);
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.putAll(pageProperties);
                        hashMap.putAll(this.y);
                        a2.setPageProperties(hashMap);
                    }
                }
                this.y = null;
                this.ag = m11327a(obj);
                b(a2);
                a(m11327a(obj), a2);
            } else {
                i.a("pageAppear", "The page object should not be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public boolean m11330a(Object obj) {
        synchronized (this) {
            if (obj != null) {
                UTPageEventObject a2 = a(obj);
                if (a2.getPageStatus() != null) {
                    if (a2.getPageStatus() == UTPageStatus.UT_H5_IN_WebView) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> c() {
        synchronized (this) {
            if (this.y == null || this.y.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.y);
            this.y.clear();
            return hashMap;
        }
    }

    public String getCurrentPageName() {
        return this.ah;
    }

    @Deprecated
    public void pageAppear(Object obj) {
        synchronized (this) {
            a(obj, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pageAppear(Object obj, String str) {
        synchronized (this) {
            a(obj, str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pageAppearByAuto(Activity activity) {
        if (this.K) {
            return;
        }
        pageAppear(activity);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0280 A[Catch: all -> 0x031e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:6:0x0006, B:11:0x0014, B:13:0x0023, B:15:0x002b, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x005b, B:26:0x0062, B:28:0x0073, B:31:0x0088, B:34:0x0093, B:37:0x00a2, B:39:0x00ad, B:41:0x00b3, B:44:0x00cb, B:46:0x00d2, B:48:0x00e3, B:52:0x00ed, B:56:0x0103, B:58:0x010d, B:60:0x0120, B:62:0x0133, B:66:0x0147, B:108:0x024b, B:109:0x024e, B:111:0x0280, B:115:0x02c9, B:117:0x02db, B:125:0x0306, B:118:0x02e4, B:120:0x02ec, B:122:0x02f7, B:123:0x0300, B:112:0x028d, B:113:0x0299, B:126:0x0312, B:68:0x0153, B:72:0x017d, B:74:0x0191, B:77:0x01a3, B:79:0x01ac, B:83:0x01b8, B:87:0x01c7, B:93:0x01df, B:95:0x01fa, B:97:0x020a, B:99:0x0219, B:101:0x0226, B:103:0x0230, B:105:0x0238), top: B:138:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028d A[Catch: all -> 0x031e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:6:0x0006, B:11:0x0014, B:13:0x0023, B:15:0x002b, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x005b, B:26:0x0062, B:28:0x0073, B:31:0x0088, B:34:0x0093, B:37:0x00a2, B:39:0x00ad, B:41:0x00b3, B:44:0x00cb, B:46:0x00d2, B:48:0x00e3, B:52:0x00ed, B:56:0x0103, B:58:0x010d, B:60:0x0120, B:62:0x0133, B:66:0x0147, B:108:0x024b, B:109:0x024e, B:111:0x0280, B:115:0x02c9, B:117:0x02db, B:125:0x0306, B:118:0x02e4, B:120:0x02ec, B:122:0x02f7, B:123:0x0300, B:112:0x028d, B:113:0x0299, B:126:0x0312, B:68:0x0153, B:72:0x017d, B:74:0x0191, B:77:0x01a3, B:79:0x01ac, B:83:0x01b8, B:87:0x01c7, B:93:0x01df, B:95:0x01fa, B:97:0x020a, B:99:0x0219, B:101:0x0226, B:103:0x0230, B:105:0x0238), top: B:138:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2 A[Catch: all -> 0x031e, TRY_ENTER, TryCatch #2 {, blocks: (B:6:0x0006, B:11:0x0014, B:13:0x0023, B:15:0x002b, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x005b, B:26:0x0062, B:28:0x0073, B:31:0x0088, B:34:0x0093, B:37:0x00a2, B:39:0x00ad, B:41:0x00b3, B:44:0x00cb, B:46:0x00d2, B:48:0x00e3, B:52:0x00ed, B:56:0x0103, B:58:0x010d, B:60:0x0120, B:62:0x0133, B:66:0x0147, B:108:0x024b, B:109:0x024e, B:111:0x0280, B:115:0x02c9, B:117:0x02db, B:125:0x0306, B:118:0x02e4, B:120:0x02ec, B:122:0x02f7, B:123:0x0300, B:112:0x028d, B:113:0x0299, B:126:0x0312, B:68:0x0153, B:72:0x017d, B:74:0x0191, B:77:0x01a3, B:79:0x01ac, B:83:0x01b8, B:87:0x01c7, B:93:0x01df, B:95:0x01fa, B:97:0x020a, B:99:0x0219, B:101:0x0226, B:103:0x0230, B:105:0x0238), top: B:138:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b3 A[Catch: all -> 0x031e, TryCatch #2 {, blocks: (B:6:0x0006, B:11:0x0014, B:13:0x0023, B:15:0x002b, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x005b, B:26:0x0062, B:28:0x0073, B:31:0x0088, B:34:0x0093, B:37:0x00a2, B:39:0x00ad, B:41:0x00b3, B:44:0x00cb, B:46:0x00d2, B:48:0x00e3, B:52:0x00ed, B:56:0x0103, B:58:0x010d, B:60:0x0120, B:62:0x0133, B:66:0x0147, B:108:0x024b, B:109:0x024e, B:111:0x0280, B:115:0x02c9, B:117:0x02db, B:125:0x0306, B:118:0x02e4, B:120:0x02ec, B:122:0x02f7, B:123:0x0300, B:112:0x028d, B:113:0x0299, B:126:0x0312, B:68:0x0153, B:72:0x017d, B:74:0x0191, B:77:0x01a3, B:79:0x01ac, B:83:0x01b8, B:87:0x01c7, B:93:0x01df, B:95:0x01fa, B:97:0x020a, B:99:0x0219, B:101:0x0226, B:103:0x0230, B:105:0x0238), top: B:138:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2 A[Catch: all -> 0x031e, TryCatch #2 {, blocks: (B:6:0x0006, B:11:0x0014, B:13:0x0023, B:15:0x002b, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x005b, B:26:0x0062, B:28:0x0073, B:31:0x0088, B:34:0x0093, B:37:0x00a2, B:39:0x00ad, B:41:0x00b3, B:44:0x00cb, B:46:0x00d2, B:48:0x00e3, B:52:0x00ed, B:56:0x0103, B:58:0x010d, B:60:0x0120, B:62:0x0133, B:66:0x0147, B:108:0x024b, B:109:0x024e, B:111:0x0280, B:115:0x02c9, B:117:0x02db, B:125:0x0306, B:118:0x02e4, B:120:0x02ec, B:122:0x02f7, B:123:0x0300, B:112:0x028d, B:113:0x0299, B:126:0x0312, B:68:0x0153, B:72:0x017d, B:74:0x0191, B:77:0x01a3, B:79:0x01ac, B:83:0x01b8, B:87:0x01c7, B:93:0x01df, B:95:0x01fa, B:97:0x020a, B:99:0x0219, B:101:0x0226, B:103:0x0230, B:105:0x0238), top: B:138:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0153 A[Catch: all -> 0x0244, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:6:0x0006, B:11:0x0014, B:13:0x0023, B:15:0x002b, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x005b, B:26:0x0062, B:28:0x0073, B:31:0x0088, B:34:0x0093, B:37:0x00a2, B:39:0x00ad, B:41:0x00b3, B:44:0x00cb, B:46:0x00d2, B:48:0x00e3, B:52:0x00ed, B:56:0x0103, B:58:0x010d, B:60:0x0120, B:62:0x0133, B:66:0x0147, B:108:0x024b, B:109:0x024e, B:111:0x0280, B:115:0x02c9, B:117:0x02db, B:125:0x0306, B:118:0x02e4, B:120:0x02ec, B:122:0x02f7, B:123:0x0300, B:112:0x028d, B:113:0x0299, B:126:0x0312, B:68:0x0153, B:72:0x017d, B:74:0x0191, B:77:0x01a3, B:79:0x01ac, B:83:0x01b8, B:87:0x01c7, B:93:0x01df, B:95:0x01fa, B:97:0x020a, B:99:0x0219, B:101:0x0226, B:103:0x0230, B:105:0x0238), top: B:138:0x0003 }] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void pageDisAppear(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTPageHitHelper.pageDisAppear(java.lang.Object):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pageDisAppearByAuto(Activity activity) {
        if (this.K) {
            return;
        }
        pageDisAppear(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void skipPage(Object obj) {
        synchronized (this) {
            if (obj == null) {
                return;
            }
            a(obj).setToSkipPage();
        }
    }

    @Deprecated
    public void turnOffAutoPageTrack() {
        synchronized (this) {
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateNextPageProperties(Map<String, String> map) {
        synchronized (this) {
            if (map != null) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(map);
                this.y = hashMap;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePageName(Object obj, String str) {
        synchronized (this) {
            if (obj != null) {
                if (!TextUtils.isEmpty(str)) {
                    a(obj).setPageName(str);
                    this.ah = str;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePageProperties(Object obj, Map<String, String> map) {
        synchronized (this) {
            if (obj != null && map != null) {
                if (map.size() != 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(map);
                    UTPageEventObject a2 = a(obj);
                    Map<String, String> pageProperties = a2.getPageProperties();
                    if (pageProperties == null) {
                        a2.setPageProperties(hashMap);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.putAll(pageProperties);
                        hashMap2.putAll(hashMap);
                        a2.setPageProperties(hashMap2);
                    }
                    return;
                }
            }
            i.a("updatePageProperties", "failed to update project, parameters should not be null and the map should not be empty");
        }
    }

    @Deprecated
    public void updatePageProperties(Map<String, String> map) {
        synchronized (this) {
            if (map != null) {
                this.w.putAll(map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        synchronized (this) {
            if (obj == null || uTPageStatus == null) {
                return;
            }
            a(obj).setPageStatus(uTPageStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePageUrl(Object obj, Uri uri) {
        synchronized (this) {
            if (obj == null || uri == null) {
                return;
            }
            Log.i("url", "url" + uri.toString());
            a(obj).setPageUrl(uri);
        }
    }
}
