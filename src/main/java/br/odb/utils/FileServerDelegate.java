/**
 * 
 */
package br.odb.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author monty
 * 
 */
public interface FileServerDelegate {

	InputStream openAsInputStream(String filename) throws IOException;

	InputStream openAsset(String filename) throws IOException;

	InputStream openAsset(int resId) throws IOException;

	OutputStream openAsOutputStream(String filename) throws IOException;

    public void log(String tag, String string);
}
