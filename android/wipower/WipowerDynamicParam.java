package android.wipower;

import android.os.SystemProperties;
import android.util.Log;

/* loaded from: source-4181928-dex2jar.jar:android/wipower/WipowerDynamicParam.class */
public class WipowerDynamicParam {
    private static final float IREG_ADC_TO_mA_RATIO = 4.765625f;
    private static final String LOGTAG = "WipowerDynamicParam";
    private static final int LSB_MASK = 255;
    private static final int MSB_MASK = 65280;
    private static final byte OVP_BIT = Byte.MIN_VALUE;
    private static final short OVP_THRESHHOLD_VAL = 21500;
    private static final float VREG_ADC_TO_mV_RATIO = 95.3125f;
    private static boolean sDebug = false;
    private byte mOptValidity = 0;
    private short mRectVoltage = 0;
    private short mRectCurrent = 0;
    private short mOutputVoltage = 0;
    private short mOutputCurrent = 0;
    private byte mTemperature = 0;
    private short mMinRectVoltageDyn = 0;
    private short mMaxRectVoltageDyn = 0;
    private short mSetRectVoltageDyn = 0;
    private byte mAlert = 0;
    private short mReserved1 = 0;
    private byte mReserved2 = 0;

    public static short IREG_ADC_TO_mA(short s) {
        return (short) (s * IREG_ADC_TO_mA_RATIO);
    }

    public static short VREG_ADC_TO_mV(short s) {
        return (short) (s * VREG_ADC_TO_mV_RATIO);
    }

    private static String toHex(int i) {
        return String.format("0x%8s", Integer.toHexString(i)).replace(' ', '0');
    }

    public static short toUnsigned(byte b) {
        return (short) (b & 255);
    }

    public byte[] getValue() {
        print();
        byte[] bArr = {this.mOptValidity, (byte) (this.mRectVoltage & 255), (byte) ((this.mRectVoltage & 65280) >> 8), (byte) (this.mRectCurrent & 255), (byte) ((this.mRectCurrent & 65280) >> 8), (byte) (this.mOutputVoltage & 255), (byte) ((this.mOutputVoltage & 65280) >> 8), (byte) (this.mOutputCurrent & 255), (byte) ((this.mOutputCurrent & 65280) >> 8), this.mTemperature, (byte) (this.mMinRectVoltageDyn & 255), (byte) ((this.mMinRectVoltageDyn & 65280) >> 8), (byte) (this.mSetRectVoltageDyn & 255), (byte) ((this.mSetRectVoltageDyn & 65280) >> 8), (byte) (this.mMaxRectVoltageDyn & 255), (byte) ((this.mMaxRectVoltageDyn & 65280) >> 8), this.mAlert};
        if ((bArr[16] & Byte.MIN_VALUE) == -128 && this.mRectVoltage < OVP_THRESHHOLD_VAL) {
            bArr[16] = (byte) (bArr[16] & Byte.MAX_VALUE);
        }
        Log.i(LOGTAG, "mPruDynamicParam.getValue");
        return bArr;
    }

    void print() {
        sDebug = SystemProperties.getBoolean("persist.a4wp.logging", false);
        if (sDebug) {
            Log.v(LOGTAG, "mOptValidity " + toHex(this.mOptValidity) + "mRectVoltage " + toHex(this.mRectVoltage) + "mRectCurrent " + toHex(this.mRectCurrent) + "mOutputVoltage " + toHex(this.mOutputVoltage));
        }
        if (sDebug) {
            Log.v(LOGTAG, "mOutputCurrent " + toHex(this.mOutputCurrent) + "mTemperature " + toHex(this.mTemperature) + "mMinRectVoltageDyn " + toHex(this.mMinRectVoltageDyn) + "mMaxRectVoltageDyn " + toHex(this.mMaxRectVoltageDyn));
        }
        if (sDebug) {
            Log.v(LOGTAG, "mSetRectVoltageDyn " + toHex(this.mSetRectVoltageDyn) + "mAlert " + toHex(this.mAlert) + "mReserved1 " + toHex(this.mReserved1) + "mReserved2 " + toHex(this.mReserved2));
        }
    }

    void resetValues() {
        this.mOptValidity = (byte) 0;
        this.mRectVoltage = (short) 0;
        this.mRectCurrent = (short) 0;
        this.mOutputVoltage = (short) 0;
        this.mOutputCurrent = (short) 0;
        this.mTemperature = (byte) 0;
        this.mMinRectVoltageDyn = (short) 0;
        this.mMaxRectVoltageDyn = (short) 0;
        this.mSetRectVoltageDyn = (short) 0;
        this.mAlert = (byte) 0;
        this.mReserved1 = (short) 0;
        this.mReserved2 = (byte) 0;
    }

    public void setValue(byte[] bArr) {
        resetValues();
        this.mOptValidity = bArr[0];
        this.mRectVoltage = toUnsigned(bArr[1]);
        this.mRectVoltage = (short) (this.mRectVoltage | ((short) (toUnsigned(bArr[2]) << 8)));
        this.mRectCurrent = toUnsigned(bArr[3]);
        this.mRectCurrent = (short) (this.mRectCurrent | ((short) (toUnsigned(bArr[4]) << 8)));
        this.mOutputVoltage = toUnsigned(bArr[5]);
        this.mOutputVoltage = (short) (this.mOutputVoltage | ((short) (toUnsigned(bArr[6]) << 8)));
        this.mOutputCurrent = toUnsigned(bArr[7]);
        this.mOutputCurrent = (short) (this.mOutputCurrent | ((short) (toUnsigned(bArr[8]) << 8)));
        this.mTemperature = bArr[9];
        this.mMinRectVoltageDyn = toUnsigned(bArr[10]);
        this.mMinRectVoltageDyn = (short) (this.mMinRectVoltageDyn | ((short) (toUnsigned(bArr[11]) << 8)));
        this.mSetRectVoltageDyn = toUnsigned(bArr[12]);
        this.mSetRectVoltageDyn = (short) (this.mSetRectVoltageDyn | ((short) (toUnsigned(bArr[13]) << 8)));
        this.mMaxRectVoltageDyn = toUnsigned(bArr[14]);
        this.mMaxRectVoltageDyn = (short) (this.mMaxRectVoltageDyn | ((short) (toUnsigned(bArr[15]) << 8)));
        this.mAlert = bArr[16];
        this.mReserved1 = toUnsigned(bArr[17]);
        this.mReserved1 = (short) (toUnsigned(bArr[18]) << 8);
        this.mReserved2 = bArr[19];
        Log.i(LOGTAG, "mPruDynamicParam.setAppValue");
        print();
    }
}
