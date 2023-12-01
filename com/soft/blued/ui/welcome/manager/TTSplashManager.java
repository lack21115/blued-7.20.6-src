package com.soft.blued.ui.welcome.manager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.soft.blued.utils.third.TTADUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/TTSplashManager.class */
public class TTSplashManager extends SplashAdManagerAdapter {

    /* renamed from: com.soft.blued.ui.welcome.manager.TTSplashManager$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/TTSplashManager$1.class */
    class AnonymousClass1 implements TTADUtils.TTGetSplashAdListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f34658a = false;
        final /* synthetic */ SplashAdListener b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f34659c;
        final /* synthetic */ ViewGroup d;

        AnonymousClass1(SplashAdListener splashAdListener, Context context, ViewGroup viewGroup) {
            this.b = splashAdListener;
            this.f34659c = context;
            this.d = viewGroup;
        }

        @Override // com.soft.blued.utils.third.TTADUtils.TTGetSplashAdListener
        public void a() {
            if (this.f34658a) {
                return;
            }
            this.b.a(0, "onNoAD");
        }

        @Override // com.soft.blued.utils.third.TTADUtils.TTGetSplashAdListener
        public void a(int i, String str) {
            if (this.f34658a) {
                return;
            }
            this.b.a(i, str);
        }

        @Override // com.soft.blued.utils.third.TTADUtils.TTGetSplashAdListener
        public void a(TTSplashAd tTSplashAd) {
            this.f34658a = true;
            this.b.a();
            View splashView = tTSplashAd.getSplashView();
            FragmentActivity fragmentActivity = (FragmentActivity) this.f34659c;
            if (splashView != null && this.d != null && fragmentActivity != null && !fragmentActivity.isFinishing()) {
                this.d.removeAllViews();
                this.d.addView(splashView);
            }
            tTSplashAd.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() { // from class: com.soft.blued.ui.welcome.manager.TTSplashManager.1.1
                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdClicked(View view, int i) {
                    AnonymousClass1.this.b.c();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdShow(View view, int i) {
                    AnonymousClass1.this.b.b();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdSkip() {
                    AnonymousClass1.this.b.d();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdTimeOver() {
                    if (AnonymousClass1.this.f34658a) {
                        return;
                    }
                    AnonymousClass1.this.b.a(0, "");
                }
            });
        }
    }

    @Override // com.soft.blued.ui.welcome.manager.SplashAdManagerAdapter, com.soft.blued.ui.welcome.manager.SplashAdManager
    public void a(Context context, String str, ViewGroup viewGroup, IRequestHost iRequestHost, SplashAdListener splashAdListener) {
        TTADUtils.a(context, str, new AnonymousClass1(splashAdListener, context, viewGroup));
    }
}
