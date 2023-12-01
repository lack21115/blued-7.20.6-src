package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.observer.WaittingCountObserver;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYWaittingView.class */
public class YYWaittingView extends FrameLayout implements View.OnClickListener, WaittingCountObserver {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f18560a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private int f18561c;

    public YYWaittingView(Context context) {
        this(context, null);
    }

    public YYWaittingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYWaittingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18561c = 0;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_waitting_layout, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.tv_waitting_count);
        setOnClickListener(this);
    }

    @Override // com.blued.android.module.yy_china.observer.WaittingCountObserver
    public void a(int i) {
        this.f18561c = i;
        int i2 = i;
        if (i > 99) {
            i2 = 99;
        }
        this.b.setText(String.format(getResources().getString(R.string.yy_waitting_count), Integer.valueOf(i2)));
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.f18560a = baseYYStudioFragment;
        if (YYRoomInfoManager.e().b() != null) {
            this.f18561c = YYRoomInfoManager.e().b().getWaittingCount();
        }
        a(this.f18561c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.e("observer", "YYWaittingView onAttachedToWindow ... ");
        YYObserverManager.a().a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        this.f18560a.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.e("observer", "YYWaittingView onAttachedToWindow ... ");
        YYObserverManager.a().b(this);
    }
}
