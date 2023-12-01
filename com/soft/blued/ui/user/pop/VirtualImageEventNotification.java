package com.soft.blued.ui.user.pop;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/VirtualImageEventNotification.class */
public final class VirtualImageEventNotification extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    private final IRequestHost f34254c;
    private String d;
    private String e;
    private OnEventClickListener f;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/VirtualImageEventNotification$OnEventClickListener.class */
    public interface OnEventClickListener {
        void a(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageEventNotification(Context context, IRequestHost requestHost, String pictureUrl, String str, OnEventClickListener onEventClickListener) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(requestHost, "requestHost");
        Intrinsics.e(pictureUrl, "pictureUrl");
        this.f34254c = requestHost;
        this.d = pictureUrl;
        this.e = str;
        this.f = onEventClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageEventNotification this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageEventNotification this$0, View view) {
        OnEventClickListener onEventClickListener;
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        String str = this$0.e;
        if (str != null && (onEventClickListener = this$0.f) != null) {
            onEventClickListener.a(str);
        }
        this$0.p();
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        ((FrameLayout) findViewById(R.id.fl_event_close)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$VirtualImageEventNotification$BULH_32zdpL_2bLpYjvxaLo6pPE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageEventNotification.a(VirtualImageEventNotification.this, view);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.iv_event_picture);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$VirtualImageEventNotification$qedvFKWJUiwz6jMjU7vwLWzuWyI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageEventNotification.b(VirtualImageEventNotification.this, view);
            }
        });
        ImageLoader.a(this.f34254c, this.d).a(imageView);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.layout_virtual_image_event;
    }

    public final IRequestHost getRequestHost() {
        return this.f34254c;
    }
}
