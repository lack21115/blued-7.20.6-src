package com.blued.android.module.live_china.view.operation;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveOperationBottomChildH5ViewBinding;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/OperationBottomChildH5View.class */
public final class OperationBottomChildH5View extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15359a;
    private final Lazy b;

    /* renamed from: c  reason: collision with root package name */
    private BaseFragment f15360c;
    private LiveRoomOperationModel d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationBottomChildH5View(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.f15359a = mContext;
        this.b = LazyKt.a(new Function0<LiveOperationBottomChildH5ViewBinding>() { // from class: com.blued.android.module.live_china.view.operation.OperationBottomChildH5View$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveOperationBottomChildH5ViewBinding invoke() {
                LiveOperationBottomChildH5ViewBinding a2 = LiveOperationBottomChildH5ViewBinding.a(LayoutInflater.from(OperationBottomChildH5View.this.getMContext()).inflate(R.layout.live_operation_bottom_child_h5_view, OperationBottomChildH5View.this));
                Intrinsics.c(a2, "bind(\n            Layout…_h5_view, this)\n        )");
                return a2;
            }
        });
    }

    private final LiveOperationBottomChildH5ViewBinding getVb() {
        return (LiveOperationBottomChildH5ViewBinding) this.b.getValue();
    }

    public final OperationBottomChildH5View a(BaseFragment baseFragment, LiveRoomOperationModel liveRoomOperationModel) {
        if (liveRoomOperationModel == null || liveRoomOperationModel.getStatus() == 0) {
            return null;
        }
        this.d = liveRoomOperationModel;
        if (baseFragment == null) {
            return null;
        }
        this.f15360c = baseFragment;
        if (a(liveRoomOperationModel)) {
            return this;
        }
        return null;
    }

    public final boolean a(LiveRoomOperationModel model) {
        ActivityFragmentActive fragmentActive;
        Intrinsics.e(model, "model");
        setModel(model);
        if (model.getIcon() == null) {
            return false;
        }
        BaseFragment baseFragment = this.f15360c;
        if (baseFragment == null || (fragmentActive = baseFragment.getFragmentActive()) == null) {
            return false;
        }
        ImageLoader.a(fragmentActive, model.getIcon()).a(getVb().b);
        return true;
    }

    public final Context getMContext() {
        return this.f15359a;
    }

    public final LiveRoomOperationModel getModel() {
        return this.d;
    }

    public final ShapeRelativeLayout getRedDot() {
        ShapeRelativeLayout shapeRelativeLayout = getVb().f12304a;
        Intrinsics.c(shapeRelativeLayout, "vb.ivH5WellDot");
        return shapeRelativeLayout;
    }

    public final void setModel(LiveRoomOperationModel liveRoomOperationModel) {
        this.d = liveRoomOperationModel;
    }
}
