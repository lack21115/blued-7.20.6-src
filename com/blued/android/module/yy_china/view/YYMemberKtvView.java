package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyMemberKtvBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMemberKtvView.class */
public class YYMemberKtvView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewYyMemberKtvBinding f18318a;
    private YYRoomModel b;

    public YYMemberKtvView(Context context) {
        this(context, null);
    }

    public YYMemberKtvView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYMemberKtvView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = YYRoomInfoManager.e().b();
        a();
    }

    private void a() {
        this.f18318a = ViewYyMemberKtvBinding.a(LayoutInflater.from(getContext()), this, true);
    }

    public void a(IRequestHost iRequestHost, String str, String str2, YYImModel yYImModel) {
        this.f18318a.f16932a.a(iRequestHost, str, str2, yYImModel);
    }

    public void a(YYSeatMemberModel yYSeatMemberModel, ActivityFragmentActive activityFragmentActive) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.music == null || !TextUtils.equals(this.b.music.uid, yYSeatMemberModel.getUid())) {
            TextView textView = this.f18318a.b;
            textView.setText(yYSeatMemberModel.mic_position + "");
            this.f18318a.b.setTextColor(getResources().getColor(R.color.syc_ffffff));
        } else {
            this.f18318a.b.setText("演唱中");
            this.f18318a.b.setTextColor(getResources().getColor(R.color.syc_00E0AB));
        }
        this.f18318a.f16932a.a(yYSeatMemberModel, activityFragmentActive);
    }

    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H) {
        this.f18318a.f16932a.a(getViewX_Y_W_H);
    }

    public void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        this.f18318a.f16932a.a(set, yYSeatMemberModel);
    }
}
