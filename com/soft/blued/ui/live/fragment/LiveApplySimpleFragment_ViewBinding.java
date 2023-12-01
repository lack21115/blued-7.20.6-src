package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveApplySimpleFragment_ViewBinding.class */
public class LiveApplySimpleFragment_ViewBinding implements Unbinder {
    private LiveApplySimpleFragment b;

    public LiveApplySimpleFragment_ViewBinding(LiveApplySimpleFragment liveApplySimpleFragment, View view) {
        this.b = liveApplySimpleFragment;
        liveApplySimpleFragment.top_title = (CommonTopTitleNoTrans) Utils.a(view, R.id.top_title, "field 'top_title'", CommonTopTitleNoTrans.class);
        liveApplySimpleFragment.ll_main = Utils.a(view, 2131367999, "field 'll_main'");
        liveApplySimpleFragment.fl_error_page = Utils.a(view, R.id.fl_error_page, "field 'fl_error_page'");
        liveApplySimpleFragment.tv_reload = Utils.a(view, 2131372414, "field 'tv_reload'");
        liveApplySimpleFragment.live_agree = (TextView) Utils.a(view, R.id.live_agree, "field 'live_agree'", TextView.class);
        liveApplySimpleFragment.live_clause = (ImageView) Utils.a(view, R.id.live_clause, "field 'live_clause'", ImageView.class);
        liveApplySimpleFragment.tv_other = (TextView) Utils.a(view, 2131372200, "field 'tv_other'", TextView.class);
        liveApplySimpleFragment.tv_id = (EditText) Utils.a(view, R.id.tv_id, "field 'tv_id'", EditText.class);
        liveApplySimpleFragment.tv_name = (EditText) Utils.a(view, 2131372046, "field 'tv_name'", EditText.class);
        liveApplySimpleFragment.tv_identify = (TextView) Utils.a(view, 2131371709, "field 'tv_identify'", TextView.class);
        liveApplySimpleFragment.tv_binding_cellphone_status = (TextView) Utils.a(view, R.id.tv_binding_cellphone_status, "field 'tv_binding_cellphone_status'", TextView.class);
        liveApplySimpleFragment.tv_binding_cellphone = (TextView) Utils.a(view, R.id.tv_binding_cellphone, "field 'tv_binding_cellphone'", TextView.class);
        liveApplySimpleFragment.iv_phone_binded = (ImageView) Utils.a(view, R.id.iv_phone_binded, "field 'iv_phone_binded'", ImageView.class);
        liveApplySimpleFragment.header_view = (ImageView) Utils.a(view, 2131364232, "field 'header_view'", ImageView.class);
        liveApplySimpleFragment.img_verify = (ImageView) Utils.a(view, R.id.img_verify, "field 'img_verify'", ImageView.class);
        liveApplySimpleFragment.tv_tip_one = (TextView) Utils.a(view, R.id.tv_tip_one, "field 'tv_tip_one'", TextView.class);
        liveApplySimpleFragment.tv_tip_two = (TextView) Utils.a(view, R.id.tv_tip_two, "field 'tv_tip_two'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LiveApplySimpleFragment liveApplySimpleFragment = this.b;
        if (liveApplySimpleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        liveApplySimpleFragment.top_title = null;
        liveApplySimpleFragment.ll_main = null;
        liveApplySimpleFragment.fl_error_page = null;
        liveApplySimpleFragment.tv_reload = null;
        liveApplySimpleFragment.live_agree = null;
        liveApplySimpleFragment.live_clause = null;
        liveApplySimpleFragment.tv_other = null;
        liveApplySimpleFragment.tv_id = null;
        liveApplySimpleFragment.tv_name = null;
        liveApplySimpleFragment.tv_identify = null;
        liveApplySimpleFragment.tv_binding_cellphone_status = null;
        liveApplySimpleFragment.tv_binding_cellphone = null;
        liveApplySimpleFragment.iv_phone_binded = null;
        liveApplySimpleFragment.header_view = null;
        liveApplySimpleFragment.img_verify = null;
        liveApplySimpleFragment.tv_tip_one = null;
        liveApplySimpleFragment.tv_tip_two = null;
    }
}
