package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.c;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/ApkInfo.class */
public class ApkInfo implements Serializable {
    private static final long serialVersionUID = 5884421861234973073L;
    private String actName;
    private String afDlBtnText;
    private long allAreaPopDelay;
    private String appDesc;
    private String appName;
    private List<Integer> btnClickActionList;
    private String channelInfo;
    private int checkSha256Flag;
    private String contiBtn;
    private String dlBtnText;
    private long fileSize;
    @c(Code = "hasper")
    private Integer hasPermission;
    @c(Code = "appIcon")
    @com.huawei.openalliance.ad.annotations.a
    private String iconUrl;
    private InstallConfig installConfig;
    private String installPermiText;
    private String installPureModeText;
    private String intent;
    private String intentPackage;
    private String nextInstallWays;
    private int noAlertTime;
    private String packageName;
    private List<Permission> permissions;
    private int popUpAfterInstallNew;
    private String popUpAfterInstallText;
    private int popUpStyle;
    private String priorInstallWay;
    private String pureModeText;
    private String reservedPkgName;
    @com.huawei.openalliance.ad.annotations.a
    private String secondUrl;
    private String sha256;
    private int trafficReminder;
    @com.huawei.openalliance.ad.annotations.a
    private String url;
    private String versionCode;
    private String permPromptForCard = "1";
    private String permPromptForLanding = "0";
    private int channelInfoSaveLimit = -2;
    private int popNotify = 1;
    private int appType = 1;

    public String A() {
        return this.contiBtn;
    }

    public String B() {
        return this.sha256;
    }

    public void B(int i) {
        this.popNotify = i;
    }

    public void B(String str) {
        this.secondUrl = str;
    }

    public String C() {
        return this.secondUrl;
    }

    public void C(int i) {
        this.checkSha256Flag = i;
    }

    public void C(String str) {
        this.appName = str;
    }

    public String Code() {
        return this.packageName;
    }

    public void Code(int i) {
        this.popUpAfterInstallNew = i;
    }

    public void Code(long j) {
        this.fileSize = j;
    }

    public void Code(InstallConfig installConfig) {
        this.installConfig = installConfig;
    }

    public void Code(Integer num) {
        this.hasPermission = num;
    }

    public void Code(String str) {
        this.packageName = str;
    }

    public void Code(List<Permission> list) {
        this.permissions = list;
    }

    public String D() {
        return this.priorInstallWay;
    }

    public void D(String str) {
        this.permPromptForLanding = str;
    }

    public String E() {
        return this.reservedPkgName;
    }

    public List<Permission> F() {
        return this.permissions;
    }

    public void F(int i) {
        this.popUpStyle = i;
    }

    public void F(String str) {
        this.permPromptForCard = str;
    }

    public String I() {
        return this.url;
    }

    public void I(int i) {
        this.noAlertTime = i;
    }

    public void I(String str) {
        this.url = str;
    }

    public InstallConfig L() {
        return this.installConfig;
    }

    public void L(String str) {
        this.popUpAfterInstallText = str;
    }

    public String S() {
        return this.appName;
    }

    public void S(int i) {
        this.appType = i;
    }

    public void S(String str) {
        this.priorInstallWay = str;
    }

    public String V() {
        return this.versionCode;
    }

    public void V(int i) {
        this.channelInfoSaveLimit = i;
    }

    public void V(long j) {
        this.allAreaPopDelay = j;
    }

    public void V(String str) {
        this.versionCode = str;
    }

    public void V(List<Integer> list) {
        this.btnClickActionList = list;
    }

    public long Z() {
        return this.fileSize;
    }

    public void Z(int i) {
        this.trafficReminder = i;
    }

    public void Z(String str) {
        this.sha256 = str;
    }

    public String a() {
        String str = this.permPromptForCard;
        String str2 = str;
        if (str == null) {
            str2 = "1";
        }
        return str2;
    }

    public void a(String str) {
        this.channelInfo = str;
    }

    public String b() {
        String str = this.permPromptForLanding;
        String str2 = str;
        if (str == null) {
            str2 = "0";
        }
        return str2;
    }

    public void b(String str) {
        this.iconUrl = str;
    }

    public int c() {
        return this.popUpAfterInstallNew;
    }

    public void c(String str) {
        this.appDesc = str;
    }

    public String d() {
        return this.popUpAfterInstallText;
    }

    public void d(String str) {
        this.intent = str;
    }

    public String e() {
        return this.channelInfo;
    }

    public void e(String str) {
        this.intentPackage = str;
    }

    public String f() {
        return this.iconUrl;
    }

    public void f(String str) {
        this.dlBtnText = str;
    }

    public int g() {
        return this.channelInfoSaveLimit;
    }

    public void g(String str) {
        this.afDlBtnText = str;
    }

    public String h() {
        return this.appDesc;
    }

    public void h(String str) {
        this.nextInstallWays = str;
    }

    public int i() {
        return this.noAlertTime;
    }

    public void i(String str) {
        this.actName = str;
    }

    public int j() {
        return this.trafficReminder;
    }

    public void j(String str) {
        this.installPermiText = str;
    }

    public String k() {
        return this.intent;
    }

    public void k(String str) {
        this.pureModeText = str;
    }

    public String l() {
        return this.intentPackage;
    }

    public void l(String str) {
        this.installPureModeText = str;
    }

    public String m() {
        return this.dlBtnText;
    }

    public void m(String str) {
        this.contiBtn = str;
    }

    public String n() {
        return this.afDlBtnText;
    }

    public void n(String str) {
        this.reservedPkgName = str;
    }

    public int o() {
        return this.popNotify;
    }

    public Integer p() {
        return this.hasPermission;
    }

    public String q() {
        return this.nextInstallWays;
    }

    public int r() {
        return this.checkSha256Flag;
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

    public int w() {
        return this.popUpStyle;
    }

    public String x() {
        return this.installPermiText;
    }

    public String y() {
        return this.pureModeText;
    }

    public String z() {
        return this.installPureModeText;
    }
}
