package com.sdk.tencent.base.framework.bean;

import com.sdk.tencent.k.a;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/framework/bean/KInfo.class */
public class KInfo {

    /* renamed from: cn  reason: collision with root package name */
    private String f14332cn;
    private String ic;
    private boolean idfd;
    private boolean idfs;
    private String ie;
    private String is;
    private String m;
    private int sid;

    public String getCn() {
        return this.f14332cn;
    }

    public String getIc() {
        return this.ic;
    }

    public String getIe() {
        return this.ie;
    }

    public String getIs() {
        return this.is;
    }

    public String getM() {
        return this.m;
    }

    public int getSid() {
        return this.sid;
    }

    public boolean isIdfd() {
        return this.idfd;
    }

    public boolean isIdfs() {
        return this.idfs;
    }

    public void setCn(String str) {
        this.f14332cn = str;
    }

    public void setIc(String str) {
        this.ic = str;
    }

    public void setIdfd(boolean z) {
        this.idfd = z;
    }

    public void setIdfs(boolean z) {
        this.idfs = z;
    }

    public void setIe(String str) {
        this.ie = str;
    }

    public void setIs(String str) {
        this.is = str;
    }

    public void setM(String str) {
        this.m = str;
    }

    public void setSid(int i) {
        this.sid = i;
    }

    public String toString() {
        return a.a(this);
    }
}
