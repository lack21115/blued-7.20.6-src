package com.soft.blued.ui.user.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/VirtualImageDoubleTapGuide.class */
public final class VirtualImageDoubleTapGuide extends BottomPopupView {
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final IRequestHost f20562c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageDoubleTapGuide(Context context, int i, IRequestHost iRequestHost) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(iRequestHost, "requestHost");
        this.b = i;
        this.f20562c = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageDoubleTapGuide virtualImageDoubleTapGuide, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageDoubleTapGuide, "this$0");
        virtualImageDoubleTapGuide.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageDoubleTapGuide virtualImageDoubleTapGuide, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageDoubleTapGuide, "this$0");
        virtualImageDoubleTapGuide.p();
    }

    public void b() {
        String str;
        super.b();
        ((ConstraintLayout) findViewById(R.id.cl_guide)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$VirtualImageDoubleTapGuide$ncPxWg8Fe6wamQJ4HhOW1p-hO-0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageDoubleTapGuide.a(VirtualImageDoubleTapGuide.this, view);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.iv_guide_bg);
        ImageLoader.a(this.f20562c, (int) R.drawable.virtual_image_guide_bg).a(imageView);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_try_now);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_click_anim);
        int i = this.b;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            relativeLayout.setVisibility(0);
            imageView2.setVisibility(8);
            ((TextView) findViewById(R.id.tv_goto_try)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$VirtualImageDoubleTapGuide$7gPn79yOmCTSXsDyv7wE97njCac
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageDoubleTapGuide.b(VirtualImageDoubleTapGuide.this, view);
                }
            });
            return;
        }
        relativeLayout.setVisibility(8);
        imageView2.setVisibility(0);
        imageView.setImageAlpha(102);
        if (BlueAppLocal.d()) {
            String country = BlueAppLocal.c().getCountry();
            Intrinsics.c(country, "getDefault().country");
            Locale locale = Locale.getDefault();
            Intrinsics.c(locale, "getDefault()");
            String upperCase = country.toUpperCase(locale);
            Intrinsics.c(upperCase, "this as java.lang.String).toUpperCase(locale)");
            str = Intrinsics.a("CN", upperCase) ? "anim_virtual_image_guide_double_click_cn.png" : "anim_virtual_image_guide_double_click_tw.png";
        } else {
            str = "anim_virtual_image_guide_double_click_en.png";
        }
        ImageLoader.c(this.f20562c, str).f().g(-1).a(imageView2);
    }

    public int getImplLayoutId() {
        return R.layout.layout_virtual_image_guide;
    }

    public final int getModel() {
        return this.b;
    }

    public final IRequestHost getRequestHost() {
        return this.f20562c;
    }
}
