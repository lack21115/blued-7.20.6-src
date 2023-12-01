package com.danlan.android.cognition.collector;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.PermissionUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/SimCardCollector.class */
public class SimCardCollector extends SubCollector {
    private List<String> mSimIDs;
    private Context mcontext;
    private final PermissionUtil permissionUtils;
    private TelephonyManager telephonyManager;
    private static final String FUN_SIM_STATE = StringFog.decrypt("RkZQcEhOd1VAV0E=");
    private static final String FUN_SIM_SERIAL_NUMBER = StringFog.decrypt("RkZQcEhOd0RTSkVPb1ZJQ0RR");
    private static final String FUN_SIM_COUNTRY_ISO = StringFog.decrypt("RkZQcEhOZ05UTVBRWGpXTg==");
    private static final String FUN_SIM_OPERATOR = StringFog.decrypt("RkZQcEhOa1FEUUVXTlE=");
    private static final String FUN_SIM_IMSI = StringFog.decrypt("RkZQcFRBV0JTSkZGU2pA");
    private static final String FUN_NETWORK_TYPE = StringFog.decrypt("RkZQbURXU05TSHBaUUY=");
    private static final String FUN_NETWORK_OPERATOR_NAME = StringFog.decrypt("RkZQbURXU05TSGtTRFFFVU5RakJMRg==");

