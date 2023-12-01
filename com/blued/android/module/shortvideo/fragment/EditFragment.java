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
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.base.chat.ChatHelperV4Proxy;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ICoverSlideListener;
import com.blued.android.module.shortvideo.contract.IEditContentView;
import com.blued.android.module.shortvideo.contract.IEditView;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPresenter;
import com.blued.android.module.shortvideo.utils.DialogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.view.ConfigView;
import com.blued.android.module.shortvideo.view.CoverView;
import com.blued.android.module.shortvideo.view.EditMainView;
import com.blued.android.module.shortvideo.view.EditVolumeView;
import com.blued.android.module.shortvideo.view.FilterView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/EditFragment.class */
public class EditFragment extends ShortVideoBaseFragment<IEditView, EditPresenter> implements View.OnClickListener, ICoverSlideListener, IEditContentView, IEditView, EventObserver {
    private static DeleteAutoCheckedListener x;
    protected FilterView b;
    protected CoverView c;
    private GLSurfaceView n;
    private ConfigView o;
    private EditMainView p;
    private EditVolumeView q;
    private Dialog r;
    private RelativeLayout s;
    private ImageView t;
    private View u;
    private TextView v;
    private KeyboardListenLinearLayout w;

    /* renamed from: com.blued.android.module.shortvideo.fragment.EditFragment$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/EditFragment$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[EventType.VALUE.values().length];
            a = iArr;
            try {
                iArr[EventType.VALUE.CONFIG_VOLUME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[EventType.VALUE.CONFIG_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[EventType.VALUE.CONFIG_COVER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[EventType.VALUE.EDIT_FINISH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[EventType.VALUE.HIDE_COVER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[EventType.VALUE.SAVE_FILTER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[EventType.VALUE.SAVE_VOLUME.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static void a(Object obj, CommonModel commonModel, int i, int i2, String str, int i3, DeleteAutoCheckedListener deleteAutoCheckedListener) {
        Bundle bundle = new Bundle();
        CommonModel commonModel2 = new CommonModel();
        commonModel2.copyModel(commonModel);
        bundle.putSerializable("commont_model", commonModel2);
        bundle.putInt("from", i2);
        bundle.putString("delete_auto_checkbox_text", str);
        bundle.putInt("delete_auto_number", i3);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        if (deleteAutoCheckedListener != null) {
            x = deleteAutoCheckedListener;
        }
        if (obj instanceof Activity) {
            TerminalActivity.a((Activity) obj, EditFragment.class, bundle, i);
        } else if (obj instanceof Fragment) {
            TerminalActivity.a((Fragment) obj, EditFragment.class, bundle, i);
        } else if (obj instanceof Application) {
            TerminalActivity.d((Context) obj, EditFragment.class, bundle);
        }
    }

    public static void a(Object obj, String str, String str2, int i) {
        boolean z = obj instanceof Fragment;
        if (z) {
            ((Fragment) obj).getContext();
        } else {
            Context context = (Context) obj;
        }
        if (Build.VERSION.SDK_INT < 18) {
            AppMethods.d(R.string.stv_low_version_prompt);
            return;
        }
        EditDataModel.SerializableData serializableData = new EditDataModel.SerializableData();
        serializableData.m = str2;
        serializableData.setFrom(2);
        serializableData.setVideoPath(str);
        serializableData.setOriginalVideoPath(str);
        serializableData.setCanDeleteVideoFile(false);
        Bundle bundle = new Bundle();
        bundle.putSerializable("serializeble_data", serializableData);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        if (obj instanceof Activity) {
            TerminalActivity.a((Activity) obj, EditFragment.class, bundle, i);
        } else if (z) {
            TerminalActivity.a((Fragment) obj, EditFragment.class, bundle, i);
        } else if (obj instanceof Application) {
            TerminalActivity.d((Context) obj, EditFragment.class, bundle);
        }
    }

    private void b(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        super.a(keyboardListenLinearLayout);
    }

    private void k() {
        if (this.s.getVisibility() == 0) {
            StvViewUtils.f(getContext(), this.s);
        }
    }

    private void l() {
        if (this.s.getVisibility() == 8) {
            this.s.setVisibility(0);
            StvViewUtils.e(getContext(), this.s);
        }
    }

    private void m() {
        j();
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public GLSurfaceView a() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    /* renamed from: a */
    public EditPresenter c(Bundle bundle) {
        return new EditPresenter(bundle);
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView, com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void a(float f) {
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public void a(int i, int i2, int i3) {
        if (getPresenter().a != 8) {
            this.o.a(i, i2, i3);
        }
        this.c.a(i, i2, i3);
        this.p.a(i, i2, i3, x);
        this.b.a(i, i2, i3);
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public void a(CommonModel commonModel) {
        if (getPresenter().a != 8) {
            this.o.a(commonModel);
            this.o.a(((EditDataModel.SerializableData) commonModel).a());
        }
        this.c.a(this);
        this.p.a((EditPresenter) this.k);
        if (AppInfo.p()) {
            this.p.setDeleteAutoCbText(getPresenter().b);
            this.p.setDeleteAutoNumber(getPresenter().c);
        }
        this.b.a(commonModel);
        this.q.a((EditPresenter) this.k);
        if (StringUtils.b(commonModel.getMusicName())) {
            this.u.setVisibility(8);
            return;
        }
        this.u.setVisibility(0);
        StringBuilder sb = new StringBuilder(commonModel.getMusicName());
        sb.append((CharSequence) sb);
        for (int i = 0; i < 10; i++) {
            sb.append("    ");
            sb.append((CharSequence) sb);
        }
        this.v.setText(sb);
        this.v.setLines(1);
        this.v.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.v.setSingleLine(true);
        this.v.setSelected(true);
        this.v.setFocusable(true);
        this.v.setFocusableInTouchMode(true);
    }

    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        switch (AnonymousClass1.a[value.ordinal()]) {
            case 1:
            case 2:
            case 3:
                k();
                return;
            case 4:
                c(true);
                return;
            case 5:
            case 6:
            case 7:
                l();
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public BaseFragment b() {
        return this;
    }

    @Override // com.blued.android.module.shortvideo.contract.ICoverSlideListener
    public void b(int i) {
        if (this.k != 0) {
            ((EditPresenter) this.k).a(i);
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void b(Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(16);
        this.w = (KeyboardListenLinearLayout) this.m.findViewById(R.id.keyboardLinearLayout);
        this.s = (RelativeLayout) this.m.findViewById(R.id.layoutTop);
        StatusBarHelper.a((Activity) getActivity(), (View) this.s);
        this.t = (ImageView) this.m.findViewById(R.id.btnBack);
        this.n = (GLSurfaceView) this.m.findViewById(R.id.stv_edit_preview);
        this.p = (EditMainView) this.m.findViewById(R.id.stv_main_view);
        this.o = (ConfigView) this.m.findViewById(R.id.stv_config_view);
        this.q = (EditVolumeView) this.m.findViewById(R.id.stv_volume_view);
        this.b = (FilterView) this.m.findViewById(R.id.stv_filter_view);
        this.c = (CoverView) this.m.findViewById(R.id.stv_cover_view);
        this.r = DialogUtils.a(getContext());
        this.u = this.m.findViewById(R.id.lay_music);
        this.v = (TextView) this.m.findViewById(R.id.tv_music);
        DeleteAutoCheckedListener deleteAutoCheckedListener = x;
        if (deleteAutoCheckedListener != null) {
            deleteAutoCheckedListener.a(this.p.getDeleteAutoCb());
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public void c() {
        j();
        this.b.d();
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView
    public void c(boolean z) {
        if (z) {
            this.r.show();
        } else {
            this.r.dismiss();
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.IEditView
    public void d() {
        this.q.d();
        j();
    }

    @Override // com.blued.android.module.shortvideo.contract.IEditView
    public void e() {
        this.c.d();
        j();
    }

    @Override // com.blued.android.module.shortvideo.contract.ICoverSlideListener
    public EditPresenter getPresenter() {
        return (EditPresenter) this.k;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void h() {
        this.t.setOnClickListener(this);
    }

    public void i() {
        ObserverMgr.a().b(this);
        this.p.e();
        this.b.j();
        this.c.j();
        if (getPresenter().a != 8) {
            this.o.e();
        }
        this.q.j();
    }

    public void j() {
        ((EditPresenter) this.k).b(0);
        if (getPresenter().a != 8) {
            this.o.a();
        }
        l();
        this.p.a();
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        int r = ((EditPresenter) this.k).r();
        if (r == 1) {
            m();
            return true;
        } else if (r == 2) {
            c();
            return true;
        } else if (r == 3) {
            e();
            return true;
        } else if (r == 4) {
            d();
            return true;
        } else {
            g();
            if (this.k != 0) {
                ((EditPresenter) this.k).g();
            }
            if (getActivity() != null) {
                getActivity().finish();
                return false;
            }
            return false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.btnBack) {
            StvViewUtils.a(this.t);
            onBackPressed();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.m == null) {
            super.a(layoutInflater, R.layout.activity_stv_edit, viewGroup, bundle);
            b(this.w);
            ChatHelperV4Proxy.a().c();
        } else if (this.m.getParent() != null) {
            ((ViewGroup) this.m.getParent()).removeView(this.m);
        }
        return this.m;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        ChatHelperV4Proxy.a().b();
        i();
        this.p.f();
        this.b.k();
        this.c.k();
        if (getPresenter().a != 8) {
            this.o.f();
        }
        this.q.k();
        x = null;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        i();
        this.p.d();
        this.b.i();
        this.c.i();
        if (getPresenter().a != 8) {
            this.o.d();
        }
        this.q.i();
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        ObserverMgr.a().a(this);
        this.p.c();
        this.b.h();
        this.c.h();
        if (getPresenter().a != 8) {
            this.o.c();
        }
        this.q.h();
    }
}
