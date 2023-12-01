package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.base.shortvideo.ISaveInterface;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.community.ui.send.fragment.AlbumSelectFragment;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.manager.VideoUploadManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.view.PhotoGridView;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.feed.adapter.NewsFeedGirdAdapter;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.user.fragment.ReportPhotoMenuDialogFragment;
import com.soft.blued.ui.user.model.ReportPic;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.observer.ReportObserver;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportFragmentNew.class */
public class ReportFragmentNew extends BaseFragment implements View.OnClickListener {
    private static String[] C;
    public static List<String> d;
    private int E;
    private String F;
    private String G;
    private boolean H;
    private int I;
    private TextView J;
    private View K;
    private ShapeTextView L;
    private String M;
    private int N;

    /* renamed from: a  reason: collision with root package name */
    private View f20238a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private CommonTopTitleNoTrans f20239c;
    public int e;
    public String f;
    public String g;
    public Dialog h;
    protected EditDataModel.SerializableData i;
    protected StvResultModel j;
    protected String k;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private EditText s;
    private TextView t;
    private PhotoGridView u;
    private TextView v;
    private TextWatcher w;
    private LinearLayout x;
    private ToggleButton y;
    private NewsFeedGirdAdapter z;
    private List<ChildImageInfo> A = new ArrayList();
    private List<ChildImageInfo> B = new ArrayList();
    private boolean D = false;
    int l = -1;
    int m = -1;
    private boolean O = false;
    int n = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.user.fragment.ReportFragmentNew$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportFragmentNew$3.class */
    public class AnonymousClass3 implements AdapterView.OnItemClickListener {
        AnonymousClass3() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Tracker.onItemClick(adapterView, view, i, j);
            if (ReportFragmentNew.this.D || ReportFragmentNew.this.B == null || i >= ReportFragmentNew.this.B.size()) {
                return;
            }
            if (StringUtils.d(((ChildImageInfo) ReportFragmentNew.this.B.get(i)).mImagePath)) {
                if (ReportFragmentNew.this.I == 1) {
                    ReportFragmentNew.this.d();
                } else if (ReportFragmentNew.this.I == 2) {
                    AlbumSelectFragment.a(ReportFragmentNew.this, 8, 1, 6 - SelectPhotoManager.a().c().size(), 100);
                } else {
                    PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.3.1
                        public void U_() {
                            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.3.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    PhotoSelectFragment.a(ReportFragmentNew.this, 7, 0);
                                }
                            });
                        }

