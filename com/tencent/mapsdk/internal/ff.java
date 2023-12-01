package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.view.View;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.map.lib.models.MapExploreByTouchHelper;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ff.class */
public class ff extends MapExploreByTouchHelper implements l5 {
    private List<AccessibleTouchItem> g;
    private List<AccessibleTouchItem> h;
    private yi i;
    private Handler j;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ff$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ff.this.accessibleTouchItems.clear();
            ff.this.g.clear();
            ff.this.h.clear();
            if (ff.this.i != null) {
                List<o0> j0 = ff.this.i.j0();
                List<MapPoi> l0 = ff.this.i.l0();
                o0 o0Var = null;
                if (j0 != null) {
                    o0Var = null;
                    for (o0 o0Var2 : j0) {
                        String contentDescription = o0Var2.getContentDescription();
                        if (!f7.b(contentDescription)) {
                            if (contentDescription.startsWith(AccessibleTouchItem.MY_LOCATION_PREFIX)) {
                                o0Var = o0Var2;
                            } else {
                                ff.this.g.add(new gf(ff.this.i, o0Var2));
                            }
                        }
                    }
                    Collections.sort(ff.this.g);
                    ff.this.accessibleTouchItems.addAll(ff.this.g);
                }
                if (l0 != null) {
                    for (MapPoi mapPoi : l0) {
                        if (!f7.b(mapPoi.getName())) {
                            ff.this.h.add(new hf(ff.this.i, mapPoi));
                        }
                    }
                    Collections.sort(ff.this.h);
                    ff.this.accessibleTouchItems.addAll(ff.this.h);
                }
                if (o0Var != null) {
                    ff.this.accessibleTouchItems.add(new gf(ff.this.i, o0Var));
                }
            }
        }
    }

    public ff(View view, yi yiVar) {
        super(view);
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.j = new Handler();
        this.i = yiVar;
        yiVar.getMap().a(this);
    }

    private int a(float f, float f2) {
        List<AccessibleTouchItem> list = this.accessibleTouchItems;
        if (list == null || list.size() <= 0) {
            return -1;
        }
        int size = this.accessibleTouchItems.size() - 1;
        AccessibleTouchItem accessibleTouchItem = this.accessibleTouchItems.get(size);
        if ((accessibleTouchItem instanceof gf) && accessibleTouchItem.getBounds().contains((int) f, (int) f2)) {
            return size;
        }
        return -1;
    }

    public void a() {
        this.i.getMap().b(this);
        this.accessibleTouchItems.clear();
        this.g.clear();
        this.h.clear();
    }

    public void a(bf bfVar) {
        if (bfVar == null) {
            return;
        }
        String contentDescription = bfVar.getContentDescription();
        if (!f7.b(contentDescription) && bfVar.S()) {
            gf gfVar = new gf(this.i, bfVar);
            AccessibleTouchItem accessibleTouchItem = null;
            if (this.accessibleTouchItems.size() > 0) {
                List<AccessibleTouchItem> list = this.accessibleTouchItems;
                AccessibleTouchItem accessibleTouchItem2 = list.get(list.size() - 1);
                accessibleTouchItem = null;
                if (accessibleTouchItem2 != null) {
                    accessibleTouchItem = null;
                    if (accessibleTouchItem2 instanceof gf) {
                        accessibleTouchItem = accessibleTouchItem2;
                    }
                }
            }
            if (contentDescription.startsWith(AccessibleTouchItem.MY_LOCATION_PREFIX)) {
                this.accessibleTouchItems.add(gfVar);
                return;
            }
            this.accessibleTouchItems.clear();
            this.g.add(gfVar);
            Collections.sort(this.g);
            this.accessibleTouchItems.addAll(this.g);
            this.accessibleTouchItems.addAll(this.h);
            if (accessibleTouchItem != null) {
                this.accessibleTouchItems.add(accessibleTouchItem);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.l5
    public void b() {
        this.j.post(new a());
    }

    @Override // com.tencent.map.lib.models.MapExploreByTouchHelper
    public int getTargetPoiItemIdx(float f, float f2) {
        List<AccessibleTouchItem> list = this.accessibleTouchItems;
        if (list == null || list.size() <= 0) {
            return -1;
        }
        int a2 = a(f, f2);
        if (a2 != -1) {
            return a2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.accessibleTouchItems.size()) {
                return -1;
            }
            if (this.accessibleTouchItems.get(i2).getBounds().contains((int) f, (int) f2)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.map.lib.models.MapExploreByTouchHelper
    public boolean onItemClicked(int i) {
        AccessibleTouchItem accessibleTouchItem;
        if (i < this.accessibleTouchItems.size() && (accessibleTouchItem = this.accessibleTouchItems.get(i)) != null) {
            invalidateVirtualView(i);
            sendEventForVirtualView(i, 1);
            accessibleTouchItem.onClick();
            return true;
        }
        return false;
    }

    @Override // com.tencent.map.lib.models.MapExploreByTouchHelper
    public void onTalkBackActivate(View view) {
        super.onTalkBackActivate(view);
        this.i.getMap().a(this);
        b();
    }

    @Override // com.tencent.map.lib.models.MapExploreByTouchHelper
    public void onTalkBackDeActivate(View view) {
        super.onTalkBackDeActivate(view);
        this.i.getMap().b(this);
    }
}
