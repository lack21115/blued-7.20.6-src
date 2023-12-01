package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyRoomBackgroundBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYBackgroundView.class */
public class YYBackgroundView extends FrameLayout {
    private ViewYyRoomBackgroundBinding a;
    private BaseYYStudioFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.yy_china.view.YYBackgroundView$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYBackgroundView$1.class */
    public class AnonymousClass1 extends ImageLoadResult {
        final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IRequestHost iRequestHost, String str) {
            super(iRequestHost);
            this.a = str;
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a() {
            super.a();
            YYBackgroundView.this.b();
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a(int i, Exception exc) {
            super.a(i, exc);
            final YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null || YYBackgroundView.this.a == null) {
                return;
            }
            YYBackgroundView.this.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYBackgroundView.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b == null || YYBackgroundView.this.a == null || YYBackgroundView.this.b == null) {
                        return;
                    }
                    ImageLoader.a(YYBackgroundView.this.b.getFragmentActive(), AnonymousClass1.this.a).c(200).a(new ImageLoadResult(YYBackgroundView.this.b.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYBackgroundView.1.1.1
                        @Override // com.blued.android.core.image.ImageLoadResult
                        public void a() {
                            super.a();
                            YYBackgroundView.this.b();
                        }
                    }).a(YYBackgroundView.this.a.a);
                }
            });
        }
    }

    public YYBackgroundView(Context context) {
        this(context, null);
    }

    public YYBackgroundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYBackgroundView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = ViewYyRoomBackgroundBinding.a(LayoutInflater.from(context), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYBackgroundView.2
            @Override // java.lang.Runnable
            public void run() {
                YYBackgroundView.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        this.a.b.setImageResource(R.color.transparent);
        if (b == null || b.background == null || StringUtils.b(b.background.getPic())) {
            return;
        }
        final String pic = b.background.getPic();
        if (TextUtils.isEmpty(pic) || !pic.toLowerCase().endsWith("png")) {
            new SVGAPlayer.Builder(pic).a((Integer) 0).a(this.a.b);
        } else {
            ImageLoader.a(this.b.getFragmentActive(), pic).c(300).a(new ImageLoadResult(this.b.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYBackgroundView.3
                @Override // com.blued.android.core.image.ImageLoadResult
                public void a(int i, Exception exc) {
                    super.a(i, exc);
                    final YYRoomModel b2 = YYRoomInfoManager.e().b();
                    if (b2 == null || YYBackgroundView.this.a == null) {
                        return;
                    }
                    YYBackgroundView.this.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYBackgroundView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b2 == null || YYBackgroundView.this.a == null || YYBackgroundView.this.b == null) {
                                return;
                            }
                            ImageLoader.a(YYBackgroundView.this.b.getFragmentActive(), pic).c(300).g(-1).f().a(YYBackgroundView.this.a.b);
                        }
                    });
                }
            }).g(-1).f().a(this.a.b);
        }
    }

    public void a() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            String default_pic = (b.background == null || StringUtils.b(b.background.getDefault_pic())) ? b.type_img : b.background.getDefault_pic();
            ImageLoader.a(this.b.getFragmentActive(), default_pic).c(200).a(new AnonymousClass1(this.b.getFragmentActive(), default_pic)).a(this.a.a);
        }
    }

    public void setFragment(BaseYYStudioFragment baseYYStudioFragment) {
        this.b = baseYYStudioFragment;
    }
}
