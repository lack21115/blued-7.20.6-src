package com.soft.blued.ui.live.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.VerifyStatus;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.feed.fragment.ClipPhotoFragment;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.live.manager.LiveApplyDelPhotoObserver;
import com.soft.blued.ui.live.model.LiveIDCardUploadResult;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.setting.fragment.ShowVerifyFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.CameraUtils;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveApplyFragment.class */
public class LiveApplyFragment extends BaseFragment implements View.OnClickListener, LiveApplyDelPhotoObserver.IDelPhotoObserver {
    private ImageView A;
    private boolean D;
    private boolean E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean W;
    private boolean X;
    private Dialog Y;
    private ImageView Z;
    private ImageView aa;
    private Dialog ab;
    private ImageView ac;
    private ImageView ad;
    private ImageView ae;
    private View af;
    private View ag;
    private View ah;
    private View ai;
    private View aj;
    private LinearLayout ak;
    private ImageView al;
    private ImageView am;
    private TextView an;
    private EditText ao;
    private EditText ap;
    private ImageView aq;
    private int au;
    private View av;
    private TextView aw;
    private TextView ax;
    Dialog b;
    private View e;
    private Context f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private LinearLayout t;
    private TextView u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private ImageView z;
    private String d = LiveApplyFragment.class.getSimpleName();
    private String[] B = new String[2];
    private boolean C = true;

    /* renamed from: a  reason: collision with root package name */
    boolean f31115a = false;
    private boolean S = true;
    private boolean T = true;
    private boolean U = true;
    private boolean V = true;

    /* renamed from: ar  reason: collision with root package name */
    private final int f31116ar = 0;
    private final int as = 1;
    private final int at = 2;

