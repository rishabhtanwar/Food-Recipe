package Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodrecipes.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.NavigationAdapter;
import Extras.Info;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment.NavigationDrawerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment.NavigationDrawerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavigationDrawerFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;

    private NavigationAdapter adapter;

    public static final String PREF_FILE_NAME = "testpref";

    public static final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";

    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerlayout;

    private Boolean mUserlearneddrawer;

    private Boolean mFromsavedinstancestate;

    private  View containerview;




    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserlearneddrawer=Boolean.valueOf(ReadfromPrefrences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
        if(savedInstanceState!=null){
            mFromsavedinstancestate=true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout=inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView= (RecyclerView) layout.findViewById(R.id.DrawerList);
        adapter=new NavigationAdapter(getActivity(),getdata());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;

    }

    public static  List<Info> getdata(){
        List<Info> data=new ArrayList<>();
        int[] icons={R.drawable.login, R.drawable.home_2, R.drawable.order, R.drawable.wallet};
        String[] titles={"Login","Home","Orders","Wallet"};
        for(int i=0;i<icons.length && i<titles.length; i++){
            Info current=new Info();
            current.iconId=icons[i];
            current.tittle=titles[i];
            data.add(current);
        }
        return data;
    }




    public void setup(int fragmentId,DrawerLayout drawerlayout, final Toolbar toolbar) {

        containerview=getActivity().findViewById(fragmentId);

        mDrawerlayout = drawerlayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerlayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!mUserlearneddrawer){
                    mUserlearneddrawer=true;
                    saveToPrefrences(getActivity(),KEY_USER_LEARNED_DRAWER,mUserlearneddrawer+"");

                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if(slideOffset<0.6){
                    toolbar.setAlpha(1-slideOffset);
                }
            }
        };
        if (mUserlearneddrawer==null && mFromsavedinstancestate==null) {

            mDrawerlayout.openDrawer(containerview);


        }
        mDrawerlayout.setDrawerListener(mDrawerToggle);

        mDrawerlayout.post(new Runnable() {
            @Override
            public void run() {

                mDrawerToggle.syncState();
            }
        });
    }

    public static void saveToPrefrences(Context context, String prefrenceName, String prefrencevalue) {

        SharedPreferences sharedprefrences = context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedprefrences.edit();

        editor.putString(prefrenceName, prefrencevalue);
        editor.apply();

    }

    public static String ReadfromPrefrences(Context context, String prefrenceName, String defaultvalue) {

        SharedPreferences sharedprefrences = context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);

        return sharedprefrences.getString(prefrenceName,defaultvalue);

    }

}
