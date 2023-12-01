package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg.contract.IMsgFilterCallback;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/MsgFilterView.class */
public class MsgFilterView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private IMsgFilterCallback f18613a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f18614c;
    private View d;
    private View e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;

    public MsgFilterView(Context context) {
        this(context, null);
    }

    public MsgFilterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MsgFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        View a2 = a(context);
        View findViewById = a2.findViewById(R.id.msg_filter_switch_ll);
        this.b = findViewById;
        findViewById.setOnClickListener(this);
        this.f18614c = a2.findViewById(R.id.msg_filter_switch_right_iv);
        this.d = a2.findViewById(R.id.msg_filter_switch_bottom_line);
        View findViewById2 = a2.findViewById(R.id.msg_filter_close_ll);
        this.f = findViewById2;
        findViewById2.setOnClickListener(this);
        this.e = a2.findViewById(R.id.msg_filter_content_v);
        this.g = (TextView) a2.findViewById(R.id.msg_filter_switch_tv);
        TextView textView = (TextView) a2.findViewById(R.id.msg_filter_reset);
        this.h = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) a2.findViewById(R.id.msg_filter_initiator);
        this.i = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) a2.findViewById(R.id.msg_filter_follower);
        this.j = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) a2.findViewById(R.id.msg_filter_nearby);
        this.k = textView4;
        textView4.setOnClickListener(this);
    }

    private void a(boolean z) {
        this.f18613a.e(z);
        setFilterSwitch(false);
        this.i.setSelected(false);
        this.j.setSelected(false);
        this.k.setSelected(false);
    }

    private void c() {
        setFilterSwitch(this.f18613a.C());
    }

    private void d() {
        TextView textView = this.i;
        if (textView != null) {
            boolean isSelected = textView.isSelected();
            setNewMessageStatus(false);
            setSwitchInitiatorButton(!isSelected);
        }
    }

    private void e() {
        TextView textView = this.j;
        if (textView != null) {
            boolean isSelected = textView.isSelected();
            setNewMessageStatus(false);
            setSwitchFollowerButton(!isSelected);
        }
    }

    private void f() {
        TextView textView = this.k;
        if (textView != null) {
            boolean isSelected = textView.isSelected();
            setNewMessageStatus(false);
            setSwitchNearbyButton(!isSelected);
        }
    }

    private void setFilterSwitch(boolean z) {
        View view;
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(z ? 2131890726 : 2131890721);
        }
        View view2 = this.b;
        if (view2 != null) {
            view2.setSelected(z);
            if (this.e.getVisibility() == 0) {
                this.f18614c.setSelected(true);
            } else {
                this.f18614c.setSelected(false);
            }
        }
        View view3 = this.d;
        if (view3 != null) {
            view3.setSelected(z);
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setSelected(z);
        }
        if (z || (view = this.f) == null || view.getVisibility() != 0) {
            return;
        }
        this.f.setVisibility(8);
    }

    private void setSwitchFollowerButton(boolean z) {
        this.j.setSelected(z);
        this.f18613a.c(z);
        c();
    }

    private void setSwitchInitiatorButton(boolean z) {
        this.i.setSelected(z);
        this.f18613a.b(z);
        c();
    }

    private void setSwitchNearbyButton(boolean z) {
        this.k.setSelected(z);
        this.f18613a.d(z);
        c();
    }

    protected View a(Context context) {
        return View.inflate(context, R.layout.view_msg_filter, this);
    }

    public void a() {
        if (this.e.getVisibility() == 0) {
            this.e.setVisibility(8);
            this.f18614c.setSelected(false);
        }
    }

    public void b() {
        if (this.e.getVisibility() == 8) {
            this.e.setVisibility(0);
            this.f18614c.setSelected(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.f18613a != null) {
            switch (view.getId()) {
                case R.id.msg_filter_close_ll /* 2131368532 */:
                    a(true);
                    return;
                case R.id.msg_filter_close_tv /* 2131368533 */:
                case R.id.msg_filter_content_v /* 2131368534 */:
                case R.id.msg_filter_guide_iv /* 2131368536 */:
                case R.id.msg_filter_switch_bottom_line /* 2131368540 */:
                default:
                    return;
                case R.id.msg_filter_follower /* 2131368535 */:
                    e();
                    return;
                case R.id.msg_filter_initiator /* 2131368537 */:
                    d();
                    return;
                case R.id.msg_filter_nearby /* 2131368538 */:
                    f();
                    return;
                case R.id.msg_filter_reset /* 2131368539 */:
                    if (this.f18613a.C()) {
                        a(false);
                        return;
                    }
                    return;
                case R.id.msg_filter_switch_ll /* 2131368541 */:
                    if (this.e.getVisibility() == 0) {
                        a();
                        this.f18613a.y();
                        return;
                    }
                    b();
                    this.f18613a.x();
                    return;
            }
        }
    }

    public void setCallback(IMsgFilterCallback iMsgFilterCallback) {
        this.f18613a = iMsgFilterCallback;
        if (iMsgFilterCallback != null) {
            this.i.setSelected(iMsgFilterCallback.z());
            this.j.setSelected(this.f18613a.A());
            this.k.setSelected(this.f18613a.B());
        }
        c();
    }

    public void setNewMessageStatus(boolean z) {
        View view = this.f;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }
}
