package com.blued.android.module.live_china.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveCouponDlgFragment.class */
public class LiveCouponDlgFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    private TextView j;
    private LiveChargeCouponModel k;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        j();
        EventTrackLive.a(LiveProtos.Event.LIVE_GET_COUPON_POP_KNOWN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        j();
    }

    private void k() {
        j();
        if (getTargetFragment() != null) {
            Intent intent = new Intent();
            intent.putExtra("coupon_model", this.k);
            getTargetFragment().onActivityResult(getTargetRequestCode(), 0, intent);
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_GET_COUPON_POP_GO_USE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_coupon_dlg;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.j = (TextView) this.b.findViewById(R.id.live_coupon_dlg_money);
        if (this.k != null) {
            String str = this.k.name;
            String str2 = "单笔充值 " + this.k.threshold + "元 可获得\n" + str;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF5E32")), 4, (this.k.threshold + "元").length() + 5, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF5E32")), str2.indexOf(str), str2.indexOf(str) + str.length(), 33);
            this.j.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveCouponDlgFragment$1A_XoZDZQCIccrRfH_ZfGB2xSkE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveCouponDlgFragment.this.c(view);
            }
        });
        this.b.findViewById(R.id.live_coupon_dlg_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveCouponDlgFragment$H6zyxkyALUmFPst2h-5h8Ic5tKw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveCouponDlgFragment.this.b(view);
            }
        });
        this.b.findViewById(R.id.live_coupon_dlg_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveCouponDlgFragment$sypKxCP0R3DRCpkgj-jM3rOzRC8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveCouponDlgFragment.this.a(view);
            }
        });
        EventTrackLive.a(LiveProtos.Event.LIVE_GET_COUPON_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        this.k = (LiveChargeCouponModel) this.c.getSerializable("coupon_model");
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        j();
        return true;
    }
}
