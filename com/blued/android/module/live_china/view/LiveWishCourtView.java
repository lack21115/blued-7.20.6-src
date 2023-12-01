package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.LiveWishCourtModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveWishCourtView.class */
public class LiveWishCourtView extends FrameLayout {
    private BaseFragment a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private LiveWishCourtModel f;
    private int g;
    private MyHandler h;
    private final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveWishCourtView$MyHandler.class */
    public class MyHandler extends Handler {
        private MyHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            if (LiveWishCourtView.this.f.countdown <= 0 || LiveWishCourtView.this.f.status != 1) {
                LiveWishCourtView.this.h.removeMessages(1);
                LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_WISHING_CONTEST.getValue()));
                LogUtils.c("set LiveWishCourtModel end countdown");
                return;
            }
            LiveWishCourtView.this.f.countdown--;
            LiveWishCourtView.this.b();
        }
    }

    public LiveWishCourtView(Context context) {
        this(context, null);
    }

    public LiveWishCourtView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveWishCourtView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public LiveWishCourtView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.g = R.layout.live_wish_court_layout;
        this.h = new MyHandler();
        this.i = 1;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(AppInfo.d()).inflate(this.g, (ViewGroup) null);
        this.b = (ImageView) inflate.findViewById(R.id.live_wish_court_iv);
        this.c = (TextView) inflate.findViewById(R.id.tv_title);
        this.d = (TextView) inflate.findViewById(R.id.live_wish_court_time_tv);
        this.e = (TextView) inflate.findViewById(R.id.live_wish_court_count_tv);
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveWishCourtView$abJnBI2AiJmPGuJR7CEdzyV_644
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveWishCourtView.this.a(view);
            }
        });
        addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f == null) {
            return;
        }
        ImageLoader.a(this.a.getFragmentActive(), this.f.goods_icon).a(this.b);
        this.c.setText(this.f.tools_title);
        this.e.setText(String.valueOf(this.f.goods_count));
        TextView textView = this.d;
        textView.setText(this.f.countdown + "s");
        if (this.f.countdown <= 1) {
            LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_WISHING_CONTEST.getValue()));
        }
        d();
    }

    private void c() {
        LiveWishCourtModel liveWishCourtModel = this.f;
        if (liveWishCourtModel == null) {
            return;
        }
        LiveEventBusUtil.b(liveWishCourtModel.url);
    }

    private void d() {
        this.h.removeMessages(1);
        this.h.sendEmptyMessageDelayed(1, 1000L);
    }

    public boolean a(LiveWishCourtModel liveWishCourtModel) {
        if (liveWishCourtModel == null) {
            LogUtils.c("set LiveWishCourtModel: model = null");
            return false;
        } else if (this.f != null && liveWishCourtModel.pushTime < this.f.pushTime) {
            LogUtils.c("set LiveWishCourtModel: lastTime=" + this.f.pushTime + ", thisTime=" + liveWishCourtModel.pushTime);
            return false;
        } else {
            this.f = liveWishCourtModel;
            this.h.removeMessages(1);
            LiveWishCourtModel liveWishCourtModel2 = this.f;
            if (liveWishCourtModel2 == null || liveWishCourtModel2.status == 0 || this.f.countdown == 0) {
                LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_WISHING_CONTEST.getValue()));
                return false;
            }
            b();
            LogUtils.c("set LiveWishCourtModel start countdown: " + liveWishCourtModel.countdown);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h.removeMessages(1);
    }

    public void setBaseFragment(BaseFragment baseFragment) {
        this.a = baseFragment;
    }
}
