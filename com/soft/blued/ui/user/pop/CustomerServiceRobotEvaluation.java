package com.soft.blued.ui.user.pop;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/CustomerServiceRobotEvaluation.class */
public final class CustomerServiceRobotEvaluation extends BottomPopupView {
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f34250c;
    private final List<ViewHolder> d;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/CustomerServiceRobotEvaluation$ViewHolder.class */
    public static final class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f34251a;
        private final ImageView b;

        public ViewHolder(TextView ratingText, ImageView ratingIcon) {
            Intrinsics.e(ratingText, "ratingText");
            Intrinsics.e(ratingIcon, "ratingIcon");
            this.f34251a = ratingText;
            this.b = ratingIcon;
        }

        public final TextView a() {
            return this.f34251a;
        }

        public final ImageView b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ViewHolder) {
                ViewHolder viewHolder = (ViewHolder) obj;
                return Intrinsics.a(this.f34251a, viewHolder.f34251a) && Intrinsics.a(this.b, viewHolder.b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f34251a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "ViewHolder(ratingText=" + this.f34251a + ", ratingIcon=" + this.b + ')';
        }
    }

    private final void a(TextView textView, boolean z, boolean z2) {
        if (z2) {
            textView.setTextColor(-26112);
            textView.setCompoundDrawablesWithIntrinsicBounds(z ? 2131233232 : 2131233230, 0, 0, 0);
            textView.setBackgroundResource(R.drawable.shape_customer_service_robot_evaluate_button_selected);
            return;
        }
        textView.setTextColor(-8947849);
        textView.setCompoundDrawablesWithIntrinsicBounds(z ? 2131233231 : 2131233229, 0, 0, 0);
        textView.setBackgroundResource(R.drawable.shape_customer_service_robot_evaluate_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CustomerServiceRobotEvaluation this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CustomerServiceRobotEvaluation this$0, View view, View view2) {
        Tracker.onClick(view2);
        Intrinsics.e(this$0, "this$0");
        Object tag = view.getTag();
        if (tag == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        this$0.setRatingBarSelected(((Integer) tag).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CustomerServiceRobotEvaluation this$0, TextView tvYes, TextView tvNo, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(tvYes, "tvYes");
        this$0.a(tvYes, true, true);
        Intrinsics.c(tvNo, "tvNo");
        this$0.a(tvNo, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CustomerServiceRobotEvaluation this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CustomerServiceRobotEvaluation this$0, TextView tvYes, TextView tvNo, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(tvYes, "tvYes");
        this$0.a(tvYes, true, false);
        Intrinsics.c(tvNo, "tvNo");
        this$0.a(tvNo, false, true);
    }

    private final void setRating(int i) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_evaluate_rating);
        if (i == 8) {
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ll_evaluate_rating_bar);
        linearLayout2.removeAllViews();
        this.d.clear();
        Iterator<String> it = this.f34250c.iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return;
            }
            String next = it.next();
            final View inflate = BottomPopupView.inflate(getContext(), R.layout.layout_customer_service_robot_rating, null);
            TextView ratingText = (TextView) inflate.findViewById(R.id.tv_rating_text);
            ratingText.setText(next);
            ImageView ratingIcon = (ImageView) inflate.findViewById(R.id.iv_rating_icon);
            inflate.setTag(Integer.valueOf(i3));
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$CustomerServiceRobotEvaluation$hifkXHprh8bEJx4j31NEC3dzLQA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CustomerServiceRobotEvaluation.a(CustomerServiceRobotEvaluation.this, inflate, view);
                }
            });
            linearLayout2.addView(inflate);
            List<ViewHolder> list = this.d;
            Intrinsics.c(ratingText, "ratingText");
            Intrinsics.c(ratingIcon, "ratingIcon");
            list.add(new ViewHolder(ratingText, ratingIcon));
            i2 = i3 + 1;
        }
    }

    private final void setRatingBarSelected(int i) {
        int size = this.f34250c.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            this.d.get(i3).a().setTextColor(i3 == i ? -26112 : -8947849);
            this.d.get(i3).b().setImageResource(i3 <= i ? R.drawable.icon_customer_service_rating_star_selected : R.drawable.icon_customer_service_rating_star);
            i2 = i3 + 1;
        }
    }

    private final void setYesNo(int i) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_evaluate_yes_no);
        if (i == 8) {
            linearLayout.setVisibility(8);
            return;
        }
        final TextView textView = (TextView) findViewById(R.id.tv_evaluate_yes);
        final TextView textView2 = (TextView) findViewById(R.id.tv_evaluate_no);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$CustomerServiceRobotEvaluation$75rAWbjNWxeslS3QciJY9mYkmTo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomerServiceRobotEvaluation.a(CustomerServiceRobotEvaluation.this, textView, textView2, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$CustomerServiceRobotEvaluation$HC-DQcwUGSudImJID96BcMAmA7E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomerServiceRobotEvaluation.b(CustomerServiceRobotEvaluation.this, textView, textView2, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        setYesNo(this.b == 2 ? 8 : 0);
        setRating(this.b == 1 ? 8 : 0);
        ((FrameLayout) findViewById(R.id.fl_evaluate_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$CustomerServiceRobotEvaluation$X1kzgnld9XZ7Q_G2DL_GOnuOhkw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomerServiceRobotEvaluation.a(CustomerServiceRobotEvaluation.this, view);
            }
        });
        ((TextView) findViewById(R.id.tv_evaluate_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$CustomerServiceRobotEvaluation$wRNzP21sySdvNpJfs684h8C0JjM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomerServiceRobotEvaluation.b(CustomerServiceRobotEvaluation.this, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_customer_service_robot_evaluate;
    }

    public final int getType() {
        return this.b;
    }
}
