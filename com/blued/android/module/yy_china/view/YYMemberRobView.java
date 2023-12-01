package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyMemberRobBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMemberRobView.class */
public class YYMemberRobView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewYyMemberRobBinding f18319a;
    private YYRoomModel b;

    public YYMemberRobView(Context context) {
        this(context, null);
    }

    public YYMemberRobView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYMemberRobView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = YYRoomInfoManager.e().b();
        a();
    }

    private void a() {
        this.f18319a = ViewYyMemberRobBinding.a(LayoutInflater.from(getContext()), this, true);
    }

    public void a(IRequestHost iRequestHost, String str, String str2, YYImModel yYImModel) {
        this.f18319a.f16934a.a(iRequestHost, str, str2, yYImModel);
    }

    public void a(YYSeatMemberModel yYSeatMemberModel, ActivityFragmentActive activityFragmentActive) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.music == null || !TextUtils.equals(this.b.music.uid, yYSeatMemberModel.getUid())) {
            TextView textView = this.f18319a.f16935c;
            textView.setText(yYSeatMemberModel.mic_position + "");
            this.f18319a.f16935c.setTextColor(getResources().getColor(R.color.syc_ffffff));
        } else {
            this.f18319a.f16935c.setText("演唱中");
            this.f18319a.f16935c.setTextColor(getResources().getColor(R.color.syc_00E0AB));
        }
        this.f18319a.f16934a.a(yYSeatMemberModel, activityFragmentActive);
    }

    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H) {
        this.f18319a.f16934a.a(getViewX_Y_W_H);
    }

    public void a(String str) {
        new SVGAPlayer.Builder(str).a((Integer) 1).a(SVGAImageView.FillMode.Clear).a(this.f18319a.b);
    }

    public void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        this.f18319a.f16934a.a(set, yYSeatMemberModel);
    }
}
