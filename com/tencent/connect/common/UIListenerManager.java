package com.tencent.connect.common;

import android.content.Intent;
import com.anythink.expressad.d.a.b;
import com.tencent.open.a.f;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/common/UIListenerManager.class */
public class UIListenerManager {
    private static final String TAG = "openSDK_LOG.UIListenerManager";
    private static UIListenerManager mInstance;
    private Map<String, ApiTask> mListenerMap;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/connect/common/UIListenerManager$ApiTask.class */
    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i, IUiListener iUiListener) {
            this.mRequestCode = i;
            this.mListener = iUiListener;
        }
    }

    private UIListenerManager() {
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.mListenerMap = synchronizedMap;
        if (synchronizedMap == null) {
            this.mListenerMap = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener buildListener(int i, IUiListener iUiListener) {
        if (i == 11101) {
            f.e(TAG, "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
            return iUiListener;
        } else if (i == 11105) {
            f.e(TAG, "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
            return iUiListener;
        } else {
            if (i == 11106) {
                f.e(TAG, "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
            }
            return iUiListener;
        }
    }

    public static UIListenerManager getInstance() {
        if (mInstance == null) {
            mInstance = new UIListenerManager();
        }
        return mInstance;
    }

    public IUiListener getListnerWithAction(String str) {
        ApiTask apiTask;
        if (str == null) {
            f.e(TAG, "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.mListenerMap) {
            apiTask = this.mListenerMap.get(str);
            this.mListenerMap.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i) {
        String actionFromRequestcode = SystemUtils.getActionFromRequestcode(i);
        if (actionFromRequestcode == null) {
            f.e(TAG, "getListner action is null! rquestCode=" + i);
            return null;
        }
        return getListnerWithAction(actionFromRequestcode);
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        f.c(TAG, "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        if (SystemUtils.ACTION_LOGIN.equals(stringExtra)) {
            int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra != 0) {
                f.e(TAG, "OpenUi, onActivityResult, onError = " + intExtra + "");
                iUiListener.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                return;
            }
            String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
            if (stringExtra2 == null) {
                f.b(TAG, "OpenUi, onActivityResult, onComplete");
                iUiListener.onComplete(new JSONObject());
                return;
            }
            try {
                iUiListener.onComplete(Util.parseJson(stringExtra2));
            } catch (JSONException e) {
                iUiListener.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                f.b(TAG, "OpenUi, onActivityResult, json error", e);
            }
        } else if (SystemUtils.ACTION_SHARE.equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if (b.dO.equals(stringExtra3)) {
                iUiListener.onCancel();
            } else if ("error".equals(stringExtra3)) {
                iUiListener.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
            } else if ("complete".equals(stringExtra3)) {
                try {
                    iUiListener.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    iUiListener.onError(new UiError(-4, "json error", stringExtra4 + ""));
                }
            }
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent, IUiListener iUiListener) {
        f.c(TAG, "onActivityResult req=" + i + " res=" + i2);
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i);
        IUiListener iUiListener2 = listnerWithRequestCode;
        if (listnerWithRequestCode == null) {
            if (iUiListener == null) {
                f.e(TAG, "onActivityResult can't find the listener");
                return false;
            }
            iUiListener2 = buildListener(i, iUiListener);
        }
        if (i2 != -1) {
            iUiListener2.onCancel();
            return true;
        } else if (intent == null) {
            iUiListener2.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return true;
        } else {
            String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
            if (SystemUtils.ACTION_LOGIN.equals(stringExtra)) {
                int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (intExtra != 0) {
                    f.e(TAG, "OpenUi, onActivityResult, onError = " + intExtra + "");
                    iUiListener2.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                    return true;
                }
                String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                if (stringExtra2 == null) {
                    f.b(TAG, "OpenUi, onActivityResult, onComplete");
                    iUiListener2.onComplete(new JSONObject());
                    return true;
                }
                try {
                    iUiListener2.onComplete(Util.parseJson(stringExtra2));
                    return true;
                } catch (JSONException e) {
                    iUiListener2.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                    f.b(TAG, "OpenUi, onActivityResult, json error", e);
                    return true;
                }
            } else if (!SystemUtils.ACTION_SHARE.equals(stringExtra)) {
                int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (intExtra2 != 0) {
                    iUiListener2.onError(new UiError(intExtra2, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                    return true;
                }
                String stringExtra3 = intent.getStringExtra(Constants.KEY_RESPONSE);
                if (stringExtra3 == null) {
                    iUiListener2.onComplete(new JSONObject());
                    return true;
                }
                try {
                    iUiListener2.onComplete(Util.parseJson(stringExtra3));
                    return true;
                } catch (JSONException e2) {
                    iUiListener2.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra3));
                    return true;
                }
            } else {
                String stringExtra4 = intent.getStringExtra("result");
                String stringExtra5 = intent.getStringExtra("response");
                if (b.dO.equals(stringExtra4)) {
                    iUiListener2.onCancel();
                    return true;
                } else if ("error".equals(stringExtra4)) {
                    iUiListener2.onError(new UiError(-6, "unknown error", stringExtra5 + ""));
                    return true;
                } else if ("complete".equals(stringExtra4)) {
                    try {
                        iUiListener2.onComplete(new JSONObject(stringExtra5 == null ? "{\"ret\": 0}" : stringExtra5));
                        return true;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        iUiListener2.onError(new UiError(-4, "json error", stringExtra5 + ""));
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
    }

    public Object setListenerWithRequestcode(int i, IUiListener iUiListener) {
        ApiTask put;
        String actionFromRequestcode = SystemUtils.getActionFromRequestcode(i);
        if (actionFromRequestcode == null) {
            f.e(TAG, "setListener action is null! rquestCode=" + i);
            return null;
        }
        synchronized (this.mListenerMap) {
            put = this.mListenerMap.put(actionFromRequestcode, new ApiTask(i, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        ApiTask put;
        int requestCodeFromCallback = SystemUtils.getRequestCodeFromCallback(str);
        if (requestCodeFromCallback == -1) {
            f.e(TAG, "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.mListenerMap) {
            put = this.mListenerMap.put(str, new ApiTask(requestCodeFromCallback, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }
}
