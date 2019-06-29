package nitin.listtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nitin on 6/22/14.
 */
public class TimeTrackerAdapter extends BaseAdapter {

    private ArrayList<TimeRecord> times = new ArrayList<TimeRecord>();

    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.time_list_item,parent,false);
        }

        TimeRecord time = times.get(position);

        TextView timeTextView = (TextView) view.findViewById(R.id.time_view);
        timeTextView.setText(time.getTime());

        TextView notesTextView = (TextView) view.findViewById(R.id.notes_view);
        notesTextView.setText(time.getNotes());

        return view;

    }

    public TimeTrackerAdapter(){
        times.add(new TimeRecord("9:45","Got up and did Surya Namaskaar and Jogged"));
        times.add(new TimeRecord("11:20","Spoke to Sindhu, Suchi, Namrata, Mummy Amma...Made food along with"));
        times.add(new TimeRecord("2:30","Reached office after Lunch!!"));
        times.add(new TimeRecord("9:23","Finished writing this!!"));
        times.add(new TimeRecord("12:45 night","Watching Waah Waah kya baat hai"));


    }

}
