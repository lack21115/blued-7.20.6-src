package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IRewardConfigView;
import com.blued.android.module.live_china.manager.GrabRewardPayManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.model.LiveRewardConfigSumModel;
import com.blued.android.module.live_china.model.LiveRewardDescribe;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.presenter.LiveRewardConfigPresenter;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.bytedance.applog.tracker.Tracker;
import java.util.HashMap;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRewardConfigView.class */
public class PopRewardConfigView implements View.OnClickListener, IRewardConfigView {
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private View D;
    private View E;
    private ImageView F;
    private ImageView G;
    private TextView H;
    private View I;
    private TextView J;
    private View K;
    private View L;
    private View M;
    private EditText N;
    private View O;
    private LinearLayout P;
    private LinearLayout Q;
    private ViewGroup R;
    private ViewGroup S;
    private ViewGroup T;
    private ImageView U;
    private boolean X;
    public View a;
    public View b;
    public View c;
    public Context d;
    public BaseFragment e;
    public LayoutInflater f;
    public RecordingOnliveFragment g;
    private MyPopupWindow h;
    private LinearLayout i;
    private ImageView j;
    private TextView k;
    private LinearLayout l;
    private ImageView m;
    private TextView n;
    private LinearLayout o;
    private ImageView p;
    private TextView q;
    private Button r;
    private Button s;
    private Button t;
    private ImageView u;
    private ImageView v;
    private ShapeFrameLayout w;
    private TextView x;
    private TextView y;
    private TextView z;
    private ScaleAnimation V = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 2, 0.5f, 2, 0.5f);
    private ScaleAnimation W = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 2, 0.5f, 2, 0.5f);
    private LiveRewardConfigModel Y = new LiveRewardConfigModel();
    private HashMap<Integer, LiveRewardConfigSumModel> Z = new HashMap<>();
    private TextWatcher aa = new TextWatcher() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.8
        private int b;
        private int c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = PopRewardConfigView.this.N.getSelectionStart();
            this.c = PopRewardConfigView.this.N.getSelectionEnd();
            PopRewardConfigView.this.N.removeTextChangedListener(PopRewardConfigView.this.aa);
            while (editable.length() > 20) {
                editable.delete(this.b - 1, this.c);
                this.b--;
                this.c--;
            }
            PopRewardConfigView.this.N.setSelection(this.b);
            PopRewardConfigView.this.N.addTextChangedListener(PopRewardConfigView.this.aa);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRewardConfigView$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopRewardConfigView.this.f();
            } catch (Exception e) {
                a();
            }
        }
    }

    public PopRewardConfigView(BaseFragment baseFragment) {
        this.e = baseFragment;
        this.d = baseFragment.getContext();
        l();
        c();
        m();
    }

    public static PopRewardConfigView a(BaseFragment baseFragment) {
        PopRewardConfigCenterView popRewardConfigCenterView = LiveFloatManager.a().C() ? new PopRewardConfigCenterView(baseFragment) : new PopRewardConfigView(baseFragment);
        popRewardConfigCenterView.d();
        return popRewardConfigCenterView;
    }

    private void a(View view) {
        if (view.getId() == R.id.live_reward_num1) {
            this.Y.count = Integer.valueOf(this.r.getText().toString()).intValue();
        } else if (view.getId() == R.id.live_reward_num2) {
            this.Y.count = Integer.valueOf(this.s.getText().toString()).intValue();
        } else if (view.getId() == R.id.live_reward_num3) {
            this.Y.count = Integer.valueOf(this.t.getText().toString()).intValue();
        }
        s();
    }

    private void b(View view) {
        LiveRewardConfigSumModel liveRewardConfigSumModel = this.Z.get(Integer.valueOf(view.getId()));
        if (liveRewardConfigSumModel != null) {
            this.Y.beans = liveRewardConfigSumModel.beans;
            this.Y.size = liveRewardConfigSumModel.size;
            this.Y.hb_beans_id = liveRewardConfigSumModel.hb_beans_id;
        }
    }

    private void c(View view) {
        if (view.getId() == R.id.live_reward_sum_layout1) {
            this.i.setBackgroundResource(R.drawable.shape_live_round_red_solid);
            this.l.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.o.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.k.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
            this.n.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.q.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.j.setImageResource(R.drawable.live_red_bean_icon);
            this.m.setImageResource(R.drawable.live_white_bean_icon);
            this.p.setImageResource(R.drawable.live_white_bean_icon);
        } else if (view.getId() == R.id.live_reward_sum_layout2) {
            this.i.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.l.setBackgroundResource(R.drawable.shape_live_round_red_solid);
            this.o.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.k.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.n.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
            this.q.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.j.setImageResource(R.drawable.live_white_bean_icon);
            this.m.setImageResource(R.drawable.live_red_bean_icon);
            this.p.setImageResource(R.drawable.live_white_bean_icon);
        } else if (view.getId() == R.id.live_reward_sum_layout3) {
            this.i.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.l.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.o.setBackgroundResource(R.drawable.shape_live_round_red_solid);
            this.k.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.n.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.q.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
            this.j.setImageResource(R.drawable.live_white_bean_icon);
            this.m.setImageResource(R.drawable.live_white_bean_icon);
            this.p.setImageResource(R.drawable.live_red_bean_icon);
        } else if (view.getId() == R.id.live_reward_num1) {
            this.r.setBackgroundResource(R.drawable.shape_live_round_red_solid);
            this.s.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.t.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.r.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
            this.s.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.t.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
        } else if (view.getId() == R.id.live_reward_num2) {
            this.r.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.s.setBackgroundResource(R.drawable.shape_live_round_red_solid);
            this.t.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.r.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.s.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
            this.t.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
        } else if (view.getId() == R.id.live_reward_num3) {
            this.r.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.s.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
            this.t.setBackgroundResource(R.drawable.shape_live_round_red_solid);
            this.r.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.s.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
            this.t.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
        }
    }

    private void l() {
        this.f = LayoutInflater.from(this.d);
        b();
        View findViewById = this.a.findViewById(R.id.tv_bg);
        this.b = findViewById;
        findViewById.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        View findViewById2 = this.a.findViewById(R.id.ll_content);
        this.c = findViewById2;
        findViewById2.setVisibility(8);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.a, -1, -1, true);
        this.h = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.h.setTouchable(true);
        this.h.setOutsideTouchable(true);
        this.h.setFocusable(true);
        this.h.update();
        this.i = (LinearLayout) this.a.findViewById(R.id.live_reward_sum_layout1);
        this.j = (ImageView) this.a.findViewById(R.id.live_reward_sum_image1);
        this.k = (TextView) this.a.findViewById(R.id.live_reward_sum1);
        this.l = (LinearLayout) this.a.findViewById(R.id.live_reward_sum_layout2);
        this.m = (ImageView) this.a.findViewById(R.id.live_reward_sum_image2);
        this.n = (TextView) this.a.findViewById(R.id.live_reward_sum2);
        this.o = (LinearLayout) this.a.findViewById(R.id.live_reward_sum_layout3);
        this.p = (ImageView) this.a.findViewById(R.id.live_reward_sum_image3);
        this.q = (TextView) this.a.findViewById(R.id.live_reward_sum3);
        this.r = (Button) this.a.findViewById(R.id.live_reward_num1);
        this.s = (Button) this.a.findViewById(R.id.live_reward_num2);
        this.t = (Button) this.a.findViewById(R.id.live_reward_num3);
        this.u = (ImageView) this.a.findViewById(R.id.live_reward_condition);
        this.v = (ImageView) this.a.findViewById(R.id.live_fans_condition);
        this.w = (ShapeFrameLayout) this.a.findViewById(R.id.live_reward_send_btn);
        this.x = (TextView) this.a.findViewById(R.id.price_view);
        this.y = (TextView) this.a.findViewById(R.id.give_price_view);
        this.z = (TextView) this.a.findViewById(R.id.top_up_btn);
        this.A = (ImageView) this.a.findViewById(R.id.top_up_icon);
        this.B = (ImageView) this.a.findViewById(R.id.live_reward_help);
        this.C = (ImageView) this.a.findViewById(R.id.live_reward_close);
        this.R = (ViewGroup) this.a.findViewById(R.id.live_reward_loading);
        this.S = (ViewGroup) this.a.findViewById(R.id.live_reward_help_layout);
        this.T = (ViewGroup) this.a.findViewById(R.id.live_reward_config_layout);
        this.U = (ImageView) this.a.findViewById(R.id.live_reward_help_close);
        this.P = (LinearLayout) this.a.findViewById(R.id.ll_reward_condition);
        this.Q = (LinearLayout) this.a.findViewById(R.id.ll_fans_condition);
        this.D = this.a.findViewById(R.id.ll_gift);
        this.E = this.a.findViewById(R.id.ll_gift_tip);
        this.F = (ImageView) this.a.findViewById(R.id.iv_gift_delete);
        this.G = (ImageView) this.a.findViewById(R.id.iv_gift_add);
        this.H = (TextView) this.a.findViewById(R.id.tv_reward_gift_num);
        this.I = this.a.findViewById(R.id.ll_word);
        this.J = (TextView) this.a.findViewById(R.id.tv_word);
        this.K = this.a.findViewById(R.id.iv_word_icon);
        this.L = this.a.findViewById(R.id.ll_reward_word);
        this.M = this.a.findViewById(R.id.tv_word_cancel);
        EditText editText = (EditText) this.a.findViewById(R.id.et_word);
        this.N = editText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.O = this.a.findViewById(R.id.tv_word_ok);
        this.b.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.K.setOnClickListener(this);
        s();
        this.K.setOnClickListener(this);
    }

    private void m() {
        this.V.setDuration(300L);
        this.W.setDuration(300L);
        this.V.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (PopRewardConfigView.this.T.getVisibility() == 0) {
                    PopRewardConfigView.this.T.setAnimation(null);
                    PopRewardConfigView.this.T.setVisibility(8);
                    PopRewardConfigView.this.S.setVisibility(0);
                    PopRewardConfigView.this.S.startAnimation(PopRewardConfigView.this.W);
                    return;
                }
                PopRewardConfigView.this.S.setAnimation(null);
                PopRewardConfigView.this.T.setVisibility(0);
                PopRewardConfigView.this.S.setVisibility(8);
                PopRewardConfigView.this.T.startAnimation(PopRewardConfigView.this.W);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private void n() {
        this.N.setText(this.J.getText());
        this.L.setVisibility(0);
        this.L.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
        h();
    }

    private void o() {
        this.L.setVisibility(8);
        this.L.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
        i();
    }

    private void p() {
        final LiveCustomViewDialog liveCustomViewDialog = new LiveCustomViewDialog(this.d);
        View inflate = LayoutInflater.from(AppInfo.d()).inflate(R.layout.live_reward_gift_tip_view, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_reward_region_content)).setText(String.format(this.d.getString(R.string.live_reward_envelop), LiveRoomInfo.a().c()));
        inflate.findViewById(R.id.iv_reward_region_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                liveCustomViewDialog.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.tv_agree)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopRewardConfigView.this.q();
                LiveRoomPreferences.K();
                liveCustomViewDialog.dismiss();
            }
        });
        liveCustomViewDialog.a(inflate, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (t()) {
            return;
        }
        this.Y.prize_total++;
        s();
    }

    private void r() {
        if (this.Y.prize_total <= 0) {
            return;
        }
        this.Y.prize_total--;
        s();
    }

    private void s() {
        int i = (int) (this.Y.count * 0.1f);
        LiveRewardConfigModel liveRewardConfigModel = this.Y;
        if (liveRewardConfigModel != null && liveRewardConfigModel.prize_total > i) {
            this.Y.prize_total = i;
        }
        this.H.setText(String.valueOf(this.Y.prize_total));
        if (this.Y.prize_total == i) {
            this.G.setImageResource(R.drawable.live_reward_add_gray);
        } else {
            this.G.setImageResource(R.drawable.live_reward_add);
        }
        if (this.Y.prize_total == 0) {
            this.F.setImageResource(R.drawable.live_reward_delete_gray);
        } else {
            this.F.setImageResource(R.drawable.live_reward_delete);
        }
    }

    private boolean t() {
        LiveRewardConfigModel liveRewardConfigModel = this.Y;
        return liveRewardConfigModel != null && ((float) liveRewardConfigModel.prize_total) >= ((float) this.Y.count) * 0.1f;
    }

    @Override // com.blued.android.module.live_china.live_interface.IRewardConfigView
    public void a() {
        this.R.setVisibility(0);
    }

    public void a(double d, double d2) {
        TextView textView = this.x;
        textView.setText("：" + CommonStringUtils.d(String.valueOf(d + d2)) + this.d.getString(R.string.Live_SendPresent_wandou));
        if (d2 > 0.0d) {
            this.y.setVisibility(0);
            TextView textView2 = this.y;
            textView2.setText("(" + String.format(this.d.getString(R.string.live_contain), CommonStringUtils.d(String.valueOf(d2))) + ")");
        }
    }

    @Override // com.blued.android.module.live_china.live_interface.IRewardConfigView
    public void a(LiveRewardConfigModel liveRewardConfigModel) {
        this.R.setVisibility(8);
        if (liveRewardConfigModel != null) {
            if (liveRewardConfigModel.hb_beans != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= liveRewardConfigModel.hb_beans.size()) {
                        break;
                    }
                    LiveRewardConfigSumModel liveRewardConfigSumModel = liveRewardConfigModel.hb_beans.get(i2);
                    if (i2 == 0) {
                        this.i.setVisibility(0);
                        TextView textView = this.k;
                        textView.setText(liveRewardConfigSumModel.beans + "");
                        this.Z.put(Integer.valueOf(this.i.getId()), liveRewardConfigSumModel);
                        this.i.performClick();
                    } else if (i2 == 1) {
                        this.l.setVisibility(0);
                        TextView textView2 = this.n;
                        textView2.setText(liveRewardConfigSumModel.beans + "");
                        this.Z.put(Integer.valueOf(this.l.getId()), liveRewardConfigSumModel);
                    } else if (i2 == 2) {
                        this.o.setVisibility(0);
                        TextView textView3 = this.q;
                        textView3.setText(liveRewardConfigSumModel.beans + "");
                        this.Z.put(Integer.valueOf(this.o.getId()), liveRewardConfigSumModel);
                    }
                    i = i2 + 1;
                }
            }
            if (liveRewardConfigModel.hb_count != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= liveRewardConfigModel.hb_count.length) {
                        break;
                    }
                    int i5 = liveRewardConfigModel.hb_count[i4];
                    if (i4 == 0) {
                        this.r.setVisibility(0);
                        Button button = this.r;
                        button.setText(i5 + "");
                    } else if (i4 == 1) {
                        this.s.setVisibility(0);
                        Button button2 = this.s;
                        button2.setText(i5 + "");
                    } else if (i4 == 2) {
                        this.t.setVisibility(0);
                        Button button3 = this.t;
                        button3.setText(i5 + "");
                    }
                    i3 = i4 + 1;
                }
                int length = liveRewardConfigModel.hb_count.length;
                if (length == 1 || length == 2) {
                    this.r.performClick();
                } else if (length != 3) {
                    this.r.performClick();
                } else {
                    this.s.performClick();
                }
            }
            if (liveRewardConfigModel.users_beans != null) {
                a(liveRewardConfigModel.users_beans.beans, liveRewardConfigModel.users_beans.bonus);
            }
            if (liveRewardConfigModel.hb_type == 1 || liveRewardConfigModel.hb_type == 3) {
                this.I.setVisibility(0);
            }
            if (liveRewardConfigModel.hb_type == 2 || liveRewardConfigModel.hb_type == 3) {
                this.D.setVisibility(0);
                this.E.setVisibility(0);
            }
        }
    }

    public void b() {
        this.a = this.f.inflate(R.layout.pop_reward, (ViewGroup) null);
    }

    public void c() {
        BaseFragment baseFragment = this.e;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.g = (RecordingOnliveFragment) baseFragment;
        }
    }

    public void d() {
        this.b.clearAnimation();
        this.c.clearAnimation();
        if (this.h.isShowing()) {
            this.h.a();
        }
        this.h.showAtLocation(this.c, 80, 0, 0);
        this.c.setVisibility(0);
        e();
    }

    public void e() {
        Logger.a("drb", "showAnim");
        this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Logger.a("drb", "onAnimationEnd");
                PopRewardConfigView popRewardConfigView = PopRewardConfigView.this;
                new LiveRewardConfigPresenter(popRewardConfigView, popRewardConfigView.e.getFragmentActive()).a();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.startAnimation(alphaAnimation);
    }

    public void f() {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.5
            @Override // java.lang.Runnable
            public void run() {
                PopRewardConfigView.this.h.a();
            }
        }, 320L);
        g();
        this.c.setVisibility(8);
    }

    public void g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
    }

    public void h() {
        this.N.setFocusableInTouchMode(true);
        this.N.setFocusable(true);
        this.N.requestFocus();
        ((InputMethodManager) this.e.getActivity().getSystemService("input_method")).showSoftInput(this.N, 0);
    }

    public void i() {
        ((InputMethodManager) this.e.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.N.getWindowToken(), 0);
    }

    public void j() {
    }

    public void k() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.ll_reward_condition) {
            this.X = true;
            this.u.setImageResource(R.drawable.live_condition_select);
            this.v.setImageResource(R.drawable.live_reward_condition_default);
            this.Y.condition = "1|2";
            if (LiveRoomPreferences.k() == 0) {
                AppMethods.d(R.string.live_receive_conditions_details);
                LiveRoomPreferences.b(1);
            }
            ShapeModel shapeModel = new ShapeModel();
            shapeModel.H = DensityUtils.a(this.d, 40.0f);
            shapeModel.k = ContextCompat.getColor(this.d, R.color.syc_dark_FFD4A3);
            this.w.setShapeModel(shapeModel);
        } else if (view.getId() == R.id.ll_fans_condition) {
            if (!LiveRoomManager.a().s()) {
                AppMethods.d(R.string.live_fans_reward_level_tip);
                return;
            }
            this.X = true;
            this.u.setImageResource(R.drawable.live_reward_condition_default);
            this.v.setImageResource(R.drawable.live_condition_select);
            this.Y.condition = "3";
            ShapeModel shapeModel2 = new ShapeModel();
            shapeModel2.H = DensityUtils.a(this.d, 40.0f);
            shapeModel2.k = ContextCompat.getColor(this.d, R.color.syc_dark_FFD4A3);
            this.w.setShapeModel(shapeModel2);
        } else if (view.getId() == R.id.live_reward_send_btn) {
            if (this.X) {
                this.R.setVisibility(0);
                GrabRewardPayManager.a().a(this.d, this.e.getFragmentManager(), this.g.getFragmentActive(), this.Y, String.valueOf(this.g.t), LiveRoomInfo.a().f(), false, this.N.getText().toString(), new GrabRewardPayManager.BackGiftStatusListener() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.7
                    @Override // com.blued.android.module.live_china.manager.GrabRewardPayManager.BackGiftStatusListener
                    public void a() {
                        PopRewardConfigView.this.R.setVisibility(8);
                    }

                    @Override // com.blued.android.module.live_china.manager.GrabRewardPayManager.BackGiftStatusListener
                    public void a(final PayRemaining payRemaining, final LiveRewardDescribe liveRewardDescribe, final LiveRewardConfigModel liveRewardConfigModel) {
                        PopRewardConfigView.this.g.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.view.PopRewardConfigView.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PopRewardConfigView.this.R.setVisibility(8);
                                if (payRemaining.sendGiftStatus == 3) {
                                    Logger.a("drb", "支付成功");
                                    LiveRewardConfigModel liveRewardConfigModel2 = liveRewardConfigModel;
                                    LiveRewardModel liveRewardModel = new LiveRewardModel(payRemaining.hongbao_id, payRemaining.start_second, payRemaining.end_second, payRemaining.is_anim, liveRewardConfigModel2 != null ? liveRewardConfigModel2.condition : "");
                                    if (PopRewardConfigView.this.g.bw != null) {
                                        PopRewardConfigView.this.g.bw.a(liveRewardModel);
                                    }
                                    if (PopRewardConfigView.this.g.co != null) {
                                        PopRewardConfigView.this.g.co.a(EnumOperation.VIEW_TYPE_RED_BAG.getValue(), liveRewardModel);
                                    }
                                    PopRewardConfigView.this.f();
                                    if (payRemaining.is_anim == 1) {
                                        LiveGiftModel liveGiftModel = new LiveGiftModel();
                                        liveGiftModel.anim_code = "hongbao";
                                        PopRewardConfigView.this.g.dd.e(liveGiftModel);
                                        if (TextUtils.equals(liveRewardConfigModel.size, "L")) {
                                            LiveGiftModel liveGiftModel2 = new LiveGiftModel();
                                            liveGiftModel2.anim_code = payRemaining.ar_name;
                                            liveGiftModel2.resource_url = payRemaining.resource_url;
                                            PopRewardConfigView.this.g.dd.a(liveGiftModel2);
                                        }
                                    }
                                    LiveRewardDescribe liveRewardDescribe2 = liveRewardDescribe;
                                    if (liveRewardDescribe2 == null || liveRewardDescribe2.m_hb_activity == null) {
                                        return;
                                    }
                                    if (liveRewardDescribe.m_hb_activity.stage == 1) {
                                        RecordingOnliveFragment recordingOnliveFragment = PopRewardConfigView.this.g;
                                        String string = PopRewardConfigView.this.d.getString(R.string.live_reward_special);
                                        recordingOnliveFragment.i(String.format(string, liveRewardDescribe.m_hb_activity.need_count + "", CommonStringUtils.d(Double.toString(liveRewardDescribe.m_hb_activity.beans))));
                                    } else if (liveRewardDescribe.m_hb_activity.stage == 2) {
                                        RecordingOnliveFragment recordingOnliveFragment2 = PopRewardConfigView.this.g;
                                        String string2 = PopRewardConfigView.this.d.getString(R.string.live_reward_horn);
                                        recordingOnliveFragment2.i(String.format(string2, liveRewardDescribe.m_hb_activity.need_count + "", CommonStringUtils.d(Double.toString(liveRewardDescribe.m_hb_activity.beans))));
                                    }
                                }
                            }
                        });
                    }
                });
            }
        } else if (view.getId() == R.id.top_up_btn || view.getId() == R.id.top_up_icon) {
            if (this.g.d(true)) {
                InstantLog.a("charge_from_red_envelope");
                if (!LiveDataManager.a().f()) {
                    LiveRoomInfo.a().a(this.d, this.e.getChildFragmentManager(), 3);
                    return;
                }
                f();
                LiveRoomInfo.a().a(this.d, 3);
            }
        } else if (view.getId() == R.id.live_reward_help) {
            this.T.startAnimation(this.V);
        } else if (view.getId() == R.id.live_reward_close) {
            f();
        } else if (view.getId() == R.id.live_reward_help_close) {
            this.S.startAnimation(this.V);
        } else if (view.getId() == R.id.live_reward_sum_layout1) {
            c(view);
            b(view);
        } else if (view.getId() == R.id.live_reward_sum_layout2) {
            c(view);
            b(view);
        } else if (view.getId() == R.id.live_reward_sum_layout3) {
            c(view);
            b(view);
        } else if (view.getId() == R.id.live_reward_num1) {
            c(view);
            a(view);
        } else if (view.getId() == R.id.live_reward_num2) {
            c(view);
            a(view);
        } else if (view.getId() == R.id.live_reward_num3) {
            c(view);
            a(view);
        } else if (view.getId() == R.id.tv_word) {
            n();
        } else if (view.getId() == R.id.iv_word_icon) {
            n();
        } else if (view.getId() == R.id.tv_bg) {
            if (this.L.getVisibility() == 0) {
                o();
            } else {
                f();
            }
        } else if (view.getId() == R.id.tv_word_cancel) {
            o();
        } else if (view.getId() == R.id.tv_word_ok) {
            if (this.N.length() > 20) {
                AppMethods.d(R.string.live_reward_word_hint);
                return;
            }
            o();
            this.J.setText(this.N.getText());
            if (TextUtils.isEmpty(this.J.getText().toString())) {
                this.K.setVisibility(8);
            } else {
                this.K.setVisibility(0);
            }
        } else if (view.getId() != R.id.iv_gift_add) {
            if (view.getId() == R.id.iv_gift_delete) {
                r();
            }
        } else if (LiveRoomPreferences.J()) {
            q();
        } else {
            p();
        }
    }
}
