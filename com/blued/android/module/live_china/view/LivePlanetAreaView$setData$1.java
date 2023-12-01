package com.blued.android.module.live_china.view;

import android.widget.ImageView;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.databinding.LivePlanetAreaItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePlanetAreaView$setData$1.class */
public final class LivePlanetAreaView$setData$1 extends ImageLoadResult {
    final /* synthetic */ LivePlanetAreaView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePlanetAreaView$setData$1(LivePlanetAreaView livePlanetAreaView, IRequestHost iRequestHost) {
        super(iRequestHost);
        this.a = livePlanetAreaView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetAreaView this$0) {
        LivePlanetAreaItemBinding livePlanetAreaItemBinding;
        LivePlanetAreaItemBinding livePlanetAreaItemBinding2;
        LivePlanetAreaItemBinding livePlanetAreaItemBinding3;
        LivePlanetAreaItemBinding livePlanetAreaItemBinding4;
        LivePlanetAreaItemBinding livePlanetAreaItemBinding5;
        Intrinsics.e(this$0, "this$0");
        livePlanetAreaItemBinding = this$0.i;
        int width = livePlanetAreaItemBinding.j.getWidth();
        livePlanetAreaItemBinding2 = this$0.i;
        int width2 = width + livePlanetAreaItemBinding2.b.getWidth() + DensityUtils.a(this$0.getContext(), 1.9f);
        livePlanetAreaItemBinding3 = this$0.i;
        int width3 = livePlanetAreaItemBinding3.a.getWidth();
        if (width2 <= width3) {
            livePlanetAreaItemBinding5 = this$0.i;
            livePlanetAreaItemBinding5.k.setTranslationX(0.0f);
            return;
        }
        livePlanetAreaItemBinding4 = this$0.i;
        livePlanetAreaItemBinding4.k.setTranslationX(0 - ((width2 - width3) / 2));
    }

    @Override // com.blued.android.core.image.ImageLoadResult
    public void a() {
        LivePlanetAreaItemBinding livePlanetAreaItemBinding;
        livePlanetAreaItemBinding = this.a.i;
        ImageView imageView = livePlanetAreaItemBinding.j;
        final LivePlanetAreaView livePlanetAreaView = this.a;
        imageView.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetAreaView$setData$1$vJIUnIBoOWZfBgcLJJ3eSzwy2vY
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetAreaView$setData$1.a(LivePlanetAreaView.this);
            }
        });
    }

    @Override // com.blued.android.core.image.ImageLoadResult
    public void a(int i, Exception exc) {
        super.a(i, exc);
    }
}
