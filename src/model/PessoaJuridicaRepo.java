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
public class PessoaJuridicaRepo {
    
    private ArrayList<PessoaJuridica> pessoasJuridicas;
    
    public PessoaJuridicaRepo() {
        this.pessoasJuridicas = new ArrayList<>();
    }
    
    public boolean inserir(PessoaJuridica pessoaJ) {
        return pessoasJuridicas.contains(pessoaJ) ? false : pessoasJuridicas.add(pessoaJ);
    }
    
    public boolean alterar(PessoaJuridica pessoaJ) {
        int position = pessoasJuridicas.indexOf(pessoaJ);
        if (position != -1) {
            pessoasJuridicas.set(position, pessoaJ);
            return true;
        }
        return false;
    }
    
    public boolean excluir(int id) {
        return pessoasJuridicas.remove(obter(id));
    }
    
    public PessoaJuridica obter(int id) {
        return pessoasJuridicas.stream()
            .filter(pessoaJ -> pessoaJ.getId() == id)
            .findFirst()
            .orElse(null);
    }
    
    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }
    
    public void persistir(String arquivo) throws IOException {
        try (ObjectOutputStream outputStream = 
                new ObjectOutputStream(new FileOutputStream(arquivo))) {
            outputStream.writeObject(pessoasJuridicas);
            System.out.println(arquivo);
        }
    }
    
    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = 
                new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) inputStream.readObject();
            System.out.println(arquivo);
        }
    }
}
