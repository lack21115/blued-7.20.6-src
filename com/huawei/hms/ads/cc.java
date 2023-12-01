package com.huawei.hms.ads;

import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cc.class */
public class cc {
    private ArrayList<cp> V = new ArrayList<>();
    private Map<String, cw> I = new HashMap();

    public cc(View view) {
        Code(view);
    }

    private void Code(View view) {
        Code((cw) new cj(view));
        Code((cw) new cf(view));
        Code((cw) new dd(view));
        Code((cw) new cv(view));
        Code((cp) new cg(view));
        Code((cp) new cr(view));
    }

    public void Code(AttributeSet attributeSet) {
        if (attributeSet == null) {
            ge.I("AttrHandlerHarbor", "parse - attrs is null");
            return;
        }
        int attributeCount = attributeSet.getAttributeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= attributeCount) {
                break;
            }
            String attributeName = attributeSet.getAttributeName(i2);
            String attributeValue = attributeSet.getAttributeValue(i2);
            cw cwVar = this.I.get(attributeName);
            if (cwVar != null) {
                try {
                    cwVar.Code(attributeName, attributeValue);
                } catch (Exception e) {
                    ge.I("AttrHandlerHarbor", "parse exception: " + e.getClass().getSimpleName());
                }
            }
            i = i2 + 1;
        }
        int size = this.V.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            try {
                this.V.get(i4).Code(attributeSet);
            } catch (Exception e2) {
                ge.I("AttrHandlerHarbor", "parse exception: " + e2.getClass().getSimpleName());
            }
            i3 = i4 + 1;
        }
    }

    public void Code(ci ciVar) {
        if (ciVar == null) {
            return;
        }
        if (ciVar instanceof cw) {
            Code((cw) ciVar);
        } else if (ciVar instanceof cp) {
            Code((cp) ciVar);
        }
    }

    void Code(cp cpVar) {
        if (cpVar == null) {
            return;
        }
        this.V.add(cpVar);
    }

    void Code(cw cwVar) {
        if (cwVar == null) {
            return;
        }
        this.I.put(cwVar.Code(), cwVar);
    }

    public void Code(JSONObject jSONObject) {
        for (cw cwVar : this.I.values()) {
            cwVar.Code(jSONObject);
        }
        int size = this.V.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.V.get(i2).Code(jSONObject);
            i = i2 + 1;
        }
    }
}
