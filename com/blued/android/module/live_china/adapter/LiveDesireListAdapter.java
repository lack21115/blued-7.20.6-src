package com.blued.android.module.live_china.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveDesireDialogFragment;
import com.blued.android.module.live_china.model.LiveDesireGiftInfo;
import com.blued.android.module.live_china.model.LiveDesireLiseModel;
import com.blued.android.module.live_china.view.LiveShaderProgress;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveDesireListAdapter.class */
public class LiveDesireListAdapter extends BaseMultiItemQuickAdapter<LiveDesireLiseModel, BaseViewHolder> {
    private LiveDesireDialogFragment.FormType a;
    private View b;
    private LiveDesireListEventCallBack c;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveDesireListAdapter$LiveDesireListEventCallBack.class */
    public interface LiveDesireListEventCallBack {
        void a();

        void a(String str, LiveDesireGiftInfo liveDesireGiftInfo, RankSccessCallBack rankSccessCallBack);

        void b(String str, LiveDesireGiftInfo liveDesireGiftInfo, RankSccessCallBack rankSccessCallBack);

        void delete(long j);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveDesireListAdapter$RankSccessCallBack.class */
    public interface RankSccessCallBack {
        void rankSccess();
    }

    public LiveDesireListAdapter(Context context, LiveDesireDialogFragment.FormType formType) {
        super(new ArrayList());
        this.mContext = context;
        this.a = formType;
        addItemType(0, formType == LiveDesireDialogFragment.FormType.TYPE_RECORDING_CONFIG ? R.layout.item_live_desire_brief : R.layout.item_live_desire_full);
        addItemType(1, R.layout.item_live_desire_increase);
        addItemType(2, R.layout.item_live_desire_tips);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
        view.animate().alpha(1.0f).setDuration(150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final View view, final RelativeLayout relativeLayout) {
        view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.adapter.LiveDesireListAdapter.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.animate().alpha(0.0f).setDuration(200L).setStartDelay(200L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.adapter.LiveDesireListAdapter.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        super.onAnimationEnd(animator2);
                        relativeLayout.removeView(view);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveDesireLiseModel liveDesireLiseModel, View view) {
        LiveDesireListEventCallBack liveDesireListEventCallBack = this.c;
        if (liveDesireListEventCallBack != null) {
            liveDesireListEventCallBack.delete(liveDesireLiseModel.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(BaseViewHolder baseViewHolder, LiveDesireLiseModel liveDesireLiseModel, View view) {
        return k(baseViewHolder, liveDesireLiseModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        LiveDesireListEventCallBack liveDesireListEventCallBack = this.c;
        if (liveDesireListEventCallBack != null) {
            liveDesireListEventCallBack.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BaseViewHolder baseViewHolder, LiveDesireLiseModel liveDesireLiseModel, View view) {
        j(baseViewHolder, liveDesireLiseModel);
    }

    private void d(BaseViewHolder baseViewHolder, LiveDesireLiseModel liveDesireLiseModel) {
        g(baseViewHolder, liveDesireLiseModel);
        if (this.a == LiveDesireDialogFragment.FormType.TYPE_RECORDING_CONFIG) {
            h(baseViewHolder, liveDesireLiseModel);
        } else {
            i(baseViewHolder, liveDesireLiseModel);
        }
    }

    private void e(BaseViewHolder baseViewHolder, LiveDesireLiseModel liveDesireLiseModel) {
        baseViewHolder.getView(R.id.rl_root).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireListAdapter$GbfCy7xX3Pu9Rug_YtfM7Dlz5zk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireListAdapter.this.b(view);
            }
        });
    }

    private void f(BaseViewHolder baseViewHolder, LiveDesireLiseModel liveDesireLiseModel) {
        ((TextView) baseViewHolder.getView(R.id.tv_funders)).setText(liveDesireLiseModel.tips);
    }

    private void g(BaseViewHolder baseViewHolder, LiveDesireLiseModel liveDesireLiseModel) {
        ImageLoader.a((IRequestHost) null, liveDesireLiseModel.gift_info.pic).a((ImageView) baseViewHolder.getView(R.id.live_gift));
        ((TextView) baseViewHolder.getView(R.id.tv_gift_name)).setText(liveDesireLiseModel.gift_info.name);
        ((TextView) baseViewHolder.getView(R.id.tv_price)).setText(new DecimalFormat("#,###").format(Float.parseFloat(String.valueOf(liveDesireLiseModel.gift_info.beans))));
        LiveShaderProgress liveShaderProgress = (LiveShaderProgress) baseViewHolder.getView(R.id.live_progress);
        liveShaderProgress.setProgressMax(liveDesireLiseModel.count);
        liveShaderProgress.setProgress(liveDesireLiseModel.progress);
        ((TextView) baseViewHolder.getView(R.id.tv_progress_current)).setText(String.valueOf(liveDesireLiseModel.progress));
        ((TextView) baseViewHolder.getView(R.id.tv_progress_count)).setText(String.valueOf(liveDesireLiseModel.count));
        baseViewHolder.getView(R.id.live_finish_mark).setVisibility(liveDesireLiseModel.progress >= liveDesireLiseModel.count ? 0 : 8);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_return_mode);
        if (liveDesireLiseModel.return_way == null || TextUtils.isEmpty(liveDesireLiseModel.return_way)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(((Object) this.mContext.getText(R.string.live_desire_return_mode)) + liveDesireLiseModel.return_way);
    }

    private void h(BaseViewHolder baseViewHolder, final LiveDesireLiseModel liveDesireLiseModel) {
        View view = baseViewHolder.getView(R.id.iv_close);
        view.setVisibility(0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireListAdapter$mzgQMffgxIJdiJcOTzwfjjeG-PA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveDesireListAdapter.this.a(liveDesireLiseModel, view2);
            }
        });
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.live_already_create);
        View view2 = baseViewHolder.getView(R.id.rl_root);
        if (liveDesireLiseModel.status == 3) {
            view2.setAlpha(0.6f);
            imageView.setImageResource(R.drawable.icon_desire_already_down_shelves);
            imageView.setVisibility(0);
        } else {
            view2.setAlpha(1.0f);
            if (liveDesireLiseModel.isCreate) {
                imageView.setImageResource(R.drawable.icon_desire_already_create);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        baseViewHolder.getView(R.id.tv_offer_help).setVisibility(8);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.blued.android.framework.view.shape.ShapeTextView, android.view.View] */
    private void i(final BaseViewHolder baseViewHolder, final LiveDesireLiseModel liveDesireLiseModel) {
        baseViewHolder.getView(R.id.iv_close).setVisibility(8);
        baseViewHolder.getView(R.id.live_already_create).setVisibility(8);
        ?? r0 = (ShapeTextView) baseViewHolder.getView(R.id.tv_offer_help);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_down_shelves);
        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.getView(R.id.rl_root);
        if (liveDesireLiseModel.status != 3 || liveDesireLiseModel.progress >= liveDesireLiseModel.count) {
            relativeLayout.setAlpha(1.0f);
            textView.setVisibility(8);
            if (this.a == LiveDesireDialogFragment.FormType.TYPE_RECORDING_LOOK_UP) {
                r0.setVisibility(8);
            } else if (liveDesireLiseModel.progress >= liveDesireLiseModel.count) {
                r0.setVisibility(8);
            } else {
                r0.setVisibility(0);
                r0.getPaint().setFakeBoldText(true);
                r0.setClickable(true);
                r0.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireListAdapter$XbYQ5KSdEQzdLl0Hpvu_ClKZ9fo
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LiveDesireListAdapter.this.b(baseViewHolder, liveDesireLiseModel, view);
                    }
                });
                r0.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireListAdapter$fSgrDpfhBrI8fEOy2HGqc7acqdc
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean a;
                        a = LiveDesireListAdapter.this.a(baseViewHolder, liveDesireLiseModel, view);
                        return a;
                    }
                });
                if (this.b == null) {
                    this.b = r0;
                }
            }
        } else {
            relativeLayout.setAlpha(0.6f);
            r0.setVisibility(8);
            textView.setVisibility(0);
            textView.getPaint().setFakeBoldText(true);
            if (this.a == LiveDesireDialogFragment.FormType.TYPE_RECORDING_LOOK_UP) {
                textView.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.transparent));
            } else {
                textView.setBackgroundResource(R.drawable.shape_live_down_shelves_bg);
            }
        }
        View view = baseViewHolder.getView(R.id.live_funders_border_1);
        View view2 = baseViewHolder.getView(R.id.live_funders_border_2);
        View view3 = baseViewHolder.getView(R.id.live_funders_border_3);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.live_funders_1);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.live_funders_2);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.live_funders_3);
        if (liveDesireLiseModel.rank == null || liveDesireLiseModel.rank.size() == 0) {
            imageView.setImageResource(R.drawable.icon_desire_funders_default);
            imageView2.setImageResource(R.drawable.icon_desire_funders_default);
            imageView3.setImageResource(R.drawable.icon_desire_funders_default);
            view.setVisibility(8);
            view2.setVisibility(8);
            view3.setVisibility(8);
            return;
        }
        if (liveDesireLiseModel.rank.size() < 1 || liveDesireLiseModel.rank.get(0) == null || liveDesireLiseModel.rank.get(0).avatar == null) {
            imageView.setVisibility(8);
            view.setVisibility(8);
        } else {
            ImageLoader.a((IRequestHost) null, liveDesireLiseModel.rank.get(0).avatar).b(R.drawable.icon_desire_funders_default).c().a(imageView);
            imageView.setVisibility(0);
            view.setVisibility(0);
        }
        if (liveDesireLiseModel.rank == null || liveDesireLiseModel.rank.size() < 2 || liveDesireLiseModel.rank.get(1) == null || liveDesireLiseModel.rank.get(1).avatar == null) {
            imageView2.setVisibility(8);
            view2.setVisibility(8);
        } else {
            ImageLoader.a((IRequestHost) null, liveDesireLiseModel.rank.get(1).avatar).b(R.drawable.icon_desire_funders_default).c().a(imageView2);
            imageView2.setVisibility(0);
            view2.setVisibility(0);
        }
        if (liveDesireLiseModel.rank == null || liveDesireLiseModel.rank.size() < 3 || liveDesireLiseModel.rank.get(2) == null) {
            imageView3.setVisibility(8);
            view3.setVisibility(8);
            return;
        }
        ImageLoader.a((IRequestHost) null, liveDesireLiseModel.rank.get(2).avatar).b(R.drawable.icon_desire_funders_default).c().a(imageView3);
        imageView3.setVisibility(0);
        view3.setVisibility(0);
    }

    private void j(final BaseViewHolder baseViewHolder, final LiveDesireLiseModel liveDesireLiseModel) {
        this.c.a(String.valueOf(liveDesireLiseModel.id), liveDesireLiseModel.gift_info, new RankSccessCallBack() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireListAdapter$V-OawT2KixzMwrwM5sIsl_MyZ40
            @Override // com.blued.android.module.live_china.adapter.LiveDesireListAdapter.RankSccessCallBack
            public final void rankSccess() {
                LiveDesireListAdapter.this.n(baseViewHolder, liveDesireLiseModel);
            }
        });
    }

    private boolean k(final BaseViewHolder baseViewHolder, final LiveDesireLiseModel liveDesireLiseModel) {
        this.c.b(String.valueOf(liveDesireLiseModel.id), liveDesireLiseModel.gift_info, new RankSccessCallBack() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireListAdapter$ZVdQ-it4GoMQcq2WOr-d0dXUWOg
            @Override // com.blued.android.module.live_china.adapter.LiveDesireListAdapter.RankSccessCallBack
            public final void rankSccess() {
                LiveDesireListAdapter.this.m(baseViewHolder, liveDesireLiseModel);
            }
        });
        return true;
    }

    private void l(final BaseViewHolder baseViewHolder, final LiveDesireLiseModel liveDesireLiseModel) {
        final LiveShaderProgress liveShaderProgress = (LiveShaderProgress) baseViewHolder.getView(R.id.live_progress);
        liveShaderProgress.setProgress(liveDesireLiseModel.progress);
        final TextView textView = (TextView) baseViewHolder.getView(R.id.tv_progress_current);
        final int height = textView.getHeight() / 3;
        textView.animate().alpha(0.0f).translationY(-height).setDuration(180L).setStartDelay(200L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.adapter.LiveDesireListAdapter.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                textView.setText(String.valueOf(liveDesireLiseModel.progress));
                textView.setTranslationY(height);
                textView.animate().alpha(1.0f).translationY(0.0f).setDuration(180L).setStartDelay(0L).setListener(null);
                if (liveShaderProgress.getProgress() < liveShaderProgress.getProgressMax()) {
                    baseViewHolder.getView(R.id.tv_offer_help).setClickable(true);
                }
            }
        });
        final RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.getView(R.id.rl_plus_one_root);
        int height2 = relativeLayout.getHeight();
        int i = height2 / 2;
        final View view = new View(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.topMargin = (height2 - i) / 2;
        layoutParams.leftMargin = layoutParams.topMargin;
        view.setLayoutParams(layoutParams);
        relativeLayout.addView(view);
        view.setAlpha(0.0f);
        float f = i / 2;
        view.setPivotX(f);
        view.setPivotY(f);
        view.setScaleX(2.0f);
        view.setScaleY(2.0f);
        view.setBackground(this.mContext.getResources().getDrawable(R.drawable.icon_plue_one));
        view.post(new Runnable() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireListAdapter$wBckLw0KeWrmUCyM7szALJ8E0y4
            @Override // java.lang.Runnable
            public final void run() {
                LiveDesireListAdapter.this.a(view, relativeLayout);
            }
        });
    }

    public View a() {
        return this.b;
    }

    public void a(LiveDesireListEventCallBack liveDesireListEventCallBack) {
        this.c = liveDesireListEventCallBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, LiveDesireLiseModel liveDesireLiseModel) {
        int i = liveDesireLiseModel.type;
        if (i == 0) {
            d(baseViewHolder, liveDesireLiseModel);
        } else if (i == 1) {
            e(baseViewHolder, liveDesireLiseModel);
        } else if (i != 2) {
        } else {
            f(baseViewHolder, liveDesireLiseModel);
        }
    }

    public void a(List<LiveDesireLiseModel> list) {
        setNewData(list);
        setEnableLoadMore(false);
    }

    /* renamed from: b */
    public void n(BaseViewHolder baseViewHolder, LiveDesireLiseModel liveDesireLiseModel) {
        final View view = baseViewHolder.getView(R.id.tv_offer_help);
        final View view2 = baseViewHolder.getView(R.id.live_finish_mark);
        view.setClickable(false);
        liveDesireLiseModel.progress++;
        l(baseViewHolder, liveDesireLiseModel);
        if (liveDesireLiseModel.progress >= liveDesireLiseModel.count) {
            view.animate().alpha(0.0f).setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.adapter.LiveDesireListAdapter.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    view.setVisibility(8);
                }
            });
            view2.setAlpha(0.0f);
            view2.setVisibility(0);
            view2.post(new Runnable() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveDesireListAdapter$kl1VEvRTw0X2oIsY6fY7lCw95Ec
                @Override // java.lang.Runnable
                public final void run() {
                    LiveDesireListAdapter.a(View.this);
                }
            });
        }
    }

    /* renamed from: c */
    public void m(BaseViewHolder baseViewHolder, LiveDesireLiseModel liveDesireLiseModel) {
        ((LiveShaderProgress) baseViewHolder.getView(R.id.live_progress)).setProgress(liveDesireLiseModel.count);
        ((TextView) baseViewHolder.getView(R.id.tv_progress_current)).setText(String.valueOf(liveDesireLiseModel.count));
        View view = baseViewHolder.getView(R.id.live_finish_mark);
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(300L);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_offer_help);
        shapeTextView.setClickable(false);
        shapeTextView.animate().alpha(0.0f).setDuration(300L);
    }
}
