package util;

import android.app.Activity;
import android.content.Context;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public abstract class SlideR {

private static SlidrInterface sldr;

    /**
     * @param activity, on envoie l'instance ce qui permettra de retourner a la vue d'avant
     */
    public static void swapBack(Activity activity){
        sldr=Slidr.attach(activity);
    }

}
