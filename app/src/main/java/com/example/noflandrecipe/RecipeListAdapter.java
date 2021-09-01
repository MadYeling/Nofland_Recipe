package com.example.noflandrecipe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.noflandrecipe.nofland_recipe_core.EncodeFileName;
import com.example.noflandrecipe.nofland_recipe_core.model.Recipe;

import java.util.List;

public class RecipeListAdapter extends BaseAdapter {
    private Context context;
    private List<Recipe> list;
    private int resource;
    private LayoutInflater inflater;

    public RecipeListAdapter(Context context, List<Recipe> list, int resource) {
        this.context = context;
        this.list = list;
        this.resource = resource;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(resource, null);
            viewHolder.imageView = convertView.findViewById(R.id.recipe_list_item_pic_image_view);
            viewHolder.textView = convertView.findViewById(R.id.recipe_list_item_name_text_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position).getName());
        String file = EncodeFileName.encode(list.get(position).getName());
        viewHolder.imageView.setImageResource(convertView.getResources().getIdentifier(file, "drawable", context.getPackageName()));

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RecipeInfoActivity.class);
            intent.putExtra("recipe", list.get(position));
            context.startActivity(intent);
        });
        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
