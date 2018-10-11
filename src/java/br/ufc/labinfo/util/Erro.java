package br.ufc.labinfo.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Erro implements Serializable{
    private final List<String> erros;
   
    public Erro() {
        erros = new ArrayList<>();
    }
   
    public Erro(String mensagem) {
        erros = new ArrayList<>();
        erros.add(mensagem);
    }
   
    public void add(String mensagem) {
        erros.add(mensagem);
    }
      
    public boolean isExisteErros() {
        return !erros.isEmpty();
    }
      
    public List<String> getErros() {
        return erros;
    }
}
