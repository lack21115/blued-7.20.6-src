package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRobMusicProgressBtnView.class */
public final class YYRobMusicProgressBtnView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private SVGAImageView f18438a;
    private RobMusicProgressBtn b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRobMusicProgressBtnView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRobMusicProgressBtnView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRobMusicProgressBtnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        Context context2 = getContext();
        Intrinsics.c(context2, "context");
        SVGAImageView sVGAImageView = new SVGAImageView(context2, null, 0, 6, null);
        this.f18438a = sVGAImageView;
        if (sVGAImageView != null) {
            sVGAImageView.setLoops(1);
        }
        SVGAImageView sVGAImageView2 = this.f18438a;
        if (sVGAImageView2 != null) {
            sVGAImageView2.setFillMode(SVGAImageView.FillMode.Forward);
        }
        Context context3 = getContext();
        Intrinsics.c(context3, "context");
        this.b = new RobMusicProgressBtn(context3);
        addView(this.f18438a, -1, -1);
        addView(this.b, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final YYRobMusicProgressBtnView this$0) {
        Intrinsics.e(this$0, "this$0");
        if (YYRoomInfoManager.e().f17579c != 1) {
            return;
        }
        SVGAParser.a(SVGAParser.f15958a.b(), "bor_music_123.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.view.YYRobMusicProgressBtnView$play$2$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity svgaVideoEntity) {
                SVGAImageView sVGAImageView;
                SVGAImageView sVGAImageView2;
                Intrinsics.e(svgaVideoEntity, "svgaVideoEntity");
                sVGAImageView = YYRobMusicProgressBtnView.this.f18438a;
                if (sVGAImageView != null) {
                    sVGAImageView.setImageDrawable(new SVGADrawable(svgaVideoEntity));
                }
                sVGAImageView2 = YYRobMusicProgressBtnView.this.f18438a;
                if (sVGAImageView2 == null) {
                    return;
                }
                sVGAImageView2.a();
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    public final void a() {
        SVGAImageView sVGAImageView = this.f18438a;
        if (sVGAImageView != null) {
            sVGAImageView.setCallback(null);
        }
        SVGAImageView sVGAImageView2 = this.f18438a;
        if (sVGAImageView2 != null) {
            sVGAImageView2.a(true);
        }
        RobMusicProgressBtn robMusicProgressBtn = this.b;
        if (robMusicProgressBtn == null) {
            return;
        }
        robMusicProgressBtn.setAniStopLi(null);
    }

    public final void a(View.OnClickListener onClickListener, View.OnClickListener aniStopLi) {
        Intrinsics.e(onClickListener, "onClickListener");
        Intrinsics.e(aniStopLi, "aniStopLi");
        RobMusicProgressBtn robMusicProgressBtn = this.b;
        if (robMusicProgressBtn != null) {
            robMusicProgressBtn.setVisibility(8);
        }
        RobMusicProgressBtn robMusicProgressBtn2 = this.b;
        if (robMusicProgressBtn2 != null) {
            robMusicProgressBtn2.setOnClickListener(onClickListener);
        }
        RobMusicProgressBtn robMusicProgressBtn3 = this.b;
        if (robMusicProgressBtn3 != null) {
            robMusicProgressBtn3.setAniStopLi(aniStopLi);
        }
        SVGAImageView sVGAImageView = this.f18438a;
        if (sVGAImageView != null) {
            sVGAImageView.setFillMode(SVGAImageView.FillMode.Clear);
        }
        SVGAImageView sVGAImageView2 = this.f18438a;
        if (sVGAImageView2 != null) {
            sVGAImageView2.setCallback(new SVGACallback() { // from class: com.blued.android.module.yy_china.view.YYRobMusicProgressBtnView$play$1
                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onFinished() {
                    RobMusicProgressBtn robMusicProgressBtn4;
                    RobMusicProgressBtn robMusicProgressBtn5;
                    robMusicProgressBtn4 = YYRobMusicProgressBtnView.this.b;
                    int i = 0;
                    if (robMusicProgressBtn4 != null) {
                        robMusicProgressBtn4.setVisibility(0);
                    }
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b == null) {
                        i = 15;
                    } else {
                        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode = b.robMus;
                        if (yYBorImJsonBodyInfoMode == null) {
                            i = 15;
                        } else {
                            int endTime = ((int) ((yYBorImJsonBodyInfoMode.getEndTime() - yYBorImJsonBodyInfoMode.getStartTime()) / 1000)) - 3;
                            if (endTime >= 0) {
                                i = endTime;
                            }
                        }
                    }
                    robMusicProgressBtn5 = YYRobMusicProgressBtnView.this.b;
                    if (robMusicProgressBtn5 == null) {
                        return;
                    }
                    robMusicProgressBtn5.setNumMax(i);
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
            });
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRobMusicProgressBtnView$2_T0rvry5tRGC4w4v99Ka86dTzo
            @Override // java.lang.Runnable
            public final void run() {
                YYRobMusicProgressBtnView.c(YYRobMusicProgressBtnView.this);
            }
        }, 1000L);
    }
}
