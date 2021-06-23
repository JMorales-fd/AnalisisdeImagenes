/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author fran_
 */
public class Expancion {

    public static int verificar(int valor) {
        if (valor > 255) {
            return 255;
        }
        if (valor < 0) {
            return 0;
        }
        return valor;
    }

    public BufferedImage expancionLine(int r1, int r2, Image imagenOriginal) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        int i, j;
        for (j = 0; j < bi.getHeight(); j++) {
            for (i = 0; i < bi.getWidth(); i++) {
                Color pixel = new Color(bi.getRGB(i, j));
                int r = (pixel.getRed() - r1) * (255 / (r2 - r1));
                int b = (pixel.getBlue() - r1) * (255 / (r2 - r1));
                int g = (pixel.getGreen() - r1) * (255 / (r2 - r1));
                pixel = new Color(verificar(r), verificar(g), verificar(b));
                bi.setRGB(i, j, pixel.getRGB());
            }
        }
        return bi;

    }

    public BufferedImage expancionLog(int alpha, Image imagenOriginal) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        int i, j;
        for (j = 0; j < bi.getHeight(); j++) {
            for (i = 0; i < bi.getWidth(); i++) {
                //optenemos el color
                Color pixel = new Color(bi.getRGB(i, j));

                int r = (int) (255 * Math.log(1 + pixel.getRed()) / (Math.log(1 + alpha)));
                int g = (int) (255 * Math.log(1 + pixel.getGreen()) / (Math.log(1 + alpha)));
                int b = (int) (255 * Math.log(1 + pixel.getBlue()) / (Math.log(1 + alpha)));
                pixel = new Color(verificar(r), verificar(g), verificar(b));
                bi.setRGB(i, j, pixel.getRGB());
            }
        }
        return bi;
    }

    public BufferedImage expancionExp(int omega, Image imagenOriginal) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        int i, j;
        for (j = 0; j < bi.getHeight(); j++) {
            for (i = 0; i < bi.getWidth(); i++) {
                //optenemos el color
                Color pixel = new Color(bi.getRGB(i, j));
                int r = (int) (Math.pow(1 + omega, pixel.getRed()) / omega);
                int g = (int) (Math.pow(1 + omega, pixel.getGreen()) / omega);
                int b = (int) (Math.pow(1 + omega, pixel.getBlue()) / omega);
                pixel = new Color(verificar(r), verificar(g), verificar(b));
                bi.setRGB(i, j, pixel.getRGB());
            }

        }
        return bi;
    }

    public BufferedImage ecualizacion(Image imagenOriginal) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        int i, j;
        for (j = 0; j < bi.getHeight(); j++) {
            for (i = 0; i < bi.getWidth(); i++) {
                Color pixel = new Color(bi.getRGB(i, j));
                int r = (int) (bi.getHeight()- bi.getWidth())*pixel.getRed()+bi.getWidth();
                int g = (int) (bi.getHeight()- bi.getWidth())*pixel.getGreen()+bi.getWidth();
                int b = (int) (bi.getHeight()- bi.getWidth())*pixel.getBlue()+bi.getWidth();
                
            }
        }
        return bi;
    }
}