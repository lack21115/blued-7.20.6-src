package com.anythink.expressad.video.dynview.h;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.video.dynview.f.e;
import com.anythink.expressad.video.dynview.f.h;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/h/a.class */
public final class a {
    public a(Context context, List<c> list, h hVar, Map<String, Object> map) {
        new com.anythink.expressad.video.dynview.j.c();
        a(com.anythink.expressad.video.dynview.j.c.a(context, list), hVar, map);
    }

    public a(com.anythink.expressad.video.dynview.c cVar, h hVar, Map<String, Object> map) {
        a(cVar, hVar, map);
    }

    private void a(com.anythink.expressad.video.dynview.c cVar, final h hVar, Map<String, Object> map) {
        if (hVar == null) {
            return;
        }
        if (cVar == null) {
            hVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
        } else if (cVar.a() == null) {
            hVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_CONTEXT);
        } else if (TextUtils.isEmpty(cVar.b())) {
            hVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_LAYOUTNAME);
        } else {
            View inflate = LayoutInflater.from(cVar.a()).inflate(i.a(cVar.a(), cVar.b(), "layout"), (ViewGroup) null);
            com.anythink.expressad.video.dynview.b.b.a();
            com.anythink.expressad.video.dynview.b.b.a(inflate, cVar);
            com.anythink.expressad.video.dynview.b.a.a().a(inflate, cVar, map, new e() { // from class: com.anythink.expressad.video.dynview.h.a.1
                @Override // com.anythink.expressad.video.dynview.f.e
                public final void a(View view, List<View> list) {
                    com.anythink.expressad.video.dynview.a aVar = new com.anythink.expressad.video.dynview.a();
                    aVar.a(view);
                    aVar.a(list);
                    aVar.d();
                    hVar.a(aVar);
                }

                @Override // com.anythink.expressad.video.dynview.f.e
                public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
                    hVar.a(bVar);
                }
            });
        }
    }
}
