package android.hardware.camera2.legacy;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.utils.ListUtils;
import android.hardware.camera2.utils.ParamsUtils;
import android.util.Log;
import android.util.Size;
import android.util.SizeF;
import com.android.internal.util.Preconditions;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.igexin.push.core.b;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/ParameterUtils.class */
public class ParameterUtils {
    public static final int NORMALIZED_RECTANGLE_MAX = 1000;
    public static final int NORMALIZED_RECTANGLE_MIN = -1000;
    private static final int ZOOM_RATIO_MULTIPLIER = 100;
    public static final Rect NORMALIZED_RECTANGLE_DEFAULT = new Rect(-1000, -1000, 1000, 1000);
    public static final Camera.Area CAMERA_AREA_DEFAULT = new Camera.Area(new Rect(NORMALIZED_RECTANGLE_DEFAULT), 1);
    public static final Rect RECTANGLE_EMPTY = new Rect(0, 0, 0, 0);
    private static final String TAG = "ParameterUtils";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/ParameterUtils$MeteringData.class */
    public static class MeteringData {
        public final Camera.Area meteringArea;
        public final Rect previewMetering;
        public final Rect reportedMetering;

        public MeteringData(Camera.Area area, Rect rect, Rect rect2) {
            this.meteringArea = area;
            this.previewMetering = rect;
            this.reportedMetering = rect2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/ParameterUtils$WeightedRectangle.class */
    public static class WeightedRectangle {
        public final Rect rect;
        public final int weight;

        public WeightedRectangle(Rect rect, int i) {
            this.rect = (Rect) Preconditions.checkNotNull(rect, "rect must not be null");
            this.weight = i;
        }

        private static int clip(int i, int i2, int i3, Rect rect, String str) {
            if (i < i2) {
                Log.w(ParameterUtils.TAG, "toMetering - Rectangle " + rect + " " + str + " too small, clip to " + i2);
            } else {
                i2 = i;
                if (i > i3) {
                    Log.w(ParameterUtils.TAG, "toMetering - Rectangle " + rect + " " + str + " too small, clip to " + i3);
                    return i3;
                }
            }
            return i2;
        }

        private static int clipLower(int i, int i2, Rect rect, String str) {
            return clip(i, i2, Integer.MAX_VALUE, rect, str);
        }

        public Face toFace() {
            return new Face(this.rect, clip(this.weight, 1, 100, this.rect, WBConstants.GAME_PARAMS_SCORE));
        }

        public Face toFace(int i, Point point, Point point2, Point point3) {
            int clipLower = clipLower(i, 0, this.rect, "id");
            return new Face(this.rect, clip(this.weight, 1, 100, this.rect, WBConstants.GAME_PARAMS_SCORE), clipLower, point, point2, point3);
        }

        public MeteringRectangle toMetering() {
            return new MeteringRectangle(clipLower(this.rect.left, 0, this.rect, "left"), clipLower(this.rect.top, 0, this.rect, Constant.MAP_KEY_TOP), clipLower(this.rect.width(), 0, this.rect, "width"), clipLower(this.rect.height(), 0, this.rect, "height"), clip(this.weight, 0, 1000, this.rect, "weight"));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/ParameterUtils$ZoomData.class */
    public static class ZoomData {
        public final Rect previewCrop;
        public final Rect reportedCrop;
        public final int zoomIndex;

        public ZoomData(int i, Rect rect, Rect rect2) {
            this.zoomIndex = i;
            this.previewCrop = rect;
            this.reportedCrop = rect2;
        }
    }

    private ParameterUtils() {
        throw new AssertionError();
    }

    public static boolean containsSize(List<Camera.Size> list, int i, int i2) {
        Preconditions.checkNotNull(list, "sizeList must not be null");
        for (Camera.Size size : list) {
            if (size.height == i2 && size.width == i) {
                return true;
            }
        }
        return false;
    }

    public static WeightedRectangle convertCameraAreaToActiveArrayRectangle(Rect rect, ZoomData zoomData, Camera.Area area) {
        return convertCameraAreaToActiveArrayRectangle(rect, zoomData, area, true);
    }

    private static WeightedRectangle convertCameraAreaToActiveArrayRectangle(Rect rect, ZoomData zoomData, Camera.Area area, boolean z) {
        Rect rect2 = zoomData.previewCrop;
        Rect rect3 = zoomData.reportedCrop;
        float width = (rect2.width() * 1.0f) / 2000.0f;
        float height = (rect2.height() * 1.0f) / 2000.0f;
        Matrix matrix = new Matrix();
        matrix.setTranslate(1000.0f, 1000.0f);
        matrix.postScale(width, height);
        matrix.postTranslate(rect2.left, rect2.top);
        if (!z) {
            rect2 = rect3;
        }
        Rect mapRect = ParamsUtils.mapRect(matrix, area.rect);
        if (!mapRect.intersect(rect2)) {
            mapRect.set(RECTANGLE_EMPTY);
        }
        if (area.weight < 0) {
            Log.w(TAG, "convertCameraAreaToMeteringRectangle - rectangle " + stringFromArea(area) + " has too small weight, clip to 0");
        }
        return new WeightedRectangle(mapRect, area.weight);
    }

    private static Point convertCameraPointToActiveArrayPoint(Rect rect, ZoomData zoomData, Point point, boolean z) {
        WeightedRectangle convertCameraAreaToActiveArrayRectangle = convertCameraAreaToActiveArrayRectangle(rect, zoomData, new Camera.Area(new Rect(point.x, point.y, point.x, point.y), 1), z);
        return new Point(convertCameraAreaToActiveArrayRectangle.rect.left, convertCameraAreaToActiveArrayRectangle.rect.top);
    }

    public static Face convertFaceFromLegacy(Camera.Face face, Rect rect, ZoomData zoomData) {
        Preconditions.checkNotNull(face, "face must not be null");
        WeightedRectangle convertCameraAreaToActiveArrayRectangle = convertCameraAreaToActiveArrayRectangle(rect, zoomData, new Camera.Area(face.rect, 1));
        Point point = face.leftEye;
        Point point2 = face.rightEye;
        Point point3 = face.mouth;
        if (point == null || point2 == null || point3 == null || point.x == -2000 || point.y == -2000 || point2.x == -2000 || point2.y == -2000 || point3.x == -2000 || point3.y == -2000) {
            return convertCameraAreaToActiveArrayRectangle.toFace();
        }
        Point convertCameraPointToActiveArrayPoint = convertCameraPointToActiveArrayPoint(rect, zoomData, point, true);
        return convertCameraAreaToActiveArrayRectangle.toFace(face.id, convertCameraPointToActiveArrayPoint, convertCameraPointToActiveArrayPoint(rect, zoomData, convertCameraPointToActiveArrayPoint, true), convertCameraPointToActiveArrayPoint(rect, zoomData, convertCameraPointToActiveArrayPoint, true));
    }

    public static MeteringData convertMeteringRectangleToLegacy(Rect rect, MeteringRectangle meteringRectangle, ZoomData zoomData) {
        Camera.Area area;
        Rect rect2 = zoomData.previewCrop;
        float width = 2000.0f / rect2.width();
        float height = 2000.0f / rect2.height();
        Matrix matrix = new Matrix();
        matrix.setTranslate(-rect2.left, -rect2.top);
        matrix.postScale(width, height);
        matrix.postTranslate(-1000.0f, -1000.0f);
        Rect mapRect = ParamsUtils.mapRect(matrix, meteringRectangle.getRect());
        Rect rect3 = new Rect(mapRect);
        if (rect3.intersect(NORMALIZED_RECTANGLE_DEFAULT)) {
            area = new Camera.Area(rect3, meteringRectangle.getMeteringWeight());
        } else {
            Log.w(TAG, "convertMeteringRectangleToLegacy - metering rectangle too small, no metering will be done");
            rect3.set(RECTANGLE_EMPTY);
            area = new Camera.Area(RECTANGLE_EMPTY, 0);
        }
        Rect rect4 = meteringRectangle.getRect();
        if (!rect4.intersect(rect2)) {
            rect4.set(RECTANGLE_EMPTY);
        }
        Rect rect5 = convertCameraAreaToActiveArrayRectangle(rect, zoomData, new Camera.Area(mapRect, meteringRectangle.getMeteringWeight()), false).rect;
        if (VERBOSE) {
            Log.v(TAG, String.format("convertMeteringRectangleToLegacy - activeArray = %s, meteringRect = %s, previewCrop = %s, meteringArea = %s, previewMetering = %s, reportedMetering = %s, normalizedRegionUnbounded = %s", rect, meteringRectangle, rect2, stringFromArea(area), rect4, rect5, mapRect));
        }
        return new MeteringData(area, rect4, rect5);
    }

    public static ZoomData convertScalerCropRegion(Rect rect, Rect rect2, Size size, Camera.Parameters parameters) {
        Rect rect3 = new Rect(0, 0, rect.width(), rect.height());
        Rect rect4 = rect2;
        if (rect2 == null) {
            rect4 = rect3;
        }
        if (VERBOSE) {
            Log.v(TAG, "convertScalerCropRegion - user crop region was " + rect4);
        }
        Rect rect5 = new Rect();
        Rect rect6 = new Rect();
        int closestAvailableZoomCrop = getClosestAvailableZoomCrop(parameters, rect3, size, rect4, rect5, rect6);
        if (VERBOSE) {
            Log.v(TAG, "convertScalerCropRegion - zoom calculated to: zoomIndex = " + closestAvailableZoomCrop + ", reported crop region = " + rect5 + ", preview crop region = " + rect6);
        }
        return new ZoomData(closestAvailableZoomCrop, rect6, rect5);
    }

    public static Size convertSize(Camera.Size size) {
        Preconditions.checkNotNull(size, "size must not be null");
        return new Size(size.width, size.height);
    }

    public static List<Size> convertSizeList(List<Camera.Size> list) {
        Preconditions.checkNotNull(list, "sizeList must not be null");
        ArrayList arrayList = new ArrayList(list.size());
        for (Camera.Size size : list) {
            arrayList.add(new Size(size.width, size.height));
        }
        return arrayList;
    }

    public static Size[] convertSizeListToArray(List<Camera.Size> list) {
        Preconditions.checkNotNull(list, "sizeList must not be null");
        Size[] sizeArr = new Size[list.size()];
        int i = 0;
        for (Camera.Size size : list) {
            sizeArr[i] = new Size(size.width, size.height);
            i++;
        }
        return sizeArr;
    }

    private static List<Rect> getAvailableCropRectangles(Camera.Parameters parameters, Rect rect, Size size) {
        ArrayList arrayList;
        Preconditions.checkNotNull(parameters, "params must not be null");
        Preconditions.checkNotNull(rect, "activeArray must not be null");
        Preconditions.checkNotNull(size, "streamSize must not be null");
        Rect previewCropRectangleUnzoomed = getPreviewCropRectangleUnzoomed(rect, size);
        if (parameters.isZoomSupported()) {
            ArrayList arrayList2 = new ArrayList(parameters.getMaxZoom() + 1);
            Matrix matrix = new Matrix();
            RectF rectF = new RectF();
            Iterator<Integer> it = parameters.getZoomRatios().iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                float intValue = 100.0f / it.next().intValue();
                ParamsUtils.convertRectF(previewCropRectangleUnzoomed, rectF);
                matrix.setScale(intValue, intValue, rect.exactCenterX(), rect.exactCenterY());
                matrix.mapRect(rectF);
                arrayList2.add(ParamsUtils.createRect(rectF));
            }
        } else {
            arrayList = new ArrayList(Arrays.asList(previewCropRectangleUnzoomed));
        }
        return arrayList;
    }

    public static List<Rect> getAvailablePreviewZoomCropRectangles(Camera.Parameters parameters, Rect rect, Size size) {
        Preconditions.checkNotNull(parameters, "params must not be null");
        Preconditions.checkNotNull(rect, "activeArray must not be null");
        Preconditions.checkNotNull(size, "previewSize must not be null");
        return getAvailableCropRectangles(parameters, rect, size);
    }

    public static List<Rect> getAvailableZoomCropRectangles(Camera.Parameters parameters, Rect rect) {
        Preconditions.checkNotNull(parameters, "params must not be null");
        Preconditions.checkNotNull(rect, "activeArray must not be null");
        return getAvailableCropRectangles(parameters, rect, ParamsUtils.createSize(rect));
    }

    public static int getClosestAvailableZoomCrop(Camera.Parameters parameters, Rect rect, Size size, Rect rect2, Rect rect3, Rect rect4) {
        Preconditions.checkNotNull(parameters, "params must not be null");
        Preconditions.checkNotNull(rect, "activeArray must not be null");
        Preconditions.checkNotNull(size, "streamSize must not be null");
        Preconditions.checkNotNull(rect3, "reportedCropRegion must not be null");
        Preconditions.checkNotNull(rect4, "previewCropRegion must not be null");
        Rect rect5 = new Rect(rect2);
        if (!rect5.intersect(rect)) {
            Log.w(TAG, "getClosestAvailableZoomCrop - Crop region out of range; setting to active array size");
            rect5.set(rect);
        }
        Rect previewCropRectangleUnzoomed = getPreviewCropRectangleUnzoomed(rect, size);
        Rect shrinkToSameAspectRatioCentered = shrinkToSameAspectRatioCentered(previewCropRectangleUnzoomed, rect5);
        if (VERBOSE) {
            Log.v(TAG, "getClosestAvailableZoomCrop - actualCrop = " + rect5);
            Log.v(TAG, "getClosestAvailableZoomCrop - previewCrop = " + previewCropRectangleUnzoomed);
            Log.v(TAG, "getClosestAvailableZoomCrop - cropRegionAsPreview = " + shrinkToSameAspectRatioCentered);
        }
        int i = -1;
        List<Rect> availableZoomCropRectangles = getAvailableZoomCropRectangles(parameters, rect);
        List<Rect> availablePreviewZoomCropRectangles = getAvailablePreviewZoomCropRectangles(parameters, rect, size);
        if (VERBOSE) {
            Log.v(TAG, "getClosestAvailableZoomCrop - availableReportedCropRegions = " + ListUtils.listToString(availableZoomCropRectangles));
            Log.v(TAG, "getClosestAvailableZoomCrop - availablePreviewCropRegions = " + ListUtils.listToString(availablePreviewZoomCropRectangles));
        }
        if (availableZoomCropRectangles.size() != availablePreviewZoomCropRectangles.size()) {
            throw new AssertionError("available reported/preview crop region size mismatch");
        }
        Rect rect6 = null;
        Rect rect7 = null;
        for (int i2 = 0; i2 < availableZoomCropRectangles.size(); i2++) {
            Rect rect8 = availablePreviewZoomCropRectangles.get(i2);
            Rect rect9 = availableZoomCropRectangles.get(i2);
            if (!(i == -1 ? true : rect8.width() >= shrinkToSameAspectRatioCentered.width() && rect8.height() >= shrinkToSameAspectRatioCentered.height())) {
                break;
            }
            rect7 = rect8;
            rect6 = rect9;
            i = i2;
        }
        if (i == -1) {
            throw new AssertionError("Should've found at least one valid zoom index");
        }
        rect3.set(rect6);
        rect4.set(rect7);
        return i;
    }

    public static Size getLargestSupportedJpegSizeByArea(Camera.Parameters parameters) {
        Preconditions.checkNotNull(parameters, "params must not be null");
        return android.hardware.camera2.utils.SizeAreaComparator.findLargestByArea(convertSizeList(parameters.getSupportedPictureSizes()));
    }

    public static float getMaxZoomRatio(Camera.Parameters parameters) {
        if (parameters.isZoomSupported()) {
            List<Integer> zoomRatios = parameters.getZoomRatios();
            return (zoomRatios.get(zoomRatios.size() - 1).intValue() * 1.0f) / 100.0f;
        }
        return 1.0f;
    }

    private static Rect getPreviewCropRectangleUnzoomed(Rect rect, Size size) {
        float width;
        float f;
        if (size.getWidth() > rect.width()) {
            throw new IllegalArgumentException("previewSize must not be wider than activeArray");
        }
        if (size.getHeight() > rect.height()) {
            throw new IllegalArgumentException("previewSize must not be taller than activeArray");
        }
        float width2 = (size.getWidth() * 1.0f) / size.getHeight();
        if (width2 < (rect.width() * 1.0f) / rect.height()) {
            f = rect.height();
            width = f * width2;
        } else {
            width = rect.width();
            f = width / width2;
        }
        Matrix matrix = new Matrix();
        RectF rectF = new RectF(0.0f, 0.0f, width, f);
        matrix.setTranslate(rect.exactCenterX(), rect.exactCenterY());
        matrix.postTranslate(-rectF.centerX(), -rectF.centerY());
        matrix.mapRect(rectF);
        return ParamsUtils.createRect(rectF);
    }

    private static SizeF getZoomRatio(Size size, Size size2) {
        Preconditions.checkNotNull(size, "activeArraySize must not be null");
        Preconditions.checkNotNull(size2, "cropSize must not be null");
        Preconditions.checkArgumentPositive(size2.getWidth(), "cropSize.width must be positive");
        Preconditions.checkArgumentPositive(size2.getHeight(), "cropSize.height must be positive");
        return new SizeF((size.getWidth() * 1.0f) / size2.getWidth(), (size.getHeight() * 1.0f) / size2.getHeight());
    }

    private static Rect shrinkToSameAspectRatioCentered(Rect rect, Rect rect2) {
        float width;
        float f;
        float width2 = (rect2.width() * 1.0f) / rect2.height();
        if (width2 < (rect.width() * 1.0f) / rect.height()) {
            f = rect.height();
            width = f * width2;
        } else {
            width = rect.width();
            f = width / width2;
        }
        Matrix matrix = new Matrix();
        RectF rectF = new RectF(rect2);
        matrix.setScale(width / rect.width(), f / rect.height(), rect2.exactCenterX(), rect2.exactCenterY());
        matrix.mapRect(rectF);
        return ParamsUtils.createRect(rectF);
    }

    public static String stringFromArea(Camera.Area area) {
        if (area == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Rect rect = area.rect;
        sb.setLength(0);
        sb.append("([");
        sb.append(rect.left);
        sb.append(',');
        sb.append(rect.top);
        sb.append("][");
        sb.append(rect.right);
        sb.append(',');
        sb.append(rect.bottom);
        sb.append(']');
        sb.append(',');
        sb.append(area.weight);
        sb.append(')');
        return sb.toString();
    }

    public static String stringFromAreaList(List<Camera.Area> list) {
        StringBuilder sb = new StringBuilder();
        if (list == null) {
            return null;
        }
        int i = 0;
        for (Camera.Area area : list) {
            if (area == null) {
                sb.append(b.l);
            } else {
                sb.append(stringFromArea(area));
            }
            if (i != list.size() - 1) {
                sb.append(", ");
            }
            i++;
        }
        return sb.toString();
    }
}