    public SimCardCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mSimIDs = new ArrayList();
        this.telephonyManager = null;
        this.permissionUtils = new PermissionUtil(context);
        this.mcontext = context;
    }

    private String getOperatorBySlot(Context context, String str, int i) {
        if (this.telephonyManager == null) {
            this.telephonyManager = (TelephonyManager) context.getSystemService(StringFog.decrypt("UUtLTUQ="));
        }
        try {
            Object invoke = Class.forName(this.telephonyManager.getClass().getName()).getMethod(str, Integer.TYPE).invoke(this.telephonyManager, Integer.valueOf(i));
            return invoke != null ? invoke.toString() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private JSONArray getSimCardInfo() {
        JSONArray jSONArray = new JSONArray();
        if (Build.VERSION.SDK_INT >= 22) {
            SubscriptionManager subscriptionManager = (SubscriptionManager) this.mContext.getSystemService(StringFog.decrypt("VUZIRlFLS09YfFdWQ1BHU0hTUEpOTXtSRFFSSkJG"));
            if (subscriptionManager != null) {
                try {
                    List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
                    if (activeSubscriptionInfoList != null) {
                        for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                            SafeJSONObject safeJSONObject = new SafeJSONObject();
                            safeJSONObject.put(StringFog.decrypt("UkpJYE5WSlVTWm1QTg=="), subscriptionInfo.getCountryIso());
                            String decrypt = StringFog.decrypt("UkpJbFFGVkBVTFY=");
                            safeJSONObject.put(decrypt, subscriptionInfo.getMcc() + "" + subscriptionInfo.getMnc());
                            if (Build.VERSION.SDK_INT >= 24) {
                                if (this.telephonyManager == null) {
                                    this.telephonyManager = (TelephonyManager) this.mcontext.getSystemService(StringFog.decrypt("UUtLTUQ="));
                                }
                                TelephonyManager createForSubscriptionId = this.telephonyManager.createForSubscriptionId(subscriptionInfo.getSubscriptionId());
                                safeJSONObject.put(StringFog.decrypt("UkpJcFVCUEQ="), String.valueOf(createForSubscriptionId.getSimState()));
                                safeJSONObject.put(StringFog.decrypt("T0ZQVE5RT3VYU0E="), String.valueOf(createForSubscriptionId.getNetworkType()));
                                safeJSONObject.put(StringFog.decrypt("T0ZQVE5RT25RRlZCVUxWb0BOQQ=="), createForSubscriptionId.getNetworkOperatorName());
                            } else {
                                safeJSONObject.put(StringFog.decrypt("UkpJcFVCUEQ="), getOperatorBySlot(this.mContext, FUN_SIM_STATE, subscriptionInfo.getSubscriptionId()));
                                safeJSONObject.put(StringFog.decrypt("T0ZQVE5RT3VYU0E="), getOperatorBySlot(this.mContext, FUN_NETWORK_TYPE, subscriptionInfo.getSubscriptionId()));
                                safeJSONObject.put(StringFog.decrypt("T0ZQVE5RT25RRlZCVUxWb0BOQQ=="), subscriptionInfo.getCarrierName());
                            }
                            this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E="));
                            safeJSONObject.put(StringFog.decrypt("SE5XSg=="), "");
                            jSONArray.put(safeJSONObject);
                        }
                    }
                } catch (Exception e) {
                    return jSONArray;
                }
            }
        } else {
            initSimIDsByReadFile();
            if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E="))) {
                for (String str : this.mSimIDs) {
                    SafeJSONObject safeJSONObject2 = new SafeJSONObject();
                    safeJSONObject2.put(StringFog.decrypt("UkpJYE5WSlVTWm1QTg=="), getOperatorBySlot(this.mContext, FUN_SIM_COUNTRY_ISO, Integer.valueOf(str).intValue()));
                    safeJSONObject2.put(StringFog.decrypt("UkpJbFFGVkBVTFY="), getOperatorBySlot(this.mContext, FUN_SIM_OPERATOR, Integer.valueOf(str).intValue()));
                    safeJSONObject2.put(StringFog.decrypt("T0ZQVE5RT3VYU0E="), getOperatorBySlot(this.mContext, FUN_NETWORK_TYPE, Integer.valueOf(str).intValue()));
                    safeJSONObject2.put(StringFog.decrypt("T0ZQVE5RT25RRlZCVUxWb0BOQQ=="), getOperatorBySlot(this.mContext, FUN_NETWORK_OPERATOR_NAME, Integer.valueOf(str).intValue()));
                    safeJSONObject2.put(StringFog.decrypt("UkpJcFVCUEQ="), getOperatorBySlot(this.mContext, FUN_SIM_STATE, Integer.valueOf(str).intValue()));
                    safeJSONObject2.put(StringFog.decrypt("SE5XSg=="), "");
                    jSONArray.put(safeJSONObject2);
                }
            }
        }
        return jSONArray;
    }

    private void initSimIDsByReadFile() {
        Cursor query = this.mContext.getContentResolver().query(Uri.parse(StringFog.decrypt("QkxKV0RNUBsODFBGTUZUSU5NXQxSSklIT0VL")), new String[]{StringFog.decrypt("fkpA"), StringFog.decrypt("SEBHfEhH"), StringFog.decrypt("UkpJfEhH"), StringFog.decrypt("RUpXU01CXX5PQklG"), StringFog.decrypt("QkJWUUhGVn5PQklG"), StringFog.decrypt("T0JJRn5QS1RTQEE="), StringFog.decrypt("QkxITFM="), StringFog.decrypt("T1ZJQURR"), StringFog.decrypt("RUpXU01CXX5PVklBRFF7R05RSUJV"), StringFog.decrypt("RUJQQn5RS0BMSkpE"), StringFog.decrypt("TEBH"), StringFog.decrypt("TE1H")}, null, null, null);
        if (query != null) {
            this.mSimIDs = new ArrayList();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex(StringFog.decrypt("fkpA")));
                if (Integer.valueOf(query.getString(query.getColumnIndex(StringFog.decrypt("UkpJfEhH")))).intValue() >= 0) {
                    this.mSimIDs.add(string);
                }
            }
            query.close();
        }
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("UkpJcE1MUGJOVkpX"), getPhoneCount(this.mContext));
            safeJSONObject.put(StringFog.decrypt("UkpJYkJXTVdEYEtWT1c="), getSimCount(this.mContext));
            safeJSONObject.put(StringFog.decrypt("SFB3SkxtQVVWTFZIbUxHSkRH"), isSimNetworkLocked());
            safeJSONObject.put(StringFog.decrypt("UkpJak9FSw=="), getSimCardInfo());
            safeJSONObject.put(StringFog.decrypt("UkpJbFVLQVNoTUJM"), getSimOtherInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        put(StringFog.decrypt("UkpJ"), safeJSONObject);
        collectDone();
    }

    public int getPhoneCount(Context context) {
        try {
            if (this.telephonyManager == null) {
                this.telephonyManager = (TelephonyManager) context.getSystemService(StringFog.decrypt("UUtLTUQ="));
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 21 || i > 22) {
                if (i >= 23) {
                    return this.telephonyManager.getPhoneCount();
                }
                return 1;
            }
            return ((Integer) this.telephonyManager.getClass().getDeclaredMethod(StringFog.decrypt("RkZQc0lMSkRiTFFNVQ=="), new Class[0]).invoke(this.telephonyManager, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int getSimCount(Context context) {
        int i = Build.VERSION.SDK_INT;
        int i2 = 0;
        try {
            if (i < 21) {
                if (!this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E="))) {
                    return -1;
                }
                if (this.telephonyManager == null) {
                    this.telephonyManager = (TelephonyManager) context.getSystemService(StringFog.decrypt("UUtLTUQ="));
                }
                if (this.telephonyManager.getSimState() == 5) {
                    return 1;
                }
            } else if (i == 21) {
                try {
                    if (!this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E="))) {
                        return -1;
                    }
                    Class<?> cls = Class.forName(StringFog.decrypt("QE1AUU5KQA9VRkhGUUtLT1gNd1ZDUEdTSFNQSk5NaUBPQkNGUw=="));
                    i2 = ((Integer) cls.getDeclaredMethod(StringFog.decrypt("RkZQYkJXTVdEcFFBaE1CTmJMUU1V"), new Class[0]).invoke(cls, new Object[0])).intValue();
                } catch (ClassNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    return 0;
                } catch (IllegalAccessException e2) {
                    e = e2;
                    e.printStackTrace();
                    return 0;
                } catch (NoSuchMethodException e3) {
                    e = e3;
                    e.printStackTrace();
                    return 0;
                } catch (InvocationTargetException e4) {
                    e = e4;
                    e.printStackTrace();
                    return 0;
                }
            } else if (i >= 22) {
                SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService(StringFog.decrypt("VUZIRlFLS09YfFdWQ1BHU0hTUEpOTXtSRFFSSkJG"));
                if (!this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E="))) {
                    return -1;
                }
                i2 = subscriptionManager.getActiveSubscriptionInfoCount();
            }
            return i2;
        } catch (Exception e5) {
            e = e5;
        }
    }

    public final SafeJSONObject getSimOtherInfo() {
        String decrypt;
        String decrypt2;
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        if (NativeLib.checkLoadSo()) {
            safeJSONObject.put(StringFog.decrypt("RlBJfFJKSX5OU0FRQFdLU35CSFNJQg=="), NativeLib.pg(StringFog.decrypt("RlBJDVJKSQ9OU0FRQFdLUw9CSFNJQg=="), StringFog.decrypt("VE1PTU5USg==")));
            safeJSONObject.put(StringFog.decrypt("RlBJfFJKSX5OU0FRQFdLU35KV0wMQEtUT1dWWg=="), NativeLib.pg(StringFog.decrypt("RlBJDVJKSQ9OU0FRQFdLUw9KV0wMQEtUT1dWWg=="), StringFog.decrypt("VE1PTU5USg==")));
            safeJSONObject.put(StringFog.decrypt("RlBJfFJKSX5SV0VXRA=="), NativeLib.pg(StringFog.decrypt("RlBJDVJKSQ9SV0VXRA=="), StringFog.decrypt("VE1PTU5USg==")));
            safeJSONObject.put(StringFog.decrypt("RlBJfE9GUFZOUU98VVpURA=="), NativeLib.pg(StringFog.decrypt("RlBJDU9GUFZOUU8NVVpURA=="), StringFog.decrypt("VE1PTU5USg==")));
            safeJSONObject.put(StringFog.decrypt("RlBJfE5TQVNAV0tRfkJIUUlC"), NativeLib.pg(StringFog.decrypt("RlBJDU5TQVNAV0tRD0JIUUlC"), StringFog.decrypt("VE1PTU5USg==")));
            safeJSONObject.put(StringFog.decrypt("RlBJfE5TQVNAV0tRfkpXTgxAS1ZPV1ZY"), NativeLib.pg(StringFog.decrypt("RlBJDU5TQVNAV0tRD0pXTgxAS1ZPV1ZY"), StringFog.decrypt("VE1PTU5USg==")));
            decrypt = StringFog.decrypt("RlBJfE5TQVNAV0tRfk1RTERRTUA=");
            decrypt2 = NativeLib.pg(StringFog.decrypt("RlBJDU5TQVNAV0tRD01RTERRTUA="), StringFog.decrypt("VE1PTU5USg=="));
        } else {
            safeJSONObject.put(StringFog.decrypt("RlBJfFJKSX5OU0FRQFdLU35CSFNJQg=="), StringFog.decrypt("VE1PTU5USg=="));
            safeJSONObject.put(StringFog.decrypt("RlBJfFJKSX5OU0FRQFdLU35KV0wMQEtUT1dWWg=="), StringFog.decrypt("VE1PTU5USg=="));
            safeJSONObject.put(StringFog.decrypt("RlBJfFJKSX5SV0VXRA=="), StringFog.decrypt("VE1PTU5USg=="));
            safeJSONObject.put(StringFog.decrypt("RlBJfE9GUFZOUU98VVpURA=="), StringFog.decrypt("VE1PTU5USg=="));
            safeJSONObject.put(StringFog.decrypt("RlBJfE5TQVNAV0tRfkJIUUlC"), StringFog.decrypt("VE1PTU5USg=="));
            safeJSONObject.put(StringFog.decrypt("RlBJfE5TQVNAV0tRfkpXTgxAS1ZPV1ZY"), StringFog.decrypt("VE1PTU5USg=="));
            decrypt = StringFog.decrypt("RlBJfE5TQVNAV0tRfk1RTERRTUA=");
            decrypt2 = StringFog.decrypt("VE1PTU5USg==");
        }
        safeJSONObject.put(decrypt, decrypt2);
        return safeJSONObject;
    }

    public final boolean isSimNetworkLocked() {
        if (this.permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E="))) {
            TelephonyManager telephonyManager = (TelephonyManager) this.mcontext.getSystemService(StringFog.decrypt("UUtLTUQ="));
            this.telephonyManager = telephonyManager;
            return telephonyManager != null && telephonyManager.getSimState() == 4;
        }
        return false;
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void reset() {
        this.mSimIDs.clear();
    }
}
