package com.zzq.spring.support;

/**
 * @author zzq
 * @date 2023/7/30
 */
import com.zzq.spring.pojo.Address;

import java.beans.PropertyEditorSupport;

public class AddressParse extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("AddressParse-test: " + text);
        final String[] vals = text.split(",");
        Address addr = new Address();
        addr.setProvince(vals[0]);
        addr.setCity(vals[1]);
        setValue(addr);
    }
}