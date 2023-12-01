package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.InstallConfig;
import com.huawei.openalliance.ad.beans.metadata.Permission;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/AppInfo.class */
public class AppInfo implements Serializable {
    private static final String TAG = "AppInfo";
    private static final long serialVersionUID = 30414300;
    private String actName;
    private String afDlBtnText;
    private long allAreaPopDelay;
    private String appDesc;
    private String appName;
    private int appType;
    private List<Integer> btnClickActionList;
    private boolean checkSha256;
    private String contiBtn;
    private String curInstallWay;
    private String dlBtnText;
    private String downloadUrl;
    private long fileSize;
    private Integer hasPermissions;
    private String iconUrl;
    private InstallConfig installConfig;
    private String installPermiText;
    private String installPureModeText;
    private String intent;
    private String intentPackage;
    private String intentUri;
    private String nextInstallWays;
    private String packageName;
    private boolean permPromptForCard;
    private boolean permPromptForLanding;
    private List<PermissionEntity> permissions;
    private int popNotify;
    private String popUpAfterInstallText;
    private int popUpStyle;
    private String priorInstallWay;
    private String pureModeText;
    private String reservedPkgName;
    private String safeDownloadUrl;
    private String sha256;
    private int trafficReminder;
    private String uniqueId;
    private String versionCode;

