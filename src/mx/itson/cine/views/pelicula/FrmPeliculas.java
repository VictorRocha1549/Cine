/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.cine.views.pelicula;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import mx.itson.cine.entities.Pelicula;

/**
 *
 * @author vagui
 */
public class FrmPeliculas extends javax.swing.JFrame {
    
    Pelicula pelicula = new Pelicula();

    /**
     * Creates new form FrmPeliculas
     */
    public FrmPeliculas() {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableModel model = (DefaultTableModel) tblPeliculas.getModel();
        model.setColumnIdentifiers(new Object[]{"id", "titulo", "duracion", "genero", "sinopsis"});
        llenarTabla("");
    }
    
    public void llenarTabla(String filtro) {
        List<Pelicula> resultados = Pelicula.getAll(filtro);
        DefaultTableModel model = (DefaultTableModel) tblPeliculas.getModel();
        model.setRowCount(0);
        for (Pelicula p : resultados) {
            Object[] rowData = {p.getId(), p.getTitulo(), p.getDuracion(), p.getGenero(), p.getSinopsis()};
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfBuscarPelicula = new javax.swing.JTextField();
        btnBuscarPelicula = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        btnAddPelicula = new javax.swing.JButton();
        btnDeletePelicula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CINEFAN");
        jLabel1.setOpaque(true);

        btnBuscarPelicula.setText("Buscar");
        btnBuscarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPeliculaActionPerformed(evt);
            }
        });

        tblPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Titulo", "Duracion", "Genero", "Sinopsis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeliculasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeliculas);

        btnAddPelicula.setText("Agregar");
        btnAddPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPeliculaActionPerformed(evt);
            }
        });

        btnDeletePelicula.setText("Eliminar");
        btnDeletePelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePeliculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfBuscarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeletePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfBuscarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPelicula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPelicula)
                    .addComponent(btnDeletePelicula))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPeliculaActionPerformed
        // TODO add your handling code here:
        String filtro = txfBuscarPelicula.getText();
        
        List<Pelicula>resultados = Pelicula.getAll(filtro);
        
        DefaultTableModel model =(DefaultTableModel)tblPeliculas.getModel();
        model.setRowCount(0);
        
        for(Pelicula p : resultados){
            Object[] rowData ={p.getId(),p.getTitulo(),p.getDuracion(),p.getGenero(),p.getSinopsis()};
            model.addRow(rowData);
            llenarTabla(filtro);
        }
    }//GEN-LAST:event_btnBuscarPeliculaActionPerformed

    private void btnDeletePeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePeliculaActionPerformed
        // TODO add your handling code here:
        int row = tblPeliculas.getSelectedRow();
        int col = 0;
        int peliculaId = (int)tblPeliculas.getValueAt(row, col);
        Pelicula pelicula = new Pelicula();
        pelicula.delete(peliculaId);
        System.out.println("Eliminado: "+peliculaId);
        llenarTabla("");
    }//GEN-LAST:event_btnDeletePeliculaActionPerformed

    private void btnAddPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPeliculaActionPerformed
        // TODO add your handling code here:
        FrmAdd frmAdd = new FrmAdd();
        frmAdd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddPeliculaActionPerformed

    private void tblPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeliculasMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int row = tblPeliculas.getSelectedRow();
            int col = 0;
            
            int peliculaId =(int)tblPeliculas.getValueAt(row, col);
            
            Pelicula peliculaEdit = Pelicula.getById(peliculaId);
            System.out.println("ID: "+peliculaId);
            
            FrmAdd frmAdd = new FrmAdd(peliculaEdit);
            frmAdd.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_tblPeliculasMouseClicked

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
            java.util.logging.Logger.getLogger(FrmPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPelicula;
    private javax.swing.JButton btnBuscarPelicula;
    private javax.swing.JButton btnDeletePelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPeliculas;
    private javax.swing.JTextField txfBuscarPelicula;
    // End of variables declaration//GEN-END:variables
}
