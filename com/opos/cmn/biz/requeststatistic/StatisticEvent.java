package com.opos.cmn.biz.requeststatistic;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/StatisticEvent.class */
public class StatisticEvent {
    public final String channel;
    public final long currentTime;
    public final String eventId;
    public final String ext;
    public final long maxResolveTime;
    public final String net;
    public final long resolveTime;
    public final long ret;
    public final String sdkVersion;
    public final String url;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/StatisticEvent$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f10981a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private long f10982c;
        private String d;
        private long e;
        private long f;
        private long g;
        private String h = "";
        private String i;
        private String j;

        public Builder(String str, String str2, long j, long j2, long j3, String str3) {
            this.b = str;
            this.d = str2;
            this.e = j;
            this.f = j2;
            this.g = j3;
            this.i = str3;
        }

        public StatisticEvent build() {
            return new StatisticEvent(this, (byte) 0);
        }

        public Builder setCurrentTime(long j) {
            this.f10982c = j;
            return this;
        }

        public Builder setExt(String str) {
            this.h = str;
            return this;
        }

        public Builder setNet(String str) {
            this.f10981a = str;
            return this;
        }

        public Builder setSdkVersion(String str) {
            this.j = str;
            return this;
        }
    }

    private StatisticEvent(Builder builder) {
        this.eventId = builder.b;
        this.url = builder.d;
        this.ret = builder.e;
        this.currentTime = builder.f10982c;
        this.resolveTime = builder.f;
        this.maxResolveTime = builder.g;
        this.net = builder.f10981a;
        this.ext = builder.h;
        this.channel = builder.i;
        this.sdkVersion = builder.j;
    }

    /* synthetic */ StatisticEvent(Builder builder, byte b) {
        this(builder);
    }
}
