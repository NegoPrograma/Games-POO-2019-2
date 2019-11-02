/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonica;

import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author pc janete
 */
public class Mediador {
     protected static void addItem(){
        String nome = JOptionPane.showInputDialog("Nome do novo contato.",CENTER);
                    String telefone = JOptionPane.showInputDialog("Telefone do novo contato.",CENTER);
                    String detalhes = JOptionPane.showInputDialog("Detalhes do novo contato.",CENTER);
                    ListPanel.contatos.add(new Contato(nome,telefone,detalhes));
                    ListPanel.list.addElement(nome);
                    ListPanel.listaDeContatos.updateUI();
    }
   
    protected static void removeItem(){
                    Contato c =ListPanel.procuraContato();
                    ListPanel.contatos.remove(c);
                    ListPanel.list = ListPanel.listReset();
                    ListPanel.listaDeContatos.setModel(ListPanel.list);
                    InfoPanel.atualizaPainel();

    }
    
    protected static void updateItem(){
            if(ListPanel.selectedItem != -1){
                        Contato c = ListPanel.procuraContato();
                        c.setNome(JOptionPane.showInputDialog("Nome novo do contato.",CENTER));
                        c.setTelefone(JOptionPane.showInputDialog("Telefone novo do contato.",CENTER));
                        c.setDetalhes(JOptionPane.showInputDialog("Detalhes novo do contato.",CENTER));
                        ListPanel.list.setElementAt(c.getNome(),ListPanel.selectedItem);
                        InfoPanel.atualizaPainel();
            }
    }
}
