package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fitem.FitemAnnounceFansGroup;
import com.blued.android.module.live_china.fragment.LiveAnnoContentDialogFragment;
import com.blued.android.module.live_china.fragment.LiveAnnoFansTimeDialogFragment;
import com.blued.android.module.live_china.fragment.LiveAnnoTimeDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveAnnounceFansModel;
import com.blued.android.module.live_china.model.LiveAnnounceInfoExtra;
import com.blued.android.module.live_china.model.LiveAnnounceInfoModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveAnnounceDialogFragment.class */
public class LiveAnnounceDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    public Context a;
    public View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private ToggleButton k;
    private ToggleButton l;
    private ToggleButton m;
    private ToggleButton n;
    private RecyclerView o;
    private FreedomAdapter p;
    private List<FitemAnnounceFansGroup> q;
    private LiveAnnoContentDialogFragment r;
    private LiveAnnoTimeDialogFragment s;
    private LiveAnnoFansTimeDialogFragment t;
    private IEventCallback u;
    private LiveAnnounceInfoModel v = new LiveAnnounceInfoModel();
    private ArrayList<String> w = new ArrayList<>();
    private LiveAnnounceInfoModel x = new LiveAnnounceInfoModel();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveAnnounceDialogFragment$IEventCallback.class */
    public interface IEventCallback {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        this.v.fans_group_remind_time = i;
        TextView textView = this.j;
        textView.setText("开播前" + i + "分钟");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntity<LiveAnnounceInfoModel, LiveAnnounceInfoExtra> bluedEntity) {
        ToggleButton toggleButton = this.k;
        boolean z = true;
        if (this.v.controller != 1) {
            z = false;
        }
        toggleButton.setChecked(z);
        this.g.setVisibility(this.k.isChecked() ? 8 : 0);
        this.c.setVisibility(this.k.isChecked() ? 0 : 8);
        if (bluedEntity != null && bluedEntity.extra != null && bluedEntity.extra.option_notice != null) {
            this.w.clear();
            this.w.addAll(bluedEntity.extra.option_notice);
        }
        m();
        n();
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, long j) {
        this.v.live_week_time = str;
        this.v.live_time = j / 1000;
        this.i.setText(LiveUtils.a(this.v));
    }

    private void l() {
        getArguments();
    }

    private void m() {
        if (TextUtils.isEmpty(this.v.notice)) {
            this.h.setText(getText(R.string.live_announce_select));
        } else {
            this.h.setText(this.v.notice);
        }
        ToggleButton toggleButton = this.l;
        int i = 0;
        boolean z = true;
        if (this.v.notice_controller != 1) {
            z = false;
        }
        toggleButton.setChecked(z);
        View view = this.d;
        if (!this.l.isChecked()) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void n() {
        String a = LiveUtils.a(this.v);
        if (TextUtils.isEmpty(a)) {
            this.i.setText(getText(R.string.live_announce_select));
        } else {
            this.i.setText(a);
        }
        ToggleButton toggleButton = this.m;
        int i = 0;
        boolean z = true;
        if (this.v.live_time_controller != 1) {
            z = false;
        }
        toggleButton.setChecked(z);
        View view = this.e;
        if (!this.m.isChecked()) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void o() {
        if (this.v.fans_group_remind_time <= 0) {
            this.j.setText(getText(R.string.live_announce_select));
        } else {
            this.j.setText(String.format(this.a.getResources().getString(R.string.live_announce_fans_group_auto_remind_ahead), Integer.valueOf(this.v.fans_group_remind_time)));
        }
        this.n.setChecked(this.v.fans_group_controller == 1);
        this.f.setVisibility(this.n.isChecked() ? 0 : 8);
        if (this.v.fans_group_info == null || this.v.fans_group_info.isEmpty()) {
            this.o.setVisibility(8);
            return;
        }
        this.q = new ArrayList();
        for (LiveAnnounceFansModel liveAnnounceFansModel : this.v.fans_group_info) {
            this.q.add(new FitemAnnounceFansGroup(liveAnnounceFansModel));
        }
        this.o.setLayoutManager(new LinearLayoutManager(this.a) { // from class: com.blued.android.module.live_china.fragment.LiveAnnounceDialogFragment.4
            public boolean canScrollVertically() {
                return false;
            }
        });
        FreedomAdapter freedomAdapter = new FreedomAdapter(this.a, a(), this.q);
        this.p = freedomAdapter;
        this.o.setAdapter(freedomAdapter);
        this.o.setVisibility(0);
    }

    private void p() {
        if (this.v.fans_group_info == null || this.v.fans_group_info.isEmpty()) {
            this.v.fans_group_id = "";
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (LiveAnnounceFansModel liveAnnounceFansModel : this.v.fans_group_info) {
            if (liveAnnounceFansModel.remind == 1) {
                stringBuffer.append(liveAnnounceFansModel.id + ",");
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        this.v.fans_group_id = stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        String str;
        LiveAnnounceInfoModel liveAnnounceInfoModel = this.v;
        if (liveAnnounceInfoModel == null || liveAnnounceInfoModel.controller != 1) {
            return;
        }
        String a = this.v.live_time_controller == 1 ? LiveUtils.a(this.v) : "";
        String str2 = this.v.notice_controller == 1 ? this.v.notice : "";
        String a2 = this.x.live_time_controller == 1 ? LiveUtils.a(this.x) : "";
        String str3 = this.x.notice_controller == 1 ? this.x.notice : "";
        if (TextUtils.equals(a2, a) && TextUtils.equals(str3, str2)) {
            return;
        }
        if (TextUtils.isEmpty(a) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (!TextUtils.isEmpty(a) && TextUtils.isEmpty(str2)) {
            str = a + "直播";
        } else if (!TextUtils.isEmpty(a) || TextUtils.isEmpty(str2)) {
            str = a + "直播，" + this.v.notice;
        } else {
            str = this.v.notice;
        }
        long g = LiveRoomInfo.a().g();
        String c = LiveRoomInfo.a().c();
        String d = LiveRoomInfo.a().d();
        int r = LiveRoomInfo.a().r();
        SessionProfileModel sessionProfileModel = new SessionProfileModel();
        sessionProfileModel.nickname = c;
        sessionProfileModel.avatar = d;
        LiveChattingModel copy = LiveChattingModel.copy(ChatHelper.getChattingModelForSendmsg(LiveRoomManager.a().d(), (short) 1, str, sessionProfileModel, "", LiveRoomManager.a().j()));
        copy.fromId = g;
        copy.fromNickName = c;
        copy.fromRichLevel = r;
        LiveMsgSendManager.a().a(copy);
    }

    private void r() {
        this.v.fans_group_id = "";
        this.x.fans_group_id = "";
        if (!AppInfo.f().toJson(this.v).equals(AppInfo.f().toJson(this.x))) {
            dismissAllowingStateLoss();
            return;
        }
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(this.a);
        builder.a(this.a.getResources().getString(R.string.live_announce_saved)).a(this.a.getResources().getString(R.string.live_announce_saved_yes), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveAnnounceDialogFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LiveAnnounceDialogFragment.this.k();
            }
        }).b(this.a.getResources().getString(R.string.live_announce_saved_no), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveAnnounceDialogFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LiveAnnounceDialogFragment.this.dismissAllowingStateLoss();
            }
        }).a(false).b(true).h(this.a.getResources().getColor(R.color.syc_dark_BABABA)).a((DialogInterface.OnDismissListener) null).a(0);
        builder.a().show();
    }

    public void d() {
        this.r = new LiveAnnoContentDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("announce", this.w);
        bundle.putString("selected", this.v.notice);
        this.r.a(new LiveAnnoContentDialogFragment.IEventCallback() { // from class: com.blued.android.module.live_china.fragment.LiveAnnounceDialogFragment.2
            @Override // com.blued.android.module.live_china.fragment.LiveAnnoContentDialogFragment.IEventCallback
            public void a(String str) {
                LiveAnnounceDialogFragment.this.v.notice = str;
                if (TextUtils.isEmpty(LiveAnnounceDialogFragment.this.v.notice)) {
                    LiveAnnounceDialogFragment.this.h.setText(LiveAnnounceDialogFragment.this.getText(R.string.live_announce_select));
                } else {
                    LiveAnnounceDialogFragment.this.h.setText(str);
                }
            }
        });
        this.r.setArguments(bundle);
        this.r.show(getChildFragmentManager(), "annoContentDialogFragment");
    }

    public void e() {
        Dialog dialog;
        LiveAnnoContentDialogFragment liveAnnoContentDialogFragment = this.r;
        if (liveAnnoContentDialogFragment == null || (dialog = liveAnnoContentDialogFragment.getDialog()) == null || !dialog.isShowing()) {
            return;
        }
        this.r.dismissAllowingStateLoss();
    }

    public void f() {
        if (this.v.live_time > 86400 && this.v.live_time - 600 < System.currentTimeMillis() / 1000) {
            this.v.live_time = 0L;
            this.v.live_week_time = "0000000";
        }
        this.s = new LiveAnnoTimeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("live_week_time", this.v.live_week_time);
        bundle.putLong("live_time", this.v.live_time * 1000);
        this.s.a(new LiveAnnoTimeDialogFragment.IEventCallback() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveAnnounceDialogFragment$BctDBECMoSteWHFWMQ7ajqYolmQ
            @Override // com.blued.android.module.live_china.fragment.LiveAnnoTimeDialogFragment.IEventCallback
            public final void save(String str, long j) {
                LiveAnnounceDialogFragment.this.a(str, j);
            }
        });
        this.s.setArguments(bundle);
        this.s.show(getChildFragmentManager(), "annoTimeDialogFragment");
    }

    public void g() {
        Dialog dialog;
        LiveAnnoTimeDialogFragment liveAnnoTimeDialogFragment = this.s;
        if (liveAnnoTimeDialogFragment == null || (dialog = liveAnnoTimeDialogFragment.getDialog()) == null || !dialog.isShowing()) {
            return;
        }
        this.s.dismissAllowingStateLoss();
    }

    public void h() {
        this.t = new LiveAnnoFansTimeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("aheadTime", this.v.fans_group_remind_time);
        this.t.a(new LiveAnnoFansTimeDialogFragment.IEventCallback() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveAnnounceDialogFragment$bsvnpy5RpUXT4MHSKQvAd10LY2o
            @Override // com.blued.android.module.live_china.fragment.LiveAnnoFansTimeDialogFragment.IEventCallback
            public final void save(int i) {
                LiveAnnounceDialogFragment.this.a(i);
            }
        });
        this.t.setArguments(bundle);
        this.t.show(getChildFragmentManager(), "annoTimeDialogFragment");
    }

    public void i() {
        Dialog dialog;
        LiveAnnoFansTimeDialogFragment liveAnnoFansTimeDialogFragment = this.t;
        if (liveAnnoFansTimeDialogFragment == null || (dialog = liveAnnoFansTimeDialogFragment.getDialog()) == null || !dialog.isShowing()) {
            return;
        }
        this.t.dismissAllowingStateLoss();
    }

    public void j() {
        LiveRoomHttpUtils.F(new BluedUIHttpResponse<BluedEntity<LiveAnnounceInfoModel, LiveAnnounceInfoExtra>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveAnnounceDialogFragment.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveAnnounceDialogFragment.this.dismissAllowingStateLoss();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveAnnounceInfoModel, LiveAnnounceInfoExtra> bluedEntity) {
                if (bluedEntity != null && bluedEntity.data != null && bluedEntity.data.size() > 0 && bluedEntity.data.get(0) != null) {
                    LiveAnnounceDialogFragment.this.v = bluedEntity.data.get(0);
                }
                ReflectionUtils.a(LiveAnnounceDialogFragment.this.v, LiveAnnounceDialogFragment.this.x);
                LiveAnnounceDialogFragment.this.a(bluedEntity);
            }
        });
    }

    public void k() {
        p();
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveAnnounceInfoModel>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveAnnounceDialogFragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveAnnounceInfoModel> bluedEntityA) {
                LiveAnnounceDialogFragment.this.dismissAllowingStateLoss();
                LiveAnnounceDialogFragment.this.q();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveAnnounceDialogFragment.this.dismissAllowingStateLoss();
                return super.onUIFailure(i, str);
            }
        }, this.v);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_announce, (ViewGroup) null);
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.blued.android.module.live_china.fragment.LiveAnnounceDialogFragment.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                Dialog dialog2;
                Dialog dialog3;
                if (LiveAnnounceDialogFragment.this.r == null || (dialog3 = LiveAnnounceDialogFragment.this.r.getDialog()) == null || !dialog3.isShowing()) {
                    return (LiveAnnounceDialogFragment.this.s == null || (dialog2 = LiveAnnounceDialogFragment.this.s.getDialog()) == null || !dialog2.isShowing()) ? false : true;
                }
                return true;
            }
        });
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, height));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = height;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - height;
        dialog.onWindowAttributesChanged(attributes);
        l();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_announce, viewGroup);
        this.b = inflate;
        this.d = inflate.findViewById(R.id.ll_to_anno_content);
        this.e = this.b.findViewById(R.id.ll_time);
        this.f = this.b.findViewById(R.id.ll_fans);
        this.h = (TextView) this.b.findViewById(R.id.tv_selectd);
        this.i = (TextView) this.b.findViewById(R.id.tv_selectd_time);
        this.j = (TextView) this.b.findViewById(R.id.tv_selectd_remind_time);
        this.c = this.b.findViewById(R.id.fl_main);
        this.k = (ToggleButton) this.b.findViewById(R.id.tglbtn_total_onoff);
        this.l = (ToggleButton) this.b.findViewById(R.id.tglbtn_content_onoff);
        this.m = (ToggleButton) this.b.findViewById(R.id.tglbtn_time_onoff);
        this.n = (ToggleButton) this.b.findViewById(R.id.tglbtn_fans_onoff);
        this.o = this.b.findViewById(R.id.rv_fans_group);
        this.g = (TextView) this.b.findViewById(R.id.tv_notice_tip);
        this.b.findViewById(R.id.empty_view).setOnClickListener(this);
        this.b.findViewById(R.id.save).setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        j();
        IEventCallback iEventCallback = this.u;
        if (iEventCallback != null) {
            iEventCallback.a();
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        IEventCallback iEventCallback = this.u;
        if (iEventCallback != null) {
            iEventCallback.b();
        }
        e();
        g();
        i();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            LiveAnnoContentDialogFragment liveAnnoContentDialogFragment = this.r;
            if (liveAnnoContentDialogFragment != null && liveAnnoContentDialogFragment.d()) {
                return true;
            }
            LiveAnnoTimeDialogFragment liveAnnoTimeDialogFragment = this.s;
            if (liveAnnoTimeDialogFragment != null && liveAnnoTimeDialogFragment.d()) {
                return true;
            }
        }
        return super.onKey(dialogInterface, i, keyEvent);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            com.blued.android.framework.utils.ReflectionUtils.a(this, "mDismissed", false);
            com.blued.android.framework.utils.ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
