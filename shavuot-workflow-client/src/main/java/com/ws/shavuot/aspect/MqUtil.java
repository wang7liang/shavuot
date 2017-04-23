package com.ws.shavuot.aspect;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang7liang on 2017/4/22.
 */
public class MqUtil {
    private static ThreadLocal<List<Long>> t_ids = new ThreadLocal<>();
    private static ThreadLocal<TransactionSynchronizationAdapter> t_tsa = new ThreadLocal<>();

    public static void putId(Long id){
        if(t_ids.get()==null){
            t_ids.set(new ArrayList<Long>());
        }
        t_ids.get().add(id);
    }

    public static List<Long> getIds(){
        return t_ids.get();
    }

    public static void clearIds(){
        t_ids.set(null);
    }



    public static void putTsa(TransactionSynchronizationAdapter tsa){
        if(t_tsa.get()==null){
            t_tsa.set(tsa);
        }
    }

    public static TransactionSynchronizationAdapter getTsa(){
        return t_tsa.get();
    }

    public static void clearTsa(){
        t_tsa.set(null);
    }

}
