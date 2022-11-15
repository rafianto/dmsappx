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
import com.mbs.mulyono.dmsapp.model.DmsOverviewItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsPrincipalAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsOverviewItem> listItem;

    public DmsPrincipalAdapter(Activity activity, ArrayList<DmsOverviewItem> listItem){
        this.activity = activity;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_principal_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_dms_no);
            holder.txtDateFrom = (TextView)convertView.findViewById(R.id.txt_item_date_from);
            holder.txtDateTo = (TextView)convertView.findViewById(R.id.txt_item_date_to);
            holder.txtPrinc = (TextView)convertView.findViewById(R.id.txt_item_principal);
            holder.txtFocus = (TextView)convertView.findViewById(R.id.txt_item_dms_focus);
            holder.txtNote = (TextView)convertView.findViewById(R.id.txt_item_note_text);
            holder.txtState = (TextView)convertView.findViewById(R.id.txt_item_state);
            holder.txtHnaFlag = (TextView)convertView.findViewById(R.id.txt_item_hnaflag);
            holder.txtNettoFlag = (TextView)convertView.findViewById(R.id.txt_item_nettoflag);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }
        }

        holder.txtNo.setText(listItem.get(position).dmsNo);
        holder.txtDateFrom.setText(listItem.get(position).dateFrom);
        holder.txtDateTo.setText(listItem.get(position).dateTo);
        holder.txtPrinc.setText(listItem.get(position).principal);
        holder.txtFocus.setText(listItem.get(position).tdmsFocus);
        holder.txtNote.setText(listItem.get(position).noteText);
        holder.txtState.setText(listItem.get(position).state);
        holder.txtHnaFlag.setText(listItem.get(position).hnaflag);
        holder.txtNettoFlag.setText(listItem.get(position).nettoflag);

        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtDateFrom, txtDateTo, txtPrinc, txtFocus, txtNote, txtState, txtHnaFlag, txtNettoFlag;
    }
}
