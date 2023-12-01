package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.track.EventTrackSuperExpose;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.superexpose.SuperExposeProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/FeedPromotionTipDialogFragment.class */
public class FeedPromotionTipDialogFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f16200a;
    public CardView b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f16201c;
    private Context d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private String i;
    private boolean j;

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.i = arguments.getString("url");
            this.j = arguments.getBoolean("always");
        }
    }

    private void b() {
        CardView cardView = (CardView) this.f16200a.findViewById(2131362749);
        this.b = cardView;
        if (this.j) {
            cardView.setVisibility(8);
            EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_SUCCESS_POP_SHOW);
            CommonAlertDialog.a(getActivity(), getResources().getString(R.string.promotion_dialog_tip_title), getResources().getString(R.string.promotion_dialog_tip_content), getResources().getString(R.string.feed_pay_for_hot), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.FeedPromotionTipDialogFragment.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK);
                    WebViewShowInfoFragment.show(FeedPromotionTipDialogFragment.this.d, FeedPromotionTipDialogFragment.this.i, 0);
                }
            }, getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.FeedPromotionTipDialogFragment.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    FeedPromotionTipDialogFragment.this.getActivity().finish();
                }
            });
            return;
        }
        cardView.setVisibility(0);
        this.e = (ImageView) this.f16200a.findViewById(2131365207);
        this.h = (TextView) this.f16200a.findViewById(R.id.tv_buy_now);
        this.f = (ImageView) this.f16200a.findViewById(R.id.img_tip);
        if (BluedConfig.a().k() != null) {
            if (!TextUtils.isEmpty(BluedConfig.a().k().btn)) {
                this.h.setText(BluedConfig.a().k().btn);
            }
            if (!TextUtils.isEmpty(BluedConfig.a().k().img)) {
                ImageLoader.a(getFragmentActive(), BluedConfig.a().k().img).f().a(this.f);
            }
        }
        TextView textView = (TextView) this.f16200a.findViewById(R.id.tv_tip);
        this.g = textView;
        textView.setText(BluedConfig.a().k().text);
        this.e.setOnClickListener(this);
        this.h.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131365207) {
            getActivity().finish();
        } else if (id != 2131371037) {
        } else {
            WebViewShowInfoFragment.show(this.d, this.i, 0);
            EventTrackSuperExpose.a(SuperExposeProtos.Event.AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY);
            getActivity().finish();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.d = activity;
        this.f16201c = LayoutInflater.from(activity);
        if (this.f16200a == null) {
            this.f16200a = layoutInflater.inflate(R.layout.dialog_feed_promotion, viewGroup, false);
            a();
            b();
            StatusBarHelper.a(getActivity(), false);
        }
        return this.f16200a;
    }
}
