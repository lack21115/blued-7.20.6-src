package com.soft.blued.ui.msg;

import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.live_china.model.LiveGuideType;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.find.view.TwoWaysBar;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgBoxSettingDialogFragment.class */
public class MsgBoxSettingDialogFragment extends CommonDialogFragment implements View.OnClickListener {
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    private CommonTopTitleNoTrans f31732c;
    private View d;
    private String e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TwoWaysBar i;
    private TextView j;
    private int k = 0;
    private ToggleButton l;
    private View m;
    private boolean n;

    private void h() {
        try {
            this.e = BluedPreferences.cH();
            this.i.d = 4;
            this.i.a(this.e, 101);
            this.j.setText(TwoWaysBar.a(getContext(), this.e, 4));
            String cG = BluedPreferences.cG();
            if (StringUtils.d(cG)) {
                return;
            }
            Set set = (Set) AppInfo.f().fromJson(cG, (Class<Object>) Set.class);
            if (set.contains("2")) {
                this.g.setSelected(true);
            }
            if (set.contains("1")) {
                this.f.setSelected(true);
            }
            if (set.contains("3")) {
                this.h.setSelected(true);
            }
        } catch (Throwable th) {
            BluedPreferences.T("");
            BluedPreferences.U("");
        }
    }

    private void i() {
        this.j = (TextView) this.d.findViewById(2131371285);
        TwoWaysBar twoWaysBar = (TwoWaysBar) this.d.findViewById(R.id.bar_distance);
        this.i = twoWaysBar;
        twoWaysBar.d = 4;
        this.i.setTwoWaysBarListner(new TwoWaysBar.TwoWaysBarListner() { // from class: com.soft.blued.ui.msg.MsgBoxSettingDialogFragment.1
            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(int i, int i2) {
                if (i == 0 && i2 == 0) {
                    BluedPreferences.U(LiveGuideType.GUIDE_TYPE_OFFICIAL_SAFETY_NOTICE);
                } else if (i == i2) {
                    int i3 = i;
                    if (i == 100) {
                        i3 = 99;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i3);
                    sb.append("-");
                    int i4 = i3 + 1;
                    if (i4 >= 100) {
                        i4 = 100;
                    }
                    sb.append(i4);
                    BluedPreferences.U(sb.toString());
                    i = i3;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    sb2.append("-");
                    sb2.append(i2 >= 100 ? 100 : i2);
                    BluedPreferences.U(sb2.toString());
                }
                MsgBoxSettingDialogFragment.this.j.setText(TwoWaysBar.a(MsgBoxSettingDialogFragment.this.getContext(), i, i2, 4));
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(boolean z) {
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void b(boolean z) {
            }

            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void c(boolean z) {
                if (z || UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                    return;
                }
                MsgBoxSettingDialogFragment.this.k();
            }
        });
        TextView textView = (TextView) this.d.findViewById(R.id.tv_make_friend);
        this.f = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgBoxSettingDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    MsgBoxSettingDialogFragment.this.k();
                } else if (MsgBoxSettingDialogFragment.this.f.isSelected()) {
                    MsgBoxSettingDialogFragment.this.f.setSelected(false);
                } else {
                    MsgBoxSettingDialogFragment.this.f.setSelected(true);
                }
            }
        });
        TextView textView2 = (TextView) this.d.findViewById(R.id.tv_feed);
        this.g = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgBoxSettingDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    MsgBoxSettingDialogFragment.this.k();
                } else if (MsgBoxSettingDialogFragment.this.g.isSelected()) {
                    MsgBoxSettingDialogFragment.this.g.setSelected(false);
                } else {
                    MsgBoxSettingDialogFragment.this.g.setSelected(true);
                }
            }
        });
        TextView textView3 = (TextView) this.d.findViewById(R.id.tv_live);
        this.h = textView3;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgBoxSettingDialogFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    MsgBoxSettingDialogFragment.this.k();
                } else if (MsgBoxSettingDialogFragment.this.h.isSelected()) {
                    MsgBoxSettingDialogFragment.this.h.setSelected(false);
                } else {
                    MsgBoxSettingDialogFragment.this.h.setSelected(true);
                }
            }
        });
        ToggleButton toggleButton = (ToggleButton) this.d.findViewById(R.id.tglbtn_box_onoff);
        this.l = toggleButton;
        toggleButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.msg.MsgBoxSettingDialogFragment.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MsgBoxSettingDialogFragment.this.n || UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                    return false;
                }
                MsgBoxSettingDialogFragment.this.n = true;
                MsgBoxSettingDialogFragment.this.k();
                return true;
            }
        });
        this.m = this.d.findViewById(R.id.filter_lay);
        this.l.setChecked(BluedPreferences.m9667do());
        this.l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.msg.MsgBoxSettingDialogFragment.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                MsgBoxSettingDialogFragment.this.m.setVisibility(z ? 8 : 0);
                MsgBoxSettingDialogFragment.this.b = z;
            }
        });
        this.m.setVisibility(BluedPreferences.m9667do() ? 8 : 0);
        this.m.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.msg.MsgBoxSettingDialogFragment.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void j() {
        HashSet hashSet = new HashSet();
        if (this.g.isSelected()) {
            hashSet.add("2");
        }
        if (this.f.isSelected()) {
            hashSet.add("1");
        }
        if (this.h.isSelected()) {
            hashSet.add("3");
        }
        if (hashSet.isEmpty()) {
            BluedPreferences.T("");
        } else {
            BluedPreferences.T(AppInfo.f().toJson(hashSet));
        }
        BluedPreferences.V(this.l.isChecked());
        if (MsgBoxManager.a().c()) {
            BluedPreferences.n(System.currentTimeMillis());
        }
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_SESSION_LIST).post(null);
        if (MsgBoxManager.a().c()) {
            ToastUtils.a(getResources().getString(R.string.msg_mute_box_open));
        } else {
            MsgBoxManager.a().b();
            ToastUtils.a(getResources().getString(R.string.msg_mute_box_close));
        }
        ChatHttpUtils.a(new BluedUIHttpResponse(a()) { // from class: com.soft.blued.ui.msg.MsgBoxSettingDialogFragment.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, BluedPreferences.cG(), BluedPreferences.cH(), MsgBoxManager.a().c(), a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        PayUtils.a(getContext(), this.k, "msg_no_disturb", 28, VipProtos.FromType.UNKNOWN_FROM);
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public void a(View view) {
        this.d = view;
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370749);
        this.f31732c = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setCenterText(getResources().getString(R.string.msg_mute_box));
        this.f31732c.setRightText(R.string.done);
        this.f31732c.setLeftClickListener(this);
        this.f31732c.setRightClickListener(this);
        this.f31732c.getTitleBackground().setBackground(new ColorDrawable(0));
        ShapeTextView rightTextView = this.f31732c.getRightTextView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rightTextView.getLayoutParams();
        layoutParams.rightMargin = DensityUtils.a(getContext(), 10.0f);
        rightTextView.setLayoutParams(layoutParams);
        rightTextView.setTextColor(getResources().getColor(2131101766));
        ImageView leftImg = this.f31732c.getLeftImg();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) leftImg.getLayoutParams();
        layoutParams2.leftMargin = DensityUtils.a(getContext(), 10.0f);
        leftImg.setLayoutParams(layoutParams2);
        leftImg.setImageResource(2131233904);
        TextView textView = (TextView) view.findViewById(R.id.tv_min_distance);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_max_distance);
        textView.setText("0" + getResources().getString(R.string.msg_mute_box_km));
        textView2.setText("100" + getResources().getString(R.string.msg_mute_box_km));
        i();
        if (getArguments() == null || !getArguments().containsKey("vipFrom")) {
            return;
        }
        this.k = getArguments().getInt("vipFrom");
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int d() {
        return R.layout.fragment_main_msg_box_setting;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int f() {
        return (int) ((AppInfo.m / 6.0f) * 5.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            dismiss();
        } else if (id != 2131363126) {
        } else {
            if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                dismiss();
                return;
            }
            j();
            dismiss();
            EventTrackMessage.a(MessageProtos.Event.MSG_NO_DISTURB_FILTER, this.b);
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.n = false;
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            this.i.a(LiveGuideType.GUIDE_TYPE_OFFICIAL_SAFETY_NOTICE, 101);
            this.i.setEnabled(false);
            return;
        }
        this.i.setEnabled(true);
        h();
    }
}
