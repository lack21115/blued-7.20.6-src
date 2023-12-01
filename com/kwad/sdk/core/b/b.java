package com.kwad.sdk.core.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.bj;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/b/b.class */
public class b implements c<Activity> {
    private static volatile b afQ;
    private static final List<c> mListeners = new CopyOnWriteArrayList();
    private final AtomicBoolean Ip = new AtomicBoolean(false);
    private Application mApplication;

    private b() {
    }

    public static void a(c cVar) {
        mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void a(com.kwad.sdk.e.a<c> aVar) {
        for (c cVar : mListeners) {
            if (cVar != null) {
                aVar.accept(cVar);
            }
        }
    }

    public static void b(c cVar) {
        mListeners.remove(cVar);
    }

    public static Activity getCurrentActivity() {
        if (vT()) {
            return KSLifecycleObserver.getInstance().getCurrentActivity();
        }
        if (a.vQ().isEnable()) {
            return a.vQ().getCurrentActivity();
        }
        return null;
    }

    public static boolean isAppOnForeground() {
        if (vT()) {
            return KSLifecycleObserver.getInstance().isAppOnForeground();
        }
        if (a.vQ().isEnable()) {
            return a.vQ().isAppOnForeground();
        }
        return false;
    }

    public static boolean isEnable() {
        return vT() || a.vQ().isEnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.b.c
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityCreated(activity, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.b.c
    public void onActivityDestroyed(final Activity activity) {
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityDestroyed(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.b.c
    public void onActivityPaused(final Activity activity) {
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityPaused(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.b.c
    public void onActivityResumed(final Activity activity) {
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: c */
            public void accept(c cVar) {
                cVar.onActivityResumed(activity);
            }
        });
    }

    public static b vS() {
        if (afQ == null) {
            synchronized (b.class) {
                try {
                    if (afQ == null) {
                        afQ = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return afQ;
    }

    public static boolean vT() {
        try {
            if (bj.aj(((e) ServiceProvider.get(e.class)).getApiVersion(), "3.3.26")) {
                return KSLifecycleObserver.getInstance().isEnable();
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public final Application getApplication() {
        return this.mApplication;
    }

    public final void init(Context context) {
        if (this.Ip.get() || context == null) {
            return;
        }
        this.Ip.set(true);
        try {
            if (bj.aj(((e) ServiceProvider.get(e.class)).getApiVersion(), "3.3.26")) {
                this.mApplication = KSLifecycleObserver.getInstance().getApplication();
                KSLifecycleObserver.getInstance().registerLifecycleListener(new KSLifecycleListener() { // from class: com.kwad.sdk.core.b.b.1
                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.1
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.e.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityCreated(activity, bundle);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityDestroyed(final Activity activity) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.4
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.e.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityDestroyed(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityPaused(final Activity activity) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.3
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.e.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityPaused(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityResumed(final Activity activity) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.2
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.e.a
                            /* renamed from: c */
                            public void accept(c cVar) {
                                cVar.onActivityResumed(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToBackground() {
                        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToBackground");
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.6
                            private static void c(c cVar) {
                                cVar.onBackToBackground();
                            }

                            @Override // com.kwad.sdk.e.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToForeground() {
                        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToForeground");
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.1.5
                            private static void c(c cVar) {
                                cVar.onBackToForeground();
                            }

                            @Override // com.kwad.sdk.e.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }
                });
            } else {
                com.kwad.sdk.core.d.b.z("LifecycleHolder", "init KSLifecycleObserver not support");
            }
        } catch (Throwable th) {
        }
        Application FP = k.FP();
        if (FP != null) {
            this.mApplication = FP;
            a.vQ().init(this.mApplication);
            a.vQ().a(this);
        }
    }

    @Override // com.kwad.sdk.core.b.c
    public void onBackToBackground() {
        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToBackground old");
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.7
            private static void c(c cVar) {
                cVar.onBackToBackground();
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onBackToForeground() {
        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToForeground old");
        a(new com.kwad.sdk.e.a<c>() { // from class: com.kwad.sdk.core.b.b.6
            private static void c(c cVar) {
                cVar.onBackToForeground();
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }
}
