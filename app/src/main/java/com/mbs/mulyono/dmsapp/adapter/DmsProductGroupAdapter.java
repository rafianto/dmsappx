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
import com.mbs.mulyono.dmsapp.model.DmsProductGroupItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsProductGroupAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsProductGroupItem> listProductGroupItem;

    public DmsProductGroupAdapter(Activity activity, ArrayList<DmsProductGroupItem> listProductGroupItem){
        this.activity = activity;
        this.listProductGroupItem = listProductGroupItem;
    }

    @Override
    public int getCount() {
        return listProductGroupItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_prodgroup_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_dms_no);
            holder.txtSalesGroup = (TextView)convertView.findViewById(R.id.txt_item_pggroupid);
            holder.txtIncExc = (TextView)convertView.findViewById(R.id.txt_item_pgincexc);
            holder.txtNameGrp = (TextView)convertView.findViewById(R.id.txt_item_pggroupname);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

        }

        holder.txtNo.setText(listProductGroupItem.get(position).pgdmsNo);
        holder.txtSalesGroup.setText(listProductGroupItem.get(position).pgsalesgroup);
        holder.txtIncExc.setText(listProductGroupItem.get(position).pgexcinc);
        holder.txtNameGrp.setText(listProductGroupItem.get(position).pgnamegrp);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtSalesGroup, txtIncExc, txtNameGrp;
    }
}
