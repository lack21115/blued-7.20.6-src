package com.soft.blued.ui.live.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.fragment.ClipPhotoFragment;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.live.model.LiveIDCardUploadResult;
import com.soft.blued.ui.live.presenter.LiveBaseImprovePresenter;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.utils.CameraUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveBaseImproveFragment.class */
public abstract class LiveBaseImproveFragment<P extends LiveBaseImprovePresenter> extends MvpFragment<P> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final int f31142a = 0;
    public final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Context f31143c;
    @BindView
    ImageView cover_del_btn1;
    @BindView
    ImageView cover_del_btn2;
    public BluedLiveState d;
    public boolean e;
    private String f;
    @BindView
    View fl_error_page;
    private String g;
    @BindView
    ImageView iv_card_binded;
    private String k;
    private String l;
    @BindView
    View live_add_card_layout1;
    @BindView
    View live_add_card_layout2;
    @BindView
    ImageView live_card1;
    @BindView
    ImageView live_card2;
    @BindView
    View live_id_card_error;
    @BindView
    View ll_bottom_button;
    @BindView
    View ll_main;
    private String m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private Dialog r;
    private Dialog s;
    @BindView
    CommonTopTitleNoTrans top_title;
    @BindView
    TextView tv_binding_credit_card;
    @BindView
    TextView tv_binding_credit_card_status;
    @BindView
    View tv_reload;
    @BindView
    TextView tv_start_verify;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveBaseImproveFragment$DialogViewHolder.class */
    public class DialogViewHolder {
        @BindView
        Button openCamera;
        @BindView
        ImageView openClose;
        @BindView
        Button openPhones;
        @BindView
        ImageView viewer_card;

        DialogViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveBaseImproveFragment$DialogViewHolder_ViewBinding.class */
    public class DialogViewHolder_ViewBinding implements Unbinder {
        private DialogViewHolder b;

        public DialogViewHolder_ViewBinding(DialogViewHolder dialogViewHolder, View view) {
            this.b = dialogViewHolder;
            dialogViewHolder.viewer_card = (ImageView) Utils.a(view, R.id.viewer_card, "field 'viewer_card'", ImageView.class);
            dialogViewHolder.openPhones = (Button) Utils.a(view, R.id.openPhones, "field 'openPhones'", Button.class);
            dialogViewHolder.openCamera = (Button) Utils.a(view, R.id.openCamera, "field 'openCamera'", Button.class);
            dialogViewHolder.openClose = (ImageView) Utils.a(view, R.id.openClose, "field 'openClose'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            DialogViewHolder dialogViewHolder = this.b;
            if (dialogViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            dialogViewHolder.viewer_card = null;
            dialogViewHolder.openPhones = null;
            dialogViewHolder.openCamera = null;
            dialogViewHolder.openClose = null;
        }
    }

    private void a(int i) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.photo_choose_dialog, (ViewGroup) null);
        DialogViewHolder dialogViewHolder = new DialogViewHolder();
        ButterKnife.a(dialogViewHolder, inflate);
        if (i == 0) {
            dialogViewHolder.viewer_card.setImageResource(R.drawable.live_id_card_front);
        } else if (i == 1) {
            dialogViewHolder.viewer_card.setImageResource(R.drawable.live_id_card_back);
        }
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyle);
        this.r = dialog;
        dialog.requestWindowFeature(1);
        this.r.setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        Window window = this.r.getWindow();
        window.setWindowAnimations(2131952889);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        attributes.width = -1;
        attributes.height = -1;
        this.r.onWindowAttributesChanged(attributes);
        String[] stringArray = getResources().getStringArray(R.array.send_feed);
        dialogViewHolder.openPhones.setText(stringArray[1]);
        dialogViewHolder.openPhones.setOnClickListener(this);
        dialogViewHolder.openCamera.setText(stringArray[0]);
        dialogViewHolder.openCamera.setOnClickListener(this);
        dialogViewHolder.openClose.setOnClickListener(this);
        this.r.setCanceledOnTouchOutside(true);
        this.r.show();
    }

    private void b(int i, String str) {
        this.q = i;
        BasePhotoFragment.a(this.f31143c, new String[]{str}, 0, 8, new LoadOptions());
    }

    private void c() {
        this.s = DialogUtils.a(getActivity());
        this.top_title.a();
        this.top_title.setCenterText(getString(2131889245));
        this.top_title.setLeftClickListener(this);
        this.top_title.setCenterTextColor(2131102254);
        c(true);
        this.tv_binding_credit_card.setOnClickListener(this);
        this.tv_binding_credit_card_status.setOnClickListener(this);
        this.live_add_card_layout1.setOnClickListener(this);
        this.live_add_card_layout2.setOnClickListener(this);
        this.live_card1.setOnClickListener(this);
        this.live_card2.setOnClickListener(this);
        this.cover_del_btn1.setOnClickListener(this);
        this.cover_del_btn2.setOnClickListener(this);
        this.tv_reload.setOnClickListener(this);
    }

    private void c(boolean z) {
        int i = 8;
        if (this.d == null) {
            this.ll_main.setVisibility(8);
            View view = this.fl_error_page;
            if (!z) {
                i = 0;
            }
            view.setVisibility(i);
            if (z) {
                b(false);
            }
        } else {
            this.ll_main.setVisibility(0);
            this.fl_error_page.setVisibility(8);
            if (this.d.has_bankcard == 1) {
                this.p = true;
                this.tv_binding_credit_card_status.setVisibility(0);
                this.tv_binding_credit_card.setVisibility(8);
                this.iv_card_binded.setVisibility(0);
            } else {
                this.p = false;
                this.tv_binding_credit_card_status.setVisibility(8);
                this.tv_binding_credit_card.setVisibility(0);
                this.iv_card_binded.setVisibility(8);
            }
            this.l = this.d.idcard_front;
            this.m = this.d.idcard_after;
            if (TextUtils.isEmpty(this.l)) {
                this.cover_del_btn1.setVisibility(8);
            } else {
                this.live_card1.setVisibility(0);
                ImageLoader.a(getFragmentActive(), this.l).b(R.drawable.live_id_card_default).a(this.live_card1);
                this.n = true;
                this.cover_del_btn1.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.m)) {
                this.cover_del_btn2.setVisibility(8);
            } else {
                this.live_card2.setVisibility(0);
                ImageLoader.a(getFragmentActive(), this.m).b(R.drawable.live_id_card_default).a(this.live_card2);
                this.o = true;
                this.cover_del_btn2.setVisibility(0);
            }
        }
        d();
    }

    private void d() {
        if (this.n && this.o && this.p) {
            this.ll_bottom_button.setBackgroundColor(-16738064);
            this.ll_bottom_button.setOnClickListener(this);
            return;
        }
        this.ll_bottom_button.setBackgroundColor(-4144960);
        this.ll_bottom_button.setOnClickListener(null);
    }

    private void e() {
        this.f = CameraUtils.a(this);
    }

    public abstract void a(int i, String str);

    public abstract void a(Context context, String str, int i);

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        c();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List list) {
        boolean z;
        super.a(str, list);
        Log.i("xpp", "type:" + str);
        switch (str.hashCode()) {
            case -694052169:
                if (str.equals("LIVE_IMPROVE_STATE")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -273513251:
                if (str.equals("LIVE_CARD_FRONT_DELETE")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -189439929:
                if (str.equals("LIVE_CARD_BACK_DELETE")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 223350067:
                if (str.equals("LIVE_CARD_FRONT_UPLOAD")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 307423389:
                if (str.equals("LIVE_CARD_BACK_UPLOAD")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (z) {
            if (!z) {
                if (z) {
                    this.n = false;
                    this.live_card1.setVisibility(8);
                    this.cover_del_btn1.setVisibility(8);
                    this.l = "";
                } else if (z) {
                    this.o = false;
                    this.live_card2.setVisibility(8);
                    this.cover_del_btn2.setVisibility(8);
                    this.m = "";
                } else if (!z) {
                    b(str, list);
                } else if (list != null && list.size() > 0) {
                    this.d = (BluedLiveState) list.get(0);
                }
            } else if (list != null && list.size() > 0) {
                this.o = true;
                this.m = ((LiveIDCardUploadResult) list.get(0)).pic;
                this.live_card2.setVisibility(0);
                ImageLoader.d(getFragmentActive(), this.k).b(R.drawable.live_id_card_default).a(this.live_card2);
                this.cover_del_btn2.setVisibility(0);
                InstantLog.b("verify_photo_uploaded", 1);
                EventTrackSettings.b(SettingsProtos.Event.VERIFY_PHOTO_UPLOADED, 1);
            }
        } else if (list != null && list.size() > 0) {
            this.n = true;
            this.l = ((LiveIDCardUploadResult) list.get(0)).pic;
            this.live_card1.setVisibility(0);
            ImageLoader.d(getFragmentActive(), this.g).b(R.drawable.live_id_card_default).a(this.live_card1);
            this.cover_del_btn1.setVisibility(0);
            InstantLog.b("verify_photo_uploaded", 0);
            EventTrackSettings.b(SettingsProtos.Event.VERIFY_PHOTO_UPLOADED, 0);
        }
        d();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        DialogUtils.b(this.s);
        if (str == "LIVE_IMPROVE_STATE") {
            c(false);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
    }

    public abstract void b();

    public abstract void b(String str, List list);

    public abstract void b(boolean z);

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_apply_improve;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
        DialogUtils.a(this.s);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 0) {
                ClipPhotoFragment.a(this, 9, this.f, 22);
            } else if (i == 22 && intent != null) {
                String stringExtra = intent.getStringExtra("photo_path");
                this.f = stringExtra;
                int i3 = this.q;
                if (i3 == 0) {
                    this.g = stringExtra;
                    a(this.f31143c, stringExtra, 0);
                } else if (i3 == 1) {
                    this.k = stringExtra;
                    a(this.f31143c, stringExtra, 1);
                }
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.cover_del_btn1 /* 2131363092 */:
                a(0, this.l);
                return;
            case R.id.cover_del_btn2 /* 2131363093 */:
                a(1, this.m);
                return;
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.live_add_card_layout1 /* 2131366915 */:
                this.q = 0;
                a(0);
                return;
            case R.id.live_add_card_layout2 /* 2131366916 */:
                this.q = 1;
                a(1);
                return;
            case R.id.live_card1 /* 2131366956 */:
                b(0, this.l);
                return;
            case R.id.live_card2 /* 2131366957 */:
                b(1, this.m);
                return;
            case 2131367669:
                b(true);
                return;
            case R.id.openCamera /* 2131368772 */:
                this.r.cancel();
                e();
                return;
            case R.id.openClose /* 2131368773 */:
                this.r.cancel();
                return;
            case R.id.openPhones /* 2131368775 */:
                this.r.cancel();
                PhotoSelectFragment.a(this, 9, 22);
                return;
            case R.id.tv_binding_credit_card /* 2131370983 */:
            case R.id.tv_binding_credit_card_status /* 2131370984 */:
                this.e = true;
                b();
                return;
            case 2131372414:
                b(false);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f31143c = getContext();
    }
}
