package com.igexin.push.core.d;

import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d/g.class */
public abstract class g {
    com.getui.gtc.dyc.b.c b = new com.getui.gtc.dyc.b.c() { // from class: com.igexin.push.core.d.g.1
        @Override // com.getui.gtc.dyc.b.c
        public final void a(Map map, Map map2) {
            g.this.a(map2);
        }

        @Override // com.getui.gtc.dyc.b.c
        public final void b(String str) {
            g.this.a(str);
        }
    };

    private com.getui.gtc.dyc.b.c a() {
        return this.b;
    }

    public abstract void a(String str);

    public abstract void a(Map<String, String> map);
}
