package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentController.class */
public class FragmentController {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentHostCallback<?> f2910a;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f2910a = fragmentHostCallback;
    }

    public static FragmentController createController(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    public void attachHost(Fragment fragment) {
        FragmentManager fragmentManager = this.f2910a.b;
        FragmentHostCallback<?> fragmentHostCallback = this.f2910a;
        fragmentManager.a(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.f2910a.b.p();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.f2910a.b.a(configuration);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.f2910a.b.b(menuItem);
    }

    public void dispatchCreate() {
        this.f2910a.b.n();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.f2910a.b.a(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.f2910a.b.v();
    }

    public void dispatchDestroyView() {
        this.f2910a.b.u();
    }

    public void dispatchLowMemory() {
        this.f2910a.b.w();
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        this.f2910a.b.b(z);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.f2910a.b.a(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.f2910a.b.b(menu);
    }

    public void dispatchPause() {
        this.f2910a.b.s();
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.f2910a.b.c(z);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.f2910a.b.a(menu);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.f2910a.b.r();
    }

    public void dispatchStart() {
        this.f2910a.b.q();
    }

    public void dispatchStop() {
        this.f2910a.b.t();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    @Deprecated
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.f2910a.b.a(true);
    }

    public Fragment findFragmentByWho(String str) {
        return this.f2910a.b.a(str);
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        return this.f2910a.b.b();
    }

    public int getActiveFragmentsCount() {
        return this.f2910a.b.c();
    }

    public FragmentManager getSupportFragmentManager() {
        return this.f2910a.b;
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.f2910a.b.l();
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2910a.b.B().onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f2910a.b.a(parcelable, fragmentManagerNonConfig);
    }

    @Deprecated
    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.f2910a.b.a(parcelable, new FragmentManagerNonConfig(list, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    public void restoreSaveState(Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.f2910a;
        if (!(fragmentHostCallback instanceof ViewModelStoreOwner)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        fragmentHostCallback.b.a(parcelable);
    }

    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.f2910a.b.f();
    }

    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig f = this.f2910a.b.f();
        if (f == null || f.a() == null) {
            return null;
        }
        return new ArrayList(f.a());
    }

    public Parcelable saveAllState() {
        return this.f2910a.b.g();
    }
}
