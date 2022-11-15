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
import com.mbs.mulyono.dmsapp.model.DmsCustomerChainItem;
import com.mbs.mulyono.dmsapp.model.DmsCustomerGroupItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsCustomerChainAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsCustomerChainItem> listCustomerChainItem;

    public DmsCustomerChainAdapter(Activity activity, ArrayList<DmsCustomerChainItem> listCustomerChainItem){
        this.activity = activity;
        this.listCustomerChainItem = listCustomerChainItem;
    }

    @Override
    public int getCount() {
        return listCustomerChainItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_custchain_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_ccdms_no);
            holder.txtCustChain = (TextView)convertView.findViewById(R.id.txt_item_cccustchain);
            holder.getTxtIncExc = (TextView)convertView.findViewById(R.id.txt_item_ccincexcl);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

        }

        holder.txtNo.setText(listCustomerChainItem.get(position).ccdmsNo);
        holder.txtCustChain.setText(listCustomerChainItem.get(position).cccustchain);
        holder.getTxtIncExc.setText(listCustomerChainItem.get(position).ccincecx);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtCustChain, getTxtIncExc;
    }
}