    /* renamed from: c  reason: collision with root package name */
    public BluedUIHttpResponse f31117c = new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.6
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedLiveListData> bluedEntityA) {
            LiveApplyFragment.this.t.setBackgroundColor(-4144960);
            LiveApplyFragment.this.t.setOnClickListener(null);
            LiveApplyFragment.this.u.setText(2131886109);
            LiveApplyFragment.this.x.setVisibility(8);
            LiveApplyFragment.this.w.setVisibility(8);
            LiveApplyFragment.this.v.setVisibility(8);
            LiveApplyFragment.this.r.setText(LiveApplyFragment.this.getResources().getString(2131886112));
            LiveApplyFragment.this.s.setText(LiveApplyFragment.this.getResources().getString(2131886113));
            LiveApplyFragment.this.aj.setVisibility(8);
            LiveApplyFragment.this.an.setVisibility(8);
            LiveApplyFragment.this.af.setVisibility(8);
            LiveApplyFragment.this.ao.setEnabled(false);
            LiveApplyFragment.this.ap.setEnabled(false);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            if (i == 4036703) {
                LiveApplyFragment.this.d();
                LiveApplyFragment.this.aj.setVisibility(0);
                return true;
            } else if (i == 4036705) {
                LiveApplyFragment.this.e();
                LiveApplyFragment.this.c();
                LiveApplyFragment.this.x.setVisibility(8);
                LiveApplyFragment.this.w.setVisibility(8);
                LiveApplyFragment.this.v.setVisibility(8);
                return true;
            } else {
                return false;
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(LiveApplyFragment.this.ab);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(LiveApplyFragment.this.ab);
        }
    };
    private TextWatcher ay = new TextWatcher() { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.12
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f31122c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = LiveApplyFragment.this.ao.getSelectionStart();
            this.f31122c = LiveApplyFragment.this.ao.getSelectionEnd();
            LiveApplyFragment.this.ao.removeTextChangedListener(LiveApplyFragment.this.ay);
            if (editable.length() > 0) {
                LiveApplyFragment.this.U = true;
                LiveApplyFragment.this.al.setVisibility(0);
                if (LiveApplyFragment.this.ap.getText().length() > 0) {
                    LiveApplyFragment.this.V = true;
                }
            } else {
                LiveApplyFragment.this.U = false;
                LiveApplyFragment.this.al.setVisibility(8);
            }
            while (editable.length() > 10) {
                editable.delete(this.b - 1, this.f31122c);
                this.b--;
                this.f31122c--;
            }
            LiveApplyFragment.this.ao.setSelection(this.b);
            LiveApplyFragment.this.i();
            LiveApplyFragment.this.ao.addTextChangedListener(LiveApplyFragment.this.ay);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private TextWatcher az = new TextWatcher() { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.13
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f31124c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = LiveApplyFragment.this.ap.getSelectionStart();
            this.f31124c = LiveApplyFragment.this.ap.getSelectionEnd();
            LiveApplyFragment.this.ap.removeTextChangedListener(LiveApplyFragment.this.az);
            if (editable.length() > 0) {
                LiveApplyFragment.this.V = true;
                LiveApplyFragment.this.am.setVisibility(0);
                if (LiveApplyFragment.this.ap.getText().length() > 0) {
                    LiveApplyFragment.this.U = true;
                }
            } else {
                LiveApplyFragment.this.V = false;
                LiveApplyFragment.this.am.setVisibility(8);
            }
            while (editable.length() > 18) {
                editable.delete(this.b - 1, this.f31124c);
                this.b--;
                this.f31124c--;
            }
            LiveApplyFragment.this.ap.setSelection(this.b);
            LiveApplyFragment.this.i();
            LiveApplyFragment.this.ap.addTextChangedListener(LiveApplyFragment.this.az);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    private void a(int i) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.photo_choose_dialog, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.viewer_card);
        if (i == 0) {
            imageView.setImageResource(R.drawable.live_id_card_front);
        } else if (i == 1) {
            imageView.setImageResource(R.drawable.live_id_card_back);
        } else if (i == 2) {
            imageView.setImageResource(R.drawable.live_id_card_hand_big);
        }
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyle);
        this.b = dialog;
        dialog.requestWindowFeature(1);
        this.b.setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        Window window = this.b.getWindow();
        window.setWindowAnimations(2131952889);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        attributes.width = -1;
        attributes.height = -1;
        this.b.onWindowAttributesChanged(attributes);
        String[] stringArray = getResources().getStringArray(R.array.send_feed);
        Button button = (Button) inflate.findViewById(R.id.openPhones);
        button.setText(stringArray[1]);
        button.setOnClickListener(this);
        Button button2 = (Button) inflate.findViewById(R.id.openCamera);
        button2.setText(stringArray[0]);
        button2.setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.openClose)).setOnClickListener(this);
        this.b.setCanceledOnTouchOutside(true);
        this.b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, String str) {
        LiveHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveIDCardUploadResult>>(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveIDCardUploadResult> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                String str2 = bluedEntityA.data.get(0).pic;
                Log.v("pk", "上传图片成功：" + i);
                int i2 = i;
                if (i2 == 0) {
                    LiveApplyFragment.this.O = true;
                    LiveApplyFragment.this.J = str2;
                    LiveApplyFragment.this.y.setVisibility(0);
                    ImageLoader.d(LiveApplyFragment.this.getFragmentActive(), LiveApplyFragment.this.G).b(R.drawable.live_id_card_default).a(LiveApplyFragment.this.y);
                    LiveApplyFragment.this.v.setVisibility(0);
                    InstantLog.b("verify_photo_uploaded", 0);
                } else if (i2 == 1) {
                    LiveApplyFragment.this.P = true;
                    LiveApplyFragment.this.K = str2;
                    LiveApplyFragment.this.z.setVisibility(0);
                    ImageLoader.d(LiveApplyFragment.this.getFragmentActive(), LiveApplyFragment.this.H).b(R.drawable.live_id_card_default).a(LiveApplyFragment.this.z);
                    LiveApplyFragment.this.w.setVisibility(0);
                    InstantLog.b("verify_photo_uploaded", 1);
                } else if (i2 == 2) {
                    LiveApplyFragment.this.Q = true;
                    LiveApplyFragment.this.L = str2;
                    LiveApplyFragment.this.A.setVisibility(0);
                    ImageLoader.d(LiveApplyFragment.this.getFragmentActive(), LiveApplyFragment.this.I).b(R.drawable.live_id_card_default).a(LiveApplyFragment.this.A);
                    LiveApplyFragment.this.x.setVisibility(0);
                }
                LiveApplyFragment.this.T = true;
                LiveApplyFragment.this.i();
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), i, str, getFragmentActive());
    }

    private void a(final String str, final int i) {
        LiveHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                LiveApplyFragment.this.a(str, bluedEntityA.data.get(0), i);
                Log.v("pk", "获取token成功：" + i);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LiveApplyFragment.this.D = false;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                LiveApplyFragment.this.D = true;
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum, final int i) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.8
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2) {
                LiveApplyFragment.this.D = false;
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, String str3) {
                int i2 = i;
                if (i2 == 0) {
                    LiveApplyFragment.this.J = str2;
                } else if (i2 == 1) {
                    LiveApplyFragment.this.K = str2;
                } else if (i2 == 2) {
                    LiveApplyFragment.this.L = str2;
                }
                Log.v("pk", "七牛上传成功：" + i);
                LiveApplyFragment.this.a(i, str2);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return LiveApplyFragment.this.E;
            }
        });
    }

    private void b() {
        this.Y = DialogUtils.a(getActivity());
        this.ab = DialogUtils.a(getActivity(), this.f.getResources().getString(2131889392), false);
        this.y = (ImageView) this.e.findViewById(R.id.live_card1);
        this.z = (ImageView) this.e.findViewById(R.id.live_card2);
        this.A = (ImageView) this.e.findViewById(R.id.live_card3);
        this.v = (ImageView) this.e.findViewById(R.id.cover_del_btn1);
        this.w = (ImageView) this.e.findViewById(R.id.cover_del_btn2);
        this.x = (ImageView) this.e.findViewById(R.id.cover_del_btn3);
        this.v.setVisibility(8);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.i = (TextView) this.e.findViewById(2131366920);
        this.j = (TextView) this.e.findViewById(R.id.live_agree1);
        this.k = (TextView) this.e.findViewById(R.id.live_agree2);
        this.l = (TextView) this.e.findViewById(R.id.live_agree3);
        this.m = (TextView) this.e.findViewById(R.id.live_agree4);
        TextView textView = this.j;
        textView.setText("1." + getString(2131886180));
        TextView textView2 = this.k;
        textView2.setText("2." + getString(2131886181));
        TextView textView3 = this.l;
        textView3.setText("3." + getString(2131886182));
        TextView textView4 = this.m;
        textView4.setText("4." + getString(2131886183));
        this.t = (LinearLayout) this.e.findViewById(2131367669);
        this.u = (TextView) this.e.findViewById(R.id.tv_start_verify);
        this.r = (TextView) this.e.findViewById(R.id.tv_live_apply_title);
        this.s = (TextView) this.e.findViewById(R.id.tv_live_apply_title1);
        this.o = (TextView) this.e.findViewById(R.id.tv_binding_cellphone);
        this.n = (TextView) this.e.findViewById(R.id.tv_verify);
        this.o.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.h = (TextView) this.e.findViewById(R.id.tv_binding_cellphone_status);
        this.g = (TextView) this.e.findViewById(R.id.tv_verify_status);
        this.p = (TextView) this.e.findViewById(R.id.tv_binding_credit_card);
        this.q = (TextView) this.e.findViewById(R.id.tv_binding_credit_card_status);
        this.ac = (ImageView) this.e.findViewById(R.id.iv_verified);
        this.ad = (ImageView) this.e.findViewById(R.id.iv_phone_binded);
        this.ae = (ImageView) this.e.findViewById(R.id.iv_card_binded);
        this.af = this.e.findViewById(R.id.live_id_card_error);
        this.ag = this.e.findViewById(R.id.live_add_card_layout1);
        this.ah = this.e.findViewById(R.id.live_add_card_layout2);
        this.ai = this.e.findViewById(R.id.live_add_card_layout3);
        this.aj = this.e.findViewById(R.id.live_id_card_failed);
        this.ak = (LinearLayout) this.e.findViewById(R.id.live_document_layout);
        this.al = (ImageView) this.e.findViewById(R.id.iv_id_name_binded);
        this.an = (TextView) this.e.findViewById(R.id.live_name_number_failed);
        this.am = (ImageView) this.e.findViewById(R.id.iv_id_number_binded);
        this.ao = (EditText) this.e.findViewById(R.id.live_document_name_edit_text);
        this.ap = (EditText) this.e.findViewById(R.id.live_document_number_edit_text);
        View findViewById = this.e.findViewById(R.id.live_apply_tips);
        this.av = findViewById;
        this.aw = (TextView) findViewById.findViewById(2131370691);
        this.ax = (TextView) this.av.findViewById(R.id.tips_btn);
        this.aq = (ImageView) this.e.findViewById(R.id.live_clause);
        this.ag.setOnClickListener(this);
        this.ah.setOnClickListener(this);
        this.ai.setOnClickListener(this);
        this.aq.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.al.setOnClickListener(this);
        this.am.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.av.setOnClickListener(this);
        this.Z = (ImageView) this.e.findViewById(2131364232);
        ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().getAvatar()).b(2131237310).c().a(this.Z);
        ImageView imageView = (ImageView) this.e.findViewById(2131364720);
        this.aa = imageView;
        UserInfoHelper.a(imageView, UserInfo.getInstance().getLoginUserInfo().getVBadge(), 3);
        if (this.aa.getVisibility() == 8 || this.aa.getVisibility() == 4) {
            this.aa.setImageResource(2131237327);
            this.aa.setVisibility(0);
        }
        f();
        this.ao.setFilters(new InputFilter[]{StringUtils.a()});
        this.ao.addTextChangedListener(this.ay);
        this.ap.addTextChangedListener(this.az);
    }

    private void b(final int i, String str) {
        DialogUtils.a(this.Y);
        LiveHttpUtils.c(new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.10
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(LiveApplyFragment.this.Y);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                try {
                    int i2 = i;
                    if (i2 == 0) {
                        LiveApplyFragment.this.O = false;
                        LiveApplyFragment.this.y.setVisibility(8);
                        LiveApplyFragment.this.v.setVisibility(8);
                        LiveApplyFragment.this.J = "";
                    } else if (i2 == 1) {
                        LiveApplyFragment.this.P = false;
                        LiveApplyFragment.this.z.setVisibility(8);
                        LiveApplyFragment.this.w.setVisibility(8);
                        LiveApplyFragment.this.K = "";
                    } else if (i2 == 2) {
                        LiveApplyFragment.this.Q = false;
                        LiveApplyFragment.this.A.setVisibility(8);
                        LiveApplyFragment.this.x.setVisibility(8);
                        LiveApplyFragment.this.L = "";
                    }
                    LiveApplyFragment.this.i();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), i, str, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.ak.setVisibility(0);
        this.an.setVisibility(0);
        this.U = false;
        this.V = false;
        i();
    }

    private void c(int i, String str) {
        this.au = i;
        BasePhotoFragment.a(this.f, new String[]{str}, 0, 8, new LoadOptions());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.av.setVisibility(0);
        this.aw.setText(this.f.getString(2131886134));
        this.ax.setText(this.f.getString(2131886178));
        this.ax.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveApplyFragment.this.av.setVisibility(8);
                EventTrackLive.a(LiveProtos.Event.LIVE_APPLY_PAGE_REUPLOAD_BTN_CLICK);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.av.setVisibility(0);
        this.aw.setText(this.f.getString(2131886135));
        this.ax.setText(this.f.getString(2131886177));
        this.ax.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveApplyFragment.this.av.setVisibility(8);
                EventTrackLive.a(LiveProtos.Event.LIVE_APPLY_PAGE_MANUALLY_MODIFY_BTN_CLICK);
            }
        });
    }

    private void f() {
        String string = this.f.getString(2131886107);
        String string2 = this.f.getString(2131886123);
        String string3 = this.f.getString(2131886108);
        String string4 = this.f.getString(2131889213);
        String str = string + " " + string2 + " " + string3 + " " + string4;
        SpannableString spannableString = new SpannableString(str);
        this.i.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewShowInfoFragment.show(LiveApplyFragment.this.getActivity(), "https://www.blued.cn/live/agreement", 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(LiveApplyFragment.this.f.getResources().getColor(2131101190));
                textPaint.setUnderlineText(false);
            }
        }, str.indexOf(string2), (string + " " + string2).length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewShowInfoFragment.show(LiveApplyFragment.this.getActivity(), "https://app.blued.cn/livereports/agreement/1", 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(LiveApplyFragment.this.f.getResources().getColor(2131101190));
                textPaint.setUnderlineText(false);
            }
        }, str.indexOf(string4), str.length(), 33);
        this.i.setText(spannableString);
    }

    private void g() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.e.findViewById(2131370749);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setCenterText(getString(2131886176));
        commonTopTitleNoTrans.setLeftClickListener(this);
        commonTopTitleNoTrans.setCenterTextColor(2131102254);
    }

    private void h() {
        LiveRoomHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveState> bluedEntityA) {
                BluedLiveState bluedLiveState = bluedEntityA.data.get(0);
                if (bluedLiveState.vbadge != 2 && bluedLiveState.vbadge != 4 && bluedLiveState.vbadge != 7 && bluedLiveState.vbadge != 5 && (bluedLiveState.vbadge != 0 || (bluedLiveState.verify != 0 && bluedLiveState.verify != 1 && bluedLiveState.verify != 2 && bluedLiveState.verify != -1))) {
                    LiveApplyFragment.this.M = false;
                    LiveApplyFragment.this.g.setVisibility(8);
                    LiveApplyFragment.this.n.setVisibility(0);
                    LiveApplyFragment.this.ac.setVisibility(8);
                } else if (bluedLiveState.verify == 0) {
                    LiveApplyFragment.this.M = false;
                    LiveApplyFragment.this.g.setText(LiveApplyFragment.this.getResources().getString(2131892566));
                    LiveApplyFragment.this.g.setVisibility(0);
                    LiveApplyFragment.this.g.setTextColor(LiveApplyFragment.this.f.getResources().getColor(2131101198));
                    LiveApplyFragment.this.n.setVisibility(8);
                    LiveApplyFragment.this.ac.setVisibility(8);
                } else if (bluedLiveState.verify == 1) {
                    LiveApplyFragment.this.M = true;
                    LiveApplyFragment.this.g.setText(LiveApplyFragment.this.getResources().getString(2131892551));
                    LiveApplyFragment.this.g.setVisibility(0);
                    LiveApplyFragment.this.g.setTextColor(LiveApplyFragment.this.f.getResources().getColor(2131101206));
                    LiveApplyFragment.this.n.setVisibility(8);
                    LiveApplyFragment.this.ac.setVisibility(0);
                } else if (bluedLiveState.verify == 2) {
                    LiveApplyFragment.this.M = false;
                    LiveApplyFragment.this.g.setText(LiveApplyFragment.this.getResources().getString(2131892395));
                    LiveApplyFragment.this.g.setTextColor(LiveApplyFragment.this.f.getResources().getColor(2131101201));
                    LiveApplyFragment.this.g.setVisibility(0);
                    LiveApplyFragment.this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            PersonalVerifyFragment.a(LiveApplyFragment.this.f, 0);
                        }
                    });
                    LiveApplyFragment.this.n.setVisibility(8);
                    LiveApplyFragment.this.ac.setVisibility(8);
                } else if (bluedLiveState.verify == -1) {
                    LiveApplyFragment.this.M = false;
                    LiveApplyFragment.this.g.setVisibility(8);
                    LiveApplyFragment.this.n.setVisibility(0);
                }
                if (bluedLiveState.mobile == 1) {
                    LiveApplyFragment.this.N = true;
                    LiveApplyFragment.this.h.setVisibility(0);
                    LiveApplyFragment.this.h.setText(LiveApplyFragment.this.getResources().getString(2131886121));
                    LiveApplyFragment.this.o.setVisibility(8);
                    LiveApplyFragment.this.ad.setVisibility(0);
                } else {
                    LiveApplyFragment.this.N = false;
                    LiveApplyFragment.this.h.setVisibility(8);
                    LiveApplyFragment.this.o.setVisibility(0);
                    LiveApplyFragment.this.ad.setVisibility(8);
                }
                if (bluedLiveState.has_bankcard == 1) {
                    LiveApplyFragment.this.R = true;
                    LiveApplyFragment.this.q.setVisibility(0);
                    LiveApplyFragment.this.p.setVisibility(8);
                    LiveApplyFragment.this.ae.setVisibility(0);
                } else {
                    LiveApplyFragment.this.R = false;
                    LiveApplyFragment.this.q.setVisibility(8);
                    LiveApplyFragment.this.p.setVisibility(0);
                    LiveApplyFragment.this.ae.setVisibility(8);
                }
                LiveApplyFragment.this.J = bluedLiveState.idcard_front;
                LiveApplyFragment.this.K = bluedLiveState.idcard_after;
                LiveApplyFragment.this.L = bluedLiveState.idcard_hands;
                if (TextUtils.isEmpty(LiveApplyFragment.this.J)) {
                    LiveApplyFragment.this.v.setVisibility(8);
                } else {
                    LiveApplyFragment.this.y.setVisibility(0);
                    ImageLoader.a(LiveApplyFragment.this.getFragmentActive(), LiveApplyFragment.this.J).b(R.drawable.live_id_card_default).a(LiveApplyFragment.this.y);
                    LiveApplyFragment.this.O = true;
                    LiveApplyFragment.this.v.setVisibility(0);
                }
                if (TextUtils.isEmpty(LiveApplyFragment.this.K)) {
                    LiveApplyFragment.this.w.setVisibility(8);
                } else {
                    LiveApplyFragment.this.z.setVisibility(0);
                    ImageLoader.a(LiveApplyFragment.this.getFragmentActive(), LiveApplyFragment.this.K).b(R.drawable.live_id_card_default).a(LiveApplyFragment.this.z);
                    LiveApplyFragment.this.P = true;
                    LiveApplyFragment.this.w.setVisibility(0);
                }
                if (TextUtils.isEmpty(LiveApplyFragment.this.L)) {
                    LiveApplyFragment.this.x.setVisibility(8);
                } else {
                    LiveApplyFragment.this.A.setVisibility(0);
                    ImageLoader.a(LiveApplyFragment.this.getFragmentActive(), LiveApplyFragment.this.L).b(R.drawable.live_id_card_default).a(LiveApplyFragment.this.A);
                    LiveApplyFragment.this.Q = true;
                    LiveApplyFragment.this.x.setVisibility(0);
                }
                if (bluedLiveState.has_audited == 0) {
                    LiveApplyFragment.this.t.setBackgroundColor(-4144960);
                    LiveApplyFragment.this.t.setOnClickListener(null);
                    LiveApplyFragment.this.u.setText(2131886109);
                    LiveApplyFragment.this.r.setText(LiveApplyFragment.this.getResources().getString(2131886112));
                    LiveApplyFragment.this.s.setText(LiveApplyFragment.this.getResources().getString(2131886113));
                    LiveApplyFragment.this.x.setVisibility(8);
                    LiveApplyFragment.this.w.setVisibility(8);
                    LiveApplyFragment.this.v.setVisibility(8);
                } else if (bluedLiveState.has_audited == 1) {
                    LiveApplyFragment.this.t.setBackgroundColor(-4144960);
                    LiveApplyFragment.this.t.setOnClickListener(null);
                    LiveApplyFragment.this.u.setText(2131886111);
                    LiveApplyFragment.this.x.setVisibility(8);
                    LiveApplyFragment.this.w.setVisibility(8);
                    LiveApplyFragment.this.v.setVisibility(8);
                } else if (bluedLiveState.has_audited == 2) {
                    LiveApplyFragment.this.t.setBackgroundColor(-4144960);
                    LiveApplyFragment.this.t.setOnClickListener(null);
                    LiveApplyFragment.this.u.setText(2131886110);
                    LiveApplyFragment.this.r.setText(2131886145);
                    LiveApplyFragment.this.s.setText(2131886146);
                    if (TextUtils.isEmpty(LiveApplyFragment.this.J)) {
                        LiveApplyFragment.this.v.setVisibility(8);
                    } else {
                        LiveApplyFragment.this.O = true;
                        LiveApplyFragment.this.v.setVisibility(0);
                    }
                    if (TextUtils.isEmpty(LiveApplyFragment.this.K)) {
                        LiveApplyFragment.this.w.setVisibility(8);
                    } else {
                        LiveApplyFragment.this.P = true;
                        LiveApplyFragment.this.w.setVisibility(0);
                    }
                    if (TextUtils.isEmpty(LiveApplyFragment.this.L)) {
                        LiveApplyFragment.this.x.setVisibility(8);
                    } else {
                        LiveApplyFragment.this.Q = true;
                        LiveApplyFragment.this.x.setVisibility(0);
                    }
                    if (bluedLiveState.idcard_front_status == 1) {
                        LiveApplyFragment.this.af.setVisibility(0);
                        LiveApplyFragment.this.T = false;
                        LiveApplyFragment.this.i();
                    }
                } else {
                    if (TextUtils.isEmpty(LiveApplyFragment.this.J)) {
                        LiveApplyFragment.this.v.setVisibility(8);
                    } else {
                        LiveApplyFragment.this.O = true;
                        LiveApplyFragment.this.v.setVisibility(0);
                    }
                    if (TextUtils.isEmpty(LiveApplyFragment.this.K)) {
                        LiveApplyFragment.this.w.setVisibility(8);
                    } else {
                        LiveApplyFragment.this.P = true;
                        LiveApplyFragment.this.w.setVisibility(0);
                    }
                    if (TextUtils.isEmpty(LiveApplyFragment.this.L)) {
                        LiveApplyFragment.this.x.setVisibility(8);
                    } else {
                        LiveApplyFragment.this.Q = true;
                        LiveApplyFragment.this.x.setVisibility(0);
                    }
                    LiveApplyFragment.this.i();
                }
                if (bluedLiveState.idcard_front_status == 0) {
                    LiveApplyFragment.this.T = true;
                } else if (bluedLiveState.idcard_front_status == 2) {
                    LiveApplyFragment.this.x.setVisibility(8);
                    LiveApplyFragment.this.w.setVisibility(8);
                    LiveApplyFragment.this.v.setVisibility(8);
                    LiveApplyFragment.this.c();
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Log.v("pk", "isVertyfied = " + this.M);
        Log.v("pk", "isBided = " + this.N);
        Log.v("pk", "isCardFrontOk = " + this.O);
        Log.v("pk", "isCardBackOk = " + this.P);
        Log.v("pk", "hasBindedBankCard = " + this.R);
        Log.v("pk", "isCardHandOk = " + this.Q);
        Log.v("pk", "isAgreeClause = " + this.S);
        Log.v("pk", "isNameOk = " + this.U);
        Log.v("pk", "isNumberOk = " + this.V);
        Log.v("pk", "isCardVerifyOk = " + this.T);
        if (this.M && this.N && this.O && this.P && this.R && this.Q && this.S && this.U && this.V && this.T) {
            this.t.setBackgroundColor(-16738064);
            this.u.setText(getResources().getString(2131886126));
            this.t.setOnClickListener(this);
            return;
        }
        this.t.setBackgroundColor(-4144960);
        this.u.setText(getResources().getString(2131886126));
        this.t.setOnClickListener(null);
    }

    private void j() {
        this.F = CameraUtils.a(this);
    }

    @Override // com.soft.blued.ui.live.manager.LiveApplyDelPhotoObserver.IDelPhotoObserver
    public void a() {
        int i = this.au;
        b(this.au, i != 0 ? i != 1 ? i != 2 ? "" : this.L : this.K : this.J);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 0) {
                ClipPhotoFragment.a(this, 9, this.F, 22);
            } else if (i == 22 && intent != null) {
                String stringExtra = intent.getStringExtra("photo_path");
                this.F = stringExtra;
                int i3 = this.au;
                if (i3 == 0) {
                    this.G = stringExtra;
                    a(stringExtra, 0);
                } else if (i3 == 1) {
                    this.H = stringExtra;
                    a(stringExtra, 1);
                } else if (i3 == 2) {
                    this.I = stringExtra;
                    a(stringExtra, 2);
                }
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.cover_del_btn1 /* 2131363092 */:
                b(0, this.J);
                return;
            case R.id.cover_del_btn2 /* 2131363093 */:
                b(1, this.K);
                return;
            case R.id.cover_del_btn3 /* 2131363094 */:
                AppMethods.a((CharSequence) "删除第三张照片");
                b(2, this.L);
                return;
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.iv_id_name_binded /* 2131365516 */:
                this.ao.setText("");
                return;
            case R.id.iv_id_number_binded /* 2131365517 */:
                this.ap.setText("");
                return;
            case R.id.live_add_card_layout1 /* 2131366915 */:
                this.au = 0;
                a(0);
                return;
            case R.id.live_add_card_layout2 /* 2131366916 */:
                this.au = 1;
                a(1);
                return;
            case R.id.live_add_card_layout3 /* 2131366917 */:
                this.au = 2;
                a(2);
                return;
            case R.id.live_card1 /* 2131366956 */:
                c(0, this.J);
                return;
            case R.id.live_card2 /* 2131366957 */:
                c(1, this.K);
                return;
            case R.id.live_card3 /* 2131366958 */:
                c(2, this.L);
                return;
            case R.id.live_clause /* 2131366997 */:
                if (this.S) {
                    this.S = false;
                    this.aq.setImageResource(R.drawable.live_clause_default);
                } else {
                    this.S = true;
                    this.aq.setImageResource(R.drawable.live_clause_selected);
                }
                i();
                return;
            case 2131367669:
                EventTrackLive.a(LiveProtos.Event.LIVE_APPLY_PAGE_CONFIRM_BTN_CLICK);
                LiveRoomHttpUtils.a(this.f31117c, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive(), this.ak.getVisibility() == 0 ? 1 : 0, this.ao.getText().toString(), this.ap.getText().toString(), 0);
                return;
            case R.id.openCamera /* 2131368772 */:
                this.W = false;
                this.b.cancel();
                j();
                return;
            case R.id.openClose /* 2131368773 */:
                this.b.cancel();
                return;
            case R.id.openPhones /* 2131368775 */:
                this.W = false;
                this.b.cancel();
                PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.live.fragment.LiveApplyFragment.11
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        PhotoSelectFragment.a(LiveApplyFragment.this, 9, 22);
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                    }
                });
                return;
            case R.id.tv_binding_cellphone /* 2131370981 */:
                this.X = true;
                this.W = true;
                String b = LoginRegisterTools.b();
                if (TextUtils.isEmpty(b)) {
                    TerminalActivity.d(getActivity(), LinkMobileFragment.class, null);
                    return;
                }
                String[] g = LoginRegisterTools.g(b);
                LoginRegisterTools.a(getActivity(), g[0], g[1]);
                return;
            case R.id.tv_binding_credit_card /* 2131370983 */:
            case R.id.tv_binding_credit_card_status /* 2131370984 */:
                this.X = true;
                this.W = true;
                WebViewShowInfoFragment.show(getActivity(), H5Url.a(7), 0);
                return;
            case R.id.tv_verify /* 2131372900 */:
                this.X = true;
                this.W = true;
                if (4 != UserInfo.getInstance().getLoginUserInfo().getVBadge() && 7 != UserInfo.getInstance().getLoginUserInfo().getVBadge()) {
                    PersonalVerifyFragment.a(getActivity(), 0);
                    return;
                }
                VerifyStatus[] verify = UserInfo.getInstance().getLoginUserInfo().getVerify();
                String str = "";
                if (verify != null) {
                    str = "";
                    if (verify.length > 0) {
                        str = verify[0].verified_time;
                    }
                }
                ShowVerifyFragment.a(getActivity(), UserInfo.getInstance().getLoginUserInfo().getName(), UserInfo.getInstance().getLoginUserInfo().getAvatar(), str, UserInfo.getInstance().getLoginUserInfo().getUid(), false);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = getActivity();
        View view = this.e;
        if (view == null) {
            this.e = layoutInflater.inflate(R.layout.fragment_live_apply, viewGroup, false);
            b();
            g();
            this.W = true;
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.b(LiveProtos.Event.LIVE_APPLY_PREPARE, LiveRoomManager.a().g());
            }
            InstantLog.a("live_apply_prepare");
            LiveApplyDelPhotoObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
        }
        return this.e;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LiveApplyDelPhotoObserver.a().b(this);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.W = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.W || this.X) {
            h();
        }
    }
}
