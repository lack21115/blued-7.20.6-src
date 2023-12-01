package com.soft.blued.ui.login_register;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/AdultVerifyFragment_ViewBinding.class */
public class AdultVerifyFragment_ViewBinding implements Unbinder {
    private AdultVerifyFragment b;

    public AdultVerifyFragment_ViewBinding(AdultVerifyFragment adultVerifyFragment, View view) {
        this.b = adultVerifyFragment;
        adultVerifyFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        adultVerifyFragment.flCover = (FrameLayout) Utils.a(view, 2131363788, "field 'flCover'", FrameLayout.class);
        adultVerifyFragment.imgCover = (ImageView) Utils.a(view, 2131364496, "field 'imgCover'", ImageView.class);
        adultVerifyFragment.imgBtmIcon = (ImageView) Utils.a(view, R.id.img_btm_icon, "field 'imgBtmIcon'", ImageView.class);
        adultVerifyFragment.tvUpIdFront = (TextView) Utils.a(view, R.id.tv_up_id_front, "field 'tvUpIdFront'", TextView.class);
        adultVerifyFragment.tvTitle = (TextView) Utils.a(view, 2131372754, "field 'tvTitle'", TextView.class);
        adultVerifyFragment.tvContent = (TextView) Utils.a(view, 2131371186, "field 'tvContent'", TextView.class);
        adultVerifyFragment.tvConfirmToSubmit = (TextView) Utils.a(view, R.id.tv_confirm_to_submit, "field 'tvConfirmToSubmit'", TextView.class);
        adultVerifyFragment.btnSolid = (ShapeTextView) Utils.a(view, R.id.btn_solid, "field 'btnSolid'", ShapeTextView.class);
        adultVerifyFragment.btnStroke = (ShapeTextView) Utils.a(view, R.id.btn_stroke, "field 'btnStroke'", ShapeTextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AdultVerifyFragment adultVerifyFragment = this.b;
        if (adultVerifyFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        adultVerifyFragment.title = null;
        adultVerifyFragment.flCover = null;
        adultVerifyFragment.imgCover = null;
        adultVerifyFragment.imgBtmIcon = null;
        adultVerifyFragment.tvUpIdFront = null;
        adultVerifyFragment.tvTitle = null;
        adultVerifyFragment.tvContent = null;
        adultVerifyFragment.tvConfirmToSubmit = null;
        adultVerifyFragment.btnSolid = null;
        adultVerifyFragment.btnStroke = null;
    }
}
