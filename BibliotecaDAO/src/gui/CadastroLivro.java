/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import model.Livro;
import sevicos.LivroServicos;

/**
 *
 * @author Jair Ferraz
 */
public class CadastroLivro extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastroLivro
     */
    private int tipo;

    public CadastroLivro() {
        livroS = new LivroServicos();
        initComponents();
        tipo = 1;
        manipulaJanela();
    }

    public CadastroLivro(int tipo) {
        livroS = new LivroServicos();
        initComponents();
        this.tipo = tipo;
        manipulaJanela();
    }

    public void manipulaJanela() {
        if (tipo == 1) {
            jbCadastrar.setText("Cadastrar");
        } else if (tipo == 2) {
            jbCadastrar.setText("Editar");
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
        jtfNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfAutores = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfEditora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfAno = new javax.swing.JTextField();
        jtfISBN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfExemplares = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jbCadastrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Livro");
        setPreferredSize(new java.awt.Dimension(413, 312));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jLabel6.setText("Exemplares:");

        jLabel3.setText("Autores:");

        jLabel4.setText("Editora:");

        jLabel5.setText("Ano:");

        jtfISBN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfISBNFocusLost(evt);
            }
        });

        jLabel1.setText("ISBN:");

        jLabel2.setText("Nome:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfExemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfAutores)
                                .addComponent(jtfNome)
                                .addComponent(jtfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfExemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbCadastrar.setMnemonic('C');
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCadastrar)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jbCadastrar)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        if (tipo == 1) {
            cadastrarLivro();
        } else if (tipo == 2) {
            editarLivro();
        }
        this.dispose();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jtfISBNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfISBNFocusLost
        if (tipo == 2) {
            String isbn = jtfISBN.getText();
            if (livroS.procurarPorISBN(isbn) == null) {
                JOptionPane.showMessageDialog(null, "Não da dados com esse ISBN!");
            } else {
                String nome = livroS.procurarPorISBN(isbn).getNome();
                String autores = livroS.procurarPorISBN(isbn).getAutores();
                String editora = livroS.procurarPorISBN(isbn).getEditora();
                int ano = livroS.procurarPorISBN(isbn).getAno();
                jtfNome.setText(nome);
                jtfAutores.setText(autores);
                jtfEditora.setText(editora);
                jtfAno.setText(Integer.toString(ano));
                JOptionPane.showMessageDialog(null, "Informe Exemplares");
            }
        }
    }//GEN-LAST:event_jtfISBNFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JTextField jtfAno;
    private javax.swing.JTextField jtfAutores;
    private javax.swing.JTextField jtfEditora;
    private javax.swing.JTextField jtfExemplares;
    private javax.swing.JTextField jtfISBN;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private LivroServicos livroS;

    private void cadastrarLivro() {
        try {
            String ISBN = jtfISBN.getText();
            String nome = jtfNome.getText();
            String autores = jtfAutores.getText();
            String editora = jtfEditora.getText();
            int ano = Integer.parseInt(jtfAno.getText());
            int quant = Integer.parseInt(jtfExemplares.getText());
            livroS.addLivro(new Livro(ISBN, nome, autores, editora, ano), quant);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Informe ano apenas digitos!");
            e.printStackTrace();
        }
    }

    private void editarLivro() {
        try {
            String isbn = jtfISBN.getText();
            String nome = jtfNome.getText();
            String autores = jtfAutores.getText();
            String editora = jtfEditora.getText();
            int ano = Integer.parseInt(jtfAno.getText());
            int quant = Integer.parseInt(jtfExemplares.getText());
            livroS.atualizarLivro(new Livro(isbn, nome, autores, editora, ano));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Informe ano apenas digitos!");
            e.printStackTrace();
        }
    }
}
