package com.common.rest;

import com.services.GameServices;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by olivier on 27/04/2016.
 */
public class MyServices extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public MyServices() {
        singletons.add(new GameServices());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
