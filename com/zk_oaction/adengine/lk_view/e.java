package com.zk_oaction.adengine.lk_view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.fw;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/e.class */
public class e extends com.zk_oaction.adengine.lk_view.b {
    ViewTreeObserver.OnGlobalLayoutListener T;
    private com.zk_oaction.adengine.lk_interfaces.b U;
    private boolean V;
    private int W;
    private Rect aa;
    private b ab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/e$a.class */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                com.zk_oaction.adengine.lk_sdk.c cVar = e.this.t;
                if (cVar == null || cVar.k == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(e.this.u)) {
                    hashMap.put("name", e.this.u);
                }
                hashMap.put("type", "onGlobalLayout");
                e eVar = e.this;
                eVar.t.k.a(eVar, hashMap);
                e.this.getViewTreeObserver().removeOnGlobalLayoutListener(e.this.T);
                e.this.T = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/e$b.class */
    public interface b {
        void a(View view, int i);
    }

    public e(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.V = true;
        this.W = 4;
        this.aa = null;
    }

    private Rect a(View view) {
        if (view instanceof com.zk_oaction.adengine.lk_view.b) {
            return this.t.a((com.zk_oaction.adengine.lk_view.b) view);
        }
        if (view instanceof c) {
            return this.t.a((c) view);
        }
        return null;
    }

    private boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aa = a(this.t.b("jump"));
        }
        Rect rect = this.aa;
        if (rect != null) {
            return rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return false;
    }

    private void f(String str) {
        try {
            if (TextUtils.isEmpty(str) || !"1".equals(str)) {
                return;
            }
            this.T = new a();
            getViewTreeObserver().addOnGlobalLayoutListener(this.T);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean b(XmlPullParser xmlPullParser, String str) {
        try {
            a(xmlPullParser);
            f(xmlPullParser.getAttributeValue(null, "viewlistener"));
            String attributeValue = xmlPullParser.getAttributeValue(null, OapsKey.KEY_BG);
            if (attributeValue != null) {
                if (attributeValue.charAt(0) == '#') {
                    setBackgroundColor(Color.parseColor(attributeValue));
                } else {
                    this.U = this.t.a(attributeValue, this, 3);
                }
            }
            return a(xmlPullParser, str);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
        boolean z;
        if (str.equals(fw.Code)) {
            this.V = true;
            return;
        }
        if (str.equals("false")) {
            z = false;
        } else if (!str.equals("toggle")) {
            return;
        } else {
            z = !this.V;
        }
        this.V = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.V && !a(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.zk_oaction.adengine.lk_interfaces.b bVar = this.U;
        if (bVar != null && bVar.b() != null) {
            canvas.drawBitmap(this.U.b(), 0.0f, 0.0f, (Paint) null);
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    public boolean isClickable() {
        return this.V;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ab = null;
        try {
            if (getChildCount() > 0) {
                removeAllViews();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        int visibility = getVisibility();
        this.W = visibility;
        b bVar = this.ab;
        if (bVar != null) {
            bVar.a(view, visibility);
        }
    }
}
