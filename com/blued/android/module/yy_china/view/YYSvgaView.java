package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import com.blued.android.module.svgaplayer.SVGAImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSvgaView.class */
public final class YYSvgaView extends SVGAImageView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYSvgaView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYSvgaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYSvgaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
    }

    @Override // com.blued.android.module.svgaplayer.SVGAImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
    }
}
