package com.hehe.kyky.guramedia;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.Spinner;
        import android.widget.SpinnerAdapter;
        import android.widget.TextView;



public class DataAdapter extends BaseAdapter
{
    Context context;


    public DataAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return Data.nama.size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.single_data, null);
        TextView txtNama = (TextView)convertView.findViewById(R.id.txtNama);
        TextView txtHarga = (TextView) convertView.findViewById(R.id.txtHarga);
        TextView txtStok = (TextView) convertView.findViewById(R.id.txtStok);
        TextView txtDesc = (TextView) convertView.findViewById(R.id.txtDesc);
//        Spinner bookType = (Spinner) convertView.findViewById(R.id.bookType);
        txtNama.setText(Data.nama.get(position));
        txtStok.setText(Data.stok.get(position));
        txtDesc.setText(Data.desc.get(position));
        txtHarga.setText(Data.harga.get(position));
//        bookType.setAdapter((SpinnerAdapter) Data.booktype);
        return convertView;
    }
}
