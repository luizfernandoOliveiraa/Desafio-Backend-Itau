package com.dev.desafiobackenditau.transacoes;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacaoRequest) {
        listaDeTransacoes.add(transacaoRequest);
    }

    public void limparDados(){}

    public void deletarDados(){
        listaDeTransacoes.clear();
    }
}
