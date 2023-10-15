package fr.isep.hotels;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<recyclerview_list> recyclerviewLists;
    private Context context;

    private RoomClickedListeners roomClickedListeners;
    public RecyclerAdapter(RoomClickedListeners roomClickedListeners)
    {
        this.roomClickedListeners = roomClickedListeners;
    }



    public void setRoomItemList(List<recyclerview_list> roomItemList){
        this.recyclerviewLists = roomItemList;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        private TextView title;
        //private TextView date;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView2);
            title = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card, parent,false);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        recyclerview_list roomItem = recyclerviewLists.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.imageView.setImageResource(recyclerviewLists.get(position).getPhoto_one());
        itemViewHolder.title.setText(recyclerviewLists.get(position).getAd_title());


                itemViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        roomClickedListeners.onCardClicked(roomItem);
                    }
                });





    }

    @Override
    public int getItemCount() {
        return recyclerviewLists.size();
    }

    public interface RoomClickedListeners{
        void onCardClicked(recyclerview_list room);
    }
}
