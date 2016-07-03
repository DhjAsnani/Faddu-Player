package son_gohan.fadduplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
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
















    @Override
    public IBinder onBind(Intent intent) {
        return null;
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
