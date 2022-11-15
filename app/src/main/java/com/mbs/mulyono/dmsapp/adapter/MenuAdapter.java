package com.mbs.mulyono.dmsapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbs.mulyono.dmsapp.R;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class MenuAdapter extends BaseAdapter {
    String menu[] = new String[]{
        "Overview", "Principal", "History", "Setting"
    };

    int[] menuIcon = new int[]{
        R.drawable.ic_overview,
        R.drawable.ic_overview,
        R.drawable.ic_history,
        R.drawable.ic_settings
    };

    Activity activity;

    public MenuAdapter(Activity activity){
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return menu.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_menu, null);
            holder = new ViewHolder();
            holder.txtMenu = (TextView)convertView.findViewById(R.id.txt_item_menu);
            holder.imgIcon = (ImageView)convertView.findViewById(R.id.img_menu);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.txtMenu.setText(menu[position]);
        holder.imgIcon.setImageResource(menuIcon[position]);

        return convertView;
    }

    static class ViewHolder{
        TextView txtMenu;
        ImageView imgIcon;
    }
}
