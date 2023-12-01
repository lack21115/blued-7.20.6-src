package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LivePKRoundSelectView;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePkRoundSelectDialogFragment.class */
public class LivePkRoundSelectDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    public Context a;
    public View b;
    public String c;
    public String d;
    public String e;
    private LivePKRoundSelectView f;
    private long g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePkRoundSelectDialogFragment$IEventCallback.class */
    public interface IEventCallback {
    }

    private void d() {
        if (getArguments() != null) {
            this.g = getArguments().getLong("delay", 8L);
            this.c = getArguments().getString("lid");
            this.d = getArguments().getString("uid");
            this.e = getArguments().getString("type");
        }
    }

    public void a(int i) {
        LiveRoomHttpUtils.a(i, new StringHttpResponseHandler() { // from class: com.blued.android.module.live_china.fragment.LivePkRoundSelectDialogFragment.2
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(String str) {
                Log.i("==xpm", "s:" + str);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onFailure(Throwable th, int i2, String str) {
                super.onFailure(th, i2, str);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_pk_round_select, (ViewGroup) null);
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, height));
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = height;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - height;
        dialog.onWindowAttributesChanged(attributes);
        d();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        EventTrackLive.b(LiveProtos.Event.LIVE_PK_CHOOSE_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.c, this.d, this.e, 0);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_pk_round_select, viewGroup);
        this.b = inflate;
        LivePKRoundSelectView livePKRoundSelectView = (LivePKRoundSelectView) inflate.findViewById(R.id.pk_select);
        this.f = livePKRoundSelectView;
        livePKRoundSelectView.a(a(), new LivePKRoundSelectView.OnEventCallbck() { // from class: com.blued.android.module.live_china.fragment.LivePkRoundSelectDialogFragment.1
            @Override // com.blued.android.module.live_china.view.LivePKRoundSelectView.OnEventCallbck
            public void a() {
                LivePkRoundSelectDialogFragment.this.dismissAllowingStateLoss();
            }

            @Override // com.blued.android.module.live_china.view.LivePKRoundSelectView.OnEventCallbck
            public void a(int i) {
                EventTrackLive.b(i == 0 ? LiveProtos.Event.LIVE_PK_CHOOSE_POP_ONE_CLICK : LiveProtos.Event.LIVE_PK_CHOOSE_POP_THREE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), LivePkRoundSelectDialogFragment.this.c, LivePkRoundSelectDialogFragment.this.d, LivePkRoundSelectDialogFragment.this.e, 0);
                LivePkRoundSelectDialogFragment.this.a(i);
                LivePkRoundSelectDialogFragment.this.dismissAllowingStateLoss();
            }
        });
        this.f.b(this.g);
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        this.f.a();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onPause() {
        super.onPause();
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