    /* renamed from: com.huawei.openalliance.ad.inter.data.AppInfo$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/AppInfo$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[com.huawei.openalliance.ad.download.app.k.values().length];
            Code = iArr;
            try {
                iArr[com.huawei.openalliance.ad.download.app.k.INSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public AppInfo() {
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        this.appType = 1;
    }

    public AppInfo(ApkInfo apkInfo) {
        boolean z = true;
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        this.appType = 1;
        if (apkInfo != null) {
            this.appName = au.V(apkInfo.S());
            this.iconUrl = apkInfo.f();
            this.packageName = apkInfo.Code();
            this.versionCode = apkInfo.V();
            this.downloadUrl = apkInfo.I();
            this.fileSize = apkInfo.Z();
            this.sha256 = apkInfo.B();
            this.checkSha256 = apkInfo.r() != 0 ? false : z;
            this.safeDownloadUrl = apkInfo.C();
            this.permPromptForCard = "1".equals(apkInfo.a());
            this.permPromptForLanding = "1".equals(apkInfo.b());
            this.dlBtnText = au.V(apkInfo.m());
            this.afDlBtnText = au.V(apkInfo.n());
            this.popNotify = apkInfo.o();
            this.popUpAfterInstallText = apkInfo.d();
            Code(apkInfo.F());
            this.iconUrl = apkInfo.f();
            this.appDesc = au.V(apkInfo.h());
            this.trafficReminder = apkInfo.j();
            String D = apkInfo.D();
            if (!TextUtils.isEmpty(D)) {
                this.priorInstallWay = D;
            }
            this.installConfig = apkInfo.L();
            this.curInstallWay = this.priorInstallWay;
            this.intent = apkInfo.k();
            this.intentPackage = apkInfo.l();
            this.hasPermissions = apkInfo.p();
            this.nextInstallWays = apkInfo.q();
            this.actName = apkInfo.s();
            this.btnClickActionList = apkInfo.t();
            this.appType = apkInfo.u();
            this.allAreaPopDelay = apkInfo.v();
            this.popUpStyle = apkInfo.w();
            this.installPermiText = apkInfo.x();
            this.pureModeText = apkInfo.y();
            this.installPureModeText = apkInfo.y();
            this.contiBtn = apkInfo.A();
            this.reservedPkgName = apkInfo.E();
        }
    }

    public static long w() {
        return serialVersionUID;
    }

    public String A() {
        return this.installPureModeText;
    }

    public long B() {
        return this.fileSize;
    }

    public void B(String str) {
        this.intentPackage = str;
    }

    public String C() {
        return this.sha256;
    }

    public void C(String str) {
        this.dlBtnText = str;
    }

    public String Code() {
        return this.packageName;
    }

    public String Code(com.huawei.openalliance.ad.download.app.k kVar) {
        int i = AnonymousClass1.Code[kVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return this.dlBtnText;
        }
        return this.afDlBtnText;
    }

    public void Code(int i) {
        this.popNotify = i;
    }

    public void Code(long j) {
        this.allAreaPopDelay = j;
    }

    public void Code(String str) {
        this.intentUri = str;
    }

    public void Code(List<Permission> list) {
        StringBuilder sb;
        String sb2;
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            ArrayMap arrayMap = new ArrayMap();
            for (Permission permission : list) {
                List list2 = (List) arrayMap.get(permission.V());
                ArrayList arrayList = list2;
                if (list2 == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayMap.put(permission.V(), arrayList2);
                    arrayList = arrayList2;
                }
                arrayList.add(new PermissionEntity(au.V(permission.Code()), 1));
            }
            this.permissions = new ArrayList();
            Iterator it = arrayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                this.permissions.add(new PermissionEntity(au.V((String) entry.getKey()), 0));
                this.permissions.addAll((Collection) entry.getValue());
            }
        } catch (RuntimeException e) {
            sb2 = "parsePermission RuntimeException:" + e.getClass().getSimpleName();
            ge.Z(TAG, sb2);
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("parsePermission Exception:");
            sb.append(e.getClass().getSimpleName());
            sb2 = sb.toString();
            ge.Z(TAG, sb2);
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            sb.append("parsePermission Exception:");
            sb.append(e.getClass().getSimpleName());
            sb2 = sb.toString();
            ge.Z(TAG, sb2);
        }
    }

    public String D() {
        return this.intentUri;
    }

    public void D(String str) {
        this.packageName = str;
    }

    public String E() {
        return this.contiBtn;
    }

    public String F() {
        return this.safeDownloadUrl;
    }

    public void F(String str) {
        this.popUpAfterInstallText = str;
    }

    public String G() {
        return this.reservedPkgName;
    }

    public String I() {
        return this.iconUrl;
    }

    public void I(int i) {
        this.popUpStyle = i;
    }

    public void I(String str) {
        this.priorInstallWay = str;
    }

    public String L() {
        String str = this.appName;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public void L(String str) {
        this.nextInstallWays = str;
    }

    public void S(String str) {
        this.afDlBtnText = str;
    }

    public boolean S() {
        return this.checkSha256;
    }

    public String V() {
        return this.versionCode;
    }

    public void V(int i) {
        this.appType = i;
    }

    public void V(String str) {
        this.uniqueId = str;
    }

    public void V(List<Integer> list) {
        this.btnClickActionList = list;
    }

    public String Z() {
        return this.downloadUrl;
    }

    public void Z(String str) {
        this.intent = str;
    }

    public String a() {
        String str = this.appDesc;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public void a(String str) {
        this.curInstallWay = str;
    }

    public List<PermissionEntity> b() {
        return this.permissions;
    }

    public void b(String str) {
        this.actName = str;
    }

    public void c(String str) {
        this.installPermiText = str;
    }

    public boolean c() {
        return this.permPromptForCard;
    }

    public void d(String str) {
        this.pureModeText = str;
    }

    public boolean d() {
        return this.permPromptForLanding;
    }

    public String e() {
        return this.uniqueId;
    }

    public void e(String str) {
        this.installPureModeText = str;
    }

    public int f() {
        return this.trafficReminder;
    }

    public void f(String str) {
        this.contiBtn = str;
    }

    public String g() {
        return TextUtils.isEmpty(this.priorInstallWay) ? "4" : this.priorInstallWay;
    }

    public void g(String str) {
        this.reservedPkgName = str;
    }

    public String h() {
        return this.intent;
    }

    public String i() {
        return this.intentPackage;
    }

    public String j() {
        return this.dlBtnText;
    }

    public String k() {
        return this.afDlBtnText;
    }

    public int l() {
        return this.popNotify;
    }

    public String m() {
        return this.popUpAfterInstallText;
    }

    public boolean n() {
        Integer num = this.hasPermissions;
        return num != null ? num.intValue() == 1 : !aa.Code(this.permissions);
    }

    public boolean o() {
        boolean z = false;
        if (TextUtils.isEmpty(this.packageName)) {
            return false;
        }
        String r = r();
        if (TextUtils.isEmpty(r)) {
            return false;
        }
        if (r.equals("8") || r.equals("6") || r.equals("5")) {
            z = true;
        }
        return z;
    }

    public String p() {
        return this.nextInstallWays;
    }

    public String q() {
        return this.curInstallWay;
    }

    public String r() {
        String q = q();
        String str = q;
        if (TextUtils.isEmpty(q)) {
            str = g();
        }
        return str;
    }

    public String s() {
        return this.actName;
    }

    public List<Integer> t() {
        return this.btnClickActionList;
    }

    public int u() {
        return this.appType;
    }

    public long v() {
        return this.allAreaPopDelay;
    }

    public int x() {
        return this.popUpStyle;
    }

    public String y() {
        return this.installPermiText;
    }

    public String z() {
        return this.pureModeText;
    }
}
