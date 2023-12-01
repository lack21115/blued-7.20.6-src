package io.github.inflationx.viewpump.internal;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BuildCompat;
import com.anythink.expressad.a;
import io.github.inflationx.viewpump.FallbackViewCreator;
import io.github.inflationx.viewpump.InflateRequest;
import io.github.inflationx.viewpump.R;
import io.github.inflationx.viewpump.ViewPump;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

@Metadata
/* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater  reason: invalid class name */
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater.class */
public final class ViewPumpLayoutInflater extends LayoutInflater implements ViewPumpActivityFactory {
    private final boolean IS_AT_LEAST_Q;
    private final FallbackViewCreator nameAndAttrsViewCreator;
    private final FallbackViewCreator parentAndNameAndAttrsViewCreator;
    private boolean setPrivateFactory;
    private boolean storeLayoutResId;
    public static final Companion Companion = new Companion(null);
    private static final Set<String> CLASS_PREFIX_LIST = SetsKt.a(new String[]{"android.widget.", "android.webkit."});
    private static final Lazy CONSTRUCTOR_ARGS_FIELD$delegate = LazyKt.a(new Function0<Field>() { // from class: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$Companion$CONSTRUCTOR_ARGS_FIELD$2
        public final Field invoke() {
            Field declaredField = LayoutInflater.class.getDeclaredField("mConstructorArgs");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField;
            }
            throw new IllegalArgumentException("No constructor arguments field found in LayoutInflater!".toString());
        }
    });

    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$ActivityViewCreator */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$ActivityViewCreator.class */
    static final class ActivityViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater inflater;
        private final View view;

        public ActivityViewCreator(ViewPumpLayoutInflater viewPumpLayoutInflater, View view) {
            Intrinsics.d(viewPumpLayoutInflater, "inflater");
            Intrinsics.d(view, a.B);
            this.inflater = viewPumpLayoutInflater;
            this.view = view;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            return this.inflater.createCustomViewInternal(this.view, str, context, attributeSet);
        }
    }

    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$Companion */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$Companion.class */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.a(new PropertyReference1Impl(Reflection.b(Companion.class), "CONSTRUCTOR_ARGS_FIELD", "getCONSTRUCTOR_ARGS_FIELD()Ljava/lang/reflect/Field;"))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Field getCONSTRUCTOR_ARGS_FIELD() {
            Lazy lazy = ViewPumpLayoutInflater.CONSTRUCTOR_ARGS_FIELD$delegate;
            Companion companion = ViewPumpLayoutInflater.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (Field) lazy.getValue();
        }
    }

    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$NameAndAttrsViewCreator */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$NameAndAttrsViewCreator.class */
    static final class NameAndAttrsViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater inflater;

        public NameAndAttrsViewCreator(ViewPumpLayoutInflater viewPumpLayoutInflater) {
            Intrinsics.d(viewPumpLayoutInflater, "inflater");
            this.inflater = viewPumpLayoutInflater;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            View view2;
            View createView;
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            View view3 = null;
            Iterator it = ViewPumpLayoutInflater.CLASS_PREFIX_LIST.iterator();
            while (true) {
                View view4 = view3;
                view2 = view4;
                if (!it.hasNext()) {
                    break;
                }
                try {
                    createView = this.inflater.createView(str, (String) it.next(), attributeSet);
                    view3 = createView;
                } catch (ClassNotFoundException e) {
                    view3 = view4;
                }
                if (createView != null) {
                    view2 = createView;
                    break;
                }
            }
            View view5 = view2;
            if (view2 == null) {
                view5 = this.inflater.superOnCreateView(str, attributeSet);
            }
            return view5;
        }
    }

    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$ParentAndNameAndAttrsViewCreator */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$ParentAndNameAndAttrsViewCreator.class */
    static final class ParentAndNameAndAttrsViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater inflater;

        public ParentAndNameAndAttrsViewCreator(ViewPumpLayoutInflater viewPumpLayoutInflater) {
            Intrinsics.d(viewPumpLayoutInflater, "inflater");
            this.inflater = viewPumpLayoutInflater;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            return this.inflater.superOnCreateView(view, str, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$PrivateWrapperFactory2 */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$PrivateWrapperFactory2.class */
    public static final class PrivateWrapperFactory2 extends WrapperFactory2 {
        private final PrivateWrapperFactory2ViewCreator viewCreator;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateWrapperFactory2(LayoutInflater.Factory2 factory2, ViewPumpLayoutInflater viewPumpLayoutInflater) {
            super(factory2);
            Intrinsics.d(factory2, "factory2");
            Intrinsics.d(viewPumpLayoutInflater, "inflater");
            this.viewCreator = new PrivateWrapperFactory2ViewCreator(factory2, viewPumpLayoutInflater);
        }

        @Override // io.github.inflationx.viewpump.internal.ViewPumpLayoutInflater.WrapperFactory2, android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            return ViewPump.Companion.get().inflate(new InflateRequest(str, context, attributeSet, view, this.viewCreator)).view();
        }
    }

    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$PrivateWrapperFactory2ViewCreator */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$PrivateWrapperFactory2ViewCreator.class */
    static final class PrivateWrapperFactory2ViewCreator extends WrapperFactory2ViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater inflater;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateWrapperFactory2ViewCreator(LayoutInflater.Factory2 factory2, ViewPumpLayoutInflater viewPumpLayoutInflater) {
            super(factory2);
            Intrinsics.d(factory2, "factory2");
            Intrinsics.d(viewPumpLayoutInflater, "inflater");
            this.inflater = viewPumpLayoutInflater;
        }

        @Override // io.github.inflationx.viewpump.internal.ViewPumpLayoutInflater.WrapperFactory2ViewCreator, io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            return this.inflater.createCustomViewInternal(getFactory2().onCreateView(view, str, context, attributeSet), str, context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$WrapperFactory */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$WrapperFactory.class */
    public static final class WrapperFactory implements LayoutInflater.Factory {
        private final FallbackViewCreator viewCreator;

        public WrapperFactory(LayoutInflater.Factory factory) {
            Intrinsics.d(factory, "factory");
            this.viewCreator = new WrapperFactoryViewCreator(factory);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            return ViewPump.Companion.get().inflate(new InflateRequest(str, context, attributeSet, null, this.viewCreator, 8, null)).view();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$WrapperFactory2 */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$WrapperFactory2.class */
    public static class WrapperFactory2 implements LayoutInflater.Factory2 {
        private final WrapperFactory2ViewCreator viewCreator;

        public WrapperFactory2(LayoutInflater.Factory2 factory2) {
            Intrinsics.d(factory2, "factory2");
            this.viewCreator = new WrapperFactory2ViewCreator(factory2);
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            return ViewPump.Companion.get().inflate(new InflateRequest(str, context, attributeSet, view, this.viewCreator)).view();
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            return onCreateView(null, str, context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$WrapperFactory2ViewCreator */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$WrapperFactory2ViewCreator.class */
    public static class WrapperFactory2ViewCreator implements FallbackViewCreator {
        private final LayoutInflater.Factory2 factory2;

        public WrapperFactory2ViewCreator(LayoutInflater.Factory2 factory2) {
            Intrinsics.d(factory2, "factory2");
            this.factory2 = factory2;
        }

        protected final LayoutInflater.Factory2 getFactory2() {
            return this.factory2;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            return this.factory2.onCreateView(view, str, context, attributeSet);
        }
    }

    @Metadata
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$WrapperFactoryViewCreator */
    /* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater$WrapperFactoryViewCreator.class */
    static final class WrapperFactoryViewCreator implements FallbackViewCreator {
        private final LayoutInflater.Factory factory;

        public WrapperFactoryViewCreator(LayoutInflater.Factory factory) {
            Intrinsics.d(factory, "factory");
            this.factory = factory;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            Intrinsics.d(str, "name");
            Intrinsics.d(context, "context");
            return this.factory.onCreateView(str, context, attributeSet);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPumpLayoutInflater(LayoutInflater layoutInflater, Context context, boolean z) {
        super(layoutInflater, context);
        Intrinsics.d(layoutInflater, "original");
        Intrinsics.d(context, "newContext");
        this.IS_AT_LEAST_Q = Build.VERSION.SDK_INT > 28 || BuildCompat.isAtLeastQ();
        this.nameAndAttrsViewCreator = new NameAndAttrsViewCreator(this);
        this.parentAndNameAndAttrsViewCreator = new ParentAndNameAndAttrsViewCreator(this);
        this.storeLayoutResId = ViewPump.Companion.get().isStoreLayoutResId();
        setUpLayoutFactories(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View createCustomViewInternal(View view, String str, Context context, AttributeSet attributeSet) {
        if (ViewPump.Companion.get().isCustomViewCreation()) {
            if (view != null || StringsKt.a(str, '.', 0, false, 6, (Object) null) <= -1) {
                return view;
            }
            if (this.IS_AT_LEAST_Q) {
                return cloneInContext(context).createView(str, null, attributeSet);
            }
            Object obj = Companion.getCONSTRUCTOR_ARGS_FIELD().get(this);
            if (obj != null) {
                Object[] objArr = (Object[]) obj;
                Object obj2 = objArr[0];
                objArr[0] = context;
                ReflectionUtils.setValueQuietly(Companion.getCONSTRUCTOR_ARGS_FIELD(), this, objArr);
                try {
                    View createView = createView(str, null, attributeSet);
                    objArr[0] = obj2;
                    view = createView;
                } catch (ClassNotFoundException e) {
                    objArr[0] = obj2;
                } catch (Throwable th) {
                    objArr[0] = obj2;
                    ReflectionUtils.setValueQuietly(Companion.getCONSTRUCTOR_ARGS_FIELD(), this, objArr);
                    throw th;
                }
                ReflectionUtils.setValueQuietly(Companion.getCONSTRUCTOR_ARGS_FIELD(), this, objArr);
                return view;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        }
        return view;
    }

    private final void setPrivateFactoryInternal() {
        if (!this.setPrivateFactory && ViewPump.Companion.get().isReflection()) {
            if (!(getContext() instanceof LayoutInflater.Factory2)) {
                this.setPrivateFactory = true;
                return;
            }
            Method accessibleMethod = ReflectionUtils.getAccessibleMethod(LayoutInflater.class, "setPrivateFactory");
            Context context = getContext();
            if (context == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater.Factory2");
            }
            ReflectionUtils.invokeMethod(accessibleMethod, this, new PrivateWrapperFactory2((LayoutInflater.Factory2) context, this));
            this.setPrivateFactory = true;
        }
    }

    private final void setUpLayoutFactories(boolean z) {
        if (z) {
            return;
        }
        if (getFactory2() != null && !(getFactory2() instanceof WrapperFactory2)) {
            setFactory2(getFactory2());
        }
        if (getFactory() == null || (getFactory() instanceof WrapperFactory)) {
            return;
        }
        setFactory(getFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View superOnCreateView(View view, String str, AttributeSet attributeSet) {
        try {
            return super.onCreateView(view, str, attributeSet);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View superOnCreateView(String str, AttributeSet attributeSet) {
        try {
            return super.onCreateView(str, attributeSet);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        Intrinsics.d(context, "newContext");
        return new ViewPumpLayoutInflater(this, context, true);
    }

    @Override // android.view.LayoutInflater
    public View inflate(int i, ViewGroup viewGroup, boolean z) {
        View inflate = super.inflate(i, viewGroup, z);
        if (inflate != null && this.storeLayoutResId) {
            inflate.setTag(R.id.viewpump_layout_res, Integer.valueOf(i));
        }
        return inflate;
    }

    @Override // android.view.LayoutInflater
    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        Intrinsics.d(xmlPullParser, "parser");
        setPrivateFactoryInternal();
        View inflate = super.inflate(xmlPullParser, viewGroup, z);
        Intrinsics.b(inflate, "super.inflate(parser, root, attachToRoot)");
        return inflate;
    }

    @Override // io.github.inflationx.viewpump.internal.ViewPumpActivityFactory
    public View onActivityCreateView(View view, View view2, String str, Context context, AttributeSet attributeSet) {
        Intrinsics.d(view2, a.B);
        Intrinsics.d(str, "name");
        Intrinsics.d(context, "context");
        return ViewPump.Companion.get().inflate(new InflateRequest(str, context, attributeSet, view, new ActivityViewCreator(this, view2))).view();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.LayoutInflater
    public View onCreateView(View view, String str, AttributeSet attributeSet) throws ClassNotFoundException {
        Intrinsics.d(str, "name");
        ViewPump viewPump = ViewPump.Companion.get();
        Context context = getContext();
        Intrinsics.b(context, "context");
        return viewPump.inflate(new InflateRequest(str, context, attributeSet, view, this.parentAndNameAndAttrsViewCreator)).view();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.LayoutInflater
    public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        Intrinsics.d(str, "name");
        ViewPump viewPump = ViewPump.Companion.get();
        Context context = getContext();
        Intrinsics.b(context, "context");
        return viewPump.inflate(new InflateRequest(str, context, attributeSet, null, this.nameAndAttrsViewCreator, 8, null)).view();
    }

    @Override // android.view.LayoutInflater
    public void setFactory(LayoutInflater.Factory factory) {
        Intrinsics.d(factory, "factory");
        if (factory instanceof WrapperFactory) {
            super.setFactory(factory);
        } else {
            super.setFactory(new WrapperFactory(factory));
        }
    }

    @Override // android.view.LayoutInflater
    public void setFactory2(LayoutInflater.Factory2 factory2) {
        Intrinsics.d(factory2, "factory2");
        if (factory2 instanceof WrapperFactory2) {
            super.setFactory2(factory2);
        } else {
            super.setFactory2(new WrapperFactory2(factory2));
        }
    }
}
