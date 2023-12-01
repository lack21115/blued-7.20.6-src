package com.blued.android.module.common.extensions;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.extensions.LifecycleViewBindingProperty;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/LifecycleViewBindingProperty.class */
public abstract class LifecycleViewBindingProperty<R, V extends ViewBinding> implements ViewBindingProperty<R, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<R, V> f10793a;
    private V b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/LifecycleViewBindingProperty$ClearOnDestroyLifecycleObserver.class */
    public static final class ClearOnDestroyLifecycleObserver implements LifecycleObserver {

        /* renamed from: a  reason: collision with root package name */
        private static final Companion f10794a = new Companion(null);
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        private static final Handler f10795c = new Handler(Looper.getMainLooper());
        private final LifecycleViewBindingProperty<?, ?> b;

        @Metadata
        /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/LifecycleViewBindingProperty$ClearOnDestroyLifecycleObserver$Companion.class */
        static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ClearOnDestroyLifecycleObserver(LifecycleViewBindingProperty<?, ?> property) {
            Intrinsics.e(property, "property");
            this.b = property;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(ClearOnDestroyLifecycleObserver this$0) {
            Intrinsics.e(this$0, "this$0");
            this$0.b.a();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy(LifecycleOwner owner) {
            Intrinsics.e(owner, "owner");
            f10795c.post(new Runnable() { // from class: com.blued.android.module.common.extensions.-$$Lambda$LifecycleViewBindingProperty$ClearOnDestroyLifecycleObserver$rUcvcR_on3Ed37qXUU0RMOpXwSg
                @Override // java.lang.Runnable
                public final void run() {
                    LifecycleViewBindingProperty.ClearOnDestroyLifecycleObserver.a(LifecycleViewBindingProperty.ClearOnDestroyLifecycleObserver.this);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LifecycleViewBindingProperty(Function1<? super R, ? extends V> viewBinder) {
        Intrinsics.e(viewBinder, "viewBinder");
        this.f10793a = viewBinder;
    }

    protected abstract Lifecycle a(R r);

    @Override // kotlin.properties.ReadOnlyProperty
    /* renamed from: a */
    public V b(R thisRef, KProperty<?> property) {
        Intrinsics.e(thisRef, "thisRef");
        Intrinsics.e(property, "property");
        V v = this.b;
        if (v == null) {
            Lifecycle a2 = a(thisRef);
            if (a2.getCurrentState() == Lifecycle.State.DESTROYED) {
                Logger.c("ViewBindingProperty", "Access to viewBinding after Lifecycle is destroyed or hasn't created yet. The instance of viewBinding will be not cached.");
            } else {
                try {
                    a2.addObserver(new ClearOnDestroyLifecycleObserver(this));
                    this.b = this.f10793a.invoke(thisRef);
                } catch (IllegalStateException e) {
                    Logger.e("ViewBindingProperty", "did not return a View from onCreateView() or this was called before onCreateView()");
                }
            }
            return this.b;
        }
        return v;
    }

    public void a() {
        Logger.c("ViewBindingProperty", Intrinsics.a("clear---", (Object) this.b));
        this.b = null;
    }
}
