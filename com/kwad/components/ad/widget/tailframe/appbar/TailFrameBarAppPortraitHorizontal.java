package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/widget/tailframe/appbar/TailFrameBarAppPortraitHorizontal.class */
public class TailFrameBarAppPortraitHorizontal extends a {
    public TailFrameBarAppPortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void bindView(AdTemplate adTemplate) {
        if (d.p(adTemplate)) {
            this.FY.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            this.lw.setTextColor(Color.parseColor("#FFFFFF"));
            this.Hi.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.FY.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        super.bindView(adTemplate);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_portrait_horizontal;
    }
}
