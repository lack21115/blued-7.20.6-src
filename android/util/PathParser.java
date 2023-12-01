package android.util;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/util/PathParser.class */
public class PathParser {
    static final String LOGTAG = PathParser.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/util/PathParser$ExtractFloatResult.class */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        private ExtractFloatResult() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/util/PathParser$PathDataNode.class */
    public static class PathDataNode {
        private float[] mParams;
        private char mType;

        private PathDataNode(char c2, float[] fArr) {
            this.mType = c2;
            this.mParams = fArr;
        }

        private PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            this.mParams = Arrays.copyOf(pathDataNode.mParams, pathDataNode.mParams.length);
        }

        private static void addCommand(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            float f;
            float f2;
            float f3;
            int i = 2;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            float f7 = fArr[3];
            float f8 = fArr[4];
            float f9 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    f4 = f8;
                    f5 = f9;
                    f6 = f8;
                    f7 = f9;
                    path.moveTo(f4, f5);
                    break;
            }
            char c4 = c2;
            int i2 = 0;
            float f10 = f9;
            float f11 = f8;
            float f12 = f7;
            float f13 = f6;
            while (i2 < fArr2.length) {
                switch (c3) {
                    case 'A':
                        drawArc(path, f4, f5, fArr2[i2 + 5], fArr2[i2 + 6], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f4 = fArr2[i2 + 5];
                        f5 = fArr2[i2 + 6];
                        f = f4;
                        f2 = f5;
                        f3 = f10;
                        break;
                    case 'C':
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        f4 = fArr2[i2 + 4];
                        f5 = fArr2[i2 + 5];
                        f = fArr2[i2 + 2];
                        f2 = fArr2[i2 + 3];
                        f3 = f10;
                        break;
                    case 'H':
                        path.lineTo(fArr2[i2 + 0], f5);
                        f4 = fArr2[i2 + 0];
                        f = f13;
                        f2 = f12;
                        f3 = f10;
                        break;
                    case 'L':
                        path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f4 = fArr2[i2 + 0];
                        f5 = fArr2[i2 + 1];
                        f = f13;
                        f2 = f12;
                        f3 = f10;
                        break;
                    case 'M':
                        path.moveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f4 = fArr2[i2 + 0];
                        f5 = fArr2[i2 + 1];
                        f11 = f4;
                        f3 = f5;
                        f = f13;
                        f2 = f12;
                        break;
                    case 'Q':
                        path.quadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f = fArr2[i2 + 0];
                        f2 = fArr2[i2 + 1];
                        f4 = fArr2[i2 + 2];
                        f5 = fArr2[i2 + 3];
                        f3 = f10;
                        break;
                    case 'S':
                        float f14 = f4;
                        float f15 = f5;
                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                            f14 = (2.0f * f4) - f13;
                            f15 = (2.0f * f5) - f12;
                        }
                        path.cubicTo(f14, f15, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f = fArr2[i2 + 0];
                        f2 = fArr2[i2 + 1];
                        f4 = fArr2[i2 + 2];
                        f5 = fArr2[i2 + 3];
                        f3 = f10;
                        break;
                    case 'T':
                        float f16 = f4;
                        float f17 = f5;
                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                            f16 = (2.0f * f4) - f13;
                            f17 = (2.0f * f5) - f12;
                        }
                        path.quadTo(f16, f17, fArr2[i2 + 0], fArr2[i2 + 1]);
                        float f18 = f17;
                        float f19 = fArr2[i2 + 0];
                        f5 = fArr2[i2 + 1];
                        f = f16;
                        f2 = f18;
                        f3 = f10;
                        f4 = f19;
                        break;
                    case 'V':
                        path.lineTo(f4, fArr2[i2 + 0]);
                        f5 = fArr2[i2 + 0];
                        f = f13;
                        f2 = f12;
                        f3 = f10;
                        break;
                    case 'a':
                        drawArc(path, f4, f5, fArr2[i2 + 5] + f4, fArr2[i2 + 6] + f5, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f4 += fArr2[i2 + 5];
                        f5 += fArr2[i2 + 6];
                        f = f4;
                        f2 = f5;
                        f3 = f10;
                        break;
                    case 'c':
                        path.rCubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        f = f4 + fArr2[i2 + 2];
                        f2 = f5 + fArr2[i2 + 3];
                        f4 += fArr2[i2 + 4];
                        f5 += fArr2[i2 + 5];
                        f3 = f10;
                        break;
                    case 'h':
                        path.rLineTo(fArr2[i2 + 0], 0.0f);
                        f4 += fArr2[i2 + 0];
                        f = f13;
                        f2 = f12;
                        f3 = f10;
                        break;
                    case 'l':
                        path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f4 += fArr2[i2 + 0];
                        f5 += fArr2[i2 + 1];
                        f = f13;
                        f2 = f12;
                        f3 = f10;
                        break;
                    case 'm':
                        path.rMoveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f4 += fArr2[i2 + 0];
                        f5 += fArr2[i2 + 1];
                        f11 = f4;
                        f3 = f5;
                        f = f13;
                        f2 = f12;
                        break;
                    case 'q':
                        path.rQuadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f = f4 + fArr2[i2 + 0];
                        f2 = f5 + fArr2[i2 + 1];
                        f4 += fArr2[i2 + 2];
                        f5 += fArr2[i2 + 3];
                        f3 = f10;
                        break;
                    case 's':
                        float f20 = 0.0f;
                        float f21 = 0.0f;
                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                            f20 = f4 - f13;
                            f21 = f5 - f12;
                        }
                        path.rCubicTo(f20, f21, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f = f4 + fArr2[i2 + 0];
                        f2 = f5 + fArr2[i2 + 1];
                        f4 += fArr2[i2 + 2];
                        f5 += fArr2[i2 + 3];
                        f3 = f10;
                        break;
                    case 't':
                        float f22 = 0.0f;
                        float f23 = 0.0f;
                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                            f22 = f4 - f13;
                            f23 = f5 - f12;
                        }
                        path.rQuadTo(f22, f23, fArr2[i2 + 0], fArr2[i2 + 1]);
                        float f24 = f4 + f22;
                        float f25 = f5 + f23;
                        f4 += fArr2[i2 + 0];
                        f5 += fArr2[i2 + 1];
                        f = f24;
                        f2 = f25;
                        f3 = f10;
                        break;
                    case 'v':
                        path.rLineTo(0.0f, fArr2[i2 + 0]);
                        f5 += fArr2[i2 + 0];
                        f = f13;
                        f2 = f12;
                        f3 = f10;
                        break;
                    default:
                        f3 = f10;
                        f2 = f12;
                        f = f13;
                        break;
                }
                c4 = c3;
                i2 += i;
                f13 = f;
                f12 = f2;
                f10 = f3;
            }
            fArr[0] = f4;
            fArr[1] = f5;
            fArr[2] = f13;
            fArr[3] = f12;
            fArr[4] = f11;
            fArr[5] = f10;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int abs = Math.abs((int) Math.ceil((4.0d * d9) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d10 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos2);
            double d11 = ((-d3) * sin * sin2) + (d4 * cos * cos2);
            double d12 = d9 / abs;
            double d13 = d6;
            double d14 = d5;
            double d15 = d8;
            double d16 = d11;
            double d17 = d10;
            for (int i = 0; i < abs; i++) {
                double d18 = d15 + d12;
                double sin3 = Math.sin(d18);
                double cos3 = Math.cos(d18);
                double d19 = (((d3 * cos) * cos3) + d) - ((d4 * sin) * sin3);
                double d20 = (d3 * sin * cos3) + d2 + (d4 * cos * sin3);
                double d21 = (((-d3) * cos) * sin3) - ((d4 * sin) * cos3);
                double d22 = ((-d3) * sin * sin3) + (d4 * cos * cos3);
                double tan = Math.tan((d18 - d15) / 2.0d);
                double sin4 = (Math.sin(d18 - d15) * (Math.sqrt(4.0d + ((3.0d * tan) * tan)) - 1.0d)) / 3.0d;
                path.cubicTo((float) (d14 + (sin4 * d17)), (float) (d13 + (sin4 * d16)), (float) (d19 - (sin4 * d21)), (float) (d20 - (sin4 * d22)), (float) d19, (float) d20);
                d15 = d18;
                d14 = d19;
                d13 = d20;
                d17 = d21;
                d16 = d22;
            }
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = ((f * cos) + (f2 * sin)) / f5;
            double d4 = (((-f) * sin) + (f2 * cos)) / f6;
            double d5 = ((f3 * cos) + (f4 * sin)) / f5;
            double d6 = (((-f3) * sin) + (f4 * cos)) / f6;
            double d7 = d3 - d5;
            double d8 = d4 - d6;
            double d9 = (d3 + d5) / 2.0d;
            double d10 = (d4 + d6) / 2.0d;
            double d11 = (d7 * d7) + (d8 * d8);
            if (d11 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d12 = (1.0d / d11) - 0.25d;
            if (d12 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d11);
                float sqrt = (float) (Math.sqrt(d11) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d12);
            double d13 = sqrt2 * d7;
            double d14 = sqrt2 * d8;
            if (z == z2) {
                d = d9 - d14;
                d2 = d10 + d13;
            } else {
                d = d9 + d14;
                d2 = d10 - d13;
            }
            double atan2 = Math.atan2(d4 - d2, d3 - d);
            double atan22 = Math.atan2(d6 - d2, d5 - d) - atan2;
            double d15 = atan22;
            if (z2 != (atan22 >= 0.0d)) {
                d15 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d16 = d * f5;
            double d17 = d2 * f6;
            arcToBezier(path, (d16 * cos) - (d17 * sin), (d16 * sin) + (d17 * cos), f5, f6, f, f2, radians, atan2, d15);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= pathDataNodeArr.length) {
                    return;
                }
                addCommand(path, fArr, c2, pathDataNodeArr[i2].mType, pathDataNodeArr[i2].mParams);
                c2 = pathDataNodeArr[i2].mType;
                i = i2 + 1;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= pathDataNode.mParams.length) {
                    return;
                }
                this.mParams[i2] = (pathDataNode.mParams[i2] * (1.0f - f)) + (pathDataNode2.mParams[i2] * f);
                i = i2 + 1;
            }
        }
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c2, float[] fArr) {
        arrayList.add(new PathDataNode(c2, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pathDataNodeArr.length) {
                return true;
            }
            if (pathDataNodeArr[i2].mType != pathDataNodeArr2[i2].mType || pathDataNodeArr[i2].mParams.length != pathDataNodeArr2[i2].mParams.length) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int i2 = 1;
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            int nextStart = nextStart(str, i2);
            String trim = str.substring(i, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i = nextStart;
            i2 = nextStart + 1;
        }
        if (i2 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData != null) {
            try {
                PathDataNode.nodesToPath(createNodesFromPathData, path);
                return path;
            } catch (RuntimeException e) {
                throw new RuntimeException("Error in parsing " + str, e);
            }
        }
        return null;
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2;
        if (pathDataNodeArr != null) {
            PathDataNode[] pathDataNodeArr3 = new PathDataNode[pathDataNodeArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                pathDataNodeArr2 = pathDataNodeArr3;
                if (i2 >= pathDataNodeArr.length) {
                    break;
                }
                pathDataNodeArr3[i2] = new PathDataNode(pathDataNodeArr[i2]);
                i = i2 + 1;
            }
        } else {
            pathDataNodeArr2 = null;
        }
        return pathDataNodeArr2;
    }

    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        boolean z;
        boolean z2;
        boolean z3;
        int i2 = i;
        boolean z4 = false;
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z5 = false;
        boolean z6 = false;
        while (i2 < str.length()) {
            switch (str.charAt(i2)) {
                case ' ':
                case ',':
                    z2 = true;
                    z = false;
                    z3 = z5;
                    break;
                case '-':
                    z2 = z4;
                    z = false;
                    z3 = z5;
                    if (i2 != i) {
                        z2 = z4;
                        z = false;
                        z3 = z5;
                        if (!z6) {
                            z2 = true;
                            extractFloatResult.mEndWithNegOrDot = true;
                            z = false;
                            z3 = z5;
                            break;
                        }
                    }
                    break;
                case '.':
                    if (!z5) {
                        z3 = true;
                        z2 = z4;
                        z = false;
                        break;
                    } else {
                        z2 = true;
                        extractFloatResult.mEndWithNegOrDot = true;
                        z = false;
                        z3 = z5;
                        break;
                    }
                case 'E':
                case 'e':
                    z = true;
                    z2 = z4;
                    z3 = z5;
                    break;
                default:
                    z3 = z5;
                    z = false;
                    z2 = z4;
                    break;
            }
            if (z2) {
                extractFloatResult.mEndPosition = i2;
            }
            i2++;
            z4 = z2;
            z6 = z;
            z5 = z3;
        }
        extractFloatResult.mEndPosition = i2;
    }

    private static float[] getFloats(String str) {
        boolean z = true;
        boolean z2 = str.charAt(0) == 'z';
        if (str.charAt(0) != 'Z') {
            z = false;
        }
        if (z2 || z) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            int i = 1;
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    int i4 = i2 + 1;
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2 = i4;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return Arrays.copyOf(fArr, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pathDataNodeArr2.length) {
                return;
            }
            pathDataNodeArr[i2].mType = pathDataNodeArr2[i2].mType;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < pathDataNodeArr2[i2].mParams.length) {
                    pathDataNodeArr[i2].mParams[i4] = pathDataNodeArr2[i2].mParams[i4];
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }
}
