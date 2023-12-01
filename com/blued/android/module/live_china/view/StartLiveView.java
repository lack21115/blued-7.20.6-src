package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomExtra;
import com.blued.android.module.live_china.model.LiveShareTextModel;
import com.blued.android.module.live_china.model.StartLiveDialog;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.share.Constants;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.push.core.b;
import com.igexin.sdk.PushConsts;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.soft.blued.constant.EventBusConstant;
import java.io.File;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/StartLiveView.class */
public class StartLiveView extends FrameLayout implements View.OnClickListener {
    private TextView A;
    private View B;
    private View C;
    private Button D;
    private TextView E;
    private View F;
    private RecordingOnliveFragment G;
    private LoadOptions H;
    private String I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private int N;
    private CountDownTimer O;
    private String[] P;
    private String[] Q;
    private boolean R;
    private boolean S;
    private String T;
    private Dialog U;
    private TextView V;
    private View W;

    /* renamed from: a  reason: collision with root package name */
    private Context f15250a;
    private View aa;
    private View ab;
    private View ac;
    private View ad;
    private TextView ae;
    private TextView af;
    private boolean ag;
    private boolean ah;
    private TextWatcher ai;
    private String aj;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private View f15251c;
    private LinearLayout d;
    private RelativeLayout e;
    private TextView f;
    private RelativeLayout g;
    private TextView h;
    private ImageView i;
    private ImageView j;
    private EditText k;
    private View l;
    private View m;
    private ViewGroup n;
    private LinearLayout o;
    private ImageView p;
    private Button q;
    private ImageView r;
    private ImageView s;
    private ImageView t;
    private ImageView u;
    private ImageView v;
    private Button w;
    private TextView x;
    private LinearLayout y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.StartLiveView$9  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/StartLiveView$9.class */
    public class AnonymousClass9 implements PermissionCallbacks {
        AnonymousClass9() {
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void U_() {
            LiveRoomHttpUtils.g(new BluedUIHttpResponse<BluedEntityA<StartLiveDialog>>(StartLiveView.this.G.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.StartLiveView.9.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<StartLiveDialog> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData()) {
                        LiveFloatManager.a().m();
                        StartLiveView.this.i();
                        return;
                    }
                    StartLiveDialog singleData = bluedEntityA.getSingleData();
                    if (singleData.need_popup == 1) {
                        final String str = singleData.confirm_url;
                        String str2 = singleData.confirm_text;
                        String str3 = singleData.cancel_text;
                        CommonAlertDialog.a(StartLiveView.this.f15250a, (View) null, StartLiveView.this.f15250a.getResources().getString(R.string.hint), singleData.popup_title, str3, str2, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.StartLiveView.9.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                                LiveRoomInfo.a().a(StartLiveView.this.f15250a, str);
                            }
                        }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.StartLiveView.9.1.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                                LiveFloatManager.a().m();
                                StartLiveView.this.i();
                            }
                        }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.view.StartLiveView.9.1.3
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                            }
                        }, true);
                    } else if (singleData.need_popup == 2) {
                        String str4 = singleData.popup_title;
                        StartLiveView.this.a(singleData.popup_content, str4);
                    } else if (singleData.need_popup == 3) {
                        LiveSetDataObserver.a().b(singleData.confirm_url, 16);
                    } else {
                        LiveFloatManager.a().m();
                        StartLiveView.this.i();
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    DialogUtils.b(StartLiveView.this.U);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                    DialogUtils.a(StartLiveView.this.U);
                }
            }, StartLiveView.this.G.getFragmentActive());
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void a(String[] strArr) {
        }
    }

    public StartLiveView(Context context) {
        this(context, null);
    }

    public StartLiveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StartLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.N = 15;
        this.ai = new TextWatcher() { // from class: com.blued.android.module.live_china.view.StartLiveView.8
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f15264c;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i2;
                this.b = StartLiveView.this.k.getSelectionStart();
                this.f15264c = StartLiveView.this.k.getSelectionEnd();
                StartLiveView.this.k.removeTextChangedListener(StartLiveView.this.ai);
                String trim = StartLiveView.this.k.getText().toString().trim();
                int i3 = 20;
                int i4 = 0;
                while (i4 < trim.length()) {
                    char charAt = trim.charAt(i4);
                    if (charAt < ' ' || charAt > 'z') {
                        i2 = i3;
                        if (i3 > 10) {
                            i2 = i3 - 1;
                        }
                    } else {
                        i2 = i3;
                    }
                    i4++;
                    i3 = i2;
                }
                Logger.a("drb", "mTextMaxLength - ", Integer.valueOf(i3));
                while (editable.length() > i3) {
                    editable.delete(this.b - 1, this.f15264c);
                    this.b--;
                    this.f15264c--;
                }
                StartLiveView.this.k.setSelection(this.b);
                StartLiveView.this.k.addTextChangedListener(StartLiveView.this.ai);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        this.f15250a = context;
    }

    private void a(long j) {
        String[] strArr;
        String[] strArr2 = this.P;
        if (strArr2 == null || strArr2.length <= 0 || (strArr = this.Q) == null || strArr.length <= 0) {
            return;
        }
        LiveMsgSendManager.a().a(Long.valueOf(j).longValue(), this.P, this.Q, this.aj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveRoomData liveRoomData, long j) {
        liveRoomData.live_type = LiveRoomManager.a().I();
        liveRoomData.profile = new LiveRoomAnchorModel(LiveRoomInfo.a().f(), LiveRoomInfo.a().c(), LiveRoomInfo.a().d(), LiveRoomInfo.a().u(), LiveRoomInfo.a().r());
        if (LiveRoomInfo.a().n() != null) {
            liveRoomData.profile.avatar_frame = LiveRoomInfo.a().n().avatar_frame;
            liveRoomData.profile.avatar_frame_type = LiveRoomInfo.a().n().avatar_frame_type;
        }
        this.G.t = liveRoomData.lid;
        this.T = liveRoomData.description;
        LiveRoomManager.a().a(liveRoomData);
        if (this.G.f13406cn != null) {
            this.G.f13406cn.c();
        }
        if (this.G.bv != null) {
            if (LiveRoomManager.a().R()) {
                this.G.bv.setVisibility(0);
            } else {
                this.G.bv.setVisibility(8);
            }
        }
        LiveMsgSendManager.a().a(liveRoomData.lid);
        this.G.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.view.StartLiveView.5
            @Override // java.lang.Runnable
            public void run() {
                StartLiveView.this.getLiveShareContent();
            }
        });
        this.G.af.a(liveRoomData.lantern, j / 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.StartLiveView.6
            @Override // java.lang.Runnable
            public void run() {
                Logger.a("pk", "showErrorLayout title:" + str2 + " -- failedMessage:" + str);
                if (StartLiveView.this.G.getFragmentActive() == null || !StartLiveView.this.G.getFragmentActive().isActive()) {
                    return;
                }
                StartLiveView.this.B.setVisibility(8);
                StartLiveView.this.V.setText(!TextUtils.isEmpty(str2) ? str2 : StartLiveView.this.getResources().getString(R.string.Live_applyHost_wormNotice));
                StartLiveView.this.E.setText(!TextUtils.isEmpty(str) ? str : StartLiveView.this.getResources().getString(R.string.unknown_error));
                StartLiveView.this.C.setVisibility(0);
                AnimationUtils.a(StartLiveView.this.C);
            }
        });
    }

    private void g() {
        this.U = DialogUtils.a(this.f15250a);
        LayoutInflater from = LayoutInflater.from(this.f15250a);
        this.b = from;
        View inflate = from.inflate(R.layout.live_start_view, this);
        this.f15251c = inflate;
        this.d = (LinearLayout) inflate.findViewById(R.id.lay_live_ori_switch);
        this.e = (RelativeLayout) this.f15251c.findViewById(R.id.lay_portrait);
        this.f = (TextView) this.f15251c.findViewById(R.id.portrait);
        this.g = (RelativeLayout) this.f15251c.findViewById(R.id.lay_landscape);
        this.h = (TextView) this.f15251c.findViewById(R.id.landscape);
        this.i = (ImageView) this.f15251c.findViewById(R.id.live_start_switch_camera_btn);
        this.j = (ImageView) this.f15251c.findViewById(R.id.live_start_close_btn);
        this.k = (EditText) this.f15251c.findViewById(R.id.live_start_edit_view);
        this.l = this.f15251c.findViewById(R.id.live_start_edit_layout);
        this.m = this.f15251c.findViewById(R.id.keyboard_view);
        this.n = (ViewGroup) this.f15251c.findViewById(R.id.bottom_layout);
        this.o = (LinearLayout) this.f15251c.findViewById(R.id.blued_layout);
        this.p = (ImageView) this.f15251c.findViewById(R.id.blued_btn);
        this.q = (Button) this.f15251c.findViewById(R.id.call_friend_num);
        this.r = (ImageView) this.f15251c.findViewById(R.id.weixin_btn);
        this.s = (ImageView) this.f15251c.findViewById(R.id.friends_btn);
        this.t = (ImageView) this.f15251c.findViewById(R.id.qq_btn);
        this.u = (ImageView) this.f15251c.findViewById(R.id.weibo_btn);
        this.v = (ImageView) this.f15251c.findViewById(R.id.live_start_beauty_btn);
        this.w = (Button) this.f15251c.findViewById(R.id.start_live_btn);
        this.x = (TextView) this.f15251c.findViewById(R.id.live_lover_details);
        this.y = (LinearLayout) this.f15251c.findViewById(R.id.live_nearby_layout);
        this.z = (ImageView) this.f15251c.findViewById(R.id.live_nearby_btn);
        this.A = (TextView) this.f15251c.findViewById(R.id.tv_show_in_nearby);
        this.B = this.f15251c.findViewById(R.id.live_create_layout);
        View findViewById = this.f15251c.findViewById(R.id.live_start_error_layout_tips);
        this.C = findViewById;
        this.V = (TextView) findViewById.findViewById(R.id.error_tips_title);
        this.D = (Button) this.C.findViewById(R.id.error_tips_btn);
        this.E = (TextView) this.C.findViewById(R.id.error_tips_message);
        this.F = this.f15251c.findViewById(R.id.live_start_beauty_layout);
        this.W = this.f15251c.findViewById(R.id.ll_live_show);
        this.aa = this.f15251c.findViewById(R.id.ll_live_lover);
        this.ab = this.f15251c.findViewById(R.id.tv_line_show);
        this.ac = this.f15251c.findViewById(R.id.tv_line_lover);
        this.ae = (TextView) this.f15251c.findViewById(R.id.tv_live_show);
        this.af = (TextView) this.f15251c.findViewById(R.id.tv_live_lover);
        this.ad = this.f15251c.findViewById(R.id.rl_lover_tip);
        this.f15251c.setBackgroundResource(R.drawable.live_start_game_bg);
        if (LiveRoomInfo.a().i()) {
            this.A.setText(R.string.live_show_up_with_hidden);
        } else {
            this.A.setText(R.string.live_show_up);
        }
        TextView textView = this.x;
        textView.setText(Html.fromHtml("<u>" + this.f15250a.getString(R.string.live_lover_title) + "</u>"));
        boolean t = LiveRoomPreferences.t();
        this.R = t;
        if (t) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        if (this.G.cx == 0) {
            this.d.setVisibility(8);
            this.ah = false;
        } else if (this.G.cx == 1) {
            this.d.setVisibility(0);
            this.ah = true;
        }
        if (AppInfo.m()) {
            this.d.setVisibility(0);
            this.ah = true;
        }
        if (LiveRoomManager.a().J()) {
            this.d.setVisibility(8);
            this.aa.setVisibility(8);
            this.ah = false;
        }
        this.f.setSelected(true);
        this.h.setSelected(false);
        String j = LiveRoomPreferences.j();
        if (j.equals(Constants.SinaWeiboNAME)) {
            this.u.setImageResource(R.drawable.share_weibo_selected);
            this.I = Constants.SinaWeiboNAME;
            this.J = true;
        } else if (j.equals(Constants.WechatNAME)) {
            this.r.setImageResource(R.drawable.share_weixin_selected);
            this.I = Constants.WechatNAME;
            this.K = true;
        } else if (j.equals(Constants.WechatMomentsNAME)) {
            this.s.setImageResource(R.drawable.share_friends_selected);
            this.I = Constants.WechatMomentsNAME;
            this.L = true;
        } else if (j.equals(Constants.QQNAME)) {
            this.t.setImageResource(R.drawable.share_qq_selected);
            this.I = Constants.QQNAME;
            this.M = true;
        } else {
            this.I = "";
        }
        LoadOptions loadOptions = new LoadOptions();
        this.H = loadOptions;
        loadOptions.d = R.drawable.user_bg_round;
        this.H.b = R.drawable.user_bg_round;
        if (LiveRoomManager.a().J()) {
            this.f15251c.setBackgroundResource(R.drawable.live_start_game_bg);
            this.l.setVisibility(4);
            this.k.setHint("");
            this.k.setEnabled(false);
            this.y.setVisibility(4);
            this.w.setEnabled(false);
            this.w.setBackgroundResource(R.drawable.shape_start_live_btn_enabled);
            this.F.setVisibility(8);
            this.i.setVisibility(8);
            int i = this.G.cy != 0 ? this.G.cy : this.N;
            Logger.a("drb", "countdown = ", Integer.valueOf(i));
            this.O = new CountDownTimer(i * 1000, 500L) { // from class: com.blued.android.module.live_china.view.StartLiveView.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    StartLiveView.this.w.setEnabled(true);
                    StartLiveView.this.w.setBackgroundResource(R.drawable.live_start_btn_bg);
                    StartLiveView.this.w.setText(R.string.liveVideo_createLive_label_startToLiveButton);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    Button button = StartLiveView.this.w;
                    button.setText((((j2 / 1000) + 1) + "") + "s");
                }
            }.start();
        } else {
            LiveRoomInfo.a().a(new PermissionCallbacks() { // from class: com.blued.android.module.live_china.view.StartLiveView.2
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    StartLiveView.this.f15251c.setBackgroundResource(R.color.transparent);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                    StartLiveView.this.f15251c.setBackgroundResource(R.drawable.live_start_game_bg);
                }
            });
        }
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.aa.setOnClickListener(this);
        this.k.addTextChangedListener(this.ai);
    }

    private void h() {
        this.S = true;
        ImageFileLoader.a(this.G.getFragmentActive()).b(LiveRoomInfo.a().d()).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.view.StartLiveView.3
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                LiveRoomInfo.a().a(StartLiveView.this.f15250a, LiveRoomManager.a().p(), StartLiveView.this.I, LiveRoomManager.a().J() ? !TextUtils.isEmpty(StartLiveView.this.T) ? StartLiveView.this.T : StartLiveView.this.f15250a.getString(R.string.live_game_share) : "", StartLiveView.this.k.getText().toString(), StartLiveView.this.aj, (file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath()));
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int i;
        this.B.setVisibility(0);
        String obj = this.k.getText().toString();
        if (this.G.x) {
            this.G.g_(8);
            i = 1;
        } else {
            this.G.g_(0);
            i = 0;
        }
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRoomData, LiveRoomExtra>>(this.G.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.StartLiveView.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                if (i2 == 403) {
                    StartLiveView.this.a(str, "");
                    return true;
                }
                StartLiveView.this.a((String) null, (String) null);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveRoomData, LiveRoomExtra> bluedEntity) {
                if (!bluedEntity.hasData()) {
                    StartLiveView.this.a((String) null, (String) null);
                    return;
                }
                LiveRoomManager.a().a(bluedEntity.extra);
                StartLiveView.this.a(bluedEntity.getSingleData(), Long.valueOf(bluedEntity.response_time).longValue());
            }
        }, this.G.getFragmentActive(), LiveRoomInfo.a().f(), this.R, obj, LiveRoomManager.a().I(), i, this.ag);
    }

    private void j() {
        boolean z = false;
        if (LiveRoomManager.a().p() == null || TextUtils.isEmpty(LiveRoomManager.a().p().publish_url)) {
            Logger.a("pk", "startLive failed");
            a((String) null, (String) null);
            return;
        }
        this.B.setVisibility(8);
        this.S = false;
        a(this.G.t);
        setVisibility(8);
        this.G.W();
        if (this.G.cm != null) {
            this.G.cm.setData(LiveRoomManager.a().p().custom_rank);
        }
        Observable<Object> observable = LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_LUCK_TURNING_BTN);
        if (LiveRoomManager.a().p().entrance_status == 1) {
            z = true;
        }
        observable.post(Boolean.valueOf(z));
        if (LiveRoomManager.a().J()) {
            this.G.R();
            return;
        }
        EditText editText = this.k;
        this.G.a(this.ag, (editText == null || editText.getText() == null) ? "" : this.k.getText().toString());
    }

    private void k() {
        this.f.setSelected(true);
        this.h.setSelected(false);
        this.G.x = false;
    }

    private void l() {
        this.f.setSelected(false);
        this.h.setSelected(true);
        this.G.x = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (TextUtils.isEmpty(this.I)) {
            j();
        } else {
            h();
        }
    }

    public void a() {
        if (!this.S || TextUtils.isEmpty(this.I)) {
            return;
        }
        j();
    }

    public void a(int i) {
        if (i == -3) {
            Logger.a("pk", "键盘打开");
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.StartLiveView.7
                @Override // java.lang.Runnable
                public void run() {
                    StartLiveView.this.m.setVisibility(0);
                    StartLiveView.this.m.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.StartLiveView.7.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            KeyboardUtils.a(StartLiveView.this.G.getActivity());
                            return true;
                        }
                    });
                }
            });
        } else if (i != -2) {
        } else {
            Logger.a("pk", "键盘隐藏");
            this.m.setVisibility(8);
        }
    }

    public void a(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 10111) {
            this.P = intent.getStringArrayExtra("CHOOSED_UID");
            this.Q = intent.getStringArrayExtra("CHOOSED_TYPE");
            String[] strArr = this.P;
            if (strArr == null || strArr.length <= 0) {
                this.p.setImageResource(R.drawable.share_blued_default);
                this.q.setVisibility(8);
                return;
            }
            this.p.setImageResource(R.drawable.share_blued_selected);
            Button button = this.q;
            button.setText(this.P.length + "");
            this.q.setVisibility(0);
        }
    }

    public void a(RecordingOnliveFragment recordingOnliveFragment) {
        this.G = recordingOnliveFragment;
        g();
        d();
    }

    public void b() {
        CountDownTimer countDownTimer = this.O;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public boolean c() {
        StringBuilder sb = new StringBuilder();
        sb.append(" start onBackPressed:");
        sb.append(this.B.getVisibility() == 0);
        sb.append("--");
        sb.append(this.C.getVisibility() == 0);
        Logger.a("pk", sb.toString());
        if (this.B.getVisibility() == 0) {
            return true;
        }
        if (this.C.getVisibility() == 0) {
            this.D.performClick();
            return true;
        } else if (getVisibility() == 0) {
            Logger.a("pk", "finish");
            this.G.ap();
            return true;
        } else {
            return false;
        }
    }

    public void d() {
        if (LiveRoomManager.a().p() != null) {
            EventTrackLive.c(LiveProtos.Event.LIVE_PREPARE, LiveRoomManager.a().g());
        }
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = "live_prepare";
        instantLogBody.event = PushConsts.SETTAG_ERROR_COUNT;
        InstantLog.a(instantLogBody);
    }

    public void e() {
        this.n.setVisibility(8);
    }

    public void f() {
        this.n.setVisibility(0);
    }

    public void getLiveShareContent() {
        LiveRoomHttpUtils.a(LiveRoomInfo.a().f(), new BluedUIHttpResponse<BluedEntityA<LiveShareTextModel>>(this.G.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.StartLiveView.11
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveShareTextModel> bluedEntityA) {
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                    StartLiveView.this.aj = bluedEntityA.data.get(0).copywriting;
                }
                StartLiveView.this.m();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                StartLiveView.this.m();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        }, this.G.getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_start_close_btn) {
            this.G.ap();
        } else if (view.getId() == R.id.blued_btn) {
            EventTrackLive.c(LiveProtos.Event.LIVE_START_SHARE_FEED, LiveRoomInfo.a().f());
            InstantLog.a("live_start_share_feed");
            LiveRoomInfo.a().a(this.G, 10111, 8, this.f15250a.getResources().getString(R.string.liveVideo_selectFriends_label_description), this.P);
        } else if (view.getId() == R.id.blued_layout) {
            LiveRoomInfo.a().a(this.G, 10111, 8, this.f15250a.getResources().getString(R.string.liveVideo_selectFriends_label_description), this.P);
        } else if (view.getId() == R.id.error_tips_btn) {
            this.C.setVisibility(8);
        } else if (view.getId() == R.id.start_live_btn) {
            EventTrackLive.a(LiveProtos.Event.ANCHOR_SETTING_START_CLICK, this.ag ? LiveProtos.LiveType.BLIND_DATING_LIVE : LiveProtos.LiveType.SHOW_LIVE);
            LiveRoomInfo.a().a(new AnonymousClass9());
        } else if (view.getId() == R.id.weibo_btn) {
            if (this.J) {
                this.u.setImageResource(R.drawable.share_weibo_default);
                this.J = false;
                this.I = "";
                LiveRoomPreferences.d(b.l);
                return;
            }
            this.u.setImageResource(R.drawable.share_weibo_selected);
            this.r.setImageResource(R.drawable.share_weixin_default);
            this.s.setImageResource(R.drawable.share_friends_default);
            this.t.setImageResource(R.drawable.share_qq_default);
            this.J = true;
            this.K = false;
            this.L = false;
            this.M = false;
            String str = Constants.SinaWeiboNAME;
            this.I = str;
            LiveRoomPreferences.d(str);
        } else if (view.getId() == R.id.weixin_btn) {
            if (this.K) {
                this.r.setImageResource(R.drawable.share_weixin_default);
                this.K = false;
                this.I = "";
                LiveRoomPreferences.d(b.l);
                return;
            }
            this.u.setImageResource(R.drawable.share_weibo_default);
            this.r.setImageResource(R.drawable.share_weixin_selected);
            this.s.setImageResource(R.drawable.share_friends_default);
            this.t.setImageResource(R.drawable.share_qq_default);
            this.J = false;
            this.K = true;
            this.L = false;
            this.M = false;
            String str2 = Constants.WechatNAME;
            this.I = str2;
            LiveRoomPreferences.d(str2);
        } else if (view.getId() == R.id.friends_btn) {
            if (this.L) {
                this.s.setImageResource(R.drawable.share_friends_default);
                this.L = false;
                this.I = "";
                LiveRoomPreferences.d(b.l);
                return;
            }
            this.u.setImageResource(R.drawable.share_weibo_default);
            this.r.setImageResource(R.drawable.share_weixin_default);
            this.s.setImageResource(R.drawable.share_friends_selected);
            this.t.setImageResource(R.drawable.share_qq_default);
            this.J = false;
            this.K = false;
            this.L = true;
            this.M = false;
            String str3 = Constants.WechatMomentsNAME;
            this.I = str3;
            LiveRoomPreferences.d(str3);
        } else if (view.getId() == R.id.qq_btn) {
            if (this.M) {
                this.t.setImageResource(R.drawable.share_qq_default);
                this.M = false;
                this.I = "";
                LiveRoomPreferences.d(b.l);
                return;
            }
            this.u.setImageResource(R.drawable.share_weibo_default);
            this.r.setImageResource(R.drawable.share_weixin_default);
            this.s.setImageResource(R.drawable.share_friends_default);
            this.t.setImageResource(R.drawable.share_qq_selected);
            this.J = false;
            this.K = false;
            this.L = false;
            this.M = true;
            String str4 = Constants.QQNAME;
            this.I = str4;
            LiveRoomPreferences.d(str4);
        } else if (view.getId() == R.id.lay_portrait) {
            if (this.ag) {
                return;
            }
            k();
        } else if (view.getId() == R.id.lay_landscape) {
            if (this.ag) {
                return;
            }
            l();
        } else if (view.getId() == R.id.live_nearby_layout) {
            if (this.R) {
                CommonAlertDialog.a(this.G.getActivity(), "", this.f15250a.getString(R.string.live_show_up_details), this.f15250a.getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.StartLiveView.10
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        StartLiveView.this.z.setVisibility(8);
                        LiveRoomPreferences.a(false);
                        StartLiveView.this.R = false;
                    }
                }, this.f15250a.getString(R.string.cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            }
            this.z.setVisibility(0);
            LiveRoomPreferences.a(true);
            this.R = true;
        } else if (view.getId() == R.id.live_lover_details) {
            EventTrackLive.a(LiveProtos.Event.ANCHOR_SETTING_BLIND_DATING_CLICK);
            LiveRoomInfo.a().a(this.G.getActivity(), LiveRoomInfo.a().D());
        } else if (view.getId() == R.id.live_start_switch_camera_btn) {
            this.G.switchCamera(view);
        } else if (view.getId() == R.id.live_start_beauty_btn) {
            this.G.ar();
            EventTrackLive.a(LiveProtos.Event.START_LIVE_BEAUTY_BTN_CLICK);
        } else if (view.getId() == R.id.ll_live_show) {
            this.ag = false;
            if (this.ah) {
                this.d.setVisibility(0);
            }
            this.ad.setVisibility(8);
            this.ab.setVisibility(0);
            this.ac.setVisibility(4);
            this.ae.setTextColor(getResources().getColor(R.color.syc_dark_b));
            this.af.setTextColor(getResources().getColor(R.color.syc_dark_z));
        } else if (view.getId() == R.id.ll_live_lover) {
            this.ag = true;
            k();
            this.d.setVisibility(4);
            this.ad.setVisibility(0);
            this.ab.setVisibility(4);
            this.ac.setVisibility(0);
            this.ae.setTextColor(getResources().getColor(R.color.syc_dark_z));
            this.af.setTextColor(getResources().getColor(R.color.syc_dark_b));
        }
    }
}
