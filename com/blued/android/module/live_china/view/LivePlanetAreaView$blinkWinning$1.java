package com.blued.android.module.live_china.view;

import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.databinding.LivePlanetAreaItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePlanetAreaView$blinkWinning$1.class */
public final class LivePlanetAreaView$blinkWinning$1 implements ImageLoader.OnAnimationStateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivePlanetAreaView f14860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LivePlanetAreaView$blinkWinning$1(LivePlanetAreaView livePlanetAreaView) {
        this.f14860a = livePlanetAreaView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetAreaView this$0) {
        LivePlanetAreaItemBinding livePlanetAreaItemBinding;
        Intrinsics.e(this$0, "this$0");
        livePlanetAreaItemBinding = this$0.i;
        ImageView imageView = livePlanetAreaItemBinding.h;
        Intrinsics.c(imageView, "vb.ivLotteryBorder");
        BluedViewExKt.a(imageView);
    }

    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
    public void a() {
        this.f14860a.b(1);
    }

    @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
    public void b() {
        LivePlanetAreaItemBinding livePlanetAreaItemBinding;
        LivePlanetAreaItemBinding livePlanetAreaItemBinding2;
        IRequestHost iRequestHost;
        LivePlanetAreaItemBinding livePlanetAreaItemBinding3;
        livePlanetAreaItemBinding = this.f14860a.i;
        ImageView imageView = livePlanetAreaItemBinding.i;
        Intrinsics.c(imageView, "vb.ivLotteryBorderJack");
        BluedViewExKt.b(imageView);
        livePlanetAreaItemBinding2 = this.f14860a.i;
        ImageView imageView2 = livePlanetAreaItemBinding2.i;
        final LivePlanetAreaView livePlanetAreaView = this.f14860a;
        imageView2.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetAreaView$blinkWinning$1$aA11goUAUYzfYOirMcuq6oLoQfs
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetAreaView$blinkWinning$1.a(LivePlanetAreaView.this);
            }
        });
        iRequestHost = this.f14860a.b;
        ImageWrapper a2 = ImageLoader.c(iRequestHost, "live_planet_winning_flow.png").g().g(-1).a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.live_china.view.LivePlanetAreaView$blinkWinning$1$onAnimationEnd$2
            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void a() {
            }

            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void b() {
            }
        });
        livePlanetAreaItemBinding3 = this.f14860a.i;
        a2.a(livePlanetAreaItemBinding3.i);
    }
}
