package com.soft.blued.ui.share_custom.Adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module_share_china.R;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share_custom/Adapter/ShareOptionRecyclerAdapter.class */
public class ShareOptionRecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f33696a;
    private List<ShareOption> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f33697c;
    private ShareOptionsItemClickListener d;
    private boolean e;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share_custom/Adapter/ShareOptionRecyclerAdapter$ShareOptionsItemClickListener.class */
    public interface ShareOptionsItemClickListener {
        void onItemClick(int i);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share_custom/Adapter/ShareOptionRecyclerAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f33701a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f33702c;
        public FrameLayout d;

        public ViewHolder(View view) {
            super(view);
            this.f33701a = (ImageView) view.findViewById(R.id.img_icon);
            this.b = (TextView) view.findViewById(R.id.tv_text);
            this.f33702c = (LinearLayout) view.findViewById(R.id.ll_main);
            this.d = (FrameLayout) view.findViewById(R.id.ll_anim);
        }
    }

    public ShareOptionRecyclerAdapter(Context context, List<ShareOption> list, boolean z) {
        this.e = false;
        this.f33697c = context;
        this.e = z;
        this.b = list;
        this.f33696a = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f33696a.inflate(R.layout.item_share_option, viewGroup, false);
        ((LinearLayout) inflate.findViewById(R.id.ll_main)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                int intValue = ((Integer) view.getTag()).intValue();
                if (ShareOptionRecyclerAdapter.this.d != null) {
                    ShareOptionRecyclerAdapter.this.d.onItemClick(intValue);
                }
            }
        });
        return new ViewHolder(inflate);
    }

    public void a(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.b.size()) {
                break;
            } else if (this.b.get(i3).textResourceID == i) {
                this.b.remove(i3);
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        notifyDataSetChanged();
    }

    public void a(final View view, int i) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator ofInt = ValueAnimator.ofInt(0, DensityUtils.a(ShareOptionRecyclerAdapter.this.f33697c, 15.0f));
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int i2 = -((Integer) valueAnimator.getAnimatedValue()).intValue();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                        layoutParams.topMargin = i2;
                        view.setLayoutParams(layoutParams);
                    }
                });
                ofInt.setInterpolator(new CycleInterpolator(0.5f));
                ofInt.setDuration(350L);
                ofInt.start();
            }
        }, (i * 30) + 200);
    }

    public void a(ShareOptionsItemClickListener shareOptionsItemClickListener) {
        this.d = shareOptionsItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (viewHolder != null) {
            ShareOption shareOption = this.b.get(i);
            viewHolder.f33701a.setImageResource(shareOption.iconResourceId);
            if (viewHolder.b != null) {
                viewHolder.b.setText(shareOption.textResourceID);
                viewHolder.f33702c.setTag(Integer.valueOf(shareOption.textResourceID));
                if (this.e) {
                    viewHolder.b.setTextColor(this.f33697c.getResources().getColor(R.color.syc_j));
                }
            }
            a((View) viewHolder.d, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }
}
