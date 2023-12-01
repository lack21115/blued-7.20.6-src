package com.blued.android.module.shortvideo.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.module.base.chat.ChatHelperV4Proxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IBaseView;
import com.blued.android.module.shortvideo.contract.IEditPreContentView;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPreViewPresenter;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/EditPreViewFragment.class */
public class EditPreViewFragment extends ShortVideoBaseFragment<IBaseView, EditPreViewPresenter> implements View.OnClickListener, IBaseView, IEditPreContentView, EventObserver {
    private GLSurfaceView b;
    private RelativeLayout c;
    private ImageView n;
    private KeyboardListenLinearLayout o;
    private RelativeLayout p;
    private View q;
    private View r;
    private View s;
    private View t;
    private CommonModel u;

    /* renamed from: com.blued.android.module.shortvideo.fragment.EditPreViewFragment$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/EditPreViewFragment$1.class */
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

    public static void a(Object obj, Bundle bundle, int i) {
        if (bundle == null) {
            return;
        }
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        if (obj instanceof Activity) {
            TerminalActivity.a((Activity) obj, EditPreViewFragment.class, bundle, i);
        } else if (obj instanceof Fragment) {
            TerminalActivity.a((Fragment) obj, EditPreViewFragment.class, bundle, i);
        } else if (obj instanceof Application) {
            TerminalActivity.d((Context) obj, EditPreViewFragment.class, bundle);
        }
    }

    private void b(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        super.a(keyboardListenLinearLayout);
    }

    private void k() {
        if (this.c.getVisibility() == 0) {
            StvViewUtils.f(getContext(), this.c);
        }
    }

    private void l() {
        if (this.c.getVisibility() == 8) {
            this.c.setVisibility(0);
            StvViewUtils.e(getContext(), this.c);
        }
    }

    private void m() {
        j();
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public GLSurfaceView a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    /* renamed from: a */
    public EditPreViewPresenter c(Bundle bundle) {
        return new EditPreViewPresenter(bundle);
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public void a(int i, int i2, int i3) {
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public void a(CommonModel commonModel) {
        EditDataModel.SerializableData serializableData;
        if (commonModel instanceof EditDataModel.SerializableData) {
            serializableData = (EditDataModel.SerializableData) commonModel;
            this.u = commonModel;
        } else {
            serializableData = null;
        }
        this.p = (RelativeLayout) this.m.findViewById(R.id.activity_local_editor_bottombar);
        if (commonModel.getFrom() < 60) {
            this.p.setVisibility(8);
            return;
        }
        this.p.setVisibility(0);
        this.q = this.m.findViewById(R.id.activity_local_editor_edit_less);
        this.r = this.m.findViewById(R.id.activity_local_editor_tip);
        this.s = this.m.findViewById(R.id.activity_local_editor_edit_more);
        this.t = this.m.findViewById(R.id.activity_local_editor_send);
        this.q.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        if (serializableData.q < 2000) {
            this.q.setVisibility(8);
            this.r.setVisibility(4);
            this.s.setVisibility(8);
            this.t.setVisibility(0);
        } else if (serializableData.q > 60000) {
            this.q.setVisibility(8);
            this.r.setVisibility(0);
            this.s.setVisibility(0);
            this.t.setVisibility(8);
        } else {
            this.q.setVisibility(0);
            this.r.setVisibility(4);
            this.s.setVisibility(8);
            this.t.setVisibility(0);
        }
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

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void b(Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(16);
        this.o = (KeyboardListenLinearLayout) this.m.findViewById(R.id.keyboardLinearLayout);
        this.c = (RelativeLayout) this.m.findViewById(R.id.layoutTop);
        StatusBarHelper.a((Activity) getActivity(), (View) this.c);
        this.n = (ImageView) this.m.findViewById(R.id.btnBack);
        this.b = (GLSurfaceView) this.m.findViewById(R.id.stv_edit_preview);
    }

    @Override // com.blued.android.module.shortvideo.contract.IBaseView
    public void c() {
        j();
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void h() {
        this.n.setOnClickListener(this);
    }

    public void i() {
        ObserverMgr.a().b(this);
    }

    public void j() {
        ((EditPreViewPresenter) this.k).a(0);
        l();
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 300 && getActivity() != null) {
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        int o = ((EditPreViewPresenter) this.k).o();
        if (o == 1) {
            m();
            return true;
        } else if (o == 2) {
            c();
            return true;
        } else {
            g();
            if (this.k != 0) {
                ((EditPreViewPresenter) this.k).g();
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
        int id = view.getId();
        if (id == R.id.btnBack) {
            StvViewUtils.a(this.n);
            onBackPressed();
        } else if (id == R.id.activity_local_editor_edit_less || id == R.id.activity_local_editor_edit_more) {
            TrimFragment.a(this, this.u.getVideoPath(), this.u.getFrom(), 300, "", 0, null);
        } else if (id == R.id.activity_local_editor_send) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("serializeble_data", this.u);
            SaveVideoFragment.a(this, bundle, this.u.getFrom(), 300);
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.m == null) {
            super.a(layoutInflater, R.layout.activity_stv_pre_edit, viewGroup, bundle);
            b(this.o);
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
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        i();
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        ObserverMgr.a().a(this);
    }
}
