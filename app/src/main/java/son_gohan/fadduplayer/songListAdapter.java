package son_gohan.fadduplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Dheeraj Asnani on 02-Jul-16.
 */
public class songListAdapter  extends BaseAdapter{
    private Context mcontext;
    private ArrayList<Song> SongList;

    public songListAdapter(Context context, ArrayList<Song> arrayList)
    {
        mcontext = context;
        this.SongList = arrayList;
    }

    @Override
    public int getCount() {
        return SongList.size();
    }

    @Override
    public Object getItem(int position) {


        return SongList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.song_list_item_layout,null);
        }
        RelativeLayout relativeLayout = (RelativeLayout) convertView.findViewById(R.id.song_item_relativeview);
        ImageView imageView_song = (ImageView) convertView.findViewById(R.id.imageView_song_art);
        TextView textView_name = (TextView) convertView.findViewById(R.id.textView_song_name);
        TextView textView_album = (TextView) convertView.findViewById(R.id.textView_song_album);
        TextView textView_duration = (TextView) convertView.findViewById(R.id.textView_song_duration);

        String color="#";
        String[] randomval = {"1","0","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        for(int i=0;i<6;i++)
        {
            color+=randomval[new Random().nextInt(16)];
        }
        if(color.length()!=1)
        {
            relativeLayout.setBackgroundColor(Integer.parseInt(color));
        }
        imageView_song.setImageResource(R.drawable.abcd);
        textView_name.setText(SongList.get(position).getmSongName());
        textView_album.setText(SongList.get(position).getmSongAlbumName());
        textView_duration.setText(SongList.get(position).getmSongDuration());
        return convertView;
    }
    public void setSongList(ArrayList<Song> list)
    {
        SongList = list;
        this.notifyDataSetChanged();
    }
}
