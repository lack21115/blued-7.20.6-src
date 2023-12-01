package com.anythink.basead.ui;

import android.content.Context;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.MraidContainerView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidEndCardView.class */
public class MraidEndCardView extends BaseEndCardView {
    private static String g = MraidEndCardView.class.getSimpleName();
    MraidContainerView e;
    a f;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidEndCardView$a.class */
    public interface a {
        void a();

        void a(String str);

        void b();
    }

    public MraidEndCardView(Context context, i iVar, j jVar) {
        super(context, iVar, jVar);
        setBackgroundColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseEndCardView
    public final void a() {
        MraidContainerView mraidContainerView = this.e;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    public void init(boolean z) {
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.b, this.c, new MraidContainerView.a() { // from class: com.anythink.basead.ui.MraidEndCardView.1
            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void a() {
                if (MraidEndCardView.this.f != null) {
                    MraidEndCardView.this.f.a();
                }
            }

            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void a(String str) {
                if (MraidEndCardView.this.f != null) {
                    MraidEndCardView.this.f.a(str);
                }
            }

            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void b() {
                if (MraidEndCardView.this.f != null) {
                    MraidEndCardView.this.f.b();
                }
            }
        });
        this.e = mraidContainerView;
        addView(mraidContainerView, new RelativeLayout.LayoutParams(-1, -1));
        this.e.setNeedRegisterVolumeChangeReceiver(true);
        this.e.init();
        if (z) {
            this.e.loadMraidWebView();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        MraidContainerView mraidContainerView = this.e;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z);
        }
    }

    public void setEndCardListener(a aVar) {
        this.f = aVar;
    }
}
