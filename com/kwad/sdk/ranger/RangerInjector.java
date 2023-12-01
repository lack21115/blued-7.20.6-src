package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.web.LoaderConstants;
import com.bytedance.apm.common.utility.Logger;
import com.kwad.sdk.utils.s;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/RangerInjector.class */
public class RangerInjector {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/RangerInjector$a.class */
    public interface a {
        void dI(String str);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/RangerInjector$b.class */
    public interface b {
        void a(String str, long j, long j2, String str2, String str3);

        void onError(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String E(JSONObject jSONObject) {
        try {
            return jSONObject.optString("threadStack");
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long F(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("cost");
        } catch (Exception e) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long G(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("time");
        } catch (Exception e) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String H(JSONObject jSONObject) {
        try {
            return jSONObject.optString("scene");
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String I(JSONObject jSONObject) {
        try {
            return jSONObject.optString(UMModuleRegister.PROCESS);
        } catch (Exception e) {
            return "";
        }
    }

    public static void a(String str, final String str2, final b bVar) {
        try {
            TracePlugin pluginByClass = Matrix.with().getPluginByClass(TracePlugin.class);
            if (pluginByClass == null) {
                bVar.onError("getPluginByClass is null");
                return;
            }
            final PluginListener pluginListener = (PluginListener) s.d(pluginByClass, "pluginListener");
            if (pluginListener != null) {
                try {
                    s.a(pluginByClass, "pluginListener", Proxy.newProxyInstance(pluginByClass.getClass().getClassLoader(), new Class[]{Class.forName(str)}, new InvocationHandler() { // from class: com.kwad.sdk.ranger.RangerInjector.1
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if (method != null) {
                                try {
                                    com.kwad.sdk.core.d.b.i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                                } catch (Throwable th) {
                                    b bVar2 = bVar;
                                    if (bVar2 != null) {
                                        bVar2.onError(Log.getStackTraceString(th));
                                        return null;
                                    }
                                    return null;
                                }
                            }
                            if (method.getName().contains(String.this)) {
                                Issue issue = (Issue) objArr[0];
                                com.kwad.sdk.core.d.b.i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                                try {
                                    JSONObject content = issue.getContent();
                                    String E = RangerInjector.E(content);
                                    long F = RangerInjector.F(content);
                                    long G = RangerInjector.G(content);
                                    String H = RangerInjector.H(content);
                                    String I = RangerInjector.I(content);
                                    if (bVar != null) {
                                        bVar.a(E, G, F, H, I);
                                    }
                                } catch (Throwable th2) {
                                }
                                pluginListener.onReportIssue(issue);
                                return null;
                            } else if (TextUtils.equals(method.getName(), LoaderConstants.ON_INIT)) {
                                pluginListener.onInit((Plugin) objArr[0]);
                                return null;
                            } else if (TextUtils.equals(method.getName(), "onStart")) {
                                pluginListener.onStart((Plugin) objArr[0]);
                                return null;
                            } else if (TextUtils.equals(method.getName(), "onStop")) {
                                pluginListener.onStop((Plugin) objArr[0]);
                                return null;
                            } else if (!TextUtils.equals(method.getName(), "onDestroy")) {
                                method.invoke(pluginListener, objArr);
                                return null;
                            } else {
                                pluginListener.onDestroy((Plugin) objArr[0]);
                                return null;
                            }
                        }
                    }));
                } catch (Exception e) {
                    bVar.onError(Log.getStackTraceString(e));
                }
            }
        } catch (Exception e2) {
            bVar.onError(Log.getStackTraceString(e2));
        }
    }

    public static void tryProxyOtherOutput(String str, String str2, String str3, final String str4, final a aVar) {
        try {
            final Logger.ILogWritter iLogWritter = (Logger.ILogWritter) s.aa(str, str2);
            if (iLogWritter == null) {
                return;
            }
            Integer num = (Integer) s.aa(str, str3);
            int i = 4;
            if (num != null) {
                i = num.intValue();
            }
            final int i2 = i;
            s.a(Class.forName(str), str2, (Object) new Logger.ILogWritter() { // from class: com.kwad.sdk.ranger.RangerInjector.2
                public final boolean isLoggable(int i3) {
                    return true;
                }

                public final void logD(String str5, String str6) {
                    try {
                        if (i2 > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6);
                    } catch (Throwable th) {
                    }
                }

                public final void logD(String str5, String str6, Throwable th) {
                    try {
                        if (i2 > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6, th);
                    } catch (Throwable th2) {
                    }
                }

                public final void logE(String str5, String str6) {
                    try {
                        if (i2 > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6);
                    } catch (Throwable th) {
                    }
                }

                public final void logE(String str5, String str6, Throwable th) {
                    try {
                        if (TextUtils.equals(str5, str4) && aVar != null) {
                            aVar.dI(Log.getStackTraceString(th));
                        }
                        if (i2 > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6, th);
                    } catch (Throwable th2) {
                    }
                }

                public final void logI(String str5, String str6) {
                    try {
                        if (i2 > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6);
                    } catch (Throwable th) {
                    }
                }

                public final void logI(String str5, String str6, Throwable th) {
                    try {
                        if (i2 > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6, th);
                    } catch (Throwable th2) {
                    }
                }

                public final void logK(String str5, String str6) {
                    try {
                        iLogWritter.logK(str5, str6);
                    } catch (Throwable th) {
                    }
                }

                public final void logV(String str5, String str6) {
                    try {
                        if (i2 > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6);
                    } catch (Throwable th) {
                    }
                }

                public final void logV(String str5, String str6, Throwable th) {
                    try {
                        if (i2 > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6, th);
                    } catch (Throwable th2) {
                    }
                }

                public final void logW(String str5, String str6) {
                    try {
                        if (i2 > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6);
                    } catch (Throwable th) {
                    }
                }

                public final void logW(String str5, String str6, Throwable th) {
                    try {
                        if (i2 > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6, th);
                    } catch (Throwable th2) {
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.w("perfMonitor.RangerInjector", Log.getStackTraceString(th));
        }
    }
}
