package com.anythink.expressad.atsignalcommon.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/base/ActionBar.class */
public class ActionBar extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private WebView f4229a;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/base/ActionBar$a.class */
    public interface a {
        void a();

        View b();
    }

    public ActionBar(Context context) {
        super(context);
    }

    public ActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private View a(a aVar) {
        View b = aVar.b();
        if (b != null) {
            View newActionItem = newActionItem();
            ((ViewGroup) ((ViewGroup) newActionItem).getChildAt(0)).addView(b);
            b.setTag(aVar);
            b.setOnClickListener(this);
            return newActionItem;
        }
        return null;
    }

    public void addAction(a aVar) {
        addAction(aVar, getChildCount());
    }

    public void addAction(a aVar, int i) {
        View view;
        View b = aVar.b();
        if (b != null) {
            View newActionItem = newActionItem();
            ((ViewGroup) ((ViewGroup) newActionItem).getChildAt(0)).addView(b);
            b.setTag(aVar);
            b.setOnClickListener(this);
            view = newActionItem;
        } else {
            view = null;
        }
        addView(view, i);
    }

    public int getActionCount() {
        return getChildCount();
    }

    public WebView getWebView() {
        return this.f4229a;
    }

    public View newActionItem() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(frameLayout);
        return linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        view.getTag();
    }

    public boolean removeAction(a aVar) {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return false;
            }
            View childAt = getChildAt(i2);
            if (childAt != null) {
                Object tag = childAt.getTag();
                if ((tag instanceof a) && tag.equals(aVar)) {
                    removeView(childAt);
                    return true;
                }
            }
            i = i2 + 1;
        }
    }

    public void removeActionAt(int i) {
        if (i < 0 || i >= getChildCount()) {
            return;
        }
        removeViewAt(i);
    }

    public void removeAllActions() {
        removeAllViews();
    }

    public void setWebView(WebView webView) {
        this.f4229a = webView;
    }
}