                        public void a(String[] strArr) {
                        }
                    });
                }
            } else if (!((ChildImageInfo) ReportFragmentNew.this.B.get(i)).isVideo) {
                int i2 = i;
                int i3 = 0;
                while (i3 < ReportFragmentNew.this.B.size()) {
                    int i4 = i2;
                    if (((ChildImageInfo) ReportFragmentNew.this.B.get(i3)).isVideo) {
                        i4 = i2;
                        if (i2 > i3) {
                            i4 = i2 - 1;
                        }
                    }
                    i3++;
                    i2 = i4;
                }
                BasePhotoFragment.a(ReportFragmentNew.this.getActivity(), i2, 0, null);
            } else if (ReportFragmentNew.this.j != null && ReportFragmentNew.this.i != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("serializeble_data", ReportFragmentNew.this.i);
                ShortVideoProxy.e().a(ReportFragmentNew.this, bundle, 0);
            } else if (ReportFragmentNew.this.j != null) {
                ShortVideoProxy e = ShortVideoProxy.e();
                ReportFragmentNew reportFragmentNew = ReportFragmentNew.this;
                e.a(reportFragmentNew, reportFragmentNew.j.f(), ReportFragmentNew.this.j.c(), 0);
            }
            ReportFragmentNew.this.D = true;
        }
    }

    /* renamed from: com.soft.blued.ui.user.fragment.ReportFragmentNew$6  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportFragmentNew$6.class */
    class AnonymousClass6 implements ISaveInterface {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReportFragmentNew f20251a;

        public void a() {
            Logger.b("FeedSend", new Object[]{"saveVideoNoUI onSaveVideoCanceled"});
        }

        public void a(float f) {
            Logger.b("FeedSend", new Object[]{"saveVideoNoUI onProgress v" + f});
        }

        public void a(int i) {
            Logger.b("FeedSend", new Object[]{"saveVideoNoUI onSaveFailed"});
        }

        public void a(StvResultModel stvResultModel) {
            this.f20251a.j = stvResultModel;
            this.f20251a.i = null;
            Logger.b("FeedSend", new Object[]{"saveVideoNoUI onSaveSucess videoFeed" + this.f20251a.j.f()});
            this.f20251a.e();
        }

        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        List<String> list = d;
        if (list != null && list.size() > 0 && !this.O) {
            AppMethods.a(getResources().getString(R.string.video_uploading));
            DialogUtils.b(this.h);
            return;
        }
        if (C == null) {
            for (ChildImageInfo childImageInfo : this.A) {
                if (childImageInfo.isVideo) {
                    this.n++;
                    this.A.remove(childImageInfo);
                }
            }
            C = new String[this.A.size()];
        }
        List<ChildImageInfo> list2 = this.A;
        if (list2 == null || i >= list2.size()) {
            DialogUtils.b(this.h);
            return;
        }
        String str = this.A.get(i).mImagePath;
        String e = RecyclingUtils.e("photo");
        Houyi.a().a(str, e).b();
        MineHttpUtils.a(this.b, new BluedUIHttpResponse<BluedEntityA<ReportPic>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.8

            /* renamed from: a  reason: collision with root package name */
            boolean f20253a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ReportPic> bluedEntityA) {
                if (bluedEntityA.data != null) {
                    if (bluedEntityA.data.size() <= 0) {
                        ReportFragmentNew reportFragmentNew = ReportFragmentNew.this;
                        reportFragmentNew.b(((Object) ReportFragmentNew.this.s.getText()) + "", ReportFragmentNew.this.e, ReportFragmentNew.this.f, ReportFragmentNew.C);
                        return;
                    }
                    if (ReportFragmentNew.C == null) {
                        String[] unused = ReportFragmentNew.C = new String[ReportFragmentNew.this.A.size()];
                    }
                    ReportFragmentNew.C[i] = ((ReportPic) bluedEntityA.data.get(0)).url;
                    if (i != ReportFragmentNew.this.A.size() - 1) {
                        ReportFragmentNew.this.a(i + 1);
                        return;
                    }
                    ReportFragmentNew reportFragmentNew2 = ReportFragmentNew.this;
                    reportFragmentNew2.b(((Object) ReportFragmentNew.this.s.getText()) + "", ReportFragmentNew.this.e, ReportFragmentNew.this.f, ReportFragmentNew.C);
                }
            }

            public boolean onUIFailure(int i2, String str2) {
                this.f20253a = true;
                return super.onUIFailure(i2, str2);
            }

            public void onUIFinish() {
                super.onUIFinish();
                if (this.f20253a) {
                    DialogUtils.b(ReportFragmentNew.this.h);
                }
                this.f20253a = false;
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ReportFragmentNew.this.h);
            }
        }, e);
    }

    public static void a(Context context, int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_REPORT_TARGET", i);
        bundle.putString("KEY_REPORT_TARGET_ID", str);
        bundle.putString("KEY_REPORT_TARGET_TEXT", str2);
        TerminalActivity.d(context, ReportFragmentNew.class, bundle);
    }

    public static void a(Context context, int i, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_REPORT_TARGET", i);
        bundle.putString("KEY_REPORT_TARGET_ID", str);
        bundle.putString("KEY_REPORT_TARGET_TEXT", str2);
        bundle.putString("KEY_REPORT_EXTRA", str3);
        TerminalActivity.d(context, ReportFragmentNew.class, bundle);
    }

    public static void a(Context context, String str, String str2, int i, String str3, int i2, int i3) {
        Bundle bundle = new Bundle();
        if (i2 == 1) {
            bundle.putInt("KEY_REPORT_TARGET", 13);
        } else {
            bundle.putInt("KEY_REPORT_TARGET", 12);
        }
        bundle.putString("KEY_REPORT_TARGET_ID", str);
        bundle.putInt("KEY_REPORT_EVENT_TYPE", i);
        bundle.putString("KEY_REPORT_TARGET_TEXT", str2);
        bundle.putString("KEY_REPORT_EVENT_POST_UID", str3);
        bundle.putInt("KEY_REPORT_EVENT_SIGN_ID", i3);
        TerminalActivity.d(context, ReportFragmentNew.class, bundle);
    }

    public static void a(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_REPORT_TARGET", 5);
        bundle.putString("KEY_REPORT_TARGET_ID", str);
        bundle.putString("KEY_REPORT_EXTRA", str2);
        bundle.putString("KEY_REPORT_TARGET_TEXT", str3);
        TerminalActivity.d(context, ReportFragmentNew.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.D = false;
    }

    private void a(Intent intent) {
        StvResultModel serializableExtra;
        if (intent == null || (serializableExtra = intent.getSerializableExtra("result_model")) == null) {
            return;
        }
        if (serializableExtra.a()) {
            Log.d("chenjiemei", "SHINE_OR_TAKE_PHOTO");
            if (intent.getSerializableExtra("serializeble_data") != null) {
                this.i = intent.getSerializableExtra("serializeble_data");
            }
            ChildImageInfo childImageInfo = new ChildImageInfo();
            childImageInfo.isVideo = true;
            childImageInfo.mImagePath = serializableExtra.c();
            SelectPhotoManager.a().a(childImageInfo);
            this.j = serializableExtra;
            Log.d("chenjiemei", "SHINE_OR_TAKE_PHOTO stvResultModel firstimage" + this.j.c());
            e();
        } else {
            ChildImageInfo childImageInfo2 = new ChildImageInfo();
            childImageInfo2.mImagePath = serializableExtra.b();
            SelectPhotoManager.a().a(childImageInfo2);
        }
        g();
    }

    public static void b(Context context, int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_REPORT_TARGET", i);
        bundle.putString("KEY_REPORT_TARGET_ID", str);
        bundle.putString("KEY_REPORT_TARGET_TEXT", str2);
        bundle.putBoolean("KEY_REPORT_SHOW_BLOCK", true);
        TerminalActivity.d(context, ReportFragmentNew.class, bundle);
    }

    public static void b(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_REPORT_TARGET", 10);
        bundle.putString("KEY_REPORT_TARGET_ID", str);
        bundle.putString("KEY_REPORT_EXTRA", str2);
        bundle.putString("KEY_REPORT_TARGET_TEXT", str3);
        TerminalActivity.d(context, ReportFragmentNew.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i, String str2, String[] strArr) {
        List<String> list = d;
        if (list != null && list.size() > 0 && !this.O) {
            AppMethods.a(getResources().getString(R.string.video_uploading));
            DialogUtils.b(this.h);
            return;
        }
        List<String> list2 = d;
        String[] strArr2 = strArr;
        if (list2 != null) {
            strArr2 = strArr;
            if (list2.size() > 0) {
                strArr2 = strArr;
                if (this.O) {
                    if (strArr != null) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= strArr.length) {
                                break;
                            }
                            if (!TextUtils.isEmpty(strArr[i3])) {
                                d.add(strArr[i3]);
                            }
                            i2 = i3 + 1;
                        }
                    }
                    strArr2 = (String[]) d.toArray(new String[0]);
                }
            }
        }
        a(str, i, str2, strArr2);
    }

    private void c() {
        String format;
        this.h = DialogUtils.a(this.b);
        CommonTopTitleNoTrans findViewById = this.f20238a.findViewById(R.id.top_title);
        this.f20239c = findViewById;
        findViewById.a();
        this.f20239c.setCenterText(this.b.getResources().getString(2131891497));
        this.f20239c.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ReportFragmentNew.this.onBackPressed();
            }
        });
        this.o = (TextView) this.f20238a.findViewById(R.id.tv_report_reason);
        this.p = (TextView) this.f20238a.findViewById(R.id.tv_report_target);
        this.q = (TextView) this.f20238a.findViewById(R.id.tv_text_count);
        this.r = (TextView) this.f20238a.findViewById(R.id.tv_identification);
        this.J = (TextView) this.f20238a.findViewById(R.id.tv_tips);
        this.q.setText("0/200");
        this.s = (EditText) this.f20238a.findViewById(R.id.et_report_description);
        TextWatcher textWatcher = new TextWatcher() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.2
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f20245c;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    ReportFragmentNew.this.s.removeTextChangedListener(ReportFragmentNew.this.w);
                    this.b = ReportFragmentNew.this.s.getSelectionStart();
                    this.f20245c = ReportFragmentNew.this.s.getSelectionEnd();
                    while (editable.length() > 200) {
                        editable.delete(this.b - 1, this.f20245c);
                        this.b--;
                        this.f20245c--;
                    }
                    int length = editable.length();
                    ReportFragmentNew.this.q.setText(length + "/200");
                    ReportFragmentNew.this.f();
                    ReportFragmentNew.this.s.addTextChangedListener(ReportFragmentNew.this.w);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.w = textWatcher;
        this.s.addTextChangedListener(textWatcher);
        boolean z = true;
        if (this.I == 1) {
            this.r.setText(getResources().getString(R.string.report_evidence));
        }
        TextView textView = (TextView) this.f20238a.findViewById(R.id.tv_pics_count);
        this.t = textView;
        textView.setText("0/6");
        this.u = (PhotoGridView) this.f20238a.findViewById(R.id.grid_view);
        NewsFeedGirdAdapter newsFeedGirdAdapter = new NewsFeedGirdAdapter(this.b, getFragmentActive(), this.B);
        this.z = newsFeedGirdAdapter;
        this.u.setAdapter((ListAdapter) newsFeedGirdAdapter);
        this.u.setOnItemClickListener(new AnonymousClass3());
        this.z.a(new NewsFeedGirdAdapter.OnClickDeletePhotoListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.4
            @Override // com.soft.blued.ui.feed.adapter.NewsFeedGirdAdapter.OnClickDeletePhotoListener
            public void a(int i) {
                if (i > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= i) {
                            break;
                        }
                        if (((ChildImageInfo) ReportFragmentNew.this.B.get(i3)).isVideo) {
                            ReportFragmentNew.this.l++;
                        } else {
                            ReportFragmentNew.this.m++;
                        }
                        i2 = i3 + 1;
                    }
                } else if (((ChildImageInfo) ReportFragmentNew.this.B.get(i)).isVideo) {
                    ReportFragmentNew.this.l++;
                }
                if (ReportFragmentNew.this.l > -1 && ReportFragmentNew.d != null && ReportFragmentNew.d.size() > ReportFragmentNew.this.l) {
                    ReportFragmentNew.d.remove(ReportFragmentNew.this.l);
                }
                if (!TextUtils.isEmpty(((ChildImageInfo) ReportFragmentNew.this.B.get(i)).mImagePath)) {
                    SelectPhotoManager.a().a(((ChildImageInfo) ReportFragmentNew.this.B.get(i)).mImagePath);
                }
                ReportFragmentNew.this.B.remove(i);
                ReportFragmentNew.this.g();
                ReportFragmentNew.this.z.notifyDataSetChanged();
                ReportFragmentNew.this.l = -1;
                ReportFragmentNew.this.m = -1;
            }
        });
        this.x = (LinearLayout) this.f20238a.findViewById(R.id.ll_block);
        this.y = (ToggleButton) this.f20238a.findViewById(R.id.tb_block);
        if (this.H) {
            this.x.setVisibility(0);
            this.y.setChecked(false);
        } else {
            this.x.setVisibility(8);
            this.y.setChecked(false);
        }
        TextView textView2 = (TextView) this.f20238a.findViewById(R.id.tv_submit);
        this.v = textView2;
        textView2.setOnClickListener(this);
        switch (this.e) {
            case 1:
                format = String.format(this.b.getResources().getString(R.string.report_user), this.g);
                break;
            case 2:
            case 9:
                format = String.format(this.b.getResources().getString(R.string.report_feed), this.g);
                break;
            case 3:
            case 8:
            default:
                format = "";
                break;
            case 4:
                format = String.format(this.b.getResources().getString(R.string.report_group), this.g);
                break;
            case 5:
            case 10:
                format = String.format(this.b.getResources().getString(R.string.report_comment), this.g);
                break;
            case 6:
            case 7:
                format = String.format(this.b.getResources().getString(R.string.report_chat), this.g);
                break;
            case 11:
                format = String.format(this.b.getResources().getString(R.string.report_album), this.g);
                break;
            case 12:
                format = String.format(this.b.getResources().getString(R.string.report_event), this.g);
                break;
            case 13:
                format = String.format(this.b.getResources().getString(R.string.report_event_signature), this.g);
                break;
        }
        this.K = this.f20238a.findViewById(R.id.bg_view_top);
        this.L = this.f20238a.findViewById(R.id.tv_submit_event);
        if (this.e == 12) {
            this.K.setVisibility(0);
            this.L.setVisibility(0);
            this.v.setVisibility(8);
        } else {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
        }
        this.L.setOnClickListener(this);
        this.p.setText(format);
        if (this.I != 1) {
            z = false;
        }
        ChooseReportReasonFragment.a(this, false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ReportPhotoMenuDialogFragment a2 = ReportPhotoMenuDialogFragment.f20260a.a(getFragmentManager());
        a2.a(new ReportPhotoMenuDialogFragment.ClickAlbumListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.5
            @Override // com.soft.blued.ui.user.fragment.ReportPhotoMenuDialogFragment.ClickAlbumListener
            public void a() {
                AlbumSelectFragment.a(ReportFragmentNew.this, 8, 3, 6 - SelectPhotoManager.a().c().size(), 100);
            }
        });
        a2.a(new ReportPhotoMenuDialogFragment.ClickCameraListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$ReportFragmentNew$8tM8qnT3hQ_cdKZzXBsZz76AlLM
            @Override // com.soft.blued.ui.user.fragment.ReportPhotoMenuDialogFragment.ClickCameraListener
            public final void onClick() {
                ReportFragmentNew.this.i();
            }
        });
        a2.a(new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$ReportFragmentNew$T4p3uodTIHNne9sKGHrq13k_R9s
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ReportFragmentNew.this.a(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Log.d("FeedSend", "uploadVideo videoFeed.getFirstFrameImgPath()" + this.j.c());
        StvResultModel stvResultModel = this.j;
        if (stvResultModel == null || TextUtils.isEmpty(stvResultModel.f())) {
            return;
        }
        Pair pair = new Pair(this.j.c(), "");
        Pair pair2 = new Pair(this.j.f(), "");
        this.O = false;
        VideoUploadManager.a().a(pair, pair2, new VideoUploadManager.VideoUploadListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.7
            public void a(String str, int i) {
                ReportFragmentNew.this.k = str;
            }

            public void a(String str, boolean z, ArrayList<Pair<String, UploadModel>> arrayList, List<Pair<String, String>> list) {
                ReportFragmentNew.this.k = str;
                ReportFragmentNew.this.O = true;
                if (ReportFragmentNew.d == null) {
                    ReportFragmentNew.d = new ArrayList();
                }
                ReportFragmentNew.d.add(list.get(list.size() - 1).second);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int i = this.E;
        if (i == -1) {
            this.v.setBackgroundColor(getResources().getColor(2131100365));
            this.v.setOnClickListener(null);
        } else if (i != 0) {
            this.v.setBackgroundColor(getResources().getColor(2131100364));
            this.v.setOnClickListener(this);
        } else {
            if (StringUtils.d(((Object) this.s.getText()) + "")) {
                this.v.setBackgroundColor(getResources().getColor(2131100365));
                this.v.setOnClickListener(null);
                return;
            }
            this.v.setBackgroundColor(getResources().getColor(2131100364));
            this.v.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        C = null;
        this.A.clear();
        this.A.addAll(SelectPhotoManager.a().c());
        this.B.clear();
        this.B.addAll(SelectPhotoManager.a().c());
        if (this.B.size() < 6) {
            ChildImageInfo childImageInfo = new ChildImageInfo();
            childImageInfo.mImagePath = null;
            this.B.add(childImageInfo);
        }
        TextView textView = this.t;
        textView.setText(this.A.size() + " / 6");
        NewsFeedGirdAdapter newsFeedGirdAdapter = this.z;
        if (newsFeedGirdAdapter != null) {
            newsFeedGirdAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        UserHttpUtils.b(this.b, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.10
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                UserInfo.getInstance().getLoginUserInfo().addBlackCount();
                ChatHelperV4.a().b(Long.parseLong(ReportFragmentNew.this.f));
                UserInfoEntity userInfoEntity = new UserInfoEntity();
                userInfoEntity.uid = ReportFragmentNew.this.f;
                userInfoEntity.relationship = "4";
                LiveEventBus.get("feed_relation_ship").post(userInfoEntity);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.f, (IRequestHost) getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        ShortVideoProxy.e().b(this, 8, 100);
    }

    protected void a() {
        this.h.show();
        if (this.A.size() > 0) {
            String[] strArr = C;
            if (strArr == null) {
                a(0);
            } else if (strArr.length > 0) {
                a(strArr.length - 1);
            }
        } else {
            b(((Object) this.s.getText()) + "", this.e, this.f, (String[]) null);
        }
        if (this.x.getVisibility() == 0 && this.y.isChecked()) {
            h();
        }
    }

    protected void a(String str, int i, String str2, String[] strArr) {
        ChatHttpUtils.a(this.b, new BluedUIHttpResponse<BluedEntityA<Object>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.9
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (ReportFragmentNew.d != null) {
                    ReportFragmentNew.d.clear();
                }
                CommonAlertDialog.a(ReportFragmentNew.this.b, (View) null, ReportFragmentNew.this.getResources().getString(R.string.report_success_title), ReportFragmentNew.this.getResources().getString(R.string.report_success_desc), ReportFragmentNew.this.getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.9.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Tracker.onClick(dialogInterface, i2);
                        ReportObserver.a().a(true);
                        ReportFragmentNew.this.getActivity().finish();
                    }
                }, new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.9.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        ReportObserver.a().a(true);
                        ReportFragmentNew.this.getActivity().finish();
                    }
                }, false);
            }

            public boolean onUIFailure(int i2, String str3, String str4) {
                if (((Integer) BluedHttpUtils.a((Throwable) null, i2, str4).first).intValue() == 0) {
                    return super.onUIFailure(i2, str3, str4);
                }
                switch (i2) {
                    case 403001:
                        CommonAlertDialog.a(ReportFragmentNew.this.b, ReportFragmentNew.this.b.getResources().getString(R.string.submission_failed), ReportFragmentNew.this.b.getResources().getString(R.string.submission_failed_details), ReportFragmentNew.this.b.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.9.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                Tracker.onClick(dialogInterface, i3);
                            }
                        }, (DialogInterface.OnDismissListener) null, 1);
                        return true;
                    case 403002:
                        CommonAlertDialog.a(ReportFragmentNew.this.b, ReportFragmentNew.this.b.getResources().getString(R.string.submission_failed), str3, ReportFragmentNew.this.b.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.9.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                Tracker.onClick(dialogInterface, i3);
                            }
                        }, (DialogInterface.OnDismissListener) null, 1);
                        return true;
                    default:
                        return super.onUIFailure(i2, str3, str4);
                }
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ReportFragmentNew.this.h);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ReportFragmentNew.this.h);
            }
        }, str, strArr, i, str2, this.G, 0L, this.E, this.F, this.f, this.M, this.N, getFragmentActive());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 100) {
                a(intent);
            }
        } else if (i2 != -1 || intent == null) {
            getActivity().finish();
        } else {
            this.E = intent.getIntExtra("KEY_REPORT_ITEM_ID", -1);
            String stringExtra = intent.getStringExtra("KEY_REPORT_ITEM_TEXT");
            this.F = stringExtra;
            if (TextUtils.equals(stringExtra, this.b.getResources().getString(R.string.content_unauth_report))) {
                if (UserInfo.getInstance().getLoginUserInfo().vbadge == 4 || UserInfo.getInstance().getLoginUserInfo().vbadge == 7) {
                    this.r.setText(R.string.identification_optional);
                } else {
                    this.J.setVisibility(0);
                    String string = this.b.getResources().getString(R.string.identification_required);
                    SpannableString spannableString = new SpannableString(string);
                    spannableString.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(2131102251)), string.indexOf("（"), spannableString.length(), 33);
                    this.r.setText(spannableString);
                }
            }
            TextView textView = this.o;
            textView.setText(this.b.getResources().getString(R.string.report_reason_with_coma) + this.F);
            f();
        }
    }

    public boolean onBackPressed() {
        if (StringUtils.d(((Object) this.s.getText()) + "") && this.A.size() == 0) {
            getActivity().finish();
            return true;
        }
        CommonAlertDialog.a(getActivity(), (String) null, getResources().getString(R.string.confirm_submit_cancel), getResources().getString(R.string.continue_report), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ReportFragmentNew.this.h.show();
                if (ReportFragmentNew.this.A.size() <= 0) {
                    ReportFragmentNew reportFragmentNew = ReportFragmentNew.this;
                    reportFragmentNew.b(((Object) ReportFragmentNew.this.s.getText()) + "", ReportFragmentNew.this.e, ReportFragmentNew.this.f, (String[]) null);
                } else if (ReportFragmentNew.C == null) {
                    ReportFragmentNew.this.a(0);
                } else if (ReportFragmentNew.C.length > 0) {
                    ReportFragmentNew.this.a(ReportFragmentNew.C.length - 1);
                }
                if (ReportFragmentNew.this.x.getVisibility() == 0 && ReportFragmentNew.this.y.isChecked()) {
                    ReportFragmentNew.this.h();
                }
            }
        }, getResources().getString(R.string.cancel_report), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.ReportFragmentNew.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ReportFragmentNew.this.getActivity().finish();
            }
        }, (DialogInterface.OnDismissListener) null);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.tv_submit /* 2131372655 */:
            case R.id.tv_submit_event /* 2131372656 */:
                a();
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        if (this.f20238a == null) {
            this.f20238a = layoutInflater.inflate(R.layout.fragment_report_new, viewGroup, false);
            if (getArguments() != null) {
                this.e = getArguments().getInt("KEY_REPORT_TARGET");
                this.f = getArguments().getString("KEY_REPORT_TARGET_ID");
                this.G = getArguments().getString("KEY_REPORT_EXTRA");
                this.g = getArguments().getString("KEY_REPORT_TARGET_TEXT");
                this.H = getArguments().getBoolean("KEY_REPORT_SHOW_BLOCK");
                this.I = getArguments().getInt("KEY_REPORT_EVENT_TYPE");
                this.M = getArguments().getString("KEY_REPORT_EVENT_POST_UID");
                this.N = getArguments().getInt("KEY_REPORT_EVENT_SIGN_ID");
            }
            SelectPhotoManager.a().d();
            c();
            g();
        }
        return this.f20238a;
    }

    public void onDestroy() {
        super.onDestroy();
        SelectPhotoManager.a().d();
    }

    public void onResume() {
        super.onResume();
        g();
        this.D = false;
    }
}
