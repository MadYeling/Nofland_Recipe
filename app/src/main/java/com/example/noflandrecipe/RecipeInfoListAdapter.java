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
import com.example.noflandrecipe.nofland_recipe_core.model.Item;
import com.example.noflandrecipe.nofland_recipe_core.model.Recipe;
import com.example.noflandrecipe.nofland_recipe_core.model.RecipeItem;

import java.util.List;

public class RecipeInfoListAdapter extends BaseAdapter {
    private Context context;
    private List<RecipeItem> list;
    private int resource;
    private LayoutInflater inflater;

    public RecipeInfoListAdapter(Context context, List<RecipeItem> list, int resource) {
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
        RecipeInfoListAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new RecipeInfoListAdapter.ViewHolder();
            convertView = inflater.inflate(resource, null);
            viewHolder.imageView = convertView.findViewById(R.id.recipe_info_list_item_pic_image_view);
            viewHolder.textView = convertView.findViewById(R.id.recipe_info_list_item_name_text_view);
            viewHolder.textView1 = convertView.findViewById(R.id.recipe_info_list_item_research_text_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (RecipeInfoListAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position).getItem().getName());
        viewHolder.textView1.setText(list.get(position).getResearch().getCnName());
        String file = EncodeFileName.encode(list.get(position).getItem().getName());
        viewHolder.imageView.setImageResource(convertView.getResources().getIdentifier(file, "drawable", context.getPackageName()));
        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;
    }
}
