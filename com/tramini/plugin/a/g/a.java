package com.tramini.plugin.a.g;

import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.tencent.connect.common.Constants;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26842a = a.class.getSimpleName();

    /* renamed from: com.tramini.plugin.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/a$a.class */
    public interface InterfaceC0902a {
        void a(com.tramini.plugin.a.c.a aVar);
    }

    public static void a(final com.tramini.plugin.b.a aVar, final String str, final String str2, final String str3, final InterfaceC0902a interfaceC0902a) {
        if (aVar == null) {
            interfaceC0902a.a(null);
        } else {
            com.tramini.plugin.a.g.b.a.a().a(new Runnable() { // from class: com.tramini.plugin.a.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.tramini.plugin.a.c.a aVar2;
                    ConcurrentHashMap<String, com.tramini.plugin.a.c.c> e;
                    try {
                        e = com.tramini.plugin.b.a.this.e();
                    } catch (Throwable th) {
                        aVar2 = null;
                    }
                    if (e == null) {
                        if (interfaceC0902a != null) {
                            interfaceC0902a.a(null);
                            return;
                        }
                        return;
                    }
                    com.tramini.plugin.a.c.c cVar = e.get(TextUtils.equals(str, BaseWrapper.ENTER_ID_OAPS_ROAMING) ? "2" : str);
                    String str4 = cVar != null ? cVar.d : "";
                    if (TextUtils.isEmpty(str4)) {
                        if (interfaceC0902a != null) {
                            interfaceC0902a.a(null);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str4);
                    String str5 = str;
                    boolean z = true;
                    int hashCode = str5.hashCode();
                    if (hashCode != 50) {
                        if (hashCode != 56) {
                            if (hashCode != 1572) {
                                if (hashCode != 1632) {
                                    if (hashCode != 1691) {
                                        if (hashCode != 53) {
                                            if (hashCode != 54) {
                                                if (hashCode != 1606) {
                                                    if (hashCode == 1607 && str5.equals("29")) {
                                                        z = true;
                                                    }
                                                } else if (str5.equals(Constants.VIA_ACT_TYPE_TWENTY_EIGHT)) {
                                                    z = true;
                                                }
                                            } else if (str5.equals("6")) {
                                                z = true;
                                            }
                                        } else if (str5.equals("5")) {
                                            z = true;
                                        }
                                    } else if (str5.equals("50")) {
                                        z = true;
                                    }
                                } else if (str5.equals(BaseWrapper.ENTER_ID_OAPS_ROAMING)) {
                                    z = true;
                                }
                            } else if (str5.equals("15")) {
                                z = true;
                            }
                        } else if (str5.equals("8")) {
                            z = true;
                        }
                    } else if (str5.equals("2")) {
                        z = false;
                    }
                    switch (z) {
                        case false:
                        case true:
                            aVar2 = com.tramini.plugin.a.e.a.a(jSONObject, cVar, str2, str3);
                            break;
                        case true:
                            aVar2 = com.tramini.plugin.a.e.b.a(jSONObject, cVar, str2, str3);
                            break;
                        case true:
                            aVar2 = com.tramini.plugin.a.e.e.a(jSONObject, cVar, str2, str3);
                            break;
                        case true:
                            aVar2 = com.tramini.plugin.a.e.c.a(jSONObject, cVar, str2);
                            break;
                        case true:
                            aVar2 = com.tramini.plugin.a.e.i.a(jSONObject, cVar, str2);
                            break;
                        case true:
                            aVar2 = com.tramini.plugin.a.e.d.a(jSONObject, cVar, str2);
                            break;
                        case true:
                            aVar2 = com.tramini.plugin.a.e.h.a(jSONObject, cVar, str2);
                            break;
                        case true:
                            aVar2 = com.tramini.plugin.a.e.g.a(jSONObject, cVar, str2);
                            break;
                        default:
                            aVar2 = null;
                            break;
                    }
                    InterfaceC0902a interfaceC0902a2 = interfaceC0902a;
                    if (interfaceC0902a2 != null) {
                        interfaceC0902a2.a(aVar2);
                    }
                }
            });
        }
    }
}
