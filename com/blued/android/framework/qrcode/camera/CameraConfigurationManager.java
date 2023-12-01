package com.blued.android.framework.qrcode.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/camera/CameraConfigurationManager.class */
public final class CameraConfigurationManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9856a = CameraConfigurationManager.class.getSimpleName();
    private static final Pattern b = Pattern.compile(",");

    /* renamed from: c  reason: collision with root package name */
    private final Context f9857c;
    private Point d;
    private Point e;
    private int f;
    private String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraConfigurationManager(Context context) {
        this.f9857c = context;
    }

    private static int a(CharSequence charSequence, int i) {
        String[] split = b.split(charSequence);
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= length) {
                return i4;
            }
            try {
                double parseDouble = Double.parseDouble(split[i2].trim());
                int i5 = (int) (10.0d * parseDouble);
                int i6 = i4;
                if (Math.abs(i - parseDouble) < Math.abs(i - i4)) {
                    i6 = i5;
                }
                i2++;
                i3 = i6;
            } catch (NumberFormatException e) {
                return i;
            }
        }
    }

    private static Point a(Camera.Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        String str2 = str;
        if (str == null) {
            str2 = parameters.get("preview-size-value");
        }
        Point point2 = null;
        if (str2 != null) {
            Log.d(f9856a, "preview-size-values parameter: " + str2);
            point2 = b(parameters, point);
        }
        Point point3 = point2;
        if (point2 == null) {
            point3 = new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        }
        return point3;
    }

    private void a(Camera.Parameters parameters) {
        if (Build.MODEL.contains("Behold II") && CameraManager.f9858a == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
    }

    private static Point b(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w(f9856a, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.blued.android.framework.qrcode.camera.CameraConfigurationManager.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        double d = point.x / point.y;
        Iterator<E> it = arrayList.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                if (arrayList.isEmpty()) {
                    Camera.Size previewSize2 = parameters.getPreviewSize();
                    Point point2 = new Point(previewSize2.width, previewSize2.height);
                    Log.i(f9856a, "No suitable preview sizes, using default: " + point2);
                    return point2;
                }
                Camera.Size size = (Camera.Size) arrayList.get(0);
                Point point3 = new Point(size.width, size.height);
                Log.i(f9856a, "Using largest suitable preview size: " + point3);
                return point3;
            }
            Camera.Size size2 = (Camera.Size) it.next();
            int i = size2.width;
            int i2 = size2.height;
            if (i * i2 < 153600) {
                it.remove();
            } else {
                if (i < i2) {
                    z = true;
                }
                int i3 = z ? i2 : i;
                int i4 = z ? i : i2;
                if (Math.abs((i3 / i4) - d) > 0.15d) {
                    it.remove();
                } else if (i3 == point.x && i4 == point.y) {
                    Point point4 = new Point(i, i2);
                    Log.i(f9856a, "Found preview size exactly matching screen size: " + point4);
                    return point4;
                }
            }
        }
    }

    private void b(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            String str2 = parameters.get("max-zoom");
            int i = 27;
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    i = 27;
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException e) {
                    Log.w(f9856a, "Bad max-zoom: " + str2);
                    i = 27;
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            int i2 = i;
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    i2 = i;
                    if (i > parseInt) {
                        i2 = parseInt;
                    }
                } catch (NumberFormatException e2) {
                    Log.w(f9856a, "Bad taking-picture-zoom-max: " + str3);
                    i2 = i;
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            int i3 = i2;
            if (str4 != null) {
                i3 = a(str4, i2);
            }
            String str5 = parameters.get("mot-zoom-step");
            int i4 = i3;
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    i4 = i3;
                    if (parseDouble2 > 1) {
                        i4 = i3 - (i3 % parseDouble2);
                    }
                } catch (NumberFormatException e3) {
                    i4 = i3;
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", String.valueOf(i4 / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.f = parameters.getPreviewFormat();
        this.g = parameters.get("preview-format");
        String str = f9856a;
        Log.d(str, "Default preview format: " + this.f + '/' + this.g);
        Display defaultDisplay = ((WindowManager) this.f9857c.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        this.d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        String str2 = f9856a;
        Log.d(str2, "Screen resolution: " + this.d);
        Point point = new Point();
        point.x = this.d.x;
        point.y = this.d.y;
        if (this.d.x < this.d.y) {
            point.x = this.d.y;
            point.y = this.d.x;
        }
        this.e = a(parameters, point);
        String str3 = f9856a;
        Log.d(str3, "Camera resolution: " + this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        String str = f9856a;
        Log.d(str, "Setting preview size: " + this.e);
        parameters.setPreviewSize(this.e.x, this.e.y);
        a(parameters);
        b(parameters);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }
}
