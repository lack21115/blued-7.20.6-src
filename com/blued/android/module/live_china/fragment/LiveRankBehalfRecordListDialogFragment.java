package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveRankBehalfRecordAdapter;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveRankBehalfRecordsModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRankBehalfRecordListDialogFragment.class */
public class LiveRankBehalfRecordListDialogFragment extends BaseDialogFragment {
    private Context a;
    private RecyclerView b;
    private LiveRankBehalfRecordAdapter c;
    private List<LiveRankBehalfRecordsModel> d;

    private void a(View view) {
        RecyclerView findViewById = view.findViewById(R.id.rv_behalf_rank);
        this.b = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(getContext()));
        LiveRankBehalfRecordAdapter liveRankBehalfRecordAdapter = new LiveRankBehalfRecordAdapter(getContext(), a());
        this.c = liveRankBehalfRecordAdapter;
        liveRankBehalfRecordAdapter.setNewData(this.d);
        this.b.setAdapter(this.c);
        view.findViewById(R.id.iv_behalf_back).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRankBehalfRecordListDialogFragment$-i7uxcXjTw8ywVh1_eFnbrNL14Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveRankBehalfRecordListDialogFragment.this.c(view2);
            }
        });
        view.findViewById(R.id.iv_common_help).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRankBehalfRecordListDialogFragment$OcIBVPwth_krQoeMqjnAk-T4eqc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveRankBehalfRecordListDialogFragment.b(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view) {
        LiveEventBus.get("live_rank_behalf_tips_show", Boolean.class).post(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        dismiss();
    }

    public void a(List<LiveRankBehalfRecordsModel> list) {
        this.d = list;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        boolean C = LiveFloatManager.a().C();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_rank_behalf, (ViewGroup) null);
        int a = DensityUtils.a(getActivity(), 360.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (C) {
            dialog.setContentView(inflate, new ViewGroup.LayoutParams(DensityUtils.a(getActivity(), 360.0f), -1));
        } else {
            dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, DensityUtils.a(getActivity(), 360.0f)));
        }
        Window window = dialog.getWindow();
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        window.setWindowAnimations(C ? R.style.rank_menu_animstyle : R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = height - a;
        attributes.width = C ? DensityUtils.a(getActivity(), 360.0f) : -1;
        attributes.height = C ? -1 : DensityUtils.a(getActivity(), 360.0f);
        attributes.gravity = 5;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_rank_behalf, viewGroup);
        a(inflate);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
