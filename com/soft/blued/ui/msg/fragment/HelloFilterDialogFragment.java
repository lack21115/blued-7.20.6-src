package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/HelloFilterDialogFragment.class */
public class HelloFilterDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f18674a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ShapeLinearLayout f18675c;
    private ImageView d;
    private ShapeTextView e;
    private ShapeTextView f;
    private ShapeTextView g;
    private ShapeTextView h;
    private ShapeTextView i;
    private ShapeTextView j;
    private ShapeTextView k;
    private ShapeTextView l;
    private OnHelloFilterChange m;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/HelloFilterDialogFragment$OnHelloFilterChange.class */
    public interface OnHelloFilterChange {
        void change(String str);
    }

    private void a(ShapeTextView shapeTextView) {
        a(shapeTextView, !((Boolean) shapeTextView.getTag()).booleanValue());
    }

    private void a(ShapeTextView shapeTextView, boolean z) {
        if (z) {
            ShapeHelper.a(shapeTextView, 2131101780);
            ShapeHelper.b(shapeTextView, 2131101766);
        } else {
            ShapeHelper.a(shapeTextView, 2131102254);
            ShapeHelper.b(shapeTextView, 2131101796);
        }
        shapeTextView.setTag(Boolean.valueOf(z));
    }

    private void i() {
        this.f18675c = this.b.findViewById(R.id.layout_read_auth);
        ImageView imageView = (ImageView) this.b.findViewById(2131365207);
        this.d = imageView;
        imageView.setOnClickListener(this);
        ShapeTextView findViewById = this.b.findViewById(R.id.stv_role_1);
        this.e = findViewById;
        findViewById.setOnClickListener(this);
        ShapeTextView findViewById2 = this.b.findViewById(R.id.stv_role_075);
        this.f = findViewById2;
        findViewById2.setVisibility(8);
        this.f.setOnClickListener(this);
        ShapeTextView findViewById3 = this.b.findViewById(R.id.stv_role_05);
        this.g = findViewById3;
        findViewById3.setOnClickListener(this);
        ShapeTextView findViewById4 = this.b.findViewById(R.id.stv_role_025);
        this.h = findViewById4;
        findViewById4.setVisibility(8);
        this.h.setOnClickListener(this);
        ShapeTextView findViewById5 = this.b.findViewById(R.id.stv_role_0);
        this.i = findViewById5;
        findViewById5.setOnClickListener(this);
        ShapeTextView findViewById6 = this.b.findViewById(R.id.stv_role_others);
        this.j = findViewById6;
        findViewById6.setOnClickListener(this);
        ShapeTextView findViewById7 = this.b.findViewById(R.id.stv_reset);
        this.k = findViewById7;
        findViewById7.setOnClickListener(this);
        ShapeTextView findViewById8 = this.b.findViewById(R.id.stv_ok);
        this.l = findViewById8;
        findViewById8.setOnClickListener(this);
    }

    public void a(OnHelloFilterChange onHelloFilterChange) {
        this.m = onHelloFilterChange;
    }

    public void a(String str) {
        a(this.e, false);
        a(this.f, false);
        a(this.g, false);
        a(this.h, false);
        a(this.i, false);
        a(this.j, false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List asList = Arrays.asList(str.split(","));
        if (asList.contains("1")) {
            a(this.e, true);
        }
        if (asList.contains("0.75")) {
            a(this.f, true);
        }
        if (asList.contains("0.5")) {
            a(this.g, true);
        }
        if (asList.contains("0.25")) {
            a(this.h, true);
        }
        if (asList.contains("0")) {
            a(this.i, true);
        }
        if (asList.contains("-1")) {
            a(this.j, true);
        }
    }

    public String h() {
        ArrayList arrayList = new ArrayList();
        if (this.e.getTag() != null && ((Boolean) this.e.getTag()).booleanValue()) {
            arrayList.add("1");
        }
        if (this.g.getTag() != null && ((Boolean) this.g.getTag()).booleanValue()) {
            arrayList.add("0.5");
        }
        if (this.i.getTag() != null && ((Boolean) this.i.getTag()).booleanValue()) {
            arrayList.add("0");
        }
        if (this.j.getTag() != null && ((Boolean) this.j.getTag()).booleanValue()) {
            arrayList.add("-1");
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            if (TextUtils.equals((CharSequence) arrayList.get(i2), "0.5")) {
                sb.append((String) arrayList.get(i2));
                sb.append(",");
                sb.append("0.75,");
                sb.append("0.25,");
            } else {
                sb.append((String) arrayList.get(i2));
                sb.append(",");
            }
            i = i2 + 1;
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return "";
        }
        Log.v("drb", "role.toString():" + sb.toString());
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131365207) {
            dismiss();
        } else if (id == 2131370405) {
            String h = h();
            BluedPreferences.aa(h);
            EventTrackGuy.c(GuyProtos.Event.VOCATIVE_SECOND_FILTER_CONFIRM_CLICK, h);
            OnHelloFilterChange onHelloFilterChange = this.m;
            if (onHelloFilterChange != null) {
                onHelloFilterChange.change(h);
            }
            dismiss();
        } else {
            switch (id) {
                case R.id.stv_reset /* 2131370413 */:
                    a((String) null);
                    return;
                case R.id.stv_role_0 /* 2131370414 */:
                    a(this.i);
                    return;
                case R.id.stv_role_025 /* 2131370415 */:
                    a(this.h);
                    return;
                case R.id.stv_role_05 /* 2131370416 */:
                    a(this.g);
                    return;
                case R.id.stv_role_075 /* 2131370417 */:
                    a(this.f);
                    return;
                case R.id.stv_role_1 /* 2131370418 */:
                    a(this.e);
                    return;
                case R.id.stv_role_others /* 2131370419 */:
                    a(this.j);
                    return;
                default:
                    return;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18674a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.dialog_hello_filter, viewGroup, false);
            i();
            a(BluedPreferences.dt());
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
