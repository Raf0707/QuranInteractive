package raf.tabiin.quraninteractive.adapter.quran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

import raf.tabiin.quraninteractive.R;
import raf.tabiin.quraninteractive.object.sures.Sura;

public class DrawerSuraContentAdapter extends RecyclerView.Adapter<DrawerSuraContentAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Sura sura;
    private List<String> versesNums;
    private Context context;
    private RecyclerView suraContent;


    public DrawerSuraContentAdapter(LayoutInflater inflater, List<String> versesNums, Context context, RecyclerView suraContent, Sura sura) {
        this.suraContent = suraContent;
        this.inflater = inflater;
        this.versesNums = versesNums;
        this.context = context;
        this.sura = sura;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.listitem1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String verse = versesNums.get(position);
        TextView txt = holder.nameView1;
        txt.setText(verse);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suraContent.scrollToPosition(holder.getBindingAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return versesNums.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView1;

        ViewHolder(View view) {
            super(view);
            nameView1 = view.findViewById(R.id.name1);
        }
    }
}
