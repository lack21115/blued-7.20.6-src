package com.sobot.network.http.download;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.sobot.network.apiUtils.SobotHttpGlobalContext;
import com.sobot.network.http.db.SobotDownloadManager;
import com.sobot.network.http.log.SobotNetLogUtils;
import com.sobot.network.http.model.SobotProgress;
import com.sobot.network.http.request.RequestCall;
import com.sobot.network.http.task.XExecutor;
import com.sobot.network.http.utils.IOUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/download/SobotDownload.class */
public class SobotDownload {
    private static final String CACHE_DIR = "cache";
    private static final String ROOT_DIR = "sobot";
    private static SobotDownload instance;
    private String folder;
    private ConcurrentHashMap<String, SobotDownloadTask> taskMap;
    private SobotDownloadThreadPool threadPool;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/download/SobotDownload$CancelTagType.class */
    public interface CancelTagType {
        public static final String SOBOT_TAG_CHATROOM = "tag_chatroom";
        public static final String SOBOT_TAG_DOWNLOAD_ACT = "tag_download_act";
    }

    private SobotDownload() {
        String str = getSDCardRootPath(SobotHttpGlobalContext.getAppContext()) + "download" + File.separator;
        this.folder = str;
        IOUtils.createFolder(str);
        this.threadPool = new SobotDownloadThreadPool();
        this.taskMap = new ConcurrentHashMap<>();
        SobotDownloadManager.getInstance().updateDownloading2None();
    }

