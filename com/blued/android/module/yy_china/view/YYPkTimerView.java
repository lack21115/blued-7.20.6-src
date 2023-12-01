package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPkTimerView.class */
public class YYPkTimerView extends FrameLayout {
    private ShapeTextView a;
    private ImageView b;

    public YYPkTimerView(Context context) {
        super(context);
        a();
    }

    public YYPkTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYPkTimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_pk_timer_layout, (ViewGroup) this, true);
        this.a = (ShapeTextView) findViewById(R.id.tv_pk_time);
        ImageView imageView = (ImageView) findViewById(R.id.iv_pk_view);
        this.b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYPkTimerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveEventBus.get("show_gift_pk_details").post("");
            }
        });
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        LiveEventBus.get("show_gift_pk_time", String.class).observe(baseYYStudioFragment, new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYPkTimerView.2
            /* renamed from: a */
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str)) {
                    YYPkTimerView.this.a.setText("00:00");
                    YYPkTimerView.this.setVisibility(8);
                    return;
                }
                if (YYPkTimerView.this.getVisibility() != 0) {
                    YYPkTimerView.this.setVisibility(0);
                }
                YYPkTimerView.this.a.setText(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
