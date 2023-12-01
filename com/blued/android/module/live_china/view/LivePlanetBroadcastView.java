package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LivePlanetBroadcastBinding;
import com.blued.android.module.live_china.model.PlanetBroadcastModel;
import com.blued.android.module.live_china.utils.LiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePlanetBroadcastView.class */
public final class LivePlanetBroadcastView extends FrameLayout {
    private final Context a;
    private final LivePlanetBroadcastBinding b;
    private ArrayList<PlanetBroadcastModel> c;
    private int d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePlanetBroadcastView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePlanetBroadcastView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePlanetBroadcastView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        LivePlanetBroadcastBinding a = LivePlanetBroadcastBinding.a(LayoutInflater.from(mContext).inflate(R.layout.live_planet_broadcast, this));
        Intrinsics.c(a, "bind(\n        LayoutInfl…et_broadcast, this)\n    )");
        this.b = a;
        this.d = -1;
    }

    public /* synthetic */ LivePlanetBroadcastView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a() {
        String nextText = getNextText();
        if (nextText == null) {
            animate().alpha(0.0f).setDuration(300L).setStartDelay(0L).start();
            return;
        }
        String str = nextText;
        if (str.length() == 0) {
            a();
            return;
        }
        this.b.b.setText(str);
        this.b.b.setText(LiveUtils.a(this.b.b.getText(), "#FFEF5F", false));
        this.b.b.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetBroadcastView$xdS6kpPZkwHDdfZerrqdT9G7D0g
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetBroadcastView.c(LivePlanetBroadcastView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final float f, final float f2, final LivePlanetBroadcastView this$0, final float f3) {
        float b;
        float f4;
        Intrinsics.e(this$0, "this$0");
        if (f <= f2) {
            if (this$0.b()) {
                this$0.b.b.animate().alpha(0.0f).translationY(0 - (f3 * 0.3f)).setDuration(200L).setStartDelay(800L).setInterpolator(new AccelerateInterpolator(1.5f)).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetBroadcastView$YxEGIpQeUm0fnw-k-TIoqNpOTtc
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePlanetBroadcastView.b(LivePlanetBroadcastView.this);
                    }
                }).start();
                return;
            } else {
                this$0.animate().alpha(0.0f).setDuration(300L).setStartDelay(800L).start();
                return;
            }
        }
        float f5 = f - f2;
        if (f5 < f2 / 3) {
            b = DensityUtils.b(this$0.getContext(), f5);
            f4 = 35.0f;
        } else {
            b = DensityUtils.b(this$0.getContext(), f5);
            f4 = 20.0f;
        }
        final long j = b * f4;
        this$0.b.b.animate().cancel();
        this$0.b.b.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetBroadcastView$RDNw_t3TscrsQjXTvk1bOEjdZy0
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetBroadcastView.a(LivePlanetBroadcastView.this, f, f2, j, f3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetBroadcastView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LivePlanetBroadcastView this$0, float f) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.b()) {
            this$0.b.b.animate().alpha(0.0f).translationY(0 - (f * 0.3f)).setDuration(200L).setStartDelay(800L).setInterpolator(new AccelerateInterpolator(1.5f)).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetBroadcastView$1aAVPjFFEv9bOSixT70ope8nmj8
                @Override // java.lang.Runnable
                public final void run() {
                    LivePlanetBroadcastView.a(LivePlanetBroadcastView.this);
                }
            }).start();
        } else {
            this$0.animate().alpha(0.0f).setDuration(300L).setStartDelay(800L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LivePlanetBroadcastView this$0, float f, float f2, long j, final float f3) {
        Intrinsics.e(this$0, "this$0");
        this$0.b.b.animate().x(0 - (f - f2)).setDuration(j).setStartDelay(500L).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetBroadcastView$NQWygrlZliEiUhExrk6SJnzQ4-g
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetBroadcastView.a(LivePlanetBroadcastView.this, f3);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetBroadcastView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.a();
    }

    private final boolean b() {
        ArrayList<PlanetBroadcastModel> arrayList = this.c;
        boolean z = false;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        int i = this.d;
        ArrayList<PlanetBroadcastModel> arrayList2 = this.c;
        Intrinsics.a(arrayList2);
        if (i < arrayList2.size() - 1) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final LivePlanetBroadcastView this$0) {
        Intrinsics.e(this$0, "this$0");
        final float width = this$0.b.b.getWidth();
        final float height = this$0.b.b.getHeight();
        final float width2 = this$0.b.a.getWidth();
        this$0.b.b.setAlpha(0.0f);
        this$0.b.b.setTranslationX(0.0f);
        this$0.b.b.setTranslationY(0.3f * height);
        this$0.b.b.animate().alpha(1.0f).translationY(0.0f).setDuration(200L).setStartDelay(0L).setInterpolator(new DecelerateInterpolator(1.5f)).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetBroadcastView$2Soja7dOgzCnMJIFaH80KaxKUQI
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetBroadcastView.a(width, width2, this$0, height);
            }
        }).start();
    }

    private final String getNextText() {
        ArrayList<PlanetBroadcastModel> arrayList = this.c;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<PlanetBroadcastModel> arrayList2 = this.c;
        if (arrayList2 == null) {
            return "";
        }
        if (getMCurrentIndex() >= arrayList2.size() - 1) {
            return null;
        }
        setMCurrentIndex(getMCurrentIndex() + 1);
        Context d = AppInfo.d();
        int i = R.string.live_planet_dispatch_succeed;
        ArrayList<PlanetBroadcastModel> mData = getMData();
        Intrinsics.a(mData);
        String name = mData.get(getMCurrentIndex()).getName();
        ArrayList<PlanetBroadcastModel> mData2 = getMData();
        Intrinsics.a(mData2);
        String string = d.getString(i, name, mData2.get(getMCurrentIndex()).getText());
        Intrinsics.c(string, "getAppContext().getStrin…Index].text\n            )");
        return string;
    }

    public final Context getMContext() {
        return this.a;
    }

    public final int getMCurrentIndex() {
        return this.d;
    }

    public final ArrayList<PlanetBroadcastModel> getMData() {
        return this.c;
    }

    public final void setData(ArrayList<PlanetBroadcastModel> arrayList) {
        ArrayList<PlanetBroadcastModel> arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        this.b.b.getPaint().setFakeBoldText(true);
        this.b.b.setAlpha(0.0f);
        this.b.b.animate().cancel();
        this.d = -1;
        this.c = arrayList;
        a();
    }

    public final void setMCurrentIndex(int i) {
        this.d = i;
    }

    public final void setMData(ArrayList<PlanetBroadcastModel> arrayList) {
        this.c = arrayList;
    }
}
