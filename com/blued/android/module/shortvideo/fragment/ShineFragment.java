package com.blued.android.module.shortvideo.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.base.chat.ChatHelperV4Proxy;
import com.blued.android.module.base.live.LiveFloatManagerProxy;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.base.ui.PopMenuFromCenterProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IShineView;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import com.blued.android.module.shortvideo.permission.PermissionHelper;
import com.blued.android.module.shortvideo.presenter.ShinePresenter;
import com.blued.android.module.shortvideo.utils.DialogUtils;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.view.ConfigView;
import com.blued.android.module.shortvideo.view.ControllerView;
import com.blued.android.module.shortvideo.view.FilterView;
import com.blued.android.module.shortvideo.view.FocusIndicator;
import com.blued.android.module.shortvideo.view.SectionProgressBar;
import com.blued.android.module.shortvideo.view.StvCustomDialog;
import com.blued.android.module.shortvideo.view.TimeDownView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/ShineFragment.class */
public class ShineFragment extends ShortVideoBaseFragment<IShineView, ShinePresenter> implements View.OnClickListener, IShineView, EventObserver, ReturnObserver {
    private static DeleteAutoCheckedListener G;
    private ImageView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private FocusIndicator b;
    private RelativeLayout c;
    private ControllerView n;
    private ConfigView o;
    private FilterView p;
    private TimeDownView q;
    private boolean r;
    private GLSurfaceView s;
    private SectionProgressBar t;
    private Dialog u;
    private StvCustomDialog v;
    private View w;
    private View x;
    private ImageView y;
    private ImageView z;

