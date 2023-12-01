package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/InflateResult.class */
public final class InflateResult {
    public static final Companion Companion = new Companion(null);
    private final AttributeSet attrs;
    private final Context context;
    private final String name;
    private final View view;

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/InflateResult$Builder.class */
    public static final class Builder {
        private AttributeSet attrs;
        private Context context;
        private String name;
        private View view;

        public Builder() {
        }

        public Builder(InflateResult inflateResult) {
            Intrinsics.d(inflateResult, "result");
            this.view = inflateResult.view();
            this.name = inflateResult.name();
            this.context = inflateResult.context();
            this.attrs = inflateResult.attrs();
        }

        public final Builder attrs(AttributeSet attributeSet) {
            Builder builder = this;
            builder.attrs = attributeSet;
            return builder;
        }

        public final InflateResult build() {
            String str = this.name;
            if (str != null) {
                View view = this.view;
                if (view == null) {
                    view = null;
                } else if (!Intrinsics.a(str, view.getClass().getName())) {
                    throw new IllegalStateException(("name (" + str + ") must be the view's fully qualified name (" + view.getClass().getName() + ')').toString());
                }
                Context context = this.context;
                if (context != null) {
                    return new InflateResult(view, str, context, this.attrs);
                }
                throw new IllegalStateException("context == null");
            }
            throw new IllegalStateException("name == null".toString());
        }

        public final Builder context(Context context) {
            Intrinsics.d(context, "context");
            Builder builder = this;
            builder.context = context;
            return builder;
        }

        public final Builder name(String str) {
            Intrinsics.d(str, "name");
            Builder builder = this;
            builder.name = str;
            return builder;
        }

        public final Builder view(View view) {
            Builder builder = this;
            builder.view = view;
            return builder;
        }
    }

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/InflateResult$Companion.class */
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

    public InflateResult(View view, String str, Context context, AttributeSet attributeSet) {
        Intrinsics.d(str, "name");
        Intrinsics.d(context, "context");
        this.view = view;
        this.name = str;
        this.context = context;
        this.attrs = attributeSet;
    }

    public /* synthetic */ InflateResult(View view, String str, Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : view, str, context, (i & 8) != 0 ? null : attributeSet);
    }

    @JvmStatic
    public static final Builder builder() {
        return Companion.builder();
    }

    public static /* synthetic */ InflateResult copy$default(InflateResult inflateResult, View view, String str, Context context, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 1) != 0) {
            view = inflateResult.view;
        }
        if ((i & 2) != 0) {
            str = inflateResult.name;
        }
        if ((i & 4) != 0) {
            context = inflateResult.context;
        }
        if ((i & 8) != 0) {
            attributeSet = inflateResult.attrs;
        }
        return inflateResult.copy(view, str, context, attributeSet);
    }

    public final AttributeSet attrs() {
        return this.attrs;
    }

    public final View component1() {
        return this.view;
    }

    public final String component2() {
        return this.name;
    }

    public final Context component3() {
        return this.context;
    }

    public final AttributeSet component4() {
        return this.attrs;
    }

    public final Context context() {
        return this.context;
    }

    public final InflateResult copy(View view, String str, Context context, AttributeSet attributeSet) {
        Intrinsics.d(str, "name");
        Intrinsics.d(context, "context");
        return new InflateResult(view, str, context, attributeSet);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof InflateResult) {
                InflateResult inflateResult = (InflateResult) obj;
                return Intrinsics.a(this.view, inflateResult.view) && Intrinsics.a(this.name, inflateResult.name) && Intrinsics.a(this.context, inflateResult.context) && Intrinsics.a(this.attrs, inflateResult.attrs);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        View view = this.view;
        int i = 0;
        int hashCode = view != null ? view.hashCode() : 0;
        String str = this.name;
        int hashCode2 = str != null ? str.hashCode() : 0;
        Context context = this.context;
        int hashCode3 = context != null ? context.hashCode() : 0;
        AttributeSet attributeSet = this.attrs;
        if (attributeSet != null) {
            i = attributeSet.hashCode();
        }
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i;
    }

    public final String name() {
        return this.name;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "InflateResult(view=" + this.view + ", name=" + this.name + ", context=" + this.context + ", attrs=" + this.attrs + ")";
    }

    public final View view() {
        return this.view;
    }
}
