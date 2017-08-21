package com.EmployeeApp.rest;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AnaCris on August/21/17.
 */
@Provider
public class MOXyJsonContextResolver implements ContextResolver<MoxyJsonConfig> {

    private final MoxyJsonConfig config;

    public MOXyJsonContextResolver(){
        final Map<String, String> namespacePrefixMapper = new HashMap<>();
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        config = new MoxyJsonConfig().setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');

    }

    @Override
    public MoxyJsonConfig getContext(Class<?> type) {
        return config;
    }
}
