package com.blued.android.module.yy_china.view.ban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGABannerUtil.class */
public class BGABannerUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGABannerUtil$LoadBitmapPair.class */
    public static class LoadBitmapPair<S extends Throwable> extends Pair<Bitmap, S> {
        LoadBitmapPair(Bitmap bitmap, S s) {
            super(bitmap, s);
        }
    }

    private BGABannerUtil() {
    }

    public static int a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            return (int) (i3 * (i2 / i4));
        } else if (i2 == 0) {
            return i;
        } else {
            double d = i4 / i3;
            double d2 = i2;
            if (i * d > d2) {
                i = (int) (d2 / d);
            }
            return i;
        }
    }

    public static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r0 > r4) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.graphics.BitmapFactory.Options r3, int r4, int r5) {
        /*
            r0 = 1
            r8 = r0
            r0 = 1
            r6 = r0
            r0 = r8
            r7 = r0
            r0 = r4
            if (r0 == 0) goto L58
            r0 = r5
            if (r0 != 0) goto L13
            r0 = 1
            return r0
        L13:
            r0 = r3
            int r0 = r0.outHeight
            r10 = r0
            r0 = r3
            int r0 = r0.outWidth
            r9 = r0
            r0 = r10
            r1 = r5
            if (r0 > r1) goto L2f
            r0 = r8
            r7 = r0
            r0 = r9
            r1 = r4
            if (r0 <= r1) goto L58
        L2f:
            r0 = r10
            r1 = 2
            int r0 = r0 / r1
            r8 = r0
            r0 = r9
            r1 = 2
            int r0 = r0 / r1
            r9 = r0
        L3b:
            r0 = r6
            r7 = r0
            r0 = r8
            r1 = r6
            int r0 = r0 / r1
            r1 = r5
            if (r0 < r1) goto L58
            r0 = r6
            r7 = r0
            r0 = r9
            r1 = r6
            int r0 = r0 / r1
            r1 = r4
            if (r0 < r1) goto L58
            r0 = r6
            r1 = 2
            int r0 = r0 * r1
            r6 = r0
            goto L3b
        L58:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.view.ban.BGABannerUtil.a(android.graphics.BitmapFactory$Options, int, int):int");
    }

    public static Bitmap a(Context context, int i, int i2, int i3, float f, float f2) {
        LoadBitmapPair<Throwable> a;
        int i4;
        do {
            a = a(context, i, i2, i3);
            if (a != null && a.first != null) {
                break;
            }
            i2 /= 2;
            i4 = i3 / 2;
            if (a == null || !(a.second instanceof OutOfMemoryError) || i2 <= f) {
                break;
            }
            i3 = i4;
        } while (i4 > f2);
        if (a == null) {
            return null;
        }
        return (Bitmap) a.first;
    }

    public static ImageView a(Context context, int i, BGALocalImageSize bGALocalImageSize, ImageView.ScaleType scaleType) {
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(a(context, i, bGALocalImageSize.a(), bGALocalImageSize.b(), bGALocalImageSize.c(), bGALocalImageSize.d()));
        imageView.setClickable(true);
        imageView.setScaleType(scaleType);
        return imageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x005e: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:13:0x005e */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.InputStream] */
    public static LoadBitmapPair<Throwable> a(Context context, int i, int i2, int i3) {
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        LoadBitmapPair<Throwable> loadBitmapPair;
        LoadBitmapPair<Throwable> loadBitmapPair2;
        InputStream openRawResource;
        LoadBitmapPair<Throwable> loadBitmapPair3;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap.Config config = Bitmap.Config.RGB_565;
        Context context2 = null;
        try {
            try {
                try {
                    if (i2 == 0 && i3 == 0) {
                        options.inPreferredConfig = config;
                        openRawResource = context.getResources().openRawResource(i);
                        LoadBitmapPair<Throwable> loadBitmapPair4 = new LoadBitmapPair<>(BitmapFactory.decodeStream(openRawResource, null, options), null);
                        context2 = openRawResource;
                        openRawResource.close();
                        loadBitmapPair3 = loadBitmapPair4;
                    } else {
                        options.inJustDecodeBounds = true;
                        options.inPreferredConfig = config;
                        InputStream openRawResource2 = context.getResources().openRawResource(i);
                        try {
                            BitmapFactory.decodeStream(openRawResource2, null, options);
                            openRawResource2.reset();
                            openRawResource2.close();
                            int i4 = options.outWidth;
                            int i5 = options.outHeight;
                            int a = a(i2, i3, i4, i5);
                            int a2 = a(i3, i2, i5, i4);
                            options.inJustDecodeBounds = false;
                            options.inSampleSize = a(options, a, a2);
                            options.inPreferredConfig = config;
                            openRawResource = context.getResources().openRawResource(i);
                            Bitmap decodeStream = BitmapFactory.decodeStream(openRawResource, null, options);
                            openRawResource.close();
                            if (decodeStream == null || (decodeStream.getWidth() <= a && decodeStream.getHeight() <= a2)) {
                                context2 = openRawResource;
                                loadBitmapPair3 = new LoadBitmapPair<>(decodeStream, null);
                            } else {
                                LoadBitmapPair<Throwable> loadBitmapPair5 = new LoadBitmapPair<>(Bitmap.createScaledBitmap(decodeStream, a, a2, true), null);
                                context2 = openRawResource;
                                decodeStream.recycle();
                                loadBitmapPair3 = loadBitmapPair5;
                            }
                        } catch (Exception e) {
                            inputStream2 = openRawResource2;
                            e = e;
                            e.printStackTrace();
                            InputStream inputStream4 = inputStream2;
                            LoadBitmapPair<Throwable> loadBitmapPair6 = new LoadBitmapPair<>(null, e);
                            loadBitmapPair = loadBitmapPair6;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                    loadBitmapPair = loadBitmapPair6;
                                } catch (IOException e2) {
                                    e = e2;
                                    loadBitmapPair = loadBitmapPair6;
                                    e.printStackTrace();
                                    loadBitmapPair2 = loadBitmapPair;
                                    return loadBitmapPair2;
                                }
                            }
                            loadBitmapPair2 = loadBitmapPair;
                            return loadBitmapPair2;
                        } catch (OutOfMemoryError e3) {
                            inputStream = openRawResource2;
                            e = e3;
                            e.printStackTrace();
                            InputStream inputStream5 = inputStream;
                            LoadBitmapPair<Throwable> loadBitmapPair7 = new LoadBitmapPair<>(null, e);
                            loadBitmapPair = loadBitmapPair7;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    loadBitmapPair = loadBitmapPair7;
                                } catch (IOException e4) {
                                    e = e4;
                                    loadBitmapPair = loadBitmapPair7;
                                    e.printStackTrace();
                                    loadBitmapPair2 = loadBitmapPair;
                                    return loadBitmapPair2;
                                }
                            }
                            loadBitmapPair2 = loadBitmapPair;
                            return loadBitmapPair2;
                        } catch (Throwable th) {
                            th = th;
                            context = openRawResource2;
                            if (context != null) {
                                try {
                                    context.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    loadBitmapPair2 = loadBitmapPair3;
                    if (openRawResource != null) {
                        try {
                            openRawResource.close();
                            return loadBitmapPair3;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return loadBitmapPair3;
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    inputStream2 = null;
                } catch (OutOfMemoryError e8) {
                    e = e8;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    context = context2;
                }
            } catch (Exception e9) {
                inputStream2 = inputStream3;
                e = e9;
            } catch (OutOfMemoryError e10) {
                e = e10;
                inputStream = null;
            }
            return loadBitmapPair2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void a(List<? extends View> list) {
        if (list == null) {
            return;
        }
        for (View view : list) {
            view.setVisibility(0);
            ViewCompat.setAlpha(view, 1.0f);
            ViewCompat.setPivotX(view, view.getMeasuredWidth() * 0.5f);
            ViewCompat.setPivotY(view, view.getMeasuredHeight() * 0.5f);
            ViewCompat.setTranslationX(view, 0.0f);
            ViewCompat.setTranslationY(view, 0.0f);
            ViewCompat.setScaleX(view, 1.0f);
            ViewCompat.setScaleY(view, 1.0f);
            ViewCompat.setRotationX(view, 0.0f);
            ViewCompat.setRotationY(view, 0.0f);
            ViewCompat.setRotation(view, 0.0f);
        }
    }

    public static boolean a(int i, Collection collection) {
        boolean z = false;
        if (b(collection, new Collection[0])) {
            z = false;
            if (i < collection.size()) {
                z = true;
            }
        }
        return z;
    }

    public static boolean a(Collection collection, Collection... collectionArr) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        int length = collectionArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            Collection collection2 = collectionArr[i2];
            if (collection2 == null || collection2.isEmpty()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static int b(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static boolean b(Collection collection, Collection... collectionArr) {
        return !a(collection, collectionArr);
    }
}
