package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsMediaFactory.class */
public class TbsMediaFactory {

    /* renamed from: a  reason: collision with root package name */
    private Context f38779a;
    private u b = null;

    /* renamed from: c  reason: collision with root package name */
    private DexLoader f38780c = null;

    public TbsMediaFactory(Context context) {
        this.f38779a = null;
        this.f38779a = context.getApplicationContext();
        a();
    }

    private void a() {
        if (this.f38779a == null) {
            Log.e("TbsVideo", "TbsVideo needs context !!");
            return;
        }
        if (this.b == null) {
            f.a(true).a(this.f38779a, false, false);
            u a2 = f.a(true).a();
            this.b = a2;
            if (a2 != null) {
                this.f38780c = a2.b();
            }
        }
        if (this.b == null || this.f38780c == null) {
            throw new RuntimeException("tbs core dex(s) load failure !!!");
        }
    }

    public TbsMediaPlayer createPlayer() {
        DexLoader dexLoader;
        if (this.b == null || (dexLoader = this.f38780c) == null) {
            throw new RuntimeException("tbs core dex(s) did not loaded !!!");
        }
        return new TbsMediaPlayer(new p(dexLoader, this.f38779a));
    }
}
