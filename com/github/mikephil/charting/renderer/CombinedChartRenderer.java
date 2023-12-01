package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/CombinedChartRenderer.class */
public class CombinedChartRenderer extends DataRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected List<DataRenderer> f22178a;
    protected WeakReference<Chart> b;

    /* renamed from: c  reason: collision with root package name */
    protected List<Highlight> f22179c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.renderer.CombinedChartRenderer$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/CombinedChartRenderer$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22180a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[CombinedChart.DrawOrder.values().length];
            f22180a = iArr;
            try {
                iArr[CombinedChart.DrawOrder.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22180a[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22180a[CombinedChart.DrawOrder.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22180a[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f22180a[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public CombinedChartRenderer(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f22178a = new ArrayList(5);
        this.f22179c = new ArrayList();
        this.b = new WeakReference<>(combinedChart);
        b();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a() {
        for (DataRenderer dataRenderer : this.f22178a) {
            dataRenderer.a();
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas) {
        for (DataRenderer dataRenderer : this.f22178a) {
            dataRenderer.a(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas, Highlight[] highlightArr) {
        Chart chart = this.b.get();
        if (chart == null) {
            return;
        }
        for (DataRenderer dataRenderer : this.f22178a) {
            BarData barData = null;
            if (dataRenderer instanceof BarChartRenderer) {
                barData = ((BarChartRenderer) dataRenderer).f22170a.getBarData();
            } else if (dataRenderer instanceof LineChartRenderer) {
                barData = ((LineChartRenderer) dataRenderer).f22185a.getLineData();
            } else if (dataRenderer instanceof CandleStickChartRenderer) {
                barData = ((CandleStickChartRenderer) dataRenderer).f22176a.getCandleData();
            } else if (dataRenderer instanceof ScatterChartRenderer) {
                barData = ((ScatterChartRenderer) dataRenderer).f22195a.getScatterData();
            } else if (dataRenderer instanceof BubbleChartRenderer) {
                barData = ((BubbleChartRenderer) dataRenderer).f22174a.getBubbleData();
            }
            int indexOf = barData == null ? -1 : ((CombinedData) chart.getData()).p().indexOf(barData);
            this.f22179c.clear();
            int length = highlightArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    Highlight highlight = highlightArr[i2];
                    if (highlight.e() == indexOf || highlight.e() == -1) {
                        this.f22179c.add(highlight);
                    }
                    i = i2 + 1;
                }
            }
            List<Highlight> list = this.f22179c;
            dataRenderer.a(canvas, (Highlight[]) list.toArray(new Highlight[list.size()]));
        }
    }

    public void b() {
        this.f22178a.clear();
        CombinedChart combinedChart = (CombinedChart) this.b.get();
        if (combinedChart == null) {
            return;
        }
        CombinedChart.DrawOrder[] drawOrder = combinedChart.getDrawOrder();
        int length = drawOrder.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            int i3 = AnonymousClass1.f22180a[drawOrder[i2].ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5 && combinedChart.getScatterData() != null) {
                                this.f22178a.add(new ScatterChartRenderer(combinedChart, this.g, this.o));
                            }
                        } else if (combinedChart.getCandleData() != null) {
                            this.f22178a.add(new CandleStickChartRenderer(combinedChart, this.g, this.o));
                        }
                    } else if (combinedChart.getLineData() != null) {
                        this.f22178a.add(new LineChartRenderer(combinedChart, this.g, this.o));
                    }
                } else if (combinedChart.getBubbleData() != null) {
                    this.f22178a.add(new BubbleChartRenderer(combinedChart, this.g, this.o));
                }
            } else if (combinedChart.getBarData() != null) {
                this.f22178a.add(new BarChartRenderer(combinedChart, this.g, this.o));
            }
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        for (DataRenderer dataRenderer : this.f22178a) {
            dataRenderer.b(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        for (DataRenderer dataRenderer : this.f22178a) {
            dataRenderer.c(canvas);
        }
    }
}
