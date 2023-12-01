package com.opos.mobad.cmn.a;

import android.content.Context;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.ad.privacy.b;
import com.opos.mobad.model.data.AdItemData;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/e.class */
public class e {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/e$a.class */
    public interface a {
        void a();

        void a(View view);
    }

    public static ComplianceInfo a(AdItemData adItemData) {
        if (adItemData == null || adItemData.O() == null) {
            return null;
        }
        return new ComplianceInfo(adItemData.O().b, adItemData.O().f26468a);
    }

    public static void a(final Context context, List<View> list, final a aVar, List<View> list2, final a aVar2, final com.opos.mobad.ad.privacy.b bVar, final ComplianceInfo complianceInfo) {
        if (complianceInfo == null || bVar == null) {
            com.opos.cmn.an.f.a.b("PrivacyTool", "bind but return " + complianceInfo + "," + bVar);
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.opos.mobad.cmn.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(view);
                }
                bVar.a(context, 0, complianceInfo, new b.a() { // from class: com.opos.mobad.cmn.a.e.1.1
                    @Override // com.opos.mobad.ad.privacy.b.a
                    public void a() {
                        if (a.this != null) {
                            a.this.a();
                        }
                    }
                });
            }
        };
        for (View view : list) {
            com.opos.cmn.an.f.a.b("PrivacyTool", "set privacy listener " + view);
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.opos.mobad.cmn.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(view2);
                }
                bVar.a(context, 1, complianceInfo, new b.a() { // from class: com.opos.mobad.cmn.a.e.2.1
                    @Override // com.opos.mobad.ad.privacy.b.a
                    public void a() {
                        if (a.this != null) {
                            a.this.a();
                        }
                    }
                });
            }
        };
        for (View view2 : list2) {
            com.opos.cmn.an.f.a.b("PrivacyTool", "set permission listener " + view2);
            if (view2 != null) {
                view2.setOnClickListener(onClickListener2);
            }
        }
    }
}
