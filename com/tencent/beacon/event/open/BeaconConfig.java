package com.tencent.beacon.event.open;

import com.tencent.beacon.base.net.adapter.AbstractNetAdapter;
import com.tencent.beacon.base.util.c;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/open/BeaconConfig.class */
public class BeaconConfig {

    /* renamed from: a  reason: collision with root package name */
    private final int f35063a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f35064c;
    private final long d;
    private final long e;
    private final int f;
    private final int g;
    private final boolean h;
    private final AbstractNetAdapter i;
    private final String j;
    private final String k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private final String x;
    private final boolean y;
    private final boolean z;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/open/BeaconConfig$Builder.class */
    public static final class Builder {
        private ScheduledExecutorService d;
        private AbstractNetAdapter f;
        private String k;
        private String l;

        /* renamed from: a  reason: collision with root package name */
        private int f35065a = 10000;
        private boolean b = true;

        /* renamed from: c  reason: collision with root package name */
        private boolean f35066c = true;
        private boolean e = true;
        private long g = 2000;
        private long h = 5000;
        private int i = 48;
        private int j = 48;
        private boolean m = false;
        private boolean n = true;
        private boolean o = true;
        private String p = "";
        private String q = "";
        private String r = "";
        private String s = "";
        private String t = "";
        private String u = "";
        private String v = "";
        private String w = "";
        private String x = "";
        private String y = "";
        private boolean z = true;
        private boolean A = true;

        public Builder auditEnable(boolean z) {
            this.b = z;
            return this;
        }

        public Builder bidEnable(boolean z) {
            this.f35066c = z;
            return this;
        }

        public BeaconConfig build() {
            ScheduledExecutorService scheduledExecutorService = this.d;
            if (scheduledExecutorService != null) {
                com.tencent.beacon.a.b.a.a(scheduledExecutorService);
            }
            return new BeaconConfig(this);
        }

        @Deprecated
        public Builder eventReportEnable(boolean z) {
            c.b("eventReportEnable is deprecated!", new Object[0]);
            return this;
        }

        public Builder maxDBCount(int i) {
            this.f35065a = i;
            return this;
        }

        public Builder pagePathEnable(boolean z) {
            this.o = z;
            return this;
        }

        public Builder qmspEnable(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setAndroidID(String str) {
            this.p = str;
            return this;
        }

        public Builder setConfigHost(String str) {
            this.l = str;
            return this;
        }

        public Builder setExecutorService(ScheduledExecutorService scheduledExecutorService) {
            this.d = scheduledExecutorService;
            return this;
        }

        public Builder setForceEnableAtta(boolean z) {
            this.m = z;
            return this;
        }

        public Builder setHttpAdapter(AbstractNetAdapter abstractNetAdapter) {
            this.f = abstractNetAdapter;
            return this;
        }

        public Builder setImei(String str) {
            this.q = str;
            return this;
        }

        public Builder setImei2(String str) {
            this.r = str;
            return this;
        }

        public Builder setImsi(String str) {
            this.s = str;
            return this;
        }

        public Builder setIsSocketMode(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setMac(String str) {
            this.v = str;
            return this;
        }

        public Builder setMeid(String str) {
            this.t = str;
            return this;
        }

        public Builder setModel(String str) {
            this.u = str;
            return this;
        }

        public Builder setNeedInitQimei(boolean z) {
            this.z = z;
            return this;
        }

        public Builder setNeedReportRqdEvent(boolean z) {
            this.A = z;
            return this;
        }

        public Builder setNormalPollingTime(long j) {
            this.h = j;
            return this;
        }

        public Builder setNormalUploadNum(int i) {
            this.j = i;
            return this;
        }

        public Builder setOaid(String str) {
            this.y = str;
            return this;
        }

        public Builder setRealtimePollingTime(long j) {
            this.g = j;
            return this;
        }

        public Builder setRealtimeUploadNum(int i) {
            this.i = i;
            return this;
        }

        public Builder setUploadHost(String str) {
            this.k = str;
            return this;
        }

        public Builder setWifiMacAddress(String str) {
            this.w = str;
            return this;
        }

        public Builder setWifiSSID(String str) {
            this.x = str;
            return this;
        }
    }

    public BeaconConfig(Builder builder) {
        this.f35063a = builder.f35065a;
        this.b = builder.b;
        this.f35064c = builder.f35066c;
        this.d = builder.g;
        this.e = builder.h;
        this.f = builder.i;
        this.g = builder.j;
        this.h = builder.e;
        this.i = builder.f;
        this.j = builder.k;
        this.k = builder.l;
        this.l = builder.m;
        this.m = builder.n;
        this.n = builder.o;
        this.o = builder.p;
        this.p = builder.q;
        this.q = builder.r;
        this.r = builder.s;
        this.s = builder.t;
        this.t = builder.u;
        this.u = builder.v;
        this.v = builder.w;
        this.w = builder.x;
        this.x = builder.y;
        this.y = builder.z;
        this.z = builder.A;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAndroidID() {
        return this.o;
    }

    public String getConfigHost() {
        return this.k;
    }

    public AbstractNetAdapter getHttpAdapter() {
        return this.i;
    }

    public String getImei() {
        return this.p;
    }

    public String getImei2() {
        return this.q;
    }

    public String getImsi() {
        return this.r;
    }

    public String getMac() {
        return this.u;
    }

    public int getMaxDBCount() {
        return this.f35063a;
    }

    public String getMeid() {
        return this.s;
    }

    public String getModel() {
        return this.t;
    }

    public long getNormalPollingTIme() {
        return this.e;
    }

    public int getNormalUploadNum() {
        return this.g;
    }

    public String getOaid() {
        return this.x;
    }

    public long getRealtimePollingTime() {
        return this.d;
    }

    public int getRealtimeUploadNum() {
        return this.f;
    }

    public String getUploadHost() {
        return this.j;
    }

    public String getWifiMacAddress() {
        return this.v;
    }

    public String getWifiSSID() {
        return this.w;
    }

    public boolean isAuditEnable() {
        return this.b;
    }

    public boolean isBidEnable() {
        return this.f35064c;
    }

    public boolean isEnableQmsp() {
        return this.m;
    }

    public boolean isForceEnableAtta() {
        return this.l;
    }

    public boolean isNeedInitQimei() {
        return this.y;
    }

    public boolean isNeedReportRqdEvent() {
        return this.z;
    }

    public boolean isPagePathEnable() {
        return this.n;
    }

    public boolean isSocketMode() {
        return this.h;
    }

    public String toString() {
        return "BeaconConfig{maxDBCount=" + this.f35063a + ", auditEnable=" + this.b + ", bidEnable=" + this.f35064c + ", realtimePollingTime=" + this.d + ", normalPollingTIme=" + this.e + ", normalUploadNum=" + this.g + ", realtimeUploadNum=" + this.f + ", httpAdapter=" + this.i + ", uploadHost='" + this.j + "', configHost='" + this.k + "', forceEnableAtta=" + this.l + ", enableQmsp=" + this.m + ", pagePathEnable=" + this.n + ", androidID='" + this.o + "', imei='" + this.p + "', imei2='" + this.q + "', imsi='" + this.r + "', meid='" + this.s + "', model='" + this.t + "', mac='" + this.u + "', wifiMacAddress='" + this.v + "', wifiSSID='" + this.w + "', oaid='" + this.x + "', needInitQ='" + this.y + "'}";
    }
}
