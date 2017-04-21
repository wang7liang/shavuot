package com.ws.shavuot.service.impl;

import com.ws.shavuot.service.UtilService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangqiliang on 17/4/7.
 */
@Service("utilService")
public class UtilServiceImpl implements UtilService {
    /**
     *
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public Date convertToDate(String str) {
        Date data = null;
        try {
            data = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
