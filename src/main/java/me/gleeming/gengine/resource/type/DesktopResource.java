package me.gleeming.gengine.resource.type;

import me.gleeming.gengine.Gengine;
import me.gleeming.gengine.resource.Resource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class DesktopResource extends Resource {
    private BufferedImage bufferedImage;

    public DesktopResource(String path) { super(path, true); if(!path.startsWith("/")) path = "/" + path; try { this.bufferedImage = ImageIO.read(Gengine.getInstance().getClass().getResource(path)); } catch(Exception ex) { ex.printStackTrace(); System.out.println("[Gengine] There was an error while attempting to read a resource from '" + path + "'"); } }

    public BufferedImage toBufferedImage() { return bufferedImage; }

    public Resource flipVertically() {
        AffineTransform at = new AffineTransform();

        at.concatenate(AffineTransform.getScaleInstance(1, -1));
        at.concatenate(AffineTransform.getTranslateInstance(0, -bufferedImage.getHeight()));

        this.bufferedImage = createTransformed(bufferedImage, at);
        return this;
    }

    public Resource flipHorizontally() {
        AffineTransform at = new AffineTransform();

        at.concatenate(AffineTransform.getScaleInstance(-1, 1));
        at.concatenate(AffineTransform.getTranslateInstance(-bufferedImage.getWidth(), 0));

        this.bufferedImage = createTransformed(bufferedImage, at);
        return this;
    }

    public Resource rotate(int angle) {
        this.bufferedImage = createRotated(angle);
        return this;
    }

    public Resource rotateClockwise(int angle) { return rotate(angle); }
    public Resource rotateCounterClockwise(int angle) { return rotate(-angle); }

    private BufferedImage createRotated(int angle) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage dest = new BufferedImage(width, height, bufferedImage.getType());

        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.translate((height - width) / 2, (height - width) / 2);
        graphics2D.rotate(((Math.PI * 2) / 360 * angle), height / 2f, width / 2f);
        graphics2D.drawRenderedImage(bufferedImage, null);

        return dest;
    }

    private BufferedImage createTransformed(BufferedImage image, AffineTransform at) {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = newImage.createGraphics();
        g.transform(at);
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return newImage;
    }
}
