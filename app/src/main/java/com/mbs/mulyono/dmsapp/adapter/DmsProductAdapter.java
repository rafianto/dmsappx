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
import com.mbs.mulyono.dmsapp.model.DmsProductItem;

import java.util.ArrayList;

/**
 * Created by Mulyono on 1/21/2016.
 */
public class DmsProductAdapter extends BaseAdapter{

    Activity activity;
    ArrayList<DmsProductItem> listProductItem;

    public DmsProductAdapter(Activity activity, ArrayList<DmsProductItem> listProductItem){
        this.activity = activity;
        this.listProductItem = listProductItem;
    }

    @Override
    public int getCount() {
        return listProductItem.size();
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
            convertView = inflater.inflate(R.layout.item_dms_product_item, null);
            holder = new ViewHolder();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

            holder.txtNo = (TextView)convertView.findViewById(R.id.txt_item_dms_no);
            holder.txtLineNo = (TextView)convertView.findViewById(R.id.txt_item_lineno);
            holder.txPartNo = (TextView)convertView.findViewById(R.id.txt_item_partno);
            holder.txtPartDesc = (TextView)convertView.findViewById(R.id.txt_item_partdesc1);
            holder.txtMinQty = (TextView)convertView.findViewById(R.id.txt_item_minqty);
            holder.txtMaxQty = (TextView)convertView.findViewById(R.id.txt_item_maxqty);
            holder.txtKetDisc = (TextView)convertView.findViewById(R.id.txt_item_ketdisc);
            holder.txtBnsPart = (TextView)convertView.findViewById(R.id.txt_item_bonuspart);
            holder.txtBnsDesc = (TextView)convertView.findViewById(R.id.txt_item_bonusdesc);
            holder.txtBnsQty = (TextView)convertView.findViewById(R.id.txt_item_bonusqty);
            holder.txtBnsKelipt = (TextView)convertView.findViewById(R.id.txt_item_bonuskel);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

            if(position %2 == 1) {
                convertView.setBackgroundColor(Color.rgb(242,242,242));
            } else {
                convertView.setBackgroundColor(Color.rgb(234,234,250));
            }

        }

        holder.txtNo.setText(listProductItem.get(position).dmsNo);
        holder.txtLineNo.setText(listProductItem.get(position).line_no);
        holder.txPartNo.setText(listProductItem.get(position).part_no);
        holder.txtPartDesc.setText(listProductItem.get(position).partdesc1);
        holder.txtMinQty.setText(listProductItem.get(position).min_qty);
        holder.txtMaxQty.setText(listProductItem.get(position).max_qty);
        holder.txtKetDisc.setText(listProductItem.get(position).ketdisc);
        holder.txtBnsPart.setText(listProductItem.get(position).bonus_part);
        holder.txtBnsDesc.setText(listProductItem.get(position).bonusdesc1);
        holder.txtBnsQty.setText(listProductItem.get(position).bonus_qty);
        holder.txtBnsKelipt.setText(listProductItem.get(position).kelipatan);
        return convertView;
    }

    static class ViewHolder{
        TextView txtNo, txtLineNo, txPartNo, txtPartDesc,txtMinQty,txtMaxQty,txtKetDisc, txtBnsPart, txtBnsDesc, txtBnsQty, txtBnsKelipt;
    }
}
