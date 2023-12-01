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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveManagerAdapter;
import com.blued.android.module.live_china.fragment.LiveRankGuestDialogFragment;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveUserinfoModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveManagerDialogFragment.class */
public class LiveManagerDialogFragment extends BaseDialogFragment {
    public Context a;
    public ListView b;
    public LiveManagerAdapter c;
    public LiveRankGuestDialogFragment.ILiveGuestDialog d;
    private LinearLayout e;
    private View f;
    private View g;
    private ProgressBar h;
    private TextView i;
    private Long j;

    private void e() {
        if (getArguments() != null) {
            this.j = Long.valueOf(getArguments().getLong("KEY_LID"));
        }
    }

    public void a(LiveRankGuestDialogFragment.ILiveGuestDialog iLiveGuestDialog) {
        this.d = iLiveGuestDialog;
    }

    public void d() {
        LiveRoomHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<LiveUserinfoModel>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveManagerDialogFragment.2
            boolean a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveUserinfoModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                LiveManagerDialogFragment.this.c.a(bluedEntityA.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.a = true;
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                if (this.a) {
                    LiveManagerDialogFragment.this.f.setVisibility(8);
                    LiveManagerDialogFragment.this.g.setVisibility(0);
                    LiveManagerDialogFragment.this.h.setVisibility(8);
                    LiveManagerDialogFragment.this.b.setVisibility(4);
                } else if (LiveManagerDialogFragment.this.c.getCount() == 0) {
                    LiveManagerDialogFragment.this.f.setVisibility(0);
                    LiveManagerDialogFragment.this.g.setVisibility(8);
                    LiveManagerDialogFragment.this.h.setVisibility(8);
                    LiveManagerDialogFragment.this.b.setVisibility(4);
                } else {
                    LiveManagerDialogFragment.this.f.setVisibility(8);
                    LiveManagerDialogFragment.this.g.setVisibility(8);
                    LiveManagerDialogFragment.this.h.setVisibility(8);
                    LiveManagerDialogFragment.this.b.setVisibility(0);
                }
                this.a = false;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveManagerDialogFragment.this.f.setVisibility(8);
                LiveManagerDialogFragment.this.g.setVisibility(8);
                LiveManagerDialogFragment.this.h.setVisibility(0);
                LiveManagerDialogFragment.this.b.setVisibility(4);
            }
        }, a());
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        boolean C = LiveFloatManager.a().C();
        View inflate = getActivity().getLayoutInflater().inflate(C ? R.layout.dialog_live_manager_list_land : R.layout.dialog_live_manager_list, (ViewGroup) null);
        int a = DensityUtils.a(getActivity(), 290.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (C) {
            dialog.setContentView(inflate, new ViewGroup.LayoutParams(DensityUtils.a(getActivity(), 360.0f), -1));
        } else {
            dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, DensityUtils.a(getActivity(), 290.0f)));
        }
        Window window = dialog.getWindow();
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        window.setWindowAnimations(C ? R.style.rank_menu_animstyle : R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = height - a;
        attributes.width = C ? DensityUtils.a(getActivity(), 360.0f) : -1;
        attributes.height = C ? -1 : DensityUtils.a(getActivity(), 290.0f);
        attributes.gravity = 5;
        dialog.onWindowAttributesChanged(attributes);
        e();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean C = LiveFloatManager.a().C();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(C ? R.layout.dialog_live_manager_list_land : R.layout.dialog_live_manager_list, viewGroup);
        this.e = (LinearLayout) inflate.findViewById(R.id.dialog_layout);
        this.f = inflate.findViewById(R.id.ll_nodata);
        this.g = inflate.findViewById(R.id.ll_nodata_error);
        this.h = (ProgressBar) inflate.findViewById(R.id.loading_view);
        this.b = (ListView) inflate.findViewById(R.id.list_view);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_reload);
        this.i = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveManagerDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveManagerDialogFragment.this.d();
            }
        });
        Context context = this.a;
        LiveManagerAdapter liveManagerAdapter = new LiveManagerAdapter(context, this.j + "", a());
        this.c = liveManagerAdapter;
        this.b.setAdapter((ListAdapter) liveManagerAdapter);
        d();
        LiveRankGuestDialogFragment.ILiveGuestDialog iLiveGuestDialog = this.d;
        if (iLiveGuestDialog != null) {
            iLiveGuestDialog.r_();
        }
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        LiveRankGuestDialogFragment.ILiveGuestDialog iLiveGuestDialog = this.d;
        if (iLiveGuestDialog != null) {
            iLiveGuestDialog.s_();
        }
    }
}
