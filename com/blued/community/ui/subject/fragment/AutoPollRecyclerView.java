package com.blued.community.ui.subject.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import java.lang.ref.WeakReference;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/AutoPollRecyclerView.class */
public class AutoPollRecyclerView extends RecyclerView {
    private boolean a;
    private boolean b;
    private int c;
    private MyHandler d;
    private int e;
    private final int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/AutoPollRecyclerView$MyHandler.class */
    public class MyHandler extends Handler {
        private final WeakReference<AutoPollRecyclerView> b;
        private LinearInterpolator c = new LinearInterpolator();
        private int d;

        public MyHandler(AutoPollRecyclerView autoPollRecyclerView) {
            this.d = 15000;
            this.b = new WeakReference<>(autoPollRecyclerView);
            this.d = (int) (((int) ((AppInfo.l / 90.0f) + 0.5f)) * 1000);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AutoPollRecyclerView autoPollRecyclerView;
            super.handleMessage(message);
            if (message.what == 1 && (autoPollRecyclerView = this.b.get()) != null && autoPollRecyclerView.b) {
                AutoPollRecyclerView.this.a = true;
                autoPollRecyclerView.smoothScrollBy(AppInfo.l, 0, this.c, this.d);
                removeMessages(1);
                sendEmptyMessageDelayed(1, this.d - 100);
            }
        }
    }

    public AutoPollRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 5;
        this.f = 1;
        this.d = new MyHandler(this);
    }

    public void a() {
        this.a = false;
        this.d.removeMessages(1);
    }

    public void a(int i) {
        if (this.a || this.e <= 1) {
            return;
        }
        this.b = true;
        this.d.removeMessages(1);
        this.d.sendEmptyMessageDelayed(1, i);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(2000);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            a(0);
        }
    }

    public void setItemCount(int i) {
        this.e = i;
    }
}
