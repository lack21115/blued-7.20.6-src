package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsReaderView.class */
public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";
    static boolean f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";

    /* renamed from: a  reason: collision with root package name */
    Context f38786a;
    ReaderWizard b;

    /* renamed from: c  reason: collision with root package name */
    Object f38787c;
    ReaderCallback d;
    ReaderCallback e;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsReaderView$ReaderCallback.class */
    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) throws RuntimeException {
        super(context.getApplicationContext());
        this.f38786a = null;
        this.b = null;
        this.f38787c = null;
        this.d = null;
        this.e = null;
        if (!(context instanceof Activity)) {
            throw new RuntimeException("error: unexpect context(none Activity)");
        }
        this.d = readerCallback;
        this.f38786a = context;
        this.e = new ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderView.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                TbsReaderView tbsReaderView;
                String str;
                Integer num2;
                Bundle bundle;
                TbsReaderView tbsReaderView2;
                String str2;
                boolean z;
                Integer num3;
                Object obj3;
                int intValue = num.intValue();
                String str3 = "";
                Bundle bundle2 = null;
                if (intValue != 5026) {
                    if (intValue != 5030) {
                        switch (intValue) {
                            case 5008:
                                if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.f38786a)) {
                                    num2 = 5011;
                                    String resString = TbsReaderView.getResString(TbsReaderView.this.f38786a, ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
                                    bundle = new Bundle();
                                    bundle.putString("tip", resString);
                                    bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD);
                                    bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PDF_ID);
                                    tbsReaderView2 = TbsReaderView.this;
                                    str2 = TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DIALOG;
                                    tbsReaderView2.userStatistics(str2);
                                    Bundle bundle3 = bundle;
                                    num = num2;
                                    obj = bundle3;
                                    z = false;
                                    num3 = num;
                                    obj3 = obj;
                                    break;
                                } else {
                                    Bundle bundle4 = null;
                                    if (obj != null) {
                                        bundle4 = (Bundle) obj;
                                        str3 = bundle4.getString("docpath");
                                    }
                                    QbSdk.startQBForDoc(TbsReaderView.this.f38786a, str3, 4, 0, "pdf", bundle4);
                                    tbsReaderView = TbsReaderView.this;
                                    str = TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_BROWSER;
                                    tbsReaderView.userStatistics(str);
                                    z = true;
                                    num3 = num;
                                    obj3 = obj;
                                    break;
                                }
                            case 5009:
                                if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.f38786a)) {
                                    num2 = 5011;
                                    String resString2 = TbsReaderView.getResString(TbsReaderView.this.f38786a, 5021);
                                    bundle = new Bundle();
                                    bundle.putString("tip", resString2);
                                    bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD);
                                    bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_PPT_ID);
                                    tbsReaderView2 = TbsReaderView.this;
                                    str2 = TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DIALOG;
                                    tbsReaderView2.userStatistics(str2);
                                    Bundle bundle32 = bundle;
                                    num = num2;
                                    obj = bundle32;
                                    z = false;
                                    num3 = num;
                                    obj3 = obj;
                                    break;
                                } else {
                                    Bundle bundle5 = null;
                                    if (obj != null) {
                                        bundle5 = (Bundle) obj;
                                        str3 = bundle5.getString("docpath");
                                    }
                                    QbSdk.startQBForDoc(TbsReaderView.this.f38786a, str3, 4, 0, "", bundle5);
                                    tbsReaderView = TbsReaderView.this;
                                    str = TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_BROWSER;
                                    tbsReaderView.userStatistics(str);
                                    z = true;
                                    num3 = num;
                                    obj3 = obj;
                                    break;
                                }
                            case 5010:
                                if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.f38786a)) {
                                    num2 = 5011;
                                    String resString3 = TbsReaderView.getResString(TbsReaderView.this.f38786a, 5022);
                                    bundle = new Bundle();
                                    bundle.putString("tip", resString3);
                                    bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD);
                                    bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_TXT_ID);
                                    tbsReaderView2 = TbsReaderView.this;
                                    str2 = TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DIALOG;
                                    tbsReaderView2.userStatistics(str2);
                                    Bundle bundle322 = bundle;
                                    num = num2;
                                    obj = bundle322;
                                    z = false;
                                    num3 = num;
                                    obj3 = obj;
                                    break;
                                } else {
                                    if (obj != null) {
                                        bundle2 = (Bundle) obj;
                                        str3 = bundle2.getString("docpath");
                                    }
                                    QbSdk.startQBForDoc(TbsReaderView.this.f38786a, str3, 4, 0, "txt", bundle2);
                                    z = true;
                                    num3 = num;
                                    obj3 = obj;
                                    break;
                                }
                            default:
                                z = false;
                                num3 = num;
                                obj3 = obj;
                                break;
                        }
                    } else {
                        z = true;
                        num3 = num;
                        obj3 = obj;
                        if (obj != null) {
                            Bundle bundle6 = (Bundle) obj;
                            TbsReaderView.gReaderPackName = bundle6.getString("name");
                            TbsReaderView.gReaderPackVersion = bundle6.getString("version");
                            z = true;
                            num3 = num;
                            obj3 = obj;
                        }
                    }
                } else if (MttLoader.isBrowserInstalledEx(TbsReaderView.this.f38786a)) {
                    Bundle bundle7 = null;
                    if (obj != null) {
                        bundle7 = (Bundle) obj;
                        str3 = bundle7.getString("docpath");
                    }
                    QbSdk.startQBForDoc(TbsReaderView.this.f38786a, str3, 4, 0, "doc", bundle7);
                    tbsReaderView = TbsReaderView.this;
                    str = TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_BROWSER;
                    tbsReaderView.userStatistics(str);
                    z = true;
                    num3 = num;
                    obj3 = obj;
                } else {
                    num2 = 5011;
                    String resString4 = TbsReaderView.getResString(TbsReaderView.this.f38786a, ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
                    bundle = new Bundle();
                    bundle.putString("tip", resString4);
                    bundle.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD);
                    bundle.putInt("channel_id", TbsReaderView.READER_CHANNEL_DOC_ID);
                    tbsReaderView2 = TbsReaderView.this;
                    str2 = TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DIALOG;
                    tbsReaderView2.userStatistics(str2);
                    Bundle bundle3222 = bundle;
                    num = num2;
                    obj = bundle3222;
                    z = false;
                    num3 = num;
                    obj3 = obj;
                }
                if (TbsReaderView.this.d == null || z) {
                    return;
                }
                TbsReaderView.this.d.onCallBackAction(num3, obj3, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        if (!f) {
            f.a(true).a(context.getApplicationContext(), true, false);
            f = f.a(false).b();
        }
        return f;
    }

    public static Drawable getResDrawable(Context context, int i) {
        if (a(context)) {
            return ReaderWizard.getResDrawable(i);
        }
        return null;
    }

    public static String getResString(Context context, int i) {
        return a(context) ? ReaderWizard.getResString(i) : "";
    }

    public static boolean isSupportExt(Context context, String str) {
        boolean z = false;
        if (a(context)) {
            z = false;
            if (ReaderWizard.isSupportCurrentPlatform(context)) {
                z = false;
                if (ReaderWizard.isSupportExt(str)) {
                    z = true;
                }
            }
        }
        return z;
    }

    boolean a() {
        try {
            if (this.b == null) {
                this.b = new ReaderWizard(this.e);
            }
            if (this.f38787c == null) {
                this.f38787c = this.b.getTbsReader();
            }
            if (this.f38787c != null) {
                return this.b.initTbsReader(this.f38787c, this.f38786a);
            }
            return false;
        } catch (NullPointerException e) {
            Log.e(TAG, "Unexpect null object!");
            return false;
        }
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        Object obj3;
        ReaderWizard readerWizard = this.b;
        if (readerWizard == null || (obj3 = this.f38787c) == null) {
            return;
        }
        readerWizard.doCommand(obj3, num, obj, obj2);
    }

    public boolean downloadPlugin(String str) {
        Object obj = this.f38787c;
        if (obj == null) {
            Log.e(TAG, "downloadPlugin failed!");
            return false;
        }
        return this.b.checkPlugin(obj, this.f38786a, str, true);
    }

    public void onSizeChanged(int i, int i2) {
        Object obj;
        ReaderWizard readerWizard = this.b;
        if (readerWizard == null || (obj = this.f38787c) == null) {
            return;
        }
        readerWizard.onSizeChanged(obj, i, i2);
    }

    public void onStop() {
        ReaderWizard readerWizard = this.b;
        if (readerWizard != null) {
            readerWizard.destroy(this.f38787c);
            this.f38787c = null;
        }
        this.f38786a = null;
        f = false;
    }

    public void openFile(Bundle bundle) {
        if (this.f38787c == null || bundle == null) {
            Log.e(TAG, "init failed!");
            return;
        }
        bundle.putBoolean("browser6.0", MttLoader.isBrowserInstalledEx(this.f38786a) | (!MttLoader.isBrowserInstalled(this.f38786a)));
        bundle.putBoolean("browser6.1", MttLoader.isGreatBrowserVer(this.f38786a, 6101625L, 610000L) | (!MttLoader.isBrowserInstalled(this.f38786a)));
        if (this.b.openFile(this.f38787c, this.f38786a, bundle, this)) {
            return;
        }
        Log.e(TAG, "OpenFile failed!");
    }

    public boolean preOpen(String str, boolean z) {
        if (!isSupportExt(this.f38786a, str)) {
            Log.e(TAG, "not supported by:" + str);
            return false;
        }
        boolean a2 = a(this.f38786a);
        boolean z2 = a2;
        if (a2) {
            boolean a3 = a();
            z2 = a3;
            if (z) {
                z2 = a3;
                if (a3) {
                    boolean z3 = false;
                    if (Apn.getApnType(this.f38786a) == 3) {
                        z3 = true;
                    }
                    z2 = this.b.checkPlugin(this.f38787c, this.f38786a, str, z3);
                }
            }
        }
        return z2;
    }

    public void userStatistics(String str) {
        ReaderWizard readerWizard = this.b;
        if (readerWizard != null) {
            readerWizard.userStatistics(this.f38787c, str);
        }
    }
}
