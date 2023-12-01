package com.tencent.txcopyrightedmedia.impl.songscore;

import com.tencent.txcopyrightedmedia.TXSongScoreNoteItem;
import com.tencent.txcopyrightedmedia.impl.utils.d;
import com.tencent.txcopyrightedmedia.impl.utils.i;
import com.tencent.txcopyrightedmedia.impl.utils.x;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/songscore/KGKTVScore.class */
public class KGKTVScore {

    /* renamed from: a  reason: collision with root package name */
    private boolean f40025a;
    private long mNativeInstance;

    static {
        System.loadLibrary("txcopyrightedmedia");
    }

    public KGKTVScore() {
        _createKTVScore();
    }

    private native boolean _active(String str);

    private native int _calculateTotalScore();

    private native void _createKTVScore();

    private native String _getActivationRequestCode(String str);

    private native ArrayList<TXSongScoreNoteItem> _getPitchData();

    private native int _immediatelyDisplay();

    private native int _init(int i, int i2, String str, String str2, int i3);

    private native void _process(byte[] bArr, int i, int i2);

    private native void _release();

    private native void _reset();

    private native void _setPitch(int i);

    private native int[] _updateScore(int i);

    private native int _updateTotalScore(int i);

    public final i a(int i, int i2, String str, String str2) {
        synchronized (this) {
            if (this.f40025a) {
                return new i(-1, "KTVScore has release");
            }
            i iVar = new i(0, null);
            byte[] a2 = d.a(new File(str));
            if (a2 == null) {
                iVar.code = -1;
                iVar.msg = "Read MIDI file fail";
                return iVar;
            }
            int _init = _init(i, i2, new String(a2), str2, 0);
            if (_init != 0) {
                if (_init == -20100) {
                    iVar.code = -1;
                    iVar.msg = "Read lyric file fail";
                    return iVar;
                }
                iVar.code = -1;
                iVar.msg = "Init native KtvScore fail. err: ".concat(String.valueOf(_init));
            }
            return iVar;
        }
    }

    public final String a(String str) {
        String _getActivationRequestCode;
        synchronized (this) {
            _getActivationRequestCode = _getActivationRequestCode(str);
        }
        return _getActivationRequestCode;
    }

    public final ArrayList<TXSongScoreNoteItem> a() {
        synchronized (this) {
            if (this.f40025a) {
                return null;
            }
            return _getPitchData();
        }
    }

    public final void a(int i) {
        synchronized (this) {
            if (!this.f40025a) {
                _setPitch(i);
            }
        }
    }

    public final void a(byte[] bArr, int i, int i2) {
        synchronized (this) {
            if (!this.f40025a) {
                _process(bArr, i, i2);
            }
        }
    }

    public final int b() {
        synchronized (this) {
            if (this.f40025a) {
                return -1;
            }
            return _immediatelyDisplay();
        }
    }

    public final x b(int i) {
        x xVar;
        synchronized (this) {
            int[] iArr = new int[2];
            iArr[0] = 0;
            iArr[1] = 0;
            if (!this.f40025a) {
                iArr = _updateScore(i);
            }
            xVar = null;
            if (iArr != null) {
                xVar = new x();
                xVar.f40187a = iArr[0];
                xVar.b = iArr[1];
            }
        }
        return xVar;
    }

    public final boolean b(String str) {
        boolean _active;
        synchronized (this) {
            _active = _active(str);
        }
        return _active;
    }

    public final int c() {
        synchronized (this) {
            if (this.f40025a) {
                return -1;
            }
            return _calculateTotalScore();
        }
    }

    public final int c(int i) {
        synchronized (this) {
            if (this.f40025a) {
                return -1;
            }
            return _updateTotalScore(i);
        }
    }

    public final void d() {
        synchronized (this) {
            if (!this.f40025a) {
                _reset();
            }
        }
    }

    public final void e() {
        synchronized (this) {
            this.f40025a = true;
            _release();
        }
    }
}
