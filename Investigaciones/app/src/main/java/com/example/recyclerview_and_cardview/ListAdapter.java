package com.example.recyclerview_and_cardview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElements> data;
    private LayoutInflater inflate;
    private Context context;

    public ListAdapter(List<ListElements> itemList, Context context){
        this.inflate= LayoutInflater.from(context);
        this.context = context;
        this.data = itemList;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflate.inflate(R.layout.list_elements, parent, false);
        return new ListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(data.get(position));
    }

    public  void setItems(List<ListElements> items){ data = items; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView name, city, status;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameID);
            city = itemView.findViewById(R.id.cityID);
            status = itemView.findViewById(R.id.statusID);
        }

        void bindData(final ListElements item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            city.setText(item.getCity());
            status.setText(item.getStatus());
        }
    }

}
