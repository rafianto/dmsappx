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
import com.mbs.mulyono.dmsapp.model.DmsCustomerItem;
import com.mbs.mulyono.dmsapp.model.DmsOrderItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsOrderAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsOrderItem> listOrderItem;

    public DmsOrderAdapter(Activity activity, ArrayList<DmsOrderItem> listOrderItem){
        this.activity = activity;
        this.listOrderItem = listOrderItem;
    }

    @Override
    public int getCount() {
        return listOrderItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_order_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_dms_no);
            holder.txtOrderType = (TextView)convertView.findViewById(R.id.txt_item_ordertype);
            holder.txtIncExc = (TextView)convertView.findViewById(R.id.txt_item_ordincexc);
            holder.txtOrderDesc = (TextView)convertView.findViewById(R.id.txt_item_orderdesc);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

        }

        holder.txtNo.setText(listOrderItem.get(position).dmsNo);
        holder.txtOrderType.setText(listOrderItem.get(position).order_type);
        holder.txtIncExc.setText(listOrderItem.get(position).ordincecx);
        holder.txtOrderDesc.setText(listOrderItem.get(position).orddesc);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtOrderType, txtIncExc, txtOrderDesc;
    }
}
