package c.t.m.g;

import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p0.class */
public class p0 {
    public static final int[] d = {31, 113, 239, ChatRoomProtos.Event.YY_LIFT_MASK_POP_USE_CLICK_VALUE, 439, LiveProtos.Event.LIVE_KEYBOARD_BARRAGE_CLICK_VALUE, LiveProtos.Event.LIVE_BATTLE_PASS_TOP_PAGE_BUY_CLICK_VALUE, 773, 853, 977};

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3867a = new byte[0];
    public a[] b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f3868c;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p0$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3869a;
        public int b;

        public a(int i, int i2) {
            this.f3869a = i;
            this.b = i2;
        }

        public int a(String str) {
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i = str.charAt(i2) + (this.b * i);
            }
            return (this.f3869a - 1) & i;
        }
    }

    public p0(int i, int i2) {
        this.b = new a[Math.min(Math.max(1, i2), d.length)];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            a[] aVarArr = this.b;
            if (i4 >= aVarArr.length) {
                this.f3868c = new byte[i];
                return;
            } else {
                aVarArr[i4] = new a(i * 8, d[i4]);
                i3 = i4 + 1;
            }
        }
    }

    public void a(String str) {
        synchronized (this.f3867a) {
            a[] aVarArr = this.b;
            int length = aVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    m2.a(this.f3868c, aVarArr[i2].a(str), true);
                    i = i2 + 1;
                }
            }
        }
    }

    public void a(byte[] bArr) {
        synchronized (this.f3867a) {
            if (bArr != null) {
                System.arraycopy(bArr, 0, this.f3868c, 0, Math.min(bArr.length, this.f3868c.length));
            }
        }
    }

    public byte[] a() {
        byte[] bArr;
        synchronized (this.f3867a) {
            bArr = this.f3868c;
        }
        return bArr;
    }

    public boolean b(String str) {
        synchronized (this.f3867a) {
            if (str == null) {
                return false;
            }
            a[] aVarArr = this.b;
            int length = aVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return true;
                }
                if (!m2.a(this.f3868c, aVarArr[i2].a(str))) {
                    return false;
                }
                i = i2 + 1;
            }
        }
    }
}
