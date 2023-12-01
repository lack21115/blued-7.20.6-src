package skin.support.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import skin.support.SkinCompatManager;
import skin.support.annotation.Skinable;
import skin.support.content.res.SkinCompatResources;
import skin.support.content.res.SkinCompatThemeUtils;
import skin.support.observe.SkinObservable;
import skin.support.observe.SkinObserver;
import skin.support.utils.Slog;
import skin.support.view.LayoutInflaterCompat;
import skin.support.widget.SkinCompatHelper;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-3503164-dex2jar.jar:skin/support/app/SkinActivityLifecycle.class */
public class SkinActivityLifecycle implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static volatile SkinActivityLifecycle f44193a;
    private WeakHashMap<Context, SkinCompatDelegate> b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<Context, LazySkinObserver> f44194c;
    private WeakReference<Activity> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:skin/support/app/SkinActivityLifecycle$LazySkinObserver.class */
    public class LazySkinObserver implements SkinObserver {
        private final Context b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f44196c = false;

        LazySkinObserver(Context context) {
            this.b = context;
        }

        void a() {
            if (this.f44196c) {
                b();
            }
        }

        @Override // skin.support.observe.SkinObserver
        public void a(SkinObservable skinObservable, Object obj) {
            if (SkinActivityLifecycle.this.d == null || this.b == SkinActivityLifecycle.this.d.get() || !(this.b instanceof Activity)) {
                b();
            } else {
                this.f44196c = true;
            }
        }

        void b() {
            if (Slog.f44252a) {
                Slog.a("SkinActivityLifecycle", "Context: " + this.b + " updateSkinForce");
            }
            Context context = this.b;
            if (context == null) {
                return;
            }
            if ((context instanceof Activity) && SkinActivityLifecycle.this.d(context)) {
                SkinActivityLifecycle.this.a((Activity) this.b);
            }
            SkinActivityLifecycle.this.b(this.b).a();
            Context context2 = this.b;
            if (context2 instanceof SkinCompatSupportable) {
                ((SkinCompatSupportable) context2).applySkin();
            }
            this.f44196c = false;
        }
    }

    private SkinActivityLifecycle(Application application) {
        application.registerActivityLifecycleCallbacks(this);
        a((Context) application);
        SkinCompatManager.a().a((SkinObserver) c(application));
    }

    public static SkinActivityLifecycle a(Application application) {
        if (f44193a == null) {
            synchronized (SkinActivityLifecycle.class) {
                try {
                    if (f44193a == null) {
                        f44193a = new SkinActivityLifecycle(application);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f44193a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        Drawable e;
        if (SkinCompatManager.a().h()) {
            int b = SkinCompatThemeUtils.b(activity);
            if (SkinCompatHelper.b(b) == 0 || (e = SkinCompatResources.e(activity, b)) == null) {
                return;
            }
            activity.getWindow().setBackgroundDrawable(e);
        }
    }

    private void a(Context context) {
        try {
            LayoutInflaterCompat.a(LayoutInflater.from(context), b(context));
        } catch (Throwable th) {
            Slog.a("SkinActivity", "A factory has already been set on this LayoutInflater");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SkinCompatDelegate b(Context context) {
        if (this.b == null) {
            this.b = new WeakHashMap<>();
        }
        SkinCompatDelegate skinCompatDelegate = this.b.get(context);
        SkinCompatDelegate skinCompatDelegate2 = skinCompatDelegate;
        if (skinCompatDelegate == null) {
            skinCompatDelegate2 = SkinCompatDelegate.a(context);
            this.b.put(context, skinCompatDelegate2);
        }
        return skinCompatDelegate2;
    }

    private LazySkinObserver c(Context context) {
        if (this.f44194c == null) {
            this.f44194c = new WeakHashMap<>();
        }
        LazySkinObserver lazySkinObserver = this.f44194c.get(context);
        LazySkinObserver lazySkinObserver2 = lazySkinObserver;
        if (lazySkinObserver == null) {
            lazySkinObserver2 = new LazySkinObserver(context);
            this.f44194c.put(context, lazySkinObserver2);
        }
        return lazySkinObserver2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(Context context) {
        return SkinCompatManager.a().g() || context.getClass().getAnnotation(Skinable.class) != null || (context instanceof SkinCompatSupportable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (d(activity)) {
            a((Context) activity);
            a(activity);
            if (activity instanceof SkinCompatSupportable) {
                ((SkinCompatSupportable) activity).applySkin();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (d(activity)) {
            SkinCompatManager.a().b(c(activity));
            this.f44194c.remove(activity);
            this.b.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.d = new WeakReference<>(activity);
        if (d(activity)) {
            LazySkinObserver c2 = c(activity);
            SkinCompatManager.a().a((SkinObserver) c2);
            c2.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
