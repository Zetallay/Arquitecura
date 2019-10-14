/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbiriche;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pc
 */


public class Avatar {
    private int ejeX;
    private int ejeY;
    private int tamaño;
    private BufferedImage imagen;

    public Avatar() {
        
    }
    
    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }  
    
    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) throws IOException {
        this.imagen = ImageIO.read(imagen);
    }

    public int getEjeX() {
        return ejeX;
    }

    public void setEjeX(int ejeX) {
        this.ejeX = ejeX;
    }

    public int getEjeY() {
        return ejeY;
    }

    public void setEjeY(int ejeY) {
        this.ejeY = ejeY;
    }

    public int getTamaño() {
        return tamaño;
    }
    
    public void setTamaño(int tamaño){
        this.tamaño = tamaño;
    }
    
    public void pintar(Graphics2D g) {
        g.drawImage(resize(imagen, this.tamaño, this.tamaño), ejeX, ejeY, null);
    }
}
