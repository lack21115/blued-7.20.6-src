package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.operation.LiveOperationDescView;
import com.blued.android.module.live_china.view.operation.LiveOperationListView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveOperationViewBinding.class */
public final class LiveOperationViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeRelativeLayout f12313a;
    public final LiveOperationDescView b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveOperationListView f12314c;
    private final FrameLayout d;

    private LiveOperationViewBinding(FrameLayout frameLayout, ShapeRelativeLayout shapeRelativeLayout, LiveOperationDescView liveOperationDescView, LiveOperationListView liveOperationListView) {
        this.d = frameLayout;
        this.f12313a = shapeRelativeLayout;
        this.b = liveOperationDescView;
        this.f12314c = liveOperationListView;
    }

    public static LiveOperationViewBinding a(View view) {
        String str;
        ShapeRelativeLayout shapeRelativeLayout = (ShapeRelativeLayout) view.findViewById(R.id.live_background);
        if (shapeRelativeLayout != null) {
            LiveOperationDescView liveOperationDescView = (LiveOperationDescView) view.findViewById(R.id.live_desc);
            if (liveOperationDescView != null) {
                LiveOperationListView liveOperationListView = (LiveOperationListView) view.findViewById(R.id.live_view_list);
                if (liveOperationListView != null) {
                    return new LiveOperationViewBinding((FrameLayout) view, shapeRelativeLayout, liveOperationDescView, liveOperationListView);
                }
                str = "liveViewList";
            } else {
                str = "liveDesc";
            }
        } else {
            str = "liveBackground";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
