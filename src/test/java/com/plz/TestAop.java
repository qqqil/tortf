package com.plz;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by andy on 17-4-7.
 */
public class TestAop {
    Logger logger = LoggerFactory.getLogger(TestAop.class);
    int[] bits =new int[]{0,1};
    List<String> watchs = new LinkedList<String>();
    public List<String> readBinaryWatch(int num) {
        readBinaryWatches(num,0,0,0);
        return watchs;
    }

    private void readBinaryWatches(int num,int idx,int w,int count){
        if(num ==count){
            int hours = w >>6;
            int mints = w&(0x3f);
            watchs.add(hours+":"+String.format("%02d",mints));
            return;
        }

        for(int i=idx;i<10;i++){
            readBinaryWatches(num,i+1,w|(0x01<<idx),count+1);
            readBinaryWatches(num,i+1,w,count);

        }
    }

    @Test
    public void testBacktracing(){
        readBinaryWatch(1);
    }
}
