package com.soft.blued.customview.selectabletextview;

import android.text.Spannable;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/selectabletextview/SelectionInfo.class */
public class SelectionInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f28650a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f28651c;

    public int a(Spannable spannable) {
        if (spannable == null) {
            return 0;
        }
        if (this.b > spannable.length()) {
            return spannable.length();
        }
        int i = this.b;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int a(TextView textView) {
        if (textView == null) {
            return 0;
        }
        if (this.b > textView.length()) {
            return textView.length();
        }
        int i = this.b;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public void a(int i) {
        this.b = i;
    }

    public int b(Spannable spannable) {
        if (spannable == null) {
            return 0;
        }
        if (this.f28651c > spannable.length()) {
            return spannable.length();
        }
        int i = this.f28651c;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int b(TextView textView) {
        if (textView == null) {
            return 0;
        }
        if (this.f28651c > textView.length()) {
            return textView.length();
        }
        int i = this.f28651c;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public void b(int i) {
        this.f28651c = i;
    }
}
