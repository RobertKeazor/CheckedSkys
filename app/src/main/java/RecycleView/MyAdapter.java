package RecycleView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ErrorCatchers.Alert_No_Internet;
import Interfaces.Deligator;
import presentation.last.com.checkedskys.MainActivity;
import presentation.last.com.checkedskys.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> mDataset;
    private ArrayList<String> mBottomDataSet;
    public Deligator deligator;
    private  int imageRes;
    

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView mainImage;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            mainImage = (ImageView) v.findViewById(R.id.icon);

        }
    }

    public void add(int position, String item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myDataset, ArrayList<String> myBottomDatasets,Deligator deligator) {
        mDataset = myDataset;
        mBottomDataSet = myBottomDatasets;
        this.deligator=deligator;


    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final String name = mDataset.get(position);
        holder.txtHeader.setText(mDataset.get(position));

        holder.mainImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                deligator.Deligate_Update(position);
                //remove(name);

            }
        });

        holder.txtFooter.setText( mBottomDataSet.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
