package com.youzan.spiderman.html;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/HtmlCacheStrategy.class */
public class HtmlCacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f41817a;
    private Long b;

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/HtmlCacheStrategy$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        Boolean f41818a = null;
        Long b = null;

        public final HtmlCacheStrategy build() {
            return new HtmlCacheStrategy(this);
        }

        public final Builder htmlCacheEnable(boolean z) {
            this.f41818a = Boolean.valueOf(z);
            return this;
        }

        public final Builder htmlCacheValidTime(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    public HtmlCacheStrategy(Builder builder) {
        this.f41817a = builder.f41818a;
        this.b = builder.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean a() {
        return this.f41817a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long b() {
        return this.b;
    }
}
