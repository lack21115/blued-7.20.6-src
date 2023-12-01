package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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
    private ViewRoomPkUserLayoutBinding a;

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
        ViewRoomPkUserLayoutBinding a = ViewRoomPkUserLayoutBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
    }

    public final void a(IRequestHost iRequestHost, String str, String str2, YYImModel yYImModel) {
        this.a.b.a(iRequestHost, str, str2, yYImModel);
    }

    public final void a(YYRoomMemberInfoModel yYRoomMemberInfoModel, ActivityFragmentActive activityFragmentActive) {
        String str = yYRoomMemberInfoModel == null ? null : yYRoomMemberInfoModel.room_id;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (TextUtils.equals(str, b == null ? null : b.room_id)) {
            this.a.a.setText("本房");
            ShapeHelper.b(this.a.a, R.color.syc_FF57F0);
        } else {
            this.a.a.setText("对方");
            ShapeHelper.b(this.a.a, R.color.syc_3883FD);
        }
        this.a.b.b(false);
        this.a.b.a(yYRoomMemberInfoModel, activityFragmentActive);
    }

    public final void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        this.a.b.a(set, yYSeatMemberModel);
    }
}
