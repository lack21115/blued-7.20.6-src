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
    private final IRequestHost f20563c;
    private String d;
    private String e;
    private OnEventClickListener f;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/VirtualImageEventNotification$OnEventClickListener.class */
    public interface OnEventClickListener {
        void a(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageEventNotification(Context context, IRequestHost iRequestHost, String str, String str2, OnEventClickListener onEventClickListener) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(iRequestHost, "requestHost");
        Intrinsics.e(str, "pictureUrl");
        this.f20563c = iRequestHost;
        this.d = str;
        this.e = str2;
        this.f = onEventClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageEventNotification virtualImageEventNotification, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageEventNotification, "this$0");
        virtualImageEventNotification.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageEventNotification virtualImageEventNotification, View view) {
        OnEventClickListener onEventClickListener;
        Tracker.onClick(view);
        Intrinsics.e(virtualImageEventNotification, "this$0");
        String str = virtualImageEventNotification.e;
        if (str != null && (onEventClickListener = virtualImageEventNotification.f) != null) {
            onEventClickListener.a(str);
        }
        virtualImageEventNotification.p();
    }

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
        ImageLoader.a(this.f20563c, this.d).a(imageView);
    }

    public int getImplLayoutId() {
        return R.layout.layout_virtual_image_event;
    }

    public final IRequestHost getRequestHost() {
        return this.f20563c;
    }
}
