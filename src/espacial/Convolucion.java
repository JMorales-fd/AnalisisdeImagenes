/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import herramientas.HerramientasImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author fran_
 */
public class Convolucion {
    public BufferedImage aplicarConvolucion(Image io, int[][] mascara, int div, int offset) {
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(io);
        int i, j;
        for (i = 0; i < bi.getWidth(); i++) {
            for (j = 0; j < bi.getHeight();j++) {
                int rgb = calcularNuevoTono(i, j,bi,mascara, div, offset);
                bi.setRGB(i, j, rgb);
            }
        }
        return bi;
    }

    private static int calcularNuevoTono(int x, int y, BufferedImage bi, int[][] mascara, int div, int offset) {
        int auxR = 0, auxG = 0, auxB = 0;
        Color color = null;
        int k = 0;
        for (int j = 0, r = x; j < mascara.length; j++, r++) {
            for (int i = 0, c = y ; i < mascara[0].length; i++, c++) {
                if(mascara[i][j]!=0){
                    try {
                        int rgb = bi.getRGB(r, c);
                        k++;
                        color = new Color(rgb);
                        //axomodar la multiplicacion
                        auxR += color.getRed()*mascara[i][j];
                        auxG += color.getGreen()*mascara[i][j];
                        auxB += color.getBlue()*mascara[i][j];
                        
                    } catch (Exception e) {
                    }
                }
            }
        }
        
        if(k!=0){
            auxR/=div;
            auxG/=div;
            auxB/=div;
        }
            auxR+=offset;
            auxR+=offset;
            auxG+=offset;
            auxB+=offset;
            auxR = Expancion.verificar(auxR);
            auxG = Expancion.verificar(auxG);
            auxB = Expancion.verificar(auxB);
            color = new Color(auxR,auxG,auxB);
            return color.getRGB();
    }
}
