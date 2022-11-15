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
import com.mbs.mulyono.dmsapp.model.DmsCustomerGroupItem;
import com.mbs.mulyono.dmsapp.model.DmsCustomerItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsCustomerGroupAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsCustomerGroupItem> listCustomerGroupItem;

    public DmsCustomerGroupAdapter(Activity activity, ArrayList<DmsCustomerGroupItem> listCustomerGroupItem){
        this.activity = activity;
        this.listCustomerGroupItem = listCustomerGroupItem;
    }

    @Override
    public int getCount() {
        return listCustomerGroupItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_custgroup_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_dms_no);
            holder.txtCustGroup = (TextView)convertView.findViewById(R.id.txt_item_csgcustgroup);
            holder.getTxtIncExc = (TextView)convertView.findViewById(R.id.txt_item_csgincexcl);
            holder.txtDescGrp = (TextView)convertView.findViewById(R.id.txt_item_csggroupdesc);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

        }

        holder.txtNo.setText(listCustomerGroupItem.get(position).csgdmsNo);
        holder.txtCustGroup.setText(listCustomerGroupItem.get(position).csgcust_group);
        holder.getTxtIncExc.setText(listCustomerGroupItem.get(position).csgexcinc);
        holder.txtDescGrp.setText(listCustomerGroupItem.get(position).csgdescgrp);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtCustGroup, getTxtIncExc, txtDescGrp;
    }
}
