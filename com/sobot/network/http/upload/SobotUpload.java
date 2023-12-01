package com.sobot.network.http.upload;

import android.util.Log;
import com.sobot.network.http.model.SobotProgress;
import com.sobot.network.http.request.RequestCall;
import com.sobot.network.http.task.XExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/upload/SobotUpload.class */
public class SobotUpload {
    private static SobotUpload instance;
    private SobotUploadThreadPool threadPool = new SobotUploadThreadPool();
    private Map<String, SobotUploadTask<?>> taskMap = new LinkedHashMap();

    private SobotUpload() {
    }

    public static SobotUpload getInstance() {
        if (instance == null) {
            synchronized (SobotUpload.class) {
                try {
                    if (instance == null) {
                        instance = new SobotUpload();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static <T> SobotUploadTask<T> request(String str, RequestCall requestCall) {
        Map<String, SobotUploadTask<?>> taskMap = getInstance().getTaskMap();
        SobotUploadTask<?> sobotUploadTask = taskMap.get(str);
        SobotUploadTask<?> sobotUploadTask2 = sobotUploadTask;
        if (sobotUploadTask == null) {
            sobotUploadTask2 = new SobotUploadTask<>(str, requestCall);
            taskMap.put(str, sobotUploadTask2);
        }
        return (SobotUploadTask<T>) sobotUploadTask2;
    }

    public static <T> SobotUploadTask<T> restore(SobotProgress sobotProgress) {
        Map<String, SobotUploadTask<?>> taskMap = getInstance().getTaskMap();
        SobotUploadTask<?> sobotUploadTask = taskMap.get(sobotProgress.tag);
        SobotUploadTask<?> sobotUploadTask2 = sobotUploadTask;
        if (sobotUploadTask == null) {
            sobotUploadTask2 = new SobotUploadTask<>(sobotProgress);
            taskMap.put(sobotProgress.tag, sobotUploadTask2);
        }
        return (SobotUploadTask<T>) sobotUploadTask2;
    }

    public static List<SobotUploadTask<?>> restore(List<SobotProgress> list) {
        Map<String, SobotUploadTask<?>> taskMap = getInstance().getTaskMap();
        ArrayList arrayList = new ArrayList();
        for (SobotProgress sobotProgress : list) {
            SobotUploadTask<?> sobotUploadTask = taskMap.get(sobotProgress.tag);
            SobotUploadTask<?> sobotUploadTask2 = sobotUploadTask;
            if (sobotUploadTask == null) {
                sobotUploadTask2 = new SobotUploadTask<>(sobotProgress);
                taskMap.put(sobotProgress.tag, sobotUploadTask2);
            }
            arrayList.add(sobotUploadTask2);
        }
        return arrayList;
    }

    public void addOnAllTaskEndListener(XExecutor.OnAllTaskEndListener onAllTaskEndListener) {
        this.threadPool.getExecutor().addOnAllTaskEndListener(onAllTaskEndListener);
    }

    public SobotUploadTask<?> getTask(String str) {
        return this.taskMap.get(str);
    }

    public Map<String, SobotUploadTask<?>> getTaskMap() {
        return this.taskMap;
    }

    public SobotUploadThreadPool getThreadPool() {
        return this.threadPool;
    }

    public boolean hasTask(String str) {
        return this.taskMap.containsKey(str);
    }

    public void pauseAll() {
        for (Map.Entry<String, SobotUploadTask<?>> entry : this.taskMap.entrySet()) {
            SobotUploadTask<?> value = entry.getValue();
            if (value == null) {
                Log.w("", "can't find task with tag = " + entry.getKey());
            } else if (value.progress.status != 2) {
                value.pause();
            }
        }
        for (Map.Entry<String, SobotUploadTask<?>> entry2 : this.taskMap.entrySet()) {
            SobotUploadTask<?> value2 = entry2.getValue();
            if (value2 == null) {
                Log.w("", "can't find task with tag = " + entry2.getKey());
            } else if (value2.progress.status == 2) {
                value2.pause();
            }
        }
    }

    public void removeAll() {
        HashMap hashMap = new HashMap(this.taskMap);
        for (Map.Entry entry : hashMap.entrySet()) {
            SobotUploadTask sobotUploadTask = (SobotUploadTask) entry.getValue();
            if (sobotUploadTask == null) {
                Log.w("", "can't find task with tag = " + ((String) entry.getKey()));
            } else if (sobotUploadTask.progress.status != 2) {
                sobotUploadTask.remove();
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            SobotUploadTask sobotUploadTask2 = (SobotUploadTask) entry2.getValue();
            if (sobotUploadTask2 == null) {
                Log.w("", "can't find task with tag = " + ((String) entry2.getKey()));
            } else if (sobotUploadTask2.progress.status == 2) {
                sobotUploadTask2.remove();
            }
        }
    }

    public void removeOnAllTaskEndListener(XExecutor.OnAllTaskEndListener onAllTaskEndListener) {
        this.threadPool.getExecutor().removeOnAllTaskEndListener(onAllTaskEndListener);
    }

    public SobotUploadTask<?> removeTask(String str) {
        return this.taskMap.remove(str);
    }

    public void startAll() {
        for (Map.Entry<String, SobotUploadTask<?>> entry : this.taskMap.entrySet()) {
            SobotUploadTask<?> value = entry.getValue();
            if (value == null) {
                Log.w("", "can't find task with tag = " + entry.getKey());
            } else {
                value.start();
            }
        }
    }

    public void unRegister() {
        for (SobotUploadTask<?> sobotUploadTask : this.taskMap.values()) {
            sobotUploadTask.listeners.clear();
        }
    }
}
