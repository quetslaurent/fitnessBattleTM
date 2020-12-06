package util;

import android.app.Activity;
import android.content.Context;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public abstract class SlideR {

private static SlidrInterface sldr;

    public static void swapBack(Activity activity){
        sldr=Slidr.attach(activity);
    }

}
