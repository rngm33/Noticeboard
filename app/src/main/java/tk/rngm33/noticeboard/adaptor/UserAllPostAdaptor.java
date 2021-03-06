package tk.rngm33.noticeboard.adaptor;

/**
 * Created by hp on 3/29/2018.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tk.rngm33.noticeboard.R;
import tk.rngm33.noticeboard.model.Notice;

/**
 * Created by hp on 3/27/2018.
 */

public class UserAllPostAdaptor extends RecyclerView.Adapter <UserAllPostAdaptor.AdminViewHolder>{
    private Context mcontext;
    String name;

    private ArrayList<Notice> mUploads= new ArrayList<>();
    public UserAllPostAdaptor(Context context, ArrayList<Notice> uploads){
        mcontext=context;
        mUploads=uploads;

    }
    @Override
    public AdminViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.adminnotice,parent,false);
        return new AdminViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdminViewHolder holder, int position) {
        Notice uploadcurrent= mUploads.get(position);
        holder.textTime.setText(uploadcurrent.getTime());
        holder.textDate.setText(uploadcurrent.getDate());
       holder.textName.setText("Posted By :"+" "+uploadcurrent.getName());
        holder.textNotice.setText(uploadcurrent.getNotice());
        holder.textTitle.setText(uploadcurrent.getTitle());
        name= uploadcurrent.getName();

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class AdminViewHolder extends  RecyclerView.ViewHolder{
        public TextView textTime,textDate,textName,textNotice,textTitle;
        public AdminViewHolder(final View itemView) {
            super(itemView);
            textTime= itemView.findViewById(R.id.ettime);
            textDate=itemView.findViewById(R.id.etdate);
           textName=itemView.findViewById(R.id.etname);
            textNotice=itemView.findViewById(R.id.etnotice);
            textTitle=itemView.findViewById(R.id.ettitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     FragmentManager fragmentManager = ((AppCompatActivity)mcontext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                    Bundle bundle= new Bundle();
                    bundle.putString("time","Published Time: "+ " " + textTime.getText().toString());
                    bundle.putString("date","Published Date:" + " " + textDate.getText().toString());
                    bundle.putString("notice","Notice : " + "" + textNotice.getText().toString());
                    bundle.putString("postedby",name);
                    bundle.putString("title","Title : " + " " + textTitle.getText().toString());
                    DetailViewNoticeFragment detailViewNoticeFragment= new DetailViewNoticeFragment();
                    detailViewNoticeFragment.setArguments(bundle);
                    fragmentTransaction.replace(R.id.frguser,detailViewNoticeFragment);
                    fragmentTransaction.commit();
                }
            });

        }
    }

}


