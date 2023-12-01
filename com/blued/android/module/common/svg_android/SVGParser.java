package com.blued.android.module.common.svg_android;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import com.cdo.oaps.ad.OapsWrapper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/svg_android/SVGParser.class */
public class SVGParser {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/svg_android/SVGParser$Gradient.class */
    public static class Gradient {

        /* renamed from: a  reason: collision with root package name */
        String f10829a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        boolean f10830c;
        float d;
        float e;
        float f;
        float g;
        float h;
        float i;
        float j;
        ArrayList<Float> k;
        ArrayList<Integer> l;
        Matrix m;

        private Gradient() {
            this.k = new ArrayList<>();
            this.l = new ArrayList<>();
            this.m = null;
        }

        public Gradient a(Gradient gradient) {
            Gradient gradient2 = new Gradient();
            gradient2.f10829a = gradient.f10829a;
            gradient2.b = this.f10829a;
            gradient2.f10830c = gradient.f10830c;
            gradient2.d = gradient.d;
            gradient2.f = gradient.f;
            gradient2.e = gradient.e;
            gradient2.g = gradient.g;
            gradient2.h = gradient.h;
            gradient2.i = gradient.i;
            gradient2.j = gradient.j;
            gradient2.k = this.k;
            gradient2.l = this.l;
            gradient2.m = this.m;
            Matrix matrix = gradient.m;
            if (matrix != null) {
                if (this.m == null) {
                    gradient2.m = matrix;
                    return gradient2;
                }
                Matrix matrix2 = new Matrix(this.m);
                matrix2.preConcat(gradient.m);
                gradient2.m = matrix2;
            }
            return gradient2;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/svg_android/SVGParser$NumberParse.class */
    public static class NumberParse {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<Float> f10831a;
        private int b;

        public NumberParse(ArrayList<Float> arrayList, int i) {
            this.f10831a = arrayList;
            this.b = i;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/svg_android/SVGParser$Properties.class */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        StyleSet f10832a;
        Attributes b;

        protected Properties(Attributes attributes) {
            this.f10832a = null;
            this.b = attributes;
            String e = SVGParser.e("style", attributes);
            if (e != null) {
                this.f10832a = new StyleSet(e);
            }
        }

        public String a(String str) {
            StyleSet styleSet = this.f10832a;
            String a2 = styleSet != null ? styleSet.a(str) : null;
            String str2 = a2;
            if (a2 == null) {
                str2 = SVGParser.e(str, this.b);
            }
            return str2;
        }

        public String b(String str) {
            return a(str);
        }

        public Integer c(String str) {
            String a2 = a(str);
            if (a2 == null || !a2.startsWith("#")) {
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(a2.substring(1), 16));
            } catch (NumberFormatException e) {
                return null;
            }
        }

        public Float d(String str) {
            String a2 = a(str);
            if (a2 == null) {
                return null;
            }
            try {
                return Float.valueOf(Float.parseFloat(a2));
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/svg_android/SVGParser$SVGHandler.class */
    public static class SVGHandler extends DefaultHandler {

        /* renamed from: a  reason: collision with root package name */
        Picture f10833a;
        Canvas b;

        /* renamed from: c  reason: collision with root package name */
        Paint f10834c;
        RectF d;
        RectF e;
        RectF f;
        Integer g;
        Integer h;
        int i;
        int j;
        boolean k;
        boolean l;
        HashMap<String, Shader> m;
        HashMap<String, Gradient> n;
        Gradient o;
        private boolean p;
        private int q;
        private boolean r;

        protected SVGHandler(Picture picture) {
            this.d = new RectF();
            this.e = null;
            this.f = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
            this.g = null;
            this.h = null;
            this.k = false;
            this.l = false;
            this.m = new HashMap<>();
            this.n = new HashMap<>();
            this.o = null;
            this.p = false;
            this.q = 0;
            this.r = false;
            this.f10833a = picture;
            Paint paint = new Paint();
            this.f10834c = paint;
            paint.setAntiAlias(true);
        }

        protected SVGHandler(Picture picture, int i, int i2) {
            this(picture);
            this.i = i;
            this.j = i2;
        }

        private Canvas a(int i, int i2) {
            int i3;
            int i4 = this.i;
            if (i4 == 0 || (i3 = this.j) == 0) {
                return this.f10833a.beginRecording(i, i2);
            }
            Canvas beginRecording = this.f10833a.beginRecording(i4, i3);
            a(beginRecording, i, i2);
            return beginRecording;
        }

        private Gradient a(boolean z, Attributes attributes) {
            Gradient gradient = new Gradient();
            gradient.f10829a = SVGParser.e("id", attributes);
            gradient.f10830c = z;
            Float valueOf = Float.valueOf(0.0f);
            if (z) {
                gradient.d = SVGParser.b("x1", attributes, valueOf).floatValue();
                gradient.f = SVGParser.b("x2", attributes, valueOf).floatValue();
                gradient.e = SVGParser.b("y1", attributes, valueOf).floatValue();
                gradient.g = SVGParser.b("y2", attributes, valueOf).floatValue();
            } else {
                gradient.h = SVGParser.b("cx", attributes, valueOf).floatValue();
                gradient.i = SVGParser.b("cy", attributes, valueOf).floatValue();
                gradient.j = SVGParser.b("r", attributes, valueOf).floatValue();
            }
            String e = SVGParser.e("gradientTransform", attributes);
            if (e != null) {
                gradient.m = SVGParser.d(e);
            }
            String e2 = SVGParser.e("href", attributes);
            if (e2 != null) {
                String str = e2;
                if (e2.startsWith("#")) {
                    str = e2.substring(1);
                }
                gradient.b = str;
            }
            return gradient;
        }

        private void a() {
            if (this.l) {
                this.b.restore();
            }
        }

        private void a(float f, float f2) {
            if (f < this.f.left) {
                this.f.left = f;
            }
            if (f > this.f.right) {
                this.f.right = f;
            }
            if (f2 < this.f.top) {
                this.f.top = f2;
            }
            if (f2 > this.f.bottom) {
                this.f.bottom = f2;
            }
        }

        private void a(float f, float f2, float f3, float f4) {
            a(f, f2);
            a(f + f3, f2 + f4);
        }

        private static final void a(Canvas canvas, float f, float f2) {
            float width = canvas.getWidth() / f;
            float height = canvas.getHeight() / f2;
            if (width > height) {
                canvas.translate(((width - height) * f) / 2.0f, 0.0f);
                canvas.scale(height, height);
                return;
            }
            canvas.translate(0.0f, ((height - width) * f2) / 2.0f);
            canvas.scale(width, width);
        }

        private void a(Path path) {
            path.computeBounds(this.d, false);
            a(this.d.left, this.d.top);
            a(this.d.right, this.d.bottom);
        }

        private void a(Properties properties, Integer num, boolean z) {
            int intValue = (num.intValue() & 16777215) | (-16777216);
            Integer num2 = this.g;
            int i = intValue;
            if (num2 != null) {
                i = intValue;
                if (num2.intValue() == intValue) {
                    i = this.h.intValue();
                }
            }
            this.f10834c.setColor(i);
            Float d = properties.d("opacity");
            Float f = d;
            if (d == null) {
                f = properties.d(z ? "fill-opacity" : "stroke-opacity");
            }
            if (f == null) {
                this.f10834c.setAlpha(255);
            } else {
                this.f10834c.setAlpha((int) (f.floatValue() * 255.0f));
            }
        }

        private void a(Attributes attributes) {
            String e = SVGParser.e("transform", attributes);
            boolean z = e != null;
            this.l = z;
            if (z) {
                Matrix d = SVGParser.d(e);
                this.b.save();
                this.b.concat(d);
            }
        }

        public void a(Integer num, Integer num2) {
            this.g = num;
            this.h = num2;
        }

        public void a(boolean z) {
            this.k = z;
        }

        protected boolean a(Properties properties) {
            Integer c2;
            if (this.k || "none".equals(properties.b("display")) || (c2 = properties.c("stroke")) == null) {
                return false;
            }
            a(properties, c2, false);
            Float d = properties.d("stroke-width");
            if (d != null) {
                this.f10834c.setStrokeWidth(d.floatValue());
            }
            String b = properties.b("stroke-linecap");
            if ("round".equals(b)) {
                this.f10834c.setStrokeCap(Paint.Cap.ROUND);
            } else if ("square".equals(b)) {
                this.f10834c.setStrokeCap(Paint.Cap.SQUARE);
            } else if ("butt".equals(b)) {
                this.f10834c.setStrokeCap(Paint.Cap.BUTT);
            }
            String b2 = properties.b("stroke-linejoin");
            if ("miter".equals(b2)) {
                this.f10834c.setStrokeJoin(Paint.Join.MITER);
            } else if ("round".equals(b2)) {
                this.f10834c.setStrokeJoin(Paint.Join.ROUND);
            } else if ("bevel".equals(b2)) {
                this.f10834c.setStrokeJoin(Paint.Join.BEVEL);
            }
            this.f10834c.setStyle(Paint.Style.STROKE);
            return true;
        }

        protected boolean a(Properties properties, HashMap<String, Shader> hashMap) {
            if ("none".equals(properties.b("display"))) {
                return false;
            }
            if (this.k) {
                this.f10834c.setStyle(Paint.Style.FILL);
                this.f10834c.setColor(-1);
                return true;
            }
            String b = properties.b("fill");
            if (b != null && b.startsWith("url(#")) {
                Shader shader = hashMap.get(b.substring(5, b.length() - 1));
                if (shader != null) {
                    this.f10834c.setShader(shader);
                    this.f10834c.setStyle(Paint.Style.FILL);
                    return true;
                }
                return false;
            }
            this.f10834c.setShader(null);
            Integer c2 = properties.c("fill");
            if (c2 != null) {
                a(properties, c2, true);
                this.f10834c.setStyle(Paint.Style.FILL);
                return true;
            } else if (properties.b("fill") == null && properties.b("stroke") == null) {
                this.f10834c.setStyle(Paint.Style.FILL);
                this.f10834c.setColor(-16777216);
                return true;
            } else {
                return false;
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            Gradient gradient;
            Gradient gradient2;
            Gradient gradient3;
            if (str2.equals("svg")) {
                this.f10833a.endRecording();
            } else if (str2.equals("linearGradient")) {
                if (this.o.f10829a != null) {
                    if (this.o.b != null && (gradient3 = this.n.get(this.o.b)) != null) {
                        this.o = gradient3.a(this.o);
                    }
                    int size = this.o.l.size();
                    int[] iArr = new int[size];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        iArr[i2] = this.o.l.get(i2).intValue();
                        i = i2 + 1;
                    }
                    int size2 = this.o.k.size();
                    float[] fArr = new float[size2];
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= size2) {
                            break;
                        }
                        fArr[i4] = this.o.k.get(i4).floatValue();
                        i3 = i4 + 1;
                    }
                    if (size == 0) {
                        Log.d("BAD", "BAD");
                    }
                    LinearGradient linearGradient = new LinearGradient(this.o.d, this.o.e, this.o.f, this.o.g, iArr, fArr, Shader.TileMode.CLAMP);
                    if (this.o.m != null) {
                        linearGradient.setLocalMatrix(this.o.m);
                    }
                    this.m.put(this.o.f10829a, linearGradient);
                    this.n.put(this.o.f10829a, this.o);
                }
            } else if (!str2.equals("radialGradient")) {
                if (str2.equals("g")) {
                    if (this.r) {
                        this.r = false;
                    }
                    if (this.p) {
                        int i5 = this.q - 1;
                        this.q = i5;
                        if (i5 == 0) {
                            this.p = false;
                        }
                    }
                    this.m.clear();
                }
            } else if (this.o.f10829a != null) {
                if (this.o.b != null && (gradient2 = this.n.get(this.o.b)) != null) {
                    this.o = gradient2.a(this.o);
                }
                int size3 = this.o.l.size();
                int[] iArr2 = new int[size3];
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= size3) {
                        break;
                    }
                    iArr2[i7] = this.o.l.get(i7).intValue();
                    i6 = i7 + 1;
                }
                int size4 = this.o.k.size();
                float[] fArr2 = new float[size4];
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    if (i9 >= size4) {
                        break;
                    }
                    fArr2[i9] = this.o.k.get(i9).floatValue();
                    i8 = i9 + 1;
                }
                if (this.o.b != null && (gradient = this.n.get(this.o.b)) != null) {
                    this.o = gradient.a(this.o);
                }
                RadialGradient radialGradient = new RadialGradient(this.o.h, this.o.i, this.o.j, iArr2, fArr2, Shader.TileMode.CLAMP);
                if (this.o.m != null) {
                    radialGradient.setLocalMatrix(this.o.m);
                }
                this.m.put(this.o.f10829a, radialGradient);
                this.n.put(this.o.f10829a, this.o);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            this.f10834c.setAlpha(255);
            boolean z = this.r;
            Float valueOf = Float.valueOf(0.0f);
            if (z) {
                if (str2.equals("rect")) {
                    Float f = SVGParser.f("x", attributes);
                    Float f2 = f;
                    if (f == null) {
                        f2 = valueOf;
                    }
                    Float f3 = SVGParser.f("y", attributes);
                    if (f3 != null) {
                        valueOf = f3;
                    }
                    Float f4 = SVGParser.f("width", attributes);
                    SVGParser.f("height", attributes);
                    this.e = new RectF(f2.floatValue(), valueOf.floatValue(), f2.floatValue() + f4.floatValue(), valueOf.floatValue() + f4.floatValue());
                }
            } else if (str2.equals("svg")) {
                this.b = a((int) Math.ceil(SVGParser.f("width", attributes).floatValue()), (int) Math.ceil(SVGParser.f("height", attributes).floatValue()));
            } else if (str2.equals("defs")) {
            } else {
                if (str2.equals("linearGradient")) {
                    this.o = a(true, attributes);
                } else if (str2.equals("radialGradient")) {
                    this.o = a(false, attributes);
                } else if (str2.equals("stop")) {
                    if (this.o != null) {
                        float floatValue = SVGParser.f("offset", attributes).floatValue();
                        StyleSet styleSet = new StyleSet(SVGParser.e("style", attributes));
                        String a2 = styleSet.a("stop-color");
                        int parseInt = a2 != null ? a2.startsWith("#") ? Integer.parseInt(a2.substring(1), 16) : Integer.parseInt(a2, 16) : -16777216;
                        String a3 = styleSet.a("stop-opacity");
                        int round = a3 != null ? parseInt | (Math.round(Float.parseFloat(a3) * 255.0f) << 24) : parseInt | (-16777216);
                        this.o.k.add(Float.valueOf(floatValue));
                        this.o.l.add(Integer.valueOf(round));
                    }
                } else if (str2.equals("g")) {
                    if ("bounds".equalsIgnoreCase(SVGParser.e("id", attributes))) {
                        this.r = true;
                    }
                    if (this.p) {
                        this.q++;
                    }
                    if (!"none".equals(SVGParser.e("display", attributes)) || this.p) {
                        return;
                    }
                    this.p = true;
                    this.q = 1;
                } else if (!this.p && str2.equals("rect")) {
                    Float f5 = SVGParser.f("x", attributes);
                    Float f6 = f5;
                    if (f5 == null) {
                        f6 = valueOf;
                    }
                    Float f7 = SVGParser.f("y", attributes);
                    if (f7 != null) {
                        valueOf = f7;
                    }
                    Float f8 = SVGParser.f("width", attributes);
                    Float f9 = SVGParser.f("height", attributes);
                    a(attributes);
                    Properties properties = new Properties(attributes);
                    if (a(properties, this.m)) {
                        a(f6.floatValue(), valueOf.floatValue(), f8.floatValue(), f9.floatValue());
                        this.b.drawRect(f6.floatValue(), valueOf.floatValue(), f6.floatValue() + f8.floatValue(), valueOf.floatValue() + f9.floatValue(), this.f10834c);
                    }
                    if (a(properties)) {
                        this.b.drawRect(f6.floatValue(), valueOf.floatValue(), f6.floatValue() + f8.floatValue(), valueOf.floatValue() + f9.floatValue(), this.f10834c);
                    }
                    a();
                } else if (!this.p && str2.equals("line")) {
                    Float f10 = SVGParser.f("x1", attributes);
                    Float f11 = SVGParser.f("x2", attributes);
                    Float f12 = SVGParser.f("y1", attributes);
                    Float f13 = SVGParser.f("y2", attributes);
                    if (a(new Properties(attributes))) {
                        a(attributes);
                        a(f10.floatValue(), f12.floatValue());
                        a(f11.floatValue(), f13.floatValue());
                        this.b.drawLine(f10.floatValue(), f12.floatValue(), f11.floatValue(), f13.floatValue(), this.f10834c);
                        a();
                    }
                } else if (!this.p && str2.equals("circle")) {
                    Float f14 = SVGParser.f("cx", attributes);
                    Float f15 = SVGParser.f("cy", attributes);
                    Float f16 = SVGParser.f("r", attributes);
                    if (f14 == null || f15 == null || f16 == null) {
                        return;
                    }
                    a(attributes);
                    Properties properties2 = new Properties(attributes);
                    if (a(properties2, this.m)) {
                        a(f14.floatValue() - f16.floatValue(), f15.floatValue() - f16.floatValue());
                        a(f14.floatValue() + f16.floatValue(), f15.floatValue() + f16.floatValue());
                        this.b.drawCircle(f14.floatValue(), f15.floatValue(), f16.floatValue(), this.f10834c);
                    }
                    if (a(properties2)) {
                        this.b.drawCircle(f14.floatValue(), f15.floatValue(), f16.floatValue(), this.f10834c);
                    }
                    a();
                } else if (!this.p && str2.equals("ellipse")) {
                    Float f17 = SVGParser.f("cx", attributes);
                    Float f18 = SVGParser.f("cy", attributes);
                    Float f19 = SVGParser.f("rx", attributes);
                    Float f20 = SVGParser.f("ry", attributes);
                    if (f17 == null || f18 == null || f19 == null || f20 == null) {
                        return;
                    }
                    a(attributes);
                    Properties properties3 = new Properties(attributes);
                    this.d.set(f17.floatValue() - f19.floatValue(), f18.floatValue() - f20.floatValue(), f17.floatValue() + f19.floatValue(), f18.floatValue() + f20.floatValue());
                    if (a(properties3, this.m)) {
                        a(f17.floatValue() - f19.floatValue(), f18.floatValue() - f20.floatValue());
                        a(f17.floatValue() + f19.floatValue(), f18.floatValue() + f20.floatValue());
                        this.b.drawOval(this.d, this.f10834c);
                    }
                    if (a(properties3)) {
                        this.b.drawOval(this.d, this.f10834c);
                    }
                    a();
                } else if (this.p || !(str2.equals("polygon") || str2.equals("polyline"))) {
                    if (this.p || !str2.equals(OapsWrapper.KEY_PATH)) {
                        if (this.p) {
                            return;
                        }
                        Log.d("SVGAndroid", "UNRECOGNIZED SVG COMMAND: " + str2);
                        return;
                    }
                    Path e = SVGParser.e(SVGParser.e("d", attributes));
                    a(attributes);
                    Properties properties4 = new Properties(attributes);
                    if (a(properties4, this.m)) {
                        a(e);
                        this.b.drawPath(e, this.f10834c);
                    }
                    if (a(properties4)) {
                        this.b.drawPath(e, this.f10834c);
                    }
                    a();
                } else {
                    NumberParse d = SVGParser.d("points", attributes);
                    if (d != null) {
                        Path path = new Path();
                        ArrayList arrayList = d.f10831a;
                        if (arrayList.size() > 1) {
                            a(attributes);
                            Properties properties5 = new Properties(attributes);
                            path.moveTo(((Float) arrayList.get(0)).floatValue(), ((Float) arrayList.get(1)).floatValue());
                            int i = 2;
                            while (true) {
                                int i2 = i;
                                if (i2 >= arrayList.size()) {
                                    break;
                                }
                                path.lineTo(((Float) arrayList.get(i2)).floatValue(), ((Float) arrayList.get(i2 + 1)).floatValue());
                                i = i2 + 2;
                            }
                            if (str2.equals("polygon")) {
                                path.close();
                            }
                            if (a(properties5, this.m)) {
                                a(path);
                                this.b.drawPath(path, this.f10834c);
                            }
                            if (a(properties5)) {
                                this.b.drawPath(path, this.f10834c);
                            }
                            a();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/svg_android/SVGParser$StyleSet.class */
    public static class StyleSet {

        /* renamed from: a  reason: collision with root package name */
        HashMap<String, String> f10835a;

        private StyleSet(String str) {
            this.f10835a = new HashMap<>();
            String[] split = str.split(";");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String[] split2 = split[i2].split(":");
                if (split2.length == 2) {
                    this.f10835a.put(split2[0], split2[1]);
                }
                i = i2 + 1;
            }
        }

        public String a(String str) {
            return this.f10835a.get(str);
        }
    }

    public static SVG a(InputStream inputStream, int i, int i2) throws SVGParseException {
        return a(inputStream, 0, 0, false, i, i2);
    }

    private static SVG a(InputStream inputStream, Integer num, Integer num2, boolean z, int i, int i2) throws SVGParseException {
        try {
            System.currentTimeMillis();
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            Picture picture = new Picture();
            SVGHandler sVGHandler = new SVGHandler(picture, i, i2);
            sVGHandler.a(num, num2);
            sVGHandler.a(z);
            xMLReader.setContentHandler(sVGHandler);
            xMLReader.parse(new InputSource(inputStream));
            SVG svg = new SVG(picture, sVGHandler.e);
            if (!Float.isInfinite(sVGHandler.f.top)) {
                svg.a(sVGHandler.f);
            }
            return svg;
        } catch (Exception e) {
            throw new SVGParseException(e);
        }
    }

    protected static NumberParse a(String str) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        for (int i2 = 1; i2 < length; i2++) {
            if (z) {
                z = false;
            } else {
                char charAt = str.charAt(i2);
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case ',':
                    case '-':
                        String substring = str.substring(i, i2);
                        if (substring.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring)));
                            if (charAt == '-') {
                                i = i2;
                                break;
                            } else {
                                i = i2 + 1;
                                z = true;
                                break;
                            }
                        } else {
                            i++;
                            continue;
                        }
                    case ')':
                    case 'A':
                    case 'C':
                    case 'H':
                    case 'L':
                    case 'M':
                    case 'Q':
                    case 'S':
                    case 'T':
                    case 'V':
                    case 'Z':
                    case 'a':
                    case 'c':
                    case 'h':
                    case 'l':
                    case 'm':
                    case 'q':
                    case 's':
                    case 't':
                    case 'v':
                    case 'z':
                        String substring2 = str.substring(i, i2);
                        if (substring2.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring2)));
                        }
                        return new NumberParse(arrayList, i2);
                }
            }
        }
        String substring3 = str.substring(i);
        if (substring3.length() > 0) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(substring3)));
            } catch (NumberFormatException e) {
            }
            i = str.length();
        }
        return new NumberParse(arrayList, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Float b(String str, Attributes attributes, Float f) {
        String e = e(str, attributes);
        if (e == null) {
            return f;
        }
        String str2 = e;
        if (e.endsWith("px")) {
            str2 = e.substring(0, e.length() - 2);
        }
        return Float.valueOf(Float.parseFloat(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Matrix d(String str) {
        float f;
        float f2 = 0.0f;
        if (str.startsWith("matrix(")) {
            NumberParse a2 = a(str.substring(7));
            if (a2.f10831a.size() == 6) {
                Matrix matrix = new Matrix();
                matrix.setValues(new float[]{((Float) a2.f10831a.get(0)).floatValue(), ((Float) a2.f10831a.get(2)).floatValue(), ((Float) a2.f10831a.get(4)).floatValue(), ((Float) a2.f10831a.get(1)).floatValue(), ((Float) a2.f10831a.get(3)).floatValue(), ((Float) a2.f10831a.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
                return matrix;
            }
            return null;
        } else if (str.startsWith("translate(")) {
            NumberParse a3 = a(str.substring(10));
            if (a3.f10831a.isEmpty()) {
                return null;
            }
            float floatValue = ((Float) a3.f10831a.get(0)).floatValue();
            float f3 = 0.0f;
            if (a3.f10831a.size() > 1) {
                f3 = ((Float) a3.f10831a.get(1)).floatValue();
            }
            Matrix matrix2 = new Matrix();
            matrix2.postTranslate(floatValue, f3);
            return matrix2;
        } else if (str.startsWith("scale(")) {
            NumberParse a4 = a(str.substring(6));
            if (a4.f10831a.isEmpty()) {
                return null;
            }
            float floatValue2 = ((Float) a4.f10831a.get(0)).floatValue();
            float f4 = 0.0f;
            if (a4.f10831a.size() > 1) {
                f4 = ((Float) a4.f10831a.get(1)).floatValue();
            }
            Matrix matrix3 = new Matrix();
            matrix3.postScale(floatValue2, f4);
            return matrix3;
        } else if (str.startsWith("skewX(")) {
            NumberParse a5 = a(str.substring(6));
            if (a5.f10831a.isEmpty()) {
                return null;
            }
            float floatValue3 = ((Float) a5.f10831a.get(0)).floatValue();
            Matrix matrix4 = new Matrix();
            matrix4.postSkew((float) Math.tan(floatValue3), 0.0f);
            return matrix4;
        } else if (str.startsWith("skewY(")) {
            NumberParse a6 = a(str.substring(6));
            if (a6.f10831a.isEmpty()) {
                return null;
            }
            float floatValue4 = ((Float) a6.f10831a.get(0)).floatValue();
            Matrix matrix5 = new Matrix();
            matrix5.postSkew(0.0f, (float) Math.tan(floatValue4));
            return matrix5;
        } else if (str.startsWith("rotate(")) {
            NumberParse a7 = a(str.substring(7));
            if (a7.f10831a.isEmpty()) {
                return null;
            }
            float floatValue5 = ((Float) a7.f10831a.get(0)).floatValue();
            if (a7.f10831a.size() > 2) {
                f2 = ((Float) a7.f10831a.get(1)).floatValue();
                f = ((Float) a7.f10831a.get(2)).floatValue();
            } else {
                f = 0.0f;
            }
            Matrix matrix6 = new Matrix();
            matrix6.postTranslate(f2, f);
            matrix6.postRotate(floatValue5);
            matrix6.postTranslate(-f2, -f);
            return matrix6;
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NumberParse d(String str, Attributes attributes) {
        int length = attributes.getLength();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            if (attributes.getLocalName(i2).equals(str)) {
                return a(attributes.getValue(i2));
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Path e(String str) {
        Path path = new Path();
        PathParser.a(str, path);
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str, Attributes attributes) {
        int length = attributes.getLength();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            if (attributes.getLocalName(i2).equals(str)) {
                return attributes.getValue(i2);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Float f(String str, Attributes attributes) {
        return b(str, attributes, null);
    }
}
