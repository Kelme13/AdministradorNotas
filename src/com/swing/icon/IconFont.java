
package com.swing.icon;

import java.io.InputStream;

public interface IconFont {

    /**
     * Gets the font family name.
     *
     * @return String
     */
    String getFontFamily();

    /**
     * Gets a stream to the font.
     *
     * @return InputStream
     */
    InputStream getFontInputStream();
}
/**
 *
 * @author kelvi
 */