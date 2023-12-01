package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProvider.class */
public class ViewModelProvider {
    private final Factory factory;
    private final ViewModelStore store;

    @Metadata
    /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProvider$AndroidViewModelFactory.class */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static final Companion Companion = new Companion(null);
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        private static AndroidViewModelFactory sInstance;
        private final Application application;

        @Metadata
        /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Factory defaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner owner) {
                Intrinsics.e(owner, "owner");
                if (owner instanceof HasDefaultViewModelProviderFactory) {
                    Factory defaultViewModelProviderFactory = ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelProviderFactory();
                    Intrinsics.c(defaultViewModelProviderFactory, "owner.defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
                return NewInstanceFactory.Companion.getInstance();
            }

            @JvmStatic
            public final AndroidViewModelFactory getInstance(Application application) {
                Intrinsics.e(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.sInstance;
                Intrinsics.a(androidViewModelFactory);
                return androidViewModelFactory;
            }
        }

        public AndroidViewModelFactory(Application application) {
            Intrinsics.e(application, "application");
            this.application = application;
        }

        @JvmStatic
        public static final AndroidViewModelFactory getInstance(Application application) {
            return Companion.getInstance(application);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.e(modelClass, "modelClass");
            if (AndroidViewModel.class.isAssignableFrom(modelClass)) {
                try {
                    T newInstance = modelClass.getConstructor(Application.class).newInstance(this.application);
                    Intrinsics.c(newInstance, "{\n                try {\n…          }\n            }");
                    return newInstance;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(Intrinsics.a("Cannot create an instance of ", (Object) modelClass), e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException(Intrinsics.a("Cannot create an instance of ", (Object) modelClass), e2);
                } catch (NoSuchMethodException e3) {
                    throw new RuntimeException(Intrinsics.a("Cannot create an instance of ", (Object) modelClass), e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException(Intrinsics.a("Cannot create an instance of ", (Object) modelClass), e4);
                }
            }
            return (T) super.create(modelClass);
        }
    }

    @Metadata
    /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProvider$Factory.class */
    public interface Factory {
        <T extends ViewModel> T create(Class<T> cls);
    }

    @Metadata
    /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProvider$KeyedFactory.class */
    public static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.e(modelClass, "modelClass");
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementations of KeyedFactory");
        }

        public abstract <T extends ViewModel> T create(String str, Class<T> cls);
    }

    @Metadata
    /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProvider$NewInstanceFactory.class */
    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion(null);
        private static NewInstanceFactory sInstance;

        @Metadata
        /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public static /* synthetic */ void getInstance$annotations() {
            }

            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory.sInstance;
                Intrinsics.a(newInstanceFactory);
                return newInstanceFactory;
            }
        }

        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.e(modelClass, "modelClass");
            try {
                T newInstance = modelClass.newInstance();
                Intrinsics.c(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(Intrinsics.a("Cannot create an instance of ", (Object) modelClass), e);
            } catch (InstantiationException e2) {
                throw new RuntimeException(Intrinsics.a("Cannot create an instance of ", (Object) modelClass), e2);
            }
        }
    }

    @Metadata
    /* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProvider$OnRequeryFactory.class */
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
            Intrinsics.e(viewModel, "viewModel");
        }
    }

    public ViewModelProvider(ViewModelStore store, Factory factory) {
        Intrinsics.e(store, "store");
        Intrinsics.e(factory, "factory");
        this.store = store;
        this.factory = factory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner r6) {
        /*
            r5 = this;
            r0 = r6
            java.lang.String r1 = "owner"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r6
            androidx.lifecycle.ViewModelStore r0 = r0.getViewModelStore()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "owner.viewModelStore"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r5
            r1 = r7
            androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory$Companion r2 = androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion
            r3 = r6
            androidx.lifecycle.ViewModelProvider$Factory r2 = r2.defaultFactory$lifecycle_viewmodel_release(r3)
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner r5, androidx.lifecycle.ViewModelProvider.Factory r6) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r1 = "owner"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r6
            java.lang.String r1 = "factory"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r5
            androidx.lifecycle.ViewModelStore r0 = r0.getViewModelStore()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "owner.viewModelStore"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r4
            r1 = r5
            r2 = r6
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner, androidx.lifecycle.ViewModelProvider$Factory):void");
    }

    public <T extends ViewModel> T get(Class<T> modelClass) {
        Intrinsics.e(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) get(Intrinsics.a("androidx.lifecycle.ViewModelProvider.DefaultKey:", (Object) canonicalName), modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends ViewModel> T get(String key, Class<T> modelClass) {
        Intrinsics.e(key, "key");
        Intrinsics.e(modelClass, "modelClass");
        T viewModel = (T) this.store.get(key);
        if (!modelClass.isInstance(viewModel)) {
            Factory factory = this.factory;
            ViewModel viewModel2 = factory instanceof KeyedFactory ? ((KeyedFactory) factory).create(key, modelClass) : factory.create(modelClass);
            this.store.put(key, viewModel2);
            Intrinsics.c(viewModel2, "viewModel");
            return (T) viewModel2;
        }
        Factory factory2 = this.factory;
        OnRequeryFactory onRequeryFactory = factory2 instanceof OnRequeryFactory ? (OnRequeryFactory) factory2 : null;
        if (onRequeryFactory != null) {
            Intrinsics.c(viewModel, "viewModel");
            onRequeryFactory.onRequery(viewModel);
        }
        if (viewModel != null) {
            return viewModel;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
    }
}
