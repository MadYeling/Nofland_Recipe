package com.example.noflandrecipe;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.noflandrecipe.nofland_recipe_core.EncodeFileName;
import com.example.noflandrecipe.nofland_recipe_core.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionAdapter extends CursorAdapter {
    private final List<Item> items = new ArrayList<>();

    public SearchSuggestionAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_view_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        System.out.println("0100：newView");
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        String itemName = cursor.getString(cursor.getColumnIndex("DarkSearch"));
        viewHolder.name.setText(itemName);
        viewHolder.icon.setImageResource(view.getResources().getIdentifier(EncodeFileName.encode(itemName), "drawable", context.getPackageName()));
        System.out.println("0100：bindView");
    }

    public void setSuggestionList(List<Item> list) {
        items.clear();
        items.addAll(list);
    }

    public String getSuggestionText(int position) {
//        if (position >= 0 && position < getCursor().getCount()) {
//            Cursor cursor = getCursor();
//            cursor.moveToPosition(position);
//            return cursor.getString(cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1));
//        }
//        return null;
        if (position < items.size())
            return items.get(position).getName();
        return null;
    }

    private static class ViewHolder {
        ImageView icon;
        TextView name;

        public ViewHolder(View view) {
            icon = view.findViewById(R.id.search_view_list_item_pic_image_view);
            name = view.findViewById(R.id.search_view_list_item_name_text_view);
        }
    }
}
