package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.presenter.HelloOpenDialogPresenter;
import com.soft.blued.ui.home.HomeActivity;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/HelloOpenDialogFragment.class */
public class HelloOpenDialogFragment extends MvpFragment<HelloOpenDialogPresenter> {
    @BindView
    ShapeTextView callOpen;
    @BindView
    CardView cardView;
    @BindView
    ImageView ivBuySuccess;
    @BindView
    ImageView ivCallLeft;
    @BindView
    ImageView ivCallRight;
    @BindView
    ImageView ivClose;
    @BindView
    ShapeLinearLayout sllCallLeft;
    @BindView
    ShapeLinearLayout sllCallRight;
    @BindView
    TextView tvCallLeft;
    @BindView
    TextView tvCallRight;
    @BindView
    TextView tvCallTitleLeft;
    @BindView
    TextView tvCallTitleRight;
    @BindView
    TextView tvContent;
    @BindView
    TextView tvCount;
    @BindView
    TextView tvTitle;

    public static void a(Context context, int i) {
        a(context, false, 0, i);
    }

    public static void a(Context context, int i, int i2) {
        a(context, false, i, i2);
    }

    public static void a(Context context, boolean z, int i) {
        a(context, z, 0, i);
    }

    public static void a(Context context, boolean z, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("hello_open_is_buy", z);
        bundle.putInt("hello_open_count", i);
        bundle.putInt("hello_open_from", i2);
        TransparentActivity.a(bundle);
        TransparentActivity.b(context, HelloOpenDialogFragment.class, bundle);
    }

    private void b() {
        ShapeHelper.b(this.sllCallLeft, 2131101780);
        ShapeHelper.d(this.sllCallLeft, 2131101766);
        this.ivCallLeft.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.call_open_selected));
        this.tvCallTitleLeft.setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
        this.tvCallLeft.setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
        ShapeHelper.b(this.sllCallRight, 2131102360);
        ShapeHelper.d(this.sllCallRight, 2131101780);
        this.ivCallRight.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.call_open_q_select));
        this.tvCallTitleRight.setTextColor(BluedSkinUtils.a(getContext(), 2131102263));
        this.tvCallRight.setTextColor(BluedSkinUtils.a(getContext(), 2131102263));
    }

    private void c() {
        ShapeHelper.b(this.sllCallLeft, 2131102360);
        ShapeHelper.d(this.sllCallLeft, 2131101780);
        this.ivCallLeft.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.call_open_select));
        this.tvCallTitleLeft.setTextColor(BluedSkinUtils.a(getContext(), 2131102263));
        this.tvCallLeft.setTextColor(BluedSkinUtils.a(getContext(), 2131102263));
        ShapeHelper.b(this.sllCallRight, 2131101780);
        ShapeHelper.d(this.sllCallRight, 2131101766);
        this.ivCallRight.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.call_open_q_selected));
        this.tvCallTitleRight.setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
        this.tvCallRight.setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (((HelloOpenDialogPresenter) j()).m()) {
            this.tvTitle.setText(R.string.hello_buy_success);
            this.tvTitle.setVisibility(0);
            this.tvCount.setVisibility(8);
            this.tvContent.setText(R.string.hello_buy_success_tip);
            this.ivBuySuccess.setVisibility(0);
            return;
        }
        this.tvCount.setText(String.valueOf(((HelloOpenDialogPresenter) j()).n()));
        this.tvCount.setVisibility(0);
        this.tvTitle.setVisibility(8);
        this.tvContent.setText(R.string.hello_count);
        this.ivBuySuccess.setVisibility(8);
    }

    public int g() {
        return R.layout.dialog_hello_open;
    }

    @OnClick
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.call_open /* 2131362697 */:
                if (((HelloOpenDialogPresenter) j()).m()) {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_BUY_SUCCESS_POP_OPEN_BTN_CLICK, ((HelloOpenDialogPresenter) j()).p() ? GuyProtos.VocativeType.VOCATIVE_QUIET : GuyProtos.VocativeType.VOCATIVE_COMMON);
                } else {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_OPEN_POP_OPEN_BTN_CLICK, ((HelloOpenDialogPresenter) j()).p() ? GuyProtos.VocativeType.VOCATIVE_QUIET : GuyProtos.VocativeType.VOCATIVE_COMMON);
                }
                final boolean p = ((HelloOpenDialogPresenter) j()).p();
                CallHelloManager.a().a(getContext(), new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.find.fragment.HelloOpenDialogFragment.1
                    @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                    public void done(boolean z) {
                        if (z && HomeActivity.f17295c != null) {
                            CallHelloManager.a().a((Context) HomeActivity.f17295c, (IRequestHost) null, p, ((HelloOpenDialogPresenter) HelloOpenDialogFragment.this.j()).o());
                        }
                        HelloOpenDialogFragment.this.getActivity().finish();
                    }
                });
                return;
            case 2131365207:
                getActivity().finish();
                return;
            case R.id.sll_call_left /* 2131369844 */:
                ((HelloOpenDialogPresenter) j()).a(false);
                b();
                return;
            case R.id.sll_call_right /* 2131369845 */:
                ((HelloOpenDialogPresenter) j()).a(true);
                c();
                return;
            default:
                return;
        }
    }
}
