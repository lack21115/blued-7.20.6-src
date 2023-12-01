package com.kwad.components.core.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.bm;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/c.class */
public final class c extends View implements bm.a {
    private View Ru;
    private boolean VK;
    private boolean VL;
    private a Wh;
    private boolean Wi;
    private final int Wj;
    private final bm gK;
    private final AtomicBoolean mIsViewDetached;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/c$a.class */
    public interface a {
        void eN();
    }

    public c(Context context, View view) {
        super(context);
        this.gK = new bm(this);
        this.mIsViewDetached = new AtomicBoolean(true);
        this.Wj = (int) (com.kwad.sdk.core.config.d.uF() * 100.0f);
        this.Ru = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void rr() {
        if (this.VL) {
            this.gK.removeCallbacksAndMessages(null);
            this.VL = false;
        }
    }

    private void rs() {
        if (!this.Wi || this.VL) {
            return;
        }
        this.VL = true;
        this.gK.sendEmptyMessage(1);
    }

    private void viewAttached() {
        this.mIsViewDetached.getAndSet(false);
    }

    private void viewDetached() {
        this.mIsViewDetached.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        a aVar;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!bl.a(this.Ru, this.Wj, false)) {
                if (this.VK) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (aVar = this.Wh) != null) {
                aVar.eN();
            }
            this.gK.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.d.b.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.VL) {
            if (!bl.a(this.Ru, this.Wj, false)) {
                this.gK.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            rr();
            Message obtainMessage = this.gK.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.gK.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.b.d("EmptyView", "onAttachedToWindow:" + this);
        rs();
        this.VK = false;
        viewAttached();
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.b.d("EmptyView", "onDetachedFromWindow" + this);
        rr();
        this.VK = true;
        viewDetached();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.b.d("EmptyView", "onFinishTemporaryDetach:" + this.Ru.getParent());
        viewAttached();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.b.d("EmptyView", "onStartTemporaryDetach:" + this.Ru.getParent());
        viewDetached();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.b.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.b.d("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public final void setNeedCheckingShow(boolean z) {
        this.Wi = z;
        if (!z && this.VL) {
            rr();
        } else if (!z || this.VL) {
        } else {
            rs();
        }
    }

    public final void setViewCallback(a aVar) {
        this.Wh = aVar;
    }
}
