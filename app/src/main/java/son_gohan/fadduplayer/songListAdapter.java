package son_gohan.fadduplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

        return null;
    }
}
