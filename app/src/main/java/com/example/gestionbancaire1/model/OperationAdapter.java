package com.example.gestionbancaire1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gestionbancaire1.model.Operation;
import com.example.gestionbancaire1.R;

import java.util.ArrayList;
import java.util.List;

public class OperationAdapter extends ArrayAdapter<Operation> {
    private Context mContext;
    private ArrayList<Operation> operations; //Declaring an array list of our History class
    private int mResource;
    public OperationAdapter(@NonNull Context context,int resource, @NonNull ArrayList<Operation> objects) {
        //The constructor of our adapter with our context and ressources
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
        this.operations = objects;
    }

    @Override
    public int getCount() {

        return operations.size();

    }

    @Nullable
    @Override
    public Operation getItem(int position) {
        return operations.get(position);
    } //Return the item in the giving position

    @Override
    public int getPosition(@Nullable Operation item) {
        return operations.indexOf(item);
    } //To get the position of certain item

    @Override
    public long getItemId(int position) {
        return position;
    } //get position by itemID

    public View getView(int position, View convertView, ViewGroup parents){ //Get the view in a given position
        if ( convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource,parents,false);
            // Inflate our layer from the custom context and using our ressources
        }

        TextView Num = (TextView) convertView.findViewById(R.id.textNum); //For the labels in our application
        TextView Montant = (TextView) convertView.findViewById(R.id.textMontant);
        TextView Date = (TextView) convertView.findViewById(R.id.textDate);

        Num.setText(getItem(position).getNum().toString());
        Montant.setText(getItem(position).getMontant());
        Date.setText(getItem(position).getDate());

        return convertView;
    }

}