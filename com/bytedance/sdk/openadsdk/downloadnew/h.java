package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/h.class */
public final class h extends mb implements Bridge {
    private static volatile h mb;
    private final Context ox;

    private h(Context context) {
        this.ox = context;
    }

    private DownloadEventConfig b(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private ExitInstallListener h(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private DownloadController hj(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private IDownloadButtonClickListener ko(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        return null;
    }

    public static h mb(Context context) {
        if (mb == null) {
            synchronized (h.class) {
                try {
                    if (mb == null) {
                        mb = new h(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    private DownloadStatusChangeListener mb(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        return null;
    }

    private static boolean mb(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    private DownloadModel ox(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private OnItemClickListener u(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 20) {
            init((Bundle) valueSet.objectValue(0, Bundle.class));
            return null;
        }
        return (T) callMethod(cls, i, (Map) valueSet.objectValue(0, Map.class));
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i, Map<String, Object> map) {
        switch (i) {
            case 0:
                return (T) Boolean.valueOf(hj.mb(getActivity(map.get("activity")), h(map.get(TTDownloadField.TT_EXIT_INSTALL_LISTENER))));
            case 1:
                return (T) hj.mb().u();
            case 2:
                try {
                    return (T) Boolean.valueOf(hj.mb((String) map.get(TTDownloadField.TT_TAG_INTERCEPT), (String) map.get("label"), new JSONObject((String) map.get(TTDownloadField.TT_META)), new HashMap()));
                } catch (JSONException e) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                hj.mb(((Integer) map.get(TTDownloadField.TT_HID)).intValue());
                return null;
            case 4:
                hj.mb().mb((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue());
                return null;
            case 5:
                hj.mb().mb(this.ox, ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue(), mb(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), ox(map.get(TTDownloadField.TT_DOWNLOAD_MODEL)));
                return null;
            case 6:
                return (T) Boolean.valueOf(hj.mb(this.ox, (String) map.get(TTDownloadField.TT_DOWNLOAD_URL)));
            case 7:
                hj.ox();
                return null;
            case 8:
                hj.mb().mb((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Boolean) map.get("force")).booleanValue());
                return null;
            case 9:
                hj.mb(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                return null;
            case 10:
                hj.mb((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                return null;
            case 11:
            default:
                return (T) super.callMethod(cls, i, map);
            case 12:
                Uri uri = (Uri) map.get("uri");
                DownloadModel ox = ox(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                DownloadEventConfig b = b(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                DownloadController hj = hj(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                IDownloadButtonClickListener ko = ko(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                return mb(ko) ? (T) Boolean.valueOf(hj.mb(this.ox, uri, ox, b, hj, ko)) : (T) Boolean.valueOf(hj.mb(this.ox, uri, ox, b, hj));
            case 13:
                int intValue = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                String str = (String) map.get(TTDownloadField.TT_USERAGENT);
                DownloadModel ox2 = ox(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                DownloadEventConfig b2 = b(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                DownloadController hj2 = hj(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                DownloadStatusChangeListener mb2 = mb(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                IDownloadButtonClickListener ko2 = ko(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (mb(ko2)) {
                    hj.mb().h().mb(this.ox, str, booleanValue, ox2, b2, hj2, mb2, intValue, ko2);
                    return null;
                }
                hj.mb().h().mb(this.ox, str, booleanValue, ox2, b2, hj2, mb2, intValue);
                return null;
            case 14:
                return (T) Boolean.valueOf(hj.mb().h().mb(this.ox, ((Long) map.get("id")).longValue(), (String) map.get(TTDownloadField.TT_LOG_EXTRA), (DownloadStatusChangeListener) null, ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 15:
                return (T) Boolean.valueOf(hj.mb((Uri) map.get("uri")));
            case 16:
                hj.mb().mb((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Long) map.get("id")).longValue(), ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue(), b(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)), hj(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER)));
                return null;
            case 17:
                hj.mb().mb((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Long) map.get("id")).longValue(), ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue(), b(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)), hj(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER)), u(map.get(TTDownloadField.TT_ITEM_CLICK_LISTENER)), ko(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                return null;
            case 18:
                return (T) Boolean.valueOf(hj.mb().h().mb(((Long) map.get("id")).longValue(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 19:
                return (T) Boolean.valueOf(hj.mb().h().mb(((Long) map.get("id")).longValue()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i, Map<String, Object> map) {
        return i != 0 ? i != 1 ? (T) super.getObj(cls) : (T) Boolean.valueOf(hj.ox) : (T) hj.mb;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.mb, com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
        super.init(bundle);
        hj.mb(this.ox);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bytedance.sdk.openadsdk.api.b.mb().mb(0, hj.mb).mb(1, Boolean.valueOf(hj.ox)).ox();
    }
}
