/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author fran_
 */
public class SalyPimienta {

    public BufferedImage aplicarPimienta(Image io, int porcP) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(io);
        int tope = bi.getHeight()* bi.getWidth();
        int pix = (porcP * tope) / 100;
        Random ran = new Random();
        Color black = new Color(0, 0, 0);
        for (int x = 1; x < pix; x++) {
            bi.setRGB(ran.nextInt(bi.getWidth()), ran.nextInt(bi.getHeight()), black.getRGB());
        }
        return bi;

    }

    public BufferedImage aplicarSal(Image io, int porcS) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(io);
        int tope = bi.getHeight() * bi.getWidth();
        int pix = (porcS * tope) / 100;
        Random ran = new Random();
        Color white = new Color(255, 255, 255);
        for (int x = 1; x < pix; x++) {

            bi.setRGB(ran.nextInt(bi.getWidth()), ran.nextInt(bi.getHeight()), white.getRGB());
        }

        return bi;
    }
    public BufferedImage aplicarMixto(Image io , int porcM){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(io);
        int top= bi.getHeight()*bi.getWidth();
        int pix = (porcM*top)/100;
        Random ran = new Random();
        for (int i = 1; i < pix; i++) {
            Color white = new Color(255, 255, 255);
            bi.setRGB(ran.nextInt(bi.getWidth()), ran.nextInt(bi.getHeight()), white.getRGB());
            Color black = new Color(0, 0, 0);
            bi.setRGB(ran.nextInt(bi.getWidth()), ran.nextInt(bi.getHeight()), black.getRGB());
        }
        return bi;
    }
}
