package com.blued.community.ui.circle.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.R;
import com.blued.community.ui.circle.presenter.CircleTextVoteEditPresenter;
import com.blued.community.widget.vote.text.adapter.CircleTextVoteEditAdapter;
import com.blued.community.widget.vote.text.model.CircleTextVote;
import com.bytedance.applog.tracker.Tracker;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleTextVoteEditFragment.class */
public class CircleTextVoteEditFragment extends MvpKeyBoardFragment<CircleTextVoteEditPresenter> {
    private KeyboardListenLinearLayout k;
    private CommonTopTitleNoTrans l;
    private EditText m;
    private RecyclerView n;
    private ShapeTextView o;
    private CircleTextVoteEditAdapter p;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        if (TextUtils.isEmpty(this.m.getText().toString())) {
            return false;
        }
        for (CircleTextVote circleTextVote : this.p.getData()) {
            if (TextUtils.isEmpty(circleTextVote.option)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        return this.p.getData().size() < 10;
    }

    private void C() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment.7
            @Override // java.lang.Runnable
            public void run() {
                if (!CircleTextVoteEditFragment.this.m.isFocusable()) {
                    CircleTextVoteEditFragment.this.m.requestFocus();
                }
                CircleTextVoteEditFragment.this.m.setSelection(CircleTextVoteEditFragment.this.m.getText().toString().length());
                KeyboardUtils.c(CircleTextVoteEditFragment.this.getActivity());
            }
        }, 300L);
    }

    public static void a(Fragment fragment, int i, String str, List<CircleTextVote> list) {
        Bundle bundle = new Bundle();
        bundle.putString("circle_vote_title", str);
        bundle.putSerializable("circle_vote_content", (Serializable) list);
        TerminalActivity.a(fragment, CircleTextVoteEditFragment.class, bundle, i);
    }

    private void v() {
        this.k = (KeyboardListenLinearLayout) this.i.findViewById(R.id.keyboardRelativeLayout);
        this.l = (CommonTopTitleNoTrans) this.i.findViewById(R.id.title);
        this.m = (EditText) this.i.findViewById(R.id.edt_content);
        this.n = this.i.findViewById(R.id.recycler_view);
        ShapeTextView shapeTextView = (ShapeTextView) this.i.findViewById(R.id.stv_add_option);
        this.o = shapeTextView;
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (!CircleTextVoteEditFragment.this.B()) {
                    AppMethods.a((CharSequence) "最多选择10个选项");
                    return;
                }
                CircleTextVoteEditFragment.this.p.addData(new CircleTextVote());
                CircleTextVoteEditFragment.this.z();
            }
        });
    }

    private void w() {
        this.n.setLayoutManager(new LinearLayoutManager(getContext()) { // from class: com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment.2
            public boolean canScrollVertically() {
                return false;
            }
        });
        CircleTextVoteEditAdapter circleTextVoteEditAdapter = new CircleTextVoteEditAdapter();
        this.p = circleTextVoteEditAdapter;
        this.n.setAdapter(circleTextVoteEditAdapter);
        this.p.a(new CircleTextVoteEditAdapter.OnEditChangeListener() { // from class: com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment.3
            public void a() {
                CircleTextVoteEditFragment.this.z();
            }
        });
    }

    private void x() {
        this.m.addTextChangedListener(new TextWatcher() { // from class: com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                CircleTextVoteEditFragment.this.z();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    private void y() {
        ShapeTextView rightTextView = this.l.getRightTextView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rightTextView.getLayoutParams();
        layoutParams.rightMargin = DensityUtils.a(getContext(), 10.0f);
        layoutParams.height = DensityUtils.a(getContext(), 26.0f);
        rightTextView.setLayoutParams(layoutParams);
        ShapeHelper.b(rightTextView, R.color.syc_a);
        ShapeHelper.a(rightTextView, DensityUtils.a(getContext(), 10.0f));
        rightTextView.setTextColor(getContext().getResources().getColor(R.color.syc_b));
        z();
        this.l.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleTextVoteEditFragment.this.onBackPressed();
            }
        });
        rightTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (CircleTextVoteEditFragment.this.A()) {
                    Intent intent = new Intent();
                    intent.putExtra("circle_vote_title", CircleTextVoteEditFragment.this.m.getText().toString());
                    intent.putExtra("circle_vote_content", (Serializable) CircleTextVoteEditFragment.this.p.getData());
                    CircleTextVoteEditFragment.this.getActivity().setResult(-1, intent);
                    CircleTextVoteEditFragment.this.getActivity().finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        ShapeTextView rightTextView = this.l.getRightTextView();
        if (A()) {
            rightTextView.setAlpha(1.0f);
        } else {
            rightTextView.setAlpha(0.3f);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        v();
        a(this.k);
        y();
        x();
        w();
        C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<CircleTextVote> list) {
        this.p.setNewData(list);
        z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        this.m.setText(str);
        z();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void f() {
        super.f();
        getActivity().getWindow().setSoftInputMode(18);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_circle_text_vote_edit;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        CommonAlertDialog.a(getContext(), getContext().getString(R.string.community_notice), getContext().getString(R.string.circle_text_vote_back_tip), getContext().getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                CircleTextVoteEditFragment.this.getActivity().finish();
            }
        }, getContext().getString(R.string.biao_v4_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        return true;
    }
}
