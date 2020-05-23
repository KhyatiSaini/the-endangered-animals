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

public class FactsAdapter extends RecyclerView.Adapter<FactsAdapter.ViewHolder> {

   private static List<FactsModel> factsModelList;
   private static Context context;
   private static SelectedImage selectedImage;

    public FactsAdapter(List<FactsModel> factsModelList, Context context, SelectedImage selectedImage){
        this.factsModelList = factsModelList;
        this.context = context;
        this.selectedImage = selectedImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.facts_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = factsModelList.get(position).getAnimalImageResource();
        String fact = factsModelList.get(position).getFact();
        String name = factsModelList.get(position).getAnimalName();

        ViewHolder.setData(image, fact, name);
    }

    @Override
    public int getItemCount() {
        return factsModelList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

   public interface SelectedImage{
        void selectedImage(FactsModel factsModel, Context context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private static ImageView imageView;
        private static TextView textView;
        private static TextView textTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageAnimal);
            textView = itemView.findViewById(R.id.textVewFact);
            textTitle = itemView.findViewById(R.id.Name);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedImage.selectedImage(factsModelList.get(getAdapterPosition()), context);
                }
            });

        }

        public static void setData(int image, String fact, String name) {
            imageView.setImageResource(image);
            textView.setText(fact);
            textTitle.setText(name);
        }
    }
}
