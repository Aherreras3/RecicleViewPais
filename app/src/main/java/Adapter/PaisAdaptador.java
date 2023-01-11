package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recicleviewpais.R;

import java.util.List;

import Models.Pais;
//import Models.Volumen;
//import uteq.solutions.recyclercardview.R;


public class PaisAdaptador extends RecyclerView.Adapter<PaisAdaptador.PaisViewHolder> {
    private Context Ctx;
    private List<Pais> ListaPais;

    public PaisAdaptador(Context mCtx, List<Pais> paises) {
        this.ListaPais = paises;
        Ctx = mCtx;
    }

    @Override
    public PaisAdaptador.PaisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.ly_itempais, null);
        return new PaisAdaptador.PaisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PaisAdaptador.PaisViewHolder holder, int position) {
        Pais paises = ListaPais.get(position);
        holder.txtTituloPais.setText(paises.getTitulo());
        holder.txtCapital.setText(paises.getCapital());
        holder.txtPrefijo.setText(paises.getPrefijo());
        holder.txtInfopais.setText(paises.getInfopais());
        Glide.with(Ctx)
                .load(paises.getUrlBandera())
                .into(holder.imgUrlBandera);
    }

    @Override
    public int getItemCount() {
        return ListaPais.size();
    }

    class PaisViewHolder extends RecyclerView.ViewHolder {
        TextView txtTituloPais, txtCapital, txtPrefijo,txtInfopais;
        ImageView imgUrlBandera;
        public PaisViewHolder(View itemView) {
            super(itemView);
            txtTituloPais = itemView.findViewById(R.id.txtTituloCountry);
            txtCapital = itemView.findViewById(R.id.txtCapital);
            txtPrefijo = itemView.findViewById(R.id.txtprefijo);
            txtInfopais=itemView.findViewById(R.id.txtinfopais);
            imgUrlBandera = itemView.findViewById(R.id.imgBandera);
        }
    }
}