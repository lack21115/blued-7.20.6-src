package com.blued.android.module.common.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.R;
import com.blued.android.module.common.model.LiveFansLevelModel;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/LiveFansLevelView.class */
public class LiveFansLevelView extends FrameLayout {
    private View a;
    private ShapeLinearLayout b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private int f;
    private String g;
    private int h;
    private int i;

    public LiveFansLevelView(Context context) {
        super(context);
        this.f = 0;
        this.g = "";
        this.h = 0;
        this.i = 1;
        a();
    }

    public LiveFansLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        this.g = "";
        this.h = 0;
        this.i = 1;
        a();
    }

    public LiveFansLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        this.g = "";
        this.h = 0;
        this.i = 1;
        a();
    }

    public LiveFansLevelView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f = 0;
        this.g = "";
        this.h = 0;
        this.i = 1;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.live_fans_heart_level_badge, this);
        this.a = inflate.findViewById(R.id.ll_join);
        this.b = (ShapeLinearLayout) inflate.findViewById(R.id.ll_level);
        this.c = (ImageView) inflate.findViewById(R.id.iv_heart);
        this.d = (TextView) inflate.findViewById(R.id.tv_level_num);
        this.e = (TextView) inflate.findViewById(R.id.tv_fans_name);
    }

    private void b() {
        requestLayout();
        if (getParent() != null) {
            getParent().requestLayout();
        }
    }

    public void a(int i, int i2, String str, int i3) {
        this.h = i;
        this.i = i3;
        this.f = i2;
        if (TextUtils.isEmpty(str)) {
            this.g = "粉丝团";
        } else if (str.length() > 3) {
            this.g = str.substring(0, 3);
        } else {
            this.g = str;
        }
        if (this.h == 0) {
            this.a.setVisibility(0);
            this.b.setVisibility(8);
            b();
            return;
        }
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        ShapeModel shapeModel = new ShapeModel();
        if (i3 == 1) {
            this.d.setTextColor(AppInfo.d().getResources().getColor(R.color.syc_dark_E07F00));
            this.c.setImageResource(R.drawable.live_fans_heart_level_badge_heart);
            shapeModel.k = BluedSkinUtils.a(getContext(), R.color.syc_dark_D6FFB928);
            shapeModel.n = BluedSkinUtils.a(getContext(), R.color.syc_dark_FFA100);
        } else if (i3 == 2) {
            this.d.setTextColor(AppInfo.d().getResources().getColor(R.color.syc_dark_777777));
            this.c.setImageResource(R.drawable.live_fans_heart_level_badge_heart_grey);
            shapeModel.k = BluedSkinUtils.a(getContext(), R.color.syc_dark_D6C3C3C3);
            shapeModel.n = BluedSkinUtils.a(getContext(), R.color.syc_dark_B2B2B2);
        }
        shapeModel.q = DensityUtils.a(getContext(), 0.5f);
        shapeModel.H = DensityUtils.a(getContext(), 7.5f);
        this.b.setShapeModel(shapeModel);
        this.e.getPaint().setFakeBoldText(true);
        this.d.getPaint().setFakeBoldText(true);
        this.e.setText(this.g);
        this.d.setText(String.valueOf(i2));
        b();
    }

    public void setFansLevel(LiveFansLevelModel liveFansLevelModel) {
        if (liveFansLevelModel != null) {
            a(liveFansLevelModel.in_fan_club, liveFansLevelModel.fan_club_level, liveFansLevelModel.fan_club_name, liveFansLevelModel.fans_status);
        }
        b();
    }
}
