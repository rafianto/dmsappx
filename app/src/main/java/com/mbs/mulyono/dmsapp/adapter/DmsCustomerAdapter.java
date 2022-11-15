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
import com.mbs.mulyono.dmsapp.model.DmsOverviewItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsCustomerAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsCustomerItem> listCustomerItem;

    public DmsCustomerAdapter(Activity activity, ArrayList<DmsCustomerItem> listCustomerItem){
        this.activity = activity;
        this.listCustomerItem = listCustomerItem;
    }

    @Override
    public int getCount() {
        return listCustomerItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_customer_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_dms_no);
            holder.txtCustid = (TextView)convertView.findViewById(R.id.txt_item_customerid);
            holder.txtCustName = (TextView)convertView.findViewById(R.id.txt_item_namecust);
            holder.txtIncExc = (TextView)convertView.findViewById(R.id.txt_item_incexl);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

        }

        holder.txtNo.setText(listCustomerItem.get(position).dmsNo);
        holder.txtCustid.setText(listCustomerItem.get(position).customerid);
        holder.txtCustName.setText(listCustomerItem.get(position).namacust);
        holder.txtIncExc.setText(listCustomerItem.get(position).incecx);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtCustid, txtCustName, txtIncExc;
    }
}
