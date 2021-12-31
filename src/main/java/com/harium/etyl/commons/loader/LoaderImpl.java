package com.harium.etyl.commons.loader;

import com.harium.etyl.util.PathHelper;
import com.harium.etyl.util.io.IOHelper;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yuripourre
 */

public class LoaderImpl implements Loader {

    protected URL url;

    protected String folder;

    public void setUrl(String s) {
        try {
            url = new URL(s);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public URL getUrl() {
        return url;
    }

    public URL getFullURL(String filename) throws MalformedURLException {
        String baseFolder = folder;

        // Fallback to current folder
        if (baseFolder == null) {
            baseFolder = "";
        }

        if (url == null) {
            // Fallback to current directory
            URL baseUrl = new URL(IOHelper.FILE_PREFIX + PathHelper.currentDirectory());
            return new URL(baseUrl, baseFolder + filename);
        }
        return new URL(url, baseFolder + filename);
    }

    public String getPath() {
        String path = "";

        if (url != null) {
            path = url.toString();
        }

        if (path.startsWith(IOHelper.FILE_PREFIX)) {
            path = path.substring(IOHelper.FILE_PREFIX.length());
            path = path.replaceAll("%20", " ");
        }

        return path;
    }

    @Override
    public void initLoader() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {

    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String fullPath(String path) {
        return fullPath(path, false);
    }

    public String fullPath(String path, boolean absolute) {
        StringBuilder sb = new StringBuilder();

        if (isHttpContext()) {
            sb.append(getPath());
            sb.append(folder);
            sb.append(path);
            return sb.toString();
        }

        if (!absolute) {
            sb.append(url.getPath());
            sb.append(folder);
        }

        sb.append(path);

        return sb.toString();
    }

    protected boolean isHttpContext() {
        return IOHelper.startsWithHttp(getPath());
    }

}
