
package GestionArchivos;

import java.io.*;

public class GestionA {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    
    public GestionA(){
        
    }
    
    //Abrir un archivo de texto
    public String abrir_Texto(File archivo){
        String contenido = "";
        
        try{
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read()) != -1)
            {
                char caracter = (char)ascci;
                contenido += caracter;
            }
        }
        catch(Exception e){}
        return contenido;
    }
    
    //Guardad archivo de texto
    public String guardar_Texto(File archivo, String contenido)
    {
        String respuesta = null;
        
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Se guardo con exito el archivo";
        } catch (Exception e) {
        }
        
        return respuesta;
    }
    
    //Abrir una imagen
    public byte[] abrir_Imagen(File archivo){
        byte[] bytesImg = new byte[1024*100];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(bytesImg);
            
        } catch (Exception e) {}
        return bytesImg;
    }
    
    //Guardar archivo de imagen
    public String guardar_Imagen(File archivo, byte[] bytesImg){
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            salida.write(bytesImg);
            respuesta = "La imagen se guardo con exito";
        } catch (Exception e) {}
        return respuesta;
    }
    
}
