package com.soft.blued.ui.welcome.manager;

import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.ui.welcome.manager.PicSplashManager;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/PicSplashManager.class */
public class PicSplashManager extends SplashAdManagerAdapter {

    /* renamed from: com.soft.blued.ui.welcome.manager.PicSplashManager$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/PicSplashManager$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IRequestHost f20960a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SplashAdListener f20961c;
        final /* synthetic */ ImageView d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(SplashAdListener splashAdListener, View view) {
            Tracker.onClick(view);
            splashAdListener.c();
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageLoader.a(this.f20960a, this.b).a(new ImageLoadResult(this.f20960a) { // from class: com.soft.blued.ui.welcome.manager.PicSplashManager.1.1
                public void a() {
                    AnonymousClass1.this.f20961c.b();
                }

                public void a(int i, Exception exc) {
                    AnonymousClass1.this.f20961c.a(i, exc.toString());
                }
            }).a(this.d);
            ImageView imageView = this.d;
            final SplashAdListener splashAdListener = this.f20961c;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.manager.-$$Lambda$PicSplashManager$1$LMtrDWKPxi8VxFnFqYWqWlRaouA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PicSplashManager.AnonymousClass1.a(SplashAdListener.this, view);
                }
            });
        }
    }
}
