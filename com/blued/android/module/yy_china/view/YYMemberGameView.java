package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyMemberGameBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMemberGameView.class */
public class YYMemberGameView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewYyMemberGameBinding f18317a;

    public YYMemberGameView(Context context) {
        this(context, null);
    }

    public YYMemberGameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYMemberGameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f18317a = ViewYyMemberGameBinding.a(LayoutInflater.from(getContext()), this, true);
    }

    public void a(IRequestHost iRequestHost, String str, String str2, YYImModel yYImModel) {
        this.f18317a.f16930a.a(iRequestHost, str, str2, yYImModel);
    }

    public void a(YYSeatMemberModel yYSeatMemberModel, ActivityFragmentActive activityFragmentActive) {
        double a2 = StringUtils.a(yYSeatMemberModel.gift_value, 0);
        this.f18317a.f16931c.setText(a2 > 0.0d ? CommonStringUtils.b(a2) : "");
        this.f18317a.f.setVisibility(8);
        this.f18317a.g.setVisibility(8);
        int a3 = StringUtils.a(yYSeatMemberModel.election, 0);
        int a4 = StringUtils.a(yYSeatMemberModel.team_num, 0);
        int a5 = StringUtils.a(yYSeatMemberModel.captain, 0);
        if (a3 != 0) {
            this.f18317a.g.setVisibility(8);
            this.f18317a.f.setVisibility(0);
        }
        if (a4 != 0) {
            this.f18317a.f.setVisibility(8);
            this.f18317a.g.setVisibility(0);
            this.f18317a.g.setText(a4 + "");
            if (a4 == 1) {
                this.f18317a.g.setBackgroundResource(R.drawable.shape_layer_team_one);
            } else {
                this.f18317a.g.setBackgroundResource(R.drawable.shape_layer_team_two);
            }
        }
        if (a5 != 0 && a4 != 0) {
            this.f18317a.f.setVisibility(8);
            this.f18317a.g.setVisibility(0);
            this.f18317a.g.setText(a4 + "队");
            if (a4 == 1) {
                this.f18317a.g.setBackgroundResource(R.drawable.shape_layer_team_one);
            } else {
                this.f18317a.g.setBackgroundResource(R.drawable.shape_layer_team_two);
            }
        }
        if (TextUtils.equals(yYSeatMemberModel.getUid(), YYRoomInfoManager.e().b().uid)) {
            this.f18317a.g.setVisibility(8);
            this.f18317a.f.setVisibility(8);
        }
        this.f18317a.d.setText(yYSeatMemberModel.mic_position + "");
        if (TextUtils.isEmpty(yYSeatMemberModel.getName())) {
            this.f18317a.e.setText("");
        } else {
            this.f18317a.e.setText(yYSeatMemberModel.getName());
        }
        this.f18317a.f16930a.a(yYSeatMemberModel, activityFragmentActive);
    }

    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H) {
        this.f18317a.f16930a.a(getViewX_Y_W_H);
    }

    public void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        this.f18317a.f16930a.a(set, yYSeatMemberModel);
    }
}
