package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYApplyFinishFragment.class */
public class YYApplyFinishFragment extends MvpFragment<MvpPresenter> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    ImageView f17094a;
    TextView b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f17095c;
    TextView d;
    TextView e;
    ShapeTextView f;
    private int g;
    private int k;

    public static void a(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("apply_state", i);
        TerminalActivity.d(context, YYApplyFinishFragment.class, bundle);
    }

    public static void a(Context context, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("apply_state", i);
        bundle.putInt("apply_from", i2);
        TerminalActivity.d(context, YYApplyFinishFragment.class, bundle);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.g = getArguments().getInt("apply_state");
        this.k = getArguments().getInt("apply_from", 0);
        this.f = (ShapeTextView) this.i.findViewById(R.id.tv_create);
        this.b = (TextView) this.i.findViewById(R.id.tv_title_text);
        this.f17094a = (ImageView) this.i.findViewById(R.id.iv_back_img);
        this.f17095c = (ImageView) this.i.findViewById(R.id.iv_status_img);
        this.d = (TextView) this.i.findViewById(R.id.tv_apply_status);
        this.e = (TextView) this.i.findViewById(R.id.tv_apply_content);
        int i = this.k;
        if (i == 1) {
            this.f.setVisibility(0);
            this.f.setText(getString(R.string.group_browse_others));
            this.b.setText(getResources().getString(R.string.yy_apply_create_title));
        } else if (i == 0) {
            this.b.setText(getResources().getString(R.string.yy_apply_finish_title));
        } else {
            this.f.setVisibility(8);
        }
        this.f.setOnClickListener(this);
        this.f17094a.setOnClickListener(this);
        int i2 = this.g;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f17095c.setImageResource(R.drawable.icon_yy_apply_ok);
                this.d.setText(getResources().getString(R.string.yy_apply_state_ok));
                this.e.setText(getResources().getString(R.string.yy_apply_ok_des));
                return;
            } else if (i2 != 2) {
                return;
            } else {
                this.f17095c.setImageResource(R.drawable.icon_yy_apply_error);
                this.d.setText(getResources().getString(R.string.yy_apply_state_error));
                this.e.setText(getResources().getString(R.string.yy_apply_error_des));
                return;
            }
        }
        this.d.setText(getResources().getString(R.string.yy_apply_state_ing));
        this.f17095c.setImageResource(R.drawable.icon_yy_apply_ing);
        int i3 = this.k;
        if (i3 == 1) {
            this.e.setText(getResources().getString(R.string.group_verify_process_hint));
        } else if (i3 == 2) {
            this.e.setText(getResources().getString(R.string.event_verify_process_hint));
        } else {
            this.e.setText(getResources().getString(R.string.yy_apply_ing_des));
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_apply_finish_layout;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_create) {
            if (this.k == 1) {
                YYRoomInfoManager.e().c().c(getContext());
            }
            t();
        } else if (view.getId() == R.id.iv_back_img) {
            t();
        }
    }
}
