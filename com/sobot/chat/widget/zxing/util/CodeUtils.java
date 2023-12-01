package com.sobot.chat.widget.zxing.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.BinaryBitmap;
import com.sobot.chat.widget.zxing.DecodeHintType;
import com.sobot.chat.widget.zxing.EncodeHintType;
import com.sobot.chat.widget.zxing.MultiFormatReader;
import com.sobot.chat.widget.zxing.MultiFormatWriter;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.RGBLuminanceSource;
import com.sobot.chat.widget.zxing.Result;
import com.sobot.chat.widget.zxing.WriterException;
import com.sobot.chat.widget.zxing.common.BitMatrix;
import com.sobot.chat.widget.zxing.common.GlobalHistogramBinarizer;
import com.sobot.chat.widget.zxing.common.HybridBinarizer;
import com.sobot.chat.widget.zxing.multi.qrcode.QRCodeMultiReader;
import com.sobot.chat.widget.zxing.qrcode.QRCodeReader;
import com.sobot.chat.widget.zxing.qrcode.QRCodeWriter;
import com.sobot.chat.widget.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/util/CodeUtils.class */
public class CodeUtils {
    private CodeUtils() {
        throw new AssertionError();
    }

    private static Bitmap addCode(Bitmap bitmap, String str, int i, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height + i + (i3 * 2), Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(i);
            textPaint.setColor(i2);
            textPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(str, width / 2, height + (i / 2) + i3, textPaint);
            canvas.save();
            canvas.restore();
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Bitmap addLogo(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 != 0 && height2 != 0) {
            float f = ((width * 1.0f) / 6.0f) / width2;
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                canvas.scale(f, f, width / 2, height / 2);
                canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
                canvas.save();
                canvas.restore();
                return createBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap compressBitmap(java.lang.String r3) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = 1
            r6 = r0
            r0 = r8
            r1 = 1
            r0.inJustDecodeBounds = r1
            r0 = r3
            r1 = r8
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r1)
            r0 = r8
            int r0 = r0.outWidth
            r5 = r0
            r0 = r8
            int r0 = r0.outHeight
            r7 = r0
            r0 = r5
            r1 = r7
            if (r0 <= r1) goto L43
            r0 = r5
            float r0 = (float) r0
            r1 = 1145569280(0x44480000, float:800.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L43
            r0 = r8
            int r0 = r0.outWidth
            float r0 = (float) r0
            r1 = 1145569280(0x44480000, float:800.0)
            float r0 = r0 / r1
            r4 = r0
        L3d:
            r0 = r4
            int r0 = (int) r0
            r5 = r0
            goto L61
        L43:
            r0 = r5
            r1 = r7
            if (r0 >= r1) goto L5f
            r0 = r7
            float r0 = (float) r0
            r1 = 1139802112(0x43f00000, float:480.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L5f
            r0 = r8
            int r0 = r0.outHeight
            float r0 = (float) r0
            r1 = 1139802112(0x43f00000, float:480.0)
            float r0 = r0 / r1
            r4 = r0
            goto L3d
        L5f:
            r0 = 1
            r5 = r0
        L61:
            r0 = r5
            if (r0 > 0) goto L6a
            r0 = r6
            r5 = r0
            goto L6a
        L6a:
            r0 = r8
            r1 = r5
            r0.inSampleSize = r1
            r0 = r8
            r1 = 0
            r0.inJustDecodeBounds = r1
            r0 = r3
            r1 = r8
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.util.CodeUtils.compressBitmap(java.lang.String):android.graphics.Bitmap");
    }

    public static Bitmap createBarCode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return createBarCode(str, barcodeFormat, i, i2, null);
    }

    public static Bitmap createBarCode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        return createBarCode(str, barcodeFormat, i, i2, map, false, 40, -16777216);
    }

