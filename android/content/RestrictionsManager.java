package android.content;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/content/RestrictionsManager.class */
public class RestrictionsManager {
    public static final String ACTION_PERMISSION_RESPONSE_RECEIVED = "android.content.action.PERMISSION_RESPONSE_RECEIVED";
    public static final String ACTION_REQUEST_LOCAL_APPROVAL = "android.content.action.REQUEST_LOCAL_APPROVAL";
    public static final String ACTION_REQUEST_PERMISSION = "android.content.action.REQUEST_PERMISSION";
    public static final String EXTRA_PACKAGE_NAME = "android.content.extra.PACKAGE_NAME";
    public static final String EXTRA_REQUEST_BUNDLE = "android.content.extra.REQUEST_BUNDLE";
    public static final String EXTRA_REQUEST_ID = "android.content.extra.REQUEST_ID";
    public static final String EXTRA_REQUEST_TYPE = "android.content.extra.REQUEST_TYPE";
    public static final String EXTRA_RESPONSE_BUNDLE = "android.content.extra.RESPONSE_BUNDLE";
    public static final String META_DATA_APP_RESTRICTIONS = "android.content.APP_RESTRICTIONS";
    public static final String REQUEST_KEY_APPROVE_LABEL = "android.request.approve_label";
    public static final String REQUEST_KEY_DATA = "android.request.data";
    public static final String REQUEST_KEY_DENY_LABEL = "android.request.deny_label";
    public static final String REQUEST_KEY_ICON = "android.request.icon";
    public static final String REQUEST_KEY_ID = "android.request.id";
    public static final String REQUEST_KEY_MESSAGE = "android.request.mesg";
    public static final String REQUEST_KEY_NEW_REQUEST = "android.request.new_request";
    public static final String REQUEST_KEY_TITLE = "android.request.title";
    public static final String REQUEST_TYPE_APPROVAL = "android.request.type.approval";
    public static final String RESPONSE_KEY_ERROR_CODE = "android.response.errorcode";
    public static final String RESPONSE_KEY_MESSAGE = "android.response.msg";
    public static final String RESPONSE_KEY_RESPONSE_TIMESTAMP = "android.response.timestamp";
    public static final String RESPONSE_KEY_RESULT = "android.response.result";
    public static final int RESULT_APPROVED = 1;
    public static final int RESULT_DENIED = 2;
    public static final int RESULT_ERROR = 5;
    public static final int RESULT_ERROR_BAD_REQUEST = 1;
    public static final int RESULT_ERROR_INTERNAL = 3;
    public static final int RESULT_ERROR_NETWORK = 2;
    public static final int RESULT_NO_RESPONSE = 3;
    public static final int RESULT_UNKNOWN_REQUEST = 4;
    private static final String TAG = "RestrictionsManager";
    private static final String TAG_RESTRICTION = "restriction";
    private final Context mContext;
    private final IRestrictionsManager mService;

    public RestrictionsManager(Context context, IRestrictionsManager iRestrictionsManager) {
        this.mContext = context;
        this.mService = iRestrictionsManager;
    }

