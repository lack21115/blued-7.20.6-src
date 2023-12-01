package com.blued.android.module.shortvideo.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ITrimBottomCallback;
import com.blued.android.module.shortvideo.contract.ITrimView;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.TrimDataModel;
import com.blued.android.module.shortvideo.presenter.TrimPresenter;
import com.blued.android.module.shortvideo.utils.DialogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.view.RangeSeekBar;
import com.blued.android.module.shortvideo.view.TrimNewBottomView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/TrimFragment.class */
public class TrimFragment extends ShortVideoBaseFragment<ITrimView, TrimPresenter> implements View.OnClickListener, ITrimBottomCallback, ITrimView {
    private static DeleteAutoCheckedListener q;
    private VideoView b;
    private RelativeLayout c;
    private ImageView n;
    private Dialog o;
    private TrimNewBottomView p;

    public static void a(Object obj, String str, int i, int i2, String str2, int i3, DeleteAutoCheckedListener deleteAutoCheckedListener) {
        Bundle bundle = new Bundle();
        CommonModel commonModel = new CommonModel();
        commonModel.setVideoPath(str);
        commonModel.setOriginalVideoPath(str);
        commonModel.setFrom(i);
        bundle.putSerializable("commont_model", commonModel);
        bundle.putString("delete_auto_checkbox_text", str2);
        bundle.putInt("delete_auto_number", i3);
        TerminalActivity.a(bundle);
        if (deleteAutoCheckedListener != null) {
            q = deleteAutoCheckedListener;
        }
        if (obj instanceof Activity) {
            TerminalActivity.a((Activity) obj, TrimFragment.class, bundle, i2);
        } else if (obj instanceof Fragment) {
            TerminalActivity.a((Fragment) obj, TrimFragment.class, bundle, i2);
        } else if (obj instanceof Application) {
            TerminalActivity.d((Context) obj, TrimFragment.class, bundle);
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public BaseFragment a() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    /* renamed from: a */
    public TrimPresenter c(Bundle bundle) {
        return new TrimPresenter(bundle, q);
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public void a(double d) {
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.a(d);
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView, com.blued.android.module.shortvideo.contract.IAuthPreviewView
    public void a(float f) {
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimBottomCallback
    public void a(View view) {
        c(true);
        if (this.k != 0) {
            ((TrimPresenter) this.k).a(view, 200);
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public void a(RecyclerView.OnScrollListener onScrollListener) {
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.a(onScrollListener);
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public void a(TrimDataModel trimDataModel) {
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.a(this, trimDataModel);
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public void a(RangeSeekBar.OnRangeSeekBarChangeListener onRangeSeekBarChangeListener) {
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.setOnRangeSeekBarChangeListener(onRangeSeekBarChangeListener);
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public VideoView b() {
        return this.b;
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimBottomCallback
    public void b(int i) {
        if (this.k != 0) {
            if (((TrimPresenter) this.k).l()) {
                ((TrimPresenter) this.k).m();
            }
            ((TrimPresenter) this.k).b(i);
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void b(Bundle bundle) {
        this.c = (RelativeLayout) this.m.findViewById(R.id.layoutTop);
        StatusBarHelper.a((Activity) getActivity(), (View) this.c);
        this.n = (ImageView) this.m.findViewById(R.id.btnBack);
        this.p = (TrimNewBottomView) this.m.findViewById(R.id.stv_trim_bottom_v);
        this.b = (VideoView) this.m.findViewById(R.id.stv_trim_preview);
        this.o = DialogUtils.a(getContext());
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public long c() {
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            return trimNewBottomView.getSelectedMinValue();
        }
        return 0L;
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public void c(int i) {
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.a(i);
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.module.shortvideo.contract.IView
    public void c(boolean z) {
        if (z) {
            this.o.show();
        } else {
            this.o.dismiss();
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public long d() {
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            return trimNewBottomView.getSelectedMaxValue();
        }
        return 0L;
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimView
    public void e() {
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.e();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    protected void h() {
        this.n.setOnClickListener(this);
        StvViewUtils.e(getContext(), this.c);
    }

    public void i() {
        g();
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.c();
        }
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // com.blued.android.module.shortvideo.contract.ITrimBottomCallback
    public void i_(int i) {
        if (this.k != 0) {
            ((TrimPresenter) this.k).a(i);
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 200 && getActivity() != null) {
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        i();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.btnBack) {
            StvViewUtils.a(this.n);
            i();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.m == null) {
            super.a(layoutInflater, R.layout.activity_stv_trim, viewGroup, bundle);
        } else if (this.m.getParent() != null) {
            ((ViewGroup) this.m.getParent()).removeView(this.m);
        }
        return this.m;
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.d();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.b();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        TrimNewBottomView trimNewBottomView = this.p;
        if (trimNewBottomView != null) {
            trimNewBottomView.a();
        }
    }

    @Override // com.blued.android.module.shortvideo.fragment.ShortVideoBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            CommonModel commonModel = new CommonModel();
            commonModel.copyModel(((TrimPresenter) this.k).h());
            TrimDataModel.SerializableData serializableData = new TrimDataModel.SerializableData();
            serializableData.a(((TrimPresenter) this.k).i());
            bundle.putSerializable("commont_model", commonModel);
            bundle.putSerializable("serializeble_data", serializableData);
        }
    }
}
