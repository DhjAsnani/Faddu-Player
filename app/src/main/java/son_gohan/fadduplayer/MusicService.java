package son_gohan.fadduplayer;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by Dheeraj Asnani on 02-Jul-16.
 */
public class MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    private MediaPlayer mPlayer;
    private Uri mSongUri;

    private ArrayList<Song> mListSong;
    private int SONG_POS = 0;

    private final IBinder musicBind = new PlayerBinder();
    private final String ACTION_STOP = "son_gohan.fadduplayer.STOP";
    private final String ACTION_NEXT = "son_gohan.fadduplayer.NEXT";
    private final String ACTION_PREVIOUS = "son_gohan.fadduplayer.PREVIOUS";
    private final String ACTION_PAUSE = "son_gohan.fadduplayer.PAUSE";

    private static final int STATE_PAUSED = 1;
    private static final int STATE_PLAYING = 2;
    private int mState = 0;
    private static final int REQUEST_CODE_PAUSE = 101;
    private static final int REQUEST_STATE_PLAYING = 102;
    private static final int REQUEST_CODE_NEXT = 103;
    private static final int REQUEST_CODE_STOP = 104;
    private static int NOTIFICATION_IS = 11;
    private Notification.Builder notificationBuilerd;
    private Notification mNotification;


    // creating binder for passing current service to activity
    public class PlayerBinder extends Binder{
        public MusicService getService(){
            return MusicService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mPlayer = new MediaPlayer();
        //wont turn the app off on clicking power button
        mPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        // for providing info of the audio
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC );
        // add various listners necessary for songs
        mPlayer.setOnErrorListener(this);
        mPlayer.setOnPreparedListener(this);
        mPlayer.setOnCompletionListener(this);
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}
