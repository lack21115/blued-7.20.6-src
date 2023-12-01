package com.blued.android.module.player.media.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/utils/Utils.class */
public class Utils {
    private static final String a = Utils.class.getSimpleName();

    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static void a(VideoPlayConfig videoPlayConfig) {
        videoPlayConfig.e = AppInfo.l;
        videoPlayConfig.f = AppInfo.m;
        if (videoPlayConfig.a() == 0 || videoPlayConfig.b() == 0 || videoPlayConfig.e == 0) {
            return;
        }
        float b = videoPlayConfig.b() * (videoPlayConfig.e / videoPlayConfig.a());
        if (videoPlayConfig.f - b <= 0.0f || b / videoPlayConfig.f < 0.8d) {
            videoPlayConfig.f = (int) b;
            return;
        }
        videoPlayConfig.e = AppInfo.l;
        videoPlayConfig.f = AppInfo.m;
        b(videoPlayConfig);
    }

    public static int[] a(int i, int i2) {
        int i3;
        int i4;
        float f = (i * 1.0f) / i2;
        int a2 = DisplayUtil.a(AppInfo.d(), 200.0f);
        int a3 = DisplayUtil.a(AppInfo.d(), 135.0f);
        int a4 = DisplayUtil.a(AppInfo.d(), 120.0f);
        if (f > 1.4814814f) {
            i3 = a3;
        } else if (f <= 0.6f) {
            i3 = a2;
            a2 = a4;
        } else if (f > 1.0f) {
            if (i < a4) {
                i4 = a4;
            } else {
                i4 = i;
                if (i > a2) {
                    i4 = a2;
                }
            }
            i3 = (int) (i4 / f);
            a2 = i4;
        } else {
            if (i2 < a3) {
                i3 = a3;
            } else {
                i3 = i2;
                if (i2 > a2) {
                    i3 = a2;
                }
            }
            a2 = (int) (i3 * f);
        }
        return new int[]{a2, i3};
    }

    public static int[] a(String str) {
        int i;
        int i2;
        int i3;
        int[] iArr = new int[3];
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (!TextUtils.isEmpty(str) && !str.contains("http")) {
                    mediaMetadataRetriever.setDataSource(str);
                }
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                if (TextUtils.isEmpty(extractMetadata) || TextUtils.isEmpty(extractMetadata2)) {
                    Log.e(a, " widthStr" + extractMetadata + ",heightStr" + extractMetadata2);
                    i = 0;
                    i2 = 0;
                } else {
                    i = Integer.parseInt(extractMetadata);
                    i2 = Integer.parseInt(extractMetadata2);
                }
                if (TextUtils.isEmpty(extractMetadata3)) {
                    Log.e(a, " rotation" + extractMetadata3);
                    i3 = 0;
                } else {
                    i3 = Integer.parseInt(extractMetadata3);
                }
                if (i3 == 90 || i3 == 270) {
                    iArr[0] = i2;
                    iArr[1] = i;
                } else {
                    iArr[0] = i;
                    iArr[1] = i2;
                }
                iArr[2] = i3;
            } catch (Exception e) {
                Log.e(a, " MediaMetadataRetriever exception " + e);
                e.printStackTrace();
            }
            return iArr;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static void b(VideoPlayConfig videoPlayConfig) {
        if (videoPlayConfig.a() == 0 || videoPlayConfig.b() == 0 || videoPlayConfig.e == 0 || videoPlayConfig.f == 0) {
            return;
        }
        float min = Math.min(videoPlayConfig.a() / videoPlayConfig.e, videoPlayConfig.b() / videoPlayConfig.f);
        videoPlayConfig.e = (int) Math.ceil(videoPlayConfig.a() / min);
        videoPlayConfig.f = (int) Math.ceil(videoPlayConfig.b() / min);
    }

    public static void b(String str) {
        Exception e;
        synchronized (Utils.class) {
            try {
                File file = new File(str);
                File file2 = new File(str, ".nomedia");
                FileOutputStream fileOutputStream = null;
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        if (!file2.exists()) {
                            file2.createNewFile();
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                fileOutputStream.flush();
                                Log.e(a, "create .nomedia file:" + file2.getAbsolutePath());
                            } catch (Exception e2) {
                                e = e2;
                                String str2 = a;
                                FileOutputStream fileOutputStream3 = fileOutputStream;
                                StringBuilder sb = new StringBuilder();
                                FileOutputStream fileOutputStream4 = fileOutputStream;
                                sb.append("exception in createNewFile() method:");
                                FileOutputStream fileOutputStream5 = fileOutputStream;
                                sb.append(e.getMessage());
                                fileOutputStream2 = fileOutputStream;
                                Log.e(str2, sb.toString());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e6) {
                    fileOutputStream = null;
                    e = e6;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
