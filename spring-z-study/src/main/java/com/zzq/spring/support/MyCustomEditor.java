package com.zzq.spring.support;

/**
 * @author zzq
 * @date 2023/7/30
 */
import com.zzq.spring.pojo.Address;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;


public class MyCustomEditor implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Address.class, new AddressParse());
    }
}