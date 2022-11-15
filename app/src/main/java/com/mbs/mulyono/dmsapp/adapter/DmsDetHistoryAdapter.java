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
import com.mbs.mulyono.dmsapp.model.DmsDetHistoryItem;
import com.mbs.mulyono.dmsapp.model.DmsSignatureItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsDetHistoryAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsDetHistoryItem> listDetHistoryItem;

    public DmsDetHistoryAdapter(Activity activity, ArrayList<DmsDetHistoryItem> listDetHistoryItem){
        this.activity = activity;
        this.listDetHistoryItem = listDetHistoryItem;
    }

    @Override
    public int getCount() {
        return listDetHistoryItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_dethistory_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_hstdms_no);
            holder.txtState = (TextView)convertView.findViewById(R.id.txt_item_hststate);
            holder.txtDateEnter = (TextView)convertView.findViewById(R.id.txt_item_hstdateproses);
            holder.txtUserid = (TextView)convertView.findViewById(R.id.txt_item_hstuserid);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

        }

        holder.txtNo.setText(listDetHistoryItem.get(position).dmsNo);
        holder.txtState.setText(listDetHistoryItem.get(position).hstrowstate);
        holder.txtDateEnter.setText(listDetHistoryItem.get(position).htsdateentered);
        holder.txtUserid.setText(listDetHistoryItem.get(position).htsduserid);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtState, txtDateEnter, txtUserid;
    }
}
