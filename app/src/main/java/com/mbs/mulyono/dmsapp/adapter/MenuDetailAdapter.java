package com.mbs.mulyono.dmsapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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
public class MenuDetailAdapter extends BaseAdapter {
    String menu[] = new String[]{
        "Header", "CustGroup", "CustChain", "Customer", "GrpProduct", "Product", "OrderType", "OrderValue", "MixedBonus", "MixPersen", "Signature", "History", "PDF~", "Sales"
    };

    int[] menuIcon = new int[]{
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb,
            R.drawable.ic_principalb
    };

    Activity activity;

    public MenuDetailAdapter(Activity activity){
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

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }


            holder.txtMenu = (TextView)convertView.findViewById(R.id.txt_item_menu);
            holder.imgIcon = (ImageView)convertView.findViewById(R.id.img_menu);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

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