    public static Bitmap createBarCode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map, boolean z) {
        return createBarCode(str, barcodeFormat, i, i2, map, z, 40, -16777216);
    }

    public static Bitmap createBarCode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map, boolean z, int i3, int i4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            BitMatrix encode = new MultiFormatWriter().encode(str, barcodeFormat, i, i2, map);
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[width * height];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= height) {
                    break;
                }
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 < width) {
                        iArr[(i6 * width) + i8] = encode.get(i8, i6) ? -16777216 : -1;
                        i7 = i8 + 1;
                    }
                }
                i5 = i6 + 1;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return z ? addCode(createBitmap, str, i3, i4, i3 / 2) : createBitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap createQRCode(String str, int i) {
        return createQRCode(str, i, null);
    }

    public static Bitmap createQRCode(String str, int i, Bitmap bitmap) {
        HashMap hashMap = new HashMap();
        hashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hashMap.put(EncodeHintType.MARGIN, 1);
        return createQRCode(str, i, bitmap, hashMap);
    }

    public static Bitmap createQRCode(String str, int i, Bitmap bitmap, Map<EncodeHintType, ?> map) {
        try {
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i, i, map);
            int[] iArr = new int[i * i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < i) {
                        if (encode.get(i5, i3)) {
                            iArr[(i3 * i) + i5] = -16777216;
                        } else {
                            iArr[(i3 * i) + i5] = -1;
                        }
                        i4 = i5 + 1;
                    }
                }
                i2 = i3 + 1;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
            Bitmap bitmap2 = createBitmap;
            if (bitmap != null) {
                bitmap2 = addLogo(createBitmap, bitmap);
            }
            return bitmap2;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static RGBLuminanceSource getRGBLuminanceSource(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        return new RGBLuminanceSource(width, height, iArr);
    }

    public static String parseCode(String str) {
        HashMap hashMap = new HashMap();
        Vector vector = new Vector();
        vector.addAll(DecodeFormatManager.ONE_D_FORMATS);
        vector.addAll(DecodeFormatManager.QR_CODE_FORMATS);
        vector.addAll(DecodeFormatManager.DATA_MATRIX_FORMATS);
        vector.addAll(DecodeFormatManager.AZTEC_FORMATS);
        vector.addAll(DecodeFormatManager.PDF417_FORMATS);
        hashMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        hashMap.put(DecodeHintType.POSSIBLE_FORMATS, vector);
        return parseCode(str, hashMap);
    }

    public static String parseCode(String str, Map<DecodeHintType, Object> map) {
        Result result;
        try {
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            multiFormatReader.setHints(map);
            RGBLuminanceSource rGBLuminanceSource = getRGBLuminanceSource(compressBitmap(str));
            if (rGBLuminanceSource != null) {
                try {
                    result = multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(rGBLuminanceSource)));
                } catch (Exception e) {
                    try {
                        result = multiFormatReader.decodeWithState(new BinaryBitmap(new GlobalHistogramBinarizer(rGBLuminanceSource)));
                    } catch (Exception e2) {
                        result = null;
                    }
                }
                multiFormatReader.reset();
            } else {
                result = null;
            }
            return result.getText();
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Result[] parseMultiQRCode(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DecodeHintType.CHARACTER_SET, "utf-8");
        return parseMultiQRCode(str, hashMap);
    }

    public static Result[] parseMultiQRCode(String str, Map<DecodeHintType, ?> map) {
        Result[] resultArr;
        try {
            QRCodeMultiReader qRCodeMultiReader = new QRCodeMultiReader();
            RGBLuminanceSource rGBLuminanceSource = getRGBLuminanceSource(compressBitmap(str));
            if (rGBLuminanceSource != null) {
                try {
                    resultArr = qRCodeMultiReader.decodeMultiple(new BinaryBitmap(new HybridBinarizer(rGBLuminanceSource)), map);
                } catch (Exception e) {
                    try {
                        resultArr = qRCodeMultiReader.decodeMultiple(new BinaryBitmap(new GlobalHistogramBinarizer(rGBLuminanceSource)));
                    } catch (NotFoundException e2) {
                        resultArr = null;
                    }
                }
                qRCodeMultiReader.reset();
                return resultArr;
            }
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String parseQRCode(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DecodeHintType.CHARACTER_SET, "utf-8");
        return parseQRCode(str, hashMap);
    }

    public static String parseQRCode(String str, Map<DecodeHintType, ?> map) {
        Result result;
        try {
            QRCodeReader qRCodeReader = new QRCodeReader();
            RGBLuminanceSource rGBLuminanceSource = getRGBLuminanceSource(compressBitmap(str));
            if (rGBLuminanceSource != null) {
                try {
                    result = qRCodeReader.decode(new BinaryBitmap(new HybridBinarizer(rGBLuminanceSource)), map);
                } catch (Exception e) {
                    try {
                        result = qRCodeReader.decode(new BinaryBitmap(new GlobalHistogramBinarizer(rGBLuminanceSource)));
                    } catch (NotFoundException e2) {
                        result = null;
                    }
                }
                qRCodeReader.reset();
            } else {
                result = null;
            }
            return result.getText();
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
