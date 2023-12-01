package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/widget/tailframe/appbar/TailFrameBarAppLandscape.class */
public class TailFrameBarAppLandscape extends a {
    public TailFrameBarAppLandscape(Context context) {
        this(context, null);
    }

    public TailFrameBarAppLandscape(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppLandscape(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_landscape;
    }
}
