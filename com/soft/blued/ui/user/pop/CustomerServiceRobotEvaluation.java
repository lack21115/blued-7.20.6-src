package com.soft.blued.ui.user.pop;

import android.view.View;
import android.view.ViewGroup;
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
    private final List<String> f20559c;
    private final List<ViewHolder> d;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/CustomerServiceRobotEvaluation$ViewHolder.class */
    public static final class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f20560a;
        private final ImageView b;

        public ViewHolder(TextView textView, ImageView imageView) {
            Intrinsics.e(textView, "ratingText");
            Intrinsics.e(imageView, "ratingIcon");
            this.f20560a = textView;
            this.b = imageView;
        }

        public final TextView a() {
            return this.f20560a;
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
                return Intrinsics.a(this.f20560a, viewHolder.f20560a) && Intrinsics.a(this.b, viewHolder.b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f20560a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "ViewHolder(ratingText=" + this.f20560a + ", ratingIcon=" + this.b + ')';
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
    public static final void a(CustomerServiceRobotEvaluation customerServiceRobotEvaluation, View view) {
        Tracker.onClick(view);
        Intrinsics.e(customerServiceRobotEvaluation, "this$0");
        customerServiceRobotEvaluation.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CustomerServiceRobotEvaluation customerServiceRobotEvaluation, View view, View view2) {
        Tracker.onClick(view2);
        Intrinsics.e(customerServiceRobotEvaluation, "this$0");
        Object tag = view.getTag();
        if (tag == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        customerServiceRobotEvaluation.setRatingBarSelected(((Integer) tag).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CustomerServiceRobotEvaluation customerServiceRobotEvaluation, TextView textView, TextView textView2, View view) {
        Tracker.onClick(view);
        Intrinsics.e(customerServiceRobotEvaluation, "this$0");
        Intrinsics.c(textView, "tvYes");
        customerServiceRobotEvaluation.a(textView, true, true);
        Intrinsics.c(textView2, "tvNo");
        customerServiceRobotEvaluation.a(textView2, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CustomerServiceRobotEvaluation customerServiceRobotEvaluation, View view) {
        Tracker.onClick(view);
        Intrinsics.e(customerServiceRobotEvaluation, "this$0");
        customerServiceRobotEvaluation.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CustomerServiceRobotEvaluation customerServiceRobotEvaluation, TextView textView, TextView textView2, View view) {
        Tracker.onClick(view);
        Intrinsics.e(customerServiceRobotEvaluation, "this$0");
        Intrinsics.c(textView, "tvYes");
        customerServiceRobotEvaluation.a(textView, true, false);
        Intrinsics.c(textView2, "tvNo");
        customerServiceRobotEvaluation.a(textView2, false, true);
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
        Iterator<String> it = this.f20559c.iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return;
            }
            String next = it.next();
            final View inflate = BottomPopupView.inflate(getContext(), (int) R.layout.layout_customer_service_robot_rating, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_rating_text);
            textView.setText(next);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_rating_icon);
            inflate.setTag(Integer.valueOf(i3));
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$CustomerServiceRobotEvaluation$hifkXHprh8bEJx4j31NEC3dzLQA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CustomerServiceRobotEvaluation.a(CustomerServiceRobotEvaluation.this, inflate, view);
                }
            });
            linearLayout2.addView(inflate);
            List<ViewHolder> list = this.d;
            Intrinsics.c(textView, "ratingText");
            Intrinsics.c(imageView, "ratingIcon");
            list.add(new ViewHolder(textView, imageView));
            i2 = i3 + 1;
        }
    }

    private final void setRatingBarSelected(int i) {
        int size = this.f20559c.size();
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

    public int getImplLayoutId() {
        return R.layout.pop_customer_service_robot_evaluate;
    }

    public final int getType() {
        return this.b;
    }
}
