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
import com.mbs.mulyono.dmsapp.model.DmsHistoryItem;
import com.mbs.mulyono.dmsapp.model.DmsOverviewItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsHistoryAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsHistoryItem> listHistoryItem;

    public DmsHistoryAdapter(Activity activity, ArrayList<DmsHistoryItem> listHistoryItem){
        this.activity = activity;
        this.listHistoryItem = listHistoryItem;
    }

    @Override
    public int getCount() {
        return listHistoryItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_history_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtDmsNo = (TextView)convertView.findViewById(R.id.txt_item_hisdms_no);
            holder.txtDateFrom = (TextView)convertView.findViewById(R.id.txt_item_hisdate_from);
            holder.txtDateTo = (TextView)convertView.findViewById(R.id.txt_item_hisdate_to);
            holder.txtPrinc = (TextView)convertView.findViewById(R.id.txt_item_hisprincipal);
            holder.txtFocus = (TextView)convertView.findViewById(R.id.txt_item_hisdms_focus);
            holder.txtNote = (TextView)convertView.findViewById(R.id.txt_item_hisnote_text);
            holder.txtState = (TextView)convertView.findViewById(R.id.txt_item_hisstate);
            holder.txtHnaFlag = (TextView)convertView.findViewById(R.id.txt_item_hishnaflag);
            holder.txtNettoFlag = (TextView)convertView.findViewById(R.id.txt_item_hisnettoflag);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }
        }

        holder.txtDmsNo.setText(listHistoryItem.get(position).hisdmsNo);
        holder.txtDateFrom.setText(listHistoryItem.get(position).hisdateFrom);
        holder.txtDateTo.setText(listHistoryItem.get(position).hisdateTo);
        holder.txtPrinc.setText(listHistoryItem.get(position).hisprincipal);
        holder.txtFocus.setText(listHistoryItem.get(position).histdmsFocus);
        holder.txtNote.setText(listHistoryItem.get(position).hisnoteText);
        holder.txtState.setText(listHistoryItem.get(position).hisstate);
        holder.txtHnaFlag.setText(listHistoryItem.get(position).hishnaflag);
        holder.txtNettoFlag.setText(listHistoryItem.get(position).hisnettoflag);
        return convertView;
    }

    static class ViewHolder{
        TextView txtDmsNo, txtDateFrom, txtDateTo, txtPrinc, txtFocus, txtNote, txtState, txtHnaFlag, txtNettoFlag;
    }
}