package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/loader/app/LoaderManagerImpl.class */
public class LoaderManagerImpl extends LoaderManager {

    /* renamed from: a  reason: collision with root package name */
    static boolean f3074a = false;
    private final LifecycleOwner b;

    /* renamed from: c  reason: collision with root package name */
    private final LoaderViewModel f3075c;

    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/app/LoaderManagerImpl$LoaderInfo.class */
    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        /* renamed from: a  reason: collision with root package name */
        private final int f3076a;
        private final Bundle b;

        /* renamed from: c  reason: collision with root package name */
        private final Loader<D> f3077c;
        private LifecycleOwner d;
        private LoaderObserver<D> e;
        private Loader<D> f;

        LoaderInfo(int i, Bundle bundle, Loader<D> loader, Loader<D> loader2) {
            this.f3076a = i;
            this.b = bundle;
            this.f3077c = loader;
            this.f = loader2;
            loader.registerListener(i, this);
        }

        Loader<D> a() {
            return this.f3077c;
        }

        Loader<D> a(LifecycleOwner lifecycleOwner, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.f3077c, loaderCallbacks);
            observe(lifecycleOwner, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.e;
            if (loaderObserver2 != null) {
                removeObserver(loaderObserver2);
            }
            this.d = lifecycleOwner;
            this.e = loaderObserver;
            return this.f3077c;
        }

        Loader<D> a(boolean z) {
            if (LoaderManagerImpl.f3074a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f3077c.cancelLoad();
            this.f3077c.abandon();
            LoaderObserver<D> loaderObserver = this.e;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (z) {
                    loaderObserver.b();
                }
            }
            this.f3077c.unregisterListener(this);
            if ((loaderObserver == null || loaderObserver.a()) && !z) {
                return this.f3077c;
            }
            this.f3077c.reset();
            return this.f;
        }

        void b() {
            LifecycleOwner lifecycleOwner = this.d;
            LoaderObserver<D> loaderObserver = this.e;
            if (lifecycleOwner == null || loaderObserver == null) {
                return;
            }
            super.removeObserver(loaderObserver);
            observe(lifecycleOwner, loaderObserver);
        }

