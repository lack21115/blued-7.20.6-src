package com.tencent.liteav.audio.route;

import java.util.HashMap;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    final a f22560a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    int f22561c;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/b$a.class */
    public enum a {
        NONE,
        EARPHONE,
        SPEAKERPHONE,
        WIRED_HEADSET,
        BLUETOOTH_HEADSET;
        
        private static final HashMap<String, a> f = new HashMap<String, a>() { // from class: com.tencent.liteav.audio.route.b.a.1
            {
                put("NONE", a.NONE);
                put("EARPHONE", a.EARPHONE);
                put("SPEAKERPHONE", a.SPEAKERPHONE);
                put("WIRED_HEADSET", a.WIRED_HEADSET);
                put("BLUETOOTH_HEADSET", a.BLUETOOTH_HEADSET);
            }
        };

        public static a a(String str) {
            a aVar = f.get(str);
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = NONE;
            }
            return aVar2;
        }
    }

    public b(a aVar, int i, boolean z) {
        this.b = false;
        this.f22560a = aVar;
        this.f22561c = i;
        this.b = z;
    }
}
