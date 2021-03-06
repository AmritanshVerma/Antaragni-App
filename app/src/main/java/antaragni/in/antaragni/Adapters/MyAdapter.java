package antaragni.in.antaragni.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import antaragni.in.antaragni.R;
import antaragni.in.antaragni.serverFields.scheduleparser;

/**
 * Created by saransh on 18/10/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public ArrayList<scheduleparser> mDataset;
    public int day;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        public TextView venue;
        public TextView time;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.Name);
            venue = (TextView) v.findViewById(R.id.Venue);
            time = (TextView) v.findViewById(R.id.Time);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<scheduleparser> myDataset) {
        mDataset=myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_scheduler, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
               if(mDataset!=null) { // - replace the contents of the view with that element
                   holder.name.setText(mDataset.get(position).EventName);
                   holder.venue.setText(mDataset.get(position).StartTime);
                   holder.time.setText(mDataset.get(position).Venue);
               }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(mDataset!=null)
            return mDataset.size();
        else
            return 0;
    }
}
