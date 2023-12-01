package com.sensetime.stmobile;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.sensetime.stmobile.model.STEffectBeautyInfo;
import com.sensetime.stmobile.model.STEffectModuleInfo;
import com.sensetime.stmobile.model.STEffectPackageInfo;
import com.sensetime.stmobile.model.STEffectRenderInParam;
import com.sensetime.stmobile.model.STEffectRenderOutParam;
import com.sensetime.stmobile.model.STEffectTryonInfo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileEffectNative.class */
public class STMobileEffectNative {
    public static final int EFFECT_CONFIG_IMAGE_MODE = 2;
    public static final int EFFECT_CONFIG_NONE = 0;
    private STSoundPlay mSoundPlay;
    private long nativeEffectHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    private native int createInstanceNative(int i, String str);

    private native int destroyInstanceNative();

    public static String findLibrary(Context context, String str) {
        Object invoke;
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            try {
                Method method = classLoader.getClass().getMethod("findLibrary", String.class);
                if (method == null || (invoke = method.invoke(classLoader, str)) == null || !(invoke instanceof String)) {
                    return null;
                }
                return (String) invoke;
            } catch (IllegalAccessException e) {
                Log.e("findLibrary1", e.toString());
                return null;
            } catch (IllegalArgumentException e2) {
                Log.e("findLibrary1", e2.toString());
                return null;
            } catch (NoSuchMethodException e3) {
                Log.e("findLibrary1", e3.toString());
                return null;
            } catch (InvocationTargetException e4) {
                Log.e("findLibrary1", e4.toString());
                return null;
            } catch (Exception e5) {
                Log.e("findLibrary1", e5.toString());
                return null;
            }
        }
        return null;
    }

    public static String getFilePath(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.length() > 0) {
                int lastIndexOf = str.lastIndexOf(47);
                str2 = str;
                if (lastIndexOf > -1) {
                    str2 = str;
                    if (lastIndexOf < str.length()) {
                        str2 = str.substring(0, lastIndexOf + 1);
                    }
                }
            }
        }
        return str2;
    }

    public native int addPackage(String str);

    public native int addPackageFromAssetsFile(String str, AssetManager assetManager);

    public native int changePackage(String str);

    public native int changePackageFromAssetsFile(String str, AssetManager assetManager);

    public native void clear();

    public int createInstance(Context context, int i) {
        STSoundPlay sTSoundPlay;
        if (context != null) {
            this.mSoundPlay = STSoundPlay.getInstance(context);
        }
        int createInstanceNative = createInstanceNative(i, "");
        if (createInstanceNative == 0 && (sTSoundPlay = this.mSoundPlay) != null) {
            sTSoundPlay.setEffectHandle(this);
        }
        return createInstanceNative;
    }

    public void destroyInstance() {
        destroyInstanceNative();
        STSoundPlay sTSoundPlay = this.mSoundPlay;
        if (sTSoundPlay != null) {
            sTSoundPlay.release();
            this.mSoundPlay = null;
        }
    }

    public void destroyInstance(boolean z) {
        STSoundPlay sTSoundPlay;
        destroyInstanceNative();
        if (!z || (sTSoundPlay = this.mSoundPlay) == null) {
            return;
        }
        sTSoundPlay.release();
        this.mSoundPlay = null;
    }

    public native long getAnimalDetectConfig();

    public native int getBeautyMode(int i);

    public native float getBeautyStrength(int i);

    public native long getCustomParamConfig();

    public native long getHumanActionDetectConfig();

    public native STEffectModuleInfo getModuleInfo(int i);

    public native STEffectModuleInfo[] getModulesInPackage(int i, int i2);

    public native STEffectBeautyInfo[] getOverlappedBeauty(int i);

    public native int getOverlappedBeautyCount();

    public native STEffectPackageInfo getPackageInfo(int i);

    public native float getParam(int i);

    public native STEffectTryonInfo getTryOnParam(int i);

    public native int releaseCachedResource();

    public native int removeEffect(int i);

    public native int render(STEffectRenderInParam sTEffectRenderInParam, STEffectRenderOutParam sTEffectRenderOutParam, boolean z);

    public native int replayPackage(int i);

    public native int setBeauty(int i, String str);

    public native int setBeautyFromAssetsFile(int i, String str, AssetManager assetManager);

    public native int setBeautyMode(int i, int i2);

    public native int setBeautyParam(int i, float f);

    public native int setBeautyStrength(int i, float f);

    public native int setPackageBeautyGroupStrength(int i, int i2, float f);

    public native int setParam(int i, float f);

    public native int setSoundPlayDone(String str);

    public native int setTryOnParam(STEffectTryonInfo sTEffectTryonInfo, int i);
}
