package com.example.harrypotter.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.harrypotter.R;
import com.example.harrypotter.model.Character;
import com.example.harrypotter.DetailActivity;

import java.util.List;

public class AdapterCharacter extends RecyclerView.Adapter<AdapterCharacter.CharacterHolder> {
    public Activity activity;
    public List<Character> list;
    public int item_character;

    public AdapterCharacter(Activity activity, List<Character> list, int item_character) {
        this.activity = activity;
        this.list = list;
        this.item_character = item_character;
    }

    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(item_character,parent,false);

        return new CharacterHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CharacterHolder holder, int position) {

        Character character = list.get(position);
        holder.item_name.setText(character.name);
        Glide.with(activity).load(character.image).into(holder.item_image);
        holder.item_house.setText(character.house);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder {

            ImageView item_image;
            TextView item_name,item_house;
            RelativeLayout item_character;

            public CharacterHolder(@NonNull View itemView) {
                super(itemView);
                item_name = itemView.findViewById(R.id.item_name);
                item_image = itemView.findViewById(R.id.item_image);
                item_house = itemView.findViewById(R.id.item_house);
                item_character = itemView.findViewById(R.id.item_character);

                item_character.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity,DetailActivity.class);
                        activity.startActivity(intent);
                    }
                });
            }
        }

}
