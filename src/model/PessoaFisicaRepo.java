/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

/**
 *
 * @author okidata
 */
public class PessoaFisicaRepo {
    
    private ArrayList<PessoaFisica> pessoasFisicas;
    
    public PessoaFisicaRepo() {
        this.pessoasFisicas = new ArrayList<>();
    }
    
    public boolean inserir(PessoaFisica pessoaF) {
        return pessoasFisicas.contains(pessoaF) ? false : pessoasFisicas.add(pessoaF);
    }
    
    public boolean alterar(PessoaFisica pessoaF) {
        int position = pessoasFisicas.indexOf(pessoaF);
        if (position != -1) {
            pessoasFisicas.set(position, pessoaF);
            return true;
        }
        return false;
    }
    
    public boolean excluir(int id) {
        return pessoasFisicas.remove(obter(id));
    }
    
    public PessoaFisica obter(int id) {
        return pessoasFisicas.stream()
            .filter(pessoaF -> pessoaF.getId() == id)
            .findFirst()
            .orElse(null);
    }
    
    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }
    
    public void persistir(String arquivo) throws IOException {
        try (ObjectOutputStream oss = 
                new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oss.writeObject(pessoasFisicas);
            System.out.println(arquivo);
        }
    }
    
    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = 
                new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) ois.readObject();
        }
    }
    
}
