package com.blued.community.ui.circle.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.community.R;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/ApplyJoinCircleDialogFragment.class */
public class ApplyJoinCircleDialogFragment extends CommonDialogFragment implements View.OnClickListener {
    private View b;
    private TextView c;
    private ImageView d;
    private TextView e;
    private ShapeFrameLayout f;
    private EditText g;
    private TextView h;
    private ShapeTextView i;
    private TextView j;
    private String k;
    private String l;
    private String m;
    private Dialog n;
    private ApplyJoinCircleListener o;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/ApplyJoinCircleDialogFragment$ApplyJoinCircleListener.class */
    public interface ApplyJoinCircleListener {
        void a();
    }

    public static ApplyJoinCircleDialogFragment a(FragmentManager fragmentManager, CircleJoinState circleJoinState, ApplyJoinCircleListener applyJoinCircleListener) {
        return a(fragmentManager, circleJoinState.circle_id, circleJoinState.title, circleJoinState.cover, applyJoinCircleListener);
    }

    public static ApplyJoinCircleDialogFragment a(FragmentManager fragmentManager, String str, String str2, String str3, ApplyJoinCircleListener applyJoinCircleListener) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        ApplyJoinCircleDialogFragment applyJoinCircleDialogFragment = new ApplyJoinCircleDialogFragment();
        applyJoinCircleDialogFragment.a(applyJoinCircleListener);
        Bundle bundle = new Bundle();
        bundle.putString("circle_id", str);
        bundle.putString("circle_name", str2);
        bundle.putString("circle_header", str3);
        applyJoinCircleDialogFragment.setArguments(bundle);
        applyJoinCircleDialogFragment.show(fragmentManager, "ApplyJoinCircleDialogFragment");
        return applyJoinCircleDialogFragment;
    }

    private void h() {
        CircleHttpUtils.a(this.k, this.g.getText().toString(), new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>(a()) { // from class: com.blued.community.ui.circle.fragment.ApplyJoinCircleDialogFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MyCircleModel> bluedEntityA) {
                if (ApplyJoinCircleDialogFragment.this.o != null) {
                    ApplyJoinCircleDialogFragment.this.o.a();
                }
                ApplyJoinCircleDialogFragment.this.dismiss();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                DialogUtils.b(ApplyJoinCircleDialogFragment.this.n);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ApplyJoinCircleDialogFragment.this.n);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (j()) {
            this.i.setAlpha(1.0f);
            this.i.setEnabled(true);
            return;
        }
        this.i.setAlpha(0.3f);
        this.i.setEnabled(false);
    }

    private boolean j() {
        EditText editText = this.g;
        return (editText == null || TextUtils.isEmpty(editText.getText().toString().trim())) ? false : true;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public void a(View view) {
        if (getArguments() != null) {
            this.k = getArguments().getString("circle_id");
            this.l = getArguments().getString("circle_name");
            this.m = getArguments().getString("circle_header");
        }
        this.n = DialogUtils.a(getContext());
        this.b = view.findViewById(R.id.root_view);
        this.c = (TextView) view.findViewById(R.id.tv_title);
        this.d = (ImageView) view.findViewById(R.id.iv_header);
        this.e = (TextView) view.findViewById(R.id.tv_name);
        this.f = (ShapeFrameLayout) view.findViewById(R.id.sfl_apply);
        this.g = (EditText) view.findViewById(R.id.edt_apply);
        this.h = (TextView) view.findViewById(R.id.tv_tip);
        this.i = (ShapeTextView) view.findViewById(R.id.stv_apply);
        this.j = (TextView) view.findViewById(R.id.tv_cancel);
        this.b.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        i();
        ImageLoader.a(a(), AvatarUtils.a(0, this.m)).b(R.drawable.circle_default_icon).d(R.drawable.circle_default_icon).a(6.0f).a(this.d);
        this.e.setText(this.l);
        this.g.setImeOptions(6);
        this.g.setInputType(262144);
        this.g.setSingleLine(false);
        this.g.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.blued.community.ui.circle.fragment.ApplyJoinCircleDialogFragment.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 1) {
                    if (i != 6) {
                        return false;
                    }
                    ApplyJoinCircleDialogFragment.this.i.callOnClick();
                    return true;
                }
                return true;
            }
        });
        this.g.addTextChangedListener(new TextWatcher() { // from class: com.blued.community.ui.circle.fragment.ApplyJoinCircleDialogFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ApplyJoinCircleDialogFragment.this.i();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public void a(ApplyJoinCircleListener applyJoinCircleListener) {
        this.o = applyJoinCircleListener;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int d() {
        return R.layout.dialog_apply_join_circle;
    }

    public void dismiss() {
        KeyboardUtils.a((Activity) getActivity());
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.stv_apply) {
            EventTrackFeed.h(FeedProtos.Event.CIRCLE_JOIN_APPLY_POP_YES_BTN_CLICK, this.k);
            if (j()) {
                h();
            }
        } else if (id == R.id.tv_cancel) {
            dismiss();
            KeyboardUtils.a((Activity) getActivity());
        } else if (id == R.id.root_view) {
            KeyboardUtils.a((Activity) getActivity());
        }
    }
}
