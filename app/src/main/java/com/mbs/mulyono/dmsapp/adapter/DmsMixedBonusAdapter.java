package com.mbs.mulyono.dmsapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mbs.mulyono.dmsapp.R;
import com.mbs.mulyono.dmsapp.model.DmsMixedBonusItem;
import com.mbs.mulyono.dmsapp.model.DmsOrderValueItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsMixedBonusAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsMixedBonusItem> listMixedBonusItem;

    public DmsMixedBonusAdapter(Activity activity, ArrayList<DmsMixedBonusItem> listMixedBonusItem){
        this.activity = activity;
        this.listMixedBonusItem = listMixedBonusItem;
    }

    @Override
    public int getCount() {
        return listMixedBonusItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_ordervalue_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_dms_no);
            holder.txtMinQty = (TextView)convertView.findViewById(R.id.txt_item_mxbminqty);
            holder.txtMaxQty = (TextView)convertView.findViewById(R.id.txt_item_mxbmaxqty);
            holder.txtBonusQty = (TextView)convertView.findViewById(R.id.txt_item_mxbonusqty);
            holder.txtKetDisc = (TextView)convertView.findViewById(R.id.txt_item_mxbketdisc);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.txtNo.setText(listMixedBonusItem.get(position).dmsNo);
        holder.txtMinQty.setText(listMixedBonusItem.get(position).mxbminqty);
        holder.txtMaxQty.setText(listMixedBonusItem.get(position).mxbmaxqty);
        holder.txtBonusQty.setText(listMixedBonusItem.get(position).mxbbonusqty);
        holder.txtKetDisc.setText(listMixedBonusItem.get(position).mxbketdisc);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtMinQty, txtMaxQty, txtBonusQty, txtKetDisc;
    }
}
