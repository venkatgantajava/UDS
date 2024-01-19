package com.ecrops.util;

import com.ecrops.entity.SessionData;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.time.Year;

@Component
public class CultivatorUtility {

    public static Integer getActiveYear(){
        return Year.now().getValue();
    }

    public SessionData getSessionData(HttpSession session){

        return null;
    }

}
