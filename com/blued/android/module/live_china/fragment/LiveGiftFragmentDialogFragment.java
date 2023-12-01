package com.blued.android.module.live_china.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveSyntheticFragmentSuccessModel;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftFragmentDialogFragment.class */
public class LiveGiftFragmentDialogFragment extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f12900a;
    public TextView b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12901c;
    public TextView d;
    public TextView e;
    private Context f;
    private ConfirmClickCallback g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftFragmentDialogFragment$ConfirmClickCallback.class */
    public interface ConfirmClickCallback {
        void onConfirmClick(View view, LiveGiftFragmentDialogFragment liveGiftFragmentDialogFragment);
    }

    public LiveGiftFragmentDialogFragment(Context context, LiveSyntheticFragmentSuccessModel liveSyntheticFragmentSuccessModel) {
        super(context, R.style.transparentFrameWindowStyleLive);
        this.f = context;
        a();
        b();
        a(liveSyntheticFragmentSuccessModel);
    }

    private void a(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.1f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.1f, 1.0f));
        animatorSet.setDuration(360L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ConfirmClickCallback confirmClickCallback, View view) {
        dismiss();
        if (confirmClickCallback != null) {
            confirmClickCallback.onConfirmClick(view, this);
        }
    }

    private void a(LiveSyntheticFragmentSuccessModel liveSyntheticFragmentSuccessModel) {
        this.f12901c.setText(liveSyntheticFragmentSuccessModel.getGoods_name());
        TextView textView = this.d;
        textView.setText(" x" + liveSyntheticFragmentSuccessModel.getCount());
        ImageLoader.a((IRequestHost) null, liveSyntheticFragmentSuccessModel.getImage()).b(R.drawable.defaultpicture).a(this.f12900a);
    }

    private void b() {
        this.b = (TextView) findViewById(R.id.tv_title);
        this.f12901c = (TextView) findViewById(R.id.tv_gift_fragment_name);
        this.d = (TextView) findViewById(R.id.tv_gift_fragment_count);
        this.f12900a = (ImageView) findViewById(R.id.iv_gift_fragment_icon);
        this.e = (TextView) findViewById(R.id.tv_confirm);
        this.b.getPaint().setFakeBoldText(true);
        this.e.getPaint().setFakeBoldText(true);
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGiftFragmentDialogFragment$PYOEo9osVTIZgoO8QDwSZL8WrcU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftFragmentDialogFragment.this.c(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGiftFragmentDialogFragment$LlX30nljwYXgLpUgzDFiu3ymO6Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftFragmentDialogFragment.this.b(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        dismiss();
    }

    public void a() {
        Window window = getWindow();
        window.requestFeature(1);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.verticalMargin = 0.0f;
        attributes.horizontalMargin = 0.0f;
        window.setAttributes(attributes);
        window.getDecorView().setMinimumWidth(getContext().getResources().getDisplayMetrics().widthPixels);
        window.getDecorView().setMinimumHeight(getContext().getResources().getDisplayMetrics().heightPixels);
        window.getDecorView().setBackgroundColor(0);
        window.setDimAmount(0.0f);
        View inflate = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_live_gift_fragment, (ViewGroup) null);
        addContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        setContentView(inflate);
        a(inflate);
        getWindow().setLayout(-1, -1);
    }

    public void a(final ConfirmClickCallback confirmClickCallback) {
        this.g = confirmClickCallback;
        TextView textView = this.e;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGiftFragmentDialogFragment$Ux8FgD7UIHTJErHmW43yRKoYmAE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftFragmentDialogFragment.this.a(confirmClickCallback, view);
                }
            });
        }
    }
}
