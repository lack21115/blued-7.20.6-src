package com.blued.android.framework.ui.xpop.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.PositionPopupView;
import com.blued.android.framework.ui.xpop.enums.ImageType;
import com.blued.android.framework.ui.xpop.impl.PartShadowPopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupImageLoader;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/XPopupUtils.class */
public class XPopupUtils {
    private static int a;
    private static Context b;

    /* renamed from: com.blued.android.framework.ui.xpop.util.XPopupUtils$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/XPopupUtils$2.class */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ XPopupImageLoader a;
        final /* synthetic */ Object b;
        final /* synthetic */ Handler c;

        @Override // java.lang.Runnable
        public void run() {
            File a = this.a.a(XPopupUtils.b, this.b);
            if (a == null) {
                this.c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.util.XPopupUtils.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(XPopupUtils.b, "图片不存在！", 0).show();
                        Context unused = XPopupUtils.b = null;
                    }
                });
                return;
            }
            String str = Environment.getExternalStorageDirectory().getAbsolutePath() + BridgeUtil.SPLIT_MARK + Environment.DIRECTORY_PICTURES;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                String b = XPopupUtils.b(ImageHeaderParser.a(new FileInputStream(a)));
                File file2 = new File(str, System.currentTimeMillis() + "." + b);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                XPopupUtils.b(file2, new FileInputStream(a));
                MediaScannerConnection.scanFile(XPopupUtils.b, new String[]{file2.getAbsolutePath()}, new String[]{"image/" + b}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.blued.android.framework.ui.xpop.util.XPopupUtils.2.2
                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                    public void onScanCompleted(String str2, Uri uri) {
                        AnonymousClass2.this.c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.util.XPopupUtils.2.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (XPopupUtils.b != null) {
                                    Toast.makeText(XPopupUtils.b, "已保存到相册！", 0).show();
                                    Context unused = XPopupUtils.b = null;
                                }
                            }
                        });
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                this.c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.util.XPopupUtils.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(XPopupUtils.b, "没有保存权限，保存功能无法使用！", 0).show();
                        Context unused = XPopupUtils.b = null;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.xpop.util.XPopupUtils$3  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/XPopupUtils$3.class */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[ImageType.values().length];
            a = iArr;
            try {
                iArr[ImageType.GIF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ImageType.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ImageType.PNG_A.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ImageType.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[ImageType.WEBP_A.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[ImageType.JPEG.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static int a() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", MsgBackupManager.PLATFORM_ANDROID));
    }

    public static int a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= b()) {
            a = abs;
            return 0;
        }
        return abs - a;
    }

    public static Bitmap a(Context context, Bitmap bitmap, float f, boolean z) {
        RenderScript renderScript;
        if (!z) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        try {
            renderScript = RenderScript.create(context);
        } catch (Throwable th) {
            th = th;
            renderScript = null;
        }
        try {
            renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius(f);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
            if (renderScript != null) {
                renderScript.destroy();
            }
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
            if (renderScript != null) {
                renderScript.destroy();
            }
            throw th;
        }
    }

    public static Bitmap a(View view) {
        Bitmap createBitmap;
        if (view == null) {
            return null;
        }
        boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache2 = view.getDrawingCache();
            if (drawingCache2 != null) {
                createBitmap = Bitmap.createBitmap(drawingCache2);
            } else {
                createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
            }
        } else {
            createBitmap = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return createBitmap;
    }

    public static GradientDrawable a(int i, float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0123, code lost:
        if (r5 > 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0126, code lost:
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x020a, code lost:
        if (r5 > 0) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(int r5, com.blued.android.framework.ui.xpop.core.BasePopupView r6) {
        /*
            Method dump skipped, instructions count: 579
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.ui.xpop.util.XPopupUtils.a(int, com.blued.android.framework.ui.xpop.core.BasePopupView):void");
    }

    public static void a(View view, int i, int i2) {
        if (i > 0 || i2 > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static void a(ViewGroup viewGroup, int i, int i2) {
        a(viewGroup, i, i2, (Runnable) null);
    }

    public static void a(final ViewGroup viewGroup, final int i, final int i2, final Runnable runnable) {
        viewGroup.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.util.XPopupUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = ViewGroup.this.getLayoutParams();
                View childAt = ViewGroup.this.getChildAt(0);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                int measuredWidth = ViewGroup.this.getMeasuredWidth();
                int i3 = i;
                if (i3 != 0) {
                    layoutParams.width = Math.min(measuredWidth, i3);
                }
                int measuredHeight = ViewGroup.this.getMeasuredHeight();
                if (layoutParams2.height == -1) {
                    measuredHeight = ((ViewGroup) ViewGroup.this.getParent()).getMeasuredHeight();
                    layoutParams.height = measuredHeight;
                }
                if (i2 != 0) {
                    if (layoutParams.height == -1 || layoutParams.height == XPopupUtils.b(ViewGroup.this.getContext()) + XPopupUtils.a()) {
                        layoutParams2.height = Math.min(childAt.getMeasuredHeight(), i2);
                        childAt.setLayoutParams(layoutParams2);
                    } else {
                        layoutParams.height = Math.min(measuredHeight, i2);
                    }
                }
                ViewGroup.this.setLayoutParams(layoutParams);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    public static void a(BasePopupView basePopupView) {
        if (basePopupView instanceof PositionPopupView) {
            return;
        }
        boolean z = basePopupView instanceof PartShadowPopupView;
        if (z || !(basePopupView instanceof AttachPopupView)) {
            if (!z || b(basePopupView)) {
                basePopupView.getPopupContentView().animate().translationY(0.0f).setDuration(100L).start();
            } else {
                basePopupView.getPopupImplView().animate().translationY(0.0f).setDuration(100L).start();
            }
        }
    }

    public static void a(ArrayList<EditText> arrayList, ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof EditText) && childAt.getVisibility() == 0) {
                arrayList.add((EditText) childAt);
            } else if (childAt instanceof ViewGroup) {
                a(arrayList, (ViewGroup) childAt);
            }
            i = i2 + 1;
        }
    }

    public static boolean a(float f, float f2, Rect rect) {
        return f >= ((float) rect.left) && f <= ((float) rect.right) && f2 >= ((float) rect.top) && f2 <= ((float) rect.bottom);
    }

    public static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", MsgBackupManager.PLATFORM_ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static Activity b(View view) {
        Context context = view.getContext();
        while (true) {
            Context context2 = context;
            if (!(context2 instanceof ContextWrapper)) {
                return null;
            }
            if (context2 instanceof Activity) {
                return (Activity) context2;
            }
            context = ((ContextWrapper) context2).getBaseContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(ImageType imageType) {
        int i = AnonymousClass3.a[imageType.ordinal()];
        return i != 1 ? (i == 2 || i == 3) ? "png" : (i == 4 || i == 5) ? "webp" : "jpeg" : "gif";
    }

    public static boolean b(Window window) {
        boolean z;
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i2);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(viewGroup.getContext().getResources().getResourceEntryName(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i = i2 + 1;
        }
        boolean z2 = z;
        if (z) {
            boolean z3 = false;
            if ((viewGroup.getSystemUiVisibility() & 2) == 0) {
                z3 = true;
            }
            z2 = z3;
        }
        return z2;
    }

    private static boolean b(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && ((PartShadowPopupView) basePopupView).b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(File file, InputStream inputStream) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 8192);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    inputStream.close();
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    e.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                            return false;
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    th = th;
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e8) {
            e = e8;
            bufferedOutputStream = null;
        }
    }

    public static int c(Window window) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static boolean c(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 17) {
            z = false;
            if (TextUtils.getLayoutDirectionFromLocale(Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale) == 1) {
                z = true;
            }
        }
        return z;
    }

    private static boolean c(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && !((PartShadowPopupView) basePopupView).b;
    }
}
