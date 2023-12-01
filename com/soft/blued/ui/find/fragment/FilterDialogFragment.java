package com.soft.blued.ui.find.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.user.BluedConfig;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FilterDialogFragment.class */
public class FilterDialogFragment extends CommonDialogFragment {
    public static boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f30190c;
    private FilterFragment d;
    private FilterNewFragment e;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FilterDialogFragment$OutsideClickDialog.class */
    static class OutsideClickDialog extends Dialog {

        /* renamed from: a  reason: collision with root package name */
        private boolean f30192a;
        private OnOutsideClickListener b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FilterDialogFragment$OutsideClickDialog$OnOutsideClickListener.class */
        public interface OnOutsideClickListener {
            boolean a();
        }

        public OutsideClickDialog(Context context, int i) {
            super(context, i);
        }

        private boolean a(Context context, MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int scaledWindowTouchSlop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
            View decorView = getWindow().getDecorView();
            int i = -scaledWindowTouchSlop;
            return x < i || y < i || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop;
        }

        public void a(OnOutsideClickListener onOutsideClickListener) {
            this.b = onOutsideClickListener;
        }

        @Override // android.app.Dialog
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.f30192a && isShowing()) {
                if (((motionEvent.getAction() != 1 || !a(getContext(), motionEvent)) && motionEvent.getAction() != 4) || this.b.a()) {
                }
                return true;
            }
            return true;
        }

        @Override // android.app.Dialog
        public void setCanceledOnTouchOutside(boolean z) {
            super.setCanceledOnTouchOutside(z);
            this.f30192a = z;
        }
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public void a(View view) {
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int d() {
        return R.layout.dialog_fragment_filter;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int f() {
        return BluedConfig.a().S() > 0 ? AppInfo.m - StatusBarHelper.a(AppInfo.d()) : (int) ((AppInfo.m / 6.0f) * 5.0f);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventTrackGuy.a(GuyProtos.Event.SCREEN_PAGE_SHOW);
        b = true;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        OutsideClickDialog outsideClickDialog = new OutsideClickDialog(getContext(), 2131951921);
        outsideClickDialog.setCanceledOnTouchOutside(true);
        outsideClickDialog.a(new OutsideClickDialog.OnOutsideClickListener() { // from class: com.soft.blued.ui.find.fragment.FilterDialogFragment.1
            @Override // com.soft.blued.ui.find.fragment.FilterDialogFragment.OutsideClickDialog.OnOutsideClickListener
            public boolean a() {
                if (FilterDialogFragment.this.d != null) {
                    FilterDialogFragment.this.d.e();
                }
                if (FilterDialogFragment.this.e != null) {
                    FilterDialogFragment.this.e.c();
                    return true;
                }
                return true;
            }
        });
        if (Build.VERSION.SDK_INT >= 19) {
            outsideClickDialog.getWindow().addFlags(67108864);
        }
        return outsideClickDialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getActivity().getWindow().setSoftInputMode(35);
        b = false;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (BluedConfig.a().S() <= 0) {
            FilterFragment filterFragment = new FilterFragment();
            this.d = filterFragment;
            filterFragment.f30193a = this;
            getChildFragmentManager().beginTransaction().replace(R.id.fm_content, this.d).commitAllowingStateLoss();
            return;
        }
        FilterNewFragment filterNewFragment = new FilterNewFragment();
        this.e = filterNewFragment;
        filterNewFragment.setArguments(new Bundle());
        this.e.a(this);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        FilterNewFragment filterNewFragment2 = this.e;
        beginTransaction.add(R.id.fm_content, filterNewFragment2, filterNewFragment2.getSimpleName()).commitAllowingStateLoss();
    }
}
