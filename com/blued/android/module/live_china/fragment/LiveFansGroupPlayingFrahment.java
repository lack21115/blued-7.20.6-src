package com.blued.android.module.live_china.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fitem.FitemFansGroupPlaying;
import com.blued.android.module.live_china.fragment.LiveFansApplyJoinGroupDialogFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansGroupModel;
import com.blued.android.module.live_china.presenter.LiveFansGroupPlayingPresent;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansGroupPlayingFrahment.class */
public class LiveFansGroupPlayingFrahment extends MvpFragment<LiveFansGroupPlayingPresent> implements OnClickCallback {
    private View a;
    private TextView b;
    private RecyclerView c;
    private ShapeTextView d;
    private View e;
    private FreedomAdapter f;
    private boolean g = false;
    private List<FitemFansGroupPlaying> k;
    private FitemFansGroupPlaying l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        FitemFansGroupPlaying fitemFansGroupPlaying = this.l;
        if (fitemFansGroupPlaying == null || fitemFansGroupPlaying.b == null) {
            return;
        }
        if (this.l.b.allow_join != 1) {
            new LiveFansApplyJoinGroupDialogFragment(getContext(), this.l.b, new LiveFansApplyJoinGroupDialogFragment.CallBack() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansGroupPlayingFrahment$NtMJTSTmvdFIP88JHoj2KvHEUKA
                @Override // com.blued.android.module.live_china.fragment.LiveFansApplyJoinGroupDialogFragment.CallBack
                public final void onSuccess() {
                    LiveFansGroupPlayingFrahment.this.d();
                }
            }).show(getFragmentManager(), "applyJoinFansGroupDialog");
            return;
        }
        this.e.setVisibility(0);
        j().a(this.l.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.e.setVisibility(0);
        j().m();
    }

    private void b() {
        RecyclerView recyclerView;
        int a;
        if (this.k == null || (recyclerView = this.c) == null) {
            return;
        }
        if (this.f == null || recyclerView.getAdapter() == null) {
            this.c.setLayoutManager(new LinearLayoutManager(getContext()));
            FreedomAdapter freedomAdapter = new FreedomAdapter(getContext(), getFragmentActive(), this.k, this);
            this.f = freedomAdapter;
            this.c.setAdapter(freedomAdapter);
        } else {
            this.f.notifyDataSetChanged();
        }
        int a2 = DensityUtils.a(getContext(), 17.0f);
        if (this.g) {
            this.f.a((OnClickCallback) null);
            a = a2;
        } else {
            this.f.a(this);
            a = DensityUtils.a(getContext(), 76.0f);
        }
        this.c.setPadding(0, a2, 0, a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        FitemFansGroupPlaying fitemFansGroupPlaying = this.l;
        if (fitemFansGroupPlaying == null || fitemFansGroupPlaying.b.apply_status != 0) {
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_USER_FANS_CLUB_PAGE_APPLY_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.l.b.group_id);
        this.e.setVisibility(0);
        j().n();
    }

    private void b(List<LiveFansGroupModel> list) {
        this.g = false;
        for (LiveFansGroupModel liveFansGroupModel : list) {
            if (liveFansGroupModel.apply_status == 3) {
                this.g = true;
            }
            this.k.add(new FitemFansGroupPlaying(liveFansGroupModel));
        }
        if (this.k.size() <= 0 || this.g) {
            this.l = null;
        } else {
            Iterator<FitemFansGroupPlaying> it = this.k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FitemFansGroupPlaying next = it.next();
                if (next.b.group_now_population < next.b.group_max_population) {
                    next.a(true);
                    this.l = next;
                    c();
                    break;
                }
            }
            if (this.l == null) {
                this.k.get(0).a(true);
                this.l = this.k.get(0);
                c();
            }
        }
        b();
    }

    private void c() {
        FitemFansGroupPlaying fitemFansGroupPlaying = this.l;
        if (fitemFansGroupPlaying == null) {
            return;
        }
        int i = fitemFansGroupPlaying.b.apply_status;
        if (i == 0) {
            this.d.setText(R.string.live_fans_apply_join_group);
            this.d.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
            ShapeHelper.a(this.d, R.color.syc_dark_922cee, R.color.syc_dark_ff3aaa);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (i == 1) {
            this.d.setText(R.string.live_fans_apply_join_group_ing);
            this.d.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
            ShapeHelper.a(this.d, R.color.syc_dark_CA96F7, R.color.syc_dark_FF9DD5);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (i != 2) {
            if (this.d.getVisibility() != 8) {
                this.d.setVisibility(8);
            }
        } else {
            this.d.setText(R.string.live_fans_apply_join_group_refuse);
            ShapeHelper.a(this.d, R.color.syc_dark_c, R.color.syc_dark_c);
            this.d.setTextColor(ContextCompat.getColor(getContext(), R.color.syc_k));
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        f("200");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = this.i.findViewById(R.id.rl_not_data);
        this.b = (TextView) this.i.findViewById(R.id.tv_not_data);
        this.c = this.i.findViewById(R.id.recycler_view);
        this.d = (ShapeTextView) this.i.findViewById(R.id.tv_apply_join);
        this.e = this.i.findViewById(R.id.loading);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansGroupPlayingFrahment$xLKVo00xE5PfbyrF33fbxPMFBiQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFansGroupPlayingFrahment.this.b(view);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansGroupPlayingFrahment$fWUIzlhg3w_QOKsKcja2t1bsGgw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFansGroupPlayingFrahment.this.a(view);
            }
        });
        j().m();
        this.e.setVisibility(0);
    }

    public void a(List<LiveFansGroupModel> list) {
        this.e.setVisibility(8);
        if (list == null || list.size() == 0) {
            c("FANS_GROUP_LIST_NULL");
            return;
        }
        List<FitemFansGroupPlaying> list2 = this.k;
        if (list2 == null) {
            this.k = new ArrayList();
        } else {
            list2.clear();
        }
        b(list);
    }

    public void c(String str) {
        this.b.setText(R.string.live_fans_group_not_create_to_playing);
        this.a.setVisibility(0);
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        this.e.setVisibility(8);
    }

    public void d(String str) {
        this.b.setText(R.string.live_fans_group_get_data_error);
        this.a.setVisibility(0);
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        this.e.setVisibility(8);
    }

    public void e(String str) {
        if (!"200".equals(str) || this.l == null) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(8);
        CommonAlertDialog.a(getContext(), getString(R.string.live_fans_join_group_dialog_title), getString(R.string.live_fans_join_group_dialog_content), getString(R.string.live_fans_group_dialog_agree), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFansGroupPlayingFrahment$q1HCqxJ7IaVK_1Mg5NmRR3vPaeI
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveFansGroupPlayingFrahment.this.a(dialogInterface, i);
            }
        }, getString(R.string.live_fans_group_dialog_reject), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void f(String str) {
        this.e.setVisibility(8);
        if (!"200".equals(str) || this.l == null) {
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_USER_FANS_CLUB_PAGE_APPLY_SUCCESS, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.l.b.group_id);
        if (this.l.b.allow_join != 1) {
            this.l.b.apply_status = 1;
            c();
            return;
        }
        this.l.b.apply_status = 3;
        this.l.e();
        this.l.f();
        ToastUtils.b("入群成功");
        this.g = true;
        this.l = null;
        this.d.setVisibility(8);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.live_fans_group_playing;
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
        if (this.g) {
            if (this.d.getVisibility() != 8) {
                this.d.setVisibility(8);
                return;
            }
            return;
        }
        List<FitemFansGroupPlaying> list = this.k;
        if (list == null || list.size() <= i) {
            return;
        }
        FitemFansGroupPlaying fitemFansGroupPlaying = this.k.get(i);
        if (this.l != null) {
            if (fitemFansGroupPlaying.b.group_id.equals(this.l.b.group_id)) {
                return;
            }
            this.l.a(false);
        }
        fitemFansGroupPlaying.a(true);
        this.l = fitemFansGroupPlaying;
        c();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
