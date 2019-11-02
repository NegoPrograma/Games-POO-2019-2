/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonica;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author pc janete
 */
public class ListPanel extends JPanel implements MouseListener {
    protected static ArrayList<Contato> contatos = new ArrayList<>();
    protected static DefaultListModel<String> list = new DefaultListModel<>();
    protected static JList<String> listaDeContatos = new JList<>();
    protected static boolean listaIniciada = false;
    protected static int selectedItem;
    protected static JScrollPane rolagem = new JScrollPane(listaDeContatos);
    
    public static void printaListas(){
            for(int i = ListPanel.contatos.size()-1; i != -1; i--){
                System.out.println("lista de contatos: "+ListPanel.contatos.get(i).getNome());
                if(ListPanel.list.get(i) != null)
                    System.out.println("jlist: "+ListPanel.list.get(i));
                System.out.println("----------");
            }
            System.out.println("Index da lista:" + selectedItem);
            System.out.println("Atual item selecionado:" + ListPanel.contatos.get(selectedItem).getNome());
            System.out.println("acabou. tamanho atual:" + ListPanel.contatos.size());
            
    }
    
    
    
    public static void inicializaLista(){
        if(!listaIniciada){
            listaDeContatos.setModel(list);
            listaIniciada = true;
        }
        listaDeContatos.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedItem = listaDeContatos.getSelectedIndex();
            //    printaListas();
                //String item = listaDeContatos.getSelectedValue();
                if(selectedItem != -1){
                    ListPanel.trocaSelecao(selectedItem);
                    InfoPanel.atualizaPainel();
                } else {
                    InfoPanel.displayPadrao();
                }
            }
        });
    }
    
    public static DefaultListModel listReset(){
            list = new DefaultListModel<String>();
            for(int i=0;i < contatos.size();i++){
                list.add(i, contatos.get(i).getNome());
                if(contatos.get(i).selecionado)
                    contatos.get(i).selecionado = false;
            }
            return list;
        }
        
    
    
    public static void trocaSelecao(int index){
        for(int i = ListPanel.contatos.size()-1; i != -1; i--){
            if(i == index)
                ListPanel.contatos.get(i).selecionado = true;
            else
                ListPanel.contatos.get(i).selecionado = false;
        }
    }
    
    /*public static Contato procuraContato(String s){
        for(int i = ListPanel.contatos.size()-1; i != -1; i--){
            if(ListPanel.contatos.get(i).getNome().equals(s)){
                return ListPanel.contatos.get(i);
            }
        }
        return null;
    }*/
    
    public static Contato procuraContato(){
        for(int i = ListPanel.contatos.size()-1; i != -1; i--){
            if(ListPanel.contatos.get(i).selecionado){
                return ListPanel.contatos.get(i);
            }
        }
        return null;
    }
    
    
    public static JScrollPane retornaPainel(){
        ListPanel.inicializaLista();
        return rolagem;
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
