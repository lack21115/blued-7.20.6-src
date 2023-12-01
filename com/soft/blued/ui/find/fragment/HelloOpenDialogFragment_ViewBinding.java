package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/HelloOpenDialogFragment_ViewBinding.class */
public class HelloOpenDialogFragment_ViewBinding implements Unbinder {
    private HelloOpenDialogFragment b;

    /* renamed from: c  reason: collision with root package name */
    private View f30328c;
    private View d;
    private View e;
    private View f;

    public HelloOpenDialogFragment_ViewBinding(final HelloOpenDialogFragment helloOpenDialogFragment, View view) {
        this.b = helloOpenDialogFragment;
        helloOpenDialogFragment.ivCallLeft = (ImageView) Utils.a(view, R.id.iv_call_left, "field 'ivCallLeft'", ImageView.class);
        helloOpenDialogFragment.tvCallTitleLeft = (TextView) Utils.a(view, R.id.tv_call_title_left, "field 'tvCallTitleLeft'", TextView.class);
        helloOpenDialogFragment.tvCallLeft = (TextView) Utils.a(view, R.id.tv_call_left, "field 'tvCallLeft'", TextView.class);
        View a2 = Utils.a(view, R.id.sll_call_left, "field 'sllCallLeft' and method 'onViewClicked'");
        helloOpenDialogFragment.sllCallLeft = (ShapeLinearLayout) Utils.b(a2, R.id.sll_call_left, "field 'sllCallLeft'", ShapeLinearLayout.class);
        this.f30328c = a2;
        a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.find.fragment.HelloOpenDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                helloOpenDialogFragment.onViewClicked(view2);
            }
        });
        helloOpenDialogFragment.ivCallRight = (ImageView) Utils.a(view, R.id.iv_call_right, "field 'ivCallRight'", ImageView.class);
        helloOpenDialogFragment.tvCallTitleRight = (TextView) Utils.a(view, R.id.tv_call_title_right, "field 'tvCallTitleRight'", TextView.class);
        helloOpenDialogFragment.tvCallRight = (TextView) Utils.a(view, R.id.tv_call_right, "field 'tvCallRight'", TextView.class);
        View a3 = Utils.a(view, R.id.sll_call_right, "field 'sllCallRight' and method 'onViewClicked'");
        helloOpenDialogFragment.sllCallRight = (ShapeLinearLayout) Utils.b(a3, R.id.sll_call_right, "field 'sllCallRight'", ShapeLinearLayout.class);
        this.d = a3;
        a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.find.fragment.HelloOpenDialogFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                helloOpenDialogFragment.onViewClicked(view2);
            }
        });
        View a4 = Utils.a(view, R.id.call_open, "field 'callOpen' and method 'onViewClicked'");
        helloOpenDialogFragment.callOpen = (ShapeTextView) Utils.b(a4, R.id.call_open, "field 'callOpen'", ShapeTextView.class);
        this.e = a4;
        a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.find.fragment.HelloOpenDialogFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                helloOpenDialogFragment.onViewClicked(view2);
            }
        });
        helloOpenDialogFragment.cardView = (CardView) Utils.a(view, 2131362749, "field 'cardView'", CardView.class);
        View a5 = Utils.a(view, 2131365207, "field 'ivClose' and method 'onViewClicked'");
        helloOpenDialogFragment.ivClose = (ImageView) Utils.b(a5, 2131365207, "field 'ivClose'", ImageView.class);
        this.f = a5;
        a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.find.fragment.HelloOpenDialogFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                helloOpenDialogFragment.onViewClicked(view2);
            }
        });
        helloOpenDialogFragment.ivBuySuccess = (ImageView) Utils.a(view, R.id.iv_buy_success, "field 'ivBuySuccess'", ImageView.class);
        helloOpenDialogFragment.tvTitle = (TextView) Utils.a(view, 2131372754, "field 'tvTitle'", TextView.class);
        helloOpenDialogFragment.tvCount = (TextView) Utils.a(view, 2131371196, "field 'tvCount'", TextView.class);
        helloOpenDialogFragment.tvContent = (TextView) Utils.a(view, 2131371186, "field 'tvContent'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        HelloOpenDialogFragment helloOpenDialogFragment = this.b;
        if (helloOpenDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        helloOpenDialogFragment.ivCallLeft = null;
        helloOpenDialogFragment.tvCallTitleLeft = null;
        helloOpenDialogFragment.tvCallLeft = null;
        helloOpenDialogFragment.sllCallLeft = null;
        helloOpenDialogFragment.ivCallRight = null;
        helloOpenDialogFragment.tvCallTitleRight = null;
        helloOpenDialogFragment.tvCallRight = null;
        helloOpenDialogFragment.sllCallRight = null;
        helloOpenDialogFragment.callOpen = null;
        helloOpenDialogFragment.cardView = null;
        helloOpenDialogFragment.ivClose = null;
        helloOpenDialogFragment.ivBuySuccess = null;
        helloOpenDialogFragment.tvTitle = null;
        helloOpenDialogFragment.tvCount = null;
        helloOpenDialogFragment.tvContent = null;
        this.f30328c.setOnClickListener(null);
        this.f30328c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
    }
}
