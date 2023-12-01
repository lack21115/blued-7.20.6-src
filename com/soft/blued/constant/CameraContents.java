package com.soft.blued.constant;

import com.soft.blued.ui.login_register.AdultVerifyFragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/constant/CameraContents.class */
public class CameraContents {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f28311a = Executors.newSingleThreadExecutor();
    public static String b = "camera_background_thread";

    /* renamed from: c  reason: collision with root package name */
    public static String f28312c = "face_";
    public static final SimpleDateFormat d = new SimpleDateFormat("yy_MM_dd_HH-mm_ss");
    public static AdultVerifyFragment.AV_START_PAGE e;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/constant/CameraContents$From.class */
    public interface From {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/constant/CameraContents$FromDef.class */
    public @interface FromDef {
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/constant/CameraContents$INTENT_DATA_KEY.class */
    public interface INTENT_DATA_KEY {
    }
}
