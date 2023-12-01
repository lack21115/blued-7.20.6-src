package com.soft.blued.ui.msg.manager;

import android.content.Context;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import java.util.Stack;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/UserPagerGiftManager.class */
public class UserPagerGiftManager {
    private static UserPagerGiftManager b;

    /* renamed from: a  reason: collision with root package name */
    public GiftGivingOptionForJsonParse f32451a;

    /* renamed from: c  reason: collision with root package name */
    private Stack<GiftPlayer> f32452c = new Stack<>();

    private UserPagerGiftManager() {
    }

    public static UserPagerGiftManager a() {
        if (b == null) {
            synchronized (UserPagerGiftManager.class) {
                try {
                    if (b == null) {
                        b = new UserPagerGiftManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static String a(boolean z, MsgExtraGift msgExtraGift, Context context, String str) {
        if (z) {
            return str + " " + context.getResources().getString(R.string.msg_has_given) + msgExtraGift.getGiftName();
        }
        return context.getResources().getString(R.string.msg_you_has_give, msgExtraGift.gift_like.toNickName, msgExtraGift.getGiftName());
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[4];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return bArr;
            }
            bArr[i3] = (byte) ((i >> (i3 * 8)) & 255);
            i2 = i3 + 1;
        }
    }

    public void a(GiftPlayer giftPlayer) {
        if (this.f32452c.contains(giftPlayer)) {
            return;
        }
        this.f32452c.add(giftPlayer);
        GiftGivingOptionForJsonParse giftGivingOptionForJsonParse = this.f32451a;
        if (giftGivingOptionForJsonParse != null) {
            giftPlayer.a(giftGivingOptionForJsonParse);
            this.f32451a = null;
        }
    }

    public GiftPlayer b() {
        return this.f32452c.peek();
    }

    public void b(GiftPlayer giftPlayer) {
        if (giftPlayer == null) {
            return;
        }
        this.f32452c.remove(giftPlayer);
    }

    public long c() {
        GiftPlayer peek;
        if (this.f32452c.isEmpty() || (peek = this.f32452c.peek()) == null) {
            return 0L;
        }
        return peek.a();
    }
}
