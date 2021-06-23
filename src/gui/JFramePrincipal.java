/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import listeners.InternalFrameListener;
import listeners.MenuItemsImagenListener;

/**
 *
 * @author working
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipa
     */
    public JFramePrincipal() {
        initComponents();
        this.jMenuItem1.addActionListener(new InternalFrameListener(this));
        MenuItemsImagenListener lis = new MenuItemsImagenListener(this);
        this.jMenuItem2.addActionListener(lis);
        this.jMenuItemGrises.addActionListener(lis);
        this.jMenuItemBin.addActionListener(lis);
        this.jMenuItemHistograma.addActionListener(lis);
        this.jMenuItemIluminacion.addActionListener(lis);
        this.jMenuItemExpan.addActionListener(lis);
        this.jMenuItemConvolucion.addActionListener(lis);
        this.jMenuItemSP.addActionListener(lis);
        this.jMenuItemFrcenciaRGB.addActionListener(lis);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPanePrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuEspacial = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemGrises = new javax.swing.JMenuItem();
        jMenuItemBin = new javax.swing.JMenuItem();
        jMenuItemHistograma = new javax.swing.JMenuItem();
        jMenuItemIluminacion = new javax.swing.JMenuItem();
        jMenuItemExpan = new javax.swing.JMenuItem();
        jMenuItemConvolucion = new javax.swing.JMenuItem();
        jMenuItemSP = new javax.swing.JMenuItem();
        jMenuItemFrcenciaRGB = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPanePrincipalLayout = new javax.swing.GroupLayout(jDesktopPanePrincipal);
        jDesktopPanePrincipal.setLayout(jDesktopPanePrincipalLayout);
        jDesktopPanePrincipalLayout.setHorizontalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1268, Short.MAX_VALUE)
        );
        jDesktopPanePrincipalLayout.setVerticalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        jMenu1.setText("Imagen");

        jMenuItem1.setText("AbrirImagen");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenuEspacial.setText("Espacial");

        jMenuItem2.setText("Modificar Pixeles");
        jMenuEspacial.add(jMenuItem2);

        jMenuItemGrises.setText("Escala de Grises");
        jMenuEspacial.add(jMenuItemGrises);

        jMenuItemBin.setText("Binarizacion");
        jMenuEspacial.add(jMenuItemBin);

        jMenuItemHistograma.setText("Histograma");
        jMenuEspacial.add(jMenuItemHistograma);

        jMenuItemIluminacion.setText("Iluminacion");
        jMenuEspacial.add(jMenuItemIluminacion);

        jMenuItemExpan.setText("Expancion");
        jMenuItemExpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExpanActionPerformed(evt);
            }
        });
        jMenuEspacial.add(jMenuItemExpan);

        jMenuItemConvolucion.setText("Convolucion");
        jMenuEspacial.add(jMenuItemConvolucion);

        jMenuItemSP.setText("RuidoSP");
        jMenuEspacial.add(jMenuItemSP);

        jMenuItemFrcenciaRGB.setText("FrecuenciaRGB");
        jMenuEspacial.add(jMenuItemFrcenciaRGB);

        jMenuBar1.add(jMenuEspacial);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemExpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemExpanActionPerformed

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
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanePrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEspacial;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemBin;
    private javax.swing.JMenuItem jMenuItemConvolucion;
    private javax.swing.JMenuItem jMenuItemExpan;
    private javax.swing.JMenuItem jMenuItemFrcenciaRGB;
    private javax.swing.JMenuItem jMenuItemGrises;
    private javax.swing.JMenuItem jMenuItemHistograma;
    private javax.swing.JMenuItem jMenuItemIluminacion;
    private javax.swing.JMenuItem jMenuItemSP;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jDesktopPanePrincipal
     */
    public javax.swing.JDesktopPane getjDesktopPanePrincipal() {
        return jDesktopPanePrincipal;
    }

    /**
     * @param jDesktopPanePrincipal the jDesktopPanePrincipal to set
     */
    public void setjDesktopPanePrincipal(javax.swing.JDesktopPane jDesktopPanePrincipal) {
        this.jDesktopPanePrincipal = jDesktopPanePrincipal;
    }
}
