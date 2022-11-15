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
import com.mbs.mulyono.dmsapp.model.DmsOrderItem;
import com.mbs.mulyono.dmsapp.model.DmsOrderValueItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsOrderValueAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsOrderValueItem> listOrderValueItem;

    public DmsOrderValueAdapter(Activity activity, ArrayList<DmsOrderValueItem> listOrderValueItem){
        this.activity = activity;
        this.listOrderValueItem = listOrderValueItem;
    }

    @Override
    public int getCount() {
        return listOrderValueItem.size();
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
            holder.txtLineNo = (TextView)convertView.findViewById(R.id.txt_item_ovlineno);
            holder.txtMin_Value = (TextView)convertView.findViewById(R.id.txt_item_ovminvalue);
            holder.txtMax_Value = (TextView)convertView.findViewById(R.id.txt_item_ovmaxvalue);
            holder.txtDiscType = (TextView)convertView.findViewById(R.id.txt_item_ovtypedisc);
            holder.txtDiscValue = (TextView)convertView.findViewById(R.id.txt_item_ovvaluedisc);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

        }

        holder.txtNo.setText(listOrderValueItem.get(position).dmsNo);
        holder.txtLineNo.setText(listOrderValueItem.get(position).ovline_no);
        holder.txtMin_Value.setText(listOrderValueItem.get(position).ovmin_value);
        holder.txtMax_Value.setText(listOrderValueItem.get(position).ovmax_value);
        holder.txtDiscType.setText(listOrderValueItem.get(position).ovtype_discount);
        holder.txtDiscValue.setText(listOrderValueItem.get(position).ovdiscount_value);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtLineNo, txtMin_Value, txtMax_Value, txtDiscType, txtDiscValue;
    }
}
