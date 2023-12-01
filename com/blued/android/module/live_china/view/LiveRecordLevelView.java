package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.view.LiveRecordLevelView;
import com.blued.android.module.live_china.view.MarqueeTextView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRecordLevelView.class */
public class LiveRecordLevelView extends LinearLayout implements View.OnClickListener {
    public int a;
    public EventCallback b;
    private Context c;
    private LayoutInflater d;
    private ImageView e;
    private View f;
    private MarqueeTextView g;
    private boolean h;
    private boolean i;
    private Runnable j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.LiveRecordLevelView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRecordLevelView$1.class */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i) {
            if (i >= 1) {
                LiveRecordLevelView.this.g.b();
                LiveRecordLevelView.this.g.a();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LiveRecordLevelView.this.g.setListener(new MarqueeTextView.callbackListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveRecordLevelView$1$677QZBz1pGrueLVzzwXBRpjjJUM
                    @Override // com.blued.android.module.live_china.view.MarqueeTextView.callbackListener
                    public final void onFinish(int i) {
                        LiveRecordLevelView.AnonymousClass1.this.a(i);
                    }
                });
                LiveRecordLevelView.this.g.setScrollSpeed(2.2f);
                LiveRecordLevelView.this.g.setWaitTime(2000L);
                LiveRecordLevelView.this.g.a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRecordLevelView$EventCallback.class */
    public interface EventCallback {
        void a();
    }

    public LiveRecordLevelView(Context context) {
        super(context);
        this.h = false;
        this.i = false;
        this.j = new AnonymousClass1();
        this.c = context;
        b();
    }

    public LiveRecordLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.i = false;
        this.j = new AnonymousClass1();
        this.c = context;
        b();
    }

    private void b() {
        LayoutInflater from = LayoutInflater.from(this.c);
        this.d = from;
        View inflate = from.inflate(R.layout.live_record_progress_view, (ViewGroup) this, true);
        this.e = (ImageView) inflate.findViewById(R.id.live_anchor_level);
        this.g = (MarqueeTextView) inflate.findViewById(R.id.live_anchor_level_exp);
        View findViewById = inflate.findViewById(R.id.fl_level_progress);
        this.f = findViewById;
        findViewById.setOnClickListener(this);
    }

    public void a() {
        try {
            removeCallbacks(this.j);
            this.g.b();
            this.h = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i, int i2, int i3, float f) {
        this.a = i2;
        if (LiveRoomManager.a().p() != null) {
            if (LiveRoomManager.a().p().level > i) {
                return;
            }
            LiveRoomManager.a().p().level = i;
            LiveRoomManager.a().p().percent = i3;
            LiveRoomManager.a().p().gap_exp = String.valueOf(f);
            LiveRoomManager.a().p().next_level = i2;
        }
        Log.v("pk", "refreshRecordLevel level:" + i + " -- percent:" + i3);
        LiveUtils.a(this.c, this.e, i, false);
        if (i2 == -1) {
            this.g.setText(this.c.getResources().getString(R.string.live_record_exp_top));
        } else {
            String string = this.c.getResources().getString(R.string.live_record_exp_start);
            String valueOf = String.valueOf(f);
            String string2 = this.c.getResources().getString(R.string.live_record_exp_end);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + valueOf + string2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.c.getResources().getColor(R.color.nafio_f));
            int length = string.length();
            spannableStringBuilder.setSpan(foregroundColorSpan, length, (string + valueOf).length(), 33);
            this.g.setText(spannableStringBuilder);
        }
        MarqueeTextView marqueeTextView = this.g;
        if (marqueeTextView == null || this.h || this.i) {
            return;
        }
        this.i = true;
        marqueeTextView.b();
        removeCallbacks(this.j);
        postDelayed(this.j, 2000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCallback eventCallback;
        Tracker.onClick(view);
        if (view.getId() != R.id.fl_level_progress || (eventCallback = this.b) == null) {
            return;
        }
        eventCallback.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setEventCallback(EventCallback eventCallback) {
        this.b = eventCallback;
    }
}
