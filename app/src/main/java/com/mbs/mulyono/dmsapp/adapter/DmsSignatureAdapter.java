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
import com.mbs.mulyono.dmsapp.model.DmsSignatureItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsSignatureAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsSignatureItem> listSignatureItem;

    public DmsSignatureAdapter(Activity activity, ArrayList<DmsSignatureItem> listSignatureItem){
        this.activity = activity;
        this.listSignatureItem = listSignatureItem;
    }

    @Override
    public int getCount() {
        return listSignatureItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_signature_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_sigdms_no);
            holder.txtpersonid = (TextView)convertView.findViewById(R.id.txt_item_sigpersonid);
            holder.txtpname = (TextView)convertView.findViewById(R.id.txt_item_sigpersonname);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

        }

        holder.txtNo.setText(listSignatureItem.get(position).dmsNo);
        holder.txtpersonid.setText(listSignatureItem.get(position).sigperson_id);
        holder.txtpname.setText(listSignatureItem.get(position).sigpname);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtpersonid, txtpname;
    }
}
