package com.soft.blued.ui.find.view;

import android.content.Context;
import android.widget.TextView;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.VisitorCountExtra;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/VisitorChartMarkerView.class */
public class VisitorChartMarkerView extends MarkerView {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f30737a;
    private final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private Context f30738c;

    public VisitorChartMarkerView(Context context, int i) {
        super(context, i);
        this.f30738c = context;
        this.f30737a = (TextView) findViewById(2131371242);
        this.b = (TextView) findViewById(2131371196);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public void a(Entry entry, Highlight highlight) {
        VisitorCountExtra._history_track _history_trackVar = (VisitorCountExtra._history_track) entry.h();
        this.f30737a.setText(_history_trackVar.date);
        TextView textView = this.b;
        textView.setText(StringUtils.a(String.valueOf(_history_trackVar.count)) + this.f30738c.getResources().getString(R.string.times));
        super.a(entry, highlight);
    }

    @Override // com.github.mikephil.charting.components.MarkerView
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
