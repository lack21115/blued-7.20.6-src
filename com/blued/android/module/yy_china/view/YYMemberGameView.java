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
    private ViewYyMemberGameBinding a;

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

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        this.a = ViewYyMemberGameBinding.a(LayoutInflater.from(getContext()), this, true);
    }

    public void a(IRequestHost iRequestHost, String str, String str2, YYImModel yYImModel) {
        this.a.a.a(iRequestHost, str, str2, yYImModel);
    }

    public void a(YYSeatMemberModel yYSeatMemberModel, ActivityFragmentActive activityFragmentActive) {
        double a = StringUtils.a(yYSeatMemberModel.gift_value, 0);
        this.a.c.setText(a > 0.0d ? CommonStringUtils.b(a) : "");
        this.a.f.setVisibility(8);
        this.a.g.setVisibility(8);
        int a2 = StringUtils.a(yYSeatMemberModel.election, 0);
        int a3 = StringUtils.a(yYSeatMemberModel.team_num, 0);
        int a4 = StringUtils.a(yYSeatMemberModel.captain, 0);
        if (a2 != 0) {
            this.a.g.setVisibility(8);
            this.a.f.setVisibility(0);
        }
        if (a3 != 0) {
            this.a.f.setVisibility(8);
            this.a.g.setVisibility(0);
            this.a.g.setText(a3 + "");
            if (a3 == 1) {
                this.a.g.setBackgroundResource(R.drawable.shape_layer_team_one);
            } else {
                this.a.g.setBackgroundResource(R.drawable.shape_layer_team_two);
            }
        }
        if (a4 != 0 && a3 != 0) {
            this.a.f.setVisibility(8);
            this.a.g.setVisibility(0);
            this.a.g.setText(a3 + "队");
            if (a3 == 1) {
                this.a.g.setBackgroundResource(R.drawable.shape_layer_team_one);
            } else {
                this.a.g.setBackgroundResource(R.drawable.shape_layer_team_two);
            }
        }
        if (TextUtils.equals(yYSeatMemberModel.getUid(), YYRoomInfoManager.e().b().uid)) {
            this.a.g.setVisibility(8);
            this.a.f.setVisibility(8);
        }
        this.a.d.setText(yYSeatMemberModel.mic_position + "");
        if (TextUtils.isEmpty(yYSeatMemberModel.getName())) {
            this.a.e.setText("");
        } else {
            this.a.e.setText(yYSeatMemberModel.getName());
        }
        this.a.a.a(yYSeatMemberModel, activityFragmentActive);
    }

    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H) {
        this.a.a.a(getViewX_Y_W_H);
    }

    public void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        this.a.a.a(set, yYSeatMemberModel);
    }
}
