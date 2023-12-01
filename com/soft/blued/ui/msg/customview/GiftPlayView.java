package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.pop.BirthCardPop;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.utils.Logger;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/GiftPlayView.class */
public class GiftPlayView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    public static final String f18586a = GiftPlayView.class.getSimpleName();
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18587c;
    private final int d;
    private int e;
    private MsgExtraGift f;
    private LinkedBlockingQueue<MsgExtraGift> g;

    public GiftPlayView(Context context) {
        super(context);
        this.b = 0;
        this.f18587c = 1;
        this.d = 2;
        this.e = 0;
        this.g = new LinkedBlockingQueue<>();
    }

    public GiftPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.f18587c = 1;
        this.d = 2;
        this.e = 0;
        this.g = new LinkedBlockingQueue<>();
    }

    public GiftPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.f18587c = 1;
        this.d = 2;
        this.e = 0;
        this.g = new LinkedBlockingQueue<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        MsgExtraGift poll = this.g.poll();
        this.f = poll;
        if (poll == null || poll.gift_like == null) {
            this.e = 0;
        } else {
            a(this.f.gift_like.gift_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GiftGivingOptionForJsonParse.CardGift cardGift, String str) {
        GiftGivingOptionForJsonParse giftGivingOptionForJsonParse = new GiftGivingOptionForJsonParse();
        giftGivingOptionForJsonParse.gift_id = str;
        giftGivingOptionForJsonParse.extra_info = cardGift;
        new XPopup.Builder(getContext()).a(new SimpleCallback() { // from class: com.soft.blued.ui.msg.customview.GiftPlayView.2
            public void d(BasePopupView basePopupView) {
                super.d(basePopupView);
                GiftPlayView.this.a();
            }
        }).a(new BirthCardPop(getContext(), giftGivingOptionForJsonParse, false, false)).h();
    }

    private void a(final String str) {
        String str2 = f18586a;
        Logger.e(str2, "ChattingModel======" + str);
        ImageLoader.a((IRequestHost) null, str).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.soft.blued.ui.msg.customview.GiftPlayView.1
            public void a() {
                String str3 = GiftPlayView.f18586a;
                Logger.e(str3, "onAnimationStart======" + str);
                GiftPlayView.this.e = 1;
                GiftPlayView.this.setVisibility(0);
                String str4 = GiftPlayView.f18586a;
                Logger.e(str4, "onAnimationStart======" + str);
            }

            public void b() {
                String str3 = GiftPlayView.f18586a;
                Logger.e(str3, "onAnimationEnd======" + str);
                if (GiftPlayView.this.f != null && GiftPlayView.this.f.gift_like != null && GiftPlayView.this.f.gift_like.giftTye == 3 && GiftPlayView.this.f.gift_like.cardGift != null && !TextUtils.isEmpty(GiftPlayView.this.f.gift_like.cardGift.text)) {
                    GiftPlayView giftPlayView = GiftPlayView.this;
                    giftPlayView.a(giftPlayView.f.gift_like.cardGift, GiftPlayView.this.f.gift_like.giftId);
                    GiftPlayView.this.e = 2;
                    GiftPlayView.this.setImageDrawable(null);
                    GiftPlayView.this.setVisibility(8);
                    return;
                }
                GiftPlayView.this.e = 0;
                GiftPlayView.this.setVisibility(8);
                if (!GiftPlayView.this.g.isEmpty()) {
                    GiftPlayView.this.a();
                    return;
                }
                GiftPlayView.this.setImageDrawable(null);
                GiftPlayView.this.setVisibility(8);
            }
        }).a(this);
    }

    public void a(MsgExtraGift msgExtraGift) {
        if (msgExtraGift == null || msgExtraGift.gift_like == null) {
            return;
        }
        if (this.e != 0) {
            this.g.add(msgExtraGift);
            return;
        }
        this.e = 1;
        this.f = msgExtraGift;
        a(msgExtraGift.gift_like.gift_url);
    }
}
