package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsMediaFactory.class */
public class TbsMediaFactory {

    /* renamed from: a  reason: collision with root package name */
    private Context f25088a;
    private u b = null;

    /* renamed from: c  reason: collision with root package name */
    private DexLoader f25089c = null;

    public TbsMediaFactory(Context context) {
        this.f25088a = null;
        this.f25088a = context.getApplicationContext();
        a();
    }

    private void a() {
        if (this.f25088a == null) {
            Log.e("TbsVideo", "TbsVideo needs context !!");
            return;
        }
        if (this.b == null) {
            f.a(true).a(this.f25088a, false, false);
            u a2 = f.a(true).a();
            this.b = a2;
            if (a2 != null) {
                this.f25089c = a2.b();
            }
        }
        if (this.b == null || this.f25089c == null) {
            throw new RuntimeException("tbs core dex(s) load failure !!!");
        }
    }

    public TbsMediaPlayer createPlayer() {
        DexLoader dexLoader;
        if (this.b == null || (dexLoader = this.f25089c) == null) {
            throw new RuntimeException("tbs core dex(s) did not loaded !!!");
        }
        return new TbsMediaPlayer(new p(dexLoader, this.f25088a));
    }
}
