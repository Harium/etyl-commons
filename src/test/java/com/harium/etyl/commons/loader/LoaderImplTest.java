package com.harium.etyl.commons.loader;

import com.harium.etyl.util.io.IOHelper;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class LoaderImplTest {

    @Test
    public void testGetPath_EmptyUrl() {
        LoaderImpl loader = new LoaderImpl();
        Assert.assertEquals("", loader.getPath());
    }

    @Test
    public void testGetFullPath_EmptyUrl() throws MalformedURLException {
        LoaderImpl loader = new LoaderImpl();
        Assert.assertFalse(loader.getFullURL("/assets/").toString().isEmpty());
    }

    @Test
    public void testGetPathWithFilePrefix() {
        LoaderImpl loader = new LoaderImpl();
        loader.setUrl(IOHelper.FILE_PREFIX + "/home/me");

        Assert.assertEquals("/home/me", loader.getPath());
    }

    @Test
    public void testGetPathWithHttpPrefix() {
        LoaderImpl loader = new LoaderImpl();
        loader.setUrl("http://localhost/");

        Assert.assertEquals("http://localhost/", loader.getPath());
    }

}
