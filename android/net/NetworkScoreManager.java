package android.net;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.INetworkScoreService;
import android.net.NetworkScorerAppManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkScoreManager.class */
public class NetworkScoreManager {
    public static final String ACTION_CHANGE_ACTIVE = "android.net.scoring.CHANGE_ACTIVE";
    public static final String ACTION_CUSTOM_ENABLE = "android.net.scoring.CUSTOM_ENABLE";
    public static final String ACTION_SCORER_CHANGED = "android.net.scoring.SCORER_CHANGED";
    public static final String ACTION_SCORE_NETWORKS = "android.net.scoring.SCORE_NETWORKS";
    public static final String EXTRA_NETWORKS_TO_SCORE = "networksToScore";
    public static final String EXTRA_NEW_SCORER = "newScorer";
    public static final String EXTRA_PACKAGE_NAME = "packageName";
    private final Context mContext;
    private final INetworkScoreService mService = INetworkScoreService.Stub.asInterface(ServiceManager.getService(Context.NETWORK_SCORE_SERVICE));

    public NetworkScoreManager(Context context) {
        this.mContext = context;
    }

    public boolean clearScores() throws SecurityException {
        try {
            return this.mService.clearScores();
        } catch (RemoteException e) {
            return false;
        }
    }

    public void disableScoring() throws SecurityException {
        try {
            this.mService.disableScoring();
        } catch (RemoteException e) {
        }
    }

    public String getActiveScorerPackage() {
        NetworkScorerAppManager.NetworkScorerAppData activeScorer = NetworkScorerAppManager.getActiveScorer(this.mContext);
        if (activeScorer == null) {
            return null;
        }
        return activeScorer.mPackageName;
    }

    public void registerNetworkScoreCache(int i, INetworkScoreCache iNetworkScoreCache) {
        try {
            this.mService.registerNetworkScoreCache(i, iNetworkScoreCache);
        } catch (RemoteException e) {
        }
    }

    public boolean requestScores(NetworkKey[] networkKeyArr) throws SecurityException {
        String activeScorerPackage = getActiveScorerPackage();
        if (activeScorerPackage == null) {
            return false;
        }
        Intent intent = new Intent(ACTION_SCORE_NETWORKS);
        intent.setPackage(activeScorerPackage);
        intent.setFlags(67108864);
        intent.putExtra(EXTRA_NETWORKS_TO_SCORE, networkKeyArr);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.OWNER, Manifest.permission.SCORE_NETWORKS);
        return true;
    }

    public boolean setActiveScorer(String str) throws SecurityException {
        try {
            return this.mService.setActiveScorer(str);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean updateScores(ScoredNetwork[] scoredNetworkArr) throws SecurityException {
        try {
            return this.mService.updateScores(scoredNetworkArr);
        } catch (RemoteException e) {
            return false;
        }
    }
}
