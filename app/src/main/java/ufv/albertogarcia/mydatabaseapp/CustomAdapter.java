package ufv.albertogarcia.mydatabaseapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MySongView> {
    private Context context;
    private ArrayList <Cancion> canciones;

    public CustomAdapter(Context context, ArrayList<Cancion> canciones) {
        this.context = context;
        this.canciones = canciones;
    }


    @NonNull
    @Override
    public CustomAdapter.MySongView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.my_song, parent, false);

        return new MySongView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MySongView holder, int position) {
        holder.songIDList.setText((String.valueOf(position +1)));
        holder.songTitle.setText(String.valueOf(canciones.get(position).getTitle()));
        holder.songAuthor.setText(String.valueOf(canciones.get(position).getAuthor()));
        holder.songDuracion.setText(String.valueOf(canciones.get(position).getYear()));
        holder.databaseID.setText(String.valueOf(canciones.get(position).getId()));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);

                intent.putExtra("arrayPosition", String.valueOf(holder.songIDList.getText()));
                intent.putExtra("arrayPosition", String.valueOf(holder.songIDList.getText()));
                intent.putExtra("arrayPosition", String.valueOf(holder.songIDList.getText()));
                intent.putExtra("arrayPosition", String.valueOf(holder.songIDList.getText()));
                intent.putExtra("arrayPosition", String.valueOf(holder.songIDList.getText()));
            }
        });


    }

    @Override
    public int getItemCount() { return canciones.size();}
    public class MySongView extends RecyclerView.ViewHolder{
        LinearLayout mainLayout;
        TextView songIDList;
        TextView songTitle;
        TextView songAuthor;
        TextView songDuracion;
        TextView databaseID;

        public MySongView (@NonNull View itemView){
            super(itemView);
            mainLayout =itemView.findViewById(R.id.mainLayout);
            songIDList = itemView.findViewById(R.id.songIDList);
            songTitle = itemView.findViewById(R.id.songTitle);
            songAuthor = itemView.findViewById(R.id.songAuthor);
            songDuracion = itemView.findViewById(R.id.songDuracion);
            databaseID = itemView.findViewById(R.id.databaseID);
        }
}

}
