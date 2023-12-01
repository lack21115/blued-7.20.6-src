package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/TextSwitcherView.class */
public class TextSwitcherView extends TextSwitcher implements ViewSwitcher.ViewFactory {
    private ArrayList<String> a;
    private int b;
    private Context c;
    private boolean d;

    public TextSwitcherView(Context context) {
        super(context);
        this.a = new ArrayList<>();
        this.b = 0;
        this.d = false;
        this.c = context;
        b();
    }

    public TextSwitcherView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList<>();
        this.b = 0;
        this.d = false;
        this.c = context;
        b();
    }

    private void b() {
        setFactory(this);
        this.a.add("给主播打赏弯豆，帮他提升热度值");
        this.a.add("叫上朋友看直播，帮他提升热度值");
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(1000L);
        setInAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
        translateAnimation2.setDuration(1000L);
        setOutAnimation(translateAnimation2);
        c();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ArrayList<String> arrayList = this.a;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        setText(this.a.get(this.b));
        int i = this.b + 1;
        this.b = i;
        if (i >= this.a.size()) {
            this.b = 0;
        }
    }

    public void a() {
        if (this.d) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.TextSwitcherView.1
            @Override // java.lang.Runnable
            public void run() {
                TextSwitcherView.this.c();
                TextSwitcherView.this.a();
            }
        }, 3000L);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        textView.setTextColor(-30914);
        textView.setTextSize(2, 13.0f);
        return textView;
    }
}
