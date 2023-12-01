package com.blued.android.module.common.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.statistics.BluedStatistics;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;
import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/BluedSharedPreferences.class */
public class BluedSharedPreferences {
    private static HashMap<String, BluedSharedPreferences> a = new HashMap<>();
    private static boolean b = true;
    private static boolean g = false;
    private MMKV c;
    private MMKV d;
    private SharedPreferences e;
    private SharedPreferences.Editor f;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/BluedSharedPreferences$Editor.class */
    public final class Editor {
        public Editor() {
        }

        public Editor a(String str) {
            if (BluedSharedPreferences.b) {
                if (BluedSharedPreferences.this.c != null) {
                    BluedSharedPreferences.this.c.removeValueForKey(str);
                    return this;
                }
            } else if (BluedSharedPreferences.this.f != null) {
                BluedSharedPreferences.this.f.remove(str);
            }
            return this;
        }

        public Editor a(String str, float f) {
            if (BluedSharedPreferences.b) {
                if (BluedSharedPreferences.this.c != null) {
                    BluedSharedPreferences.this.c.encode(str, f);
                    return this;
                }
            } else if (BluedSharedPreferences.this.f != null) {
                BluedSharedPreferences.this.f.putFloat(str, f);
            }
            return this;
        }

        public Editor a(String str, int i) {
            if (BluedSharedPreferences.b) {
                if (BluedSharedPreferences.this.c != null) {
                    BluedSharedPreferences.this.c.encode(str, i);
                    return this;
                }
            } else if (BluedSharedPreferences.this.f != null) {
                BluedSharedPreferences.this.f.putInt(str, i);
            }
            return this;
        }

        public Editor a(String str, long j) {
            if (BluedSharedPreferences.b) {
                if (BluedSharedPreferences.this.c != null) {
                    BluedSharedPreferences.this.c.encode(str, j);
                    return this;
                }
            } else if (BluedSharedPreferences.this.f != null) {
                BluedSharedPreferences.this.f.putLong(str, j);
            }
            return this;
        }

        public Editor a(String str, String str2) {
            if (BluedSharedPreferences.b) {
                if (BluedSharedPreferences.this.c != null) {
                    BluedSharedPreferences.this.c.encode(str, str2);
                    return this;
                }
            } else if (BluedSharedPreferences.this.f != null) {
                BluedSharedPreferences.this.f.putString(str, str2);
            }
            return this;
        }

        public Editor a(String str, boolean z) {
            if (BluedSharedPreferences.b) {
                if (BluedSharedPreferences.this.c != null) {
                    BluedSharedPreferences.this.c.encode(str, z);
                    return this;
                }
            } else if (BluedSharedPreferences.this.f != null) {
                BluedSharedPreferences.this.f.putBoolean(str, z);
            }
            return this;
        }

        public boolean a() {
            if (BluedSharedPreferences.b || BluedSharedPreferences.this.f == null) {
                return true;
            }
            return BluedSharedPreferences.this.f.commit();
        }

        public void b() {
            if (BluedSharedPreferences.b || BluedSharedPreferences.this.f == null) {
                return;
            }
            BluedSharedPreferences.this.f.apply();
        }
    }

    private BluedSharedPreferences(Context context, String str, int i) {
        if (b) {
            try {
                this.c = MMKV.mmkvWithID(str);
                this.d = MMKV.defaultMMKV();
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                if (!TextUtils.isEmpty(message) && message.contains("Opening a multi-process MMKV")) {
                    try {
                        this.c = MMKV.mmkvWithID(str, 2);
                        this.d = MMKV.defaultMMKV(2, (String) null);
                    } catch (Throwable th) {
                        BluedStatistics.c().b("MMKV", 0L, 102, str);
                        return;
                    }
                }
            } catch (Throwable th2) {
                BluedStatistics.c().b("MMKV", 0L, 101, str);
                return;
            }
        }
        Context d = context == null ? AppInfo.d() : context;
        if (d != null) {
            if (!b) {
                this.e = d.getSharedPreferences(str, i);
                return;
            }
            MMKV mmkv = this.d;
            if (mmkv == null || mmkv.contains(str)) {
                return;
            }
            this.c.importFromSharedPreferences(d.getSharedPreferences(str, i));
            this.d.encode(str, true);
            Logger.b("BluedSharedPreferences", "transform SP-" + str + " to MMKV");
        }
    }

    public static BluedSharedPreferences a() {
        Context d = AppInfo.d();
        return a(d, d.getPackageName() + "_preferences", 0);
    }

    private static BluedSharedPreferences a(Context context, String str, int i) {
        if (a.containsKey(str)) {
            return a.get(str);
        }
        BluedSharedPreferences bluedSharedPreferences = new BluedSharedPreferences(context, str, i);
        a.put(str, bluedSharedPreferences);
        return bluedSharedPreferences;
    }

    public static BluedSharedPreferences a(String str) {
        return a(AppInfo.d(), str, 0);
    }

    public static BluedSharedPreferences a(String str, int i) {
        return a(null, str, i);
    }

    public static void a(Application application) {
        if (g) {
            return;
        }
        g = true;
        if (b()) {
            try {
                MMKV.initialize(application.getFilesDir().getAbsolutePath() + "/mmkv", AppInfo.m() ? MMKVLogLevel.LevelDebug : MMKVLogLevel.LevelError);
            } catch (Throwable th) {
                a(false);
            }
        }
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean b() {
        return b;
    }

    public float a(String str, float f) {
        if (b) {
            MMKV mmkv = this.c;
            if (mmkv != null) {
                return mmkv.getFloat(str, f);
            }
        } else {
            SharedPreferences sharedPreferences = this.e;
            if (sharedPreferences != null) {
                return sharedPreferences.getFloat(str, f);
            }
        }
        return f;
    }

    public long a(String str, long j) {
        if (b) {
            MMKV mmkv = this.c;
            if (mmkv != null) {
                return mmkv.getLong(str, j);
            }
        } else {
            SharedPreferences sharedPreferences = this.e;
            if (sharedPreferences != null) {
                return sharedPreferences.getLong(str, j);
            }
        }
        return j;
    }

    public String a(String str, String str2) {
        if (b) {
            MMKV mmkv = this.c;
            if (mmkv != null) {
                return mmkv.getString(str, str2);
            }
        } else {
            SharedPreferences sharedPreferences = this.e;
            if (sharedPreferences != null) {
                return sharedPreferences.getString(str, str2);
            }
        }
        return str2;
    }

    public boolean a(String str, boolean z) {
        if (b) {
            MMKV mmkv = this.c;
            if (mmkv != null) {
                return mmkv.getBoolean(str, z);
            }
        } else {
            SharedPreferences sharedPreferences = this.e;
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(str, z);
            }
        }
        return z;
    }

    public int b(String str, int i) {
        if (b) {
            MMKV mmkv = this.c;
            if (mmkv != null) {
                return mmkv.getInt(str, i);
            }
        } else {
            SharedPreferences sharedPreferences = this.e;
            if (sharedPreferences != null) {
                return sharedPreferences.getInt(str, i);
            }
        }
        return i;
    }

    public boolean b(String str) {
        if (b) {
            MMKV mmkv = this.c;
            if (mmkv != null) {
                return mmkv.containsKey(str);
            }
            return false;
        }
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        return false;
    }

    public Editor c() {
        if (!b) {
            this.f = this.e.edit();
        }
        return new Editor();
    }
}
