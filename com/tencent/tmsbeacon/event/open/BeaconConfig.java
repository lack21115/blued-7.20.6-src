package com.tencent.tmsbeacon.event.open;

import com.tencent.tmsbeacon.a.b.a;
import com.tencent.tmsbeacon.base.net.adapter.AbstractNetAdapter;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/open/BeaconConfig.class */
public class BeaconConfig {

    /* renamed from: a  reason: collision with root package name */
    private final int f39581a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39582c;
    private final boolean d;
    private final long e;
    private final long f;
    private final boolean g;
    private final AbstractNetAdapter h;
    private final String i;
    private final String j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/open/BeaconConfig$Builder.class */
    public static final class Builder {
        private ScheduledExecutorService e;
        private AbstractNetAdapter g;
        private long h;
        private long i;
        private String j;
        private String k;

        /* renamed from: a  reason: collision with root package name */
        private int f39583a = 10000;
        private boolean b = true;

        /* renamed from: c  reason: collision with root package name */
        private boolean f39584c = true;
        private boolean d = true;
        private boolean f = true;
        private boolean l = false;
        private boolean m = true;
        private boolean n = true;
        private String o = "";
        private String p = "";
        private String q = "";
        private String r = "";
        private String s = "";
        private String t = "";
        private String u = "";
        private String v = "";
        private String w = "";
        private String x = "";

        public Builder auditEnable(boolean z) {
            this.f39584c = z;
            return this;
        }

        public Builder bidEnable(boolean z) {
            this.d = z;
            return this;
        }

        public BeaconConfig build() {
            ScheduledExecutorService scheduledExecutorService = this.e;
            if (scheduledExecutorService != null) {
                a.a(scheduledExecutorService);
            }
            return new BeaconConfig(this.f39583a, this.b, this.f39584c, this.d, this.h, this.i, this.f, this.g, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x);
        }

        @Deprecated
        public Builder collectAndroidIdEnable(boolean z) {
            return this;
        }

        @Deprecated
        public Builder collectIMEIEnable(boolean z) {
            return this;
        }

        @Deprecated
        public Builder collectMACEnable(boolean z) {
            return this;
        }

        @Deprecated
        public Builder collectProcessInfoEnable(boolean z) {
            return this;
        }

        public Builder eventReportEnable(boolean z) {
            this.b = z;
            return this;
        }

        public Builder maxDBCount(int i) {
            this.f39583a = i;
            return this;
        }

        public Builder pagePathEnable(boolean z) {
            this.n = z;
            return this;
        }

        public Builder qmspEnable(boolean z) {
            this.m = z;
            return this;
        }

        public Builder setAndroidID(String str) {
            this.o = str;
            return this;
        }

        public Builder setConfigHost(String str) {
            this.k = str;
            return this;
        }

        public Builder setExecutorService(ScheduledExecutorService scheduledExecutorService) {
            this.e = scheduledExecutorService;
            return this;
        }

        public Builder setForceEnableAtta(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setHttpAdapter(AbstractNetAdapter abstractNetAdapter) {
            this.g = abstractNetAdapter;
            return this;
        }

        public Builder setImei(String str) {
            this.p = str;
            return this;
        }

        public Builder setImei2(String str) {
            this.q = str;
            return this;
        }

        public Builder setImsi(String str) {
            this.r = str;
            return this;
        }

        public Builder setIsSocketMode(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setMac(String str) {
            this.u = str;
            return this;
        }

        public Builder setMeid(String str) {
            this.s = str;
            return this;
        }

        public Builder setModel(String str) {
            this.t = str;
            return this;
        }

        public Builder setNormalPollingTime(long j) {
            this.i = j;
            return this;
        }

        public Builder setOaid(String str) {
            this.x = str;
            return this;
        }

        public Builder setRealtimePollingTime(long j) {
            this.h = j;
            return this;
        }

        public Builder setUploadHost(String str) {
            this.j = str;
            return this;
        }

        public Builder setWifiMacAddress(String str) {
            this.v = str;
            return this;
        }

        public Builder setWifiSSID(String str) {
            this.w = str;
            return this;
        }
    }

    public BeaconConfig(int i, boolean z, boolean z2, boolean z3, long j, long j2, boolean z4, AbstractNetAdapter abstractNetAdapter, String str, String str2, boolean z5, boolean z6, boolean z7, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f39581a = i;
        this.b = z;
        this.f39582c = z2;
        this.d = z3;
        this.e = j;
        this.f = j2;
        this.g = z4;
        this.h = abstractNetAdapter;
        this.i = str;
        this.j = str2;
        this.k = z5;
        this.l = z6;
        this.m = z7;
        this.n = str3;
        this.o = str4;
        this.p = str5;
        this.q = str6;
        this.r = str7;
        this.s = str8;
        this.t = str9;
        this.u = str10;
        this.v = str11;
        this.w = str12;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAndroidID() {
        return this.n;
    }

    public String getConfigHost() {
        return this.j;
    }

    public AbstractNetAdapter getHttpAdapter() {
        return this.h;
    }

    public String getImei() {
        return this.o;
    }

    public String getImei2() {
        return this.p;
    }

    public String getImsi() {
        return this.q;
    }

    public String getMac() {
        return this.t;
    }

    public int getMaxDBCount() {
        return this.f39581a;
    }

    public String getMeid() {
        return this.r;
    }

    public String getModel() {
        return this.s;
    }

    public long getNormalPollingTIme() {
        return this.f;
    }

    public String getOaid() {
        return this.w;
    }

    public long getRealtimePollingTime() {
        return this.e;
    }

    public String getUploadHost() {
        return this.i;
    }

    public String getWifiMacAddress() {
        return this.u;
    }

    public String getWifiSSID() {
        return this.v;
    }

    public boolean isAuditEnable() {
        return this.f39582c;
    }

    public boolean isBidEnable() {
        return this.d;
    }

    public boolean isEnableQmsp() {
        return this.l;
    }

    public boolean isEventReportEnable() {
        return this.b;
    }

    public boolean isForceEnableAtta() {
        return this.k;
    }

    public boolean isPagePathEnable() {
        return this.m;
    }

    public boolean isSocketMode() {
        return this.g;
    }

    public String toString() {
        return "BeaconConfig{maxDBCount=" + this.f39581a + ", eventReportEnable=" + this.b + ", auditEnable=" + this.f39582c + ", bidEnable=" + this.d + ", realtimePollingTime=" + this.e + ", normalPollingTIme=" + this.f + ", httpAdapter=" + this.h + ", uploadHost='" + this.i + "', configHost='" + this.j + "', forceEnableAtta=" + this.k + ", enableQmsp=" + this.l + ", pagePathEnable=" + this.m + ", androidID=" + this.n + "', imei='" + this.o + "', imei2='" + this.p + "', imsi='" + this.q + "', meid='" + this.r + "', model='" + this.s + "', mac='" + this.t + "', wifiMacAddress='" + this.u + "', wifiSSID='" + this.v + "', oaid='" + this.w + "'}";
    }
}