        boolean c() {
            if (hasActiveObservers()) {
                LoaderObserver<D> loaderObserver = this.e;
                boolean z = false;
                if (loaderObserver != null) {
                    z = false;
                    if (!loaderObserver.a()) {
                        z = true;
                    }
                }
                return z;
            }
            return false;
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3076a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3077c);
            Loader<D> loader = this.f3077c;
            loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.e);
                LoaderObserver<D> loaderObserver = this.e;
                loaderObserver.dump(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(a().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            if (LoaderManagerImpl.f3074a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f3077c.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            if (LoaderManagerImpl.f3074a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f3077c.stopLoading();
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(Loader<D> loader, D d) {
            if (LoaderManagerImpl.f3074a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
                return;
            }
            if (LoaderManagerImpl.f3074a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(Observer<? super D> observer) {
            super.removeObserver(observer);
            this.d = null;
            this.e = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D d) {
            super.setValue(d);
            Loader<D> loader = this.f;
            if (loader != null) {
                loader.reset();
                this.f = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f3076a);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.f3077c, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/app/LoaderManagerImpl$LoaderObserver.class */
    public static class LoaderObserver<D> implements Observer<D> {

        /* renamed from: a  reason: collision with root package name */
        private final Loader<D> f3078a;
        private final LoaderManager.LoaderCallbacks<D> b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3079c = false;

        LoaderObserver(Loader<D> loader, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.f3078a = loader;
            this.b = loaderCallbacks;
        }

        boolean a() {
            return this.f3079c;
        }

        void b() {
            if (this.f3079c) {
                if (LoaderManagerImpl.f3074a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f3078a);
                }
                this.b.onLoaderReset(this.f3078a);
            }
        }

        public void dump(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f3079c);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(D d) {
            if (LoaderManagerImpl.f3074a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f3078a + ": " + this.f3078a.dataToString(d));
            }
            this.b.onLoadFinished(this.f3078a, d);
            this.f3079c = true;
        }

        public String toString() {
            return this.b.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/app/LoaderManagerImpl$LoaderViewModel.class */
    public static class LoaderViewModel extends ViewModel {

        /* renamed from: a  reason: collision with root package name */
        private static final ViewModelProvider.Factory f3080a = new ViewModelProvider.Factory() { // from class: androidx.loader.app.LoaderManagerImpl.LoaderViewModel.1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        private SparseArrayCompat<LoaderInfo> b = new SparseArrayCompat<>();

        /* renamed from: c  reason: collision with root package name */
        private boolean f3081c = false;

        LoaderViewModel() {
        }

        static LoaderViewModel a(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, f3080a).get(LoaderViewModel.class);
        }

        <D> LoaderInfo<D> a(int i) {
            return this.b.get(i);
        }

        void a() {
            this.f3081c = true;
        }

        void a(int i, LoaderInfo loaderInfo) {
            this.b.put(i, loaderInfo);
        }

        void b(int i) {
            this.b.remove(i);
        }

        boolean b() {
            return this.f3081c;
        }

        void c() {
            this.f3081c = false;
        }

        boolean d() {
            int size = this.b.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return false;
                }
                if (this.b.valueAt(i2).c()) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.size() <= 0) {
                return;
            }
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    return;
                }
                LoaderInfo valueAt = this.b.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                i = i2 + 1;
            }
        }

        void e() {
            int size = this.b.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                this.b.valueAt(i2).b();
                i = i2 + 1;
            }
        }

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int size = this.b.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    this.b.clear();
                    return;
                } else {
                    this.b.valueAt(i2).a(true);
                    i = i2 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.b = lifecycleOwner;
        this.f3075c = LoaderViewModel.a(viewModelStore);
    }

    private <D> Loader<D> a(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks, Loader<D> loader) {
        try {
            this.f3075c.a();
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                }
                LoaderInfo loaderInfo = new LoaderInfo(i, bundle, onCreateLoader, loader);
                if (f3074a) {
                    Log.v("LoaderManager", "  Created new loader " + loaderInfo);
                }
                this.f3075c.a(i, loaderInfo);
                this.f3075c.c();
                return loaderInfo.a(this.b, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f3075c.c();
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    public void destroyLoader(int i) {
        if (this.f3075c.b()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        if (f3074a) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
        }
        LoaderInfo a2 = this.f3075c.a(i);
        if (a2 != null) {
            a2.a(true);
            this.f3075c.b(i);
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3075c.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.LoaderManager
    public <D> Loader<D> getLoader(int i) {
        if (this.f3075c.b()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo<D> a2 = this.f3075c.a(i);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        return this.f3075c.d();
    }

    @Override // androidx.loader.app.LoaderManager
    public <D> Loader<D> initLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f3075c.b()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderInfo<D> a2 = this.f3075c.a(i);
            if (f3074a) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (a2 == null) {
                return a(i, bundle, loaderCallbacks, null);
            }
            if (f3074a) {
                Log.v("LoaderManager", "  Re-using existing loader " + a2);
            }
            return a2.a(this.b, loaderCallbacks);
        }
        throw new IllegalStateException("initLoader must be called on the main thread");
    }

    @Override // androidx.loader.app.LoaderManager
    public void markForRedelivery() {
        this.f3075c.e();
    }

    @Override // androidx.loader.app.LoaderManager
    public <D> Loader<D> restartLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f3075c.b()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f3074a) {
                Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
            }
            LoaderInfo<D> a2 = this.f3075c.a(i);
            Loader<D> loader = null;
            if (a2 != null) {
                loader = a2.a(false);
            }
            return a(i, bundle, loaderCallbacks, loader);
        }
        throw new IllegalStateException("restartLoader must be called on the main thread");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.b, sb);
        sb.append("}}");
        return sb.toString();
    }
}
