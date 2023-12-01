package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/update/ui/UpdateBean.class */
public class UpdateBean implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f22907a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public String f22908c;
    public int d;
    public String e;
    public String f;
    public ArrayList g;
    public boolean h = true;

    public static <T> T a(T t) {
        return t;
    }

    public String getClientAppId() {
        return (String) a(this.e);
    }

    public String getClientAppName() {
        return (String) a(this.f);
    }

    public String getClientPackageName() {
        return (String) a(this.f22908c);
    }

    public int getClientVersionCode() {
        return ((Integer) a(Integer.valueOf(this.d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) a(Boolean.valueOf(this.f22907a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.e = str;
    }

    public void setClientAppName(String str) {
        this.f = str;
    }

    public void setClientPackageName(String str) {
        this.f22908c = str;
    }

    public void setClientVersionCode(int i) {
        this.d = i;
    }

    public void setHmsOrApkUpgrade(boolean z) {
        this.f22907a = z;
    }

    public void setNeedConfirm(boolean z) {
        this.h = z;
    }

    public void setResolutionInstallHMS(boolean z) {
        this.b = z;
    }

    public void setTypeList(ArrayList arrayList) {
        this.g = arrayList;
    }
}
