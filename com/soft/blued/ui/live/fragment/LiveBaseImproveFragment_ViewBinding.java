package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveBaseImproveFragment_ViewBinding.class */
public class LiveBaseImproveFragment_ViewBinding implements Unbinder {
    private LiveBaseImproveFragment b;

    public LiveBaseImproveFragment_ViewBinding(LiveBaseImproveFragment liveBaseImproveFragment, View view) {
        this.b = liveBaseImproveFragment;
        liveBaseImproveFragment.ll_main = Utils.a(view, 2131367999, "field 'll_main'");
        liveBaseImproveFragment.fl_error_page = Utils.a(view, R.id.fl_error_page, "field 'fl_error_page'");
        liveBaseImproveFragment.tv_reload = Utils.a(view, 2131372414, "field 'tv_reload'");
        liveBaseImproveFragment.tv_start_verify = (TextView) Utils.a(view, R.id.tv_start_verify, "field 'tv_start_verify'", TextView.class);
        liveBaseImproveFragment.top_title = (CommonTopTitleNoTrans) Utils.a(view, R.id.top_title, "field 'top_title'", CommonTopTitleNoTrans.class);
        liveBaseImproveFragment.live_id_card_error = Utils.a(view, R.id.live_id_card_error, "field 'live_id_card_error'");
        liveBaseImproveFragment.live_add_card_layout1 = Utils.a(view, R.id.live_add_card_layout1, "field 'live_add_card_layout1'");
        liveBaseImproveFragment.live_add_card_layout2 = Utils.a(view, R.id.live_add_card_layout2, "field 'live_add_card_layout2'");
        liveBaseImproveFragment.live_card1 = (ImageView) Utils.a(view, R.id.live_card1, "field 'live_card1'", ImageView.class);
        liveBaseImproveFragment.live_card2 = (ImageView) Utils.a(view, R.id.live_card2, "field 'live_card2'", ImageView.class);
        liveBaseImproveFragment.cover_del_btn1 = (ImageView) Utils.a(view, R.id.cover_del_btn1, "field 'cover_del_btn1'", ImageView.class);
        liveBaseImproveFragment.cover_del_btn2 = (ImageView) Utils.a(view, R.id.cover_del_btn2, "field 'cover_del_btn2'", ImageView.class);
        liveBaseImproveFragment.tv_binding_credit_card = (TextView) Utils.a(view, R.id.tv_binding_credit_card, "field 'tv_binding_credit_card'", TextView.class);
        liveBaseImproveFragment.tv_binding_credit_card_status = (TextView) Utils.a(view, R.id.tv_binding_credit_card_status, "field 'tv_binding_credit_card_status'", TextView.class);
        liveBaseImproveFragment.iv_card_binded = (ImageView) Utils.a(view, R.id.iv_card_binded, "field 'iv_card_binded'", ImageView.class);
        liveBaseImproveFragment.ll_bottom_button = Utils.a(view, R.id.ll_bottom_button, "field 'll_bottom_button'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LiveBaseImproveFragment liveBaseImproveFragment = this.b;
        if (liveBaseImproveFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        liveBaseImproveFragment.ll_main = null;
        liveBaseImproveFragment.fl_error_page = null;
        liveBaseImproveFragment.tv_reload = null;
        liveBaseImproveFragment.tv_start_verify = null;
        liveBaseImproveFragment.top_title = null;
        liveBaseImproveFragment.live_id_card_error = null;
        liveBaseImproveFragment.live_add_card_layout1 = null;
        liveBaseImproveFragment.live_add_card_layout2 = null;
        liveBaseImproveFragment.live_card1 = null;
        liveBaseImproveFragment.live_card2 = null;
        liveBaseImproveFragment.cover_del_btn1 = null;
        liveBaseImproveFragment.cover_del_btn2 = null;
        liveBaseImproveFragment.tv_binding_credit_card = null;
        liveBaseImproveFragment.tv_binding_credit_card_status = null;
        liveBaseImproveFragment.iv_card_binded = null;
        liveBaseImproveFragment.ll_bottom_button = null;
    }
}
