package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/PathParser.class */
public class PathParser {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/PathParser$ExtractFloatResult.class */
    public static class ExtractFloatResult {

        /* renamed from: a  reason: collision with root package name */
        int f2451a;
        boolean b;

        ExtractFloatResult() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/PathParser$PathDataNode.class */
    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        PathDataNode(char c2, float[] fArr) {
            this.mType = c2;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.a(fArr, 0, fArr.length);
        }

        private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d10 = -d3;
            double d11 = d10 * cos;
            double d12 = d4 * sin;
            double d13 = d10 * sin;
            double d14 = d4 * cos;
            double d15 = d9 / ceil;
            double d16 = (sin2 * d13) + (cos2 * d14);
            double d17 = (d11 * sin2) - (d12 * cos2);
            int i = 0;
            double d18 = d8;
            double d19 = d6;
            double d20 = d5;
            while (i < ceil) {
                double d21 = d18 + d15;
                double sin3 = Math.sin(d21);
                double cos3 = Math.cos(d21);
                double d22 = (d + ((d3 * cos) * cos3)) - (d12 * sin3);
                double d23 = d2 + (d3 * sin * cos3) + (d14 * sin3);
                double d24 = (d11 * sin3) - (d12 * cos3);
                double d25 = (sin3 * d13) + (cos3 * d14);
                double d26 = d21 - d18;
                double tan = Math.tan(d26 / 2.0d);
                double sin4 = (Math.sin(d26) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d20 + (d17 * sin4)), (float) (d19 + (d16 * sin4)), (float) (d22 - (sin4 * d24)), (float) (d23 - (sin4 * d25)), (float) d22, (float) d23);
                i++;
                d20 = d22;
                d18 = d21;
                d16 = d25;
                d17 = d24;
                d19 = d23;
            }
        }

        private static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = f;
            double d4 = f2;
            double d5 = f5;
            double d6 = ((d3 * cos) + (d4 * sin)) / d5;
            double d7 = f6;
            double d8 = (((-f) * sin) + (d4 * cos)) / d7;
            double d9 = f4;
            double d10 = ((f3 * cos) + (d9 * sin)) / d5;
            double d11 = (((-f3) * sin) + (d9 * cos)) / d7;
            double d12 = d6 - d10;
            double d13 = d8 - d11;
            double d14 = (d6 + d10) / 2.0d;
            double d15 = (d8 + d11) / 2.0d;
            double d16 = (d12 * d12) + (d13 * d13);
            if (d16 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d17 = (1.0d / d16) - 0.25d;
            if (d17 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d16);
                float sqrt = (float) (Math.sqrt(d16) / 1.99999d);
                a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d17);
            double d18 = d12 * sqrt2;
            double d19 = sqrt2 * d13;
            if (z == z2) {
                d = d14 - d19;
                d2 = d15 + d18;
            } else {
                d = d14 + d19;
                d2 = d15 - d18;
            }
            double atan2 = Math.atan2(d8 - d2, d6 - d);
            double atan22 = Math.atan2(d11 - d2, d10 - d) - atan2;
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            double d20 = atan22;
            if (z2 != (i >= 0)) {
                d20 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d21 = d * d5;
            double d22 = d2 * d7;
            a(path, (d21 * cos) - (d22 * sin), (d21 * sin) + (d22 * cos), d5, d7, d3, d4, radians, atan2, d20);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x03bd, code lost:
            if (r27 == 'T') goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x042c, code lost:
            if (r27 == 'S') goto L102;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(android.graphics.Path r11, float[] r12, char r13, char r14, float[] r15) {
            /*
                Method dump skipped, instructions count: 2178
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.PathDataNode.a(android.graphics.Path, float[], char, char, float[]):void");
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
                a(path, fArr, c2, pathDataNodeArr[i2].mType, pathDataNodeArr[i2].mParams);
                c2 = pathDataNodeArr[i2].mType;
                i = i2 + 1;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                int i2 = i;
                float[] fArr = pathDataNode.mParams;
                if (i2 >= fArr.length) {
                    return;
                }
                this.mParams[i2] = (fArr[i2] * (1.0f - f)) + (pathDataNode2.mParams[i2] * f);
                i = i2 + 1;
            }
        }
    }

    private PathParser() {
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095 A[LOOP:0: B:3:0x0010->B:29:0x0095, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r3, int r4, androidx.core.graphics.PathParser.ExtractFloatResult r5) {
        /*
            r0 = r5
            r1 = 0
            r0.b = r1
            r0 = r4
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r8 = r0
        L10:
            r0 = r7
            r1 = r3
            int r1 = r1.length()
            if (r0 >= r1) goto L9e
            r0 = r3
            r1 = r7
            char r0 = r0.charAt(r1)
            r10 = r0
            r0 = r10
            r1 = 32
            if (r0 == r1) goto L88
            r0 = r10
            r1 = 69
            if (r0 == r1) goto L83
            r0 = r10
            r1 = 101(0x65, float:1.42E-43)
            if (r0 == r1) goto L83
            r0 = r10
            switch(r0) {
                case 44: goto L88;
                case 45: goto L6c;
                case 46: goto L57;
                default: goto L54;
            }
        L54:
            goto L7e
        L57:
            r0 = r9
            if (r0 != 0) goto L64
            r0 = 0
            r6 = r0
            r0 = 1
            r9 = r0
            goto L8d
        L64:
            r0 = r5
            r1 = 1
            r0.b = r1
            goto L88
        L6c:
            r0 = r7
            r1 = r4
            if (r0 == r1) goto L7e
            r0 = r6
            if (r0 != 0) goto L7e
            r0 = r5
            r1 = 1
            r0.b = r1
            goto L88
        L7e:
            r0 = 0
            r6 = r0
            goto L8d
        L83:
            r0 = 1
            r6 = r0
            goto L8d
        L88:
            r0 = 0
            r6 = r0
            r0 = 1
            r8 = r0
        L8d:
            r0 = r8
            if (r0 == 0) goto L95
            goto L9e
        L95:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L10
        L9e:
            r0 = r5
            r1 = r7
            r0.f2451a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.a(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static void a(ArrayList<PathDataNode> arrayList, char c2, float[] fArr) {
        arrayList.add(new PathDataNode(c2, fArr));
    }

    private static float[] a(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= length) {
                    return a(fArr, 0, i3);
                }
                a(str, i, extractFloatResult);
                int i4 = extractFloatResult.f2451a;
                int i5 = i3;
                if (i < i4) {
                    fArr[i3] = Float.parseFloat(str.substring(i, i4));
                    i5 = i3 + 1;
                }
                if (extractFloatResult.b) {
                    i = i4;
                    i2 = i5;
                } else {
                    i = i4 + 1;
                    i2 = i5;
                }
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    static float[] a(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy((Object) fArr, i, (Object) fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
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
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a2 = a(str, i);
            String trim = str.substring(i2, a2).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), a(trim));
            }
            i2 = a2;
            i = a2 + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
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
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pathDataNodeArr.length) {
                return pathDataNodeArr2;
            }
            pathDataNodeArr2[i2] = new PathDataNode(pathDataNodeArr[i2]);
            i = i2 + 1;
        }
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr3 == null) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                for (int i = 0; i < pathDataNodeArr.length; i++) {
                    pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
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
