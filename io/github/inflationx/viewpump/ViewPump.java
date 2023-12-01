package io.github.inflationx.viewpump;

import android.content.Context;
import android.view.View;
import io.github.inflationx.viewpump.internal.FallbackViewCreationInterceptor;
import io.github.inflationx.viewpump.internal.InterceptorChain;
import io.github.inflationx.viewpump.internal.ReflectiveFallbackViewCreator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/ViewPump.class */
public final class ViewPump {
    private static ViewPump INSTANCE;
    private final List<Interceptor> interceptors;
    private final List<Interceptor> interceptorsWithFallback;
    private final boolean isCustomViewCreation;
    private final boolean isReflection;
    private final boolean isStoreLayoutResId;
    public static final Companion Companion = new Companion(null);
    private static final Lazy reflectiveFallbackViewCreator$delegate = LazyKt.a(new Function0<ReflectiveFallbackViewCreator>() { // from class: io.github.inflationx.viewpump.ViewPump$Companion$reflectiveFallbackViewCreator$2
        /* renamed from: invoke */
        public final ReflectiveFallbackViewCreator m9364invoke() {
            return new ReflectiveFallbackViewCreator();
        }
    });

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/ViewPump$Builder.class */
    public static final class Builder {
        private FallbackViewCreator reflectiveFallbackViewCreator;
        private boolean storeLayoutResId;
        private final List<Interceptor> interceptors = new ArrayList();
        private boolean reflection = true;
        private boolean customViewCreation = true;

        public final Builder addInterceptor(Interceptor interceptor) {
            Intrinsics.d(interceptor, "interceptor");
            Builder builder = this;
            builder.interceptors.add(interceptor);
            return builder;
        }

        public final ViewPump build() {
            return new ViewPump(CollectionsKt.f(this.interceptors), this.reflection, this.customViewCreation, this.storeLayoutResId, null);
        }

        public final Builder setCustomViewInflationEnabled(boolean z) {
            Builder builder = this;
            builder.customViewCreation = z;
            return builder;
        }

        public final Builder setPrivateFactoryInjectionEnabled(boolean z) {
            Builder builder = this;
            builder.reflection = z;
            return builder;
        }

        public final Builder setReflectiveFallbackViewCreator(FallbackViewCreator fallbackViewCreator) {
            Intrinsics.d(fallbackViewCreator, "reflectiveFallbackViewCreator");
            Builder builder = this;
            builder.reflectiveFallbackViewCreator = fallbackViewCreator;
            return builder;
        }

        public final Builder setStoreLayoutResId(boolean z) {
            Builder builder = this;
            builder.storeLayoutResId = z;
            return builder;
        }
    }

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/ViewPump$Companion.class */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.a(new PropertyReference1Impl(Reflection.b(Companion.class), "reflectiveFallbackViewCreator", "getReflectiveFallbackViewCreator()Lio/github/inflationx/viewpump/FallbackViewCreator;"))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final FallbackViewCreator getReflectiveFallbackViewCreator() {
            Lazy lazy = ViewPump.reflectiveFallbackViewCreator$delegate;
            Companion companion = ViewPump.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (FallbackViewCreator) lazy.getValue();
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }

        @JvmStatic
        public final View create(Context context, Class<? extends View> cls) {
            Intrinsics.d(context, "context");
            Intrinsics.d(cls, "clazz");
            Companion companion = this;
            ViewPump viewPump = companion.get();
            String name = cls.getName();
            Intrinsics.b(name, "clazz.name");
            return viewPump.inflate(new InflateRequest(name, context, null, null, companion.getReflectiveFallbackViewCreator(), 12, null)).view();
        }

        @JvmStatic
        public final ViewPump get() {
            ViewPump viewPump = ViewPump.INSTANCE;
            if (viewPump != null) {
                return viewPump;
            }
            ViewPump build = builder().build();
            ViewPump.INSTANCE = build;
            return build;
        }

        @JvmStatic
        public final void init(ViewPump viewPump) {
            ViewPump.INSTANCE = viewPump;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ViewPump(List<? extends Interceptor> list, boolean z, boolean z2, boolean z3) {
        this.interceptors = list;
        this.isReflection = z;
        this.isCustomViewCreation = z2;
        this.isStoreLayoutResId = z3;
        this.interceptorsWithFallback = CollectionsKt.c(CollectionsKt.a(list, new FallbackViewCreationInterceptor()));
    }

    public /* synthetic */ ViewPump(List list, boolean z, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, z2, z3);
    }

    @JvmStatic
    public static final Builder builder() {
        return Companion.builder();
    }

    @JvmStatic
    public static final View create(Context context, Class<? extends View> cls) {
        return Companion.create(context, cls);
    }

    @JvmStatic
    public static final ViewPump get() {
        return Companion.get();
    }

    @JvmStatic
    public static final void init(ViewPump viewPump) {
        Companion.init(viewPump);
    }

    public final InflateResult inflate(InflateRequest inflateRequest) {
        Intrinsics.d(inflateRequest, "originalRequest");
        return new InterceptorChain(this.interceptorsWithFallback, 0, inflateRequest).proceed(inflateRequest);
    }

    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public final boolean isCustomViewCreation() {
        return this.isCustomViewCreation;
    }

    public final boolean isReflection() {
        return this.isReflection;
    }

    public final boolean isStoreLayoutResId() {
        return this.isStoreLayoutResId;
    }
}
