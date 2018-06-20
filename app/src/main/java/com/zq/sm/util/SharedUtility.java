package com.zq.sm.util;

import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/10/18.
 */

public class SharedUtility {

    public SharedPreferences pref;
    public SharedPreferences.Editor editor;

    public void loginOut() {
        editor.remove("token");
        editor.commit();
    }

    public String getToken() {
        return pref.getString("token", "");
    }

    public void setToken(String token) {
        editor.putString("token", token);
        editor.commit();
    }

    public String getEquipId(){
        return pref.getString("equipId", "");
    }

    public void setEquipId(String equipId){
        editor.putString("equipId", equipId);
        editor.commit();
    }
}
