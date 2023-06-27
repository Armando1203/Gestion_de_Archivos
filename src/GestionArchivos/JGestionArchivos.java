
package GestionArchivos;

import java.io.File;
import javax.swing.*;

public class JGestionArchivos extends javax.swing.JFrame {

    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    byte[] bytesImg;
    GestionA gestion = new GestionA();
    
    public JGestionArchivos() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Abrir_Archivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_Imagen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Area_Texto = new javax.swing.JTextArea();
        btn_Guardar_Imagen = new javax.swing.JButton();
        btn_Guardar_Texto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Gestión de archivos img y txt");

        btn_Abrir_Archivo.setText("ABRIR ARCHIVO");
        btn_Abrir_Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Abrir_ArchivoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lbl_Imagen);

        txt_Area_Texto.setColumns(20);
        txt_Area_Texto.setRows(5);
        jScrollPane2.setViewportView(txt_Area_Texto);

        btn_Guardar_Imagen.setText("GUARDAR IMAGEN");
        btn_Guardar_Imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Guardar_ImagenActionPerformed(evt);
            }
        });

        btn_Guardar_Texto.setText("GUARDAR TEXTO");
        btn_Guardar_Texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Guardar_TextoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Guardar_Texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Guardar_Imagen))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(btn_Abrir_Archivo)))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btn_Abrir_Archivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btn_Guardar_Imagen)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Guardar_Texto)
                        .addGap(108, 108, 108))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Abrir_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Abrir_ArchivoActionPerformed
        
        if(seleccionado.showDialog(this, "Abrir archivo") == JFileChooser.APPROVE_OPTION)
        {
            archivo = seleccionado.getSelectedFile();
            if(archivo.canRead())
            {
                if(archivo.getName().endsWith("txt"))
                {
                    String contenido = gestion.abrir_Texto(archivo);
                    txt_Area_Texto.setText(contenido);
                }
                else
                {
                    if(archivo.getName().endsWith("jpg")
                            || archivo.getName().endsWith("png")
                            || archivo.getName().endsWith("jpeg")
                            || archivo.getName().endsWith("gif"))
                    {
                        bytesImg = gestion.abrir_Imagen(archivo);
                        lbl_Imagen.setIcon(new ImageIcon(bytesImg));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Por favor selecciona un archivo de imagen o de texto");
                    }
                }
            }
        }
        
        
    }//GEN-LAST:event_btn_Abrir_ArchivoActionPerformed

    private void btn_Guardar_ImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Guardar_ImagenActionPerformed
        
        if(seleccionado.showDialog(this, "Guardar imagen") == JFileChooser.APPROVE_OPTION)
        {
            archivo = seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("jpg")
                    || archivo.getName().endsWith("png")
                    || archivo.getName().endsWith("jpeg")
                    || archivo.getName().endsWith("gif"))
            {
                String respuesta = gestion.guardar_Imagen(archivo, bytesImg);
                if(respuesta != null)
                {
                    JOptionPane.showMessageDialog(null, respuesta);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar imagen");
                }
            }else{
                    JOptionPane.showMessageDialog(null, "La imagen se debe guardar en formato de imagen");
            }
        }
        
    }//GEN-LAST:event_btn_Guardar_ImagenActionPerformed

    private void btn_Guardar_TextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Guardar_TextoActionPerformed
        
        if(seleccionado.showDialog(this, "Guardar texto") == JFileChooser.APPROVE_OPTION)
        {
            archivo = seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("txt"))
            {
                String contenido = txt_Area_Texto.getText();
                String respuesta = gestion.guardar_Texto(archivo, contenido);
                if(respuesta != null)
                {
                    JOptionPane.showMessageDialog(null, respuesta);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar texto");
                }
            }else{
                    JOptionPane.showMessageDialog(null, "El texto se debe guardar en formato txt");
            }
        }
        
    }//GEN-LAST:event_btn_Guardar_TextoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JGestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JGestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JGestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JGestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JGestionArchivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Abrir_Archivo;
    private javax.swing.JButton btn_Guardar_Imagen;
    private javax.swing.JButton btn_Guardar_Texto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Imagen;
    private javax.swing.JTextArea txt_Area_Texto;
    // End of variables declaration//GEN-END:variables
}
