package com.blued.android.module.live_china.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fitem.FitemFansGroupRecording;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansGroupModel;
import com.blued.android.module.live_china.presenter.LiveFansGroupRecordingPresent;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansGroupRecordingFrahment.class */
public class LiveFansGroupRecordingFrahment extends MvpFragment<LiveFansGroupRecordingPresent> {
    View a;
    TextView b;
    View c;
    RecyclerView d;
    private FreedomAdapter e;
    private List<FitemFansGroupRecording> f;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        j().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        j().m();
    }

    private void b() {
        FreedomAdapter freedomAdapter = this.e;
        if (freedomAdapter != null) {
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.d.setLayoutManager(new LinearLayoutManager(getContext()));
        FreedomAdapter freedomAdapter2 = new FreedomAdapter(getContext(), getFragmentActive(), this.f);
        this.e = freedomAdapter2;
        this.d.setAdapter(freedomAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_FANS_CLUB_PAGE_CREATE_GROUP_CLICK, LiveRoomManager.a().e());
        CommonAlertDialog.a(getContext(), getString(R.string.live_fans_create_group_dialog_title), getString(R.string.live_fans_create_group_dialog_content), getString(R.string.live_fans_group_dialog_agree), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansGroupRecordingFrahment$AoncIcu5lmGpsfLIsMvrqOgIDII
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveFansGroupRecordingFrahment.this.a(dialogInterface, i);
            }
        }, getString(R.string.live_fans_group_dialog_reject), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = this.i.findViewById(R.id.rl_not_data);
        this.b = (TextView) this.i.findViewById(R.id.tv_not_data);
        this.c = this.i.findViewById(R.id.tv_create);
        this.d = this.i.findViewById(R.id.recycler_view);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansGroupRecordingFrahment$Amm5I1qWJPYLgC2ZLaKI7O-UVkg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFansGroupRecordingFrahment.this.b(view);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansGroupRecordingFrahment$lA2lZcQhfrTkAzwance_zw8eWB4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFansGroupRecordingFrahment.this.a(view);
            }
        });
        j().m();
    }

    public void a(List<LiveFansGroupModel> list) {
        if (list == null || list.size() == 0) {
            c("FANS_GROUP_LIST_NULL");
            return;
        }
        List<FitemFansGroupRecording> list2 = this.f;
        if (list2 == null) {
            this.f = new ArrayList();
        } else {
            list2.clear();
        }
        for (LiveFansGroupModel liveFansGroupModel : list) {
            this.f.add(new FitemFansGroupRecording(liveFansGroupModel, j()));
        }
        this.a.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        b();
    }

    public void c(String str) {
        this.b.setText(getString(R.string.live_fans_group_not_create));
        this.a.setVisibility(0);
        this.c.setVisibility(0);
        this.d.setVisibility(8);
    }

    public void d(String str) {
        this.b.setText(getString(R.string.live_window_load_fail));
        this.a.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    public void e(String str) {
        EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_FANS_CLUB_PAGE_CREATE_GROUP_SUCCESS, LiveRoomManager.a().e(), str);
        ToastUtils.b("创建成功");
    }

    public void f(String str) {
        ToastUtils.b("升级成功");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.live_fans_group_recording;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
