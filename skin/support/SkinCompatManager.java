package skin.support;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import skin.support.app.SkinActivityLifecycle;
import skin.support.app.SkinLayoutInflater;
import skin.support.app.SkinWrapper;
import skin.support.content.res.SkinCompatResources;
import skin.support.load.SkinAssetsLoader;
import skin.support.load.SkinBuildInLoader;
import skin.support.load.SkinNoneLoader;
import skin.support.load.SkinPrefixBuildInLoader;
import skin.support.observe.SkinObservable;
import skin.support.utils.SkinPreference;

/* loaded from: source-3503164-dex2jar.jar:skin/support/SkinCompatManager.class */
public class SkinCompatManager extends SkinObservable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile SkinCompatManager f44189a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f44190c;
    private final Object b = new Object();
    private boolean d = false;
    private List<SkinWrapper> e = new ArrayList();
    private List<SkinLayoutInflater> f = new ArrayList();
    private List<SkinLayoutInflater> g = new ArrayList();
    private SparseArray<SkinLoaderStrategy> h = new SparseArray<>();
    private boolean i = true;
    private boolean j = false;
    private boolean k = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:skin/support/SkinCompatManager$SkinLoadTask.class */
    public class SkinLoadTask extends AsyncTask<String, Void, String> {
        private final SkinLoaderListener b;

        /* renamed from: c  reason: collision with root package name */
        private final SkinLoaderStrategy f44192c;

        SkinLoadTask(SkinLoaderListener skinLoaderListener, SkinLoaderStrategy skinLoaderStrategy) {
            this.b = skinLoaderListener;
            this.f44192c = skinLoaderStrategy;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            synchronized (SkinCompatManager.this.b) {
                while (SkinCompatManager.this.d) {
                    try {
                        SkinCompatManager.this.b.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                SkinCompatManager.this.d = true;
            }
            try {
                if (strArr.length == 1) {
                    if (TextUtils.isEmpty(this.f44192c.a(SkinCompatManager.this.f44190c, strArr[0]))) {
                        SkinCompatResources.a().a(this.f44192c);
                        return "";
                    }
                    return strArr[0];
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            SkinCompatResources.a().b();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            synchronized (SkinCompatManager.this.b) {
                if (str != null) {
                    SkinPreference.a().a(str).a(this.f44192c.getType()).e();
                    SkinCompatManager.this.j();
                    if (this.b != null) {
                        this.b.b();
                    }
                } else {
                    SkinPreference.a().a("").a(-1).e();
                    if (this.b != null) {
                        this.b.a("皮肤资源获取失败");
                    }
                }
                SkinCompatManager.this.d = false;
                SkinCompatManager.this.b.notifyAll();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            SkinLoaderListener skinLoaderListener = this.b;
            if (skinLoaderListener != null) {
                skinLoaderListener.a();
            }
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:skin/support/SkinCompatManager$SkinLoaderListener.class */
    public interface SkinLoaderListener {
        void a();

        void a(String str);

        void b();
    }

    /* loaded from: source-3503164-dex2jar.jar:skin/support/SkinCompatManager$SkinLoaderStrategy.class */
    public interface SkinLoaderStrategy {
        String a(Context context, String str);

        String a(Context context, String str, int i);

        ColorStateList b(Context context, String str, int i);

        ColorStateList c(Context context, String str, int i);

        Drawable d(Context context, String str, int i);

        int getType();
    }

    private SkinCompatManager(Context context) {
        this.f44190c = context.getApplicationContext();
        k();
    }

    public static SkinCompatManager a() {
        return f44189a;
    }

    public static SkinCompatManager a(Application application) {
        a((Context) application);
        SkinActivityLifecycle.a(application);
        return f44189a;
    }

    public static SkinCompatManager a(Context context) {
        if (f44189a == null) {
            synchronized (SkinCompatManager.class) {
                try {
                    if (f44189a == null) {
                        f44189a = new SkinCompatManager(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        SkinPreference.a(context);
        return f44189a;
    }

    private void k() {
        this.h.put(-1, new SkinNoneLoader());
        this.h.put(0, new SkinAssetsLoader());
        this.h.put(1, new SkinBuildInLoader());
        this.h.put(2, new SkinPrefixBuildInLoader());
    }

    public AsyncTask a(String str, int i) {
        return a(str, null, i);
    }

    public AsyncTask a(String str, SkinLoaderListener skinLoaderListener, int i) {
        SkinLoaderStrategy skinLoaderStrategy = this.h.get(i);
        if (skinLoaderStrategy == null) {
            return null;
        }
        return new SkinLoadTask(skinLoaderListener, skinLoaderStrategy).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
    }

    public String a(String str) {
        return this.f44190c.getPackageManager().getPackageArchiveInfo(str, 1).packageName;
    }

    public SkinCompatManager a(SkinLayoutInflater skinLayoutInflater) {
        if (skinLayoutInflater instanceof SkinWrapper) {
            this.e.add((SkinWrapper) skinLayoutInflater);
        }
        this.f.add(skinLayoutInflater);
        return this;
    }

    public SkinCompatManager a(boolean z) {
        this.i = z;
        return this;
    }

    public Resources b(String str) {
        try {
            PackageInfo packageArchiveInfo = this.f44190c.getPackageManager().getPackageArchiveInfo(str, 0);
            packageArchiveInfo.applicationInfo.sourceDir = str;
            packageArchiveInfo.applicationInfo.publicSourceDir = str;
            Resources resourcesForApplication = this.f44190c.getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo);
            Resources resources = this.f44190c.getResources();
            return new Resources(resourcesForApplication.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SparseArray<SkinLoaderStrategy> b() {
        return this.h;
    }

    @Deprecated
    public SkinCompatManager b(boolean z) {
        this.j = z;
        return this;
    }

    public List<SkinWrapper> c() {
        return this.e;
    }

    public SkinCompatManager c(boolean z) {
        this.k = z;
        return this;
    }

    public List<SkinLayoutInflater> d() {
        return this.f;
    }

    @Deprecated
    public List<SkinLayoutInflater> e() {
        return this.g;
    }

    public void f() {
        a("", -1);
    }

    public boolean g() {
        return this.i;
    }

    public Context getContext() {
        return this.f44190c;
    }

    public boolean h() {
        return this.k;
    }

    public AsyncTask i() {
        String b = SkinPreference.a().b();
        int c2 = SkinPreference.a().c();
        if (TextUtils.isEmpty(b) || c2 == -1) {
            return null;
        }
        return a(b, null, c2);
    }
}
