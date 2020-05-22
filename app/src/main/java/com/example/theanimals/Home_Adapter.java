package com.example.theanimals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.ViewHolder>{

    private static List<Home_Model> homeModelList;
    private static Context context;
    private static SelectedAnimalHome selectedAnimalHome;

    public Home_Adapter(List<Home_Model> homeModelList, Context context, SelectedAnimalHome selectedAnimalHome) {
        this.homeModelList = homeModelList;
        this.context = context;
        this.selectedAnimalHome = selectedAnimalHome;
    }

    @NonNull
    @Override
    public Home_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Home_Adapter.ViewHolder holder, int position) {
        int imageRes = homeModelList.get(position).getAnimalImageResource();
        String nameAnimal = homeModelList.get(position).getNameOfAnimal();
        int nextArrow = homeModelList.get(position).getNextImageView();

        ViewHolder.setData(imageRes, nameAnimal, nextArrow);
    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public interface SelectedAnimalHome{
        void selectedAnimalHome(Home_Model homeModel, Context context, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private static ImageView imageView;
        private static TextView textView;
        private static ImageView next;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.circleImageView);
            textView = itemView.findViewById(R.id.textViewNameHome);
            next = itemView.findViewById(R.id.imageView);

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedAnimalHome.selectedAnimalHome(homeModelList.get(getAdapterPosition()), context, getAdapterPosition());
                }
            });
        }

        public static void setData(int imageRes, String nameAnimal, int nextArrow) {

            imageView.setImageResource(imageRes);
            textView.setText(nameAnimal);
            next.setImageResource(nextArrow);
        }
    }
}