    public static String encode(String str) {
        String str2 = str;
        if (str != null) {
            Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
            while (true) {
                str2 = str;
                if (!matcher.find()) {
                    break;
                }
                String group = matcher.group();
                try {
                    str = str.replaceAll(group, URLEncoder.encode(group, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return str2;
    }

    public static SobotDownload getInstance() {
        if (instance == null) {
            synchronized (SobotDownload.class) {
                try {
                    if (instance == null) {
                        instance = new SobotDownload();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static String getRootDir(Context context) {
        String packageName = context != null ? context.getPackageName() : "";
        return Environment.getExternalStorageDirectory().getPath() + File.separator + ROOT_DIR + File.separator + encode(packageName + File.separator + CACHE_DIR);
    }

    public static String getSDCardRootPath(Context context) {
        String str;
        if (context == null) {
            SobotNetLogUtils.i("context为空：SobotHttpUtils init 没有初始化");
            return "";
        } else if (!isExitsSdcard()) {
            String str2 = context.getFilesDir().getPath() + File.separator + ROOT_DIR;
            SobotNetLogUtils.i("外部存储不可用 存储路径：" + str2);
            return str2;
        } else {
            if (Build.VERSION.SDK_INT < 29) {
                str = getRootDir(context) + File.separator;
            } else {
                str = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath() + File.separator + CACHE_DIR + File.separator;
            }
            SobotNetLogUtils.i("SD卡已装入 存储路径：" + str);
            return str;
        }
    }

    public static boolean isExitsSdcard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static SobotDownloadTask request(String str, RequestCall requestCall) {
        Map<String, SobotDownloadTask> taskMap = getInstance().getTaskMap();
        SobotDownloadTask sobotDownloadTask = taskMap.get(str);
        SobotDownloadTask sobotDownloadTask2 = sobotDownloadTask;
        if (sobotDownloadTask == null) {
            sobotDownloadTask2 = new SobotDownloadTask(str, requestCall);
            taskMap.put(str, sobotDownloadTask2);
        }
        return sobotDownloadTask2;
    }

    public static SobotDownloadTask restore(SobotProgress sobotProgress) {
        Map<String, SobotDownloadTask> taskMap = getInstance().getTaskMap();
        SobotDownloadTask sobotDownloadTask = taskMap.get(sobotProgress.tag);
        SobotDownloadTask sobotDownloadTask2 = sobotDownloadTask;
        if (sobotDownloadTask == null) {
            sobotDownloadTask2 = new SobotDownloadTask(sobotProgress);
            taskMap.put(sobotProgress.tag, sobotDownloadTask2);
        }
        return sobotDownloadTask2;
    }

    public static List<SobotDownloadTask> restore(List<SobotProgress> list) {
        Map<String, SobotDownloadTask> taskMap = getInstance().getTaskMap();
        ArrayList arrayList = new ArrayList();
        for (SobotProgress sobotProgress : list) {
            SobotDownloadTask sobotDownloadTask = taskMap.get(sobotProgress.tag);
            SobotDownloadTask sobotDownloadTask2 = sobotDownloadTask;
            if (sobotDownloadTask == null) {
                sobotDownloadTask2 = new SobotDownloadTask(sobotProgress);
                taskMap.put(sobotProgress.tag, sobotDownloadTask2);
            }
            arrayList.add(sobotDownloadTask2);
        }
        return arrayList;
    }

    public void addOnAllTaskEndListener(XExecutor.OnAllTaskEndListener onAllTaskEndListener) {
        this.threadPool.getExecutor().addOnAllTaskEndListener(onAllTaskEndListener);
    }

    public String getFolder() {
        return this.folder;
    }

    public SobotDownloadTask getTask(String str) {
        return this.taskMap.get(str);
    }

    public Map<String, SobotDownloadTask> getTaskMap() {
        return this.taskMap;
    }

    public SobotDownloadThreadPool getThreadPool() {
        return this.threadPool;
    }

    public boolean hasTask(String str) {
        return this.taskMap.containsKey(str);
    }

    public void initFolder(String str) {
        setFolder(Environment.getExternalStorageDirectory() + File.separator + "download" + File.separator + str + File.separator);
    }

    public void pauseAll() {
        for (Map.Entry<String, SobotDownloadTask> entry : this.taskMap.entrySet()) {
            SobotDownloadTask value = entry.getValue();
            if (value != null && value.progress.status != 2) {
                value.pause();
            }
        }
        for (Map.Entry<String, SobotDownloadTask> entry2 : this.taskMap.entrySet()) {
            SobotDownloadTask value2 = entry2.getValue();
            if (value2 != null && value2.progress.status == 2) {
                value2.pause();
            }
        }
    }

    public void removeAll() {
        removeAll(false);
    }

    public void removeAll(boolean z) {
        HashMap hashMap = new HashMap(this.taskMap);
        for (Map.Entry entry : hashMap.entrySet()) {
            SobotDownloadTask sobotDownloadTask = (SobotDownloadTask) entry.getValue();
            if (sobotDownloadTask != null && sobotDownloadTask.progress.status != 2) {
                sobotDownloadTask.remove(z);
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            SobotDownloadTask sobotDownloadTask2 = (SobotDownloadTask) entry2.getValue();
            if (sobotDownloadTask2 != null && sobotDownloadTask2.progress.status == 2) {
                sobotDownloadTask2.remove(z);
            }
        }
    }

    public void removeOnAllTaskEndListener(XExecutor.OnAllTaskEndListener onAllTaskEndListener) {
        this.threadPool.getExecutor().removeOnAllTaskEndListener(onAllTaskEndListener);
    }

    public SobotDownloadTask removeTask(String str) {
        return this.taskMap.remove(str);
    }

    public SobotDownload setFolder(String str) {
        this.folder = str;
        return this;
    }

    public void startAll() {
        for (Map.Entry<String, SobotDownloadTask> entry : this.taskMap.entrySet()) {
            SobotDownloadTask value = entry.getValue();
            if (value != null) {
                value.start();
            }
        }
    }

    public void unRegister(String str) {
        getInstance().getTaskMap();
        for (SobotDownloadTask sobotDownloadTask : this.taskMap.values()) {
            sobotDownloadTask.unRegister(str);
        }
    }
}
