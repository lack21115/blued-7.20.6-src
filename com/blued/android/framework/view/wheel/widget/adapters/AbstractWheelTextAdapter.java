package com.blued.android.framework.view.wheel.widget.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/adapters/AbstractWheelTextAdapter.class */
public abstract class AbstractWheelTextAdapter extends AbstractWheelAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected Context f10362a;
    protected LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    protected int f10363c;
    protected int d;
    protected int e;
    private int f;

    private View a(int i, ViewGroup viewGroup) {
        if (i != -1) {
            if (i != 0) {
                return this.b.inflate(i, viewGroup, false);
            }
            return null;
        }
        return new TextView(this.f10362a);
    }

    private TextView a(View view, int i) {
        if (i == 0) {
            try {
                if (view instanceof TextView) {
                    return (TextView) view;
                }
            } catch (ClassCastException e) {
                Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
                throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", e);
            }
        }
        if (i != 0) {
            return (TextView) view.findViewById(i);
        }
        return null;
    }

    @Override // com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter
    public View a(int i, View view, ViewGroup viewGroup) {
        if (i < 0 || i >= a()) {
            return null;
        }
        View view2 = view;
        if (view == null) {
            view2 = a(this.f10363c, viewGroup);
        }
        TextView a2 = a(view2, this.d);
        a2.setTextSize(this.f);
        a2.setGravity(17);
        a2.setLines(2);
        if (a2 != null) {
            CharSequence a3 = a(i);
            CharSequence charSequence = a3;
            if (a3 == null) {
                charSequence = "";
            }
            a2.setText(charSequence);
            if (this.f10363c == -1) {
                a(a2);
            }
        }
        return view2;
    }

    @Override // com.blued.android.framework.view.wheel.widget.adapters.AbstractWheelAdapter, com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter
    public View a(View view, ViewGroup viewGroup) {
        View view2 = view;
        if (view == null) {
            view2 = a(this.e, viewGroup);
        }
        if (this.e == -1 && (view2 instanceof TextView)) {
            a((TextView) view2);
        }
        return view2;
    }

    protected abstract CharSequence a(int i);

    protected void a(TextView textView) {
        textView.setGravity(17);
        textView.setTextSize(this.f);
        textView.setLines(2);
    }
}
