package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/InflateRequest.class */
public final class InflateRequest {
    public static final Companion Companion = new Companion(null);
    private final AttributeSet attrs;
    private final Context context;
    private final FallbackViewCreator fallbackViewCreator;
    private final String name;
    private final View parent;

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/InflateRequest$Builder.class */
    public static final class Builder {
        private AttributeSet attrs;
        private Context context;
        private FallbackViewCreator fallbackViewCreator;
        private String name;
        private View parent;

        public Builder() {
        }

        public Builder(InflateRequest request) {
            Intrinsics.d(request, "request");
            this.name = request.name();
            this.context = request.context();
            this.attrs = request.attrs();
            this.parent = request.parent();
            this.fallbackViewCreator = request.fallbackViewCreator();
        }

        public final Builder attrs(AttributeSet attributeSet) {
            Builder builder = this;
            builder.attrs = attributeSet;
            return builder;
        }

        public final InflateRequest build() {
            String str = this.name;
            if (str != null) {
                Context context = this.context;
                if (context != null) {
                    AttributeSet attributeSet = this.attrs;
                    View view = this.parent;
                    FallbackViewCreator fallbackViewCreator = this.fallbackViewCreator;
                    if (fallbackViewCreator != null) {
                        return new InflateRequest(str, context, attributeSet, view, fallbackViewCreator);
                    }
                    throw new IllegalStateException("fallbackViewCreator == null");
                }
                throw new IllegalStateException("context == null");
            }
            throw new IllegalStateException("name == null");
        }

        public final Builder context(Context context) {
            Intrinsics.d(context, "context");
            Builder builder = this;
            builder.context = context;
            return builder;
        }

        public final Builder fallbackViewCreator(FallbackViewCreator fallbackViewCreator) {
            Intrinsics.d(fallbackViewCreator, "fallbackViewCreator");
            Builder builder = this;
            builder.fallbackViewCreator = fallbackViewCreator;
            return builder;
        }

        public final Builder name(String name) {
            Intrinsics.d(name, "name");
            Builder builder = this;
            builder.name = name;
            return builder;
        }

        public final Builder parent(View view) {
            Builder builder = this;
            builder.parent = view;
            return builder;
        }
    }

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/InflateRequest$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }

    public InflateRequest(String name, Context context, AttributeSet attributeSet, View view, FallbackViewCreator fallbackViewCreator) {
        Intrinsics.d(name, "name");
        Intrinsics.d(context, "context");
        Intrinsics.d(fallbackViewCreator, "fallbackViewCreator");
        this.name = name;
        this.context = context;
        this.attrs = attributeSet;
        this.parent = view;
        this.fallbackViewCreator = fallbackViewCreator;
    }

    public /* synthetic */ InflateRequest(String str, Context context, AttributeSet attributeSet, View view, FallbackViewCreator fallbackViewCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, context, (i & 4) != 0 ? null : attributeSet, (i & 8) != 0 ? null : view, fallbackViewCreator);
    }

    @JvmStatic
    public static final Builder builder() {
        return Companion.builder();
    }

    public static /* synthetic */ InflateRequest copy$default(InflateRequest inflateRequest, String str, Context context, AttributeSet attributeSet, View view, FallbackViewCreator fallbackViewCreator, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inflateRequest.name;
        }
        if ((i & 2) != 0) {
            context = inflateRequest.context;
        }
        if ((i & 4) != 0) {
            attributeSet = inflateRequest.attrs;
        }
        if ((i & 8) != 0) {
            view = inflateRequest.parent;
        }
        if ((i & 16) != 0) {
            fallbackViewCreator = inflateRequest.fallbackViewCreator;
        }
        return inflateRequest.copy(str, context, attributeSet, view, fallbackViewCreator);
    }

    public final AttributeSet attrs() {
        return this.attrs;
    }

    public final String component1() {
        return this.name;
    }

    public final Context component2() {
        return this.context;
    }

    public final AttributeSet component3() {
        return this.attrs;
    }

    public final View component4() {
        return this.parent;
    }

    public final FallbackViewCreator component5() {
        return this.fallbackViewCreator;
    }

    public final Context context() {
        return this.context;
    }

    public final InflateRequest copy(String name, Context context, AttributeSet attributeSet, View view, FallbackViewCreator fallbackViewCreator) {
        Intrinsics.d(name, "name");
        Intrinsics.d(context, "context");
        Intrinsics.d(fallbackViewCreator, "fallbackViewCreator");
        return new InflateRequest(name, context, attributeSet, view, fallbackViewCreator);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof InflateRequest) {
                InflateRequest inflateRequest = (InflateRequest) obj;
                return Intrinsics.a((Object) this.name, (Object) inflateRequest.name) && Intrinsics.a(this.context, inflateRequest.context) && Intrinsics.a(this.attrs, inflateRequest.attrs) && Intrinsics.a(this.parent, inflateRequest.parent) && Intrinsics.a(this.fallbackViewCreator, inflateRequest.fallbackViewCreator);
            }
            return false;
        }
        return true;
    }

    public final FallbackViewCreator fallbackViewCreator() {
        return this.fallbackViewCreator;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        Context context = this.context;
        int hashCode2 = context != null ? context.hashCode() : 0;
        AttributeSet attributeSet = this.attrs;
        int hashCode3 = attributeSet != null ? attributeSet.hashCode() : 0;
        View view = this.parent;
        int hashCode4 = view != null ? view.hashCode() : 0;
        FallbackViewCreator fallbackViewCreator = this.fallbackViewCreator;
        if (fallbackViewCreator != null) {
            i = fallbackViewCreator.hashCode();
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }

    public final String name() {
        return this.name;
    }

    public final View parent() {
        return this.parent;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "InflateRequest(name=" + this.name + ", context=" + this.context + ", attrs=" + this.attrs + ", parent=" + this.parent + ", fallbackViewCreator=" + this.fallbackViewCreator + ")";
    }
}