    /* renamed from: com.blued.android.module.shortvideo.fragment.ShineFragment$6  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/ShineFragment$6.class */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0089 -> B:51:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008d -> B:67:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0091 -> B:61:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0095 -> B:55:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0099 -> B:49:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009d -> B:65:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a1 -> B:59:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a5 -> B:53:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00a9 -> B:47:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00ad -> B:63:0x007c). Please submit an issue!!! */
        static {
            int[] iArr = new int[EventType.VALUE.values().length];
            a = iArr;
            try {
                iArr[EventType.VALUE.START_TIMEDOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[EventType.VALUE.CONFIG_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[EventType.VALUE.CONCAT_SECOTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[EventType.VALUE.SHINE_ENDRECORD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[EventType.VALUE.CONCAT_SECTION_FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[EventType.VALUE.RECOVER_SHINE_V.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[EventType.VALUE.SAVE_FILTER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[EventType.VALUE.SHINE_TABS_LOCATION_FILE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[EventType.VALUE.SHINE_TABS_CAMERA.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[EventType.VALUE.SHINE_TABS_SHINE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[EventType.VALUE.SHINE_RECORD.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public static void a(final Object obj, final int i, final int i2, final int i3, final String str, final int i4, DeleteAutoCheckedListener deleteAutoCheckedListener) {
        Context context = obj instanceof Fragment ? ((Fragment) obj).getContext() : (Context) obj;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            AppMethods.d(R.string.stv_low_version_prompt);
            return;
        }
        if (deleteAutoCheckedListener != null) {
            G = deleteAutoCheckedListener;
        }
        if (PopMenuFromCenterProxy.a().a(context) || LiveFloatManagerProxy.a().a(context)) {
            return;
        }
        PermissionHelper.c(new PermissionCallbacks() { // from class: com.blued.android.module.shortvideo.fragment.ShineFragment.2
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                Bundle bundle = new Bundle();
                CommonModel commonModel = new CommonModel();
                commonModel.setFrom(i);
                commonModel.setCurrentPage(i2);
                bundle.putSerializable("commont_model", commonModel);
                bundle.putString("delete_auto_checkbox_text", str);
                bundle.putInt("delete_auto_number", i4);
                TerminalActivity.a(bundle);
                TerminalActivity.b(bundle);
                Object obj2 = obj;
                if (obj2 instanceof Activity) {
                    TerminalActivity.a((Activity) obj2, ShineFragment.class, bundle, i3);
                } else if (obj2 instanceof Fragment) {
                    TerminalActivity.a((Fragment) obj2, ShineFragment.class, bundle, i3);
                } else if (obj2 instanceof Application) {
                    TerminalActivity.d((Context) obj2, ShineFragment.class, bundle);
                }
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
    }

    public static void a(final Object obj, final int i, final String str, final String str2, final int i2) {
        Context context = obj instanceof Fragment ? ((Fragment) obj).getContext() : (Context) obj;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            AppMethods.d(R.string.stv_low_version_prompt);
        } else if (PopMenuFromCenterProxy.a().a(context) || LiveFloatManagerProxy.a().a(context)) {
        } else {
            PermissionHelper.c(new PermissionCallbacks() { // from class: com.blued.android.module.shortvideo.fragment.ShineFragment.1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    Bundle bundle = new Bundle();
                    CommonModel commonModel = new CommonModel();
                    commonModel.setFrom(i);
                    commonModel.setMusicPath(str);
                    commonModel.setMusicName(str2);
                    bundle.putSerializable("commont_model", commonModel);
                    TerminalActivity.a(bundle);
                    TerminalActivity.b(bundle);
                    Object obj2 = obj;
                    if (obj2 instanceof Activity) {
                        TerminalActivity.a((Activity) obj2, ShineFragment.class, bundle, i2);
                    } else if (obj2 instanceof Fragment) {
                        TerminalActivity.a((Fragment) obj2, ShineFragment.class, bundle, i2);
                    } else if (obj2 instanceof Application) {
                        TerminalActivity.d((Context) obj2, ShineFragment.class, bundle);
                    }
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                }
            });
        }
    }

    private void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_stv_common_dialog, (ViewGroup) null);
        this.w = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
        this.B = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) this.w.findViewById(R.id.tv_cancel);
        this.D = textView2;
        textView2.setText(R.string.stv_cancel);
        TextView textView3 = (TextView) this.w.findViewById(R.id.tv_ok);
        this.C = textView3;
        textView3.setText(R.string.stv_sure);
        this.E = (TextView) this.w.findViewById(R.id.tv_des);
        this.u = DialogUtils.a(getContext());
    }

    private void k() {
        c(true);
        ((ShinePresenter) this.k).t();
    }

    private void l() {
        ((ShinePresenter) this.k).w();
        this.b.d();
    }

    private void m() {
        this.r = !this.r;
        ((ShinePresenter) this.k).a(this.r);
        this.z.setActivated(this.r);
    }

    private void n() {
        if (this.c.getVisibility() == 0) {
            StvViewUtils.f(getContext(), this.c);
        }
    }

    private void o() {
        if (this.c.getVisibility() == 8) {
            this.c.setVisibility(0);
            StvViewUtils.e(getContext(), this.c);
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IShineView
    public void X_() {
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public GLSurfaceView a() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    /* renamed from: a */
    public ShinePresenter c(Bundle bundle) {
        return new ShinePresenter(bundle, G);
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView, com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void a(float f) {
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public void a(int i, int i2, int i3) {
        this.n.a(i, i2, i3);
        if (((ShinePresenter) this.k).o() != 8) {
            this.o.a(i, i2, i3);
        }
        this.p.a(i, i2, i3);
    }

    @Override // com.blued.android.module.shortvideo.contract.IShineView
    public void a(int i, long j, boolean z) {
        if (z) {
            b(false);
        }
        this.n.a(i, j);
        if (((ShinePresenter) this.k).o() != 8) {
            this.o.a(i, j);
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public void a(CommonModel commonModel) {
        this.q.a((ShinePresenter) this.k);
        this.n.a((ShinePresenter) this.k);
        if (((ShinePresenter) this.k).o() != 8) {
            this.o.a(commonModel);
        }
        this.p.a(commonModel);
        if (StringUtils.b(commonModel.getMusicName())) {
            this.x.setVisibility(8);
            return;
        }
        this.x.setVisibility(0);
        StringBuilder sb = new StringBuilder(commonModel.getMusicName());
        sb.append((CharSequence) sb);
        for (int i = 0; i < 10; i++) {
            sb.append("    ");
            sb.append((CharSequence) sb);
        }
        this.F.setText(sb);
        this.F.setLines(1);
        this.F.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.F.setSingleLine(true);
        this.F.setSelected(true);
        this.F.setFocusable(true);
        this.F.setFocusableInTouchMode(true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        switch (AnonymousClass6.a[value.ordinal()]) {
            case 1:
            case 2:
                n();
                return;
            case 3:
                k();
                return;
            case 4:
                b(true);
                o();
                return;
            case 5:
                c(false);
                break;
            case 6:
            case 7:
                break;
            case 8:
                if (this.t.i()) {
                    h_(2);
                    return;
                } else if (this.k != 0) {
                    ((ShinePresenter) this.k).j();
                    return;
                } else {
                    return;
                }
            case 9:
                if (this.t.i()) {
                    h_(3);
                    return;
                } else if (this.k != 0) {
                    ((ShinePresenter) this.k).i();
                    return;
                } else {
                    return;
                }
            case 10:
                if (this.k != 0) {
                    ((ShinePresenter) this.k).h();
                    return;
                }
                return;
            default:
                return;
        }
        o();
    }

    @Override // com.blued.android.module.shortvideo.observer.ReturnObserver
    public void a(EventType.VALUE value, boolean z) {
        if (z) {
            int i = AnonymousClass6.a[value.ordinal()];
            if (i == 4) {
                o();
            } else if (i != 11) {
            } else {
                n();
            }
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public BaseFragment b() {
        return this;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void b(Bundle bundle) {
        j();
        this.t = (SectionProgressBar) this.m.findViewById(R.id.record_progressbar);
        this.s = (GLSurfaceView) this.m.findViewById(R.id.preview);
        this.c = (RelativeLayout) this.m.findViewById(R.id.layoutTop);
        StatusBarHelper.a((Activity) getActivity(), (View) this.c);
        this.y = (ImageView) this.m.findViewById(R.id.btnBack);
        this.z = (ImageView) this.m.findViewById(R.id.switch_flash);
        this.A = (ImageView) this.m.findViewById(R.id.switch_camera);
        this.b = (FocusIndicator) this.m.findViewById(R.id.focus_indicator);
        this.n = (ControllerView) this.m.findViewById(R.id.stv_controller_view);
        this.o = (ConfigView) this.m.findViewById(R.id.stv_config_view);
        this.p = (FilterView) this.m.findViewById(R.id.stv_filter_view);
        TimeDownView timeDownView = (TimeDownView) this.m.findViewById(R.id.stv_timedown_view);
        this.q = timeDownView;
        timeDownView.setVisibility(0);
        this.x = this.m.findViewById(R.id.lay_music);
        this.F = (TextView) this.m.findViewById(R.id.tv_music);
    }

    @Override // com.blued.android.module.shortvideo.contract.IShineView, com.blued.android.module.shortvideo.contract.IBaseView
    public void c() {
        this.p.d();
        o();
        if (((ShinePresenter) this.k).o() != 8) {
            this.o.a();
        }
        this.n.a();
        if (((ShinePresenter) this.k).n() != 5) {
            this.t.a();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView
    public void c(boolean z) {
        Dialog dialog = this.u;
        if (dialog != null) {
            if (z) {
                dialog.show();
            } else {
                dialog.dismiss();
            }
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IShineView
    public void d() {
        this.z.setVisibility(((ShinePresenter) this.k).B() ? 0 : 8);
        this.r = false;
        this.z.setActivated(false);
        this.n.f();
    }

    @Override // com.blued.android.module.shortvideo.contract.IShineView
    public SectionProgressBar e() {
        return this.t;
    }

    @Override // com.blued.android.module.shortvideo.contract.IShineView
    public FocusIndicator f() {
        return this.b;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void h() {
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
    }

    @Override // com.blued.android.module.shortvideo.contract.IShineView
    public void h_(final int i) {
        if (this.v == null) {
            StvCustomDialog stvCustomDialog = new StvCustomDialog(getContext(), R.style.TranslucentBackground);
            this.v = stvCustomDialog;
            stvCustomDialog.requestWindowFeature(1);
            this.v.getWindow().setFlags(1024, 1024);
            this.v.setContentView(this.w);
            this.v.setCancelable(false);
        }
        StvCustomDialog stvCustomDialog2 = this.v;
        if (stvCustomDialog2 != null && stvCustomDialog2.isShowing()) {
            this.v.dismiss();
        }
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.shortvideo.fragment.ShineFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ShineFragment.this.v.dismiss();
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.shortvideo.fragment.ShineFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ShineFragment.this.v.dismiss();
                ShineFragment.this.t.a(false);
                if (ShineFragment.this.k != 0) {
                    ((ShinePresenter) ShineFragment.this.k).r();
                    ((ShinePresenter) ShineFragment.this.k).v();
                }
                int i2 = i;
                if (i2 == 2) {
                    if (ShineFragment.this.k != 0) {
                        ((ShinePresenter) ShineFragment.this.k).j();
                    }
                } else if (i2 != 3) {
                    if (ShineFragment.this.getActivity() != null) {
                        ShineFragment.this.getActivity().finish();
                    }
                } else if (ShineFragment.this.k != 0) {
                    ((ShinePresenter) ShineFragment.this.k).i();
                }
            }
        });
        this.E.setText(getString(R.string.stv_switch_channel_title));
        this.v.a(new StvCustomDialog.OnBackCallBack() { // from class: com.blued.android.module.shortvideo.fragment.ShineFragment.5
            @Override // com.blued.android.module.shortvideo.view.StvCustomDialog.OnBackCallBack
            public void a() {
            }
        });
    }

    public void i() {
        ObserverMgr.a().b((EventObserver) this);
        ObserverMgr.a().b((ReturnObserver) this);
        this.t.e();
        this.n.e();
        this.o.e();
        this.p.j();
        this.q.e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        StvViewUtils.a(view);
        int id = view.getId();
        if (id == R.id.btnBack) {
            onBackPressed();
        } else if (id == R.id.switch_flash) {
            m();
        } else if (id == R.id.switch_camera) {
            l();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(19);
        getActivity().getWindow().setFlags(1024, 1024);
        super.a(layoutInflater, R.layout.activity_stv_shoot_v, viewGroup, bundle);
        StvLogUtils.a(j + "ShineFragment onCreate()", new Object[0]);
        ChatHelperV4Proxy.a().c();
        return this.m;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        ChatHelperV4Proxy.a().b();
        this.t.f();
        this.n.g();
        this.o.f();
        this.p.k();
        this.q.f();
        i();
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        o();
        this.t.d();
        this.n.d();
        this.o.d();
        this.p.i();
        this.q.d();
        i();
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        ObserverMgr.a().a((EventObserver) this);
        ObserverMgr.a().a((ReturnObserver) this);
        this.t.c();
        this.n.c();
        this.o.c();
        this.p.h();
        this.q.c();
    }
}
