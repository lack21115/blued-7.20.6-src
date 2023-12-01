package io.github.inflationx.viewpump;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import io.github.inflationx.viewpump.internal.ViewPumpActivityFactory;
import io.github.inflationx.viewpump.internal.ViewPumpLayoutInflater;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/ViewPumpContextWrapper.class */
public final class ViewPumpContextWrapper extends ContextWrapper {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.a(new PropertyReference1Impl(Reflection.b(ViewPumpContextWrapper.class), "inflater", "getInflater()Lio/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater;"))};
    public static final Companion Companion = new Companion(null);
    private final Lazy inflater$delegate;

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/ViewPumpContextWrapper$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ViewPumpActivityFactory get$viewpump_release(Activity activity) {
            Intrinsics.d(activity, "activity");
            if (activity.getLayoutInflater() instanceof ViewPumpLayoutInflater) {
                LayoutInflater layoutInflater = activity.getLayoutInflater();
                if (layoutInflater != null) {
                    return (ViewPumpActivityFactory) layoutInflater;
                }
                throw new TypeCastException("null cannot be cast to non-null type io.github.inflationx.viewpump.internal.`-ViewPumpActivityFactory`");
            }
            throw new RuntimeException("This activity does not wrap the Base Context! See ViewPumpContextWrapper.wrap(Context)");
        }

        @JvmStatic
        public final View onActivityCreateView(Activity activity, View view, View view2, String name, Context context, AttributeSet attributeSet) {
            Intrinsics.d(activity, "activity");
            Intrinsics.d(view2, "view");
            Intrinsics.d(name, "name");
            Intrinsics.d(context, "context");
            return get$viewpump_release(activity).onActivityCreateView(view, view2, name, context, attributeSet);
        }

        @JvmStatic
        public final ContextWrapper wrap(Context base) {
            Intrinsics.d(base, "base");
            return new ViewPumpContextWrapper(base, null);
        }
    }

    private ViewPumpContextWrapper(Context context) {
        super(context);
        this.inflater$delegate = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<ViewPumpLayoutInflater>() { // from class: io.github.inflationx.viewpump.ViewPumpContextWrapper$inflater$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewPumpLayoutInflater invoke() {
                LayoutInflater from = LayoutInflater.from(ViewPumpContextWrapper.this.getBaseContext());
                Intrinsics.b(from, "LayoutInflater.from(baseContext)");
                return new ViewPumpLayoutInflater(from, ViewPumpContextWrapper.this, false);
            }
        });
    }

    public /* synthetic */ ViewPumpContextWrapper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final ViewPumpLayoutInflater getInflater() {
        Lazy lazy = this.inflater$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ViewPumpLayoutInflater) lazy.getValue();
    }

    @JvmStatic
    public static final View onActivityCreateView(Activity activity, View view, View view2, String str, Context context, AttributeSet attributeSet) {
        return Companion.onActivityCreateView(activity, view, view2, str, context, attributeSet);
    }

    @JvmStatic
    public static final ContextWrapper wrap(Context context) {
        return Companion.wrap(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        Intrinsics.d(name, "name");
        return Intrinsics.a((Object) Context.LAYOUT_INFLATER_SERVICE, (Object) name) ? getInflater() : super.getSystemService(name);
    }
}
