package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewRoomPkUserLayoutBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomMemberInfoModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMemberRoomPkView.class */
public final class YYMemberRoomPkView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewRoomPkUserLayoutBinding f18320a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYMemberRoomPkView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYMemberRoomPkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYMemberRoomPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewRoomPkUserLayoutBinding a2 = ViewRoomPkUserLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18320a = a2;
    }

    public final void a(IRequestHost iRequestHost, String str, String str2, YYImModel yYImModel) {
        this.f18320a.b.a(iRequestHost, str, str2, yYImModel);
    }

    public final void a(YYRoomMemberInfoModel yYRoomMemberInfoModel, ActivityFragmentActive activityFragmentActive) {
        String str = yYRoomMemberInfoModel == null ? null : yYRoomMemberInfoModel.room_id;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (TextUtils.equals(str, b == null ? null : b.room_id)) {
            this.f18320a.f16877a.setText("本房");
            ShapeHelper.b(this.f18320a.f16877a, R.color.syc_FF57F0);
        } else {
            this.f18320a.f16877a.setText("对方");
            ShapeHelper.b(this.f18320a.f16877a, R.color.syc_3883FD);
        }
        this.f18320a.b.b(false);
        this.f18320a.b.a(yYRoomMemberInfoModel, activityFragmentActive);
    }

    public final void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        this.f18320a.b.a(set, yYSeatMemberModel);
    }
}
