package com.soft.blued.ui.welcome;

import android.widget.ImageView;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.databinding.FragmentBluedInterstitialBinding;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.welcome.model.TwoFloorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/BluedInterstitialFragment$loadPic$1$1$1$1.class */
public final class BluedInterstitialFragment$loadPic$1$1$1$1 extends ImageLoadResult {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BluedInterstitialFragment f20829a;
    final /* synthetic */ TwoFloorModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluedInterstitialFragment$loadPic$1$1$1$1(BluedInterstitialFragment bluedInterstitialFragment, TwoFloorModel twoFloorModel, ActivityFragmentActive activityFragmentActive) {
        super((IRequestHost) activityFragmentActive);
        this.f20829a = bluedInterstitialFragment;
        this.b = twoFloorModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BluedInterstitialFragment bluedInterstitialFragment) {
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding;
        ImageView imageView;
        Intrinsics.e(bluedInterstitialFragment, "this$0");
        fragmentBluedInterstitialBinding = bluedInterstitialFragment.b;
        if (fragmentBluedInterstitialBinding == null || (imageView = fragmentBluedInterstitialBinding.b) == null) {
            return;
        }
        imageView.performClick();
    }

    public void a() {
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding;
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding2;
        FragmentBluedInterstitialBinding fragmentBluedInterstitialBinding3;
        fragmentBluedInterstitialBinding = this.f20829a.b;
        ShapeTextView shapeTextView = fragmentBluedInterstitialBinding == null ? null : fragmentBluedInterstitialBinding.f15098a;
        if (shapeTextView != null) {
            shapeTextView.setVisibility(0);
        }
        if (this.b.is_show_adm_icon == 1) {
            fragmentBluedInterstitialBinding3 = this.f20829a.b;
            ShapeTextView shapeTextView2 = fragmentBluedInterstitialBinding3 == null ? null : fragmentBluedInterstitialBinding3.f15099c;
            if (shapeTextView2 != null) {
                shapeTextView2.setVisibility(0);
            }
        } else {
            fragmentBluedInterstitialBinding2 = this.f20829a.b;
            ShapeTextView shapeTextView3 = fragmentBluedInterstitialBinding2 == null ? null : fragmentBluedInterstitialBinding2.f15099c;
            if (shapeTextView3 != null) {
                shapeTextView3.setVisibility(8);
            }
        }
        FindHttpUtils.b(this.b.show_url);
        if (this.b.click_prob == 1) {
            final BluedInterstitialFragment bluedInterstitialFragment = this.f20829a;
            bluedInterstitialFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.welcome.-$$Lambda$BluedInterstitialFragment$loadPic$1$1$1$1$ZckbLpg1hDXrzkiWdSpovliow9A
                @Override // java.lang.Runnable
                public final void run() {
                    BluedInterstitialFragment$loadPic$1$1$1$1.a(BluedInterstitialFragment.this);
                }
            }, 1000L);
        }
    }

    public void a(int i, Exception exc) {
        super.a(i, exc);
        this.f20829a.d();
    }
}
