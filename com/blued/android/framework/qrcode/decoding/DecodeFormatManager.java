package com.blued.android.framework.qrcode.decoding;

import com.google.zxing.BarcodeFormat;
import java.util.Vector;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/decoding/DecodeFormatManager.class */
final class DecodeFormatManager {

    /* renamed from: a  reason: collision with root package name */
    static final Vector<BarcodeFormat> f6666a;
    static final Vector<BarcodeFormat> b;

    /* renamed from: c  reason: collision with root package name */
    static final Vector<BarcodeFormat> f6667c;
    static final Vector<BarcodeFormat> d;
    private static final Pattern e = Pattern.compile(",");

    static {
        Vector<BarcodeFormat> vector = new Vector<>(5);
        f6666a = vector;
        vector.add(BarcodeFormat.UPC_A);
        f6666a.add(BarcodeFormat.UPC_E);
        f6666a.add(BarcodeFormat.EAN_13);
        f6666a.add(BarcodeFormat.EAN_8);
        Vector<BarcodeFormat> vector2 = new Vector<>(f6666a.size() + 4);
        b = vector2;
        vector2.addAll(f6666a);
        b.add(BarcodeFormat.CODE_39);
        b.add(BarcodeFormat.CODE_93);
        b.add(BarcodeFormat.CODE_128);
        b.add(BarcodeFormat.ITF);
        Vector<BarcodeFormat> vector3 = new Vector<>(1);
        f6667c = vector3;
        vector3.add(BarcodeFormat.QR_CODE);
        Vector<BarcodeFormat> vector4 = new Vector<>(1);
        d = vector4;
        vector4.add(BarcodeFormat.DATA_MATRIX);
    }

    private DecodeFormatManager() {
    }
}
