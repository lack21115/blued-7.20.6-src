package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRoomFullSvgaAniView.class */
public final class YYRoomFullSvgaAniView extends SVGAImageView implements SVGACallback {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<YYRoomFullSvgaMode> f18447a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRoomFullSvgaAniView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRoomFullSvgaAniView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRoomFullSvgaAniView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f18447a = new ArrayList<>();
        setCallback(this);
    }

    public final void a(YYRoomFullSvgaMode da) {
        Intrinsics.e(da, "da");
        this.f18447a.add(da);
        if (this.f18447a.size() < 2) {
            f();
        }
    }

    public final void f() {
        if (this.f18447a.size() > 0) {
            YYRoomFullSvgaMode yYRoomFullSvgaMode = this.f18447a.get(0);
            Intrinsics.c(yYRoomFullSvgaMode, "mSvgaDatas[0]");
            YYRoomFullSvgaMode yYRoomFullSvgaMode2 = yYRoomFullSvgaMode;
            SVGAPlayer.Builder a2 = new SVGAPlayer.Builder(yYRoomFullSvgaMode2.getUrl()).a((Integer) 1).a(SVGAImageView.FillMode.Clear);
            setBackgroundResource(R.color.transparent);
            if (yYRoomFullSvgaMode2.getType() == 1) {
                setCallback(this);
                setBackgroundResource(R.color.black_alpha70);
            }
            SVGADynamicEntity svgaDynamic = yYRoomFullSvgaMode2.getSvgaDynamic();
            if (svgaDynamic == null) {
                a2.a(this);
            } else {
                a2.a(this, svgaDynamic);
            }
        }
    }

    @Override // com.blued.android.module.svgaplayer.SVGACallback
    public void onFinished() {
        setBackgroundResource(R.color.transparent);
        if (this.f18447a.size() > 0) {
            this.f18447a.remove(0);
            f();
        }
    }

    @Override // com.blued.android.module.svgaplayer.SVGACallback
    public void onPause() {
    }

    @Override // com.blued.android.module.svgaplayer.SVGACallback
    public void onRepeat() {
    }

    @Override // com.blued.android.module.svgaplayer.SVGACallback
    public void onStep(int i, double d) {
    }
}
