package me.gleeming.gengine.resource;

import lombok.Getter;
import me.gleeming.gengine.Gengine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Resource {
    @Getter private BufferedImage bufferedImage;

    public Resource(BufferedImage bufferedImage) { this.bufferedImage = bufferedImage; }
    public Resource(String path) { if(!path.startsWith("/")) path = "/" + path; try { this.bufferedImage = ImageIO.read(Gengine.getInstance().getClass().getResource(path)); } catch(Exception ex) { ex.printStackTrace(); System.out.println("[Gengine] There was an error while attempting to read a resource from '" + path + "'"); } }
}
