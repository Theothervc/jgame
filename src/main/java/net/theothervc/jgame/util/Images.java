package net.theothervc.jgame.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Images {

    public static BufferedImage getImageFromPath(String path) {
        try {
            return ImageIO.read(new URI(path).toURL());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
