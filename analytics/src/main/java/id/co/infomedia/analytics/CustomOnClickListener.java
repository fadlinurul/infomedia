package id.co.infomedia.analytics;

import android.content.Context;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Infomedia on 26/01/2017.
 */

public class CustomOnClickListener implements View.OnClickListener{

    private OnClickListener mListener;
    private String className;
    private String viewId;

    public interface OnClickListener{
        void onClick(View v);
    }
    public CustomOnClickListener(Context context, View view, OnClickListener listener){
        className = context.getClass().getSimpleName();
        viewId = view.getResources().getResourceName(view.getId());
        this.mListener = listener;
    }

    @Override
    public void onClick(View view) {
        System.out.println(className + " | " + viewId + " | " +getCurrentTimeStamp());
        mListener.onClick(view);
    }
    private String getCurrentTimeStamp(){
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
