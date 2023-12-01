package com.blued.android.module.yy_china.adapter;

import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.databinding.ItemYyConnectingRobLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRobMusicAdapter$lightSingger$1$2.class */
public final class YYRobMusicAdapter$lightSingger$1$2 implements SVGAParser.ParseCompletion {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ YYRobMusicAdapter f16222a;

    @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
    public void onComplete(SVGAVideoEntity videoItem) {
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding;
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding2;
        ItemYyConnectingRobLayoutBinding itemYyConnectingRobLayoutBinding3;
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        Intrinsics.e(videoItem, "videoItem");
        itemYyConnectingRobLayoutBinding = this.f16222a.b;
        SVGAImageView sVGAImageView3 = itemYyConnectingRobLayoutBinding == null ? null : itemYyConnectingRobLayoutBinding.y;
        if (sVGAImageView3 != null) {
            sVGAImageView3.setLoops(1);
        }
        itemYyConnectingRobLayoutBinding2 = this.f16222a.b;
        if (itemYyConnectingRobLayoutBinding2 != null && (sVGAImageView2 = itemYyConnectingRobLayoutBinding2.y) != null) {
            sVGAImageView2.setImageDrawable(new SVGADrawable(videoItem));
        }
        itemYyConnectingRobLayoutBinding3 = this.f16222a.b;
        if (itemYyConnectingRobLayoutBinding3 == null || (sVGAImageView = itemYyConnectingRobLayoutBinding3.y) == null) {
            return;
        }
        sVGAImageView.a();
    }

    @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
    public void onError() {
    }
}
