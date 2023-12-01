package com.tencent.thumbplayer.adapter;

import com.tencent.thumbplayer.api.TPPlayerState;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private TPPlayerState f39210a;

    public i(TPPlayerState tPPlayerState) {
        this.f39210a = tPPlayerState;
    }

    private static boolean a(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(2) || tPPlayerState.is(8) || tPPlayerState.is(9);
    }

    private static boolean b(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1);
    }

    private static boolean c(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7) || tPPlayerState.is(8) || tPPlayerState.is(9);
    }

    private static boolean d(TPPlayerState tPPlayerState) {
        return true;
    }

    private static boolean e(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    private static boolean f(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean g(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    private static boolean h(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7) || tPPlayerState.is(10);
    }

    private static boolean i(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    private static boolean j(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean k(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean l(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean m(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean n(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean o(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean p(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7) || tPPlayerState.is(10);
    }

    private static boolean q(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3);
    }

    private static boolean r(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean s(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean t(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean u(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean v(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean w(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7) || tPPlayerState.is(8);
    }

    private static boolean x(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    private static boolean y(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    public final boolean a(int i) {
        if (i == 1) {
            return a(this.f39210a);
        }
        if (i == 2) {
            return b(this.f39210a);
        }
        if (i == 3) {
            return c(this.f39210a);
        }
        if (i == 4) {
            return d(this.f39210a);
        }
        if (i == 5) {
            return e(this.f39210a);
        }
        if (i == 6) {
            return f(this.f39210a);
        }
        if (i == 7) {
            return g(this.f39210a);
        }
        if (i == 8) {
            return h(this.f39210a);
        }
        if (i == 9) {
            return i(this.f39210a);
        }
        if (i == 11) {
            return j(this.f39210a);
        }
        if (i == 12) {
            return k(this.f39210a);
        }
        if (i == 13) {
            return m(this.f39210a);
        }
        if (i == 14) {
            return n(this.f39210a);
        }
        if (i == 15) {
            return o(this.f39210a);
        }
        if (i == 16) {
            return p(this.f39210a);
        }
        if (i == 17) {
            return x(this.f39210a);
        }
        if (i == 18) {
            return y(this.f39210a);
        }
        if (i == 19) {
            return l(this.f39210a);
        }
        return false;
    }

    public final boolean b(int i) {
        if (i == 1) {
            return q(this.f39210a);
        }
        if (i == 2) {
            return r(this.f39210a);
        }
        if (i == 3) {
            return s(this.f39210a);
        }
        if (i == 4) {
            return t(this.f39210a);
        }
        if (i == 5) {
            return u(this.f39210a);
        }
        if (i == 6) {
            return v(this.f39210a);
        }
        if (i == 7) {
            return w(this.f39210a);
        }
        return false;
    }
}
