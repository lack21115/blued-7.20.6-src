package com.ss.android.socialbase.downloader.utils;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/utils/DownloadStenographer.class */
public class DownloadStenographer {
    private static final int MAX_NODE_COUNT = 20;
    private static final int SECONDS_TO_MILLS = 1000;
    private int count;
    private Node head;
    private int maxCount;
    private Node tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/utils/DownloadStenographer$Node.class */
    public static class Node {
        long curBytes;
        Node next;
        Node prev;
        long when;

        private Node() {
        }
    }

    public DownloadStenographer() {
        this.maxCount = 10;
    }

    public DownloadStenographer(int i) {
        this.maxCount = i > 20 ? 20 : i;
    }

    private Node findFirstNodeNearWhen(long j) {
        Node node = this.head;
        Node node2 = null;
        while (node != null && node.when > j) {
            node2 = node;
            node = node.next;
        }
        return (node == null || node2 == null || node == node2 || j - node.when >= node2.when - j) ? node2 : node;
    }

    private Node obtainNode() {
        Node node;
        if (this.count < this.maxCount || (node = this.tail) == null) {
            this.count++;
            return new Node();
        }
        Node node2 = node.prev;
        node.prev = null;
        this.tail = node2;
        if (node2 != null) {
            node2.next = null;
        }
        return node;
    }

    public long getRecentDownloadSpeed(long j, long j2) {
        synchronized (this) {
            Node node = this.head;
            if (node == null) {
                return -1L;
            }
            Node findFirstNodeNearWhen = findFirstNodeNearWhen(j);
            if (findFirstNodeNearWhen == null) {
                return -1L;
            }
            long j3 = node.curBytes - findFirstNodeNearWhen.curBytes;
            long j4 = j2 - findFirstNodeNearWhen.when;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    public boolean markProgress(long j, long j2) {
        synchronized (this) {
            Node node = this.head;
            if (node != null) {
                if (j >= node.curBytes && j2 >= node.when) {
                    Node node2 = node.next;
                    if (node2 != null && j2 - node2.when < 1000) {
                        node.curBytes = j;
                        node.when = j2;
                        return true;
                    }
                }
                return false;
            }
            Node obtainNode = obtainNode();
            obtainNode.curBytes = j;
            obtainNode.when = j2;
            if (node != null) {
                obtainNode.next = node;
                node.prev = obtainNode;
            }
            this.head = obtainNode;
            return true;
        }
    }
}
