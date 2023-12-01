package com.ut.mini.base;

import com.ut.mini.sdkevents.UTMI1010_2001Event;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/base/UTMIVariables.class */
public class UTMIVariables {

    /* renamed from: a  reason: collision with root package name */
    private static UTMIVariables f27330a = new UTMIVariables();
    private String am = null;
    private String aj = null;
    private String an = null;

    /* renamed from: a  reason: collision with other field name */
    private UTMI1010_2001Event f31a = null;
    private boolean O = false;

    public static UTMIVariables getInstance() {
        return f27330a;
    }

    public String getH5RefPage() {
        return this.am;
    }

    public String getH5Url() {
        return this.an;
    }

    public String getRefPage() {
        return this.aj;
    }

    public UTMI1010_2001Event getUTMI1010_2001EventInstance() {
        UTMI1010_2001Event uTMI1010_2001Event;
        synchronized (this) {
            uTMI1010_2001Event = this.f31a;
        }
        return uTMI1010_2001Event;
    }

    public boolean isAliyunOSPlatform() {
        boolean z;
        synchronized (this) {
            z = this.O;
        }
        return z;
    }

    public void setH5RefPage(String str) {
        this.am = str;
    }

    public void setH5Url(String str) {
        this.an = str;
    }

    public void setRefPage(String str) {
        this.aj = str;
    }

    public void setToAliyunOSPlatform() {
        synchronized (this) {
            this.O = true;
        }
    }

    public void setUTMI1010_2001EventInstance(UTMI1010_2001Event uTMI1010_2001Event) {
        synchronized (this) {
            this.f31a = uTMI1010_2001Event;
        }
    }
}
