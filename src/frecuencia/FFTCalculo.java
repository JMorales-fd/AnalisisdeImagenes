/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencia;

/**
 *
 * @author fran_
 */
public class FFTCalculo {
    public NumeroComplejo[][] calculateFT(NumeroComplejo[][] imagenOrigial,boolean inversa){
        int anchoImagen = imagenOrigial.length;
        int altoImagen = imagenOrigial[0].length;
        NumeroComplejo[][] imagenTransformada = new NumeroComplejo[anchoImagen][altoImagen];
        int anchoLog2 = calculaLog2(anchoImagen);
        int altoLon2 = calculaLog2(altoImagen);
        //copiar a cero para acumular
        for (int x = 0; x < anchoImagen; x++) {
            for (int y = 0; y < altoImagen; y++) {
                imagenTransformada[x][y] = new NumeroComplejo(imagenOrigial[x][y]);
            }
        }
        //invercion de bits por renglon
        for (int y = 0; y < altoImagen; y++) {
            //para cada renglon
            int offset = 0;
            for (int i = 0; i <anchoImagen-1; i++) {
                imagenTransformada[i][y] = new NumeroComplejo(imagenOrigial[offset][y]);
                int puntoMedio = anchoImagen/2;
                while(puntoMedio<=offset){
                    offset -=puntoMedio;
                    puntoMedio /=2;
                }
                offset +=puntoMedio;
            }
        }
        //inversion a bits por columnas
        for (int x = 0; x < anchoImagen; x++) {
            //para cada columna
            int j = 0;
            for (int i = 0; i < altoImagen-1; i++) {
                if (i < j) {
                    NumeroComplejo tempoComplex = new NumeroComplejo(imagenTransformada[x][i]);
                    imagenTransformada[x][i] = new NumeroComplejo(imagenTransformada[x][j]);
                    imagenTransformada[x][j] = tempoComplex;
                }
                int puntoMedio = altoImagen/2;
                while (puntoMedio <= j) {                    
                    j-=puntoMedio;
                    puntoMedio/=2;
                    
                }
                j += puntoMedio;
            }
        }
        //acumulcion por columna
        
        for (int x = 0; x < anchoImagen; x++) {
            double coseno = -1.0;
            double seno = 0.0;
            int l1 = 1,l2 = 1;
            for (int l = 0; l < anchoLog2 ; l++) {
                l1 = l2;
                l2 <<=1;
                double u1 = 1.0;
                double u2 = 0.0;
                for (int j = 0; j < l1; j++) {
                    for (int i = j; i < anchoImagen; i+=l2) {
                        int i1 = i+l1;
                        double t1 = u1 *imagenTransformada[x][i1].getParteReal()-u2 * imagenTransformada[x][i1].getParteImaginario();
                        double t2 = u1 *imagenTransformada[x][i1].getParteReal()+u2 * imagenTransformada[x][i1].getParteImaginario();
                        imagenTransformada[x][i1] = imagenTransformada[x][i].sumar(new NumeroComplejo(-t1, -t2));
                        imagenTransformada[x][i] = imagenTransformada[x][i].sumar(new NumeroComplejo(t1, t2));
                    }
                    double z = u1 *coseno -u2*seno;
                    u2 = u1*seno + u2*coseno;
                    u1 =z;
                }
                seno = Math.sqrt((1.0-coseno)/2.0);
                if(!inversa){
                    seno = -seno;
                }
                coseno = Math.sqrt((1.0+coseno)/2.0);
            }
        }
        //acomulacion por renglon
        for (int y = 0; y < altoImagen; y++) {
            double coseno = -1.0;
            double seno = 0.0;
            int l1 = 1,l2 = 1;
            for (int l= 0; l < altoLon2; l++) {
                l1 = l2;
                l2 <<= 1;
                double u1 = 1.0;
                double u2 = 0.0;
                for (int j = 0; j < l1; j++) {
                    for (int i = j; i <anchoImagen; i+=l2) {
                        int i1 = i+l1;
                        double t1 = u1*imagenTransformada[i1][y].getParteReal() - u2*imagenTransformada[i1][y].getParteImaginario();
                        double t2 = u1*imagenTransformada[i1][y].getParteReal() + u2*imagenTransformada[i1][y].getParteImaginario();
                        imagenTransformada[i1][y] = imagenTransformada[i][y].sumar(new NumeroComplejo(-t1, -t2));
                        imagenTransformada[i][y] = imagenTransformada[i][y].sumar(new NumeroComplejo(t1, t2));
                    }
                    double z = u1*coseno -u2*seno;
                    u2 = u1 *seno+u2*coseno;
                    u1 = z;
                }
                seno = Math.sqrt((1.0 - coseno)/2.0);
                if(!inversa){
                    seno -=seno;
                }
                coseno = Math.sqrt((1.0+coseno)/2.0);
            }
        }
        int dimension;
        if(inversa){
            dimension = anchoImagen;
        }else{
            dimension = altoImagen;
        }
        for (int x = 0; x < anchoImagen; x++) {
            for (int y = 0; y < altoImagen; y++) {
                imagenTransformada[x][y] = imagenTransformada[x][y].product(1/(double)dimension);
            }
        }
        return imagenTransformada;
    }
    private int calculaLog2(int dim){
        int conteo = 0;
        while ((dim >>=1)>0 )
            conteo++;
        return conteo;
    }
}
