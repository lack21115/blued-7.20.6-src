package com.blued.android.module.live_china.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostErrorFragment.class */
public class LiveHostErrorFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    public Button j;
    public ImageView k;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view) {
    }

    private void l() {
        EventTrackLive.b(LiveProtos.Event.ANCHOR_END_PAGE_CONFIRM_CLICK, LiveRoomManager.a().e());
        getActivity().finish();
        if (LiveRoomManager.a().J()) {
            LiveRoomInfo.a().a(getContext());
        }
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_host_error;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostErrorFragment$SedKWM_jME2nYzzlJv9HTm4unoQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostErrorFragment.b(view);
            }
        });
        Button button = (Button) this.b.findViewById(R.id.live_exit_des_error_sure_btn);
        this.j = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostErrorFragment$2AlPKEbq6M70raFsBgdFleZh8_E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostErrorFragment.this.a(view);
            }
        });
        this.k = (ImageView) this.b.findViewById(R.id.background_header);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void g() {
        super.g();
        ImageLoader.a(a(), LiveRoomInfo.a().d()).d().a(this.k);
        k();
    }

    public void k() {
        if (LiveRoomManager.a().p() != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_INTERRUPT, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        Map<String, String> a = BluedHttpTools.a();
        a.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, LiveRoomManager.a().e());
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = "live_interrupt";
        instantLogBody.event = 20001;
        InstantLog.a(instantLogBody, a);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        l();
        return true;
    }
}