    private List<RestrictionEntry> loadManifestRestrictions(String str, XmlResourceParser xmlResourceParser) {
        ArrayList arrayList;
        AttributeSet asAttributeSet;
        RestrictionEntry loadRestriction;
        try {
            Context createPackageContext = this.mContext.createPackageContext(str, 0);
            ArrayList arrayList2 = new ArrayList();
            try {
                int next = xmlResourceParser.next();
                while (true) {
                    arrayList = arrayList2;
                    if (next == 1) {
                        break;
                    }
                    if (next == 2) {
                        if (xmlResourceParser.getName().equals(TAG_RESTRICTION) && (asAttributeSet = Xml.asAttributeSet(xmlResourceParser)) != null && (loadRestriction = loadRestriction(createPackageContext, createPackageContext.obtainStyledAttributes(asAttributeSet, R.styleable.RestrictionEntry))) != null) {
                            arrayList2.add(loadRestriction);
                        }
                    }
                    next = xmlResourceParser.next();
                }
            } catch (IOException e) {
                Log.w(TAG, "Reading restriction metadata for " + str, e);
                return null;
            } catch (XmlPullParserException e2) {
                Log.w(TAG, "Reading restriction metadata for " + str, e2);
                return null;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            arrayList = null;
        }
        return arrayList;
    }

    private RestrictionEntry loadRestriction(Context context, TypedArray typedArray) {
        RestrictionEntry restrictionEntry;
        String string = typedArray.getString(3);
        int i = typedArray.getInt(6, -1);
        String string2 = typedArray.getString(2);
        String string3 = typedArray.getString(0);
        int resourceId = typedArray.getResourceId(1, 0);
        int resourceId2 = typedArray.getResourceId(5, 0);
        if (i == -1) {
            Log.w(TAG, "restrictionType cannot be omitted");
            restrictionEntry = null;
        } else if (string == null) {
            Log.w(TAG, "key cannot be omitted");
            return null;
        } else {
            RestrictionEntry restrictionEntry2 = new RestrictionEntry(i, string);
            restrictionEntry2.setTitle(string2);
            restrictionEntry2.setDescription(string3);
            if (resourceId != 0) {
                restrictionEntry2.setChoiceEntries(context, resourceId);
            }
            if (resourceId2 != 0) {
                restrictionEntry2.setChoiceValues(context, resourceId2);
            }
            switch (i) {
                case 0:
                case 2:
                case 6:
                    restrictionEntry2.setSelectedString(typedArray.getString(4));
                    return restrictionEntry2;
                case 1:
                    restrictionEntry2.setSelectedState(typedArray.getBoolean(4, false));
                    return restrictionEntry2;
                case 3:
                default:
                    Log.w(TAG, "Unknown restriction type " + i);
                    return restrictionEntry2;
                case 4:
                    int resourceId3 = typedArray.getResourceId(4, 0);
                    restrictionEntry = restrictionEntry2;
                    if (resourceId3 != 0) {
                        restrictionEntry2.setAllSelectedStrings(context.getResources().getStringArray(resourceId3));
                        return restrictionEntry2;
                    }
                    break;
                case 5:
                    restrictionEntry2.setIntValue(typedArray.getInt(4, 0));
                    return restrictionEntry2;
            }
        }
        return restrictionEntry;
    }

    public Intent createLocalApprovalIntent() {
        try {
            if (this.mService != null) {
                return this.mService.createLocalApprovalIntent();
            }
            return null;
        } catch (RemoteException e) {
            Log.w(TAG, "Couldn't reach service");
            return null;
        }
    }

    public Bundle getApplicationRestrictions() {
        try {
            if (this.mService != null) {
                return this.mService.getApplicationRestrictions(this.mContext.getPackageName());
            }
            return null;
        } catch (RemoteException e) {
            Log.w(TAG, "Couldn't reach service");
            return null;
        }
    }

    public List<RestrictionEntry> getManifestRestrictions(String str) {
        try {
            ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null || !applicationInfo.metaData.containsKey(META_DATA_APP_RESTRICTIONS)) {
                return null;
            }
            return loadManifestRestrictions(str, applicationInfo.loadXmlMetaData(this.mContext.getPackageManager(), META_DATA_APP_RESTRICTIONS));
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException("No such package " + str);
        }
    }

    public boolean hasRestrictionsProvider() {
        try {
            if (this.mService != null) {
                return this.mService.hasRestrictionsProvider();
            }
            return false;
        } catch (RemoteException e) {
            Log.w(TAG, "Couldn't reach service");
            return false;
        }
    }

    public void notifyPermissionResponse(String str, PersistableBundle persistableBundle) {
        if (str == null) {
            throw new NullPointerException("packageName cannot be null");
        }
        if (persistableBundle == null) {
            throw new NullPointerException("request cannot be null");
        }
        if (!persistableBundle.containsKey(REQUEST_KEY_ID)) {
            throw new IllegalArgumentException("REQUEST_KEY_ID must be specified");
        }
        if (!persistableBundle.containsKey(RESPONSE_KEY_RESULT)) {
            throw new IllegalArgumentException("RESPONSE_KEY_RESULT must be specified");
        }
        try {
            if (this.mService != null) {
                this.mService.notifyPermissionResponse(str, persistableBundle);
            }
        } catch (RemoteException e) {
            Log.w(TAG, "Couldn't reach service");
        }
    }

    public void requestPermission(String str, String str2, PersistableBundle persistableBundle) {
        if (str == null) {
            throw new NullPointerException("requestType cannot be null");
        }
        if (str2 == null) {
            throw new NullPointerException("requestId cannot be null");
        }
        if (persistableBundle == null) {
            throw new NullPointerException("request cannot be null");
        }
        try {
            if (this.mService != null) {
                this.mService.requestPermission(this.mContext.getPackageName(), str, str2, persistableBundle);
            }
        } catch (RemoteException e) {
            Log.w(TAG, "Couldn't reach service");
        }
    }
}
