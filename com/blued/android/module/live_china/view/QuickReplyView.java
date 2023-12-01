package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.same.Logger;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/QuickReplyView.class */
public class QuickReplyView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f15235a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f15236c;
    private ImageView d;
    private FlowLayout e;
    private boolean f;
    private OnItemClickListener g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/QuickReplyView$OnItemClickListener.class */
    public interface OnItemClickListener {
        void a(View view, LiveZanExtraModel.HotWords hotWords);
    }

    public QuickReplyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuickReplyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f15236c = from;
        View inflate = from.inflate(R.layout.live_quick_reply_view, this);
        this.f15235a = inflate;
        this.d = (ImageView) inflate.findViewById(R.id.quick_reply_close);
        this.e = (FlowLayout) this.f15235a.findViewById(R.id.quick_reply_flow_layout);
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.QuickReplyView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.QuickReplyView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                QuickReplyView.this.f = true;
                QuickReplyView.this.setVisibility(8);
            }
        });
        setMaxRows(3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setData(final List<LiveZanExtraModel.HotWords> list) {
        if (list == null || list.size() <= 0) {
            setQuickReplyViewVisibility(8);
            return;
        }
        this.e.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.e.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.blued.android.module.live_china.view.QuickReplyView.3
                    @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
                    public void onItemClick(View view, int i3) {
                        Logger.a("drb", "mFlowLayout onItemClick");
                        TextView textView = (TextView) view.findViewById(R.id.live_quick_reply_text);
                        if (QuickReplyView.this.g != null) {
                            QuickReplyView.this.g.a(textView, (LiveZanExtraModel.HotWords) list.get(i3));
                        }
                        QuickReplyView.this.setVisibility(8);
                        KeyboardUtils.a((Activity) QuickReplyView.this.b);
                    }
                });
                return;
            }
            View inflate = this.f15236c.inflate(R.layout.live_quick_reply_text_view, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.live_quick_reply_text)).setText(list.get(i2).text);
            this.e.addView(inflate);
            i = i2 + 1;
        }
    }

    public void setMaxRows(int i) {
        this.e.setMaxRows(i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.g = onItemClickListener;
    }

    public void setQuickReplyViewVisibility(int i) {
        if (i != 0) {
            setVisibility(8);
        } else if (this.f) {
        } else {
            if (this.e.getChildCount() > 0) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
        }
    }
}
