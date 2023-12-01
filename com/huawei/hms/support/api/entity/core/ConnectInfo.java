package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/entity/core/ConnectInfo.class */
public class ConnectInfo implements IMessageEntity {
    @Packed

    /* renamed from: a  reason: collision with root package name */
    private List<String> f9274a;
    @Packed
    private List<Scope> b;
    @Packed

    /* renamed from: c  reason: collision with root package name */
    private String f9275c;
    @Packed
    private String d;

    public ConnectInfo() {
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.f9274a = list;
        this.b = list2;
        this.f9275c = str;
        this.d = str2;
    }

    public List<String> getApiNameList() {
        return this.f9274a;
    }

    public String getFingerprint() {
        return this.f9275c;
    }

    public List<Scope> getScopeList() {
        return this.b;
    }

    public String getSubAppID() {
        return this.d;
    }

    public void setApiNameList(List<String> list) {
        this.f9274a = list;
    }

    public void setFingerprint(String str) {
        this.f9275c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.b = list;
    }

    public void setSubAppID(String str) {
        this.d = str;
    }
}
